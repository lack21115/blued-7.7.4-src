package com.qq.e.comm.plugin.intersitial2;

import android.text.TextUtils;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class a implements ADListener {
  private static final String a = a.class.getSimpleName();
  
  private final UnifiedInterstitialADListener b;
  
  private final d c;
  
  private NativeExpressADView d;
  
  private AdData e;
  
  private d.a f;
  
  a(d paramd, UnifiedInterstitialADListener paramUnifiedInterstitialADListener, String paramString, d.a parama) {
    this.c = paramd;
    this.b = paramUnifiedInterstitialADListener;
    this.f = parama;
  }
  
  public NativeExpressADView a() {
    return this.d;
  }
  
  public AdData b() {
    return this.e;
  }
  
  public void onADEvent(ADEvent paramADEvent) {
    y.a(new Runnable(this, paramADEvent) {
          public void run() {
            ak.b(a.c(), "onADEvent ( %d )", new Object[] { Integer.valueOf(this.a.getType()) });
            int i = this.a.getType();
            if (i != 10) {
              if (i != 20) {
                if (i != 21) {
                  StringBuilder stringBuilder;
                  switch (i) {
                    default:
                      return;
                    case 8:
                      if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof NativeExpressADView) {
                        a.a(this.b).onADLeftApplication();
                        return;
                      } 
                      stringBuilder = new StringBuilder();
                      stringBuilder.append("ADEvent.Params error for UnifiedBannerView(");
                    case 7:
                      if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof NativeExpressADView) {
                        a.d(this.b).close();
                        return;
                      } 
                      stringBuilder = new StringBuilder();
                      stringBuilder.append("ADEvent.Params error for UnifiedBannerView(");
                    case 6:
                      if ((this.a.getParas()).length == 2 && this.a.getParas()[0] instanceof NativeExpressADView && this.a.getParas()[1] instanceof String) {
                        String str = (String)this.a.getParas()[1];
                        if (!TextUtils.isEmpty(str))
                          try {
                            a.d(this.b);
                            d.ext.put("clickUrl", str);
                          } catch (Exception exception) {
                            GDTLogger.e("interstitial2 set click url error");
                            exception.printStackTrace();
                          }  
                        a.a(this.b).onADClicked();
                        return;
                      } 
                      stringBuilder = new StringBuilder();
                      stringBuilder.append("ADEvent.Params error for UnifiedBannerView(");
                    case 5:
                      if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof NativeExpressADView) {
                        a.a(this.b).onADExposure();
                      } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("ADEvent.Params error for UnifiedBannerView(");
                        stringBuilder.append(this.a);
                        stringBuilder.append(")");
                        GDTLogger.e(stringBuilder.toString());
                      } 
                      if (a.b(this.b) != null) {
                        a.b(this.b).a(false);
                        return;
                      } 
                      return;
                    case 4:
                      a.a(this.b).onADReceive();
                      if (a.b(this.b) != null) {
                        a.b(this.b).a(true);
                        return;
                      } 
                      return;
                    case 3:
                      if (a.c(this.b) != null) {
                        a.c(this.b).destroy();
                        a.a(this.b, (NativeExpressADView)null);
                      } 
                      a.a(this.b).onNoAD(ai.a(5007));
                      return;
                    case 2:
                      if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof List && ((List)this.a.getParas()[0]).get(0) instanceof NativeExpressADView) {
                        if (a.c(this.b) != null)
                          a.c(this.b).destroy(); 
                        a.a(this.b, ((List<NativeExpressADView>)this.a.getParas()[0]).get(0));
                        try {
                          JSONObject jSONObject = new JSONObject(a.c(this.b).getBoundData().getProperty("ad_info"));
                          a.d(this.b).a(jSONObject);
                        } catch (JSONException jSONException) {
                          jSONException.printStackTrace();
                        } 
                        a.c(this.b).render();
                        return;
                      } 
                      if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof AdData && this.a.getParas()[0] != null) {
                        if (a.e(this.b) != null)
                          a.a(this.b, (AdData)null); 
                        a.a(this.b, (AdData)this.a.getParas()[0]);
                        if (a.a(this.b) != null)
                          a.a(this.b).onADReceive(); 
                        if (a.b(this.b) != null) {
                          a.b(this.b).a(true);
                          return;
                        } 
                      } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("ADEvent.Params error for UnifiedBannerView(");
                      } 
                      return;
                    case 1:
                      if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof Integer) {
                        i = ((Integer)this.a.getParas()[0]).intValue();
                        a.a(this.b).onNoAD(ai.a(i));
                        if (a.b(this.b) != null) {
                          a.b(this.b).a(false);
                          return;
                        } 
                      } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("AdEvent.Params error for UnifiedBannerView(");
                        break;
                      } 
                      return;
                  } 
                  stringBuilder.append(this.a);
                  stringBuilder.append(")");
                  GDTLogger.e(stringBuilder.toString());
                  return;
                } 
                if (SDKStatus.getSDKVersionCode() >= 60) {
                  a.a(this.b).onVideoCached();
                  return;
                } 
              } else {
                a.d(this.b).b();
                return;
              } 
            } else {
              a.d(this.b).c();
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */