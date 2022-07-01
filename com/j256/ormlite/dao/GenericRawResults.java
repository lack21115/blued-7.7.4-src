package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericRawResults<T> extends CloseableWrappedIterable<T> {
  void close() throws SQLException;
  
  String[] getColumnNames();
  
  T getFirstResult() throws SQLException;
  
  int getNumberColumns();
  
  List<T> getResults() throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\GenericRawResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */