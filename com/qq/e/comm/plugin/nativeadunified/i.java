package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.util.a;
import com.qq.e.comm.plugin.util.m;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class i implements NUADI {
  private String a;
  
  private String b;
  
  private String c;
  
  private l d;
  
  private int e = BrowserType.Default.value();
  
  private ADListener f;
  
  private List<String> g;
  
  private int h = -1;
  
  private c i = new c();
  
  private Handler j = new Handler(Looper.getMainLooper());
  
  private volatile int k;
  
  private volatile int l;
  
  private int m = 0;
  
  private int n = 0;
  
  public i(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    this(paramContext, paramString1, paramString2, l.a, paramADListener);
  }
  
  public i(Context paramContext, String paramString1, String paramString2, l paraml, ADListener paramADListener) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = a.a(paramString1, paramString2, o.b());
    this.d = paraml;
    this.f = paramADListener;
    this.i.a(paramString2);
  }
  
  private b a(int paramInt, LoadAdParams paramLoadAdParams) {
    b b = new b();
    b.a(this.b);
    b.c(1);
    b.d(paramInt);
    b.a(this.d);
    b.e(2);
    b.h(e.l.b());
    b.a(this.g);
    b.k(this.k);
    b.l(this.l);
    b.o(this.m);
    b.p(this.n);
    return b;
  }
  
  private void a(int paramInt) {
    this.j.post(new Runnable(this, paramInt) {
          public void run() {
            if (i.b(this.b) != null)
              i.b(this.b).onADEvent(new ADEvent(2, new Object[] { Integer.valueOf(this.a) })); 
          }
        });
  }
  
  private void a(List<NativeUnifiedADData> paramList) {
    this.j.post(new Runnable(this, paramList) {
          public void run() {
            if (i.b(this.b) != null)
              i.b(this.b).onADEvent(new ADEvent(1, new Object[] { this.a })); 
          }
        });
  }
  
  private void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: ldc 'gdt_tag_net'
    //   2: ldc 'LoadGDTNativeUnifiedADResponse: '
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: invokestatic a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_1
    //   16: ldc 'ret'
    //   18: invokevirtual optInt : (Ljava/lang/String;)I
    //   21: istore_2
    //   22: iload_2
    //   23: ifeq -> 41
    //   26: aload_0
    //   27: iload_2
    //   28: invokespecial a : (I)V
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield i : Lcom/qq/e/comm/plugin/y/c;
    //   36: iload_2
    //   37: invokestatic a : (ZLcom/qq/e/comm/plugin/y/c;I)V
    //   40: return
    //   41: aload_1
    //   42: ldc 'data'
    //   44: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull -> 284
    //   52: aload_1
    //   53: aload_0
    //   54: getfield b : Ljava/lang/String;
    //   57: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   60: astore_1
    //   61: aload_1
    //   62: ifnonnull -> 68
    //   65: goto -> 284
    //   68: aload_1
    //   69: ldc 'ret'
    //   71: invokevirtual optInt : (Ljava/lang/String;)I
    //   74: istore_2
    //   75: iload_2
    //   76: ifeq -> 94
    //   79: aload_0
    //   80: iload_2
    //   81: invokespecial a : (I)V
    //   84: iconst_0
    //   85: aload_0
    //   86: getfield i : Lcom/qq/e/comm/plugin/y/c;
    //   89: iload_2
    //   90: invokestatic a : (ZLcom/qq/e/comm/plugin/y/c;I)V
    //   93: return
    //   94: aload_1
    //   95: ldc 'list'
    //   97: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   100: astore #4
    //   102: aload #4
    //   104: ifnull -> 265
    //   107: aload #4
    //   109: invokevirtual length : ()I
    //   112: ifgt -> 118
    //   115: goto -> 265
    //   118: new java/util/ArrayList
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore_1
    //   126: aload #4
    //   128: new com/qq/e/comm/plugin/ad/m
    //   131: dup
    //   132: aload_0
    //   133: getfield b : Ljava/lang/String;
    //   136: getstatic com/qq/e/comm/plugin/ad/e.l : Lcom/qq/e/comm/plugin/ad/e;
    //   139: aconst_null
    //   140: invokespecial <init> : (Ljava/lang/String;Lcom/qq/e/comm/plugin/ad/e;Lcom/qq/e/comm/plugin/ad/d;)V
    //   143: aload_0
    //   144: getfield c : Ljava/lang/String;
    //   147: invokestatic a : (Lorg/json/JSONArray;Lcom/qq/e/comm/plugin/ad/m;Ljava/lang/String;)Ljava/util/List;
    //   150: invokeinterface iterator : ()Ljava/util/Iterator;
    //   155: astore #4
    //   157: iconst_0
    //   158: istore_2
    //   159: aload #4
    //   161: invokeinterface hasNext : ()Z
    //   166: ifeq -> 220
    //   169: new com/qq/e/comm/plugin/nativeadunified/g
    //   172: dup
    //   173: aload #4
    //   175: invokeinterface next : ()Ljava/lang/Object;
    //   180: checkcast org/json/JSONObject
    //   183: aload_0
    //   184: invokespecial <init> : (Lorg/json/JSONObject;Lcom/qq/e/comm/plugin/nativeadunified/i;)V
    //   187: astore #5
    //   189: iload_2
    //   190: istore_3
    //   191: iload_2
    //   192: ifne -> 206
    //   195: aload_0
    //   196: aload #5
    //   198: invokevirtual r : ()I
    //   201: putfield h : I
    //   204: iconst_1
    //   205: istore_3
    //   206: aload_1
    //   207: aload #5
    //   209: invokeinterface add : (Ljava/lang/Object;)Z
    //   214: pop
    //   215: iload_3
    //   216: istore_2
    //   217: goto -> 159
    //   220: aload_1
    //   221: invokeinterface size : ()I
    //   226: istore_2
    //   227: iload_2
    //   228: ifgt -> 250
    //   231: iconst_0
    //   232: aload_0
    //   233: getfield i : Lcom/qq/e/comm/plugin/y/c;
    //   236: sipush #5014
    //   239: invokestatic a : (ZLcom/qq/e/comm/plugin/y/c;I)V
    //   242: aload_0
    //   243: sipush #501
    //   246: invokespecial a : (I)V
    //   249: return
    //   250: iconst_1
    //   251: aload_0
    //   252: getfield i : Lcom/qq/e/comm/plugin/y/c;
    //   255: iload_2
    //   256: invokestatic a : (ZLcom/qq/e/comm/plugin/y/c;I)V
    //   259: aload_0
    //   260: aload_1
    //   261: invokespecial a : (Ljava/util/List;)V
    //   264: return
    //   265: aload_0
    //   266: sipush #501
    //   269: invokespecial a : (I)V
    //   272: aload_0
    //   273: getfield i : Lcom/qq/e/comm/plugin/y/c;
    //   276: astore_1
    //   277: sipush #5025
    //   280: istore_2
    //   281: goto -> 300
    //   284: aload_0
    //   285: sipush #501
    //   288: invokespecial a : (I)V
    //   291: aload_0
    //   292: getfield i : Lcom/qq/e/comm/plugin/y/c;
    //   295: astore_1
    //   296: sipush #5004
    //   299: istore_2
    //   300: iconst_0
    //   301: aload_1
    //   302: iload_2
    //   303: invokestatic a : (ZLcom/qq/e/comm/plugin/y/c;I)V
    //   306: return
  }
  
  public int a() {
    return this.e;
  }
  
  public String b() {
    return this.a;
  }
  
  public String c() {
    return this.b;
  }
  
  public String d() {
    return this.c;
  }
  
  public int e() {
    return this.h;
  }
  
  public String getAdNetWorkName() {
    return null;
  }
  
  public void loadData(int paramInt) {
    loadData(paramInt, null);
  }
  
  public void loadData(int paramInt, LoadAdParams paramLoadAdParams) {
    l.a(this.i);
    if (Build.VERSION.SDK_INT < 16) {
      a(4007);
      l.a(4007, this.i);
      return;
    } 
    int j = paramInt;
    if (paramInt < 1) {
      GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为1", null);
      j = 1;
    } 
    paramInt = j;
    if (j > 10) {
      GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为10", null);
      paramInt = 10;
    } 
    long l1 = SystemClock.elapsedRealtime();
    b b = new b(this.c, e.l, this.b);
    e.a(a(paramInt, paramLoadAdParams), b, new e.a(this, l1) {
          public void a(a param1a) {
            GDTLogger.w("load NativeAd failed");
            l.a(param1a, i.a(this.b));
            int j = param1a.a();
            i.a(this.b, j);
          }
          
          public void a(JSONObject param1JSONObject) {
            l.a(i.a(this.b), this.a);
            i.a(this.b, param1JSONObject);
          }
        });
  }
  
  public void setBrowserType(int paramInt) {
    this.e = paramInt;
  }
  
  public void setCategories(List<String> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.g = new ArrayList<String>();
      for (String str : paramList) {
        if (!TextUtils.isEmpty(str))
          this.g.add(str); 
      } 
    } 
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    GDTADManager.getInstance().getSM().setDEVCodeSetting("download_confirm", Integer.valueOf(paramDownAPPConfirmPolicy.value()), this.b);
  }
  
  public void setMaxVideoDuration(int paramInt) {
    if (m.a(paramInt))
      this.l = paramInt; 
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.k = paramInt;
  }
  
  public void setVastClassName(String paramString) {}
  
  public void setVideoADContainerRender(int paramInt) {
    this.n = paramInt;
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.m = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */