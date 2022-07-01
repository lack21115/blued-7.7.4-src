package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.ad.a;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.h;
import com.qq.e.comm.plugin.c.a.c;
import com.qq.e.comm.plugin.intersitial2.fullscreen.a.a;
import com.qq.e.comm.plugin.intersitial2.fullscreen.a.b;
import com.qq.e.comm.plugin.n.a;
import com.qq.e.comm.plugin.n.b;
import com.qq.e.comm.plugin.n.d;
import com.qq.e.comm.plugin.n.f;
import com.qq.e.comm.plugin.n.g;
import com.qq.e.comm.plugin.n.h;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.util.v;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements ACTD, b.a, b.a, f.a {
  private Activity a;
  
  private boolean b;
  
  private c c;
  
  private ViewGroup d;
  
  private a e;
  
  private g f;
  
  private h g;
  
  private boolean h;
  
  private boolean i;
  
  private boolean j;
  
  private g k;
  
  private c l = new c();
  
  private c m;
  
  public e(Activity paramActivity) {
    this.a = paramActivity;
  }
  
  private void a(int paramInt, String paramString) {
    b.a(this.c, (View)this.d, paramInt, paramString, this.m);
    InterstitialFSEventCenter.a().a(this.c.m(), 10003, null);
  }
  
  private int l() {
    return !this.c.k() ? 1 : (q.a(this.c) ? 2 : 0);
  }
  
  private void m() {
    InterstitialFSEventCenter.a().a(this.c.m(), 10004, null);
    Activity activity = this.a;
    if (activity != null && !activity.isFinishing())
      this.a.finish(); 
  }
  
  private void n() {
    a a2 = this.e;
    if (a2 != null)
      a2.e(); 
    h h1 = this.g;
    if (h1 != null) {
      if (!this.h)
        h1.a(this.c.h()); 
      this.g.b();
    } 
    a a1 = this.e;
    if (a1 != null)
      a1.b(this.d); 
    g g1 = this.f;
    if (g1 != null)
      g1.a(this.d); 
    this.i = true;
  }
  
  private String o() {
    boolean bool;
    String str;
    this.k.a().a(this.d.getHeight());
    this.k.a().b(this.d.getWidth());
    h h1 = this.k.a();
    a a1 = this.e;
    if (a1 != null && a1.f()) {
      bool = true;
    } else {
      bool = false;
    } 
    h1.b(bool);
    this.k.a().c(1);
    c c1 = this.c;
    if (c1 != null) {
      str = c1.x();
    } else {
      str = "-999";
    } 
    this.k.a().b(str);
    try {
      return this.k.b();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return null;
    } 
  }
  
  public void a() {
    boolean bool;
    if (q.a(this.c)) {
      bool = true;
    } else {
      bool = true;
    } 
    v.a(true, this.l);
    this.k.b(System.currentTimeMillis());
    String str = o();
    try {
      JSONObject jSONObject = new JSONObject(str);
      jSONObject.put("click_area", String.valueOf(bool));
      int i = 0;
      if (this.e != null)
        i = this.e.b().f(); 
      jSONObject.put("p", String.valueOf(i));
      String str1 = jSONObject.toString();
      str = str1;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    a(bool, str);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    c c1 = this.l;
    int i = 0;
    v.b(false, c1);
    int j = l();
    byte b = 2;
    if (j == 2)
      u.a(1140003, 0, this.l); 
    if (paramBoolean) {
      b = 10;
    } else if (!this.h) {
      b = 4;
    } 
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      jSONObject.put("click_area", String.valueOf(b));
      if (this.e != null)
        i = this.e.b().e(); 
      jSONObject.put("p", String.valueOf(i));
      String str2 = this.c.E().optString("template_id");
      jSONObject.put("vp", String.valueOf(1));
      jSONObject.put("sz", "-999");
      jSONObject.put("tid", str2);
      String str1 = jSONObject.toString();
      paramString = str1;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    a(b, g.a(paramString));
  }
  
  public void a(boolean paramBoolean, int paramInt, Exception paramException) {
    b.a(this.c, this.e, this.b, 2);
    if (paramBoolean) {
      v.a(com.qq.e.comm.plugin.ad.e.v, false, this.l, paramInt, paramException);
    } else {
      v.a(com.qq.e.comm.plugin.ad.e.v, this.l, this.c.g(), paramInt, paramException);
    } 
    n();
  }
  
  public void b() {
    m();
    v.b(true, this.l);
  }
  
  public a c() {
    return this.c;
  }
  
  public void d() {
    GDTLogger.d("onVideoLoaded");
  }
  
  public void e() {
    ac.a(this.c.j());
    v.a(com.qq.e.comm.plugin.ad.e.v, true, this.l, 0, null);
  }
  
  public void f() {
    v.a(this.l);
    b.a(this.c, this.e, this.b, 0);
    n();
  }
  
  public void g() {
    g g1 = this.f;
    if (g1 != null) {
      g1.a();
      v.a(false, this.l);
    } 
  }
  
  public void h() {
    a a1 = this.e;
    if (a1 != null) {
      b.a(this.c, a1, this.b, 0);
      n();
    } 
  }
  
  public void i() {
    this.k.b(System.currentTimeMillis());
    String str = o();
    try {
      JSONObject jSONObject = new JSONObject(str);
      jSONObject.put("click_area", String.valueOf(3));
      int i = 0;
      if (this.e != null)
        i = this.e.b().f(); 
      jSONObject.put("p", String.valueOf(i));
      String str1 = jSONObject.toString();
      str = str1;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    a(3, str);
  }
  
  public void j() {
    this.k.b(System.currentTimeMillis());
    String str = o();
    try {
      JSONObject jSONObject = new JSONObject(str);
      jSONObject.put("click_area", String.valueOf(11));
      int i = 0;
      if (this.e != null)
        i = this.e.b().f(); 
      jSONObject.put("p", String.valueOf(i));
      String str1 = jSONObject.toString();
      str = str1;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    a(11, str);
  }
  
  public boolean k() {
    return this.j;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAfterCreate(Bundle paramBundle) {
    char c1;
    String str1 = this.a.getIntent().getStringExtra("adinfo");
    String str2 = this.a.getIntent().getStringExtra("appid");
    String str3 = this.a.getIntent().getStringExtra("adThreadId");
    String str4 = this.a.getIntent().getStringExtra("posId");
    this.l.a(str4);
    com.qq.e.comm.plugin.ad.e e1 = com.qq.e.comm.plugin.ad.e.v;
    if (!TextUtils.isEmpty(str1)) {
      this.c = new c(str1, str2, str4, str3);
      this.c.a(com.qq.e.comm.plugin.ad.e.v);
      this.l.b(this.c.f()).c(this.c.H());
      if (TextUtils.isEmpty(this.c.g())) {
        c1 = '᎜';
      } else {
        this.d = (ViewGroup)new RelativeLayout((Context)this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.k = new g();
        this.e = (a)new b(this.a, this.c, this.b, this.k, this.l);
        this.e.a(this);
        this.e.a(this.c.g());
        this.e.a(this.d);
        this.f = a.a((Context)this.a, this.c, this.l);
        g g1 = this.f;
        if (g1 != null) {
          g1.a(this);
          this.f.a(this.k);
          this.f.a(this.d, this.b);
        } 
        boolean bool = this.c.k();
        this.g = d.a((Context)this.a, this.c, this.k, "Interstitial", l(), this.l);
        this.g.a(this);
        if (bool) {
          this.h = true;
          this.g.a(this.c.h());
        } 
        this.g.a(this.d);
        this.g.a();
        this.m = new c((Context)this.a);
        this.a.setContentView((View)this.d);
        a.a().a((View)this.d);
        this.d.post(new Runnable(this) {
              public void run() {
                InterstitialFSEventCenter.a().a(e.a(this.a).m(), 10002, null);
                e.b(this.a).a().c(1);
                e.b(this.a).a(System.currentTimeMillis());
                v.a(null, e.c(this.a), 0, null);
                b.a(e.a(this.a), (View)e.d(this.a), e.b(this.a), new d.b(this) {
                      public void a() {
                        v.a(Boolean.valueOf(true), e.c(this.a.a), 0, null);
                      }
                      
                      public void a(int param2Int, Exception param2Exception) {
                        v.a(Boolean.valueOf(false), e.c(this.a.a), param2Int, param2Exception);
                      }
                    });
              }
            });
        InterstitialFSEventCenter.a().a(this.c.m(), 10001, null);
        return;
      } 
    } else {
      GDTLogger.e("InterstitialFSActivityDelegate onAfterCreate adData null");
      c1 = 'ྮ';
    } 
    v.a(e1, true, c1, this.l);
    this.a.finish();
  }
  
  public void onBackPressed() {
    if (this.i) {
      b();
      return;
    } 
    a a1 = this.e;
    if (a1 != null)
      a1.g(); 
  }
  
  public void onBeforeCreate(Bundle paramBundle) {
    this.b = "l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation());
    this.a.requestWindowFeature(1);
    this.a.getWindow().setFlags(1024, 1024);
    this.a.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(-16777216));
    this.a.getWindow().setFlags(16777216, 16777216);
    this.a.getWindow().setFlags(128, 128);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy() {
    a a1 = this.e;
    if (a1 != null)
      a1.h(); 
    g g1 = this.f;
    if (g1 != null)
      g1.c(); 
    h h1 = this.g;
    if (h1 != null)
      h1.c(); 
    InterstitialFSEventCenter.a().a(this.c.m());
  }
  
  public void onPause() {
    this.j = false;
    if (!this.i) {
      a a1 = this.e;
      if (a1 != null)
        a1.c(); 
    } 
    if (this.c != null && this.e != null && !this.i) {
      Activity activity = this.a;
      if (activity != null && !activity.isFinishing())
        b.a(this.c, this.e, this.b, 0); 
    } 
  }
  
  public void onResume() {
    this.j = true;
    if (!this.i) {
      a a1 = this.e;
      if (a1 != null)
        a1.d(); 
    } 
  }
  
  public void onStop() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\fullscreen\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */