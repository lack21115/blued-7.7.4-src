package com.facebook.stetho.inspector.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SqliteDatabaseDriver extends DatabaseDriver2<SqliteDatabaseDriver.SqliteDatabaseDescriptor> {
  private static final String[] UNINTERESTING_FILENAME_SUFFIXES = new String[] { "-journal", "-shm", "-uid", "-wal" };
  
  private final DatabaseConnectionProvider mDatabaseConnectionProvider;
  
  private final DatabaseFilesProvider mDatabaseFilesProvider;
  
  @Deprecated
  public SqliteDatabaseDriver(Context paramContext) {
    this(paramContext, new DefaultDatabaseFilesProvider(paramContext), new DefaultDatabaseConnectionProvider());
  }
  
  @Deprecated
  public SqliteDatabaseDriver(Context paramContext, DatabaseFilesProvider paramDatabaseFilesProvider) {
    this(paramContext, paramDatabaseFilesProvider, new DefaultDatabaseConnectionProvider());
  }
  
  public SqliteDatabaseDriver(Context paramContext, DatabaseFilesProvider paramDatabaseFilesProvider, DatabaseConnectionProvider paramDatabaseConnectionProvider) {
    super(paramContext);
    this.mDatabaseFilesProvider = paramDatabaseFilesProvider;
    this.mDatabaseConnectionProvider = paramDatabaseConnectionProvider;
  }
  
  private <T> T executeInsert(SQLiteDatabase paramSQLiteDatabase, String paramString, BaseDatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler) {
    return (T)paramExecuteResultHandler.handleInsert(paramSQLiteDatabase.compileStatement(paramString).executeInsert());
  }
  
  private <T> T executeRawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, BaseDatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler) {
    paramSQLiteDatabase.execSQL(paramString);
    return (T)paramExecuteResultHandler.handleRawQuery();
  }
  
  private <T> T executeSelect(SQLiteDatabase paramSQLiteDatabase, String paramString, BaseDatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler) {
    Cursor cursor = paramSQLiteDatabase.rawQuery(paramString, null);
    try {
      return (T)paramExecuteResultHandler.handleSelect(cursor);
    } finally {
      cursor.close();
    } 
  }
  
  private <T> T executeUpdateDelete(SQLiteDatabase paramSQLiteDatabase, String paramString, BaseDatabaseDriver.ExecuteResultHandler<T> paramExecuteResultHandler) {
    return (T)paramExecuteResultHandler.handleUpdateDelete(paramSQLiteDatabase.compileStatement(paramString).executeUpdateDelete());
  }
  
  private static String getFirstWord(String paramString) {
    String str = paramString.trim();
    int i = str.indexOf(' ');
    paramString = str;
    if (i >= 0)
      paramString = str.substring(0, i); 
    return paramString;
  }
  
  private SQLiteDatabase openDatabase(SqliteDatabaseDescriptor paramSqliteDatabaseDescriptor) throws SQLiteException {
    Util.throwIfNull(paramSqliteDatabaseDescriptor);
    return this.mDatabaseConnectionProvider.openDatabase(paramSqliteDatabaseDescriptor.file);
  }
  
  private static String removeSuffix(String paramString, String[] paramArrayOfString) {
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str = paramArrayOfString[i];
      if (paramString.endsWith(str))
        return paramString.substring(0, paramString.length() - str.length()); 
    } 
    return paramString;
  }
  
  static List<File> tidyDatabaseList(List<File> paramList) {
    HashSet<File> hashSet = new HashSet<File>(paramList);
    ArrayList<File> arrayList = new ArrayList();
    for (File file : paramList) {
      String str1 = file.getPath();
      String str2 = removeSuffix(str1, UNINTERESTING_FILENAME_SUFFIXES);
      if (str2.equals(str1) || !hashSet.contains(new File(str2)))
        arrayList.add(file); 
    } 
    return arrayList;
  }
  
  public Database.ExecuteSQLResponse executeSQL(SqliteDatabaseDescriptor paramSqliteDatabaseDescriptor, String paramString, BaseDatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse> paramExecuteResultHandler) throws SQLiteException {
    Util.throwIfNull(paramString);
    Util.throwIfNull(paramExecuteResultHandler);
    SQLiteDatabase sQLiteDatabase = openDatabase(paramSqliteDatabaseDescriptor);
    try {
      String str = getFirstWord(paramString).toUpperCase();
      byte b = -1;
      switch (str.hashCode()) {
        case 2012838315:
          if (str.equals("DELETE"))
            b = 1; 
          break;
        case -591179561:
          if (str.equals("EXPLAIN"))
            b = 5; 
          break;
        case -1785516855:
          if (str.equals("UPDATE"))
            b = 0; 
          break;
        case -1852692228:
          if (str.equals("SELECT"))
            b = 3; 
          break;
        case -1926899396:
          if (str.equals("PRAGMA"))
            b = 4; 
          break;
        case -2130463047:
          if (str.equals("INSERT"))
            b = 2; 
          break;
      } 
      if (b != 0 && b != 1) {
        if (b != 2) {
          if (b != 3 && b != 4 && b != 5) {
            executeSQLResponse = executeRawQuery(sQLiteDatabase, paramString, paramExecuteResultHandler);
            return executeSQLResponse;
          } 
          executeSQLResponse = executeSelect(sQLiteDatabase, (String)executeSQLResponse, paramExecuteResultHandler);
          return executeSQLResponse;
        } 
        executeSQLResponse = executeInsert(sQLiteDatabase, (String)executeSQLResponse, paramExecuteResultHandler);
        return executeSQLResponse;
      } 
      Database.ExecuteSQLResponse executeSQLResponse = executeUpdateDelete(sQLiteDatabase, (String)executeSQLResponse, paramExecuteResultHandler);
      return executeSQLResponse;
    } finally {
      sQLiteDatabase.close();
    } 
  }
  
  public List<SqliteDatabaseDescriptor> getDatabaseNames() {
    ArrayList<SqliteDatabaseDescriptor> arrayList = new ArrayList();
    List<File> list = this.mDatabaseFilesProvider.getDatabaseFiles();
    Collections.sort(list);
    Iterator<File> iterator = tidyDatabaseList(list).iterator();
    while (iterator.hasNext())
      arrayList.add(new SqliteDatabaseDescriptor(iterator.next())); 
    return arrayList;
  }
  
  public List<String> getTableNames(SqliteDatabaseDescriptor paramSqliteDatabaseDescriptor) throws SQLiteException {
    SQLiteDatabase sQLiteDatabase = openDatabase(paramSqliteDatabaseDescriptor);
    try {
      Cursor cursor = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type IN (?, ?)", new String[] { "table", "view" });
    } finally {
      sQLiteDatabase.close();
    } 
  }
  
  static class SqliteDatabaseDescriptor implements DatabaseDescriptor {
    public final File file;
    
    public SqliteDatabaseDescriptor(File param1File) {
      this.file = param1File;
    }
    
    public String name() {
      return this.file.getName();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\database\SqliteDatabaseDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */