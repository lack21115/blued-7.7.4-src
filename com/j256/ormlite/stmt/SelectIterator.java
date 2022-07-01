package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class SelectIterator<T, ID> implements CloseableIterator<T> {
  private static final Logger logger = LoggerFactory.getLogger(SelectIterator.class);
  
  private boolean alreadyMoved;
  
  private final Dao<T, ID> classDao;
  
  private boolean closed;
  
  private final CompiledStatement compiledStmt;
  
  private final DatabaseConnection connection;
  
  private final ConnectionSource connectionSource;
  
  private final Class<?> dataClass;
  
  private boolean first = true;
  
  private T last;
  
  private final DatabaseResults results;
  
  private int rowC;
  
  private final GenericRowMapper<T> rowMapper;
  
  private final String statement;
  
  public SelectIterator(Class<?> paramClass, Dao<T, ID> paramDao, GenericRowMapper<T> paramGenericRowMapper, ConnectionSource paramConnectionSource, DatabaseConnection paramDatabaseConnection, CompiledStatement paramCompiledStatement, String paramString, ObjectCache paramObjectCache) throws SQLException {
    this.dataClass = paramClass;
    this.classDao = paramDao;
    this.rowMapper = paramGenericRowMapper;
    this.connectionSource = paramConnectionSource;
    this.connection = paramDatabaseConnection;
    this.compiledStmt = paramCompiledStatement;
    this.results = paramCompiledStatement.runQuery(paramObjectCache);
    this.statement = paramString;
    if (paramString != null)
      logger.debug("starting iterator @{} for '{}'", Integer.valueOf(hashCode()), paramString); 
  }
  
  private T getCurrent() throws SQLException {
    this.last = this.rowMapper.mapRow(this.results);
    this.alreadyMoved = false;
    this.rowC++;
    return this.last;
  }
  
  public void close() throws SQLException {
    if (!this.closed) {
      this.compiledStmt.close();
      this.closed = true;
      this.last = null;
      if (this.statement != null)
        logger.debug("closed iterator @{} after {} rows", Integer.valueOf(hashCode()), Integer.valueOf(this.rowC)); 
      this.connectionSource.releaseConnection(this.connection);
    } 
  }
  
  public void closeQuietly() {
    try {
      close();
      return;
    } catch (SQLException sQLException) {
      return;
    } 
  }
  
  public T current() throws SQLException {
    return this.closed ? null : (this.first ? first() : getCurrent());
  }
  
  public T first() throws SQLException {
    if (this.closed)
      return null; 
    this.first = false;
    return this.results.first() ? getCurrent() : null;
  }
  
  public DatabaseResults getRawResults() {
    return this.results;
  }
  
  public boolean hasNext() {
    try {
      return hasNextThrow();
    } catch (SQLException sQLException) {
      this.last = null;
      closeQuietly();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Errors getting more results of ");
      stringBuilder.append(this.dataClass);
      throw new IllegalStateException(stringBuilder.toString(), sQLException);
    } 
  }
  
  public boolean hasNextThrow() throws SQLException {
    boolean bool;
    if (this.closed)
      return false; 
    if (this.alreadyMoved)
      return true; 
    if (this.first) {
      this.first = false;
      bool = this.results.first();
    } else {
      bool = this.results.next();
    } 
    if (!bool)
      close(); 
    this.alreadyMoved = true;
    return bool;
  }
  
  public T moveRelative(int paramInt) throws SQLException {
    if (this.closed)
      return null; 
    this.first = false;
    return this.results.moveRelative(paramInt) ? getCurrent() : null;
  }
  
  public void moveToNext() {
    this.last = null;
    this.first = false;
    this.alreadyMoved = false;
  }
  
  public T next() {
    try {
      T t = nextThrow();
      if (t != null)
        return t; 
      t = null;
    } catch (SQLException sQLException) {}
    this.last = null;
    closeQuietly();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not get next result for ");
    stringBuilder.append(this.dataClass);
    throw new IllegalStateException(stringBuilder.toString(), sQLException);
  }
  
  public T nextThrow() throws SQLException {
    if (this.closed)
      return null; 
    if (!this.alreadyMoved) {
      boolean bool;
      if (this.first) {
        this.first = false;
        bool = this.results.first();
      } else {
        bool = this.results.next();
      } 
      if (!bool) {
        this.first = false;
        return null;
      } 
    } 
    this.first = false;
    return getCurrent();
  }
  
  public T previous() throws SQLException {
    if (this.closed)
      return null; 
    this.first = false;
    return this.results.previous() ? getCurrent() : null;
  }
  
  public void remove() {
    try {
      removeThrow();
      return;
    } catch (SQLException sQLException) {
      closeQuietly();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not delete ");
      stringBuilder.append(this.dataClass);
      stringBuilder.append(" object ");
      stringBuilder.append(this.last);
      throw new IllegalStateException(stringBuilder.toString(), sQLException);
    } 
  }
  
  public void removeThrow() throws SQLException {
    T t = this.last;
    if (t != null) {
      Dao<T, ID> dao = this.classDao;
      if (dao != null)
        try {
          dao.delete(t);
          return;
        } finally {
          this.last = null;
        }  
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Cannot remove ");
      stringBuilder1.append(this.dataClass);
      stringBuilder1.append(" object because classDao not initialized");
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No last ");
    stringBuilder.append(this.dataClass);
    stringBuilder.append(" object to remove. Must be called after a call to next.");
    throw new IllegalStateException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\SelectIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */