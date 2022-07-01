package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bytedance.tea.crash.d;
import java.util.HashMap;
import java.util.Map;

public class a {
  private Context a;
  
  private d b;
  
  private Map<String, Object> c;
  
  public a(Context paramContext, d paramd) {
    this.a = paramContext;
    this.b = paramd;
  }
  
  public static boolean a(Map<String, Object> paramMap) {
    return (paramMap == null || paramMap.isEmpty() || (!paramMap.containsKey("app_version") && !paramMap.containsKey("version_name")) || !paramMap.containsKey("version_code") || !paramMap.containsKey("update_version_code"));
  }
  
  public Map<String, Object> a() {
    Map<Object, Object> map1 = this.b.a();
    Map<Object, Object> map2 = map1;
    if (map1 == null)
      map2 = new HashMap<Object, Object>(4); 
    if (a((Map)map2))
      try {
        PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 128);
      } finally {
        map1 = null;
        map2.put("version_name", com.bytedance.tea.crash.g.a.e(this.a));
        map2.put("version_code", Integer.valueOf(com.bytedance.tea.crash.g.a.f(this.a)));
      }  
    return (Map)map2;
  }
  
  public Map<String, Object> b() {
    if (this.c == null)
      this.c = this.b.g(); 
    return this.c;
  }
  
  public d c() {
    return this.b;
  }
  
  public String d() {
    return com.bytedance.tea.crash.g.a.d(this.a);
  }
  
  public String e() {
    return this.b.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */