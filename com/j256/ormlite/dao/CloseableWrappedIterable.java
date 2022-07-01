package com.j256.ormlite.dao;

import java.sql.SQLException;

public interface CloseableWrappedIterable<T> extends CloseableIterable<T> {
  void close() throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\CloseableWrappedIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */