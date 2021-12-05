package com.spamalot.sorts.algorithm;

import com.spamalot.sorts.Sorter;

import java.util.List;

/**
 * Implementation of an Insertion Sort.
 * 
 * <p>Algorithm taken from ...
 * 
 * <p>Modified to allow 0 as starting index and allow sorting an index
 * range.
 * 
 * @author gej
 * @param <T>
 *          A type that implements the Comparable interface.
 */
public final class InsertionSort<T extends Comparable<T>> extends Sorter<T> {

  /**
   * Constructor for InsertionSort.
   */
  public InsertionSort() {
    super("InsertionSort");
  }

  @Override
  public void sort(final List<T> list, final int start, final int end) {
    int ii;
    T key;

    for (int j = start + 1; j <= end; j++) {
      key = list.get(j);
      ii = j;
      while (ii > start && sortOrderCompare(list.get(ii - 1), key) > 0) {
        move(list, ii, ii - 1);
        ii--;
      }
      list.set(ii, key);
    }
  }
}
