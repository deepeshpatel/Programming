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

package com.sutra.algo.sequence;

import com.sutra.algo.sequence.combination.Combinations.ObjectCombinations;
import com.sutra.algo.sequence.combination.Combinations.StringCombinations;
import com.sutra.algo.sequence.number.Numbers;
import com.sutra.algo.sequence.permutation.Permutations;
import com.sutra.algo.sequence.permutation.Permutations.ObjectPermutations;
import com.sutra.algo.sequence.random.UniqueRandomGenerator;

import java.util.Collection;

/**
 * @author Deepesh Patel
 * This class provides various useful utilitis to generate sequence of
 * permutations, combinations, unique random numbers, number system of given base etc
 * of
 */
public class Sequence {

    /**
     * Utility to configure and build combination generator from a given String
     * Following code example will generate all combinations of size 2 in input order.
     * That is : CB, CA and BA.
     * <p>
     * Order.LEXICAL will generate output in dictionary order
     * That is: AB, AC and BC
     *
     * @ <code>
     * <p>
     * Iterable<String> itr = Sequence
     * .combinationsOf("CBA")
     * .ofSize(2)
     * .withOrder(Order.INPUT)
     * .build
     * <p>
     * for(String s: itr) {
     * System.out.println(s)
     * }
     *
     * </code>
     */
    public static StringCombinations combinationsOf(String data) {
        return new StringCombinations(data);
    }

    public static <T> ObjectCombinations<T> combinationsOf(Collection<T> data) {
        return new ObjectCombinations<>(data);
    }

    public static <T> ObjectPermutations<T> permutationsOf(Collection<T> data) {
        return new ObjectPermutations<>(data);
    }

    public static Permutations.StringPermutations permutationsOf(String data) {
        return new Permutations.StringPermutations(data);
    }

    public static Numbers numbers() {
        return new Numbers();
    }

    public static UniqueRandomGenerator.Builder uniqueRandomNumbers() {
        return new UniqueRandomGenerator.Builder();
    }
}
