package com.qq.e.comm.plugin.intersitial2.fullscreen.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ac.b;
import com.qq.e.comm.plugin.ac.k;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.intersitial2.fullscreen.InterstitialFSEventCenter;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import org.json.JSONObject;

public class b extends RelativeLayout implements View.OnClickListener, b.a, a {
  private static final int a = GDTADManager.getInstance().getSM().getInteger("ifsvmlt", 10000);
  
  private Activity b;
  
  private com.qq.e.comm.plugin.s.a c;
  
  private f d;
  
  private b e;
  
  private ImageView f;
  
  private ImageView g;
  
  private ImageView h;
  
  private com.qq.e.comm.plugin.ac.a i;
  
  private k j;
  
  private String k;
  
  private a l;
  
  private String m;
  
  private String n;
  
  private boolean o;
  
  private g p;
  
  private long q = GDTADManager.getInstance().getSM().getInteger("ifsvmpt", 5000);
  
  private boolean r = true;
  
  private long s;
  
  private int t;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private CountDownTimer w;
  
  private boolean x;
  
  private c y;
  
  private r z;
  
  public b(Activity paramActivity, com.qq.e.comm.plugin.s.a parama, boolean paramBoolean, g paramg, c paramc) {
    super((Context)paramActivity);
    this.b = paramActivity;
    this.z = new r((Context)this.b);
    this.c = parama;
    this.m = this.c.m();
    this.n = this.c.B();
    this.o = paramBoolean;
    this.p = paramg;
    this.y = paramc;
    j();
    k();
    l();
    m();
    n();
    o();
    setOnClickListener(this);
    int i = a;
    this.w = (new CountDownTimer(this, i, i) {
        public void onFinish() {
          GDTLogger.d("InterstitialFSVideoADView load video timeout");
          b.a(this.a, true);
          if (b.a(this.a) != null)
            b.a(this.a).a(false, 5046, null); 
        }
        
        public void onTick(long param1Long) {}
      }).start();
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.d.i();
      this.f.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAA51BMVEUAAAAAAAD///////9VVVUM\nDAzj4+MTExMeHh49PT339/f////////////////////////////+/v4SEhL5+fnt7e0aGhoEBAQs\nLCxQUFBkZGRycnJ4eHiLi4uioqKnp6e/v7/Z2dny8vL////////////////////////7+/vHx8dC\nQkIrKyv39/fw8PDa2tpiYmLe3t66urqzs7Ourq6MjIyHh4f////V1dWampqTk5NxcXFra2tPT09I\nSEg1NTXp6enl5eXOzs5bW1s/Pz/y8vLm5ubCwsK8vLyioqJ4eHgeHh7////ORlUAAAAATHRSTlOA\nAE1HmXrmdnJoTkA9KyceEQT9hPjthn5tY15cW1hVVFFQTkQyIxoKB/vRkov28N6e4cjEwbCtNtq3\ns6Ohl5SO6+fVm5Hy587JuqaHiSSVHgAAAuFJREFUWMOll2lX4jAUhu9QCxRZSssqm8paliICCiIu\no7Pf//97hiSUtHSLJ+8HOJwkD7lrEvgWotEg38t2lURC6WZ7+cEobF4wQM9dJs50mdNFAcU+X+1l\n9IsCgGJeSYRKyRfjAIXT8utmvZZSq1U1Vas3r0+IQiRgmGXTMm1NBY9UrZ1hY9lhOEBX2PKGCgFS\nGwyh6GGAQoKqlYIQpVpsRiEYkKODnTREKN2hk3JBgEc6dAUxuqLTHjnA8/+3GsRKu/XsAdz236RB\nQOkb6gcvQKfrVRCSSgm6GzBUyP7TIKg0sUIZugA0fzQQlkYzigMKPv8LxaLgAIoKiT98SR1iRPEI\nyBNcoAPukvZDiBvImjwFsA20IEBPBqJhBhNadAsU0Cf1E5T/94jLn3gRUheksvoUQPpPA3yaztFa\nQzIMAA3SowhAJxtQ/ebb+OMDIgBqhmYT0CJow0n/Pj8nB60MXEzBB1jfwUltWhJALeA5tDWQyVgB\n+AAVw+I/NWoDjEg8uAUzLFPNP4AD3H61pycbyMoRDEj/5DMQgcsPgAX+Bkek0w6AZFFTAGAC1cSw\nXp2xJskl6B0+6/GAqTUGqjEunbH6YWkPSCHW4gHmDP+y8OKbM1YjJQndw2dKwIQ12o6bHRtSh6Vd\nUEgQRJxYRpYDc3x2hUEBEouqCOA7Ph2d4BRolawVB9zjn+P31g0QN2GDa74DboKYE1kYXrgPuBNF\nwwhLXDBQCafuMAonkmGwDTzjuyeRRFPZnG+dYKw8qfzVYtqjNfUU03k5I1aYggHmOy695XzeUGw8\nKrkPAozxreJpKL6WtiuXqCy0HvwA0yhNvC0ttKmavxBX/h3sXnxNlbd1/6kyhri2Hnmw7Eq4MZPR\nB0v00XYxw0UZ91FHW8zhOrERZ1GHa+zx/jreXEQd77IXDNkrjvQlS/aaJ3vRlL3qSl+25a/78g8O\n+SeP/KNL/tkn//CUf/rKP76ln///AWO5YPW0P5qvAAAAAElFTkSuQmCC\n"));
      paramBoolean = true;
    } else {
      this.d.h();
      this.f.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAw1BMVEUAAAAAAAD///8nJyfp6en+\n/v7///9UVFTj4+MMDAz19fX///8eHh49PT11dXX///////////////////8FBQUTExP///8bGxsW\nFhYsLCxQUFBkZGSLi4uioqKnp6e/v7/Z2dn////////////////////////////////5+fns7OxB\nQUETExPe3t78/Pz29vbm5ubw8PDV1dWwsLCHh4dbW1va2trExMSTk5NxcXFjY2Py8vLt7e3IyMi6\nurqbm5v///8IvZbOAAAAQHRSTlOAAE2K6k1HmeZ6Tj9yaFsrJx4EAX93M4Z1bWNeWFVUUVBEPCMa\nEhAKB/nskoTh/Pbn8drCrpvez7Okn/Lt0ci3+fRniwAAArFJREFUWMOll+l2qkAMgHNrQdGibFq1\nLrWubXHvete8/1NdMmgjCMGeyQ8PByaf2WcGfuTIYuK0aiPTMMxRreVMFnnrsgGzRu0qJbXG7FKA\nN2btJGPsXQDwHPMqV0zHKwD47lHdGNa7nbYVBFa7060PjSPC9SXA/CFeVu3bFiTEsvvV+NvDPB8w\nNWP1OmufMuoxwpzmAVxD2d5rQo40e/EKNxPgNxR/cAOC3AzUooZ/DvBb6tMdFMidWtbyzwAN5b0N\nhWJXlQ1pgEtv79l8yY17WusmAVOD9JtwkTSJYExPAXOT7Of/L7KBvDDnDPBV/dhwsdiqovwvgCvE\nX8iFewR4JuUfviUDcsI7AByKSWYAfla2LzlhoKg7BDgY0IMM+VghrsJsQk+ZoABjykBGBoO/iPsN\nlnNySZkYKwDNnzqcSekNVy9QyQNAnWYUAWZkgHXu/hZ/vYIAsMiEWQSgJujz+9tnJXvEZQkkAPRV\nS4DygGvoHx5lH4AMsJUPsKAcsgdrfFLyFplfALAokwuYRL9DfovIzwzYRe5wdJc7UDKMVCfgUA6K\nAEu8/iKUrnHJeXCABlFXBpBSTEg+dmk0AcWwIwJYLakPHYoijKLftgxgxYQ+tCPVEVAjWDKACQl9\nsKgdgHIRyAAmJPQhoAq4BMAE1meA4IIAYBeEIEoucBCFNEpB5DQKhSSlkQtJKGWpkLiUhWaSSpmb\nKd3OiLexJACbZDNtTto5PVC2eJBKmQHhenPazpt1yAMlPdI+fz8qWUUTlS1IjfaQR1ruUA3fEfdQ\nPFSFsf6B+B4UjXVxY/l8xF1YkTcWeWt7XePyiQDC1iZvrs9bxHUgb67y9l76sytL27vuAUP7iKN7\nyNI95ukeNHWPutqHbf3jvv6FQ//Ko3/p0r/26V889a+++pdv7ev/f9d/WD42EM2oAAAAAElFTkSu\nQmCC\n"));
      paramBoolean = false;
    } 
    this.r = paramBoolean;
  }
  
  private void j() {
    this.d = new f(getContext());
    this.d.setId(2131755010);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams.addRule(13, -1);
    this.d.a(new f.a(this) {
          public void a() {
            if (b.b(this.a) != null)
              b.b(this.a).setVisibility(4); 
            if (b.c(this.a) != null)
              b.c(this.a).setVisibility(0); 
            if (b.a(this.a) != null && b.a(this.a).k())
              b.d(this.a).b(); 
            InterstitialFSEventCenter.a().a(b.e(this.a), 10008, Long.valueOf(b.d(this.a).e()));
          }
          
          public void a(int param1Int, Exception param1Exception) {
            InterstitialFSEventCenter.a().a(b.e(this.a), 10012, new AdError(701, "video error while playing!"));
            if (b.a(this.a) != null)
              b.a(this.a).a(true, param1Int, param1Exception); 
          }
          
          public void b() {
            if (b.f(this.a) != null)
              b.f(this.a).setVisibility(4); 
            if (b.g(this.a) != null && b.d(this.a) != null)
              b.g(this.a).a(b.d(this.a), 500, this.a); 
            b.h(this.a).a(System.currentTimeMillis());
            InterstitialFSEventCenter.a().a(b.e(this.a), 10009, null);
            if (b.a(this.a) != null)
              b.a(this.a).e(); 
            if (b.i(this.a) != 0L)
              bc.b(System.currentTimeMillis() - b.i(this.a), b.j(this.a), b.k(this.a), b.l(this.a)); 
            if (b.m(this.a) != null) {
              Context context1 = this.a.getContext();
              int j = this.a.getHeight();
              Context context2 = this.a.getContext();
              if (b.n(this.a)) {
                i = 8;
              } else if (q.a(b.o(this.a))) {
                i = 120;
              } else {
                i = 96;
              } 
              int i = am.b(context1, j - am.a(context2, i));
              b.m(this.a).a(8, i, b.n(this.a));
            } 
          }
          
          public void c() {
            if (b.a(this.a) != null)
              b.a(this.a).f(); 
            InterstitialFSEventCenter.a().a(b.e(this.a), 10011, null);
          }
          
          public void d() {}
          
          public void e() {
            InterstitialFSEventCenter.a().a(b.e(this.a), 10010, null);
          }
          
          public void f() {
            b.b(this.a, true);
            InterstitialFSEventCenter.a().a(b.e(this.a), 10009, null);
          }
        });
    addView((View)this.d, (ViewGroup.LayoutParams)layoutParams);
    this.h = new ImageView(getContext());
    addView((View)this.h, (ViewGroup.LayoutParams)layoutParams);
    com.qq.e.comm.plugin.p.a.a().a(this.c.o(), this.h, new com.qq.e.comm.plugin.p.b(this) {
          public void a(String param1String, int param1Int, Exception param1Exception) {}
          
          public void a(String param1String, ImageView param1ImageView, e param1e) {
            if (param1ImageView != null)
              param1ImageView.setScaleType(ImageView.ScaleType.FIT_CENTER); 
          }
        });
  }
  
  private void k() {
    this.e = new b(getContext());
    this.e.setId(2131755009);
    this.e.a(am.a(getContext(), 2));
    this.e.a(Color.argb(77, 255, 255, 255));
    this.e.b(-1);
    this.e.c(Color.argb(128, 0, 0, 0));
    this.e.b(am.a(getContext(), 14));
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(am.a(getContext(), 30), am.a(getContext(), 30));
    layoutParams.addRule(11, -1);
    layoutParams.topMargin = am.a(getContext(), 20);
    layoutParams.rightMargin = am.a(getContext(), 20);
    addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void l() {
    boolean bool;
    this.f = new ImageView(getContext());
    this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.f.setOnClickListener(this);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(am.a(getContext(), 30), am.a(getContext(), 30));
    layoutParams.addRule(0, 2131755009);
    layoutParams.rightMargin = am.a(getContext(), 20);
    layoutParams.topMargin = am.a(getContext(), 20);
    try {
      String str = GDTADManager.getInstance().getSM().getStringForPlacement("videoOptions", this.n);
      if (str == null)
        str = "{}"; 
      bool = (new JSONObject(str)).optBoolean("autoPlayMuted", true);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get video options error: ");
      stringBuilder.append(exception.getMessage());
      GDTLogger.d(stringBuilder.toString());
      bool = true;
    } 
    a(true ^ bool);
    this.f.setVisibility(4);
    addView((View)this.f, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void m() {
    this.g = new ImageView(getContext());
    this.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.g.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(am.a(getContext(), 30), am.a(getContext(), 30));
    layoutParams.addRule(9, -1);
    layoutParams.leftMargin = am.a(getContext(), 20);
    layoutParams.topMargin = am.a(getContext(), 20);
    this.g.setOnClickListener(this);
    this.g.setVisibility(8);
    addView((View)this.g, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void n() {
    this.i = new com.qq.e.comm.plugin.ac.a(getContext());
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(am.a(getContext(), 46), am.a(getContext(), 46));
    layoutParams.addRule(13);
    this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    addView((View)this.i);
  }
  
  private void o() {
    String str = this.c.ac();
    if (this.c != null) {
      if (TextUtils.isEmpty(str))
        return; 
      this.j = new k(getContext(), str, this.p);
      this.j.a(this);
    } 
  }
  
  public void a(ViewGroup paramViewGroup) {
    if (paramViewGroup.getParent() == null)
      paramViewGroup.addView((View)this, new ViewGroup.LayoutParams(-1, -1)); 
  }
  
  public void a(a parama) {
    this.l = parama;
  }
  
  public void a(String paramString) {
    a a1;
    if (TextUtils.isEmpty(paramString)) {
      GDTLogger.e("video url null");
      return;
    } 
    this.k = paramString;
    File file = aj.d(paramString);
    if (file != null && file.exists()) {
      this.t = (int)(file.length() >> 10L);
      InterstitialFSEventCenter.a().a(this.m, 10006, null);
      this.s = System.currentTimeMillis();
      this.d.a(file.getAbsolutePath());
      com.qq.e.comm.plugin.ac.a a3 = this.i;
      if (a3 != null)
        a3.setVisibility(8); 
      a1 = this.l;
      if (a1 != null)
        a1.d(); 
      this.x = false;
      this.w.cancel();
      return;
    } 
    com.qq.e.comm.plugin.intersitial2.fullscreen.a.a a2 = new com.qq.e.comm.plugin.intersitial2.fullscreen.a.a(this) {
        public void a() {
          if (b.b(this.a) != null)
            b.b(this.a).setVisibility(0); 
          InterstitialFSEventCenter.a().a(b.e(this.a), 10007, null);
        }
        
        public void a(int param1Int) {
          if (b.b(this.a) != null) {
            b.b(this.a).setVisibility(0);
            b.b(this.a).a(param1Int);
          } 
        }
        
        public void a(c param1c) {
          if (b.p(this.a))
            return; 
          GDTLogger.e("download video fail");
          param1c.printStackTrace();
          InterstitialFSEventCenter.a().a(b.e(this.a), 10012, new AdError(700, "download video error!"));
          if (b.a(this.a) != null)
            b.a(this.a).a(false, param1c.a(), (Exception)param1c); 
          b.a(this.a, false);
          b.q(this.a).cancel();
        }
        
        public void a(String param1String) {
          if (b.p(this.a))
            return; 
          if (b.b(this.a) != null)
            b.b(this.a).setVisibility(8); 
          if (b.d(this.a) != null && param1String != null) {
            InterstitialFSEventCenter.a().a(b.e(this.a), 10006, null);
            b.a(this.a, System.currentTimeMillis());
            b.a(this.a, (int)((new File(param1String)).length() >> 10L));
            b.d(this.a).a(param1String);
          } 
          if (b.a(this.a) != null)
            b.a(this.a).d(); 
          b.a(this.a, false);
          b.q(this.a).cancel();
        }
      };
    com.qq.e.comm.plugin.intersitial2.fullscreen.a.a().a((String)a1, this.m, a2, this.y);
  }
  
  public boolean a() {
    return this.v;
  }
  
  public f b() {
    return this.d;
  }
  
  public void b(ViewGroup paramViewGroup) {
    if (paramViewGroup != null)
      paramViewGroup.removeView((View)this); 
  }
  
  public void c() {
    f f1 = this.d;
    if (f1 != null && f1.c())
      this.d.a(); 
  }
  
  public void d() {
    f f1 = this.d;
    if (f1 != null && !f1.c())
      this.d.b(); 
  }
  
  public void e() {
    k k1 = this.j;
    if (k1 != null)
      k1.a(); 
  }
  
  public boolean f() {
    f f1 = this.d;
    return (f1 == null || f1.f() >= this.q);
  }
  
  public void g() {
    if (f()) {
      b b1 = this.e;
      if (b1 != null) {
        b1.a();
        this.e = null;
      } 
      f f1 = this.d;
      if (f1 != null)
        f1.a(); 
      a a1 = this.l;
      if (a1 != null) {
        a1.h();
        return;
      } 
    } else {
      GDTLogger.i("InterstitialFS ad back button click, no op");
    } 
  }
  
  public void h() {
    CountDownTimer countDownTimer = this.w;
    if (countDownTimer != null) {
      countDownTimer.cancel();
      this.w = null;
    } 
    b b1 = this.e;
    if (b1 != null) {
      b1.a();
      this.e = null;
    } 
    f f1 = this.d;
    if (f1 != null) {
      f1.a(null);
      this.d.l();
      this.d = null;
    } 
    com.qq.e.comm.plugin.intersitial2.fullscreen.a.a().a(this.k);
  }
  
  public void i() {
    f f1 = this.d;
    if (f1 != null) {
      if (f1.f() >= this.q) {
        if (this.u)
          return; 
        this.g.setVisibility(0);
        a a1 = this.l;
        if (a1 != null)
          a1.g(); 
        this.u = true;
        return;
      } 
      this.g.setVisibility(8);
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView == this) {
      if (this.l != null && this.z.a()) {
        this.l.i();
        return;
      } 
    } else {
      if (paramView == this.f) {
        a(this.r ^ true);
        return;
      } 
      if (paramView == this.g) {
        g();
        return;
      } 
      if (paramView == this.j) {
        a a1 = this.l;
        if (a1 != null)
          a1.j(); 
      } 
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    this.p.a(this.b.getWindow().getDecorView(), paramMotionEvent, false);
    this.z.a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public static interface a {
    void a(boolean param1Boolean, int param1Int, Exception param1Exception);
    
    void d();
    
    void e();
    
    void f();
    
    void g();
    
    void h();
    
    void i();
    
    void j();
    
    boolean k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\fullscreen\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */