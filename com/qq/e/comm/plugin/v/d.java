package com.qq.e.comm.plugin.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.m.m;
import com.qq.e.comm.plugin.n.f;
import com.qq.e.comm.plugin.n.h;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.be;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.GDTLogger;

public class d implements ACTD, m {
  private f a;
  
  private Activity b;
  
  private i c;
  
  private e d;
  
  private View e;
  
  private FrameLayout f;
  
  private h g;
  
  private volatile boolean h;
  
  private volatile boolean i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private c m = new c();
  
  public d(Activity paramActivity) {
    this.b = paramActivity;
  }
  
  private void a() {
    if (this.h)
      return; 
    this.e = this.c.getAdView();
    this.c.a(this);
    View view = this.e;
    if (view != null) {
      be.a(view);
      this.f.addView(this.e);
    } 
  }
  
  private boolean a(Object paramObject, String paramString) {
    if (paramObject == null) {
      paramObject = new StringBuilder();
      paramObject.append("RewardPage activity fail to create ! miss ");
      paramObject.append(paramString);
      GDTLogger.e(paramObject.toString());
      this.b.finish();
      return true;
    } 
    return false;
  }
  
  private void b() {
    g g = this.c.e();
    g.a(System.currentTimeMillis());
    g.a(1);
    Activity activity = this.b;
    e e1 = this.d;
    this.g = com.qq.e.comm.plugin.n.d.a((Context)activity, (a)e1, g, "Reward", n.a((a)e1, e1.k_()), this.m);
    this.g.a(new f.a(this) {
          public void a(String param1String, boolean param1Boolean) {
            d.g(this.a).a(param1String, param1Boolean, (View)d.f(this.a));
          }
          
          public void b() {
            d.d(this.a).b();
            if (!d.b(this.a).isFinishing())
              d.b(this.a).finish(); 
          }
          
          public a c() {
            return (a)d.e(this.a);
          }
        });
    if (this.d.k_())
      c(); 
    this.g.a();
    this.g.a((ViewGroup)this.f);
  }
  
  private void c() {
    this.i = true;
    this.g.a(this.d.j());
  }
  
  private void d() {
    this.h = true;
    if (!this.d.k_())
      c(); 
    be.a(this.e);
    this.g.b();
  }
  
  public void a(int paramInt) {
    if (this.j == 1 && !this.i && n.a(paramInt, this.l, this.d.g(), this.k))
      c(); 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAfterCreate(Bundle paramBundle) {
    this.a = a.a(this.b.getIntent().getIntExtra("objectId", 0));
    if (a(this.a, "mAdImpl"))
      return; 
    this.c = this.a.d();
    if (!a(this.c, "mDataController")) {
      this.d = this.c.o();
      if (!a(this.d, "mAdData")) {
        this.f = new FrameLayout((Context)this.b);
        this.f.setBackgroundColor(-16777216);
        this.b.setContentView((View)this.f, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        this.a.a((View)this.f);
        this.a.a(new ADListener(this) {
              public void onADEvent(ADEvent param1ADEvent) {
                int i = param1ADEvent.getType();
                if (i != 206 && i != 207 && i != 901)
                  switch (i) {
                    default:
                      return;
                    case 105:
                      if (!d.b(this.a).isFinishing()) {
                        d.b(this.a).finish();
                        return;
                      } 
                      return;
                    case 103:
                      d.a(this.a);
                      return;
                    case 104:
                      break;
                  }  
                d.c(this.a);
              }
            });
        e e1 = this.d;
        this.j = n.a((a)e1, e1.k_());
        if (this.j == 1) {
          this.k = n.a(GDTADManager.getInstance().getSM());
          this.l = n.a(this.d.B());
        } 
        a();
        b();
        if (this.c.b() || this.a.c())
          d(); 
      } 
    } 
  }
  
  public void onBackPressed() {
    if (this.h)
      this.b.finish(); 
  }
  
  public void onBeforeCreate(Bundle paramBundle) {
    this.b.requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21)
      this.b.getWindow().setStatusBarColor(-16777216); 
    Window window = this.b.getWindow();
    window.setBackgroundDrawable((Drawable)new ColorDrawable(Color.parseColor("#E6000000")));
    window.setFlags(1024, 1024);
    window.setFlags(16777216, 16777216);
    window.setFlags(128, 128);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy() {
    i i1 = this.c;
    if (i1 != null) {
      i1.a((m)null);
      this.c.destroy();
    } 
    h h1 = this.g;
    if (h1 != null)
      h1.c(); 
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStop() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\v\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */