package com.ishumei.l111l1111llIl;

import android.util.Log;

public final class l111l11111Il {
  private static boolean l1111l111111Il = false;
  
  private static int l111l11111lIl = 5;
  
  private static String l1111l111111Il(String paramString, Object... paramVarArgs) {
    for (int i = 0; i < paramVarArgs.length; i++) {
      if (paramVarArgs[i] instanceof String[])
        paramVarArgs[i] = l1111l111111Il((String[])paramVarArgs[i]); 
    } 
    paramString = String.format(paramString, paramVarArgs);
    StringBuilder stringBuilder = new StringBuilder("[");
    stringBuilder.append(Thread.currentThread().getId());
    stringBuilder.append("] ");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private static String l1111l111111Il(String[] paramArrayOfString) {
    if (paramArrayOfString.length == 0)
      return "[]"; 
    StringBuilder stringBuilder = new StringBuilder("[");
    int j = paramArrayOfString.length - 1;
    for (int i = 0; i < j; i++) {
      stringBuilder.append(paramArrayOfString[i]);
      stringBuilder.append(", ");
    } 
    stringBuilder.append(paramArrayOfString[j]);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private static void l1111l111111Il(int paramInt) {
    l111l11111lIl = paramInt;
  }
  
  public static void l1111l111111Il(String paramString1, String paramString2, Object... paramVarArgs) {
    if (l1111l111111Il && l111l11111lIl <= 3)
      Log.d(paramString1, l1111l111111Il(paramString2, paramVarArgs)); 
  }
  
  public static void l1111l111111Il(Throwable paramThrowable) {
    if (l1111l111111Il)
      paramThrowable.printStackTrace(); 
  }
  
  private static void l1111l111111Il(boolean paramBoolean) {
    l1111l111111Il = paramBoolean;
  }
  
  public static void l111l11111I1l(String paramString1, String paramString2, Object... paramVarArgs) {
    if (l1111l111111Il && l111l11111lIl <= 5)
      Log.w(paramString1, l1111l111111Il(paramString2, paramVarArgs)); 
  }
  
  public static void l111l11111Il(String paramString1, String paramString2, Object... paramVarArgs) {
    if (l1111l111111Il && l111l11111lIl <= 6)
      Log.e(paramString1, l1111l111111Il(paramString2, paramVarArgs)); 
  }
  
  public static void l111l11111lIl(String paramString1, String paramString2, Object... paramVarArgs) {
    if (l1111l111111Il && l111l11111lIl <= 4)
      Log.i(paramString1, l1111l111111Il(paramString2, paramVarArgs)); 
  }
  
  private static void l111l1111l1Il(String paramString1, String paramString2, Object... paramVarArgs) {
    if (l1111l111111Il && l111l11111lIl <= 2)
      Log.v(paramString1, l1111l111111Il(paramString2, paramVarArgs)); 
  }
  
  private static void l111l1111llIl(String paramString1, String paramString2, Object... paramVarArgs) {
    if (l111l11111lIl <= 6)
      Log.e(paramString1, l1111l111111Il(paramString2, paramVarArgs)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111llIl\l111l11111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */