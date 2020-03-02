package outside;

import algo.sequence.Sequence;

import java.util.Arrays;
import java.util.List;

public class SequenceTest {

    public static void main(String[] args) {

        Iterable<String> itr = Sequence
                .combination()
                .from("ABC")
                .ofSize(2)
                .build();

        System.out.println("----------------------");
        System.out.println("String Combinations");
        for(String s: itr) {
            System.out.println(s);
        }

        System.out.println("----------------------");
        System.out.println("Object Combinations");
        Iterable<List<String>> itr2 = Sequence
                .combination()
                .from(Arrays.asList("A", "B", "C"))
                .ofSize(2)
                .build();

        for(List<String> list: itr2) {
            System.out.println(list);
        }

        Iterable<String> pItr1 = Sequence
                .permutation()
                .from("ABC")
                .build();

        System.out.println("----------------------");
        System.out.println("String Permutations");
        for(String s: pItr1) {
            System.out.println(s);
        }

        Iterable<List<String>> pItr2 = Sequence
                .permutation()
                .from(Arrays.asList("A","B","C"))
                .build();

        System.out.println("----------------------");
        System.out.println("Object Permutations");
        for(List<String> list: pItr2) {
            System.out.println(list);
        }
    }
}
