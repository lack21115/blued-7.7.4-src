package com.pgl.sys.ces;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.pgl.a.a.a;
import com.pgl.a.b.f;
import com.pgl.sys.a.a;
import com.pgl.sys.a.a.a;
import com.pgl.sys.ces.a.b;
import com.pgl.sys.ces.a.c;
import com.pgl.sys.ces.a.d;
import com.pgl.sys.ces.a.e;
import com.pgl.sys.ces.a.f;
import com.pgl.sys.ces.b.a;
import com.pgl.sys.ces.out.ISdkLite;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b extends Thread implements ISdkLite {
  public static boolean g = false;
  
  public static boolean h = false;
  
  private static volatile b i;
  
  private static boolean j = false;
  
  private static boolean l = false;
  
  private static Map<String, Object> m;
  
  public boolean a = false;
  
  public Context b = null;
  
  public String c = "";
  
  public String d = "";
  
  public String e = "";
  
  public String f = "";
  
  private boolean k = false;
  
  private b(Context paramContext, String paramString) {
    setName("CZL-00");
    this.b = paramContext;
    this.c = paramString;
  }
  
  public static b a() {
    return i;
  }
  
  public static b a(Context paramContext, String paramString, int paramInt) {
    // Byte code:
    //   0: getstatic com/pgl/sys/ces/b.i : Lcom/pgl/sys/ces/b;
    //   3: ifnonnull -> 78
    //   6: ldc com/pgl/sys/ces/b
    //   8: monitorenter
    //   9: aload_0
    //   10: astore_3
    //   11: getstatic com/pgl/sys/ces/b.i : Lcom/pgl/sys/ces/b;
    //   14: ifnonnull -> 51
    //   17: aload_0
    //   18: astore_3
    //   19: aload_0
    //   20: ifnonnull -> 30
    //   23: invokestatic a : ()Landroid/app/Application;
    //   26: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull -> 39
    //   34: ldc com/pgl/sys/ces/b
    //   36: monitorexit
    //   37: aconst_null
    //   38: areturn
    //   39: new com/pgl/sys/ces/b
    //   42: dup
    //   43: aload_3
    //   44: aload_1
    //   45: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   48: putstatic com/pgl/sys/ces/b.i : Lcom/pgl/sys/ces/b;
    //   51: iload_2
    //   52: invokestatic a : (I)V
    //   55: aload_3
    //   56: ldc 'nms'
    //   58: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   61: pop
    //   62: aload_3
    //   63: invokestatic a : (Landroid/content/Context;)V
    //   66: ldc com/pgl/sys/ces/b
    //   68: monitorexit
    //   69: goto -> 78
    //   72: astore_0
    //   73: ldc com/pgl/sys/ces/b
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    //   78: getstatic com/pgl/sys/ces/b.i : Lcom/pgl/sys/ces/b;
    //   81: areturn
    // Exception table:
    //   from	to	target	type
    //   11	17	72	finally
    //   23	30	72	finally
    //   34	37	72	finally
    //   39	51	72	finally
    //   51	69	72	finally
    //   73	76	72	finally
  }
  
  private static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/pgl/sys/ces/b
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull -> 271
    //   7: getstatic com/pgl/sys/ces/b.j : Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifne -> 271
    //   15: bipush #101
    //   17: aconst_null
    //   18: ldc '0'
    //   20: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: new java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: astore_2
    //   32: aload_2
    //   33: ldc ''
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_2
    //   40: invokestatic b : ()Ljava/lang/String;
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: sipush #1020
    //   50: aconst_null
    //   51: aload_2
    //   52: invokevirtual toString : ()Ljava/lang/String;
    //   55: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: new java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: astore_2
    //   67: aload_2
    //   68: ldc ''
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_2
    //   75: aload_0
    //   76: invokestatic b : (Landroid/content/Context;)I
    //   79: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: bipush #105
    //   85: aconst_null
    //   86: aload_2
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: new java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: astore_2
    //   102: aload_2
    //   103: ldc ''
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_2
    //   110: aload_0
    //   111: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: bipush #106
    //   120: aconst_null
    //   121: aload_2
    //   122: invokevirtual toString : ()Ljava/lang/String;
    //   125: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: new java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial <init> : ()V
    //   136: astore_2
    //   137: aload_2
    //   138: ldc ''
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_2
    //   145: aload_0
    //   146: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: bipush #107
    //   155: aconst_null
    //   156: aload_2
    //   157: invokevirtual toString : ()Ljava/lang/String;
    //   160: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: new java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial <init> : ()V
    //   171: astore_2
    //   172: aload_2
    //   173: ldc ''
    //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: aload_0
    //   181: invokestatic d : (Landroid/content/Context;)Ljava/lang/String;
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: bipush #108
    //   190: aconst_null
    //   191: aload_2
    //   192: invokevirtual toString : ()Ljava/lang/String;
    //   195: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: new java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial <init> : ()V
    //   206: astore_0
    //   207: aload_0
    //   208: ldc ''
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_0
    //   215: invokestatic b : ()Ljava/lang/String;
    //   218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: bipush #109
    //   224: aconst_null
    //   225: aload_0
    //   226: invokevirtual toString : ()Ljava/lang/String;
    //   229: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: new java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: astore_0
    //   241: aload_0
    //   242: ldc ''
    //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_0
    //   249: invokestatic c : ()Ljava/lang/String;
    //   252: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: bipush #110
    //   258: aconst_null
    //   259: aload_0
    //   260: invokevirtual toString : ()Ljava/lang/String;
    //   263: invokestatic meta : (ILandroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: iconst_1
    //   268: putstatic com/pgl/sys/ces/b.j : Z
    //   271: ldc com/pgl/sys/ces/b
    //   273: monitorexit
    //   274: return
    //   275: astore_0
    //   276: ldc com/pgl/sys/ces/b
    //   278: monitorexit
    //   279: aload_0
    //   280: athrow
    //   281: astore_0
    //   282: goto -> 271
    // Exception table:
    //   from	to	target	type
    //   7	11	275	finally
    //   15	271	281	finally
    //   271	274	275	finally
    //   276	279	275	finally
  }
  
  private void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CZL-");
    stringBuilder.append(paramString);
    (new Thread(this, stringBuilder.toString()) {
        public void run() {
          d.a = 0;
          d.a(this.a.b);
        }
      }).start();
  }
  
  public static String b() {
    return (a()).c;
  }
  
  public static String c() {
    return (a()).e;
  }
  
  public static String d() {
    return (a()).d;
  }
  
  private boolean e() {
    return this.k;
  }
  
  private void f() {
    a.a(this.b, b(), new a(this) {
          public void a(String param1String) {
            b.a(true);
          }
        });
  }
  
  private boolean g() {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)this.b.getSystemService("connectivity");
      if (connectivityManager != null) {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
          boolean bool = networkInfo.isConnected();
          if (bool)
            return true; 
        } else {
          return true;
        } 
      } 
    } finally {
      Exception exception;
    } 
    return false;
  }
  
  public void SetRegionType(int paramInt) {
    a.a(paramInt);
  }
  
  public Object a(int paramInt, Object paramObject) {
    Object object = null;
    if (paramInt == 123)
      return e.a(this.b); 
    if (paramInt == 121)
      return c.c(this.b); 
    if (paramInt == 122)
      return c.a(); 
    if (paramInt == 126)
      return c.d(this.b); 
    if (paramInt == 127)
      return c.a(this.b); 
    if (paramInt == 128)
      return c.b(this.b); 
    if (paramInt == 120)
      return b.a(); 
    if (paramInt == 124)
      return f.b(this.b); 
    if (paramInt == 130)
      return f.a(this.b); 
    if (paramInt == 125)
      return f.c(this.b); 
    if (paramInt == 129)
      return d.a(this.b); 
    if (paramInt == 131)
      return a.a(); 
    if (paramInt == 132) {
      reportNow((String)paramObject);
      return null;
    } 
    if (paramInt == 134)
      return a.a(this.b).a(); 
    if (paramInt == 133) {
      try {
        paramObject = new JSONObject();
        for (Map.Entry<String, Object> entry : m.entrySet()) {
          if (entry.getValue() == null) {
            paramObject.put((String)entry.getKey(), "");
            continue;
          } 
          paramObject.put((String)entry.getKey(), entry.getValue());
        } 
      } finally {
        paramObject = null;
      } 
      if (paramObject == null) {
        paramObject = "{}";
      } else {
        paramObject = ((String)paramObject).trim();
      } 
      return paramObject;
    } 
    if (paramInt == 135) {
      paramObject = c.a();
      return (paramObject == null) ? "0000000000000000000000000000000000000000" : ((String)paramObject).trim();
    } 
    if (paramInt == 136)
      try {
        return (this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64)).signatures[0].toByteArray();
      } finally {
        paramObject = null;
      }  
    return null;
  }
  
  public String debugEntry(Context paramContext, int paramInt) {
    return (String)a.meta(1024768, null, null);
  }
  
  public String onEvent() {
    return a.a();
  }
  
  public String pullSg() {
    return c.a();
  }
  
  public String pullVer(String paramString) {
    return c.a(paramString);
  }
  
  public void reportNow(String paramString) {
    try {
      return;
    } finally {
      paramString = null;
      paramString.printStackTrace();
    } 
  }
  
  public void run() {
    this.k = true;
    f.a(60000L);
    reportNow("CZL-L1st");
    while (true) {
      f.a(7200000L);
      if (g()) {
        reportNow("CZL-LLP");
        f.a(60000L);
        a("CZL-LSP");
      } 
    } 
  }
  
  public void setCustomInfo(HashMap<String, Object> paramHashMap) {
    if (paramHashMap != null)
      m = paramHashMap; 
  }
  
  public void setEfficientDebug(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void setParams(String paramString1, String paramString2) {
    if (paramString1 != null && paramString1.length() > 0) {
      this.e = paramString1;
      a.meta(103, null, paramString1);
    } 
    if (paramString2 != null && paramString2.length() > 0) {
      this.f = paramString2;
      a.meta(104, null, paramString2);
    } 
    a("SP1");
    f();
    if (!isAlive() || !e())
      try {
        return;
      } finally {
        paramString1 = null;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */