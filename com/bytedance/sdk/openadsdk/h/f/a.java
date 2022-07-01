package com.bytedance.sdk.openadsdk.h.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.h.e;
import com.bytedance.sdk.openadsdk.h.f;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class a {
  public static final boolean a = t.c();
  
  private HashMap<String, Boolean> b = new HashMap<String, Boolean>();
  
  private a c;
  
  private a() {
    b();
  }
  
  public static a a() {
    return b.a();
  }
  
  private static c c() {
    IOException iOException;
    boolean bool = com.bytedance.sdk.openadsdk.h.g.a.d();
    File file = null;
    Object object = null;
    if (bool) {
      file = new File(com.bytedance.sdk.openadsdk.h.g.a.a(com.bytedance.sdk.openadsdk.h.g.a.b(), "cache").getPath());
      if (!file.exists())
        file.mkdirs(); 
      try {
        c c = new c(file);
        try {
          c.a(104857600L);
          return c;
        } catch (IOException iOException1) {}
      } catch (IOException iOException2) {
        iOException = iOException1;
        iOException1 = iOException2;
      } 
      iOException1.printStackTrace();
    } 
    return (c)iOException;
  }
  
  public boolean a(b paramb) {
    if (b()) {
      this.c.a(paramb);
      return true;
    } 
    return false;
  }
  
  public String b(b paramb) {
    String str;
    if (paramb == null)
      return null; 
    int i = TextUtils.isEmpty(paramb.c) ^ true;
    if (i != 0) {
      str = paramb.c;
    } else {
      str = paramb.a;
    } 
    return f.a().a(false, i, str, new String[] { paramb.a });
  }
  
  public boolean b() {
    if (this.c != null)
      return true; 
    c c = c();
    if (c == null)
      return false; 
    e.a(true);
    e.b(true);
    e.a(1);
    f.a().d();
    try {
      this.c = new a(this);
      this.c.start();
      e.a(c, o.a());
      d.c().a(30000L, 30000L, 30000L);
      d.c().a(10485759);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  class a extends Thread {
    private Queue<a> b = new LinkedBlockingQueue<a>();
    
    private boolean c = true;
    
    private final Queue<a> d = new ArrayBlockingQueue<a>(10);
    
    private Queue<a> e = new LinkedBlockingQueue<a>();
    
    public a(a this$0) {}
    
    private a a(int param1Int, b param1b) {
      b();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pool: ");
      stringBuilder.append(this.d.size());
      t.b("VideoCachePreloader", stringBuilder.toString());
      a a2 = this.d.poll();
      a a1 = a2;
      if (a2 == null)
        a1 = new a(this); 
      a1.a = param1Int;
      a1.f = param1b;
      return a1;
    }
    
    private void a() {}
    
    private void a(a param1a) {
      a();
      param1a.c = null;
      param1a.b = null;
      param1a.a = -1;
      param1a.f = null;
      this.d.offer(param1a);
    }
    
    private void b() {}
    
    private void b(a param1a) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial b : ()V
      //   6: aload_0
      //   7: getfield e : Ljava/util/Queue;
      //   10: aload_1
      //   11: invokeinterface add : (Ljava/lang/Object;)Z
      //   16: pop
      //   17: aload_0
      //   18: invokevirtual notify : ()V
      //   21: aload_0
      //   22: monitorexit
      //   23: return
      //   24: astore_1
      //   25: aload_0
      //   26: monitorexit
      //   27: aload_1
      //   28: athrow
      // Exception table:
      //   from	to	target	type
      //   2	21	24	finally
    }
    
    private void c() {
      a();
      while (true) {
        a a1 = this.e.poll();
        if (a1 != null) {
          a1.b = a1.f.a;
          a1.c = new String[] { a1.f.a };
          a1.d = a1.f.b;
          a1.e = a1.f.c;
          if (!TextUtils.isEmpty(a1.f.c))
            a1.b = a1.f.c; 
          a1.f = null;
          c(a1);
          continue;
        } 
        break;
      } 
    }
    
    private void c(a param1a) {
      a();
      if (param1a == null)
        return; 
      this.b.offer(param1a);
      notify();
    }
    
    public void a(b param1b) {
      b(a(0, param1b));
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield c : Z
      //   4: ifeq -> 320
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield e : Ljava/util/Queue;
      //   13: invokeinterface isEmpty : ()Z
      //   18: ifne -> 25
      //   21: aload_0
      //   22: invokespecial c : ()V
      //   25: aload_0
      //   26: getfield b : Ljava/util/Queue;
      //   29: invokeinterface isEmpty : ()Z
      //   34: ifne -> 294
      //   37: aload_0
      //   38: getfield b : Ljava/util/Queue;
      //   41: invokeinterface poll : ()Ljava/lang/Object;
      //   46: checkcast com/bytedance/sdk/openadsdk/h/f/a$a$a
      //   49: astore #4
      //   51: aload #4
      //   53: ifnonnull -> 59
      //   56: goto -> 25
      //   59: aload #4
      //   61: getfield a : I
      //   64: istore_1
      //   65: iload_1
      //   66: ifeq -> 162
      //   69: iload_1
      //   70: iconst_1
      //   71: if_icmpeq -> 148
      //   74: iload_1
      //   75: iconst_2
      //   76: if_icmpeq -> 139
      //   79: iload_1
      //   80: iconst_3
      //   81: if_icmpeq -> 106
      //   84: iload_1
      //   85: iconst_4
      //   86: if_icmpeq -> 92
      //   89: goto -> 285
      //   92: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/h/d;
      //   95: invokevirtual d : ()V
      //   98: aload_0
      //   99: iconst_0
      //   100: putfield c : Z
      //   103: goto -> 285
      //   106: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/h/d;
      //   109: invokevirtual d : ()V
      //   112: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/h/a/b;
      //   115: ifnull -> 124
      //   118: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/h/a/b;
      //   121: invokevirtual a : ()V
      //   124: invokestatic b : ()Lcom/bytedance/sdk/openadsdk/h/a/c;
      //   127: ifnull -> 285
      //   130: invokestatic b : ()Lcom/bytedance/sdk/openadsdk/h/a/c;
      //   133: invokevirtual a : ()V
      //   136: goto -> 285
      //   139: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/h/d;
      //   142: invokevirtual d : ()V
      //   145: goto -> 285
      //   148: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/h/d;
      //   151: aload #4
      //   153: getfield b : Ljava/lang/String;
      //   156: invokevirtual a : (Ljava/lang/String;)V
      //   159: goto -> 285
      //   162: aload #4
      //   164: getfield c : [Ljava/lang/String;
      //   167: ifnull -> 285
      //   170: aload #4
      //   172: getfield c : [Ljava/lang/String;
      //   175: arraylength
      //   176: ifle -> 285
      //   179: new java/util/ArrayList
      //   182: dup
      //   183: invokespecial <init> : ()V
      //   186: astore #5
      //   188: aload #4
      //   190: getfield c : [Ljava/lang/String;
      //   193: astore #6
      //   195: aload #6
      //   197: arraylength
      //   198: istore_2
      //   199: iconst_0
      //   200: istore_1
      //   201: iload_1
      //   202: iload_2
      //   203: if_icmpge -> 231
      //   206: aload #6
      //   208: iload_1
      //   209: aaload
      //   210: astore #7
      //   212: aload #7
      //   214: invokestatic a : (Ljava/lang/String;)Z
      //   217: ifeq -> 321
      //   220: aload #5
      //   222: aload #7
      //   224: invokevirtual add : (Ljava/lang/Object;)Z
      //   227: pop
      //   228: goto -> 321
      //   231: aload #5
      //   233: aload #5
      //   235: invokevirtual size : ()I
      //   238: anewarray java/lang/String
      //   241: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
      //   244: checkcast [Ljava/lang/String;
      //   247: astore #5
      //   249: aload #4
      //   251: getfield e : Ljava/lang/String;
      //   254: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   257: ifne -> 328
      //   260: iconst_1
      //   261: istore_3
      //   262: goto -> 265
      //   265: invokestatic c : ()Lcom/bytedance/sdk/openadsdk/h/d;
      //   268: iconst_0
      //   269: iload_3
      //   270: aload #4
      //   272: getfield d : I
      //   275: aload #4
      //   277: getfield b : Ljava/lang/String;
      //   280: aload #5
      //   282: invokevirtual a : (ZZILjava/lang/String;[Ljava/lang/String;)V
      //   285: aload_0
      //   286: aload #4
      //   288: invokespecial a : (Lcom/bytedance/sdk/openadsdk/h/f/a$a$a;)V
      //   291: goto -> 25
      //   294: aload_0
      //   295: invokevirtual wait : ()V
      //   298: goto -> 308
      //   301: astore #4
      //   303: aload #4
      //   305: invokevirtual printStackTrace : ()V
      //   308: aload_0
      //   309: monitorexit
      //   310: goto -> 0
      //   313: astore #4
      //   315: aload_0
      //   316: monitorexit
      //   317: aload #4
      //   319: athrow
      //   320: return
      //   321: iload_1
      //   322: iconst_1
      //   323: iadd
      //   324: istore_1
      //   325: goto -> 201
      //   328: iconst_0
      //   329: istore_3
      //   330: goto -> 265
      // Exception table:
      //   from	to	target	type
      //   9	25	313	finally
      //   25	51	313	finally
      //   59	65	313	finally
      //   92	103	313	finally
      //   106	124	313	finally
      //   124	136	313	finally
      //   139	145	313	finally
      //   148	159	313	finally
      //   162	199	313	finally
      //   212	228	313	finally
      //   231	260	313	finally
      //   265	285	313	finally
      //   285	291	313	finally
      //   294	298	301	java/lang/InterruptedException
      //   294	298	313	finally
      //   303	308	313	finally
      //   308	310	313	finally
      //   315	317	313	finally
    }
    
    class a {
      public int a;
      
      public String b;
      
      public String[] c;
      
      public int d;
      
      public String e;
      
      public b f;
      
      public a(a.a this$0) {}
    }
  }
  
  class a {
    public int a;
    
    public String b;
    
    public String[] c;
    
    public int d;
    
    public String e;
    
    public b f;
    
    public a(a this$0) {}
  }
  
  static class b {
    private static final a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */