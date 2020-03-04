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

import com.sutra.algo.struct.Order;

import java.util.List;

public class CombinationBuilder {

    public <T> ObjectCombinationBuilder<T> from(List<T> data) {
        return new ObjectCombinationBuilder<>(data);
    }

    public StringCombinationBuilder from(String data) {
        return new StringCombinationBuilder(data);
    }

    public static abstract class AbstractCombinationBuilder<T> {
        private int size;
        private Order order = Order.INPUT;

        public AbstractCombinationBuilder<T> ofSize(int r) {
            this.size = r;
            return this;
        }

        public AbstractCombinationBuilder<T> orderBy(Order order) {
            this.order = order;
            return this;
        }

        abstract public Iterable<T> build();

    }

    public static class ObjectCombinationBuilder<T> extends AbstractCombinationBuilder<List<T>>{

        private List<T> data;

        ObjectCombinationBuilder(List<T> data) {
            this.data = data;
        }

        @Override
        public Iterable<List<T>> build() {
            return new ObjectCombinationGenerator<>(data, super.size, super.order);
        }
    }

    public static class StringCombinationBuilder extends AbstractCombinationBuilder<String> {

        private String data;

        StringCombinationBuilder(String data) {
            this.data = data;
        }

        @Override
        public Iterable<String> build() {
            return new StringCombinationGenerator(data, super.size, super.order);
        }

    }
}
