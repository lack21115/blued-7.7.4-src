package com.j256.ormlite.android;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseConnectionProxyFactory;
import java.sql.SQLException;

public class AndroidConnectionSource extends BaseConnectionSource implements ConnectionSource {
  private static DatabaseConnectionProxyFactory connectionProxyFactory;
  
  private static final Logger logger = LoggerFactory.getLogger(AndroidConnectionSource.class);
  
  private boolean cancelQueriesEnabled = false;
  
  private DatabaseConnection connection = null;
  
  private final DatabaseType databaseType = (DatabaseType)new SqliteAndroidDatabaseType();
  
  private final SQLiteOpenHelper helper = null;
  
  private volatile boolean isOpen = true;
  
  private final SQLiteDatabase sqliteDatabase;
  
  public AndroidConnectionSource(SQLiteDatabase paramSQLiteDatabase) {
    this.sqliteDatabase = paramSQLiteDatabase;
  }
  
  public AndroidConnectionSource(SQLiteOpenHelper paramSQLiteOpenHelper) {
    this.sqliteDatabase = null;
  }
  
  public static void setDatabaseConnectionProxyFactory(DatabaseConnectionProxyFactory paramDatabaseConnectionProxyFactory) {
    connectionProxyFactory = paramDatabaseConnectionProxyFactory;
  }
  
  public void clearSpecialConnection(DatabaseConnection paramDatabaseConnection) {
    clearSpecial(paramDatabaseConnection, logger);
  }
  
  public void close() {
    this.isOpen = false;
  }
  
  public void closeQuietly() {
    close();
  }
  
  public DatabaseType getDatabaseType() {
    return this.databaseType;
  }
  
  public DatabaseConnection getReadOnlyConnection() throws SQLException {
    return getReadWriteConnection();
  }
  
  public DatabaseConnection getReadWriteConnection() throws SQLException {
    DatabaseConnection databaseConnection = getSavedConnection();
    if (databaseConnection != null)
      return databaseConnection; 
    databaseConnection = this.connection;
    if (databaseConnection == null) {
      SQLiteDatabase sQLiteDatabase2 = this.sqliteDatabase;
      SQLiteDatabase sQLiteDatabase1 = sQLiteDatabase2;
      if (sQLiteDatabase2 == null)
        try {
          sQLiteDatabase1 = this.helper.getWritableDatabase();
        } catch (SQLException sQLException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Getting a writable database from helper ");
          stringBuilder.append(this.helper);
          stringBuilder.append(" failed");
          throw SqlExceptionUtil.create(stringBuilder.toString(), sQLException);
        }  
      this.connection = new AndroidDatabaseConnection((SQLiteDatabase)sQLException, true, this.cancelQueriesEnabled);
      DatabaseConnectionProxyFactory databaseConnectionProxyFactory = connectionProxyFactory;
      if (databaseConnectionProxyFactory != null)
        this.connection = databaseConnectionProxyFactory.createProxy(this.connection); 
      logger.trace("created connection {} for db {}, helper {}", this.connection, sQLException, this.helper);
    } else {
      logger.trace("{}: returning read-write connection {}, helper {}", this, sQLException, this.helper);
    } 
    return this.connection;
  }
  
  public boolean isCancelQueriesEnabled() {
    return this.cancelQueriesEnabled;
  }
  
  public boolean isOpen() {
    return this.isOpen;
  }
  
  public void releaseConnection(DatabaseConnection paramDatabaseConnection) {}
  
  public boolean saveSpecialConnection(DatabaseConnection paramDatabaseConnection) throws SQLException {
    return saveSpecial(paramDatabaseConnection);
  }
  
  public void setCancelQueriesEnabled(boolean paramBoolean) {
    this.cancelQueriesEnabled = paramBoolean;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("@");
    stringBuilder.append(Integer.toHexString(hashCode()));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\AndroidConnectionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */