package com.amap.api.mapcore2d;

import android.database.sqlite.SQLiteDatabase;

public class dx implements ds {
  public String a() {
    return "logdb.db";
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase) {
    try {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a1  varchar(20), a2 varchar(10),a3 varchar(50),a4 varchar(100),a5 varchar(20),a6 integer);");
      paramSQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", new Object[] { "b" }));
      paramSQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", new Object[] { "c" }));
      return;
    } finally {
      paramSQLiteDatabase = null;
      dl.a((Throwable)paramSQLiteDatabase, "DB", "onCreate");
    } 
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public int b() {
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */