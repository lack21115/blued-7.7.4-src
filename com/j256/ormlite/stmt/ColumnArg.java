package com.j256.ormlite.stmt;

public class ColumnArg {
  private final String columnName;
  
  private final String tableName = null;
  
  public ColumnArg(String paramString) {
    this.columnName = paramString;
  }
  
  public ColumnArg(String paramString1, String paramString2) {
    this.columnName = paramString2;
  }
  
  public String getColumnName() {
    return this.columnName;
  }
  
  public String getTableName() {
    return this.tableName;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\ColumnArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */