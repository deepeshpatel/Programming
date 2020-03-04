package com.sutra.algo.sequence.random;

import com.sutra.algo.sequence.Sequence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueRandomGeneratorTest {

    @Test
    public void shouldGenerateUniqueValuesBetweenRange() {
        int from = 11;
        int to = 20;
        int expectedSum = (from + to) * (to - from + 1) / 2;

        Iterable<Integer> itr = Sequence
                .uniqueRandomNumbers()
                .from(from)
                .to(to)
                .build();

        int valueSum = 0;
        int count =0;

        for (int r : itr) {
            count++;
            valueSum += r;
        }

        assertEquals(expectedSum, valueSum);
        assertEquals(10, count);

    }
}
