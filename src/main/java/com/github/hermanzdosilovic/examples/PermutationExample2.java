package com.github.hermanzdosilovic.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.hermanzdosilovic.java.util.Permutation;

/**
 * @author Herman Zvonimir Došilović
 * @version 1.0
 */
public final class PermutationExample2 {

    /**
     * Private constructor.
     */
    private PermutationExample2() {
        throw new UnsupportedOperationException("Cannot instantiate utility class.");
    }

    /**
     * Program entry. Does not use command line arguments.
     * @param args
     *            command line arguments. Not is use.
     */
    public static void main(final String[] args) {
        final List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        final Permutation<Integer> permutation = new Permutation<>(list);
        do {
            System.out.println(permutation);
        } while (permutation.nextPermutation());
    }

}
