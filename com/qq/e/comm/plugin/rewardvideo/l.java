package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ab.b.b;
import com.qq.e.comm.plugin.ab.d.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.ac.b;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.h;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.n.b;
import com.qq.e.comm.plugin.n.d;
import com.qq.e.comm.plugin.n.f;
import com.qq.e.comm.plugin.n.g;
import com.qq.e.comm.plugin.n.h;
import com.qq.e.comm.plugin.p.b;
import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.rewardvideo.a.b;
import com.qq.e.comm.plugin.rewardvideo.b.a;
import com.qq.e.comm.plugin.rewardvideo.b.c;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.plugin.util.g;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.util.s;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;

public class l implements View.OnClickListener, ACTD, a, b.a, b.a, f.a {
  private int A;
  
  private j B;
  
  private g C;
  
  private String D;
  
  private File E;
  
  private boolean F;
  
  private boolean G;
  
  private boolean H;
  
  private int I;
  
  private r J;
  
  private f K;
  
  private final String a = getClass().getSimpleName();
  
  private SM b = GDTADManager.getInstance().getSM();
  
  private final Activity c;
  
  private d d;
  
  private boolean e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private RelativeLayout i;
  
  private c j;
  
  private g k;
  
  private h l;
  
  private com.qq.e.comm.plugin.ac.a m;
  
  private a n = null;
  
  private boolean o = true;
  
  private boolean p = false;
  
  private String q;
  
  private boolean r = true;
  
  private boolean s = false;
  
  private boolean t;
  
  private boolean u;
  
  private c v = new c();
  
  private long w;
  
  private int x;
  
  private int y;
  
  private int z;
  
  public l(Activity paramActivity) {
    this.c = paramActivity;
    this.A = n.a();
  }
  
  private JSONObject a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      HashSet hashSet;
      Iterator<String> iterator = paramJSONObject.keys();
      String str2 = this.b.getString("rewardVideoAdInfoFilter");
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = "apurl,rl,customized_invoke_url,video,edid,video_tracking_url,click_mo_url,click_mo_url_sdk,report_url,report_url_sdk,endcard_info,negative_feedback_url,wechat_ad_trace_data,pkg_download_schema,requrl,corporate_logo,mqq_via,endcard"; 
      if (TextUtils.isEmpty(str1)) {
        str1 = null;
      } else {
        hashSet = new HashSet(Arrays.asList((Object[])str1.split(",")));
      } 
      if (iterator != null && hashSet != null && hashSet.size() > 0) {
        ArrayList<String> arrayList = new ArrayList();
        try {
          return new JSONObject(paramJSONObject, arrayList.<String>toArray(new String[0]));
        } finally {
          hashSet = null;
        } 
      } 
    } 
    return paramJSONObject;
  }
  
  private void a(int paramInt1, int paramInt2) {
    gdtadv.getVresult(167, 0, new Object[] { this, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void a(String paramString) {
    this.d = new d(paramString, this.g, this.h, this.f);
    this.d.a(e.a);
    if (!this.d.f()) {
      this.B.a(5001);
      this.c.finish();
      return;
    } 
    this.p = d.a(this.d);
    if (this.p) {
      j j1 = d.d(this.d.l_());
      this.q = j1.d();
      if (!TextUtils.isEmpty(this.q))
        com.qq.e.comm.plugin.a.l.a().a(j1.d(), this); 
    } 
    this.v.a(this.h);
    this.v.b(this.d.j());
    this.v.c(this.d.H());
  }
  
  private void b(int paramInt1, int paramInt2) {
    if (this.F) {
      com.qq.e.comm.plugin.ab.d.a a1 = this.j.f();
      if (a1 != null) {
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.putOpt("status", Integer.valueOf(paramInt1));
          jSONObject.putOpt("progress", Integer.valueOf(paramInt2));
          a1.c().a(new b("onAPKStatusUpdate", jSONObject));
          ak.b("gdt_tag_reward_video", "jsbridge.dispatch updateAppDownloadStatus（%d,%d）", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          return;
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
      } 
    } 
  }
  
  private void b(String paramString) {
    this.i.removeView((View)this.m);
    this.l.a();
    this.j.j();
    this.w = System.currentTimeMillis();
    this.j.c().a(paramString);
    if (this.H)
      this.j.c().b(); 
  }
  
  private void g() {
    boolean bool = n.a(this.d);
    this.i = new RelativeLayout(this, (Context)this.c, bool) {
        public boolean onTouchEvent(MotionEvent param1MotionEvent) {
          if (this.a) {
            l.a(this.b).a(param1MotionEvent);
            l.c(this.b).a((View)l.b(this.b), param1MotionEvent, false);
          } 
          return super.onTouchEvent(param1MotionEvent);
        }
      };
    if (bool)
      this.i.setOnClickListener(this); 
    h();
    k();
    j();
    l();
    this.c.setContentView((View)this.i, new ViewGroup.LayoutParams(-1, -1));
  }
  
  private void h() {
    this.I = 1;
    if (this.j == null) {
      ImageView imageView;
      String str;
      ak.a(this.a, "initVideoLayout");
      this.j = new c((Context)this.c, this.e, this.F, this.d, this.C);
      this.j.c().a(new a());
      this.m = new com.qq.e.comm.plugin.ac.a((Context)this.c);
      this.j.a().setOnClickListener(this);
      this.j.b().setOnClickListener(this);
      this.j.b().setVisibility(8);
      if (this.j.h() != null)
        this.j.h().a(this); 
      TextView textView = this.j.g();
      if (textView != null)
        textView.setVisibility(4); 
      this.j.i();
      this.j.a((ViewGroup)this.i);
      if (this.o) {
        this.j.c().i();
        imageView = this.j.a();
        str = "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAA51BMVEUAAAAAAAD///////9VVVUM\nDAzj4+MTExMeHh49PT339/f////////////////////////////+/v4SEhL5+fnt7e0aGhoEBAQs\nLCxQUFBkZGRycnJ4eHiLi4uioqKnp6e/v7/Z2dny8vL////////////////////////7+/vHx8dC\nQkIrKyv39/fw8PDa2tpiYmLe3t66urqzs7Ourq6MjIyHh4f////V1dWampqTk5NxcXFra2tPT09I\nSEg1NTXp6enl5eXOzs5bW1s/Pz/y8vLm5ubCwsK8vLyioqJ4eHgeHh7////ORlUAAAAATHRSTlOA\nAE1HmXrmdnJoTkA9KyceEQT9hPjthn5tY15cW1hVVFFQTkQyIxoKB/vRkov28N6e4cjEwbCtNtq3\ns6Ohl5SO6+fVm5Hy587JuqaHiSSVHgAAAuFJREFUWMOll2lX4jAUhu9QCxRZSssqm8paliICCiIu\no7Pf//97hiSUtHSLJ+8HOJwkD7lrEvgWotEg38t2lURC6WZ7+cEobF4wQM9dJs50mdNFAcU+X+1l\n9IsCgGJeSYRKyRfjAIXT8utmvZZSq1U1Vas3r0+IQiRgmGXTMm1NBY9UrZ1hY9lhOEBX2PKGCgFS\nGwyh6GGAQoKqlYIQpVpsRiEYkKODnTREKN2hk3JBgEc6dAUxuqLTHjnA8/+3GsRKu/XsAdz236RB\nQOkb6gcvQKfrVRCSSgm6GzBUyP7TIKg0sUIZugA0fzQQlkYzigMKPv8LxaLgAIoKiT98SR1iRPEI\nyBNcoAPukvZDiBvImjwFsA20IEBPBqJhBhNadAsU0Cf1E5T/94jLn3gRUheksvoUQPpPA3yaztFa\nQzIMAA3SowhAJxtQ/ebb+OMDIgBqhmYT0CJow0n/Pj8nB60MXEzBB1jfwUltWhJALeA5tDWQyVgB\n+AAVw+I/NWoDjEg8uAUzLFPNP4AD3H61pycbyMoRDEj/5DMQgcsPgAX+Bkek0w6AZFFTAGAC1cSw\nXp2xJskl6B0+6/GAqTUGqjEunbH6YWkPSCHW4gHmDP+y8OKbM1YjJQndw2dKwIQ12o6bHRtSh6Vd\nUEgQRJxYRpYDc3x2hUEBEouqCOA7Ph2d4BRolawVB9zjn+P31g0QN2GDa74DboKYE1kYXrgPuBNF\nwwhLXDBQCafuMAonkmGwDTzjuyeRRFPZnG+dYKw8qfzVYtqjNfUU03k5I1aYggHmOy695XzeUGw8\nKrkPAozxreJpKL6WtiuXqCy0HvwA0yhNvC0ttKmavxBX/h3sXnxNlbd1/6kyhri2Hnmw7Eq4MZPR\nB0v00XYxw0UZ91FHW8zhOrERZ1GHa+zx/jreXEQd77IXDNkrjvQlS/aaJ3vRlL3qSl+25a/78g8O\n+SeP/KNL/tkn//CUf/rKP76ln///AWO5YPW0P5qvAAAAAElFTkSuQmCC\n";
      } else {
        this.j.c().h();
        imageView = this.j.a();
        str = "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAw1BMVEUAAAAAAAD///8nJyfp6en+\n/v7///9UVFTj4+MMDAz19fX///8eHh49PT11dXX///////////////////8FBQUTExP///8bGxsW\nFhYsLCxQUFBkZGSLi4uioqKnp6e/v7/Z2dn////////////////////////////////5+fns7OxB\nQUETExPe3t78/Pz29vbm5ubw8PDV1dWwsLCHh4dbW1va2trExMSTk5NxcXFjY2Py8vLt7e3IyMi6\nurqbm5v///8IvZbOAAAAQHRSTlOAAE2K6k1HmeZ6Tj9yaFsrJx4EAX93M4Z1bWNeWFVUUVBEPCMa\nEhAKB/nskoTh/Pbn8drCrpvez7Okn/Lt0ci3+fRniwAAArFJREFUWMOll+l2qkAMgHNrQdGibFq1\nLrWubXHvete8/1NdMmgjCMGeyQ8PByaf2WcGfuTIYuK0aiPTMMxRreVMFnnrsgGzRu0qJbXG7FKA\nN2btJGPsXQDwHPMqV0zHKwD47lHdGNa7nbYVBFa7060PjSPC9SXA/CFeVu3bFiTEsvvV+NvDPB8w\nNWP1OmufMuoxwpzmAVxD2d5rQo40e/EKNxPgNxR/cAOC3AzUooZ/DvBb6tMdFMidWtbyzwAN5b0N\nhWJXlQ1pgEtv79l8yY17WusmAVOD9JtwkTSJYExPAXOT7Of/L7KBvDDnDPBV/dhwsdiqovwvgCvE\nX8iFewR4JuUfviUDcsI7AByKSWYAfla2LzlhoKg7BDgY0IMM+VghrsJsQk+ZoABjykBGBoO/iPsN\nlnNySZkYKwDNnzqcSekNVy9QyQNAnWYUAWZkgHXu/hZ/vYIAsMiEWQSgJujz+9tnJXvEZQkkAPRV\nS4DygGvoHx5lH4AMsJUPsKAcsgdrfFLyFplfALAokwuYRL9DfovIzwzYRe5wdJc7UDKMVCfgUA6K\nAEu8/iKUrnHJeXCABlFXBpBSTEg+dmk0AcWwIwJYLakPHYoijKLftgxgxYQ+tCPVEVAjWDKACQl9\nsKgdgHIRyAAmJPQhoAq4BMAE1meA4IIAYBeEIEoucBCFNEpB5DQKhSSlkQtJKGWpkLiUhWaSSpmb\nKd3OiLexJACbZDNtTto5PVC2eJBKmQHhenPazpt1yAMlPdI+fz8qWUUTlS1IjfaQR1ruUA3fEfdQ\nPFSFsf6B+B4UjXVxY/l8xF1YkTcWeWt7XePyiQDC1iZvrs9bxHUgb67y9l76sytL27vuAUP7iKN7\nyNI95ukeNHWPutqHbf3jvv6FQ//Ko3/p0r/26V889a+++pdv7ev/f9d/WD42EM2oAAAAAElFTkSu\nQmCC\n";
      } 
      imageView.setImageBitmap(aq.a(str));
      com.qq.e.comm.plugin.p.a.a().a(this.d.o(), this.j.d(), new b(this) {
            public void a(String param1String, int param1Int, Exception param1Exception) {}
            
            public void a(String param1String, ImageView param1ImageView, e param1e) {
              if (param1ImageView != null)
                param1ImageView.setScaleType(ImageView.ScaleType.FIT_CENTER); 
            }
          });
    } 
  }
  
  private void j() {
    if (this.F) {
      com.qq.e.comm.plugin.ab.d.a a1 = this.j.f();
      if (a1 != null) {
        a1.c().a("rewardVideo", (c)new b(this));
        long l1 = System.currentTimeMillis();
        String str = aj.c(this.E);
        ak.b("gdt_tag_reward_video", "HtmlFile read cost : %d  ", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        if (!TextUtils.isEmpty(str)) {
          a1.a(new f(this, SystemClock.elapsedRealtime(), a1) {
                long a;
                
                public void a(int param1Int) {
                  ak.b("gdt_tag_reward_video", "onProgressChanged(%d)", new Object[] { Integer.valueOf(param1Int) });
                }
                
                public void a(int param1Int, String param1String1, String param1String2) {
                  ak.b("gdt_tag_reward_video", "onReceivedError(%d,%s,%s)", new Object[] { Integer.valueOf(param1Int), param1String1, param1String2 });
                  long l1 = System.currentTimeMillis();
                  long l2 = this.a;
                  s.a("Reward", "BottomCard", l.d(this.d), l1 - l2, param1String2, param1String1, l.e(this.d));
                }
                
                public void a(ValueCallback<Uri> param1ValueCallback, Intent param1Intent) {}
                
                public void a(String param1String) {
                  long l1 = System.currentTimeMillis();
                  long l2 = this.a;
                  s.a("Reward", "BottomCard", l.d(this.d), l1 - l2, param1String, null, l.e(this.d));
                  ak.b("gdt_tag_reward_video", "load webview layer cost %d ms", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - this.b) });
                  ak.b("gdt_tag_reward_video", "onPageFinished(%s)", new Object[] { param1String });
                  JSONObject jSONObject = new JSONObject();
                  try {
                    jSONObject.putOpt("adInfo", l.a(this.d, l.f(this.d).l_()));
                    jSONObject.putOpt("layout", l.g(this.d));
                    if (l.f(this.d) == null) {
                      param1String = null;
                    } else {
                      param1String = g.a(l.f(this.d).C());
                    } 
                    jSONObject.putOpt("logo", param1String);
                    ak.b("gdt_tag_reward_video", "bridge.dispatch onRewardVideoShow(%s)", new Object[] { jSONObject });
                    this.c.c().a(new b("onRewardVideoShow", jSONObject));
                    if (l.h(this.d)) {
                      int i = com.qq.e.comm.plugin.a.l.a().a(l.i(this.d));
                      l.a(this.d, i, -1);
                      return;
                    } 
                  } catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                  } 
                }
                
                public void a(String param1String, Bitmap param1Bitmap) {
                  ak.b("gdt_tag_reward_video", "onPageStarted(%s)", new Object[] { param1String });
                  this.a = System.currentTimeMillis();
                }
                
                public void b(String param1String) {
                  ak.b("gdt_tag_reward_video", "onOverrideUrlLoading(%s)", new Object[] { param1String });
                }
                
                public boolean b(ValueCallback<Uri[]> param1ValueCallback, Intent param1Intent) {
                  return false;
                }
                
                public void c(String param1String) {
                  ak.b("gdt_tag_reward_video", "onReceivedTitle(%s)", new Object[] { param1String });
                }
                
                public void d_() {
                  ak.a("gdt_tag_reward_video", "onLeftApplication");
                }
              });
          a1.a(this.D, str, bb.a.a.a(), "UTF-8", null);
        } 
      } 
    } 
  }
  
  private void k() {
    this.k = com.qq.e.comm.plugin.n.a.a((Context)this.c, this.d, this.v);
    g g1 = this.k;
    if (g1 != null) {
      g1.a(this);
      this.k.a((ViewGroup)this.i, this.e);
      this.k.a(this.C);
    } 
  }
  
  private void l() {
    ak.a(this.a, "initEndCard");
    n.a((Context)this.c, this.g, this.h, this.d);
    this.l = d.a((Context)this.c, this.d, this.C, "Reward", m(), this.v);
    this.l.a(this);
    if (this.d.k_()) {
      this.u = true;
      this.l.a(this.d.ak());
    } 
    this.l.a();
    this.l.a((ViewGroup)this.i);
  }
  
  private int m() {
    boolean bool = this.d.k_();
    return n.a(this.d, bool);
  }
  
  private void n() {
    if (this.G)
      return; 
    ak.a(this.a, "onAdExposure");
    com.qq.e.comm.plugin.ad.a.a().a((View)this.i);
    this.i.post(new Runnable(this) {
          public void run() {
            if (l.f(this.a) != null && l.j(this.a) != null && l.c(this.a) != null) {
              ac.a(l.f(this.a).am());
              l.k(this.a);
              l.j(this.a).h();
            } 
          }
        });
    this.G = true;
  }
  
  private JSONObject o() {
    Rect rect = new Rect();
    this.i.getGlobalVisibleRect(rect);
    int n = Math.abs(rect.right - rect.left);
    int k = Math.abs(rect.bottom - rect.top);
    int i = this.d.P();
    int m = this.d.Q();
    int i1 = this.j.a((Context)this.c);
    if (i > 0 && m > 0 && n > 0 && k > 0 && i1 > 0) {
      rect = new Rect();
      int i2 = i * k;
      int i3 = n * m;
      if (i2 > i3) {
        i = i3 / i;
        rect.left = 0;
        rect.top = (k - i) / 2;
        rect.right = n;
        rect.bottom = (k + i) / 2;
      } else if (i2 == i3) {
        rect.left = 0;
        rect.top = 0;
        rect.right = n;
        rect.bottom = k;
        i = k;
      } else {
        m = i2 / m;
        rect.left = (n - m) / 2;
        rect.top = 0;
        rect.right = (n + m) / 2;
        rect.bottom = k;
        i = k;
        ak.b("gdt_tag_reward_video", "layout detail : webview(%d,%d) , videoRect = %s , scaledVideoWidth = %d , scaledVideoHeight = %d , funcTopMargin = %d", new Object[] { Integer.valueOf(n), Integer.valueOf(k), rect, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i1) });
        float f2 = (this.c.getResources().getDisplayMetrics()).density;
        n = (int)Math.ceil((n / f2));
        k = (int)Math.ceil((k / f2));
        rect.left = (int)Math.ceil((rect.left / f2));
        rect.top = (int)Math.ceil((rect.top / f2));
        rect.right = (int)Math.ceil((rect.right / f2));
        rect.bottom = (int)Math.ceil((rect.bottom / f2));
        ak.b("gdt_tag_reward_video", "layout detail transformed : webview(%d,%d) , videoRect = %s , scaledVideoWidth = %d , scaledVideoHeight = %d , funcTopMargin = %d", new Object[] { Integer.valueOf(n), Integer.valueOf(k), rect, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i1) });
        JSONObject jSONObject1 = new JSONObject();
      } 
      m = n;
    } else {
      return null;
    } 
    ak.b("gdt_tag_reward_video", "layout detail : webview(%d,%d) , videoRect = %s , scaledVideoWidth = %d , scaledVideoHeight = %d , funcTopMargin = %d", new Object[] { Integer.valueOf(n), Integer.valueOf(k), rect, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i1) });
    float f1 = (this.c.getResources().getDisplayMetrics()).density;
    n = (int)Math.ceil((n / f1));
    k = (int)Math.ceil((k / f1));
    rect.left = (int)Math.ceil((rect.left / f1));
    rect.top = (int)Math.ceil((rect.top / f1));
    rect.right = (int)Math.ceil((rect.right / f1));
    rect.bottom = (int)Math.ceil((rect.bottom / f1));
    ak.b("gdt_tag_reward_video", "layout detail transformed : webview(%d,%d) , videoRect = %s , scaledVideoWidth = %d , scaledVideoHeight = %d , funcTopMargin = %d", new Object[] { Integer.valueOf(n), Integer.valueOf(k), rect, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i1) });
    JSONObject jSONObject = new JSONObject();
  }
  
  private void p() {
    this.c.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(-16777216));
    String str = this.d.k();
    File file = aj.d(str);
    if (file != null && file.exists()) {
      b(file.getAbsolutePath());
      this.x = (int)(file.length() >> 10L);
    } else {
      this.i.removeView((View)this.m);
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(am.a((Context)this.c, 46), am.a((Context)this.c, 46));
      layoutParams.addRule(13, -1);
      this.i.addView((View)this.m, (ViewGroup.LayoutParams)layoutParams);
      this.B.a(str, this.v);
      this.B.a(this);
    } 
    n();
  }
  
  private void q() {
    this.I = 2;
    if (this.j.h() != null)
      this.j.h().a(); 
    if (!this.u)
      this.l.a(this.d.ak()); 
    this.i.removeView((View)this.m);
    g g1 = this.k;
    if (g1 != null)
      g1.a((ViewGroup)this.i); 
    this.i.removeView((View)this.j);
    com.qq.e.comm.plugin.ab.d.a a1 = this.j.f();
    if (a1 != null)
      a1.a(); 
    this.l.b();
  }
  
  private void r() {
    String str;
    int i = this.j.c().f();
    this.j.c().a();
    if (i >= this.z * 1000) {
      a a1 = this.n;
      if (a1 != null && a1.isShowing())
        this.n.cancel(); 
      q();
      return;
    } 
    i = this.j.c().e();
    if (this.z * 1000 > i) {
      str = "观看完视频，可获得奖励\n确认要离开吗？";
    } else {
      str = "观看视频满%d秒即可获得激励\n确认要离开吗？";
    } 
    if (this.n == null)
      this.n = new a((Context)this.c); 
    this.n.setCancelable(false);
    if (!this.n.isShowing())
      this.n.show(); 
    LinearLayout linearLayout = this.n.a((Context)this.c, String.format(Locale.getDefault(), str, new Object[] { Integer.valueOf(this.z) }), "继续观看", "放弃奖励");
    this.n.setContentView((View)linearLayout);
    if (this.n.getWindow() != null) {
      WindowManager.LayoutParams layoutParams = this.n.getWindow().getAttributes();
      linearLayout.measure(0, 0);
      layoutParams.width = linearLayout.getMeasuredWidth();
      layoutParams.height = linearLayout.getMeasuredHeight();
      layoutParams.gravity = 17;
      this.n.getWindow().setAttributes(layoutParams);
      this.n.getWindow().setBackgroundDrawable((Drawable)ar.a(am.a((Context)this.c, 10), -1, 255));
    } 
    this.n.a().setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            boolean bool;
            l l1 = this.a;
            if (l.l(l1)) {
              bool = true;
            } else {
              bool = true;
            } 
            l.b(l1, bool, 0);
            l.m(this.a);
          }
        });
    this.n.b().setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            l.n(this.a).cancel();
            l.o(this.a).c().b();
          }
        });
  }
  
  private void s() {
    this.B.d();
    this.c.finish();
  }
  
  private void t() {
    boolean bool;
    if (this.o) {
      this.j.c().h();
      this.j.a().setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAw1BMVEUAAAAAAAD///8nJyfp6en+\n/v7///9UVFTj4+MMDAz19fX///8eHh49PT11dXX///////////////////8FBQUTExP///8bGxsW\nFhYsLCxQUFBkZGSLi4uioqKnp6e/v7/Z2dn////////////////////////////////5+fns7OxB\nQUETExPe3t78/Pz29vbm5ubw8PDV1dWwsLCHh4dbW1va2trExMSTk5NxcXFjY2Py8vLt7e3IyMi6\nurqbm5v///8IvZbOAAAAQHRSTlOAAE2K6k1HmeZ6Tj9yaFsrJx4EAX93M4Z1bWNeWFVUUVBEPCMa\nEhAKB/nskoTh/Pbn8drCrpvez7Okn/Lt0ci3+fRniwAAArFJREFUWMOll+l2qkAMgHNrQdGibFq1\nLrWubXHvete8/1NdMmgjCMGeyQ8PByaf2WcGfuTIYuK0aiPTMMxRreVMFnnrsgGzRu0qJbXG7FKA\nN2btJGPsXQDwHPMqV0zHKwD47lHdGNa7nbYVBFa7060PjSPC9SXA/CFeVu3bFiTEsvvV+NvDPB8w\nNWP1OmufMuoxwpzmAVxD2d5rQo40e/EKNxPgNxR/cAOC3AzUooZ/DvBb6tMdFMidWtbyzwAN5b0N\nhWJXlQ1pgEtv79l8yY17WusmAVOD9JtwkTSJYExPAXOT7Of/L7KBvDDnDPBV/dhwsdiqovwvgCvE\nX8iFewR4JuUfviUDcsI7AByKSWYAfla2LzlhoKg7BDgY0IMM+VghrsJsQk+ZoABjykBGBoO/iPsN\nlnNySZkYKwDNnzqcSekNVy9QyQNAnWYUAWZkgHXu/hZ/vYIAsMiEWQSgJujz+9tnJXvEZQkkAPRV\nS4DygGvoHx5lH4AMsJUPsKAcsgdrfFLyFplfALAokwuYRL9DfovIzwzYRe5wdJc7UDKMVCfgUA6K\nAEu8/iKUrnHJeXCABlFXBpBSTEg+dmk0AcWwIwJYLakPHYoijKLftgxgxYQ+tCPVEVAjWDKACQl9\nsKgdgHIRyAAmJPQhoAq4BMAE1meA4IIAYBeEIEoucBCFNEpB5DQKhSSlkQtJKGWpkLiUhWaSSpmb\nKd3OiLexJACbZDNtTto5PVC2eJBKmQHhenPazpt1yAMlPdI+fz8qWUUTlS1IjfaQR1ruUA3fEfdQ\nPFSFsf6B+B4UjXVxY/l8xF1YkTcWeWt7XePyiQDC1iZvrs9bxHUgb67y9l76sytL27vuAUP7iKN7\nyNI95ukeNHWPutqHbf3jvv6FQ//Ko3/p0r/26V889a+++pdv7ev/f9d/WD42EM2oAAAAAElFTkSu\nQmCC\n"));
      bool = false;
    } else {
      this.j.c().i();
      this.j.a().setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAA51BMVEUAAAAAAAD///////9VVVUM\nDAzj4+MTExMeHh49PT339/f////////////////////////////+/v4SEhL5+fnt7e0aGhoEBAQs\nLCxQUFBkZGRycnJ4eHiLi4uioqKnp6e/v7/Z2dny8vL////////////////////////7+/vHx8dC\nQkIrKyv39/fw8PDa2tpiYmLe3t66urqzs7Ourq6MjIyHh4f////V1dWampqTk5NxcXFra2tPT09I\nSEg1NTXp6enl5eXOzs5bW1s/Pz/y8vLm5ubCwsK8vLyioqJ4eHgeHh7////ORlUAAAAATHRSTlOA\nAE1HmXrmdnJoTkA9KyceEQT9hPjthn5tY15cW1hVVFFQTkQyIxoKB/vRkov28N6e4cjEwbCtNtq3\ns6Ohl5SO6+fVm5Hy587JuqaHiSSVHgAAAuFJREFUWMOll2lX4jAUhu9QCxRZSssqm8paliICCiIu\no7Pf//97hiSUtHSLJ+8HOJwkD7lrEvgWotEg38t2lURC6WZ7+cEobF4wQM9dJs50mdNFAcU+X+1l\n9IsCgGJeSYRKyRfjAIXT8utmvZZSq1U1Vas3r0+IQiRgmGXTMm1NBY9UrZ1hY9lhOEBX2PKGCgFS\nGwyh6GGAQoKqlYIQpVpsRiEYkKODnTREKN2hk3JBgEc6dAUxuqLTHjnA8/+3GsRKu/XsAdz236RB\nQOkb6gcvQKfrVRCSSgm6GzBUyP7TIKg0sUIZugA0fzQQlkYzigMKPv8LxaLgAIoKiT98SR1iRPEI\nyBNcoAPukvZDiBvImjwFsA20IEBPBqJhBhNadAsU0Cf1E5T/94jLn3gRUheksvoUQPpPA3yaztFa\nQzIMAA3SowhAJxtQ/ebb+OMDIgBqhmYT0CJow0n/Pj8nB60MXEzBB1jfwUltWhJALeA5tDWQyVgB\n+AAVw+I/NWoDjEg8uAUzLFPNP4AD3H61pycbyMoRDEj/5DMQgcsPgAX+Bkek0w6AZFFTAGAC1cSw\nXp2xJskl6B0+6/GAqTUGqjEunbH6YWkPSCHW4gHmDP+y8OKbM1YjJQndw2dKwIQ12o6bHRtSh6Vd\nUEgQRJxYRpYDc3x2hUEBEouqCOA7Ph2d4BRolawVB9zjn+P31g0QN2GDa74DboKYE1kYXrgPuBNF\nwwhLXDBQCafuMAonkmGwDTzjuyeRRFPZnG+dYKw8qfzVYtqjNfUU03k5I1aYggHmOy695XzeUGw8\nKrkPAozxreJpKL6WtiuXqCy0HvwA0yhNvC0ttKmavxBX/h3sXnxNlbd1/6kyhri2Hnmw7Eq4MZPR\nB0v00XYxw0UZ91FHW8zhOrERZ1GHa+zx/jreXEQd77IXDNkrjvQlS/aaJ3vRlL3qSl+25a/78g8O\n+SeP/KNL/tkn//CUf/rKP76ln///AWO5YPW0P5qvAAAAAElFTkSuQmCC\n"));
      bool = true;
    } 
    this.o = bool;
  }
  
  private void u() {
    gdtadv.getVresult(168, 0, new Object[] { this });
  }
  
  private void v() {
    if (!this.t) {
      this.B.f();
      this.t = true;
      h.a(e.a, this.v);
    } 
  }
  
  private String w() {
    g g1 = this.C;
    boolean bool = true;
    g1.a(1);
    this.C.a().a(this.j.getHeight());
    this.C.a().b(this.j.getWidth());
    h h1 = this.C.a();
    if (this.j.b().getVisibility() != 0)
      bool = false; 
    h1.b(bool);
    try {
      return this.C.b();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return null;
    } 
  }
  
  public void a() {
    boolean bool;
    this.C.b(System.currentTimeMillis());
    if (q.a(this.d)) {
      bool = true;
    } else {
      bool = true;
    } 
    a(bool, w());
    h.a(this.v);
  }
  
  public void a(int paramInt, String paramString) {
    gdtadv.getVresult(169, 0, new Object[] { this, Integer.valueOf(paramInt), paramString });
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, String paramString) {
    String str = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onDownloadProgress, finished : ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(" ,total : ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" ,progress : ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" ,videoUrl : ");
    stringBuilder.append(paramString);
    ak.a(str, stringBuilder.toString());
    d d1 = this.d;
    if (d1 != null) {
      String str1 = d1.k();
      if (str1 != null) {
        if (!str1.equals(paramString))
          return; 
      } else {
        return;
      } 
    } 
    this.m.a(paramInt);
    if (paramInt == 100)
      y.a(new Runnable(this) {
            public void run() {
              l.b(this.a).removeView((View)l.p(this.a));
            }
          }); 
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong) {
    b(paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    int i = m();
    byte b = 2;
    if (i == 2)
      u.a(1140003, 0, this.v); 
    if (!this.d.k_())
      b = 4; 
    if (paramBoolean)
      b = 10; 
    a(b, paramString);
  }
  
  public void b() {
    this.B.d();
    this.c.finish();
  }
  
  public com.qq.e.comm.plugin.s.a c() {
    return this.d;
  }
  
  public void d() {
    y.a(new Runnable(this) {
          public void run() {
            l.q(this.a);
          }
        });
  }
  
  public void e() {
    y.a(new Runnable(this) {
          public void run() {
            l.r(this.a);
          }
        });
  }
  
  public void f() {
    y.a(new Runnable(this) {
          public void run() {
            l.r(this.a);
          }
        });
  }
  
  public void i() {
    int i = this.j.c().f();
    if (i - this.A * 1000 >= 0) {
      g g1 = this.k;
      if (g1 != null && !g1.b() && !this.F)
        this.k.a(); 
    } 
    int k = this.j.c().e();
    int m = Math.min(k, this.z * 1000);
    int n = this.y;
    if (n >= 0 && i >= n * 1000 && this.j.b().getVisibility() != 0)
      this.j.b().setVisibility(0); 
    TextView textView = this.j.g();
    if (textView != null) {
      textView.setVisibility(0);
      n = (m - i) / 1000;
      if (n > 0)
        textView.setText(String.format(Locale.getDefault(), "奖励将于%d秒后发放", new Object[] { Integer.valueOf(n) })); 
    } 
    if (i >= m) {
      v();
      if (textView != null) {
        textView.setVisibility(0);
        textView.setText("恭喜获得奖励");
      } 
    } 
    if (m() == 1 && !this.u) {
      m = n.a(this.b);
      if (n.a(i, this.y, k, m)) {
        h h1 = this.l;
        if (h1 != null) {
          d d1 = this.d;
          if (d1 != null) {
            this.u = true;
            h1.a(d1.ak());
          } 
        } 
      } 
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAfterCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Landroid/app/Activity;
    //   4: invokevirtual getIntent : ()Landroid/content/Intent;
    //   7: astore_1
    //   8: aload_1
    //   9: ldc_w 'adinfo'
    //   12: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   15: astore_3
    //   16: aload_0
    //   17: aload_1
    //   18: ldc_w 'adThreadId'
    //   21: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   24: putfield f : Ljava/lang/String;
    //   27: aload_0
    //   28: aload_1
    //   29: ldc_w 'posId'
    //   32: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   35: putfield h : Ljava/lang/String;
    //   38: aload_0
    //   39: aload_1
    //   40: ldc_w 'styleUrl'
    //   43: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   46: putfield D : Ljava/lang/String;
    //   49: aload_0
    //   50: aload_0
    //   51: getfield D : Ljava/lang/String;
    //   54: invokestatic e : (Ljava/lang/String;)Ljava/io/File;
    //   57: putfield E : Ljava/io/File;
    //   60: aload_0
    //   61: getfield D : Ljava/lang/String;
    //   64: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   67: ifne -> 94
    //   70: aload_0
    //   71: getfield E : Ljava/io/File;
    //   74: astore #4
    //   76: aload #4
    //   78: ifnull -> 94
    //   81: aload #4
    //   83: invokevirtual exists : ()Z
    //   86: ifeq -> 94
    //   89: iconst_1
    //   90: istore_2
    //   91: goto -> 96
    //   94: iconst_0
    //   95: istore_2
    //   96: aload_0
    //   97: iload_2
    //   98: putfield F : Z
    //   101: aload_0
    //   102: aload_0
    //   103: getfield c : Landroid/app/Activity;
    //   106: invokevirtual getIntent : ()Landroid/content/Intent;
    //   109: ldc_w 'objectId'
    //   112: iconst_0
    //   113: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   116: invokestatic b : (I)Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   119: putfield B : Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   122: aload_0
    //   123: getfield B : Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   126: ifnonnull -> 143
    //   129: ldc_w 'RewardVideo activity fail to create ! ad instance pass failed'
    //   132: invokestatic e : (Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield c : Landroid/app/Activity;
    //   139: invokevirtual finish : ()V
    //   142: return
    //   143: aload_0
    //   144: aload_0
    //   145: getfield h : Ljava/lang/String;
    //   148: invokestatic a : (Ljava/lang/String;)I
    //   151: putfield y : I
    //   154: aload_0
    //   155: aload_0
    //   156: getfield h : Ljava/lang/String;
    //   159: invokestatic b : (Ljava/lang/String;)I
    //   162: putfield z : I
    //   165: aload_0
    //   166: getfield B : Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   169: invokevirtual g : ()V
    //   172: aload_0
    //   173: new com/qq/e/comm/plugin/ad/g
    //   176: dup
    //   177: invokespecial <init> : ()V
    //   180: putfield C : Lcom/qq/e/comm/plugin/ad/g;
    //   183: aload_0
    //   184: new com/qq/e/comm/plugin/ad/r
    //   187: dup
    //   188: aload_0
    //   189: getfield c : Landroid/app/Activity;
    //   192: invokespecial <init> : (Landroid/content/Context;)V
    //   195: putfield J : Lcom/qq/e/comm/plugin/ad/r;
    //   198: aload_0
    //   199: aload_0
    //   200: getfield B : Lcom/qq/e/comm/plugin/rewardvideo/j;
    //   203: invokevirtual j : ()Z
    //   206: putfield o : Z
    //   209: aload_0
    //   210: aload_1
    //   211: ldc_w 'appid'
    //   214: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   217: putfield g : Ljava/lang/String;
    //   220: aload_0
    //   221: aload_3
    //   222: invokespecial a : (Ljava/lang/String;)V
    //   225: aload_0
    //   226: invokespecial g : ()V
    //   229: aload_0
    //   230: invokespecial p : ()V
    //   233: aload_0
    //   234: new com/qq/e/comm/plugin/rewardvideo/f
    //   237: dup
    //   238: new com/qq/e/comm/plugin/c/a/c
    //   241: dup
    //   242: aload_0
    //   243: getfield c : Landroid/app/Activity;
    //   246: invokespecial <init> : (Landroid/content/Context;)V
    //   249: invokespecial <init> : (Lcom/qq/e/comm/plugin/c/a/c;)V
    //   252: putfield K : Lcom/qq/e/comm/plugin/rewardvideo/f;
    //   255: return
  }
  
  public void onBackPressed() {
    if (this.r)
      s(); 
  }
  
  public void onBeforeCreate(Bundle paramBundle) {
    this.e = "l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation());
    this.c.requestWindowFeature(1);
    Window window = this.c.getWindow();
    window.setBackgroundDrawable((Drawable)new ColorDrawable(Color.parseColor("#E6000000")));
    window.setFlags(1024, 1024);
    window.setFlags(16777216, 16777216);
    window.setFlags(128, 128);
  }
  
  public void onClick(View paramView) {
    byte b;
    if (paramView == this.i && this.I == 1 && this.J.a()) {
      this.C.b(System.currentTimeMillis());
      b = 3;
    } else {
      c c1 = this.j;
      if (c1 != null && paramView == c1.a()) {
        t();
        return;
      } 
      c1 = this.j;
      if (c1 != null && paramView == c1.b()) {
        r();
        return;
      } 
      c1 = this.j;
      if (c1 != null && paramView == c1.h()) {
        this.C.b(System.currentTimeMillis());
        b = 11;
      } else {
        return;
      } 
    } 
    a(b, w());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy() {
    g g1 = this.k;
    if (g1 != null)
      g1.c(); 
    h h1 = this.l;
    if (h1 != null)
      h1.c(); 
    c c1 = this.j;
    if (c1 != null) {
      c1.c().l();
      com.qq.e.comm.plugin.ab.d.a a2 = this.j.f();
      if (a2 != null)
        a2.a(); 
    } 
    y.a(null);
    if (!TextUtils.isEmpty(this.q))
      com.qq.e.comm.plugin.a.l.a().b(this.q, this); 
    a a1 = this.n;
    if (a1 != null && a1.isShowing())
      this.n.cancel(); 
  }
  
  public void onPause() {
    this.H = false;
    c c1 = this.j;
    if (c1 != null)
      c1.c().a(); 
  }
  
  public void onResume() {
    this.H = true;
    if (this.j != null) {
      a a1 = this.n;
      if (a1 == null || !a1.isShowing())
        this.j.c().b(); 
    } 
  }
  
  public void onStop() {}
  
  class a implements f.a {
    private a(l this$0) {}
    
    public void a() {}
    
    public void a(int param1Int, Exception param1Exception) {
      boolean bool;
      l l1 = this.a;
      if (l.l(l1)) {
        bool = true;
      } else {
        bool = true;
      } 
      l.b(l1, bool, 2);
      l.r(this.a);
      l.j(this.a).a(5003);
      l.a(this.a, true);
      h.a(param1Int, l.e(this.a), l.f(this.a).G(), param1Exception);
    }
    
    public void b() {
      l.a(this.a, false);
      int j = l.o(this.a).c().e() / 1000;
      int i = j;
      if (j <= 0)
        i = l.f(this.a).h(); 
      if (i > 0) {
        l.o(this.a).e().a(l.o(this.a).c(), 500, this.a);
        l.o(this.a).a().setVisibility(0);
      } 
      if (l.s(this.a) != 0L)
        bc.b(System.currentTimeMillis() - l.s(this.a), l.t(this.a), l.f(this.a).k(), l.e(this.a)); 
      if (l.o(this.a).h() != null && !l.u(this.a)) {
        j = l.b(this.a).getHeight();
        Activity activity = l.v(this.a);
        if (l.w(this.a)) {
          i = 8;
        } else if (q.a(l.f(this.a))) {
          i = 120;
        } else {
          i = 96;
        } 
        i = am.a((Context)activity, i);
        l.o(this.a).h().a(8, am.b((Context)l.v(this.a), j - i), l.w(this.a));
      } 
      l.o(this.a).d().setVisibility(4);
      h.b(l.e(this.a));
    }
    
    public void c() {
      boolean bool;
      l l1 = this.a;
      if (l.l(l1)) {
        bool = true;
      } else {
        bool = true;
      } 
      l.b(l1, bool, 0);
      l.r(this.a);
      l.j(this.a).i();
      l.x(this.a);
      l.a(this.a, true);
      h.a(f.d.g, l.e(this.a));
    }
    
    public void d() {
      l.a(this.a, true);
    }
    
    public void e() {
      boolean bool;
      l l1 = this.a;
      if (l.l(l1)) {
        bool = true;
      } else {
        bool = true;
      } 
      l.b(l1, bool, 0);
      h.a(f.d.f, l.e(this.a));
    }
    
    public void f() {
      l.b(this.a, true);
      h.a(f.d.d, l.e(this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */