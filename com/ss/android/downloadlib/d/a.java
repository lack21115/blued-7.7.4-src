package com.ss.android.downloadlib.d;

import android.os.Build;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.d;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.e.g;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.i;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private a() {}
  
  public static a a() {
    return a.a();
  }
  
  private JSONObject a(c paramc) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("download_url", paramc.a());
      jSONObject.put("package_name", paramc.t());
      jSONObject.put("android_int", Build.VERSION.SDK_INT);
      jSONObject.put("rom_name", i.f());
      jSONObject.put("rom_version", i.g());
      g.a(paramc.w(), jSONObject);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private JSONObject a(com.ss.android.downloadad.a.b.a parama) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("download_url", parama.q());
      jSONObject.put("package_name", parama.d());
      jSONObject.put("android_int", Build.VERSION.SDK_INT);
      jSONObject.put("rom_name", i.f());
      jSONObject.put("rom_version", i.g());
      g.a(parama.h(), jSONObject);
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private void a(d paramd) {
    if (j.b() == null)
      return; 
    if (paramd.e()) {
      j.b().a(paramd);
      return;
    } 
    j.b().b(paramd);
  }
  
  private void a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, int paramInt, c paramc, b paramb) {
    try {
      a((new d.a()).a(g.a(new String[] { paramString1, "embeded_ad" })).b(paramString2).b(paramc.r()).a(paramc.d()).c(paramc.s()).b(paramLong).d(paramb.a()).a(paramc.v()).a(g.a(new JSONObject[] { a(paramc), paramJSONObject })).a(paramb.j()).a(paramInt).a(paramb.m()).a());
      return;
    } catch (Exception exception) {
      g.a(exception);
      return;
    } 
  }
  
  private void a(String paramString1, String paramString2, JSONObject paramJSONObject, c paramc, b paramb) {
    a(paramString1, paramString2, paramJSONObject, paramc.e(), 2, paramc, paramb);
  }
  
  private void b(String paramString1, String paramString2, JSONObject paramJSONObject, com.ss.android.downloadad.a.b.a parama) {
    try {
      a((new d.a()).a(g.a(new String[] { paramString1, "embeded_ad" })).b(paramString2).b(parama.g()).a(parama.a()).c(parama.f()).b(parama.b()).d(parama.p()).a(g.a(new JSONObject[] { a(parama), paramJSONObject })).a(2).a(parama.l()).a());
      return;
    } catch (Exception exception) {
      g.a(exception);
      return;
    } 
  }
  
  public void a(long paramLong, int paramInt) {
    String str1;
    c.a a1 = c.a().e(paramLong);
    if (a1.a()) {
      g.b();
      return;
    } 
    if (!a1.c.l())
      return; 
    b b = a1.c;
    if (paramInt == 1) {
      str1 = b.c();
    } else {
      str1 = str1.b();
    } 
    String str2 = g.a(new String[] { a1.c.d(), "click" });
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("click_type", Integer.valueOf(paramInt));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    a(str1, str2, jSONObject, a1.b, a1.c);
  }
  
  public void a(long paramLong, int paramInt, c paramc) {
    String str;
    c.a a1 = c.a().e(paramLong);
    if (a1.a()) {
      g.b();
      return;
    } 
    c c1 = null;
    JSONObject jSONObject = new JSONObject();
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            if (paramInt != 5) {
              paramc = c1;
            } else {
              if (paramc != null)
                try {
                  com.ss.android.downloadlib.a.a(jSONObject, paramc.g());
                  com.ss.android.downloadlib.a.a(jSONObject, paramc);
                } finally {} 
              str = g.a(new String[] { a1.c.h(), "click_install" });
            } 
          } else {
            str = g.a(new String[] { a1.c.g(), "click_continue" });
          } 
        } else {
          str = g.a(new String[] { a1.c.f(), "click_pause" });
        } 
      } else {
        String str1 = g.a(new String[] { a1.c.e(), "click_start" });
        a((c)str, jSONObject);
        str = str1;
      } 
    } else {
      str = g.a(new String[] { a1.c.i(), "storage_deny" });
    } 
    a(a1.c.b(), str, jSONObject, a1.b.e(), 1, a1.b, a1.c);
  }
  
  public void a(long paramLong, com.ss.android.socialbase.downloader.e.a parama) {
    c.a a1 = c.a().e(paramLong);
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("download_time", Integer.valueOf(0));
      if (parama != null) {
        jSONObject.putOpt("fail_status", Integer.valueOf(parama.a()));
        jSONObject.putOpt("fail_msg", parama.b());
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    a(a1.c.b(), "download_failed", jSONObject, a1.b, a1.c);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt) {
    String str;
    c.a a1 = c.a().e(paramLong);
    if (a1.a()) {
      g.b();
      return;
    } 
    if (a1.b.y() == null)
      return; 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("click_type", Integer.valueOf(paramInt));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    if (paramBoolean) {
      str = "deeplink_quickapp_success";
    } else {
      str = "deeplink_quickapp_failed";
    } 
    a(a1.c.b(), str, jSONObject, a1.b, a1.c);
  }
  
  public void a(c paramc, com.ss.android.socialbase.downloader.e.a parama) {
    if (paramc == null)
      return; 
    com.ss.android.downloadad.a.b.a a1 = c.a().a(paramc);
    if (a1 == null) {
      g.b();
      return;
    } 
    if (a1.a.get())
      return; 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.putOpt("download_time", Long.valueOf(paramc.aw()));
      if (parama != null) {
        jSONObject.putOpt("fail_status", Integer.valueOf(parama.a()));
        jSONObject.putOpt("fail_msg", parama.b());
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    com.ss.android.downloadlib.a.a(jSONObject, paramc, true);
    a(a1.o(), "download_failed", jSONObject, a1);
  }
  
  public void a(c paramc, JSONObject paramJSONObject) {
    if (paramc != null)
      try {
        paramJSONObject.put("total_bytes", paramc.ab());
        paramJSONObject.put("chunk_count", paramc.aV());
        paramJSONObject.put("app_name", paramc.i());
        paramJSONObject.put("network_quality", paramc.ad());
        paramJSONObject.put("save_path", paramc.k());
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void a(String paramString, int paramInt, c.a parama) {
    a(parama.c.b(), paramString, null, paramInt, 2, parama.b, parama.c);
  }
  
  public void a(String paramString, long paramLong) {
    com.ss.android.downloadad.a.b.a a1 = c.a().d(paramLong);
    if (a1 == null) {
      g.b();
      return;
    } 
    b(a1.o(), paramString, null, a1);
  }
  
  public void a(String paramString, c paramc, b paramb) {
    a(paramb.b(), paramString, paramc.w(), paramc, paramb);
  }
  
  public void a(String paramString, com.ss.android.downloadad.a.b.a parama) {
    if (parama == null) {
      g.b();
      return;
    } 
    b(parama.o(), paramString, null, parama);
  }
  
  public void a(String paramString, c.a parama) {
    a(parama.c.b(), paramString, parama.b.w(), parama.b, parama.c);
  }
  
  public void a(String paramString1, String paramString2, com.ss.android.downloadad.a.b.a parama) {
    if (parama == null) {
      g.b();
      return;
    } 
    b(paramString1, paramString2, null, parama);
  }
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject, com.ss.android.downloadad.a.b.a parama) {
    b(paramString1, paramString2, paramJSONObject, parama);
  }
  
  public void a(String paramString, JSONObject paramJSONObject, com.ss.android.downloadad.a.b.a parama) {
    if (parama == null) {
      g.b();
      return;
    } 
    b("embeded_ad", paramString, paramJSONObject, parama);
  }
  
  public void a(JSONObject paramJSONObject, com.ss.android.downloadad.a.b.a parama) {
    b(parama.o(), "download_finish", paramJSONObject, parama);
  }
  
  public void b(long paramLong, int paramInt) {
    a(paramLong, paramInt, (c)null);
  }
  
  public void b(JSONObject paramJSONObject, com.ss.android.downloadad.a.b.a parama) {
    b(parama.o(), "install_finish", paramJSONObject, parama);
  }
  
  static class a {
    private static a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */