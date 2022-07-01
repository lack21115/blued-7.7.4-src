package com.baidu.mobads.openad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.aa;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

public class f extends Observable implements IOAdDownloader, Runnable {
  protected Context a;
  
  protected URL b;
  
  protected String c;
  
  protected String d;
  
  protected int e;
  
  protected IOAdDownloader.DownloadStatus f;
  
  protected int g;
  
  protected int h;
  
  private boolean i = false;
  
  private IXAdURIUitls j = (IXAdURIUitls)new aa();
  
  public f(Context paramContext, URL paramURL, String paramString1, String paramString2, boolean paramBoolean) {
    this.a = paramContext;
    this.b = paramURL;
    this.c = paramString1;
    this.i = paramBoolean;
    if (paramString2 != null && paramString2.trim().length() > 0) {
      this.d = paramString2;
    } else {
      String str = paramURL.getFile();
      this.d = str.substring(str.lastIndexOf('/') + 1);
    } 
    this.e = -1;
    this.f = IOAdDownloader.DownloadStatus.DOWNLOADING;
    this.g = 0;
    this.h = 0;
  }
  
  private HttpURLConnection a(HttpURLConnection paramHttpURLConnection) {
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
  
  private void d() {
    a(IOAdDownloader.DownloadStatus.ERROR);
  }
  
  public void a() {
    IXAdIOUtils iXAdIOUtils = XAdSDKFoundationFacade.getInstance().getIoUtils();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.c);
    stringBuilder1.append(this.d);
    stringBuilder1.append(".tmp");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.c);
    stringBuilder2.append(this.d);
    iXAdIOUtils.renameFile(str, stringBuilder2.toString());
  }
  
  protected void a(int paramInt, float paramFloat) {
    this.g += paramInt;
    c();
  }
  
  protected void a(IOAdDownloader.DownloadStatus paramDownloadStatus) {
    this.f = paramDownloadStatus;
    c();
  }
  
  protected void b() {
    (new Thread(this)).start();
  }
  
  protected void c() {
    setChanged();
    notifyObservers();
  }
  
  @Deprecated
  public void cancel() {}
  
  public int getFileSize() {
    return this.e;
  }
  
  public String getOutputPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.c);
    stringBuilder.append(this.d);
    return stringBuilder.toString();
  }
  
  @Deprecated
  public String getPackageName() {
    return null;
  }
  
  public float getProgress() {
    return Math.abs(this.g / this.e * 100.0F);
  }
  
  public IOAdDownloader.DownloadStatus getState() {
    return this.f;
  }
  
  @Deprecated
  public String getTargetURL() {
    return null;
  }
  
  @Deprecated
  public String getTitle() {
    return null;
  }
  
  public String getURL() {
    return this.b.toString();
  }
  
  public boolean isPausedManually() {
    return false;
  }
  
  @Deprecated
  public void pause() {}
  
  public void removeObservers() {}
  
  @Deprecated
  public void resume() {}
  
  public void run() {
    // Byte code:
    //   0: aconst_null
    //   1: astore #11
    //   3: aconst_null
    //   4: astore #7
    //   6: aconst_null
    //   7: astore #9
    //   9: aconst_null
    //   10: astore #12
    //   12: aconst_null
    //   13: astore #10
    //   15: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   18: invokevirtual getURIUitls : ()Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   21: aload_0
    //   22: getfield b : Ljava/net/URL;
    //   25: invokeinterface getHttpURLConnection : (Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   30: astore #4
    //   32: aload #4
    //   34: astore #5
    //   36: aload #4
    //   38: astore #6
    //   40: aload #4
    //   42: sipush #10000
    //   45: invokevirtual setConnectTimeout : (I)V
    //   48: aload #4
    //   50: astore #5
    //   52: aload #4
    //   54: astore #6
    //   56: aload #4
    //   58: iconst_1
    //   59: invokevirtual setInstanceFollowRedirects : (Z)V
    //   62: aload #4
    //   64: astore #5
    //   66: aload #4
    //   68: astore #6
    //   70: aload #4
    //   72: invokevirtual connect : ()V
    //   75: aload #4
    //   77: astore #5
    //   79: aload #4
    //   81: astore #6
    //   83: aload #4
    //   85: invokevirtual getResponseCode : ()I
    //   88: istore_2
    //   89: iload_2
    //   90: sipush #302
    //   93: if_icmpeq -> 108
    //   96: aload #4
    //   98: astore_3
    //   99: iload_2
    //   100: istore_1
    //   101: iload_2
    //   102: sipush #301
    //   105: if_icmpne -> 148
    //   108: aload #4
    //   110: astore #5
    //   112: aload #4
    //   114: astore #6
    //   116: aload #4
    //   118: iconst_0
    //   119: invokevirtual setInstanceFollowRedirects : (Z)V
    //   122: aload #4
    //   124: astore #5
    //   126: aload #4
    //   128: astore #6
    //   130: aload_0
    //   131: aload #4
    //   133: invokespecial a : (Ljava/net/HttpURLConnection;)Ljava/net/HttpURLConnection;
    //   136: astore_3
    //   137: aload_3
    //   138: astore #5
    //   140: aload_3
    //   141: astore #6
    //   143: aload_3
    //   144: invokevirtual getResponseCode : ()I
    //   147: istore_1
    //   148: aload_3
    //   149: astore #5
    //   151: aload_3
    //   152: astore #6
    //   154: iload_1
    //   155: bipush #100
    //   157: idiv
    //   158: iconst_2
    //   159: if_icmpeq -> 172
    //   162: aload_3
    //   163: astore #5
    //   165: aload_3
    //   166: astore #6
    //   168: aload_0
    //   169: invokespecial d : ()V
    //   172: aload_3
    //   173: astore #5
    //   175: aload_3
    //   176: astore #6
    //   178: aload_3
    //   179: invokevirtual getContentLength : ()I
    //   182: istore_1
    //   183: iload_1
    //   184: ifle -> 198
    //   187: aload_3
    //   188: astore #5
    //   190: aload_3
    //   191: astore #6
    //   193: aload_0
    //   194: iload_1
    //   195: putfield e : I
    //   198: aload_3
    //   199: astore #5
    //   201: aload_3
    //   202: astore #6
    //   204: new java/io/File
    //   207: dup
    //   208: aload_0
    //   209: getfield c : Ljava/lang/String;
    //   212: invokespecial <init> : (Ljava/lang/String;)V
    //   215: astore #4
    //   217: aload_3
    //   218: astore #5
    //   220: aload_3
    //   221: astore #6
    //   223: aload #4
    //   225: invokevirtual exists : ()Z
    //   228: ifne -> 243
    //   231: aload_3
    //   232: astore #5
    //   234: aload_3
    //   235: astore #6
    //   237: aload #4
    //   239: invokevirtual mkdirs : ()Z
    //   242: pop
    //   243: aload_3
    //   244: astore #5
    //   246: aload_3
    //   247: astore #6
    //   249: new java/io/BufferedInputStream
    //   252: dup
    //   253: aload_3
    //   254: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   257: invokespecial <init> : (Ljava/io/InputStream;)V
    //   260: astore #4
    //   262: new java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial <init> : ()V
    //   269: astore #5
    //   271: aload #5
    //   273: aload_0
    //   274: invokevirtual getOutputPath : ()Ljava/lang/String;
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload #5
    //   283: ldc '.tmp'
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: new java/io/BufferedOutputStream
    //   292: dup
    //   293: new java/io/FileOutputStream
    //   296: dup
    //   297: aload #5
    //   299: invokevirtual toString : ()Ljava/lang/String;
    //   302: invokespecial <init> : (Ljava/lang/String;)V
    //   305: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   308: astore #8
    //   310: aload #10
    //   312: astore #6
    //   314: aload #11
    //   316: astore #7
    //   318: sipush #10240
    //   321: newarray byte
    //   323: astore #9
    //   325: aload #10
    //   327: astore #6
    //   329: aload #11
    //   331: astore #7
    //   333: aload #12
    //   335: astore #5
    //   337: aload_0
    //   338: getfield i : Z
    //   341: ifeq -> 1226
    //   344: aload #10
    //   346: astore #6
    //   348: aload #11
    //   350: astore #7
    //   352: new java/io/ByteArrayOutputStream
    //   355: dup
    //   356: invokespecial <init> : ()V
    //   359: astore #5
    //   361: goto -> 1226
    //   364: aload #5
    //   366: astore #6
    //   368: aload #5
    //   370: astore #7
    //   372: aload_0
    //   373: getfield f : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   376: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.DOWNLOADING : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   379: if_acmpne -> 474
    //   382: aload #5
    //   384: astore #6
    //   386: aload #5
    //   388: astore #7
    //   390: aload #4
    //   392: aload #9
    //   394: iconst_0
    //   395: sipush #10240
    //   398: invokevirtual read : ([BII)I
    //   401: istore_2
    //   402: iload_2
    //   403: iconst_m1
    //   404: if_icmpeq -> 474
    //   407: aload #5
    //   409: astore #6
    //   411: aload #5
    //   413: astore #7
    //   415: aload #8
    //   417: aload #9
    //   419: iconst_0
    //   420: iload_2
    //   421: invokevirtual write : ([BII)V
    //   424: aload #5
    //   426: ifnull -> 446
    //   429: aload #5
    //   431: astore #6
    //   433: aload #5
    //   435: astore #7
    //   437: aload #5
    //   439: aload #9
    //   441: iconst_0
    //   442: iload_2
    //   443: invokevirtual write : ([BII)V
    //   446: iload_1
    //   447: iload_2
    //   448: iadd
    //   449: istore_1
    //   450: aload #5
    //   452: astore #6
    //   454: aload #5
    //   456: astore #7
    //   458: aload_0
    //   459: iload_2
    //   460: iload_1
    //   461: i2f
    //   462: aload_0
    //   463: getfield e : I
    //   466: i2f
    //   467: fdiv
    //   468: invokevirtual a : (IF)V
    //   471: goto -> 364
    //   474: aload #5
    //   476: astore #6
    //   478: aload #5
    //   480: astore #7
    //   482: aload #8
    //   484: invokevirtual flush : ()V
    //   487: aload #5
    //   489: ifnull -> 505
    //   492: aload #5
    //   494: astore #6
    //   496: aload #5
    //   498: astore #7
    //   500: aload #5
    //   502: invokevirtual flush : ()V
    //   505: aload #5
    //   507: astore #6
    //   509: aload #5
    //   511: astore #7
    //   513: aload_0
    //   514: getfield f : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   517: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.DOWNLOADING : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   520: if_acmpne -> 553
    //   523: aload #5
    //   525: astore #6
    //   527: aload #5
    //   529: astore #7
    //   531: aload_0
    //   532: invokevirtual a : ()V
    //   535: aload #5
    //   537: astore #6
    //   539: aload #5
    //   541: astore #7
    //   543: aload_0
    //   544: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.COMPLETED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   547: invokevirtual a : (Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;)V
    //   550: goto -> 580
    //   553: aload #5
    //   555: astore #6
    //   557: aload #5
    //   559: astore #7
    //   561: aload_0
    //   562: getfield f : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   565: astore #9
    //   567: aload #5
    //   569: astore #6
    //   571: aload #5
    //   573: astore #7
    //   575: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   578: astore #9
    //   580: aload #8
    //   582: invokevirtual close : ()V
    //   585: goto -> 620
    //   588: astore #6
    //   590: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   593: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   596: iconst_2
    //   597: anewarray java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: ldc_w 'OAdSimpleFileDownloader'
    //   605: aastore
    //   606: dup
    //   607: iconst_1
    //   608: aload #6
    //   610: invokevirtual getMessage : ()Ljava/lang/String;
    //   613: aastore
    //   614: invokeinterface e : ([Ljava/lang/Object;)I
    //   619: pop
    //   620: aload #5
    //   622: ifnull -> 665
    //   625: aload #5
    //   627: invokevirtual close : ()V
    //   630: goto -> 665
    //   633: astore #5
    //   635: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   638: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   641: iconst_2
    //   642: anewarray java/lang/Object
    //   645: dup
    //   646: iconst_0
    //   647: ldc_w 'OAdSimpleFileDownloader'
    //   650: aastore
    //   651: dup
    //   652: iconst_1
    //   653: aload #5
    //   655: invokevirtual getMessage : ()Ljava/lang/String;
    //   658: aastore
    //   659: invokeinterface e : ([Ljava/lang/Object;)I
    //   664: pop
    //   665: aload #4
    //   667: invokevirtual close : ()V
    //   670: goto -> 705
    //   673: astore #4
    //   675: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   678: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   681: iconst_2
    //   682: anewarray java/lang/Object
    //   685: dup
    //   686: iconst_0
    //   687: ldc_w 'OAdSimpleFileDownloader'
    //   690: aastore
    //   691: dup
    //   692: iconst_1
    //   693: aload #4
    //   695: invokevirtual getMessage : ()Ljava/lang/String;
    //   698: aastore
    //   699: invokeinterface e : ([Ljava/lang/Object;)I
    //   704: pop
    //   705: aload_0
    //   706: getfield j : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   709: astore #4
    //   711: aload #4
    //   713: ifnull -> 1062
    //   716: aload #4
    //   718: aload_3
    //   719: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   724: return
    //   725: astore #9
    //   727: aload #8
    //   729: astore #7
    //   731: aload #4
    //   733: astore #5
    //   735: aload #9
    //   737: astore #4
    //   739: aload_3
    //   740: astore #8
    //   742: aload #6
    //   744: astore_3
    //   745: aload #8
    //   747: astore #6
    //   749: goto -> 1077
    //   752: astore #6
    //   754: aload #7
    //   756: astore #5
    //   758: aload #8
    //   760: astore #7
    //   762: aload_3
    //   763: astore #8
    //   765: aload #5
    //   767: astore_3
    //   768: aload #8
    //   770: astore #5
    //   772: goto -> 882
    //   775: astore #7
    //   777: aload_3
    //   778: astore #6
    //   780: aconst_null
    //   781: astore_3
    //   782: aload #4
    //   784: astore #5
    //   786: aload #7
    //   788: astore #4
    //   790: aload #9
    //   792: astore #7
    //   794: goto -> 1077
    //   797: astore #6
    //   799: aload_3
    //   800: astore #5
    //   802: aconst_null
    //   803: astore_3
    //   804: goto -> 882
    //   807: astore #4
    //   809: aconst_null
    //   810: astore #6
    //   812: aload #5
    //   814: astore #8
    //   816: aload #6
    //   818: astore_3
    //   819: aload #9
    //   821: astore #7
    //   823: aload #6
    //   825: astore #5
    //   827: aload #8
    //   829: astore #6
    //   831: goto -> 1077
    //   834: astore #8
    //   836: aconst_null
    //   837: astore #4
    //   839: aload #6
    //   841: astore #5
    //   843: aload #4
    //   845: astore_3
    //   846: aload #8
    //   848: astore #6
    //   850: goto -> 882
    //   853: astore #4
    //   855: aconst_null
    //   856: astore_3
    //   857: aload_3
    //   858: astore #5
    //   860: aload #5
    //   862: astore #6
    //   864: aload #9
    //   866: astore #7
    //   868: goto -> 1077
    //   871: astore #6
    //   873: aconst_null
    //   874: astore_3
    //   875: aload_3
    //   876: astore #4
    //   878: aload #4
    //   880: astore #5
    //   882: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   885: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   888: iconst_2
    //   889: anewarray java/lang/Object
    //   892: dup
    //   893: iconst_0
    //   894: ldc_w 'OAdSimpleFileDownloader'
    //   897: aastore
    //   898: dup
    //   899: iconst_1
    //   900: aload #6
    //   902: invokevirtual getMessage : ()Ljava/lang/String;
    //   905: aastore
    //   906: invokeinterface e : ([Ljava/lang/Object;)I
    //   911: pop
    //   912: aload_0
    //   913: invokespecial d : ()V
    //   916: aload #7
    //   918: ifnull -> 961
    //   921: aload #7
    //   923: invokevirtual close : ()V
    //   926: goto -> 961
    //   929: astore #6
    //   931: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   934: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   937: iconst_2
    //   938: anewarray java/lang/Object
    //   941: dup
    //   942: iconst_0
    //   943: ldc_w 'OAdSimpleFileDownloader'
    //   946: aastore
    //   947: dup
    //   948: iconst_1
    //   949: aload #6
    //   951: invokevirtual getMessage : ()Ljava/lang/String;
    //   954: aastore
    //   955: invokeinterface e : ([Ljava/lang/Object;)I
    //   960: pop
    //   961: aload_3
    //   962: ifnull -> 1002
    //   965: aload_3
    //   966: invokevirtual close : ()V
    //   969: goto -> 1002
    //   972: astore_3
    //   973: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   976: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   979: iconst_2
    //   980: anewarray java/lang/Object
    //   983: dup
    //   984: iconst_0
    //   985: ldc_w 'OAdSimpleFileDownloader'
    //   988: aastore
    //   989: dup
    //   990: iconst_1
    //   991: aload_3
    //   992: invokevirtual getMessage : ()Ljava/lang/String;
    //   995: aastore
    //   996: invokeinterface e : ([Ljava/lang/Object;)I
    //   1001: pop
    //   1002: aload #4
    //   1004: ifnull -> 1045
    //   1007: aload #4
    //   1009: invokevirtual close : ()V
    //   1012: goto -> 1045
    //   1015: astore_3
    //   1016: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1019: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1022: iconst_2
    //   1023: anewarray java/lang/Object
    //   1026: dup
    //   1027: iconst_0
    //   1028: ldc_w 'OAdSimpleFileDownloader'
    //   1031: aastore
    //   1032: dup
    //   1033: iconst_1
    //   1034: aload_3
    //   1035: invokevirtual getMessage : ()Ljava/lang/String;
    //   1038: aastore
    //   1039: invokeinterface e : ([Ljava/lang/Object;)I
    //   1044: pop
    //   1045: aload_0
    //   1046: getfield j : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   1049: astore_3
    //   1050: aload_3
    //   1051: ifnull -> 1062
    //   1054: aload_3
    //   1055: aload #5
    //   1057: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   1062: return
    //   1063: astore #8
    //   1065: aload #5
    //   1067: astore #6
    //   1069: aload #4
    //   1071: astore #5
    //   1073: aload #8
    //   1075: astore #4
    //   1077: aload #7
    //   1079: ifnull -> 1122
    //   1082: aload #7
    //   1084: invokevirtual close : ()V
    //   1087: goto -> 1122
    //   1090: astore #7
    //   1092: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1095: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1098: iconst_2
    //   1099: anewarray java/lang/Object
    //   1102: dup
    //   1103: iconst_0
    //   1104: ldc_w 'OAdSimpleFileDownloader'
    //   1107: aastore
    //   1108: dup
    //   1109: iconst_1
    //   1110: aload #7
    //   1112: invokevirtual getMessage : ()Ljava/lang/String;
    //   1115: aastore
    //   1116: invokeinterface e : ([Ljava/lang/Object;)I
    //   1121: pop
    //   1122: aload_3
    //   1123: ifnull -> 1163
    //   1126: aload_3
    //   1127: invokevirtual close : ()V
    //   1130: goto -> 1163
    //   1133: astore_3
    //   1134: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1137: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1140: iconst_2
    //   1141: anewarray java/lang/Object
    //   1144: dup
    //   1145: iconst_0
    //   1146: ldc_w 'OAdSimpleFileDownloader'
    //   1149: aastore
    //   1150: dup
    //   1151: iconst_1
    //   1152: aload_3
    //   1153: invokevirtual getMessage : ()Ljava/lang/String;
    //   1156: aastore
    //   1157: invokeinterface e : ([Ljava/lang/Object;)I
    //   1162: pop
    //   1163: aload #5
    //   1165: ifnull -> 1206
    //   1168: aload #5
    //   1170: invokevirtual close : ()V
    //   1173: goto -> 1206
    //   1176: astore_3
    //   1177: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1180: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1183: iconst_2
    //   1184: anewarray java/lang/Object
    //   1187: dup
    //   1188: iconst_0
    //   1189: ldc_w 'OAdSimpleFileDownloader'
    //   1192: aastore
    //   1193: dup
    //   1194: iconst_1
    //   1195: aload_3
    //   1196: invokevirtual getMessage : ()Ljava/lang/String;
    //   1199: aastore
    //   1200: invokeinterface e : ([Ljava/lang/Object;)I
    //   1205: pop
    //   1206: aload_0
    //   1207: getfield j : Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   1210: astore_3
    //   1211: aload_3
    //   1212: ifnull -> 1223
    //   1215: aload_3
    //   1216: aload #6
    //   1218: invokeinterface closeHttpURLConnection : (Ljava/net/HttpURLConnection;)V
    //   1223: aload #4
    //   1225: athrow
    //   1226: iconst_0
    //   1227: istore_1
    //   1228: goto -> 364
    // Exception table:
    //   from	to	target	type
    //   15	32	871	java/lang/Exception
    //   15	32	853	finally
    //   40	48	834	java/lang/Exception
    //   40	48	807	finally
    //   56	62	834	java/lang/Exception
    //   56	62	807	finally
    //   70	75	834	java/lang/Exception
    //   70	75	807	finally
    //   83	89	834	java/lang/Exception
    //   83	89	807	finally
    //   116	122	834	java/lang/Exception
    //   116	122	807	finally
    //   130	137	834	java/lang/Exception
    //   130	137	807	finally
    //   143	148	834	java/lang/Exception
    //   143	148	807	finally
    //   154	162	834	java/lang/Exception
    //   154	162	807	finally
    //   168	172	834	java/lang/Exception
    //   168	172	807	finally
    //   178	183	834	java/lang/Exception
    //   178	183	807	finally
    //   193	198	834	java/lang/Exception
    //   193	198	807	finally
    //   204	217	834	java/lang/Exception
    //   204	217	807	finally
    //   223	231	834	java/lang/Exception
    //   223	231	807	finally
    //   237	243	834	java/lang/Exception
    //   237	243	807	finally
    //   249	262	834	java/lang/Exception
    //   249	262	807	finally
    //   262	310	797	java/lang/Exception
    //   262	310	775	finally
    //   318	325	752	java/lang/Exception
    //   318	325	725	finally
    //   337	344	752	java/lang/Exception
    //   337	344	725	finally
    //   352	361	752	java/lang/Exception
    //   352	361	725	finally
    //   372	382	752	java/lang/Exception
    //   372	382	725	finally
    //   390	402	752	java/lang/Exception
    //   390	402	725	finally
    //   415	424	752	java/lang/Exception
    //   415	424	725	finally
    //   437	446	752	java/lang/Exception
    //   437	446	725	finally
    //   458	471	752	java/lang/Exception
    //   458	471	725	finally
    //   482	487	752	java/lang/Exception
    //   482	487	725	finally
    //   500	505	752	java/lang/Exception
    //   500	505	725	finally
    //   513	523	752	java/lang/Exception
    //   513	523	725	finally
    //   531	535	752	java/lang/Exception
    //   531	535	725	finally
    //   543	550	752	java/lang/Exception
    //   543	550	725	finally
    //   561	567	752	java/lang/Exception
    //   561	567	725	finally
    //   575	580	752	java/lang/Exception
    //   575	580	725	finally
    //   580	585	588	java/lang/Exception
    //   625	630	633	java/lang/Exception
    //   665	670	673	java/lang/Exception
    //   882	916	1063	finally
    //   921	926	929	java/lang/Exception
    //   965	969	972	java/lang/Exception
    //   1007	1012	1015	java/lang/Exception
    //   1082	1087	1090	java/lang/Exception
    //   1126	1130	1133	java/lang/Exception
    //   1168	1173	1176	java/lang/Exception
  }
  
  public void setPausedManually(boolean paramBoolean) {}
  
  public void start() {
    a(IOAdDownloader.DownloadStatus.DOWNLOADING);
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */