package com.spamalot.sorts;

/**
 * A class to count operations.
 * 
 * @author gej
 * 
 */
class OperationCounter {

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
  public void report() {
    for (SortOperation op : SortOperation.values()) {
      System.out.print(op.toString());
      System.out.print(": ");
      System.out.println(getCount(op));
    }
  }
}
