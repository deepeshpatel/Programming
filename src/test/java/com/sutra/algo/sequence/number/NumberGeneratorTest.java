package com.sutra.algo.sequence.number;

import com.sutra.algo.sequence.Sequence;
import org.junit.Assert;
import org.junit.Test;

public class NumberGeneratorTest {

    @Test
    public void shouldGenerate8ValuesOfBinary() {

        String[] expected = new String[]{"000", "001", "010", "011", "100", "101", "110", "111"};
        Iterable<String> itr = Sequence
                .numbers()
                .ofBase(2)
                .ofSize(3)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldHandleStartAndSkipValues() {

        String[] expected = new String[]{"001", "100", "111"};
        Iterable<String> itr = Sequence
                .numbers()
                .ofBase(2)
                .ofSize(3)
                .withStartingValue(1)
                .andSkipEvery(2)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldWorkWithCustomSymbols() {

        String[] expected = new String[]{"HHT", "THH", "TTT"};
        Iterable<String> itr = Sequence
                .numbers()
                .fromSymbols("HT")
                .ofSize(3)
                .withStartingValue(1)
                .andSkipEvery(2)
                .build();

        assertResults(expected, itr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowBothSymbolsAndBase() {

        Sequence
                .numbers()
                .fromSymbols("HT")
                .ofBase(3)
                .ofSize(3)
                .build();

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldSpecifyEitherSymbolsOrBase() {

        Sequence
                .numbers()
                .ofSize(3)
                .build();

    }

    private void assertResults(String[] expected, Iterable<String> itr) {

        int i=0;
        for (String s : itr) {
            Assert.assertEquals(expected[i++], s);
            System.out.println(s);
        }
    }

}
