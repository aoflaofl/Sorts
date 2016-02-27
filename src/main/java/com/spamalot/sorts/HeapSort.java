package com.spamalot.sorts;

import java.util.List;

/**
 * Implementation of a Heap Sort.
 *
 * <p>
 * Algorithm adapted from ....
 * 
 * <p>
 * Modified to allow 0 as starting index and allow sorting an index range.
 * 
 * @author gej
 * @param <T>
 *          A type that implements the Comparable interface.
 */

final class HeapSort<T extends Comparable<T>> extends Sorter<T> {

  /**
   * Constructor for HeapSort.
   */
  HeapSort() {
    super("HeapSort");
  }

  /**
   * Hold the index of the first element to be sorted.
   */
  private int listStartIdx;

  /**
   * Get the parent index of an element.
   * 
   * @param idx
   *          An index.
   * @return The index of the parent.
   */
  private int parent(final int idx) {
    return (idx - 1 + this.listStartIdx) / 2;
  }

  /**
   * Get the left child index in a heap.
   * 
   * @param idx
   *          An index.
   * @return The left child of this index in a heap.
   */
  private int left(final int idx) {
    return 2 * idx + 1 - this.listStartIdx;
  }

  /**
   * Get the right child index in a heap.
   * 
   * @param idx
   *          An index.
   * @return The right child of this index in a heap.
   */
  private int right(final int idx) {
    return 2 * idx + 2 - this.listStartIdx;
  }

  /**
   * @param list
   *          The list to be heaped.
   * @param start
   *          The index to start the heaping.
   * @param end
   *          The index to end the heaping.
   */
  private void maxHeapify(final List<T> list, final int start, final int end) {
    int largest;

    int left = left(start);
    int right = right(start);
    if (left <= end && sortOrderCompare(list, left, start) > 0) {
      largest = left;
    } else {
      largest = start;
    }
    if (right <= end && sortOrderCompare(list, right, largest) > 0) {
      largest = right;
    }
    if (largest != start) {
      swap(list, start, largest);

      maxHeapify(list, largest, end);
    }
  }

  /**
   * Take a list and heapify it.
   * 
   * @param list
   *          The list to heapify.
   * @param start
   *          The start index
   * @param end
   *          The end index
   */
  private void buildMaxHeap(final List<T> list, final int start, final int end) {
    int lastHeap = parent(end);

    for (int i = lastHeap; i >= start; i--) {
      maxHeapify(list, i, end);
    }
  }

  @Override
  public void sort(final List<T> list, final int start, final int end) {
    this.listStartIdx = start;

    buildMaxHeap(list, start, end);
    for (int i = end; i > start; i--) {
      swap(list, start, i);

      maxHeapify(list, start, i - 1);
    }
  }
}
