package com.bytedance.sdk.openadsdk.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.d.c;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a.b;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.c;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
  private static volatile a a;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/f/a.a : Lcom/bytedance/sdk/openadsdk/f/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/f/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/f/a.a : Lcom/bytedance/sdk/openadsdk/f/a;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/f/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/f/a.a : Lcom/bytedance/sdk/openadsdk/f/a;
    //   25: ldc com/bytedance/sdk/openadsdk/f/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/f/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/f/a.a : Lcom/bytedance/sdk/openadsdk/f/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private boolean a(String paramString, int paramInt) {
    d d = d.a(o.a());
    boolean bool = false;
    int i = d.b(paramString, 0);
    if ((i & 0x2) == 0 || (i & 0x1) != paramInt)
      bool = true; 
    if (bool)
      d.a(paramString, paramInt + 2); 
    return bool;
  }
  
  private JSONObject b(List<c> paramList, k paramk, JSONObject paramJSONObject) {
    if (paramList == null || paramList.size() == 0 || paramk == null)
      return null; 
    JSONObject jSONObject1 = new JSONObject();
    JSONObject jSONObject2 = new JSONObject();
    try {
      jSONObject2.put("log_extra", paramk.P());
      jSONObject2.put("network_type", w.c(o.a()));
      jSONObject2.put("timestamp", System.currentTimeMillis() / 1000L);
      jSONObject2.put("cid", paramk.M());
      jSONObject2.put("platform", "Android");
      jSONObject2.put("app", h.c().f());
      jSONObject2.put("device_id", j.a(o.a()));
      c c = d.a(o.a());
      JSONObject jSONObject = new JSONObject();
      if (c != null) {
        jSONObject.put("longitude", c.b);
        jSONObject.put("latitude", c.a);
      } 
      jSONObject2.put("location", jSONObject);
      JSONArray jSONArray = new JSONArray();
      for (c c1 : paramList) {
        if (c1 != null)
          jSONArray.put(c1.a()); 
      } 
      jSONObject2.put("pages", jSONArray);
      if (paramJSONObject != null) {
        jSONObject2.put("extra_info", paramJSONObject);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("back extra info:");
        stringBuilder1.append(paramJSONObject.toString());
        t.b("extra_info", stringBuilder1.toString());
      } 
      String str = com.bytedance.sdk.openadsdk.core.a.a(ah.i(jSONObject2.toString()), b.c());
      jSONObject1.put("content", str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("html content:");
      stringBuilder.append(str);
      t.e("StatsLogManager", stringBuilder.toString());
      return jSONObject1;
    } catch (Exception exception) {
      return jSONObject1;
    } 
  }
  
  private boolean o(d paramd) {
    return (paramd == null);
  }
  
  public void a(d paramd) {
    if (o(paramd))
      return; 
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd);
  }
  
  public void a(List<c> paramList, k paramk, JSONObject paramJSONObject) {
    if (paramList != null && paramList.size() != 0) {
      if (paramk == null)
        return; 
      com.bytedance.sdk.openadsdk.i.a.a().d(new Runnable(this, paramList, paramk, paramJSONObject) {
            public void run() {
              if (o.h().v() && w.c(o.a()) != 4)
                return; 
              JSONObject jSONObject = a.a(this.d, this.a, this.b, this.c);
              o.f().a(jSONObject, 1);
            }
          }5);
    } 
  }
  
  public void a(boolean paramBoolean, String[] paramArrayOfString) {
    int i;
    JSONObject jSONObject = new JSONObject();
    byte b = 0;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    } 
    try {
      jSONObject.put("if_sd", i);
      if (paramArrayOfString != null && paramArrayOfString.length > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        int j = paramArrayOfString.length;
        for (i = b;; i++) {
          if (i < j) {
            String str = paramArrayOfString[i];
            if (!TextUtils.isEmpty(str)) {
              stringBuilder.append(str);
              stringBuilder.append(",");
            } 
          } else {
            jSONObject.put("permission", stringBuilder.toString());
            d d1 = d.b().a("download_permission").c(System.currentTimeMillis() / 1000L).b(jSONObject.toString());
            o.j().a((b)d1);
          } 
        } 
      } 
    } finally {}
    d d = d.b().a("download_permission").c(System.currentTimeMillis() / 1000L).b(jSONObject.toString());
    o.j().a((b)d);
  }
  
  public void b() {
    boolean bool1;
    boolean bool3 = h.c().d().alist();
    boolean bool4 = h.c().d().isCanUseLocation();
    boolean bool5 = h.c().d().isCanUseWriteExternal();
    boolean bool6 = h.c().d().isCanUseWifiState();
    boolean bool7 = h.c().d().isCanUsePhoneState();
    JSONObject jSONObject = new JSONObject();
    boolean bool2 = true;
    if (bool4) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    try {
      jSONObject.put("access_fine_location", bool1);
      if (bool3) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      jSONObject.put("applist", bool1);
      if (bool5) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      jSONObject.put("external_storage", bool1);
      if (bool6) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      jSONObject.put("wifi_state", bool1);
      if (bool7) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      jSONObject.put("phone_state", bool1);
    } finally {
      Exception exception;
    } 
    d d = d.b().a("sdk_permission").b(jSONObject.toString());
    o.j().a((b)d, false);
  }
  
  public void b(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("outer_call");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd, true);
  }
  
  public void c(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("outer_call_send");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd, true);
  }
  
  public void d(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("outer_call_no_rsp");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd, true);
  }
  
  public void e(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("load_ad_duration_no_ad");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd);
  }
  
  public void f(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("load_creative_error");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd, true);
  }
  
  public void g(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("load_timeout");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd, true);
  }
  
  public void h(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("express_ad_render");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd);
  }
  
  public void i(d paramd) {
    if (!o(paramd))
      com.bytedance.sdk.openadsdk.i.a.a().d(new Runnable(this, paramd) {
            public void run() {
              if (!a.a(this.b, this.a)) {
                if (!a.a(this.b, this.a.e(), 1))
                  return; 
                this.a.a("reg_creative");
                o.j().a((b)this.a);
              } 
            }
          }5); 
  }
  
  public void j(d paramd) {
    if (!o(paramd))
      com.bytedance.sdk.openadsdk.i.a.a().d(new Runnable(this, paramd) {
            public void run() {
              if (!a.a(this.b, this.a)) {
                if (!a.a(this.b, this.a.e(), 0))
                  return; 
                this.a.a("no_reg_creative");
                o.j().a((b)this.a);
              } 
            }
          }5); 
  }
  
  public void k(d paramd) {
    if (!o(paramd)) {
      paramd.a("load_icon_error");
      o.j().a((b)paramd);
    } 
  }
  
  public void l(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("show_backup_endcard");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd);
  }
  
  public void m(d paramd) {
    if (!o(paramd))
      o.j().a((b)paramd); 
  }
  
  public void n(d paramd) {
    if (o(paramd))
      return; 
    paramd.a("splash_creative_check");
    paramd.c(System.currentTimeMillis() / 1000L);
    o.j().a((b)paramd, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */