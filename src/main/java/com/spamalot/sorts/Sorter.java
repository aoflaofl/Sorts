package com.spamalot.sorts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Abstract class that Sorting classes must extend.
 * 
 * @author gej
 * 
 * @param <T>
 *          Type being sorted.
 */
abstract class Sorter<T extends Comparable<T>> {
  /** Logger for this class */
  private static final Logger logger = LoggerFactory.getLogger(Sorter.class);

  /**
   * Object to keep track of sort metrics.
   */
  private final OperationCounter opCounter = new OperationCounter();

  /**
   * Base Constructor.
   * 
   * @param name
   *          Name of this sort algorithm.
   */
  Sorter(final String name) {
    this.sortName = name;
  }

  /**
   * The name of the sort.
   */
  private final String sortName;

  /**
   * The order to sort in.
   */
  private SortOrder order = SortOrder.ASCENDING;

  /**
   * Get name of this Sort.
   * 
   * @return The name of this sort.
   */
  final String getName() {
    return this.sortName;
  }

  /**
   * Get the order to sort in.
   * 
   * @return the order to do the sort in.
   */
  private SortOrder getOrder() {
    return this.order;
  }

  /**
   * Move the element at index j to index i, replacing the value at index i.
   * 
   * @param list
   *          The list.
   * @param ii
   *          target index.
   * @param jj
   *          source index.
   */
  protected final void move(final List<T> list, final int ii, final int jj) {

    this.opCounter.count(SortOperation.MOVE);

    list.set(ii, list.get(jj));
  }

  /**
   * Report the statistics of this sort.
   */
  protected final void report() {
    logger.info("");
    logger.info("{}", getName());
    logger.info("{}", "----");
    this.opCounter.report();
  }

  /**
   * Set the order to sort the List in.
   * 
   * @param ord
   *          the order to do the sort in.
   */
  public final void setOrder(final SortOrder ord) {
    this.order = ord;
  }

  /**
   * Sort the List handed in. Sort should happen in place so nothing is
   * returned.
   * 
   * @param list
   *          The list to be sorted.
   */
  final void sort(final List<T> list) {
    sort(list, 0, list.size() - 1);
  }

  /**
   * Sort the elements in the List handed in between start and end. Sort
   * should happen in place so nothing is returned.
   * 
   * @param list
   *          The list to be sorted.
   * @param start
   *          The index of the element to start sorting at. The first element
   *          in the list is 0.
   * @param end
   *          The index of the element to stop sorting at.
   */
  public abstract void sort(List<T> list, int start, int end);

  /**
   * Compare the two arguments passed in. Takes into account the sort order.
   * 
   * @param list
   *          List of elements
   * @param ii
   *          Index of first element of compare.
   * @param jj
   *          Index of second element of compare.
   * @return output of compareTo();
   */
  protected final int sortOrderCompare(final List<T> list, final int ii, final int jj) {
    return sortOrderCompare(list.get(ii), list.get(jj));
  }

  /**
   * Compare the two arguments passed in.
   * 
   * <p>Counts the number of compares done which can be retrieved from a
   * function.
   * 
   * 
   * @param xx
   *          First element to compare.
   * @param yy
   *          Second element to compare.
   * @return output of compareTo();
   */
  protected final int sortOrderCompare(final T xx, final T yy) {

    this.opCounter.count(SortOperation.COMPARE);
    int result;

    if (getOrder() == SortOrder.ASCENDING) {
      result = xx.compareTo(yy);
    } else {
      result = yy.compareTo(xx);
    }
    return result;
  }

  /**
   * Swap two elements in the list.
   * 
   * @param ary
   *          The list.
   * @param ii
   *          first element.
   * @param jj
   *          second element.
   */
  protected final void swap(final List<T> ary, final int ii, final int jj) {

    this.opCounter.count(SortOperation.SWAP);
    T tmp = ary.get(ii);
    ary.set(ii, ary.get(jj));
    ary.set(jj, tmp);
  }

  /**
   * Compare and exchange two elements. The compare takes into account the
   * sort order.
   * 
   * @param ary
   *          The list.
   * @param ii
   *          index of first element.
   * @param jj
   *          index of second element.
   */
  protected final void compareExchange(final List<T> ary, final int ii, final int jj) {

    if (sortOrderCompare(ary, ii, jj) > 0) {
      swap(ary, ii, jj);
    }
  }

}
