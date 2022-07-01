package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.IOaidObserver;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;

public class x {
  private static volatile String a = "";
  
  private static volatile boolean b = false;
  
  static {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String a() {
    if (TextUtils.isEmpty(a) && !b) {
      TTCustomController tTCustomController = h.c().d();
      if (tTCustomController != null && !TextUtils.isEmpty(tTCustomController.getDevOaid())) {
        a = tTCustomController.getDevOaid();
        c();
      } 
    } 
    return (a == null) ? "" : a;
  }
  
  public static void a(Context paramContext) {
    try {
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  private static void c() {
    if (!TextUtils.isEmpty(a))
      com.bytedance.sdk.openadsdk.i.a.a().c(new a(a), 5); 
  }
  
  static class a implements Runnable {
    String a;
    
    a(String param1String) {
      this.a = param1String;
    }
    
    public void run() {
      if (!TextUtils.isEmpty(this.a)) {
        d.a(o.a()).a("oaid", this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("oaid=");
        stringBuilder.append(this.a);
        t.b("OAIDHelper", stringBuilder.toString());
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */