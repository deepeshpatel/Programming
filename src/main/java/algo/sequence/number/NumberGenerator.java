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
    private int startFrom;
    private int skipEvery;

    NumberGenerator(char[] symbols, int size, int startFrom, int skipEvery) {
        init(symbols, size, startFrom, skipEvery);
    }

    NumberGenerator(int base, int size, int startFrom, int skipEvery) {

        char[] numericSymbols = new char[base];

        for(int i=0; i<base && i<10; i++) {
            numericSymbols[i] = (char) (i + '0');
        }

        for(int i=10; i<base; i++) {
            numericSymbols[i] = (char) ('A' + (i-10));
        }

        init(numericSymbols, size, startFrom, skipEvery);
    }

    private void init(char[] symbols, int size, int startFrom, int skipEvery) {
        this.symbols = symbols;
        this.size = size;
        this.startFrom = startFrom;
        this.skipEvery = skipEvery;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr(symbols,size, startFrom, skipEvery);
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
            if(startFrom> 0 )
                nextKthNumber(symbols.length, currentValuesAsIndices, startFrom);

        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public String next() {
            String result = indicesToValues(currentValuesAsIndices, symbols);

            if(skipEvery > 0) {
                nextKthNumber(symbols.length, currentValuesAsIndices, skipEvery);
                return result;
            } else {
                nextNumber(symbols.length, currentValuesAsIndices);
            }
            return result;
        }

        void nextKthNumber(int numOfSymbols,  int[] indices, int k)  {

            int nextK = k;
            for(int i=0; i<indices.length; i++) {
                int v = (indices[i] + nextK) % numOfSymbols;
                nextK = (indices[i] + nextK) / numOfSymbols;
                indices[i] = v;
            }
            if(nextK > 0) {
                hasNext = false;
            }
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
            hasNext = j != indices.length;
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
