package com.github.hermanzdosilovic.examples;

import com.github.hermanzdosilovic.java.util.Permutation;

/**
 * @author Herman Zvonimir Došilović
 * @version 1.0
 */
public final class PermutationExample3 {

    /**
     * Private constructor.
     */
    private PermutationExample3() {
        throw new UnsupportedOperationException("Cannot instantiate utility class.");
    }

    /**
     * Program entry. Does not use command line arguments.
     * @param args
     *            command line arguments. Not is use.
     */
    public static void main(final String[] args) {
        final Permutation<Integer> permutation = new Permutation<>(1, 2, 3);
        while (true) {
            System.out.println(permutation);
            if (!permutation.nextPermutation()) {
                System.out.println("-----------------");
            }
        }
    }

}
