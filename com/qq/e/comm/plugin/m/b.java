package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.MediaEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.aa.a.a;
import com.qq.e.comm.plugin.ab.j;
import com.qq.e.comm.plugin.ad.a;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.j;
import com.qq.e.comm.plugin.j.a;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.nativeadunified.b;
import com.qq.e.comm.plugin.nativeadunified.c;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.a;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.bc;
import com.qq.e.comm.plugin.util.m;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import org.json.JSONObject;

public class b implements NativeExpressADData2, ADEventListener, a, b {
  public String a;
  
  public String b;
  
  int c;
  
  VideoOption2 d;
  
  protected c e = new c();
  
  public k f;
  
  protected boolean g;
  
  private Context h;
  
  private c i;
  
  private ADListener j;
  
  private d k = new d();
  
  private Handler l;
  
  private int m;
  
  private i n;
  
  private com.qq.e.comm.plugin.w.b o;
  
  private g p;
  
  private boolean q;
  
  private b.c r;
  
  private b.d s = b.d.a;
  
  private String t;
  
  private com.qq.e.comm.plugin.aa.a.b u;
  
  private boolean v;
  
  private String w;
  
  private g x;
  
  public b(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, int paramInt1, int paramInt2, int paramInt3, VideoOption2 paramVideoOption2) {
    this.h = paramContext;
    this.a = paramString2;
    this.b = a.a(paramString1, this.a, o.b());
    this.i = a(paramString1, this.a, this.b, paramJSONObject, paramInt2, paramInt3, paramVideoOption2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b.class.getSimpleName());
    stringBuilder.append(this.i.m());
    this.w = stringBuilder.toString();
    this.c = paramInt1;
    this.d = paramVideoOption2;
    this.e.a(this.a);
    this.e.b(this.i.m());
    this.e.c(this.i.H());
    this.k.a("posId", paramString2);
    this.k.a("appid", paramString1);
    this.o = new com.qq.e.comm.plugin.w.b(this.b, e.w, this.a);
    this.l = new Handler(Looper.getMainLooper());
    this.p = new g();
    if (this.i.ah()) {
      q();
      if (!o()) {
        SM sM = GDTADManager.getInstance().getSM();
        paramInt1 = 1;
        if (sM.getInteger("Express2_Preload_Video", 1) != 1)
          paramInt1 = 0; 
        if (paramInt1 != 0)
          r(); 
      } else {
        a(301, (String)null);
      } 
    } 
    if (this.i.v())
      l.a().a(this.i.z().d(), this); 
    j.e().a(this.i.o(), null);
    l();
    this.x = new g(this.h, this, this.i);
  }
  
  private boolean o() {
    return (this.s == b.d.d && !TextUtils.isEmpty(this.t));
  }
  
  private void p() {
    k k1 = this.f;
    if (k1 != null)
      k1.a(this.t); 
    if (!this.q) {
      a(201, new Object[0]);
      this.q = true;
    } 
  }
  
  private void q() {
    File file = aj.d(this.i.G());
    if (file != null && file.exists()) {
      this.s = b.d.d;
      this.t = file.getAbsolutePath();
    } 
  }
  
  private void r() {
    if (!this.i.ah())
      return; 
    if (o()) {
      p();
      return;
    } 
    if (this.u == null) {
      this.u = (new com.qq.e.comm.plugin.aa.a.b.a()).b(this.i.G()).a(aj.a(this.i.G())).a(aj.f()).a();
      a.a().a(this.u, this.i.G(), new a(this) {
            public void a() {
              b.a(this.a, b.d.b);
              if (this.a.f != null)
                this.a.f.p(); 
              ak.a(b.i(this.a), "Video download onStarted: ");
            }
            
            public void a(long param1Long1, long param1Long2, int param1Int) {
              if (b.j(this.a) != null)
                b.j(this.a).a(param1Int); 
              if (this.a.f != null)
                this.a.f.a(param1Long1, param1Long2, param1Int); 
            }
            
            public void a(long param1Long, boolean param1Boolean) {
              b.a(this.a, (int)(param1Long >> 10L));
            }
            
            public void a(c param1c) {
              b.a(this.a, b.d.e);
              if (b.j(this.a) != null)
                b.j(this.a).b(); 
              this.a.a(207, new Object[0]);
              b.a(this.a, true);
              if (this.a.f != null)
                this.a.f.a((String)null); 
              this.a.a();
              String str = b.i(this.a);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Video download onFailed e: ");
              stringBuilder.append(param1c.b());
              ak.a(str, stringBuilder.toString());
              b b1 = this.a;
              b1.a(302, b.f(b1).G());
            }
            
            public void a(File param1File, long param1Long) {
              if (b.j(this.a) != null)
                b.j(this.a).a(); 
              b.k(this.a);
              if (b.c(this.a))
                b.d(this.a); 
              bc.a(param1Long, b.l(this.a), b.f(this.a).r(), this.a.e);
              ak.a(b.i(this.a), "Video download onCompleted: ");
            }
            
            public void b() {
              b.a(this.a, b.d.c);
            }
            
            public void c() {}
          });
    } 
  }
  
