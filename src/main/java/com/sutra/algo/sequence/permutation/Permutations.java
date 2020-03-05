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

import java.util.Collection;
import java.util.List;

public abstract class Permutations<T> {

    protected Order order = Order.INPUT;

    public Permutations<T> withOrder(Order order) {
        this.order = order;
        return this;
    }

    abstract public Iterable<T> build();

    public static class ObjectPermutations<T> extends Permutations<List<T>> {

        private Collection<T> data;

        public ObjectPermutations(Collection<T> data) {
            this.data = data;
        }

        @Override
        public Iterable<List<T>> build() {
            return new ObjectPermutationGenerator<>(data, order);
        }
    }

    public static class StringPermutations extends Permutations<String> {
        private String data;

        public StringPermutations(String data) {
            this.data = data;
        }

        public Iterable<String> build() {
            return new StringPermutationGenerator(data, order);
        }
    }
}