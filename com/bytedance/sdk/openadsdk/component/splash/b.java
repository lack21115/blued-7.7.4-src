package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.n;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class b implements ak.a {
  private static Set<b> j = Collections.synchronizedSet(new HashSet<b>());
  
  private AdSlot a;
  
  private l b;
  
  private TTAdNative.SplashAdListener c = null;
  
  private final p d;
  
  private Context e;
  
  private final ak f;
  
  private final AtomicBoolean g = new AtomicBoolean(false);
  
  private e h;
  
  private e i;
  
  private a k;
  
  private AtomicBoolean l = new AtomicBoolean(false);
  
  private AtomicBoolean m = new AtomicBoolean(false);
  
  private AtomicBoolean n = new AtomicBoolean(false);
  
  private boolean o;
  
  private long p;
  
  private long q;
  
  private long r = 0L;
  
  private final AtomicBoolean s = new AtomicBoolean(false);
  
  private final AtomicBoolean t = new AtomicBoolean(false);
  
  private AtomicBoolean u = new AtomicBoolean(false);
  
  private AtomicBoolean v = new AtomicBoolean(false);
  
  private a w;
  
  private b(Context paramContext) {
    if (paramContext != null)
      this.e = paramContext.getApplicationContext(); 
    this.d = o.f();
    this.f = new ak(Looper.myLooper(), this);
    paramContext = this.e;
    if (paramContext == null)
      paramContext = o.a(); 
    this.k = a.a(paramContext);
    this.o = o.h().u();
    j.add(this);
  }
  
  public static b a(Context paramContext) {
    return new b(paramContext);
  }
  
  private e a(n paramn, String paramString) {
    if (!c.a(paramn))
      return null; 
    if (paramString != null)
      paramn.a().d(true); 
    e e1 = new e(this.e, paramn.a(), paramString, this.a, "splash_ad");
    this.h = e1;
    return e1;
  }
  
  private d a(int paramInt, n paramn) {
    String str1;
    String str2;
    String str3;
    n n1 = null;
    if (paramn != null && paramn.a() != null) {
      String str4 = paramn.a().M();
      String str5 = paramn.a().P();
      paramn = n1;
      str2 = str4;
      str1 = str5;
      if (!TextUtils.isEmpty(str5))
        try {
        
        } finally {
          paramn = null;
          paramn = n1;
          str2 = str4;
        }  
    } else {
      str1 = null;
      str2 = str1;
      paramn = n1;
    } 
    n1 = paramn;
    if (paramn == null)
      str3 = this.b.a; 
    d d = d.b().f(str3).a(paramInt).c(this.a.getCodeId());
    if (str2 != null)
      d.d(str2); 
    if (str1 != null)
      d.h(str1); 
    return d;
  }
  
  private void a() {
    if (this.c == null)
      return; 
    int i = o.h().r();
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          this.s.set(false);
          this.t.set(true);
          t.b("splashLoadAd", "splash_type_concurrent_first_come_first_use=====并发请求广告和check缓存，谁先到用谁");
          a(this.a);
          b();
          return;
        } 
        t.b("splashLoadAd", "splash_type_concurrent_priority_real_time=====并发请求广告和check缓存，优先使用实时");
        this.s.set(true);
        this.t.set(false);
        a(this.a);
        b();
        return;
      } 
      this.s.set(false);
      this.t.set(false);
      t.b("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存");
      if (!b()) {
        t.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存失败，进行网络请求");
        a(this.a);
        return;
      } 
      t.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存成功！！");
      return;
    } 
    this.s.set(false);
    this.t.set(false);
    t.b("splashLoadAd", "splash_type_real_time=====只走实时");
    a(this.a);
  }
  
  private void a(int paramInt, a parama, n paramn, e parame, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: sipush #15000
    //   6: if_icmpne -> 57
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #8
    //   18: aload #8
    //   20: ldc_w 'splashAdTryCallback start....实时请求来了！='
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload #8
    //   29: aload #4
    //   31: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: ldc_w 'splashLoadAd'
    //   38: aload #8
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield u : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   50: iconst_1
    //   51: invokevirtual set : (Z)V
    //   54: goto -> 203
    //   57: iload_1
    //   58: sipush #15001
    //   61: if_icmpne -> 112
    //   64: new java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: astore #8
    //   73: aload #8
    //   75: ldc_w 'splashAdTryCallback start....缓存请求来了！='
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #8
    //   84: aload #4
    //   86: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc_w 'splashLoadAd'
    //   93: aload #8
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_0
    //   102: getfield v : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   105: iconst_1
    //   106: invokevirtual set : (Z)V
    //   109: goto -> 203
    //   112: iload_1
    //   113: sipush #15004
    //   116: if_icmpne -> 159
    //   119: new java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial <init> : ()V
    //   126: astore #8
    //   128: aload #8
    //   130: ldc_w 'splashAdTryCallback start....超时请求来了！='
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload #8
    //   139: aload #4
    //   141: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc_w 'splashLoadAd'
    //   148: aload #8
    //   150: invokevirtual toString : ()Ljava/lang/String;
    //   153: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -> 203
    //   159: iload_1
    //   160: sipush #15003
    //   163: if_icmpne -> 203
    //   166: new java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial <init> : ()V
    //   173: astore #8
    //   175: aload #8
    //   177: ldc_w 'splashAdTryCallback start....渲染超时请求来了！='
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #8
    //   186: aload #4
    //   188: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: ldc_w 'splashLoadAd'
    //   195: aload #8
    //   197: invokevirtual toString : ()Ljava/lang/String;
    //   200: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_0
    //   204: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   207: invokevirtual get : ()Z
    //   210: ifeq -> 225
    //   213: ldc_w 'splashLoadAd'
    //   216: ldc_w 'splashAdTryCallback mSplashAdHasLoad==true 已成功回调，不再执行回调操作！！！'
    //   219: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: monitorexit
    //   224: return
    //   225: aload #4
    //   227: ifnonnull -> 558
    //   230: aload_0
    //   231: getfield s : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   234: invokevirtual get : ()Z
    //   237: ifne -> 265
    //   240: aload_0
    //   241: getfield t : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   244: invokevirtual get : ()Z
    //   247: ifeq -> 253
    //   250: goto -> 265
    //   253: ldc_w 'splashLoadAd'
    //   256: ldc_w '普通类型走这，直接失败回调'
    //   259: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   262: goto -> 550
    //   265: iload_1
    //   266: sipush #15000
    //   269: if_icmpne -> 392
    //   272: aload_0
    //   273: getfield v : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   276: invokevirtual get : ()Z
    //   279: ifne -> 294
    //   282: ldc_w 'splashLoadAd'
    //   285: ldc_w 'splashAdTryCallback 实时请求失败（实时先回，缓存还没回）...等待缓存'
    //   288: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload_0
    //   292: monitorexit
    //   293: return
    //   294: ldc_w 'splashLoadAd'
    //   297: ldc_w 'splashAdTryCallback 实时请求失败（缓存先回，实时后回）....'
    //   300: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload_0
    //   304: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   307: invokevirtual get : ()Z
    //   310: ifeq -> 360
    //   313: aload_0
    //   314: getfield m : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   317: invokevirtual get : ()Z
    //   320: ifne -> 333
    //   323: aload_0
    //   324: getfield n : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   327: invokevirtual get : ()Z
    //   330: ifeq -> 360
    //   333: aload_0
    //   334: getfield w : Lcom/bytedance/sdk/openadsdk/component/splash/b$a;
    //   337: ifnull -> 360
    //   340: ldc_w 'splashLoadAd'
    //   343: ldc_w 'splashAdTryCallback 实时请求失败（缓存先回，实时后回）....尝试回调缓存成功！'
    //   346: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_0
    //   350: aload_0
    //   351: getfield w : Lcom/bytedance/sdk/openadsdk/component/splash/b$a;
    //   354: invokespecial a : (Lcom/bytedance/sdk/openadsdk/component/splash/b$a;)V
    //   357: aload_0
    //   358: monitorexit
    //   359: return
    //   360: aload_0
    //   361: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   364: invokevirtual get : ()Z
    //   367: ifeq -> 550
    //   370: aload_0
    //   371: getfield n : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   374: invokevirtual get : ()Z
    //   377: ifne -> 550
    //   380: ldc_w 'splashLoadAd'
    //   383: ldc_w 'splashAdTryCallback 当为模版广告，存在缓存的情况下，模版渲染还没有回来时等待模版广告渲染回来！'
    //   386: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload_0
    //   390: monitorexit
    //   391: return
    //   392: iload_1
    //   393: sipush #15001
    //   396: if_icmpne -> 433
    //   399: aload_0
    //   400: getfield u : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   403: invokevirtual get : ()Z
    //   406: ifne -> 421
    //   409: ldc_w 'splashLoadAd'
    //   412: ldc_w 'splashAdTryCallback 缓存请求失败(缓存先回来)，实时还没有回调....等待...！'
    //   415: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   418: aload_0
    //   419: monitorexit
    //   420: return
    //   421: ldc_w 'splashLoadAd'
    //   424: ldc_w 'splashAdTryCallback 缓存请求失败(缓存先回来)，实时也失败....直接回调出去！'
    //   427: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   430: goto -> 550
    //   433: aload_0
    //   434: getfield s : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   437: invokevirtual get : ()Z
    //   440: ifeq -> 550
    //   443: iload_1
    //   444: sipush #15004
    //   447: if_icmpne -> 550
    //   450: ldc_w 'splashLoadAd'
    //   453: ldc_w '如果实时已超时，REQUEST_TYPE_TIMEOUT--->>>>'
    //   456: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload_0
    //   460: getfield v : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   463: invokevirtual get : ()Z
    //   466: ifeq -> 541
    //   469: aload_0
    //   470: getfield u : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   473: invokevirtual get : ()Z
    //   476: ifne -> 550
    //   479: aload_0
    //   480: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   483: invokevirtual get : ()Z
    //   486: ifeq -> 529
    //   489: aload_0
    //   490: getfield m : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   493: invokevirtual get : ()Z
    //   496: ifne -> 509
    //   499: aload_0
    //   500: getfield n : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   503: invokevirtual get : ()Z
    //   506: ifeq -> 529
    //   509: ldc_w 'splashLoadAd'
    //   512: ldc_w '如果实时已超时，缓存成功直接回调'
    //   515: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload_0
    //   519: aload_0
    //   520: getfield w : Lcom/bytedance/sdk/openadsdk/component/splash/b$a;
    //   523: invokespecial a : (Lcom/bytedance/sdk/openadsdk/component/splash/b$a;)V
    //   526: aload_0
    //   527: monitorexit
    //   528: return
    //   529: ldc_w 'splashLoadAd'
    //   532: ldc_w '如果实时已超时，直接失败回调'
    //   535: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   538: goto -> 550
    //   541: ldc_w 'splashLoadAd'
    //   544: ldc_w '如果实时已超时，缓存也失败直接回调，直接失败回调'
    //   547: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload_0
    //   551: aload_2
    //   552: invokespecial a : (Lcom/bytedance/sdk/openadsdk/component/splash/b$a;)V
    //   555: aload_0
    //   556: monitorexit
    //   557: return
    //   558: aload #5
    //   560: ifnonnull -> 581
    //   563: aload_3
    //   564: ifnull -> 581
    //   567: aload #4
    //   569: ifnull -> 581
    //   572: aload #4
    //   574: aload_3
    //   575: invokevirtual b : ()[B
    //   578: invokevirtual a : ([B)V
    //   581: aload_0
    //   582: getfield s : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   585: invokevirtual get : ()Z
    //   588: ifeq -> 703
    //   591: iload_1
    //   592: sipush #15001
    //   595: if_icmpne -> 703
    //   598: aload_0
    //   599: getfield v : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   602: invokevirtual get : ()Z
    //   605: ifeq -> 664
    //   608: aload_0
    //   609: getfield u : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   612: invokevirtual get : ()Z
    //   615: ifne -> 664
    //   618: aload_0
    //   619: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   622: invokevirtual get : ()Z
    //   625: ifeq -> 664
    //   628: aload_0
    //   629: getfield n : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   632: invokevirtual get : ()Z
    //   635: ifeq -> 664
    //   638: ldc_w 'splashLoadAd'
    //   641: ldc_w '缓存赋值给resultTemp'
    //   644: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload_0
    //   648: aload_2
    //   649: putfield w : Lcom/bytedance/sdk/openadsdk/component/splash/b$a;
    //   652: ldc_w 'splashLoadAd'
    //   655: ldc_w '如果缓存先回来,实时还没有回来，等待实时回来'
    //   658: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   661: aload_0
    //   662: monitorexit
    //   663: return
    //   664: aload_0
    //   665: getfield u : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   668: invokevirtual get : ()Z
    //   671: ifeq -> 703
    //   674: aload_0
    //   675: getfield i : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   678: ifnull -> 703
    //   681: aload_0
    //   682: getfield i : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   685: invokevirtual a : ()Z
    //   688: ifeq -> 703
    //   691: ldc_w 'splashLoadAd'
    //   694: ldc_w '此时实时可能在渲染，避免缓存的渲染成功后直接被回调'
    //   697: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload_0
    //   701: monitorexit
    //   702: return
    //   703: iload_1
    //   704: sipush #15000
    //   707: if_icmpne -> 719
    //   710: ldc_w 'splashLoadAd'
    //   713: ldc_w 'splashAdTryCallback 实时或渲染成功回调......！'
    //   716: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   719: new java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial <init> : ()V
    //   726: astore_3
    //   727: aload_3
    //   728: ldc_w 'splashAdTryCallback..（ 是否缓存已check成功：'
    //   731: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_3
    //   736: aload_0
    //   737: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   740: invokevirtual get : ()Z
    //   743: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload_3
    //   748: ldc_w ' || 是否渲染超时：'
    //   751: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: iconst_0
    //   756: istore #7
    //   758: iload_1
    //   759: sipush #15003
    //   762: if_icmpne -> 925
    //   765: iconst_1
    //   766: istore #6
    //   768: goto -> 771
    //   771: aload_3
    //   772: iload #6
    //   774: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload_3
    //   779: ldc_w ' || 是否为实时请求'
    //   782: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: iload #7
    //   788: istore #6
    //   790: iload_1
    //   791: sipush #15000
    //   794: if_icmpne -> 800
    //   797: iconst_1
    //   798: istore #6
    //   800: aload_3
    //   801: iload #6
    //   803: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload_3
    //   808: ldc_w '） && （是否实时模版渲染成功：'
    //   811: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload_3
    //   816: aload_0
    //   817: getfield m : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   820: invokevirtual get : ()Z
    //   823: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload_3
    //   828: ldc_w ' || 是否缓存模版渲染成功：'
    //   831: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload_3
    //   836: aload_0
    //   837: getfield n : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   840: invokevirtual get : ()Z
    //   843: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload_3
    //   848: ldc_w '）'
    //   851: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: ldc_w 'splashLoadAd'
    //   858: aload_3
    //   859: invokevirtual toString : ()Ljava/lang/String;
    //   862: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   865: aload_0
    //   866: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   869: invokevirtual get : ()Z
    //   872: ifne -> 889
    //   875: iload_1
    //   876: sipush #15000
    //   879: if_icmpeq -> 889
    //   882: iload_1
    //   883: sipush #15003
    //   886: if_icmpne -> 914
    //   889: aload_0
    //   890: getfield m : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   893: invokevirtual get : ()Z
    //   896: ifne -> 909
    //   899: aload_0
    //   900: getfield n : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   903: invokevirtual get : ()Z
    //   906: ifeq -> 914
    //   909: aload_0
    //   910: aload_2
    //   911: invokespecial a : (Lcom/bytedance/sdk/openadsdk/component/splash/b$a;)V
    //   914: aload_0
    //   915: monitorexit
    //   916: return
    //   917: aload_0
    //   918: monitorexit
    //   919: aload_2
    //   920: athrow
    //   921: astore_2
    //   922: goto -> 917
    //   925: iconst_0
    //   926: istore #6
    //   928: goto -> 771
    // Exception table:
    //   from	to	target	type
    //   9	54	921	finally
    //   64	109	921	finally
    //   119	156	921	finally
    //   166	203	921	finally
    //   203	222	921	finally
    //   230	250	921	finally
    //   253	262	921	finally
    //   272	291	921	finally
    //   294	333	921	finally
    //   333	357	921	finally
    //   360	389	921	finally
    //   399	418	921	finally
    //   421	430	921	finally
    //   433	443	921	finally
    //   450	509	921	finally
    //   509	526	921	finally
    //   529	538	921	finally
    //   541	550	921	finally
    //   550	555	921	finally
    //   572	581	921	finally
    //   581	591	921	finally
    //   598	661	921	finally
    //   664	700	921	finally
    //   710	719	921	finally
    //   719	755	921	finally
    //   771	786	921	finally
    //   800	875	921	finally
    //   889	909	921	finally
    //   909	914	921	finally
  }
  
  private void a(AdSlot paramAdSlot) {
    t.e("splashLoadAd", "try LoadSplashAdFromNetwork......");
    d d = a(3, (n)null);
    if (o.h().i(paramAdSlot.getCodeId()) || paramAdSlot.getExpressViewAcceptedWidth() > 0.0F)
      this.b.e = 2; 
    this.d.a(paramAdSlot, this.b, 3, new p.b(this, d) {
          public void a(int param1Int, String param1String) {
            this.a.b(param1Int).g(param1String);
            b b1 = this.b;
            b.a(b1, 15000, new b.a(b1, 2, param1Int, param1String, null, this.a), null, null, null);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1String);
            stringBuilder.append(param1Int);
            t.b("splashLoadAd", stringBuilder.toString());
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            if (param1a != null)
              this.a.f(param1a.a()); 
            if (c.b(param1a)) {
              k k = param1a.c().get(0);
              String str1 = k.P();
              String str2 = k.M();
              if (!TextUtils.isEmpty(str1)) {
                this.a.h(str1).d(str2);
                try {
                  str1 = (new JSONObject(str1)).getString("req_id");
                  this.a.f(str1);
                } finally {}
              } 
              if (k.aa()) {
                b.a(this.b, 0L);
                b b1 = this.b;
                b.a(b1, param1a, b.h(b1), this.a);
                return;
              } 
              this.a.b(-3).g(g.a(-3));
              b.a a2 = new b.a(this.b, 2, -3, g.a(-3), null, this.a);
              b.a(this.b, 15000, a2, null, null, null);
              t.b("SplashAdLoadManager", "网络请求的广告解析失败");
              return;
            } 
            this.a.b(-3).g(g.a(-3));
            b.a a1 = new b.a(this.b, 2, -3, g.a(-3), null, this.a);
            b.a(this.b, 15000, a1, null, null, null);
            t.b("SplashAdLoadManager", "网络请求的广告解析失败");
          }
        });
  }
  
  private void a(a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'splashLoadAd'
    //   5: ldc_w 'onCallback ......'
    //   8: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokespecial f : ()V
    //   15: aload_1
    //   16: ifnonnull -> 38
    //   19: ldc_w 'splashAdListener is null, then return'
    //   22: invokestatic a : (Ljava/lang/String;)V
    //   25: getstatic com/bytedance/sdk/openadsdk/component/splash/b.j : Ljava/util/Set;
    //   28: aload_0
    //   29: invokeinterface remove : (Ljava/lang/Object;)Z
    //   34: pop
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: getfield c : Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;
    //   42: ifnonnull -> 80
    //   45: ldc_w 'splashAdListener is null, then return'
    //   48: invokestatic a : (Ljava/lang/String;)V
    //   51: aload_1
    //   52: getfield a : I
    //   55: iconst_3
    //   56: if_icmpne -> 67
    //   59: aload_0
    //   60: aload_1
    //   61: getfield e : Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   64: invokespecial a : (Lcom/bytedance/sdk/openadsdk/f/a/d;)V
    //   67: getstatic com/bytedance/sdk/openadsdk/component/splash/b.j : Ljava/util/Set;
    //   70: aload_0
    //   71: invokeinterface remove : (Ljava/lang/Object;)Z
    //   76: pop
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   84: invokevirtual get : ()Z
    //   87: ifne -> 251
    //   90: aload_0
    //   91: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   94: iconst_1
    //   95: invokevirtual set : (Z)V
    //   98: aload_1
    //   99: getfield a : I
    //   102: istore_2
    //   103: iload_2
    //   104: iconst_1
    //   105: if_icmpeq -> 187
    //   108: iload_2
    //   109: iconst_2
    //   110: if_icmpeq -> 157
    //   113: iload_2
    //   114: iconst_3
    //   115: if_icmpeq -> 137
    //   118: aload_0
    //   119: getfield c : Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;
    //   122: bipush #-2
    //   124: bipush #-2
    //   126: invokestatic a : (I)Ljava/lang/String;
    //   129: invokeinterface onError : (ILjava/lang/String;)V
    //   134: goto -> 210
    //   137: aload_0
    //   138: aload_1
    //   139: getfield e : Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   142: invokespecial a : (Lcom/bytedance/sdk/openadsdk/f/a/d;)V
    //   145: aload_0
    //   146: getfield c : Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;
    //   149: invokeinterface onTimeout : ()V
    //   154: goto -> 210
    //   157: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/f/a;
    //   160: aload_1
    //   161: getfield e : Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   164: invokevirtual d : (Lcom/bytedance/sdk/openadsdk/f/a/d;)V
    //   167: aload_0
    //   168: getfield c : Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;
    //   171: aload_1
    //   172: getfield b : I
    //   175: aload_1
    //   176: getfield c : Ljava/lang/String;
    //   179: invokeinterface onError : (ILjava/lang/String;)V
    //   184: goto -> 210
    //   187: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/f/a;
    //   190: aload_1
    //   191: getfield e : Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   194: invokevirtual c : (Lcom/bytedance/sdk/openadsdk/f/a/d;)V
    //   197: aload_0
    //   198: getfield c : Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;
    //   201: aload_1
    //   202: getfield d : Lcom/bytedance/sdk/openadsdk/TTSplashAd;
    //   205: invokeinterface onSplashAdLoad : (Lcom/bytedance/sdk/openadsdk/TTSplashAd;)V
    //   210: aload_0
    //   211: getfield f : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   214: ifnull -> 233
    //   217: aload_0
    //   218: getfield f : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   221: iconst_2
    //   222: invokevirtual removeMessages : (I)V
    //   225: aload_0
    //   226: getfield f : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   229: iconst_3
    //   230: invokevirtual removeMessages : (I)V
    //   233: aload_0
    //   234: aconst_null
    //   235: putfield c : Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;
    //   238: getstatic com/bytedance/sdk/openadsdk/component/splash/b.j : Ljava/util/Set;
    //   241: aload_0
    //   242: invokeinterface remove : (Ljava/lang/Object;)Z
    //   247: pop
    //   248: aload_0
    //   249: monitorexit
    //   250: return
    //   251: aload_0
    //   252: aconst_null
    //   253: putfield c : Lcom/bytedance/sdk/openadsdk/TTAdNative$SplashAdListener;
    //   256: aload_1
    //   257: getfield a : I
    //   260: iconst_3
    //   261: if_icmpne -> 272
    //   264: aload_0
    //   265: aload_1
    //   266: getfield e : Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   269: invokespecial a : (Lcom/bytedance/sdk/openadsdk/f/a/d;)V
    //   272: getstatic com/bytedance/sdk/openadsdk/component/splash/b.j : Ljava/util/Set;
    //   275: aload_0
    //   276: invokeinterface remove : (Ljava/lang/Object;)Z
    //   281: pop
    //   282: aload_0
    //   283: monitorexit
    //   284: return
    //   285: astore_1
    //   286: aload_0
    //   287: monitorexit
    //   288: aload_1
    //   289: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	285	finally
    //   19	35	285	finally
    //   38	67	285	finally
    //   67	77	285	finally
    //   80	103	285	finally
    //   118	134	285	finally
    //   137	154	285	finally
    //   157	184	285	finally
    //   187	210	285	finally
    //   210	233	285	finally
    //   233	248	285	finally
    //   251	272	285	finally
    //   272	282	285	finally
  }
  
  private void a(com.bytedance.sdk.openadsdk.core.d.a parama, Context paramContext, d paramd) {
    if (c.b(parama)) {
      boolean bool;
      if (paramContext == null)
        return; 
      List<k> list = parama.c();
      byte b1 = 0;
      k k = list.get(0);
      j j2 = k.D();
      j j1 = j2;
      if (j2 == null)
        j1 = k.F().get(0); 
      String str = j1.a();
      int i = j1.b();
      if (k.z() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.q = System.currentTimeMillis();
      this.r = SystemClock.elapsedRealtime();
      if (bool)
        b1 = 2; 
      c.a(k, b1);
      n.a(paramContext, str, i, new n.a(this, parama, k, bool, paramd, str) {
            public void a() {
              c.a(this.a);
              c.a(this.d, this.e);
              this.d.b(-7).g(g.a(-7));
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("splashLoad----5-LoadImageBytes-onFailed-code=");
              stringBuilder.append(-7);
              stringBuilder.append(",msg=");
              stringBuilder.append(g.a(-7));
              t.b("splashLoadAd", stringBuilder.toString());
              b b1 = this.f;
              b.a(b1, 15000, new b.a(b1, 2, -7, g.a(-7), null, this.d), null, null, null);
              if (this.c)
                c.a(b.k(this.f), false, false, this.b, -7L, null); 
              t.b("SplashAdLoadManager", "图片加载失败");
            }
            
            public void a(byte[] param1ArrayOfbyte) {
              c.a(this.a);
              c.a(this.b);
              if (!this.c)
                d.a(this.b, "splash_ad", "download_creative_duration", System.currentTimeMillis() - b.i(this.f)); 
              if (param1ArrayOfbyte != null) {
                k k1 = this.b;
                boolean bool = false;
                k1.d(false);
                e e = new e(b.h(this.f), this.b, b.g(this.f), "splash_ad");
                b.a(this.f, e);
                e.a(param1ArrayOfbyte);
                AtomicBoolean atomicBoolean = b.j(this.f);
                if (this.b.x() == null)
                  bool = true; 
                atomicBoolean.set(bool);
                b.a a1 = new b.a(this.f, 1, 0, null, e, this.d);
                b.a(this.f, 15000, a1, null, e, null);
                b.b(this.f, null, e, null, this.d);
                if (this.c) {
                  c.a(b.k(this.f), false, true, this.b, 0L, null);
                  return;
                } 
              } else {
                c.a(this.d, this.e);
                this.d.b(-7).g(g.a(-7));
                b.a a1 = new b.a(this.f, 2, -7, g.a(-7), null, this.d);
                b.a(this.f, 15000, a1, null, null, null);
                if (this.c)
                  c.a(b.k(this.f), false, false, this.b, -7L, null); 
                t.b("SplashAdLoadManager", "图片加载失败");
              } 
            }
          });
    } 
  }
  
  private void a(n paramn, e parame, String paramString) {
    t.c("splashLoadAd", "执行 checkAdFromServer 检测缓存....");
    if (c.a(paramn)) {
      k k = paramn.a();
      d d1 = a(4, paramn);
      o.f().a(k.M(), k.P(), new p.a(this, parame, d1, paramn, paramString) {
            public void a(boolean param1Boolean, long param1Long1, long param1Long2) {
              c.a(b.g(this.e), param1Boolean, param1Long1, param1Long2);
              if (param1Boolean && !b.l(this.e).get()) {
                t.b("splashLoadAd", "check 成功回调.......");
                b.e(this.e).set(true);
                b b2 = this.e;
                b.a(b2, 15001, new b.a(b2, 1, 0, null, this.a, this.b), this.c, this.a, this.d);
                return;
              } 
              if (b.f(this.e)) {
                t.b("SplashAdLoadManager", "开屏视频缓存广告不在投放期或本次调用已回调出去");
                b b2 = this.e;
                b.a(b2, b.g(b2));
                return;
              } 
              t.b("splashLoadAd", "并发请求开屏视频check 失败 无需再网络请求");
              d d1 = this.b;
              int i = (int)param1Long1;
              d1.b(i).g(g.a(i));
              b b1 = this.e;
              b.a(b1, 15001, new b.a(b1, 2, 0, null, null, this.b), this.c, null, null);
            }
          });
      return;
    } 
    t.b("splashLoadAd", "checkAdFromServer check fail !!!!");
    if (c()) {
      t.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> tryLoadSplashAdFromNetwork !!!");
      a(this.a);
      return;
    } 
    d d = a(4, (n)null);
    t.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> return callback !!!");
    a(15001, new a(this, 2, 0, null, null, d), paramn, (e)null, (String)null);
  }
  
  private void a(n paramn, e parame, String paramString, d paramd) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_2
    //   10: new com/bytedance/sdk/openadsdk/component/splash/b$5
    //   13: dup
    //   14: aload_0
    //   15: aload_2
    //   16: aload_1
    //   17: aload #4
    //   19: aload_3
    //   20: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/splash/b;Lcom/bytedance/sdk/openadsdk/component/splash/e;Lcom/bytedance/sdk/openadsdk/core/d/n;Lcom/bytedance/sdk/openadsdk/f/a/d;Ljava/lang/String;)V
    //   23: invokevirtual renderExpressAd : (Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd$ExpressAdInteractionListener;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   9	26	29	finally
  }
  
  private void a(d paramd) {
    com.bytedance.sdk.openadsdk.f.a.a().d(paramd);
    com.bytedance.sdk.openadsdk.f.a.a().g(paramd);
  }
  
  private void b(n paramn, e parame, String paramString, d paramd) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_2
    //   10: new com/bytedance/sdk/openadsdk/component/splash/b$6
    //   13: dup
    //   14: aload_0
    //   15: aload_2
    //   16: aload_1
    //   17: aload #4
    //   19: aload_3
    //   20: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/splash/b;Lcom/bytedance/sdk/openadsdk/component/splash/e;Lcom/bytedance/sdk/openadsdk/core/d/n;Lcom/bytedance/sdk/openadsdk/f/a/d;Ljava/lang/String;)V
    //   23: invokevirtual renderExpressAd : (Lcom/bytedance/sdk/openadsdk/TTNativeExpressAd$ExpressAdInteractionListener;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   9	26	29	finally
  }
  
  private boolean b() {
    t.e("splashLoadAd", "try checkSpashAdCacheIsValidAndTryShowAd......");
    d d = a(15001, (n)null);
    if (!this.k.b(this.a.getCodeId()) && !this.k.a(this.a.getCodeId())) {
      t.e("splashLoadAd", "没有缓存数据..........");
      if (this.s.get() || this.t.get())
        a(15001, new a(this, 2, -12, g.a(-12), null, d), (n)null, (e)null, (String)null); 
      return false;
    } 
    if (this.k.a(this.a, true)) {
      c.a(this.e, this.a);
      t.b("splashLoadAd", "======== 缓存过期 ========");
      if (this.s.get() || this.t.get())
        a(15001, new a(this, 2, -11, g.a(-11), null, d), (n)null, (e)null, (String)null); 
      return false;
    } 
    d();
    return true;
  }
  
  private boolean c() {
    int i = o.h().r();
    return (2 != i && 3 != i);
  }
  
  private void d() {
    if (this.k.b(this.a.getCodeId())) {
      this.k.a(this.a.getCodeId(), new a.b(this) {
            public void a() {
              b.b(this.a);
            }
            
            public void a(n param1n) {
              if (param1n.a() != null && param1n.a().z() != null && param1n.a().z().g() != null) {
                boolean bool;
                String str = b.a(this.a).a(param1n.a());
                if (str == null) {
                  b.b(this.a);
                  return;
                } 
                d d = b.a(this.a, 4, param1n);
                e e = b.a(this.a, param1n, str);
                AtomicBoolean atomicBoolean = b.c(this.a);
                if (param1n.a().x() == null) {
                  bool = true;
                } else {
                  bool = false;
                } 
                atomicBoolean.set(bool);
                if (b.d(this.a)) {
                  b.a(this.a, param1n, e, str);
                } else {
                  b.e(this.a).set(true);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("不检测直接返回缓存....splashAd=");
                  stringBuilder.append(e);
                  t.c("splashLoadAd", stringBuilder.toString());
                  b b1 = this.a;
                  b.a(b1, 15001, new b.a(b1, 1, 0, null, e, d), param1n, e, str);
                } 
                if (param1n.a().x() != null) {
                  b.a(this.a, param1n, e, str, d);
                  return;
                } 
              } else {
                b.b(this.a);
              } 
            }
          });
      return;
    } 
    e();
  }
  
  private void e() {
    this.k.b(this.a.getCodeId(), new a.b(this) {
          public void a() {
            t.b("splashLoadAd", "缓存广告对象解析出错");
            if (b.f(this.a)) {
              b b2 = this.a;
              b.a(b2, b.g(b2));
              return;
            } 
            d d = b.a(this.a, 4, (n)null);
            b b1 = this.a;
            b.a(b1, 15001, new b.a(b1, 2, 0, null, null, d), null, null, null);
          }
          
          public void a(n param1n) {
            d d = b.a(this.a, 4, param1n);
            if (c.b(param1n)) {
              param1n.a().c(true);
              k k = param1n.a();
              boolean bool = false;
              k.d(false);
              AtomicBoolean atomicBoolean = b.c(this.a);
              if (param1n.a().x() == null)
                bool = true; 
              atomicBoolean.set(bool);
              e e = b.a(this.a, param1n, (String)null);
              if (b.d(this.a)) {
                b.a(this.a, param1n, e, (String)null);
              } else {
                t.c("splashLoadAd", ".....不检测直接返回缓存....");
                b.e(this.a).set(true);
                b b1 = this.a;
                b.a(b1, 15001, new b.a(b1, 1, 0, null, e, d), param1n, e, null);
              } 
              if (param1n.a().x() != null) {
                b.a(this.a, param1n, e, (String)null, d);
                return;
              } 
            } else {
              b b1;
              if (b.f(this.a)) {
                t.b("SplashAdLoadManager", "缓存广告素材解析出错");
                b1 = this.a;
                b.a(b1, b.g(b1));
                return;
              } 
              b b2 = this.a;
              b.a(b2, 15001, new b.a(b2, 2, 0, null, null, d), (n)b1, null, null);
            } 
          }
        });
  }
  
  private void f() {
    a a1 = this.k;
    if (a1 != null)
      a1.a(this.a, this.b); 
  }
  
  public void a(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield what : I
    //   4: iconst_1
    //   5: if_icmpne -> 63
    //   8: aload_0
    //   9: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   12: invokevirtual get : ()Z
    //   15: ifne -> 42
    //   18: aload_0
    //   19: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   22: iconst_1
    //   23: invokevirtual set : (Z)V
    //   26: aload_0
    //   27: invokespecial a : ()V
    //   30: ldc_w 'SplashAdLoadManager'
    //   33: ldc_w '尝试从缓存中取'
    //   36: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: goto -> 55
    //   42: aload_0
    //   43: invokespecial f : ()V
    //   46: ldc_w 'SplashAdLoadManager'
    //   49: ldc_w '开始预加载'
    //   52: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield f : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   59: aconst_null
    //   60: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   63: aload_1
    //   64: getfield what : I
    //   67: iconst_2
    //   68: if_icmpne -> 131
    //   71: aload_0
    //   72: getfield f : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   75: aconst_null
    //   76: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   79: aload_0
    //   80: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   83: invokevirtual get : ()Z
    //   86: ifeq -> 90
    //   89: return
    //   90: ldc_w 'splashLoadAd'
    //   93: ldc_w 'MSG_USER_TIME_OUT----7-'
    //   96: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: iconst_0
    //   101: aconst_null
    //   102: invokespecial a : (ILcom/bytedance/sdk/openadsdk/core/d/n;)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   105: astore #4
    //   107: new android/os/Handler
    //   110: dup
    //   111: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   114: invokespecial <init> : (Landroid/os/Looper;)V
    //   117: new com/bytedance/sdk/openadsdk/component/splash/b$8
    //   120: dup
    //   121: aload_0
    //   122: aload #4
    //   124: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/splash/b;Lcom/bytedance/sdk/openadsdk/f/a/d;)V
    //   127: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   130: pop
    //   131: aload_1
    //   132: getfield what : I
    //   135: istore_3
    //   136: iconst_3
    //   137: istore_2
    //   138: iload_3
    //   139: iconst_3
    //   140: if_icmpne -> 429
    //   143: aload_0
    //   144: getfield f : Lcom/bytedance/sdk/openadsdk/utils/ak;
    //   147: iconst_3
    //   148: invokevirtual removeMessages : (I)V
    //   151: aload_0
    //   152: getfield g : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   155: invokevirtual get : ()Z
    //   158: ifeq -> 162
    //   161: return
    //   162: aload_0
    //   163: getfield m : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   166: iconst_1
    //   167: invokevirtual set : (Z)V
    //   170: aload_0
    //   171: getfield n : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   174: iconst_1
    //   175: invokevirtual set : (Z)V
    //   178: invokestatic h : ()Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   181: invokevirtual r : ()I
    //   184: istore_3
    //   185: iload_3
    //   186: ifeq -> 378
    //   189: iload_3
    //   190: iconst_1
    //   191: if_icmpeq -> 330
    //   194: iload_3
    //   195: iconst_2
    //   196: if_icmpeq -> 273
    //   199: iload_3
    //   200: iconst_3
    //   201: if_icmpeq -> 207
    //   204: goto -> 371
    //   207: aload_0
    //   208: getfield h : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   211: ifnull -> 243
    //   214: aload_0
    //   215: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   218: invokevirtual get : ()Z
    //   221: ifeq -> 243
    //   224: ldc_w 'splashLoadAd'
    //   227: ldc_w '谁回来用谁//--mCacheTTSplashAd'
    //   230: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: getfield h : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   237: astore_1
    //   238: iconst_4
    //   239: istore_2
    //   240: goto -> 245
    //   243: aconst_null
    //   244: astore_1
    //   245: iload_2
    //   246: istore_3
    //   247: aload_0
    //   248: getfield i : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   251: ifnull -> 385
    //   254: ldc_w 'splashLoadAd'
    //   257: ldc_w '谁回来用谁//--mRealNetWorkTTSplashAd'
    //   260: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield i : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   267: astore_1
    //   268: iload_2
    //   269: istore_3
    //   270: goto -> 385
    //   273: aload_0
    //   274: getfield i : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   277: astore_1
    //   278: aload_1
    //   279: ifnull -> 296
    //   282: ldc_w 'splashLoadAd'
    //   285: ldc_w '超时使用实时--mRealNetWorkTTSplashAd'
    //   288: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   291: iload_2
    //   292: istore_3
    //   293: goto -> 385
    //   296: aload_0
    //   297: getfield h : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   300: ifnull -> 371
    //   303: aload_0
    //   304: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   307: invokevirtual get : ()Z
    //   310: ifeq -> 371
    //   313: ldc_w 'splashLoadAd'
    //   316: ldc_w '超时使用实时//--mCacheTTSplashAd'
    //   319: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_0
    //   323: getfield h : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   326: astore_1
    //   327: goto -> 352
    //   330: aload_0
    //   331: getfield h : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   334: ifnull -> 357
    //   337: aload_0
    //   338: getfield l : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   341: invokevirtual get : ()Z
    //   344: ifeq -> 357
    //   347: aload_0
    //   348: getfield h : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   351: astore_1
    //   352: iconst_4
    //   353: istore_3
    //   354: goto -> 385
    //   357: aload_0
    //   358: getfield i : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   361: astore_1
    //   362: aload_1
    //   363: ifnull -> 371
    //   366: iload_2
    //   367: istore_3
    //   368: goto -> 385
    //   371: aconst_null
    //   372: astore_1
    //   373: iload_2
    //   374: istore_3
    //   375: goto -> 385
    //   378: aload_0
    //   379: getfield i : Lcom/bytedance/sdk/openadsdk/component/splash/e;
    //   382: astore_1
    //   383: iload_2
    //   384: istore_3
    //   385: aload_1
    //   386: ifnull -> 429
    //   389: aload_1
    //   390: invokevirtual a : ()Z
    //   393: ifeq -> 429
    //   396: aload_0
    //   397: iload_3
    //   398: aconst_null
    //   399: invokespecial a : (ILcom/bytedance/sdk/openadsdk/core/d/n;)Lcom/bytedance/sdk/openadsdk/f/a/d;
    //   402: astore #4
    //   404: new android/os/Handler
    //   407: dup
    //   408: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   411: invokespecial <init> : (Landroid/os/Looper;)V
    //   414: new com/bytedance/sdk/openadsdk/component/splash/b$9
    //   417: dup
    //   418: aload_0
    //   419: aload_1
    //   420: aload #4
    //   422: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/splash/b;Lcom/bytedance/sdk/openadsdk/component/splash/e;Lcom/bytedance/sdk/openadsdk/f/a/d;)V
    //   425: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   428: pop
    //   429: return
  }
  
  public void a(AdSlot paramAdSlot, TTAdNative.SplashAdListener paramSplashAdListener, int paramInt) {
    this.a = paramAdSlot;
    this.c = paramSplashAdListener;
    this.g.set(false);
    this.h = null;
    this.i = null;
    long l1 = paramInt;
    int i = o.h().c(paramAdSlot.getCodeId());
    if (i == -1)
      i = paramInt; 
    paramInt = i;
    if (i <= 0)
      paramInt = 3000; 
    this.f.sendEmptyMessageDelayed(2, paramInt);
    i = paramInt - 300;
    if (i > 0)
      paramInt = i; 
    this.f.sendEmptyMessageDelayed(3, paramInt);
    this.b = new l();
    this.b.f = System.currentTimeMillis();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("publisher_timeout_control", l1);
    } finally {}
    com.bytedance.sdk.openadsdk.f.a.a().b(d.b().a(3).c(this.a.getCodeId()).f(this.b.a).b(jSONObject.toString()));
    a();
  }
  
  class a {
    public int a;
    
    public int b;
    
    public String c;
    
    public TTSplashAd d;
    
    public d e;
    
    public a(b this$0, int param1Int1, int param1Int2, String param1String, TTSplashAd param1TTSplashAd, d param1d) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1String;
      this.d = param1TTSplashAd;
      this.e = param1d;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\splash\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */