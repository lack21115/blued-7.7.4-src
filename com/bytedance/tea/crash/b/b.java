package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.tea.crash.b.b.b;

public class b extends SQLiteOpenHelper {
  public b(Context paramContext) {
    super(paramContext, "npth_log.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    (new b()).a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */