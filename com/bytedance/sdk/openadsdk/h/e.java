package com.bytedance.sdk.openadsdk.h;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Set;

public class e {
  static volatile b a;
  
  static volatile c b;
  
  public static final boolean c = t.c();
  
  public static volatile boolean d;
  
  static volatile boolean e = true;
  
  static volatile boolean f;
  
  static volatile int g = 0;
  
  public static volatile int h = 3;
  
  public static volatile Integer i;
  
  private static volatile c j;
  
  private static volatile Context k;
  
  public static Context a() {
    return k;
  }
  
  public static void a(int paramInt) {
    g = paramInt;
  }
  
  public static void a(c paramc, Context paramContext) {
    if (paramc != null && paramContext != null) {
      k = paramContext.getApplicationContext();
      if (b != null)
        return; 
      b b1 = a;
      if (b1 == null || !b1.a.getAbsolutePath().equals(paramc.a.getAbsolutePath())) {
        b = paramc;
        j = c.a(paramContext);
        b.a(new c.a() {
              public void a(String param1String) {
                if (e.c) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("new cache created: ");
                  stringBuilder.append(param1String);
                  Log.i("TAG_PROXY_DiskLruCache", stringBuilder.toString());
                } 
              }
              
              public void a(Set<String> param1Set) {
                e.d().a(param1Set, 0);
                if (e.c) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("cache file removed, ");
                  stringBuilder.append(param1Set);
                  Log.i("TAG_PROXY_DiskLruCache", stringBuilder.toString());
                } 
              }
            });
        f f = f.a();
        f.a(paramc);
        f.a(j);
        d d = d.c();
        d.a(paramc);
        d.a(j);
        return;
      } 
      throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
    } 
    throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
  }
  
  public static void a(boolean paramBoolean) {
    e = paramBoolean;
  }
  
  public static c b() {
    return b;
  }
  
  public static void b(boolean paramBoolean) {
    f = paramBoolean;
  }
  
  public static b c() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */