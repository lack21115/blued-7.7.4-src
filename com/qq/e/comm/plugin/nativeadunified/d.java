package com.qq.e.comm.plugin.nativeadunified;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ab.d.e;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.c.e;
import com.qq.e.comm.plugin.gdtnativead.a.b;
import com.qq.e.comm.plugin.gdtnativead.a.c;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.g;
import com.qq.e.comm.plugin.util.j;
import com.qq.e.comm.plugin.util.n;
import com.qq.e.comm.plugin.util.u;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.w.a.h;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class d implements ACTD, b.a {
  private final String a = getClass().getSimpleName();
  
  private Activity b;
  
  private FrameLayout c;
  
  private f d;
  
  private MediaView e;
  
  private com.qq.e.comm.plugin.ac.a f;
  
  private c g;
  
  private FrameLayout.LayoutParams h;
  
  private FrameLayout.LayoutParams i;
  
  private g j;
  
  private boolean k;
  
  private boolean l;
  
  private com.qq.e.comm.plugin.ab.d.a m;
  
  private b n;
  
  private com.qq.e.comm.plugin.gdtnativead.a.a o;
  
  private boolean p;
  
  private String q;
  
  private b r;
  
  private com.qq.e.comm.plugin.s.a s;
  
  private a t = new a();
  
  private boolean u;
  
  private int v;
  
  private b w = new b();
  
  private c x = new c();
  
  private boolean y = false;
  
  public d(Activity paramActivity) {
    this.b = paramActivity;
  }
  
  private void a() {
    FrameLayout frameLayout = new FrameLayout((Context)this.b);
    frameLayout.setBackgroundColor(-16777216);
    TextView textView = new TextView((Context)this.b);
    textView.setTextColor(-65536);
    textView.setText("未知错误，请稍后再试");
    textView.setTextSize(24.0F);
    textView.setGravity(17);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    frameLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    this.b.setContentView((View)frameLayout);
    this.b.setRequestedOrientation(1);
    JSONObject jSONObject = n.a((Context)this.b, this.r);
    u.a(30292, 5, this.x, new com.qq.e.comm.plugin.y.d(jSONObject));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("after: ");
    stringBuilder.append(jSONObject.toString());
    GDTLogger.i(stringBuilder.toString());
  }
  
  private void a(int paramInt) {
    if (this.n == null) {
      this.n = new b((Context)this.b, this.s.z(), this.s.E());
      this.n.a(this);
    } 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.topMargin = paramInt;
    this.c.addView((View)this.n, (ViewGroup.LayoutParams)layoutParams);
    if (f())
      c(true); 
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean) {
    if (this.m == null)
      this.m = (new e((Context)this.b, this.s.E())).a(); 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.topMargin = paramInt;
    this.c.addView(this.m.b(), (ViewGroup.LayoutParams)layoutParams);
    if (this.u) {
      b(paramString);
      return;
    } 
    a(paramString, paramBoolean);
  }
  
  private void a(MotionEvent paramMotionEvent) {
    this.j.a((View)this.c, paramMotionEvent, false);
  }
  
  private void a(String paramString, boolean paramBoolean) {
    if (paramString == null)
      return; 
    String str1 = paramString;
    if (f())
      str1 = bb.c(paramString, "_autodownload", "1"); 
    if (!paramBoolean) {
      this.s.X();
      this.s.Y();
      this.m.a(str1);
      c(str1);
      return;
    } 
    String str2 = h.a(str1);
    paramString = null;
    if (this.s.z() != null)
      paramString = this.s.z().d(); 
    com.qq.e.comm.plugin.w.a.d.a(str2, this.s, new j<Pair<Integer, JSONObject>>(this, paramString, str1) {
          public void a(Pair<Integer, JSONObject> param1Pair) {
            if (d.h(this.c) == null)
              return; 
            if (param1Pair != null && param1Pair.second != null) {
              String str2 = ((JSONObject)param1Pair.second).optString("clickid");
              com.qq.e.comm.plugin.w.a.a(str2);
              com.qq.e.comm.plugin.w.a.a(this.a, str2);
              String str1 = ((JSONObject)param1Pair.second).optString("dstlink");
              if (!TextUtils.isEmpty(str1)) {
                d.a(this.c, str1);
                return;
              } 
            } 
            d.a(this.c, this.b);
            u.a(30252, 0, d.i(this.c));
          }
        });
    c(str2);
  }
  
  private void a(boolean paramBoolean) {
    byte b1;
    MediaView mediaView = this.e;
    if (mediaView == null)
      return; 
    if (paramBoolean) {
      mediaView.setLayoutParams((ViewGroup.LayoutParams)this.i);
      b1 = 4;
    } else {
      mediaView.setLayoutParams((ViewGroup.LayoutParams)this.h);
      b1 = 3;
    } 
    b(b1);
    this.e.bringToFront();
  }
  
  private void a(boolean paramBoolean, String paramString) {
    String str1;
    String str2 = paramString;
    if (StringUtil.isEmpty(paramString))
      str2 = g(); 
    if (this.e != null) {
      c c1 = this.g;
      if (c1 != null && c1.getParent() == null)
        this.g.setVisibility(0); 
    } 
    int i = (int)(Math.min(am.b((Context)this.b), am.c((Context)this.b)) * 0.5625F);
    if (this.s.v()) {
      if (this.s.w()) {
        if (this.u) {
          paramString = this.q;
        } else {
          paramString = com.qq.e.comm.plugin.w.a.d.a(null, this.s.E(), str2, this.r.i());
        } 
        a(i, paramString, paramBoolean);
        return;
      } 
      if (this.p) {
        l();
        k();
        return;
      } 
      a(i);
      return;
    } 
    if (this.u) {
      str1 = this.q;
    } else {
      str1 = this.s.s();
    } 
    paramString = str1;
    if (!TextUtils.isEmpty(str1)) {
      paramString = str1;
      if (!this.u) {
        str1 = bb.a(str1, "s", str2);
        paramString = str1;
        if (u.a(str1)) {
          ak.b("gdt_tag_p", "get P in addFullscreenViews , url = %s", new Object[] { str1 });
          paramString = u.a(str1, g.a(str2, this.r.i(), "click"));
        } 
      } 
    } 
    a(i, paramString, paramBoolean);
  }
  
  private void b() {
    FrameLayout.LayoutParams layoutParams2;
    this.e = new MediaView((Context)this.b);
    this.e.setBackgroundColor(-16777216);
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (d.a(this.a) != null)
              d.a(this.a).n(); 
          }
        });
    this.i = new FrameLayout.LayoutParams(-1, -1);
    this.c.addView((View)this.e, (ViewGroup.LayoutParams)this.i);
    if (this.p) {
      layoutParams2 = new FrameLayout.LayoutParams(-1, Math.min(am.c((Context)this.b), am.b((Context)this.b) * this.s.Q() / this.s.P()), 17);
    } else {
      layoutParams2 = new FrameLayout.LayoutParams(-1, (int)(Math.min(am.c((Context)this.b), am.b((Context)this.b)) * 0.5625F));
    } 
    this.h = layoutParams2;
    this.e.post(new Runnable(this) {
          public void run() {
            if (d.b(this.a) == 3)
              d.d(this.a).setLayoutParams((ViewGroup.LayoutParams)d.c(this.a)); 
          }
        });
    this.d = c.b();
    com.qq.e.comm.plugin.aa.b.b b1 = c.c();
    if (b1 != null && b1 instanceof c) {
      this.g = (c)b1;
      b(3);
    } 
    f f1 = this.d;
    if (f1 == null || this.g == null) {
      GDTLogger.e("NativeUnifiedADController don't provide necessary widget");
      u.a(30242, 0, this.x);
      j();
      return;
    } 
    ViewParent viewParent = f1.getParent();
    if (viewParent != null)
      ((ViewGroup)viewParent).removeView((View)this.d); 
    viewParent = this.g.getParent();
    if (viewParent != null)
      ((ViewGroup)viewParent).removeView((View)this.g); 
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    layoutParams1.gravity = 17;
    this.e.addView((View)this.d, 0, (ViewGroup.LayoutParams)layoutParams1);
    this.e.addView((View)this.g, 1, (ViewGroup.LayoutParams)layoutParams1);
    if (this.p) {
      boolean bool;
      c c1 = this.g;
      if (this.d.getWidth() < this.d.getHeight()) {
        bool = true;
      } else {
        bool = false;
      } 
      c1.e(bool);
      com.qq.e.comm.plugin.aa.b.a.a((ViewGroup)this.c, this.s.o(), this.d, -872415232, true);
      this.g.a();
    } else {
      com.qq.e.comm.plugin.aa.b.a.a((ViewGroup)this.e, this.s.o(), this.d);
      this.g.c(false);
    } 
    if (this.y) {
      this.d.h();
    } else {
      this.d.i();
    } 
    this.d.b(false);
    if (!this.d.c()) {
      c();
      return;
    } 
  }
  
  private void b(int paramInt) {
    this.v = paramInt;
    this.r.a(this.v);
    c c1 = this.g;
    if (c1 != null) {
      c1.a(paramInt);
      this.g.g();
      this.g.f();
    } 
  }
  
  private void b(String paramString) {
    y.a(new Runnable(this, paramString) {
          public void run() {
            if (d.g(this.b) != null)
              d.g(this.b).a(this.a); 
          }
        });
  }
  
  private void c() {
    b.d d1 = this.r.f();
    if (d1 == b.d.a || d1 == b.d.b) {
      d();
      c c1 = this.g;
      if (c1 != null)
        c1.d(); 
      this.r.a(new b.c(this) {
            public void a() {
              d.e(this.a).e_();
            }
            
            public void a(int param1Int) {
              Message message = Message.obtain();
              message.what = 1;
              message.arg1 = param1Int;
              d.f(this.a).sendMessage(message);
            }
            
            public void b() {}
          });
      if (d1 == b.d.a)
        this.r.a(false); 
      return;
    } 
    this.r.e_();
  }
  
  private void c(String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("code", "InnerBrowser");
    com.qq.e.comm.plugin.w.a.d.a(paramString, this.s.E(), c.f(), c.e(), hashMap);
  }
  
  private void d() {
    this.f = new com.qq.e.comm.plugin.ac.a(this.e.getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(am.a(this.e.getContext().getApplicationContext(), 46), am.a(this.e.getContext().getApplicationContext(), 46));
    layoutParams.gravity = 17;
    this.e.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NativeAdDetailPage stopVideo() mVideoView: ");
    stringBuilder.append(this.d);
    GDTLogger.d(stringBuilder.toString());
    this.r.a(b.b.c);
    f f1 = this.d;
    if (f1 != null)
      f1.a(); 
  }
  
  private boolean f() {
    return (this.s.v() && this.s.z() != null && com.qq.e.comm.plugin.a.e.b.a(this.s.z().h(), this.s.B()));
  }
  
  private String g() {
    this.j.a().b(this.c.getMeasuredWidth());
    this.j.a().a(this.c.getMeasuredHeight());
    String str = this.s.x();
    this.j.a().b(str);
    try {
      str = this.j.b();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("anti info:");
      stringBuilder.append(str);
      GDTLogger.d(stringBuilder.toString());
      return URLEncoder.encode(str, "UTF-8");
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get anti failed:");
      stringBuilder.append(exception);
      GDTLogger.w(stringBuilder.toString());
      return null;
    } 
  }
  
  private void h() {
    this.k = true;
    f f1 = this.d;
    if (f1 != null)
      f1.b(true); 
    if (this.p) {
      c c1 = this.g;
      if (c1 != null)
        c1.l(); 
    } 
  }
  
  private boolean i() {
    return "l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation());
  }
  
  private void j() {
    b b1 = this.r;
    if (b1 != null)
      b1.k(); 
    this.b.finish();
  }
  
  private void k() {
    Context context = this.c.getContext();
    ImageView imageView = new ImageView(context);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(am.a(context, 46), am.a(context, 14));
    layoutParams.gravity = 8388693;
    this.c.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
    g.a(imageView, this.s.C());
  }
  
  private void l() {
    if (this.o == null) {
      this.o = new com.qq.e.comm.plugin.gdtnativead.a.a((Context)this.b, this.s.z(), this.s);
      this.o.a(this);
      this.o.a(new com.qq.e.comm.plugin.gdtnativead.a.a.a(this) {
            public void a() {
              if (d.a(this.a) != null && d.a(this.a).c() && d.k(this.a) != null)
                d.k(this.a).d(); 
              d.l(this.a);
              GDTLogger.d("NativeAdDetailPageActivityDelegateWeb onCloseButtonClicked");
              d.m(this.a);
            }
            
            public void b() {
              d.k(this.a).k();
              d.t(this.a).postDelayed(new Runnable(this) {
                    public void run() {
                      if (d.t(this.a.a) != null && d.k(this.a.a) != null)
                        d.t(this.a.a).a(d.k(this.a.a).j()); 
                    }
                  },  50L);
            }
          });
    } 
    this.o.a(this.y);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.c.addView((View)this.o, (ViewGroup.LayoutParams)layoutParams);
    if (f())
      c(true); 
  }
  
  public c a(String paramString) {
    List list = l.a().d();
    if (list != null && list.size() > 0)
      for (c c1 : list) {
        if (c1.h().equals(paramString))
          return c1; 
      }  
    return null;
  }
  
  public void c(boolean paramBoolean) {
    if (this.r == null)
      return; 
    this.j.b(System.currentTimeMillis());
    if (this.u) {
      this.r.a((View)this.c, g(), paramBoolean);
      return;
    } 
    if (this.s.z() != null && this.s.z().h() == 4) {
      c c1 = a(this.s.z().d());
      if (c1 != null) {
        l.a().a(c1.m(), 1);
        return;
      } 
    } else if (this.s.z() != null && this.s.z().h() == 32) {
      c c1 = a(this.s.z().d());
      if (c1 != null) {
        l.a().a(c1.m());
        return;
      } 
    } else {
      this.r.a((View)this.c, 2, this.s.n(), this.s.B(), this.s.D(), g(), this.s.v(), paramBoolean);
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAfterCreate(Bundle paramBundle) {
    byte b1;
    if (this.r == null || this.s == null) {
      a();
      return;
    } 
    this.c = new FrameLayout(this, (Context)this.b) {
        public boolean dispatchTouchEvent(MotionEvent param1MotionEvent) {
          d.a(this.a, param1MotionEvent);
          return super.dispatchTouchEvent(param1MotionEvent);
        }
      };
    this.b.setContentView((View)this.c);
    Activity activity = this.b;
    boolean bool = true;
    activity.setRequestedOrientation(1);
    this.j = this.r.e();
    if (i()) {
      b1 = 4;
    } else {
      b1 = 3;
    } 
    this.v = b1;
    this.r.a(this.v);
    Intent intent = this.b.getIntent();
    String str = intent.getStringExtra("antiSpam");
    this.y = intent.getBooleanExtra("detailPageMuted", false);
    this.q = intent.getStringExtra("url");
    if (!this.s.v() || this.s.w() || !this.s.aa())
      bool = false; 
    this.p = bool;
    b();
    a(c.d(), str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NativeAdDetailPageActivityDelegate product type:");
    stringBuilder.append(this.s.a_());
    stringBuilder.append(" landding page:");
    stringBuilder.append(this.s.w());
    GDTLogger.d(stringBuilder.toString());
    if (!this.c.isHardwareAccelerated()) {
      GDTLogger.e("Hardware acceleration is off");
      u.a(30102, 2, this.x);
    } 
    this.r.a(this.t);
  }
  
  public void onBackPressed() {
    GDTLogger.d("NativeAdDetailPageActivityDelegate onBackPressed");
    if (i()) {
      this.b.setRequestedOrientation(1);
      return;
    } 
    GDTLogger.d("NativeAdDetailPageActivityDelegate onBackPressed");
    f f1 = this.d;
    if (f1 != null && f1.c()) {
      c c1 = this.g;
      if (c1 != null)
        c1.d(); 
    } 
    h();
    j();
  }
  
  public void onBeforeCreate(Bundle paramBundle) {
    StringBuilder stringBuilder;
    String str1;
    String str2;
    String str3;
    this.r = c.a();
    b b1 = this.r;
    if (b1 != null && b1.d() && Build.VERSION.SDK_INT >= 11)
      this.b.getWindow().setFlags(16777216, 16777216); 
    b1 = this.r;
    if (b1 == null) {
      GDTLogger.e("mAd is null, why??");
      JSONObject jSONObject = n.a((Context)this.b, this.r);
      u.a(30292, 2, this.x, new com.qq.e.comm.plugin.y.d(jSONObject));
      stringBuilder = new StringBuilder();
      str2 = "before: mAdController ";
    } else {
      StringBuilder stringBuilder1;
      this.s = stringBuilder.n();
      com.qq.e.comm.plugin.s.a a1 = this.s;
      if (a1 == null) {
        JSONObject jSONObject = n.a((Context)this.b, this.r);
        u.a(30292, 6, this.x, new com.qq.e.comm.plugin.y.d(jSONObject));
        stringBuilder1 = new StringBuilder();
        str2 = "before: mAdInfo ";
      } else {
        this.u = e.a((com.qq.e.comm.plugin.s.a)stringBuilder1);
        str1 = this.s.B();
        str2 = this.s.m();
        str3 = this.s.H();
        this.x.a(str1).c(str3).b(str2);
        u.a(30222, 1, this.x);
      } 
    } 
    str1.append(str2);
    str1.append(str3.toString());
    GDTLogger.i(str1.toString());
    u.a(30222, 1, this.x);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    a(i());
  }
  
  public void onDestroy() {
    if (this.r == null)
      return; 
    this.e.removeView((View)this.d);
    this.e.removeView((View)this.g);
    this.d = null;
    this.g = null;
    com.qq.e.comm.plugin.ab.d.a a1 = this.m;
    if (a1 != null) {
      a1.a();
      this.m = null;
    } 
    b b1 = this.n;
    if (b1 != null) {
      b1.removeAllViews();
      this.n = null;
    } 
    this.r.j();
    this.r.a((b.c)null);
    this.w.removeCallbacksAndMessages(null);
    u.a(30222, 2, this.x);
  }
  
  public void onPause() {
    this.l = false;
    if (this.r == null)
      return; 
    String str = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPause() MediaStatus: ");
    stringBuilder.append(this.r.h());
    ak.a(str, stringBuilder.toString());
    if (this.r.h() == b.b.b && !this.k)
      e(); 
  }
  
  public void onResume() {
    this.l = true;
    if (this.r != null) {
      if (this.s == null)
        return; 
      String str = this.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onResume: mediaStatus = ");
      stringBuilder.append(this.r.h());
      ak.a(str, stringBuilder.toString());
      if (this.r.h() == b.b.c) {
        this.r.e_();
        this.r.a(b.b.b);
      } 
      if (this.s.z() != null) {
        Message message = Message.obtain();
        message.what = 3;
        message.arg1 = this.s.z().f();
        message.arg2 = this.s.z().h();
        this.w.sendMessage(message);
      } 
    } 
  }
  
  public void onStop() {}
  
  class a implements b.a {
    private a(d this$0) {}
    
    public void a() {
      boolean bool;
      Activity activity = d.j(this.a);
      if (d.b(this.a) == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      activity.setRequestedOrientation(bool);
      u.a(30262, d.b(this.a), d.i(this.a));
    }
    
    public void a(String param1String, int param1Int1, int param1Int2, long param1Long) {
      if ((param1Int1 == 4 && param1Int2 % 5 == 0) || param1Int1 != 4) {
        Message message = Message.obtain();
        message.what = 3;
        message.arg1 = param1Int2;
        message.arg2 = param1Int1;
        d.f(this.a).sendMessage(message);
      } 
    }
    
    public void b() {
      if (d.b(this.a) == 4) {
        d.j(this.a).setRequestedOrientation(1);
        return;
      } 
      if (d.a(this.a) != null && d.a(this.a).c() && d.k(this.a) != null)
        d.k(this.a).d(); 
      d.l(this.a);
      GDTLogger.d("NativeAdDetailPageActivityDelegate onCloseButtonClicked");
      d.m(this.a);
    }
    
    public void c() {}
    
    public void d() {
      String str = d.n(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onVideoPlaying: isResume = ");
      stringBuilder.append(d.o(this.a));
      ak.a(str, stringBuilder.toString());
      if (!d.p(this.a) && !d.o(this.a))
        d.q(this.a); 
    }
  }
  
  class b extends Handler {
    private b(d this$0) {}
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          if (d.s(this.a) && d.t(this.a) != null) {
            d.t(this.a).a(param1Message.arg1, param1Message.arg2);
            return;
          } 
          if (d.u(this.a) != null) {
            d.u(this.a).a(param1Message.arg1, param1Message.arg2);
            return;
          } 
        } else {
          if (d.r(this.a) != null)
            d.r(this.a).setVisibility(8); 
          if (d.k(this.a) != null) {
            d.k(this.a).c();
            return;
          } 
        } 
      } else if (d.r(this.a) != null) {
        d.r(this.a).a(param1Message.arg1);
        if (param1Message.arg1 == 100)
          d.r(this.a).setVisibility(8); 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */