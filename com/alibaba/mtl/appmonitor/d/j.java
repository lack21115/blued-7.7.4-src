package com.alibaba.mtl.appmonitor.d;

import android.content.Context;
import com.alibaba.mtl.appmonitor.a.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class j {
  private static final String TAG;
  
  private static j a;
  
  private String A;
  
  private Map<f, g> q = new HashMap<f, g>();
  
  private int r;
  
  private j() {
    for (f f : f.a()) {
      if (f == f.a) {
        this.q.put(f, new f(f, f.e()));
      } else {
        this.q.put(f, new g(f, f.e()));
      } 
    } 
  }
  
  public static j a() {
    // Byte code:
    //   0: getstatic com/alibaba/mtl/appmonitor/d/j.a : Lcom/alibaba/mtl/appmonitor/d/j;
    //   3: ifnonnull -> 37
    //   6: ldc com/alibaba/mtl/appmonitor/d/j
    //   8: monitorenter
    //   9: getstatic com/alibaba/mtl/appmonitor/d/j.a : Lcom/alibaba/mtl/appmonitor/d/j;
    //   12: ifnonnull -> 25
    //   15: new com/alibaba/mtl/appmonitor/d/j
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/alibaba/mtl/appmonitor/d/j.a : Lcom/alibaba/mtl/appmonitor/d/j;
    //   25: ldc com/alibaba/mtl/appmonitor/d/j
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/alibaba/mtl/appmonitor/d/j
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/alibaba/mtl/appmonitor/d/j.a : Lcom/alibaba/mtl/appmonitor/d/j;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static boolean a(f paramf, String paramString1, String paramString2) {
    return a().b(paramf, paramString1, paramString2, (Map<String, String>)null);
  }
  
  public static boolean a(f paramf, String paramString1, String paramString2, Map<String, String> paramMap) {
    return a().b(paramf, paramString1, paramString2, paramMap);
  }
  
  public static boolean a(String paramString1, String paramString2, Boolean paramBoolean, Map<String, String> paramMap) {
    return a().b(paramString1, paramString2, paramBoolean, paramMap);
  }
  
  public void a(f paramf, int paramInt) {
    g g = this.q.get(paramf);
    if (g != null)
      g.setSampling(paramInt); 
  }
  
  public void b(String paramString) {
    // Byte code:
    //   0: ldc 'SampleRules'
    //   2: iconst_2
    //   3: anewarray java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: ldc 'config:'
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_1
    //   14: aastore
    //   15: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_1
    //   21: invokestatic isBlank : (Ljava/lang/String;)Z
    //   24: ifne -> 156
    //   27: aload_0
    //   28: getfield A : Ljava/lang/String;
    //   31: ifnull -> 48
    //   34: aload_0
    //   35: getfield A : Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual equals : (Ljava/lang/Object;)Z
    //   42: ifeq -> 48
    //   45: goto -> 156
    //   48: aload_0
    //   49: monitorexit
    //   50: new org/json/JSONObject
    //   53: dup
    //   54: aload_1
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: astore #4
    //   60: invokestatic a : ()[Lcom/alibaba/mtl/appmonitor/a/f;
    //   63: astore #5
    //   65: aload #5
    //   67: arraylength
    //   68: istore_3
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmpge -> 150
    //   76: aload #5
    //   78: iload_2
    //   79: aaload
    //   80: astore #6
    //   82: aload #4
    //   84: aload #6
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   92: astore #7
    //   94: aload_0
    //   95: getfield q : Ljava/util/Map;
    //   98: aload #6
    //   100: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   105: checkcast com/alibaba/mtl/appmonitor/d/g
    //   108: astore #8
    //   110: aload #7
    //   112: ifnull -> 166
    //   115: aload #8
    //   117: ifnull -> 166
    //   120: getstatic com/alibaba/mtl/appmonitor/d/j.TAG : Ljava/lang/String;
    //   123: iconst_2
    //   124: anewarray java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload #6
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload #7
    //   136: aastore
    //   137: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload #8
    //   142: aload #7
    //   144: invokevirtual b : (Lorg/json/JSONObject;)V
    //   147: goto -> 166
    //   150: aload_0
    //   151: aload_1
    //   152: putfield A : Ljava/lang/String;
    //   155: return
    //   156: aload_0
    //   157: monitorexit
    //   158: return
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: return
    //   166: iload_2
    //   167: iconst_1
    //   168: iadd
    //   169: istore_2
    //   170: goto -> 71
    // Exception table:
    //   from	to	target	type
    //   20	45	159	finally
    //   48	50	159	finally
    //   50	69	164	finally
    //   82	110	164	finally
    //   120	147	164	finally
    //   150	155	164	finally
    //   156	158	159	finally
    //   160	162	159	finally
  }
  
  public boolean b(f paramf, String paramString1, String paramString2, Map<String, String> paramMap) {
    g g = this.q.get(paramf);
    return (g != null) ? g.a(this.r, paramString1, paramString2, paramMap) : false;
  }
  
  public boolean b(String paramString1, String paramString2, Boolean paramBoolean, Map<String, String> paramMap) {
    g g = this.q.get(f.a);
    return (g != null && g instanceof f) ? ((f)g).a(this.r, paramString1, paramString2, paramBoolean, paramMap) : false;
  }
  
  public void init(Context paramContext) {
    k();
  }
  
  public void k() {
    this.r = (new Random(System.currentTimeMillis())).nextInt(10000);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */