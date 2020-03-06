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

import com.sutra.algo.sequence.combination.ObjectCombinationGenerator;
import com.sutra.algo.sequence.combination.StringCombinationGenerator;
import com.sutra.algo.sequence.number.NumberGenerator;
import com.sutra.algo.sequence.permutation.ObjectPermutationGenerator;
import com.sutra.algo.sequence.permutation.StringPermutationGenerator;
import com.sutra.algo.sequence.random.UniqueRandomGenerator;
import com.sutra.algo.sequence.subset.ObjectSubsetGenerator;
import com.sutra.algo.sequence.subset.StringSubsetGenerator;

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
    public static StringCombinationGenerator.Combinations combinationsOf(String data) {
        return new StringCombinationGenerator.Combinations(data);
    }

    public static <T> ObjectCombinationGenerator.Combinations<T> combinationsOf(Collection<T> data) {
        return new ObjectCombinationGenerator.Combinations<>(data);
    }

    public static <T> ObjectPermutationGenerator.Permutations<T> permutationsOf(Collection<T> data) {
        return new ObjectPermutationGenerator.Permutations<>(data);
    }

    public static StringPermutationGenerator.Permutations permutationsOf(String data) {
        return new StringPermutationGenerator.Permutations(data);
    }

    public static NumberGenerator.Numbers numbers() {
        return new NumberGenerator.Numbers();
    }

    public static UniqueRandomGenerator.Builder uniqueRandomNumbers() {
        return new UniqueRandomGenerator.Builder();
    }

    public static StringSubsetGenerator.Subsets subsetsOf(String data) {
        return new StringSubsetGenerator.Subsets(data);
    }

    public static <T> ObjectSubsetGenerator.Subsets<T> subsetsOf(Collection<T> data) {
        return new ObjectSubsetGenerator.Subsets<>(data);
    }
}
