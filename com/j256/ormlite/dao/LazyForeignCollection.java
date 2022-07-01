package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
  private static final long serialVersionUID = -5460708106909626233L;
  
  private transient CloseableIterator<T> lastIterator;
  
  public LazyForeignCollection(Dao<T, ID> paramDao, Object paramObject1, Object paramObject2, FieldType paramFieldType, String paramString, boolean paramBoolean) {
    super(paramDao, paramObject1, paramObject2, paramFieldType, paramString, paramBoolean);
  }
  
  private CloseableIterator<T> seperateIteratorThrow(int paramInt) throws SQLException {
    if (this.dao != null)
      return this.dao.iterator(getPreparedQuery(), paramInt); 
    throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
  }
  
  public void closeLastIterator() throws SQLException {
    CloseableIterator<T> closeableIterator = this.lastIterator;
    if (closeableIterator != null) {
      closeableIterator.close();
      this.lastIterator = null;
    } 
  }
  
  public CloseableIterator<T> closeableIterator() {
    return closeableIterator(-1);
  }
  
  public CloseableIterator<T> closeableIterator(int paramInt) {
    try {
      return iteratorThrow(paramInt);
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not build lazy iterator for ");
      stringBuilder.append(this.dao.getDataClass());
      throw new IllegalStateException(stringBuilder.toString(), sQLException);
    } 
  }
  
  public boolean contains(Object paramObject) {
    CloseableIterator<T> closeableIterator = iterator();
    try {
      while (closeableIterator.hasNext()) {
        boolean bool = closeableIterator.next().equals(paramObject);
        if (bool)
          try {
            return true;
          } catch (SQLException sQLException) {
            return true;
          }  
      } 
    } finally {
      try {
        closeableIterator.close();
      } catch (SQLException sQLException) {}
    } 
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    null = new HashSet(paramCollection);
    CloseableIterator<T> closeableIterator = iterator();
    try {
      while (closeableIterator.hasNext())
        null.remove(closeableIterator.next()); 
      boolean bool = null.isEmpty();
    } finally {
      try {
        sQLException.close();
      } catch (SQLException sQLException1) {}
    } 
  }
  
  public boolean equals(Object paramObject) {
    return super.equals(paramObject);
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable() {
    return getWrappedIterable(-1);
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable(final int flags) {
    return new CloseableWrappedIterableImpl<T>(new CloseableIterable<T>() {
          public CloseableIterator<T> closeableIterator() {
            try {
              return LazyForeignCollection.this.seperateIteratorThrow(flags);
            } catch (Exception exception) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Could not build lazy iterator for ");
              stringBuilder.append(LazyForeignCollection.this.dao.getDataClass());
              throw new IllegalStateException(stringBuilder.toString(), exception);
            } 
          }
          
          public CloseableIterator<T> iterator() {
            return closeableIterator();
          }
        });
  }
  
  public int hashCode() {
    return super.hashCode();
  }
  
  public boolean isEager() {
    return false;
  }
  
  public boolean isEmpty() {
    CloseableIterator<T> closeableIterator = iterator();
    try {
      boolean bool = closeableIterator.hasNext();
      int i = bool ^ true;
    } finally {
      try {
        closeableIterator.close();
      } catch (SQLException sQLException) {}
    } 
  }
  
  public CloseableIterator<T> iterator() {
    return closeableIterator(-1);
  }
  
  public CloseableIterator<T> iterator(int paramInt) {
    return closeableIterator(paramInt);
  }
  
  public CloseableIterator<T> iteratorThrow() throws SQLException {
    return iteratorThrow(-1);
  }
  
  public CloseableIterator<T> iteratorThrow(int paramInt) throws SQLException {
    this.lastIterator = seperateIteratorThrow(paramInt);
    return this.lastIterator;
  }
  
  public int refreshAll() {
    throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
  }
  
  public int refreshCollection() {
    return 0;
  }
  
  public boolean remove(Object paramObject) {
    CloseableIterator<T> closeableIterator = iterator();
    try {
      while (closeableIterator.hasNext()) {
        if (closeableIterator.next().equals(paramObject)) {
          closeableIterator.remove();
          try {
            return true;
          } catch (SQLException sQLException) {
            return true;
          } 
        } 
      } 
    } finally {
      try {
        closeableIterator.close();
      } catch (SQLException sQLException) {}
    } 
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    CloseableIterator<T> closeableIterator = iterator();
    boolean bool = false;
    try {
      while (closeableIterator.hasNext()) {
        if (paramCollection.contains(closeableIterator.next())) {
          closeableIterator.remove();
          bool = true;
        } 
      } 
    } finally {
      try {
        closeableIterator.close();
      } catch (SQLException sQLException) {}
    } 
  }
  
  public int size() {
    CloseableIterator<T> closeableIterator = iterator();
    int i = 0;
    try {
      while (closeableIterator.hasNext()) {
        closeableIterator.moveToNext();
        i++;
      } 
    } finally {
      try {
        closeableIterator.close();
      } catch (SQLException sQLException) {}
    } 
  }
  
  public Object[] toArray() {
    null = new ArrayList();
    CloseableIterator<T> closeableIterator = iterator();
    try {
      while (closeableIterator.hasNext())
        null.add(closeableIterator.next()); 
      Object[] arrayOfObject = null.toArray();
    } finally {
      try {
        sQLException.close();
      } catch (SQLException sQLException1) {}
    } 
  }
  
  public <E> E[] toArray(E[] paramArrayOfE) {
    CloseableIterator<T> closeableIterator = iterator();
    ArrayList<E> arrayList = null;
    int i = 0;
    try {
      while (closeableIterator.hasNext()) {
        T t = closeableIterator.next();
        if (i >= paramArrayOfE.length) {
          ArrayList<E> arrayList1 = arrayList;
          if (arrayList == null) {
            arrayList = new ArrayList();
            int k = paramArrayOfE.length;
            int j = 0;
            while (true) {
              arrayList1 = arrayList;
              if (j < k) {
                arrayList.add(paramArrayOfE[j]);
                j++;
                continue;
              } 
              break;
            } 
          } 
          arrayList1.add((E)t);
          arrayList = arrayList1;
        } else {
          paramArrayOfE[i] = (E)t;
        } 
        i++;
      } 
      try {
        closeableIterator.close();
      } catch (SQLException sQLException) {}
      return arrayList.toArray(paramArrayOfE);
    } finally {
      try {
        closeableIterator.close();
      } catch (SQLException sQLException) {}
    } 
  }
  
  public int updateAll() {
    throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\LazyForeignCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */