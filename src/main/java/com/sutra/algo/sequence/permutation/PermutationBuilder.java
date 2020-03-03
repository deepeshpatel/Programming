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

import java.util.List;

public class PermutationBuilder {

    public <T> ObjectPermutationBuilder<T> from(List<T> data) {
        return new ObjectPermutationBuilder<>(data);
    }

    public StringPermutationBuilder from(String data) {
        return new StringPermutationBuilder(data);
    }

    public static class ObjectPermutationBuilder<T> {
        List<T> data;

        ObjectPermutationBuilder(List<T> data) {
            this.data = data;
        }

        public Iterable<List<T>> build() {
            return new ObjectPermutationGenerator<>(data);
        }
    }

    public static class StringPermutationBuilder {
        String data;

        StringPermutationBuilder(String data) {
            this.data = data;
        }

        public Iterable<String> build() {
            return new StringPermutationGenerator(data);
        }
    }

}