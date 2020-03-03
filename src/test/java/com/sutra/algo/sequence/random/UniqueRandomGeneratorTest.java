package com.sutra.algo.sequence.random;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueRandomGeneratorTest {

    @Test
    public void shouldGenerateUniqueValuesBetweenRange() {
        int from = 11;
        int to = 20;
        int sum = (from+to) * (to-from+1)/2;
        UniqueRandomGenerator generator = new UniqueRandomGenerator(11,20);

        int valueSum = 0;
        int count =0;

        for(int r : generator) {
            count++;
            valueSum += r;
        }

        assertEquals(sum, valueSum);
        assertEquals(10, count);

    }
}