  private void s() {
    ac.a(this.i.y());
  }
  
  protected c a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, int paramInt1, int paramInt2, VideoOption2 paramVideoOption2) {
    boolean bool;
    c c1 = new c(paramString1, paramString2, paramString3, e.w, paramJSONObject, paramInt1, paramInt2, paramVideoOption2);
    if (c1.v() && c1.ah() && com.qq.e.comm.plugin.l.b.a(c1.Z())) {
      bool = true;
    } else {
      bool = false;
    } 
    c1.c(bool);
    return c1;
  }
  
  protected e a(Context paramContext, c paramc, VideoOption2 paramVideoOption2, i.a parama, c paramc1) {
    return new e(paramContext, paramc, paramVideoOption2, parama, paramc1);
  }
  
  public void a() {
    byte b1;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    String str1 = this.i.q();
    String str2 = this.i.t();
    int m = this.i.g();
    k k1 = this.f;
    int j = 0;
    if (k1 != null) {
      b1 = k1.k();
      if (b1 == 0)
        j = this.f.n(); 
      if (this.f.o() > 0)
        m = this.f.o(); 
      bool1 = this.f.m();
      bool3 = this.f.l();
      bool2 = this.f.j();
    } else {
      bool1 = true;
      bool2 = true;
      bool3 = true;
      b1 = 2;
      j = 0;
    } 
    d.a(bool1, bool2, bool3, b1, j, m, str1, this.o, new d.b(this, str2) {
          public void a() {
            if (!StringUtil.isEmpty(this.a))
              ah.a(this.a); 
          }
          
          public void a(int param1Int, Exception param1Exception) {}
        });
  }
  
  public void a(int paramInt) {
    k k1 = this.f;
    if (k1 != null)
      k1.a(paramInt); 
  }
  
  protected void a(int paramInt, String paramString) {
    h.a(paramInt, this.e, paramString);
  }
  
  public void a(int paramInt, Object... paramVarArgs) {
    if (this.j != null)
      this.l.post(new Runnable(this, paramInt, paramVarArgs) {
            public void run() {
              if (b.m(this.c) != null)
                b.m(this.c).onADEvent(new ADEvent(this.a, this.b)); 
            }
          }); 
  }
  
  public void a(View paramView) {
    if (this.g)
      return; 
    if (this.f != null || paramView != null) {
      if (paramView == null)
        paramView = this.f.q(); 
      this.g = true;
      a.a().a(paramView);
      a(102, new Object[0]);
      paramView.post(new Runnable(this, paramView) {
            public void run() {
              byte b1;
              String str2 = b.f(this.b).q();
              String str1 = str2;
              if (b.f(this.b).ah())
                str1 = i.a(str2); 
              str2 = b.f(this.b).t();
              g g = b.g(this.b);
              View view = this.a;
              if (b.f(this.b).ah()) {
                b1 = 1;
              } else {
                b1 = 2;
              } 
              i.a(g.a(view, b1, b.f(this.b).x(), null), a.a().b(this.a), b.f(this.b), b.h(this.b), str1, new d.b(this, str2) {
                    public void a() {
                      if (!m.a(this.a))
                        ah.a(this.a); 
                    }
                    
                    public void a(int param2Int, Exception param2Exception) {}
                  });
            }
          });
      this.i.V();
      this.i.W();
      m();
    } 
  }
  
  public void a(View paramView, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2) {
    a(paramString4, paramInt);
  }
  
  public void a(View paramView, String paramString, boolean paramBoolean) {
    this.x.a(paramView, paramString);
  }
  
  public void a(b.a parama) {
    k k1 = this.f;
    if (k1 != null)
      k1.a(parama); 
  }
  
  public void a(b.b paramb) {
    k k1 = this.f;
    if (k1 != null)
      k1.a(paramb); 
  }
  
  public void a(b.c paramc) {
    this.r = paramc;
  }
  
  protected void a(String paramString) {
    this.x.a(paramString);
  }
  
  protected void a(String paramString, int paramInt) {
    a(paramString, paramInt, -1);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2) {
    if (this.f != null) {
      d.a a1 = i.a(this.i);
      d.e e = new d.e(this.b, e.w, this.a);
      d.b b1 = d.a(paramInt1, paramInt2, this.i, this.f.q(), paramString, this.c);
      b1.i = a.a().b(this.f.q());
      d.a(this.f.q(), a1, e, b1);
    } 
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong) {
    String str = this.w;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onAPKStatusUpdate: pkgName:");
    stringBuilder.append(paramString);
    stringBuilder.append(",status:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",progress:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(",totalSize:");
    stringBuilder.append(paramLong);
    ak.a(str, stringBuilder.toString());
    j j = this.i.z();
    if (j != null) {
      j.a(paramInt2);
      j.c(paramInt1);
    } 
    k k1 = this.f;
    if (k1 != null)
      k1.a(paramString, paramInt1, paramInt2, paramLong); 
  }
  
  public void a(boolean paramBoolean) {
    r();
  }
  
  protected void b(int paramInt) {
    h.b(paramInt, this.e);
  }
  
  public boolean b() {
    return this.v;
  }
  
  public c c() {
    return this.i;
  }
  
  protected void c(int paramInt) {
    h.c(paramInt, this.e);
  }
  
  public boolean d() {
    k k1 = this.f;
    return (k1 != null) ? k1.w() : true;
  }
  
  public void destroy() {
    i i1 = this.n;
    if (i1 != null)
      i1.c(); 
  }
  
  public g e() {
    return this.p;
  }
  
  public void e_() {
    k k1 = this.f;
    if (k1 != null)
      k1.a(); 
  }
  
  public b.d f() {
    return this.s;
  }
  
  public View getAdView() {
    k k1 = this.f;
    return (k1 != null) ? k1.q() : null;
  }
  
  public String getECPMLevel() {
    return this.i.J();
  }
  
  public int getVideoDuration() {
    return this.i.g();
  }
  
  public b.b h() {
    k k1 = this.f;
    return (k1 != null) ? k1.r() : null;
  }
  
  public int i() {
    k k1 = this.f;
    return (k1 != null) ? k1.s() : 0;
  }
  
  public boolean isVideoAd() {
    return this.i.ah();
  }
  
  public void j() {
    k k1 = this.f;
    if (k1 != null)
      k1.t(); 
  }
  
  public void k() {
    if (this.f != null && this == c.a()) {
      this.f.v();
      c.g();
    } 
  }
  
  protected void l() {
    h.a(this.i.ah(), this.e);
  }
  
  protected void m() {
    h.b(this.e);
  }
  
  public void render() {
    if (this.h != null && e.w == this.i.C())
      ab.a().a(this.a); 
    this.l.post(new Runnable(this) {
          public void run() {
            if (b.a(this.a) == null) {
              i.a a = new i.a(this) {
                  public void a(int param2Int) {
                    this.a.a.a(104, new Object[0]);
                    this.a.a.b(param2Int);
                  }
                  
                  public void a(k param2k) {
                    this.a.a.f = param2k;
                    this.a.a.f.a(new j(this) {
                          public void a() {
                            this.a.a.a.a((View)null);
                          }
                          
                          public void a(int param3Int, int... param3VarArgs) {
                            switch (param3Int) {
                              default:
                                return;
                              case 208:
                                this.a.a.a.a(false);
                                return;
                              case 204:
                              case 205:
                              case 206:
                              case 207:
                                this.a.a.a.a();
                                break;
                              case 202:
                                b.b(this.a.a.a);
                                this.a.a.a.a(param3Int, new Object[0]);
                                return;
                              case 201:
                              case 203:
                                break;
                            } 
                            this.a.a.a.a(param3Int, new Object[0]);
                          }
                          
                          public void a(String param3String) {
                            this.a.a.a.a(param3String);
                          }
                          
                          public void b() {
                            this.a.a.a.a(105, new Object[0]);
                          }
                        });
                    this.a.a.a(103, new Object[0]);
                    if (b.c(this.a.a))
                      b.d(this.a.a); 
                    this.a.a.b(101);
                  }
                };
              b b1 = this.a;
              b.a(b1, b1.a(b.e(b1), b.f(this.a), this.a.d, a, this.a.e));
            } 
            b.a(this.a).b();
            this.a.b(104);
          }
        });
  }
  
  public void setAdEventListener(AdEventListener paramAdEventListener) {}
  
  public void setAdListener(ADListener paramADListener) {
    this.j = paramADListener;
  }
  
  public void setMediaListener(MediaEventListener paramMediaEventListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */