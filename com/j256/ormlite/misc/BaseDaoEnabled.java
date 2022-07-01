package com.j256.ormlite.misc;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;

public abstract class BaseDaoEnabled<T, ID> {
  protected transient Dao<T, ID> dao;
  
  private void checkForDao() throws SQLException {
    if (this.dao != null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Dao has not been set on ");
    stringBuilder.append(getClass());
    stringBuilder.append(" object: ");
    stringBuilder.append(this);
    throw new SQLException(stringBuilder.toString());
  }
  
  public int create() throws SQLException {
    checkForDao();
    return this.dao.create(this);
  }
  
  public int delete() throws SQLException {
    checkForDao();
    return this.dao.delete(this);
  }
  
  public ID extractId() throws SQLException {
    checkForDao();
    return (ID)this.dao.extractId(this);
  }
  
  public Dao<T, ID> getDao() {
    return this.dao;
  }
  
  public String objectToString() {
    try {
      checkForDao();
      return this.dao.objectToString(this);
    } catch (SQLException sQLException) {
      throw new IllegalArgumentException(sQLException);
    } 
  }
  
  public boolean objectsEqual(T paramT) throws SQLException {
    checkForDao();
    return this.dao.objectsEqual(this, paramT);
  }
  
  public int refresh() throws SQLException {
    checkForDao();
    return this.dao.refresh(this);
  }
  
  public void setDao(Dao<T, ID> paramDao) {
    this.dao = paramDao;
  }
  
  public int update() throws SQLException {
    checkForDao();
    return this.dao.update(this);
  }
  
  public int updateId(ID paramID) throws SQLException {
    checkForDao();
    return this.dao.updateId(this, paramID);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\misc\BaseDaoEnabled.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */