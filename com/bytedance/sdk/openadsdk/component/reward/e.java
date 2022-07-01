package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e {
  private static volatile e a;
  
  private final Context b;
  
  private final h c;
  
  private Map<k, Long> d = Collections.synchronizedMap(new HashMap<k, Long>());
  
  private e(Context paramContext) {
    if (paramContext == null) {
      paramContext = o.a();
    } else {
      paramContext = paramContext.getApplicationContext();
    } 
    this.b = paramContext;
    this.c = new h(this.b, "sp_reward_video");
  }
  
  public static e a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/component/reward/e.a : Lcom/bytedance/sdk/openadsdk/component/reward/e;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/component/reward/e
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/component/reward/e.a : Lcom/bytedance/sdk/openadsdk/component/reward/e;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/component/reward/e
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/component/reward/e.a : Lcom/bytedance/sdk/openadsdk/component/reward/e;
    //   26: ldc com/bytedance/sdk/openadsdk/component/reward/e
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/component/reward/e
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/component/reward/e.a : Lcom/bytedance/sdk/openadsdk/component/reward/e;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private File a(Context paramContext, String paramString1, String paramString2) {
    return k.a(paramContext, b.b(), paramString1, paramString2);
  }
  
  private String a(String paramString, boolean paramBoolean) {
    if (paramBoolean) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("reward_video_cache_");
      stringBuilder1.append(paramString);
      stringBuilder1.append("/");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/reward_video_cache_");
    stringBuilder.append(paramString);
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  private void a(File paramFile) {
    try {
      h.c().p().a(paramFile);
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("trimFileCache IOException:");
      stringBuilder.append(iOException.toString());
      t.e("RewardVideoCache", stringBuilder.toString());
      return;
    } 
  }
  
  private void a(boolean paramBoolean, k paramk, long paramLong, n paramn) {
    long l;
    String str;
    Long long_ = this.d.remove(paramk);
    if (long_ == null) {
      l = 0L;
    } else {
      l = SystemClock.elapsedRealtime() - long_.longValue();
    } 
    if (paramBoolean) {
      str = "load_video_success";
    } else {
      str = "load_video_error";
    } 
    if (!paramBoolean && paramn != null && paramn.c != null) {
      String str1 = paramn.c.getMessage();
    } else {
      paramn = null;
    } 
    Map map = ah.a(paramBoolean, paramk, l, paramLong, (String)paramn);
    d.m(this.b, paramk, "rewarded_video", str, map);
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
    paramString1 = a(String.valueOf(paramString3), b.b());
    File file = a(this.b, paramString1, str);
    return (file != null && file.exists() && file.isFile()) ? file.getAbsolutePath() : null;
  }
  
  public void a() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: getstatic android/os/Build$VERSION.SDK_INT : I
    //   5: istore_1
    //   6: iload_1
    //   7: bipush #24
    //   9: if_icmplt -> 33
    //   12: new java/io/File
    //   15: dup
    //   16: aload_0
    //   17: getfield b : Landroid/content/Context;
    //   20: invokevirtual getDataDir : ()Ljava/io/File;
    //   23: ldc 'shared_prefs'
    //   25: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   28: astore #4
    //   30: goto -> 59
    //   33: new java/io/File
    //   36: dup
    //   37: aload_0
    //   38: getfield b : Landroid/content/Context;
    //   41: ldc '1'
    //   43: invokevirtual getDatabasePath : (Ljava/lang/String;)Ljava/io/File;
    //   46: invokevirtual getParentFile : ()Ljava/io/File;
    //   49: invokevirtual getParentFile : ()Ljava/io/File;
    //   52: ldc 'shared_prefs'
    //   54: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   57: astore #4
    //   59: aload #4
    //   61: invokevirtual exists : ()Z
    //   64: ifeq -> 186
    //   67: aload #4
    //   69: invokevirtual isDirectory : ()Z
    //   72: ifeq -> 186
    //   75: aload #4
    //   77: new com/bytedance/sdk/openadsdk/component/reward/e$1
    //   80: dup
    //   81: aload_0
    //   82: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/reward/e;)V
    //   85: invokevirtual listFiles : (Ljava/io/FileFilter;)[Ljava/io/File;
    //   88: astore #4
    //   90: aload #4
    //   92: ifnull -> 186
    //   95: aload #4
    //   97: arraylength
    //   98: istore_3
    //   99: iconst_0
    //   100: istore_1
    //   101: iload_1
    //   102: iload_3
    //   103: if_icmpge -> 186
    //   106: aload #4
    //   108: iload_1
    //   109: aaload
    //   110: astore #5
    //   112: aload #5
    //   114: invokevirtual getName : ()Ljava/lang/String;
    //   117: ldc_w '.xml'
    //   120: ldc_w ''
    //   123: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   126: astore #6
    //   128: getstatic android/os/Build$VERSION.SDK_INT : I
    //   131: bipush #24
    //   133: if_icmplt -> 149
    //   136: aload_0
    //   137: getfield b : Landroid/content/Context;
    //   140: aload #6
    //   142: invokevirtual deleteSharedPreferences : (Ljava/lang/String;)Z
    //   145: pop
    //   146: goto -> 179
    //   149: aload_0
    //   150: getfield b : Landroid/content/Context;
    //   153: aload #6
    //   155: iconst_0
    //   156: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   159: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   164: invokeinterface clear : ()Landroid/content/SharedPreferences$Editor;
    //   169: invokeinterface apply : ()V
    //   174: aload #5
    //   176: invokestatic c : (Ljava/io/File;)V
    //   179: iload_1
    //   180: iconst_1
    //   181: iadd
    //   182: istore_1
    //   183: goto -> 101
    //   186: ldc_w 'mounted'
    //   189: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   192: invokevirtual equals : (Ljava/lang/Object;)Z
    //   195: ifne -> 204
    //   198: invokestatic isExternalStorageRemovable : ()Z
    //   201: ifne -> 226
    //   204: aload_0
    //   205: getfield b : Landroid/content/Context;
    //   208: invokevirtual getExternalCacheDir : ()Ljava/io/File;
    //   211: ifnull -> 226
    //   214: aload_0
    //   215: getfield b : Landroid/content/Context;
    //   218: invokevirtual getExternalCacheDir : ()Ljava/io/File;
    //   221: astore #4
    //   223: goto -> 235
    //   226: aload_0
    //   227: getfield b : Landroid/content/Context;
    //   230: invokevirtual getCacheDir : ()Ljava/io/File;
    //   233: astore #4
    //   235: aload #4
    //   237: ifnull -> 311
    //   240: aload #4
    //   242: invokevirtual exists : ()Z
    //   245: ifeq -> 311
    //   248: aload #4
    //   250: invokevirtual isDirectory : ()Z
    //   253: ifeq -> 311
    //   256: aload #4
    //   258: new com/bytedance/sdk/openadsdk/component/reward/e$2
    //   261: dup
    //   262: aload_0
    //   263: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/reward/e;)V
    //   266: invokevirtual listFiles : (Ljava/io/FileFilter;)[Ljava/io/File;
    //   269: astore #4
    //   271: aload #4
    //   273: ifnull -> 311
    //   276: aload #4
    //   278: arraylength
    //   279: ifle -> 311
    //   282: aload #4
    //   284: arraylength
    //   285: istore_3
    //   286: iload_2
    //   287: istore_1
    //   288: iload_1
    //   289: iload_3
    //   290: if_icmpge -> 311
    //   293: aload #4
    //   295: iload_1
    //   296: aaload
    //   297: astore #5
    //   299: aload #5
    //   301: invokestatic c : (Ljava/io/File;)V
    //   304: iload_1
    //   305: iconst_1
    //   306: iadd
    //   307: istore_1
    //   308: goto -> 288
    //   311: return
    //   312: astore #4
    //   314: goto -> 186
    //   317: astore #5
    //   319: goto -> 179
    //   322: astore #4
    //   324: return
    //   325: astore #5
    //   327: goto -> 304
    // Exception table:
    //   from	to	target	type
    //   2	6	312	finally
    //   12	30	312	finally
    //   33	59	312	finally
    //   59	90	312	finally
    //   95	99	312	finally
    //   112	146	317	finally
    //   149	179	317	finally
    //   186	204	322	finally
    //   204	223	322	finally
    //   226	235	322	finally
    //   240	271	322	finally
    //   276	286	322	finally
    //   299	304	325	finally
  }
  
  public void a(AdSlot paramAdSlot) {
    this.c.a(paramAdSlot);
  }
  
  public void a(AdSlot paramAdSlot, k paramk) {
    a(paramAdSlot);
    if (paramk != null)
      try {
        String str = paramAdSlot.getCodeId();
        return;
      } finally {
        paramAdSlot = null;
      }  
  }
  
  public void a(k paramk, a<Object> parama) {
    this.d.put(paramk, Long.valueOf(SystemClock.elapsedRealtime()));
    if (paramk == null || paramk.z() == null || TextUtils.isEmpty(paramk.z().g())) {
      if (parama != null)
        parama.a(false, null); 
      a(false, paramk, -1L, null);
      return;
    } 
    String str3 = paramk.z().g();
    String str2 = paramk.z().j();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = j.a(str3); 
    int i = ah.d(paramk.P());
    str2 = a(String.valueOf(i), b.b());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ritId:");
    stringBuilder.append(i);
    stringBuilder.append(",cacheDirPath=");
    stringBuilder.append(str2);
    t.e("wzj", stringBuilder.toString());
    File file = a(this.b, str2, str1);
    com.bytedance.sdk.openadsdk.g.e.a(this.b).a(str3, new b.a(this, file, str1, parama, paramk) {
          public File a(String param1String) {
            try {
              File file = this.a.getParentFile();
              if (file != null && file.exists())
                return h.c().p().a(this.b, file); 
            } catch (IOException iOException) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("datastoreGet throw IOException : ");
              stringBuilder.append(iOException.toString());
              t.e("RewardVideoCache", stringBuilder.toString());
            } 
            return null;
          }
          
          public void a(long param1Long1, long param1Long2) {}
          
          public void a(n<File> param1n) {
            long l;
            if (param1n != null && param1n.a != null) {
              e.a a2 = this.c;
              if (a2 != null)
                a2.a(true, null); 
              e.a(this.e, true, this.d, 0L, param1n);
              return;
            } 
            e.a a1 = this.c;
            if (a1 != null)
              a1.a(false, null); 
            e e1 = this.e;
            k k1 = this.d;
            if (param1n == null) {
              l = -3L;
            } else {
              l = param1n.h;
            } 
            e.a(e1, false, k1, l, param1n);
          }
          
          public void a(String param1String, File param1File) {
            if (param1File != null)
              e.a(this.e, param1File); 
          }
          
          public File b(String param1String) {
            return this.a;
          }
          
          public void b(n<File> param1n) {
            long l;
            e.a a1 = this.c;
            if (a1 != null)
              a1.a(false, null); 
            e e1 = this.e;
            k k1 = this.d;
            if (param1n == null) {
              l = -2L;
            } else {
              l = param1n.h;
            } 
            e.a(e1, false, k1, l, param1n);
          }
        });
  }
  
  public void a(String paramString) {
    this.c.d(paramString);
  }
  
  public AdSlot b() {
    return this.c.a();
  }
  
  public AdSlot b(String paramString) {
    return this.c.e(paramString);
  }
  
  public void b(AdSlot paramAdSlot) {
    this.c.b(paramAdSlot);
  }
  
  public k c(String paramString) {
    boolean bool;
    long l = this.c.b(paramString);
    boolean bool1 = this.c.c(paramString);
    if (System.currentTimeMillis() - l < 10800000L) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && !bool1)
      try {
        String str = this.c.a(paramString);
        if (!TextUtils.isEmpty(str)) {
          k k = c.a(new JSONObject(str));
          if (k != null && k.z() != null) {
            r r = k.z();
            bool1 = TextUtils.isEmpty(a(r.g(), r.j(), paramString));
            if (!bool1)
              return k; 
          } 
        } 
      } catch (Exception exception) {} 
    return null;
  }
  
  static interface a<T> {
    void a(boolean param1Boolean, T param1T);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */