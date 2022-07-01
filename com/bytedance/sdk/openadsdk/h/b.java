package com.bytedance.sdk.openadsdk.h;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.a.a;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.h.c.a;
import com.bytedance.sdk.openadsdk.h.c.b;
import com.bytedance.sdk.openadsdk.h.c.c;
import java.io.IOException;
import java.util.List;

class b extends a {
  final Object m;
  
  final Object n;
  
  private final int o;
  
  private final b p;
  
  private volatile h.a q;
  
  private volatile b r;
  
  b(a parama) {
    super(parama.d, parama.e);
    this.o = parama.g;
    this.p = parama.i;
    this.m = this;
    this.g = parama.a;
    this.h = parama.b;
    this.f = parama.f;
    this.j = parama.c;
    this.i = parama.h;
    this.n = parama.j;
  }
  
  private void a(l.a parama) throws IOException, h.a, a, b, VAdError {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Lcom/bytedance/sdk/openadsdk/h/a/a;
    //   4: aload_0
    //   5: getfield h : Ljava/lang/String;
    //   8: invokevirtual c : (Ljava/lang/String;)Ljava/io/File;
    //   11: astore #10
    //   13: aload #10
    //   15: invokevirtual length : ()J
    //   18: lstore #7
    //   20: aload_0
    //   21: getfield o : I
    //   24: istore_2
    //   25: iload_2
    //   26: ifle -> 108
    //   29: lload #7
    //   31: iload_2
    //   32: i2l
    //   33: lcmp
    //   34: iflt -> 108
    //   37: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   40: ifeq -> 107
    //   43: new java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial <init> : ()V
    //   50: astore_1
    //   51: aload_1
    //   52: ldc 'no necessary to download for '
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: aload_0
    //   60: getfield h : Ljava/lang/String;
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_1
    //   68: ldc ', cache file size: '
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: lload #7
    //   77: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: ldc ', max: '
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: aload_0
    //   90: getfield o : I
    //   93: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: ldc 'TAG_PROXY_DownloadTask'
    //   99: aload_1
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: return
    //   108: aload_0
    //   109: invokevirtual f : ()I
    //   112: istore_2
    //   113: aload_0
    //   114: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   117: aload_0
    //   118: getfield h : Ljava/lang/String;
    //   121: iload_2
    //   122: invokevirtual a : (Ljava/lang/String;I)Lcom/bytedance/sdk/openadsdk/h/b/a;
    //   125: astore #13
    //   127: aload #13
    //   129: ifnull -> 185
    //   132: lload #7
    //   134: aload #13
    //   136: getfield c : I
    //   139: i2l
    //   140: lcmp
    //   141: iflt -> 185
    //   144: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   147: ifeq -> 184
    //   150: new java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial <init> : ()V
    //   157: astore_1
    //   158: aload_1
    //   159: ldc 'file download complete, key: '
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: aload_0
    //   167: getfield h : Ljava/lang/String;
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: ldc 'TAG_PROXY_DownloadTask'
    //   176: aload_1
    //   177: invokevirtual toString : ()Ljava/lang/String;
    //   180: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: return
    //   185: aload_0
    //   186: invokevirtual e : ()V
    //   189: lload #7
    //   191: l2i
    //   192: istore_3
    //   193: aload_0
    //   194: aload_1
    //   195: iload_3
    //   196: aload_0
    //   197: getfield o : I
    //   200: ldc 'GET'
    //   202: invokevirtual a : (Lcom/bytedance/sdk/openadsdk/h/l$a;IILjava/lang/String;)Lcom/bytedance/sdk/openadsdk/h/e/a;
    //   205: astore #12
    //   207: aload #12
    //   209: ifnonnull -> 213
    //   212: return
    //   213: aconst_null
    //   214: astore #11
    //   216: iconst_1
    //   217: istore #5
    //   219: aload_0
    //   220: invokevirtual e : ()V
    //   223: aload_0
    //   224: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   227: ifnonnull -> 968
    //   230: getstatic com/bytedance/sdk/openadsdk/h/e.e : Z
    //   233: ifeq -> 968
    //   236: iconst_1
    //   237: istore #9
    //   239: goto -> 242
    //   242: aload #12
    //   244: iload #9
    //   246: iconst_1
    //   247: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/e/a;ZZ)Ljava/lang/String;
    //   250: astore #14
    //   252: aload #14
    //   254: ifnonnull -> 854
    //   257: aload #12
    //   259: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/e/a;)I
    //   262: istore #4
    //   264: aload #13
    //   266: ifnull -> 467
    //   269: aload #13
    //   271: getfield c : I
    //   274: iload #4
    //   276: if_icmpeq -> 467
    //   279: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   282: ifeq -> 358
    //   285: new java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial <init> : ()V
    //   292: astore #10
    //   294: aload #10
    //   296: ldc 'Content-Length not match, old: '
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload #10
    //   304: aload #13
    //   306: getfield c : I
    //   309: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload #10
    //   315: ldc ', '
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload #10
    //   323: iload #4
    //   325: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload #10
    //   331: ldc ', key: '
    //   333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload #10
    //   339: aload_0
    //   340: getfield h : Ljava/lang/String;
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: ldc 'TAG_PROXY_DownloadTask'
    //   349: aload #10
    //   351: invokevirtual toString : ()Ljava/lang/String;
    //   354: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   357: pop
    //   358: new java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial <init> : ()V
    //   365: astore #10
    //   367: aload #10
    //   369: ldc 'Content-Length not match, old length: '
    //   371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload #10
    //   377: aload #13
    //   379: getfield c : I
    //   382: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload #10
    //   388: ldc ', new length: '
    //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload #10
    //   396: iload #4
    //   398: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload #10
    //   404: ldc ', rawKey: '
    //   406: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload #10
    //   412: aload_0
    //   413: getfield g : Ljava/lang/String;
    //   416: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload #10
    //   422: ldc ', currentUrl: '
    //   424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload #10
    //   430: aload_1
    //   431: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload #10
    //   437: ldc ', previousInfo: '
    //   439: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload #10
    //   445: aload #13
    //   447: getfield e : Ljava/lang/String;
    //   450: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: new com/bytedance/sdk/openadsdk/h/c/b
    //   457: dup
    //   458: aload #10
    //   460: invokevirtual toString : ()Ljava/lang/String;
    //   463: invokespecial <init> : (Ljava/lang/String;)V
    //   466: athrow
    //   467: aload #12
    //   469: aload_0
    //   470: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   473: aload_0
    //   474: getfield h : Ljava/lang/String;
    //   477: iload_2
    //   478: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/e/a;Lcom/bytedance/sdk/openadsdk/h/b/c;Ljava/lang/String;I)Lcom/bytedance/sdk/openadsdk/h/b/a;
    //   481: pop
    //   482: aload_0
    //   483: getfield b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   486: aload_0
    //   487: getfield h : Ljava/lang/String;
    //   490: iload_2
    //   491: invokevirtual a : (Ljava/lang/String;I)Lcom/bytedance/sdk/openadsdk/h/b/a;
    //   494: astore_1
    //   495: aload_1
    //   496: ifnonnull -> 504
    //   499: iconst_0
    //   500: istore_2
    //   501: goto -> 509
    //   504: aload_1
    //   505: getfield c : I
    //   508: istore_2
    //   509: aload #12
    //   511: invokevirtual d : ()Ljava/io/InputStream;
    //   514: astore #13
    //   516: getstatic com/bytedance/sdk/openadsdk/h/e.d : Z
    //   519: ifeq -> 974
    //   522: ldc 'rwd'
    //   524: astore_1
    //   525: goto -> 528
    //   528: new com/bytedance/sdk/openadsdk/h/h
    //   531: dup
    //   532: aload #10
    //   534: aload_1
    //   535: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   538: astore_1
    //   539: aload_1
    //   540: lload #7
    //   542: invokevirtual a : (J)V
    //   545: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   548: ifeq -> 587
    //   551: new java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial <init> : ()V
    //   558: astore #10
    //   560: aload #10
    //   562: ldc 'preload start from: '
    //   564: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload #10
    //   570: lload #7
    //   572: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: ldc 'TAG_PROXY_DownloadTask'
    //   578: aload #10
    //   580: invokevirtual toString : ()Ljava/lang/String;
    //   583: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   586: pop
    //   587: sipush #8192
    //   590: newarray byte
    //   592: astore #11
    //   594: aload #13
    //   596: aload #11
    //   598: invokevirtual read : ([B)I
    //   601: istore #6
    //   603: iload #6
    //   605: iflt -> 807
    //   608: aload_0
    //   609: invokevirtual e : ()V
    //   612: iload_3
    //   613: istore #4
    //   615: iload #6
    //   617: ifle -> 689
    //   620: aload_1
    //   621: aload #11
    //   623: iconst_0
    //   624: iload #6
    //   626: invokevirtual a : ([BII)V
    //   629: iload_3
    //   630: iload #6
    //   632: iadd
    //   633: istore #4
    //   635: aload_0
    //   636: getfield i : Lcom/bytedance/sdk/openadsdk/h/i;
    //   639: ifnull -> 672
    //   642: aload_0
    //   643: getfield m : Ljava/lang/Object;
    //   646: astore #10
    //   648: aload #10
    //   650: monitorenter
    //   651: aload_0
    //   652: getfield m : Ljava/lang/Object;
    //   655: invokevirtual notifyAll : ()V
    //   658: aload #10
    //   660: monitorexit
    //   661: goto -> 672
    //   664: astore #11
    //   666: aload #10
    //   668: monitorexit
    //   669: aload #11
    //   671: athrow
    //   672: aload_0
    //   673: getfield c : Ljava/util/concurrent/atomic/AtomicInteger;
    //   676: iload #6
    //   678: invokevirtual addAndGet : (I)I
    //   681: pop
    //   682: aload_0
    //   683: iload_2
    //   684: iload #4
    //   686: invokevirtual a : (II)V
    //   689: aload_0
    //   690: getfield o : I
    //   693: ifle -> 797
    //   696: iload #4
    //   698: aload_0
    //   699: getfield o : I
    //   702: if_icmplt -> 797
    //   705: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   708: ifeq -> 765
    //   711: new java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial <init> : ()V
    //   718: astore #10
    //   720: aload #10
    //   722: ldc 'download, more data received, currentCacheFileSize: '
    //   724: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload #10
    //   730: iload #4
    //   732: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload #10
    //   738: ldc ', max: '
    //   740: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload #10
    //   746: aload_0
    //   747: getfield o : I
    //   750: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: ldc 'TAG_PROXY_DownloadTask'
    //   756: aload #10
    //   758: invokevirtual toString : ()Ljava/lang/String;
    //   761: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   764: pop
    //   765: aload #12
    //   767: invokevirtual d : ()Ljava/io/InputStream;
    //   770: invokestatic a : (Ljava/io/Closeable;)V
    //   773: aload_1
    //   774: invokevirtual a : ()V
    //   777: aload_0
    //   778: invokevirtual a : ()V
    //   781: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   784: ifeq -> 796
    //   787: ldc 'TAG_PROXY_DownloadTask'
    //   789: ldc_w 'cancel call'
    //   792: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   795: pop
    //   796: return
    //   797: aload_0
    //   798: invokevirtual e : ()V
    //   801: iload #4
    //   803: istore_3
    //   804: goto -> 594
    //   807: aload_0
    //   808: invokevirtual c : ()V
    //   811: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   814: ifeq -> 826
    //   817: ldc 'TAG_PROXY_DownloadTask'
    //   819: ldc_w 'download succeed, no need to cancel call'
    //   822: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   825: pop
    //   826: aload #12
    //   828: invokevirtual d : ()Ljava/io/InputStream;
    //   831: invokestatic a : (Ljava/io/Closeable;)V
    //   834: aload_1
    //   835: invokevirtual a : ()V
    //   838: return
    //   839: astore #10
    //   841: iconst_0
    //   842: istore_2
    //   843: goto -> 926
    //   846: astore #10
    //   848: iload #5
    //   850: istore_2
    //   851: goto -> 926
    //   854: new java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial <init> : ()V
    //   861: astore #10
    //   863: aload #10
    //   865: aload #14
    //   867: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload #10
    //   873: ldc ', rawKey: '
    //   875: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload #10
    //   881: aload_0
    //   882: getfield g : Ljava/lang/String;
    //   885: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: aload #10
    //   891: ldc_w ', url: '
    //   894: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: pop
    //   898: aload #10
    //   900: aload_1
    //   901: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: new com/bytedance/sdk/openadsdk/h/c/c
    //   908: dup
    //   909: aload #10
    //   911: invokevirtual toString : ()Ljava/lang/String;
    //   914: invokespecial <init> : (Ljava/lang/String;)V
    //   917: athrow
    //   918: astore #10
    //   920: iload #5
    //   922: istore_2
    //   923: aload #11
    //   925: astore_1
    //   926: aload #12
    //   928: invokevirtual d : ()Ljava/io/InputStream;
    //   931: invokestatic a : (Ljava/io/Closeable;)V
    //   934: aload_1
    //   935: ifnull -> 942
    //   938: aload_1
    //   939: invokevirtual a : ()V
    //   942: iload_2
    //   943: ifeq -> 965
    //   946: aload_0
    //   947: invokevirtual a : ()V
    //   950: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   953: ifeq -> 965
    //   956: ldc 'TAG_PROXY_DownloadTask'
    //   958: ldc_w 'cancel call'
    //   961: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   964: pop
    //   965: aload #10
    //   967: athrow
    //   968: iconst_0
    //   969: istore #9
    //   971: goto -> 242
    //   974: ldc_w 'rw'
    //   977: astore_1
    //   978: goto -> 528
    // Exception table:
    //   from	to	target	type
    //   219	236	918	finally
    //   242	252	918	finally
    //   257	264	918	finally
    //   269	358	918	finally
    //   358	467	918	finally
    //   467	495	918	finally
    //   504	509	918	finally
    //   509	522	918	finally
    //   528	539	918	finally
    //   539	587	846	finally
    //   587	594	846	finally
    //   594	603	846	finally
    //   608	612	846	finally
    //   620	629	846	finally
    //   635	651	846	finally
    //   651	661	664	finally
    //   666	669	664	finally
    //   669	672	846	finally
    //   672	689	846	finally
    //   689	765	846	finally
    //   797	801	846	finally
    //   807	826	839	finally
    //   854	918	918	finally
  }
  
  private boolean j() throws a, VAdError {
    while (this.j.a()) {
      e();
      l.a a1 = this.j.b();
      try {
        return true;
      } catch (c c) {
      
      } catch (IOException iOException) {
        if (iOException instanceof java.net.SocketTimeoutException)
          a1.b(); 
      } catch (a a2) {
        return false;
      } catch (b b1) {
        return false;
      } finally {
        a1 = null;
        if (e.c)
          Log.e("TAG_PROXY_DownloadTask", Log.getStackTraceString((Throwable)a1)); 
      } 
    } 
    return false;
  }
  
  h.a h() {
    return this.q;
  }
  
  b i() {
    return this.r;
  }
  
  public void run() {
    this.a.a(this.h);
    long l = SystemClock.elapsedRealtime();
    try {
      j();
    } catch (a a1) {
    
    } catch (com.bytedance.sdk.adnet.err.a a1) {
    
    } catch (VAdError vAdError) {
    
    } finally {
      Exception exception = null;
    } 
    this.a.b(this.h);
    b b1 = this.p;
    if (b1 != null)
      b1.a(this); 
  }
  
  static final class a {
    String a;
    
    String b;
    
    l c;
    
    a d;
    
    c e;
    
    List<i.b> f;
    
    int g;
    
    i h;
    
