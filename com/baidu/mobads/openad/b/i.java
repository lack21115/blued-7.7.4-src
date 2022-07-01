package com.baidu.mobads.openad.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class i extends SQLiteOpenHelper {
  public i(Context paramContext) {
    super(paramContext, "__bd_sdk_download_x.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("create table download_info(_id integer PRIMARY KEY AUTOINCREMENT, thread_id integer, start_pos integer, end_pos integer, compelete_size integer, url char, local_file char, process_name char)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */