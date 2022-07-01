package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.a.a;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.d.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class f implements c {
  private static f c;
  
  Handler a = new Handler(this, Looper.getMainLooper()) {
      public void handleMessage(Message param1Message) {
        boolean bool;
        if (param1Message.what != 10000)
          return; 
        if (param1Message.arg1 == 0) {
          bool = false;
        } else {
          bool = true;
        } 
        f.a(this.a, bool);
      }
    };
  
  private long b = 0L;
  
  private boolean d = false;
  
  private Context e;
  
  private e f;
  
  private int g = 0;
  
  private long h = 0L;
  
  private int i = 0;
  
  private HashMap<String, Integer> j = new HashMap<String, Integer>();
  
  private HashMap<String, Integer> k = new HashMap<String, Integer>();
  
  private int l = 0;
  
  private HashMap<String, Integer> m = new HashMap<String, Integer>();
  
  private HashMap<String, Integer> n = new HashMap<String, Integer>();
  
  private boolean o = true;
  
  private Map<String, Integer> p = new HashMap<String, Integer>();
  
  public static f a() {
    // Byte code:
    //   0: ldc com/bytedance/sdk/adnet/c/f
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/adnet/c/f.c : Lcom/bytedance/sdk/adnet/c/f;
    //   6: ifnonnull -> 19
    //   9: new com/bytedance/sdk/adnet/c/f
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/bytedance/sdk/adnet/c/f.c : Lcom/bytedance/sdk/adnet/c/f;
    //   19: getstatic com/bytedance/sdk/adnet/c/f.c : Lcom/bytedance/sdk/adnet/c/f;
    //   22: astore_0
    //   23: ldc com/bytedance/sdk/adnet/c/f
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/bytedance/sdk/adnet/c/f
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  private String a(Exception paramException) {
    StringWriter stringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString().toLowerCase();
  }
  
  private void a(n paramn, String paramString) {
    StringBuilder stringBuilder2;
    boolean bool;
    long l1;
    if (paramn == null)
      return; 
    if (!this.o)
      return; 
    String str = paramn.a("tt-idc-switch", null);
    if (TextUtils.isEmpty(str)) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("handleTncProbe, no probeProto, ");
      stringBuilder2.append(paramString);
      d.b("TNCManager", stringBuilder2.toString());
      return;
    } 
    String[] arrayOfString = stringBuilder2.split("@");
    if (arrayOfString == null || arrayOfString.length != 2) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("handleTncProbe, probeProto err, ");
      stringBuilder1.append(paramString);
      d.b("TNCManager", stringBuilder1.toString());
      return;
    } 
    long l2 = 0L;
    try {
    
    } finally {
      stringBuilder1 = null;
      bool = false;
      stringBuilder1.printStackTrace();
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("handleTncProbe, probeProto except, ");
      stringBuilder1.append(paramString);
      d.b("TNCManager", stringBuilder1.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("handleTncProbe, local: ");
    stringBuilder1.append(this.g);
    stringBuilder1.append("@");
    stringBuilder1.append(this.h);
    stringBuilder1.append(" svr: ");
    stringBuilder1.append(bool);
    stringBuilder1.append("@");
    stringBuilder1.append(l1);
    stringBuilder1.append(" ");
    stringBuilder1.append(paramString);
    d.b("TNCManager", stringBuilder1.toString());
    if (l1 <= this.h)
      return; 
    this.g = bool;
    this.h = l1;
    this.e.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", bool).putLong("tnc_probe_version", l1).apply();
    if (this.g == 10000) {
      d d = c();
      if (d == null)
        return; 
      Random random = new Random(System.currentTimeMillis());
      l1 = l2;
      if (d.l > 0)
        l1 = random.nextInt(d.l) * 1000L; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("handleTncProbe, updateConfig delay: ");
      stringBuilder.append(l1);
      stringBuilder.append(" ");
      stringBuilder.append(paramString);
      d.b("TNCManager", stringBuilder.toString());
      a(true, l1);
    } 
  }
  
  private void a(boolean paramBoolean) {
    d d = c();
    if (d == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("doUpdateRemote, ");
    stringBuilder.append(paramBoolean);
    d.b("TNCManager", stringBuilder.toString());
    long l = SystemClock.elapsedRealtime();
    if (!paramBoolean && this.b + d.k * 1000L > l) {
      d.b("TNCManager", "doUpdateRemote, time limit");
      return;
    } 
    this.b = l;
    a.a(this.e).b(com.bytedance.sdk.adnet.d.f.a(this.e));
  }
  
  private void a(boolean paramBoolean, long paramLong) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean a(int paramInt) {
    return (paramInt >= 200 && paramInt < 400);
  }
  
  private void b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    Map<String, String> map = d();
    if (map != null) {
      if (!map.containsValue(paramString))
        return; 
      if (this.p.get(paramString) == null) {
        this.p.put(paramString, Integer.valueOf(1));
        return;
      } 
      int i = ((Integer)this.p.get(paramString)).intValue();
      this.p.put(paramString, Integer.valueOf(i + 1));
    } 
  }
  
  private boolean b(int paramInt) {
    if (paramInt >= 100) {
      if (paramInt >= 1000)
        return true; 
      d d = c();
      if (d != null && !TextUtils.isEmpty(d.m)) {
        String str = d.m;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(paramInt);
        if (str.contains(stringBuilder.toString()))
          return true; 
      } 
      return false;
    } 
    return true;
  }
  
  private void c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    if (!this.p.containsKey(paramString))
      return; 
    this.p.put(paramString, Integer.valueOf(0));
  }
  
  private boolean d(String paramString) {
    Map<String, String> map = d();
    if (map == null)
      return false; 
    String str = map.get(paramString);
    if (!TextUtils.isEmpty(str)) {
      if (this.p.get(str) == null)
        return false; 
      if (((Integer)this.p.get(str)).intValue() >= 3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handleHostMapping, TNC host faild num over limit: ");
        stringBuilder.append(paramString);
        d.b("TNCManager", stringBuilder.toString());
        return true;
      } 
    } 
    return false;
  }
  
  private void f() {
    SharedPreferences sharedPreferences = this.e.getSharedPreferences("ttnet_tnc_config", 0);
    this.g = sharedPreferences.getInt("tnc_probe_cmd", 0);
    this.h = sharedPreferences.getLong("tnc_probe_version", 0L);
  }
  
  private void g() {
    d.b("TNCManager", "resetTNCControlState");
    this.i = 0;
    this.j.clear();
    this.k.clear();
    this.l = 0;
    this.m.clear();
    this.n.clear();
  }
  
  public String a(String paramString) {
    StringBuilder stringBuilder;
    if (!TextUtils.isEmpty(paramString) && !paramString.contains("/network/get_network") && !paramString.contains("/get_domains/v4")) {
      String str1;
      String str2;
      if (paramString.contains("/ies/speed"))
        return paramString; 
      String str3 = null;
      try {
      
      } finally {
        Exception exception = null;
        str1 = null;
        exception.printStackTrace();
        str2 = str1;
      } 
      if (!TextUtils.isEmpty(str2) && ("http".equals(str2) || "https".equals(str2))) {
        StringBuilder stringBuilder2;
        if (TextUtils.isEmpty(str1))
          return paramString; 
        if (d(str1)) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("handleHostMapping, TNC host faild num over limit: ");
          stringBuilder2.append(str1);
          d.b("TNCManager", stringBuilder2.toString());
          return paramString;
        } 
        Map<String, String> map = d();
        if (map == null || !map.containsKey(str1)) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("handleHostMapping, nomatch: ");
          stringBuilder2.append(str1);
          d.b("TNCManager", stringBuilder2.toString());
          return paramString;
        } 
        String str6 = map.get(str1);
        if (TextUtils.isEmpty(str6))
          return paramString; 
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("handleHostMapping, match, origin: ");
        stringBuilder3.append(paramString);
        d.b("TNCManager", stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append((String)stringBuilder2);
        stringBuilder3.append("://");
        stringBuilder3.append(str1);
        String str7 = stringBuilder3.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append((String)stringBuilder2);
        stringBuilder1.append("://");
        stringBuilder1.append(str6);
        String str5 = stringBuilder1.toString();
        String str4 = paramString;
        if (paramString.startsWith(str7))
          str4 = paramString.replaceFirst(str7, str5); 
        stringBuilder = new StringBuilder();
        stringBuilder.append("handleHostMapping, target: ");
        stringBuilder.append(str4);
        d.b("TNCManager", stringBuilder.toString());
        return str4;
      } 
    } 
    return (String)stringBuilder;
  }
  
  public void a(Context paramContext, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: ifne -> 110
    //   9: aload_0
    //   10: aload_1
    //   11: putfield e : Landroid/content/Context;
    //   14: aload_0
    //   15: iload_2
    //   16: putfield o : Z
    //   19: aload_0
    //   20: new com/bytedance/sdk/adnet/c/e
    //   23: dup
    //   24: aload_1
    //   25: iload_2
    //   26: invokespecial <init> : (Landroid/content/Context;Z)V
    //   29: putfield f : Lcom/bytedance/sdk/adnet/c/e;
    //   32: iload_2
    //   33: ifeq -> 40
    //   36: aload_0
    //   37: invokespecial f : ()V
    //   40: new java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: astore_1
    //   48: aload_1
    //   49: ldc_w 'initTnc, isMainProc: '
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_1
    //   57: iload_2
    //   58: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: ldc_w ' probeCmd: '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: aload_0
    //   72: getfield g : I
    //   75: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_1
    //   80: ldc_w ' probeVersion: '
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_1
    //   88: aload_0
    //   89: getfield h : J
    //   92: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 'TNCManager'
    //   98: aload_1
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield d : Z
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	113	finally
    //   36	40	113	finally
    //   40	110	113	finally
  }
  
  public void a(Request paramRequest, n paramn) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 681
    //   6: aload_2
    //   7: ifnonnull -> 13
    //   10: goto -> 681
    //   13: aload_0
    //   14: getfield o : Z
    //   17: istore #4
    //   19: iload #4
    //   21: ifne -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield e : Landroid/content/Context;
    //   31: invokestatic a : (Landroid/content/Context;)Z
    //   34: istore #4
    //   36: iload #4
    //   38: ifne -> 44
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aconst_null
    //   45: astore #5
    //   47: new java/net/URL
    //   50: dup
    //   51: aload_1
    //   52: invokevirtual getUrl : ()Ljava/lang/String;
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: astore #6
    //   60: aload #6
    //   62: astore #5
    //   64: goto -> 67
    //   67: aload #5
    //   69: ifnonnull -> 75
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: aload #5
    //   77: invokevirtual getProtocol : ()Ljava/lang/String;
    //   80: astore #6
    //   82: aload #5
    //   84: invokevirtual getHost : ()Ljava/lang/String;
    //   87: astore #7
    //   89: aload #5
    //   91: invokevirtual getPath : ()Ljava/lang/String;
    //   94: astore #5
    //   96: aload_1
    //   97: invokevirtual getIpAddrStr : ()Ljava/lang/String;
    //   100: astore_1
    //   101: aload_2
    //   102: getfield h : J
    //   105: l2i
    //   106: istore_3
    //   107: ldc_w 'http'
    //   110: aload #6
    //   112: invokevirtual equals : (Ljava/lang/Object;)Z
    //   115: ifne -> 136
    //   118: ldc_w 'https'
    //   121: aload #6
    //   123: invokevirtual equals : (Ljava/lang/Object;)Z
    //   126: istore #4
    //   128: iload #4
    //   130: ifne -> 136
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: aload_1
    //   137: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   140: istore #4
    //   142: iload #4
    //   144: ifeq -> 150
    //   147: aload_0
    //   148: monitorexit
    //   149: return
    //   150: new java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial <init> : ()V
    //   157: astore #8
    //   159: aload #8
    //   161: ldc_w 'onResponse, url: '
    //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload #8
    //   170: aload #6
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload #8
    //   178: ldc_w '://'
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #8
    //   187: aload #7
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload #8
    //   195: ldc_w '#'
    //   198: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload #8
    //   204: aload_1
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #8
    //   211: ldc_w '#'
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload #8
    //   220: iload_3
    //   221: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 'TNCManager'
    //   227: aload #8
    //   229: invokevirtual toString : ()Ljava/lang/String;
    //   232: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload_0
    //   236: invokevirtual c : ()Lcom/bytedance/sdk/adnet/c/d;
    //   239: astore #8
    //   241: aload #8
    //   243: ifnull -> 261
    //   246: aload #8
    //   248: getfield b : Z
    //   251: ifeq -> 261
    //   254: aload_0
    //   255: aload_2
    //   256: aload #7
    //   258: invokespecial a : (Lcom/bytedance/sdk/adnet/core/n;Ljava/lang/String;)V
    //   261: aload #8
    //   263: ifnonnull -> 269
    //   266: aload_0
    //   267: monitorexit
    //   268: return
    //   269: new java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial <init> : ()V
    //   276: astore_2
    //   277: aload_2
    //   278: ldc_w 'onResponse, url matched: '
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_2
    //   286: aload #6
    //   288: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_2
    //   293: ldc_w '://'
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_2
    //   301: aload #7
    //   303: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_2
    //   308: ldc_w '#'
    //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: aload_1
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_2
    //   322: ldc_w '#'
    //   325: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_2
    //   330: iload_3
    //   331: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_2
    //   336: ldc ' '
    //   338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_2
    //   343: aload_0
    //   344: getfield i : I
    //   347: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_2
    //   352: ldc_w '#'
    //   355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_2
    //   360: aload_0
    //   361: getfield j : Ljava/util/HashMap;
    //   364: invokevirtual size : ()I
    //   367: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload_2
    //   372: ldc_w '#'
    //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_2
    //   380: aload_0
    //   381: getfield k : Ljava/util/HashMap;
    //   384: invokevirtual size : ()I
    //   387: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_2
    //   392: ldc ' '
    //   394: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_2
    //   399: aload_0
    //   400: getfield l : I
    //   403: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_2
    //   408: ldc_w '#'
    //   411: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload_2
    //   416: aload_0
    //   417: getfield m : Ljava/util/HashMap;
    //   420: invokevirtual size : ()I
    //   423: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_2
    //   428: ldc_w '#'
    //   431: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload_2
    //   436: aload_0
    //   437: getfield n : Ljava/util/HashMap;
    //   440: invokevirtual size : ()I
    //   443: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: ldc 'TNCManager'
    //   449: aload_2
    //   450: invokevirtual toString : ()Ljava/lang/String;
    //   453: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   456: iload_3
    //   457: ifle -> 673
    //   460: aload_0
    //   461: iload_3
    //   462: invokespecial a : (I)Z
    //   465: ifeq -> 495
    //   468: aload_0
    //   469: getfield i : I
    //   472: ifgt -> 482
    //   475: aload_0
    //   476: getfield l : I
    //   479: ifle -> 486
    //   482: aload_0
    //   483: invokespecial g : ()V
    //   486: aload_0
    //   487: aload #7
    //   489: invokespecial c : (Ljava/lang/String;)V
    //   492: goto -> 673
    //   495: aload_0
    //   496: iload_3
    //   497: invokespecial b : (I)Z
    //   500: ifne -> 673
    //   503: aload_0
    //   504: aload_0
    //   505: getfield l : I
    //   508: iconst_1
    //   509: iadd
    //   510: putfield l : I
    //   513: aload_0
    //   514: getfield m : Ljava/util/HashMap;
    //   517: aload #5
    //   519: iconst_0
    //   520: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   523: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   526: pop
    //   527: aload_0
    //   528: getfield n : Ljava/util/HashMap;
    //   531: aload_1
    //   532: iconst_0
    //   533: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   536: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   539: pop
    //   540: aload_0
    //   541: getfield l : I
    //   544: aload #8
    //   546: getfield h : I
    //   549: if_icmplt -> 667
    //   552: aload_0
    //   553: getfield m : Ljava/util/HashMap;
    //   556: invokevirtual size : ()I
    //   559: aload #8
    //   561: getfield i : I
    //   564: if_icmplt -> 667
    //   567: aload_0
    //   568: getfield n : Ljava/util/HashMap;
    //   571: invokevirtual size : ()I
    //   574: aload #8
    //   576: getfield j : I
    //   579: if_icmplt -> 667
    //   582: new java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial <init> : ()V
    //   589: astore_2
    //   590: aload_2
    //   591: ldc_w 'onResponse, url doUpdate: '
    //   594: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_2
    //   599: aload #6
    //   601: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_2
    //   606: ldc_w '://'
    //   609: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_2
    //   614: aload #7
    //   616: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload_2
    //   621: ldc_w '#'
    //   624: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload_2
    //   629: aload_1
    //   630: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload_2
    //   635: ldc_w '#'
    //   638: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload_2
    //   643: iload_3
    //   644: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: ldc 'TNCManager'
    //   650: aload_2
    //   651: invokevirtual toString : ()Ljava/lang/String;
    //   654: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   657: aload_0
    //   658: iconst_0
    //   659: lconst_0
    //   660: invokespecial a : (ZJ)V
    //   663: aload_0
    //   664: invokespecial g : ()V
    //   667: aload_0
    //   668: aload #7
    //   670: invokespecial b : (Ljava/lang/String;)V
    //   673: aload_0
    //   674: monitorexit
    //   675: return
    //   676: astore_1
    //   677: aload_0
    //   678: monitorexit
    //   679: aload_1
    //   680: athrow
    //   681: aload_0
    //   682: monitorexit
    //   683: return
    //   684: astore #6
    //   686: goto -> 67
    // Exception table:
    //   from	to	target	type
    //   13	19	676	finally
    //   27	36	676	finally
    //   47	60	684	java/lang/Exception
    //   47	60	676	finally
    //   75	128	676	finally
    //   136	142	676	finally
    //   150	241	676	finally
    //   246	261	676	finally
    //   269	456	676	finally
    //   460	482	676	finally
    //   482	486	676	finally
    //   486	492	676	finally
    //   495	667	676	finally
    //   667	673	676	finally
  }
  
  public void a(Request paramRequest, Exception paramException) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 517
    //   6: aload_2
    //   7: ifnonnull -> 13
    //   10: goto -> 517
    //   13: aload_0
    //   14: getfield o : Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifne -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield e : Landroid/content/Context;
    //   29: invokestatic a : (Landroid/content/Context;)Z
    //   32: istore_3
    //   33: iload_3
    //   34: ifne -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aconst_null
    //   41: astore #4
    //   43: new java/net/URL
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual getUrl : ()Ljava/lang/String;
    //   51: invokespecial <init> : (Ljava/lang/String;)V
    //   54: astore #5
    //   56: aload #5
    //   58: astore #4
    //   60: goto -> 63
    //   63: aload #4
    //   65: ifnonnull -> 71
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: aload #4
    //   73: invokevirtual getProtocol : ()Ljava/lang/String;
    //   76: astore #5
    //   78: aload #4
    //   80: invokevirtual getHost : ()Ljava/lang/String;
    //   83: astore #6
    //   85: aload #4
    //   87: invokevirtual getPath : ()Ljava/lang/String;
    //   90: astore #4
    //   92: aload_1
    //   93: invokevirtual getIpAddrStr : ()Ljava/lang/String;
    //   96: astore_1
    //   97: aload_0
    //   98: aload_2
    //   99: invokespecial a : (Ljava/lang/Exception;)Ljava/lang/String;
    //   102: astore_2
    //   103: ldc_w 'http'
    //   106: aload #5
    //   108: invokevirtual equals : (Ljava/lang/Object;)Z
    //   111: ifne -> 130
    //   114: ldc_w 'https'
    //   117: aload #5
    //   119: invokevirtual equals : (Ljava/lang/Object;)Z
    //   122: istore_3
    //   123: iload_3
    //   124: ifne -> 130
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_0
    //   131: invokevirtual c : ()Lcom/bytedance/sdk/adnet/c/d;
    //   134: astore #7
    //   136: aload #7
    //   138: ifnonnull -> 144
    //   141: aload_0
    //   142: monitorexit
    //   143: return
    //   144: new java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial <init> : ()V
    //   151: astore #8
    //   153: aload #8
    //   155: ldc_w 'onError, url matched: '
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload #8
    //   164: aload #5
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload #8
    //   172: ldc_w '://'
    //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload #8
    //   181: aload #6
    //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload #8
    //   189: ldc_w '#'
    //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload #8
    //   198: aload_1
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload #8
    //   205: ldc_w '#'
    //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload #8
    //   214: aload_2
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload #8
    //   221: ldc ' '
    //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload #8
    //   229: aload_0
    //   230: getfield i : I
    //   233: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload #8
    //   239: ldc_w '#'
    //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload #8
    //   248: aload_0
    //   249: getfield j : Ljava/util/HashMap;
    //   252: invokevirtual size : ()I
    //   255: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload #8
    //   261: ldc_w '#'
    //   264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload #8
    //   270: aload_0
    //   271: getfield k : Ljava/util/HashMap;
    //   274: invokevirtual size : ()I
    //   277: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload #8
    //   283: ldc ' '
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload #8
    //   291: aload_0
    //   292: getfield l : I
    //   295: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload #8
    //   301: ldc_w '#'
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload #8
    //   310: aload_0
    //   311: getfield m : Ljava/util/HashMap;
    //   314: invokevirtual size : ()I
    //   317: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload #8
    //   323: ldc_w '#'
    //   326: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload #8
    //   332: aload_0
    //   333: getfield n : Ljava/util/HashMap;
    //   336: invokevirtual size : ()I
    //   339: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: ldc 'TNCManager'
    //   345: aload #8
    //   347: invokevirtual toString : ()Ljava/lang/String;
    //   350: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   353: aload_0
    //   354: aload_0
    //   355: getfield i : I
    //   358: iconst_1
    //   359: iadd
    //   360: putfield i : I
    //   363: aload_0
    //   364: getfield j : Ljava/util/HashMap;
    //   367: aload #4
    //   369: iconst_0
    //   370: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   373: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   376: pop
    //   377: aload_0
    //   378: getfield k : Ljava/util/HashMap;
    //   381: aload_1
    //   382: iconst_0
    //   383: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   386: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   389: pop
    //   390: aload_0
    //   391: getfield i : I
    //   394: aload #7
    //   396: getfield e : I
    //   399: if_icmplt -> 503
    //   402: aload_0
    //   403: getfield j : Ljava/util/HashMap;
    //   406: invokevirtual size : ()I
    //   409: aload #7
    //   411: getfield f : I
    //   414: if_icmplt -> 503
    //   417: aload_0
    //   418: getfield k : Ljava/util/HashMap;
    //   421: invokevirtual size : ()I
    //   424: aload #7
    //   426: getfield g : I
    //   429: if_icmplt -> 503
    //   432: new java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial <init> : ()V
    //   439: astore_2
    //   440: aload_2
    //   441: ldc_w 'onError, url doUpate: '
    //   444: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_2
    //   449: aload #5
    //   451: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload_2
    //   456: ldc_w '://'
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_2
    //   464: aload #6
    //   466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_2
    //   471: ldc_w '#'
    //   474: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload_2
    //   479: aload_1
    //   480: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: ldc 'TNCManager'
    //   486: aload_2
    //   487: invokevirtual toString : ()Ljava/lang/String;
    //   490: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_0
    //   494: iconst_0
    //   495: lconst_0
    //   496: invokespecial a : (ZJ)V
    //   499: aload_0
    //   500: invokespecial g : ()V
    //   503: aload_0
    //   504: aload #6
    //   506: invokespecial b : (Ljava/lang/String;)V
    //   509: aload_0
    //   510: monitorexit
    //   511: return
    //   512: astore_1
    //   513: aload_0
    //   514: monitorexit
    //   515: aload_1
    //   516: athrow
    //   517: aload_0
    //   518: monitorexit
    //   519: return
    //   520: astore #5
    //   522: goto -> 63
    // Exception table:
    //   from	to	target	type
    //   13	18	512	finally
    //   25	33	512	finally
    //   43	56	520	java/lang/Exception
    //   43	56	512	finally
    //   71	123	512	finally
    //   130	136	512	finally
    //   144	503	512	finally
    //   503	509	512	finally
  }
  
  public void b() {
    this.p.clear();
  }
  
  public d c() {
    e e1 = this.f;
    return (e1 != null) ? e1.c() : null;
  }
  
  public Map<String, String> d() {
    d d = c();
    return (d != null) ? d.d : null;
  }
  
  public e e() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */