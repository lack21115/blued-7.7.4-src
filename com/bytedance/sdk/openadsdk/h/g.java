package com.bytedance.sdk.openadsdk.h;

import android.util.Log;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.a.a;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.h.b.a;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.h.c.a;
import com.bytedance.sdk.openadsdk.h.c.b;
import com.bytedance.sdk.openadsdk.h.c.c;
import com.bytedance.sdk.openadsdk.h.c.d;
import com.bytedance.sdk.openadsdk.h.e.a;
import com.bytedance.sdk.openadsdk.h.g.d;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

class g extends a {
  private final Socket m;
  
  private final c n;
  
  private final d o;
  
  private volatile b p;
  
  private volatile boolean q = true;
  
  g(a parama) {
    super(parama.a, parama.b);
    this.m = parama.c;
    this.n = parama.d;
    this.o = d.c();
  }
  
  private void a(a parama, File paramFile, b paramb, l.a parama1) throws IOException, d, h.a, a, b, VAdError {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual a : ()Z
    //   4: ifne -> 37
    //   7: aload_0
    //   8: aload_1
    //   9: aload_3
    //   10: aload #4
    //   12: invokespecial a : (Lcom/bytedance/sdk/openadsdk/h/b/a;Lcom/bytedance/sdk/openadsdk/h/g$b;Lcom/bytedance/sdk/openadsdk/h/l$a;)[B
    //   15: astore #7
    //   17: aload_0
    //   18: invokevirtual e : ()V
    //   21: aload #7
    //   23: ifnonnull -> 27
    //   26: return
    //   27: aload_3
    //   28: aload #7
    //   30: iconst_0
    //   31: aload #7
    //   33: arraylength
    //   34: invokevirtual a : ([BII)V
    //   37: aload_1
    //   38: astore #7
    //   40: aload_1
    //   41: ifnonnull -> 177
    //   44: aload_0
    //   45: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   48: aload_0
    //   49: getfield h : Ljava/lang/String;
    //   52: aload_0
    //   53: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   56: getfield c : Lcom/bytedance/sdk/openadsdk/h/i$a;
    //   59: getfield a : I
    //   62: invokevirtual a : (Ljava/lang/String;I)Lcom/bytedance/sdk/openadsdk/h/b/a;
    //   65: astore_1
    //   66: aload_1
    //   67: astore #7
    //   69: aload_1
    //   70: ifnonnull -> 177
    //   73: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   76: ifeq -> 87
    //   79: ldc 'TAG_PROXY_ProxyTask'
    //   81: ldc 'failed to get video header info from db'
    //   83: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_0
    //   88: aconst_null
    //   89: aload_3
    //   90: aload #4
    //   92: invokespecial a : (Lcom/bytedance/sdk/openadsdk/h/b/a;Lcom/bytedance/sdk/openadsdk/h/g$b;Lcom/bytedance/sdk/openadsdk/h/l$a;)[B
    //   95: pop
    //   96: aload_0
    //   97: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   100: aload_0
    //   101: getfield h : Ljava/lang/String;
    //   104: aload_0
    //   105: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   108: getfield c : Lcom/bytedance/sdk/openadsdk/h/i$a;
    //   111: getfield a : I
    //   114: invokevirtual a : (Ljava/lang/String;I)Lcom/bytedance/sdk/openadsdk/h/b/a;
    //   117: astore #7
    //   119: aload #7
    //   121: ifnull -> 127
    //   124: goto -> 177
    //   127: new java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial <init> : ()V
    //   134: astore_1
    //   135: aload_1
    //   136: ldc 'failed to get header, rawKey: '
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: aload_0
    //   144: getfield g : Ljava/lang/String;
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_1
    //   152: ldc ', url: '
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: aload #4
    //   161: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: new com/bytedance/sdk/openadsdk/h/c/c
    //   168: dup
    //   169: aload_1
    //   170: invokevirtual toString : ()Ljava/lang/String;
    //   173: invokespecial <init> : (Ljava/lang/String;)V
    //   176: athrow
    //   177: aload_2
    //   178: invokevirtual length : ()J
    //   181: aload #7
    //   183: getfield c : I
    //   186: i2l
    //   187: lcmp
    //   188: ifge -> 351
    //   191: aload_0
    //   192: getfield p : Lcom/bytedance/sdk/openadsdk/h/b;
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull -> 214
    //   200: aload_1
    //   201: invokevirtual b : ()Z
    //   204: ifne -> 214
    //   207: aload_1
    //   208: invokevirtual d : ()Z
    //   211: ifeq -> 351
    //   214: new com/bytedance/sdk/openadsdk/h/b$a
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: aload_0
    //   222: getfield a : Lcom/bytedance/sdk/openadsdk/h/a/a;
    //   225: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/a/a;)Lcom/bytedance/sdk/openadsdk/h/b$a;
    //   228: aload_0
    //   229: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   232: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/b/c;)Lcom/bytedance/sdk/openadsdk/h/b$a;
    //   235: aload_0
    //   236: getfield g : Ljava/lang/String;
    //   239: invokevirtual a : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/h/b$a;
    //   242: aload_0
    //   243: getfield h : Ljava/lang/String;
    //   246: invokevirtual b : (Ljava/lang/String;)Lcom/bytedance/sdk/openadsdk/h/b$a;
    //   249: new com/bytedance/sdk/openadsdk/h/l
    //   252: dup
    //   253: aload #4
    //   255: getfield a : Ljava/lang/String;
    //   258: invokespecial <init> : (Ljava/lang/String;)V
    //   261: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/l;)Lcom/bytedance/sdk/openadsdk/h/b$a;
    //   264: aload_0
    //   265: getfield f : Ljava/util/List;
    //   268: invokevirtual a : (Ljava/util/List;)Lcom/bytedance/sdk/openadsdk/h/b$a;
    //   271: aload_0
    //   272: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   275: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/i;)Lcom/bytedance/sdk/openadsdk/h/b$a;
    //   278: new com/bytedance/sdk/openadsdk/h/g$1
    //   281: dup
    //   282: aload_0
    //   283: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/h/g;)V
    //   286: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/b$b;)Lcom/bytedance/sdk/openadsdk/h/b$a;
    //   289: invokevirtual a : ()Lcom/bytedance/sdk/openadsdk/h/b;
    //   292: astore_1
    //   293: aload_0
    //   294: aload_1
    //   295: putfield p : Lcom/bytedance/sdk/openadsdk/h/b;
    //   298: new com/bytedance/sdk/openadsdk/i/b
    //   301: dup
    //   302: aload_1
    //   303: aconst_null
    //   304: bipush #10
    //   306: iconst_1
    //   307: invokespecial <init> : (Ljava/lang/Runnable;Ljava/lang/Object;II)V
    //   310: astore #8
    //   312: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/i/a;
    //   315: new com/bytedance/sdk/openadsdk/h/g$2
    //   318: dup
    //   319: aload_0
    //   320: aload #8
    //   322: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/h/g;Lcom/bytedance/sdk/openadsdk/i/b;)V
    //   325: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/i/c;)V
    //   328: aload #8
    //   330: astore_1
    //   331: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   334: ifeq -> 353
    //   337: ldc 'TAG_PROXY_ProxyTask'
    //   339: ldc 'fire download in process cache task'
    //   341: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   344: pop
    //   345: aload #8
    //   347: astore_1
    //   348: goto -> 353
    //   351: aconst_null
    //   352: astore_1
    //   353: sipush #8192
    //   356: newarray byte
    //   358: astore #8
    //   360: new com/bytedance/sdk/openadsdk/h/h
    //   363: dup
    //   364: aload_2
    //   365: ldc 'r'
    //   367: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   370: astore_2
    //   371: aload_2
    //   372: aload_3
    //   373: invokevirtual b : ()I
    //   376: i2l
    //   377: invokevirtual a : (J)V
    //   380: aload_0
    //   381: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   384: getfield c : Lcom/bytedance/sdk/openadsdk/h/i$a;
    //   387: getfield e : I
    //   390: ifle -> 416
    //   393: aload #7
    //   395: getfield c : I
    //   398: aload_0
    //   399: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   402: getfield c : Lcom/bytedance/sdk/openadsdk/h/i$a;
    //   405: getfield e : I
    //   408: invokestatic min : (II)I
    //   411: istore #5
    //   413: goto -> 423
    //   416: aload #7
    //   418: getfield c : I
    //   421: istore #5
    //   423: aload_3
    //   424: invokevirtual b : ()I
    //   427: iload #5
    //   429: if_icmpge -> 649
    //   432: aload_0
    //   433: invokevirtual e : ()V
    //   436: aload_2
    //   437: aload #8
    //   439: invokevirtual a : ([B)I
    //   442: istore #6
    //   444: iload #6
    //   446: ifgt -> 633
    //   449: aload_0
    //   450: getfield p : Lcom/bytedance/sdk/openadsdk/h/b;
    //   453: astore #7
    //   455: aload #7
    //   457: ifnull -> 493
    //   460: aload #7
    //   462: invokevirtual i : ()Lcom/bytedance/sdk/openadsdk/h/c/b;
    //   465: astore #9
    //   467: aload #9
    //   469: ifnonnull -> 490
    //   472: aload #7
    //   474: invokevirtual h : ()Lcom/bytedance/sdk/openadsdk/h/h$a;
    //   477: astore #9
    //   479: aload #9
    //   481: ifnonnull -> 487
    //   484: goto -> 493
    //   487: aload #9
    //   489: athrow
    //   490: aload #9
    //   492: athrow
    //   493: aload #7
    //   495: ifnull -> 567
    //   498: aload #7
    //   500: invokevirtual b : ()Z
    //   503: ifne -> 567
    //   506: aload #7
    //   508: invokevirtual d : ()Z
    //   511: ifeq -> 517
    //   514: goto -> 567
    //   517: aload_0
    //   518: invokevirtual e : ()V
    //   521: aload #7
    //   523: getfield m : Ljava/lang/Object;
    //   526: astore #9
    //   528: aload #9
    //   530: monitorenter
    //   531: aload #7
    //   533: getfield m : Ljava/lang/Object;
    //   536: ldc2_w 1000
    //   539: invokevirtual wait : (J)V
    //   542: goto -> 556
    //   545: astore_3
    //   546: goto -> 562
    //   549: astore #7
    //   551: aload #7
    //   553: invokevirtual printStackTrace : ()V
    //   556: aload #9
    //   558: monitorexit
    //   559: goto -> 642
    //   562: aload #9
    //   564: monitorexit
    //   565: aload_3
    //   566: athrow
    //   567: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   570: ifeq -> 582
    //   573: ldc 'TAG_PROXY_ProxyTask'
    //   575: ldc_w 'download task has finished!!!'
    //   578: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   581: pop
    //   582: new java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial <init> : ()V
    //   589: astore_3
    //   590: aload_3
    //   591: ldc_w 'illegal state download task has finished, rawKey: '
    //   594: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_3
    //   599: aload_0
    //   600: getfield g : Ljava/lang/String;
    //   603: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_3
    //   608: ldc ', url: '
    //   610: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_3
    //   615: aload #4
    //   617: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: new com/bytedance/sdk/openadsdk/h/c/c
    //   624: dup
    //   625: aload_3
    //   626: invokevirtual toString : ()Ljava/lang/String;
    //   629: invokespecial <init> : (Ljava/lang/String;)V
    //   632: athrow
    //   633: aload_3
    //   634: aload #8
    //   636: iconst_0
    //   637: iload #6
    //   639: invokevirtual b : ([BII)V
    //   642: aload_0
    //   643: invokevirtual e : ()V
    //   646: goto -> 423
    //   649: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   652: ifeq -> 711
    //   655: new java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial <init> : ()V
    //   662: astore #4
    //   664: aload #4
    //   666: ldc_w 'read cache file complete: '
    //   669: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: pop
    //   673: aload #4
    //   675: aload_3
    //   676: invokevirtual b : ()I
    //   679: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload #4
    //   685: ldc_w ', '
    //   688: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload #4
    //   694: iload #5
    //   696: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: ldc 'TAG_PROXY_ProxyTask'
    //   702: aload #4
    //   704: invokevirtual toString : ()Ljava/lang/String;
    //   707: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   710: pop
    //   711: aload_0
    //   712: invokevirtual c : ()V
    //   715: aload_2
    //   716: invokevirtual a : ()V
    //   719: aload_1
    //   720: ifnull -> 734
    //   723: aload_1
    //   724: invokevirtual get : ()Ljava/lang/Object;
    //   727: pop
    //   728: return
    //   729: astore_1
    //   730: aload_1
    //   731: invokevirtual printStackTrace : ()V
    //   734: return
    //   735: astore #4
    //   737: aload_2
    //   738: astore_3
    //   739: aload #4
    //   741: astore_2
    //   742: goto -> 748
    //   745: astore_2
    //   746: aconst_null
    //   747: astore_3
    //   748: aload_3
    //   749: ifnull -> 756
    //   752: aload_3
    //   753: invokevirtual a : ()V
    //   756: aload_1
    //   757: ifnull -> 773
    //   760: aload_1
    //   761: invokevirtual get : ()Ljava/lang/Object;
    //   764: pop
    //   765: goto -> 773
    //   768: astore_1
    //   769: aload_1
    //   770: invokevirtual printStackTrace : ()V
    //   773: aload_2
    //   774: athrow
    // Exception table:
    //   from	to	target	type
    //   360	371	745	finally
    //   371	413	735	finally
    //   416	423	735	finally
    //   423	444	735	finally
    //   449	455	735	finally
    //   460	467	735	finally
    //   472	479	735	finally
    //   487	490	735	finally
    //   490	493	735	finally
    //   498	514	735	finally
    //   517	531	735	finally
    //   531	542	549	java/lang/InterruptedException
    //   531	542	545	finally
    //   551	556	545	finally
    //   556	559	545	finally
    //   562	565	545	finally
    //   565	567	735	finally
    //   567	582	735	finally
    //   582	633	735	finally
    //   633	642	735	finally
    //   642	646	735	finally
    //   649	711	735	finally
    //   711	715	735	finally
    //   723	728	729	finally
    //   760	765	768	finally
  }
  
