package algo.sequence.combination;

import java.util.List;

public class CombinationBuilder {

    public <T> ObjectCombinationBuilder<T> from(List<T> data) {
        return new ObjectCombinationBuilder<>(data);
    }

    public StringCombinationBuilder from(String data) {
        return new StringCombinationBuilder(data);
    }

    public static class ObjectCombinationBuilder<T> {

        int size;
        List<T> data;

        ObjectCombinationBuilder(List<T> data) {
            this.data = data;
        }

        public ObjectCombinationBuilder<T> ofSize(int r) {
            this.size = r;
            return this;
        }

        public Iterable<List<T>> build() {
            return new ObjectCombinationGenerator<>(data, size);
        }

    }

    public static class StringCombinationBuilder {

        int size;
        String data;

        StringCombinationBuilder(String data) {
            this.data = data;
        }

        public StringCombinationBuilder ofSize(int r) {
            this.size = r;
            return this;
        }

        public Iterable<String> build() {
            return new StringCombinationGenerator(data, size);
        }

    }
}
