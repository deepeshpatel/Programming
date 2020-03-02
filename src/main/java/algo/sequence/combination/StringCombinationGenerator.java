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

import com.sun.istack.internal.NotNull;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class StringCombinationGenerator implements Iterable<String> {

    private String seed;
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
     */
     StringCombinationGenerator(@NotNull String seed, int r) {

        if(r > seed.length())
            throw new IllegalArgumentException("Can't produce combinations of length " +
                    r + " from list of length " + seed.length());

        this.seed = seed;
        this.r = r;

    }

    Stream<String> stream() {
        return StreamSupport.stream(this.spliterator(),false);
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr(seed,r);
    }

    private static class Itr implements Iterator<String> {

        char[] seed;
        int[] indices;
        int r;

        private Itr(String seed, int r) {
            this.seed = seed.toCharArray();
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
        public String next() {
            int[] old = indices;
            indices = CombinationAlgorithm.nextCombination(indices, seed.length);
            return indicesToString(seed, old);
        }

        private String indicesToString(char[] seed, int[] indices) {
            char[] result = new char[indices.length];
            for(int i=0; i<result.length; i++) {
                result[i] = seed[indices[i]];
            }
            return new String(result);
        }
    }
}




