package com.sutra.algo.sequence.permutation;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StringPermutationGeneratorTest {

    @Test
    public void permutationsShouldBeInInputOrderByDefault() {

        String[] expected = new String[]{"BA", "AB"};

        Object[] output = Sequence
                .permutationsOf("BA")
                .build().stream().toArray();

        assertArrayEquals(expected, output);
    }

    @Test
    public void permutationsShouldBeInLexOrderWhenSetToLex() {

        String[] expected = new String[]{"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};

        Object[] output = Sequence
                .permutationsOf("BAC")
                .withOrder(Order.LEXICAL)
                .build().stream().toArray();

        assertArrayEquals(expected, output);
    }

    @Test
    public void shouldGenerateEmptyPermutationStringForEmptyInput() {

        Object[] output = Sequence
                .permutationsOf("")
                .build().stream().toArray();

        assertArrayEquals(new String[]{""}, output);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionForNullInputString() {
        Sequence.permutationsOf((String) null).build();
    }
}
