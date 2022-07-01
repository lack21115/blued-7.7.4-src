package com.j256.ormlite.support;

import com.j256.ormlite.db.DatabaseType;
import java.sql.SQLException;

public interface ConnectionSource {
  void clearSpecialConnection(DatabaseConnection paramDatabaseConnection);
  
  void close() throws SQLException;
  
  void closeQuietly();
  
  DatabaseType getDatabaseType();
  
  DatabaseConnection getReadOnlyConnection() throws SQLException;
  
  DatabaseConnection getReadWriteConnection() throws SQLException;
  
  DatabaseConnection getSpecialConnection();
  
  boolean isOpen();
  
  void releaseConnection(DatabaseConnection paramDatabaseConnection) throws SQLException;
  
  boolean saveSpecialConnection(DatabaseConnection paramDatabaseConnection) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\support\ConnectionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */