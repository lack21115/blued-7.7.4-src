package com.huawei.hms.framework.network.grs.c;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public class e {
  private static final String a = "e";
  
  private Map<String, List<String>> b;
  
  private byte[] c;
  
  private int d = 0;
  
  private long e;
  
  private long f;
  
  private long g;
  
  private String h;
  
  private int i = 2;
  
  private int j = 9001;
  
  private String k = "";
  
  private String l = "";
  
  private String m = "";
  
  private long n = 0L;
  
  private Exception o;
  
  private String p;
  
  private int q;
  
  public e(int paramInt, Map<String, List<String>> paramMap, byte[] paramArrayOfbyte, long paramLong) {
    this.d = paramInt;
    this.b = paramMap;
    this.c = ByteBuffer.wrap(paramArrayOfbyte).array();
    this.e = paramLong;
    q();
  }
  
  public e(Exception paramException, long paramLong) {
    this.o = paramException;
    this.e = paramLong;
  }
  
  private void a(Map<String, String> paramMap) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 335
    //   4: aload_1
    //   5: invokeinterface size : ()I
    //   10: ifgt -> 16
    //   13: goto -> 335
    //   16: aload_1
    //   17: ldc 'Cache-Control'
    //   19: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   24: ifeq -> 115
    //   27: aload_1
    //   28: ldc 'Cache-Control'
    //   30: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast java/lang/String
    //   38: astore_1
    //   39: aload_1
    //   40: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   43: ifne -> 272
    //   46: aload_1
    //   47: ldc 'max-age='
    //   49: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   52: ifeq -> 272
    //   55: aload_1
    //   56: aload_1
    //   57: ldc 'max-age='
    //   59: invokevirtual indexOf : (Ljava/lang/String;)I
    //   62: bipush #8
    //   64: iadd
    //   65: invokevirtual substring : (I)Ljava/lang/String;
    //   68: invokestatic parseLong : (Ljava/lang/String;)J
    //   71: lstore_2
    //   72: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   75: astore_1
    //   76: aload_1
    //   77: ldc 'Cache-Control value{%s}'
    //   79: iconst_1
    //   80: anewarray java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: lload_2
    //   86: invokestatic valueOf : (J)Ljava/lang/Long;
    //   89: aastore
    //   90: invokestatic v : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: goto -> 274
    //   96: astore_1
    //   97: goto -> 103
    //   100: astore_1
    //   101: lconst_0
    //   102: lstore_2
    //   103: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   106: ldc 'getExpireTime addHeadersToResult NumberFormatException'
    //   108: aload_1
    //   109: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: goto -> 274
    //   115: aload_1
    //   116: ldc 'Expires'
    //   118: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   123: ifeq -> 264
    //   126: aload_1
    //   127: ldc 'Expires'
    //   129: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast java/lang/String
    //   137: astore #8
    //   139: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   142: ldc 'expires is{%s}'
    //   144: iconst_1
    //   145: anewarray java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload #8
    //   152: aastore
    //   153: invokestatic v : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: new java/text/SimpleDateFormat
    //   159: dup
    //   160: ldc 'EEE, d MMM yyyy HH:mm:ss 'GMT''
    //   162: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   165: invokespecial <init> : (Ljava/lang/String;Ljava/util/Locale;)V
    //   168: astore #7
    //   170: aconst_null
    //   171: astore #6
    //   173: aload_1
    //   174: ldc 'Date'
    //   176: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   181: ifeq -> 197
    //   184: aload_1
    //   185: ldc 'Date'
    //   187: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   192: checkcast java/lang/String
    //   195: astore #6
    //   197: aload #7
    //   199: aload #8
    //   201: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   204: astore #8
    //   206: aload #6
    //   208: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   211: ifeq -> 225
    //   214: new java/util/Date
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: astore_1
    //   222: goto -> 233
    //   225: aload #7
    //   227: aload #6
    //   229: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   232: astore_1
    //   233: aload #8
    //   235: invokevirtual getTime : ()J
    //   238: aload_1
    //   239: invokevirtual getTime : ()J
    //   242: lsub
    //   243: ldc2_w 1000
    //   246: ldiv
    //   247: lstore_2
    //   248: goto -> 274
    //   251: astore_1
    //   252: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   255: ldc 'getExpireTime ParseException.'
    //   257: aload_1
    //   258: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: goto -> 272
    //   264: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   267: ldc 'response headers neither contains Cache-Control nor Expires.'
    //   269: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   272: lconst_0
    //   273: lstore_2
    //   274: lload_2
    //   275: lconst_0
    //   276: lcmp
    //   277: ifle -> 291
    //   280: lload_2
    //   281: lstore #4
    //   283: lload_2
    //   284: ldc2_w 2592000
    //   287: lcmp
    //   288: ifle -> 296
    //   291: ldc2_w 86400
    //   294: lstore #4
    //   296: lload #4
    //   298: ldc2_w 1000
    //   301: lmul
    //   302: lstore_2
    //   303: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   306: ldc 'convert expireTime{%s}'
    //   308: iconst_1
    //   309: anewarray java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: lload_2
    //   315: invokestatic valueOf : (J)Ljava/lang/Long;
    //   318: aastore
    //   319: invokestatic v : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload_0
    //   323: lload_2
    //   324: invokestatic currentTimeMillis : ()J
    //   327: ladd
    //   328: invokestatic valueOf : (J)Ljava/lang/String;
    //   331: invokespecial b : (Ljava/lang/String;)V
    //   334: return
    //   335: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   338: ldc 'getExpireTime {headers == null} or {headers.size() <= 0}'
    //   340: invokestatic w : (Ljava/lang/String;Ljava/lang/Object;)V
    //   343: return
    // Exception table:
    //   from	to	target	type
    //   55	72	100	java/lang/NumberFormatException
    //   72	76	96	java/lang/NumberFormatException
    //   76	93	96	java/lang/NumberFormatException
    //   197	222	251	java/text/ParseException
    //   225	233	251	java/text/ParseException
    //   233	248	251	java/text/ParseException
  }
  
  private void b(int paramInt) {
    this.j = paramInt;
  }
  
  private void b(String paramString) {
    this.m = paramString;
  }
  
  private void b(Map<String, String> paramMap) {
    if (paramMap == null || paramMap.size() <= 0) {
      Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
      return;
    } 
    long l2 = 0L;
    long l1 = l2;
    if (paramMap.containsKey("Retry-After")) {
      String str = paramMap.get("Retry-After");
      l1 = l2;
      if (!TextUtils.isEmpty(str))
        try {
          l1 = Long.parseLong(str);
        } catch (NumberFormatException numberFormatException) {
          Logger.w(a, "getRetryAfter addHeadersToResult NumberFormatException", numberFormatException);
          l1 = l2;
        }  
    } 
    l1 *= 1000L;
    Logger.v(a, "convert retry-afterTime{%s}", new Object[] { Long.valueOf(l1) });
    c(l1);
  }
  
  private void c(int paramInt) {
    this.i = paramInt;
  }
  
  private void c(long paramLong) {
    this.n = paramLong;
  }
  
  private void c(String paramString) {
    this.k = paramString;
  }
  
  private void d(String paramString) {
    this.l = paramString;
  }
  
  private void e(String paramString) {
    this.h = paramString;
  }
  
  private void n() {
    // Byte code:
    //   0: ldc 'isSuccess'
    //   2: astore #4
    //   4: aload_0
    //   5: invokevirtual m : ()Z
    //   8: ifne -> 25
    //   11: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   14: ldc 'GRSSDK parse server body all failed.'
    //   16: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   19: aload_0
    //   20: iconst_2
    //   21: invokespecial c : (I)V
    //   24: return
    //   25: aload_0
    //   26: getfield c : [B
    //   29: invokestatic byte2Str : ([B)Ljava/lang/String;
    //   32: astore #6
    //   34: new org/json/JSONObject
    //   37: dup
    //   38: aload #6
    //   40: invokespecial <init> : (Ljava/lang/String;)V
    //   43: astore #5
    //   45: iconst_m1
    //   46: istore_1
    //   47: aload #5
    //   49: ldc 'isSuccess'
    //   51: invokevirtual has : (Ljava/lang/String;)Z
    //   54: istore_3
    //   55: iload_3
    //   56: ifeq -> 62
    //   59: goto -> 76
    //   62: aload #5
    //   64: ldc 'resultCode'
    //   66: invokevirtual has : (Ljava/lang/String;)Z
    //   69: ifeq -> 87
    //   72: ldc 'resultCode'
    //   74: astore #4
    //   76: aload #5
    //   78: aload #4
    //   80: invokevirtual getInt : (Ljava/lang/String;)I
    //   83: istore_1
    //   84: goto -> 99
    //   87: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   90: astore #4
    //   92: aload #4
    //   94: ldc 'sth. wrong because server errorcode's key.'
    //   96: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   99: aload_0
    //   100: iload_1
    //   101: invokespecial c : (I)V
    //   104: iload_1
    //   105: ifne -> 125
    //   108: aload #6
    //   110: ldc 'services'
    //   112: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   115: istore_3
    //   116: iload_3
    //   117: ifeq -> 125
    //   120: iconst_1
    //   121: istore_2
    //   122: goto -> 127
    //   125: iconst_0
    //   126: istore_2
    //   127: ldc ''
    //   129: astore #4
    //   131: iload_1
    //   132: iconst_1
    //   133: if_icmpeq -> 202
    //   136: iload_2
    //   137: ifeq -> 143
    //   140: goto -> 202
    //   143: aload_0
    //   144: iconst_2
    //   145: invokespecial c : (I)V
    //   148: aload #5
    //   150: ldc 'errorCode'
    //   152: invokevirtual has : (Ljava/lang/String;)Z
    //   155: ifeq -> 267
    //   158: aload #5
    //   160: ldc 'errorCode'
    //   162: invokevirtual getInt : (Ljava/lang/String;)I
    //   165: istore_1
    //   166: goto -> 169
    //   169: aload_0
    //   170: iload_1
    //   171: invokespecial b : (I)V
    //   174: aload #5
    //   176: ldc_w 'errorDesc'
    //   179: invokevirtual has : (Ljava/lang/String;)Z
    //   182: ifeq -> 195
    //   185: aload #5
    //   187: ldc_w 'errorDesc'
    //   190: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   193: astore #4
    //   195: aload_0
    //   196: aload #4
    //   198: invokespecial c : (Ljava/lang/String;)V
    //   201: return
    //   202: aload_0
    //   203: aload #5
    //   205: ldc 'services'
    //   207: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   210: invokevirtual toString : ()Ljava/lang/String;
    //   213: invokespecial e : (Ljava/lang/String;)V
    //   216: iload_2
    //   217: ifeq -> 266
    //   220: aload #5
    //   222: ldc_w 'errorList'
    //   225: invokevirtual has : (Ljava/lang/String;)Z
    //   228: ifeq -> 241
    //   231: aload #5
    //   233: ldc_w 'errorList'
    //   236: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   239: astore #4
    //   241: aload_0
    //   242: aload #4
    //   244: invokespecial d : (Ljava/lang/String;)V
    //   247: return
    //   248: astore #4
    //   250: getstatic com/huawei/hms/framework/network/grs/c/e.a : Ljava/lang/String;
    //   253: ldc_w 'GrsResponse GrsResponse(String result) JSONException'
    //   256: aload #4
    //   258: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: aload_0
    //   262: iconst_2
    //   263: invokespecial c : (I)V
    //   266: return
    //   267: sipush #9001
    //   270: istore_1
    //   271: goto -> 169
    // Exception table:
    //   from	to	target	type
    //   25	45	248	org/json/JSONException
    //   47	55	248	org/json/JSONException
    //   62	72	248	org/json/JSONException
    //   76	84	248	org/json/JSONException
    //   87	92	248	org/json/JSONException
    //   92	99	248	org/json/JSONException
    //   99	104	248	org/json/JSONException
    //   108	116	248	org/json/JSONException
    //   143	166	248	org/json/JSONException
    //   169	174	248	org/json/JSONException
    //   174	195	248	org/json/JSONException
    //   195	201	248	org/json/JSONException
    //   202	216	248	org/json/JSONException
    //   220	241	248	org/json/JSONException
    //   241	247	248	org/json/JSONException
  }
  
  private void o() {
    if (!m() && !l())
      return; 
    Map<String, String> map = p();
    try {
      if (m())
        a(map); 
      if (l()) {
        b(map);
        return;
      } 
    } catch (JSONException jSONException) {
      Logger.w(a, "parseHeader catch JSONException", (Throwable)jSONException);
    } 
  }
  
  private Map<String, String> p() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(16);
    Map<String, List<String>> map = this.b;
    if (map == null || map.size() <= 0) {
      Logger.v(a, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
      return (Map)hashMap;
    } 
    for (Map.Entry<String, List<String>> entry : this.b.entrySet())
      hashMap.put(entry.getKey(), ((List)entry.getValue()).get(0)); 
    return (Map)hashMap;
  }
  
  private void q() {
    o();
    n();
  }
  
  public String a() {
    return this.m;
  }
  
  public void a(int paramInt) {
    this.q = paramInt;
  }
  
  public void a(long paramLong) {
    this.g = paramLong;
  }
  
  public void a(String paramString) {
    this.p = paramString;
  }
  
  public int b() {
    return this.d;
  }
  
  public void b(long paramLong) {
    this.f = paramLong;
  }
  
  public int c() {
    return this.j;
  }
  
  public Exception d() {
    return this.o;
  }
  
  public int e() {
    return this.i;
  }
  
  public long f() {
    return this.g;
  }
  
  public long g() {
    return this.f;
  }
  
  public long h() {
    return this.e;
  }
  
  public String i() {
    return this.h;
  }
  
  public long j() {
    return this.n;
  }
  
  public String k() {
    return this.p;
  }
  
  public boolean l() {
    return (this.d == 503);
  }
  
  public boolean m() {
    return (this.d == 200);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */