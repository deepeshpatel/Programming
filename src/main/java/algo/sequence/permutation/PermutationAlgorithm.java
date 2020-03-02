package algo.sequence.permutation;

class PermutationAlgorithm {

    static int[] nextPermutation(int[] n) {

        int[] c = new int[n.length];
        System.arraycopy(n,0,c,0,c.length);

        int highestI = -1;
        for(int i= c.length-2; i>=0; i-- ) {
            if(c[i] <c[i+1]) {
                highestI = i;
                break;
            }
        }

        if(highestI == -1) {
            return null;
        }

        for(int j=c.length-1; j>highestI; j--) {
            if(c[j] > c[highestI]) {
                int temp = c[j];
                c[j] = c[highestI];
                c[highestI]= temp;
                break;
            }
        }

        for(int i=highestI+1, j = c.length-1; i<j ; i++, j--) {
            int t = c[i];
            c[i] = c[j];
            c[j] = t;
        }

        return c;
    }

    //1. Find the highest index i such that s[i] < s[i+1]. If no such index exists, the permutation is the last permutation.
    //2. Find the highest index j > i such that s[j] > s[i]. Such a j must exist, since i+1 is such an index.
    //3. Swap s[i] with s[j].
    //4. Reverse the order of all of the elements after index i till the last element.

    static String nextPermutation(String s) {

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
