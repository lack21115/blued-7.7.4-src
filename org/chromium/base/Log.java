package org.chromium.base;

import java.util.Locale;

public final class Log {
  public static void e(String paramString1, String paramString2, Object... paramVarArgs) {
    paramString2 = formatLog(paramString2, paramVarArgs);
    Throwable throwable = getThrowableToLog(paramVarArgs);
    if (throwable != null) {
      android.util.Log.e(normalizeTag(paramString1), paramString2, throwable);
      return;
    } 
    android.util.Log.e(normalizeTag(paramString1), paramString2);
  }
  
  private static String formatLog(String paramString, Object... paramVarArgs) {
    String str = paramString;
    if (paramVarArgs != null) {
      str = paramString;
      if (paramVarArgs.length != 0)
        str = String.format(Locale.US, paramString, paramVarArgs); 
    } 
    return str;
  }
  
  private static Throwable getThrowableToLog(Object[] paramArrayOfObject) {
    if (paramArrayOfObject != null) {
      if (paramArrayOfObject.length == 0)
        return null; 
      Object object = paramArrayOfObject[paramArrayOfObject.length - 1];
      return !(object instanceof Throwable) ? null : (Throwable)object;
    } 
    return null;
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs) {
    paramString2 = formatLog(paramString2, paramVarArgs);
    Throwable throwable = getThrowableToLog(paramVarArgs);
    if (throwable != null) {
      android.util.Log.i(normalizeTag(paramString1), paramString2, throwable);
      return;
    } 
    android.util.Log.i(normalizeTag(paramString1), paramString2);
  }
  
  private static String normalizeTag(String paramString) {
    if (paramString.startsWith("cr_"))
      return paramString; 
    byte b = 0;
    if (paramString.startsWith("cr."))
      b = 3; 
    StringBuilder stringBuilder = new StringBuilder("cr_");
    stringBuilder.append(paramString.substring(b, paramString.length()));
    return stringBuilder.toString();
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs) {
    paramString2 = formatLog(paramString2, paramVarArgs);
    Throwable throwable = getThrowableToLog(paramVarArgs);
    if (throwable != null) {
      android.util.Log.w(normalizeTag(paramString1), paramString2, throwable);
      return;
    } 
    android.util.Log.w(normalizeTag(paramString1), paramString2);
  }
  
  public static void wtf(String paramString1, String paramString2, Object... paramVarArgs) {
    paramString2 = formatLog(paramString2, paramVarArgs);
    Throwable throwable = getThrowableToLog(paramVarArgs);
    if (throwable != null) {
      android.util.Log.wtf(normalizeTag(paramString1), paramString2, throwable);
      return;
    } 
    android.util.Log.wtf(normalizeTag(paramString1), paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */