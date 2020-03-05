package com.sutra.algo.sequence.permutation;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ObjectPermutationGeneratorTest {

    @Test
    public void shouldReturn2ValuesInDescendingOrder() {

        List<String> input = Arrays.asList("B", "A");
        String[] expected = new String[]{"[B, A]", "[A, B]"};

        Iterable<List<String>> itr = Sequence
                .permutationsOf(input)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturn2ValuesInAscendingOrder() {

        List<String> input = Arrays.asList("B", "A");
        String[] expected = new String[]{"[A, B]","[B, A]"};

        Iterable<List<String>> itr = Sequence
                .permutationsOf(input)
                .withOrder(Order.LEXICAL)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturnEmptyList() {

        List<String> input = new ArrayList<>();
        String[] expected = new String[]{"[]"};

        Iterable<List<String>> itr = Sequence
                .combinationsOf(input)
                .withOrder(Order.LEXICAL)
                .build();

        assertResults(expected, itr);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionForNullInputString() {

        Sequence
                .combinationsOf((List<String>) null)
                .withOrder(Order.LEXICAL)
                .build();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionForOutOfBoundsIteration() {

        Iterator<List<String>> itr = Sequence
                .permutationsOf(new ArrayList<String>())
                .build().iterator();

        itr.next();
        itr.next();
    }

    private void assertResults(String[] expected, Iterable<List<String>> itr) {

        int i = 0;
        for (List<String> list : itr) {
            Assert.assertEquals(expected[i++], list.toString());
        }
    }
}
