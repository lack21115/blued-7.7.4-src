package com.baidu.mobads.openad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.aa;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;

public class a extends Observable implements IOAdDownloader, Runnable {
  protected Context a;
  
  protected URL b;
  
  protected URL c;
  
  protected String d;
  
  protected int e;
  
  protected Boolean f = Boolean.valueOf(true);
  
  protected String g;
  
  protected int h;
  
  protected IOAdDownloader.DownloadStatus i;
  
  protected volatile int j;
  
  protected int k;
  
  protected ArrayList<a> l;
  
  g m = null;
  
  private String n;
  
  private String o;
  
  private boolean p = false;
  
  private IXAdURIUitls q = (IXAdURIUitls)new aa();
  
  public a(Context paramContext, URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {
    this.a = paramContext;
    this.b = paramURL;
    this.d = paramString1;
    this.e = paramInt;
    if (paramString2 != null && paramString2.trim().length() > 0) {
      this.g = paramString2;
    } else {
      String str = paramURL.getFile();
      this.g = str.substring(str.lastIndexOf('/') + 1);
    } 
    this.h = -1;
    this.i = IOAdDownloader.DownloadStatus.NONE;
    this.j = 0;
    this.k = 0;
    this.n = paramString3;
    this.o = paramString4;
    this.l = new ArrayList<a>();
  }
  
  private HttpURLConnection b(HttpURLConnection paramHttpURLConnection) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getResponseCode : ()I
    //   4: istore_2
    //   5: iload_2
    //   6: sipush #302
    //   9: if_icmpeq -> 21
    //   12: aload_1
    //   13: astore_3
    //   14: iload_2
    //   15: sipush #301
    //   18: if_icmpne -> 74
    //   21: aload_0
    //   22: new java/net/URL
    //   25: dup
    //   26: aload_1
    //   27: ldc 'Location'
    //   29: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: putfield b : Ljava/net/URL;
    //   38: aload_0
    //   39: getfield b : Ljava/net/URL;
    //   42: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   45: checkcast java/net/HttpURLConnection
    //   48: astore_3
    //   49: aload_3
    //   50: sipush #10000
    //   53: invokevirtual setConnectTimeout : (I)V
    //   56: aload_3
    //   57: iconst_0
    //   58: invokevirtual setInstanceFollowRedirects : (Z)V
    //   61: aload_3
    //   62: ldc 'Range'
    //   64: ldc 'bytes=0-'
    //   66: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_3
    //   70: astore_1
    //   71: goto -> 0
    //   74: aload_3
    //   75: areturn
    //   76: astore_3
    //   77: aload_1
    //   78: areturn
    //   79: astore_1
    //   80: goto -> 74
    // Exception table:
    //   from	to	target	type
    //   0	5	76	java/lang/Exception
    //   21	49	76	java/lang/Exception
    //   49	69	79	java/lang/Exception
  }
  
  protected void a() {
    setChanged();
    notifyObservers();
  }
  
