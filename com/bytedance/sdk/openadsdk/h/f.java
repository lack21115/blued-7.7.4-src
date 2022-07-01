package com.bytedance.sdk.openadsdk.h;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.h.g.b;
import com.bytedance.sdk.openadsdk.h.g.d;
import com.bytedance.sdk.openadsdk.i.b;
import com.bytedance.sdk.openadsdk.i.c;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class f {
  private static volatile f d;
  
  private volatile ServerSocket a;
  
  private volatile int b;
  
  private final AtomicInteger c = new AtomicInteger(0);
  
  private volatile c e;
  
  private volatile c f;
  
  private volatile b g;
  
  private final SparseArray<Set<g>> h = new SparseArray(2);
  
  private final g.c i = new g.c(this) {
      public void a(g param1g) {
        synchronized (f.a(this.a)) {
          Set<g> set = (Set)f.a(this.a).get(param1g.f());
          if (set != null)
            set.add(param1g); 
          return;
        } 
      }
      
      public void b(g param1g) {
        if (e.c) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("afterExecute, ProxyTask: ");
          stringBuilder.append(param1g);
          Log.d("TAG_PROXY_ProxyServer", stringBuilder.toString());
        } 
        int i = param1g.f();
        synchronized (f.a(this.a)) {
          Set set = (Set)f.a(this.a).get(i);
          if (set != null)
            set.remove(param1g); 
          return;
        } 
      }
    };
  
  private volatile c j;
  
  private volatile c k;
  
  private final Runnable l = new Runnable(this) {
      public void run() {
        // Byte code:
        //   0: aload_0
        //   1: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   4: astore_3
        //   5: ldc '127.0.0.1'
        //   7: invokestatic getByName : (Ljava/lang/String;)Ljava/net/InetAddress;
        //   10: astore #4
        //   12: iconst_0
        //   13: istore_2
        //   14: aload_3
        //   15: new java/net/ServerSocket
        //   18: dup
        //   19: iconst_0
        //   20: bipush #50
        //   22: aload #4
        //   24: invokespecial <init> : (IILjava/net/InetAddress;)V
        //   27: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/f;Ljava/net/ServerSocket;)Ljava/net/ServerSocket;
        //   30: pop
        //   31: aload_0
        //   32: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   35: astore_3
        //   36: aload_3
        //   37: aload_3
        //   38: invokestatic c : (Lcom/bytedance/sdk/openadsdk/h/f;)Ljava/net/ServerSocket;
        //   41: invokevirtual getLocalPort : ()I
        //   44: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/f;I)I
        //   47: pop
        //   48: aload_0
        //   49: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   52: invokestatic d : (Lcom/bytedance/sdk/openadsdk/h/f;)I
        //   55: iconst_m1
        //   56: if_icmpne -> 74
        //   59: ldc 'socket not bound'
        //   61: ldc ''
        //   63: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
        //   66: aload_0
        //   67: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   70: invokestatic b : (Lcom/bytedance/sdk/openadsdk/h/f;)V
        //   73: return
        //   74: ldc '127.0.0.1'
        //   76: aload_0
        //   77: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   80: invokestatic d : (Lcom/bytedance/sdk/openadsdk/h/f;)I
        //   83: invokestatic a : (Ljava/lang/String;I)V
        //   86: aload_0
        //   87: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   90: invokestatic e : (Lcom/bytedance/sdk/openadsdk/h/f;)Z
        //   93: ifne -> 97
        //   96: return
        //   97: aload_0
        //   98: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   101: invokestatic f : (Lcom/bytedance/sdk/openadsdk/h/f;)Ljava/util/concurrent/atomic/AtomicInteger;
        //   104: iconst_0
        //   105: iconst_1
        //   106: invokevirtual compareAndSet : (II)Z
        //   109: ifne -> 113
        //   112: return
        //   113: iload_2
        //   114: istore_1
        //   115: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
        //   118: ifeq -> 131
        //   121: ldc 'TAG_PROXY_ProxyServer'
        //   123: ldc 'proxy server start!'
        //   125: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
        //   128: pop
        //   129: iload_2
        //   130: istore_1
        //   131: aload_0
        //   132: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   135: invokestatic f : (Lcom/bytedance/sdk/openadsdk/h/f;)Ljava/util/concurrent/atomic/AtomicInteger;
        //   138: invokevirtual get : ()I
        //   141: istore_2
        //   142: iload_2
        //   143: iconst_1
        //   144: if_icmpne -> 296
        //   147: aload_0
        //   148: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   151: invokestatic c : (Lcom/bytedance/sdk/openadsdk/h/f;)Ljava/net/ServerSocket;
        //   154: invokevirtual accept : ()Ljava/net/Socket;
        //   157: astore_3
        //   158: aload_0
        //   159: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   162: invokestatic g : (Lcom/bytedance/sdk/openadsdk/h/f;)Lcom/bytedance/sdk/openadsdk/h/b/c;
        //   165: astore #4
        //   167: aload #4
        //   169: ifnull -> 214
        //   172: new com/bytedance/sdk/openadsdk/h/g$a
        //   175: dup
        //   176: invokespecial <init> : ()V
        //   179: aload #4
        //   181: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/b/c;)Lcom/bytedance/sdk/openadsdk/h/g$a;
        //   184: aload_3
        //   185: invokevirtual a : (Ljava/net/Socket;)Lcom/bytedance/sdk/openadsdk/h/g$a;
        //   188: aload_0
        //   189: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   192: invokestatic h : (Lcom/bytedance/sdk/openadsdk/h/f;)Lcom/bytedance/sdk/openadsdk/h/g$c;
        //   195: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/g$c;)Lcom/bytedance/sdk/openadsdk/h/g$a;
        //   198: invokevirtual a : ()Lcom/bytedance/sdk/openadsdk/h/g;
        //   201: astore_3
        //   202: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/i/a;
        //   205: aload_3
        //   206: bipush #10
        //   208: invokevirtual b : (Ljava/lang/Runnable;I)V
        //   211: goto -> 131
        //   214: aload_3
        //   215: invokestatic a : (Ljava/net/Socket;)V
        //   218: goto -> 131
        //   221: astore_3
        //   222: aload_3
        //   223: invokevirtual printStackTrace : ()V
        //   226: ldc 'accept error'
        //   228: aload_3
        //   229: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
        //   232: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
        //   235: iload_1
        //   236: iconst_1
        //   237: iadd
        //   238: istore_2
        //   239: iload_2
        //   240: istore_1
        //   241: iload_2
        //   242: iconst_3
        //   243: if_icmple -> 131
        //   246: goto -> 296
        //   249: astore_3
        //   250: aload_3
        //   251: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
        //   254: astore_3
        //   255: new java/lang/StringBuilder
        //   258: dup
        //   259: invokespecial <init> : ()V
        //   262: astore #4
        //   264: aload #4
        //   266: ldc 'proxy server crashed!  '
        //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   271: pop
        //   272: aload #4
        //   274: aload_3
        //   275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   278: pop
        //   279: ldc 'TAG_PROXY_ProxyServer'
        //   281: aload #4
        //   283: invokevirtual toString : ()Ljava/lang/String;
        //   286: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
        //   289: pop
        //   290: ldc 'error'
        //   292: aload_3
        //   293: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
        //   296: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
        //   299: ifeq -> 310
        //   302: ldc 'TAG_PROXY_ProxyServer'
        //   304: ldc 'proxy server closed!'
        //   306: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
        //   309: pop
        //   310: aload_0
        //   311: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   314: invokestatic b : (Lcom/bytedance/sdk/openadsdk/h/f;)V
        //   317: return
        //   318: astore_3
        //   319: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
        //   322: ifeq -> 363
        //   325: new java/lang/StringBuilder
        //   328: dup
        //   329: invokespecial <init> : ()V
        //   332: astore #4
        //   334: aload #4
        //   336: ldc 'create ServerSocket error!  '
        //   338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   341: pop
        //   342: aload #4
        //   344: aload_3
        //   345: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
        //   348: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   351: pop
        //   352: ldc 'TAG_PROXY_ProxyServer'
        //   354: aload #4
        //   356: invokevirtual toString : ()Ljava/lang/String;
        //   359: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
        //   362: pop
        //   363: ldc 'create ServerSocket error'
        //   365: aload_3
        //   366: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
        //   369: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
        //   372: aload_0
        //   373: getfield a : Lcom/bytedance/sdk/openadsdk/h/f;
        //   376: invokestatic b : (Lcom/bytedance/sdk/openadsdk/h/f;)V
        //   379: return
        // Exception table:
        //   from	to	target	type
        //   0	12	318	java/io/IOException
        //   14	31	318	java/io/IOException
        //   131	142	249	finally
        //   147	158	221	java/io/IOException
        //   147	158	249	finally
        //   158	167	249	finally
        //   172	211	249	finally
        //   214	218	249	finally
        //   222	235	249	finally
      }
    };
  
  private final AtomicBoolean m = new AtomicBoolean();
  
  private f() {
    this.h.put(0, new HashSet());
    this.h.put(1, new HashSet());
  }
  
  public static f a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/h/f.d : Lcom/bytedance/sdk/openadsdk/h/f;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/h/f
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/h/f.d : Lcom/bytedance/sdk/openadsdk/h/f;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/h/f
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/h/f.d : Lcom/bytedance/sdk/openadsdk/h/f;
    //   25: ldc com/bytedance/sdk/openadsdk/h/f
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/h/f
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/h/f.d : Lcom/bytedance/sdk/openadsdk/h/f;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private static void b(String paramString1, String paramString2) {}
  
  private void e() {
    if (this.c.compareAndSet(1, 2) || this.c.compareAndSet(0, 2)) {
      d.a(this.a);
      f();
    } 
  }
  
  private void f() {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload_0
    //   10: getfield h : Landroid/util/SparseArray;
    //   13: astore_3
    //   14: aload_3
    //   15: monitorenter
    //   16: iconst_0
    //   17: istore_1
    //   18: aload_0
    //   19: getfield h : Landroid/util/SparseArray;
    //   22: invokevirtual size : ()I
    //   25: istore_2
    //   26: iload_1
    //   27: iload_2
    //   28: if_icmpge -> 74
    //   31: aload_0
    //   32: getfield h : Landroid/util/SparseArray;
    //   35: aload_0
    //   36: getfield h : Landroid/util/SparseArray;
    //   39: iload_1
    //   40: invokevirtual keyAt : (I)I
    //   43: invokevirtual get : (I)Ljava/lang/Object;
    //   46: checkcast java/util/Set
    //   49: astore #5
    //   51: aload #5
    //   53: ifnull -> 114
    //   56: aload #4
    //   58: aload #5
    //   60: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   63: pop
    //   64: aload #5
    //   66: invokeinterface clear : ()V
    //   71: goto -> 114
    //   74: aload_3
    //   75: monitorexit
    //   76: aload #4
    //   78: invokevirtual iterator : ()Ljava/util/Iterator;
    //   81: astore_3
    //   82: aload_3
    //   83: invokeinterface hasNext : ()Z
    //   88: ifeq -> 106
    //   91: aload_3
    //   92: invokeinterface next : ()Ljava/lang/Object;
    //   97: checkcast com/bytedance/sdk/openadsdk/h/g
    //   100: invokevirtual a : ()V
    //   103: goto -> 82
    //   106: return
    //   107: astore #4
    //   109: aload_3
    //   110: monitorexit
    //   111: aload #4
    //   113: athrow
    //   114: iload_1
    //   115: iconst_1
    //   116: iadd
    //   117: istore_1
    //   118: goto -> 26
    // Exception table:
    //   from	to	target	type
    //   18	26	107	finally
    //   31	51	107	finally
    //   56	71	107	finally
    //   74	76	107	finally
    //   109	111	107	finally
  }
  
  private boolean g() {
    b b1 = new b(new a("127.0.0.1", this.b), 5, 1);
    com.bytedance.sdk.openadsdk.i.a.a().a(new c(this, b1) {
          public void run() {
            t.b("TTExecutor", "pingTest.....run");
            this.a.run();
          }
        });
    h();
    try {
      return true;
    } finally {
      b1 = null;
      b1.printStackTrace();
      b("ping error", Log.getStackTraceString((Throwable)b1));
      e();
    } 
  }
  
  private void h() {
    Socket socket3;
    Socket socket1 = null;
    Socket socket2 = null;
    try {
      Socket socket = this.a.accept();
      socket2 = socket;
      socket1 = socket;
      socket.setSoTimeout(2000);
      socket2 = socket;
      socket1 = socket;
      socket3 = socket;
      if ("Ping".equals((new BufferedReader(new InputStreamReader(socket.getInputStream()))).readLine())) {
        socket2 = socket;
        socket1 = socket;
        OutputStream outputStream = socket.getOutputStream();
        socket2 = socket;
        socket1 = socket;
        outputStream.write("OK\n".getBytes(d.a));
        socket2 = socket;
        socket1 = socket;
        outputStream.flush();
        Socket socket4 = socket;
      } 
    } catch (IOException iOException) {
      socket2 = socket1;
      iOException.printStackTrace();
      socket2 = socket1;
      b("ping error", Log.getStackTraceString(iOException));
      socket3 = socket1;
    } finally {}
    d.a(socket3);
  }
  
  public String a(boolean paramBoolean1, boolean paramBoolean2, String paramString, String... paramVarArgs) {
    StringBuilder stringBuilder1;
    c c1;
    String str2;
    if (paramVarArgs == null || paramVarArgs.length == 0) {
      b("url", "url is empty");
      return null;
    } 
    if (TextUtils.isEmpty(paramString)) {
      b("key", "key is empty");
      return paramVarArgs[0];
    } 
    if (this.e == null) {
      b("db", "VideoProxyDB is null");
      return paramVarArgs[0];
    } 
    if (paramBoolean1) {
      b b1 = this.g;
    } else {
      c1 = this.f;
    } 
    if (c1 == null) {
      b("cache", "Cache is null");
      return paramVarArgs[0];
    } 
    int i = this.c.get();
    if (i != 1) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("ProxyServer is not running, ");
      stringBuilder1.append(i);
      b("state", stringBuilder1.toString());
      return paramVarArgs[0];
    } 
    List<String> list = d.a(paramVarArgs);
    if (list == null) {
      b("url", "url not start with http/https");
      return paramVarArgs[0];
    } 
    if (paramBoolean2) {
      StringBuilder stringBuilder = stringBuilder1;
    } else {
      str2 = b.a((String)stringBuilder1);
    } 
    String str1 = i.a((String)stringBuilder1, str2, list);
    if (str1 == null) {
      b("url", "combine proxy url error");
      return paramVarArgs[0];
    } 
    if (paramBoolean1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("http://127.0.0.1:");
      stringBuilder.append(this.b);
      stringBuilder.append("?f=");
      stringBuilder.append(1);
      stringBuilder.append("&");
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("http://127.0.0.1:");
    stringBuilder2.append(this.b);
    stringBuilder2.append("?");
    stringBuilder2.append(str1);
    return stringBuilder2.toString();
  }
  
  void a(c paramc) {
    this.f = paramc;
  }
  
  void a(c paramc) {
    this.e = paramc;
  }
  
  boolean a(int paramInt, String paramString) {
    if (paramString == null)
      return false; 
    synchronized (this.h) {
      Set set = (Set)this.h.get(paramInt);
      if (set != null)
        for (g g : set) {
          if (g != null && paramString.equals(g.h))
            return true; 
        }  
      return false;
    } 
  }
  
  c b() {
    return this.j;
  }
  
  c c() {
    return this.k;
  }
  
  public void d() {
    if (this.m.compareAndSet(false, true))
      (new Thread(this.l)).start(); 
  }
  
  static final class a implements Callable<Boolean> {
    private final String a;
    
    private final int b;
    
    a(String param1String, int param1Int) {
      this.a = param1String;
      this.b = param1Int;
    }
    
    public Boolean a() {
      try {
        Socket socket;
      } finally {
        null = null;
        Exception exception = null;
      } 
      d.a((Socket)SYNTHETIC_LOCAL_VARIABLE_2);
      return Boolean.valueOf(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */