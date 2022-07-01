package com.bytedance.sdk.openadsdk.core.h;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a;
import com.bytedance.sdk.openadsdk.f.a.a;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.bytedance.sdk.openadsdk.utils.ad;
import org.json.JSONObject;

public class k implements e {
  private String a;
  
  private c b;
  
  private String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    long l = System.currentTimeMillis();
    d d2 = null;
    c c1 = this.b;
    d d1 = d2;
    if (c1 != null) {
      d1 = d2;
      if (c1.b != null)
        d1 = this.b.b.get(paramString); 
    } 
    if (d1 == null) {
      if (paramString.equals("is.snssdk.com"))
        h.a(this).a(); 
      return paramString;
    } 
    if (d1.d()) {
      h.a(this).a();
      return paramString;
    } 
    paramString = d1.e();
    if (TextUtils.isEmpty(paramString)) {
      h.a(this).a();
      return paramString;
    } 
    a(d1, System.currentTimeMillis() - l);
    return paramString;
  }
  
  private void a(d paramd, long paramLong) {
    if (paramd != null) {
      if (paramd.g())
        return; 
      if (TextUtils.isEmpty(paramd.a()))
        return; 
      paramd.a(true);
      a a = new a();
      a.a("dns_resolution_time");
      a.a("dns_host", paramd.a());
      a.a("dns_duration", Long.valueOf(paramLong));
      a.a().a((d)a);
    } 
  }
  
  private void c() {
    if (!TextUtils.isEmpty(this.a))
      try {
        this.b = c.a(new JSONObject(this.a));
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private void d() {
    if (b.b()) {
      if (!TextUtils.isEmpty(this.a))
        a.a("tt_dns_settings", "dnsinfo", this.a); 
      return;
    } 
    ad ad = e();
    if (!TextUtils.isEmpty(this.a))
      ad.a("dnsinfo", this.a); 
  }
  
  private ad e() {
    return ad.a("tt_dns_settings", o.a());
  }
  
  public void a() {
    if (b.b()) {
      this.a = a.b("tt_dns_settings", "dnsinfo", "");
      c();
      return;
    } 
    this.a = e().b("dnsinfo", "");
    c();
  }
  
  public void a(JSONObject paramJSONObject) {
    this.b = c.a(paramJSONObject);
    c c1 = this.b;
    if (c1 != null)
      this.a = c1.c().toString(); 
    d();
  }
  
  public void b() {
    e.a(o.a()).a(new o(this) {
          public String a(String param1String) {
            return k.a(this.a, param1String);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */