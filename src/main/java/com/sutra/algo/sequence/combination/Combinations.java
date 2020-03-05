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

import com.sutra.algo.util.Order;

import java.util.Collection;
import java.util.List;

public abstract class Combinations<T> {

    private int size;
    private Order order = Order.INPUT;

    public Combinations<T> ofSize(int r) {
        this.size = r;
        return this;
    }

    public Combinations<T> withOrder(Order order) {
        this.order = order;
        return this;
    }

    abstract public Iterable<T> build();

    public static class ObjectCombinations<T> extends Combinations<List<T>> {

        private Collection<T> data;

        public ObjectCombinations(Collection<T> data) {
            this.data = data;
        }

        @Override
        public Iterable<List<T>> build() {
            return new ObjectCombinationGenerator<>(data, super.size, super.order);
        }
    }

    public static class StringCombinations extends Combinations<String> {

        private String data;

        public StringCombinations(String data) {
            this.data = data;
        }

        @Override
        public Iterable<String> build() {
            return new StringCombinationGenerator(data, super.size, super.order);
        }

    }
}
