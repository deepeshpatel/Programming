package com.sutra.algo.sequence.permutation;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringPermutationGeneratorTest {

    @Test
    public void shouldReturn2ValuesInDescendingOrder() {

        String input = "BA";
        String[] expected = new String[]{"BA", "AB"};

        Iterable<String> itr = Sequence
                .permutationsOf(input)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturn2ValuesInAscendingOrder() {

        String input = "BAC";
        String[] expected = new String[]{"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};

        Iterable<String> itr = Sequence
                .permutationsOf(input)
                .withOrder(Order.LEXICAL)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturnEmptyString() {

        String input = "";
        String[] expected = new String[]{""};

        Iterable<String> itr = Sequence
                .permutationsOf(input)
                .withOrder(Order.LEXICAL)
                .build();

        assertResults(expected, itr);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionForNullInputString() {

        Sequence
                .permutationsOf((String) null)
                .withOrder(Order.LEXICAL)
                .build();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowExceptionForOutOfBoundsIteration() {

        Iterator<String> itr = Sequence
                .permutationsOf("A")
                .build().iterator();


        itr.next();
        itr.next();
    }

    private void assertResults(String[] expected, Iterable<String> itr) {

        int i = 0;
        for (String s : itr) {
            Assert.assertEquals(expected[i++], s);
        }
    }
}
