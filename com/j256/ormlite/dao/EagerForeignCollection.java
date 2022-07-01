package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EagerForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements CloseableWrappedIterable<T>, ForeignCollection<T>, Serializable {
  private static final long serialVersionUID = -2523335606983317721L;
  
  private List<T> results;
  
  public EagerForeignCollection(Dao<T, ID> paramDao, Object paramObject1, Object paramObject2, FieldType paramFieldType, String paramString, boolean paramBoolean) throws SQLException {
    super(paramDao, paramObject1, paramObject2, paramFieldType, paramString, paramBoolean);
    if (paramObject2 == null) {
      this.results = new ArrayList<T>();
      return;
    } 
    this.results = paramDao.query(getPreparedQuery());
  }
  
  public boolean add(T paramT) {
    return this.results.add(paramT) ? super.add(paramT) : false;
  }
  
  public boolean addAll(Collection<? extends T> paramCollection) {
    return this.results.addAll(paramCollection) ? super.addAll(paramCollection) : false;
  }
  
  public void close() {}
  
  public void closeLastIterator() {}
  
  public CloseableIterator<T> closeableIterator() {
    return iteratorThrow(-1);
  }
  
  public CloseableIterator<T> closeableIterator(int paramInt) {
    return iteratorThrow(-1);
  }
  
  public boolean contains(Object paramObject) {
    return this.results.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    return this.results.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof EagerForeignCollection))
      return false; 
    paramObject = paramObject;
    return this.results.equals(((EagerForeignCollection)paramObject).results);
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable() {
    return this;
  }
  
  public CloseableWrappedIterable<T> getWrappedIterable(int paramInt) {
    return this;
  }
  
  public int hashCode() {
    return this.results.hashCode();
  }
  
  public boolean isEager() {
    return true;
  }
  
  public boolean isEmpty() {
    return this.results.isEmpty();
  }
  
  public CloseableIterator<T> iterator() {
    return iteratorThrow(-1);
  }
  
  public CloseableIterator<T> iterator(int paramInt) {
    return iteratorThrow(paramInt);
  }
  
  public CloseableIterator<T> iteratorThrow() {
    return iteratorThrow(-1);
  }
  
  public CloseableIterator<T> iteratorThrow(int paramInt) {
    return new CloseableIterator<T>() {
        private int offset = -1;
        
        public void close() {}
        
        public void closeQuietly() {}
        
        public T current() {
          if (this.offset < 0)
            this.offset = 0; 
          return (this.offset >= EagerForeignCollection.this.results.size()) ? null : (T)EagerForeignCollection.this.results.get(this.offset);
        }
        
        public T first() {
          this.offset = 0;
          return (this.offset >= EagerForeignCollection.this.results.size()) ? null : (T)EagerForeignCollection.this.results.get(0);
        }
        
        public DatabaseResults getRawResults() {
          return null;
        }
        
        public boolean hasNext() {
          return (this.offset + 1 < EagerForeignCollection.this.results.size());
        }
        
        public T moveRelative(int param1Int) {
          this.offset += param1Int;
          param1Int = this.offset;
          return (param1Int < 0 || param1Int >= EagerForeignCollection.this.results.size()) ? null : (T)EagerForeignCollection.this.results.get(this.offset);
        }
        
        public void moveToNext() {
          this.offset++;
        }
        
        public T next() {
          this.offset++;
          return (T)EagerForeignCollection.this.results.get(this.offset);
        }
        
        public T nextThrow() {
          this.offset++;
          return (this.offset >= EagerForeignCollection.this.results.size()) ? null : (T)EagerForeignCollection.this.results.get(this.offset);
        }
        
        public T previous() {
          int i = --this.offset;
          return (i < 0 || i >= EagerForeignCollection.this.results.size()) ? null : (T)EagerForeignCollection.this.results.get(this.offset);
        }
        
        public void remove() {
          int i = this.offset;
          if (i >= 0) {
            if (i < EagerForeignCollection.this.results.size()) {
              Object object = EagerForeignCollection.this.results.remove(this.offset);
              this.offset--;
              if (EagerForeignCollection.this.dao != null)
                try {
                  EagerForeignCollection.this.dao.delete(object);
                  return;
                } catch (SQLException sQLException) {
                  throw new RuntimeException(sQLException);
                }  
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("current results position (");
            stringBuilder.append(this.offset);
            stringBuilder.append(") is out of bounds");
            throw new IllegalStateException(stringBuilder.toString());
          } 
          throw new IllegalStateException("next() must be called before remove()");
        }
      };
  }
  
  public int refreshAll() throws SQLException {
    Iterator<T> iterator = this.results.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += this.dao.refresh(t))
      T t = iterator.next(); 
    return i;
  }
  
  public int refreshCollection() throws SQLException {
    this.results = this.dao.query(getPreparedQuery());
    return this.results.size();
  }
  
  public boolean remove(Object paramObject) {
    if (this.results.remove(paramObject)) {
      if (this.dao == null)
        return false; 
      try {
        int i = this.dao.delete((T)paramObject);
        return (i == 1);
      } catch (SQLException sQLException) {
        throw new IllegalStateException("Could not delete data element from dao", sQLException);
      } 
    } 
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    Iterator<?> iterator = paramCollection.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      if (remove(iterator.next()))
        bool = true; 
    } 
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    return super.retainAll(paramCollection);
  }
  
  public int size() {
    return this.results.size();
  }
  
  public Object[] toArray() {
    return this.results.toArray();
  }
  
  public <E> E[] toArray(E[] paramArrayOfE) {
    return this.results.toArray(paramArrayOfE);
  }
  
  public int updateAll() throws SQLException {
    Iterator<T> iterator = this.results.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += this.dao.update(t))
      T t = iterator.next(); 
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\EagerForeignCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */