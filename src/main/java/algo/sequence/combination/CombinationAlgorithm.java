
package algo.sequence.combination;

class CombinationAlgorithm {

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
