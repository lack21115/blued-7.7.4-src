package com.bytedance.sdk.openadsdk.h;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.h.a.a;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.h.b.b;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.h.g.b;
import com.bytedance.sdk.openadsdk.h.g.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class d {
  private static volatile d e;
  
  private volatile int a = 163840;
  
  private final SparseArray<Map<String, b>> b = new SparseArray(2);
  
  private final b<Runnable> c = new b<Runnable>();
  
  private final ExecutorService d = a(this.c);
  
  private volatile c f;
  
  private volatile c g;
  
  private volatile b h;
  
  private final HashSet<a> i = new HashSet<a>();
  
  private final b.b j = new b.b(this) {
      public void a(b param1b) {
        SparseArray sparseArray;
        StringBuilder stringBuilder;
        int i = param1b.f();
        synchronized (d.a(this.a)) {
          Map map = (Map)d.a(this.a).get(i);
          if (map != null)
            map.remove(param1b.h); 
          if (e.c) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("afterExecute, key: ");
            stringBuilder.append(param1b.h);
            Log.d("TAG_PROXY_Preloader", stringBuilder.toString());
          } 
          return;
        } 
      }
    };
  
  private volatile c k;
  
  private volatile c l;
  
  private volatile String m;
  
  private volatile boolean n;
  
  private d() {
    this.c.a((ThreadPoolExecutor)this.d);
    this.b.put(0, new HashMap<Object, Object>());
    this.b.put(1, new HashMap<Object, Object>());
  }
  
  private static ExecutorService a(b<Runnable> paramb) {
    int i = d.a();
    if (i < 1) {
      i = 1;
    } else if (i > 4) {
      i = 4;
    } 
    return new ThreadPoolExecutor(0, i, 60L, TimeUnit.SECONDS, paramb, new ThreadFactory() {
          public Thread newThread(Runnable param1Runnable) {
            param1Runnable = new Thread(this, param1Runnable) {
                public void run() {
                  try {
                    Process.setThreadPriority(10);
                  } finally {
                    Exception exception = null;
                  } 
                }
              };
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("video-preload-");
            stringBuilder.append(param1Runnable.getId());
            param1Runnable.setName(stringBuilder.toString());
            param1Runnable.setDaemon(true);
            if (e.c) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("new preload thead: ");
              stringBuilder.append(param1Runnable.getName());
              Log.i("TAG_PROXY_Preloader", stringBuilder.toString());
            } 
            return (Thread)param1Runnable;
          }
        }new RejectedExecutionHandler(paramb) {
          public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
            try {
              this.a.offerFirst(param1Runnable);
              if (e.c)
                return; 
            } finally {
              param1Runnable = null;
            } 
          }
        });
  }
  
  public static d c() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/h/d.e : Lcom/bytedance/sdk/openadsdk/h/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/h/d
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/h/d.e : Lcom/bytedance/sdk/openadsdk/h/d;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/h/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/h/d.e : Lcom/bytedance/sdk/openadsdk/h/d;
    //   25: ldc com/bytedance/sdk/openadsdk/h/d
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/h/d
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/h/d.e : Lcom/bytedance/sdk/openadsdk/h/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  c a() {
    return this.k;
  }
  
  public void a(int paramInt) {
    if (paramInt > 0)
      this.a = paramInt; 
    if (e.c) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("MaxPreloadSize: ");
      stringBuilder.append(paramInt);
      Log.i("TAG_PROXY_Preloader", stringBuilder.toString());
    } 
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {
    /* monitor enter ThisExpression{ObjectType{com/bytedance/sdk/openadsdk/h/d}} */
    /* monitor exit ThisExpression{ObjectType{com/bytedance/sdk/openadsdk/h/d}} */
  }
  
  void a(c paramc) {
    this.g = paramc;
  }
  
  void a(c paramc) {
    this.f = paramc;
  }
  
  public void a(String paramString) {
    a(false, false, paramString);
  }
  
  void a(boolean paramBoolean, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: putfield m : Ljava/lang/String;
    //   5: aload_0
    //   6: iload_1
    //   7: putfield n : Z
    //   10: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   13: ifeq -> 51
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore #6
    //   25: aload #6
    //   27: ldc 'setCurrentPlayKey, '
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload #6
    //   35: aload_2
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 'TAG_PROXY_Preloader'
    //   42: aload #6
    //   44: invokevirtual toString : ()Ljava/lang/String;
    //   47: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: aconst_null
    //   52: astore #6
    //   54: aconst_null
    //   55: astore #8
    //   57: aconst_null
    //   58: astore #7
    //   60: aload_2
    //   61: ifnonnull -> 225
    //   64: aload_0
    //   65: getfield i : Ljava/util/HashSet;
    //   68: astore #6
    //   70: aload #6
    //   72: monitorenter
    //   73: aload #7
    //   75: astore_2
    //   76: aload_0
    //   77: getfield i : Ljava/util/HashSet;
    //   80: invokevirtual isEmpty : ()Z
    //   83: ifne -> 105
    //   86: new java/util/HashSet
    //   89: dup
    //   90: aload_0
    //   91: getfield i : Ljava/util/HashSet;
    //   94: invokespecial <init> : (Ljava/util/Collection;)V
    //   97: astore_2
    //   98: aload_0
    //   99: getfield i : Ljava/util/HashSet;
    //   102: invokevirtual clear : ()V
    //   105: aload #6
    //   107: monitorexit
    //   108: aload_2
    //   109: ifnull -> 605
    //   112: aload_2
    //   113: invokevirtual iterator : ()Ljava/util/Iterator;
    //   116: astore_2
    //   117: aload_2
    //   118: invokeinterface hasNext : ()Z
    //   123: ifeq -> 605
    //   126: aload_2
    //   127: invokeinterface next : ()Ljava/lang/Object;
    //   132: checkcast com/bytedance/sdk/openadsdk/h/d$a
    //   135: astore #6
    //   137: aload_0
    //   138: aload #6
    //   140: getfield a : Z
    //   143: aload #6
    //   145: getfield b : Z
    //   148: aload #6
    //   150: getfield c : I
    //   153: aload #6
    //   155: getfield d : Ljava/lang/String;
    //   158: aload #6
    //   160: getfield e : Ljava/util/Map;
    //   163: aload #6
    //   165: getfield f : [Ljava/lang/String;
    //   168: invokevirtual a : (ZZILjava/lang/String;Ljava/util/Map;[Ljava/lang/String;)V
    //   171: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   174: ifeq -> 117
    //   177: new java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial <init> : ()V
    //   184: astore #7
    //   186: aload #7
    //   188: ldc 'setCurrentPlayKey, resume preload: '
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #7
    //   196: aload #6
    //   198: getfield d : Ljava/lang/String;
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 'TAG_PROXY_Preloader'
    //   207: aload #7
    //   209: invokevirtual toString : ()Ljava/lang/String;
    //   212: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   215: pop
    //   216: goto -> 117
    //   219: astore_2
    //   220: aload #6
    //   222: monitorexit
    //   223: aload_2
    //   224: athrow
    //   225: getstatic com/bytedance/sdk/openadsdk/h/e.h : I
    //   228: istore #4
    //   230: iload #4
    //   232: iconst_3
    //   233: if_icmpeq -> 314
    //   236: iload #4
    //   238: iconst_2
    //   239: if_icmpne -> 245
    //   242: goto -> 314
    //   245: iload #4
    //   247: iconst_1
    //   248: if_icmpne -> 605
    //   251: aload_0
    //   252: getfield b : Landroid/util/SparseArray;
    //   255: astore #7
    //   257: aload #7
    //   259: monitorenter
    //   260: aload_0
    //   261: getfield b : Landroid/util/SparseArray;
    //   264: iload_1
    //   265: invokestatic a : (Z)I
    //   268: invokevirtual get : (I)Ljava/lang/Object;
    //   271: checkcast java/util/Map
    //   274: astore #8
    //   276: aload #8
    //   278: ifnull -> 294
    //   281: aload #8
    //   283: aload_2
    //   284: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   289: checkcast com/bytedance/sdk/openadsdk/h/b
    //   292: astore #6
    //   294: aload #7
    //   296: monitorexit
    //   297: aload #6
    //   299: ifnull -> 605
    //   302: aload #6
    //   304: invokevirtual a : ()V
    //   307: return
    //   308: astore_2
    //   309: aload #7
    //   311: monitorexit
    //   312: aload_2
    //   313: athrow
    //   314: aload_0
    //   315: getfield b : Landroid/util/SparseArray;
    //   318: astore #7
    //   320: aload #7
    //   322: monitorenter
    //   323: iconst_0
    //   324: istore_3
    //   325: aload_0
    //   326: getfield b : Landroid/util/SparseArray;
    //   329: invokevirtual size : ()I
    //   332: istore #5
    //   334: aload #8
    //   336: astore_2
    //   337: iload_3
    //   338: iload #5
    //   340: if_icmpge -> 435
    //   343: aload_0
    //   344: getfield b : Landroid/util/SparseArray;
    //   347: aload_0
    //   348: getfield b : Landroid/util/SparseArray;
    //   351: iload_3
    //   352: invokevirtual keyAt : (I)I
    //   355: invokevirtual get : (I)Ljava/lang/Object;
    //   358: checkcast java/util/Map
    //   361: astore #8
    //   363: aload_2
    //   364: astore #6
    //   366: aload #8
    //   368: ifnull -> 612
    //   371: aload #8
    //   373: invokeinterface values : ()Ljava/util/Collection;
    //   378: astore #9
    //   380: aload_2
    //   381: astore #6
    //   383: aload #9
    //   385: ifnull -> 425
    //   388: aload_2
    //   389: astore #6
    //   391: aload #9
    //   393: invokeinterface isEmpty : ()Z
    //   398: ifne -> 425
    //   401: aload_2
    //   402: astore #6
    //   404: aload_2
    //   405: ifnonnull -> 417
    //   408: new java/util/HashSet
    //   411: dup
    //   412: invokespecial <init> : ()V
    //   415: astore #6
    //   417: aload #6
    //   419: aload #9
    //   421: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   424: pop
    //   425: aload #8
    //   427: invokeinterface clear : ()V
    //   432: goto -> 612
    //   435: aload #7
    //   437: monitorexit
    //   438: aload_2
    //   439: ifnull -> 605
    //   442: aload_2
    //   443: invokevirtual isEmpty : ()Z
    //   446: ifne -> 605
    //   449: aload_2
    //   450: invokevirtual iterator : ()Ljava/util/Iterator;
    //   453: astore #6
    //   455: aload #6
    //   457: invokeinterface hasNext : ()Z
    //   462: ifeq -> 531
    //   465: aload #6
    //   467: invokeinterface next : ()Ljava/lang/Object;
    //   472: checkcast com/bytedance/sdk/openadsdk/h/b
    //   475: astore #7
    //   477: aload #7
    //   479: invokevirtual a : ()V
    //   482: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   485: ifeq -> 455
    //   488: new java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial <init> : ()V
    //   495: astore #8
    //   497: aload #8
    //   499: ldc_w 'setCurrentPlayKey, cancel preload: '
    //   502: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload #8
    //   508: aload #7
    //   510: getfield g : Ljava/lang/String;
    //   513: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: ldc 'TAG_PROXY_Preloader'
    //   519: aload #8
    //   521: invokevirtual toString : ()Ljava/lang/String;
    //   524: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   527: pop
    //   528: goto -> 455
    //   531: iload #4
    //   533: iconst_3
    //   534: if_icmpne -> 605
    //   537: aload_0
    //   538: getfield i : Ljava/util/HashSet;
    //   541: astore #6
    //   543: aload #6
    //   545: monitorenter
    //   546: aload_2
    //   547: invokevirtual iterator : ()Ljava/util/Iterator;
    //   550: astore_2
    //   551: aload_2
    //   552: invokeinterface hasNext : ()Z
    //   557: ifeq -> 595
    //   560: aload_2
    //   561: invokeinterface next : ()Ljava/lang/Object;
    //   566: checkcast com/bytedance/sdk/openadsdk/h/b
    //   569: getfield n : Ljava/lang/Object;
    //   572: checkcast com/bytedance/sdk/openadsdk/h/d$a
    //   575: astore #7
    //   577: aload #7
    //   579: ifnull -> 551
    //   582: aload_0
    //   583: getfield i : Ljava/util/HashSet;
    //   586: aload #7
    //   588: invokevirtual add : (Ljava/lang/Object;)Z
    //   591: pop
    //   592: goto -> 551
    //   595: aload #6
    //   597: monitorexit
    //   598: return
    //   599: astore_2
    //   600: aload #6
    //   602: monitorexit
    //   603: aload_2
    //   604: athrow
    //   605: return
    //   606: astore_2
    //   607: aload #7
    //   609: monitorexit
    //   610: aload_2
    //   611: athrow
    //   612: iload_3
    //   613: iconst_1
    //   614: iadd
    //   615: istore_3
    //   616: aload #6
    //   618: astore_2
    //   619: goto -> 337
    // Exception table:
    //   from	to	target	type
    //   76	105	219	finally
    //   105	108	219	finally
    //   220	223	219	finally
    //   260	276	308	finally
    //   281	294	308	finally
    //   294	297	308	finally
    //   309	312	308	finally
    //   325	334	606	finally
    //   343	363	606	finally
    //   371	380	606	finally
    //   391	401	606	finally
    //   408	417	606	finally
    //   417	425	606	finally
    //   425	432	606	finally
    //   435	438	606	finally
    //   546	551	599	finally
    //   551	577	599	finally
    //   582	592	599	finally
    //   595	598	599	finally
    //   600	603	599	finally
    //   607	610	606	finally
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString, Map<String, String> paramMap, String... paramVarArgs) {
    c c1;
    if (e.c)
      Log.d("TAG_PROXY_Preloader", "preload start ！！！！"); 
    if (paramBoolean1) {
      b b1 = this.h;
    } else {
      c1 = this.g;
    } 
    c c2 = this.f;
    if (c1 == null || c2 == null) {
      if (e.c)
        Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!"); 
      return;
    } 
    if (!TextUtils.isEmpty(paramString) && paramVarArgs != null) {
      StringBuilder stringBuilder;
      String str;
      if (paramVarArgs.length <= 0)
        return; 
      if (paramInt <= 0)
        paramInt = this.a; 
      if (paramBoolean2) {
        str = paramString;
      } else {
        str = b.a(paramString);
      } 
      File file = c1.d(str);
      if (file != null && file.length() >= paramInt) {
        if (e.c) {
          null = new StringBuilder();
          null.append("no need preload, file size: ");
          null.append(file.length());
          null.append(", need preload size: ");
          null.append(paramInt);
          Log.i("TAG_PROXY_Preloader", null.toString());
        } 
        return;
      } 
      if (f.a().a(b.a(paramBoolean1), str)) {
        if (e.c) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("has running proxy task, skip preload for key: ");
          stringBuilder.append((String)null);
          Log.w("TAG_PROXY_Preloader", stringBuilder.toString());
        } 
        return;
      } 
      synchronized (this.b) {
        i.b b2;
        int i;
        SparseArray<Map<String, b>> sparseArray = this.b;
        if (paramBoolean1) {
          i = 1;
        } else {
          i = 0;
        } 
        Map<String, b> map = (Map)sparseArray.get(i);
        if (map.containsKey(str))
          return; 
        a a = new a(paramBoolean1, paramBoolean2, paramInt, (String)null, (Map<String, String>)stringBuilder, paramVarArgs);
        String str2 = this.m;
        if (str2 != null) {
          i = e.h;
          if (i == 3) {
            HashSet<a> hashSet;
            StringBuilder stringBuilder1;
            synchronized (this.i) {
              this.i.add(a);
              if (e.c) {
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("cancel preload: ");
                stringBuilder1.append((String)null);
                stringBuilder1.append(", add to pending queue");
                Log.w("TAG_PROXY_Preloader", stringBuilder1.toString());
              } 
              return;
            } 
          } 
          if (i == 2) {
            if (e.c) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("cancel preload: ");
              stringBuilder.append((String)null);
              Log.w("TAG_PROXY_Preloader", stringBuilder.toString());
            } 
            return;
          } 
          if (i == 1 && this.n == paramBoolean1 && str2.equals(str)) {
            if (e.c) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("cancel preload: ");
              stringBuilder.append((String)null);
              stringBuilder.append(", it is playing");
              Log.w("TAG_PROXY_Preloader", stringBuilder.toString());
            } 
            return;
          } 
        } 
        str2 = null;
        List<i.b> list = d.a(d.a((Map)stringBuilder));
        String str1 = str2;
        if (list != null) {
          ArrayList<i.b> arrayList = new ArrayList(list.size());
          int j = list.size();
          for (i = 0;; i++) {
            ArrayList<i.b> arrayList1 = arrayList;
            if (i < j) {
              b2 = list.get(i);
              if (b2 != null)
                arrayList.add(new i.b(b2.a, b2.b)); 
              continue;
            } 
            b1 = (new b.a()).a((a)c1).a(c2).a((String)null).b(str).a(new l(d.a(paramVarArgs))).a((List<i.b>)b2).a(paramInt).a(this.j).a(a).a();
            map.put(str, b1);
            this.d.execute(b1);
            return;
          } 
        } 
        b b1 = (new b.a()).a((a)c1).a(c2).a((String)b1).b(str).a(new l(d.a(paramVarArgs))).a((List<i.b>)b2).a(paramInt).a(this.j).a(a).a();
        map.put(str, b1);
        this.d.execute(b1);
        return;
      } 
    } 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString, String... paramVarArgs) {
    a(paramBoolean1, paramBoolean2, paramInt, paramString, null, paramVarArgs);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    d.a(new Runnable(this, paramBoolean1, paramBoolean2, paramString) {
          public void run() {
            synchronized (d.a(this.d)) {
              b b;
              Map map = (Map)d.a(this.d).get(b.a(this.a));
              if (map != null) {
                String str;
                if (this.b) {
                  str = this.c;
                } else {
                  str = b.a(this.c);
                } 
                b = (b)map.remove(str);
              } else {
                b = null;
              } 
              if (b != null)
                b.a(); 
              return;
            } 
          }
        });
  }
  
  c b() {
    return this.l;
  }
  
  public void d() {
    d.a(new Runnable(this) {
          public void run() {
            // Byte code:
            //   0: new java/util/ArrayList
            //   3: dup
            //   4: invokespecial <init> : ()V
            //   7: astore #4
            //   9: aload_0
            //   10: getfield a : Lcom/bytedance/sdk/openadsdk/h/d;
            //   13: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/d;)Landroid/util/SparseArray;
            //   16: astore_3
            //   17: aload_3
            //   18: monitorenter
            //   19: iconst_0
            //   20: istore_1
            //   21: aload_0
            //   22: getfield a : Lcom/bytedance/sdk/openadsdk/h/d;
            //   25: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/d;)Landroid/util/SparseArray;
            //   28: invokevirtual size : ()I
            //   31: istore_2
            //   32: iload_1
            //   33: iload_2
            //   34: if_icmpge -> 93
            //   37: aload_0
            //   38: getfield a : Lcom/bytedance/sdk/openadsdk/h/d;
            //   41: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/d;)Landroid/util/SparseArray;
            //   44: aload_0
            //   45: getfield a : Lcom/bytedance/sdk/openadsdk/h/d;
            //   48: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/d;)Landroid/util/SparseArray;
            //   51: iload_1
            //   52: invokevirtual keyAt : (I)I
            //   55: invokevirtual get : (I)Ljava/lang/Object;
            //   58: checkcast java/util/Map
            //   61: astore #5
            //   63: aload #5
            //   65: ifnull -> 199
            //   68: aload #4
            //   70: aload #5
            //   72: invokeinterface values : ()Ljava/util/Collection;
            //   77: invokeinterface addAll : (Ljava/util/Collection;)Z
            //   82: pop
            //   83: aload #5
            //   85: invokeinterface clear : ()V
            //   90: goto -> 199
            //   93: aload_0
            //   94: getfield a : Lcom/bytedance/sdk/openadsdk/h/d;
            //   97: invokestatic b : (Lcom/bytedance/sdk/openadsdk/h/d;)Lcom/bytedance/sdk/openadsdk/h/d$b;
            //   100: invokevirtual clear : ()V
            //   103: aload_3
            //   104: monitorexit
            //   105: aload #4
            //   107: invokeinterface iterator : ()Ljava/util/Iterator;
            //   112: astore_3
            //   113: aload_3
            //   114: invokeinterface hasNext : ()Z
            //   119: ifeq -> 191
            //   122: aload_3
            //   123: invokeinterface next : ()Ljava/lang/Object;
            //   128: checkcast com/bytedance/sdk/openadsdk/h/b
            //   131: astore #4
            //   133: aload #4
            //   135: invokevirtual a : ()V
            //   138: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
            //   141: ifeq -> 113
            //   144: new java/lang/StringBuilder
            //   147: dup
            //   148: invokespecial <init> : ()V
            //   151: astore #5
            //   153: aload #5
            //   155: ldc 'PreloadTask: '
            //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   160: pop
            //   161: aload #5
            //   163: aload #4
            //   165: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   168: pop
            //   169: aload #5
            //   171: ldc ', canceled!!!'
            //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   176: pop
            //   177: ldc 'TAG_PROXY_Preloader'
            //   179: aload #5
            //   181: invokevirtual toString : ()Ljava/lang/String;
            //   184: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
            //   187: pop
            //   188: goto -> 113
            //   191: return
            //   192: astore #4
            //   194: aload_3
            //   195: monitorexit
            //   196: aload #4
            //   198: athrow
            //   199: iload_1
            //   200: iconst_1
            //   201: iadd
            //   202: istore_1
            //   203: goto -> 32
            // Exception table:
            //   from	to	target	type
            //   21	32	192	finally
            //   37	63	192	finally
            //   68	90	192	finally
            //   93	105	192	finally
            //   194	196	192	finally
          }
        });
  }
  
  static final class a {
    final boolean a;
    
    final boolean b;
    
    final int c;
    
    final String d;
    
    final Map<String, String> e;
    
    final String[] f;
    
    a(boolean param1Boolean1, boolean param1Boolean2, int param1Int, String param1String, Map<String, String> param1Map, String[] param1ArrayOfString) {
      this.a = param1Boolean1;
      this.b = param1Boolean2;
      this.c = param1Int;
      this.d = param1String;
      this.e = param1Map;
      this.f = param1ArrayOfString;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        param1Object = param1Object;
        return (this.a != ((a)param1Object).a) ? false : ((this.b != ((a)param1Object).b) ? false : ((this.c != ((a)param1Object).c) ? false : this.d.equals(((a)param1Object).d)));
      } 
      return false;
    }
    
    public int hashCode() {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class b<T> extends LinkedBlockingDeque<T> {
    private ThreadPoolExecutor a;
    
    private b() {}
    
    public void a(ThreadPoolExecutor param1ThreadPoolExecutor) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/concurrent/ThreadPoolExecutor;
      //   6: ifnonnull -> 31
      //   9: aload_1
      //   10: ifnull -> 21
      //   13: aload_0
      //   14: aload_1
      //   15: putfield a : Ljava/util/concurrent/ThreadPoolExecutor;
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: new java/lang/NullPointerException
      //   24: dup
      //   25: ldc 'executor argument can't be null!'
      //   27: invokespecial <init> : (Ljava/lang/String;)V
      //   30: athrow
      //   31: new java/lang/IllegalStateException
      //   34: dup
      //   35: ldc 'You can only call setExecutor() once!'
      //   37: invokespecial <init> : (Ljava/lang/String;)V
      //   40: athrow
      //   41: astore_1
      //   42: aload_0
      //   43: monitorexit
      //   44: aload_1
      //   45: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	41	finally
      //   13	20	41	finally
      //   21	31	41	finally
      //   31	41	41	finally
      //   42	44	41	finally
    }
    
    public boolean offer(T param1T) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/concurrent/ThreadPoolExecutor;
      //   6: invokevirtual getPoolSize : ()I
      //   9: istore_2
      //   10: aload_0
      //   11: getfield a : Ljava/util/concurrent/ThreadPoolExecutor;
      //   14: invokevirtual getActiveCount : ()I
      //   17: istore_3
      //   18: aload_0
      //   19: getfield a : Ljava/util/concurrent/ThreadPoolExecutor;
      //   22: invokevirtual getMaximumPoolSize : ()I
      //   25: istore #4
      //   27: iload_3
      //   28: iload_2
      //   29: if_icmplt -> 56
      //   32: iload_2
      //   33: iload #4
      //   35: if_icmpge -> 56
      //   38: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
      //   41: ifeq -> 52
      //   44: ldc 'TAG_PROXY_TT'
      //   46: ldc 'create new preloader thread'
      //   48: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   51: pop
      //   52: aload_0
      //   53: monitorexit
      //   54: iconst_0
      //   55: ireturn
      //   56: aload_0
      //   57: monitorexit
      //   58: aload_0
      //   59: aload_1
      //   60: invokevirtual offerFirst : (Ljava/lang/Object;)Z
      //   63: ireturn
      //   64: astore_1
      //   65: aload_0
      //   66: monitorexit
      //   67: aload_1
      //   68: athrow
      // Exception table:
      //   from	to	target	type
      //   2	27	64	finally
      //   38	52	64	finally
      //   52	54	64	finally
      //   56	58	64	finally
      //   65	67	64	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */