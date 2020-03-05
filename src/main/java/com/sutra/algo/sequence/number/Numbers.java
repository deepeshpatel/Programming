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

public class Numbers {

    private int startFrom;
    private int skipEvery;
    private int base;
    private int size;
    private String symbols;

    public Numbers ofBase(int base) {
        if(base <= 0 )
            throw new IllegalArgumentException(" base must be > 0");
        this.base = base;
        return this;
    }

    public Numbers ofSize(int size) {
        if(size <= 0 )
            throw new IllegalArgumentException(" size must be > 0");
        this.size = size;
        return this;
    }

    public Numbers andSkipEvery(int skipEvery) {
        this.skipEvery = skipEvery;
        return this;
    }

    public Numbers withStartingValue(int startFrom) {
        if(startFrom < 0 )
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

    public Iterable<String> build() {

        if(symbols == null && base == 0) {
            throw new IllegalArgumentException("Must specify either base of the number " +
                    "system or Symbols used to create number system ");
        }

        if (symbols != null && base != 0) {
            throw new IllegalArgumentException("You have specified both base and symbols" +
                    " for the number system. specify only one of them");
        }

        NumberGeneratorParams params;

        if(symbols != null) {
            params = new NumberGeneratorParams(symbols, size, startFrom, skipEvery);
        } else {
            params = new NumberGeneratorParams(base, size, startFrom, skipEvery);
        }
        return new NumberGenerator(params);

    }
}
