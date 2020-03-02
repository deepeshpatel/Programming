package algo.sequence.number;

import org.junit.Assert;
import org.junit.Test;

public class NumberGeneratorTest {

    @Test
    public void shouldGenerate8Values() {

        int i=0;
        for(String s: new NumberGenerator(2, 3)) {
            i++;
        }
        Assert.assertEquals(8,i);

    }
}
