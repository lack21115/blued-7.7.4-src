package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import com.amap.api.maps2d.model.TileProvider;

class an extends ao {
  av a;
  
  public String b = "";
  
  public int c = 19;
  
  public int d = 3;
  
  public boolean e = true;
  
  public boolean f = false;
  
  public boolean g = false;
  
  public boolean h = true;
  
  public long i = 0L;
  
  public cb j = null;
  
  TileProvider k = null;
  
  public int l = -1;
  
  public String m = "";
  
  ba n = null;
  
  u o = null;
  
  bn<bs> p = null;
  
  private String r = "LayerPropertys";
  
  private boolean s = false;
  
  public an(av paramav) {
    this.a = paramav;
  }
  
  protected void a(Canvas paramCanvas) {
    try {
      if (this.p == null)
        return; 
    } finally {
      paramCanvas = null;
    } 
  }
  
  void a(boolean paramBoolean) {
    this.s = paramBoolean;
    if (paramBoolean) {
      this.q.d();
      return;
    } 
    this.n.c();
    this.q.c();
  }
  
  boolean a() {
    return this.s;
  }
  
  protected void b() {
    this.q.e();
    this.o.a((ba)null);
    this.n.c();
    this.p.clear();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof an))
      return false; 
    paramObject = paramObject;
    return this.b.equals(((an)paramObject).b);
  }
  
  public int hashCode() {
    return this.l;
  }
  
  public String toString() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */