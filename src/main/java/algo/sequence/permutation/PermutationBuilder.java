package algo.sequence.permutation;

import java.util.List;

public class PermutationBuilder {

    public <T> ObjectPermutationBuilder<T> from(List<T> data) {
        return new ObjectPermutationBuilder<>(data);
    }

    public StringPermutationBuilder from(String data) {
        return new StringPermutationBuilder(data);
    }

    public static class ObjectPermutationBuilder<T> {
        List<T> data;

        ObjectPermutationBuilder(List<T> data) {
            this.data = data;
        }

        public Iterable<List<T>> build() {
            return new ObjectPermutationGenerator<>(data);
        }
    }

    public static class StringPermutationBuilder {
        String data;

        StringPermutationBuilder(String data) {
            this.data = data;
        }

        public Iterable<String> build() {
            return new StringPermutationGenerator(data);
        }
    }

}