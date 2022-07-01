package com.qq.e.comm;

import android.content.Context;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.SystemUtil;

public class StubVisitor {
  private static volatile StubVisitor a;
  
  public static StubVisitor getInstance() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/StubVisitor.a : Lcom/qq/e/comm/StubVisitor;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/StubVisitor
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/StubVisitor.a : Lcom/qq/e/comm/StubVisitor;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/StubVisitor
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/StubVisitor.a : Lcom/qq/e/comm/StubVisitor;
    //   25: ldc com/qq/e/comm/StubVisitor
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/StubVisitor
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/StubVisitor.a : Lcom/qq/e/comm/StubVisitor;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public String appendPathName(String paramString) {
    return SystemUtil.buildNewPathByProcessName(paramString);
  }
  
  public boolean jumpToCustomLandingPage(Context paramContext, String paramString1, String paramString2) {
    CustomLandingPageListener customLandingPageListener = GlobalSetting.getCustomLandingPageListener();
    return (customLandingPageListener != null) ? customLandingPageListener.jumpToCustomLandingPage(paramContext, paramString1, paramString2) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\StubVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */