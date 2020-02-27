package algo.sequence;

import org.junit.Assert;
import org.junit.Test;


public class PermutationGeneratorTest {

    @Test
    public void shouldGenerate6PermutationsForLength3() {

        String[] values = new String[] {"ABC","ACB","BAC","BCA","CAB","CBA"};
        PermutationGenerator pg = new PermutationGenerator("ABC");

        int i = 0;
        for(String s:pg) {
            Assert.assertEquals(values[i++], s);
        }
    }

    @Test
    public void shouldGenerateFiveFactorialPermutations() {
        int i = 0;
        for(String s: new PermutationGenerator("ABCDE")) {
            i++;
        }
        Assert.assertEquals(120, i);
    }
}
