package com.spamalot.sorts;

/**
 * The kinds of operations.
 * 
 */
enum SortOperation {
  /**
   * Comparing two elements.
   */
  COMPARE("Number of Compares"),
  /**
   * Swapping two elements.
   */
  SWAP("Number of Swaps"),
  /**
   * Moving an element from one place to another.
   */
  MOVE("Number of Moves"),
  /**
   * Total number of operations.
   */
  TOTAL("Total");

  /**
   * How this operation will be listed in the report.
   */
  private final String operationDescription;

  /**
   * Format to use when printing out the description.
   */
  private static String format;

  @Override
  public String toString() {
    String out = String.format(format, this.operationDescription);
    return out;
  }

  static {
    int longest = 0;
    for (SortOperation op : SortOperation.values()) {
      if (op.getDescription().length() > longest) {
        longest = op.getDescription().length();
      }
    }
    format = String.format("%%%ds", Integer.valueOf(longest));
  }

  /**
   * Construct SortOperation object.
   * 
   * @param description
   *          How this operation will be listed in the report.
   */
  SortOperation(final String description) {
    this.operationDescription = description;
  }

  /**
   * Get the description.
   * 
   * @return the description.
   */
  public String getDescription() {
    return this.operationDescription;
  }
}
