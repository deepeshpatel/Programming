package com.sutra.algo.sequence.combination;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.struct.Order;
import org.junit.Assert;
import org.junit.Test;

public class StringCombinationGeneratorTest {

    @Test
    public void shouldReturnCombinationsInInputOrder() {

        String input = "DBCA";
        String[] expected = new String[]{"DB", "DC", "DA", "BC", "BA", "CA"};
        int size = 2;

        Iterable<String> itr = Sequence
                .combination()
                .from(input)
                .ofSize(size)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturnCombinationsInLexOrder() {

        String input = "DBCA";
        String[] expected = new String[] {"AB","AC","AD","BC","BD","CD"};
        int size = 2;

        Iterable<String> itr = Sequence
                .combination()
                .from(input)
                .ofSize(size)
                .orderBy(Order.LEXICAL)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturnEmptyForEmptyInput() {

        String input = "";
        String[] expected = new String[]{""};
        int size = 0;

        Iterable<String> itr = Sequence
                .combination()
                .from(input)
                .ofSize(size)
                .build();

        assertResults(expected, itr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExpForSizeGreaterThanInput() {

        String input = "AB";
        String[] expected = new String[]{""};
        int size = 3;

        Iterable<String> itr = Sequence
                .combination()
                .from(input)
                .ofSize(size)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldReturnEmptyForSizeZero() {

        String input = "AB";
        String[] expected = new String[]{""};
        int size = 0;

        Iterable<String> itr = Sequence
                .combination()
                .from(input)
                .ofSize(size)
                .build();

        assertResults(expected, itr);
    }

    private void assertResults(String[] expected, Iterable<String> itr) {
        int i=0;
        for (String s : itr) {
            Assert.assertEquals(expected[i++], s);
        }
    }
}
