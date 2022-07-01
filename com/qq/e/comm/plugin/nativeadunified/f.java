package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.view.View;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.c.e;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.w.a.c;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.a.i;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;

class f implements View.OnClickListener {
  private h a;
  
  private g b;
  
  private com.qq.e.comm.plugin.c.a.a c;
  
  private c d;
  
  private Context e;
  
  private boolean f;
  
  public f(g paramg, h paramh, com.qq.e.comm.plugin.c.a.a parama, Context paramContext, c paramc) {
    this(paramg, paramh, parama, paramContext, paramc, false);
  }
  
  public f(g paramg, h paramh, com.qq.e.comm.plugin.c.a.a parama, Context paramContext, c paramc, boolean paramBoolean) {
    this.b = paramg;
    this.a = paramh;
    this.c = parama;
    this.d = paramc;
    this.e = paramContext;
    this.f = paramBoolean;
  }
  
  private a a() {
    if (this.b.i == 1 && b.a(this.a.a_())) {
      String str = b.e(this.a.E());
      if (bb.b(str)) {
        if (c.a(this.e.getApplicationContext(), this.a.al(), str, this.a.m(), null)) {
          if (!this.b.b) {
            g g1 = this.b;
            g1.a((View)g1.a);
          } 
          u.a(30212, 1, this.d);
          return a.c;
        } 
        u.a(30212, 2, this.d);
        return a.b;
      } 
    } 
    u.a(30212, 3, this.d);
    return a.a;
  }
  
  private void a(View paramView, int paramInt) {
    a(paramView, paramInt, -1);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2) {
    a(paramView, paramInt1, paramInt2, false);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    g g1 = this.b;
    g1.a(paramView, paramInt1, g1.getTitle(), this.b.p(), this.b.o(), this.b.m(), this.b.isAppAd(), paramInt2, false, paramBoolean);
  }
  
  private void a(View paramView, a parama) {
    this.b.a(2, new Object[] { "" });
    if (!this.b.b) {
      g g2 = this.b;
      g2.a((View)g2.a);
    } 
    d.a a1 = i.a(this.a);
    d.e e = new d.e(this.b.o(), e.l, this.b.p());
    g g1 = this.b;
    d.b b = g1.a(paramView, 0, g1.p(), this.b.m(), this.b.isAppAd(), -1, false);
    b.i = com.qq.e.comm.plugin.ad.a.a().b((View)this.b.a);
    if (!((Boolean)(i.a(paramView, a1, b, e, new i.a(this, parama) {
          public void a(String param1String, boolean param1Boolean) {
            if (this.a == f.a.b && param1Boolean)
              com.qq.e.comm.plugin.w.a.a(param1String); 
          }
        })).second).booleanValue())
      this.b.c(false); 
  }
  
  private void b(boolean paramBoolean) {
    e.a((new com.qq.e.comm.plugin.c.f.a(this.a, (View)this.b.a)).b(this.b.j).a(paramBoolean).a(this.b.m()).a(), this.c);
    this.b.a(2, new Object[] { "" });
  }
  
  private boolean b() {
    return this.a.ah();
  }
  
  private void c(boolean paramBoolean) {
    d(paramBoolean);
  }
  
  private void d(boolean paramBoolean) {
    boolean bool = b();
    if (bool && !paramBoolean && this.b.j) {
      MediaView mediaView;
      if (this.b.f == null || this.b.e == null) {
        GDTLogger.e("VideoView未初始化完成，不可点击");
        return;
      } 
      if (this.b.f.getVisibility() != 0)
        this.b.f.setVisibility(0); 
      int i = this.b.i;
      boolean bool1 = true;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0 && b.b(this.a)) {
        a((View)this.b.d, (a)null);
        return;
      } 
      a a1 = a();
      if (a1 == a.c) {
        a((View)this.b.d, 4);
        return;
      } 
      if (i != 0 && b.c(this.a)) {
        a((View)this.b.d, a1);
        return;
      } 
      if (i != 0 && this.b.isAppAd() && !this.a.w()) {
        if (a1 == a.b) {
          mediaView = this.b.d;
          i = 3;
        } else {
          mediaView = this.b.d;
          i = bool1;
        } 
        a((View)mediaView, i);
      } else {
        if (mediaView == a.b) {
          this.b.a(2, new Object[] { "" });
          this.b.c(true);
          return;
        } 
        this.b.a(2, new Object[] { "" });
      } 
      this.b.c(false);
      return;
    } 
    if (bool && !this.b.b)
      this.b.l(); 
    a((View)this.b.d, 0, -1, paramBoolean);
  }
  
  void a(boolean paramBoolean) {
    if (e.a(this.a)) {
      b(false);
      return;
    } 
    d(paramBoolean);
  }
  
  public void onClick(View paramView) {
    boolean bool;
    if (this.b.o != null && !this.b.o.a())
      return; 
    GDTLogger.d("report click event");
    g g1 = this.b;
    if (!g1.a((View)g1.a, paramView)) {
      u.a(30082, 0, this.d);
      GDTLogger.e("clicked view is not in NativeAdContainer");
      return;
    } 
    this.b.c.b(System.currentTimeMillis());
    if (this.b.t() && this.b.m) {
      if ((paramView == this.b.d || paramView == this.b.n) && this.b.k) {
        this.b.s();
        return;
      } 
      if (e.a(this.a)) {
        b(this.f);
      } else {
        c(this.f);
      } 
      bool = true;
    } else {
      if (e.a(this.a)) {
        b(this.f);
      } else {
        a(paramView, 0, -1, this.f);
      } 
      bool = true;
    } 
    u.a(30192, bool, this.d);
  }
  
  enum a {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */