package com.ss.android.downloadlib.c;

import android.content.Context;
import com.ss.android.downloadad.a.b.a;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.c;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.d.a;
import com.ss.android.downloadlib.e.g;
import com.ss.android.downloadlib.g;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import org.json.JSONObject;

public class b implements d {
  private Context a;
  
  public b(Context paramContext) {
    this.a = paramContext.getApplicationContext();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong) {
    Context context = this.a;
    if (context == null)
      return; 
    c c = f.a(context).h(paramInt1);
    if (c != null) {
      JSONObject jSONObject;
      if (c.q() == 0)
        return; 
      a a = c.a().a(c);
      if (a == null) {
        g.b();
        return;
      } 
      if (paramInt2 != 1) {
        if (paramInt2 != 3) {
          if (paramInt2 != 5) {
            if (paramInt2 != 6) {
              if (paramInt2 != 7)
                return; 
              a.a().a("download_notification", "download_notification_click", a);
              return;
            } 
            a.a().a("download_notification", "download_notification_continue", a);
            return;
          } 
          a.a().a("download_notification", "download_notification_pause", a);
          return;
        } 
        jSONObject = a.a(new JSONObject(), c);
        a.a().a("download_notification", "download_notification_install", jSONObject, a);
        return;
      } 
      a.a((c)jSONObject, a);
      if ("application/vnd.android.package-archive".equals(jSONObject.ah()))
        com.ss.android.downloadlib.a.b.a().a((c)jSONObject, a.a(), a.b(), a.d(), jSONObject.i(), a.f(), jSONObject.n()); 
    } 
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {
    Context context = this.a;
    if (context == null)
      return; 
    c c = f.a(context).h(paramInt1);
    if (c != null) {
      if (c.q() != -3)
        return; 
      c.d(paramString2);
      c.a().a(this.a, c);
    } 
  }
  
  public void a(Context paramContext, String paramString) {
    a.a().a(paramString);
  }
  
  public void a(c paramc) {
    if (paramc == null)
      return; 
    g.a().a(paramc);
    a.a().a(paramc, new a(1012, ""));
  }
  
  public boolean a() {
    return c.a().b();
  }
  
  public boolean a(int paramInt, boolean paramBoolean) {
    return (j.n() != null) ? j.n().a(paramBoolean) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */