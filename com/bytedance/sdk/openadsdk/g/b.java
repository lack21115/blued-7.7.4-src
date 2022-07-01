package com.bytedance.sdk.openadsdk.g;

import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.f.a;
import com.bytedance.sdk.openadsdk.f.a.d;

public class b implements d.d {
  private boolean a;
  
  private d b;
  
  public b(boolean paramBoolean) {
    this.a = paramBoolean;
    if (this.a)
      this.b = d.b(); 
  }
  
  public void a() {}
  
  public void a(int paramInt) {
    if (this.a) {
      d d1 = this.b;
      if (d1 == null)
        return; 
      d1.a(paramInt);
    } 
  }
  
  public void a(d.c paramc, boolean paramBoolean) {
    if (this.a) {
      if (this.b == null)
        return; 
      if (paramc == null || paramc.a() == null) {
        this.b.b(202).g(g.a(202));
        a.a().k(this.b);
      } 
    } 
  }
  
  public void a(n<Bitmap> paramn) {}
  
  public void a(String paramString) {
    if (this.a) {
      d d1 = this.b;
      if (d1 == null)
        return; 
      d1.c(paramString);
    } 
  }
  
  public void b() {}
  
  public void b(n<Bitmap> paramn) {
    if (this.a) {
      d d1 = this.b;
      if (d1 == null)
        return; 
      d1.b(201).g(g.a(201));
      a.a().k(this.b);
    } 
  }
  
  public void b(String paramString) {
    if (this.a) {
      d d1 = this.b;
      if (d1 == null)
        return; 
      d1.f(paramString);
    } 
  }
  
  public void c(String paramString) {
    if (this.a) {
      d d1 = this.b;
      if (d1 == null)
        return; 
      d1.d(paramString);
    } 
  }
  
  public void d(String paramString) {
    if (this.a) {
      d d1 = this.b;
      if (d1 == null)
        return; 
      d1.h(paramString);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */