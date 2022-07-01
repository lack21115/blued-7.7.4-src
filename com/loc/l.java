package com.loc;

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

public final class l {
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
  
  public static b a(Context paramContext, t paramt, String paramString1, String paramString2, String paramString3, String paramString4) {
    return b(paramContext, paramt, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void a(int paramInt) {
    if (paramInt != 2)
      return; 
    try {
      e e = b(c, "IPV6_CONFIG_NAME");
      String str = u.a(System.currentTimeMillis(), "yyyyMMdd");
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
  
  private static void a(Context paramContext, t paramt, String paramString) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("amap_sdk_auth_fail", "1");
    hashMap.put("amap_sdk_auth_fail_type", paramString);
    hashMap.put("amap_sdk_name", paramt.a());
    hashMap.put("amap_sdk_version", paramt.c());
    String str = (new JSONObject(hashMap)).toString();
    if (TextUtils.isEmpty(str))
      return; 
    try {
      bb bb = new bb(paramContext, "core", "1.0", "O001");
      bb.a(str);
      bc.a(bb, paramContext);
      return;
    } catch (j j) {
      return;
    } 
  }
  
  public static void a(Context paramContext, t paramt, String paramString, a parama) {
    // Byte code:
    //   0: ldc com/loc/l
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 200
    //   7: aload_1
    //   8: ifnonnull -> 14
    //   11: goto -> 200
    //   14: getstatic com/loc/l.c : Landroid/content/Context;
    //   17: ifnonnull -> 27
    //   20: aload_0
    //   21: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   24: putstatic com/loc/l.c : Landroid/content/Context;
    //   27: aload_1
    //   28: invokevirtual a : ()Ljava/lang/String;
    //   31: astore_0
    //   32: aload_0
    //   33: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   36: istore #4
    //   38: iload #4
    //   40: ifeq -> 47
    //   43: ldc com/loc/l
    //   45: monitorexit
    //   46: return
    //   47: aload_1
    //   48: invokestatic a : (Lcom/loc/t;)V
    //   51: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   54: ifnonnull -> 69
    //   57: new java/util/concurrent/ConcurrentHashMap
    //   60: dup
    //   61: bipush #8
    //   63: invokespecial <init> : (I)V
    //   66: putstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   69: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   72: ifnonnull -> 87
    //   75: new java/util/concurrent/ConcurrentHashMap
    //   78: dup
    //   79: bipush #8
    //   81: invokespecial <init> : (I)V
    //   84: putstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   87: getstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   90: ifnonnull -> 105
    //   93: new java/util/concurrent/ConcurrentHashMap
    //   96: dup
    //   97: bipush #8
    //   99: invokespecial <init> : (I)V
    //   102: putstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   105: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   108: aload_0
    //   109: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   112: ifne -> 177
    //   115: new com/loc/l$d
    //   118: dup
    //   119: iconst_0
    //   120: invokespecial <init> : (B)V
    //   123: astore #7
    //   125: aload #7
    //   127: aload_1
    //   128: putfield a : Lcom/loc/t;
    //   131: aload #7
    //   133: aload_2
    //   134: putfield b : Ljava/lang/String;
    //   137: aload #7
    //   139: aload_3
    //   140: putfield c : Lcom/loc/l$a;
    //   143: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   146: aload_0
    //   147: aload #7
    //   149: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: pop
    //   153: getstatic com/loc/l.c : Landroid/content/Context;
    //   156: ldc 'open_common'
    //   158: aload_0
    //   159: invokestatic c : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)J
    //   162: lstore #5
    //   164: getstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   167: aload_0
    //   168: lload #5
    //   170: invokestatic valueOf : (J)Ljava/lang/Long;
    //   173: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: pop
    //   177: ldc com/loc/l
    //   179: monitorexit
    //   180: return
    //   181: astore_0
    //   182: aload_0
    //   183: ldc 'at'
    //   185: ldc 'rglc'
    //   187: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   190: ldc com/loc/l
    //   192: monitorexit
    //   193: return
    //   194: astore_0
    //   195: ldc com/loc/l
    //   197: monitorexit
    //   198: aload_0
    //   199: athrow
    //   200: ldc com/loc/l
    //   202: monitorexit
    //   203: return
    // Exception table:
    //   from	to	target	type
    //   14	27	181	finally
    //   27	38	181	finally
    //   47	69	181	finally
    //   69	87	181	finally
    //   87	105	181	finally
    //   105	177	181	finally
    //   182	190	194	finally
  }
  
  private static void a(Context paramContext, t paramt, String paramString, b paramb, JSONObject paramJSONObject) throws JSONException {
    b.a a = new b.a();
    a.a = false;
    a.b = false;
    paramb.g = a;
    try {
      String[] arrayOfString = paramString.split(";");
    } finally {
      paramString = null;
    } 
    if (u.a(paramJSONObject, "16H"))
      try {
        b.a(paramb, a(paramJSONObject.getJSONObject("16H").optString("able"), false));
      } finally {
        paramString = null;
      }  
    if (u.a(paramJSONObject, "11K"))
      try {
        JSONObject jSONObject = paramJSONObject.getJSONObject("11K");
        a.a = a(jSONObject.getString("able"), false);
        if (jSONObject.has("off"))
          a.c = jSONObject.getJSONObject("off"); 
      } finally {
        paramString = null;
      }  
    if (u.a(paramJSONObject, "145"))
      try {
        paramb.a = paramJSONObject.getJSONObject("145");
      } finally {
        paramString = null;
      }  
    if (u.a(paramJSONObject, "14D"))
      try {
        paramb.b = paramJSONObject.getJSONObject("14D");
      } finally {
        paramString = null;
      }  
    if (u.a(paramJSONObject, "151"))
      try {
        JSONObject jSONObject = paramJSONObject.getJSONObject("151");
        b.b b1 = new b.b();
        if (jSONObject != null)
          b1.a = a(jSONObject.optString("able"), false); 
      } finally {
        paramString = null;
      }  
    if (u.a(paramJSONObject, "17S"))
      try {
        JSONObject jSONObject = paramJSONObject.getJSONObject("17S");
      } finally {
        paramString = null;
      }  
    if (u.a(paramJSONObject, "15K"))
      try {
        JSONObject jSONObject = paramJSONObject.getJSONObject("15K");
      } finally {
        paramContext = null;
      }  
    if (u.a(paramJSONObject, "183"))
      try {
        return;
      } finally {
        paramContext = null;
      }  
  }
  
  private static void a(Context paramContext, t paramt, Throwable paramThrowable) {
    a(paramContext, paramt, paramThrowable.getMessage());
  }
  
  public static void a(Context paramContext, String paramString) {
    k.a(paramContext, paramString);
  }
  
  private static void a(t paramt) {
    if (paramt != null)
      try {
        if (TextUtils.isEmpty(paramt.a()))
          return; 
        String str2 = paramt.c();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = paramt.b(); 
        if (TextUtils.isEmpty(str1))
          return; 
        return;
      } finally {
        paramt = null;
      }  
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4) {
    // Byte code:
    //   0: ldc com/loc/l
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore #5
    //   9: iload #5
    //   11: ifeq -> 18
    //   14: ldc com/loc/l
    //   16: monitorexit
    //   17: return
    //   18: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   21: ifnonnull -> 36
    //   24: new java/util/concurrent/ConcurrentHashMap
    //   27: dup
    //   28: bipush #8
    //   30: invokespecial <init> : (I)V
    //   33: putstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   36: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_0
    //   40: invokestatic elapsedRealtime : ()J
    //   43: invokestatic valueOf : (J)Ljava/lang/Long;
    //   46: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   53: astore #6
    //   55: aload #6
    //   57: ifnonnull -> 64
    //   60: ldc com/loc/l
    //   62: monitorexit
    //   63: return
    //   64: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   67: aload_0
    //   68: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   71: istore #5
    //   73: iload #5
    //   75: ifne -> 82
    //   78: ldc com/loc/l
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   86: istore #5
    //   88: iload #5
    //   90: ifeq -> 97
    //   93: ldc com/loc/l
    //   95: monitorexit
    //   96: return
    //   97: iload_1
    //   98: ifeq -> 106
    //   101: iconst_1
    //   102: aload_0
    //   103: invokestatic a : (ZLjava/lang/String;)V
    //   106: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
    //   109: new com/loc/l$1
    //   112: dup
    //   113: aload_0
    //   114: aload_2
    //   115: aload_3
    //   116: aload #4
    //   118: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   121: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   126: pop
    //   127: ldc com/loc/l
    //   129: monitorexit
    //   130: return
    //   131: astore_0
    //   132: aload_0
    //   133: ldc 'at'
    //   135: ldc_w 'lca'
    //   138: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   141: ldc com/loc/l
    //   143: monitorexit
    //   144: return
    //   145: astore_0
    //   146: ldc com/loc/l
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
      int i = n.q(c);
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
        bb bb = new bb(c, "core", "1.0", "O002");
        bb.a(paramString);
        bc.a(bb, c);
        return;
      } catch (j j) {
        return;
      } 
    } 
  }
  
  public static boolean a() {
    // Byte code:
    //   0: getstatic com/loc/l.c : Landroid/content/Context;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnull -> 353
    //   8: aload_1
    //   9: ifnull -> 74
    //   12: aload_1
    //   13: invokestatic v : (Landroid/content/Context;)Ljava/lang/String;
    //   16: astore_1
    //   17: getstatic com/loc/l.h : Ljava/lang/String;
    //   20: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   23: ifne -> 60
    //   26: aload_1
    //   27: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   30: ifne -> 60
    //   33: getstatic com/loc/l.h : Ljava/lang/String;
    //   36: aload_1
    //   37: invokevirtual equals : (Ljava/lang/Object;)Z
    //   40: ifeq -> 60
    //   43: invokestatic currentTimeMillis : ()J
    //   46: getstatic com/loc/l.i : J
    //   49: lsub
    //   50: ldc2_w 60000
    //   53: lcmp
    //   54: ifge -> 60
    //   57: goto -> 337
    //   60: aload_1
    //   61: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   64: ifne -> 91
    //   67: aload_1
    //   68: putstatic com/loc/l.h : Ljava/lang/String;
    //   71: goto -> 91
    //   74: invokestatic currentTimeMillis : ()J
    //   77: getstatic com/loc/l.i : J
    //   80: lsub
    //   81: ldc2_w 10000
    //   84: lcmp
    //   85: ifge -> 91
    //   88: goto -> 337
    //   91: invokestatic currentTimeMillis : ()J
    //   94: putstatic com/loc/l.i : J
    //   97: getstatic com/loc/l.g : Ljava/util/Map;
    //   100: invokeinterface clear : ()V
    //   105: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   108: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   111: invokevirtual iterator : ()Ljava/util/Iterator;
    //   114: astore #4
    //   116: aload #4
    //   118: invokeinterface hasNext : ()Z
    //   123: ifeq -> 337
    //   126: aload #4
    //   128: invokeinterface next : ()Ljava/lang/Object;
    //   133: checkcast java/net/NetworkInterface
    //   136: astore_2
    //   137: aload_2
    //   138: invokevirtual getInterfaceAddresses : ()Ljava/util/List;
    //   141: invokeinterface isEmpty : ()Z
    //   146: ifne -> 116
    //   149: aload_2
    //   150: invokevirtual getDisplayName : ()Ljava/lang/String;
    //   153: astore_1
    //   154: aload_2
    //   155: invokevirtual getInterfaceAddresses : ()Ljava/util/List;
    //   158: invokeinterface iterator : ()Ljava/util/Iterator;
    //   163: astore_2
    //   164: iconst_0
    //   165: istore_0
    //   166: aload_2
    //   167: invokeinterface hasNext : ()Z
    //   172: ifeq -> 254
    //   175: aload_2
    //   176: invokeinterface next : ()Ljava/lang/Object;
    //   181: checkcast java/net/InterfaceAddress
    //   184: invokevirtual getAddress : ()Ljava/net/InetAddress;
    //   187: astore_3
    //   188: aload_3
    //   189: instanceof java/net/Inet6Address
    //   192: ifeq -> 212
    //   195: aload_3
    //   196: checkcast java/net/Inet6Address
    //   199: invokestatic a : (Ljava/net/InetAddress;)Z
    //   202: ifne -> 166
    //   205: iload_0
    //   206: iconst_2
    //   207: ior
    //   208: istore_0
    //   209: goto -> 166
    //   212: aload_3
    //   213: instanceof java/net/Inet4Address
    //   216: ifeq -> 166
    //   219: aload_3
    //   220: checkcast java/net/Inet4Address
    //   223: astore_3
    //   224: aload_3
    //   225: invokestatic a : (Ljava/net/InetAddress;)Z
    //   228: ifne -> 166
    //   231: aload_3
    //   232: invokevirtual getHostAddress : ()Ljava/lang/String;
    //   235: ldc_w 'FMTkyLjE2OC40My4'
    //   238: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   241: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   244: ifne -> 166
    //   247: iload_0
    //   248: iconst_1
    //   249: ior
    //   250: istore_0
    //   251: goto -> 166
    //   254: iload_0
    //   255: ifeq -> 116
    //   258: aload_1
    //   259: ifnull -> 297
    //   262: aload_1
    //   263: ldc_w 'wlan'
    //   266: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   269: ifeq -> 297
    //   272: getstatic com/loc/l.g : Ljava/util/Map;
    //   275: astore_1
    //   276: ldc_w 'WIFI'
    //   279: astore_2
    //   280: iload_0
    //   281: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   284: astore_3
    //   285: aload_1
    //   286: aload_2
    //   287: aload_3
    //   288: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: pop
    //   294: goto -> 116
    //   297: aload_1
    //   298: ifnull -> 116
    //   301: aload_1
    //   302: ldc_w 'rmnet'
    //   305: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   308: ifeq -> 116
    //   311: getstatic com/loc/l.g : Ljava/util/Map;
    //   314: astore_1
    //   315: ldc_w 'MOBILE'
    //   318: astore_2
    //   319: iload_0
    //   320: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   323: astore_3
    //   324: goto -> 285
    //   327: astore_1
    //   328: aload_1
    //   329: ldc 'at'
    //   331: ldc_w 'ipstack'
    //   334: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   337: invokestatic c : ()Z
    //   340: ifne -> 345
    //   343: iconst_0
    //   344: ireturn
    //   345: invokestatic b : ()Z
    //   348: ifeq -> 353
    //   351: iconst_1
    //   352: ireturn
    //   353: getstatic com/loc/l.e : Z
    //   356: ifne -> 361
    //   359: iconst_0
    //   360: ireturn
    //   361: getstatic com/loc/l.c : Landroid/content/Context;
    //   364: ldc 'IPV6_CONFIG_NAME'
    //   366: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Lcom/loc/l$e;
    //   369: astore_1
    //   370: aload_1
    //   371: ifnonnull -> 376
    //   374: iconst_0
    //   375: ireturn
    //   376: aload_1
    //   377: invokevirtual a : ()I
    //   380: iconst_5
    //   381: if_icmpge -> 386
    //   384: iconst_1
    //   385: ireturn
    //   386: iconst_0
    //   387: ireturn
    // Exception table:
    //   from	to	target	type
    //   12	57	327	finally
    //   60	71	327	finally
    //   74	88	327	finally
    //   91	116	327	finally
    //   116	164	327	finally
    //   166	205	327	finally
    //   212	247	327	finally
    //   262	276	327	finally
    //   280	285	327	finally
    //   285	294	327	finally
    //   301	315	327	finally
    //   319	324	327	finally
  }
  
  public static boolean a(String paramString) {
    // Byte code:
    //   0: ldc com/loc/l
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq -> 17
    //   12: ldc com/loc/l
    //   14: monitorexit
    //   15: iconst_0
    //   16: ireturn
    //   17: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull -> 30
    //   25: ldc com/loc/l
    //   27: monitorexit
    //   28: iconst_0
    //   29: ireturn
    //   30: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ifnonnull -> 48
    //   36: new java/util/concurrent/ConcurrentHashMap
    //   39: dup
    //   40: bipush #8
    //   42: invokespecial <init> : (I)V
    //   45: putstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   48: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   51: aload_0
    //   52: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   55: ifeq -> 97
    //   58: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   61: aload_0
    //   62: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   65: ifne -> 97
    //   68: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   71: aload_0
    //   72: invokestatic elapsedRealtime : ()J
    //   75: invokestatic valueOf : (J)Ljava/lang/Long;
    //   78: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: pop
    //   82: ldc com/loc/l
    //   84: monitorexit
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_0
    //   88: aload_0
    //   89: ldc 'at'
    //   91: ldc_w 'cslct'
    //   94: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   97: ldc com/loc/l
    //   99: monitorexit
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_0
    //   103: ldc com/loc/l
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
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/loc/l}} */
    boolean bool2 = false;
    try {
      bool1 = TextUtils.isEmpty(paramString);
      if (bool1)
        return false; 
      bool1 = bool2;
    } finally {
      paramString = null;
    } 
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/loc/l}} */
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
  
  private static b b(Context paramContext, t paramt, String paramString1, String paramString2, String paramString3, String paramString4) {
    // Byte code:
    //   0: new com/loc/l$b
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #12
    //   9: aload #12
    //   11: new org/json/JSONObject
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: putfield f : Lorg/json/JSONObject;
    //   21: getstatic com/loc/p$a.a : Lcom/loc/p;
    //   24: aload_0
    //   25: invokevirtual a : (Landroid/content/Context;)V
    //   28: aload_0
    //   29: invokestatic b : (Landroid/content/Context;)V
    //   32: aload_0
    //   33: ifnull -> 43
    //   36: aload_0
    //   37: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   40: putstatic com/loc/l.c : Landroid/content/Context;
    //   43: aconst_null
    //   44: astore #13
    //   46: aload_1
    //   47: invokestatic a : (Lcom/loc/t;)V
    //   50: new com/loc/aq
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
    //   111: goto -> 553
    //   114: astore_3
    //   115: goto -> 581
    //   118: aload #12
    //   120: astore #9
    //   122: new com/loc/l$c
    //   125: dup
    //   126: aload_0
    //   127: aload_1
    //   128: aload_2
    //   129: aload_3
    //   130: aload #4
    //   132: aload #5
    //   134: invokespecial <init> : (Landroid/content/Context;Lcom/loc/t;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   137: astore_3
    //   138: aload_3
    //   139: aload_3
    //   140: invokevirtual a : ()Z
    //   143: invokestatic a : (Lcom/loc/av;Z)Lcom/loc/aw;
    //   146: astore #4
    //   148: iload #7
    //   150: ifeq -> 156
    //   153: aload #9
    //   155: areturn
    //   156: aload #4
    //   158: ifnull -> 1124
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
    //   293: invokevirtual a : ()Ljava/lang/String;
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
    //   344: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
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
    //   522: goto -> 682
    //   525: astore #5
    //   527: aload #9
    //   529: astore_3
    //   530: goto -> 606
    //   533: astore #5
    //   535: aload #10
    //   537: astore_3
    //   538: goto -> 627
    //   541: astore #5
    //   543: aload #11
    //   545: astore_3
    //   546: goto -> 649
    //   549: astore_3
    //   550: goto -> 581
    //   553: new com/loc/j
    //   556: dup
    //   557: ldc_w '未知的错误'
    //   560: invokespecial <init> : (Ljava/lang/String;)V
    //   563: athrow
    //   564: astore #5
    //   566: goto -> 600
    //   569: astore #5
    //   571: goto -> 621
    //   574: astore #5
    //   576: goto -> 643
    //   579: astore #4
    //   581: aload_3
    //   582: athrow
    //   583: astore #5
    //   585: goto -> 600
    //   588: astore #5
    //   590: goto -> 621
    //   593: astore #5
    //   595: goto -> 643
    //   598: astore #5
    //   600: aconst_null
    //   601: astore #4
    //   603: aload #4
    //   605: astore_3
    //   606: aload #5
    //   608: ldc 'at'
    //   610: ldc_w 'lc'
    //   613: invokestatic b : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   616: goto -> 627
    //   619: astore #5
    //   621: aconst_null
    //   622: astore #4
    //   624: aload #4
    //   626: astore_3
    //   627: aload_0
    //   628: aload_1
    //   629: aload #5
    //   631: invokestatic a : (Landroid/content/Context;Lcom/loc/t;Ljava/lang/Throwable;)V
    //   634: aload #13
    //   636: astore #5
    //   638: goto -> 682
    //   641: astore #5
    //   643: aconst_null
    //   644: astore #4
    //   646: aload #4
    //   648: astore_3
    //   649: aload #12
    //   651: aload #5
    //   653: invokevirtual a : ()Ljava/lang/String;
    //   656: putfield c : Ljava/lang/String;
    //   659: aload_0
    //   660: aload_1
    //   661: aload #5
    //   663: invokevirtual a : ()Ljava/lang/String;
    //   666: invokestatic a : (Landroid/content/Context;Lcom/loc/t;Ljava/lang/String;)V
    //   669: aload_1
    //   670: ldc_w '/v3/iasdkauth'
    //   673: aload #5
    //   675: invokestatic a : (Lcom/loc/t;Ljava/lang/String;Lcom/loc/j;)V
    //   678: aload #13
    //   680: astore #5
    //   682: aload_3
    //   683: ifnonnull -> 689
    //   686: aload #12
    //   688: areturn
    //   689: aload #5
    //   691: astore #9
    //   693: aload #5
    //   695: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   698: ifeq -> 707
    //   701: aload_3
    //   702: invokestatic a : ([B)Ljava/lang/String;
    //   705: astore #9
    //   707: aload #9
    //   709: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   712: ifeq -> 723
    //   715: aload_0
    //   716: aload_1
    //   717: ldc_w 'result is null'
    //   720: invokestatic a : (Landroid/content/Context;Lcom/loc/t;Ljava/lang/String;)V
    //   723: new org/json/JSONObject
    //   726: dup
    //   727: aload #9
    //   729: invokespecial <init> : (Ljava/lang/String;)V
    //   732: astore #9
    //   734: aload #9
    //   736: ldc_w 'status'
    //   739: invokevirtual has : (Ljava/lang/String;)Z
    //   742: ifeq -> 1080
    //   745: aload #9
    //   747: ldc_w 'status'
    //   750: invokevirtual getInt : (Ljava/lang/String;)I
    //   753: istore #6
    //   755: iload #6
    //   757: iconst_1
    //   758: if_icmpne -> 768
    //   761: iconst_1
    //   762: putstatic com/loc/l.a : I
    //   765: goto -> 892
    //   768: iload #6
    //   770: ifne -> 892
    //   773: aload #4
    //   775: ifnull -> 1129
    //   778: aload #4
    //   780: getfield c : Ljava/lang/String;
    //   783: astore_3
    //   784: aload #4
    //   786: getfield d : Ljava/lang/String;
    //   789: astore #5
    //   791: aload_3
    //   792: astore #4
    //   794: aload #5
    //   796: astore_3
    //   797: goto -> 800
    //   800: aload_0
    //   801: aload #4
    //   803: aload_3
    //   804: aload #9
    //   806: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   809: iconst_0
    //   810: putstatic com/loc/l.a : I
    //   813: aload #9
    //   815: ldc_w 'info'
    //   818: invokevirtual has : (Ljava/lang/String;)Z
    //   821: ifeq -> 835
    //   824: aload #9
    //   826: ldc_w 'info'
    //   829: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   832: putstatic com/loc/l.b : Ljava/lang/String;
    //   835: ldc ''
    //   837: astore #5
    //   839: aload #9
    //   841: ldc_w 'infocode'
    //   844: invokevirtual has : (Ljava/lang/String;)Z
    //   847: ifeq -> 860
    //   850: aload #9
    //   852: ldc_w 'infocode'
    //   855: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   858: astore #5
    //   860: aload_1
    //   861: ldc_w '/v3/iasdkauth'
    //   864: getstatic com/loc/l.b : Ljava/lang/String;
    //   867: aload_3
    //   868: aload #4
    //   870: aload #5
    //   872: invokestatic a : (Lcom/loc/t;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   875: getstatic com/loc/l.a : I
    //   878: ifne -> 892
    //   881: aload #12
    //   883: getstatic com/loc/l.b : Ljava/lang/String;
    //   886: putfield c : Ljava/lang/String;
    //   889: aload #12
    //   891: areturn
    //   892: aload #9
    //   894: ldc_w 'ver'
    //   897: invokevirtual has : (Ljava/lang/String;)Z
    //   900: ifeq -> 929
    //   903: aload #12
    //   905: aload #9
    //   907: ldc_w 'ver'
    //   910: invokevirtual getInt : (Ljava/lang/String;)I
    //   913: putfield d : I
    //   916: goto -> 929
    //   919: astore_3
    //   920: aload_3
    //   921: ldc 'at'
    //   923: ldc_w 'lc'
    //   926: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload #9
    //   931: ldc_w 'result'
    //   934: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   937: ifeq -> 1080
    //   940: aload #9
    //   942: ldc_w 'result'
    //   945: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   948: astore_3
    //   949: aload_0
    //   950: aload_1
    //   951: aload_2
    //   952: aload #12
    //   954: aload_3
    //   955: invokestatic a : (Landroid/content/Context;Lcom/loc/t;Ljava/lang/String;Lcom/loc/l$b;Lorg/json/JSONObject;)V
    //   958: aload_3
    //   959: ldc_w '17I'
    //   962: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   965: ifeq -> 1012
    //   968: aload_3
    //   969: ldc_w '17I'
    //   972: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   975: astore_1
    //   976: aload_1
    //   977: ldc_w 'na'
    //   980: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   983: iconst_0
    //   984: invokestatic a : (Ljava/lang/String;Z)Z
    //   987: istore #7
    //   989: aload_1
    //   990: ldc_w 'aa'
    //   993: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   996: iconst_0
    //   997: invokestatic a : (Ljava/lang/String;Z)Z
    //   1000: istore #8
    //   1002: iload #7
    //   1004: putstatic com/loc/v.d : Z
    //   1007: iload #8
    //   1009: putstatic com/loc/v.e : Z
    //   1012: aload_3
    //   1013: ldc_w '15K'
    //   1016: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   1019: astore_1
    //   1020: aload_1
    //   1021: ldc_w 'isTargetAble'
    //   1024: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1027: iconst_0
    //   1028: invokestatic a : (Ljava/lang/String;Z)Z
    //   1031: istore #7
    //   1033: aload_1
    //   1034: ldc_w 'able'
    //   1037: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1040: iconst_0
    //   1041: invokestatic a : (Ljava/lang/String;Z)Z
    //   1044: ifne -> 1058
    //   1047: getstatic com/loc/p$a.a : Lcom/loc/p;
    //   1050: astore_1
    //   1051: aload_0
    //   1052: invokestatic b : (Landroid/content/Context;)V
    //   1055: aload #12
    //   1057: areturn
    //   1058: getstatic com/loc/p$a.a : Lcom/loc/p;
    //   1061: aload_0
    //   1062: iload #7
    //   1064: invokevirtual a : (Landroid/content/Context;Z)V
    //   1067: aload #12
    //   1069: areturn
    //   1070: astore_0
    //   1071: aload_0
    //   1072: ldc 'at'
    //   1074: ldc_w 'lc'
    //   1077: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1080: aload #12
    //   1082: areturn
    //   1083: astore_3
    //   1084: goto -> 111
    //   1087: astore_3
    //   1088: goto -> 111
    //   1091: astore_0
    //   1092: goto -> 111
    //   1095: astore_3
    //   1096: goto -> 553
    //   1099: astore_0
    //   1100: aload #12
    //   1102: areturn
    //   1103: astore #5
    //   1105: aconst_null
    //   1106: astore_3
    //   1107: goto -> 606
    //   1110: astore #5
    //   1112: aconst_null
    //   1113: astore_3
    //   1114: goto -> 627
    //   1117: astore #5
    //   1119: aconst_null
    //   1120: astore_3
    //   1121: goto -> 649
    //   1124: aconst_null
    //   1125: astore_3
    //   1126: goto -> 353
    //   1129: ldc_w 'authcsid'
    //   1132: astore #4
    //   1134: ldc_w 'authgsid'
    //   1137: astore_3
    //   1138: goto -> 800
    // Exception table:
    //   from	to	target	type
    //   46	64	641	com/loc/j
    //   46	64	619	javax/crypto/IllegalBlockSizeException
    //   46	64	598	finally
    //   69	78	114	com/loc/j
    //   69	78	1083	finally
    //   78	101	107	com/loc/j
    //   78	101	1087	finally
    //   122	148	549	com/loc/j
    //   122	148	1095	finally
    //   161	168	1117	com/loc/j
    //   161	168	1110	javax/crypto/IllegalBlockSizeException
    //   161	168	1103	finally
    //   168	175	325	finally
    //   186	214	325	finally
    //   225	248	325	finally
    //   251	272	325	finally
    //   282	298	325	finally
    //   301	319	325	finally
    //   338	347	541	com/loc/j
    //   338	347	533	javax/crypto/IllegalBlockSizeException
    //   338	347	525	finally
    //   362	368	541	com/loc/j
    //   362	368	533	javax/crypto/IllegalBlockSizeException
    //   362	368	525	finally
    //   377	386	541	com/loc/j
    //   377	386	533	javax/crypto/IllegalBlockSizeException
    //   377	386	525	finally
    //   395	405	541	com/loc/j
    //   395	405	533	javax/crypto/IllegalBlockSizeException
    //   395	405	525	finally
    //   414	428	541	com/loc/j
    //   414	428	533	javax/crypto/IllegalBlockSizeException
    //   414	428	525	finally
    //   437	454	541	com/loc/j
    //   437	454	533	javax/crypto/IllegalBlockSizeException
    //   437	454	525	finally
    //   463	474	541	com/loc/j
    //   463	474	533	javax/crypto/IllegalBlockSizeException
    //   463	474	525	finally
    //   483	501	541	com/loc/j
    //   483	501	533	javax/crypto/IllegalBlockSizeException
    //   483	501	525	finally
    //   510	522	541	com/loc/j
    //   510	522	533	javax/crypto/IllegalBlockSizeException
    //   510	522	525	finally
    //   553	564	574	com/loc/j
    //   553	564	569	javax/crypto/IllegalBlockSizeException
    //   553	564	564	finally
    //   581	583	593	com/loc/j
    //   581	583	588	javax/crypto/IllegalBlockSizeException
    //   581	583	583	finally
    //   723	755	1070	finally
    //   761	765	1070	finally
    //   778	791	1070	finally
    //   800	835	1070	finally
    //   839	860	1070	finally
    //   860	889	1070	finally
    //   892	916	919	finally
    //   920	929	1070	finally
    //   929	1012	1070	finally
    //   1012	1055	1099	finally
    //   1058	1067	1099	finally
  }
  
  private static e b(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/loc/l
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: ifne -> 63
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: getstatic com/loc/l.f : Ljava/util/Vector;
    //   16: invokevirtual size : ()I
    //   19: if_icmpge -> 63
    //   22: getstatic com/loc/l.f : Ljava/util/Vector;
    //   25: iload_2
    //   26: invokevirtual get : (I)Ljava/lang/Object;
    //   29: checkcast com/loc/l$e
    //   32: astore #4
    //   34: aload #4
    //   36: ifnull -> 56
    //   39: aload_1
    //   40: aload #4
    //   42: invokestatic c : (Lcom/loc/l$e;)Ljava/lang/String;
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
    //   71: ldc com/loc/l
    //   73: monitorexit
    //   74: aload #4
    //   76: areturn
    //   77: aload_0
    //   78: ifnonnull -> 86
    //   81: ldc com/loc/l
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    //   86: new com/loc/x
    //   89: dup
    //   90: aload_1
    //   91: invokespecial <init> : (Ljava/lang/String;)V
    //   94: aload_0
    //   95: ldc 'i'
    //   97: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   100: invokestatic b : (Ljava/lang/String;)Lcom/loc/l$e;
    //   103: astore_1
    //   104: invokestatic currentTimeMillis : ()J
    //   107: ldc 'yyyyMMdd'
    //   109: invokestatic a : (JLjava/lang/String;)Ljava/lang/String;
    //   112: astore #4
    //   114: aload_1
    //   115: astore_0
    //   116: aload_1
    //   117: ifnonnull -> 133
    //   120: new com/loc/l$e
    //   123: dup
    //   124: ldc 'IPV6_CONFIG_NAME'
    //   126: aload #4
    //   128: iconst_0
    //   129: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;I)V
    //   132: astore_0
    //   133: aload #4
    //   135: aload_0
    //   136: invokestatic a : (Lcom/loc/l$e;)Ljava/lang/String;
    //   139: invokevirtual equals : (Ljava/lang/Object;)Z
    //   142: ifne -> 159
    //   145: aload_0
    //   146: aload #4
    //   148: invokevirtual a : (Ljava/lang/String;)V
    //   151: aload_0
    //   152: invokestatic b : (Lcom/loc/l$e;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   155: iconst_0
    //   156: invokevirtual set : (I)V
    //   159: getstatic com/loc/l.f : Ljava/util/Vector;
    //   162: aload_0
    //   163: invokevirtual add : (Ljava/lang/Object;)Z
    //   166: pop
    //   167: ldc com/loc/l
    //   169: monitorexit
    //   170: aload_0
    //   171: areturn
    //   172: astore_0
    //   173: ldc com/loc/l
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
  
  public static void b(Context paramContext) {
    if (paramContext == null)
      return; 
    e = x.a(paramContext, "open_common", "a2", true);
  }
  
  public static void b(String paramString) {
    // Byte code:
    //   0: ldc com/loc/l
    //   2: monitorenter
    //   3: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull -> 15
    //   11: ldc com/loc/l
    //   13: monitorexit
    //   14: return
    //   15: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   18: aload_0
    //   19: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   22: ifeq -> 33
    //   25: getstatic com/loc/l.k : Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_0
    //   29: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: ldc com/loc/l
    //   35: monitorexit
    //   36: return
    //   37: astore_0
    //   38: ldc com/loc/l
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
    //   0: ldc com/loc/l
    //   2: monitorenter
    //   3: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: ifnull -> 81
    //   9: getstatic com/loc/l.l : Ljava/util/concurrent/ConcurrentHashMap;
    //   12: aload_0
    //   13: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   16: ifne -> 22
    //   19: goto -> 81
    //   22: getstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   25: ifnonnull -> 40
    //   28: new java/util/concurrent/ConcurrentHashMap
    //   31: dup
    //   32: bipush #8
    //   34: invokespecial <init> : (I)V
    //   37: putstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   40: getstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   43: aload_0
    //   44: lload_1
    //   45: invokestatic valueOf : (J)Ljava/lang/Long;
    //   48: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: getstatic com/loc/l.c : Landroid/content/Context;
    //   55: ifnull -> 77
    //   58: getstatic com/loc/l.c : Landroid/content/Context;
    //   61: ldc 'open_common'
    //   63: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   66: astore_3
    //   67: aload_3
    //   68: aload_0
    //   69: lload_1
    //   70: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;J)V
    //   73: aload_3
    //   74: invokestatic a : (Landroid/content/SharedPreferences$Editor;)V
    //   77: ldc com/loc/l
    //   79: monitorexit
    //   80: return
    //   81: ldc com/loc/l
    //   83: monitorexit
    //   84: return
    //   85: astore_0
    //   86: aload_0
    //   87: ldc 'at'
    //   89: ldc_w 'ucut'
    //   92: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   95: ldc com/loc/l
    //   97: monitorexit
    //   98: return
    //   99: astore_0
    //   100: ldc com/loc/l
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
    //   0: ldc com/loc/l
    //   2: monitorenter
    //   3: aload_0
    //   4: iload_1
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: invokestatic a : (Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11: ldc com/loc/l
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/loc/l
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
    String str = n.v(context);
    if (TextUtils.isEmpty(str))
      return false; 
    Integer integer = g.get(str.toUpperCase());
    return (integer == null) ? false : ((integer.intValue() == 2));
  }
  
  public static long c(String paramString) {
    // Byte code:
    //   0: ldc com/loc/l
    //   2: monitorenter
    //   3: getstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: ifnonnull -> 21
    //   9: new java/util/concurrent/ConcurrentHashMap
    //   12: dup
    //   13: bipush #8
    //   15: invokespecial <init> : (I)V
    //   18: putstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   21: getstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_0
    //   25: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   28: ifeq -> 60
    //   31: getstatic com/loc/l.j : Ljava/util/concurrent/ConcurrentHashMap;
    //   34: aload_0
    //   35: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast java/lang/Long
    //   41: invokevirtual longValue : ()J
    //   44: lstore_1
    //   45: ldc com/loc/l
    //   47: monitorexit
    //   48: lload_1
    //   49: lreturn
    //   50: astore_0
    //   51: aload_0
    //   52: ldc 'at'
    //   54: ldc_w 'glcut'
    //   57: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   60: ldc com/loc/l
    //   62: monitorexit
    //   63: lconst_0
    //   64: lreturn
    //   65: astore_0
    //   66: ldc com/loc/l
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	50	finally
    //   21	45	50	finally
    //   51	60	65	finally
  }
  
  public static boolean c() {
    Context context = c;
    if (context == null)
      return false; 
    String str = n.v(context);
    if (TextUtils.isEmpty(str))
      return false; 
    Integer integer = g.get(str.toUpperCase());
    return (integer == null) ? false : ((integer.intValue() >= 2));
  }
  
  public static void d() {
    if (d)
      return; 
    try {
      d = true;
      Context context = c;
      if (context == null)
        return; 
      p.a.a.a(c);
      b(c);
      f.a = x.a(context, "open_common", "ucf", f.a);
      f.b = x.a(context, "open_common", "fsv2", f.b);
      f.c = x.a(context, "open_common", "usc", f.c);
      f.d = x.a(context, "open_common", "umv", f.d);
      f.e = x.a(context, "open_common", "ust", f.e);
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static interface a {
    void a(l.b param1b);
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
  
  static final class c extends ar {
    private String f;
    
    private Map<String, String> g;
    
    private boolean h;
    
    private String i;
    
    private String j;
    
    private String k;
    
    c(Context param1Context, t param1t, String param1String1, String param1String2, String param1String3, String param1String4) {
      super(param1Context, param1t);
      boolean bool;
      this.f = param1String1;
      this.g = null;
      if (Build.VERSION.SDK_INT != 19) {
        bool = true;
      } else {
        bool = false;
      } 
      this.h = bool;
      this.i = param1String2;
      this.j = param1String3;
      this.k = param1String4;
    }
    
    public final boolean a() {
      return this.h;
    }
    
    public final byte[] a_() {
      return null;
    }
    
    public final Map<String, String> b() {
      if (!TextUtils.isEmpty(this.k)) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("host", this.k);
        return (Map)hashMap;
      } 
      return null;
    }
    
    public final String c() {
      String str1;
      if (this.h) {
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
    
    public final String d() {
      try {
        String str;
        if (this.h) {
          str = "https://restsdk.amap.com/v3/iasdkauth";
        } else {
          str = "http://restsdk.amap.com/v3/iasdkauth";
        } 
      } finally {
        Exception exception = null;
      } 
    }
    
    public final byte[] f() {
      String str2 = n.w(this.a);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
        str1 = r.a((new StringBuilder(str2)).reverse().toString()); 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      if (TextUtils.isEmpty(this.f)) {
        str2 = "";
      } else {
        str2 = this.f;
      } 
      hashMap.put("authkey", str2);
      hashMap.put("plattype", "android");
      hashMap.put("product", this.b.a());
      hashMap.put("version", this.b.b());
      hashMap.put("output", "json");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Build.VERSION.SDK_INT);
      hashMap.put("androidversion", stringBuilder.toString());
      hashMap.put("deviceId", str1);
      hashMap.put("manufacture", Build.MANUFACTURER);
      Map<String, String> map = this.g;
      if (map != null && !map.isEmpty())
        hashMap.putAll(this.g); 
      hashMap.put("abitype", u.a(this.a));
      hashMap.put("ext", this.b.d());
      return u.a(u.a((Map)hashMap));
    }
    
    protected final String g() {
      return "3.0";
    }
    
    protected final String h() {
      return !TextUtils.isEmpty(this.k) ? this.k : super.h();
    }
  }
  
  static final class d {
    t a;
    
    String b;
    
    l.a c;
    
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */