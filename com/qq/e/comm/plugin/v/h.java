package com.qq.e.comm.plugin.v;

import android.content.Context;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.plugin.ab.f.a.b;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.m.c;
import com.qq.e.comm.plugin.m.e;
import com.qq.e.comm.plugin.m.i;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.p;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.z.c;
import org.json.JSONException;
import org.json.JSONObject;

class h extends e {
  private a e;
  
  h(Context paramContext, c paramc, VideoOption2 paramVideoOption2, a parama, c paramc1) {
    super(paramContext, paramc, paramVideoOption2, parama, paramc1);
    this.e = parama;
  }
  
  public void a() {
    this.d = false;
    super.a();
  }
  
  public void a(long paramLong) {
    g.a(paramLong, this.c);
  }
  
  public void a(e parame) {
    super.a(parame);
    parame.a(new b(this) {
          public String a() {
            return "onReward";
          }
          
          public void a(e param1e, String param1String1, String param1String2, String param1String3) {
            if (h.a(this.a) != null)
              h.a(this.a).a(); 
          }
        });
  }
  
  public void b() {
    a(c.a().d());
  }
  
  public void b(long paramLong) {
    g.b(paramLong, this.c);
  }
  
  public JSONObject d() throws JSONException {
    JSONObject jSONObject = n.a(this.a, (com.qq.e.comm.plugin.s.a)this.b);
    jSONObject.put("tpl_info", this.b.m_());
    return jSONObject;
  }
  
  public JSONObject e() throws JSONException {
    JSONObject jSONObject = super.e();
    String str = this.b.B();
    jSONObject.put("rewardVideoCardShowTime", n.a() * 1000);
    jSONObject.put("rewardVideoCloseShowTime", n.a(str) * 1000);
    jSONObject.put("rewardVideoEffectiveTime", n.b(str) * 1000);
    jSONObject.put("showRewardVideoTips", n.c(str));
    jSONObject.put("fullScreenClickable", n.a((com.qq.e.comm.plugin.s.a)this.b));
    return jSONObject;
  }
  
  public JSONObject f() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    boolean bool = this.b.h();
    int i = p.a(this.a);
    int j = p.b(this.a);
    int k = am.b(this.a, Math.max(i, j));
    k = b.a().a(this.a, k);
    i = am.b(this.a, Math.min(i, j));
    if (bool) {
      jSONObject.put("width", k);
      jSONObject.put("height", i);
    } else {
      jSONObject.put("width", i);
      jSONObject.put("height", k);
    } 
    jSONObject.put("isLandscape", bool);
    return jSONObject;
  }
  
  static interface a extends i.a {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\v\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */