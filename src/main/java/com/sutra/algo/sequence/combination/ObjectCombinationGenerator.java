/*
 * Copyright (c) 2020 Deepesh Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sutra.algo.sequence.combination;

import com.sutra.algo.util.IndexedListWrapper;
import com.sutra.algo.util.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ObjectCombinationGenerator<T> implements Iterable<List<T>> {

    private List<T> seed;
    private int r;

    /**
     * @author Deepesh Patel
     *
     * Algorithm for generating r-combinations of Seed = {1, 2, . . ., n − 1, n}
     *
     * Generates r combinations from n=seed.length items.
     * combinations are generated in Lexicographic order
     * of indices of items in a list.
     *
     * The collection of all 4-combinations of {1, 2, 3, 4, 5, 6} are -
     * 1234 1245 1345 1456 2356
     * 1235 1246 1346 2345 2456
     * 1236 1256 1356 2346 3456
     *
     * @param seed List of N items
     * @param r number of combinations from N items. r must be <= N
     * @param order order of output. Input order or Lexicographical order
     */
    private ObjectCombinationGenerator(Collection<T> seed, int r, Order order) {

        if (r > seed.size())
            throw new IllegalArgumentException("Can't produce combinations of length " +
                    r + " from collection of length " + seed.size());

        this.r = r;
        this.seed = order == Order.INPUT ?
                new ArrayList<>(seed)
                : seed.stream().sorted().collect(Collectors.toList());

    }

    public Stream<List<T>> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new Itr<>(seed,r);
    }

    private static class Itr<T> implements Iterator<List<T>> {

        List<T> values;
        int[] indices;
        int r;

        private Itr(List<T> values, int r) {
            this.values = values;
            this.r = r;
            createIndices();
        }

        private void createIndices() {
            indices = new int[r];
            for (int i = 0; i < indices.length; i++) {
                indices[i] = i;
            }
        }

        @Override
        public boolean hasNext() {
            return indices != null;
        }

        @Override
        public List<T> next() {
            int[] old = indices;
            indices = Algorithm.nextCombination(indices, values.size());
            return new IndexedListWrapper<>(values, old);
        }
    }

    public static class Combinations<T> {

        private Collection<T> data;
        private int size;
        private Order order = Order.INPUT;


        public Combinations(Collection<T> data) {
            if (data == null) {
                throw new NullPointerException("can not generate combinations from null input");
            }
            this.data = data;
        }

        public Combinations<T> ofSize(int r) {
            this.size = r;
            return this;
        }

        public Combinations<T> withOrder(Order order) {
            this.order = order;
            return this;
        }

        public ObjectCombinationGenerator<T> build() {
            return new ObjectCombinationGenerator<>(data, size, order);
        }
    }
}

