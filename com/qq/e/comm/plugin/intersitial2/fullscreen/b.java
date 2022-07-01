package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.a;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.c.a.c;
import com.qq.e.comm.plugin.c.e;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.intersitial2.d;
import com.qq.e.comm.plugin.intersitial2.fullscreen.a.a;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.at;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.plugin.util.u;
import com.qq.e.comm.plugin.util.v;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import org.json.JSONObject;
import yaq.gdtadv;

public class b {
  private static void a(a parama, View paramView, int paramInt, String paramString) {
    boolean bool;
    if (d.a(parama.E()) && !com.qq.e.comm.plugin.util.b.g(parama.E())) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = GDTADManager.getInstance().getSM().getIntegerForPlacement("download_confirm", parama.B(), 0);
    d.a a1 = i.a(parama);
    d.e e = new d.e(parama.D(), e.i, parama.B());
    d.b b1 = (new d.b(bool, d.c.a)).a(paramString).b(i).c(paramInt);
    b1.i = a.a().b(paramView);
    if (a(paramInt)) {
      a(parama, a.a().b(paramView), paramInt, paramString, e, b1, parama.y());
      return;
    } 
    d.a(paramView, a1, e, b1);
  }
  
  public static void a(a parama, View paramView, int paramInt, String paramString, c paramc) {
    if (e.a(parama)) {
      e.a((new f.a(parama, paramView)).a(paramInt).a(paramString).b(false).d(a(paramInt)).e(true).a(), (a)paramc);
      return;
    } 
    a(parama, paramView, paramInt, paramString);
  }
  
  public static void a(a parama, View paramView, g paramg, d.b paramb) {
    gdtadv.getVresult(366, 1, new Object[] { parama, paramView, paramg, paramb });
  }
  
  static void a(a parama, a parama1, boolean paramBoolean, int paramInt) {
    gdtadv.getVresult(367, 1, new Object[] { parama, parama1, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, UnifiedInterstitialADListener paramUnifiedInterstitialADListener, UnifiedInterstitialMediaListener paramUnifiedInterstitialMediaListener, d.a parama) {
    c c;
    String str2;
    e e = e.v;
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      GDTLogger.d("showFullScreenAD appID or posID null");
      v.a(e, true, 4001, null);
      return;
    } 
    if (paramJSONObject == null) {
      GDTLogger.d("showFullScreenAD adData null");
      c = new c();
      c.a(paramString2);
      v.a(e, true, 4014, c);
      return;
    } 
    Context context = GDTADManager.getInstance().getAppContext();
    Intent intent = new Intent();
    if ("l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation())) {
      str2 = at.d();
    } else {
      str2 = at.b();
    } 
    intent.setClassName(context, str2);
    intent.putExtra("gdt_activity_delegate_name", "interstitialFullScreen");
    intent.putExtra("appid", (String)c);
    intent.putExtra("posId", paramString2);
    intent.putExtra("adThreadId", paramString3);
    intent.putExtra("adinfo", paramJSONObject.toString());
    intent.addFlags(268435456);
    context.startActivity(intent);
    String str1 = paramJSONObject.optString("cl");
    InterstitialFSEventCenter.a().a(str1, new InterstitialFSEventCenter.a(str1, paramUnifiedInterstitialADListener, parama, paramUnifiedInterstitialMediaListener) {
          public void a(String param1String, int param1Int, Object param1Object) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener;
            UnifiedInterstitialADListener unifiedInterstitialADListener2;
            d.a a1;
            if (!param1String.equals(this.a))
              return; 
            switch (param1Int) {
              default:
                return;
              case 10012:
                if (this.d != null) {
                  if (param1Object instanceof AdError) {
                    AdError adError = (AdError)param1Object;
                  } else {
                    param1String = null;
                  } 
                  this.d.onVideoError((AdError)param1String);
                  return;
                } 
                return;
              case 10011:
                unifiedInterstitialMediaListener = this.d;
                if (unifiedInterstitialMediaListener != null) {
                  unifiedInterstitialMediaListener.onVideoComplete();
                  return;
                } 
                return;
              case 10010:
                unifiedInterstitialMediaListener = this.d;
                if (unifiedInterstitialMediaListener != null) {
                  unifiedInterstitialMediaListener.onVideoPause();
                  return;
                } 
                return;
              case 10009:
                unifiedInterstitialMediaListener = this.d;
                if (unifiedInterstitialMediaListener != null) {
                  unifiedInterstitialMediaListener.onVideoStart();
                  return;
                } 
                return;
              case 10008:
                if (this.d != null) {
                  long l = -1L;
                  if (param1Object instanceof Long)
                    l = ((Long)param1Object).longValue(); 
                  this.d.onVideoReady(l);
                  return;
                } 
                return;
              case 10007:
                unifiedInterstitialMediaListener = this.d;
                if (unifiedInterstitialMediaListener != null) {
                  unifiedInterstitialMediaListener.onVideoLoading();
                  return;
                } 
                return;
              case 10006:
                unifiedInterstitialMediaListener = this.d;
                if (unifiedInterstitialMediaListener != null) {
                  unifiedInterstitialMediaListener.onVideoInit();
                  return;
                } 
                return;
              case 10005:
                unifiedInterstitialADListener2 = this.b;
                if (unifiedInterstitialADListener2 != null) {
                  unifiedInterstitialADListener2.onVideoCached();
                  return;
                } 
                return;
              case 10004:
                unifiedInterstitialADListener2 = this.b;
                if (unifiedInterstitialADListener2 != null) {
                  unifiedInterstitialADListener2.onADClosed();
                  return;
                } 
                return;
              case 10003:
                unifiedInterstitialADListener2 = this.b;
                if (unifiedInterstitialADListener2 != null) {
                  unifiedInterstitialADListener2.onADClicked();
                  return;
                } 
                return;
              case 10002:
                unifiedInterstitialADListener2 = this.b;
                if (unifiedInterstitialADListener2 != null)
                  unifiedInterstitialADListener2.onADExposure(); 
                a1 = this.c;
                if (a1 != null) {
                  a1.a(false);
                  return;
                } 
                return;
              case 10001:
                break;
            } 
            UnifiedInterstitialADListener unifiedInterstitialADListener1 = this.b;
            if (unifiedInterstitialADListener1 != null)
              unifiedInterstitialADListener1.onADOpened(); 
          }
        });
  }
  
  public static boolean a(int paramInt) {
    return (paramInt == 10);
  }
  
  public static boolean a(a parama, int paramInt1, int paramInt2, String paramString1, d.e parame, d.b paramb, String paramString2) {
    String str1 = parama.M();
    if (TextUtils.isEmpty(str1))
      return true; 
    String str2 = bb.a(str1, "s", paramString1);
    str1 = str2;
    if (u.a(str2)) {
      ak.b("gdt_tag_p", "endCard landingPage click, url = %s", new Object[] { str2 });
      str1 = u.a(str2, g.a(paramString1, paramInt1, "click"));
    } 
    d.a(bb.c(str1, "click_area", String.valueOf(paramInt2)), parama, null);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("code", "InnerBrowser");
    d.a(parama.M(), parama.E(), parame, paramb, hashMap);
    ac.a(paramString2);
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\fullscreen\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */