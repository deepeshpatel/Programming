package algo.sequence;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationGeneratorTest {

    private static <T> String listToString(List<T> list) {
        return list.toString();
    }

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

    @Test
    public void testStreamOFCombinations() {
        String[] s = new String[]{"A", "B", "C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X"};
        List<String> list = Arrays.asList(s);
        CombinationGenerator<List<String>> cg = new CombinationGenerator(list, s.length/2);

        List<String> output = cg.stream().map(e -> listToString(e)).collect(Collectors.toList());
        for(String v: output) {
            System.out.println(v);
        }

    }

}
