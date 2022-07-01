package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public interface CompiledStatement {
  void cancel() throws SQLException;
  
  void close() throws SQLException;
  
  void closeQuietly();
  
  int getColumnCount() throws SQLException;
  
  String getColumnName(int paramInt) throws SQLException;
  
  int runExecute() throws SQLException;
  
  DatabaseResults runQuery(ObjectCache paramObjectCache) throws SQLException;
  
  int runUpdate() throws SQLException;
  
  void setMaxRows(int paramInt) throws SQLException;
  
  void setObject(int paramInt, Object paramObject, SqlType paramSqlType) throws SQLException;
  
  void setQueryTimeout(long paramLong) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\support\CompiledStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */