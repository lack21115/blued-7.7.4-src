package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.n;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class a implements ak.a {
  private static final Integer a = Integer.valueOf(1);
  
  private static final Integer b = Integer.valueOf(2);
  
  private static volatile a c;
  
  private Context d;
  
  private final ak e = new ak(Looper.getMainLooper(), this);
  
  private final WeakHashMap<Integer, b> f = new WeakHashMap<Integer, b>();
  
  private c g;
  
  private d h;
  
  private long i = 0L;
  
  private long j = 0L;
  
  private AtomicBoolean k = new AtomicBoolean(false);
  
  private a(Context paramContext) {
    if (paramContext != null)
      this.d = paramContext.getApplicationContext(); 
  }
  
  static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/component/splash/a.c : Lcom/bytedance/sdk/openadsdk/component/splash/a;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/component/splash/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/component/splash/a.c : Lcom/bytedance/sdk/openadsdk/component/splash/a;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/component/splash/a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/component/splash/a.c : Lcom/bytedance/sdk/openadsdk/component/splash/a;
    //   26: ldc com/bytedance/sdk/openadsdk/component/splash/a
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/component/splash/a
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/component/splash/a.c : Lcom/bytedance/sdk/openadsdk/component/splash/a;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private Runnable a(String paramString, File paramFile) {
    c c1 = this.g;
    if (c1 == null) {
      this.g = new c(this, paramString, paramFile);
    } else {
      c.a(c1, paramString, paramFile);
    } 
    return this.g;
  }
  
  private void a(int paramInt, long paramLong) {
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("expiration");
      stringBuilder1.append(paramInt);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString(), Long.valueOf(paramLong));
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("update");
      stringBuilder1.append(paramInt);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString(), Long.valueOf(System.currentTimeMillis() / 1000L));
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("has_ad_cache");
      stringBuilder1.append(paramInt);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString(), Boolean.valueOf(true));
      return;
    } 
    SharedPreferences.Editor editor = b().getSharedPreferences("tt_splash", 0).edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("expiration");
    stringBuilder.append(paramInt);
    editor = editor.putLong(stringBuilder.toString(), paramLong);
    stringBuilder = new StringBuilder();
    stringBuilder.append("update");
    stringBuilder.append(paramInt);
    editor = editor.putLong(stringBuilder.toString(), System.currentTimeMillis() / 1000L);
    stringBuilder = new StringBuilder();
    stringBuilder.append("has_ad_cache");
    stringBuilder.append(paramInt);
    editor.putBoolean(stringBuilder.toString(), true).apply();
  }
  
  private void a(n paramn, File paramFile) {
    d d1 = this.h;
    if (d1 == null) {
      this.h = new d(paramn, paramFile);
    } else {
      d1.a(paramn);
      this.h.a(paramFile);
    } 
    com.bytedance.sdk.openadsdk.i.a.a().c(this.h, 1);
  }
  
  private Context b() {
    Context context = this.d;
    return (context != null) ? context : o.a();
  }
  
  private void b(AdSlot paramAdSlot, l paraml) {
    if (this.k.getAndSet(true)) {
      t.b("splashLoad", "已在预加载开屏广告....不再发出");
      return;
    } 
    if ((o.h().i(paramAdSlot.getCodeId()) || paramAdSlot.getExpressViewAcceptedWidth() > 0.0F) && paraml != null)
      paraml.e = 2; 
    o.f().a(paramAdSlot, paraml, 4, new p.b(this) {
          public void a(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("广告物料预加载失败....");
            stringBuilder.append(param1String);
            stringBuilder.append(param1Int);
            t.b("splashLoad", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(param1String);
            stringBuilder.append(param1Int);
            t.b("SplashAdCacheManager", stringBuilder.toString());
            a.c(this.a).set(false);
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            boolean bool = c.b(param1a);
            byte b1 = 0;
            if (bool) {
              t.b("splashLoad", "广告物料预加载成功....");
              k k = param1a.c().get(0);
              if (k.aa()) {
                if (k.z() != null) {
                  bool = true;
                } else {
                  bool = false;
                } 
                j j2 = k.D();
                j j1 = j2;
                if (j2 == null)
                  j1 = k.F().get(0); 
                String str = j1.a();
                int i = j1.b();
                a.a(this.a, System.currentTimeMillis());
                if (bool)
                  b1 = 2; 
                c.a(k, b1);
                a.b(this.a, SystemClock.elapsedRealtime());
                n.a(a.d(this.a), str, i, new n.a(this, param1a, k, bool) {
                      public void a() {
                        c.a(this.a);
                        t.b("SplashAdCacheManager", "图片数据加载失败");
                        t.b("splashLoad", "图片数据预加载失败....");
                        if (this.c)
                          c.a(a.f(this.d.a), false, false, this.b, -7L, null); 
                        a.c(this.d.a).set(false);
                      }
                      
                      public void a(byte[] param2ArrayOfbyte) {
                        c.a(this.a);
                        c.a(this.b);
                        if (!this.c)
                          com.bytedance.sdk.openadsdk.c.d.a(this.b, "splash_ad", "download_creative_duration", System.currentTimeMillis() - a.e(this.d.a)); 
                        a.a(this.d.a, 0L);
                        t.b("SplashAdCacheManager", "图片数据加载的广告缓存到本地");
                        t.b("splashLoad", "预加载成功，广告缓存到本地----10");
                        a.a(a.d(this.d.a)).a(new n(this.a, this.b, param2ArrayOfbyte));
                        if (this.c)
                          c.a(a.f(this.d.a), false, true, this.b, 0L, null); 
                        a.c(this.d.a).set(false);
                      }
                    });
                return;
              } 
            } else {
              a.c(this.a).set(false);
            } 
          }
        });
  }
  
  private com.bytedance.sdk.openadsdk.core.d.a e(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("materialMeta");
      stringBuilder.append(paramString);
      paramString = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_materialMeta", stringBuilder.toString(), null);
    } else {
      SharedPreferences sharedPreferences = b().getSharedPreferences("tt_materialMeta", 0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("materialMeta");
      stringBuilder.append(paramString);
      paramString = sharedPreferences.getString(stringBuilder.toString(), null);
    } 
    if (!TextUtils.isEmpty(paramString))
      try {
        q.a a1 = q.a.a(new JSONObject(paramString));
        return (a1 != null && a1.h != null) ? a1.h : null;
      } catch (JSONException jSONException) {
        return null;
      }  
    return null;
  }
  
  public String a(k paramk) {
    return (paramk == null || paramk.z() == null || TextUtils.isEmpty(paramk.z().g())) ? null : a(paramk.z().g(), paramk.z().j(), String.valueOf(ah.d(paramk.P())));
  }
  
  public String a(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString1))
      return null; 
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
      str = j.a(paramString1); 
    paramString1 = a(String.valueOf(paramString3), com.bytedance.sdk.openadsdk.multipro.b.b());
    File file = c.a(this.d, paramString1, str);
    return (file != null && file.exists() && file.isFile()) ? file.getAbsolutePath() : null;
  }
  
  public String a(String paramString, boolean paramBoolean) {
    if (paramBoolean) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("splash_video_cache_");
      stringBuilder1.append(paramString);
      stringBuilder1.append("/");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/splash_video_cache_");
    stringBuilder.append(paramString);
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  void a() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic b : ()Z
    //   5: istore_3
    //   6: iload_3
    //   7: ifeq -> 24
    //   10: ldc_w 'tt_materialMeta'
    //   13: invokestatic a : (Ljava/lang/String;)V
    //   16: ldc 'tt_splash'
    //   18: invokestatic a : (Ljava/lang/String;)V
    //   21: goto -> 75
    //   24: aload_0
    //   25: invokespecial b : ()Landroid/content/Context;
    //   28: ldc_w 'tt_materialMeta'
    //   31: iconst_0
    //   32: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   35: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   40: invokeinterface clear : ()Landroid/content/SharedPreferences$Editor;
    //   45: invokeinterface apply : ()V
    //   50: aload_0
    //   51: invokespecial b : ()Landroid/content/Context;
    //   54: ldc 'tt_splash'
    //   56: iconst_0
    //   57: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   60: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   65: invokeinterface clear : ()Landroid/content/SharedPreferences$Editor;
    //   70: invokeinterface apply : ()V
    //   75: ldc_w 'mounted'
    //   78: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   81: invokevirtual equals : (Ljava/lang/Object;)Z
    //   84: ifne -> 93
    //   87: invokestatic isExternalStorageRemovable : ()Z
    //   90: ifne -> 115
    //   93: aload_0
    //   94: invokespecial b : ()Landroid/content/Context;
    //   97: invokevirtual getExternalCacheDir : ()Ljava/io/File;
    //   100: ifnull -> 115
    //   103: aload_0
    //   104: invokespecial b : ()Landroid/content/Context;
    //   107: invokevirtual getExternalCacheDir : ()Ljava/io/File;
    //   110: astore #4
    //   112: goto -> 124
    //   115: aload_0
    //   116: invokespecial b : ()Landroid/content/Context;
    //   119: invokevirtual getCacheDir : ()Ljava/io/File;
    //   122: astore #4
    //   124: aload #4
    //   126: ifnull -> 198
    //   129: aload #4
    //   131: invokevirtual exists : ()Z
    //   134: ifeq -> 198
    //   137: aload #4
    //   139: invokevirtual isDirectory : ()Z
    //   142: ifeq -> 198
    //   145: aload #4
    //   147: new com/bytedance/sdk/openadsdk/component/splash/a$2
    //   150: dup
    //   151: aload_0
    //   152: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/splash/a;)V
    //   155: invokevirtual listFiles : (Ljava/io/FileFilter;)[Ljava/io/File;
    //   158: astore #4
    //   160: aload #4
    //   162: ifnull -> 198
    //   165: aload #4
    //   167: arraylength
    //   168: ifle -> 198
    //   171: aload #4
    //   173: arraylength
    //   174: istore_2
    //   175: iload_1
    //   176: iload_2
    //   177: if_icmpge -> 198
    //   180: aload #4
    //   182: iload_1
    //   183: aaload
    //   184: astore #5
    //   186: aload #5
    //   188: invokestatic c : (Ljava/io/File;)V
    //   191: iload_1
    //   192: iconst_1
    //   193: iadd
    //   194: istore_1
    //   195: goto -> 175
    //   198: return
    //   199: astore #4
    //   201: goto -> 75
    //   204: astore #4
    //   206: return
    //   207: astore #5
    //   209: goto -> 191
    // Exception table:
    //   from	to	target	type
    //   2	6	199	finally
    //   10	21	199	finally
    //   24	75	199	finally
    //   75	93	204	finally
    //   93	112	204	finally
    //   115	124	204	finally
    //   129	160	204	finally
    //   165	175	204	finally
    //   186	191	207	finally
  }
  
  public void a(Message paramMessage) {
    StringBuilder stringBuilder;
    int i = paramMessage.what;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 1) {
      b b = this.f.remove(a);
      if (b != null)
        if (paramMessage.obj != null && paramMessage.obj instanceof n) {
          b.a((n)paramMessage.obj);
          t.b("SplashAdCacheManager", "缓存反序列化成功");
        } else {
          b.a();
          t.b("SplashAdCacheManager", "缓存反序列化失败");
        }  
      stringBuilder = new StringBuilder();
      stringBuilder.append("OnLoadCacheCallback is null: ");
      if (b == null)
        bool1 = true; 
      stringBuilder.append(bool1);
      t.b("SplashAdCacheManager", stringBuilder.toString());
      this.e.removeCallbacksAndMessages(null);
      return;
    } 
    if (((Message)stringBuilder).what == 2) {
      b b = this.f.remove(b);
      if (b != null)
        if (((Message)stringBuilder).obj != null && ((Message)stringBuilder).obj instanceof n) {
          b.a((n)((Message)stringBuilder).obj);
          t.b("SplashAdCacheManager", "视频物料缓存反序列化成功");
        } else {
          b.a();
          t.b("SplashAdCacheManager", "视频物料缓存反序列化失败");
        }  
      stringBuilder = new StringBuilder();
      stringBuilder.append("OnLoadCacheCallback is null: ");
      bool1 = bool2;
      if (b == null)
        bool1 = true; 
      stringBuilder.append(bool1);
      t.b("SplashAdCacheManager", stringBuilder.toString());
      this.e.removeCallbacksAndMessages(null);
    } 
  }
  
  public void a(AdSlot paramAdSlot, l paraml) {
    if (o.h().t() && paramAdSlot != null) {
      if (paraml == null) {
        paraml = new l();
      } else {
        paraml = paraml.a();
      } 
      paraml.f = System.currentTimeMillis();
      b(paramAdSlot, paraml);
    } 
  }
  
  void a(n paramn) {
    String str1;
    if (paramn == null)
      return; 
    int i = c.c(paramn);
    if (i <= 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tt_splash_image_cache_");
    stringBuilder.append(i);
    String str2 = stringBuilder.toString();
    Context context = b();
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      str1 = "splash_ad_cache/";
    } else {
      str1 = "/splash_ad_cache/";
    } 
    File file = c.a(context, str1, str2);
    if (file == null)
      return; 
    a(i, paramn.a().S());
    a(paramn, file);
  }
  
  public void a(File paramFile) {
    try {
      h.c().p().a(paramFile);
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("trimFileCache IOException:");
      stringBuilder.append(iOException.toString());
      t.e("SplashAdCacheManager", stringBuilder.toString());
      return;
    } 
  }
  
  void a(String paramString, b paramb) {
    Message message;
    this.f.put(b, paramb);
    if (TextUtils.isEmpty(paramString)) {
      message = this.e.obtainMessage();
      message.what = 2;
      this.e.sendMessage(message);
      return;
    } 
    com.bytedance.sdk.openadsdk.i.a.a().c(new Runnable(this, (String)message) {
          public void run() {
            t.b("TTExecutor", "readSplashMaterialMeta....->run....");
            Message message = a.a(this.b).obtainMessage();
            message.what = 2;
            try {
              com.bytedance.sdk.openadsdk.core.d.a a1 = a.a(this.b, this.a);
              n n = new n(a1, null, null);
              if (a1 != null && a1.c() != null && !a1.c().isEmpty()) {
                k k = a1.c().get(0);
                if (k != null)
                  n.a(k); 
              } 
              message.obj = n;
            } finally {
              Exception exception;
            } 
            a.a(this.b).sendMessage(message);
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("has_video_ad_cache");
              stringBuilder1.append(this.a);
              com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString());
              return;
            } 
            SharedPreferences.Editor editor = a.b(this.b).getSharedPreferences("tt_splash", 0).edit();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("has_video_ad_cache");
            stringBuilder.append(this.a);
            editor.remove(stringBuilder.toString()).apply();
          }
        }10);
  }
  
  public boolean a(AdSlot paramAdSlot, boolean paramBoolean) {
    a a1 = a(this.d).c(paramAdSlot.getCodeId());
    if (paramBoolean && a1.a)
      try {
        long l1 = a1.d;
        long l2 = a1.b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("available_type", Integer.valueOf(0));
        jSONObject.putOpt("creative_timeout_duration", Long.valueOf((l1 - l2) / 3600L));
        com.bytedance.sdk.openadsdk.f.a.d d1 = com.bytedance.sdk.openadsdk.f.a.d.b().a(4).c(paramAdSlot.getCodeId()).b(jSONObject.toString());
        com.bytedance.sdk.openadsdk.f.a.a().n(d1);
      } finally {} 
    return a1.a;
  }
  
  boolean a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("has_ad_cache");
      stringBuilder1.append(paramString);
      return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString(), false);
    } 
    SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("has_ad_cache");
    stringBuilder.append(paramString);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  void b(n paramn) {
    int i = c.c(paramn);
    if (i <= 0)
      return; 
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("has_video_ad_cache");
      stringBuilder1.append(i);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString(), Boolean.valueOf(true));
      return;
    } 
    SharedPreferences.Editor editor = b().getSharedPreferences("tt_splash", 0).edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("has_video_ad_cache");
    stringBuilder.append(i);
    editor.putBoolean(stringBuilder.toString(), true).apply();
  }
  
  void b(String paramString, b paramb) {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      paramb.a();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tt_splash_image_cache_");
    stringBuilder.append(paramString);
    String str2 = stringBuilder.toString();
    Context context = b();
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      str1 = "splash_ad_cache/";
    } else {
      str1 = "/splash_ad_cache/";
    } 
    File file = c.a(context, str1, str2);
    if (file == null || !file.exists() || !file.isFile() || file.length() <= 0L) {
      paramb.a();
      return;
    } 
    this.f.put(a, paramb);
    com.bytedance.sdk.openadsdk.i.a.a().c(a(paramString, file), 10);
  }
  
  boolean b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("has_video_ad_cache");
      stringBuilder1.append(paramString);
      return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString(), false);
    } 
    SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("has_video_ad_cache");
    stringBuilder.append(paramString);
    return sharedPreferences.getBoolean(stringBuilder.toString(), false);
  }
  
  a c(String paramString) {
    a a1 = new a();
    if (TextUtils.isEmpty(paramString))
      return a1; 
    boolean bool = com.bytedance.sdk.openadsdk.multipro.b.b();
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("expiration");
      stringBuilder1.append(paramString);
      long l4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString(), 0L);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("update");
      stringBuilder1.append(paramString);
      long l5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString(), 0L);
      long l6 = System.currentTimeMillis() / 1000L;
      bool = bool1;
      if (l6 >= l5)
        if (l6 >= l4) {
          bool = bool1;
        } else {
          bool = false;
        }  
      a1.a = bool;
      a1.b = l5;
      a1.c = l4;
      a1.d = l6;
      return a1;
    } 
    SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("expiration");
    stringBuilder.append(paramString);
    long l1 = sharedPreferences.getLong(stringBuilder.toString(), 0L);
    stringBuilder = new StringBuilder();
    stringBuilder.append("update");
    stringBuilder.append(paramString);
    long l2 = sharedPreferences.getLong(stringBuilder.toString(), 0L);
    long l3 = System.currentTimeMillis() / 1000L;
    bool = bool2;
    if (l3 >= l2)
      if (l3 >= l1) {
        bool = bool2;
      } else {
        bool = false;
      }  
    a1.a = bool;
    a1.b = l2;
    a1.c = l1;
    a1.d = l3;
    return a1;
  }
  
  void d(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("materialMeta");
      stringBuilder1.append(paramString);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("has_ad_cache");
      stringBuilder1.append(paramString);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("has_video_ad_cache");
      stringBuilder1.append(paramString);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("expiration");
      stringBuilder1.append(paramString);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("expiration");
      stringBuilder1.append(paramString);
      com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", stringBuilder1.toString());
      return;
    } 
    SharedPreferences.Editor editor = b().getSharedPreferences("tt_materialMeta", 0).edit();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("materialMeta");
    stringBuilder.append(paramString);
    editor.remove(stringBuilder.toString()).apply();
    editor = b().getSharedPreferences("tt_splash", 0).edit();
    stringBuilder = new StringBuilder();
    stringBuilder.append("has_ad_cache");
    stringBuilder.append(paramString);
    editor = editor.remove(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("has_video_ad_cache");
    stringBuilder.append(paramString);
    editor = editor.remove(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("expiration");
    stringBuilder.append(paramString);
    editor = editor.remove(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("expiration");
    stringBuilder.append(paramString);
    editor.remove(stringBuilder.toString()).apply();
  }
  
  static class a {
    boolean a = true;
    
    long b = 0L;
    
    long c = 0L;
    
    long d = 0L;
  }
  
  static interface b {
    void a();
    
    void a(n param1n);
  }
  
  class c implements Runnable {
    private File b;
    
    private String c;
    
    public c(a this$0, String param1String, File param1File) {
      this.c = param1String;
      this.b = param1File;
    }
    
    private void a(String param1String, File param1File) {
      this.c = param1String;
      this.b = param1File;
    }
    
    private byte[] a(File param1File) {
      // Byte code:
      //   0: new java/io/ByteArrayOutputStream
      //   3: dup
      //   4: invokespecial <init> : ()V
      //   7: astore #5
      //   9: sipush #1024
      //   12: newarray byte
      //   14: astore_3
      //   15: new java/io/FileInputStream
      //   18: dup
      //   19: aload_1
      //   20: invokespecial <init> : (Ljava/io/File;)V
      //   23: astore_1
      //   24: aload_1
      //   25: aload_3
      //   26: iconst_0
      //   27: aload_3
      //   28: arraylength
      //   29: invokevirtual read : ([BII)I
      //   32: istore_2
      //   33: iload_2
      //   34: iconst_m1
      //   35: if_icmpeq -> 49
      //   38: aload #5
      //   40: aload_3
      //   41: iconst_0
      //   42: iload_2
      //   43: invokevirtual write : ([BII)V
      //   46: goto -> 24
      //   49: aload #5
      //   51: invokevirtual flush : ()V
      //   54: aload #5
      //   56: invokevirtual close : ()V
      //   59: aload_1
      //   60: invokevirtual close : ()V
      //   63: goto -> 108
      //   66: astore #4
      //   68: aload_1
      //   69: astore_3
      //   70: aload #4
      //   72: astore_1
      //   73: goto -> 79
      //   76: astore_1
      //   77: aconst_null
      //   78: astore_3
      //   79: aload #5
      //   81: invokevirtual close : ()V
      //   84: aload_3
      //   85: ifnull -> 92
      //   88: aload_3
      //   89: invokevirtual close : ()V
      //   92: aload_1
      //   93: athrow
      //   94: aconst_null
      //   95: astore_1
      //   96: aload #5
      //   98: invokevirtual close : ()V
      //   101: aload_1
      //   102: ifnull -> 108
      //   105: goto -> 59
      //   108: aload #5
      //   110: invokevirtual toByteArray : ()[B
      //   113: areturn
      //   114: astore_1
      //   115: goto -> 94
      //   118: astore_3
      //   119: goto -> 96
      //   122: astore_1
      //   123: goto -> 108
      //   126: astore_3
      //   127: goto -> 92
      // Exception table:
      //   from	to	target	type
      //   15	24	114	java/lang/Exception
      //   15	24	76	finally
      //   24	33	118	java/lang/Exception
      //   24	33	66	finally
      //   38	46	118	java/lang/Exception
      //   38	46	66	finally
      //   49	54	118	java/lang/Exception
      //   49	54	66	finally
      //   54	59	122	java/io/IOException
      //   59	63	122	java/io/IOException
      //   79	84	126	java/io/IOException
      //   88	92	126	java/io/IOException
      //   96	101	122	java/io/IOException
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/bytedance/sdk/openadsdk/component/splash/a;
      //   4: invokestatic a : (Lcom/bytedance/sdk/openadsdk/component/splash/a;)Lcom/bytedance/sdk/openadsdk/utils/ak;
      //   7: invokevirtual obtainMessage : ()Landroid/os/Message;
      //   10: astore_1
      //   11: aload_1
      //   12: iconst_1
      //   13: putfield what : I
      //   16: aload_0
      //   17: getfield a : Lcom/bytedance/sdk/openadsdk/component/splash/a;
      //   20: aload_0
      //   21: getfield c : Ljava/lang/String;
      //   24: invokestatic a : (Lcom/bytedance/sdk/openadsdk/component/splash/a;Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/core/d/a;
      //   27: astore_3
      //   28: new com/bytedance/sdk/openadsdk/core/d/n
      //   31: dup
      //   32: aload_3
      //   33: aconst_null
      //   34: aconst_null
      //   35: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/d/a;Lcom/bytedance/sdk/openadsdk/core/d/k;[B)V
      //   38: astore_2
      //   39: aload_3
      //   40: ifnull -> 119
      //   43: aload_3
      //   44: invokevirtual c : ()Ljava/util/List;
      //   47: ifnull -> 119
      //   50: aload_3
      //   51: invokevirtual c : ()Ljava/util/List;
      //   54: invokeinterface isEmpty : ()Z
      //   59: ifne -> 119
      //   62: aload_3
      //   63: invokevirtual c : ()Ljava/util/List;
      //   66: iconst_0
      //   67: invokeinterface get : (I)Ljava/lang/Object;
      //   72: checkcast com/bytedance/sdk/openadsdk/core/d/k
      //   75: astore_3
      //   76: aload_3
      //   77: ifnull -> 119
      //   80: aload_3
      //   81: invokevirtual aa : ()Z
      //   84: ifeq -> 119
      //   87: aload_0
      //   88: aload_0
      //   89: getfield b : Ljava/io/File;
      //   92: invokespecial a : (Ljava/io/File;)[B
      //   95: astore #4
      //   97: aload #4
      //   99: ifnull -> 119
      //   102: aload #4
      //   104: arraylength
      //   105: ifeq -> 119
      //   108: aload_2
      //   109: aload_3
      //   110: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/core/d/k;)V
      //   113: aload_2
      //   114: aload #4
      //   116: invokevirtual a : ([B)V
      //   119: aload_1
      //   120: aload_2
      //   121: putfield obj : Ljava/lang/Object;
      //   124: aload_0
      //   125: getfield a : Lcom/bytedance/sdk/openadsdk/component/splash/a;
      //   128: invokestatic a : (Lcom/bytedance/sdk/openadsdk/component/splash/a;)Lcom/bytedance/sdk/openadsdk/utils/ak;
      //   131: aload_1
      //   132: invokevirtual sendMessage : (Landroid/os/Message;)Z
      //   135: pop
      //   136: aload_0
      //   137: getfield a : Lcom/bytedance/sdk/openadsdk/component/splash/a;
      //   140: aload_0
      //   141: getfield c : Ljava/lang/String;
      //   144: invokevirtual d : (Ljava/lang/String;)V
      //   147: return
      //   148: astore_2
      //   149: goto -> 124
      //   152: astore_1
      //   153: return
      // Exception table:
      //   from	to	target	type
      //   16	39	148	finally
      //   43	76	148	finally
      //   80	97	148	finally
      //   102	119	148	finally
      //   119	124	148	finally
      //   136	147	152	finally
    }
  }
  
  static class d implements Runnable {
    private n a;
    
    private File b;
    
    public d(n param1n, File param1File) {
      this.a = param1n;
      this.b = param1File;
    }
    
    private void a() {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_3
      //   4: aload_3
      //   5: astore_1
      //   6: aload_0
      //   7: getfield a : Lcom/bytedance/sdk/openadsdk/core/d/n;
      //   10: ifnull -> 65
      //   13: aload_3
      //   14: astore_1
      //   15: aload_0
      //   16: getfield a : Lcom/bytedance/sdk/openadsdk/core/d/n;
      //   19: invokevirtual b : ()[B
      //   22: ifnull -> 65
      //   25: new java/io/BufferedOutputStream
      //   28: dup
      //   29: new java/io/FileOutputStream
      //   32: dup
      //   33: aload_0
      //   34: getfield b : Ljava/io/File;
      //   37: invokespecial <init> : (Ljava/io/File;)V
      //   40: invokespecial <init> : (Ljava/io/OutputStream;)V
      //   43: astore_1
      //   44: aload_1
      //   45: aload_0
      //   46: getfield a : Lcom/bytedance/sdk/openadsdk/core/d/n;
      //   49: invokevirtual b : ()[B
      //   52: invokevirtual write : ([B)V
      //   55: aload_1
      //   56: invokevirtual flush : ()V
      //   59: goto -> 65
      //   62: goto -> 74
      //   65: aload_1
      //   66: ifnull -> 81
      //   69: aload_1
      //   70: invokevirtual close : ()V
      //   73: return
      //   74: aload_1
      //   75: ifnull -> 81
      //   78: goto -> 69
      //   81: return
      //   82: astore_1
      //   83: aload_2
      //   84: astore_1
      //   85: goto -> 74
      //   88: astore_2
      //   89: goto -> 62
      //   92: astore_1
      //   93: return
      // Exception table:
      //   from	to	target	type
      //   6	13	82	finally
      //   15	44	82	finally
      //   44	59	88	finally
      //   69	73	92	finally
    }
    
    private void b() {
      int i = c.c(this.a);
      if (i <= 0)
        return; 
      if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("materialMeta");
        stringBuilder1.append(i);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta", stringBuilder1.toString(), this.a.c().d());
        return;
      } 
      SharedPreferences.Editor editor = o.a().getSharedPreferences("tt_materialMeta", 0).edit();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("materialMeta");
      stringBuilder.append(i);
      editor.putString(stringBuilder.toString(), this.a.c().d()).apply();
    }
    
    public void a(n param1n) {
      this.a = param1n;
    }
    
    public void a(File param1File) {
      this.b = param1File;
    }
    
    public void run() {
      a();
      b();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\splash\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */