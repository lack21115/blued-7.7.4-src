package com.qq.e.comm.plugin.intersitial2;

import android.content.Context;
import android.util.Pair;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.gdtnativead.f;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.v;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.c;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends f implements a {
  private JSONObject g = null;
  
  public f(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, l paraml, ADListener paramADListener) {
    super(paramContext, paramADSize, paramString1, paramString2, paraml, paramADListener, e.n);
  }
  
  public f(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, l paraml, ADListener paramADListener, e parame) {
    super(paramContext, paramADSize, paramString1, paramString2, paraml, paramADListener, parame);
  }
  
  public void a(JSONObject paramJSONObject) {
    List<NativeExpressADView> list;
    int i;
    Pair pair = b(paramJSONObject);
    if (pair == null || pair.first == null || pair.second == null) {
      i = 6000;
      c(6000);
      c c = this.f;
    } else if (pair.first instanceof Integer) {
      c(((Integer)pair.first).intValue());
      c c = this.f;
      i = ((Integer)pair.second).intValue();
    } else {
      list = a((JSONObject)pair.first, (JSONArray)pair.second);
      if (list == null || list.size() <= 0) {
        c(501);
        v.a(this.f, 5011);
        return;
      } 
      try {
        JSONObject jSONObject = new JSONObject(((NativeExpressADView)list.get(0)).getBoundData().getProperty("ad_info"));
        this.f.b(jSONObject.optString("cl"));
        this.f.c(jSONObject.optString("traceid"));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      v.a(this.a, this.f);
      a(list);
      return;
    } 
    v.a((c)list, i);
  }
  
  public e d() {
    return e.n;
  }
  
  public int getMediationPrice() {
    return super.getMediationPrice();
  }
  
  public boolean isContractAd() {
    return super.isContractAd();
  }
  
  public void loadAd(int paramInt) {
    v.c(this.f);
    this.e = paramInt;
    b b = new b(this.c, this.a, this.b);
    e.a(a(paramInt), b, new e.a(this) {
          public void a(a param1a) {
            ak.a("LoadGDTNativeExpressADFail", (Exception)param1a);
            v.a(param1a, f.b(this.a));
            f.a(this.a, param1a.a());
          }
          
          public void a(JSONObject param1JSONObject) {
            ak.a("gdt_tag_net", "LoadUnifiedInterstitialADResponse: ", new Object[] { param1JSONObject });
            v.d(f.a(this.a));
            this.a.a(param1JSONObject);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */