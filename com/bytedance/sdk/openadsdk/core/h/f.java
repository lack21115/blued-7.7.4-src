package com.bytedance.sdk.openadsdk.core.h;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.i.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.c;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.i;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class f implements Runnable {
  private static volatile f a;
  
  public static f a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/h/f.a : Lcom/bytedance/sdk/openadsdk/core/h/f;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/h/i
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/h/f.a : Lcom/bytedance/sdk/openadsdk/core/h/f;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/h/f
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/h/f.a : Lcom/bytedance/sdk/openadsdk/core/h/f;
    //   25: ldc com/bytedance/sdk/openadsdk/core/h/i
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/h/i
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/h/f.a : Lcom/bytedance/sdk/openadsdk/core/h/f;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private String b(g paramg, int paramInt) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("wk_status", paramInt);
      jSONObject.put("app_id", h.c().e());
      jSONObject.put("package_name", ah.d());
      jSONObject.put("geo", c());
      jSONObject.put("ad_sdk_version", "2.9.5.6");
      jSONObject.put("os", 1);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Build.VERSION.RELEASE);
      stringBuilder.append("");
      jSONObject.put("os_version", stringBuilder.toString());
      jSONObject.put("ip", i.a(true));
      jSONObject.put("ua", ah.a());
      jSONObject.put("vendor", Build.MANUFACTURER);
      jSONObject.put("model", Build.MODEL);
      jSONObject.put("ad_package_name", paramg.c);
      jSONObject.put("action", paramg.a);
      jSONObject.put("service", paramg.b);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject.toString();
  }
  
  private JSONObject c() {
    c c = d.a(o.a());
    if (c != null)
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("latitude", c.a);
        jSONObject.put("longitude", c.b);
        return jSONObject;
      } catch (Exception exception) {} 
    return null;
  }
  
  private boolean d() {
    return TextUtils.isEmpty(h.c().e());
  }
  
  public void a(g paramg, int paramInt) {
    d d = new d();
    d.b(b(paramg, paramInt));
    d.a("wk_status");
    d.e("2.9.5.6");
    d.c(System.currentTimeMillis());
    a.a().m(d);
  }
  
  public void b() {
    a.a().b(this, 1);
  }
  
  public void run() {
    if (d())
      return; 
    try {
      wait(1000L);
    } catch (Exception exception) {}
    List<g> list = o.h().T();
    if (list != null) {
      int i = 0;
      while (true) {
        if (i < list.size()) {
          g g = list.get(i);
          if (g != null)
            try {
              long l = System.currentTimeMillis();
            } finally {
              Exception exception = null;
            }  
          i++;
          continue;
        } 
        return;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */