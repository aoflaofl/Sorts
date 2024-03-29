package com.spamalot.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility functions for Sorting.
 * 
 * @author gej
 *
 */
final class SortUtil {
  /** Logger for this class */
  private static final Logger LOGGER = LoggerFactory.getLogger(SortUtil.class);

  /**
   * Nothing to declare.
   */
  private SortUtil() {
  }

  /**
   * Check if a list is ordered.
   * 
   * @param list
   *          The list to check.
   * @param <T>
   *          A type that implements the Comparable interface.
   * @return true if the list is ordered, else false.
   */
  static <T extends Comparable<T>> boolean isOrdered(final List<T> list) {
    if (list.size() <= 1) {
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

  /**
   * Generate a list of Random Integers.
   * 
   * @param count
   *          Number of random Integers to generate.
   * @param maxval
   *          Maximum value of an integer.
   * @return List of Integers in random order.
   */
  static List<Integer> makeListOfRndInts(final int count, final int maxval) {
    LOGGER.debug("Making list of {} integers in range (0 to {}]", count, maxval);

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < count; i++) {
      Integer vv = Integer.valueOf(ThreadLocalRandom.current().nextInt(maxval));
      list.add(vv);
    }

    return list;
  }

}
