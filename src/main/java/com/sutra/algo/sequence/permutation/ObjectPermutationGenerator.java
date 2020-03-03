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

import com.sutra.algo.struct.IndexedListWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectPermutationGenerator<T> implements Iterable<List<T>> {

    private final List<T> seed = new ArrayList<>();

    ObjectPermutationGenerator(List<T> seed) {
        this.seed.addAll(seed);
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new Itr<>(seed);
    }

    private static class Itr<T> implements Iterator<List<T>> {

        List<T> values;
        int[] indices;

        private Itr(List<T> values) {
            this.values = values;
            createIndices();
        }

        private void createIndices() {
            indices = new int[values.size()];
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
            indices = PermutationAlgorithm.nextPermutation(indices);
            return new IndexedListWrapper<>(values, old);
        }
    }

}
