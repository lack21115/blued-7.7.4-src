package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.aa.b.b;
import com.qq.e.comm.plugin.aa.b.d;
import com.qq.e.comm.plugin.ab.b.b;
import com.qq.e.comm.plugin.ab.d.a;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.ab.j;
import com.qq.e.comm.plugin.ad.a;
import com.qq.e.comm.plugin.c.c;
import com.qq.e.comm.plugin.gdtnativead.a.c;
import com.qq.e.comm.plugin.nativeadunified.b;
import com.qq.e.comm.plugin.nativeadunified.c;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.be;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class f implements d.a, c.a, k {
  private m A;
  
  private int a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private b.b e;
  
  private j f;
  
  private Context g;
  
  private a h;
  
  private MediaView i;
  
  private com.qq.e.comm.plugin.aa.b.f j;
  
  private c k;
  
  private String l;
  
  private AtomicBoolean m;
  
  private boolean n;
  
  private az o;
  
  private int p;
  
  private b.a q;
  
  private a r;
  
  private boolean s;
  
  private String t;
  
  private VideoOption2 u;
  
  private boolean v;
  
  private int w;
  
  private boolean x;
  
  private boolean y;
  
  private int z;
  
  f(Context paramContext, a parama, MediaView paramMediaView, com.qq.e.comm.plugin.aa.b.f paramf, c paramc, a parama1, String paramString, VideoOption2 paramVideoOption2) {
    boolean bool = true;
    this.a = 1;
    this.b = 1;
    this.c = 1;
    this.d = 1;
    this.e = b.b.a;
    this.m = new AtomicBoolean(false);
    this.w = 0;
    this.z = 0;
    this.g = paramContext;
    this.h = parama;
    this.i = paramMediaView;
    this.j = paramf;
    this.k = paramc;
    this.r = parama1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(f.class.getSimpleName());
    stringBuilder.append(paramString);
    this.t = stringBuilder.toString();
    this.u = paramVideoOption2;
    c c1 = this.k;
    if (c1 != null && this.j != null) {
      c1.a(this);
      this.j.a((b)this.k);
      C();
    } 
    if (GDTADManager.getInstance().getSM().getInteger("express2CheckWindowFocus", 1) != 1)
      bool = false; 
    this.n = bool;
    this.h.a(new a.a(this) {
          public void a() {
            f.a(this.a, true);
          }
          
          public void a(int param1Int) {
            if (param1Int == 0) {
              f.a(this.a, false);
              return;
            } 
            f.a(this.a);
          }
          
          public void b() {
            f.a(this.a);
          }
          
          public void c() {
            f.a(this.a);
          }
          
          public void d() {
            f.a(this.a, true);
          }
        });
  }
  
  private void A() {
    if (this.s)
      return; 
    this.s = true;
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("expressShow", true);
      a("onAdExposure", jSONObject);
      ak.a(this.t, "callJsExpressShow");
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  private boolean B() {
    if (this.u != null) {
      boolean bool;
      if (GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI) {
        bool = true;
      } else {
        bool = false;
      } 
      int i = null.b[this.u.getAutoPlayPolicy().ordinal()];
      if (i != 1) {
        if (i != 2 && i == 3)
          return false; 
      } else {
        return bool;
      } 
    } 
    return true;
  }
  
  private void C() {
    VideoOption2 videoOption2 = this.u;
    if (videoOption2 == null || videoOption2.isAutoPlayMuted()) {
      this.j.h();
      return;
    } 
    this.j.i();
  }
  
  private void a(int paramInt1, int paramInt2) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("status", paramInt1);
      jSONObject.put("progress", paramInt2);
      a("onAPKStatusUpdate", jSONObject);
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  private void a(String paramString, JSONObject paramJSONObject) {
    this.r.c().a(new b(paramString, paramJSONObject));
  }
  
  private void b(int paramInt) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("status", paramInt);
      a("onViewableChange", jSONObject);
      ak.a(this.t, "callJsViewableChange");
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  private void c(boolean paramBoolean) {
    if (!this.x)
      return; 
    az az1 = this.o;
    if (az1 == null) {
      this.o = new az(this, Long.MAX_VALUE, 200L) {
          public void a() {}
          
          public void a(long param1Long) {
            f.b(this.a);
          }
        };
      this.o.b();
    } else {
      az1.e();
    } 
    if (paramBoolean && this.e == b.b.e)
      this.e = b.b.a; 
  }
  
  private void d(boolean paramBoolean) {
    this.m.set(false);
    if (this.j != null) {
      b.b b1;
      if (paramBoolean) {
        b1 = b.b.d;
      } else {
        b1 = b.b.c;
      } 
      this.e = b1;
      this.j.a();
    } 
  }
  
  private void y() {
    if (!this.x)
      return; 
    az az1 = this.o;
    if (az1 != null)
      az1.d(); 
    com.qq.e.comm.plugin.aa.b.f f1 = this.j;
    if (f1 != null && f1 != c.b() && this.j.c())
      this.j.a(); 
  }
  
  private boolean z() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a() {
    this.m.set(true);
    if (!TextUtils.isEmpty(this.l)) {
      if (this.j != null) {
        this.e = b.b.b;
        this.j.b();
        String str = this.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("playVideo: mControllerViewListener = ");
        stringBuilder.append(this.q);
        ak.a(str, stringBuilder.toString());
        b.a a1 = this.q;
        if (a1 != null) {
          a1.d();
          return;
        } 
      } 
    } else if (TextUtils.isEmpty(this.l)) {
      j j1 = this.f;
      if (j1 != null)
        j1.a(208, new int[0]); 
    } 
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(int paramInt, Exception paramException) {
    this.w = 5;
    this.c = 2;
    this.e = b.b.h;
    j j1 = this.f;
    if (j1 != null)
      j1.a(207, new int[0]); 
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {
    if (paramLong1 < paramLong2 && B())
      this.w = 1; 
  }
  
  void a(e parame, String paramString1, String paramString2, String paramString3) {
    JSONObject jSONObject;
    int i;
    String str = this.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(" param: ");
    stringBuilder.append(paramString2);
    ak.a(str, stringBuilder.toString());
    switch (paramString1.hashCode()) {
      default:
        i = -1;
        break;
      case 1070487396:
        if (paramString1.equals("changeVideoMute")) {
          i = 2;
          break;
        } 
      case 217446186:
        if (paramString1.equals("clickCloseEvent")) {
          i = 5;
          break;
        } 
      case -401693945:
        if (paramString1.equals("clickLogoEvent")) {
          i = 1;
          break;
        } 
      case -620782193:
        if (paramString1.equals("clickAdEvent")) {
          i = 0;
          break;
        } 
      case -1169135450:
        if (paramString1.equals("changeVideoState")) {
          i = 3;
          break;
        } 
      case -1926689588:
        if (paramString1.equals("getVideoState")) {
          i = 4;
          break;
        } 
    } 
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            j j1;
            if (i != 4) {
              if (i != 5)
                return; 
              j1 = this.f;
              if (j1 != null) {
                j1.b();
                return;
              } 
            } else {
              try {
                i = n();
                JSONObject jSONObject1 = new JSONObject();
                jSONObject1.put("state", this.w);
                jSONObject1.put("currentTime", i);
                jSONObject1.put("totalTime", this.p);
                jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("data", jSONObject1);
                j1.a(paramString3, 0, jSONObject.toString(), 0);
                if (this.A != null) {
                  this.A.a(i);
                  return;
                } 
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
                return;
              } 
            } 
          } else {
            i = (new JSONObject((String)jSONObject)).optInt("stateType");
            if (i == 2) {
              a();
              return;
            } 
            if (i == 3) {
              d(true);
              return;
            } 
          } 
        } else if (this.j != null) {
          if ((new JSONObject((String)jSONObject)).optBoolean("mute")) {
            this.j.h();
            return;
          } 
          this.j.i();
          return;
        } 
      } else {
        c.a((new JSONObject((String)jSONObject)).optString("url"), null);
        return;
      } 
    } else if (this.f != null) {
      A();
      this.f.a((String)jSONObject);
    } 
  }
  
  public void a(j paramj) {
    this.f = paramj;
  }
  
  public void a(m paramm) {
    this.A = paramm;
  }
  
  public void a(b.a parama) {
    this.q = parama;
  }
  
  public void a(b.b paramb) {
    this.e = paramb;
  }
  
  public void a(String paramString) {
    this.l = paramString;
    if (!TextUtils.isEmpty(this.l)) {
      this.c = 0;
      com.qq.e.comm.plugin.aa.b.f f1 = this.j;
      if (f1 != null)
        f1.a(this.l); 
      if (this.m.get()) {
        a();
        return;
      } 
    } else {
      this.c = 2;
      this.w = 5;
    } 
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong) {
    b.a a1 = this.q;
    if (a1 != null)
      a1.a(paramString, paramInt1, paramInt2, paramLong); 
    a(paramInt1, paramInt2);
  }
  
  void a(boolean paramBoolean) {
    this.x = paramBoolean;
  }
  
  public void b(boolean paramBoolean) {
    b.b b1;
    if (!paramBoolean)
      this.d = 0; 
    b.a a1 = this.q;
    if (a1 != null)
      a1.c(); 
    if (paramBoolean) {
      b1 = b.b.d;
    } else {
      b1 = b.b.b;
    } 
    this.e = b1;
  }
  
  public void b_() {
    this.c = 0;
    com.qq.e.comm.plugin.aa.b.f f1 = this.j;
    if (f1 != null)
      this.p = f1.e(); 
  }
  
  public void c_() {
    this.w = 2;
    j j1 = this.f;
    if (j1 != null)
      j1.a(202, new int[0]); 
    String str = this.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onVideoStart: mControllerViewListener = ");
    stringBuilder.append(this.q);
    ak.a(str, stringBuilder.toString());
    b.a a1 = this.q;
    if (a1 != null)
      a1.d(); 
  }
  
  public void f_() {
    this.w = 4;
    this.e = b.b.e;
    j j1 = this.f;
    if (j1 != null)
      j1.a(206, new int[0]); 
    this.b = 3;
  }
  
  public void g() {
    this.w = 2;
    this.b = 2;
    j j1 = this.f;
    if (j1 != null)
      j1.a(203, new int[0]); 
    b.a a1 = this.q;
    if (a1 != null)
      a1.d(); 
  }
  
  public void g_() {
    this.w = 4;
    this.e = b.b.e;
    j j1 = this.f;
    if (j1 != null)
      j1.a(205, new int[0]); 
  }
  
  public void h_() {
    this.w = 3;
    j j1 = this.f;
    if (j1 != null && !this.y)
      j1.a(204, new int[0]); 
    this.y = false;
  }
  
  public void i_() {
    b.a a1 = this.q;
    if (a1 != null)
      a1.a(); 
  }
  
  public int j() {
    return this.a;
  }
  
  public void j_() {
    b.a a1 = this.q;
    if (a1 != null)
      a1.b(); 
  }
  
  public int k() {
    return this.c;
  }
  
  public int l() {
    return this.b;
  }
  
  public int m() {
    return this.d;
  }
  
  public int n() {
    com.qq.e.comm.plugin.aa.b.f f1 = this.j;
    return (f1 != null) ? f1.f() : this.z;
  }
  
  public int o() {
    return this.p;
  }
  
  public void p() {
    if (B())
      this.w = 1; 
  }
  
  public View q() {
    return (View)this.h;
  }
  
  public b.b r() {
    return this.e;
  }
  
  public int s() {
    return a.a().b((View)this.h);
  }
  
  public void t() {
    this.q = null;
  }
  
  public void u() {
    this.i.removeView((View)this.j);
    this.i.removeView((View)this.k);
    this.k.b(true);
    c.a((b)this.k);
    c.a(this.j);
    c.a(n());
    com.qq.e.comm.plugin.aa.b.f f1 = this.j;
    if (f1 != null && !f1.c())
      this.d = 0; 
    y();
  }
  
  public void v() {
    this.y = true;
    be.a((View)this.j);
    be.a((View)this.k);
    MediaView mediaView = this.i;
    if (mediaView != null) {
      mediaView.addView((View)this.j);
      this.i.addView((View)this.k);
    } 
    c c1 = this.k;
    if (c1 != null)
      c1.d(); 
    this.a = 1;
    if (this.j != null)
      C(); 
    c1 = this.k;
    if (c1 != null)
      c1.b(); 
  }
  
  public boolean w() {
    return !(Build.VERSION.SDK_INT >= 11 && !this.h.isHardwareAccelerated());
  }
  
  public void x() {
    if (this.e == b.b.b) {
      this.j.a();
      this.e = b.b.f;
    } 
    MediaView mediaView = this.i;
    if (mediaView != null) {
      mediaView.removeAllViews();
      this.i = null;
    } 
    com.qq.e.comm.plugin.aa.b.f f1 = this.j;
    if (f1 != null) {
      this.z = f1.f();
      this.j.l();
      this.j = null;
    } 
    c c1 = this.k;
    if (c1 != null) {
      c1.i();
      this.k.removeAllViews();
      this.k = null;
    } 
    az az1 = this.o;
    if (az1 != null)
      az1.c(); 
    this.r.a();
    j.e().d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */