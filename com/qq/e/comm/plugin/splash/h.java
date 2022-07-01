package com.qq.e.comm.plugin.splash;

import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.s.f;
import com.qq.e.comm.plugin.splash.a.b;
import com.qq.e.comm.plugin.u.b;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.w.b;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONObject;

class h {
  private final String a;
  
  private final String b;
  
  private final m c;
  
  private final String d;
  
  private final a e;
  
  private final f f;
  
  private final l g;
  
  private final c h;
  
  private volatile List<f> i = null;
  
  private LoadAdParams j;
  
  private volatile boolean k = false;
  
  private boolean l = false;
  
  private boolean m = false;
  
  public h(String paramString1, String paramString2, m paramm, String paramString3, l paraml, a parama, c paramc) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramm;
    this.d = paramString3;
    this.g = paraml;
    this.e = parama;
    this.f = new f(paramString1, paramString2, paramString3, e.d);
    this.h = paramc;
  }
  
  private void a(int paramInt1, int paramInt2) {
    if (this.m)
      return; 
    this.e.a(paramInt1);
    k.a(paramInt2, this.h, (com.qq.e.comm.plugin.k.a)null);
  }
  
  private void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield l : Z
    //   5: aload_1
    //   6: ldc 'ret'
    //   8: invokevirtual optInt : (Ljava/lang/String;)I
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq -> 23
    //   16: aload_0
    //   17: iload_2
    //   18: iload_2
    //   19: invokespecial a : (II)V
    //   22: return
    //   23: aload_1
    //   24: ldc 'data'
    //   26: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnonnull -> 45
    //   34: aload_0
    //   35: sipush #501
    //   38: sipush #5004
    //   41: invokespecial a : (II)V
    //   44: return
    //   45: aload_1
    //   46: aload_0
    //   47: getfield b : Ljava/lang/String;
    //   50: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnonnull -> 61
    //   58: goto -> 34
    //   61: aload_3
    //   62: ldc 'ret'
    //   64: invokevirtual optInt : (Ljava/lang/String;)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifeq -> 79
    //   72: aload_0
    //   73: iload_2
    //   74: iload_2
    //   75: invokespecial a : (II)V
    //   78: return
    //   79: aload_3
    //   80: ldc 'list'
    //   82: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   85: astore_1
    //   86: aload_3
    //   87: ldc 'cfg'
    //   89: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnonnull -> 100
    //   97: goto -> 107
    //   100: aload_3
    //   101: ldc 'playcfg'
    //   103: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload_1
    //   108: ifnull -> 387
    //   111: aload_1
    //   112: invokevirtual length : ()I
    //   115: ifgt -> 121
    //   118: goto -> 387
    //   121: aload_1
    //   122: aload_0
    //   123: getfield c : Lcom/qq/e/comm/plugin/ad/m;
    //   126: aload_0
    //   127: getfield d : Ljava/lang/String;
    //   130: invokestatic a : (Lorg/json/JSONArray;Lcom/qq/e/comm/plugin/ad/m;Ljava/lang/String;)Ljava/util/List;
    //   133: astore_1
    //   134: aload_1
    //   135: invokeinterface size : ()I
    //   140: ifle -> 165
    //   143: aload_1
    //   144: iconst_0
    //   145: invokeinterface get : (I)Ljava/lang/Object;
    //   150: checkcast org/json/JSONObject
    //   153: astore_1
    //   154: aload_0
    //   155: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   158: aload_1
    //   159: invokevirtual g : (Lorg/json/JSONObject;)V
    //   162: goto -> 167
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_1
    //   168: ifnonnull -> 178
    //   171: sipush #5014
    //   174: istore_2
    //   175: goto -> 391
    //   178: aload_0
    //   179: getfield h : Lcom/qq/e/comm/plugin/y/c;
    //   182: aload_0
    //   183: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   186: invokevirtual m : ()Ljava/lang/String;
    //   189: invokevirtual b : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   192: aload_0
    //   193: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   196: invokevirtual H : ()Ljava/lang/String;
    //   199: invokevirtual c : (Ljava/lang/String;)Lcom/qq/e/comm/plugin/y/c;
    //   202: pop
    //   203: aload_0
    //   204: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   207: invokevirtual e : ()Z
    //   210: ifeq -> 220
    //   213: aload_0
    //   214: getfield b : Ljava/lang/String;
    //   217: invokestatic a : (Ljava/lang/String;)V
    //   220: aload_0
    //   221: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   224: invokevirtual d : ()Z
    //   227: ifeq -> 273
    //   230: aload_0
    //   231: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   234: invokevirtual e : ()Z
    //   237: ifeq -> 273
    //   240: aload_0
    //   241: getfield e : Lcom/qq/e/comm/plugin/splash/h$a;
    //   244: sipush #501
    //   247: invokeinterface a : (I)V
    //   252: ldc 1010025
    //   254: iconst_0
    //   255: aload_0
    //   256: getfield h : Lcom/qq/e/comm/plugin/y/c;
    //   259: invokestatic a : (IILcom/qq/e/comm/plugin/y/c;)V
    //   262: aload_0
    //   263: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   266: invokevirtual q : ()Ljava/lang/String;
    //   269: invokestatic a : (Ljava/lang/String;)V
    //   272: return
    //   273: aload_0
    //   274: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   277: invokevirtual f : ()Ljava/lang/String;
    //   280: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   283: ifne -> 354
    //   286: aload_0
    //   287: getfield i : Ljava/util/List;
    //   290: ifnull -> 354
    //   293: aload_0
    //   294: getfield i : Ljava/util/List;
    //   297: invokeinterface size : ()I
    //   302: ifle -> 354
    //   305: aload_0
    //   306: getfield i : Ljava/util/List;
    //   309: invokeinterface iterator : ()Ljava/util/Iterator;
    //   314: astore_3
    //   315: aload_3
    //   316: invokeinterface hasNext : ()Z
    //   321: ifeq -> 354
    //   324: aload_3
    //   325: invokeinterface next : ()Ljava/lang/Object;
    //   330: checkcast com/qq/e/comm/plugin/s/f
    //   333: astore_1
    //   334: aload_0
    //   335: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   338: invokevirtual f : ()Ljava/lang/String;
    //   341: aload_1
    //   342: invokevirtual f : ()Ljava/lang/String;
    //   345: invokevirtual equals : (Ljava/lang/Object;)Z
    //   348: ifeq -> 315
    //   351: goto -> 356
    //   354: aconst_null
    //   355: astore_1
    //   356: aload_0
    //   357: getfield m : Z
    //   360: ifne -> 399
    //   363: aload_0
    //   364: getfield e : Lcom/qq/e/comm/plugin/splash/h$a;
    //   367: aload_0
    //   368: getfield f : Lcom/qq/e/comm/plugin/s/f;
    //   371: aload_1
    //   372: invokeinterface a : (Lcom/qq/e/comm/plugin/s/f;Lcom/qq/e/comm/plugin/s/f;)V
    //   377: iconst_0
    //   378: aload_0
    //   379: getfield h : Lcom/qq/e/comm/plugin/y/c;
    //   382: aconst_null
    //   383: invokestatic a : (ILcom/qq/e/comm/plugin/y/c;Lcom/qq/e/comm/plugin/k/a;)V
    //   386: return
    //   387: sipush #5025
    //   390: istore_2
    //   391: aload_0
    //   392: sipush #501
    //   395: iload_2
    //   396: invokespecial a : (II)V
    //   399: return
  }
  
  private boolean e() {
    if (this.i != null && this.i.size() > 0)
      for (f f1 : this.i) {
        if (b.a(f1)) {
          GDTLogger.d("本地成功获取第一刷订单号码信息");
          this.k = true;
          this.e.a(f1, f1);
          return true;
        } 
      }  
    return false;
  }
  
  private b f() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a() {
    this.l = false;
    t.a.submit(new Runnable(this) {
          public void run() {
            try {
              h.a(this.a, b.a().b(h.a(this.a), h.b(this.a), h.c(this.a), e.d));
              if (!b.c() && h.d(this.a))
                return; 
              h.a(this.a, false);
              b b = new b(h.c(this.a), e.d, h.b(this.a));
              long l = System.currentTimeMillis();
              e.a(h.e(this.a), b, new e.a(this, l) {
                    public void a(com.qq.e.comm.plugin.k.a param2a) {
                      if (h.g(this.b.a)) {
                        GDTLogger.d("LoadGDTSplashADFail but timeout");
                        return;
                      } 
                      ak.a("LoadGDTSplashADFail", (Exception)param2a);
                      int i = param2a.a();
                      if (i == 5001) {
                        k.a(i, h.f(this.b.a), param2a);
                      } else {
                        k.a(i, h.f(this.b.a), (Exception)param2a);
                      } 
                      h.h(this.b.a).a(i);
                    }
                    
                    public void a(JSONObject param2JSONObject) {
                      long l1 = System.currentTimeMillis();
                      long l2 = this.a;
                      g g = (new g(2010001)).b(l1 - l2);
                      g.a(h.f(this.b.a));
                      u.a(g);
                      if (h.g(this.b.a)) {
                        GDTLogger.d("SplashOnADLoadSuccess but timeout");
                        return;
                      } 
                      GDTLogger.d("SplashOnADLoadSuccess");
                      ak.a("gdt_tag_net", "LoadGDTSplashADResponse: ", new Object[] { param2JSONObject });
                      k.a(0, h.f(this.b.a), (Exception)null);
                      h.a(this.b.a, param2JSONObject);
                    }
                  });
              return;
            } catch (Exception exception) {
              GDTLogger.d("Error: Exception occurred when fetching ad");
              h.h(this.a).a(6000);
              k.a(6000, h.f(this.a), exception);
              return;
            } 
          }
        });
  }
  
  public void a(LoadAdParams paramLoadAdParams) {
    this.j = paramLoadAdParams;
  }
  
  public boolean b() {
    return this.k;
  }
  
  public boolean c() {
    return this.l;
  }
  
  public void d() {
    this.m = true;
  }
  
  public static interface a {
    void a(int param1Int);
    
    void a(f param1f1, f param1f2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\splash\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */