package com.qq.e.comm.plugin.v;

import android.content.Context;
import android.view.View;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.m.b;
import com.qq.e.comm.plugin.m.c;
import com.qq.e.comm.plugin.m.e;
import com.qq.e.comm.plugin.m.k;
import com.qq.e.comm.plugin.m.m;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.y.c;
import org.json.JSONObject;

class i extends b {
  long h;
  
  View i;
  
  private e j;
  
  private f k;
  
  private m l;
  
  private c m;
  
  i(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, VideoOption2 paramVideoOption2, f paramf) {
    super(paramContext, paramString1, paramString2, paramJSONObject, 0, 0, 0, paramVideoOption2);
    this.k = paramf;
    this.m = new c(paramContext, this.j, this);
  }
  
  public c a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, int paramInt1, int paramInt2, VideoOption2 paramVideoOption2) {
    this.j = new e(paramString1, paramString2, paramString3, e.x, paramJSONObject, paramInt1, paramInt2, paramVideoOption2);
    return this.j;
  }
  
  public e a(Context paramContext, c paramc, VideoOption2 paramVideoOption2, com.qq.e.comm.plugin.m.i.a parama, c paramc1) {
    h.a a1 = new h.a(this, parama) {
        public void a() {
          i.a(this.b).e();
        }
        
        public void a(int param1Int) {
          com.qq.e.comm.plugin.m.i.a a1 = this.a;
          if (a1 != null)
            a1.a(param1Int); 
        }
        
        public void a(k param1k) {
          com.qq.e.comm.plugin.m.i.a a1 = this.a;
          if (a1 != null)
            a1.a(param1k); 
          if (param1k != null)
            param1k.a(new m(this) {
                  public void a(int param2Int) {
                    if (i.b(this.a.b) != null)
                      i.b(this.a.b).a(param2Int); 
                  }
                }); 
        }
      };
    return new h(paramContext, this.j, paramVideoOption2, a1, paramc1);
  }
  
  public void a() {
    if (this.f != null) {
      byte b1;
      k k = this.f;
      if (this.j.h()) {
        b1 = 4;
      } else {
        b1 = 3;
      } 
      k.a(b1);
    } 
    super.a();
  }
  
  public void a(int paramInt, String paramString) {
    g.a(paramInt, this.e, paramString);
  }
  
  public void a(int paramInt, Object... paramVarArgs) {
    super.a(paramInt, paramVarArgs);
  }
  
  public void a(View paramView) {
    if (paramView == null)
      return; 
    if (!this.g)
      this.h = System.currentTimeMillis(); 
    this.i = paramView;
    super.a(this.i);
  }
  
  public void a(m paramm) {
    this.l = paramm;
  }
  
  public void a(String paramString) {
    this.m.a(paramString);
  }
  
  void a(String paramString, boolean paramBoolean, View paramView) {
    this.m.a(paramString, paramBoolean, paramView);
  }
  
  public void b(int paramInt) {
    g.b(paramInt, this.e);
  }
  
  public void c(int paramInt) {
    g.c(paramInt, this.e);
  }
  
  public void destroy() {
    super.destroy();
    this.i = null;
    this.k = null;
  }
  
  public void l() {}
  
  public void m() {
    g.b(this.e);
  }
  
  public e o() {
    return this.j;
  }
  
  public void setAdListener(ADListener paramADListener) {
    super.setAdListener(new ADListener(this, paramADListener) {
          private void a(ADEvent param1ADEvent) {
            ADListener aDListener = this.a;
            if (aDListener != null)
              aDListener.onADEvent(param1ADEvent); 
          }
          
          public void onADEvent(ADEvent param1ADEvent) {
            ADEvent aDEvent = param1ADEvent;
            if (param1ADEvent.getType() == 105) {
              aDEvent = param1ADEvent;
              if (this.b.f.n() > n.b(this.b.a) * 1000)
                aDEvent = new ADEvent(901, null); 
            } 
            a(aDEvent);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\v\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */