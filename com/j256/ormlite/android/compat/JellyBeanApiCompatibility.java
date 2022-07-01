package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;

public class JellyBeanApiCompatibility extends BasicApiCompatibility {
  public ApiCompatibility.CancellationHook createCancellationHook() {
    return new JellyBeanCancellationHook();
  }
  
  public Cursor rawQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString, ApiCompatibility.CancellationHook paramCancellationHook) {
    return (paramCancellationHook == null) ? paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString) : paramSQLiteDatabase.rawQuery(paramString, paramArrayOfString, ((JellyBeanCancellationHook)paramCancellationHook).cancellationSignal);
  }
  
  public static class JellyBeanCancellationHook implements ApiCompatibility.CancellationHook {
    private final CancellationSignal cancellationSignal = new CancellationSignal();
    
    public void cancel() {
      this.cancellationSignal.cancel();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\compat\JellyBeanApiCompatibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */