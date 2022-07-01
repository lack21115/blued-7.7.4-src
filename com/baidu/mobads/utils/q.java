package com.baidu.mobads.utils;

import android.util.Log;
import com.baidu.mobads.constants.a;
import com.baidu.mobads.interfaces.utils.IXAdLogger;

public class q implements IXAdLogger {
  private static volatile q a;
  
  public static q a() {
    // Byte code:
    //   0: getstatic com/baidu/mobads/utils/q.a : Lcom/baidu/mobads/utils/q;
    //   3: ifnonnull -> 37
    //   6: ldc com/baidu/mobads/utils/q
    //   8: monitorenter
    //   9: getstatic com/baidu/mobads/utils/q.a : Lcom/baidu/mobads/utils/q;
    //   12: ifnonnull -> 25
    //   15: new com/baidu/mobads/utils/q
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/baidu/mobads/utils/q.a : Lcom/baidu/mobads/utils/q;
    //   25: ldc com/baidu/mobads/utils/q
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/baidu/mobads/utils/q
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/baidu/mobads/utils/q.a : Lcom/baidu/mobads/utils/q;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private String a(Object[] paramArrayOfObject) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramArrayOfObject.length;
    for (int i = 0; i < j; i++) {
      stringBuilder.append(paramArrayOfObject[i]);
      stringBuilder.append(' ');
    } 
    return stringBuilder.toString();
  }
  
  public int d(String paramString) {
    return d("BaiduXAdSDK", paramString);
  }
  
  public int d(String paramString1, String paramString2) {
    if (!isLoggable(3))
      return -1; 
    try {
      return Log.d(paramString1, paramString2);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public int d(String paramString, Throwable paramThrowable) {
    if (!isLoggable(3))
      return -1; 
    try {
      return Log.d("BaiduXAdSDK", paramString, paramThrowable);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public int d(Throwable paramThrowable) {
    return d("", paramThrowable);
  }
  
  public int d(Object... paramVarArgs) {
    return !isLoggable(3) ? -1 : d(a(paramVarArgs));
  }
  
  public int e(String paramString) {
    if (!isLoggable(6))
      return -1; 
    try {
      return Log.e("BaiduXAdSDK", paramString);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public int e(String paramString, Throwable paramThrowable) {
    if (!isLoggable(6))
      return -1; 
    try {
      return Log.e("BaiduXAdSDK", paramString, paramThrowable);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public int e(Throwable paramThrowable) {
    return e("", paramThrowable);
  }
  
  public int e(Object... paramVarArgs) {
    return !isLoggable(6) ? -1 : e(a(paramVarArgs));
  }
  
  public int i(String paramString) {
    return i("BaiduXAdSDK", paramString);
  }
  
  public int i(String paramString1, String paramString2) {
    if (!isLoggable(4))
      return -1; 
    try {
      return Log.i(paramString1, paramString2);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public int i(String paramString, Throwable paramThrowable) {
    if (!isLoggable(4))
      return -1; 
    try {
      return Log.i("BaiduXAdSDK", paramString, paramThrowable);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public int i(Object... paramVarArgs) {
    return !isLoggable(4) ? -1 : i(a(paramVarArgs));
  }
  
  public boolean isLoggable(int paramInt) {
    return isLoggable("BaiduXAdSDK", paramInt);
  }
  
  public boolean isLoggable(String paramString, int paramInt) {
    return (paramInt >= a.b);
  }
  
  public int w(String paramString) {
    if (!isLoggable(5))
      return -1; 
    try {
      return Log.w("BaiduXAdSDK", paramString);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public int w(String paramString, Throwable paramThrowable) {
    if (!isLoggable(5))
      return -1; 
    try {
      return Log.w("BaiduXAdSDK", paramString, paramThrowable);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public int w(Throwable paramThrowable) {
    return w("", paramThrowable);
  }
  
  public int w(Object... paramVarArgs) {
    return !isLoggable(5) ? -1 : w(a(paramVarArgs));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */