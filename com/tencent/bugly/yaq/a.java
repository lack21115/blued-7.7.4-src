package com.tencent.bugly.yaq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.yaq.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.yaq.proguard.x;

public abstract class a {
  public int id;
  
  public String moduleName;
  
  public String version;
  
  public String versionKey;
  
  public a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract String[] getTables();
  
  public abstract void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy);
  
  public void onDbCreate(SQLiteDatabase paramSQLiteDatabase) {
    throw new VerifyError("bad dex opcode");
  }
  
  public void onDbDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public void onDbUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean) {
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */