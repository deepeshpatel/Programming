package algo.sequence.permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ObjectPermutationGeneratorTest {

    @Test
    public void shouldGenerate6PermutationsForLength3() {

        String[] expected = new String[]{"[A, B]","[B, A]"};
        Iterable<List<String>> pg = new ObjectPermutationGenerator<>(Arrays.asList("A","B"));

        int i=0;
        for(List<String> l : pg) {
            assertEquals(expected[i], l.toString());
            i++;
        }
    }

    @Test
    public void shouldGenerateFiveFactorialPermutations() {
        Iterable<List<String>> pg =
                new ObjectPermutationGenerator<>(Arrays.asList("A","B","C","D","E"));

        int i = 0;
        for(List<String> ignored : pg) {
            i++;
        }
        assertEquals(120, i);
    }
}
