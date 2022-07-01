package com.amap.api.mapcore2d;

import android.content.Context;

public class dl {
  protected static dl a;
  
  protected Thread.UncaughtExceptionHandler b;
  
  protected boolean c = true;
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2) {
    dl dl1 = a;
    if (dl1 != null)
      dl1.a(paramThrowable, 1, paramString1, paramString2); 
  }
  
  protected void a() {}
  
  protected void a(Context paramContext, da paramda, boolean paramBoolean) {}
  
  protected void a(da paramda, String paramString1, String paramString2) {}
  
  protected void a(Throwable paramThrowable, int paramInt, String paramString1, String paramString2) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */