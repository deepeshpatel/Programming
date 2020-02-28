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

package algo.sequence;

import com.sun.istack.internal.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;



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
public class PermutationGenerator implements Iterable<String> {

    private final String seed;

    public PermutationGenerator(@NotNull String seed){
       this.seed = seed;
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr(this.seed);
    }

    @Override
    public Spliterator<String> spliterator() {
        throw new RuntimeException("spliterator() not implemented");
    }

    private class Itr implements Iterator<String> {

        String currentVal;

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
            currentVal = findNextLexPermutation(previous);
            return previous;
        }


        //1. Find the highest index i such that s[i] < s[i+1]. If no such index exists, the permutation is the last permutation.
        //2. Find the highest index j > i such that s[j] > s[i]. Such a j must exist, since i+1 is such an index.
        //3. Swap s[i] with s[j].
        //4. Reverse the order of all of the elements after index i till the last element.

        private String findNextLexPermutation(String s) {

            char[]  c = s.toCharArray();

            int highestI = -1;
            for(int i= c.length-2; i>=0; i-- ) {
                if(c[i] <c[i+1]) {
                    highestI = i;
                    break;
                }
            }

            if(highestI == -1) {
                return "-1";
            }

            for(int j=c.length-1; j>highestI; j--) {
                if(c[j] > c[highestI]) {
                    char temp = c[j];
                    c[j] = c[highestI];
                    c[highestI]= temp;
                    break;
                }
            }

            for(int i=highestI+1, j = c.length-1; i<j ; i++, j--) {
                char t = c[i];
                c[i] = c[j];
                c[j] = t;
            }

            return new String(c);
        }


    }
}
