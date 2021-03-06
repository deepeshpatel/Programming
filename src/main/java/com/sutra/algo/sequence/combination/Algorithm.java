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

class Algorithm {

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
     * @param a int array containing current indices/number of length r
     * @param n number of combinations from N items. r must be <= n
     */
    static int[] nextCombination(int[]a, int n) {

        int[] next = new int[a.length];
        System.arraycopy(a,0,next,0, a.length);

        int i=next.length-1;
        //max supported value at index i
        int maxSupportedValue = n-1;

        while( i>=0 && next[i] == maxSupportedValue) {
            i--;
            maxSupportedValue--;
        }
        if(i==-1) {
            return null;
        }

        next[i] = next[i] + 1;

        for(int j=i+1; j<next.length; j++) {
            next[j] = next[j-1]+1;
        }

        return next;
    }

}
