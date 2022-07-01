package com.bytedance.tea.crash.e.a;

import android.content.Context;
import android.os.Process;
import com.bytedance.tea.crash.a;
import com.bytedance.tea.crash.c.a;
import com.bytedance.tea.crash.d;
import com.bytedance.tea.crash.e.e;
import com.bytedance.tea.crash.g.a;
import com.bytedance.tea.crash.g.n;
import com.bytedance.tea.crash.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public abstract class c {
  protected com.bytedance.tea.crash.c a;
  
  protected Context b;
  
  protected d c;
  
  protected b d;
  
  protected d e;
  
  c(com.bytedance.tea.crash.c paramc, Context paramContext, b paramb, d paramd) {
    this.a = paramc;
    this.b = paramContext;
    this.d = paramb;
    this.e = paramd;
    this.c = h.a().c();
  }
  
  private void e(a parama) {
    List list = h.b().a(this.a);
    if (list != null) {
      JSONObject jSONObject = new JSONObject();
      Iterator<a> iterator = list.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map map = ((a)iterator.next()).a(this.a);
          if (map != null)
            try {
              for (String str : map.keySet())
                jSONObject.put(str, map.get(str)); 
            } finally {} 
          continue;
        } 
        parama.a("custom", jSONObject);
        return;
      } 
    } 
  }
  
  public a a(a parama) {
    a a1 = parama;
    if (parama == null)
      a1 = new a(); 
    b(a1);
    e(a1);
    return a1;
  }
  
  protected boolean a() {
    return true;
  }
  
  void b(a parama) {
    if (b()) {
      b b1 = this.d;
      if (b1 != null)
        parama.a(b1); 
    } 
    parama.a(h.f());
    parama.a("is_background", Boolean.valueOf(a.a(this.b) ^ true));
    parama.a("pid", Integer.valueOf(Process.myPid()));
    parama.a("battery", Integer.valueOf(this.e.a()));
    parama.a(this.c.e());
    parama.b(h.i());
    parama.a(h.j(), h.k());
    parama.a(this.c.f());
    parama.a(n.a(this.b));
    if (a())
      d(parama); 
    parama.a(this.c.d());
    String str = h.g();
    if (str != null)
      parama.a("business", str); 
    if (h.h())
      parama.a("is_mp", Integer.valueOf(1)); 
    parama.c(h.b().a());
    parama.a("crash_uuid", UUID.randomUUID().toString());
  }
  
  protected boolean b() {
    return true;
  }
  
  void c(a parama) {
    Map map = h.a().a();
    if (map == null)
      return; 
    if (map.containsKey("app_version"))
      parama.a("crash_version", map.get("app_version")); 
    if (map.containsKey("version_name"))
      parama.a("app_version", map.get("version_name")); 
    if (map.containsKey("version_code"))
      try {
        parama.a("crash_version_code", Integer.valueOf(Integer.parseInt(map.get("version_code").toString())));
      } catch (Exception exception) {
        parama.a("crash_version_code", map.get("version_code"));
      }  
    if (map.containsKey("update_version_code"))
      try {
        parama.a("crash_update_version_code", Integer.valueOf(Integer.parseInt(map.get("update_version_code").toString())));
        return;
      } catch (Exception exception) {
        parama.a("crash_update_version_code", map.get("update_version_code"));
      }  
  }
  
  protected void d(a parama) {
    parama.b(e.a(h.e().b(), h.e().c()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */