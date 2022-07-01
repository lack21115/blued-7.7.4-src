package com.qq.e.comm.plugin.b;

import android.content.Context;
import android.util.Pair;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.a;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.gdtnativead.f;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.n;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c extends f {
  private volatile int g = 30;
  
  private final Runnable h = new Runnable(this) {
      public void run() {
        if (c.a(this.a)) {
          c c1 = this.a;
          c1.loadAd(c.b(c1));
        } 
      }
    };
  
  private volatile boolean i = true;
  
  private LoadAdParams j = null;
  
  c(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, ADListener paramADListener) {
    super(paramContext, paramADSize, paramString1, paramString2, l.a, paramADListener, e.m);
  }
  
  private void i() {
    if (this.g == 0) {
      c();
      return;
    } 
    if (this.i) {
      long l;
      Runnable runnable;
      if (this.g >= 30 && this.g <= 120) {
        runnable = this.h;
        l = (this.g * 1000);
      } else {
        runnable = this.h;
        l = 30000L;
      } 
      y.a(runnable, l);
    } 
  }
  
  public b a(int paramInt) {
    b b = super.a(paramInt);
    if (a.a().d()) {
      LoadAdParams loadAdParams = this.j;
      if (loadAdParams != null) {
        b.g(loadAdParams.getLoginAppId());
        b.a(this.j.getLoginType());
        b.e(this.j.getLoginOpenid());
        b.c(this.j.getExtraInfo());
        u.a(100402, 1, (new com.qq.e.comm.plugin.y.c()).a(this.b), n.a(this.j));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Banner 2.0: ");
        stringBuilder.append(this.j.toString());
        GDTLogger.d(stringBuilder.toString());
      } 
    } 
    return b;
  }
  
  public void a() {
    b();
    loadAd(this.a.c());
  }
  
  public void a(LoadAdParams paramLoadAdParams) {
    this.j = paramLoadAdParams;
  }
  
  public void a(JSONObject paramJSONObject) {
    List<NativeExpressADView> list;
    int i;
    Pair pair = b(paramJSONObject);
    if (pair == null || pair.first == null || pair.second == null) {
      i = 6000;
      c(6000);
      com.qq.e.comm.plugin.y.c c1 = this.f;
    } else if (pair.first instanceof Integer) {
      c(((Integer)pair.first).intValue());
      com.qq.e.comm.plugin.y.c c1 = this.f;
      i = ((Integer)pair.second).intValue();
    } else {
      list = a((JSONObject)pair.first, (JSONArray)pair.second);
      if (list == null || list.size() <= 0) {
        c(501);
        b.a(false, this.f, 5011);
        return;
      } 
      try {
        JSONObject jSONObject = new JSONObject(((NativeExpressADView)list.get(0)).getBoundData().getProperty("ad_info"));
        this.f.b(jSONObject.optString("cl"));
        this.f.c(jSONObject.optString("traceid"));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      b.a(true, this.f, 0);
      a(list);
      return;
    } 
    b.a(false, (com.qq.e.comm.plugin.y.c)list, i);
  }
  
  public void b() {
    y.c(this.h);
    this.i = true;
  }
  
  public void b(int paramInt) {
    this.g = paramInt;
  }
  
  public void c() {
    y.c(this.h);
    this.i = false;
  }
  
  public e d() {
    return e.m;
  }
  
  public void loadAd(int paramInt) {
    b.b(this.f);
    this.e = paramInt;
    b b = new b(this.c, this.a, this.b);
    e.a(a(paramInt), b, new e.a(this) {
          public void a(a param1a) {
            ak.a("LoadGDTNativeExpressADFail", (Exception)param1a);
            b.a(param1a, c.d(this.a));
            c.a(this.a, param1a.a());
          }
          
          public void a(JSONObject param1JSONObject) {
            ak.a("gdt_tag_net", "LoadGDTUnifiedBannerADResponse: ", new Object[] { param1JSONObject });
            b.c(c.c(this.a));
            this.a.a(param1JSONObject);
          }
        });
    i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */