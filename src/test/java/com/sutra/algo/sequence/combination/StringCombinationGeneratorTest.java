package com.sutra.algo.sequence.combination;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StringCombinationGeneratorTest {

    @Test
    public void combinationsShouldBeInInputOrderByDefault() {

        String[] expected = new String[]{"DB", "DC", "DA", "BC", "BA", "CA"};

        Object[] output = Sequence
                .combinationsOf("DBCA")
                .ofSize(2)
                .build()
                .stream().toArray();

        assertArrayEquals(expected, output);
    }

    @Test
    public void combinationsShouldBeInLexOrderWhenSetToLex() {

        String[] expected = new String[] {"AB","AC","AD","BC","BD","CD"};

        Object[] output = Sequence
                .combinationsOf("DBCA")
                .ofSize(2)
                .withOrder(Order.LEXICAL)
                .build().stream().toArray();

        assertArrayEquals(expected, output);
    }

    @Test
    public void shouldReturnEmptyForEmptyInput() {

        String[] expected = new String[]{""};

        Object[] output = Sequence
                .combinationsOf("")
                .build().stream().toArray();

        assertArrayEquals(expected, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowToGenerateCombinationsOFSizeGreaterThanInput() {
        Sequence.combinationsOf("AB")
                .ofSize(3).build();
    }

    @Test
    public void shouldReturnEmptyForSizeZero() {

        Object[] output = Sequence
                .combinationsOf("AB")
                .ofSize(0)
                .build().stream().toArray();

        assertArrayEquals(new String[]{""}, output);
    }
}
