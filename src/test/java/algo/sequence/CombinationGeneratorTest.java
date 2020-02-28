package algo.sequence;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CombinationGeneratorTest {

    @Test
    public void shouldReturn3Combinations() {
        String[] s = new String[]{"Red", "Green", "Blue"};
        List<String> list = Arrays.asList(s);

        CombinationGenerator<List<String>> cg = new CombinationGenerator(list, 2);

        String[] result = new String[] {
                "[Red, Green]",
                "[Red, Blue]",
                "[Green, Blue]"
        };

        int i=0;
        for (List<String> l: cg ) {
            Assert.assertEquals(result[i++], l.toString());
        }

    }

}
