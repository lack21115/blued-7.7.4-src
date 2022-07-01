package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.util.Pair;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.NativeExpressADDataAdapter;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.util.a;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.m;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.plugin.z.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class l implements NEIADI {
  protected Context a;
  
  protected String b;
  
  protected String c;
  
  protected c d = new c();
  
  private ADListener e;
  
  private String f;
  
  private int g;
  
  private int h;
  
  private VideoOption2 i;
  
  private e j = e.w;
  
  private int k = BrowserType.Default.value();
  
  private d l = new d();
  
  public l(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.e = paramADListener;
    this.f = a.a(paramString1, paramString2, o.b());
    this.d.a(this.c);
    this.l.a("posId", paramString2);
    this.l.a("appid", paramString1);
  }
  
  private b b(int paramInt) {
    b b = new b();
    b.a(this.c);
    b.c(1);
    b.d(paramInt);
    b.e(2);
    b.h(this.j.b());
    VideoOption2 videoOption2 = this.i;
    boolean bool = false;
    if (videoOption2 != null && m.a(videoOption2.getMinVideoDuration())) {
      paramInt = this.i.getMinVideoDuration();
    } else {
      paramInt = 0;
    } 
    b.k(paramInt);
    videoOption2 = this.i;
    if (videoOption2 == null) {
      paramInt = bool;
    } else {
      paramInt = bool;
      if (m.a(videoOption2.getMaxVideoDuration()))
        paramInt = this.i.getMaxVideoDuration(); 
    } 
    b.l(paramInt);
    b.a(c.a().a(b.c()));
    return b;
  }
  
  protected void a() {
    h.a(this.d);
  }
  
  protected void a(int paramInt) {
    h.a(paramInt, this.d);
  }
  
  protected void a(int paramInt, boolean paramBoolean) {
    y.a(new Runnable(this, paramInt) {
          public void run() {
            if (l.c(this.b) != null)
              l.c(this.b).onADEvent(new ADEvent(2, new Object[] { Integer.valueOf(this.a) })); 
          }
        });
  }
  
  public void a(e parame) {
    this.j = parame;
  }
  
  protected void a(List<JSONObject> paramList) {
    ArrayList<NativeExpressADDataAdapter> arrayList = new ArrayList();
    ArrayList<JSONObject> arrayList1 = new ArrayList();
    for (JSONObject jSONObject : paramList) {
      b b = new b(this.a, this.b, this.c, jSONObject, this.k, this.g, this.h, this.i);
      arrayList1.add(b.c().b());
      arrayList.add(new NativeExpressADDataAdapter(b));
    } 
    c.a().a(this.c, arrayList1, this.d);
    b((List)arrayList);
    u.a(1210002, this.d);
  }
  
  protected void b(List<NativeExpressADData2> paramList) {
    y.a(new Runnable(this, paramList) {
          public void run() {
            if (l.c(this.b) != null)
              l.c(this.b).onADEvent(new ADEvent(1, new Object[] { this.a })); 
          }
        });
  }
  
  public void loadAd(int paramInt) {
    int i = paramInt;
    if (paramInt < 1) {
      GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为1", null);
      i = 1;
    } 
    paramInt = i;
    if (i > 10) {
      GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为10", null);
      paramInt = 10;
    } 
    b b = new b(this.f, this.j, this.c);
    e.a(b(paramInt), b, new e.a(this) {
          public void a(a param1a) {
            GDTLogger.e("NativeExpressAd2Impl: loadFailed", (Throwable)param1a);
            this.a.a(param1a.a(), false);
          }
          
          public void a(JSONObject param1JSONObject) {
            List<JSONObject> list;
            ak.a("gdt_tag_net", "LoadGDTNativeExpressAD2Response : ", new Object[] { param1JSONObject });
            Pair pair2 = b.a(param1JSONObject, this.a.c);
            JSONArray jSONArray = (JSONArray)pair2.first;
            if (jSONArray != null) {
              list = b.a(jSONArray, new m(this.a.c, l.a(this.a), null), l.b(this.a));
              if (list.size() <= 0) {
                this.a.a(501, true);
                this.a.a(0);
                return;
              } 
              this.a.a(list);
              return;
            } 
            Pair pair1 = (Pair)((Pair)list).second;
            if (pair1 != null) {
              this.a.a(((Integer)pair1.first).intValue(), false);
              this.a.a(((Integer)pair1.second).intValue());
            } 
          }
        });
    a();
  }
  
  public void setAdSize(int paramInt1, int paramInt2) {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void setBrowserType(int paramInt) {
    this.k = paramInt;
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    GDTADManager.getInstance().getSM().setDEVCodeSetting("download_confirm", Integer.valueOf(paramDownAPPConfirmPolicy.value()), this.c);
  }
  
  public void setVideoOption(VideoOption2 paramVideoOption2) {
    this.i = paramVideoOption2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\m\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */