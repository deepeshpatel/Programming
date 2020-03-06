package com.sutra.algo.sequence.permutation;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ObjectPermutationGeneratorTest {

    @Test
    public void permutationsShouldBeInInputOrderByDefault() {

        List<String> input = Arrays.asList("B", "A");
        String[][] expected = new String[][]{
                {"B", "A"},
                {"A", "B"}};

        Object[] output = Sequence
                .permutationsOf(input)
                .build().stream().toArray();

        assertArrayEqual(expected, output);
    }

    @Test
    public void permutationsShouldBeInLexOrderWhenSetToLex() {

        List<String> input = Arrays.asList("B", "A");
        String[][] expected = new String[][]{
                {"A", "B"},
                {"B", "A"}};

        Object[] output = Sequence
                .permutationsOf(input)
                .withOrder(Order.LEXICAL)
                .build().stream().toArray();

        assertArrayEqual(expected, output);
    }

    @Test
    public void shouldReturnEmptyList() {

        List<String> input = new ArrayList<>();
        String[][] expected = new String[1][0];

        Object[] output = Sequence
                .combinationsOf(input)
                .withOrder(Order.LEXICAL)
                .build().stream().toArray();

        assertArrayEqual(expected, output);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionForNullInputString() {
        Sequence.combinationsOf((List<String>) null).build();
    }

    private void assertArrayEqual(String[][] expected, Object[] output) {

        assertEquals(expected.length, output.length);

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], ((List) output[i]).toArray());
        }
    }
}
