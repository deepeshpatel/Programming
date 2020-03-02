package algo.sequence.permutation;

import algo.struct.IndexedListWrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjectPermutationGenerator<T> implements Iterable<List<T>> {

    private final List<T> seed = new ArrayList<>();

    ObjectPermutationGenerator(List<T> seed) {
        this.seed.addAll(seed);
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new Itr<>(seed);
    }

    private static class Itr<T> implements Iterator<List<T>> {

        List<T> values;
        int[] indices;

        private Itr(List<T> values) {
            this.values = values;
            createIndices();
        }

        private void createIndices() {
            indices = new int[values.size()];
            for (int i = 0; i < indices.length; i++) {
                indices[i] = i;
            }
        }

        @Override
        public boolean hasNext() {
            return indices != null;
        }

        @Override
        public List<T> next() {
            int[] old = indices;
            indices = PermutationAlgorithm.nextPermutation(indices);
            return new IndexedListWrapper<>(values, old);
        }
    }

}
