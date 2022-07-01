package com.facebook.stetho.inspector.protocol.module;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import java.util.List;

public abstract class BaseDatabaseDriver<DESC> {
  protected Context mContext;
  
  public BaseDatabaseDriver(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public abstract Database.ExecuteSQLResponse executeSQL(DESC paramDESC, String paramString, ExecuteResultHandler<Database.ExecuteSQLResponse> paramExecuteResultHandler) throws SQLiteException;
  
  public Context getContext() {
    return this.mContext;
  }
  
  public abstract List<DESC> getDatabaseNames();
  
  public abstract List<String> getTableNames(DESC paramDESC);
  
  public static interface ExecuteResultHandler<RESULT> {
    RESULT handleInsert(long param1Long) throws SQLiteException;
    
    RESULT handleRawQuery() throws SQLiteException;
    
    RESULT handleSelect(Cursor param1Cursor) throws SQLiteException;
    
    RESULT handleUpdateDelete(int param1Int) throws SQLiteException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\BaseDatabaseDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */