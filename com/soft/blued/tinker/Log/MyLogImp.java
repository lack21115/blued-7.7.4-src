package com.soft.blued.tinker.Log;

import android.util.Log;
import com.soft.blued.utils.Logger;
import com.tencent.tinker.lib.util.TinkerLog;

public class MyLogImp implements TinkerLog.TinkerLogImp {
  private static int a;
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs) {
    if (a <= 1) {
      if (paramVarArgs != null)
        paramString2 = String.format(paramString2, paramVarArgs); 
      Logger.c(paramString1, new Object[] { paramString2 });
    } 
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs) {
    if (a <= 4) {
      if (paramVarArgs != null)
        paramString2 = String.format(paramString2, paramVarArgs); 
      Logger.e(paramString1, new Object[] { paramString2 });
    } 
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs) {
    if (a <= 2) {
      if (paramVarArgs != null)
        paramString2 = String.format(paramString2, paramVarArgs); 
      Logger.b(paramString1, new Object[] { paramString2 });
    } 
  }
  
  public void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs) {
    if (paramVarArgs != null)
      paramString2 = String.format(paramString2, paramVarArgs); 
    String str = paramString2;
    if (paramString2 == null)
      str = ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("  ");
    stringBuilder.append(Log.getStackTraceString(paramThrowable));
    Logger.e(paramString1, new Object[] { stringBuilder.toString() });
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs) {
    if (a <= 0) {
      if (paramVarArgs != null)
        paramString2 = String.format(paramString2, paramVarArgs); 
      Logger.a(paramString1, new Object[] { paramString2 });
    } 
  }
  
  public void w(String paramString1, String paramString2, Object... paramVarArgs) {
    if (a <= 3) {
      if (paramVarArgs != null)
        paramString2 = String.format(paramString2, paramVarArgs); 
      Logger.d(paramString1, new Object[] { paramString2 });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\Log\MyLogImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */