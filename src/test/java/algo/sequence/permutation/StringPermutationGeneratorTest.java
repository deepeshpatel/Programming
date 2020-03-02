package algo.sequence.permutation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringPermutationGeneratorTest {

    @Test
    public void shouldGenerate6PermutationsForLength3() {

        String[] values = new String[] {"ABC","ACB","BAC","BCA","CAB","CBA"};
        StringPermutationGenerator pg = new StringPermutationGenerator("ABC");

        int i = 0;
        for(String s:pg) {
            assertEquals(values[i++], s);
        }
    }

    @Test
    public void shouldGenerateFiveFactorialPermutations() {
        int i = 0;
        for(String ignored : new StringPermutationGenerator("ABCDE")) {
            i++;
        }
        assertEquals(120, i);
    }
}
