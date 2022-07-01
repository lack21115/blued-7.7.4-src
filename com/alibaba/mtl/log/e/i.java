package com.alibaba.mtl.log.e;

import android.os.Process;
import android.util.Log;

public class i {
  private static boolean I = false;
  
  private static boolean J = false;
  
  private static String af = "UTAnalytics:";
  
  public static void a(String paramString, Object paramObject) {
    if (n() || m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(af);
      paramString = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramObject);
      stringBuilder.append("");
      Log.w(paramString, stringBuilder.toString());
    } 
  }
  
  public static void a(String paramString, Object paramObject, Throwable paramThrowable) {
    if (n() || m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(af);
      paramString = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramObject);
      stringBuilder.append("");
      Log.w(paramString, stringBuilder.toString(), paramThrowable);
    } 
  }
  
  public static void a(String paramString, Object... paramVarArgs) {
    if (J) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(af);
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append("pid:");
      stringBuilder.append(Process.myPid());
      stringBuilder.append(" ");
      if (paramVarArgs != null)
        for (int j = 0; j < paramVarArgs.length; j++) {
          if (paramVarArgs[j] != null) {
            String str = paramVarArgs[j].toString();
            if (str.endsWith(":") || str.endsWith(": ")) {
              stringBuilder.append(str);
            } else {
              stringBuilder.append(str);
              stringBuilder.append(",");
            } 
          } 
        }  
      Log.d(paramString, stringBuilder.toString());
    } 
  }
  
  public static void a(String paramString, String... paramVarArgs) {
    if (J) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(af);
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append("pid:");
      stringBuilder.append(Process.myPid());
      stringBuilder.append(" ");
      if (paramVarArgs != null)
        for (int j = 0; j < paramVarArgs.length; j++) {
          if (paramVarArgs[j] != null) {
            String str = paramVarArgs[j];
            if (str.endsWith(":") || str.endsWith(": ")) {
              stringBuilder.append(str);
            } else {
              stringBuilder.append(str);
              stringBuilder.append(",");
            } 
          } 
        }  
      Log.i(paramString, stringBuilder.toString());
    } 
  }
  
  public static void d(boolean paramBoolean) {
    J = paramBoolean;
  }
  
  public static boolean m() {
    return I;
  }
  
  public static boolean n() {
    return J;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */