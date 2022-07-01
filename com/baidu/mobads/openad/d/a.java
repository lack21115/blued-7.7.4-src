package com.baidu.mobads.openad.d;

import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.aa;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class a extends c {
  public static int a = 1024;
  
  private static final TimeUnit f = TimeUnit.SECONDS;
  
  private static int g = 5;
  
  private static BlockingQueue<Runnable> h = new LinkedBlockingQueue<Runnable>();
  
  private static ThreadPoolExecutor i;
  
  private String b;
  
  private Boolean d = Boolean.valueOf(false);
  
  private AtomicBoolean e = new AtomicBoolean();
  
  private IXAdLogger j = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  private IXAdURIUitls k = (IXAdURIUitls)new aa();
  
  static {
    try {
      i = new ThreadPoolExecutor(g, g, 1L, f, h);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(exception);
      return;
    } 
  }
  
  public a() {
    this(null);
  }
  
  public a(String paramString) {
    this.b = paramString;
  }
  
  private static String b(InputStream paramInputStream) {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    String str = "";
    while (true) {
      String str1 = bufferedReader.readLine();
      if (str1 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str1);
        stringBuilder.append("\n");
        str = stringBuilder.toString();
        continue;
      } 
      return str;
    } 
  }
  
  public void a() {}
  
  public void a(b paramb) {
    a(paramb, 20000.0D);
  }
  
  public void a(b paramb, double paramDouble) {
    try {
      i.execute(new a(this, paramb, paramDouble));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a(b paramb, Boolean paramBoolean) {
    this.d = paramBoolean;
    a(paramb, 20000.0D);
  }
  
  public void dispose() {
    this.e.set(true);
    a();
    super.dispose();
  }
  
  class a implements Runnable {
    private b b;
    
    private double c;
    
    public a(a this$0, b param1b, double param1Double) {
      this.b = param1b;
      this.c = param1Double;
    }
    
    public void run() {
      // Byte code:
      //   0: aconst_null
      //   1: astore #5
      //   3: aconst_null
      //   4: astore_3
      //   5: aconst_null
      //   6: astore #4
      //   8: aload_0
      //   9: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   12: getfield c : J
      //   15: lconst_0
      //   16: lcmp
      //   17: ifle -> 30
      //   20: aload_0
      //   21: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   24: getfield c : J
      //   27: invokestatic sleep : (J)V
      //   30: new java/net/URL
      //   33: dup
      //   34: aload_0
      //   35: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   38: getfield a : Ljava/lang/String;
      //   41: invokespecial <init> : (Ljava/lang/String;)V
      //   44: astore_1
      //   45: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   48: invokevirtual getURIUitls : ()Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   51: aload_1
      //   52: invokeinterface getHttpURLConnection : (Ljava/net/URL;)Ljava/net/HttpURLConnection;
      //   57: astore_2
      //   58: aload #5
      //   60: astore_1
      //   61: aload_2
      //   62: aload_0
      //   63: getfield c : D
      //   66: d2i
      //   67: invokevirtual setConnectTimeout : (I)V
      //   70: aload #5
      //   72: astore_1
      //   73: aload_2
      //   74: aload_0
      //   75: getfield c : D
      //   78: d2i
      //   79: invokevirtual setReadTimeout : (I)V
      //   82: aload #5
      //   84: astore_1
      //   85: aload_2
      //   86: iconst_0
      //   87: invokevirtual setUseCaches : (Z)V
      //   90: aload #5
      //   92: astore_1
      //   93: aload_0
      //   94: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   97: getfield b : Ljava/lang/String;
      //   100: ifnull -> 135
      //   103: aload #5
      //   105: astore_1
      //   106: aload_0
      //   107: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   110: getfield b : Ljava/lang/String;
      //   113: invokevirtual length : ()I
      //   116: ifle -> 135
      //   119: aload #5
      //   121: astore_1
      //   122: aload_2
      //   123: ldc 'User-Agent'
      //   125: aload_0
      //   126: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   129: getfield b : Ljava/lang/String;
      //   132: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
      //   135: aload #5
      //   137: astore_1
      //   138: aload_2
      //   139: ldc 'Content-type'
      //   141: aload_0
      //   142: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   145: getfield d : Ljava/lang/String;
      //   148: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
      //   151: aload #5
      //   153: astore_1
      //   154: aload_2
      //   155: ldc 'Connection'
      //   157: ldc 'keep-alive'
      //   159: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
      //   162: aload #5
      //   164: astore_1
      //   165: aload_2
      //   166: ldc 'Cache-Control'
      //   168: ldc 'no-cache'
      //   170: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
      //   173: aload #5
      //   175: astore_1
      //   176: getstatic android/os/Build$VERSION.SDK : Ljava/lang/String;
      //   179: invokestatic parseInt : (Ljava/lang/String;)I
      //   182: bipush #8
      //   184: if_icmpge -> 198
      //   187: aload #5
      //   189: astore_1
      //   190: ldc 'http.keepAlive'
      //   192: ldc 'false'
      //   194: invokestatic setProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   197: pop
      //   198: aload #5
      //   200: astore_1
      //   201: aload_0
      //   202: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   205: getfield e : I
      //   208: iconst_1
      //   209: if_icmpne -> 376
      //   212: aload #5
      //   214: astore_1
      //   215: aload_2
      //   216: ldc 'GET'
      //   218: invokevirtual setRequestMethod : (Ljava/lang/String;)V
      //   221: aload #5
      //   223: astore_1
      //   224: aload_2
      //   225: invokevirtual connect : ()V
      //   228: aload #5
      //   230: astore_1
      //   231: aload_2
      //   232: invokevirtual getHeaderFields : ()Ljava/util/Map;
      //   235: pop
      //   236: aload #5
      //   238: astore_1
      //   239: aload_0
      //   240: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   243: invokestatic a : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   246: astore_3
      //   247: aload #5
      //   249: astore_1
      //   250: new java/lang/StringBuilder
      //   253: dup
      //   254: invokespecial <init> : ()V
      //   257: astore #6
      //   259: aload #5
      //   261: astore_1
      //   262: aload #6
      //   264: ldc 'GET connect code :'
      //   266: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   269: pop
      //   270: aload #5
      //   272: astore_1
      //   273: aload #6
      //   275: aload_2
      //   276: invokevirtual getResponseCode : ()I
      //   279: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   282: pop
      //   283: aload #5
      //   285: astore_1
      //   286: aload_3
      //   287: ldc 'OAdURLLoader'
      //   289: aload #6
      //   291: invokevirtual toString : ()Ljava/lang/String;
      //   294: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   299: pop
      //   300: aload #5
      //   302: astore_1
      //   303: aload_0
      //   304: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   307: invokestatic b : (Lcom/baidu/mobads/openad/d/a;)Ljava/lang/Boolean;
      //   310: invokevirtual booleanValue : ()Z
      //   313: ifne -> 362
      //   316: aload #5
      //   318: astore_1
      //   319: aload_2
      //   320: invokevirtual getInputStream : ()Ljava/io/InputStream;
      //   323: astore_3
      //   324: aload_3
      //   325: astore_1
      //   326: aload_3
      //   327: invokestatic a : (Ljava/io/InputStream;)Ljava/lang/String;
      //   330: astore #4
      //   332: aload_3
      //   333: astore_1
      //   334: aload_0
      //   335: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   338: new com/baidu/mobads/openad/c/d
      //   341: dup
      //   342: ldc 'URLLoader.Load.Complete'
      //   344: aload #4
      //   346: aload_0
      //   347: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   350: invokevirtual a : ()Ljava/lang/String;
      //   353: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   356: invokevirtual dispatchEvent : (Lcom/baidu/mobads/openad/interfaces/event/IOAdEvent;)V
      //   359: goto -> 594
      //   362: aload #5
      //   364: astore_1
      //   365: aload_2
      //   366: invokevirtual getResponseCode : ()I
      //   369: pop
      //   370: aload #4
      //   372: astore_3
      //   373: goto -> 594
      //   376: aload #4
      //   378: astore_3
      //   379: aload #5
      //   381: astore_1
      //   382: aload_0
      //   383: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   386: getfield e : I
      //   389: ifne -> 594
      //   392: aload #5
      //   394: astore_1
      //   395: aload_2
      //   396: ldc 'POST'
      //   398: invokevirtual setRequestMethod : (Ljava/lang/String;)V
      //   401: aload #5
      //   403: astore_1
      //   404: aload_2
      //   405: iconst_1
      //   406: invokevirtual setDoInput : (Z)V
      //   409: aload #5
      //   411: astore_1
      //   412: aload_2
      //   413: iconst_1
      //   414: invokevirtual setDoOutput : (Z)V
      //   417: aload #5
      //   419: astore_1
      //   420: aload_0
      //   421: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   424: invokevirtual b : ()Landroid/net/Uri$Builder;
      //   427: ifnull -> 512
      //   430: aload #5
      //   432: astore_1
      //   433: aload_0
      //   434: getfield b : Lcom/baidu/mobads/openad/d/b;
      //   437: invokevirtual b : ()Landroid/net/Uri$Builder;
      //   440: invokevirtual build : ()Landroid/net/Uri;
      //   443: invokevirtual getEncodedQuery : ()Ljava/lang/String;
      //   446: astore_3
      //   447: aload #5
      //   449: astore_1
      //   450: aload_2
      //   451: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
      //   454: astore #6
      //   456: aload #5
      //   458: astore_1
      //   459: new java/io/BufferedWriter
      //   462: dup
      //   463: new java/io/OutputStreamWriter
      //   466: dup
      //   467: aload #6
      //   469: ldc 'UTF-8'
      //   471: invokespecial <init> : (Ljava/io/OutputStream;Ljava/lang/String;)V
      //   474: invokespecial <init> : (Ljava/io/Writer;)V
      //   477: astore #7
      //   479: aload #5
      //   481: astore_1
      //   482: aload #7
      //   484: aload_3
      //   485: invokevirtual write : (Ljava/lang/String;)V
      //   488: aload #5
      //   490: astore_1
      //   491: aload #7
      //   493: invokevirtual flush : ()V
      //   496: aload #5
      //   498: astore_1
      //   499: aload #7
      //   501: invokevirtual close : ()V
      //   504: aload #5
      //   506: astore_1
      //   507: aload #6
      //   509: invokevirtual close : ()V
      //   512: aload #5
      //   514: astore_1
      //   515: aload_2
      //   516: invokevirtual connect : ()V
      //   519: aload #5
      //   521: astore_1
      //   522: aload_2
      //   523: invokevirtual getResponseCode : ()I
      //   526: pop
      //   527: aload #5
      //   529: astore_1
      //   530: aload_0
      //   531: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   534: invokestatic a : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   537: astore_3
      //   538: aload #5
      //   540: astore_1
      //   541: new java/lang/StringBuilder
      //   544: dup
      //   545: invokespecial <init> : ()V
      //   548: astore #6
      //   550: aload #5
      //   552: astore_1
      //   553: aload #6
      //   555: ldc 'Post connect code :'
      //   557: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   560: pop
      //   561: aload #5
      //   563: astore_1
      //   564: aload #6
      //   566: aload_2
      //   567: invokevirtual getResponseCode : ()I
      //   570: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   573: pop
      //   574: aload #5
      //   576: astore_1
      //   577: aload_3
      //   578: ldc 'OAdURLLoader'
      //   580: aload #6
      //   582: invokevirtual toString : ()Ljava/lang/String;
      //   585: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   590: pop
      //   591: aload #4
      //   593: astore_3
      //   594: aload_3
      //   595: ifnull -> 625
      //   598: aload_3
      //   599: invokevirtual close : ()V
      //   602: goto -> 625
      //   605: astore_1
      //   606: aload_0
      //   607: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   610: invokestatic a : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   613: ldc 'OAdURLLoader'
      //   615: aload_1
      //   616: invokevirtual getMessage : ()Ljava/lang/String;
      //   619: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   624: pop
      //   625: aload_0
      //   626: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   629: invokestatic d : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   632: ifnull -> 841
      //   635: aload_2
      //   636: astore_1
      //   637: goto -> 828
      //   640: astore #4
      //   642: aload_1
      //   643: astore_3
      //   644: aload_2
      //   645: astore_1
      //   646: aload #4
      //   648: astore_2
      //   649: goto -> 655
      //   652: astore_2
      //   653: aconst_null
      //   654: astore_1
      //   655: aload_0
      //   656: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   659: invokestatic a : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   662: astore #4
      //   664: new java/lang/StringBuilder
      //   667: dup
      //   668: invokespecial <init> : ()V
      //   671: astore #5
      //   673: aload #5
      //   675: ldc_w 'load throwable :'
      //   678: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   681: pop
      //   682: aload #5
      //   684: aload_2
      //   685: invokevirtual getMessage : ()Ljava/lang/String;
      //   688: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   691: pop
      //   692: aload #4
      //   694: ldc 'OAdURLLoader'
      //   696: aload #5
      //   698: invokevirtual toString : ()Ljava/lang/String;
      //   701: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   706: pop
      //   707: aload_0
      //   708: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   711: invokestatic b : (Lcom/baidu/mobads/openad/d/a;)Ljava/lang/Boolean;
      //   714: invokevirtual booleanValue : ()Z
      //   717: ifne -> 787
      //   720: aload_0
      //   721: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   724: invokestatic c : (Lcom/baidu/mobads/openad/d/a;)Ljava/util/concurrent/atomic/AtomicBoolean;
      //   727: invokevirtual get : ()Z
      //   730: ifne -> 787
      //   733: aload_0
      //   734: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   737: astore #4
      //   739: new java/lang/StringBuilder
      //   742: dup
      //   743: invokespecial <init> : ()V
      //   746: astore #5
      //   748: aload #5
      //   750: ldc_w 'RuntimeError: '
      //   753: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   756: pop
      //   757: aload #5
      //   759: aload_2
      //   760: invokevirtual toString : ()Ljava/lang/String;
      //   763: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   766: pop
      //   767: aload #4
      //   769: new com/baidu/mobads/openad/c/a
      //   772: dup
      //   773: ldc_w 'URLLoader.Load.Error'
      //   776: aload #5
      //   778: invokevirtual toString : ()Ljava/lang/String;
      //   781: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
      //   784: invokevirtual dispatchEvent : (Lcom/baidu/mobads/openad/interfaces/event/IOAdEvent;)V
      //   787: aload_3
      //   788: ifnull -> 818
      //   791: aload_3
      //   792: invokevirtual close : ()V
      //   795: goto -> 818
      //   798: astore_2
      //   799: aload_0
      //   800: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   803: invokestatic a : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   806: ldc 'OAdURLLoader'
      //   808: aload_2
      //   809: invokevirtual getMessage : ()Ljava/lang/String;
      //   812: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   817: pop
      //   818: aload_0
      //   819: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   822: invokestatic d : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   825: ifnull -> 841
      //   828: aload_0
      //   829: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   832: invokestatic d : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   835: aload_1
      //   836: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
      //   841: return
      //   842: astore_2
      //   843: aload_3
      //   844: ifnull -> 874
      //   847: aload_3
      //   848: invokevirtual close : ()V
      //   851: goto -> 874
      //   854: astore_3
      //   855: aload_0
      //   856: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   859: invokestatic a : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   862: ldc 'OAdURLLoader'
      //   864: aload_3
      //   865: invokevirtual getMessage : ()Ljava/lang/String;
      //   868: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   873: pop
      //   874: aload_0
      //   875: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   878: invokestatic d : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   881: ifnull -> 897
      //   884: aload_0
      //   885: getfield a : Lcom/baidu/mobads/openad/d/a;
      //   888: invokestatic d : (Lcom/baidu/mobads/openad/d/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   891: aload_1
      //   892: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
      //   897: aload_2
      //   898: athrow
      // Exception table:
      //   from	to	target	type
      //   8	30	652	finally
      //   30	58	652	finally
      //   61	70	640	finally
      //   73	82	640	finally
      //   85	90	640	finally
      //   93	103	640	finally
      //   106	119	640	finally
      //   122	135	640	finally
      //   138	151	640	finally
      //   154	162	640	finally
      //   165	173	640	finally
      //   176	187	640	finally
      //   190	198	640	finally
      //   201	212	640	finally
      //   215	221	640	finally
      //   224	228	640	finally
      //   231	236	640	finally
      //   239	247	640	finally
      //   250	259	640	finally
      //   262	270	640	finally
      //   273	283	640	finally
      //   286	300	640	finally
      //   303	316	640	finally
      //   319	324	640	finally
      //   326	332	640	finally
      //   334	359	640	finally
      //   365	370	640	finally
      //   382	392	640	finally
      //   395	401	640	finally
      //   404	409	640	finally
      //   412	417	640	finally
      //   420	430	640	finally
      //   433	447	640	finally
      //   450	456	640	finally
      //   459	479	640	finally
      //   482	488	640	finally
      //   491	496	640	finally
      //   499	504	640	finally
      //   507	512	640	finally
      //   515	519	640	finally
      //   522	527	640	finally
      //   530	538	640	finally
      //   541	550	640	finally
      //   553	561	640	finally
      //   564	574	640	finally
      //   577	591	640	finally
      //   598	602	605	finally
      //   655	787	842	finally
      //   791	795	798	finally
      //   847	851	854	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */