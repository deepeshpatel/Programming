package algo.sequence.combination;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationListGeneratorTest {

    private static <T> String listToString(List<T> list) {
        return list.toString();
    }

    @Test
    public void shouldReturn3Combinations() {
        String[] s = new String[]{"Red", "Green", "Blue"};
        List<String> list = Arrays.asList(s);
        CombinationListGenerator<String> cg = new CombinationListGenerator(list, 2);

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

    @Test
    public void testStreamOFCombinations() {
        String[] input = new String[]{"Z", "B", "C"};
        String[] expected = new String[] {"[Z, B]", "[Z, C]","[B, C]"};
        List<String> list = Arrays.asList(input);

        List<String> output = new CombinationListGenerator<String>(list, 2)
                .stream()
                .map(e -> listToString(e))
                .collect(Collectors.toList());

        int i=0;
        for(String s: output) {
            Assert.assertEquals(expected[i++], s);
        }

    }

}
