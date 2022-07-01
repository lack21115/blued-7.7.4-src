package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Iterator;

public class CloseableWrappedIterableImpl<T> implements CloseableWrappedIterable<T> {
  private final CloseableIterable<T> iterable;
  
  private CloseableIterator<T> iterator;
  
  public CloseableWrappedIterableImpl(CloseableIterable<T> paramCloseableIterable) {
    this.iterable = paramCloseableIterable;
  }
  
  public void close() throws SQLException {
    CloseableIterator<T> closeableIterator = this.iterator;
    if (closeableIterator != null) {
      closeableIterator.close();
      this.iterator = null;
    } 
  }
  
  public CloseableIterator<T> closeableIterator() {
    try {
      close();
    } catch (SQLException sQLException) {}
    this.iterator = this.iterable.closeableIterator();
    return this.iterator;
  }
  
  public CloseableIterator<T> iterator() {
    return closeableIterator();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\CloseableWrappedIterableImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */