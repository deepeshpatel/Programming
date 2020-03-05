package com.sutra.algo.util;

import java.util.Arrays;

public class Util {

    public static String toLexString(String s) {
        char[] values = s.toCharArray();
        Arrays.sort(values);
        return new String(values);
    }

    public static char[] indicesToValues(char[] input, int[] indices) {
        char[] output = new char[indices.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = input[indices[i]];
        }
        return output;
    }
}
