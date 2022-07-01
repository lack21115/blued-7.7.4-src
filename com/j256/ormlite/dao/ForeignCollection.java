package com.j256.ormlite.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface ForeignCollection<T> extends CloseableIterable<T>, Collection<T> {
  boolean add(T paramT);
  
  void closeLastIterator() throws SQLException;
  
  CloseableIterator<T> closeableIterator(int paramInt);
  
  CloseableWrappedIterable<T> getWrappedIterable();
  
  CloseableWrappedIterable<T> getWrappedIterable(int paramInt);
  
  boolean isEager();
  
  CloseableIterator<T> iterator(int paramInt);
  
  CloseableIterator<T> iteratorThrow() throws SQLException;
  
  CloseableIterator<T> iteratorThrow(int paramInt) throws SQLException;
  
  int refresh(T paramT) throws SQLException;
  
  int refreshAll() throws SQLException;
  
  int refreshCollection() throws SQLException;
  
  int update(T paramT) throws SQLException;
  
  int updateAll() throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\ForeignCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */