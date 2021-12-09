package com.spamalot.sorts.algorithm;

import com.spamalot.sorts.AbstractSorter;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends AbstractSorter<T> {

  public QuickSort() {
    super("QuickSort");
  }

  @Override
  public void sort(List<T> list, int start, int end) {
    if (start >= 0 && end >= 0 && start < end) {
      int p = partition(list, start, end);
      sort(list, start, p);
      sort(list, p + 1, end);
    }
  }

  private int partition(List<T> list, int start, int end) {

    // Pivot value
    T pivot = list.get((end + start) / 2);

    // Left index
    int i = start - 1;

    // Right index
    int j = end + 1;

    while (true) {
      // Move the left index to the right at least once and while the element at
      // the left index is less than the pivot
      do {
        i++;
      } while (sortOrderCompare(list.get(i), pivot) < 0);

      // Move the right index to the left at least once and while the element at
      // the right index is greater than the pivot
      do {
        j--;
      } while (sortOrderCompare(list.get(j), pivot) > 0);

      // If the indices crossed, return
      if (i >= j) {
        return j;
      }

      // Swap the elements at the left and right indices
      swap(list, i, j);
    }
  }
}
