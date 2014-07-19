package com.github.hermanzdosilovic.examples;

import com.github.hermanzdosilovic.java.util.Permutation;

/**
 * @author Herman Zvonimir Došilović
 * @version 1.0
 */
public final class PermutationExample1 {

	/**
	 * Program entry. Does not use command line arguments.
	 * 
	 * @param args
	 *            command line arguments. Not is use.
	 */
	public static void main(String[] args) {
		Permutation<Integer> permutation = new Permutation<>(1, 2, 3);
		do {
			System.out.println(permutation);
		} while (permutation.nextPermutation());
	}

}
