package com.bytedance.sdk.openadsdk.h.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class d extends SQLiteOpenHelper {
  public d(Context paramContext) {
    super(paramContext, "tt_open_sdk_video.db", null, 3);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS video_http_header_t(_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,mime TEXT,contentLength INTEGER,flag INTEGER,extra TEXT)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    if (paramInt1 == 1) {
      paramSQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN flag INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN extra TEXT DEFAULT ''");
      return;
    } 
    if (paramInt1 == 2) {
      paramSQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN extra TEXT DEFAULT ''");
      return;
    } 
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS video_http_header_t");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */