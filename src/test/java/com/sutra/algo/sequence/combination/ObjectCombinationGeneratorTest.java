package com.sutra.algo.sequence.combination;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ObjectCombinationGeneratorTest {

    @Test
    public void combinationsShouldBeInInputOrderByDefault() {

        String[][] expected = new String[][]{
                {"Red", "Green"},
                {"Red", "Blue"},
                {"Green", "Blue"},
        };

        Object[] output = Sequence
                .combinationsOf(Arrays.asList("Red", "Green", "Blue"))
                .ofSize(2)
                .build().stream().toArray();

        assertArrayEqual(expected, output);
    }

    @Test
    public void combinationsShouldBeInLexOrderWhenSetToLex() {

        String[][] expected = new String[][]{
                {"Blue", "Green"},
                {"Blue", "Red"},
                {"Green", "Red"},
        };

        Object[] output = Sequence
                .combinationsOf(Arrays.asList("Red", "Green", "Blue"))
                .ofSize(2)
                .withOrder(Order.LEXICAL)
                .build().stream().toArray();

        assertArrayEqual(expected, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowToGenerateCombinationsOFSizeGreaterThanInput() {
        Sequence
                .combinationsOf(new ArrayList<>())
                .ofSize(2)
                .build();
    }

    @Test
    public void shouldReturnEmptyListForSizeZero() {

        String[][] expected = new String[1][0];

        Object[] output = Sequence
                .combinationsOf(new ArrayList<>())
                .ofSize(0)
                .withOrder(Order.LEXICAL)
                .build().stream().toArray();

        assertArrayEqual(expected, output);
    }

    private void assertArrayEqual(String[][] expected, Object[] output) {

        assertEquals(expected.length, output.length);

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], ((List) output[i]).toArray());
        }
    }
}
