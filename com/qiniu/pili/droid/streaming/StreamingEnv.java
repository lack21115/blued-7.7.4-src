package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.d.c;
import a.a.a.a.a.e.e;
import a.a.a.a.a.k.b;
import a.a.a.a.a.n.b;
import android.content.Context;

public class StreamingEnv {
  public static boolean a = false;
  
  public static boolean b = true;
  
  public static void a() {
    if (a)
      return; 
    throw new IllegalStateException("You must initialize StreamingEnv by StreamingEnv#init first!");
  }
  
  public static void a(Context paramContext, a parama) {
    e.d.c("StreamingEnv", "init");
    if (a) {
      e.d.d("StreamingEnv", "ignore since had been initialized!");
      return;
    } 
    a = true;
    b.a(paramContext);
    b.a(paramContext);
    f.a(paramContext);
    c.a(paramContext);
    a.a.a.a.a.j.a.a().a(paramContext);
    e.d.c("StreamingEnv", "init success !");
  }
  
  public static boolean b() {
    return b;
  }
  
  public static void checkAuthentication(PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    if (!a) {
      e.d.e("StreamingEnv", "Should StreamingEnv.init first!");
      return;
    } 
    b.a().a(paramPLAuthenticationResultCallback);
  }
  
  public static void init(Context paramContext) {
    a(paramContext, null);
  }
  
  public static void setLogLevel(int paramInt) {
    e.a(paramInt);
  }
  
  public static void setNeedLoadSO(boolean paramBoolean) {
    b = paramBoolean;
  }
  
  public static class a {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\StreamingEnv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */