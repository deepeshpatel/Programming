package com.sutra.algo.sequence.subset;

import com.sutra.algo.sequence.combination.ObjectCombinationGenerator;
import com.sutra.algo.util.IteratorSequence;
import com.sutra.algo.util.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ObjectSubsetGenerator<T> implements Iterable<List<T>> {

    private Collection<T> data;
    private int fromSize;
    private int toSize;
    private Order order;

    private ObjectSubsetGenerator(Collection<T> data, int fromSize, int toSize, Order order) {
        this.data = data;
        this.fromSize = fromSize;
        this.toSize = toSize;
        this.order = order;
    }

    public Stream<List<T>> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @Override
    public Iterator<List<T>> iterator() {

        List<Iterable<List<T>>> iterables = new ArrayList<>();
        for (int i = toSize; i >= fromSize; i--) {

            ObjectCombinationGenerator<T> generator = new ObjectCombinationGenerator
                    .Combinations<>(data)
                    .ofSize(i)
                    .withOrder(order)
                    .build();

            iterables.add(generator);
        }

        return new IteratorSequence<>(iterables);
    }

    public static class Subsets<T> {

        private int fromSize = 1;
        private int toSize;
        private Collection<T> data;
        private Order order = Order.INPUT;

        public Subsets(Collection<T> data) {
            if (data == null) {
                throw new NullPointerException("Can not generate subset of null String");
            }
            this.data = data;
        }


        public Subsets<T> inRange(int from, int to) {

            if (from < 0 || to > data.size() || to < from) {
                throw new IllegalArgumentException("'from' must be >=0\n" +
                        "'to' must be <= data length\n" +
                        "and 'from' must be <= 'to'");
            }

            this.fromSize = from;
            this.toSize = to;
            return this;
        }

        public Subsets<T> withOrder(Order order) {
            this.order = order;
            return this;
        }

        public ObjectSubsetGenerator build() {
            if (toSize == 0) {
                toSize = data.size();
            }
            return new ObjectSubsetGenerator<>(data, fromSize, toSize, order);
        }
    }
}
