package com.bytedance.sdk.openadsdk.core.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.f;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.c;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import com.bytedance.sdk.openadsdk.utils.x;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

public class i implements Runnable {
  private static final AtomicLong c = new AtomicLong(0L);
  
  private static volatile i d;
  
  private static boolean e = true;
  
  private static volatile boolean f = false;
  
  private final e a;
  
  private final Context b;
  
  private i(e parame) {
    e e1 = parame;
    if (parame == null)
      e1 = o.h(); 
    this.a = e1;
    this.b = o.a();
    if (b.b())
      try {
        IntentFilter intentFilter = new IntentFilter("com.bytedance.openadsdk.settingReceiver");
        return;
      } finally {
        parame = null;
      }  
  }
  
  public static i a(e parame) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/h/i.d : Lcom/bytedance/sdk/openadsdk/core/h/i;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/core/h/i
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/h/i.d : Lcom/bytedance/sdk/openadsdk/core/h/i;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/core/h/i
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/h/e;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/core/h/i.d : Lcom/bytedance/sdk/openadsdk/core/h/i;
    //   26: ldc com/bytedance/sdk/openadsdk/core/h/i
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/core/h/i
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/core/h/i.d : Lcom/bytedance/sdk/openadsdk/core/h/i;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private JSONObject a(JSONObject paramJSONObject) {
    JSONObject jSONObject = paramJSONObject;
    if (e)
      jSONObject = ah.a(paramJSONObject); 
    return jSONObject;
  }
  
  public static void a() {
    try {
      Context context = o.a();
      int j = Build.VERSION.SDK_INT;
      if (j >= 24) {
        file = new File(context.getDataDir(), "shared_prefs");
      } else {
        file = new File(context.getDatabasePath("1").getParentFile().getParentFile(), "shared_prefs");
      } 
      File file = new File(file, "tt_sdk_settings.xml");
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void a(long paramLong) {
    if (paramLong <= 0L)
      return; 
    if (o.a() != null)
      try {
        Intent intent = new Intent();
        intent.setAction("com.bytedance.openadsdk.settingReceiver");
        intent.putExtra("b_msg_id", 1);
        intent.putExtra("b_msg_time", paramLong);
        return;
      } finally {
        Exception exception = null;
      }  
  }
  
  private void a(String paramString, Map<String, String> paramMap) {
    byte b = 1;
    int j = b;
    try {
    
    } finally {
      paramString = null;
    } 
    j.a(j);
  }
  
  public static void b() {
    if (o.a() != null)
      try {
        Intent intent = new Intent();
        intent.setAction("com.bytedance.openadsdk.settingReceiver");
        intent.putExtra("b_msg_id", 2);
        return;
      } finally {
        Exception exception = null;
      }  
  }
  
  public static boolean d() {
    return f;
  }
  
  private boolean g() {
    return TextUtils.isEmpty(h.c().e());
  }
  
  private JSONObject h() {
    JSONObject jSONObject = new JSONObject();
    try {
      c c = d.a(this.b);
      if (c != null) {
        jSONObject.put("latitude", c.a);
        jSONObject.put("longitude", c.b);
      } 
    } catch (Exception exception) {}
    byte b = 1;
    try {
      jSONObject.put("ip", com.bytedance.sdk.openadsdk.utils.i.a(true));
      jSONObject.put("imei", j.d(this.b));
      jSONObject.put("oaid", x.a());
      jSONObject.put("model", Build.MODEL);
      jSONObject.put("conn_type", w.b(this.b));
      jSONObject.put("os", 1);
      jSONObject.put("oversea_version_type", 0);
      jSONObject.put("os_version", String.valueOf(Build.VERSION.RELEASE));
      jSONObject.put("sdk_version", "2.9.5.6");
      jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.downloadnew.a.a());
      jSONObject.put("package_name", ah.d());
      if (!ah.d(this.b, ah.d()))
        b = 2; 
      jSONObject.put("position", b);
      jSONObject.put("app_version", ah.f());
      jSONObject.put("vendor", Build.MANUFACTURER);
      jSONObject.put("app_id", h.c().e());
      long l = System.currentTimeMillis() / 1000L;
      jSONObject.put("ts", l);
      String str = "";
      if (h.c().e() != null)
        str = h.c().e().concat(String.valueOf(l)).concat("2.9.5.6"); 
      jSONObject.put("req_sign", j.a(str));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("app_version:");
      stringBuilder.append(ah.f());
      stringBuilder.append("，vendor:");
      stringBuilder.append(Build.MANUFACTURER);
      t.c("isApplicationForeground", stringBuilder.toString());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public void c() {
    try {
      if (g())
        return; 
      long l = System.currentTimeMillis();
      if (l - c.get() < 600000L)
        return; 
      c.set(l);
      return;
    } finally {
      Exception exception = null;
      t.a("SdkSettingsHelper", "load sdk settings error: ", exception);
    } 
  }
  
  public void run() {
    if (!w.a(this.b))
      try {
        return;
      } finally {
        Exception exception = null;
      }  
    if (g())
      return; 
    JSONObject jSONObject = h();
    (new f(1, ah.q("/api/ad/union/sdk/settings/"), a(jSONObject), new n.a<JSONObject>(this) {
          public void a(n<JSONObject> param1n) {
            if (param1n != null && param1n.a != null) {
              String str;
              JSONObject jSONObject1;
              int j = ((JSONObject)param1n.a).optInt("cypher", -1);
              JSONObject jSONObject2 = (JSONObject)param1n.a;
              n n1 = null;
              if (j == 1) {
                String str1 = com.bytedance.sdk.openadsdk.core.a.b(((JSONObject)param1n.a).optString("message"), b.a());
                str = str1;
                jSONObject1 = jSONObject2;
                if (!TextUtils.isEmpty(str1))
                  try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("setting data : ");
                    stringBuilder.append(str1.toString());
                  } finally {
                    str = null;
                    t.a("SdkSettingsHelper", "setting data error: ", (Throwable)str);
                    str = str1;
                  }  
              } else if (j == 2) {
                String str1 = ah.k(((JSONObject)param1n.a).optString("message"));
                str = str1;
                jSONObject1 = jSONObject2;
                if (!TextUtils.isEmpty(str1))
                  try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("setting data1 : ");
                    stringBuilder.append(str1.toString());
                  } finally {
                    str = null;
                    t.a("SdkSettingsHelper", "setting data error2: ", (Throwable)str);
                    str = str1;
                  }  
              } else {
                str = null;
                jSONObject1 = jSONObject2;
              } 
              try {
                Map map;
                if (param1n.b == null) {
                  param1n = n1;
                } else {
                  map = param1n.b.h;
                } 
                i.a(this.a, str, map);
              } finally {}
              try {
                if (!i.f())
                  i.a(true); 
                i.a(this.a).a(jSONObject1);
              } finally {}
              com.bytedance.sdk.openadsdk.f.a.a().b();
              if (b.b())
                i.b(); 
              return;
            } 
            try {
              return;
            } finally {
              param1n = null;
            } 
          }
          
          public void b(n<JSONObject> param1n) {
            try {
              return;
            } finally {
              param1n = null;
            } 
          }
        })).setResponseOnMain(false).setShouldCache(false).build(e.a(this.b).d());
  }
  
  class a extends BroadcastReceiver {
    private a(i this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (param1Intent == null)
        return; 
      int j = param1Intent.getIntExtra("b_msg_id", -1);
      if (j == 1) {
        long l = param1Intent.getLongExtra("b_msg_time", -1L);
        if (l > 0L) {
          i.e().set(l);
          return;
        } 
      } else if (j == 2) {
        try {
          return;
        } finally {
          param1Context = null;
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\h\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */