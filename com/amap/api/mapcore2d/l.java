package com.amap.api.mapcore2d;

import java.util.ArrayList;

class l {
  private static l a = new l();
  
  private ArrayList<a> b = new ArrayList<a>();
  
  public static l a() {
    return a;
  }
  
  public void a(a parama) {
    if (parama != null)
      this.b.add(parama); 
  }
  
  public void b() {
    for (a a : this.b) {
      if (a != null)
        a.v(); 
    } 
  }
  
  public void b(a parama) {
    if (parama != null)
      this.b.remove(parama); 
  }
  
  public static interface a {
    void v();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */