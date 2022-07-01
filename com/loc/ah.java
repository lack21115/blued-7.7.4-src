package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class ah extends SQLiteOpenHelper {
  private static boolean b = true;
  
  private static boolean c = false;
  
  private ad a;
  
  public ah(Context paramContext, String paramString, ad paramad) {
    super(paramContext, paramString, null, 1);
    this.a = paramad;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    this.a.a(paramSQLiteDatabase);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */