package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ab.d.a;
import com.qq.e.comm.plugin.ab.f.a.b;
import com.qq.e.comm.plugin.gdtnativead.a.c;
import com.qq.e.comm.plugin.m.a.a;
import com.qq.e.comm.plugin.m.a.b;
import com.qq.e.comm.plugin.m.a.c;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.z.c;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements i {
  protected Context a;
  
  protected c b;
  
  protected c c;
  
  protected boolean d = true;
  
  private a e;
  
  private f f;
  
  private i.a g;
  
  private AtomicBoolean h;
  
  private a i;
  
  private MediaView j;
  
  private f k;
  
  private c l;
  
  private String m;
  
  private Handler n;
  
  private long o;
  
  private b p = new b(this) {
      public String a() {
        return "getAdInfo";
      }
      
      public void a(com.qq.e.comm.plugin.ab.f.e param1e, String param1String1, String param1String2, String param1String3) {
        try {
          JSONObject jSONObject2 = new JSONObject();
          jSONObject2.put("adInfo", this.a.d());
          jSONObject2.put("adSize", this.a.f());
          jSONObject2.put("setting", this.a.e());
          jSONObject2.put("cfg", this.a.b.Z().a());
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("code", 0);
          jSONObject1.put("data", jSONObject2);
          String str = e.a(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("getAdInfoActionHandler result: ");
          stringBuilder.append(jSONObject1);
          ak.a(str, stringBuilder.toString());
          param1e.a(param1String3, 0, jSONObject1.toString(), 0);
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        this.a.a(System.currentTimeMillis() - e.b(this.a));
      }
    };
  
  private b q = new b(this) {
      public String a() {
        return "renderDidFinish";
      }
      
      public void a(com.qq.e.comm.plugin.ab.f.e param1e, String param1String1, String param1String2, String param1String3) {
        boolean bool1;
        e.d(this.a).removeCallbacks(e.c(this.a));
        boolean bool3 = false;
        try {
          String str = e.a(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("renderDidFinishActionHandler param: ");
          stringBuilder.append(param1String2);
          ak.a(str, stringBuilder.toString());
          JSONObject jSONObject = new JSONObject(param1String2);
          boolean bool = jSONObject.optBoolean("isRenderSuc", false);
          bool1 = bool;
          if (bool)
            try {
              bool1 = this.a.b.ah();
              if (bool1 && e.e(this.a) != null) {
                JSONObject jSONObject1 = jSONObject.optJSONObject("videoInfo");
                if (jSONObject1 != null) {
                  float f1 = am.a(this.a.a, (float)jSONObject1.optDouble("x", 0.0D));
                  float f2 = am.a(this.a.a, (float)jSONObject1.optDouble("y", 0.0D));
                  float f3 = am.a(this.a.a, (float)jSONObject1.optDouble("width", 0.0D));
                  float f4 = am.a(this.a.a, (float)jSONObject1.optDouble("height", 0.0D));
                  FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Math.round(f3), Math.round(f4));
                  layoutParams.leftMargin = Math.round(f1);
                  layoutParams.topMargin = Math.round(f2);
                  e.e(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                } 
              } 
              jSONObject = jSONObject.optJSONObject("adSize");
              if (jSONObject != null) {
                float f1 = am.a(this.a.a, (float)jSONObject.optDouble("width", 0.0D));
                float f2 = am.a(this.a.a, (float)jSONObject.optDouble("height", 0.0D));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Math.round(f1 + 0.5F), Math.round(f2 + 0.5F));
                layoutParams.gravity = 17;
                e.f(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                bool1 = bool;
              } else {
                bool1 = false;
              } 
            } catch (JSONException jSONException) {
              bool1 = bool;
              jSONException.printStackTrace();
            }  
        } catch (JSONException jSONException) {
          bool1 = false;
          jSONException.printStackTrace();
        } 
        boolean bool2 = bool3;
        if (bool1) {
          bool2 = bool3;
          if (!e.g(this.a).get())
            bool2 = true; 
        } 
        e e1 = this.a;
        if (bool2) {
          if (e.h(e1) != null)
            e.h(this.a).a(e.i(this.a)); 
        } else {
          e.a(e1, 103);
        } 
        e.i(this.a).a(bool2);
        this.a.b(System.currentTimeMillis() - e.b(this.a));
      }
    };
  
  private b r = new b(this) {
      public String a() {
        return "getVideoState";
      }
      
      public void a(com.qq.e.comm.plugin.ab.f.e param1e, String param1String1, String param1String2, String param1String3) {
        e.i(this.a).a(param1e, param1String1, param1String2, param1String3);
      }
    };
  
  private b s = new b(this) {
      public String a() {
        return "changeVideoState";
      }
      
      public void a(com.qq.e.comm.plugin.ab.f.e param1e, String param1String1, String param1String2, String param1String3) {
        e.i(this.a).a(param1e, param1String1, param1String2, param1String3);
      }
    };
  
  private b t = new b(this) {
      public String a() {
        return "changeVideoMute";
      }
      
      public void a(com.qq.e.comm.plugin.ab.f.e param1e, String param1String1, String param1String2, String param1String3) {
        e.i(this.a).a(param1e, param1String1, param1String2, param1String3);
      }
    };
  
  private b u = new b(this) {
      public String a() {
        return "clickAdEvent";
      }
      
      public void a(com.qq.e.comm.plugin.ab.f.e param1e, String param1String1, String param1String2, String param1String3) {
        e.i(this.a).a(param1e, param1String1, param1String2, param1String3);
      }
    };
  
  private b v = new b(this) {
      public String a() {
        return "clickCloseEvent";
      }
      
      public void a(com.qq.e.comm.plugin.ab.f.e param1e, String param1String1, String param1String2, String param1String3) {
        e.i(this.a).a(param1e, param1String1, param1String2, param1String3);
      }
    };
  
  private b w = new b(this) {
      public String a() {
        return "clickLogoEvent";
      }
      
      public void a(com.qq.e.comm.plugin.ab.f.e param1e, String param1String1, String param1String2, String param1String3) {
        e.i(this.a).a(param1e, param1String1, param1String2, param1String3);
      }
    };
  
  private Runnable x = new Runnable(this) {
      public void run() {
        e.g(this.a).set(true);
        e.a(this.a, 102);
        ak.a(e.a(this.a), "RenderOverTime");
      }
    };
  
  public e(Context paramContext, c paramc, VideoOption2 paramVideoOption2, i.a parama, c paramc1) {
    this.a = paramContext;
    this.b = paramc;
    this.g = parama;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e.class.getSimpleName());
    stringBuilder.append(this.b.m());
    this.m = stringBuilder.toString();
    this.i = new a(this.a);
    a();
    g();
    this.f = new f(this.a, this.i, this.j, this.k, this.l, this.e, this.b.m(), paramVideoOption2);
    this.c = paramc1;
    this.n = new Handler(Looper.getMainLooper());
    this.h = new AtomicBoolean(false);
  }
  
  private void a(int paramInt) {
    i.a a1 = this.g;
    if (a1 != null)
      a1.a(paramInt); 
    this.n.post(new Runnable(this) {
          public void run() {
            e.i(this.a).x();
          }
        });
  }
  
  private void g() {
    this.e = (new com.qq.e.comm.plugin.ab.d.e(this.a, null, true)).a();
    a(this.e.c());
    View view = this.e.b();
    view.setBackgroundColor(0);
    this.e.a(false);
    this.i.addView(view, -1, -1);
  }
  
  private boolean h() {
    return this.b.h();
  }
  
  public void a() {
    if (this.b.ah()) {
      this.j = new MediaView(this.a);
      this.k = new f(this.a);
      this.l = new c(this.a, 1, this.b.o(), this.d, false);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
      layoutParams.gravity = 17;
      this.j.addView((View)this.k, (ViewGroup.LayoutParams)layoutParams);
      this.j.addView((View)this.l, (ViewGroup.LayoutParams)layoutParams);
      this.l.b();
      this.i.addView((View)this.j);
    } 
  }
  
  protected void a(long paramLong) {
    h.a(paramLong, this.c);
  }
  
  public void a(com.qq.e.comm.plugin.ab.f.e parame) {
    parame.a(this.p).a(this.q).a(this.r).a(this.s).a(this.t).a(this.u).a(this.v).a(this.w).a((b)new a()).a((b)new b()).a((b)new c());
  }
  
  protected void a(String paramString) {
    this.n.removeCallbacks(this.x);
    this.h.set(false);
    this.n.postDelayed(this.x, GDTADManager.getInstance().getSM().getInteger("EXPRESS2_RENDER_TIMEOUT", 5000));
    this.e.a(paramString);
    this.o = System.currentTimeMillis();
  }
  
  public void b() {
    a(c.a().c());
  }
  
  protected void b(long paramLong) {
    h.b(paramLong, this.c);
  }
  
  public void c() {
    this.f.x();
    this.n.removeCallbacks(this.x);
  }
  
  protected JSONObject d() throws JSONException {
    JSONObject jSONObject = new JSONObject(this.b.E().toString());
    jSONObject.put("tpl_info", this.b.m_());
    return jSONObject;
  }
  
  public JSONObject e() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    VideoOption2 videoOption2 = this.b.f();
    if (videoOption2 != null) {
      boolean bool;
      if (videoOption2.getAutoPlayPolicy() != null && videoOption2.getAutoPlayPolicy().getPolicy() == VideoOption2.AutoPlayPolicy.ALWAYS.getPolicy()) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.put("autoPlayOnWWAN", bool);
      jSONObject.put("videoMuted", videoOption2.isAutoPlayMuted());
      if (this.b.v())
        jSONObject.put("apkStatus", l.a().a(this.b.z().d())); 
    } 
    return jSONObject;
  }
  
  protected JSONObject f() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("width", this.b.c());
    jSONObject.put("height", this.b.d());
    jSONObject.put("isLandscape", h());
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */