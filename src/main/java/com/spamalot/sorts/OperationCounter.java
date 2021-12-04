package com.spamalot.sorts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class to count operations.
 * 
 * @author gej
 * 
 */
class OperationCounter {
  /** Logger for this class */
  private static final Logger logger = LoggerFactory.getLogger(OperationCounter.class);

  /**
   * Keep track of the counts.
   */
  private final int[] counts = new int[SortOperation.values().length];

  /**
   * Count an operation.
   * 
   * @param op
   *          The operation to count.
   */
  public void count(final SortOperation op) {
    this.counts[op.ordinal()]++;
    this.counts[SortOperation.TOTAL.ordinal()]++;
  }

  /**
   * Get the count for an operation.
   * 
   * @param op
   *          The operation.
   * @return The count.
   */
  private int getCount(final SortOperation op) {
    return this.counts[op.ordinal()];
  }

  /**
   * Print a report.
   */
  @SuppressWarnings("boxing")
  public void report() {
    for (SortOperation op : SortOperation.values()) {
      logger.info("{}: {}", op, getCount(op));
    }
  }
}