  private void a(b paramb, l.a parama) throws d, IOException, h.a, a, b, VAdError {
    if ("HEAD".equalsIgnoreCase(this.i.a.a)) {
      b(paramb, parama);
      return;
    } 
    c(paramb, parama);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  private boolean a(b paramb) throws a, VAdError {
    while (this.j.a()) {
      e();
      l.a a1 = this.j.b();
      try {
        a(paramb, a1);
        return true;
      } catch (c c1) {
        a1.a();
        a(Boolean.valueOf(g()), this.g, (Throwable)c1);
      } catch (IOException iOException) {
        if (iOException instanceof java.net.SocketTimeoutException)
          a1.b(); 
        if (b()) {
          if (e.c) {
            if ("Canceled".equalsIgnoreCase(iOException.getMessage())) {
              Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
              continue;
            } 
            Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(iOException));
          } 
          continue;
        } 
        a(Boolean.valueOf(g()), this.g, iOException);
      } catch (d d1) {
        if (e.c)
          Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString((Throwable)d1)); 
        return true;
      } catch (a a2) {
        if (e.c)
          Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(a2)); 
        this.q = false;
        a(Boolean.valueOf(g()), this.g, a2);
      } catch (b b1) {
        if (e.c)
          Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString((Throwable)b1)); 
        return false;
      } catch (com.bytedance.sdk.adnet.err.a a2) {
        if (e.c)
          Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString((Throwable)a2)); 
      } catch (Exception exception) {
        if (e.c)
          Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(exception)); 
      } 
    } 
    return false;
  }
  
  private byte[] a(a parama, b paramb, l.a parama1) throws IOException, VAdError {
    if (parama != null) {
      if (e.c)
        Log.i("TAG_PROXY_ProxyTask", "get header from db"); 
      return d.a(parama, paramb.b()).getBytes(d.a);
    } 
    a a1 = a(parama1, 0, -1, "HEAD");
    if (a1 == null)
      return null; 
    try {
      a a2;
      String str = d.a(a1, false, false);
      if (str == null) {
        a2 = d.a(a1, this.b, this.h, this.i.c.a);
        if (e.c)
          Log.w("TAG_PROXY_ProxyTask", "get header from network"); 
        return d.a(a2, paramb.b()).getBytes(d.a);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(", rawKey: ");
      stringBuilder.append(this.g);
      stringBuilder.append(", url: ");
      stringBuilder.append(a2);
      throw new c(stringBuilder.toString());
    } finally {
      d.a(a1.d());
    } 
  }
  
  private void b(b paramb, l.a parama) throws IOException, d, VAdError {
    byte[] arrayOfByte = a(this.b.a(this.h, this.i.c.a), paramb, parama);
    if (arrayOfByte == null)
      return; 
    paramb.a(arrayOfByte, 0, arrayOfByte.length);
  }
  
  private void c(b paramb, l.a parama) throws h.a, d, IOException, a, b, VAdError {
    if (this.q) {
      int i;
      File file = this.a.c(this.h);
      long l1 = file.length();
      a a1 = this.b.a(this.h, this.i.c.a);
      int j = paramb.b();
      long l2 = l1 - j;
      int k = (int)l2;
      if (a1 == null) {
        i = -1;
      } else {
        i = a1.c;
      } 
      if (l1 > paramb.b()) {
        if (e.c) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("cache hit, remainSize: ");
          stringBuilder.append(l2);
          Log.i("TAG_PROXY_ProxyTask", stringBuilder.toString());
        } 
        a(true, k, i, (int)l1, j);
        a(a1, file, paramb, parama);
        return;
      } 
      a(false, k, i, (int)l1, j);
    } else {
      a(false, 0, 0, 0, paramb.b());
    } 
    d(paramb, parama);
  }
  
  private void d(b paramb, l.a parama) throws d, IOException, a, b, VAdError {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial i : ()V
    //   4: invokestatic elapsedRealtime : ()J
    //   7: lstore #8
    //   9: aload_1
    //   10: invokevirtual b : ()I
    //   13: istore #4
    //   15: aload_0
    //   16: aload_2
    //   17: iload #4
    //   19: aload_0
    //   20: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   23: getfield c : Lcom/bytedance/sdk/openadsdk/h/i$a;
    //   26: getfield e : I
    //   29: ldc_w 'GET'
    //   32: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/l$a;IILjava/lang/String;)Lcom/bytedance/sdk/openadsdk/h/e/a;
    //   35: astore #14
    //   37: aload #14
    //   39: ifnonnull -> 43
    //   42: return
    //   43: aconst_null
    //   44: astore #13
    //   46: iconst_0
    //   47: istore_3
    //   48: aload #14
    //   50: iconst_0
    //   51: iconst_1
    //   52: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/e/a;ZZ)Ljava/lang/String;
    //   55: astore #11
    //   57: aload #11
    //   59: ifnonnull -> 943
    //   62: aload_0
    //   63: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   66: aload_0
    //   67: getfield h : Ljava/lang/String;
    //   70: aload_0
    //   71: invokevirtual f : ()I
    //   74: invokevirtual a : (Ljava/lang/String;I)Lcom/bytedance/sdk/openadsdk/h/b/a;
    //   77: astore #11
    //   79: aload #14
    //   81: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/e/a;)I
    //   84: istore #5
    //   86: aload #11
    //   88: ifnull -> 277
    //   91: aload #11
    //   93: getfield c : I
    //   96: iload #5
    //   98: if_icmpeq -> 277
    //   101: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   104: ifeq -> 175
    //   107: new java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial <init> : ()V
    //   114: astore_1
    //   115: aload_1
    //   116: ldc_w 'Content-Length not match, old: '
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_1
    //   124: aload #11
    //   126: getfield c : I
    //   129: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: ldc_w ', '
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: iload #5
    //   144: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: ldc_w ', key: '
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_1
    //   157: aload_0
    //   158: getfield h : Ljava/lang/String;
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: ldc 'TAG_PROXY_ProxyTask'
    //   167: aload_1
    //   168: invokevirtual toString : ()Ljava/lang/String;
    //   171: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: new java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial <init> : ()V
    //   182: astore_1
    //   183: aload_1
    //   184: ldc_w 'Content-Length not match, old length: '
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: aload #11
    //   194: getfield c : I
    //   197: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: ldc_w ', new length: '
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: iload #5
    //   212: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_1
    //   217: ldc_w ', rawKey: '
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload_0
    //   226: getfield g : Ljava/lang/String;
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: ldc_w ', currentUrl: '
    //   237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_1
    //   242: aload_2
    //   243: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_1
    //   248: ldc_w ', previousInfo: '
    //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_1
    //   256: aload #11
    //   258: getfield e : Ljava/lang/String;
    //   261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: new com/bytedance/sdk/openadsdk/h/c/b
    //   268: dup
    //   269: aload_1
    //   270: invokevirtual toString : ()Ljava/lang/String;
    //   273: invokespecial <init> : (Ljava/lang/String;)V
    //   276: athrow
    //   277: aload_1
    //   278: invokevirtual a : ()Z
    //   281: ifne -> 312
    //   284: aload #14
    //   286: iload #4
    //   288: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/e/a;I)Ljava/lang/String;
    //   291: astore_2
    //   292: aload_0
    //   293: invokevirtual e : ()V
    //   296: aload_2
    //   297: getstatic com/bytedance/sdk/openadsdk/h/g/d.a : Ljava/nio/charset/Charset;
    //   300: invokevirtual getBytes : (Ljava/nio/charset/Charset;)[B
    //   303: astore_2
    //   304: aload_1
    //   305: aload_2
    //   306: iconst_0
    //   307: aload_2
    //   308: arraylength
    //   309: invokevirtual a : ([BII)V
    //   312: aload_0
    //   313: invokevirtual e : ()V
    //   316: aload_0
    //   317: getfield a : Lcom/bytedance/sdk/openadsdk/h/a/a;
    //   320: aload_0
    //   321: getfield h : Ljava/lang/String;
    //   324: invokevirtual d : (Ljava/lang/String;)Ljava/io/File;
    //   327: astore #15
    //   329: aload_0
    //   330: getfield q : Z
    //   333: istore #10
    //   335: iload #10
    //   337: ifeq -> 530
    //   340: aload #15
    //   342: ifnull -> 530
    //   345: aload #15
    //   347: invokevirtual length : ()J
    //   350: aload_1
    //   351: invokevirtual b : ()I
    //   354: i2l
    //   355: lcmp
    //   356: iflt -> 530
    //   359: aload #14
    //   361: aload_0
    //   362: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   365: aload_0
    //   366: getfield h : Ljava/lang/String;
    //   369: aload_0
    //   370: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   373: getfield c : Lcom/bytedance/sdk/openadsdk/h/i$a;
    //   376: getfield a : I
    //   379: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/e/a;Lcom/bytedance/sdk/openadsdk/h/b/c;Ljava/lang/String;I)Lcom/bytedance/sdk/openadsdk/h/b/a;
    //   382: pop
    //   383: new com/bytedance/sdk/openadsdk/h/h
    //   386: dup
    //   387: aload #15
    //   389: ldc_w 'rwd'
    //   392: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   395: astore #12
    //   397: aload #12
    //   399: astore_2
    //   400: aload #12
    //   402: aload_1
    //   403: invokevirtual b : ()I
    //   406: i2l
    //   407: invokevirtual a : (J)V
    //   410: goto -> 433
    //   413: astore #11
    //   415: aload #12
    //   417: astore_2
    //   418: goto -> 425
    //   421: astore #11
    //   423: aconst_null
    //   424: astore_2
    //   425: aload #11
    //   427: invokevirtual printStackTrace : ()V
    //   430: aconst_null
    //   431: astore #12
    //   433: aload #12
    //   435: astore #11
    //   437: aload #12
    //   439: astore_2
    //   440: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   443: ifeq -> 592
    //   446: aload #12
    //   448: astore_2
    //   449: new java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial <init> : ()V
    //   456: astore #11
    //   458: aload #12
    //   460: astore_2
    //   461: aload #11
    //   463: ldc_w 'can write to cache file in network task, cache file size: '
    //   466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload #12
    //   472: astore_2
    //   473: aload #11
    //   475: aload #15
    //   477: invokevirtual length : ()J
    //   480: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload #12
    //   486: astore_2
    //   487: aload #11
    //   489: ldc_w ', from: '
    //   492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload #12
    //   498: astore_2
    //   499: aload #11
    //   501: aload_1
    //   502: invokevirtual b : ()I
    //   505: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload #12
    //   511: astore_2
    //   512: ldc 'TAG_PROXY_ProxyTask'
    //   514: aload #11
    //   516: invokevirtual toString : ()Ljava/lang/String;
    //   519: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   522: pop
    //   523: aload #12
    //   525: astore #11
    //   527: goto -> 592
    //   530: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   533: ifeq -> 589
    //   536: new java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial <init> : ()V
    //   543: astore_2
    //   544: aload_2
    //   545: ldc_w 'can't write to cache file in network task, cache file size: '
    //   548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload_2
    //   553: aload #15
    //   555: invokevirtual length : ()J
    //   558: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload_2
    //   563: ldc_w ', from: '
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload_2
    //   571: aload_1
    //   572: invokevirtual b : ()I
    //   575: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: ldc 'TAG_PROXY_ProxyTask'
    //   581: aload_2
    //   582: invokevirtual toString : ()Ljava/lang/String;
    //   585: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   588: pop
    //   589: aconst_null
    //   590: astore #11
    //   592: aload #11
    //   594: astore_2
    //   595: aload_0
    //   596: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   599: aload_0
    //   600: getfield h : Ljava/lang/String;
    //   603: aload_0
    //   604: invokevirtual f : ()I
    //   607: invokevirtual a : (Ljava/lang/String;I)Lcom/bytedance/sdk/openadsdk/h/b/a;
    //   610: astore #12
    //   612: aload #12
    //   614: ifnonnull -> 623
    //   617: iconst_0
    //   618: istore #6
    //   620: goto -> 633
    //   623: aload #11
    //   625: astore_2
    //   626: aload #12
    //   628: getfield c : I
    //   631: istore #6
    //   633: aload #11
    //   635: astore_2
    //   636: sipush #8192
    //   639: newarray byte
    //   641: astore #15
    //   643: aload #11
    //   645: astore_2
    //   646: aload #14
    //   648: invokevirtual d : ()Ljava/io/InputStream;
    //   651: astore #16
    //   653: iconst_0
    //   654: istore #4
    //   656: iload #4
    //   658: istore_3
    //   659: aload #11
    //   661: astore_2
    //   662: aload #16
    //   664: aload #15
    //   666: invokevirtual read : ([B)I
    //   669: istore #7
    //   671: iload #7
    //   673: iflt -> 855
    //   676: iload #4
    //   678: istore_3
    //   679: aload #11
    //   681: astore_2
    //   682: aload_0
    //   683: invokevirtual e : ()V
    //   686: iload #4
    //   688: istore #5
    //   690: aload #11
    //   692: astore #12
    //   694: iload #7
    //   696: ifle -> 834
    //   699: iload #4
    //   701: istore_3
    //   702: aload #11
    //   704: astore_2
    //   705: aload_1
    //   706: aload #15
    //   708: iconst_0
    //   709: iload #7
    //   711: invokevirtual b : ([BII)V
    //   714: iload #4
    //   716: iload #7
    //   718: iadd
    //   719: istore #5
    //   721: aload #11
    //   723: astore #12
    //   725: aload #11
    //   727: ifnull -> 818
    //   730: aload #11
    //   732: aload #15
    //   734: iconst_0
    //   735: iload #7
    //   737: invokevirtual a : ([BII)V
    //   740: aload #11
    //   742: astore #12
    //   744: goto -> 818
    //   747: astore #12
    //   749: iload #5
    //   751: istore_3
    //   752: aload #11
    //   754: astore_2
    //   755: aload #11
    //   757: invokevirtual a : ()V
    //   760: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   763: ifeq -> 802
    //   766: new java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial <init> : ()V
    //   773: astore_2
    //   774: aload_2
    //   775: ldc_w 'append to cache file error in network task!!! '
    //   778: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload_2
    //   783: aload #12
    //   785: invokestatic getStackTraceString : (Ljava/lang/Throwable;)Ljava/lang/String;
    //   788: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: ldc 'TAG_PROXY_ProxyTask'
    //   794: aload_2
    //   795: invokevirtual toString : ()Ljava/lang/String;
    //   798: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   801: pop
    //   802: aconst_null
    //   803: astore #12
    //   805: goto -> 818
    //   808: astore_1
    //   809: iload #5
    //   811: istore_3
    //   812: aload #13
    //   814: astore_2
    //   815: goto -> 1004
    //   818: iload #5
    //   820: istore_3
    //   821: aload #12
    //   823: astore_2
    //   824: aload_0
    //   825: iload #6
    //   827: aload_1
    //   828: invokevirtual b : ()I
    //   831: invokevirtual a : (II)V
    //   834: iload #5
    //   836: istore_3
    //   837: aload #12
    //   839: astore_2
    //   840: aload_0
    //   841: invokevirtual e : ()V
    //   844: iload #5
    //   846: istore #4
    //   848: aload #12
    //   850: astore #11
    //   852: goto -> 656
    //   855: iload #4
    //   857: istore_3
    //   858: aload #11
    //   860: astore_2
    //   861: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   864: ifeq -> 882
    //   867: iload #4
    //   869: istore_3
    //   870: aload #11
    //   872: astore_2
    //   873: ldc 'TAG_PROXY_ProxyTask'
    //   875: ldc_w 'read from net complete!'
    //   878: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   881: pop
    //   882: iload #4
    //   884: istore_3
    //   885: aload #11
    //   887: astore_2
    //   888: aload_0
    //   889: invokevirtual c : ()V
    //   892: aload #14
    //   894: invokevirtual d : ()Ljava/io/InputStream;
    //   897: invokestatic a : (Ljava/io/Closeable;)V
    //   900: aload #11
    //   902: ifnull -> 910
    //   905: aload #11
    //   907: invokevirtual a : ()V
    //   910: aload_0
    //   911: getfield c : Ljava/util/concurrent/atomic/AtomicInteger;
    //   914: iload #4
    //   916: invokevirtual addAndGet : (I)I
    //   919: pop
    //   920: aload_0
    //   921: getfield d : Ljava/util/concurrent/atomic/AtomicLong;
    //   924: invokestatic elapsedRealtime : ()J
    //   927: lload #8
    //   929: lsub
    //   930: invokevirtual addAndGet : (J)J
    //   933: pop2
    //   934: return
    //   935: astore_1
    //   936: goto -> 1004
    //   939: astore_1
    //   940: goto -> 1004
    //   943: new java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial <init> : ()V
    //   950: astore_1
    //   951: aload_1
    //   952: aload #11
    //   954: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload_1
    //   959: ldc_w ', rawKey: '
    //   962: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload_1
    //   967: aload_0
    //   968: getfield g : Ljava/lang/String;
    //   971: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload_1
    //   976: ldc ', url: '
    //   978: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload_1
    //   983: aload_2
    //   984: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: new com/bytedance/sdk/openadsdk/h/c/c
    //   991: dup
    //   992: aload_1
    //   993: invokevirtual toString : ()Ljava/lang/String;
    //   996: invokespecial <init> : (Ljava/lang/String;)V
    //   999: athrow
    //   1000: astore_1
    //   1001: aload #13
    //   1003: astore_2
    //   1004: aload #14
    //   1006: invokevirtual d : ()Ljava/io/InputStream;
    //   1009: invokestatic a : (Ljava/io/Closeable;)V
    //   1012: aload_2
    //   1013: ifnull -> 1020
    //   1016: aload_2
    //   1017: invokevirtual a : ()V
    //   1020: aload_0
    //   1021: getfield c : Ljava/util/concurrent/atomic/AtomicInteger;
    //   1024: iload_3
    //   1025: invokevirtual addAndGet : (I)I
    //   1028: pop
    //   1029: aload_0
    //   1030: getfield d : Ljava/util/concurrent/atomic/AtomicLong;
    //   1033: invokestatic elapsedRealtime : ()J
    //   1036: lload #8
    //   1038: lsub
    //   1039: invokevirtual addAndGet : (J)J
    //   1042: pop2
    //   1043: aload_1
    //   1044: athrow
    // Exception table:
    //   from	to	target	type
    //   48	57	1000	finally
    //   62	86	1000	finally
    //   91	175	1000	finally
    //   175	277	1000	finally
    //   277	312	1000	finally
    //   312	335	1000	finally
    //   345	383	1000	finally
    //   383	397	421	com/bytedance/sdk/openadsdk/h/h$a
    //   383	397	1000	finally
    //   400	410	413	com/bytedance/sdk/openadsdk/h/h$a
    //   400	410	939	finally
    //   425	430	939	finally
    //   440	446	939	finally
    //   449	458	939	finally
    //   461	470	939	finally
    //   473	484	939	finally
    //   487	496	939	finally
    //   499	509	939	finally
    //   512	523	939	finally
    //   530	589	1000	finally
    //   595	612	939	finally
    //   626	633	939	finally
    //   636	643	939	finally
    //   646	653	939	finally
    //   662	671	935	finally
    //   682	686	935	finally
    //   705	714	935	finally
    //   730	740	747	finally
    //   755	760	935	finally
    //   760	802	808	finally
    //   824	834	935	finally
    //   840	844	935	finally
    //   861	867	935	finally
    //   873	882	935	finally
    //   888	892	935	finally
    //   943	1000	1000	finally
  }
  
  private b h() {
    try {
      c c1;
      this.i = i.a(this.m.getInputStream());
      OutputStream outputStream = this.m.getOutputStream();
      if (this.i.c.a == 1) {
        b b1 = e.a;
      } else {
        c1 = e.b;
      } 
      if (c1 == null) {
        if (e.c) {
          Log.e("TAG_PROXY_ProxyTask", "cache is null");
          return null;
        } 
      } else {
        this.a = (a)c1;
        this.g = this.i.c.b;
        this.h = this.i.c.c;
        this.j = new l(this.i.c.g);
        this.f = this.i.b;
        if (e.c) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("request from MediaPlayer:    ");
          stringBuilder.append(this.i.toString());
          Log.i("TAG_PROXY_ProxyTask", stringBuilder.toString());
        } 
        return new b(outputStream, this.i.c.d);
      } 
    } catch (IOException iOException) {
      Boolean bool;
      d.a(this.m);
      if (e.c)
        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(iOException)); 
      if (this.a == null) {
        bool = null;
      } else {
        bool = Boolean.valueOf(g());
      } 
      a(bool, this.g, iOException);
      return null;
    } catch (d d1) {
      Boolean bool;
      d.a(this.m);
      if (e.c)
        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(d1)); 
      if (this.a == null) {
        bool = null;
      } else {
        bool = Boolean.valueOf(g());
      } 
      a(bool, this.g, d1);
      return null;
    } 
    return null;
  }
  
  private void i() {
    b b1 = this.p;
    this.p = null;
    if (b1 != null)
      b1.a(); 
  }
  
  public void a() {
    super.a();
    i();
  }
  
  public void run() {
    b b1 = h();
    if (b1 == null)
      return; 
    c c2 = this.n;
    if (c2 != null)
      c2.a(this); 
    this.a.a(this.h);
    if (e.h != 0) {
      a a1 = this.b.a(this.h, this.i.c.a);
      if (a1 == null || this.a.c(this.h).length() < a1.c)
        this.o.a(g(), this.h); 
    } 
    try {
      a(b1);
    } catch (a a1) {
    
    } catch (VAdError vAdError) {
    
    } finally {
      b1 = null;
    } 
    this.o.a(g(), null);
    a();
    d.a(this.m);
    c c1 = this.n;
    if (c1 != null)
      c1.b(this); 
  }
  
  static final class a {
    a a;
    
    c b;
    
    Socket c;
    
    g.c d;
    
    a a(c param1c) {
      if (param1c != null) {
        this.b = param1c;
        return this;
      } 
      throw new IllegalArgumentException("db == null");
    }
    
    a a(g.c param1c) {
      this.d = param1c;
      return this;
    }
    
    a a(Socket param1Socket) {
      if (param1Socket != null) {
        this.c = param1Socket;
        return this;
      } 
      throw new IllegalArgumentException("socket == null");
    }
    
    g a() {
      if (this.b != null && this.c != null)
        return new g(this); 
      throw new IllegalArgumentException();
    }
  }
  
  static class b {
    private final OutputStream a;
    
    private int b;
    
    private boolean c;
    
    b(OutputStream param1OutputStream, int param1Int) {
      this.a = param1OutputStream;
      this.b = param1Int;
    }
    
    void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws d {
      if (!this.c)
        try {
          this.a.write(param1ArrayOfbyte, param1Int1, param1Int2);
          this.c = true;
          return;
        } catch (IOException iOException) {
          throw new d(iOException);
        }  
    }
    
    boolean a() {
      return this.c;
    }
    
    int b() {
      return this.b;
    }
    
    void b(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws d {
      try {
        this.a.write(param1ArrayOfbyte, param1Int1, param1Int2);
        this.b += param1Int2;
        return;
      } catch (IOException iOException) {
        throw new d(iOException);
      } 
    }
  }
  
  public static interface c {
    void a(g param1g);
    
    void b(g param1g);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */