package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import com.soft.blued.utils.Logger;

public abstract class SDKBaseAction {
  private static long f = System.currentTimeMillis() / 1000L;
  
  protected long a = d();
  
  protected String b;
  
  protected String c;
  
  protected String d;
  
  protected String e;
  
  private boolean g = false;
  
  private boolean h = false;
  
  public SDKBaseAction(Intent paramIntent) {
    this.b = paramIntent.getAction();
    this.c = paramIntent.getStringExtra("app_key");
    this.d = paramIntent.getStringExtra("secret_key");
    this.e = paramIntent.getStringExtra("pkg_name");
    Logger.a("SDKAction", new Object[] { "action create, action:", this });
  }
  
  public static SDKBaseAction a(Intent paramIntent) {
    String str = paramIntent.getAction();
    return (SDKBaseAction)("com.blued.android.sdk.action.auth".equals(str) ? new SDKAuthAction(paramIntent) : ("com.blued.android.sdk.action.pay".equals(str) ? new SDKPayAction(paramIntent) : ("com.blued.android.sdk.action.browser".equals(str) ? new SDKBrowserAction(paramIntent) : null)));
  }
  
  private static long d() {
    // Byte code:
    //   0: ldc com/soft/blued/sdk/SDKBaseAction
    //   2: monitorenter
    //   3: getstatic com/soft/blued/sdk/SDKBaseAction.f : J
    //   6: lstore_0
    //   7: lconst_1
    //   8: lload_0
    //   9: ladd
    //   10: putstatic com/soft/blued/sdk/SDKBaseAction.f : J
    //   13: ldc com/soft/blued/sdk/SDKBaseAction
    //   15: monitorexit
    //   16: lload_0
    //   17: lreturn
    //   18: astore_2
    //   19: ldc com/soft/blued/sdk/SDKBaseAction
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	18	finally
  }
  
  private void e() {
    this.g = true;
    SDKActionManager.c(this.a);
  }
  
  public long a() {
    return this.a;
  }
  
  protected abstract void a(Context paramContext);
  
  public void b() {
    Logger.a("SDKAction", new Object[] { "action finish, action:", this });
    e();
  }
  
  protected abstract void b(Context paramContext);
  
  public void c(Context paramContext) {
    Logger.a("SDKAction", new Object[] { "action start, action:", this });
    if (!this.g) {
      if (this.h)
        return; 
      this.h = true;
      a(paramContext);
    } 
  }
  
  public boolean c() {
    return this.g;
  }
  
  public void d(Context paramContext) {
    Logger.a("SDKAction", new Object[] { "action cancel, action:", this });
    if (!this.g)
      b(paramContext); 
    e();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[action:");
    stringBuilder.append(this.b);
    stringBuilder.append(", id:");
    stringBuilder.append(this.a);
    stringBuilder.append(", appKey:");
    stringBuilder.append(this.c);
    stringBuilder.append(", appPkgName:");
    stringBuilder.append(this.e);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public static interface Result {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sdk\SDKBaseAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */