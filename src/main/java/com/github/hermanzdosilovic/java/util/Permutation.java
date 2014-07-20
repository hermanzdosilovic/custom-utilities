package com.github.hermanzdosilovic.java.util;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <code>Permutation</code> collection is used as any other collection from Java Collection Framework except it works
 * with <code>Comparable</code> types. On this collection you can ask for <code>nextPermutation</code>. This function
 * will generate next permutation of elements in this collection and will return <code>true</code> if more permutations
 * are available.
 * @author Herman Zvonimir Došilović
 * @version 1.0
 * @param <T>
 *            type of <code>Comparable</code> value that this collection will store.
 */
public class Permutation<T extends Comparable<T>> extends AbstractList<T> {

    /** Working set of elements. **/
    private List<T> workElements;

    /** Initial set of elements given by user. **/
    private List<T> initialElements;

    /** Sorted set of initial elements. **/
    private List<T> sortedElements;

    /** If <code>true</code> user gave sorted elements, <code>false</code> otherwise. **/
    private boolean fromBegin;

    /**
     * Constructs new <code>Permutation</code> collection.
     * @param elements
     *            array of elements.
     */
    @SafeVarargs
    public Permutation(final T... elements) {
        this(Arrays.asList(elements));
    }

    /**
     * Constructs new <code>Permutation</code> collection. Will make its own copy of elements.
     * @param elements
     *            collection from which it needs to take over elements.
     */
    public Permutation(final Collection<T> elements) {
        super();
        this.workElements = new ArrayList<>(elements);
        this.initialElements = new ArrayList<>(elements);
        this.sortedElements = new ArrayList<>(elements);
        Collections.sort(sortedElements);
        fromBegin = this.workElements.equals(this.sortedElements);
    }

    /**
     * Generates next permutation of elements it this collection.
     * @return <code>true</code> if more permutations are available, <code>false</code> otherwise.
     */
    public final boolean nextPermutation() {
        int i;
        for (i = workElements.size() - 2; i >= 0; i--) {
            if (workElements.get(i).compareTo(workElements.get(i + 1)) < 0) {
                break;
            }
        }

        if (i < 0) {
            if (fromBegin) {
                workElements = new ArrayList<>(initialElements);
                return false;
            }
            workElements = new ArrayList<>(sortedElements);
            return true;
        }

        int minn = i + 1;
        for (int j = i + 1; j < workElements.size(); j++) {
            if (workElements.get(i).compareTo(workElements.get(j)) < 0
                    && workElements.get(j).compareTo(workElements.get(minn)) < 0) {
                minn = j;
            }
        }

        T element = workElements.get(minn);
        workElements.set(minn, workElements.get(i));
        workElements.set(i, element);

        Collections.sort(workElements.subList(i + 1, workElements.size()));
        if (!fromBegin && workElements.equals(initialElements)) {
            return false;
        }
        return true;
    }

    /**
     * Resets this collection to its initial order.
     */
    public final void reset() {
        this.workElements = new ArrayList<>(initialElements);
    }

    @Override
    public final T get(final int index) {
        return workElements.get(index);
    }

    @Override
    public final int size() {
        return workElements.size();
    }

}
