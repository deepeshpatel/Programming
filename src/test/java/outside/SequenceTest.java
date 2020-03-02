package outside;

import algo.sequence.Sequence;

import java.util.Arrays;
import java.util.List;

public class SequenceTest {

    private static void testPermutation() {
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

    private static void testCombination() {
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
    }

    private static void testNumbers() {
        Iterable<String> itr1 = Sequence
                .numbers()
                .fromSymbols("HT")
                .ofSize(3)
                .build();

        System.out.println("----------------------");
        System.out.println("Number sequence using symbols");
        for(String s: itr1) {
            System.out.println(s);
        }


        Iterable<String> itr2 = Sequence
                .numbers()
                .ofBase(5)
                .ofSize(2)
                .build();

        System.out.println("----------------------");
        System.out.println("Number sequence using base");
        for(String s: itr2) {
            System.out.println(s);
        }


    }

    public static void main(String[] args) {
        testNumbers();
        testCombination();
        testPermutation();
    }
}
