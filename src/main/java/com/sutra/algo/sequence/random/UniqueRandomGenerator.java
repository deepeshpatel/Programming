package com.sutra.algo.sequence.random;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class UniqueRandomGenerator implements Iterable<Integer> {

    private int from;
    private int to;

    private UniqueRandomGenerator(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr(from, to);
    }

    static class Itr implements Iterator<Integer> {

        private ArrayList<Integer> values;
        private Random random = new Random();

        Itr(int from, int to) {
            values = new ArrayList<>(to-from);
            for(int i=from; i<=to; i++) {
                values.add(i);
            }
        }

        @Override
        public boolean hasNext() {
            return values.size() > 0;
        }

        @Override
        public Integer next() {
            int index = random.nextInt(values.size());
            int lastIndex = values.size()-1;
            int value = values.get(index);

            values.set(index, values.get(lastIndex));
            values.remove(lastIndex);
            return value;
        }
    }

    public static class Builder {

        int from;
        int to;

        public Builder inRange(int from, int to) {
            this.from = from;
            this.to = to;
            if(to < from ) {
                throw new IllegalArgumentException("parameter 'to' must be greater than 'from'");
            }

            return this;
        }

        public Iterable<Integer> build() {
            return new UniqueRandomGenerator(from, to);
        }
    }
}
