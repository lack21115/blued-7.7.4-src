package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

public abstract class OrmLiteSqliteOpenHelper extends SQLiteOpenHelper {
  protected static Logger logger = LoggerFactory.getLogger(OrmLiteSqliteOpenHelper.class);
  
  protected boolean cancelQueriesEnabled;
  
  public AndroidConnectionSource connectionSource = new AndroidConnectionSource(this);
  
  private volatile boolean isOpen = true;
  
  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt) {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    logger.trace("{}: constructed connectionSource {}", this, this.connectionSource);
  }
  
  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt1, int paramInt2) {
    this(paramContext, paramString, paramCursorFactory, paramInt1, openFileId(paramContext, paramInt2));
  }
  
  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, File paramFile) {
    this(paramContext, paramString, paramCursorFactory, paramInt, openFile(paramFile));
  }
  
  public OrmLiteSqliteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, InputStream paramInputStream) {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    if (paramInputStream == null)
      return; 
    try {
      DaoManager.addCachedDatabaseConfigs(DatabaseTableConfigLoader.loadDatabaseConfigFromReader(new BufferedReader(new InputStreamReader(paramInputStream), 4096)));
      try {
        paramInputStream.close();
        return;
      } catch (IOException iOException) {}
    } catch (SQLException sQLException) {
      throw new IllegalStateException("Could not load object config file", sQLException);
    } finally {}
  }
  
  private static InputStream openFile(File paramFile) {
    if (paramFile == null)
      return null; 
    try {
      return new FileInputStream(paramFile);
    } catch (FileNotFoundException fileNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not open config file ");
      stringBuilder.append(paramFile);
      throw new IllegalArgumentException(stringBuilder.toString(), fileNotFoundException);
    } 
  }
  
  private static InputStream openFileId(Context paramContext, int paramInt) {
    InputStream inputStream = paramContext.getResources().openRawResource(paramInt);
    if (inputStream != null)
      return inputStream; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not find object config file with id ");
    stringBuilder.append(paramInt);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void close() {
    super.close();
    this.connectionSource.close();
    this.isOpen = false;
  }
  
  public ConnectionSource getConnectionSource() {
    if (!this.isOpen)
      logger.warn(new IllegalStateException(), "Getting connectionSource was called after closed"); 
    return (ConnectionSource)this.connectionSource;
  }
  
  public <D extends com.j256.ormlite.dao.Dao<T, ?>, T> D getDao(Class<T> paramClass) throws SQLException {
    return (D)DaoManager.createDao(getConnectionSource(), paramClass);
  }
  
  public <D extends RuntimeExceptionDao<T, ?>, T> D getRuntimeExceptionDao(Class<T> paramClass) {
    try {
      return (D)new RuntimeExceptionDao(getDao(paramClass));
    } catch (SQLException sQLException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not create RuntimeExcepitionDao for class ");
      stringBuilder.append(paramClass);
      throw new RuntimeException(stringBuilder.toString(), sQLException);
    } 
  }
  
  public boolean isOpen() {
    return this.isOpen;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    AndroidDatabaseConnection androidDatabaseConnection;
    ConnectionSource connectionSource = getConnectionSource();
    DatabaseConnection databaseConnection = connectionSource.getSpecialConnection();
    boolean bool = true;
    if (databaseConnection == null) {
      androidDatabaseConnection = new AndroidDatabaseConnection(paramSQLiteDatabase, true, this.cancelQueriesEnabled);
      try {
        connectionSource.saveSpecialConnection((DatabaseConnection)androidDatabaseConnection);
      } catch (SQLException null) {
        throw new IllegalStateException("Could not save special connection", null);
      } 
    } else {
      bool = false;
    } 
    try {
      onCreate((SQLiteDatabase)null, connectionSource);
      return;
    } finally {
      if (bool)
        connectionSource.clearSpecialConnection((DatabaseConnection)androidDatabaseConnection); 
    } 
  }
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource);
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    AndroidDatabaseConnection androidDatabaseConnection;
    ConnectionSource connectionSource = getConnectionSource();
    DatabaseConnection databaseConnection = connectionSource.getSpecialConnection();
    boolean bool = true;
    if (databaseConnection == null) {
      androidDatabaseConnection = new AndroidDatabaseConnection(paramSQLiteDatabase, true, this.cancelQueriesEnabled);
      try {
        connectionSource.saveSpecialConnection((DatabaseConnection)androidDatabaseConnection);
      } catch (SQLException null) {
        throw new IllegalStateException("Could not save special connection", null);
      } 
    } else {
      bool = false;
    } 
    try {
      onUpgrade((SQLiteDatabase)null, connectionSource, paramInt1, paramInt2);
      return;
    } finally {
      if (bool)
        connectionSource.clearSpecialConnection((DatabaseConnection)androidDatabaseConnection); 
    } 
  }
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource, int paramInt1, int paramInt2);
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("@");
    stringBuilder.append(Integer.toHexString(hashCode()));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\apptools\OrmLiteSqliteOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */