package com.bytedance.sdk.openadsdk.downloadnew.a.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.ss.android.a.a.b.f;
import com.ss.android.downloadad.a.a.a;
import com.ss.android.downloadad.a.a.c;
import org.json.JSONObject;

public class b {
  private static int a(int paramInt) {
    if (paramInt != 0) {
      byte b1 = 1;
      if (paramInt != 1) {
        b1 = 2;
        if (paramInt != 2) {
          b1 = 3;
          if (paramInt != 3)
            return 0; 
        } 
      } 
      return b1;
    } 
    return 0;
  }
  
  public static f.a a(String paramString1, String paramString2) {
    f.a a = (new f.a()).a(paramString1).a(true).b(h.c().k()).d(h.c().k() ^ true).b(d.a);
    if (com.bytedance.sdk.openadsdk.multipro.b.b())
      a.c(true); 
    return a;
  }
  
  public static a.a a(k paramk) {
    int i;
    int j;
    boolean bool = true;
    if (paramk == null) {
      j = 1;
    } else {
      j = paramk.v();
    } 
    if (paramk == null) {
      i = 0;
    } else {
      i = paramk.w();
    } 
    int m = i;
    if (paramk != null) {
      m = i;
      if (!TextUtils.isEmpty(paramk.Z()))
        m = 2; 
    } 
    a.a a = (new a.a()).a(b(j)).b(a(m)).a(true);
    if (paramk == null || !paramk.u())
      bool = false; 
    return a.c(bool).b(false).a(paramk);
  }
  
  public static com.ss.android.downloadad.a.a.b.a a(k paramk, String paramString) {
    return (new com.ss.android.downloadad.a.a.b.a()).a(true).c(true).b(true).d(false).d(paramString).k("click_start").f(paramString).m("click_continue").e(paramString).l("click_pause").r("download_failed").j(paramString).q("download_failed").g(paramString).n("click_install").h(paramString).o("click_open").i(paramString).p("open_url_app").c(paramString).a(paramString).b(paramString);
  }
  
  public static c.a a(String paramString, k paramk, JSONObject paramJSONObject) {
    if (paramk == null)
      return new c.a(); 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("open_ad_sdk_download_extra", a.a().a(paramString).b(paramJSONObject).a(paramk).b());
    } catch (Exception exception) {}
    c.a a2 = (new c.a()).a(Long.valueOf(paramk.M()).longValue());
    if (paramk.C() == null) {
      paramString = null;
    } else {
      paramString = paramk.C().a();
    } 
    c.a a1 = a2.c(paramString).b(h.c().k()).d(h.c().k() ^ true).a(paramk.P()).a(jSONObject).f(d.a);
    com.bytedance.sdk.openadsdk.core.d.b b1 = paramk.N();
    if (b1 != null)
      a1.d(b1.b()).e(b1.c()).b(b1.d()); 
    if (com.bytedance.sdk.openadsdk.multipro.b.b())
      a1.c(true); 
    if (paramk.O() != null) {
      com.ss.android.a.a.c.b b2 = new com.ss.android.a.a.c.b();
      b2.a(Long.valueOf(paramk.M()).longValue());
      b2.b(paramk.O().a());
      b2.c(paramk.J());
      if (paramk.O().c() != 2 || paramk.Q() == 5 || paramk.Q() == 15)
        if (paramk.O().c() == 1) {
          b2.a(paramk.O().b());
        } else {
          b2.a(paramk.E());
        }  
      a1.a(b2);
    } 
    return a1;
  }
  
  private static int b(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? 1 : 2) : 1) : 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */