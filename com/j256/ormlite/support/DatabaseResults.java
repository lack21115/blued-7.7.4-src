package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

public interface DatabaseResults {
  void close() throws SQLException;
  
  void closeQuietly();
  
  int findColumn(String paramString) throws SQLException;
  
  boolean first() throws SQLException;
  
  BigDecimal getBigDecimal(int paramInt) throws SQLException;
  
  InputStream getBlobStream(int paramInt) throws SQLException;
  
  boolean getBoolean(int paramInt) throws SQLException;
  
  byte getByte(int paramInt) throws SQLException;
  
  byte[] getBytes(int paramInt) throws SQLException;
  
  char getChar(int paramInt) throws SQLException;
  
  int getColumnCount() throws SQLException;
  
  String[] getColumnNames() throws SQLException;
  
  double getDouble(int paramInt) throws SQLException;
  
  float getFloat(int paramInt) throws SQLException;
  
  int getInt(int paramInt) throws SQLException;
  
  long getLong(int paramInt) throws SQLException;
  
  ObjectCache getObjectCache();
  
  short getShort(int paramInt) throws SQLException;
  
  String getString(int paramInt) throws SQLException;
  
  Timestamp getTimestamp(int paramInt) throws SQLException;
  
  boolean last() throws SQLException;
  
  boolean moveAbsolute(int paramInt) throws SQLException;
  
  boolean moveRelative(int paramInt) throws SQLException;
  
  boolean next() throws SQLException;
  
  boolean previous() throws SQLException;
  
  boolean wasNull(int paramInt) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\support\DatabaseResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */