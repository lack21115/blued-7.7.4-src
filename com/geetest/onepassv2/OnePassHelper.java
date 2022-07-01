package com.geetest.onepassv2;

import android.content.Context;
import com.geetest.onepassv2.c.a;
import com.geetest.onepassv2.listener.OnePassListener;

public class OnePassHelper {
  private static volatile OnePassHelper gopOnePassHelper;
  
  public static OnePassHelper with() {
    // Byte code:
    //   0: getstatic com/geetest/onepassv2/OnePassHelper.gopOnePassHelper : Lcom/geetest/onepassv2/OnePassHelper;
    //   3: ifnonnull -> 37
    //   6: ldc com/geetest/onepassv2/OnePassHelper
    //   8: monitorenter
    //   9: getstatic com/geetest/onepassv2/OnePassHelper.gopOnePassHelper : Lcom/geetest/onepassv2/OnePassHelper;
    //   12: ifnonnull -> 25
    //   15: new com/geetest/onepassv2/OnePassHelper
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/geetest/onepassv2/OnePassHelper.gopOnePassHelper : Lcom/geetest/onepassv2/OnePassHelper;
    //   25: ldc com/geetest/onepassv2/OnePassHelper
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/geetest/onepassv2/OnePassHelper
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/geetest/onepassv2/OnePassHelper.gopOnePassHelper : Lcom/geetest/onepassv2/OnePassHelper;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void cancel() {
    a.a().e();
  }
  
  public String getPhone() {
    return a.a().c();
  }
  
  public String getProcessId() {
    return a.a().d();
  }
  
  public String getSimOperator(Context paramContext) {
    return a.a().b(paramContext);
  }
  
  public void getToken(String paramString1, String paramString2, OnePassListener paramOnePassListener) {
    a.a().a(paramString1, paramString2, paramOnePassListener);
  }
  
  public String getVersion() {
    return a.a().b();
  }
  
  public OnePassHelper init(Context paramContext) {
    a.a().a(paramContext);
    return this;
  }
  
  public OnePassHelper openDebug(boolean paramBoolean) {
    a.a().a(paramBoolean);
    return this;
  }
  
  public OnePassHelper setApiServer(String paramString) {
    a.a().b(paramString);
    return this;
  }
  
  public OnePassHelper setConnectTimeout(int paramInt) {
    a.a().a(paramInt);
    return this;
  }
  
  public OnePassHelper setLogEnable(boolean paramBoolean, String paramString) {
    a.a().a(paramBoolean, paramString);
    return this;
  }
  
  public OnePassHelper setOperator(String paramString) {
    a.a().a(paramString);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\OnePassHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */