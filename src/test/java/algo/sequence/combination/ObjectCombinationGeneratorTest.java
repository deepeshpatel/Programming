package algo.sequence.combination;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectCombinationGeneratorTest {

    private static <T> String listToString(List<T> list) {
        return list.toString();
    }

    @Test
    public void shouldReturn3Combinations() {
        List<String> list = Arrays.asList("Red", "Green", "Blue");
        ObjectCombinationGenerator<String> cg = new ObjectCombinationGenerator<>(list, 2);

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
        String[] expected = new String[] {"[Z, B]", "[Z, C]","[B, C]"};
        List<String> input = Arrays.asList("Z", "B", "C");

        List<String> output = new ObjectCombinationGenerator<>(input, 2)
                .stream()
                .map(ObjectCombinationGeneratorTest::listToString)
                .collect(Collectors.toList());

        int i=0;
        for(String s: output) {
            Assert.assertEquals(expected[i++], s);
        }

    }

}
