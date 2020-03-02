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

package algo.sequence.number;

public class NumberGeneratorBuilder {

    private int base;
    private int size;
    private String symbols;

    public NumberGeneratorBuilder ofBase(int base) {
        this.base = base;
        return this;
    }

    public NumberGeneratorBuilder ofSize(int size) {
        this.size = size;
        return this;
    }

    public NumberGeneratorBuilder fromSymbols(String symbols) {
        this.symbols = symbols;
        return this;
    }

    public Iterable<String> build() {

        if(symbols == null && base == 0) {
            throw new IllegalArgumentException("Must specify base of NumberSystem or Symbols");
        }

        if(symbols != null) {
            return new NumberGenerator(symbols.toCharArray(), size);
        }

        return new NumberGenerator(base, size);
    }
}
