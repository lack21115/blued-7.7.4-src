package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.io.File;

public class DefaultDatabaseConnectionProvider implements DatabaseConnectionProvider {
  protected int determineOpenOptions(File paramFile) {
    String str = paramFile.getParent();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFile.getName());
    stringBuilder.append("-wal");
    return (new File(str, stringBuilder.toString())).exists() ? 1 : 0;
  }
  
  public SQLiteDatabase openDatabase(File paramFile) throws SQLiteException {
    return performOpen(paramFile, determineOpenOptions(paramFile));
  }
  
  protected SQLiteDatabase performOpen(File paramFile, int paramInt) {
    SQLiteDatabaseCompat sQLiteDatabaseCompat = SQLiteDatabaseCompat.getInstance();
    int i = sQLiteDatabaseCompat.provideOpenFlags(paramInt);
    SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase(paramFile.getAbsolutePath(), null, i | 0x0);
    sQLiteDatabaseCompat.enableFeatures(paramInt, sQLiteDatabase);
    return sQLiteDatabase;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\database\DefaultDatabaseConnectionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */