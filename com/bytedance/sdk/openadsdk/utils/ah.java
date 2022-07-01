package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.i.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class ah {
  private static String a;
  
  private static String b;
  
  private static String c;
  
  public static int a(c paramc, boolean paramBoolean) {
    return (paramc != null && paramc.t() != null && paramc.t().g()) ? (paramBoolean ^ true) : 3;
  }
  
  public static int a(String paramString) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1912999166:
        if (paramString.equals("draw_ad")) {
          b = 1;
          break;
        } 
      case 1844104722:
        if (paramString.equals("interaction")) {
          b = 3;
          break;
        } 
      case 564365438:
        if (paramString.equals("cache_splash_ad")) {
          b = 5;
          break;
        } 
      case 174971131:
        if (paramString.equals("splash_ad")) {
          b = 4;
          break;
        } 
      case -712491894:
        if (paramString.equals("embeded_ad")) {
          b = 0;
          break;
        } 
      case -764631662:
        if (paramString.equals("fullscreen_interstitial_ad")) {
          b = 6;
          break;
        } 
      case -1364000502:
        if (paramString.equals("rewarded_video")) {
          b = 7;
          break;
        } 
      case -1695837674:
        if (paramString.equals("banner_ad")) {
          b = 2;
          break;
        } 
    } 
    switch (b) {
      default:
        return 1;
      case 7:
        return 7;
      case 6:
        return 5;
      case 4:
      case 5:
        return 4;
      case 3:
        return 3;
      case 2:
        return 2;
      case 1:
        return 6;
      case 0:
        break;
    } 
    return 1;
  }
  
  public static String a() {
    String str1;
    try {
      str1 = System.getProperty("http.agent");
    } catch (Exception exception) {
      str1 = "unKnow";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    if (str1 == null)
      return ""; 
    int i = str1.lastIndexOf(";");
    String str2 = str1;
    if (i != -1) {
      str2 = str1;
      if (str1.length() > i) {
        str2 = str1.substring(0, ++i);
        str1 = str1.substring(i);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" ");
        stringBuilder1.append(Locale.getDefault().getLanguage());
        stringBuilder1.append("-");
        stringBuilder1.append(Locale.getDefault().getCountry());
        stringBuilder1.append(";");
        str2 = str2.concat(stringBuilder1.toString()).concat(str1);
      } 
    } 
    int j = str2.length();
    for (i = 0; i < j; i++) {
      char c = str2.charAt(i);
      if (c <= '\037' || c >= '') {
        stringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      } else {
        stringBuilder.append(c);
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static String a(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 7:
        return "rewarded_video_landingpage";
      case 6:
        return "draw_ad_landingpage";
      case 5:
        return "fullscreen_interstitial_ad_landingpage";
      case 4:
        return "splash_ad_landingpage";
      case 3:
        return "interaction_landingpage";
      case 2:
        return "banner_ad_landingpage";
      case 1:
        break;
    } 
    return "embeded_ad_landingpage";
  }
  
  public static String a(Context paramContext) {
    String str2 = d.a(paramContext).b("total_memory", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = f(paramContext, "MemTotal");
      d.a(paramContext).a("total_memory", str1);
    } 
    return str1;
  }
  
  public static Map<String, Object> a(long paramLong, k paramk, d paramd) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("video_start_duration", Long.valueOf(paramLong));
    if (paramk != null) {
      if (!TextUtils.isEmpty(paramk.M()))
        hashMap.put("creative_id", paramk.M()); 
      r r = paramk.z();
      if (r != null) {
        hashMap.put("video_resolution", r.e());
        hashMap.put("video_size", Long.valueOf(r.c()));
      } 
    } 
    a((Map)hashMap, paramd);
    return (Map)hashMap;
  }
  
  public static Map<String, Object> a(k paramk, int paramInt1, int paramInt2, d paramd) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("creative_id", paramk.M());
    hashMap.put("error_code", Integer.valueOf(paramInt1));
    hashMap.put("extra_error_code", Integer.valueOf(paramInt2));
    r r = paramk.z();
    if (r != null) {
      hashMap.put("video_size", Long.valueOf(r.c()));
      hashMap.put("video_resolution", r.e());
    } 
    a((Map)hashMap, paramd);
    return (Map)hashMap;
  }
  
  public static Map<String, Object> a(k paramk, long paramLong, d paramd) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("creative_id", paramk.M());
    hashMap.put("buffers_time", Long.valueOf(paramLong));
    r r = paramk.z();
    if (r != null) {
      hashMap.put("video_size", Long.valueOf(r.c()));
      hashMap.put("video_resolution", r.e());
    } 
    a((Map)hashMap, paramd);
    return (Map)hashMap;
  }
  
  public static Map<String, Object> a(boolean paramBoolean, k paramk, long paramLong1, long paramLong2, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("creative_id", paramk.M());
    hashMap.put("load_time", Long.valueOf(paramLong1));
    r r = paramk.z();
    if (r != null) {
      hashMap.put("video_size", Long.valueOf(r.c()));
      hashMap.put("video_resolution", r.e());
    } 
    if (!paramBoolean) {
      hashMap.put("error_code", Long.valueOf(paramLong2));
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
        str = "unknown"; 
      hashMap.put("error_message", str);
    } 
    return (Map)hashMap;
  }
  
  public static JSONObject a(Map<String, Object> paramMap) {
    JSONObject jSONObject2 = null;
    JSONObject jSONObject1 = jSONObject2;
    if (paramMap != null) {
      jSONObject1 = jSONObject2;
      if (paramMap.size() > 0)
        try {
          jSONObject1 = new JSONObject();
          try {
            for (Map.Entry<String, Object> entry : paramMap.entrySet())
              jSONObject1.put((String)entry.getKey(), entry.getValue()); 
          } catch (Exception exception) {}
        } catch (Exception exception) {
          return null;
        }  
    } 
    return jSONObject1;
  }
  
  public static JSONObject a(JSONObject paramJSONObject) {
    JSONObject jSONObject = new JSONObject();
    if (paramJSONObject == null)
      return jSONObject; 
    try {
      String str1 = a.a();
      String str2 = a.a(str1);
      str2 = a.a(paramJSONObject.toString(), str2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(2);
      stringBuilder.append(str1);
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
      if (!TextUtils.isEmpty(str1)) {
        jSONObject.put("message", str1);
        return jSONObject;
      } 
      jSONObject.put("message", paramJSONObject.toString());
      return jSONObject;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void a(k paramk, View paramView) {
    a.a().c(new Runnable(paramk, paramView) {
          public void run() {
            JSONObject jSONObject = ah.b(this.a.P());
            if (jSONObject != null) {
              int i = jSONObject.optInt("rit", 0);
              String str = jSONObject.optString("req_id", "");
              o.f().a(i, str, this.a.M(), ai.b(this.b.getRootView(), 1048576));
            } 
          }
        }5);
  }
  
  public static void a(k paramk, String paramString) {
    if (paramk != null)
      try {
        String str2 = paramk.E();
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = str2;
          if (paramk.O() != null) {
            str1 = str2;
            if (paramk.O().c() == 1) {
              str1 = str2;
              if (!TextUtils.isEmpty(paramk.O().b()))
                str1 = paramk.O().b(); 
            } 
          } 
        } 
        return;
      } finally {
        paramk = null;
      }  
  }
  
  private static void a(Map<String, Object> paramMap, d paramd) {
    if (!paramMap.containsKey("video_resolution") && paramd != null)
      try {
        return;
      } finally {
        paramMap = null;
      }  
  }
  
  public static boolean a(Context paramContext, Intent paramIntent) {
    boolean bool2 = false;
    if (paramIntent == null)
      return false; 
    List list = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    boolean bool1 = bool2;
    if (list != null) {
      bool1 = bool2;
      if (list.size() > 0)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static boolean a(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      try {
        return false;
      } finally {
        paramContext = null;
      } 
    } 
    return false;
  }
  
  public static boolean a(k paramk) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramk != null) {
      bool1 = bool2;
      if (c(paramk.P()) == 9)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static Intent b(Context paramContext, String paramString) {
    Intent intent = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    if (intent == null)
      return null; 
    if (!intent.hasCategory("android.intent.category.LAUNCHER"))
      intent.addCategory("android.intent.category.LAUNCHER"); 
    intent.setPackage(null);
    intent.addFlags(2097152);
    intent.addFlags(268435456);
    return intent;
  }
  
  public static String b() {
    return UUID.randomUUID().toString();
  }
  
  public static String b(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3 && paramInt != 4) ? ((paramInt != 7) ? ((paramInt != 8) ? ((paramInt != 9) ? "embeded_ad" : "draw_ad") : "fullscreen_interstitial_ad") : "rewarded_video") : "splash_ad") : "interaction") : "banner_ad";
  }
  
  public static String b(Context paramContext) {
    try {
      Locale locale;
      if (Build.VERSION.SDK_INT >= 24) {
        locale = paramContext.getResources().getConfiguration().getLocales().get(0);
      } else {
        locale = Locale.getDefault();
      } 
      return locale.getLanguage();
    } catch (Exception exception) {
      t.e("ToolUtils", exception.toString());
      return "";
    } 
  }
  
  public static Map<String, Object> b(boolean paramBoolean, k paramk, long paramLong1, long paramLong2, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("creative_id", paramk.M());
    hashMap.put("load_time", Long.valueOf(paramLong1));
    if (!paramBoolean) {
      hashMap.put("error_code", Long.valueOf(paramLong2));
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
        str = "unknown"; 
      hashMap.put("error_message", str);
    } 
    return (Map)hashMap;
  }
  
  public static JSONObject b(String paramString) {
    if (paramString != null)
      try {
        return new JSONObject(paramString);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
    return null;
  }
  
  public static boolean b(k paramk) {
    boolean bool = false;
    null = bool;
    if (paramk != null) {
      if (c(paramk.P()) != 3) {
        null = bool;
        return (c(paramk.P()) == 4) ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public static int c(String paramString) {
    JSONObject jSONObject = b(paramString);
    return (jSONObject != null) ? jSONObject.optInt("ad_slot_type", 0) : 0;
  }
  
  public static String c() {
    SecureRandom secureRandom = new SecureRandom();
    try {
      byte[] arrayOfByte = new byte[8];
      secureRandom.nextBytes(arrayOfByte);
      return j.a(arrayOfByte);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static boolean c(Context paramContext, String paramString) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString)) {
        PackageManager packageManager = paramContext.getPackageManager();
        try {
          PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 0);
          bool1 = bool2;
          return bool1;
        } finally {
          packageManager = null;
        } 
      } 
    } 
    return bool1;
  }
  
  public static boolean c(k paramk) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramk != null) {
      bool1 = bool2;
      if (c(paramk.P()) == 7)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static int d(String paramString) {
    JSONObject jSONObject = b(paramString);
    return (jSONObject != null) ? jSONObject.optInt("rit", 0) : 0;
  }
  
  public static String d() {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/openadsdk/utils/ah.a : Ljava/lang/String;
    //   6: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   9: ifeq -> 43
    //   12: invokestatic a : ()Landroid/content/Context;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull -> 43
    //   20: invokestatic a : ()Landroid/content/Context;
    //   23: invokevirtual getPackageName : ()Ljava/lang/String;
    //   26: putstatic com/bytedance/sdk/openadsdk/utils/ah.a : Ljava/lang/String;
    //   29: goto -> 43
    //   32: astore_0
    //   33: ldc_w 'ToolUtils'
    //   36: ldc_w 'ToolUtils getPackageName throws exception :'
    //   39: aload_0
    //   40: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: getstatic com/bytedance/sdk/openadsdk/utils/ah.a : Ljava/lang/String;
    //   46: astore_0
    //   47: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	52	finally
    //   20	29	32	finally
    //   33	43	52	finally
    //   43	47	52	finally
  }
  
  public static boolean d(Context paramContext, String paramString) {
    return (h.c() != null && !h.c().a());
  }
  
  public static boolean d(k paramk) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramk != null) {
      bool1 = bool2;
      if (c(paramk.P()) == 8)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public static long e(String paramString) {
    JSONObject jSONObject = b(paramString);
    long l = 0L;
    if (jSONObject != null)
      l = jSONObject.optLong("uid", 0L); 
    return l;
  }
  
  public static String e() {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/openadsdk/utils/ah.b : Ljava/lang/String;
    //   6: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   9: ifeq -> 67
    //   12: invokestatic a : ()Landroid/content/Context;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull -> 67
    //   20: invokestatic d : ()Ljava/lang/String;
    //   23: astore_0
    //   24: invokestatic a : ()Landroid/content/Context;
    //   27: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   30: aload_0
    //   31: iconst_0
    //   32: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   35: astore_0
    //   36: aload_0
    //   37: getfield versionCode : I
    //   40: invokestatic valueOf : (I)Ljava/lang/String;
    //   43: putstatic com/bytedance/sdk/openadsdk/utils/ah.b : Ljava/lang/String;
    //   46: aload_0
    //   47: getfield versionName : Ljava/lang/String;
    //   50: putstatic com/bytedance/sdk/openadsdk/utils/ah.c : Ljava/lang/String;
    //   53: goto -> 67
    //   56: astore_0
    //   57: ldc_w 'ToolUtils'
    //   60: ldc_w 'ToolUtils getVersionCode throws exception :'
    //   63: aload_0
    //   64: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: getstatic com/bytedance/sdk/openadsdk/utils/ah.b : Ljava/lang/String;
    //   70: astore_0
    //   71: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   73: monitorexit
    //   74: aload_0
    //   75: areturn
    //   76: astore_0
    //   77: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	76	finally
    //   20	53	56	finally
    //   57	67	76	finally
    //   67	71	76	finally
  }
  
  public static boolean e(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tel:");
        stringBuilder.append(Uri.encode(paramString));
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(stringBuilder.toString()));
        if (!(paramContext instanceof android.app.Activity))
          intent.setFlags(268435456); 
        b.a(paramContext, intent, null);
        return true;
      } catch (Exception exception) {
        return false;
      } 
    } 
    return false;
  }
  
  public static boolean e(k paramk) {
    return (paramk != null && paramk.O() != null && !TextUtils.isEmpty(paramk.O().a()));
  }
  
  public static int f(String paramString) {
    JSONObject jSONObject = b(paramString);
    return (jSONObject != null) ? jSONObject.optInt("ut", 0) : 0;
  }
  
  public static String f() {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/openadsdk/utils/ah.c : Ljava/lang/String;
    //   6: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   9: ifeq -> 67
    //   12: invokestatic a : ()Landroid/content/Context;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull -> 67
    //   20: invokestatic d : ()Ljava/lang/String;
    //   23: astore_0
    //   24: invokestatic a : ()Landroid/content/Context;
    //   27: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   30: aload_0
    //   31: iconst_0
    //   32: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   35: astore_0
    //   36: aload_0
    //   37: getfield versionCode : I
    //   40: invokestatic valueOf : (I)Ljava/lang/String;
    //   43: putstatic com/bytedance/sdk/openadsdk/utils/ah.b : Ljava/lang/String;
    //   46: aload_0
    //   47: getfield versionName : Ljava/lang/String;
    //   50: putstatic com/bytedance/sdk/openadsdk/utils/ah.c : Ljava/lang/String;
    //   53: goto -> 67
    //   56: astore_0
    //   57: ldc_w 'ToolUtils'
    //   60: ldc_w 'ToolUtils getVersionName throws exception :'
    //   63: aload_0
    //   64: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: getstatic com/bytedance/sdk/openadsdk/utils/ah.c : Ljava/lang/String;
    //   70: astore_0
    //   71: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   73: monitorexit
    //   74: aload_0
    //   75: areturn
    //   76: astore_0
    //   77: ldc com/bytedance/sdk/openadsdk/utils/ah
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	76	finally
    //   20	53	56	finally
    //   57	67	76	finally
    //   67	71	76	finally
  }
  
  public static String f(Context paramContext, String paramString) {
    Context context;
    try {
    
    } finally {
      paramString = null;
      context = null;
    } 
    try {
      paramString.printStackTrace();
      return null;
    } finally {
      if (exception != null)
        try {
          exception.close();
        } catch (Exception exception1) {} 
      if (context != null)
        try {
          context.close();
        } catch (Exception exception1) {} 
    } 
  }
  
  public static String f(k paramk) {
    return e(paramk) ? "deeplink_fail" : "installed";
  }
  
  public static double g(String paramString) {
    JSONObject jSONObject = b(paramString);
    double d = 0.0D;
    if (jSONObject != null)
      d = jSONObject.optDouble("pack_time", 0.0D); 
    return d;
  }
  
  public static String g() {
    return String.format("https://%s", new Object[] { o.h().c() });
  }
  
  public static String g(k paramk) {
    return (paramk != null && paramk.N() != null && !TextUtils.isEmpty(paramk.N().b())) ? paramk.N().b() : null;
  }
  
  public static int h() {
    try {
      long l = Runtime.getRuntime().maxMemory();
      return (int)(l * 1.0D / 1048576.0D);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public static String h(String paramString) {
    JSONObject jSONObject = b(paramString);
    return (jSONObject != null) ? jSONObject.optString("req_id", "") : "";
  }
  
  public static boolean h(k paramk) {
    boolean bool = true;
    if (paramk == null)
      return true; 
    int i = d(paramk.P());
    i = o.h().c(i);
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4);
          return true;
        } 
        return false;
      } 
      if (!w.e(o.a())) {
        if (w.d(o.a()))
          return true; 
        bool = false;
      } 
      return bool;
    } 
    return w.d(o.a());
  }
  
  public static int i() {
    try {
      long l = Runtime.getRuntime().freeMemory();
      return (int)(l * 1.0D / 1048576.0D);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public static byte[] i(String paramString) throws IOException {
    if (paramString != null) {
      if (paramString.length() == 0)
        return null; 
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
      try {
        gZIPOutputStream.write(paramString.getBytes());
        try {
          gZIPOutputStream.close();
        } catch (Exception exception) {
          t.b(exception.toString());
        } 
        return byteArrayOutputStream.toByteArray();
      } catch (Exception exception) {
        t.b(exception.toString());
        try {
          gZIPOutputStream.close();
          return null;
        } catch (Exception exception1) {
          t.b(exception1.toString());
          return null;
        } 
      } finally {}
      try {
        gZIPOutputStream.close();
      } catch (Exception exception) {
        t.b(exception.toString());
      } 
      throw paramString;
    } 
    return null;
  }
  
  public static int j() {
    try {
      long l = Runtime.getRuntime().totalMemory();
      return (int)(l * 1.0D / 1048576.0D);
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public static boolean j(String paramString) {
    try {
      boolean bool = Pattern.compile("[一-龥]").matcher(paramString).find();
      if (bool)
        return true; 
    } finally {}
    return false;
  }
  
  public static String k(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
      if (paramString.length() >= 17) {
        str = r(paramString.substring(1, 17));
        str = a.b(paramString.substring(17), str);
      } 
    } 
    return str;
  }
  
  public static boolean l(String paramString) {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool = false;
    if (bool1)
      return false; 
    if (m(paramString) || n(paramString))
      bool = true; 
    return bool;
  }
  
  public static boolean m(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : Pattern.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", paramString);
  }
  
  public static boolean n(String paramString) {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool = false;
    if (bool1)
      return false; 
    if (o(paramString) || p(paramString))
      bool = true; 
    return bool;
  }
  
  public static boolean o(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : Pattern.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", paramString);
  }
  
  public static boolean p(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : Pattern.matches("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$", paramString);
  }
  
  public static String q(String paramString) {
    return String.format("https://%s%s", new Object[] { o.h().b(), paramString });
  }
  
  private static String r(String paramString) {
    String str = a.a(paramString);
    if (paramString == null) {
      paramString = b.a();
      return paramString.concat(paramString).substring(8, 24);
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */