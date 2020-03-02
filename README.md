# OpenAlgo
Open Source library for useful algorithms and data structures

Currently Available Algorithms

***
**Permutation Generator for String:**
Following code will print all permutations of String "ABC" in lexicographical order


                
      Iterable<String> pItr = Sequence
                .permutation()
                .from("ABC")
                .build();

     for(String s: pItr) {
        System.out.println(s);
     }

***
**Permutation Generator for Objects:**
Following code will print all permutations of Objects in List in lexicographical order
 
        Iterable<List<String>> pItr = Sequence
               .permutation()
               .from(Arrays.asList("A","B","C"))
               .build();

        for(List<String> list: pItr) {
            System.out.println(list);
        }

***
**Combination Generator for String:**
Following code will print all combinations of size R in a string of size N where R <=N in lexicographical order

        Iterable<String> itr = Sequence
                .combination()
                .from("ABC")
                .ofSize(2)
                .build();


        for(String s: itr) {
            System.out.println(s);
        } 

***

**Combination Generator for Objects:**
Following code will print all combinations of size R in a list of Objects of size N where R <=N in lexicographical order

        Iterable<List<String>> itr = Sequence
                .combination()
                .from(Arrays.asList("A", "B", "C"))
                .ofSize(2)
                .build();

        for(List<String> list: itr) {
            System.out.println(list);
        }

***
**Number Sequence Generator for a give base and size:**
Following code will print all numbers of base 5 and size 2 lexicographical order. That is from "00" to "44". Symbols are considered starting from 0-9 and A-Z in order.

        Iterable<String> itr = Sequence
                .numbers()
                .ofBase(5)
                .ofSize(2)
                .build();

        for(String s: itr) {
            System.out.println(s);
        }
***
**Number Sequence Generator with given symbols and size:**
Following code will print all numbers of size 3 for symbols "H" and "T" in lexicographical order. That is from "HHH" to "TTT"

        Iterable<String> itr = Sequence
                .numbers()
                .fromSymbols("HT")
                .ofSize(3)
                .build();

        for(String s: itr) {
            System.out.println(s);
        }
