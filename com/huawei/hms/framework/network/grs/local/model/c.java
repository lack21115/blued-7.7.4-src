package com.huawei.hms.framework.network.grs.local.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {
  private String a;
  
  private String b;
  
  private Map<String, d> c = new HashMap<String, d>(16);
  
  private List<b> d = new ArrayList<b>(16);
  
  public d a(String paramString) {
    return this.c.get(paramString);
  }
  
  public List<b> a() {
    return this.d;
  }
  
  public void a(String paramString, d paramd) {
    this.c.put(paramString, paramd);
  }
  
  public void a(List<b> paramList) {
    this.d = paramList;
  }
  
  public String b() {
    return this.a;
  }
  
  public void b(String paramString) {
    this.a = paramString;
  }
  
  public String c() {
    return this.b;
  }
  
  public void c(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\local\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */