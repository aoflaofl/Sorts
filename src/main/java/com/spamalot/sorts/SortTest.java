package com.spamalot.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
   * The maximum random number to generate if nothing is specified on the
   * command line.
   */
  private static final int DEFAULT_MAX_VAL = 100;

  /**
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

    list = makeListOfRndInts(count, maxval);
    if (!isOrdered(list)) {
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

    if (isOrdered(list)) {
      System.out.println("Sorted!");
    }

    for (int k = 0; k < list.size(); k++) {
      System.out.print(k);
      System.out.print(": ");
      System.out.println(list.get(k));
    }

    heapSort.report();
  }

  /**
   * Generate a list of Random Integers.
   * 
   * @param count
   *          Number of random Integers to generate.
   * @param maxval
   *          Maximum value of an integer.
   * @return List of Integers.
   */
  private static List<Integer> makeListOfRndInts(final int count, final int maxval) {

    Random rng = new java.util.Random();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < count; i++) {
      Integer vv = Integer.valueOf(rng.nextInt(maxval));
      list.add(vv);
      System.out.println(vv);
    }

    System.out.println("----");

    return list;
  }

  /**
   * Check if a list is ordered.
   * 
   * @param list
   *          A list to check.
   * @param <T>
   *          A type that implements the Comparable interface.
   * @return True if the list is ordered.
   */
  private static <T extends Comparable<T>> boolean isOrdered(final List<T> list) {

    if (list.size() == 0 || list.size() == 1) {
      return true;
    }

    T e1;
    T e2 = list.get(0);

    for (int i = 1; i < list.size(); i++) {
      e1 = e2;
      e2 = list.get(i);
      if (e1.compareTo(e2) > 0) {
        return false;
      }
    }
    return true;
  }
}
