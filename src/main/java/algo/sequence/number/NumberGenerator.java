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

import java.util.Iterator;

public class NumberGenerator implements Iterable<String>{

    private char[] symbols;
    private int size;

    NumberGenerator(char[] symbols, int size) {
        this.symbols = symbols;
        this.size = size;
    }

    NumberGenerator(int base, int size) {

        char[] numericSymbols = new char[base];

        for(int i=0; i<base && i<10; i++) {
            numericSymbols[i] = (char) (i + '0');
        }

        for(int i=10; i<base; i++) {
            numericSymbols[i] = (char) ('A' + (i-10));
        }

        this.size = size;
        this.symbols = numericSymbols;

    }

    @Override
    public Iterator<String> iterator() {
        return new Itr(symbols,size);
    }

    static class Itr implements Iterator<String> {

        private char[] symbols;
        private int[] currentValuesAsIndices;
        private boolean hasNext = true;


        Itr(char[] symbols, int size) {
            this.symbols = symbols;
            currentValuesAsIndices = new int[size];
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public String next() {
            String result = indicesToValues(currentValuesAsIndices, symbols);
            nextNumber(symbols, currentValuesAsIndices);
            return result;
        }

        void nextNumber(char[] allSymbols,  int[] currentValue)  {


            int j;
            for (j=0; j <currentValue.length ; j++) {

                int v = currentValue[j];

                if(v == allSymbols.length-1) {
                    currentValue[j] = 0; //reset to zero
                } else {
                    currentValue[j] = v + 1;
                    break;  //increment done. no need to proceed further
                }
            }
            hasNext = j != currentValue.length;
        }

        private static String indicesToValues(int[] indices, char[] values) {
            char[] result = new char[indices.length];
            for (int i = 0; i<indices.length; i++) {
                result[indices.length-1-i] = values[indices[i]];
            }
            return new String(result);
        }
    }
}
