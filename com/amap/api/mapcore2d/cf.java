package com.amap.api.mapcore2d;

import android.graphics.Point;
import android.view.animation.Animation;

class cf extends e {
  public float c = -1.0F;
  
  public boolean d = false;
  
  private Animation.AnimationListener e;
  
  private b f;
  
  private float g;
  
  private float h;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private boolean l;
  
  private boolean m = false;
  
  public cf(b paramb, Animation.AnimationListener paramAnimationListener, int paramInt) {
    super(i, 40);
    this.f = paramb;
    this.e = paramAnimationListener;
    this.a /= 2;
  }
  
  protected void a() {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean, float paramFloat3, float paramFloat4) {
    this.l = paramBoolean;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.i = paramFloat1;
    this.f.a.h.c = this.i;
    if (this.l) {
      this.k = this.f.a.h.c * this.b / this.a;
      this.j = this.i * 2.0F;
      return;
    } 
    this.k = this.f.a.h.c * 0.5F * this.b / this.a;
    this.j = this.i * 0.5F;
  }
  
  public void a(float paramFloat1, boolean paramBoolean, float paramFloat2, float paramFloat3) {
    this.f.c[0] = this.f.c[1];
    this.f.c[1] = paramFloat1;
    if (this.f.c[0] == this.f.c[1])
      return; 
    this.f.a().a(this.f.g());
    if (!f()) {
      if (this.a < 160)
        this.a = 160; 
      a(this.f.o(), paramFloat1, paramBoolean, paramFloat2, paramFloat3);
      (this.f.a()).e.a(true);
      (this.f.a()).e.b = true;
      this.e.onAnimationStart(null);
      d();
      return;
    } 
    this.m = true;
    e();
    a(this.j, paramFloat1, paramBoolean, paramFloat2, paramFloat3);
    (this.f.a()).e.a(true);
    (this.f.a()).e.b = true;
    this.e.onAnimationStart(null);
    d();
    this.m = false;
  }
  
  public void a(int paramInt) {
    this.a = paramInt / 2;
  }
  
  protected void b() {
    if (this.m)
      return; 
    try {
      if (this.f != null) {
        if (this.f.a() == null)
          return; 
        (this.f.a()).e.b = false;
        if (this.d == true) {
          Point point = new Point((int)this.g, (int)this.h);
          w w = this.f.d().a((int)this.g, (int)this.h);
          (this.f.a()).h.l = (this.f.a()).h.a(w);
          (this.f.a()).h.a(point);
          (this.f.a()).c.a(false, false);
        } 
        this.f.i().c(this.c);
        this.e.onAnimationEnd(null);
        if (this.d == true) {
          Point point = new Point((this.f.a()).c.c() / 2, (this.f.a()).c.d() / 2);
          w w = this.f.d().a((this.f.a()).c.c() / 2, (this.f.a()).c.d() / 2);
          (this.f.a()).h.l = (this.f.a()).h.a(w);
          (this.f.a()).h.a(point);
          (this.f.a()).c.a(false, false);
        } 
        this.f.a.h.c = 1.0F;
        bb.j = 1.0F;
        this.f.a().a(true);
        l.a().b();
      } else {
        return;
      } 
    } catch (Exception exception) {
      cm.a(exception, "ZoomCtlAnim", "onStop");
    } 
    this.a = 160;
  }
  
  protected void c() {
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */