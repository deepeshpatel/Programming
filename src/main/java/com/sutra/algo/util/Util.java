package com.sutra.algo.util;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static String toLexString(String s) {
        char[] values = s.toCharArray();
        Arrays.sort(values);
        return new String(values);
    }

    public static <T> List<T> sorted(List<T> list) {

        T[] values = (T[]) list.toArray();
        Arrays.sort(values);
        return Arrays.asList(values);
    }

    public static char[] indicesToValues(char[] input, int[] indices) {
        char[] output = new char[input.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = input[indices[i]];
        }
        return output;
    }
}
