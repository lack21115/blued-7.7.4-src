package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;

public abstract class a {
  public int id;
  
  public String moduleName;
  
  public String version;
  
  public String versionKey;
  
  public abstract String[] getTables();
  
  public abstract void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy);
  
  public void onDbCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onDbDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    try {
      if (getTables() == null)
        return; 
      String[] arrayOfString = getTables();
      paramInt2 = arrayOfString.length;
      return;
    } finally {
      paramSQLiteDatabase = null;
      if (!x.b((Throwable)paramSQLiteDatabase))
        paramSQLiteDatabase.printStackTrace(); 
    } 
  }
  
  public void onDbUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    try {
      if (getTables() == null)
        return; 
      String[] arrayOfString = getTables();
      paramInt2 = arrayOfString.length;
      return;
    } finally {
      paramSQLiteDatabase = null;
      if (!x.b((Throwable)paramSQLiteDatabase))
        paramSQLiteDatabase.printStackTrace(); 
    } 
  }
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */