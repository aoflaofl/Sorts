package com.spamalot.sorts.algorithm;

import com.spamalot.sorts.AbstractSorter;
import java.util.List;

/**
 * Implementation of an Insertion Sort.
 * 
 * <p>Algorithm taken from Section 8-7 of Introduction to Algorithms, Third
 * Edition by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and
 * Clifford Stein
 * 
 * <p>Modified to allow 0 as starting index and allow sorting an index
 * range.
 * 
 * @author gej
 * @param <T>
 *          A type that implements the Comparable interface.
 */
public final class InsertionSort2<T extends Comparable<T>> extends AbstractSorter<T> {
  /**
   * Constructor for InsertionSort.
   */
  public InsertionSort2() {
    super("InsertionSort2");
  }

  @Override
  public void sort(final List<T> list, final int start, final int end) {

    for (int j = start + 1; j <= end; j++) {
      for (int i = j - 1; i >= start; i--) {
        compareExchange(list, i, i + 1);
      }
    }
  }

}
