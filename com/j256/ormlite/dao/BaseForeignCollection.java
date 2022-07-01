package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public abstract class BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
  private static final long serialVersionUID = -5158840898186237589L;
  
  protected final transient Dao<T, ID> dao;
  
  private final transient FieldType foreignFieldType;
  
  private final transient boolean orderAscending;
  
  private final transient String orderColumn;
  
  private final transient Object parent;
  
  private final transient Object parentId;
  
  private transient PreparedQuery<T> preparedQuery;
  
  protected BaseForeignCollection(Dao<T, ID> paramDao, Object paramObject1, Object paramObject2, FieldType paramFieldType, String paramString, boolean paramBoolean) {
    this.dao = paramDao;
    this.foreignFieldType = paramFieldType;
    this.parentId = paramObject2;
    this.orderColumn = paramString;
    this.orderAscending = paramBoolean;
    this.parent = paramObject1;
  }
  
  private boolean addElement(T paramT) throws SQLException {
    if (this.dao == null)
      return false; 
    if (this.parent != null && this.foreignFieldType.getFieldValueIfNotDefault(paramT) == null)
      this.foreignFieldType.assignField(paramT, this.parent, true, null); 
    this.dao.create(paramT);
    return true;
  }
  
  public boolean add(T paramT) {
    try {
      return addElement(paramT);
    } catch (SQLException sQLException) {
      throw new IllegalStateException("Could not create data element in dao", sQLException);
    } 
  }
  
  public boolean addAll(Collection<? extends T> paramCollection) {
    Iterator<? extends T> iterator = paramCollection.iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      T t = iterator.next();
      try {
        boolean bool1 = addElement(t);
        if (bool1)
          bool = true; 
      } catch (SQLException sQLException) {
        throw new IllegalStateException("Could not create data elements in dao", sQLException);
      } 
    } 
    return bool;
  }
  
  public void clear() {
    if (this.dao == null)
      return; 
    CloseableIterator<T> closeableIterator = closeableIterator();
    try {
      while (closeableIterator.hasNext()) {
        closeableIterator.next();
        closeableIterator.remove();
      } 
    } finally {
      try {
        closeableIterator.close();
      } catch (SQLException sQLException) {}
    } 
  }
  
  protected PreparedQuery<T> getPreparedQuery() throws SQLException {
    if (this.dao == null)
      return null; 
    if (this.preparedQuery == null) {
      SelectArg selectArg = new SelectArg();
      selectArg.setValue(this.parentId);
      QueryBuilder<T, ID> queryBuilder = this.dao.queryBuilder();
      String str = this.orderColumn;
      if (str != null)
        queryBuilder.orderBy(str, this.orderAscending); 
      this.preparedQuery = queryBuilder.where().eq(this.foreignFieldType.getColumnName(), selectArg).prepare();
      PreparedQuery<T> preparedQuery = this.preparedQuery;
      if (preparedQuery instanceof MappedPreparedStmt)
        ((MappedPreparedStmt)preparedQuery).setParentInformation(this.parent, this.parentId); 
    } 
    return this.preparedQuery;
  }
  
  public int refresh(T paramT) throws SQLException {
    Dao<T, ID> dao = this.dao;
    return (dao == null) ? 0 : dao.refresh(paramT);
  }
  
  public abstract boolean remove(Object paramObject);
  
  public abstract boolean removeAll(Collection<?> paramCollection);
  
  public boolean retainAll(Collection<?> paramCollection) {
    Dao<T, ID> dao = this.dao;
    boolean bool = false;
    if (dao == null)
      return false; 
    CloseableIterator<T> closeableIterator = closeableIterator();
    try {
      while (closeableIterator.hasNext()) {
        if (!paramCollection.contains(closeableIterator.next())) {
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
  
  public int update(T paramT) throws SQLException {
    Dao<T, ID> dao = this.dao;
    return (dao == null) ? 0 : dao.update(paramT);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\BaseForeignCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */