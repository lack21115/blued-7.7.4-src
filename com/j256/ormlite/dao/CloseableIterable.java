package com.j256.ormlite.dao;

public interface CloseableIterable<T> extends Iterable<T> {
  CloseableIterator<T> closeableIterator();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\CloseableIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */