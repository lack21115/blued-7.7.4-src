package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.io.File;

public interface DatabaseConnectionProvider {
  SQLiteDatabase openDatabase(File paramFile) throws SQLiteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\database\DatabaseConnectionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */