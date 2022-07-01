package com.amap.api.mapcore2d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dw extends SQLiteOpenHelper {
  private static boolean b = true;
  
  private static boolean c = false;
  
  private ds a;
  
  public dw(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, ds paramds) {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.a = paramds;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    this.a.a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    this.a.a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */