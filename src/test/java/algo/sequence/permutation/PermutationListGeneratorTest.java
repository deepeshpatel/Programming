package algo.sequence.permutation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PermutationListGeneratorTest {

    @Test
    public void shouldGenerate6PermutationsForLength3() {

        String[] values = new String[] {"A","B"};
        String[] expected = new String[]{"[A, B]","[B, A]"};
        PermutationListGenerator<String> pg = new PermutationListGenerator<>(Arrays.asList(values));

        int i=0;
        for(List<String> l : pg) {
            assertEquals(expected[i], l.toString());
            i++;
        }
    }

    @Test
    public void shouldGenerateFiveFactorialPermutations() {
        String[] values = new String[] {"A","B","C","D","E"};
        PermutationListGenerator<String> pg = new PermutationListGenerator<>(Arrays.asList(values));

        int i = 0;
        for(List<String> ignored : pg) {
            i++;
        }
        assertEquals(120, i);
    }
}
