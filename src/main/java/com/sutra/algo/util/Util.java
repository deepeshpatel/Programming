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
}
