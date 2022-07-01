package com.amap.api.col.s;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cu {
  public static volatile ConcurrentHashMap<String, c> a = new ConcurrentHashMap<String, c>(8);
  
  public static volatile List<String> b = Collections.synchronizedList(new ArrayList<String>(8));
  
  private static volatile ConcurrentHashMap<String, b> c = new ConcurrentHashMap<String, b>(8);
  
  private static Random d = new Random();
  
  private static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<String, String>(8);
  
  private static List<de> f = Collections.synchronizedList(new ArrayList<de>(16));
  
  public static cz a(String paramString1, String paramString2, String paramString3) {
    try {
      if (c == null)
        return null; 
      if (c.containsKey("app")) {
        b b = c.get("app");
        if (SystemClock.elapsedRealtime() <= b.b) {
          cz cz = b.a;
          if (cz != null)
            cz.e = false; 
          return cz;
        } 
        return null;
      } 
      if (!TextUtils.isEmpty(paramString1))
        paramString2 = paramString1; 
      if (TextUtils.isEmpty(paramString2))
        return null; 
      Uri uri = Uri.parse(paramString2);
      return null;
    } finally {
      paramString1 = null;
    } 
  }
  
  public static String a(String paramString1, String paramString2) throws bh {
    // Byte code:
    //   0: ldc com/amap/api/col/s/cu
    //   2: monitorenter
    //   3: invokestatic currentTimeMillis : ()J
    //   6: pop2
    //   7: aload_1
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: ifne -> 210
    //   14: aload_0
    //   15: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   18: ifeq -> 24
    //   21: goto -> 210
    //   24: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   27: astore_3
    //   28: getstatic com/amap/api/col/s/cu.b : Ljava/util/List;
    //   31: ifnonnull -> 241
    //   34: new java/util/ArrayList
    //   37: dup
    //   38: bipush #8
    //   40: invokespecial <init> : (I)V
    //   43: invokestatic synchronizedList : (Ljava/util/List;)Ljava/util/List;
    //   46: putstatic com/amap/api/col/s/cu.b : Ljava/util/List;
    //   49: goto -> 241
    //   52: getstatic com/amap/api/col/s/cu.b : Ljava/util/List;
    //   55: aload_1
    //   56: invokeinterface contains : (Ljava/lang/Object;)Z
    //   61: ifeq -> 67
    //   64: goto -> 119
    //   67: getstatic com/amap/api/col/s/cu.b : Ljava/util/List;
    //   70: aload_1
    //   71: invokeinterface add : (Ljava/lang/Object;)Z
    //   76: pop
    //   77: aload_3
    //   78: ldc 'Yb3Blbl9odHRwX2NvbnRyb2w'
    //   80: aload_1
    //   81: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_3
    //   85: aload_3
    //   86: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   89: ifeq -> 95
    //   92: goto -> 119
    //   95: aload_1
    //   96: new org/json/JSONObject
    //   99: dup
    //   100: aload_3
    //   101: invokespecial <init> : (Ljava/lang/String;)V
    //   104: invokestatic a : (Ljava/lang/String;Lorg/json/JSONObject;)V
    //   107: goto -> 119
    //   110: astore_3
    //   111: aload_3
    //   112: ldc 'hlUtil'
    //   114: ldc 'llhl'
    //   116: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   119: getstatic com/amap/api/col/s/cu.a : Ljava/util/concurrent/ConcurrentHashMap;
    //   122: ifnull -> 205
    //   125: getstatic com/amap/api/col/s/cu.a : Ljava/util/concurrent/ConcurrentHashMap;
    //   128: invokevirtual size : ()I
    //   131: ifgt -> 137
    //   134: goto -> 205
    //   137: getstatic com/amap/api/col/s/cu.a : Ljava/util/concurrent/ConcurrentHashMap;
    //   140: aload_1
    //   141: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   144: istore_2
    //   145: iload_2
    //   146: ifne -> 154
    //   149: ldc com/amap/api/col/s/cu
    //   151: monitorexit
    //   152: aload_0
    //   153: areturn
    //   154: getstatic com/amap/api/col/s/cu.a : Ljava/util/concurrent/ConcurrentHashMap;
    //   157: aload_1
    //   158: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   161: checkcast com/amap/api/col/s/cu$c
    //   164: astore_3
    //   165: aload_3
    //   166: ifnonnull -> 174
    //   169: ldc com/amap/api/col/s/cu
    //   171: monitorexit
    //   172: aload_0
    //   173: areturn
    //   174: aload_0
    //   175: aload_3
    //   176: aload_1
    //   177: invokestatic a : (Ljava/lang/String;Lcom/amap/api/col/s/cu$c;Ljava/lang/String;)Z
    //   180: ifne -> 195
    //   183: aload_0
    //   184: aload_3
    //   185: aload_1
    //   186: invokestatic b : (Ljava/lang/String;Lcom/amap/api/col/s/cu$c;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore_1
    //   190: ldc com/amap/api/col/s/cu
    //   192: monitorexit
    //   193: aload_1
    //   194: areturn
    //   195: new com/amap/api/col/s/bh
    //   198: dup
    //   199: ldc '服务QPS超限'
    //   201: invokespecial <init> : (Ljava/lang/String;)V
    //   204: athrow
    //   205: ldc com/amap/api/col/s/cu
    //   207: monitorexit
    //   208: aload_0
    //   209: areturn
    //   210: ldc com/amap/api/col/s/cu
    //   212: monitorexit
    //   213: aload_0
    //   214: areturn
    //   215: astore_1
    //   216: aload_1
    //   217: ldc 'hlUtil'
    //   219: ldc 'pcr'
    //   221: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   224: ldc com/amap/api/col/s/cu
    //   226: monitorexit
    //   227: aload_0
    //   228: areturn
    //   229: astore_0
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: aload_0
    //   234: athrow
    //   235: astore_0
    //   236: ldc com/amap/api/col/s/cu
    //   238: monitorexit
    //   239: aload_0
    //   240: athrow
    //   241: aload_3
    //   242: ifnonnull -> 52
    //   245: goto -> 119
    // Exception table:
    //   from	to	target	type
    //   3	21	229	com/amap/api/col/s/bh
    //   3	21	215	finally
    //   24	28	229	com/amap/api/col/s/bh
    //   24	28	215	finally
    //   28	49	110	finally
    //   52	64	110	finally
    //   67	92	110	finally
    //   95	107	110	finally
    //   111	119	229	com/amap/api/col/s/bh
    //   111	119	215	finally
    //   119	134	229	com/amap/api/col/s/bh
    //   119	134	215	finally
    //   137	145	229	com/amap/api/col/s/bh
    //   137	145	215	finally
    //   154	165	229	com/amap/api/col/s/bh
    //   154	165	215	finally
    //   174	190	229	com/amap/api/col/s/bh
    //   174	190	215	finally
    //   195	205	229	com/amap/api/col/s/bh
    //   195	205	215	finally
    //   216	224	232	finally
    //   230	232	232	finally
    //   233	235	235	finally
  }
  
  public static void a() {
    try {
      Context context = bj.c;
      if (context == null)
        return; 
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void a(br parambr, JSONObject paramJSONObject) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/cu
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull -> 11
    //   7: ldc com/amap/api/col/s/cu
    //   9: monitorexit
    //   10: return
    //   11: aload_0
    //   12: invokevirtual b : ()Ljava/lang/String;
    //   15: astore_0
    //   16: aload_0
    //   17: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   20: istore_2
    //   21: iload_2
    //   22: ifeq -> 29
    //   25: ldc com/amap/api/col/s/cu
    //   27: monitorexit
    //   28: return
    //   29: aload_1
    //   30: ifnonnull -> 37
    //   33: aload_0
    //   34: invokestatic a : (Ljava/lang/String;)V
    //   37: aload_1
    //   38: ldc 'able'
    //   40: aconst_null
    //   41: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   44: iconst_0
    //   45: invokestatic a : (Ljava/lang/String;Z)Z
    //   48: ifne -> 59
    //   51: aload_0
    //   52: invokestatic a : (Ljava/lang/String;)V
    //   55: ldc com/amap/api/col/s/cu
    //   57: monitorexit
    //   58: return
    //   59: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   62: ldc 'Yb3Blbl9odHRwX2NvbnRyb2w'
    //   64: aload_0
    //   65: aload_1
    //   66: invokevirtual toString : ()Ljava/lang/String;
    //   69: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: aload_1
    //   74: invokestatic a : (Ljava/lang/String;Lorg/json/JSONObject;)V
    //   77: ldc com/amap/api/col/s/cu
    //   79: monitorexit
    //   80: return
    //   81: astore_0
    //   82: aload_0
    //   83: ldc 'hlUtil'
    //   85: ldc 'par'
    //   87: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   90: ldc com/amap/api/col/s/cu
    //   92: monitorexit
    //   93: return
    //   94: astore_0
    //   95: ldc com/amap/api/col/s/cu
    //   97: monitorexit
    //   98: aload_0
    //   99: athrow
    // Exception table:
    //   from	to	target	type
    //   11	21	81	finally
    //   33	37	81	finally
    //   37	55	81	finally
    //   59	77	81	finally
    //   82	90	94	finally
  }
  
  private static void a(c paramc, JSONObject paramJSONObject) {
    try {
      int i;
      JSONArray jSONArray = paramJSONObject.optJSONArray("block");
      if (jSONArray == null)
        return; 
    } finally {
      paramc = null;
      cd.a((Throwable)paramc, "hlUtil", "pbr");
    } 
  }
  
  private static void a(String paramString) {
    // Byte code:
    //   0: ldc com/amap/api/col/s/cu
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/cu.a : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_0
    //   7: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   10: ifeq -> 21
    //   13: getstatic com/amap/api/col/s/cu.a : Ljava/util/concurrent/ConcurrentHashMap;
    //   16: aload_0
    //   17: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   20: pop
    //   21: getstatic com/amap/api/col/s/bj.c : Landroid/content/Context;
    //   24: ldc 'Yb3Blbl9odHRwX2NvbnRyb2w'
    //   26: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   29: astore_1
    //   30: aload_1
    //   31: aload_0
    //   32: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;)V
    //   35: aload_1
    //   36: invokestatic a : (Landroid/content/SharedPreferences$Editor;)V
    //   39: ldc com/amap/api/col/s/cu
    //   41: monitorexit
    //   42: return
    //   43: astore_0
    //   44: aload_0
    //   45: ldc 'hlUtil'
    //   47: ldc_w 'rc'
    //   50: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   53: ldc com/amap/api/col/s/cu
    //   55: monitorexit
    //   56: return
    //   57: astore_0
    //   58: ldc com/amap/api/col/s/cu
    //   60: monitorexit
    //   61: aload_0
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	43	finally
    //   21	39	43	finally
    //   44	53	57	finally
  }
  
  private static void a(String paramString, c paramc) {
    try {
      return;
    } finally {
      paramString = null;
      cd.a((Throwable)paramString, "hlUtil", "ucr");
    } 
  }
  
  private static void a(String paramString, JSONObject paramJSONObject) {
    try {
      c c = new c((byte)0);
      a(c, paramJSONObject);
      b(c, paramJSONObject);
      if (c.b == null && c.a == null)
        return; 
      return;
    } finally {
      paramString = null;
    } 
  }
  
  public static void a(URL paramURL, cz paramcz) {
    try {
      if (c == null)
        c = new ConcurrentHashMap<String, b>(8); 
      return;
    } finally {
      paramURL = null;
    } 
  }
  
  public static void a(boolean paramBoolean, String paramString) {
    try {
      Context context = bj.c;
      return;
    } finally {
      paramString = null;
    } 
  }
  
  private static void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {
    try {
      Context context = bj.c;
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  private static boolean a(a parama) {
    if (parama == null)
      return false; 
    if (parama.c == 1.0D)
      return false; 
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(parama.a) && parama.b > 0) {
      long l1 = l - bs.a(parama.a, "HH:mm:ss").getTimeInMillis();
      if (l1 > 0L && l1 < (parama.b * 1000)) {
        if (parama.c == 0.0D)
          return true; 
        if (d == null)
          d = new Random(); 
        d.setSeed(UUID.randomUUID().hashCode() + l);
        if (d.nextDouble() > parama.c)
          return true; 
      } 
    } 
    return false;
  }
  
  private static boolean a(String paramString1, c paramc, String paramString2) {
    try {
      Map<String, List<a>> map = paramc.a;
    } finally {
      paramString1 = null;
    } 
    return false;
  }
  
  private static boolean a(List<a> paramList) {
    if (paramList != null) {
      if (paramList.size() <= 0)
        return false; 
      Iterator<a> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        if (a(iterator.next()))
          return true; 
      } 
    } 
    return false;
  }
  
  private static String b(String paramString1, c paramc, String paramString2) {
    String str1;
    String str2 = paramString1;
    try {
    
    } finally {
      paramString1 = null;
      cd.a((Throwable)paramString1, "hlUtil", "pdr");
    } 
    return str1;
  }
  
  private static List<de> b() {
    ArrayList<de> arrayList1 = null;
    ArrayList<de> arrayList4 = null;
    ArrayList<de> arrayList3 = null;
    ArrayList<de> arrayList2 = arrayList1;
    try {
      List<de> list = f;
      arrayList2 = arrayList1;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/List<ObjectType{com/amap/api/col/s/de}>}, name=null} */
      arrayList2 = arrayList3;
      arrayList1 = arrayList4;
      try {
        return arrayList2;
      } finally {
        arrayList3 = null;
        arrayList2 = arrayList1;
        arrayList1 = arrayList2;
      } 
      throw arrayList3;
    } finally {
      arrayList1 = null;
    } 
  }
  
  private static void b(c paramc, JSONObject paramJSONObject) {
    try {
      int i;
      paramJSONObject = paramJSONObject.optJSONObject("domainMap");
      if (paramJSONObject == null)
        return; 
      JSONArray jSONArray = paramJSONObject.names();
      if (jSONArray == null)
        return; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(8);
      int j = jSONArray.length();
      return;
    } finally {
      paramc = null;
      cd.a((Throwable)paramc, "hlUtil", "pdr");
    } 
  }
  
  private static void b(String paramString1, String paramString2, String paramString3) {
    try {
      Context context = bj.c;
      return;
    } finally {
      paramString1 = null;
    } 
  }
  
  static final class a {
    String a;
    
    int b;
    
    double c;
    
    private a() {}
  }
  
  static final class b {
    cz a;
    
    long b;
    
    private b() {}
  }
  
  static final class c {
    Map<String, List<cu.a>> a = new HashMap<String, List<cu.a>>(8);
    
    Map<String, String> b = new HashMap<String, String>(8);
    
    private c() {}
    
    public final boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        if (this.a.equals(((c)param1Object).a) && this.b.equals(((c)param1Object).b))
          return true; 
      } 
      return false;
    }
    
    public final int hashCode() {
      byte b;
      Map<String, List<cu.a>> map1 = this.a;
      int i = 0;
      if (map1 != null) {
        b = map1.hashCode();
      } else {
        b = 0;
      } 
      Map<String, String> map = this.b;
      if (map != null)
        i = map.hashCode(); 
      return b + i;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */