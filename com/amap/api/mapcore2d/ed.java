package com.amap.api.mapcore2d;

import android.database.sqlite.SQLiteDatabase;

public class ed implements ds {
  private static ed a;
  
  public static ed c() {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/ed
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/ed.a : Lcom/amap/api/mapcore2d/ed;
    //   6: ifnonnull -> 19
    //   9: new com/amap/api/mapcore2d/ed
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/amap/api/mapcore2d/ed.a : Lcom/amap/api/mapcore2d/ed;
    //   19: getstatic com/amap/api/mapcore2d/ed.a : Lcom/amap/api/mapcore2d/ed;
    //   22: astore_0
    //   23: ldc com/amap/api/mapcore2d/ed
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/amap/api/mapcore2d/ed
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public String a() {
    return "dafile.db";
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase) {
    try {
      return;
    } finally {
      paramSQLiteDatabase = null;
      eh.a((Throwable)paramSQLiteDatabase, "DynamicFileDBCreator", "onCreate");
    } 
  }
  
  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public int b() {
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */