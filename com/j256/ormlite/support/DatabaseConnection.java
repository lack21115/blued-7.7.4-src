package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import java.sql.SQLException;
import java.sql.Savepoint;

public interface DatabaseConnection {
  public static final int DEFAULT_RESULT_FLAGS = -1;
  
  public static final Object MORE_THAN_ONE = new Object();
  
  void close() throws SQLException;
  
  void closeQuietly();
  
  void commit(Savepoint paramSavepoint) throws SQLException;
  
  CompiledStatement compileStatement(String paramString, StatementBuilder.StatementType paramStatementType, FieldType[] paramArrayOfFieldType, int paramInt) throws SQLException;
  
  int delete(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException;
  
  int executeStatement(String paramString, int paramInt) throws SQLException;
  
  int insert(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GeneratedKeyHolder paramGeneratedKeyHolder) throws SQLException;
  
  boolean isAutoCommit() throws SQLException;
  
  boolean isAutoCommitSupported() throws SQLException;
  
  boolean isClosed() throws SQLException;
  
  boolean isTableExists(String paramString) throws SQLException;
  
  long queryForLong(String paramString) throws SQLException;
  
  long queryForLong(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException;
  
  <T> Object queryForOne(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType, GenericRowMapper<T> paramGenericRowMapper, ObjectCache paramObjectCache) throws SQLException;
  
  void rollback(Savepoint paramSavepoint) throws SQLException;
  
  void setAutoCommit(boolean paramBoolean) throws SQLException;
  
  Savepoint setSavePoint(String paramString) throws SQLException;
  
  int update(String paramString, Object[] paramArrayOfObject, FieldType[] paramArrayOfFieldType) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\support\DatabaseConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */