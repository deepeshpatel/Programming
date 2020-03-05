package com.sutra.algo.sequence.combination;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectCombinationGeneratorTest {

    @Test
    public void shouldReturnCombinationsInInputOrder() {

        List<String> input = Arrays.asList("Red", "Green", "Blue");

        String[] expected = new String[]{
                "[Red, Green]",
                "[Red, Blue]",
                "[Green, Blue]"
        };

        int size = 2;

        Iterable<List<String>> itr = Sequence
                .combinationsOf(input)
                //.of(input)
                .ofSize(size)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturnCombinationsInLexOrder() {

        List<String> input = Arrays.asList("Red", "Green", "Blue");

        String[] expected = new String[]{
                "[Blue, Green]",
                "[Blue, Red]",
                "[Green, Red]"
        };

        int size = 2;

        Iterable<List<String>> itr = Sequence
                .combinationsOf(input)
                .ofSize(size)
                .withOrder(Order.LEXICAL)
                .build();

        assertResults(expected, itr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExpForSizeGreaterThanInput() {

        List<String> input = new ArrayList<>();

        String[] expected = new String[]{
                "[Blue, Green]",
                "[Blue, Red]",
                "[Green, Red]"
        };

        int size = 2;

        Iterable<List<String>> itr = Sequence
                .combinationsOf(input)
                .ofSize(size)
                .withOrder(Order.LEXICAL)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturnEmptyListForSizeZero() {

        List<String> input = new ArrayList<>();
        String[] expected = new String[]{"[]"};
        int size = 0;

        Iterable<List<String>> itr = Sequence
                .combinationsOf(input)
                .ofSize(size)
                .withOrder(Order.LEXICAL)
                .build();

        assertResults(expected, itr);
    }

    private void assertResults(String[] expected, Iterable<List<String>> itr) {
        int i=0;
        for (List<String> list : itr) {
            Assert.assertEquals(expected[i++], list.toString());
        }
    }
}
