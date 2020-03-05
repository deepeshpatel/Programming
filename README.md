# OpenAlgo
Open Source library for useful algorithms and data structures

**Currently Available Algorithms**

Sequence Generators For -

1. Permutation of Strings
1. Permutation of Objects
1. Combination of R characters in a string of length N
1. Combination of R objects in a list of length N
1. Numbers of any base/symbols with a given width
1. Unique random integers in a given bound   

***
**Permutation Generator for String:**
Following code will print all permutations of String "ABC" in lexicographical order.

```java
class Example {
    public example() {
        Iterable<String> pItr = Sequence
                .permutationsOf("CBA")
                .from("ABC")
                .orderBy(Order.LEXICAL) //Or Order.INPUT
                .build();
        
        for(String s: pItr) {
        System.out.println(s);
        }        
    }
}
```
***
**Permutation Generator for Objects:**
Following code will print all permutations of Objects in List in lexicographical order
```java
class Example {
    public example() {
        Iterable<List<String>> pItr = Sequence
               .permutationsOf(Arrays.asList("A","B","C"))
               //.orderBy(Order.INPUT) //Not required. Input is already sorted
               .build();

        for(List<String> list: pItr) {
            System.out.println(list);
        }        
    }
}
```
***
**Combination Generator for String:**
Following code will print (in lexicographical order) all combinations
 of substring of size R in a string of size N where R <= N
```java
class Example {
    public example() {
        Iterable<String> itr = Sequence
                .combinationsOf("ABC")
                .ofSize(2)
                .orderBy(Order.LEXICAL)
                .build();
    
        for(String s: itr) {
            System.out.println(s);
        }         
    }
}
```
***

**Combination Generator for Objects:**
Following code will print (in lexicographical order) all combinations of size R in a list of Objects of size N where R <=N
```java
class Example {
    public example() {
        Iterable<List<String>> itr = Sequence
                .combinationsOf(Arrays.asList("A", "B", "C"))
                .ofSize(2)
                .orderBy(Order.LEXICAL)
                .build();
    
        for(List<String> list: itr) {
            System.out.println(list);
        }        
    }
}
```
***
**Number Sequence Generator for a given base and size:**
Following code will print numbers of base 5 and size 2 in lexicographical order 
starting from 4th number and skipping every 5 numbers. 
Symbols are considered starting from 0-9 and then A-Z in order.

```java
class Example {
    public example() {
        Iterable<String> itr = Sequence
            .numbers()
            .ofBase(5)
            .ofSize(2)
            .withStartingValue(4)
            .andSkipEvery(5)
            .build();
    
        for(String s: itr) {
            System.out.println(s);
        }        
    }
}
```
***
**Number Sequence Generator with given symbols and size:**
Following code will print all numbers of size 3 for symbols "H" and "T" 
in lexicographical order.That is, from "HHH" to "TTT". 
In this case length of 'symbols' define the base of number system

```java
class Example {
    public example() {
        Iterable<String> itr = Sequence
             .numbers()
             .fromSymbols("HT")
             .ofSize(3)
             .withStartingValue(2)
             .andSkipEvery(2) //-ve values are supported       
             .build();
        
        for(String s: itr) {
         System.out.println(s);
        }       
    }
}
```
***
**Random Integer Generator which produces unique random integers in a given bound. 

```java
class Example {
    public example() {
        Iterable<Integer> randomInts = Sequence
                .uniqueRandomNumbers()
                .inRange(-4, 4)
                .build();

        for(int i: randomInts) {
            System.out.println(i);
        }      
    }
}
```
