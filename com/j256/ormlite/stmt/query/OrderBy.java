package com.j256.ormlite.stmt.query;

public class OrderBy {
  private final boolean ascending;
  
  private final String columnName;
  
  public OrderBy(String paramString, boolean paramBoolean) {
    this.columnName = paramString;
    this.ascending = paramBoolean;
  }
  
  public String getColumnName() {
    return this.columnName;
  }
  
  public boolean isAscending() {
    return this.ascending;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\OrderBy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */