package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;

public class z {
  private static boolean a = false;
  
  private static Intent a(Context paramContext, String paramString1, k paramk, int paramInt, TTNativeAd paramTTNativeAd, TTNativeExpressAd paramTTNativeExpressAd, String paramString2, boolean paramBoolean) {
    String str1;
    Intent intent;
    if (paramk.q() && (paramTTNativeAd != null || paramTTNativeExpressAd != null)) {
      Intent intent1 = new Intent(paramContext, TTPlayableLandingPageActivity.class);
      intent1.putExtra("ad_pending_download", a(paramk, paramBoolean));
      intent = intent1;
      str2 = paramString1;
      if (paramk.z() != null) {
        intent = intent1;
        str2 = paramString1;
        if (!TextUtils.isEmpty(paramk.z().h())) {
          paramString1 = paramk.z().h();
          if (paramString1.contains("?")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(paramString1);
            stringBuilder.append("&orientation=portrait");
            str2 = stringBuilder.toString();
            Intent intent2 = intent1;
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(paramString1);
            stringBuilder.append("?orientation=portrait");
            str2 = stringBuilder.toString();
            Intent intent2 = intent1;
          } 
        } 
      } 
    } else if (paramTTNativeAd instanceof com.bytedance.sdk.openadsdk.TTDrawFeedAd) {
      intent = new Intent(paramContext, TTLandingPageActivity.class);
      str2 = paramString1;
    } else if (paramk.Q() == 5 && !a) {
      intent = new Intent(paramContext, TTVideoLandingPageActivity.class);
      str2 = paramString1;
    } else {
      intent = new Intent(paramContext, TTLandingPageActivity.class);
      str2 = paramString1;
    } 
    intent.putExtra("url", str2);
    intent.putExtra("web_title", paramk.J());
    intent.putExtra("sdk_version", 2956);
    intent.putExtra("adid", paramk.M());
    intent.putExtra("log_extra", paramk.P());
    j j = paramk.C();
    Context context = null;
    String str2 = null;
    if (j == null) {
      j = null;
    } else {
      str1 = paramk.C().a();
    } 
    intent.putExtra("icon_url", str1);
    intent.putExtra("event_tag", paramString2);
    intent.putExtra("source", paramInt);
    if (!(paramContext instanceof android.app.Activity))
      intent.addFlags(268435456); 
    if (b.b()) {
      intent.putExtra("multi_process_materialmeta", paramk.ae().toString());
    } else {
      u.a().g();
      u.a().a(paramk);
    } 
    if (paramk.Q() == 5) {
      a a;
      paramContext = context;
      if (paramTTNativeAd != null) {
        a a1;
        str1 = str2;
        if (paramTTNativeAd instanceof a.a)
          a1 = ((a.a)paramTTNativeAd).a(); 
        a = a1;
        if (a1 != null) {
          intent.putExtra("multi_process_data", a1.a().toString());
          a = a1;
        } 
      } 
      if (paramTTNativeExpressAd != null) {
        a a1 = paramTTNativeExpressAd.getVideoModel();
        a = a1;
        if (a1 != null) {
          intent.putExtra("multi_process_data", a1.a().toString());
          a = a1;
        } 
      } 
      if (a != null) {
        intent.putExtra("video_is_auto_play", a.d);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("videoDataModel=");
        stringBuilder.append(a.a().toString());
        t.c("videoDataModel", stringBuilder.toString());
      } 
    } 
    return intent;
  }
  
  public static void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public static boolean a(Context paramContext, k paramk, int paramInt, TTNativeAd paramTTNativeAd, TTNativeExpressAd paramTTNativeExpressAd, String paramString, a parama, boolean paramBoolean) {
    if (paramContext != null && paramk != null) {
      String str;
      if (paramInt == -1)
        return false; 
      f f = paramk.O();
      boolean bool = true;
      if (f != null) {
        str = f.a();
        if (!TextUtils.isEmpty(str)) {
          Uri uri = Uri.parse(f.a());
          Intent intent = new Intent("android.intent.action.VIEW");
          intent.setData(uri);
          if (ah.a(paramContext, intent)) {
            if (o.h().d())
              ah.a(paramk, paramString); 
            if (!(paramContext instanceof android.app.Activity))
              intent.addFlags(268435456); 
            b.a(paramContext, intent, new b.a(paramContext, paramk, paramInt, paramString, paramBoolean) {
                  public void a() {}
                  
                  public void a(Throwable param1Throwable) {
                    if (!o.h().d()) {
                      z.a(this.a, this.b.E(), this.b, this.c, this.d, this.e);
                      t.c("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", param1Throwable);
                    } 
                  }
                });
            d.p(paramContext, paramk, paramString, "open_url_app", null);
            k.a().a(paramk, paramString);
            return true;
          } 
        } 
        if (f.c() == 2 && paramk.Q() != 5 && paramk.Q() != 15) {
          if (parama != null) {
            boolean bool2 = parama.k();
            boolean bool1 = bool2;
            if (!bool2) {
              bool1 = bool2;
              if (parama.i()) {
                bool1 = bool2;
                if (parama.a(paramBoolean))
                  bool1 = true; 
              } 
            } 
            bool2 = bool1;
            if (!bool1) {
              bool2 = bool1;
              if (parama.b(paramBoolean))
                bool2 = true; 
            } 
            if (!bool2 && parama.j())
              bool2 = bool; 
            d.p(paramContext, paramk, paramString, "open_fallback_url", null);
            return bool2;
          } 
        } else if (f.c() == 1) {
          str = f.b();
        } else {
          str = paramk.E();
        } 
        d.p(paramContext, paramk, paramString, "open_fallback_url", null);
      } else {
        str = paramk.E();
      } 
      if (!TextUtils.isEmpty(str) || paramk.q()) {
        Intent intent;
        if (paramk.B() == 2) {
          if (!w.a(str))
            return false; 
          intent = new Intent("android.intent.action.VIEW");
          try {
            intent.setData(Uri.parse(str));
            if (!(paramContext instanceof android.app.Activity))
              intent.addFlags(268435456); 
            b.a(paramContext, intent, null);
            return true;
          } catch (Exception exception) {
            return false;
          } 
        } 
        b.a((Context)exception, a((Context)exception, str, (k)intent, paramInt, paramTTNativeAd, paramTTNativeExpressAd, paramString, paramBoolean), null);
        a = false;
        return true;
      } 
      return false;
    } 
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, k paramk, int paramInt, String paramString2, boolean paramBoolean) {
    try {
      return true;
    } finally {
      paramContext = null;
    } 
  }
  
  private static boolean a(k paramk, boolean paramBoolean) {
    return !paramBoolean ? false : ((paramk != null) ? ((paramk.B() != 4) ? false : (!!paramk.q())) : false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */