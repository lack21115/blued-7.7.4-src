package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

public abstract class SQLiteDatabaseCompat {
  public static final int ENABLE_FOREIGN_KEY_CONSTRAINTS = 2;
  
  public static final int ENABLE_WRITE_AHEAD_LOGGING = 1;
  
  private static final SQLiteDatabaseCompat sInstance = new NoopImpl();
  
  public static SQLiteDatabaseCompat getInstance() {
    return sInstance;
  }
  
  public abstract void enableFeatures(int paramInt, SQLiteDatabase paramSQLiteDatabase);
  
  public abstract int provideOpenFlags(int paramInt);
  
  static {
    if (Build.VERSION.SDK_INT >= 16) {
      sInstance = new JellyBeanAndBeyondImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 11) {
      sInstance = new HoneycombImpl();
      return;
    } 
  }
  
  static class HoneycombImpl extends SQLiteDatabaseCompat {
    private HoneycombImpl() {}
    
    public void enableFeatures(int param1Int, SQLiteDatabase param1SQLiteDatabase) {
      if ((param1Int & 0x1) != 0)
        param1SQLiteDatabase.enableWriteAheadLogging(); 
      if ((param1Int & 0x2) != 0)
        param1SQLiteDatabase.execSQL("PRAGMA foreign_keys = ON"); 
    }
    
    public int provideOpenFlags(int param1Int) {
      return 0;
    }
  }
  
  static class JellyBeanAndBeyondImpl extends SQLiteDatabaseCompat {
    private JellyBeanAndBeyondImpl() {}
    
    public void enableFeatures(int param1Int, SQLiteDatabase param1SQLiteDatabase) {
      if ((param1Int & 0x2) != 0)
        param1SQLiteDatabase.setForeignKeyConstraintsEnabled(true); 
    }
    
    public int provideOpenFlags(int param1Int) {
      return ((param1Int & 0x1) != 0) ? 536870912 : 0;
    }
  }
  
  static class NoopImpl extends SQLiteDatabaseCompat {
    private NoopImpl() {}
    
    public void enableFeatures(int param1Int, SQLiteDatabase param1SQLiteDatabase) {}
    
    public int provideOpenFlags(int param1Int) {
      return 0;
    }
  }
  
  public static @interface SQLiteOpenOptions {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\database\SQLiteDatabaseCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */