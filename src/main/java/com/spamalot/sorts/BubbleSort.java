package com.spamalot.sorts;

import java.util.List;

/**
 * Implementation of a Bubble Sort.
 * 
 * <p>
 * Algorithm adapted from Algorithm B in Knuth, The Art of Computer Programming
 * - Volume 3 -Sorting and Searching - Second Edition - page 107
 * 
 * <p>
 * Modified to allow 0 as starting index and allow sorting an index range.
 * 
 * <p>
 * Analysis: Blah... blah...
 * 
 * @author gej
 * @param <T>
 *          A type that implements the Comparable interface.
 */

public final class BubbleSort<T extends Comparable<T>> extends Sorter<T> {

  /**
   * Constructor for BubbleSort.
   */
  BubbleSort() {
    super("BubbleSort");
  }

  @Override
  public void sort(final List<T> list, final int start, final int end) {
    int bound = end;
    int tt;
    do {
      tt = start;
      for (int j = start; j < bound; j++) {
        if (sortOrderCompare(list, j, j + 1) > 0) {
          swap(list, j, j + 1);
          tt = j;
        }
      }
      bound = tt;
    } while (tt != start);
  }
}
