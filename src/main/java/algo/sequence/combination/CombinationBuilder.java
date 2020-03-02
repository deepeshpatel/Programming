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

package algo.sequence.combination;

import java.util.List;

public class CombinationBuilder {

    public <T> ObjectCombinationBuilder<T> from(List<T> data) {
        return new ObjectCombinationBuilder<>(data);
    }

    public StringCombinationBuilder from(String data) {
        return new StringCombinationBuilder(data);
    }

    public static class ObjectCombinationBuilder<T> {

        int size;
        List<T> data;

        ObjectCombinationBuilder(List<T> data) {
            this.data = data;
        }

        public ObjectCombinationBuilder<T> ofSize(int r) {
            this.size = r;
            return this;
        }

        public Iterable<List<T>> build() {
            return new ObjectCombinationGenerator<>(data, size);
        }

    }

    public static class StringCombinationBuilder {

        int size;
        String data;

        StringCombinationBuilder(String data) {
            this.data = data;
        }

        public StringCombinationBuilder ofSize(int r) {
            this.size = r;
            return this;
        }

        public Iterable<String> build() {
            return new StringCombinationGenerator(data, size);
        }

    }
}
