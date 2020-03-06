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

package com.sutra.algo.sequence.permutation;

import com.sutra.algo.util.Order;
import com.sutra.algo.util.Util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.sutra.algo.sequence.permutation.Algorithm.nextPermutation;

/**
 * @author Deepesh Patel
 * Starting from a input string, generates all permutaions of a given string
 *
 * For example:
 * <code>
 *          for(String s : new PermutationGenerator ( " ABC ")) {
 *             System.out.println(s);
 *         }
 * </code>
 * will generate following 6 strings
 * ABC,ACB,BAC,BCA,CAB,CBA
 */
public class StringPermutationGenerator implements Iterable<String> {

    private String seed;

    private StringPermutationGenerator(String seed, Order order) {
        this.seed = (order == Order.LEXICAL) ? Util.toLexString(seed) : seed;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr(this.seed);
    }

    public Stream<String> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    private static class Itr implements Iterator<String> {

        private String initialValue;
        private int[] indices;


        Itr(String currentVal) {
            this.initialValue = currentVal;
            createIndices();
        }

        private void createIndices() {
            indices = new int[initialValue.length()];
            for (int i = 0; i < indices.length; i++) {
                indices[i] = i;
            }
        }

        @Override
        public boolean hasNext() {
            return indices != null;
        }

        @Override
        public String next() {

            if (!hasNext()) {
                throw new NoSuchElementException("Reached to maximum permutation");
            }

            int[] oldIndices = indices;
            indices = nextPermutation(indices);
            char[] newChars = Util.indicesToValues(initialValue.toCharArray(), oldIndices);
            return new String(newChars);
        }
    }

    public static class Permutations {

        private String data;
        private Order order = Order.INPUT;

        public Permutations(String data) {
            if (data == null) {
                throw new NullPointerException("cannot generate permutations for null string");
            }
            this.data = data;
        }

        public Permutations withOrder(Order order) {
            this.order = order;
            return this;
        }

        public StringPermutationGenerator build() {
            return new StringPermutationGenerator(data, order);
        }
    }
}
