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


import com.sun.istack.internal.NotNull;
import com.sutra.algo.struct.Order;
import com.sutra.algo.util.Util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Deepesh Patel
 * Starting from a input string, generates all permutaions of a given string
 * which are lexicographically greater than
 * a given string.
 *
 * For example:
 * <code>
 *          for(String s : new PermutationGenerator ( " ABC ")) {
 *             System.out.println(s);
 *         }
 * </code>
 * will generate following 6 strings
 * ABC,ACB,BAC,BCA,CAB,CBA
 * Note that if you start from CAB it will generate only 2 values CAB and CBA
 */
public class StringPermutationGenerator implements Iterable<String> {

    private String seed;

    StringPermutationGenerator(@NotNull String seed){
        this.seed = seed;
    }

    StringPermutationGenerator(@NotNull String seed, Order order){
        this.seed = (order == Order.LEXICAL) ? Util.toLexString(seed) : seed;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr(this.seed);
    }

    private static class Itr implements Iterator<String> {

        private String currentVal;

        Itr(String currentVal) {
            this.currentVal = currentVal;
        }

        @Override
        public boolean hasNext() {
            return  !currentVal.equals("-1");
        }

        @Override
        public String next() {

            if(! hasNext()) {
                throw new NoSuchElementException("Reached to maximum permutation");
            }

            String previous = currentVal;
            currentVal = PermutationAlgorithm.nextPermutation(previous);
            return previous;
        }
    }
}