  protected void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield j : I
    //   7: iload_1
    //   8: iadd
    //   9: putfield j : I
    //   12: aload_0
    //   13: invokevirtual getProgress : ()F
    //   16: f2i
    //   17: istore_1
    //   18: aload_0
    //   19: getfield k : I
    //   22: iload_1
    //   23: if_icmpge -> 35
    //   26: aload_0
    //   27: iload_1
    //   28: putfield k : I
    //   31: aload_0
    //   32: invokevirtual a : ()V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	38	finally
  }
  
  protected void a(IOAdDownloader.DownloadStatus paramDownloadStatus) {
    this.i = paramDownloadStatus;
    a();
  }
  
  protected void a(HttpURLConnection paramHttpURLConnection) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Ljava/net/URL;
    //   4: invokevirtual toString : ()Ljava/lang/String;
    //   7: astore #12
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #7
    //   18: aload #7
    //   20: aload_0
    //   21: getfield d : Ljava/lang/String;
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload #7
    //   30: aload_0
    //   31: getfield g : Ljava/lang/String;
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload #7
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: astore #7
    //   45: new java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial <init> : ()V
    //   52: astore #8
    //   54: aload #8
    //   56: aload #7
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload #8
    //   64: ldc '.tmp'
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #8
    //   72: invokevirtual toString : ()Ljava/lang/String;
    //   75: astore #13
    //   77: aload_0
    //   78: getfield l : Ljava/util/ArrayList;
    //   81: invokevirtual size : ()I
    //   84: istore_2
    //   85: ldc ';complete='
    //   87: astore #10
    //   89: ldc 'Downloader'
    //   91: astore #8
    //   93: aload #8
    //   95: astore #11
    //   97: aload #10
    //   99: astore #9
    //   101: iload_2
    //   102: ifne -> 872
    //   105: new java/io/File
    //   108: dup
    //   109: aload_0
    //   110: getfield d : Ljava/lang/String;
    //   113: invokespecial <init> : (Ljava/lang/String;)V
    //   116: astore #7
    //   118: aload #7
    //   120: invokevirtual exists : ()Z
    //   123: ifne -> 132
    //   126: aload #7
    //   128: invokevirtual mkdirs : ()Z
    //   131: pop
    //   132: aconst_null
    //   133: astore #11
    //   135: aconst_null
    //   136: astore #9
    //   138: new java/io/File
    //   141: dup
    //   142: aload #13
    //   144: invokespecial <init> : (Ljava/lang/String;)V
    //   147: astore #14
    //   149: aload #11
    //   151: astore #7
    //   153: aload_0
    //   154: getfield f : Ljava/lang/Boolean;
    //   157: invokevirtual booleanValue : ()Z
    //   160: ifeq -> 464
    //   163: aload #11
    //   165: astore #7
    //   167: aload #14
    //   169: invokevirtual exists : ()Z
    //   172: ifeq -> 464
    //   175: aload #11
    //   177: astore #7
    //   179: aload #14
    //   181: invokevirtual length : ()J
    //   184: aload_0
    //   185: getfield h : I
    //   188: i2l
    //   189: lcmp
    //   190: ifne -> 464
    //   193: aload_0
    //   194: new com/baidu/mobads/openad/b/g
    //   197: dup
    //   198: aload_0
    //   199: getfield a : Landroid/content/Context;
    //   202: invokespecial <init> : (Landroid/content/Context;)V
    //   205: putfield m : Lcom/baidu/mobads/openad/b/g;
    //   208: aload_0
    //   209: getfield m : Lcom/baidu/mobads/openad/b/g;
    //   212: aload #12
    //   214: aload #13
    //   216: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   219: astore #15
    //   221: aload #11
    //   223: astore #7
    //   225: aload #15
    //   227: ifnull -> 464
    //   230: aload #11
    //   232: astore #7
    //   234: aload #15
    //   236: invokeinterface size : ()I
    //   241: ifle -> 464
    //   244: new java/util/ArrayList
    //   247: dup
    //   248: invokespecial <init> : ()V
    //   251: astore #7
    //   253: new java/util/HashSet
    //   256: dup
    //   257: invokespecial <init> : ()V
    //   260: astore #9
    //   262: aload #15
    //   264: invokeinterface iterator : ()Ljava/util/Iterator;
    //   269: astore #11
    //   271: aload #11
    //   273: invokeinterface hasNext : ()Z
    //   278: ifeq -> 430
    //   281: aload #11
    //   283: invokeinterface next : ()Ljava/lang/Object;
    //   288: checkcast com/baidu/mobads/openad/b/h
    //   291: astore #15
    //   293: aload #9
    //   295: aload #15
    //   297: invokevirtual c : ()I
    //   300: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   303: invokevirtual contains : (Ljava/lang/Object;)Z
    //   306: ifeq -> 312
    //   309: goto -> 271
    //   312: aload #9
    //   314: aload #15
    //   316: invokevirtual c : ()I
    //   319: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   322: invokevirtual add : (Ljava/lang/Object;)Z
    //   325: pop
    //   326: aload #7
    //   328: aload #15
    //   330: invokeinterface add : (Ljava/lang/Object;)Z
    //   335: pop
    //   336: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   339: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   342: astore #16
    //   344: new java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial <init> : ()V
    //   351: astore #17
    //   353: aload #17
    //   355: ldc_w 'resume from db: start='
    //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload #17
    //   364: aload #15
    //   366: invokevirtual d : ()I
    //   369: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload #17
    //   375: ldc_w ';end ='
    //   378: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload #17
    //   384: aload #15
    //   386: invokevirtual e : ()I
    //   389: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload #17
    //   395: ldc ';complete='
    //   397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload #17
    //   403: aload #15
    //   405: invokevirtual a : ()I
    //   408: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload #16
    //   414: ldc 'Downloader'
    //   416: aload #17
    //   418: invokevirtual toString : ()Ljava/lang/String;
    //   421: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   426: pop
    //   427: goto -> 271
    //   430: goto -> 464
    //   433: astore #9
    //   435: goto -> 448
    //   438: astore #11
    //   440: aload #9
    //   442: astore #7
    //   444: aload #11
    //   446: astore #9
    //   448: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   451: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   454: ldc 'Downloader'
    //   456: aload #9
    //   458: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   463: pop
    //   464: aload #7
    //   466: ifnull -> 486
    //   469: aload #7
    //   471: invokeinterface size : ()I
    //   476: iconst_1
    //   477: if_icmpge -> 483
    //   480: goto -> 486
    //   483: goto -> 727
    //   486: aload #14
    //   488: invokevirtual exists : ()Z
    //   491: ifeq -> 500
    //   494: aload #14
    //   496: invokevirtual delete : ()Z
    //   499: pop
    //   500: aload #14
    //   502: invokevirtual createNewFile : ()Z
    //   505: pop
    //   506: new java/io/RandomAccessFile
    //   509: dup
    //   510: aload #14
    //   512: ldc_w 'rwd'
    //   515: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   518: astore #7
    //   520: aload #7
    //   522: aload_0
    //   523: getfield h : I
    //   526: i2l
    //   527: invokevirtual setLength : (J)V
    //   530: aload #7
    //   532: invokevirtual close : ()V
    //   535: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   538: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   541: astore #7
    //   543: new java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial <init> : ()V
    //   550: astore #9
    //   552: aload #9
    //   554: ldc_w 'Downloader.init():  建立完random文件 ts:'
    //   557: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload #9
    //   563: invokestatic currentTimeMillis : ()J
    //   566: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload #7
    //   572: aload #9
    //   574: invokevirtual toString : ()Ljava/lang/String;
    //   577: invokeinterface d : (Ljava/lang/String;)I
    //   582: pop
    //   583: new java/util/ArrayList
    //   586: dup
    //   587: invokespecial <init> : ()V
    //   590: astore #9
    //   592: iconst_m1
    //   593: istore_3
    //   594: aload_0
    //   595: getfield e : I
    //   598: istore_2
    //   599: iload_2
    //   600: iconst_1
    //   601: if_icmple -> 697
    //   604: aload_0
    //   605: getfield h : I
    //   608: i2f
    //   609: iload_2
    //   610: i2f
    //   611: fdiv
    //   612: ldc_w 102400.0
    //   615: fdiv
    //   616: invokestatic round : (F)I
    //   619: istore #6
    //   621: iconst_0
    //   622: istore #4
    //   624: aload_0
    //   625: getfield h : I
    //   628: istore_2
    //   629: aload #9
    //   631: astore #7
    //   633: iload_3
    //   634: iload_2
    //   635: if_icmpge -> 727
    //   638: iload_3
    //   639: iload #6
    //   641: ldc_w 102400
    //   644: imul
    //   645: iadd
    //   646: istore #5
    //   648: iload #5
    //   650: iload_2
    //   651: if_icmpge -> 660
    //   654: iload #5
    //   656: istore_2
    //   657: goto -> 660
    //   660: iload #4
    //   662: iconst_1
    //   663: iadd
    //   664: istore #4
    //   666: aload #9
    //   668: new com/baidu/mobads/openad/b/h
    //   671: dup
    //   672: iload #4
    //   674: aload #12
    //   676: aload #13
    //   678: iload_3
    //   679: iconst_1
    //   680: iadd
    //   681: iload_2
    //   682: iconst_0
    //   683: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;III)V
    //   686: invokeinterface add : (Ljava/lang/Object;)Z
    //   691: pop
    //   692: iload_2
    //   693: istore_3
    //   694: goto -> 624
    //   697: aload #9
    //   699: new com/baidu/mobads/openad/b/h
    //   702: dup
    //   703: iconst_1
    //   704: aload #12
    //   706: aload #13
    //   708: iconst_0
    //   709: aload_0
    //   710: getfield h : I
    //   713: iconst_0
    //   714: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;III)V
    //   717: invokeinterface add : (Ljava/lang/Object;)Z
    //   722: pop
    //   723: aload #9
    //   725: astore #7
    //   727: aload #7
    //   729: invokeinterface iterator : ()Ljava/util/Iterator;
    //   734: astore #14
    //   736: aload #10
    //   738: astore #7
    //   740: aload #8
    //   742: astore #11
    //   744: aload #7
    //   746: astore #9
    //   748: aload #14
    //   750: invokeinterface hasNext : ()Z
    //   755: ifeq -> 872
    //   758: aload #14
    //   760: invokeinterface next : ()Ljava/lang/Object;
    //   765: checkcast com/baidu/mobads/openad/b/h
    //   768: astore #9
    //   770: new com/baidu/mobads/openad/b/a$a
    //   773: dup
    //   774: aload_0
    //   775: aload #9
    //   777: invokevirtual c : ()I
    //   780: aload_0
    //   781: getfield c : Ljava/net/URL;
    //   784: aload #9
    //   786: invokevirtual f : ()Ljava/lang/String;
    //   789: aload #9
    //   791: invokevirtual d : ()I
    //   794: aload #9
    //   796: invokevirtual e : ()I
    //   799: aload #9
    //   801: invokevirtual a : ()I
    //   804: invokespecial <init> : (Lcom/baidu/mobads/openad/b/a;ILjava/net/URL;Ljava/lang/String;III)V
    //   807: astore #10
    //   809: aload #9
    //   811: invokevirtual d : ()I
    //   814: ifne -> 834
    //   817: aload #9
    //   819: invokevirtual a : ()I
    //   822: ifne -> 834
    //   825: aload #10
    //   827: aload_1
    //   828: invokevirtual a : (Ljava/net/HttpURLConnection;)V
    //   831: goto -> 834
    //   834: aload_0
    //   835: getfield l : Ljava/util/ArrayList;
    //   838: aload #10
    //   840: invokevirtual add : (Ljava/lang/Object;)Z
    //   843: pop
    //   844: goto -> 740
    //   847: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   850: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   853: ldc 'Downloader'
    //   855: ldc_w ' 建立文件失败:'
    //   858: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   863: pop
    //   864: aload_0
    //   865: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   868: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   871: return
    //   872: aload #9
    //   874: astore_1
    //   875: aload_0
    //   876: getfield f : Ljava/lang/Boolean;
    //   879: invokevirtual booleanValue : ()Z
    //   882: ifeq -> 927
    //   885: iconst_0
    //   886: istore_3
    //   887: iconst_0
    //   888: istore_2
    //   889: iload_2
    //   890: istore #4
    //   892: iload_3
    //   893: aload_0
    //   894: getfield l : Ljava/util/ArrayList;
    //   897: invokevirtual size : ()I
    //   900: if_icmpge -> 930
    //   903: iload_2
    //   904: aload_0
    //   905: getfield l : Ljava/util/ArrayList;
    //   908: iload_3
    //   909: invokevirtual get : (I)Ljava/lang/Object;
    //   912: checkcast com/baidu/mobads/openad/b/a$a
    //   915: getfield f : I
    //   918: iadd
    //   919: istore_2
    //   920: iload_3
    //   921: iconst_1
    //   922: iadd
    //   923: istore_3
    //   924: goto -> 889
    //   927: iconst_0
    //   928: istore #4
    //   930: aload_0
    //   931: iload #4
    //   933: putfield j : I
    //   936: aload_0
    //   937: aload_0
    //   938: invokevirtual getProgress : ()F
    //   941: f2i
    //   942: putfield k : I
    //   945: aload_0
    //   946: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.DOWNLOADING : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   949: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   952: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   955: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   958: aload #11
    //   960: ldc_w 'Downloader starts unfinished threads and waits threads end'
    //   963: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   968: pop
    //   969: iconst_0
    //   970: istore_2
    //   971: iload_2
    //   972: aload_0
    //   973: getfield l : Ljava/util/ArrayList;
    //   976: invokevirtual size : ()I
    //   979: if_icmpge -> 1020
    //   982: aload_0
    //   983: getfield l : Ljava/util/ArrayList;
    //   986: iload_2
    //   987: invokevirtual get : (I)Ljava/lang/Object;
    //   990: checkcast com/baidu/mobads/openad/b/a$a
    //   993: invokevirtual a : ()Z
    //   996: ifne -> 1013
    //   999: aload_0
    //   1000: getfield l : Ljava/util/ArrayList;
    //   1003: iload_2
    //   1004: invokevirtual get : (I)Ljava/lang/Object;
    //   1007: checkcast com/baidu/mobads/openad/b/a$a
    //   1010: invokevirtual b : ()V
    //   1013: iload_2
    //   1014: iconst_1
    //   1015: iadd
    //   1016: istore_2
    //   1017: goto -> 971
    //   1020: iconst_0
    //   1021: istore_2
    //   1022: iload_2
    //   1023: aload_0
    //   1024: getfield l : Ljava/util/ArrayList;
    //   1027: invokevirtual size : ()I
    //   1030: if_icmpge -> 1071
    //   1033: aload_0
    //   1034: getfield l : Ljava/util/ArrayList;
    //   1037: iload_2
    //   1038: invokevirtual get : (I)Ljava/lang/Object;
    //   1041: checkcast com/baidu/mobads/openad/b/a$a
    //   1044: invokevirtual a : ()Z
    //   1047: ifne -> 1064
    //   1050: aload_0
    //   1051: getfield l : Ljava/util/ArrayList;
    //   1054: iload_2
    //   1055: invokevirtual get : (I)Ljava/lang/Object;
    //   1058: checkcast com/baidu/mobads/openad/b/a$a
    //   1061: invokevirtual d : ()V
    //   1064: iload_2
    //   1065: iconst_1
    //   1066: iadd
    //   1067: istore_2
    //   1068: goto -> 1022
    //   1071: aload_0
    //   1072: getfield i : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1075: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.DOWNLOADING : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1078: if_acmpne -> 1157
    //   1081: iconst_0
    //   1082: istore_2
    //   1083: iload_2
    //   1084: aload_0
    //   1085: getfield l : Ljava/util/ArrayList;
    //   1088: invokevirtual size : ()I
    //   1091: if_icmpge -> 1123
    //   1094: aload_0
    //   1095: getfield l : Ljava/util/ArrayList;
    //   1098: iload_2
    //   1099: invokevirtual get : (I)Ljava/lang/Object;
    //   1102: checkcast com/baidu/mobads/openad/b/a$a
    //   1105: invokevirtual a : ()Z
    //   1108: ifne -> 1116
    //   1111: iconst_1
    //   1112: istore_2
    //   1113: goto -> 1125
    //   1116: iload_2
    //   1117: iconst_1
    //   1118: iadd
    //   1119: istore_2
    //   1120: goto -> 1083
    //   1123: iconst_0
    //   1124: istore_2
    //   1125: iload_2
    //   1126: ifeq -> 1139
    //   1129: aload_0
    //   1130: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1133: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   1136: goto -> 1234
    //   1139: aload_0
    //   1140: aload_0
    //   1141: getfield l : Ljava/util/ArrayList;
    //   1144: invokevirtual a : (Ljava/util/ArrayList;)V
    //   1147: aload_0
    //   1148: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.COMPLETED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1151: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   1154: goto -> 1234
    //   1157: aload_0
    //   1158: getfield i : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1161: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1164: if_acmpne -> 1177
    //   1167: aload_0
    //   1168: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1171: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   1174: goto -> 1234
    //   1177: aload_0
    //   1178: getfield i : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1181: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.CANCELLED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1184: if_acmpne -> 1207
    //   1187: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1190: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1193: aload #11
    //   1195: ldc_w 'Downloader is cancelled'
    //   1198: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   1203: pop
    //   1204: goto -> 1234
    //   1207: aload_0
    //   1208: getfield i : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1211: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.PAUSED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1214: if_acmpne -> 1234
    //   1217: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1220: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1223: aload #11
    //   1225: ldc_w 'Downloader is paused'
    //   1228: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   1233: pop
    //   1234: aload_0
    //   1235: getfield i : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1238: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.COMPLETED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   1241: if_acmpeq -> 1515
    //   1244: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1247: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1250: aload #11
    //   1252: ldc_w 'save database now'
    //   1255: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   1260: pop
    //   1261: aload_0
    //   1262: getfield f : Ljava/lang/Boolean;
    //   1265: invokevirtual booleanValue : ()Z
    //   1268: ifeq -> 1515
    //   1271: aload_0
    //   1272: getfield m : Lcom/baidu/mobads/openad/b/g;
    //   1275: ifnonnull -> 1293
    //   1278: aload_0
    //   1279: new com/baidu/mobads/openad/b/g
    //   1282: dup
    //   1283: aload_0
    //   1284: getfield a : Landroid/content/Context;
    //   1287: invokespecial <init> : (Landroid/content/Context;)V
    //   1290: putfield m : Lcom/baidu/mobads/openad/b/g;
    //   1293: new java/util/ArrayList
    //   1296: dup
    //   1297: invokespecial <init> : ()V
    //   1300: astore #7
    //   1302: aload_0
    //   1303: getfield l : Ljava/util/ArrayList;
    //   1306: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1309: astore #8
    //   1311: aload #8
    //   1313: invokeinterface hasNext : ()Z
    //   1318: ifeq -> 1465
    //   1321: aload #8
    //   1323: invokeinterface next : ()Ljava/lang/Object;
    //   1328: checkcast com/baidu/mobads/openad/b/a$a
    //   1331: astore #9
    //   1333: aload #7
    //   1335: new com/baidu/mobads/openad/b/h
    //   1338: dup
    //   1339: aload #9
    //   1341: getfield a : I
    //   1344: aload #12
    //   1346: aload #13
    //   1348: aload #9
    //   1350: getfield d : I
    //   1353: aload #9
    //   1355: getfield e : I
    //   1358: aload #9
    //   1360: getfield f : I
    //   1363: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;III)V
    //   1366: invokeinterface add : (Ljava/lang/Object;)Z
    //   1371: pop
    //   1372: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1375: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1378: astore #10
    //   1380: new java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial <init> : ()V
    //   1387: astore #14
    //   1389: aload #14
    //   1391: ldc_w 'save to db: start='
    //   1394: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: pop
    //   1398: aload #14
    //   1400: aload #9
    //   1402: getfield d : I
    //   1405: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload #14
    //   1411: ldc_w ';end ='
    //   1414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: aload #14
    //   1420: aload #9
    //   1422: getfield e : I
    //   1425: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1428: pop
    //   1429: aload #14
    //   1431: aload_1
    //   1432: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: pop
    //   1436: aload #14
    //   1438: aload #9
    //   1440: getfield f : I
    //   1443: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1446: pop
    //   1447: aload #10
    //   1449: aload #11
    //   1451: aload #14
    //   1453: invokevirtual toString : ()Ljava/lang/String;
    //   1456: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   1461: pop
    //   1462: goto -> 1311
    //   1465: aload_0
    //   1466: getfield m : Lcom/baidu/mobads/openad/b/g;
    //   1469: aload #12
    //   1471: aload #13
    //   1473: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1476: ifeq -> 1489
    //   1479: aload_0
    //   1480: getfield m : Lcom/baidu/mobads/openad/b/g;
    //   1483: aload #7
    //   1485: invokevirtual b : (Ljava/util/List;)V
    //   1488: return
    //   1489: aload_0
    //   1490: getfield m : Lcom/baidu/mobads/openad/b/g;
    //   1493: aload #7
    //   1495: invokevirtual a : (Ljava/util/List;)V
    //   1498: return
    //   1499: astore_1
    //   1500: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1503: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1506: aload #11
    //   1508: aload_1
    //   1509: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1514: pop
    //   1515: return
    //   1516: astore_1
    //   1517: goto -> 847
    // Exception table:
    //   from	to	target	type
    //   193	221	438	java/lang/Exception
    //   234	253	438	java/lang/Exception
    //   253	271	433	java/lang/Exception
    //   271	309	433	java/lang/Exception
    //   312	427	433	java/lang/Exception
    //   500	583	1516	java/lang/Exception
    //   1271	1293	1499	java/lang/Exception
    //   1293	1311	1499	java/lang/Exception
    //   1311	1462	1499	java/lang/Exception
    //   1465	1488	1499	java/lang/Exception
    //   1489	1498	1499	java/lang/Exception
  }
  
  protected void a(ArrayList<a> paramArrayList) {
    IXAdIOUtils iXAdIOUtils = XAdSDKFoundationFacade.getInstance().getIoUtils();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.d);
    stringBuilder1.append(this.g);
    stringBuilder1.append(".tmp");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.d);
    stringBuilder2.append(this.g);
    iXAdIOUtils.renameFile(str, stringBuilder2.toString());
  }
  
  protected void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   6: putfield i : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   9: iconst_0
    //   10: istore_1
    //   11: iload_1
    //   12: aload_0
    //   13: getfield l : Ljava/util/ArrayList;
    //   16: invokevirtual size : ()I
    //   19: if_icmpge -> 60
    //   22: aload_0
    //   23: getfield l : Ljava/util/ArrayList;
    //   26: iload_1
    //   27: invokevirtual get : (I)Ljava/lang/Object;
    //   30: checkcast com/baidu/mobads/openad/b/a$a
    //   33: invokevirtual a : ()Z
    //   36: ifne -> 53
    //   39: aload_0
    //   40: getfield l : Ljava/util/ArrayList;
    //   43: iload_1
    //   44: invokevirtual get : (I)Ljava/lang/Object;
    //   47: checkcast com/baidu/mobads/openad/b/a$a
    //   50: invokevirtual c : ()V
    //   53: iload_1
    //   54: iconst_1
    //   55: iadd
    //   56: istore_1
    //   57: goto -> 11
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	63	finally
    //   11	53	63	finally
  }
  
  public void cancel() {
    try {
      IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("execute Cancel; state = ");
      stringBuilder.append(this.i);
      iXAdLogger.d("Downloader", stringBuilder.toString());
      if (this.i == IOAdDownloader.DownloadStatus.PAUSED || this.i == IOAdDownloader.DownloadStatus.DOWNLOADING) {
        if (this.l != null)
          for (int i = 0;; i++) {
            if (i < this.l.size()) {
              if (!((a)this.l.get(i)).a())
                ((a)this.l.get(i)).c(); 
              continue;
            } 
            a(IOAdDownloader.DownloadStatus.CANCELLED);
            return;
          }  
      } else {
        return;
      } 
      a(IOAdDownloader.DownloadStatus.CANCELLED);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "cancel exception");
      com.baidu.mobads.b.a a1 = com.baidu.mobads.b.a.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("apk download cancel failed: ");
      stringBuilder.append(exception.toString());
      a1.a(stringBuilder.toString());
    } 
  }
  
  public int getFileSize() {
    return this.h;
  }
  
  public String getOutputPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d);
    stringBuilder.append(this.g);
    return stringBuilder.toString();
  }
  
  public String getPackageName() {
    return this.o;
  }
  
  public float getProgress() {
    return Math.abs(this.j / this.h * 100.0F);
  }
  
  public IOAdDownloader.DownloadStatus getState() {
    return this.i;
  }
  
  public String getTargetURL() {
    URL uRL = this.c;
    return (uRL == null) ? null : uRL.toString();
  }
  
  public String getTitle() {
    return this.n;
  }
  
  public String getURL() {
    return this.b.toString();
  }
  
  public boolean isPausedManually() {
    return this.p;
  }
  
  public void pause() {
    try {
      IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("execute Pause; state = ");
      stringBuilder.append(this.i);
      iXAdLogger.d("Downloader", stringBuilder.toString());
      if (this.i == IOAdDownloader.DownloadStatus.DOWNLOADING || this.i == IOAdDownloader.DownloadStatus.ERROR || this.i == IOAdDownloader.DownloadStatus.NONE) {
        if (this.l != null)
          for (int i = 0;; i++) {
            if (i < this.l.size()) {
              if (!((a)this.l.get(i)).a())
                ((a)this.l.get(i)).c(); 
              continue;
            } 
            a(IOAdDownloader.DownloadStatus.PAUSED);
            return;
          }  
      } else {
        return;
      } 
      a(IOAdDownloader.DownloadStatus.PAUSED);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "pause exception");
      com.baidu.mobads.b.a a1 = com.baidu.mobads.b.a.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("apk download pause failed: ");
      stringBuilder.append(exception.toString());
      a1.a(stringBuilder.toString());
    } 
  }
  
  public void removeObservers() {
    deleteObservers();
  }
  
  public void resume() {
    try {
      IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("execute Resume; state = ");
      stringBuilder.append(this.i);
      iXAdLogger.d("Downloader", stringBuilder.toString());
      if (this.i == IOAdDownloader.DownloadStatus.PAUSED || this.i == IOAdDownloader.DownloadStatus.ERROR || this.i == IOAdDownloader.DownloadStatus.CANCELLED) {
        a(IOAdDownloader.DownloadStatus.INITING);
        setPausedManually(true);
        (new Thread(this)).start();
        return;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "resume exception");
      com.baidu.mobads.b.a a1 = com.baidu.mobads.b.a.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("apk download resume failed: ");
      stringBuilder.append(exception.toString());
      a1.a(stringBuilder.toString());
    } 
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Ljava/net/URL;
    //   4: astore #4
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore #5
    //   11: aload #4
    //   13: ifnull -> 57
    //   16: aload_0
    //   17: getfield h : I
    //   20: iconst_1
    //   21: if_icmpge -> 27
    //   24: goto -> 57
    //   27: aload_0
    //   28: aconst_null
    //   29: invokevirtual a : (Ljava/net/HttpURLConnection;)V
    //   32: return
    //   33: astore_3
    //   34: aload_0
    //   35: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   38: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   41: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   44: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   47: ldc 'Downloader'
    //   49: aload_3
    //   50: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   55: pop
    //   56: return
    //   57: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   60: invokevirtual getURIUitls : ()Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   63: aload_0
    //   64: getfield b : Ljava/net/URL;
    //   67: invokeinterface getHttpURLConnection : (Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   72: astore #6
    //   74: aload #6
    //   76: astore #5
    //   78: aload #6
    //   80: astore_3
    //   81: aload #6
    //   83: ldc 'Range'
    //   85: ldc 'bytes=0-'
    //   87: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload #6
    //   92: astore #5
    //   94: aload #6
    //   96: astore_3
    //   97: aload #6
    //   99: sipush #10000
    //   102: invokevirtual setConnectTimeout : (I)V
    //   105: aload #6
    //   107: astore #5
    //   109: aload #6
    //   111: astore_3
    //   112: aload #6
    //   114: iconst_1
    //   115: invokevirtual setInstanceFollowRedirects : (Z)V
    //   118: aload #6
    //   120: astore #5
    //   122: aload #6
    //   124: astore_3
    //   125: aload #6
    //   127: invokevirtual connect : ()V
    //   130: aload #6
    //   132: astore #5
    //   134: aload #6
    //   136: astore_3
    //   137: aload #6
    //   139: invokevirtual getResponseCode : ()I
    //   142: istore_2
    //   143: iload_2
    //   144: sipush #302
    //   147: if_icmpeq -> 163
    //   150: iload_2
    //   151: istore_1
    //   152: aload #6
    //   154: astore #4
    //   156: iload_2
    //   157: sipush #301
    //   160: if_icmpne -> 204
    //   163: aload #6
    //   165: astore #5
    //   167: aload #6
    //   169: astore_3
    //   170: aload #6
    //   172: iconst_0
    //   173: invokevirtual setInstanceFollowRedirects : (Z)V
    //   176: aload #6
    //   178: astore #5
    //   180: aload #6
    //   182: astore_3
    //   183: aload_0
    //   184: aload #6
    //   186: invokespecial b : (Ljava/net/HttpURLConnection;)Ljava/net/HttpURLConnection;
    //   189: astore #4
    //   191: aload #4
    //   193: astore #5
    //   195: aload #4
    //   197: astore_3
    //   198: aload #4
    //   200: invokevirtual getResponseCode : ()I
    //   203: istore_1
    //   204: aload #4
    //   206: astore #5
    //   208: aload #4
    //   210: astore_3
    //   211: iload_1
    //   212: bipush #100
    //   214: idiv
    //   215: iconst_2
    //   216: if_icmpeq -> 251
    //   219: aload #4
    //   221: astore #5
    //   223: aload #4
    //   225: astore_3
    //   226: aload_0
    //   227: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   230: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   233: aload_0
    //   234: getfield q : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   237: astore_3
    //   238: aload_3
    //   239: ifnull -> 250
    //   242: aload_3
    //   243: aload #4
    //   245: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   250: return
    //   251: aload #4
    //   253: astore #5
    //   255: aload #4
    //   257: astore_3
    //   258: aload #4
    //   260: invokevirtual getContentType : ()Ljava/lang/String;
    //   263: ldc_w 'text/html'
    //   266: invokevirtual equals : (Ljava/lang/Object;)Z
    //   269: ifeq -> 304
    //   272: aload #4
    //   274: astore #5
    //   276: aload #4
    //   278: astore_3
    //   279: aload_0
    //   280: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   283: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   286: aload_0
    //   287: getfield q : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   290: astore_3
    //   291: aload_3
    //   292: ifnull -> 303
    //   295: aload_3
    //   296: aload #4
    //   298: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   303: return
    //   304: aload #4
    //   306: astore #5
    //   308: aload #4
    //   310: astore_3
    //   311: aload #4
    //   313: invokevirtual getContentLength : ()I
    //   316: istore_1
    //   317: iload_1
    //   318: iconst_1
    //   319: if_icmpge -> 354
    //   322: aload #4
    //   324: astore #5
    //   326: aload #4
    //   328: astore_3
    //   329: aload_0
    //   330: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   333: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   336: aload_0
    //   337: getfield q : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   340: astore_3
    //   341: aload_3
    //   342: ifnull -> 353
    //   345: aload_3
    //   346: aload #4
    //   348: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   353: return
    //   354: iload_1
    //   355: ldc_w 5120000
    //   358: if_icmpge -> 373
    //   361: aload #4
    //   363: astore #5
    //   365: aload #4
    //   367: astore_3
    //   368: aload_0
    //   369: iconst_1
    //   370: putfield e : I
    //   373: aload #4
    //   375: astore #5
    //   377: aload #4
    //   379: astore_3
    //   380: aload_0
    //   381: aload #4
    //   383: invokevirtual getURL : ()Ljava/net/URL;
    //   386: putfield c : Ljava/net/URL;
    //   389: aload #4
    //   391: astore #5
    //   393: aload #4
    //   395: astore_3
    //   396: ldc_w 'mounted'
    //   399: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   402: invokevirtual equals : (Ljava/lang/Object;)Z
    //   405: ifne -> 440
    //   408: aload #4
    //   410: astore #5
    //   412: aload #4
    //   414: astore_3
    //   415: aload_0
    //   416: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   419: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   422: aload_0
    //   423: getfield q : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   426: astore_3
    //   427: aload_3
    //   428: ifnull -> 439
    //   431: aload_3
    //   432: aload #4
    //   434: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   439: return
    //   440: aload #4
    //   442: astore #5
    //   444: aload #4
    //   446: astore_3
    //   447: aload_0
    //   448: getfield a : Landroid/content/Context;
    //   451: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   454: astore #6
    //   456: aload #4
    //   458: astore #5
    //   460: aload #4
    //   462: astore_3
    //   463: new java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial <init> : ()V
    //   470: astore #7
    //   472: aload #4
    //   474: astore #5
    //   476: aload #4
    //   478: astore_3
    //   479: aload #7
    //   481: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   484: invokevirtual getCommonUtils : ()Lcom/baidu/mobads/utils/h;
    //   487: aload_0
    //   488: getfield c : Ljava/net/URL;
    //   491: invokevirtual toString : ()Ljava/lang/String;
    //   494: invokevirtual md5 : (Ljava/lang/String;)Ljava/lang/String;
    //   497: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload #4
    //   503: astore #5
    //   505: aload #4
    //   507: astore_3
    //   508: aload #7
    //   510: ldc_w '.apk'
    //   513: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload #4
    //   519: astore #5
    //   521: aload #4
    //   523: astore_3
    //   524: aload #7
    //   526: invokevirtual toString : ()Ljava/lang/String;
    //   529: astore #7
    //   531: aload #4
    //   533: astore #5
    //   535: aload #4
    //   537: astore_3
    //   538: aload_0
    //   539: aload #6
    //   541: putfield d : Ljava/lang/String;
    //   544: aload #4
    //   546: astore #5
    //   548: aload #4
    //   550: astore_3
    //   551: aload_0
    //   552: aload #7
    //   554: putfield g : Ljava/lang/String;
    //   557: aload #4
    //   559: astore #5
    //   561: aload #4
    //   563: astore_3
    //   564: new java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial <init> : ()V
    //   571: astore #8
    //   573: aload #4
    //   575: astore #5
    //   577: aload #4
    //   579: astore_3
    //   580: aload #8
    //   582: aload #6
    //   584: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload #4
    //   590: astore #5
    //   592: aload #4
    //   594: astore_3
    //   595: aload #8
    //   597: aload #7
    //   599: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload #4
    //   605: astore #5
    //   607: aload #4
    //   609: astore_3
    //   610: new java/io/File
    //   613: dup
    //   614: aload #8
    //   616: invokevirtual toString : ()Ljava/lang/String;
    //   619: invokespecial <init> : (Ljava/lang/String;)V
    //   622: invokevirtual exists : ()Z
    //   625: ifeq -> 660
    //   628: aload #4
    //   630: astore #5
    //   632: aload #4
    //   634: astore_3
    //   635: aload_0
    //   636: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.COMPLETED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   639: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   642: aload_0
    //   643: getfield q : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   646: astore_3
    //   647: aload_3
    //   648: ifnull -> 659
    //   651: aload_3
    //   652: aload #4
    //   654: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   659: return
    //   660: aload #4
    //   662: astore #5
    //   664: aload #4
    //   666: astore_3
    //   667: aload #4
    //   669: ldc_w 'Content-Range'
    //   672: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   675: ifnonnull -> 747
    //   678: aload #4
    //   680: astore #5
    //   682: aload #4
    //   684: astore_3
    //   685: aload #4
    //   687: ldc_w 'Accept-Ranges'
    //   690: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   693: ifnull -> 720
    //   696: aload #4
    //   698: astore #5
    //   700: aload #4
    //   702: astore_3
    //   703: aload #4
    //   705: ldc_w 'Accept-Ranges'
    //   708: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   711: ldc_w 'none'
    //   714: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   717: ifeq -> 747
    //   720: aload #4
    //   722: astore #5
    //   724: aload #4
    //   726: astore_3
    //   727: aload_0
    //   728: iconst_0
    //   729: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   732: putfield f : Ljava/lang/Boolean;
    //   735: aload #4
    //   737: astore #5
    //   739: aload #4
    //   741: astore_3
    //   742: aload_0
    //   743: iconst_1
    //   744: putfield e : I
    //   747: aload #4
    //   749: astore #5
    //   751: aload #4
    //   753: astore_3
    //   754: aload_0
    //   755: getfield h : I
    //   758: iconst_m1
    //   759: if_icmpne -> 774
    //   762: aload #4
    //   764: astore #5
    //   766: aload #4
    //   768: astore_3
    //   769: aload_0
    //   770: iload_1
    //   771: putfield h : I
    //   774: aload #4
    //   776: astore #5
    //   778: aload #4
    //   780: astore_3
    //   781: aload_0
    //   782: aload #4
    //   784: invokevirtual a : (Ljava/net/HttpURLConnection;)V
    //   787: aload_0
    //   788: getfield q : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   791: astore_3
    //   792: aload_3
    //   793: ifnull -> 838
    //   796: goto -> 830
    //   799: astore_3
    //   800: goto -> 839
    //   803: aload_3
    //   804: astore #5
    //   806: aload_0
    //   807: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   810: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   813: aload_0
    //   814: getfield q : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   817: astore #5
    //   819: aload #5
    //   821: ifnull -> 838
    //   824: aload_3
    //   825: astore #4
    //   827: aload #5
    //   829: astore_3
    //   830: aload_3
    //   831: aload #4
    //   833: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   838: return
    //   839: aload_0
    //   840: getfield q : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   843: astore #4
    //   845: aload #4
    //   847: ifnull -> 859
    //   850: aload #4
    //   852: aload #5
    //   854: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   859: aload_3
    //   860: athrow
    //   861: astore #4
    //   863: goto -> 803
    // Exception table:
    //   from	to	target	type
    //   27	32	33	java/lang/Exception
    //   57	74	861	java/lang/Exception
    //   57	74	799	finally
    //   81	90	861	java/lang/Exception
    //   81	90	799	finally
    //   97	105	861	java/lang/Exception
    //   97	105	799	finally
    //   112	118	861	java/lang/Exception
    //   112	118	799	finally
    //   125	130	861	java/lang/Exception
    //   125	130	799	finally
    //   137	143	861	java/lang/Exception
    //   137	143	799	finally
    //   170	176	861	java/lang/Exception
    //   170	176	799	finally
    //   183	191	861	java/lang/Exception
    //   183	191	799	finally
    //   198	204	861	java/lang/Exception
    //   198	204	799	finally
    //   211	219	861	java/lang/Exception
    //   211	219	799	finally
    //   226	233	861	java/lang/Exception
    //   226	233	799	finally
    //   258	272	861	java/lang/Exception
    //   258	272	799	finally
    //   279	286	861	java/lang/Exception
    //   279	286	799	finally
    //   311	317	861	java/lang/Exception
    //   311	317	799	finally
    //   329	336	861	java/lang/Exception
    //   329	336	799	finally
    //   368	373	861	java/lang/Exception
    //   368	373	799	finally
    //   380	389	861	java/lang/Exception
    //   380	389	799	finally
    //   396	408	861	java/lang/Exception
    //   396	408	799	finally
    //   415	422	861	java/lang/Exception
    //   415	422	799	finally
    //   447	456	861	java/lang/Exception
    //   447	456	799	finally
    //   463	472	861	java/lang/Exception
    //   463	472	799	finally
    //   479	501	861	java/lang/Exception
    //   479	501	799	finally
    //   508	517	861	java/lang/Exception
    //   508	517	799	finally
    //   524	531	861	java/lang/Exception
    //   524	531	799	finally
    //   538	544	861	java/lang/Exception
    //   538	544	799	finally
    //   551	557	861	java/lang/Exception
    //   551	557	799	finally
    //   564	573	861	java/lang/Exception
    //   564	573	799	finally
    //   580	588	861	java/lang/Exception
    //   580	588	799	finally
    //   595	603	861	java/lang/Exception
    //   595	603	799	finally
    //   610	628	861	java/lang/Exception
    //   610	628	799	finally
    //   635	642	861	java/lang/Exception
    //   635	642	799	finally
    //   667	678	861	java/lang/Exception
    //   667	678	799	finally
    //   685	696	861	java/lang/Exception
    //   685	696	799	finally
    //   703	720	861	java/lang/Exception
    //   703	720	799	finally
    //   727	735	861	java/lang/Exception
    //   727	735	799	finally
    //   742	747	861	java/lang/Exception
    //   742	747	799	finally
    //   754	762	861	java/lang/Exception
    //   754	762	799	finally
    //   769	774	861	java/lang/Exception
    //   769	774	799	finally
    //   781	787	861	java/lang/Exception
    //   781	787	799	finally
    //   806	813	799	finally
  }
  
  public void setPausedManually(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  public void start() {
    IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("execute Start; state = ");
    stringBuilder.append(this.i);
    iXAdLogger.d("Downloader", stringBuilder.toString());
    if (this.i == IOAdDownloader.DownloadStatus.NONE) {
      a(IOAdDownloader.DownloadStatus.INITING);
      setPausedManually(true);
      (new Thread(this)).start();
    } 
  }
  
  public class a implements Runnable {
    protected int a;
    
    protected URL b;
    
    protected String c;
    
    protected int d;
    
    protected int e;
    
    protected int f;
    
    protected boolean g;
    
    protected Thread h;
    
    private volatile boolean j = false;
    
    private volatile int k = 0;
    
    private HttpURLConnection l;
    
    public a(a this$0, int param1Int1, URL param1URL, String param1String, int param1Int2, int param1Int3, int param1Int4) {
      this.a = param1Int1;
      this.b = param1URL;
      this.c = param1String;
      this.d = param1Int2;
      this.e = param1Int3;
      this.f = param1Int4;
      this.g = false;
    }
    
    public void a(HttpURLConnection param1HttpURLConnection) {
      this.l = param1HttpURLConnection;
    }
    
    public boolean a() {
      return this.g;
    }
    
    public void b() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_0
      //   4: putfield j : Z
      //   7: aload_0
      //   8: new java/lang/Thread
      //   11: dup
      //   12: aload_0
      //   13: invokespecial <init> : (Ljava/lang/Runnable;)V
      //   16: putfield h : Ljava/lang/Thread;
      //   19: aload_0
      //   20: getfield h : Ljava/lang/Thread;
      //   23: invokevirtual start : ()V
      //   26: aload_0
      //   27: monitorexit
      //   28: return
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      // Exception table:
      //   from	to	target	type
      //   2	26	29	finally
    }
    
    public void c() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield j : Z
      //   7: aload_0
      //   8: aload_0
      //   9: getfield k : I
      //   12: iconst_1
      //   13: iadd
      //   14: putfield k : I
      //   17: aload_0
      //   18: monitorexit
      //   19: return
      //   20: astore_1
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: athrow
      // Exception table:
      //   from	to	target	type
      //   2	17	20	finally
    }
    
    public void d() {
      Thread thread = this.h;
      if (thread != null) {
        thread.join();
        return;
      } 
      XAdSDKFoundationFacade.getInstance().getAdLogger().w(new Object[] { "DownloadThread", "Warning: mThread in DownloadThread.waitFinish is null" });
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield k : I
      //   4: istore_3
      //   5: aconst_null
      //   6: astore #11
      //   8: aconst_null
      //   9: astore #12
      //   11: aconst_null
      //   12: astore #8
      //   14: aload_0
      //   15: getfield d : I
      //   18: aload_0
      //   19: getfield f : I
      //   22: iadd
      //   23: aload_0
      //   24: getfield e : I
      //   27: if_icmplt -> 45
      //   30: aload_0
      //   31: iconst_1
      //   32: putfield g : Z
      //   35: aconst_null
      //   36: astore #7
      //   38: aload #7
      //   40: astore #10
      //   42: goto -> 1030
      //   45: aload_0
      //   46: getfield l : Ljava/net/HttpURLConnection;
      //   49: ifnonnull -> 766
      //   52: aload_0
      //   53: getfield b : Ljava/net/URL;
      //   56: invokevirtual openConnection : ()Ljava/net/URLConnection;
      //   59: checkcast java/net/HttpURLConnection
      //   62: astore #7
      //   64: aload #7
      //   66: astore #8
      //   68: aload #7
      //   70: astore #9
      //   72: aload_0
      //   73: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   76: getfield f : Ljava/lang/Boolean;
      //   79: invokevirtual booleanValue : ()Z
      //   82: ifeq -> 246
      //   85: aload #7
      //   87: astore #8
      //   89: aload #7
      //   91: astore #9
      //   93: new java/lang/StringBuilder
      //   96: dup
      //   97: invokespecial <init> : ()V
      //   100: astore #10
      //   102: aload #7
      //   104: astore #8
      //   106: aload #7
      //   108: astore #9
      //   110: aload #10
      //   112: aload_0
      //   113: getfield d : I
      //   116: aload_0
      //   117: getfield f : I
      //   120: iadd
      //   121: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   124: pop
      //   125: aload #7
      //   127: astore #8
      //   129: aload #7
      //   131: astore #9
      //   133: aload #10
      //   135: ldc '-'
      //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: pop
      //   141: aload #7
      //   143: astore #8
      //   145: aload #7
      //   147: astore #9
      //   149: aload #10
      //   151: aload_0
      //   152: getfield e : I
      //   155: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   158: pop
      //   159: aload #7
      //   161: astore #8
      //   163: aload #7
      //   165: astore #9
      //   167: aload #10
      //   169: invokevirtual toString : ()Ljava/lang/String;
      //   172: astore #10
      //   174: aload #7
      //   176: astore #8
      //   178: aload #7
      //   180: astore #9
      //   182: new java/lang/StringBuilder
      //   185: dup
      //   186: invokespecial <init> : ()V
      //   189: astore #13
      //   191: aload #7
      //   193: astore #8
      //   195: aload #7
      //   197: astore #9
      //   199: aload #13
      //   201: ldc 'bytes='
      //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   206: pop
      //   207: aload #7
      //   209: astore #8
      //   211: aload #7
      //   213: astore #9
      //   215: aload #13
      //   217: aload #10
      //   219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   222: pop
      //   223: aload #7
      //   225: astore #8
      //   227: aload #7
      //   229: astore #9
      //   231: aload #7
      //   233: ldc 'Range'
      //   235: aload #13
      //   237: invokevirtual toString : ()Ljava/lang/String;
      //   240: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
      //   243: goto -> 259
      //   246: aload #7
      //   248: astore #8
      //   250: aload #7
      //   252: astore #9
      //   254: aload_0
      //   255: iconst_0
      //   256: putfield f : I
      //   259: aload #7
      //   261: astore #8
      //   263: aload #7
      //   265: astore #9
      //   267: aload #7
      //   269: invokevirtual connect : ()V
      //   272: aload #7
      //   274: astore #8
      //   276: aload #7
      //   278: astore #9
      //   280: aload #7
      //   282: invokevirtual getResponseCode : ()I
      //   285: istore_2
      //   286: iload_2
      //   287: sipush #302
      //   290: if_icmpeq -> 306
      //   293: aload #7
      //   295: astore #10
      //   297: iload_2
      //   298: istore_1
      //   299: iload_2
      //   300: sipush #301
      //   303: if_icmpne -> 353
      //   306: aload #7
      //   308: astore #8
      //   310: aload #7
      //   312: astore #9
      //   314: aload #7
      //   316: iconst_0
      //   317: invokevirtual setInstanceFollowRedirects : (Z)V
      //   320: aload #7
      //   322: astore #8
      //   324: aload #7
      //   326: astore #9
      //   328: aload_0
      //   329: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   332: aload #7
      //   334: invokestatic a : (Lcom/baidu/mobads/openad/b/a;Ljava/net/HttpURLConnection;)Ljava/net/HttpURLConnection;
      //   337: astore #10
      //   339: aload #10
      //   341: astore #8
      //   343: aload #10
      //   345: astore #9
      //   347: aload #10
      //   349: invokevirtual getResponseCode : ()I
      //   352: istore_1
      //   353: aload #10
      //   355: astore #8
      //   357: aload #10
      //   359: astore #9
      //   361: aload_0
      //   362: getfield k : I
      //   365: istore_2
      //   366: iload_3
      //   367: iload_2
      //   368: if_icmpeq -> 479
      //   371: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   374: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   377: astore #7
      //   379: new java/lang/StringBuilder
      //   382: dup
      //   383: invokespecial <init> : ()V
      //   386: astore #8
      //   388: aload #8
      //   390: ldc 'Thread['
      //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   395: pop
      //   396: aload #8
      //   398: aload_0
      //   399: getfield a : I
      //   402: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   405: pop
      //   406: aload #8
      //   408: ldc '] ver('
      //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   413: pop
      //   414: aload #8
      //   416: iload_3
      //   417: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   420: pop
      //   421: aload #8
      //   423: ldc ') executed end; isFinished='
      //   425: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   428: pop
      //   429: aload #8
      //   431: aload_0
      //   432: getfield g : Z
      //   435: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   438: pop
      //   439: aload #7
      //   441: ldc 'DownloadThread'
      //   443: aload #8
      //   445: invokevirtual toString : ()Ljava/lang/String;
      //   448: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   453: pop
      //   454: aload_0
      //   455: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   458: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   461: ifnull -> 478
      //   464: aload_0
      //   465: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   468: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   471: aload #10
      //   473: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
      //   478: return
      //   479: aload #10
      //   481: astore #8
      //   483: aload #10
      //   485: astore #9
      //   487: iload_1
      //   488: bipush #100
      //   490: idiv
      //   491: iconst_2
      //   492: if_icmpeq -> 618
      //   495: aload #10
      //   497: astore #8
      //   499: aload #10
      //   501: astore #9
      //   503: aload_0
      //   504: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   507: invokevirtual b : ()V
      //   510: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   513: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   516: astore #7
      //   518: new java/lang/StringBuilder
      //   521: dup
      //   522: invokespecial <init> : ()V
      //   525: astore #8
      //   527: aload #8
      //   529: ldc 'Thread['
      //   531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   534: pop
      //   535: aload #8
      //   537: aload_0
      //   538: getfield a : I
      //   541: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   544: pop
      //   545: aload #8
      //   547: ldc '] ver('
      //   549: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   552: pop
      //   553: aload #8
      //   555: iload_3
      //   556: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   559: pop
      //   560: aload #8
      //   562: ldc ') executed end; isFinished='
      //   564: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   567: pop
      //   568: aload #8
      //   570: aload_0
      //   571: getfield g : Z
      //   574: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   577: pop
      //   578: aload #7
      //   580: ldc 'DownloadThread'
      //   582: aload #8
      //   584: invokevirtual toString : ()Ljava/lang/String;
      //   587: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   592: pop
      //   593: aload_0
      //   594: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   597: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   600: ifnull -> 617
      //   603: aload_0
      //   604: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   607: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   610: aload #10
      //   612: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
      //   617: return
      //   618: aload #10
      //   620: astore #7
      //   622: aload #10
      //   624: astore #8
      //   626: aload #10
      //   628: astore #9
      //   630: aload #10
      //   632: invokevirtual getContentType : ()Ljava/lang/String;
      //   635: ldc 'text/html'
      //   637: invokevirtual equals : (Ljava/lang/Object;)Z
      //   640: ifeq -> 785
      //   643: aload #10
      //   645: astore #8
      //   647: aload #10
      //   649: astore #9
      //   651: aload_0
      //   652: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   655: invokevirtual b : ()V
      //   658: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   661: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   664: astore #7
      //   666: new java/lang/StringBuilder
      //   669: dup
      //   670: invokespecial <init> : ()V
      //   673: astore #8
      //   675: aload #8
      //   677: ldc 'Thread['
      //   679: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   682: pop
      //   683: aload #8
      //   685: aload_0
      //   686: getfield a : I
      //   689: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   692: pop
      //   693: aload #8
      //   695: ldc '] ver('
      //   697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   700: pop
      //   701: aload #8
      //   703: iload_3
      //   704: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   707: pop
      //   708: aload #8
      //   710: ldc ') executed end; isFinished='
      //   712: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   715: pop
      //   716: aload #8
      //   718: aload_0
      //   719: getfield g : Z
      //   722: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   725: pop
      //   726: aload #7
      //   728: ldc 'DownloadThread'
      //   730: aload #8
      //   732: invokevirtual toString : ()Ljava/lang/String;
      //   735: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   740: pop
      //   741: aload_0
      //   742: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   745: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   748: ifnull -> 765
      //   751: aload_0
      //   752: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   755: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   758: aload #10
      //   760: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
      //   765: return
      //   766: aload_0
      //   767: getfield l : Ljava/net/HttpURLConnection;
      //   770: astore #7
      //   772: aload #7
      //   774: astore #8
      //   776: aload #7
      //   778: astore #9
      //   780: aload_0
      //   781: aconst_null
      //   782: putfield l : Ljava/net/HttpURLConnection;
      //   785: aload #7
      //   787: astore #8
      //   789: aload #7
      //   791: astore #9
      //   793: new java/io/BufferedInputStream
      //   796: dup
      //   797: aload #7
      //   799: invokevirtual getInputStream : ()Ljava/io/InputStream;
      //   802: invokespecial <init> : (Ljava/io/InputStream;)V
      //   805: astore #10
      //   807: aload_0
      //   808: getfield d : I
      //   811: aload_0
      //   812: getfield f : I
      //   815: iadd
      //   816: istore_1
      //   817: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   820: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   823: astore #8
      //   825: new java/lang/StringBuilder
      //   828: dup
      //   829: invokespecial <init> : ()V
      //   832: astore #9
      //   834: aload #9
      //   836: ldc 'tmpStartByte = '
      //   838: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   841: pop
      //   842: aload #9
      //   844: iload_1
      //   845: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   848: pop
      //   849: aload #8
      //   851: ldc 'DownloadThread'
      //   853: aload #9
      //   855: invokevirtual toString : ()Ljava/lang/String;
      //   858: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   863: pop
      //   864: new java/io/RandomAccessFile
      //   867: dup
      //   868: aload_0
      //   869: getfield c : Ljava/lang/String;
      //   872: ldc 'rw'
      //   874: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
      //   877: astore #8
      //   879: iload_1
      //   880: i2l
      //   881: lstore #5
      //   883: aload #8
      //   885: lload #5
      //   887: invokevirtual seek : (J)V
      //   890: ldc 102400
      //   892: newarray byte
      //   894: astore #9
      //   896: iload_1
      //   897: istore_2
      //   898: aload_0
      //   899: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   902: getfield i : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
      //   905: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.DOWNLOADING : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
      //   908: if_acmpne -> 1017
      //   911: aload #10
      //   913: aload #9
      //   915: iconst_0
      //   916: ldc 102400
      //   918: invokevirtual read : ([BII)I
      //   921: istore #4
      //   923: iload_1
      //   924: istore_2
      //   925: iload #4
      //   927: iconst_m1
      //   928: if_icmpeq -> 1017
      //   931: iload_1
      //   932: istore_2
      //   933: iload_1
      //   934: aload_0
      //   935: getfield e : I
      //   938: if_icmpge -> 1017
      //   941: iload_3
      //   942: aload_0
      //   943: getfield k : I
      //   946: if_icmpeq -> 954
      //   949: iload_1
      //   950: istore_2
      //   951: goto -> 1017
      //   954: aload #8
      //   956: aload #9
      //   958: iconst_0
      //   959: iload #4
      //   961: invokevirtual write : ([BII)V
      //   964: aload_0
      //   965: aload_0
      //   966: getfield f : I
      //   969: iload #4
      //   971: iadd
      //   972: putfield f : I
      //   975: iload_1
      //   976: iload #4
      //   978: iadd
      //   979: istore_1
      //   980: aload_0
      //   981: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   984: iload #4
      //   986: invokevirtual a : (I)V
      //   989: aload_0
      //   990: monitorenter
      //   991: aload_0
      //   992: getfield j : Z
      //   995: ifeq -> 1005
      //   998: aload_0
      //   999: monitorexit
      //   1000: iload_1
      //   1001: istore_2
      //   1002: goto -> 1017
      //   1005: aload_0
      //   1006: monitorexit
      //   1007: goto -> 896
      //   1010: astore #9
      //   1012: aload_0
      //   1013: monitorexit
      //   1014: aload #9
      //   1016: athrow
      //   1017: iload_2
      //   1018: aload_0
      //   1019: getfield e : I
      //   1022: if_icmplt -> 1030
      //   1025: aload_0
      //   1026: iconst_1
      //   1027: putfield g : Z
      //   1030: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1033: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1036: astore #9
      //   1038: new java/lang/StringBuilder
      //   1041: dup
      //   1042: invokespecial <init> : ()V
      //   1045: astore #11
      //   1047: aload #11
      //   1049: ldc 'Thread['
      //   1051: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1054: pop
      //   1055: aload #11
      //   1057: aload_0
      //   1058: getfield a : I
      //   1061: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1064: pop
      //   1065: aload #11
      //   1067: ldc '] ver('
      //   1069: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1072: pop
      //   1073: aload #11
      //   1075: iload_3
      //   1076: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1079: pop
      //   1080: aload #11
      //   1082: ldc ') executed end; isFinished='
      //   1084: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1087: pop
      //   1088: aload #11
      //   1090: aload_0
      //   1091: getfield g : Z
      //   1094: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1097: pop
      //   1098: aload #9
      //   1100: ldc 'DownloadThread'
      //   1102: aload #11
      //   1104: invokevirtual toString : ()Ljava/lang/String;
      //   1107: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   1112: pop
      //   1113: aload #8
      //   1115: ifnull -> 1157
      //   1118: aload #8
      //   1120: invokevirtual close : ()V
      //   1123: goto -> 1157
      //   1126: astore #8
      //   1128: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1131: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1134: iconst_2
      //   1135: anewarray java/lang/Object
      //   1138: dup
      //   1139: iconst_0
      //   1140: ldc 'DownloadThread'
      //   1142: aastore
      //   1143: dup
      //   1144: iconst_1
      //   1145: aload #8
      //   1147: invokevirtual getMessage : ()Ljava/lang/String;
      //   1150: aastore
      //   1151: invokeinterface w : ([Ljava/lang/Object;)I
      //   1156: pop
      //   1157: aload #10
      //   1159: ifnull -> 1201
      //   1162: aload #10
      //   1164: invokevirtual close : ()V
      //   1167: goto -> 1201
      //   1170: astore #8
      //   1172: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1175: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1178: iconst_2
      //   1179: anewarray java/lang/Object
      //   1182: dup
      //   1183: iconst_0
      //   1184: ldc 'DownloadThread'
      //   1186: aastore
      //   1187: dup
      //   1188: iconst_1
      //   1189: aload #8
      //   1191: invokevirtual getMessage : ()Ljava/lang/String;
      //   1194: aastore
      //   1195: invokeinterface w : ([Ljava/lang/Object;)I
      //   1200: pop
      //   1201: aload_0
      //   1202: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   1205: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   1208: ifnull -> 1600
      //   1211: aload_0
      //   1212: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   1215: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   1218: aload #7
      //   1220: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
      //   1225: return
      //   1226: astore #11
      //   1228: aload #7
      //   1230: astore #9
      //   1232: aload #10
      //   1234: astore #7
      //   1236: aload #8
      //   1238: astore #10
      //   1240: aload #11
      //   1242: astore #8
      //   1244: goto -> 1611
      //   1247: astore #9
      //   1249: aload #7
      //   1251: astore #11
      //   1253: aload #10
      //   1255: astore #7
      //   1257: aload #8
      //   1259: astore #10
      //   1261: aload #11
      //   1263: astore #8
      //   1265: goto -> 1371
      //   1268: astore #8
      //   1270: aload #7
      //   1272: astore #9
      //   1274: aload #10
      //   1276: astore #7
      //   1278: aload #12
      //   1280: astore #10
      //   1282: goto -> 1611
      //   1285: astore #9
      //   1287: aload #7
      //   1289: astore #8
      //   1291: aload #10
      //   1293: astore #7
      //   1295: aload #11
      //   1297: astore #10
      //   1299: goto -> 1371
      //   1302: astore #11
      //   1304: aload #8
      //   1306: astore #9
      //   1308: aconst_null
      //   1309: astore #7
      //   1311: aload #12
      //   1313: astore #10
      //   1315: aload #11
      //   1317: astore #8
      //   1319: goto -> 1611
      //   1322: astore #12
      //   1324: aload #9
      //   1326: astore #8
      //   1328: aconst_null
      //   1329: astore #7
      //   1331: aload #11
      //   1333: astore #10
      //   1335: aload #12
      //   1337: astore #9
      //   1339: goto -> 1371
      //   1342: astore #8
      //   1344: aconst_null
      //   1345: astore #9
      //   1347: aload #9
      //   1349: astore #7
      //   1351: aload #12
      //   1353: astore #10
      //   1355: goto -> 1611
      //   1358: astore #9
      //   1360: aconst_null
      //   1361: astore #8
      //   1363: aload #8
      //   1365: astore #7
      //   1367: aload #11
      //   1369: astore #10
      //   1371: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1374: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1377: ldc 'DownloadThread'
      //   1379: aload #9
      //   1381: invokevirtual getMessage : ()Ljava/lang/String;
      //   1384: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   1389: pop
      //   1390: iload_3
      //   1391: aload_0
      //   1392: getfield k : I
      //   1395: if_icmpne -> 1405
      //   1398: aload_0
      //   1399: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   1402: invokevirtual b : ()V
      //   1405: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1408: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1411: astore #9
      //   1413: new java/lang/StringBuilder
      //   1416: dup
      //   1417: invokespecial <init> : ()V
      //   1420: astore #11
      //   1422: aload #11
      //   1424: ldc 'Thread['
      //   1426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1429: pop
      //   1430: aload #11
      //   1432: aload_0
      //   1433: getfield a : I
      //   1436: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1439: pop
      //   1440: aload #11
      //   1442: ldc '] ver('
      //   1444: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1447: pop
      //   1448: aload #11
      //   1450: iload_3
      //   1451: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1454: pop
      //   1455: aload #11
      //   1457: ldc ') executed end; isFinished='
      //   1459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1462: pop
      //   1463: aload #11
      //   1465: aload_0
      //   1466: getfield g : Z
      //   1469: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1472: pop
      //   1473: aload #9
      //   1475: ldc 'DownloadThread'
      //   1477: aload #11
      //   1479: invokevirtual toString : ()Ljava/lang/String;
      //   1482: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   1487: pop
      //   1488: aload #10
      //   1490: ifnull -> 1532
      //   1493: aload #10
      //   1495: invokevirtual close : ()V
      //   1498: goto -> 1532
      //   1501: astore #9
      //   1503: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1506: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1509: iconst_2
      //   1510: anewarray java/lang/Object
      //   1513: dup
      //   1514: iconst_0
      //   1515: ldc 'DownloadThread'
      //   1517: aastore
      //   1518: dup
      //   1519: iconst_1
      //   1520: aload #9
      //   1522: invokevirtual getMessage : ()Ljava/lang/String;
      //   1525: aastore
      //   1526: invokeinterface w : ([Ljava/lang/Object;)I
      //   1531: pop
      //   1532: aload #7
      //   1534: ifnull -> 1576
      //   1537: aload #7
      //   1539: invokevirtual close : ()V
      //   1542: goto -> 1576
      //   1545: astore #7
      //   1547: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1550: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1553: iconst_2
      //   1554: anewarray java/lang/Object
      //   1557: dup
      //   1558: iconst_0
      //   1559: ldc 'DownloadThread'
      //   1561: aastore
      //   1562: dup
      //   1563: iconst_1
      //   1564: aload #7
      //   1566: invokevirtual getMessage : ()Ljava/lang/String;
      //   1569: aastore
      //   1570: invokeinterface w : ([Ljava/lang/Object;)I
      //   1575: pop
      //   1576: aload_0
      //   1577: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   1580: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   1583: ifnull -> 1600
      //   1586: aload_0
      //   1587: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   1590: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   1593: aload #8
      //   1595: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
      //   1600: return
      //   1601: astore #11
      //   1603: aload #8
      //   1605: astore #9
      //   1607: aload #11
      //   1609: astore #8
      //   1611: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1614: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1617: astore #11
      //   1619: new java/lang/StringBuilder
      //   1622: dup
      //   1623: invokespecial <init> : ()V
      //   1626: astore #12
      //   1628: aload #12
      //   1630: ldc 'Thread['
      //   1632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1635: pop
      //   1636: aload #12
      //   1638: aload_0
      //   1639: getfield a : I
      //   1642: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1645: pop
      //   1646: aload #12
      //   1648: ldc '] ver('
      //   1650: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1653: pop
      //   1654: aload #12
      //   1656: iload_3
      //   1657: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1660: pop
      //   1661: aload #12
      //   1663: ldc ') executed end; isFinished='
      //   1665: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1668: pop
      //   1669: aload #12
      //   1671: aload_0
      //   1672: getfield g : Z
      //   1675: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1678: pop
      //   1679: aload #11
      //   1681: ldc 'DownloadThread'
      //   1683: aload #12
      //   1685: invokevirtual toString : ()Ljava/lang/String;
      //   1688: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
      //   1693: pop
      //   1694: aload #10
      //   1696: ifnull -> 1738
      //   1699: aload #10
      //   1701: invokevirtual close : ()V
      //   1704: goto -> 1738
      //   1707: astore #10
      //   1709: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1712: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1715: iconst_2
      //   1716: anewarray java/lang/Object
      //   1719: dup
      //   1720: iconst_0
      //   1721: ldc 'DownloadThread'
      //   1723: aastore
      //   1724: dup
      //   1725: iconst_1
      //   1726: aload #10
      //   1728: invokevirtual getMessage : ()Ljava/lang/String;
      //   1731: aastore
      //   1732: invokeinterface w : ([Ljava/lang/Object;)I
      //   1737: pop
      //   1738: aload #7
      //   1740: ifnull -> 1782
      //   1743: aload #7
      //   1745: invokevirtual close : ()V
      //   1748: goto -> 1782
      //   1751: astore #7
      //   1753: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
      //   1756: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
      //   1759: iconst_2
      //   1760: anewarray java/lang/Object
      //   1763: dup
      //   1764: iconst_0
      //   1765: ldc 'DownloadThread'
      //   1767: aastore
      //   1768: dup
      //   1769: iconst_1
      //   1770: aload #7
      //   1772: invokevirtual getMessage : ()Ljava/lang/String;
      //   1775: aastore
      //   1776: invokeinterface w : ([Ljava/lang/Object;)I
      //   1781: pop
      //   1782: aload_0
      //   1783: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   1786: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   1789: ifnull -> 1806
      //   1792: aload_0
      //   1793: getfield i : Lcom/baidu/mobads/openad/b/a;
      //   1796: invokestatic a : (Lcom/baidu/mobads/openad/b/a;)Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
      //   1799: aload #9
      //   1801: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
      //   1806: aload #8
      //   1808: athrow
      // Exception table:
      //   from	to	target	type
      //   14	35	1358	java/lang/Exception
      //   14	35	1342	finally
      //   45	64	1358	java/lang/Exception
      //   45	64	1342	finally
      //   72	85	1322	java/lang/Exception
      //   72	85	1302	finally
      //   93	102	1322	java/lang/Exception
      //   93	102	1302	finally
      //   110	125	1322	java/lang/Exception
      //   110	125	1302	finally
      //   133	141	1322	java/lang/Exception
      //   133	141	1302	finally
      //   149	159	1322	java/lang/Exception
      //   149	159	1302	finally
      //   167	174	1322	java/lang/Exception
      //   167	174	1302	finally
      //   182	191	1322	java/lang/Exception
      //   182	191	1302	finally
      //   199	207	1322	java/lang/Exception
      //   199	207	1302	finally
      //   215	223	1322	java/lang/Exception
      //   215	223	1302	finally
      //   231	243	1322	java/lang/Exception
      //   231	243	1302	finally
      //   254	259	1322	java/lang/Exception
      //   254	259	1302	finally
      //   267	272	1322	java/lang/Exception
      //   267	272	1302	finally
      //   280	286	1322	java/lang/Exception
      //   280	286	1302	finally
      //   314	320	1322	java/lang/Exception
      //   314	320	1302	finally
      //   328	339	1322	java/lang/Exception
      //   328	339	1302	finally
      //   347	353	1322	java/lang/Exception
      //   347	353	1302	finally
      //   361	366	1322	java/lang/Exception
      //   361	366	1302	finally
      //   487	495	1322	java/lang/Exception
      //   487	495	1302	finally
      //   503	510	1322	java/lang/Exception
      //   503	510	1302	finally
      //   630	643	1322	java/lang/Exception
      //   630	643	1302	finally
      //   651	658	1322	java/lang/Exception
      //   651	658	1302	finally
      //   766	772	1358	java/lang/Exception
      //   766	772	1342	finally
      //   780	785	1322	java/lang/Exception
      //   780	785	1302	finally
      //   793	807	1322	java/lang/Exception
      //   793	807	1302	finally
      //   807	879	1285	java/lang/Exception
      //   807	879	1268	finally
      //   883	896	1247	java/lang/Exception
      //   883	896	1226	finally
      //   898	923	1247	java/lang/Exception
      //   898	923	1226	finally
      //   933	949	1247	java/lang/Exception
      //   933	949	1226	finally
      //   954	975	1247	java/lang/Exception
      //   954	975	1226	finally
      //   980	991	1247	java/lang/Exception
      //   980	991	1226	finally
      //   991	1000	1010	finally
      //   1005	1007	1010	finally
      //   1012	1014	1010	finally
      //   1014	1017	1247	java/lang/Exception
      //   1014	1017	1226	finally
      //   1017	1030	1247	java/lang/Exception
      //   1017	1030	1226	finally
      //   1118	1123	1126	java/lang/Exception
      //   1162	1167	1170	java/lang/Exception
      //   1371	1405	1601	finally
      //   1493	1498	1501	java/lang/Exception
      //   1537	1542	1545	java/lang/Exception
      //   1699	1704	1707	java/lang/Exception
      //   1743	1748	1751	java/lang/Exception
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */