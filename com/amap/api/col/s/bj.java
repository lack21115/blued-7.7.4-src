package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public final class bj {
  public static int a = -1;
  
  public static String b = "";
  
  public static Context c;
  
  public static volatile boolean d = false;
  
  private static volatile boolean e = true;
  
  private static Vector<e> f = new Vector<e>();
  
  private static Map<String, Integer> g = new HashMap<String, Integer>();
  
  private static String h = null;
  
  private static long i = 0L;
  
  private static volatile ConcurrentHashMap<String, Long> j;
  
  private static volatile ConcurrentHashMap<String, Long> k;
  
  private static volatile ConcurrentHashMap<String, d> l;
  
  static {
    d = false;
    j = new ConcurrentHashMap<String, Long>(8);
    k = new ConcurrentHashMap<String, Long>(8);
    l = new ConcurrentHashMap<String, d>(8);
  }
  
  public static b a(Context paramContext, br parambr, String paramString1, String paramString2, String paramString3, String paramString4) {
    return b(paramContext, parambr, paramString1, paramString2, paramString3, paramString4);
  }
  
  private static e a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bj
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: ifne -> 63
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: getstatic com/amap/api/col/s/bj.f : Ljava/util/Vector;
    //   16: invokevirtual size : ()I
    //   19: if_icmpge -> 63
    //   22: getstatic com/amap/api/col/s/bj.f : Ljava/util/Vector;
    //   25: iload_2
    //   26: invokevirtual get : (I)Ljava/lang/Object;
    //   29: checkcast com/amap/api/col/s/bj$e
    //   32: astore #4
    //   34: aload #4
    //   36: ifnull -> 56
    //   39: aload_1
    //   40: aload #4
    //   42: invokestatic c : (Lcom/amap/api/col/s/bj$e;)Ljava/lang/String;
    //   45: invokevirtual equals : (Ljava/lang/Object;)Z
    //   48: istore_3
    //   49: iload_3
    //   50: ifeq -> 56
    //   53: goto -> 66
    //   56: iload_2
    //   57: iconst_1
    //   58: iadd
    //   59: istore_2
    //   60: goto -> 12
    //   63: aconst_null
    //   64: astore #4
    //   66: aload #4
    //   68: ifnull -> 77
    //   71: ldc com/amap/api/col/s/bj
    //   73: monitorexit
    //   74: aload #4
    //   76: areturn
    //   77: aload_0
    //   78: ifnonnull -> 86
    //   81: ldc com/amap/api/col/s/bj
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    //   86: new com/amap/api/col/s/ci
    //   89: dup
    //   90: aload_1
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: aload_0
    //   95: ldc 'i'
    //   97: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   100: invokestatic b : (Ljava/lang/String;)Lcom/amap/api/col/s/bj$e;
    //   103: astore_1
    //   104: invokestatic currentTimeMillis : ()J
    //   107: ldc 'yyyyMMdd'
    //   109: invokestatic a : (JLjava/lang/String;)Ljava/lang/String;
    //   112: astore #4
    //   114: aload_1
    //   115: astore_0
    //   116: aload_1
    //   117: ifnonnull -> 133
    //   120: new com/amap/api/col/s/bj$e
    //   123: dup
    //   124: ldc 'IPV6_CONFIG_NAME'
    //   126: aload #4
    //   128: iconst_0
    //   129: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;I)V
    //   132: astore_0
    //   133: aload #4
    //   135: aload_0
    //   136: invokestatic a : (Lcom/amap/api/col/s/bj$e;)Ljava/lang/String;
    //   139: invokevirtual equals : (Ljava/lang/Object;)Z
    //   142: ifne -> 159
    //   145: aload_0
    //   146: aload #4
    //   148: invokevirtual a : (Ljava/lang/String;)V
    //   151: aload_0
    //   152: invokestatic b : (Lcom/amap/api/col/s/bj$e;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   155: iconst_0
    //   156: invokevirtual set : (I)V
    //   159: getstatic com/amap/api/col/s/bj.f : Ljava/util/Vector;
    //   162: aload_0
    //   163: invokevirtual add : (Ljava/lang/Object;)Z
    //   166: pop
    //   167: ldc com/amap/api/col/s/bj
    //   169: monitorexit
    //   170: aload_0
    //   171: areturn
    //   172: astore_0
    //   173: ldc com/amap/api/col/s/bj
    //   175: monitorexit
    //   176: aload_0
    //   177: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	172	finally
    //   12	34	172	finally
    //   39	49	172	finally
    //   86	114	172	finally
    //   120	133	172	finally
    //   133	159	172	finally
    //   159	167	172	finally
  }
  
  public static void a(int paramInt) {
    if (paramInt != 2)
      return; 
    try {
      e e = a(c, "IPV6_CONFIG_NAME");
      String str = bs.a(System.currentTimeMillis(), "yyyyMMdd");
      if (!str.equals(e.a(e))) {
        e.a(str);
        e.b(e).set(0);
      } 
      e.b(e).incrementAndGet();
      Context context = c;
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void a(Context paramContext) {
    if (paramContext != null)
      c = paramContext.getApplicationContext(); 
  }
  
  private static void a(Context paramContext, br parambr, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("amap_sdk_auth_fail", "1");
    hashMap.put("amap_sdk_auth_fail_type", paramString);
    hashMap.put("amap_sdk_name", parambr.b());
    hashMap.put("amap_sdk_version", parambr.d());
    String str = (new JSONObject(hashMap)).toString();
    if (TextUtils.isEmpty(str))
      return; 
    try {
      de de = new de(paramContext, "core", "2.0", "O001");
      de.a(str);
      df.a(de, paramContext);
      return;
    } catch (bh bh) {
      return;
    } 
  }
  
  public static void a(Context paramContext, br parambr, String paramString, a parama) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bj
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 201
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: goto -> 201
    //   14: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   17: ifnonnull -> 27
    //   20: aload_0
    //   21: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   24: putstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   27: aload_1
    //   28: invokevirtual b : ()Ljava/lang/String;
    //   31: astore_0
    //   32: aload_0
    //   33: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   36: istore #4
    //   38: iload #4
    //   40: ifeq -> 47
    //   43: ldc com/amap/api/col/s/bj
    //   45: monitorexit
    //   46: return
    //   47: aload_1
    //   48: invokestatic a : (Lcom/amap/api/col/s/br;)V
    //   51: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   54: ifnonnull -> 69
    //   57: new java/util/concurrent/ConcurrentHashMap
    //   60: dup
    //   61: bipush #8
    //   63: invokespecial <init> : (I)V
    //   66: putstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   69: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   72: ifnonnull -> 87
    //   75: new java/util/concurrent/ConcurrentHashMap
    //   78: dup
    //   79: bipush #8
    //   81: invokespecial <init> : (I)V
    //   84: putstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   87: getstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   90: ifnonnull -> 105
    //   93: new java/util/concurrent/ConcurrentHashMap
    //   96: dup
    //   97: bipush #8
    //   99: invokespecial <init> : (I)V
    //   102: putstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   105: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   108: aload_0
    //   109: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   112: ifne -> 177
    //   115: new com/amap/api/col/s/bj$d
    //   118: dup
    //   119: iconst_0
    //   120: invokespecial <init> : (B)V
    //   123: astore #7
    //   125: aload #7
    //   127: aload_1
    //   128: putfield a : Lcom/amap/api/col/s/br;
    //   131: aload #7
    //   133: aload_2
    //   134: putfield b : Ljava/lang/String;
    //   137: aload #7
    //   139: aload_3
    //   140: putfield c : Lcom/amap/api/col/s/bj$a;
    //   143: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   146: aload_0
    //   147: aload #7
    //   149: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   156: ldc 'open_common'
    //   158: aload_0
    //   159: invokestatic c : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)J
    //   162: lstore #5
    //   164: getstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   167: aload_0
    //   168: lload #5
    //   170: invokestatic valueOf : (J)Ljava/lang/Long;
    //   173: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: ldc com/amap/api/col/s/bj
    //   179: monitorexit
    //   180: return
    //   181: astore_0
    //   182: aload_0
    //   183: ldc 'at'
    //   185: ldc_w 'rglc'
    //   188: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   191: ldc com/amap/api/col/s/bj
    //   193: monitorexit
    //   194: return
    //   195: astore_0
    //   196: ldc com/amap/api/col/s/bj
    //   198: monitorexit
    //   199: aload_0
    //   200: athrow
    //   201: ldc com/amap/api/col/s/bj
    //   203: monitorexit
    //   204: return
    // Exception table:
    //   from	to	target	type
    //   14	27	181	finally
    //   27	38	181	finally
    //   47	69	181	finally
    //   69	87	181	finally
    //   87	105	181	finally
    //   105	177	181	finally
    //   182	191	195	finally
  }
  
  private static void a(Context paramContext, br parambr, String paramString, b paramb, JSONObject paramJSONObject) throws JSONException {
    b.a a = new b.a();
    a.a = false;
    a.b = false;
    paramb.g = a;
    try {
      String[] arrayOfString = paramString.split(";");
    } finally {
      paramString = null;
    } 
    if (bs.a(paramJSONObject, "16H"))
      try {
        b.a(paramb, a(paramJSONObject.getJSONObject("16H").optString("able"), false));
      } finally {
        paramString = null;
      }  
    if (bs.a(paramJSONObject, "11K"))
      try {
        JSONObject jSONObject = paramJSONObject.getJSONObject("11K");
        a.a = a(jSONObject.getString("able"), false);
        if (jSONObject.has("off"))
          a.c = jSONObject.getJSONObject("off"); 
      } finally {
        paramString = null;
      }  
    if (bs.a(paramJSONObject, "145"))
      try {
        paramb.a = paramJSONObject.getJSONObject("145");
      } finally {
        paramString = null;
      }  
    if (bs.a(paramJSONObject, "14D"))
      try {
        paramb.b = paramJSONObject.getJSONObject("14D");
      } finally {
        paramString = null;
      }  
    if (bs.a(paramJSONObject, "151"))
      try {
        JSONObject jSONObject = paramJSONObject.getJSONObject("151");
        b.b b1 = new b.b();
        if (jSONObject != null)
          b1.a = a(jSONObject.optString("able"), false); 
      } finally {
        paramString = null;
      }  
    if (bs.a(paramJSONObject, "17S"))
      try {
        JSONObject jSONObject = paramJSONObject.getJSONObject("17S");
      } finally {
        paramString = null;
      }  
    if (bs.a(paramJSONObject, "15K"))
      try {
        JSONObject jSONObject = paramJSONObject.getJSONObject("15K");
      } finally {
        paramContext = null;
      }  
    if (bs.a(paramJSONObject, "183"))
      try {
        return;
      } finally {
        paramContext = null;
      }  
  }
  
  private static void a(Context paramContext, br parambr, Throwable paramThrowable) {
    a(paramContext, parambr, paramThrowable.getMessage());
  }
  
  private static void a(br parambr) {
    if (parambr != null)
      try {
        if (TextUtils.isEmpty(parambr.b()))
          return; 
        String str2 = parambr.d();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = parambr.c(); 
        if (TextUtils.isEmpty(str1))
          return; 
        return;
      } finally {
        parambr = null;
      }  
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bj
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore #5
    //   9: iload #5
    //   11: ifeq -> 18
    //   14: ldc com/amap/api/col/s/bj
    //   16: monitorexit
    //   17: return
    //   18: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   21: ifnonnull -> 36
    //   24: new java/util/concurrent/ConcurrentHashMap
    //   27: dup
    //   28: bipush #8
    //   30: invokespecial <init> : (I)V
    //   33: putstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   36: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_0
    //   40: invokestatic elapsedRealtime : ()J
    //   43: invokestatic valueOf : (J)Ljava/lang/Long;
    //   46: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   53: astore #6
    //   55: aload #6
    //   57: ifnonnull -> 64
    //   60: ldc com/amap/api/col/s/bj
    //   62: monitorexit
    //   63: return
    //   64: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   67: aload_0
    //   68: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   71: istore #5
    //   73: iload #5
    //   75: ifne -> 82
    //   78: ldc com/amap/api/col/s/bj
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   86: istore #5
    //   88: iload #5
    //   90: ifeq -> 97
    //   93: ldc com/amap/api/col/s/bj
    //   95: monitorexit
    //   96: return
    //   97: iload_1
    //   98: ifeq -> 106
    //   101: iconst_1
    //   102: aload_0
    //   103: invokestatic a : (ZLjava/lang/String;)V
    //   106: invokestatic c : ()Ljava/util/concurrent/ExecutorService;
    //   109: new com/amap/api/col/s/bj$1
    //   112: dup
    //   113: aload_0
    //   114: aload_2
    //   115: aload_3
    //   116: aload #4
    //   118: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   121: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   126: pop
    //   127: ldc com/amap/api/col/s/bj
    //   129: monitorexit
    //   130: return
    //   131: astore_0
    //   132: aload_0
    //   133: ldc 'at'
    //   135: ldc_w 'lca'
    //   138: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc com/amap/api/col/s/bj
    //   143: monitorexit
    //   144: return
    //   145: astore_0
    //   146: ldc com/amap/api/col/s/bj
    //   148: monitorexit
    //   149: aload_0
    //   150: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	131	finally
    //   18	36	131	finally
    //   36	55	131	finally
    //   64	73	131	finally
    //   82	88	131	finally
    //   101	106	131	finally
    //   106	127	131	finally
    //   132	141	145	finally
  }
  
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong) {
    if (!TextUtils.isEmpty(paramString)) {
      if (c == null)
        return; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("url", paramString);
      hashMap.put("downLevel", String.valueOf(paramBoolean2));
      int i = bm.p(c);
      String str = "0";
      if (i == 0) {
        paramString = "0";
      } else {
        paramString = "1";
      } 
      hashMap.put("ant", paramString);
      if (paramBoolean1) {
        paramString = "6";
      } else {
        paramString = "4";
      } 
      hashMap.put("type", paramString);
      if (paramBoolean3) {
        paramString = str;
      } else {
        paramString = "1";
      } 
      hashMap.put("status", paramString);
      hashMap.put("duration", String.valueOf(paramLong));
      paramString = (new JSONObject(hashMap)).toString();
      if (TextUtils.isEmpty(paramString))
        return; 
      try {
        de de = new de(c, "core", "2.0", "O002");
        de.a(paramString);
        df.a(de, c);
        return;
      } catch (bh bh) {
        return;
      } 
    } 
  }
  
  public static boolean a() {
    // Byte code:
    //   0: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnull -> 408
    //   8: aload_1
    //   9: ifnull -> 74
    //   12: aload_1
    //   13: invokestatic r : (Landroid/content/Context;)Ljava/lang/String;
    //   16: astore_1
    //   17: getstatic com/amap/api/col/s/bj.h : Ljava/lang/String;
    //   20: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   23: ifne -> 60
    //   26: aload_1
    //   27: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   30: ifne -> 60
    //   33: getstatic com/amap/api/col/s/bj.h : Ljava/lang/String;
    //   36: aload_1
    //   37: invokevirtual equals : (Ljava/lang/Object;)Z
    //   40: ifeq -> 60
    //   43: invokestatic currentTimeMillis : ()J
    //   46: getstatic com/amap/api/col/s/bj.i : J
    //   49: lsub
    //   50: ldc2_w 60000
    //   53: lcmp
    //   54: ifge -> 60
    //   57: goto -> 339
    //   60: aload_1
    //   61: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   64: ifne -> 91
    //   67: aload_1
    //   68: putstatic com/amap/api/col/s/bj.h : Ljava/lang/String;
    //   71: goto -> 91
    //   74: invokestatic currentTimeMillis : ()J
    //   77: getstatic com/amap/api/col/s/bj.i : J
    //   80: lsub
    //   81: ldc2_w 10000
    //   84: lcmp
    //   85: ifge -> 91
    //   88: goto -> 339
    //   91: invokestatic currentTimeMillis : ()J
    //   94: putstatic com/amap/api/col/s/bj.i : J
    //   97: getstatic com/amap/api/col/s/bj.g : Ljava/util/Map;
    //   100: invokeinterface clear : ()V
    //   105: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   108: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   111: invokevirtual iterator : ()Ljava/util/Iterator;
    //   114: astore_1
    //   115: aload_1
    //   116: invokeinterface hasNext : ()Z
    //   121: ifeq -> 339
    //   124: aload_1
    //   125: invokeinterface next : ()Ljava/lang/Object;
    //   130: checkcast java/net/NetworkInterface
    //   133: astore_3
    //   134: aload_3
    //   135: invokevirtual getInterfaceAddresses : ()Ljava/util/List;
    //   138: invokeinterface isEmpty : ()Z
    //   143: ifne -> 115
    //   146: aload_3
    //   147: invokevirtual getDisplayName : ()Ljava/lang/String;
    //   150: astore_2
    //   151: aload_3
    //   152: invokevirtual getInterfaceAddresses : ()Ljava/util/List;
    //   155: invokeinterface iterator : ()Ljava/util/Iterator;
    //   160: astore_3
    //   161: iconst_0
    //   162: istore_0
    //   163: aload_3
    //   164: invokeinterface hasNext : ()Z
    //   169: ifeq -> 259
    //   172: aload_3
    //   173: invokeinterface next : ()Ljava/lang/Object;
    //   178: checkcast java/net/InterfaceAddress
    //   181: invokevirtual getAddress : ()Ljava/net/InetAddress;
    //   184: astore #4
    //   186: aload #4
    //   188: instanceof java/net/Inet6Address
    //   191: ifeq -> 212
    //   194: aload #4
    //   196: checkcast java/net/Inet6Address
    //   199: invokestatic a : (Ljava/net/InetAddress;)Z
    //   202: ifne -> 163
    //   205: iload_0
    //   206: iconst_2
    //   207: ior
    //   208: istore_0
    //   209: goto -> 163
    //   212: aload #4
    //   214: instanceof java/net/Inet4Address
    //   217: ifeq -> 163
    //   220: aload #4
    //   222: checkcast java/net/Inet4Address
    //   225: astore #4
    //   227: aload #4
    //   229: invokestatic a : (Ljava/net/InetAddress;)Z
    //   232: ifne -> 163
    //   235: aload #4
    //   237: invokevirtual getHostAddress : ()Ljava/lang/String;
    //   240: ldc_w 'FMTkyLjE2OC40My4'
    //   243: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   246: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   249: ifne -> 163
    //   252: iload_0
    //   253: iconst_1
    //   254: ior
    //   255: istore_0
    //   256: goto -> 163
    //   259: iload_0
    //   260: ifeq -> 115
    //   263: aload_2
    //   264: ifnull -> 296
    //   267: aload_2
    //   268: ldc_w 'wlan'
    //   271: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   274: ifeq -> 296
    //   277: getstatic com/amap/api/col/s/bj.g : Ljava/util/Map;
    //   280: ldc_w 'WIFI'
    //   283: iload_0
    //   284: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   287: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: pop
    //   293: goto -> 115
    //   296: aload_2
    //   297: ifnull -> 115
    //   300: aload_2
    //   301: ldc_w 'rmnet'
    //   304: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   307: ifeq -> 115
    //   310: getstatic com/amap/api/col/s/bj.g : Ljava/util/Map;
    //   313: ldc_w 'MOBILE'
    //   316: iload_0
    //   317: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   320: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: goto -> 115
    //   329: astore_1
    //   330: aload_1
    //   331: ldc 'at'
    //   333: ldc_w 'ipstack'
    //   336: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   339: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   342: astore_1
    //   343: aload_1
    //   344: ifnull -> 392
    //   347: aload_1
    //   348: invokestatic r : (Landroid/content/Context;)Ljava/lang/String;
    //   351: astore_1
    //   352: aload_1
    //   353: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   356: ifne -> 392
    //   359: getstatic com/amap/api/col/s/bj.g : Ljava/util/Map;
    //   362: aload_1
    //   363: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   366: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast java/lang/Integer
    //   374: astore_1
    //   375: aload_1
    //   376: ifnull -> 392
    //   379: aload_1
    //   380: invokevirtual intValue : ()I
    //   383: iconst_2
    //   384: if_icmplt -> 392
    //   387: iconst_1
    //   388: istore_0
    //   389: goto -> 394
    //   392: iconst_0
    //   393: istore_0
    //   394: iload_0
    //   395: ifne -> 400
    //   398: iconst_0
    //   399: ireturn
    //   400: invokestatic b : ()Z
    //   403: ifeq -> 408
    //   406: iconst_1
    //   407: ireturn
    //   408: getstatic com/amap/api/col/s/bj.e : Z
    //   411: ifne -> 416
    //   414: iconst_0
    //   415: ireturn
    //   416: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   419: ldc 'IPV6_CONFIG_NAME'
    //   421: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Lcom/amap/api/col/s/bj$e;
    //   424: astore_1
    //   425: aload_1
    //   426: ifnonnull -> 431
    //   429: iconst_0
    //   430: ireturn
    //   431: aload_1
    //   432: invokevirtual a : ()I
    //   435: iconst_5
    //   436: if_icmpge -> 441
    //   439: iconst_1
    //   440: ireturn
    //   441: iconst_0
    //   442: ireturn
    // Exception table:
    //   from	to	target	type
    //   12	57	329	finally
    //   60	71	329	finally
    //   74	88	329	finally
    //   91	115	329	finally
    //   115	161	329	finally
    //   163	205	329	finally
    //   212	252	329	finally
    //   267	293	329	finally
    //   300	326	329	finally
  }
  
  public static boolean a(String paramString) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bj
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq -> 17
    //   12: ldc com/amap/api/col/s/bj
    //   14: monitorexit
    //   15: iconst_0
    //   16: ireturn
    //   17: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull -> 30
    //   25: ldc com/amap/api/col/s/bj
    //   27: monitorexit
    //   28: iconst_0
    //   29: ireturn
    //   30: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ifnonnull -> 48
    //   36: new java/util/concurrent/ConcurrentHashMap
    //   39: dup
    //   40: bipush #8
    //   42: invokespecial <init> : (I)V
    //   45: putstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   48: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   51: aload_0
    //   52: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   55: ifeq -> 97
    //   58: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   61: aload_0
    //   62: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   65: ifne -> 97
    //   68: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   71: aload_0
    //   72: invokestatic elapsedRealtime : ()J
    //   75: invokestatic valueOf : (J)Ljava/lang/Long;
    //   78: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: ldc com/amap/api/col/s/bj
    //   84: monitorexit
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_0
    //   88: aload_0
    //   89: ldc 'at'
    //   91: ldc_w 'cslct'
    //   94: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   97: ldc com/amap/api/col/s/bj
    //   99: monitorexit
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_0
    //   103: ldc com/amap/api/col/s/bj
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	87	finally
    //   17	21	87	finally
    //   30	48	87	finally
    //   48	82	87	finally
    //   88	97	102	finally
  }
  
  public static boolean a(String paramString, long paramLong) {
    boolean bool1;
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/amap/api/col/s/bj}} */
    boolean bool2 = false;
    try {
      bool1 = TextUtils.isEmpty(paramString);
      if (bool1)
        return false; 
      bool1 = bool2;
    } finally {
      paramString = null;
    } 
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/amap/api/col/s/bj}} */
    return bool1;
  }
  
  public static boolean a(String paramString, boolean paramBoolean) {
    try {
      if (TextUtils.isEmpty(paramString))
        return paramBoolean; 
      String[] arrayOfString = URLDecoder.decode(paramString).split("/");
      return (c % 2 == 1);
    } finally {
      paramString = null;
    } 
  }
  
  private static boolean a(InetAddress paramInetAddress) {
    return (paramInetAddress.isLoopbackAddress() || paramInetAddress.isLinkLocalAddress() || paramInetAddress.isAnyLocalAddress());
  }
  
  private static b b(Context paramContext, br parambr, String paramString1, String paramString2, String paramString3, String paramString4) {
    // Byte code:
    //   0: new com/amap/api/col/s/bj$b
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #12
    //   9: aload #12
    //   11: new org/json/JSONObject
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: putfield f : Lorg/json/JSONObject;
    //   21: getstatic com/amap/api/col/s/bo$a.a : Lcom/amap/api/col/s/bo;
    //   24: aload_0
    //   25: invokevirtual a : (Landroid/content/Context;)V
    //   28: aload_0
    //   29: invokestatic b : (Landroid/content/Context;)V
    //   32: aload_0
    //   33: ifnull -> 43
    //   36: aload_0
    //   37: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   40: putstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   43: aconst_null
    //   44: astore #13
    //   46: aload_1
    //   47: invokestatic a : (Lcom/amap/api/col/s/br;)V
    //   50: new com/amap/api/col/s/cs
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: pop
    //   58: aload_2
    //   59: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   62: istore #7
    //   64: iload #7
    //   66: ifne -> 118
    //   69: new java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial <init> : ()V
    //   76: astore #9
    //   78: aload #9
    //   80: aload_2
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload #9
    //   87: ldc_w ';15K;16H;17I;17S;183'
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload #9
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: astore #9
    //   101: aload #9
    //   103: astore_2
    //   104: goto -> 118
    //   107: astore_3
    //   108: goto -> 115
    //   111: goto -> 561
    //   114: astore_3
    //   115: goto -> 589
    //   118: aload #12
    //   120: astore #9
    //   122: new com/amap/api/col/s/bj$c
    //   125: dup
    //   126: aload_0
    //   127: aload_1
    //   128: aload_2
    //   129: aload_3
    //   130: aload #4
    //   132: aload #5
    //   134: invokespecial <init> : (Landroid/content/Context;Lcom/amap/api/col/s/br;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   137: astore_3
    //   138: aload_3
    //   139: aload_3
    //   140: invokevirtual a : ()Z
    //   143: invokestatic a : (Lcom/amap/api/col/s/cy;Z)Lcom/amap/api/col/s/cz;
    //   146: astore #4
    //   148: iload #7
    //   150: ifeq -> 156
    //   153: aload #9
    //   155: areturn
    //   156: aload #4
    //   158: ifnull -> 1167
    //   161: aload #4
    //   163: getfield a : [B
    //   166: astore #5
    //   168: aload #4
    //   170: getfield b : Ljava/util/Map;
    //   173: astore #10
    //   175: aload #5
    //   177: astore_3
    //   178: aload #10
    //   180: ifnull -> 353
    //   183: aload #5
    //   185: astore_3
    //   186: aload #10
    //   188: ldc_w 'lct'
    //   191: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   196: ifeq -> 353
    //   199: aload #10
    //   201: ldc_w 'lct'
    //   204: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   209: checkcast java/util/List
    //   212: astore #10
    //   214: aload #5
    //   216: astore_3
    //   217: aload #10
    //   219: ifnull -> 353
    //   222: aload #5
    //   224: astore_3
    //   225: aload #10
    //   227: invokeinterface size : ()I
    //   232: ifle -> 353
    //   235: aload #10
    //   237: iconst_0
    //   238: invokeinterface get : (I)Ljava/lang/Object;
    //   243: checkcast java/lang/String
    //   246: astore #10
    //   248: aload #5
    //   250: astore_3
    //   251: aload #10
    //   253: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   256: ifne -> 353
    //   259: aload #9
    //   261: aload #10
    //   263: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   266: invokevirtual longValue : ()J
    //   269: putfield e : J
    //   272: aload #5
    //   274: astore_3
    //   275: aload_1
    //   276: ifnull -> 353
    //   279: aload #5
    //   281: astore_3
    //   282: aload #9
    //   284: getfield e : J
    //   287: lconst_0
    //   288: lcmp
    //   289: ifeq -> 353
    //   292: aload_1
    //   293: invokevirtual b : ()Ljava/lang/String;
    //   296: astore #10
    //   298: aload #5
    //   300: astore_3
    //   301: aload #10
    //   303: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   306: ifne -> 353
    //   309: aload #10
    //   311: aload #9
    //   313: getfield e : J
    //   316: invokestatic b : (Ljava/lang/String;J)V
    //   319: aload #5
    //   321: astore_3
    //   322: goto -> 353
    //   325: astore_3
    //   326: aload #5
    //   328: astore #9
    //   330: aload #5
    //   332: astore #10
    //   334: aload #5
    //   336: astore #11
    //   338: aload_3
    //   339: ldc 'at'
    //   341: ldc_w 'lct'
    //   344: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload #5
    //   349: astore_3
    //   350: goto -> 353
    //   353: aload_3
    //   354: astore #9
    //   356: aload_3
    //   357: astore #10
    //   359: aload_3
    //   360: astore #11
    //   362: bipush #16
    //   364: newarray byte
    //   366: astore #14
    //   368: aload_3
    //   369: astore #9
    //   371: aload_3
    //   372: astore #10
    //   374: aload_3
    //   375: astore #11
    //   377: aload_3
    //   378: arraylength
    //   379: bipush #16
    //   381: isub
    //   382: newarray byte
    //   384: astore #5
    //   386: aload_3
    //   387: astore #9
    //   389: aload_3
    //   390: astore #10
    //   392: aload_3
    //   393: astore #11
    //   395: aload_3
    //   396: iconst_0
    //   397: aload #14
    //   399: iconst_0
    //   400: bipush #16
    //   402: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   405: aload_3
    //   406: astore #9
    //   408: aload_3
    //   409: astore #10
    //   411: aload_3
    //   412: astore #11
    //   414: aload_3
    //   415: bipush #16
    //   417: aload #5
    //   419: iconst_0
    //   420: aload_3
    //   421: arraylength
    //   422: bipush #16
    //   424: isub
    //   425: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   428: aload_3
    //   429: astore #9
    //   431: aload_3
    //   432: astore #10
    //   434: aload_3
    //   435: astore #11
    //   437: new javax/crypto/spec/SecretKeySpec
    //   440: dup
    //   441: aload #14
    //   443: ldc_w 'EQUVT'
    //   446: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   449: invokespecial <init> : ([BLjava/lang/String;)V
    //   452: astore #14
    //   454: aload_3
    //   455: astore #9
    //   457: aload_3
    //   458: astore #10
    //   460: aload_3
    //   461: astore #11
    //   463: ldc_w 'CQUVTL0NCQy9QS0NTNVBhZGRpbmc'
    //   466: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   469: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   472: astore #15
    //   474: aload_3
    //   475: astore #9
    //   477: aload_3
    //   478: astore #10
    //   480: aload_3
    //   481: astore #11
    //   483: aload #15
    //   485: iconst_2
    //   486: aload #14
    //   488: new javax/crypto/spec/IvParameterSpec
    //   491: dup
    //   492: invokestatic c : ()[B
    //   495: invokespecial <init> : ([B)V
    //   498: invokevirtual init : (ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   501: aload_3
    //   502: astore #9
    //   504: aload_3
    //   505: astore #10
    //   507: aload_3
    //   508: astore #11
    //   510: aload #15
    //   512: aload #5
    //   514: invokevirtual doFinal : ([B)[B
    //   517: invokestatic a : ([B)Ljava/lang/String;
    //   520: astore #5
    //   522: goto -> 717
    //   525: astore #5
    //   527: aload #4
    //   529: astore #10
    //   531: aload #9
    //   533: astore_3
    //   534: goto -> 618
    //   537: astore #5
    //   539: aload #4
    //   541: astore #9
    //   543: aload #10
    //   545: astore_3
    //   546: goto -> 658
    //   549: astore #5
    //   551: aload #11
    //   553: astore_3
    //   554: goto -> 684
    //   557: astore_3
    //   558: goto -> 589
    //   561: new com/amap/api/col/s/bh
    //   564: dup
    //   565: ldc_w '未知的错误'
    //   568: invokespecial <init> : (Ljava/lang/String;)V
    //   571: athrow
    //   572: astore #4
    //   574: goto -> 608
    //   577: astore #4
    //   579: goto -> 648
    //   582: astore #5
    //   584: goto -> 678
    //   587: astore #4
    //   589: aload_3
    //   590: athrow
    //   591: astore #4
    //   593: goto -> 608
    //   596: astore #4
    //   598: goto -> 648
    //   601: astore #5
    //   603: goto -> 678
    //   606: astore #4
    //   608: aconst_null
    //   609: astore #10
    //   611: aload #10
    //   613: astore_3
    //   614: aload #4
    //   616: astore #5
    //   618: aload #5
    //   620: ldc 'at'
    //   622: ldc_w 'lc'
    //   625: invokestatic c : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   628: aload_0
    //   629: aload_1
    //   630: aload #5
    //   632: invokestatic a : (Landroid/content/Context;Lcom/amap/api/col/s/br;Ljava/lang/Throwable;)V
    //   635: aload #10
    //   637: astore #4
    //   639: aload #13
    //   641: astore #5
    //   643: goto -> 717
    //   646: astore #4
    //   648: aconst_null
    //   649: astore #9
    //   651: aload #9
    //   653: astore_3
    //   654: aload #4
    //   656: astore #5
    //   658: aload_0
    //   659: aload_1
    //   660: aload #5
    //   662: invokestatic a : (Landroid/content/Context;Lcom/amap/api/col/s/br;Ljava/lang/Throwable;)V
    //   665: aload #9
    //   667: astore #4
    //   669: aload #13
    //   671: astore #5
    //   673: goto -> 717
    //   676: astore #5
    //   678: aconst_null
    //   679: astore #4
    //   681: aload #4
    //   683: astore_3
    //   684: aload #12
    //   686: aload #5
    //   688: invokevirtual a : ()Ljava/lang/String;
    //   691: putfield c : Ljava/lang/String;
    //   694: aload_0
    //   695: aload_1
    //   696: aload #5
    //   698: invokevirtual a : ()Ljava/lang/String;
    //   701: invokestatic a : (Landroid/content/Context;Lcom/amap/api/col/s/br;Ljava/lang/String;)V
    //   704: aload_1
    //   705: ldc_w '/v3/iasdkauth'
    //   708: aload #5
    //   710: invokestatic a : (Lcom/amap/api/col/s/br;Ljava/lang/String;Lcom/amap/api/col/s/bh;)V
    //   713: aload #13
    //   715: astore #5
    //   717: aload_3
    //   718: ifnonnull -> 724
    //   721: aload #12
    //   723: areturn
    //   724: aload #5
    //   726: astore #9
    //   728: aload #5
    //   730: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   733: ifeq -> 742
    //   736: aload_3
    //   737: invokestatic a : ([B)Ljava/lang/String;
    //   740: astore #9
    //   742: aload #9
    //   744: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   747: ifeq -> 758
    //   750: aload_0
    //   751: aload_1
    //   752: ldc_w 'result is null'
    //   755: invokestatic a : (Landroid/content/Context;Lcom/amap/api/col/s/br;Ljava/lang/String;)V
    //   758: new org/json/JSONObject
    //   761: dup
    //   762: aload #9
    //   764: invokespecial <init> : (Ljava/lang/String;)V
    //   767: astore #9
    //   769: aload #9
    //   771: ldc_w 'status'
    //   774: invokevirtual has : (Ljava/lang/String;)Z
    //   777: ifeq -> 1115
    //   780: aload #9
    //   782: ldc_w 'status'
    //   785: invokevirtual getInt : (Ljava/lang/String;)I
    //   788: istore #6
    //   790: iload #6
    //   792: iconst_1
    //   793: if_icmpne -> 803
    //   796: iconst_1
    //   797: putstatic com/amap/api/col/s/bj.a : I
    //   800: goto -> 927
    //   803: iload #6
    //   805: ifne -> 927
    //   808: aload #4
    //   810: ifnull -> 1172
    //   813: aload #4
    //   815: getfield c : Ljava/lang/String;
    //   818: astore_3
    //   819: aload #4
    //   821: getfield d : Ljava/lang/String;
    //   824: astore #5
    //   826: aload_3
    //   827: astore #4
    //   829: aload #5
    //   831: astore_3
    //   832: goto -> 835
    //   835: aload_0
    //   836: aload #4
    //   838: aload_3
    //   839: aload #9
    //   841: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   844: iconst_0
    //   845: putstatic com/amap/api/col/s/bj.a : I
    //   848: aload #9
    //   850: ldc_w 'info'
    //   853: invokevirtual has : (Ljava/lang/String;)Z
    //   856: ifeq -> 870
    //   859: aload #9
    //   861: ldc_w 'info'
    //   864: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   867: putstatic com/amap/api/col/s/bj.b : Ljava/lang/String;
    //   870: ldc ''
    //   872: astore #5
    //   874: aload #9
    //   876: ldc_w 'infocode'
    //   879: invokevirtual has : (Ljava/lang/String;)Z
    //   882: ifeq -> 895
    //   885: aload #9
    //   887: ldc_w 'infocode'
    //   890: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   893: astore #5
    //   895: aload_1
    //   896: ldc_w '/v3/iasdkauth'
    //   899: getstatic com/amap/api/col/s/bj.b : Ljava/lang/String;
    //   902: aload_3
    //   903: aload #4
    //   905: aload #5
    //   907: invokestatic a : (Lcom/amap/api/col/s/br;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   910: getstatic com/amap/api/col/s/bj.a : I
    //   913: ifne -> 927
    //   916: aload #12
    //   918: getstatic com/amap/api/col/s/bj.b : Ljava/lang/String;
    //   921: putfield c : Ljava/lang/String;
    //   924: aload #12
    //   926: areturn
    //   927: aload #9
    //   929: ldc_w 'ver'
    //   932: invokevirtual has : (Ljava/lang/String;)Z
    //   935: ifeq -> 964
    //   938: aload #12
    //   940: aload #9
    //   942: ldc_w 'ver'
    //   945: invokevirtual getInt : (Ljava/lang/String;)I
    //   948: putfield d : I
    //   951: goto -> 964
    //   954: astore_3
    //   955: aload_3
    //   956: ldc 'at'
    //   958: ldc_w 'lc'
    //   961: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   964: aload #9
    //   966: ldc_w 'result'
    //   969: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   972: ifeq -> 1115
    //   975: aload #9
    //   977: ldc_w 'result'
    //   980: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   983: astore_3
    //   984: aload_0
    //   985: aload_1
    //   986: aload_2
    //   987: aload #12
    //   989: aload_3
    //   990: invokestatic a : (Landroid/content/Context;Lcom/amap/api/col/s/br;Ljava/lang/String;Lcom/amap/api/col/s/bj$b;Lorg/json/JSONObject;)V
    //   993: aload_3
    //   994: ldc_w '17I'
    //   997: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   1000: ifeq -> 1047
    //   1003: aload_3
    //   1004: ldc_w '17I'
    //   1007: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   1010: astore_1
    //   1011: aload_1
    //   1012: ldc_w 'na'
    //   1015: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1018: iconst_0
    //   1019: invokestatic a : (Ljava/lang/String;Z)Z
    //   1022: istore #7
    //   1024: aload_1
    //   1025: ldc_w 'aa'
    //   1028: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1031: iconst_0
    //   1032: invokestatic a : (Ljava/lang/String;Z)Z
    //   1035: istore #8
    //   1037: iload #7
    //   1039: putstatic com/amap/api/col/s/cc.d : Z
    //   1042: iload #8
    //   1044: putstatic com/amap/api/col/s/cc.e : Z
    //   1047: aload_3
    //   1048: ldc_w '15K'
    //   1051: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   1054: astore_1
    //   1055: aload_1
    //   1056: ldc_w 'isTargetAble'
    //   1059: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1062: iconst_0
    //   1063: invokestatic a : (Ljava/lang/String;Z)Z
    //   1066: istore #7
    //   1068: aload_1
    //   1069: ldc_w 'able'
    //   1072: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1075: iconst_0
    //   1076: invokestatic a : (Ljava/lang/String;Z)Z
    //   1079: ifne -> 1093
    //   1082: getstatic com/amap/api/col/s/bo$a.a : Lcom/amap/api/col/s/bo;
    //   1085: astore_1
    //   1086: aload_0
    //   1087: invokestatic b : (Landroid/content/Context;)V
    //   1090: aload #12
    //   1092: areturn
    //   1093: getstatic com/amap/api/col/s/bo$a.a : Lcom/amap/api/col/s/bo;
    //   1096: aload_0
    //   1097: iload #7
    //   1099: invokevirtual a : (Landroid/content/Context;Z)V
    //   1102: aload #12
    //   1104: areturn
    //   1105: astore_0
    //   1106: aload_0
    //   1107: ldc 'at'
    //   1109: ldc_w 'lc'
    //   1112: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1115: aload #12
    //   1117: areturn
    //   1118: astore_3
    //   1119: goto -> 111
    //   1122: astore_3
    //   1123: goto -> 111
    //   1126: astore_0
    //   1127: goto -> 111
    //   1130: astore_3
    //   1131: goto -> 561
    //   1134: astore_0
    //   1135: aload #12
    //   1137: areturn
    //   1138: astore #5
    //   1140: aconst_null
    //   1141: astore_3
    //   1142: aload #4
    //   1144: astore #10
    //   1146: goto -> 618
    //   1149: astore #5
    //   1151: aconst_null
    //   1152: astore_3
    //   1153: aload #4
    //   1155: astore #9
    //   1157: goto -> 658
    //   1160: astore #5
    //   1162: aconst_null
    //   1163: astore_3
    //   1164: goto -> 684
    //   1167: aconst_null
    //   1168: astore_3
    //   1169: goto -> 353
    //   1172: ldc_w 'authcsid'
    //   1175: astore #4
    //   1177: ldc_w 'authgsid'
    //   1180: astore_3
    //   1181: goto -> 835
    // Exception table:
    //   from	to	target	type
    //   46	64	676	com/amap/api/col/s/bh
    //   46	64	646	javax/crypto/IllegalBlockSizeException
    //   46	64	606	finally
    //   69	78	114	com/amap/api/col/s/bh
    //   69	78	1118	finally
    //   78	101	107	com/amap/api/col/s/bh
    //   78	101	1122	finally
    //   122	148	557	com/amap/api/col/s/bh
    //   122	148	1130	finally
    //   161	168	1160	com/amap/api/col/s/bh
    //   161	168	1149	javax/crypto/IllegalBlockSizeException
    //   161	168	1138	finally
    //   168	175	325	finally
    //   186	214	325	finally
    //   225	248	325	finally
    //   251	272	325	finally
    //   282	298	325	finally
    //   301	319	325	finally
    //   338	347	549	com/amap/api/col/s/bh
    //   338	347	537	javax/crypto/IllegalBlockSizeException
    //   338	347	525	finally
    //   362	368	549	com/amap/api/col/s/bh
    //   362	368	537	javax/crypto/IllegalBlockSizeException
    //   362	368	525	finally
    //   377	386	549	com/amap/api/col/s/bh
    //   377	386	537	javax/crypto/IllegalBlockSizeException
    //   377	386	525	finally
    //   395	405	549	com/amap/api/col/s/bh
    //   395	405	537	javax/crypto/IllegalBlockSizeException
    //   395	405	525	finally
    //   414	428	549	com/amap/api/col/s/bh
    //   414	428	537	javax/crypto/IllegalBlockSizeException
    //   414	428	525	finally
    //   437	454	549	com/amap/api/col/s/bh
    //   437	454	537	javax/crypto/IllegalBlockSizeException
    //   437	454	525	finally
    //   463	474	549	com/amap/api/col/s/bh
    //   463	474	537	javax/crypto/IllegalBlockSizeException
    //   463	474	525	finally
    //   483	501	549	com/amap/api/col/s/bh
    //   483	501	537	javax/crypto/IllegalBlockSizeException
    //   483	501	525	finally
    //   510	522	549	com/amap/api/col/s/bh
    //   510	522	537	javax/crypto/IllegalBlockSizeException
    //   510	522	525	finally
    //   561	572	582	com/amap/api/col/s/bh
    //   561	572	577	javax/crypto/IllegalBlockSizeException
    //   561	572	572	finally
    //   589	591	601	com/amap/api/col/s/bh
    //   589	591	596	javax/crypto/IllegalBlockSizeException
    //   589	591	591	finally
    //   758	790	1105	finally
    //   796	800	1105	finally
    //   813	826	1105	finally
    //   835	870	1105	finally
    //   874	895	1105	finally
    //   895	924	1105	finally
    //   927	951	954	finally
    //   955	964	1105	finally
    //   964	1047	1105	finally
    //   1047	1090	1134	finally
    //   1093	1102	1134	finally
  }
  
  private static void b(Context paramContext) {
    if (paramContext == null)
      return; 
    e = ci.a(paramContext, "open_common", "a2", true);
  }
  
  public static void b(String paramString) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bj
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 15
    //   11: ldc com/amap/api/col/s/bj
    //   13: monitorexit
    //   14: return
    //   15: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   18: aload_0
    //   19: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   22: ifeq -> 33
    //   25: getstatic com/amap/api/col/s/bj.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_0
    //   29: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: ldc com/amap/api/col/s/bj
    //   35: monitorexit
    //   36: return
    //   37: astore_0
    //   38: ldc com/amap/api/col/s/bj
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	37	finally
    //   15	33	37	finally
  }
  
  private static void b(String paramString, long paramLong) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bj
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: ifnull -> 81
    //   9: getstatic com/amap/api/col/s/bj.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   12: aload_0
    //   13: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   16: ifne -> 22
    //   19: goto -> 81
    //   22: getstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   25: ifnonnull -> 40
    //   28: new java/util/concurrent/ConcurrentHashMap
    //   31: dup
    //   32: bipush #8
    //   34: invokespecial <init> : (I)V
    //   37: putstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   40: getstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   43: aload_0
    //   44: lload_1
    //   45: invokestatic valueOf : (J)Ljava/lang/Long;
    //   48: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   55: ifnull -> 77
    //   58: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   61: ldc 'open_common'
    //   63: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   66: astore_3
    //   67: aload_3
    //   68: aload_0
    //   69: lload_1
    //   70: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;J)V
    //   73: aload_3
    //   74: invokestatic a : (Landroid/content/SharedPreferences$Editor;)V
    //   77: ldc com/amap/api/col/s/bj
    //   79: monitorexit
    //   80: return
    //   81: ldc com/amap/api/col/s/bj
    //   83: monitorexit
    //   84: return
    //   85: astore_0
    //   86: aload_0
    //   87: ldc 'at'
    //   89: ldc_w 'ucut'
    //   92: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   95: ldc com/amap/api/col/s/bj
    //   97: monitorexit
    //   98: return
    //   99: astore_0
    //   100: ldc com/amap/api/col/s/bj
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	85	finally
    //   22	40	85	finally
    //   40	77	85	finally
    //   86	95	99	finally
  }
  
  public static void b(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bj
    //   2: monitorenter
    //   3: aload_0
    //   4: iload_1
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: invokestatic a : (Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11: ldc com/amap/api/col/s/bj
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/amap/api/col/s/bj
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static boolean b() {
    Context context = c;
    if (context == null)
      return false; 
    String str = bm.r(context);
    if (TextUtils.isEmpty(str))
      return false; 
    Integer integer = g.get(str.toUpperCase());
    return (integer == null) ? false : ((integer.intValue() == 2));
  }
  
  public static long c(String paramString) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/bj
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: ifnonnull -> 21
    //   9: new java/util/concurrent/ConcurrentHashMap
    //   12: dup
    //   13: bipush #8
    //   15: invokespecial <init> : (I)V
    //   18: putstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   21: getstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_0
    //   25: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   28: ifeq -> 60
    //   31: getstatic com/amap/api/col/s/bj.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   34: aload_0
    //   35: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast java/lang/Long
    //   41: invokevirtual longValue : ()J
    //   44: lstore_1
    //   45: ldc com/amap/api/col/s/bj
    //   47: monitorexit
    //   48: lload_1
    //   49: lreturn
    //   50: astore_0
    //   51: aload_0
    //   52: ldc 'at'
    //   54: ldc_w 'glcut'
    //   57: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   60: ldc com/amap/api/col/s/bj
    //   62: monitorexit
    //   63: lconst_0
    //   64: lreturn
    //   65: astore_0
    //   66: ldc com/amap/api/col/s/bj
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	50	finally
    //   21	45	50	finally
    //   51	60	65	finally
  }
  
  public static void c() {
    if (d)
      return; 
    try {
      d = true;
      Context context = c;
      if (context == null)
        return; 
      bo.a.a.a(c);
      b(c);
      f.a = ci.a(context, "open_common", "ucf", f.a);
      f.b = ci.a(context, "open_common", "fsv2", f.b);
      f.c = ci.a(context, "open_common", "usc", f.c);
      f.d = ci.a(context, "open_common", "umv", f.d);
      f.e = ci.a(context, "open_common", "ust", f.e);
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static interface a {
    void a(bj.b param1b);
  }
  
  public static final class b {
    @Deprecated
    public JSONObject a;
    
    @Deprecated
    public JSONObject b;
    
    public String c;
    
    public int d = -1;
    
    public long e = 0L;
    
    public JSONObject f;
    
    public a g;
    
    public b h;
    
    private boolean i;
    
    public static final class a {
      public boolean a;
      
      public boolean b;
      
      public JSONObject c;
    }
    
    public static final class b {
      public boolean a;
    }
  }
  
  public static final class a {
    public boolean a;
    
    public boolean b;
    
    public JSONObject c;
  }
  
  public static final class b {
    public boolean a;
  }
  
  static final class c extends ct {
    private String c;
    
    private Map<String, String> d;
    
    private boolean e;
    
    private String f;
    
    private String j;
    
    private String k;
    
    c(Context param1Context, br param1br, String param1String1, String param1String2, String param1String3, String param1String4) {
      super(param1Context, param1br);
      boolean bool;
      this.c = param1String1;
      this.d = null;
      if (Build.VERSION.SDK_INT != 19) {
        bool = true;
      } else {
        bool = false;
      } 
      this.e = bool;
      this.f = param1String2;
      this.j = param1String3;
      this.k = param1String4;
    }
    
    public final boolean a() {
      return this.e;
    }
    
    public final String b() {
      try {
        String str;
        if (this.e) {
          str = "https://restsdk.amap.com/v3/iasdkauth";
        } else {
          str = "http://restsdk.amap.com/v3/iasdkauth";
        } 
      } finally {
        Exception exception = null;
      } 
    }
    
    public final byte[] d() {
      String str2 = bm.s(this.a);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
        str1 = bq.a((new StringBuilder(str2)).reverse().toString()); 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      if (TextUtils.isEmpty(this.c)) {
        str2 = "";
      } else {
        str2 = this.c;
      } 
      hashMap.put("authkey", str2);
      hashMap.put("plattype", "android");
      hashMap.put("product", this.b.b());
      hashMap.put("version", this.b.c());
      hashMap.put("output", "json");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Build.VERSION.SDK_INT);
      hashMap.put("androidversion", stringBuilder.toString());
      hashMap.put("deviceId", str1);
      hashMap.put("manufacture", Build.MANUFACTURER);
      Map<String, String> map = this.d;
      if (map != null && !map.isEmpty())
        hashMap.putAll(this.d); 
      hashMap.put("abitype", bs.a(this.a));
      hashMap.put("ext", this.b.e());
      return bs.a(bs.a((Map)hashMap));
    }
    
    public final Map<String, String> f() {
      if (!TextUtils.isEmpty(this.k)) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("host", this.k);
        return (Map)hashMap;
      } 
      return null;
    }
    
    public final String g() {
      String str1;
      if (this.e) {
        str1 = "https://restsdk.amap.com/v3/iasdkauth";
      } else {
        str1 = "http://restsdk.amap.com/v3/iasdkauth";
      } 
      String str2 = str1;
      try {
        return str2;
      } finally {
        str2 = null;
      } 
    }
    
    protected final String h() {
      return "3.0";
    }
    
    protected final String j() {
      return !TextUtils.isEmpty(this.k) ? this.k : super.j();
    }
  }
  
  static final class d {
    br a;
    
    String b;
    
    bj.a c;
    
    private d() {}
  }
  
  static final class e {
    private String a;
    
    private String b;
    
    private AtomicInteger c;
    
    public e(String param1String1, String param1String2, int param1Int) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = new AtomicInteger(param1Int);
    }
    
    public static e b(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return null; 
      try {
        return new e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
      } finally {
        param1String = null;
      } 
    }
    
    public final int a() {
      AtomicInteger atomicInteger = this.c;
      return (atomicInteger == null) ? 0 : atomicInteger.get();
    }
    
    public final void a(String param1String) {
      this.b = param1String;
    }
    
    public final String b() {
      try {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("a", this.a);
        jSONObject.put("f", this.b);
        return jSONObject.toString();
      } finally {
        Exception exception = null;
      } 
    }
  }
  
  public static final class f {
    public static boolean a = true;
    
    public static boolean b = false;
    
    public static boolean c = true;
    
    public static int d = 0;
    
    public static boolean e = false;
    
    public static int f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */