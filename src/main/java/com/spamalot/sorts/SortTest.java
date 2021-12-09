package com.spamalot.sorts;

import com.spamalot.sorts.algorithm.BubbleSort;
import com.spamalot.sorts.algorithm.HeapSort;
import com.spamalot.sorts.algorithm.InsertionSort;
import com.spamalot.sorts.algorithm.QuickSort;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Contains main() method to test Sorting Classes.
 * 
 * @author gej
 * 
 */
public final class SortTest {
  /** Logger for this class */
  private static final Logger LOGGER = LoggerFactory.getLogger(SortTest.class);

  /**
   * Do not instantiate.
   */
  private SortTest() {
  }

  /**
   * The number of elements if nothing is specified on the command line.
   */
  private static final int DEFAULT_COUNT = 100000;
  /**
   * The maximum random number to generate if nothing is specified on the
   * command line.
   */
  private static final int DEFAULT_MAX_VAL = 10000000;

  /**
   * Start here.
   * 
   * @param args
   *          Arguments to the program.
   */
  public static void main(final String[] args) {

    List<AbstractSorter<Integer>> sorts = new ArrayList<>();
    sorts.add(new BubbleSort<>());
    sorts.add(new InsertionSort<>());
    sorts.add(new HeapSort<>());
    sorts.add(new QuickSort<>());

    int count = DEFAULT_COUNT;
    if (args.length > 0 && args[0] != null) {
      count = Integer.parseInt(args[0]);
    }
    int maxval = DEFAULT_MAX_VAL;
    if (args.length > 1 && args[1] != null) {
      maxval = Integer.parseInt(args[1]);
    }

    List<Integer> list = SortUtil.makeListOfRndInts(count, maxval);

    if (!SortUtil.isOrdered(list)) {
      LOGGER.info("Not Sorted!");
    }

    for (AbstractSorter<Integer> s : sorts) {
      doASort(s, list);
    }
  }

  /**
   * Sort and report a List using an algorithm.
   * 
   * @param sortAlgorithm
   *          The Sorting algorithm to use
   * @param list
   *          List to be sorted
   */
  static void doASort(AbstractSorter<Integer> sortAlgorithm, List<Integer> list) {
    List<Integer> listCopy = new ArrayList<>();
    listCopy.addAll(list);

    LOGGER.info("");
    LOGGER.info("Starting {}", sortAlgorithm.getName());
    sortAlgorithm.sort(listCopy);
    LOGGER.info("Ending {}", sortAlgorithm.getName());
    sortAlgorithm.report();
  }
}
