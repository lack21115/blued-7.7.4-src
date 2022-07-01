package com.amap.api.mapcore2d;

import java.util.HashMap;
import java.util.Map;

@Deprecated
class dc extends ew {
  private Map<String, String> a = new HashMap<String, String>();
  
  private String b;
  
  private Map<String, String> f = new HashMap<String, String>();
  
  void a(String paramString) {
    this.b = paramString;
  }
  
  void a(Map<String, String> paramMap) {
    this.a.clear();
    this.a.putAll(paramMap);
  }
  
  void b(Map<String, String> paramMap) {
    this.f.clear();
    this.f.putAll(paramMap);
  }
  
  public Map<String, String> f() {
    return this.a;
  }
  
  public Map<String, String> g() {
    return this.f;
  }
  
  public String h() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */