package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import java.sql.SQLException;
import java.sql.Savepoint;

public class DatabaseConnectionProxy implements DatabaseConnection {
  private final DatabaseConnection proxy;
  
  public DatabaseConnectionProxy(DatabaseConnection paramDatabaseConnection) {
    this.proxy = paramDatabaseConnection;
  }
  
  public void close() throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    if (databaseConnection != null)
      databaseConnection.close(); 
  }
  
  public void closeQuietly() {
    DatabaseConnection databaseConnection = this.proxy;
    if (databaseConnection != null)
      databaseConnection.closeQuietly(); 
  }
  
  public void commit(Savepoint paramSavepoint) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    if (databaseConnection != null)
      databaseConnection.commit(paramSavepoint); 
  }
  
  public CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType, int paramInt) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? null : databaseConnection.compileStatement(paramString, paramStatementType, paramArrayOfFieldType, paramInt);
  }
  
  public int delete(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? 0 : databaseConnection.delete(paramString, paramArrayOfObject, paramArrayOfFieldType);
  }
  
  public int executeStatement(String paramString, int paramInt) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? 0 : databaseConnection.executeStatement(paramString, paramInt);
  }
  
  public int insert(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GeneratedKeyHolder paramGeneratedKeyHolder) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? 0 : databaseConnection.insert(paramString, paramArrayOfObject, paramArrayOfFieldType, paramGeneratedKeyHolder);
  }
  
  public boolean isAutoCommit() throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? false : databaseConnection.isAutoCommit();
  }
  
  public boolean isAutoCommitSupported() throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? false : databaseConnection.isAutoCommitSupported();
  }
  
  public boolean isClosed() throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? true : databaseConnection.isClosed();
  }
  
  public boolean isTableExists(String paramString) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? false : databaseConnection.isTableExists(paramString);
  }
  
  public long queryForLong(String paramString) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? 0L : databaseConnection.queryForLong(paramString);
  }
  
  public long queryForLong(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? 0L : databaseConnection.queryForLong(paramString, paramArrayOfObject, paramArrayOfFieldType);
  }
  
  public <T> Object queryForOne(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? null : databaseConnection.queryForOne(paramString, paramArrayOfObject, paramArrayOfFieldType, paramGenericRowMapper, paramObjectCache);
  }
  
  public void rollback(Savepoint paramSavepoint) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    if (databaseConnection != null)
      databaseConnection.rollback(paramSavepoint); 
  }
  
  public void setAutoCommit(boolean paramBoolean) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    if (databaseConnection != null)
      databaseConnection.setAutoCommit(paramBoolean); 
  }
  
  public Savepoint setSavePoint(String paramString) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? null : databaseConnection.setSavePoint(paramString);
  }
  
  public int update(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException {
    DatabaseConnection databaseConnection = this.proxy;
    return (databaseConnection == null) ? 0 : databaseConnection.update(paramString, paramArrayOfObject, paramArrayOfFieldType);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\support\DatabaseConnectionProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */