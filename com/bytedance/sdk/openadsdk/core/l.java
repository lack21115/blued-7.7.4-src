package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.ISensitiveInfoProvider;
import com.bytedance.embedapplog.InitConfig;
import com.bytedance.sdk.adnet.a;
import com.bytedance.sdk.adnet.c.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.h.b;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.a;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.g.c;
import com.bytedance.sdk.openadsdk.i.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.af;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.tea.crash.d;
import com.bytedance.tea.crash.f;
import com.bytedance.tea.crash.g;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class l {
  public static volatile boolean a = false;
  
  public static volatile TTCustomController b;
  
  private static AtomicBoolean c = new AtomicBoolean(false);
  
  private static void a() {
    if (!o.h().e())
      return; 
    Context context = o.a();
    if (context == null)
      return; 
    try {
      a.a((b)new c(context));
      a.a(true);
      a.a(context, (Application)context, b.b());
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/l.c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3: invokevirtual get : ()Z
    //   6: ifne -> 42
    //   9: ldc com/bytedance/sdk/openadsdk/TTAdManagerFactory
    //   11: monitorenter
    //   12: getstatic com/bytedance/sdk/openadsdk/core/l.c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   15: invokevirtual get : ()Z
    //   18: ifne -> 32
    //   21: aload_0
    //   22: invokestatic c : (Landroid/content/Context;)V
    //   25: getstatic com/bytedance/sdk/openadsdk/core/l.c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   28: iconst_1
    //   29: invokevirtual set : (Z)V
    //   32: ldc com/bytedance/sdk/openadsdk/TTAdManagerFactory
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc com/bytedance/sdk/openadsdk/TTAdManagerFactory
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: return
    // Exception table:
    //   from	to	target	type
    //   12	32	36	finally
    //   32	35	36	finally
    //   37	40	36	finally
  }
  
  private static void b() {
    if (Build.VERSION.SDK_INT < 28)
      return; 
    try {
      Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(new Class[] { String.class }).setAccessible(true);
      Class<?> clazz = Class.forName("android.app.ActivityThread");
      Method method = clazz.getDeclaredMethod("currentActivityThread", new Class[0]);
      method.setAccessible(true);
      Object object = method.invoke((Object)null, new Object[0]);
      Field field = clazz.getDeclaredField("mHiddenApiWarningShown");
      field.setAccessible(true);
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static void c() {
    b.a().b();
  }
  
  private static void c(Context paramContext) {
    long l1 = System.currentTimeMillis();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("init start: ");
    stringBuilder2.append(a);
    Log.d("InitHelper", stringBuilder2.toString());
    a.a(b.b());
    o.a(paramContext.getApplicationContext());
    if (!j.a())
      return; 
    d.a(paramContext);
    if (a) {
      a.a().c(new Runnable(paramContext) {
            public void run() {
              l.b(this.a);
            }
          },  10);
    } else {
      d(paramContext);
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("init over: ");
    stringBuilder1.append(System.currentTimeMillis() - l1);
    Log.d("InitHelper", stringBuilder1.toString());
  }
  
  private static void d(Context paramContext) {
    long l1 = System.currentTimeMillis();
    e(paramContext);
    b();
    g(paramContext);
    af.a();
    o.h().a();
    ai.a(paramContext);
    f(paramContext);
    o.c().a();
    o.e().a();
    o.d().a();
    o.j().a();
    String str = j.a(paramContext);
    if (!TextUtils.isEmpty(str))
      o.g().a(str); 
    s.b(str);
    d.a(paramContext);
    c();
    a.a();
    a.a().b();
    a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("do async task: ");
    stringBuilder.append(System.currentTimeMillis() - l1);
    Log.d("InitHelper", stringBuilder.toString());
  }
  
  private static void e(Context paramContext) {
    InitConfig initConfig = new InitConfig(String.valueOf(164362), "unionser_slardar_applog");
    if (b != null) {
      initConfig.setImeiEnable(b.isCanUsePhoneState());
      if (!b.isCanUsePhoneState())
        initConfig.setAppImei(b.getDevImei()); 
      initConfig.setMacEnable(b.isCanUseWifiState());
    } 
    initConfig.setSensitiveInfoProvider(new ISensitiveInfoProvider() {
          public String getImsi() {
            return (l.b != null && !l.b.isCanUsePhoneState()) ? "" : j.f(o.a());
          }
          
          public String getMac() {
            return (l.b != null && !l.b.isCanUseWifiState()) ? null : j.h(o.a());
          }
        });
    initConfig.setUriConfig(0);
    AppLog.setEnableLog(t.c());
    AppLog.init(paramContext, initConfig);
    x.a(paramContext);
  }
  
  private static void f(Context paramContext) {
    d.a(paramContext).a("uuid", UUID.randomUUID().toString());
  }
  
  private static void g(Context paramContext) {
    g.a(paramContext.getApplicationContext(), new d(paramContext) {
          public Map<String, Object> a() {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            String str = j.a(this.a);
            if (!TextUtils.isEmpty(str))
              hashMap.put("device_id", str); 
            hashMap.put("ac", w.f(this.a));
            hashMap.put("aid", Integer.valueOf(164362));
            hashMap.put("app_name", "unionser_slardar_applog");
            str = ah.f();
            if (!TextUtils.isEmpty(str))
              hashMap.put("app_version", str); 
            str = ah.e();
            if (!TextUtils.isEmpty(str)) {
              hashMap.put("version_code", str);
              hashMap.put("update_version_code", str);
            } 
            hashMap.put("version_name", "2.9.5.6");
            hashMap.put("device_platform", "android");
            hashMap.put("os", "Android");
            hashMap.put("device_type", Build.MODEL);
            hashMap.put("device_mode", Build.MODEL);
            hashMap.put("rom", ac.a());
            hashMap.put("cpu_abi", Build.CPU_ABI);
            hashMap.put("device_brand", Build.BRAND);
            hashMap.put("language", Locale.getDefault().getLanguage());
            hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
            try {
              String str1 = Build.VERSION.RELEASE;
              str = str1;
              if (str1 != null) {
                str = str1;
                if (str1.length() > 10)
                  str = str1.substring(0, 10); 
              } 
              hashMap.put("os_version", str);
            } catch (Exception exception) {}
            hashMap.put("openudid", j.c(this.a));
            hashMap.put("dpi", String.valueOf(ai.f(this.a)));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ai.c(this.a));
            stringBuilder.append("*");
            stringBuilder.append(ai.d(this.a));
            hashMap.put("resolution", stringBuilder.toString());
            return (Map)hashMap;
          }
          
          public String b() {
            return j.a(this.a);
          }
          
          public String c() {
            return AppLog.getUserUniqueID();
          }
          
          public String d() {
            return AppLog.getSsid();
          }
          
          public Map<String, Integer> e() {
            return null;
          }
          
          public List<String> f() {
            return null;
          }
          
          public Map<String, Object> g() {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            String str2 = h.c().e();
            String str1 = str2;
            if (TextUtils.isEmpty(str2))
              str1 = String.valueOf(164362); 
            hashMap.put("host_appid", str1);
            hashMap.put("sdk_version", "2.9.5.6");
            return (Map)hashMap;
          }
        }true, false);
    g.a(new f() {
          public boolean a(Throwable param1Throwable, Thread param1Thread) {
            try {
              StringWriter stringWriter = new StringWriter();
              param1Throwable.printStackTrace(new PrintWriter(stringWriter));
              String str = stringWriter.toString();
              if (str != null) {
                boolean bool = str.contains(AdSlot.class.getPackage().getName());
                if (bool)
                  return true; 
              } 
            } finally {}
            return false;
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */