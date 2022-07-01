package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.ss.android.a.a.a.h;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class e implements h {
  private static boolean b = true;
  
  private static boolean c = false;
  
  private static boolean d = true;
  
  private static String e = "com.oppo.market";
  
  private static int f = 0;
  
  private static String g = "com.huawei.appmarket";
  
  private static int h = 1;
  
  private static int i = 30;
  
  private static int j = 10;
  
  private static int k;
  
  private static int l;
  
  private static volatile e m;
  
  private WeakReference<Context> a;
  
  static {
    b();
  }
  
  public e(Context paramContext) {
    this.a = new WeakReference<Context>(paramContext);
    b();
  }
  
  private int a(int paramInt) {
    if (paramInt == 1)
      return 0; 
    if (paramInt == 0);
    return 1;
  }
  
  public static e a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/downloadnew/a/a/e.m : Lcom/bytedance/sdk/openadsdk/downloadnew/a/a/e;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/downloadnew/a/a/e
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/downloadnew/a/a/e.m : Lcom/bytedance/sdk/openadsdk/downloadnew/a/a/e;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/downloadnew/a/a/e
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/downloadnew/a/a/e.m : Lcom/bytedance/sdk/openadsdk/downloadnew/a/a/e;
    //   26: ldc com/bytedance/sdk/openadsdk/downloadnew/a/a/e
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/downloadnew/a/a/e
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/downloadnew/a/a/e.m : Lcom/bytedance/sdk/openadsdk/downloadnew/a/a/e;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private static void b() {
    try {
      l l = o.h();
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private JSONObject c() {
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject1 = new JSONObject();
      return jSONObject1;
    } finally {
      Exception exception = null;
    } 
  }
  
  public JSONObject a() {
    b();
    return c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */