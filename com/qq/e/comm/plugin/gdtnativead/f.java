package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.ad.n;
import com.qq.e.comm.plugin.ad.o;
import com.qq.e.comm.plugin.ad.p;
import com.qq.e.comm.plugin.k.a;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.s.i;
import com.qq.e.comm.plugin.util.a;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.m;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f implements NEADI, a {
  public final e a;
  
  protected final String b;
  
  protected final String c;
  
  public final ADListener d;
  
  public int e;
  
  public c f = new c();
  
  private final Context g;
  
  private final String h;
  
  private final ADSize i;
  
  private l j;
  
  private VideoOption k;
  
  private volatile int l;
  
  private volatile int m;
  
  private int n;
  
  private int o = -1;
  
  private boolean p;
  
  private int q = -1;
  
  private int r = 0;
  
  public f(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, ADListener paramADListener) {
    this(paramContext, paramADSize, paramString1, paramString2, l.a, paramADListener);
  }
  
  public f(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, l paraml, ADListener paramADListener) {
    this(paramContext, paramADSize, paramString1, paramString2, paraml, paramADListener, e.i);
  }
  
  public f(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, l paraml, ADListener paramADListener, e parame) {
    this.a = parame;
    this.g = paramContext;
    this.h = paramString1;
    this.b = paramString2;
    this.i = paramADSize;
    this.d = paramADListener;
    this.j = paraml;
    this.c = a.a(paramString1, paramString2, o.b());
    this.f.a(paramString2);
  }
  
  public b a(int paramInt) {
    return a(paramInt, (LoadAdParams)null);
  }
  
  protected b a(int paramInt, LoadAdParams paramLoadAdParams) {
    b b = new b();
    b.a(this.b);
    b.c(1);
    b.d(paramInt);
    b.e(2);
    b.h(this.a.b());
    b.a(this.i.getWidth());
    b.b(this.i.getHeight());
    b.k(this.m);
    b.l(this.l);
    b.o(this.n);
    b.a(this.j);
    b.p(1);
    return b;
  }
  
  protected List<NativeExpressADView> a(JSONObject paramJSONObject, JSONArray paramJSONArray) {
    boolean bool;
    JSONArray jSONArray = paramJSONObject.optJSONArray("template");
    if (jSONArray == null) {
      bool = false;
    } else {
      bool = true;
    } 
    if (bool && paramJSONArray.length() != jSONArray.length())
      bool = false; 
    ArrayList<NativeExpressADView> arrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = this.e;
    if (j <= i)
      i = paramJSONArray.length(); 
    for (j = 0; j < i; j++) {
      JSONObject jSONObject = paramJSONArray.optJSONObject(j);
      paramJSONObject = null;
      if (bool)
        paramJSONObject = jSONArray.optJSONObject(j); 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      if (SDKStatus.getSDKVersionCode() >= 3) {
        try {
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("adinfo", c(jSONObject));
          hashMap.put("adinfo", jSONObject1);
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
      } else {
        hashMap.put("adinfo", jSONException);
      } 
      arrayList.add(new NativeExpressADView(this, this.g, this.i, this.h, this.b, paramJSONObject, hashMap));
    } 
    return arrayList;
  }
  
  protected void a(List<NativeExpressADView> paramList) {
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramList) {
          public void run() {
            this.b.d.onADEvent(new ADEvent(2, new Object[] { this.a }));
          }
        });
  }
  
  protected void a(JSONObject paramJSONObject) {
    List<NativeExpressADView> list;
    int i;
    c c1;
    ak.a("gdt_tag_net", "LoadGDTNativeExpressADResponse: ", new Object[] { paramJSONObject });
    Pair<Object, Object> pair = b(paramJSONObject);
    if (pair == null || pair.first == null || pair.second == null) {
      i = 6000;
      c(6000);
      e e1 = this.a;
      c1 = this.f;
    } else if (pair.first instanceof Integer) {
      c(((Integer)pair.first).intValue());
      e e1 = this.a;
      c1 = this.f;
      i = ((Integer)pair.second).intValue();
    } else {
      list = a((JSONObject)pair.first, (JSONArray)pair.second);
      if (list != null) {
        i = list.size();
        if (i > 0) {
          c.a(this.a, true, this.f, i);
          a(list);
          return;
        } 
      } 
      c(501);
      c.a(this.a, false, this.f, 5011);
      return;
    } 
    c.a((e)list, false, c1, i);
  }
  
  protected Pair<Object, Object> b(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 'ret'
    //   4: invokevirtual optInt : (Ljava/lang/String;)I
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq -> 28
    //   12: new android/util/Pair
    //   15: dup
    //   16: iload_2
    //   17: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   20: iload_2
    //   21: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   24: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   27: areturn
    //   28: aload_1
    //   29: ldc_w 'data'
    //   32: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnonnull -> 60
    //   40: new android/util/Pair
    //   43: dup
    //   44: sipush #501
    //   47: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   50: sipush #5004
    //   53: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   56: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   59: areturn
    //   60: aload_1
    //   61: aload_0
    //   62: getfield b : Ljava/lang/String;
    //   65: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   68: astore #4
    //   70: aload #4
    //   72: ifnonnull -> 95
    //   75: new android/util/Pair
    //   78: dup
    //   79: sipush #501
    //   82: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   85: sipush #5004
    //   88: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   91: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   94: areturn
    //   95: aload #4
    //   97: ldc_w 'ret'
    //   100: invokevirtual optInt : (Ljava/lang/String;)I
    //   103: istore_2
    //   104: iload_2
    //   105: ifeq -> 124
    //   108: new android/util/Pair
    //   111: dup
    //   112: iload_2
    //   113: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   116: iload_2
    //   117: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   120: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   123: areturn
    //   124: aload #4
    //   126: ldc_w 'list'
    //   129: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   132: astore_3
    //   133: aload_3
    //   134: ifnull -> 398
    //   137: aload_3
    //   138: invokevirtual length : ()I
    //   141: ifgt -> 147
    //   144: goto -> 398
    //   147: aload_3
    //   148: invokevirtual length : ()I
    //   151: newarray boolean
    //   153: astore #5
    //   155: aload_0
    //   156: getfield a : Lcom/qq/e/comm/plugin/ad/e;
    //   159: getstatic com/qq/e/comm/plugin/ad/e.m : Lcom/qq/e/comm/plugin/ad/e;
    //   162: if_acmpeq -> 187
    //   165: aload_0
    //   166: getfield a : Lcom/qq/e/comm/plugin/ad/e;
    //   169: getstatic com/qq/e/comm/plugin/ad/e.n : Lcom/qq/e/comm/plugin/ad/e;
    //   172: if_acmpeq -> 187
    //   175: aload_3
    //   176: astore_1
    //   177: aload_0
    //   178: getfield a : Lcom/qq/e/comm/plugin/ad/e;
    //   181: getstatic com/qq/e/comm/plugin/ad/e.i : Lcom/qq/e/comm/plugin/ad/e;
    //   184: if_acmpne -> 267
    //   187: aload_3
    //   188: astore_1
    //   189: invokestatic a : ()Z
    //   192: ifeq -> 267
    //   195: aload_3
    //   196: new com/qq/e/comm/plugin/ad/m
    //   199: dup
    //   200: aload_0
    //   201: getfield b : Ljava/lang/String;
    //   204: aload_0
    //   205: getfield a : Lcom/qq/e/comm/plugin/ad/e;
    //   208: aconst_null
    //   209: invokespecial <init> : (Ljava/lang/String;Lcom/qq/e/comm/plugin/ad/e;Lcom/qq/e/comm/plugin/ad/d;)V
    //   212: aload_0
    //   213: getfield c : Ljava/lang/String;
    //   216: aload #5
    //   218: invokestatic a : (Lorg/json/JSONArray;Lcom/qq/e/comm/plugin/ad/m;Ljava/lang/String;[Z)Ljava/util/List;
    //   221: astore_3
    //   222: new org/json/JSONArray
    //   225: dup
    //   226: invokespecial <init> : ()V
    //   229: astore_1
    //   230: aload_3
    //   231: ifnull -> 267
    //   234: aload_3
    //   235: invokeinterface iterator : ()Ljava/util/Iterator;
    //   240: astore_3
    //   241: aload_3
    //   242: invokeinterface hasNext : ()Z
    //   247: ifeq -> 267
    //   250: aload_1
    //   251: aload_3
    //   252: invokeinterface next : ()Ljava/lang/Object;
    //   257: checkcast org/json/JSONObject
    //   260: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   263: pop
    //   264: goto -> 241
    //   267: aload_1
    //   268: invokevirtual length : ()I
    //   271: ifgt -> 294
    //   274: new android/util/Pair
    //   277: dup
    //   278: sipush #501
    //   281: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   284: sipush #5014
    //   287: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   290: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   293: areturn
    //   294: aload #5
    //   296: arraylength
    //   297: aload_1
    //   298: invokevirtual length : ()I
    //   301: if_icmple -> 387
    //   304: new org/json/JSONArray
    //   307: dup
    //   308: invokespecial <init> : ()V
    //   311: astore_3
    //   312: aload #4
    //   314: ldc 'template'
    //   316: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   319: astore #6
    //   321: aload #6
    //   323: ifnull -> 387
    //   326: aload #6
    //   328: invokevirtual length : ()I
    //   331: ifle -> 387
    //   334: iconst_0
    //   335: istore_2
    //   336: iload_2
    //   337: aload #6
    //   339: invokevirtual length : ()I
    //   342: if_icmpge -> 370
    //   345: aload #5
    //   347: iload_2
    //   348: baload
    //   349: ifne -> 363
    //   352: aload_3
    //   353: aload #6
    //   355: iload_2
    //   356: invokevirtual opt : (I)Ljava/lang/Object;
    //   359: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   362: pop
    //   363: iload_2
    //   364: iconst_1
    //   365: iadd
    //   366: istore_2
    //   367: goto -> 336
    //   370: aload #4
    //   372: ldc 'template'
    //   374: aload_3
    //   375: invokevirtual putOpt : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   378: pop
    //   379: goto -> 387
    //   382: astore_3
    //   383: aload_3
    //   384: invokevirtual printStackTrace : ()V
    //   387: new android/util/Pair
    //   390: dup
    //   391: aload #4
    //   393: aload_1
    //   394: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   397: areturn
    //   398: new android/util/Pair
    //   401: dup
    //   402: sipush #501
    //   405: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   408: sipush #5025
    //   411: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   414: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   417: areturn
    // Exception table:
    //   from	to	target	type
    //   370	379	382	org/json/JSONException
  }
  
  public AdData c(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    o o = new o();
    o.a("ad_id", paramJSONObject.optString("cl"));
    o.a("ad_desc", paramJSONObject.optString("desc"));
    o.a("ad_title", paramJSONObject.optString("txt"));
    o.a("ad_ecpm", a.d(paramJSONObject));
    o.a("ad_ecpm_level", paramJSONObject.optString("ecpm_level"));
    o.a("negative_feedback_url", paramJSONObject.optString("negative_feedback_url"));
    if (!m.a(paramJSONObject.optString("video")))
      o.a("ad_pattern_type", 2); 
    o.a("ad_video_duration", paramJSONObject.optInt("video_duration") * 1000);
    o.a("ad_info", paramJSONObject.toString());
    this.q = i.b(paramJSONObject);
    o.a("ad_rt_priority", this.q);
    this.p = a.f(paramJSONObject);
    o.a("ad_contract_ad", this.p);
    this.o = a.e(paramJSONObject);
    o.a("ad_mp", this.o);
    return (AdData)new n((p)o);
  }
  
  public void c(int paramInt) {
    y.a(new Runnable(this, paramInt) {
          public void run() {
            this.b.d.onADEvent(new ADEvent(1, new Object[] { Integer.valueOf(this.a) }));
          }
        });
  }
  
  protected e d() {
    return e.i;
  }
  
  public void e() {
    ADListener aDListener = this.d;
    if (aDListener != null)
      aDListener.onADEvent(new ADEvent(21)); 
  }
  
  public int f() {
    return this.q;
  }
  
  public String g() {
    return this.c;
  }
  
  public int getMediationPrice() {
    return this.o;
  }
  
  ADListener h() {
    return this.d;
  }
  
  public boolean isContractAd() {
    return this.p;
  }
  
  public void loadAd(int paramInt) {
    loadAd(paramInt, null);
  }
  
  public void loadAd(int paramInt, LoadAdParams paramLoadAdParams) {
    int i = paramInt;
    if (paramInt < 1) {
      GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为1", null);
      i = 1;
    } 
    paramInt = i;
    if (i > 10) {
      GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为10", null);
      paramInt = 10;
    } 
    c.d(this.a, this.f);
    this.e = paramInt;
    b b = new b(this.c, this.a, this.b);
    e.a(a(paramInt, paramLoadAdParams), b, new e.a(this) {
          public void a(a param1a) {
            ak.a("LoadGDTNativeExpressADFail", (Exception)param1a);
            c.a(this.a.a, param1a, this.a.f);
            this.a.c(param1a.a());
          }
          
          public void a(JSONObject param1JSONObject) {
            c.e(this.a.a, this.a.f);
            this.a.a(param1JSONObject);
          }
        });
  }
  
  public void setBrowserType(int paramInt) {
    this.r = paramInt;
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    b.a(this.b, paramDownAPPConfirmPolicy);
  }
  
  public void setMaxVideoDuration(int paramInt) {
    if (m.a(paramInt))
      this.l = paramInt; 
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.m = paramInt;
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    this.k = paramVideoOption;
    if (paramVideoOption != null)
      b.a(this.b, paramVideoOption); 
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.n = paramInt;
    u.a(60582, paramInt, this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */