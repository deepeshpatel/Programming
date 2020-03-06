package com.sutra.algo.sequence.subset;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ObjectSubsetGeneratorTest {

    @Test(expected = NullPointerException.class)
    public void shouldNotAllowSubsetOfNullCollection() {
        Sequence.subsetsOf((Collection) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toValueMustBeGreaterThanFrom() {
        Sequence.subsetsOf(Arrays.asList("ABC"))
                .inRange(3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromMustBeGreaterThanOrEqualTo0() {
        Sequence.subsetsOf(Arrays.asList("ABC"))
                .inRange(-1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toValueMustBeLessThanOrEqualToInput() {
        Sequence.subsetsOf(Arrays.asList("ABC"))
                .inRange(1, 4);
    }

    @Test
    public void shouldReturnAllSubsetsInInputOrderByDefault() {

        String[][] expected = new String[][]{
                {"C"},
                {"B"},
                {"A"},
                {"C", "B"},
                {"C", "A"},
                {"B", "A"},
                {"C", "B", "A"},
        };

        Object[] output = Sequence
                .subsetsOf(Arrays.asList("C", "B", "A"))
                .build()
                .stream().toArray();

        assertArrayEqual(expected, output);
    }

    @Test
    public void shouldReturnAllSubsetsInLexOrder() {

        String[][] expected = new String[][]{
                {"A"},
                {"B"},
                {"C"},
                {"A", "B"},
                {"A", "C"},
                {"B", "C"},
                {"A", "B", "C"},
        };

        Object[] output = Sequence
                .subsetsOf(Arrays.asList("C", "B", "A"))
                .withOrder(Order.LEXICAL)
                .build()
                .stream().toArray();

        assertArrayEqual(expected, output);
    }

    @Test
    public void shouldReturnAllSubsetsInGivenRange() {
        String[][] expected = new String[][]{
                {"A", "B"},
                {"A", "C"},
                {"B", "C"},
                {"A", "B", "C"},
        };

        Object[] output = Sequence
                .subsetsOf(Arrays.asList("A", "B", "C"))
                .inRange(2, 3)
                .build()
                .stream().toArray();

        assertArrayEqual(expected, output);
    }


    private void assertArrayEqual(String[][] expected, Object[] output) {

        assertEquals(expected.length, output.length);

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], ((List) output[i]).toArray());
        }
    }
}
