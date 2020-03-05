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
    public void shouldUseDefaultSizeEqualToBaseOfNumberSystem1() {

        String[] expected = new String[]{"0"};
        Iterable<String> itr = Sequence
                .numbers()
                .ofBase(1)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldUseDefaultSizeEqualToBaseOfNumberSystem3() {

        String[] expected = new String[]{
                "000", "001", "002",
                "010", "011", "012",
                "020", "021", "022",
                "100", "101", "102",
                "110", "111", "112",
                "120", "121", "122",
                "200", "201", "202",
                "210", "211", "212",
                "220", "221", "222"};
        Iterable<String> itr = Sequence
                .numbers()
                .ofBase(3)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldUseDefaultSizeEqualToBaseOfNumberSystemWith3Symbols() {

        String[] expected = new String[]{
                "HHH", "HHT", "HHV",
                "HTH", "HTT", "HTV",
                "HVH", "HVT", "HVV",
                "THH", "THT", "THV",
                "TTH", "TTT", "TTV",
                "TVH", "TVT", "TVV",
                "VHH", "VHT", "VHV",
                "VTH", "VTT", "VTV",
                "VVH", "VVT", "VVV"};

        Iterable<String> itr = Sequence
                .numbers()
                .withSymbols("HTV")
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldNotUseDefaultSizeEqualToBaseOfNumberSystemWhenSizeIsDefined() {

        String[] expected = new String[]{
                "HH", "HT", "HV",
                "TH", "TT", "TV",
                "VH", "VT", "VV"};

        Iterable<String> itr = Sequence
                .numbers()
                .withSymbols("HTV")
                .ofSize(2)
                .build();

        assertResults(expected, itr);
    }

    @Test
    public void shouldWorkWithCustomSymbols() {

        String[] expected = new String[]{"HHT", "THH", "TTT"};
        Iterable<String> itr = Sequence
                .numbers()
                .withSymbols("HT")
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
                .withSymbols("HT")
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
        }
    }

}
