package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BasicApiCompatibility implements ApiCompatibility {
  public ApiCompatibility.CancellationHook createCancellationHook() {
    return null;
  }
  
  public Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString, ApiCompatibility.CancellationHook paramCancellationHook) {
    return paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\compat\BasicApiCompatibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */