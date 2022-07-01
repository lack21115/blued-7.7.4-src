package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public interface ApiCompatibility {
  CancellationHook createCancellationHook();
  
  Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString, CancellationHook paramCancellationHook);
  
  public static interface CancellationHook {
    void cancel();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\compat\ApiCompatibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */