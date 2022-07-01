package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import com.ss.android.a.a.a.e;
import com.ss.android.a.a.c.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements e {
  private final WeakReference<Context> a;
  
  public b(Context paramContext) {
    this.a = new WeakReference<Context>(paramContext);
  }
  
  private void a(d paramd, boolean paramBoolean) {
    TTDownloadEventLogger tTDownloadEventLogger = h.c().m();
    if (tTDownloadEventLogger != null) {
      if (paramd == null)
        return; 
      if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && f(paramd))
        return; 
      if (paramBoolean) {
        tTDownloadEventLogger.onV3Event(paramd);
        return;
      } 
      tTDownloadEventLogger.onEvent(paramd);
    } 
  }
  
  private void d(d paramd) {
    if (paramd == null)
      return; 
    com.bytedance.sdk.openadsdk.i.a.a().d(a.a(paramd), 5);
  }
  
  private static JSONObject e(d paramd) {
    if (paramd != null) {
      JSONObject jSONObject = paramd.d();
      if (jSONObject != null) {
        String str = jSONObject.optString("ad_extra_data");
        if (!TextUtils.isEmpty(str))
          try {
            return new JSONObject(str);
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
          }  
      } 
    } 
    return null;
  }
  
  private boolean f(d paramd) {
    paramd.c();
    boolean bool = false;
    if (paramd == null)
      return false; 
    String str = paramd.toString();
    if (!TextUtils.isEmpty(str))
      bool = str.contains("open_ad_sdk_download_extra"); 
    return bool;
  }
  
  public void a(d paramd) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onV3Event: ");
    stringBuilder.append(String.valueOf(paramd));
    t.b("LibEventLogger", stringBuilder.toString());
    a(paramd, true);
  }
  
  public void b(d paramd) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onEvent: ");
    stringBuilder.append(String.valueOf(paramd));
    t.b("LibEventLogger", stringBuilder.toString());
    a(paramd, false);
    d(paramd);
  }
  
  static class a implements Runnable {
    private final d a;
    
    private com.bytedance.sdk.openadsdk.downloadnew.a.b.a b;
    
    private k c;
    
    private a(d param1d) {
      this.a = param1d;
      param1d = this.a;
      if (param1d != null && param1d.d() != null) {
        String str = this.a.d().optString("ad_extra_data");
        if (!TextUtils.isEmpty(str))
          try {
            this.b = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a((new JSONObject(str)).optJSONObject("open_ad_sdk_download_extra"));
            this.b.b(this.a.b());
            if (this.b != null)
              this.c = this.b.a; 
            return;
          } catch (Exception exception) {
            return;
          }  
      } 
    }
    
    private Context a() {
      return o.a();
    }
    
    public static a a(d param1d) {
      return new a(param1d);
    }
    
    private boolean a(String param1String) {
      return (!TextUtils.isEmpty(param1String) && ("embeded_ad".equals(this.a.a()) || "draw_ad".equals(this.a.a()) || "draw_ad_landingpage".equals(this.a.a()) || "banner_ad".equals(this.a.a()) || "banner_call".equals(this.a.a()) || "banner_ad_landingpage".equals(this.a.a()) || "feed_call".equals(this.a.a()) || "embeded_ad_landingpage".equals(this.a.a()) || "interaction".equals(this.a.a()) || "interaction_call".equals(this.a.a()) || "interaction_landingpage".equals(this.a.a()) || "slide_banner_ad".equals(this.a.a()) || "splash_ad".equals(this.a.a()) || "fullscreen_interstitial_ad".equals(this.a.a()) || "splash_ad_landingpage".equals(this.a.a()) || "rewarded_video".equals(this.a.a()) || "rewarded_video_landingpage".equals(this.a.a()) || "openad_sdk_download_complete_tag".equals(this.a.a()) || "download_notificaion".equals(this.a.a()) || "landing_h5_download_ad_button".equals(this.a.a())));
    }
    
    private boolean b() {
      boolean bool = false;
      try {
        if (a() == null)
          return false; 
        boolean bool1 = bool;
        return bool1;
      } finally {
        Exception exception = null;
      } 
    }
    
    public void run() {
      int j;
      int m;
      String str2;
      JSONObject jSONObject;
      HashMap<Object, Object> hashMap;
      String str3;
      try {
        if (this.a == null)
          return; 
        String str = this.a.a();
        str1 = str;
        if (this.b != null) {
          str1 = str;
          if (!TextUtils.isEmpty(this.b.b))
            str1 = this.b.b; 
        } 
        hashMap = new HashMap<Object, Object>();
      } finally {
        Exception exception = null;
        t.a("LibEventLogger", "upload event log error", exception);
      } 
      switch (i) {
        case 28:
          d.b(a(), this.c, str3, "market_openapp_failed");
          return;
        case 27:
          d.b(a(), this.c, str3, "market_openapp_success");
          return;
        case 26:
          d.b(a(), this.c, str3, "market_openapp_cancel");
          return;
        case 25:
          d.b(a(), this.c, str3, "market_openapp_window_show");
          return;
        case 24:
          d.b(a(), this.c, str3, "open_market_fail");
          return;
        case 23:
          d.b(a(), this.c, str3, "open_market_suc");
          return;
        case 22:
          d.b(a(), this.c, str3, "open_market_url");
          return;
        case 21:
          d.i(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 20:
          d.g(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 18:
        case 19:
          d.f(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 17:
          d.e(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 16:
          d.p(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 14:
        case 15:
          str2 = ah.f(this.c);
          d.q(a(), this.c, str3, str2, hashMap);
          return;
        case 13:
          jSONObject = b.c(this.a);
          if (jSONObject != null) {
            m = jSONObject.optInt("scene", -1);
            i = jSONObject.optInt("hijack", 0);
            if (i == 2)
              i = j; 
            j = m;
          } else {
            j = -1;
            i = m;
          } 
          hashMap.put("hijack", Integer.valueOf(i));
          d.a(a(), this.c, str3, this.a.b(), j, hashMap);
          if (b()) {
            d.q(a(), this.c, str3, "auto_control", hashMap);
            return;
          } 
          return;
        case 11:
        case 12:
          d.d(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 10:
          jSONObject = b.c(this.a);
          if (jSONObject != null) {
            i = jSONObject.optInt("fail_status", -1);
            str1 = jSONObject.optString("fail_msg", "unknown");
          } else {
            break;
          } 
          d.a(a(), this.c, str3, this.a.b(), i, str1, hashMap);
          return;
        case 9:
          d.c(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 7:
        case 8:
          d.b(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 5:
        case 6:
          d.a(a(), this.c, str3, this.a.b(), hashMap);
          return;
        case 4:
          d.a(a(), this.c, str3, this.a.b(), ah.a(hashMap));
          return;
        case 3:
          d.a(a(), this.c);
          return;
        case 2:
          d.c(a(), this.c, "back_install_1", hashMap);
          return;
        case 1:
          d.c(a(), this.c, "back_install_0", hashMap);
          return;
        case 0:
          d.c(a(), this.c, "back_install", hashMap);
          return;
        default:
          return;
      } 
      String str1 = "unknown";
      int i = -1;
      d.a(a(), this.c, str3, this.a.b(), i, str1, hashMap);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */