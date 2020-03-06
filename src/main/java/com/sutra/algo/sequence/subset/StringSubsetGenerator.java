package com.sutra.algo.sequence.subset;

import com.sutra.algo.sequence.combination.StringCombinationGenerator;
import com.sutra.algo.util.IteratorSequence;
import com.sutra.algo.util.Order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StringSubsetGenerator implements Iterable<String> {

    private String data;
    private int fromSize;
    private int toSize;
    private Order order;

    private StringSubsetGenerator(String data, int fromSize, int toSize, Order order) {
        this.data = data;
        this.fromSize = fromSize;
        this.toSize = toSize;
        this.order = order;
    }

    public Stream<String> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @Override
    public Iterator<String> iterator() {

        List<Iterable<String>> iterables = new ArrayList<>();
        for (int i = toSize; i >= fromSize; i--) {

            StringCombinationGenerator generator = new StringCombinationGenerator
                    .Combinations(data)
                    .ofSize(i)
                    .withOrder(order)
                    .build();

            iterables.add(generator);
        }

        return new IteratorSequence<>(iterables);
    }

    public static class Subsets {

        private int fromSize = 1;
        private int toSize;
        private String data;
        private Order order = Order.INPUT;

        public Subsets(String data) {
            if (data == null) {
                throw new NullPointerException("Can not generate subset of null String");
            }
            this.data = data;
        }


        public Subsets inRange(int from, int to) {

            if (from <= 0 || to > data.length() || to < from) {
                throw new IllegalArgumentException("'from' must be >0\n" +
                        "'to' must be <= data length\n" +
                        "and 'from' must be <= 'to'");
            }

            this.fromSize = from;
            this.toSize = to;
            return this;
        }

        public Subsets withOrder(Order order) {
            this.order = order;
            return this;
        }

        public StringSubsetGenerator build() {
            if (toSize == 0) {
                toSize = data.length();
            }
            return new StringSubsetGenerator(data, fromSize, toSize, order);
        }
    }
}
