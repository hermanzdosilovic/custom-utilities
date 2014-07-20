package com.github.hermanzdosilovic.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class PermutationTest {

    @Test
    public void allPermutationsTest() {
        List<List<Integer>> expectedPermutations = new ArrayList<>();
        expectedPermutations.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(2, 1, 3)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(3, 1, 2)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(3, 2, 1)));

        Permutation<Integer> actualPermutation = new Permutation<>(1, 2, 3);
        for (int i = 0;; i++) {
            Assert.assertArrayEquals("List is not the same.", expectedPermutations.get(i).toArray(),
                    actualPermutation.toArray());
            if (!actualPermutation.nextPermutation()) {
                break;
            }
        }
    }

    @Test
    public void resetCollectionToInitialOrder() {
        List<Integer> initialList = new ArrayList<>();
        Random rand = new Random();
        final int listSize = 10;

        for (int i = 0; i < listSize; i++) {
            initialList.add(rand.nextInt());
        }

        List<Integer> expectedList = new ArrayList<>(initialList);
        Permutation<Integer> permutation = new Permutation<>(initialList);

        permutation.nextPermutation();
        permutation.reset();

        List<Integer> actualList = new ArrayList<>(permutation);

        Assert.assertEquals("Size of list is not the same.", expectedList.size(), actualList.size());
        Assert.assertArrayEquals("Elements are not the same.", expectedList.toArray(), actualList.toArray());
    }

    @Test
    public void loopBackPermutationTest() {
        List<List<Integer>> expectedPermutations = new ArrayList<>();
        expectedPermutations.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(3, 1, 2)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(3, 2, 1)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        expectedPermutations.add(new ArrayList<>(Arrays.asList(2, 1, 3)));

        Permutation<Integer> actualPermutation = new Permutation<>(2, 3, 1);
        for (int i = 0;; i++) {
            Assert.assertArrayEquals("List is not the same.", expectedPermutations.get(i).toArray(),
                    actualPermutation.toArray());
            if (!actualPermutation.nextPermutation()) {
                break;
            }
        }
    }
}
