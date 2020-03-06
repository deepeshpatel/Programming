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

package com.sutra.algo.sequence.number;

import java.util.Iterator;

public class NumberGenerator implements Iterable<String>{

    private NumberGeneratorParams params;

    private NumberGenerator(NumberGeneratorParams params) {
        this.params = params;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr(params.symbols.toCharArray(),
                params.size,
                params.startFrom,
                params.skipEvery);
    }

    static class Itr implements Iterator<String> {

        private char[] symbols;
        private int[] currentValuesAsIndices;
        private int skipEvery;
        private boolean hasNext = true;

        Itr(char[] symbols, int size, int startFrom, int skipEvery) {
            this.symbols = symbols;
            this.skipEvery = skipEvery;
            currentValuesAsIndices = new int[size];
            if (startFrom > 0) {
                nextKthNumber(symbols.length, currentValuesAsIndices, startFrom);
            }
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        private static String indicesToValues(int[] indices, char[] values) {

            char[] result = new char[indices.length];

            for (int i = 0; i < indices.length; i++) {
                result[indices.length - 1 - i] = values[indices[i]];
            }

            return new String(result);
        }

        void nextKthNumber(int numOfSymbols, int[] indices, int k) {

            int nextK = k;
            for (int i = 0; i < indices.length; i++) {
                int v = (indices[i] + nextK) % numOfSymbols;
                nextK = (indices[i] + nextK) / numOfSymbols;
                indices[i] = v;
            }
            if (nextK > 0) {
                hasNext = false;
            }
        }

        @Override
        public String next() {
            String result = indicesToValues(currentValuesAsIndices, symbols);

            //TODO: Remove this mess.
            //Use Consumer functional interface for method selection only once
            if(skipEvery > 0) {
                nextKthNumber(symbols.length, currentValuesAsIndices, skipEvery + 1);
                return result;
            } else if(skipEvery < 0) {
                previousKthNumber(symbols.length, currentValuesAsIndices, -(skipEvery + 1));
            } else {
                nextNumber(symbols.length, currentValuesAsIndices);
            }
            return result;
        }

        void previousKthNumber(int numOfSymbols, int[] indices, int k) {

            boolean needToDivide = false;

            for (int i = 0; i < indices.length; i++) {

                int current = needToDivide ? indices[i] - 1 : indices[i];
                int toBeSubtracted = k % numOfSymbols;
                k = k / numOfSymbols;

                int result = current - toBeSubtracted;
                needToDivide = false;

                if (result < 0) {
                    result = (numOfSymbols + current) - toBeSubtracted;
                    needToDivide = true;
                }

                indices[i] = result;
            }

            hasNext = !needToDivide;
        }

        void nextNumber(int numOfSymbols,  int[] indices)  {

            int j;
            for (j=0; j <indices.length ; j++) {

                int v = indices[j];

                if(v == numOfSymbols-1) {
                    indices[j] = 0; //reset to zero
                } else {
                    indices[j] = v + 1;
                    break;  //increment done. no need to proceed further
                }
            }
            hasNext = (j != indices.length);
        }
    }

    public static class Numbers {

        private int startFrom;
        private int skipEvery;
        private int base;
        private int size;
        private String symbols;

        public Numbers ofBase(int base) {
            if (base <= 0)
                throw new IllegalArgumentException(" base must be > 0");
            this.base = base;
            return this;
        }

        public Numbers ofSize(int size) {
            if (size <= 0)
                throw new IllegalArgumentException(" size must be > 0");
            this.size = size;
            return this;
        }

        public Numbers andSkipEvery(int skipEvery) {
            this.skipEvery = skipEvery;
            return this;
        }

        public Numbers withStartingValue(int startFrom) {
            if (startFrom < 0)
                throw new IllegalArgumentException(" StartingValue must be >=0");
            this.startFrom = startFrom;
            return this;
        }

        public Numbers withSymbols(String symbols) {

            if (symbols == null || symbols.isEmpty()) {
                throw new IllegalArgumentException("A non null and non empty string is required" +
                        " for creating symbols of number system");
            }

            this.symbols = symbols;
            return this;
        }

        public NumberGenerator build() {

            if (symbols == null && base == 0) {
                throw new IllegalArgumentException("Must specify either base of the number " +
                        "system or Symbols used to create number system ");
            }

            if (symbols != null && base != 0) {
                throw new IllegalArgumentException("You have specified both base and symbols" +
                        " for the number system. specify only one of them");
            }

            NumberGeneratorParams params;

            if (symbols != null) {
                params = new NumberGeneratorParams(symbols, size, startFrom, skipEvery);
            } else {
                params = new NumberGeneratorParams(base, size, startFrom, skipEvery);
            }
            return new NumberGenerator(params);

        }
    }
}
