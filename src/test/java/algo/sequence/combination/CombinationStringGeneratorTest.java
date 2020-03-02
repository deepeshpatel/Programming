package algo.sequence.combination;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CombinationStringGeneratorTest {

    @Test
    public void shouldReturn3Combinations() {

        CombinationStringGenerator cg = new CombinationStringGenerator("ABCD", 2);
        String[] expected = new String[] {"AB","AC","AD","BC","BD","CD"};

        int i=0;
        for (String s : cg ) {
            Assert.assertEquals(expected[i++], s);
        }
    }

    @Test
    public void testStreamOFCombinations() {

        CombinationStringGenerator cg = new CombinationStringGenerator("ZBC", 2);
        String[] expected = new String[]{"ZB","ZC","BC"};
        List<String> output = cg.stream().map(e -> e).collect(Collectors.toList());

        int i=0;
        for(String s: output) {
            Assert.assertEquals(expected[i++], s);
        }

    }
}