    b.b i;
    
    Object j;
    
    a a(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    a a(a param1a) {
      if (param1a != null) {
        this.d = param1a;
        return this;
      } 
      throw new IllegalArgumentException("cache == null");
    }
    
    a a(b.b param1b) {
      this.i = param1b;
      return this;
    }
    
    a a(c param1c) {
      if (param1c != null) {
        this.e = param1c;
        return this;
      } 
      throw new IllegalArgumentException("db == null");
    }
    
    a a(i param1i) {
      this.h = param1i;
      return this;
    }
    
    a a(l param1l) {
      if (param1l != null) {
        this.c = param1l;
        return this;
      } 
      throw new IllegalArgumentException("urls is empty");
    }
    
    a a(Object param1Object) {
      this.j = param1Object;
      return this;
    }
    
    a a(String param1String) {
      if (!TextUtils.isEmpty(param1String)) {
        this.a = param1String;
        return this;
      } 
      throw new IllegalArgumentException("rawKey == null");
    }
    
    a a(List<i.b> param1List) {
      this.f = param1List;
      return this;
    }
    
    b a() {
      if (this.d != null && this.e != null && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && this.c != null)
        return new b(this); 
      throw new IllegalArgumentException();
    }
    
    a b(String param1String) {
      if (!TextUtils.isEmpty(param1String)) {
        this.b = param1String;
        return this;
      } 
      throw new IllegalArgumentException("key == null");
    }
  }
  
  public static interface b {
    void a(b param1b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */