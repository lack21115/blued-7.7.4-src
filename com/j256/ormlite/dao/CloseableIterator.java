package com.j256.ormlite.dao;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Iterator;

public interface CloseableIterator<T> extends Iterator<T> {
  void close() throws SQLException;
  
  void closeQuietly();
  
  T current() throws SQLException;
  
  T first() throws SQLException;
  
  DatabaseResults getRawResults();
  
  T moveRelative(int paramInt) throws SQLException;
  
  void moveToNext();
  
  T nextThrow() throws SQLException;
  
  T previous() throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\CloseableIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */