package com.spamalot.sorts;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains main() method to test Sorting Classes.
 * 
 * @author gej
 * 
 */
public final class SortTest {

  /**
   * Do not instantiate.
   */
  private SortTest() {
  }

  /**
   * The number of elements if nothing is specified on the command line.
   */
  private static final int DEFAULT_COUNT = 10;
  /**
   * The maximum random number to generate if nothing is specified on the command
   * line.
   */
  private static final int DEFAULT_MAX_VAL = 100;

  /**
   * Start here.
   * 
   * @param args
   *          Arguments to the program.
   */
  public static void main(final String[] args) {
    List<Integer> list;

    int count = DEFAULT_COUNT;
    if (args.length > 0 && args[0] != null) {
      count = Integer.parseInt(args[0]);
    }
    int maxval = DEFAULT_MAX_VAL;
    if (args.length > 1 && args[1] != null) {
      maxval = Integer.parseInt(args[1]);
    }

    list = SortUtil.makeListOfRndInts(count, maxval);
    if (!SortUtil.isOrdered(list)) {
      System.out.println("Not Sorted!");
    }
    List<Integer> listCopy = new ArrayList<>();
    listCopy.addAll(list);

    Sorter<Integer> insertionSort = new InsertionSort<>();
    insertionSort.sort(list);

    for (int k = 0; k < list.size(); k++) {
      System.out.println(list.get(k));
    }

    insertionSort.report();

    list.clear();
    list.addAll(listCopy);

    Sorter<Integer> i2 = new InsertionSort2<>();
    i2.sort(list);
    i2.report();

    list.clear();
    list.addAll(listCopy);

    Sorter<Integer> bubbleSort = new BubbleSort<>();
    bubbleSort.sort(list);
    bubbleSort.report();

    list.clear();
    list.addAll(listCopy);
    Sorter<Integer> heapSort = new HeapSort<>();
    heapSort.sort(list);

    if (SortUtil.isOrdered(list)) {
      System.out.println("Sorted!");
    }

    for (int k = 0; k < list.size(); k++) {
      System.out.print(k);
      System.out.print(": ");
      System.out.println(list.get(k));
    }

    heapSort.report();
  }
}
