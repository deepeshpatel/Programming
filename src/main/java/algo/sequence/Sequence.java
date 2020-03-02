package algo.sequence;

import algo.sequence.combination.CombinationBuilder;
import algo.sequence.permutation.PermutationBuilder;

public class Sequence {

    public static CombinationBuilder combination() {
        return new CombinationBuilder();
    }

    public static PermutationBuilder permutation() {
        return new PermutationBuilder();
    }

}
