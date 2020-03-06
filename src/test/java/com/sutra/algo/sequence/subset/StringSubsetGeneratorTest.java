package com.sutra.algo.sequence.subset;

import com.sutra.algo.sequence.Sequence;
import com.sutra.algo.util.Order;
import org.junit.Assert;
import org.junit.Test;

public class StringSubsetGeneratorTest {

    @Test(expected = NullPointerException.class)
    public void shouldNotAllowSubsetsOfNullString() {
        Sequence.subsetsOf((String) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toValueMustBeGreaterThanFrom() {
        Sequence.subsetsOf("ABC")
                .inRange(3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromMustBeGreaterThanOrEqualTo0() {
        Sequence.subsetsOf("ABC")
                .inRange(-1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void toValueMustBeLessThanOrEqualToInput() {
        Sequence.subsetsOf("ABC")
                .inRange(1, 4);
    }

    @Test
    public void shouldReturnAllSubsetsInInputOrderByDefault() {
        String[] expected = new String[]{"C", "B", "A", "CB", "CA", "BA", "CBA"};
        Object[] output = Sequence
                .subsetsOf("CBA")
                .build()
                .stream().toArray();
        Assert.assertArrayEquals(expected, output);
    }

    @Test
    public void shouldReturnAllSubsetsInLexOrder() {
        String[] expected = new String[]{"A", "B", "C", "AB", "AC", "BC", "ABC"};
        Object[] output = Sequence
                .subsetsOf("CBA")
                .withOrder(Order.LEXICAL)
                .build()
                .stream().toArray();
        Assert.assertArrayEquals(expected, output);
    }

    @Test
    public void shouldReturnAllSubsetsInGivenRange() {
        String[] expected = new String[]{"AB", "AC", "BC", "ABC"};
        Object[] output = Sequence
                .subsetsOf("ABC")
                .inRange(2, 3)
                .build()
                .stream().toArray();
        Assert.assertArrayEquals(expected, output);
    }
}
