package com.qq.e.comm.plugin.i;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.a.f;
import com.qq.e.comm.plugin.a.n;
import com.qq.e.comm.plugin.a.p;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.av;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

class b {
  private ak.a a = null;
  
  private Context b = GDTADManager.getInstance().getAppContext();
  
  private void a(IGDTApkListener paramIGDTApkListener, int paramInt, String paramString) {
    if (paramIGDTApkListener != null)
      y.a(new Runnable(this, paramIGDTApkListener, paramInt, paramString) {
            public void run() {
              this.a.onError(new AdError(this.b, this.c));
            }
          }); 
  }
  
  private void a(IGDTApkListener paramIGDTApkListener, a parama) {
    y.a(new Runnable(this, paramIGDTApkListener, parama) {
          public void run() {
            IGDTApkListener iGDTApkListener = this.a;
            if (iGDTApkListener != null)
              iGDTApkListener.onApkLoad(this.b); 
          }
        });
  }
  
  public void a(Context paramContext, GDTApk paramGDTApk, IGDTApkListener paramIGDTApkListener) {
    p p;
    if (paramContext == null || paramGDTApk == null || paramIGDTApkListener == null) {
      String str = "传入参数为 null";
    } else {
      c c = null;
      if (paramGDTApk instanceof a)
        c = ((a)paramGDTApk).a(); 
      if (c == null) {
        String str = "传入的 GDTApk 为 null";
      } else {
        char c1;
        u.a(100422, 1, (new c()).b(c.l()));
        if (!com.qq.e.comm.plugin.a.e.a.a(c)) {
          c1 = 'Ꮃ';
          String str = "调用安装器时，Apk 文件不存在";
        } else {
          String str;
          if (d.a(av.b("downloaded_not_installed_apk", System.currentTimeMillis()), System.currentTimeMillis(), c)) {
            c1 = 'Ꮂ';
            str = "接口调用时间间隔过长!";
          } else {
            p = new p((Context)str, c);
            p.a(new a(this, c) {
                  public void a(int param1Int, String param1String, boolean param1Boolean) {
                    if (param1Int == 0) {
                      JSONObject jSONObject = this.a.s();
                      if (jSONObject != null) {
                        try {
                          String str = jSONObject.optJSONObject("reportUrl").optString(String.valueOf(2));
                          if (TextUtils.isEmpty(str)) {
                            com.qq.e.comm.plugin.a.b.a(this.a, true);
                          } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append("&tips_install=1");
                            ah.a(stringBuilder.toString(), true, null);
                          } 
                        } catch (Exception exception) {
                          exception.printStackTrace();
                          com.qq.e.comm.plugin.a.b.a(this.a, true);
                        } 
                        n.a(this.a);
                        ak.a("ApkInstallWorker.SUCCESS", b.a(this.b));
                        return;
                      } 
                    } else {
                      return;
                    } 
                    com.qq.e.comm.plugin.a.b.a(this.a, true);
                  }
                  
                  public boolean a() {
                    return true;
                  }
                });
            p.a(d.c(c));
            return;
          } 
        } 
        a(paramIGDTApkListener, c1, (String)p);
        return;
      } 
    } 
    GDTLogger.e((String)p);
  }
  
  public void a(IGDTApkListener paramIGDTApkListener) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   3: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   6: ldc 'apk_downloaded_task'
    //   8: iconst_0
    //   9: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   12: ifne -> 30
    //   15: sipush #5045
    //   18: istore_2
    //   19: ldc '接口功能未开启'
    //   21: astore_3
    //   22: aload_0
    //   23: aload_1
    //   24: iload_2
    //   25: aload_3
    //   26: invokespecial a : (Lcom/qq/e/ads/dfa/IGDTApkListener;ILjava/lang/String;)V
    //   29: return
    //   30: invokestatic a : ()Z
    //   33: ifeq -> 46
    //   36: sipush #5041
    //   39: istore_2
    //   40: ldc '调用接口短时间内过于频繁，请稍后再试!'
    //   42: astore_3
    //   43: goto -> 22
    //   46: invokestatic a : ()Lcom/qq/e/comm/plugin/a/l;
    //   49: invokevirtual e : ()Ljava/util/List;
    //   52: astore #6
    //   54: aload #6
    //   56: invokestatic a : (Ljava/util/List;)Z
    //   59: ifeq -> 73
    //   62: aload_0
    //   63: aload_1
    //   64: sipush #5044
    //   67: ldc '不存在有效的 Apk 文件'
    //   69: invokespecial a : (Lcom/qq/e/ads/dfa/IGDTApkListener;ILjava/lang/String;)V
    //   72: return
    //   73: aload #6
    //   75: invokeinterface size : ()I
    //   80: iconst_1
    //   81: if_icmpne -> 261
    //   84: aload #6
    //   86: iconst_0
    //   87: invokeinterface get : (I)Ljava/lang/Object;
    //   92: checkcast com/qq/e/comm/plugin/a/c
    //   95: astore_3
    //   96: aload_3
    //   97: invokestatic a : (Lcom/qq/e/comm/plugin/a/c;)Z
    //   100: ifne -> 62
    //   103: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   106: invokevirtual getAppContext : ()Landroid/content/Context;
    //   109: aload_3
    //   110: invokevirtual h : ()Ljava/lang/String;
    //   113: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   116: ifne -> 62
    //   119: aload_3
    //   120: iconst_1
    //   121: invokevirtual a : (Z)V
    //   124: invokestatic a : ()Lcom/qq/e/comm/plugin/a/l;
    //   127: aload_3
    //   128: invokevirtual b : (Lcom/qq/e/comm/plugin/a/c;)I
    //   131: pop
    //   132: new java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial <init> : ()V
    //   139: astore #4
    //   141: aload #4
    //   143: aload_3
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload #4
    //   153: ldc ' , , time='
    //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload #4
    //   161: invokestatic currentTimeMillis : ()J
    //   164: aload_3
    //   165: invokevirtual d : ()J
    //   168: lsub
    //   169: l2f
    //   170: fconst_1
    //   171: fmul
    //   172: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #4
    //   178: ldc 'ms'
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #4
    //   186: invokevirtual toString : ()Ljava/lang/String;
    //   189: aload_0
    //   190: getfield a : Lcom/qq/e/comm/plugin/util/ak$a;
    //   193: invokestatic a : (Ljava/lang/String;Lcom/qq/e/comm/plugin/util/ak$a;)V
    //   196: ldc 'downloaded_not_installed_apk'
    //   198: invokestatic currentTimeMillis : ()J
    //   201: invokestatic a : (Ljava/lang/String;J)V
    //   204: ldc 100412
    //   206: iconst_1
    //   207: new com/qq/e/comm/plugin/y/c
    //   210: dup
    //   211: invokespecial <init> : ()V
    //   214: aload_3
    //   215: invokevirtual l : ()Ljava/lang/String;
    //   218: invokevirtual b : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   221: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;)V
    //   224: aload_3
    //   225: invokestatic a : (Lcom/qq/e/comm/plugin/a/c;)Z
    //   228: ifeq -> 62
    //   231: aload_3
    //   232: invokestatic c : (Lcom/qq/e/comm/plugin/a/c;)Ljava/io/File;
    //   235: aload_3
    //   236: invokevirtual h : ()Ljava/lang/String;
    //   239: aload_0
    //   240: getfield b : Landroid/content/Context;
    //   243: invokestatic a : (Ljava/io/File;Ljava/lang/String;Landroid/content/Context;)Z
    //   246: ifeq -> 62
    //   249: aload_3
    //   250: invokestatic b : (Lcom/qq/e/comm/plugin/a/c;)Lcom/qq/e/comm/plugin/i/a;
    //   253: astore_3
    //   254: aload_0
    //   255: aload_1
    //   256: aload_3
    //   257: invokespecial a : (Lcom/qq/e/ads/dfa/IGDTApkListener;Lcom/qq/e/comm/plugin/i/a;)V
    //   260: return
    //   261: aload #6
    //   263: invokeinterface iterator : ()Ljava/util/Iterator;
    //   268: astore_3
    //   269: aload_3
    //   270: invokeinterface hasNext : ()Z
    //   275: ifeq -> 351
    //   278: aload_3
    //   279: invokeinterface next : ()Ljava/lang/Object;
    //   284: checkcast com/qq/e/comm/plugin/a/c
    //   287: astore #4
    //   289: aload #4
    //   291: invokestatic a : (Lcom/qq/e/comm/plugin/a/c;)Z
    //   294: ifne -> 342
    //   297: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   300: invokevirtual getAppContext : ()Landroid/content/Context;
    //   303: aload #4
    //   305: invokevirtual h : ()Ljava/lang/String;
    //   308: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   311: ifne -> 342
    //   314: aload #4
    //   316: invokestatic a : (Lcom/qq/e/comm/plugin/a/c;)Z
    //   319: ifeq -> 342
    //   322: aload #4
    //   324: invokestatic c : (Lcom/qq/e/comm/plugin/a/c;)Ljava/io/File;
    //   327: aload #4
    //   329: invokevirtual h : ()Ljava/lang/String;
    //   332: aload_0
    //   333: getfield b : Landroid/content/Context;
    //   336: invokestatic a : (Ljava/io/File;Ljava/lang/String;Landroid/content/Context;)Z
    //   339: ifne -> 269
    //   342: aload_3
    //   343: invokeinterface remove : ()V
    //   348: goto -> 269
    //   351: aload #6
    //   353: invokestatic a : (Ljava/util/List;)Z
    //   356: ifeq -> 362
    //   359: goto -> 62
    //   362: aload #6
    //   364: invokestatic b : (Ljava/util/List;)V
    //   367: aload #6
    //   369: iconst_0
    //   370: invokeinterface get : (I)Ljava/lang/Object;
    //   375: checkcast com/qq/e/comm/plugin/a/c
    //   378: astore_3
    //   379: iconst_1
    //   380: istore_2
    //   381: iload_2
    //   382: aload #6
    //   384: invokeinterface size : ()I
    //   389: if_icmpge -> 450
    //   392: aload #6
    //   394: iload_2
    //   395: invokeinterface get : (I)Ljava/lang/Object;
    //   400: checkcast com/qq/e/comm/plugin/a/c
    //   403: astore #5
    //   405: aload #5
    //   407: invokevirtual c : ()Z
    //   410: ifne -> 426
    //   413: aload_3
    //   414: invokevirtual d : ()J
    //   417: aload #5
    //   419: invokevirtual d : ()J
    //   422: lcmp
    //   423: ifgt -> 436
    //   426: aload_3
    //   427: astore #4
    //   429: aload_3
    //   430: invokevirtual c : ()Z
    //   433: ifeq -> 440
    //   436: aload #5
    //   438: astore #4
    //   440: iload_2
    //   441: iconst_1
    //   442: iadd
    //   443: istore_2
    //   444: aload #4
    //   446: astore_3
    //   447: goto -> 381
    //   450: aload_3
    //   451: iconst_1
    //   452: invokevirtual a : (Z)V
    //   455: invokestatic a : ()Lcom/qq/e/comm/plugin/a/l;
    //   458: aload_3
    //   459: invokevirtual b : (Lcom/qq/e/comm/plugin/a/c;)I
    //   462: pop
    //   463: ldc 'downloaded_not_installed_apk'
    //   465: invokestatic currentTimeMillis : ()J
    //   468: invokestatic a : (Ljava/lang/String;J)V
    //   471: ldc 100412
    //   473: iconst_1
    //   474: new com/qq/e/comm/plugin/y/c
    //   477: dup
    //   478: invokespecial <init> : ()V
    //   481: aload_3
    //   482: invokevirtual l : ()Ljava/lang/String;
    //   485: invokevirtual b : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   488: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;)V
    //   491: aload_3
    //   492: invokestatic b : (Lcom/qq/e/comm/plugin/a/c;)Lcom/qq/e/comm/plugin/i/a;
    //   495: astore_3
    //   496: goto -> 254
  }
  
  static interface a extends f.a {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */