package com.loc;

import android.text.TextUtils;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

public final class at {
  private static SoftReference<SSLContext> k;
  
  private static SoftReference<au> m;
  
  private int a;
  
  private int b;
  
  private boolean c;
  
  private SSLContext d;
  
  private Proxy e;
  
  private volatile boolean f;
  
  private long g;
  
  private long h;
  
  private String i;
  
  private b j;
  
  private aq.a l;
  
  private String n;
  
  private boolean o;
  
  private String p;
  
  private at(int paramInt1, int paramInt2, Proxy paramProxy, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield f : Z
    //   9: aload_0
    //   10: ldc2_w -1
    //   13: putfield g : J
    //   16: aload_0
    //   17: lconst_0
    //   18: putfield h : J
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield o : Z
    //   26: aload_0
    //   27: ldc ''
    //   29: putfield p : Ljava/lang/String;
    //   32: aload_0
    //   33: iload_1
    //   34: putfield a : I
    //   37: aload_0
    //   38: iload_2
    //   39: putfield b : I
    //   42: aload_0
    //   43: aload_3
    //   44: putfield e : Ljava/net/Proxy;
    //   47: aload_0
    //   48: invokestatic a : ()Lcom/loc/p;
    //   51: iload #4
    //   53: invokevirtual b : (Z)Z
    //   56: putfield c : Z
    //   59: invokestatic d : ()V
    //   62: invokestatic b : ()Z
    //   65: ifeq -> 73
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield c : Z
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield l : Lcom/loc/aq$a;
    //   78: aload_0
    //   79: invokestatic randomUUID : ()Ljava/util/UUID;
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: ldc '-'
    //   87: ldc ''
    //   89: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   95: putfield i : Ljava/lang/String;
    //   98: goto -> 110
    //   101: astore_3
    //   102: aload_3
    //   103: ldc 'ht'
    //   105: ldc 'ic'
    //   107: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_0
    //   111: getfield c : Z
    //   114: ifeq -> 208
    //   117: getstatic com/loc/at.k : Ljava/lang/ref/SoftReference;
    //   120: ifnull -> 132
    //   123: getstatic com/loc/at.k : Ljava/lang/ref/SoftReference;
    //   126: invokevirtual get : ()Ljava/lang/Object;
    //   129: ifnonnull -> 147
    //   132: new java/lang/ref/SoftReference
    //   135: dup
    //   136: ldc 'TLS'
    //   138: invokestatic getInstance : (Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   141: invokespecial <init> : (Ljava/lang/Object;)V
    //   144: putstatic com/loc/at.k : Ljava/lang/ref/SoftReference;
    //   147: getstatic com/loc/at.k : Ljava/lang/ref/SoftReference;
    //   150: ifnull -> 166
    //   153: getstatic com/loc/at.k : Ljava/lang/ref/SoftReference;
    //   156: invokevirtual get : ()Ljava/lang/Object;
    //   159: checkcast javax/net/ssl/SSLContext
    //   162: astore_3
    //   163: goto -> 168
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: astore #5
    //   171: aload_3
    //   172: ifnonnull -> 182
    //   175: ldc 'TLS'
    //   177: invokestatic getInstance : (Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   180: astore #5
    //   182: aload #5
    //   184: aconst_null
    //   185: aconst_null
    //   186: aconst_null
    //   187: invokevirtual init : ([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   190: aload_0
    //   191: aload #5
    //   193: putfield d : Ljavax/net/ssl/SSLContext;
    //   196: goto -> 208
    //   199: astore_3
    //   200: aload_3
    //   201: ldc 'ht'
    //   203: ldc 'ne'
    //   205: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_0
    //   209: new com/loc/at$b
    //   212: dup
    //   213: iconst_0
    //   214: invokespecial <init> : (B)V
    //   217: putfield j : Lcom/loc/at$b;
    //   220: return
    //   221: astore_3
    //   222: goto -> 166
    // Exception table:
    //   from	to	target	type
    //   78	98	101	finally
    //   117	132	221	finally
    //   132	147	221	finally
    //   147	163	221	finally
    //   175	182	199	finally
    //   182	196	199	finally
  }
  
  at(av paramav, boolean paramBoolean) {
    this(paramav, paramBoolean, (byte)0);
  }
  
  private at(av paramav, boolean paramBoolean, byte paramByte) {
    this(paramav.c, paramav.d, paramav.e, paramBoolean);
    if (paramav == null)
      return; 
    try {
      return;
    } finally {
      paramav = null;
      y.a((Throwable)paramav, "ht", "pnfr");
    } 
  }
  
  public static int a(av paramav) {
    try {
      byte b1;
      if (l.b())
        return 4; 
      if (paramav != null && !paramav.i())
        return 1; 
      boolean bool = l.a();
      if (!bool) {
        b1 = 1;
      } else {
        b1 = 2;
      } 
    } finally {
      paramav = null;
    } 
    return 1;
  }
  
  private au a() {
    try {
      au au1;
      if (m == null || m.get() == null)
        m = new SoftReference<au>(new au(l.c, this.d)); 
      if (k != null) {
        au1 = m.get();
      } else {
        au1 = null;
      } 
      return au2;
    } finally {
      Exception exception = null;
      ab.b(exception, "ht", "gsf");
    } 
  }
  
  private aw a(a parama) throws j, IOException {
    // Byte code:
    //   0: ldc ''
    //   2: astore #10
    //   4: aload #10
    //   6: astore #9
    //   8: invokestatic a : ()V
    //   11: aload #10
    //   13: astore #9
    //   15: invokestatic currentTimeMillis : ()J
    //   18: lstore #4
    //   20: aload #10
    //   22: astore #9
    //   24: aload_1
    //   25: getfield a : Ljava/net/HttpURLConnection;
    //   28: astore #13
    //   30: aload #10
    //   32: astore #9
    //   34: aload #13
    //   36: invokevirtual connect : ()V
    //   39: aload #10
    //   41: astore #9
    //   43: aload #13
    //   45: invokevirtual getHeaderFields : ()Ljava/util/Map;
    //   48: astore #14
    //   50: aload #10
    //   52: astore #9
    //   54: aload #13
    //   56: invokevirtual getResponseCode : ()I
    //   59: istore_3
    //   60: aload #14
    //   62: ifnull -> 322
    //   65: aload #10
    //   67: astore #9
    //   69: aload #14
    //   71: ldc 'gsid'
    //   73: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   78: checkcast java/util/List
    //   81: astore #11
    //   83: aload #10
    //   85: astore #8
    //   87: aload #11
    //   89: ifnull -> 127
    //   92: aload #10
    //   94: astore #8
    //   96: aload #10
    //   98: astore #9
    //   100: aload #11
    //   102: invokeinterface size : ()I
    //   107: ifle -> 127
    //   110: aload #10
    //   112: astore #9
    //   114: aload #11
    //   116: iconst_0
    //   117: invokeinterface get : (I)Ljava/lang/Object;
    //   122: checkcast java/lang/String
    //   125: astore #8
    //   127: aload_0
    //   128: getfield p : Ljava/lang/String;
    //   131: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   134: ifne -> 316
    //   137: aload_0
    //   138: getfield o : Z
    //   141: ifeq -> 186
    //   144: aload #14
    //   146: ldc_w 'sc'
    //   149: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   154: ifeq -> 171
    //   157: aload_0
    //   158: aload #14
    //   160: iconst_0
    //   161: invokespecial a : (Ljava/util/Map;Z)Z
    //   164: istore #6
    //   166: iconst_1
    //   167: istore_2
    //   168: goto -> 197
    //   171: aload_0
    //   172: getfield p : Ljava/lang/String;
    //   175: invokestatic b : (Ljava/lang/String;)V
    //   178: iconst_0
    //   179: istore #6
    //   181: iconst_0
    //   182: istore_2
    //   183: goto -> 197
    //   186: aload_0
    //   187: aload #14
    //   189: iconst_1
    //   190: invokespecial a : (Ljava/util/Map;Z)Z
    //   193: istore #6
    //   195: iconst_2
    //   196: istore_2
    //   197: iload #6
    //   199: ifeq -> 293
    //   202: aload_0
    //   203: getfield p : Ljava/lang/String;
    //   206: astore #9
    //   208: aload #9
    //   210: ldc_w 'loc'
    //   213: invokevirtual equals : (Ljava/lang/Object;)Z
    //   216: ifeq -> 266
    //   219: aload_0
    //   220: getfield p : Ljava/lang/String;
    //   223: astore #9
    //   225: iload_2
    //   226: iconst_2
    //   227: if_icmpne -> 1076
    //   230: iconst_1
    //   231: istore #7
    //   233: goto -> 236
    //   236: aload #9
    //   238: iload #7
    //   240: aload #13
    //   242: invokevirtual getURL : ()Ljava/net/URL;
    //   245: invokevirtual getHost : ()Ljava/lang/String;
    //   248: aload #13
    //   250: invokevirtual getURL : ()Ljava/net/URL;
    //   253: invokevirtual getHost : ()Ljava/lang/String;
    //   256: aload_0
    //   257: getfield n : Ljava/lang/String;
    //   260: invokestatic a : (Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -> 1088
    //   266: aload_0
    //   267: getfield p : Ljava/lang/String;
    //   270: astore #9
    //   272: iload_2
    //   273: iconst_2
    //   274: if_icmpne -> 1082
    //   277: iconst_1
    //   278: istore #7
    //   280: goto -> 283
    //   283: aload #9
    //   285: iload #7
    //   287: invokestatic b : (Ljava/lang/String;Z)V
    //   290: goto -> 1088
    //   293: iload_2
    //   294: iconst_1
    //   295: if_icmpne -> 313
    //   298: aload_0
    //   299: getfield p : Ljava/lang/String;
    //   302: astore #9
    //   304: iconst_0
    //   305: aload #9
    //   307: invokestatic a : (ZLjava/lang/String;)V
    //   310: goto -> 319
    //   313: goto -> 319
    //   316: iconst_0
    //   317: istore #6
    //   319: goto -> 329
    //   322: iconst_0
    //   323: istore #6
    //   325: aload #10
    //   327: astore #8
    //   329: iload_3
    //   330: sipush #200
    //   333: if_icmpne -> 719
    //   336: aload #8
    //   338: astore #9
    //   340: aload_1
    //   341: iconst_0
    //   342: lload #4
    //   344: invokestatic currentTimeMillis : ()J
    //   347: invokestatic a : (Lcom/loc/at$a;ZJJ)V
    //   350: aload #8
    //   352: astore #9
    //   354: new java/io/ByteArrayOutputStream
    //   357: dup
    //   358: invokespecial <init> : ()V
    //   361: astore_1
    //   362: aload #13
    //   364: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   367: astore #11
    //   369: aload #11
    //   371: astore #10
    //   373: new java/io/PushbackInputStream
    //   376: dup
    //   377: aload #10
    //   379: iconst_2
    //   380: invokespecial <init> : (Ljava/io/InputStream;I)V
    //   383: astore #9
    //   385: iconst_2
    //   386: newarray byte
    //   388: astore #12
    //   390: aload #9
    //   392: aload #12
    //   394: invokevirtual read : ([B)I
    //   397: pop
    //   398: aload #9
    //   400: aload #12
    //   402: invokevirtual unread : ([B)V
    //   405: aload #12
    //   407: iconst_0
    //   408: baload
    //   409: bipush #31
    //   411: if_icmpne -> 441
    //   414: aload #12
    //   416: iconst_1
    //   417: baload
    //   418: bipush #-117
    //   420: if_icmpne -> 441
    //   423: new java/util/zip/GZIPInputStream
    //   426: dup
    //   427: aload #9
    //   429: invokespecial <init> : (Ljava/io/InputStream;)V
    //   432: astore #12
    //   434: aload #12
    //   436: astore #11
    //   438: goto -> 445
    //   441: aload #9
    //   443: astore #11
    //   445: sipush #1024
    //   448: newarray byte
    //   450: astore #12
    //   452: aload #11
    //   454: aload #12
    //   456: invokevirtual read : ([B)I
    //   459: istore_2
    //   460: iload_2
    //   461: iconst_m1
    //   462: if_icmpeq -> 476
    //   465: aload_1
    //   466: aload #12
    //   468: iconst_0
    //   469: iload_2
    //   470: invokevirtual write : ([BII)V
    //   473: goto -> 452
    //   476: invokestatic c : ()V
    //   479: new com/loc/aw
    //   482: dup
    //   483: invokespecial <init> : ()V
    //   486: astore #12
    //   488: aload #12
    //   490: aload_1
    //   491: invokevirtual toByteArray : ()[B
    //   494: putfield a : [B
    //   497: aload #12
    //   499: aload #14
    //   501: putfield b : Ljava/util/Map;
    //   504: aload #12
    //   506: aload_0
    //   507: getfield i : Ljava/lang/String;
    //   510: putfield c : Ljava/lang/String;
    //   513: aload #12
    //   515: aload #8
    //   517: putfield d : Ljava/lang/String;
    //   520: aload #12
    //   522: iload #6
    //   524: putfield e : Z
    //   527: aload #13
    //   529: invokevirtual getURL : ()Ljava/net/URL;
    //   532: aload #12
    //   534: invokestatic a : (Ljava/net/URL;Lcom/loc/aw;)V
    //   537: aload_1
    //   538: invokevirtual close : ()V
    //   541: goto -> 554
    //   544: astore_1
    //   545: aload_1
    //   546: ldc 'ht'
    //   548: ldc_w 'par'
    //   551: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   554: aload #10
    //   556: ifnull -> 577
    //   559: aload #10
    //   561: invokevirtual close : ()V
    //   564: goto -> 577
    //   567: astore_1
    //   568: aload_1
    //   569: ldc 'ht'
    //   571: ldc_w 'par'
    //   574: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload #9
    //   579: invokevirtual close : ()V
    //   582: goto -> 595
    //   585: astore_1
    //   586: aload_1
    //   587: ldc 'ht'
    //   589: ldc_w 'par'
    //   592: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload #11
    //   597: invokevirtual close : ()V
    //   600: aload #12
    //   602: areturn
    //   603: astore_1
    //   604: aload_1
    //   605: ldc 'ht'
    //   607: ldc_w 'par'
    //   610: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   613: aload #12
    //   615: areturn
    //   616: astore #12
    //   618: aload_1
    //   619: astore #8
    //   621: aload #12
    //   623: astore_1
    //   624: goto -> 959
    //   627: astore #12
    //   629: aload #10
    //   631: astore #13
    //   633: aload #12
    //   635: astore #10
    //   637: aload #8
    //   639: astore #12
    //   641: aload #13
    //   643: astore #8
    //   645: goto -> 888
    //   648: astore #8
    //   650: goto -> 694
    //   653: astore #10
    //   655: goto -> 668
    //   658: astore #8
    //   660: goto -> 691
    //   663: astore #10
    //   665: aconst_null
    //   666: astore #9
    //   668: aload #11
    //   670: astore #13
    //   672: aconst_null
    //   673: astore #11
    //   675: aload #8
    //   677: astore #12
    //   679: aload #13
    //   681: astore #8
    //   683: goto -> 888
    //   686: astore #8
    //   688: aconst_null
    //   689: astore #10
    //   691: aconst_null
    //   692: astore #9
    //   694: aload_1
    //   695: astore #12
    //   697: aconst_null
    //   698: astore #11
    //   700: aload #8
    //   702: astore_1
    //   703: aload #12
    //   705: astore #8
    //   707: goto -> 959
    //   710: astore #10
    //   712: aload #8
    //   714: astore #12
    //   716: goto -> 879
    //   719: aload #8
    //   721: astore #9
    //   723: new java/lang/StringBuilder
    //   726: dup
    //   727: ldc_w '网络异常原因：'
    //   730: invokespecial <init> : (Ljava/lang/String;)V
    //   733: astore_1
    //   734: aload #8
    //   736: astore #9
    //   738: aload_1
    //   739: aload #13
    //   741: invokevirtual getResponseMessage : ()Ljava/lang/String;
    //   744: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload #8
    //   750: astore #9
    //   752: aload_1
    //   753: ldc_w ' 网络异常状态码：'
    //   756: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload #8
    //   762: astore #9
    //   764: aload_1
    //   765: iload_3
    //   766: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload #8
    //   772: astore #9
    //   774: aload_1
    //   775: ldc_w '  '
    //   778: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload #8
    //   784: astore #9
    //   786: aload_1
    //   787: aload #8
    //   789: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload #8
    //   795: astore #9
    //   797: aload_1
    //   798: ldc_w ' '
    //   801: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload #8
    //   807: astore #9
    //   809: aload_1
    //   810: aload_0
    //   811: getfield i : Ljava/lang/String;
    //   814: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload #8
    //   820: astore #9
    //   822: new com/loc/j
    //   825: dup
    //   826: aload_1
    //   827: invokevirtual toString : ()Ljava/lang/String;
    //   830: aload #8
    //   832: aload_0
    //   833: getfield i : Ljava/lang/String;
    //   836: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   839: astore_1
    //   840: aload #8
    //   842: astore #9
    //   844: aload_1
    //   845: iload_3
    //   846: invokevirtual a : (I)V
    //   849: aload #8
    //   851: astore #9
    //   853: aload_1
    //   854: athrow
    //   855: astore_1
    //   856: aconst_null
    //   857: astore #10
    //   859: aconst_null
    //   860: astore #9
    //   862: aconst_null
    //   863: astore #11
    //   865: aconst_null
    //   866: astore #8
    //   868: goto -> 959
    //   871: astore #10
    //   873: aconst_null
    //   874: astore_1
    //   875: aload #9
    //   877: astore #12
    //   879: aconst_null
    //   880: astore #9
    //   882: aconst_null
    //   883: astore #11
    //   885: aconst_null
    //   886: astore #8
    //   888: new com/loc/j
    //   891: dup
    //   892: ldc_w 'IO 操作异常 - IOException'
    //   895: aload #12
    //   897: aload_0
    //   898: getfield i : Ljava/lang/String;
    //   901: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   904: astore #12
    //   906: aload #10
    //   908: instanceof java/io/InterruptedIOException
    //   911: ifeq -> 944
    //   914: aload #10
    //   916: invokevirtual getMessage : ()Ljava/lang/String;
    //   919: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   922: ifne -> 944
    //   925: aload #10
    //   927: invokevirtual getMessage : ()Ljava/lang/String;
    //   930: ldc_w 'thread interrupted'
    //   933: invokevirtual equals : (Ljava/lang/Object;)Z
    //   936: ifeq -> 944
    //   939: aload #12
    //   941: invokevirtual h : ()V
    //   944: aload #12
    //   946: athrow
    //   947: astore #12
    //   949: aload #8
    //   951: astore #10
    //   953: aload_1
    //   954: astore #8
    //   956: aload #12
    //   958: astore_1
    //   959: aload #8
    //   961: ifnull -> 984
    //   964: aload #8
    //   966: invokevirtual close : ()V
    //   969: goto -> 984
    //   972: astore #8
    //   974: aload #8
    //   976: ldc 'ht'
    //   978: ldc_w 'par'
    //   981: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   984: aload #10
    //   986: ifnull -> 1009
    //   989: aload #10
    //   991: invokevirtual close : ()V
    //   994: goto -> 1009
    //   997: astore #8
    //   999: aload #8
    //   1001: ldc 'ht'
    //   1003: ldc_w 'par'
    //   1006: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1009: aload #9
    //   1011: ifnull -> 1034
    //   1014: aload #9
    //   1016: invokevirtual close : ()V
    //   1019: goto -> 1034
    //   1022: astore #8
    //   1024: aload #8
    //   1026: ldc 'ht'
    //   1028: ldc_w 'par'
    //   1031: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1034: aload #11
    //   1036: ifnull -> 1059
    //   1039: aload #11
    //   1041: invokevirtual close : ()V
    //   1044: goto -> 1059
    //   1047: astore #8
    //   1049: aload #8
    //   1051: ldc 'ht'
    //   1053: ldc_w 'par'
    //   1056: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1059: aload_1
    //   1060: athrow
    //   1061: astore #9
    //   1063: goto -> 316
    //   1066: astore #9
    //   1068: goto -> 319
    //   1071: astore #9
    //   1073: goto -> 313
    //   1076: iconst_0
    //   1077: istore #7
    //   1079: goto -> 236
    //   1082: iconst_0
    //   1083: istore #7
    //   1085: goto -> 283
    //   1088: goto -> 329
    // Exception table:
    //   from	to	target	type
    //   8	11	871	java/io/IOException
    //   8	11	855	finally
    //   15	20	871	java/io/IOException
    //   15	20	855	finally
    //   24	30	871	java/io/IOException
    //   24	30	855	finally
    //   34	39	871	java/io/IOException
    //   34	39	855	finally
    //   43	50	871	java/io/IOException
    //   43	50	855	finally
    //   54	60	871	java/io/IOException
    //   54	60	855	finally
    //   69	83	871	java/io/IOException
    //   69	83	855	finally
    //   100	110	871	java/io/IOException
    //   100	110	855	finally
    //   114	127	871	java/io/IOException
    //   114	127	855	finally
    //   127	166	1061	finally
    //   171	178	1061	finally
    //   186	195	1061	finally
    //   202	208	1066	finally
    //   208	225	1071	finally
    //   236	263	1071	finally
    //   266	272	1071	finally
    //   283	290	1071	finally
    //   298	304	1071	finally
    //   304	310	1066	finally
    //   340	350	871	java/io/IOException
    //   340	350	855	finally
    //   354	362	871	java/io/IOException
    //   354	362	855	finally
    //   362	369	710	java/io/IOException
    //   362	369	686	finally
    //   373	385	663	java/io/IOException
    //   373	385	658	finally
    //   385	405	653	java/io/IOException
    //   385	405	648	finally
    //   423	434	653	java/io/IOException
    //   423	434	648	finally
    //   445	452	627	java/io/IOException
    //   445	452	616	finally
    //   452	460	627	java/io/IOException
    //   452	460	616	finally
    //   465	473	627	java/io/IOException
    //   465	473	616	finally
    //   476	537	627	java/io/IOException
    //   476	537	616	finally
    //   537	541	544	finally
    //   559	564	567	finally
    //   577	582	585	finally
    //   595	600	603	finally
    //   723	734	871	java/io/IOException
    //   723	734	855	finally
    //   738	748	871	java/io/IOException
    //   738	748	855	finally
    //   752	760	871	java/io/IOException
    //   752	760	855	finally
    //   764	770	871	java/io/IOException
    //   764	770	855	finally
    //   774	782	871	java/io/IOException
    //   774	782	855	finally
    //   786	793	871	java/io/IOException
    //   786	793	855	finally
    //   797	805	871	java/io/IOException
    //   797	805	855	finally
    //   809	818	871	java/io/IOException
    //   809	818	855	finally
    //   822	840	871	java/io/IOException
    //   822	840	855	finally
    //   844	849	871	java/io/IOException
    //   844	849	855	finally
    //   853	855	871	java/io/IOException
    //   853	855	855	finally
    //   888	944	947	finally
    //   944	947	947	finally
    //   964	969	972	finally
    //   989	994	997	finally
    //   1014	1019	1022	finally
    //   1039	1044	1047	finally
  }
  
  private static String a(String paramString) {
    // Byte code:
    //   0: ldc ''
    //   2: astore #5
    //   4: aload #5
    //   6: astore_3
    //   7: aload #5
    //   9: astore #4
    //   11: aload_0
    //   12: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   15: ifne -> 245
    //   18: aload #5
    //   20: astore_3
    //   21: aload_0
    //   22: ldc_w '&'
    //   25: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   28: astore #6
    //   30: aload #5
    //   32: astore_3
    //   33: aload #5
    //   35: astore #4
    //   37: aload #6
    //   39: arraylength
    //   40: iconst_1
    //   41: if_icmple -> 245
    //   44: aload #5
    //   46: astore_3
    //   47: aload #6
    //   49: arraylength
    //   50: istore_2
    //   51: iconst_0
    //   52: istore_1
    //   53: ldc ''
    //   55: astore_0
    //   56: iload_1
    //   57: iload_2
    //   58: if_icmpge -> 255
    //   61: aload #6
    //   63: iload_1
    //   64: aaload
    //   65: astore #4
    //   67: aload #5
    //   69: astore_3
    //   70: aload #4
    //   72: ldc_w 'sdkversion'
    //   75: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   78: ifeq -> 84
    //   81: aload #4
    //   83: astore_0
    //   84: aload #5
    //   86: astore_3
    //   87: aload #4
    //   89: ldc_w 'product'
    //   92: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   95: ifeq -> 248
    //   98: aload #4
    //   100: astore #6
    //   102: goto -> 105
    //   105: aload #5
    //   107: astore_3
    //   108: aload #5
    //   110: astore #4
    //   112: aload #6
    //   114: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   117: ifne -> 245
    //   120: aload #5
    //   122: astore_3
    //   123: aload #6
    //   125: ldc_w '='
    //   128: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   131: astore #6
    //   133: aload #5
    //   135: astore_3
    //   136: aload #5
    //   138: astore #4
    //   140: aload #6
    //   142: arraylength
    //   143: iconst_1
    //   144: if_icmple -> 245
    //   147: aload #5
    //   149: astore_3
    //   150: aload #6
    //   152: iconst_1
    //   153: aaload
    //   154: invokevirtual trim : ()Ljava/lang/String;
    //   157: astore #5
    //   159: aload #5
    //   161: astore_3
    //   162: aload #5
    //   164: astore #4
    //   166: aload_0
    //   167: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   170: ifne -> 245
    //   173: aload #5
    //   175: astore_3
    //   176: aload #5
    //   178: astore #4
    //   180: aload #5
    //   182: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   185: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   188: ifeq -> 245
    //   191: aload #5
    //   193: astore_3
    //   194: aload_0
    //   195: ldc_w '='
    //   198: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   201: astore_0
    //   202: aload #5
    //   204: astore_3
    //   205: aload #5
    //   207: astore #4
    //   209: aload_0
    //   210: arraylength
    //   211: iconst_1
    //   212: if_icmple -> 245
    //   215: aload #5
    //   217: astore_3
    //   218: aload #5
    //   220: aload_0
    //   221: iconst_1
    //   222: aaload
    //   223: invokevirtual trim : ()Ljava/lang/String;
    //   226: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload #5
    //   231: areturn
    //   232: astore_0
    //   233: aload_0
    //   234: ldc 'ht'
    //   236: ldc_w 'pnfp'
    //   239: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_3
    //   243: astore #4
    //   245: aload #4
    //   247: areturn
    //   248: iload_1
    //   249: iconst_1
    //   250: iadd
    //   251: istore_1
    //   252: goto -> 56
    //   255: ldc ''
    //   257: astore #6
    //   259: goto -> 105
    // Exception table:
    //   from	to	target	type
    //   11	18	232	finally
    //   21	30	232	finally
    //   37	44	232	finally
    //   47	51	232	finally
    //   70	81	232	finally
    //   87	98	232	finally
    //   112	120	232	finally
    //   123	133	232	finally
    //   140	147	232	finally
    //   150	159	232	finally
    //   166	173	232	finally
    //   180	191	232	finally
    //   194	202	232	finally
    //   209	215	232	finally
    //   218	229	232	finally
  }
  
  private static String a(String paramString1, String paramString2, int paramInt) {
    if (paramInt == 2 || paramInt == 4) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (paramInt != 0)
      try {
        return !bool ? paramString2 : paramString1;
      } finally {
        paramString2 = null;
      }  
    return paramString1;
  }
  
  static String a(Map<String, String> paramMap) {
    if (paramMap != null) {
      StringBuilder stringBuilder = new StringBuilder();
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        String str3 = (String)entry.getKey();
        String str2 = (String)entry.getValue();
        String str1 = str2;
        if (str2 == null)
          str1 = ""; 
        if (stringBuilder.length() > 0)
          stringBuilder.append("&"); 
        stringBuilder.append(URLEncoder.encode(str3));
        stringBuilder.append("=");
        stringBuilder.append(URLEncoder.encode(str1));
      } 
      return stringBuilder.toString();
    } 
    return null;
  }
  
  private static void a(a parama, boolean paramBoolean, long paramLong1, long paramLong2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #8
    //   3: aload_0
    //   4: getfield a : Ljava/net/HttpURLConnection;
    //   7: invokevirtual getURL : ()Ljava/net/URL;
    //   10: invokevirtual toString : ()Ljava/lang/String;
    //   13: astore #9
    //   15: aload_0
    //   16: getfield b : I
    //   19: istore #6
    //   21: iload #6
    //   23: iconst_3
    //   24: if_icmpne -> 33
    //   27: iconst_1
    //   28: istore #7
    //   30: goto -> 36
    //   33: iconst_0
    //   34: istore #7
    //   36: aload_0
    //   37: getfield b : I
    //   40: iconst_2
    //   41: if_icmpeq -> 56
    //   44: aload_0
    //   45: getfield b : I
    //   48: istore #6
    //   50: iload #6
    //   52: iconst_4
    //   53: if_icmpne -> 59
    //   56: iconst_1
    //   57: istore #8
    //   59: goto -> 71
    //   62: aconst_null
    //   63: astore #9
    //   65: iconst_0
    //   66: istore #7
    //   68: iconst_0
    //   69: istore #8
    //   71: aload #9
    //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   76: ifeq -> 80
    //   79: return
    //   80: aload #9
    //   82: iload #8
    //   84: iload #7
    //   86: iload_1
    //   87: lconst_0
    //   88: lload #4
    //   90: lload_2
    //   91: lsub
    //   92: invokestatic max : (JJ)J
    //   95: invokestatic a : (Ljava/lang/String;ZZZJ)V
    //   98: return
    //   99: astore_0
    //   100: goto -> 62
    //   103: astore_0
    //   104: goto -> 65
    //   107: astore_0
    //   108: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   3	15	99	finally
    //   15	21	103	finally
    //   36	50	107	finally
  }
  
  private void a(Map<String, String> paramMap, HttpURLConnection paramHttpURLConnection) {
    if (paramMap != null)
      for (String str : paramMap.keySet())
        paramHttpURLConnection.addRequestProperty(str, paramMap.get(str));  
    try {
      paramHttpURLConnection.addRequestProperty("csid", this.i);
    } finally {
      paramMap = null;
    } 
    paramHttpURLConnection.setReadTimeout(this.b);
  }
  
  public static boolean a(int paramInt) {
    return (paramInt == 2);
  }
  
  private boolean a(Map<String, List<String>> paramMap, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #4
    //   3: aload_1
    //   4: ldc_w 'sc'
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast java/util/List
    //   15: astore #7
    //   17: aload #7
    //   19: ifnull -> 196
    //   22: aload #7
    //   24: invokeinterface size : ()I
    //   29: ifle -> 196
    //   32: aload #7
    //   34: iconst_0
    //   35: invokeinterface get : (I)Ljava/lang/Object;
    //   40: checkcast java/lang/String
    //   43: astore #7
    //   45: aload #7
    //   47: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   50: ifne -> 196
    //   53: aload #7
    //   55: ldc_w '#'
    //   58: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   61: ifne -> 67
    //   64: goto -> 191
    //   67: aload #7
    //   69: ldc_w '#'
    //   72: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   75: astore #7
    //   77: aload #7
    //   79: arraylength
    //   80: iconst_1
    //   81: if_icmple -> 196
    //   84: ldc_w '1'
    //   87: aload #7
    //   89: iconst_1
    //   90: aaload
    //   91: invokevirtual equals : (Ljava/lang/Object;)Z
    //   94: ifeq -> 196
    //   97: goto -> 191
    //   100: iload_2
    //   101: ifeq -> 184
    //   104: aload_1
    //   105: ldc_w 'lct'
    //   108: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   113: ifeq -> 181
    //   116: aload_1
    //   117: ldc_w 'lct'
    //   120: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast java/util/List
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull -> 181
    //   133: aload_1
    //   134: invokeinterface size : ()I
    //   139: ifle -> 181
    //   142: aload_1
    //   143: iconst_0
    //   144: invokeinterface get : (I)Ljava/lang/Object;
    //   149: checkcast java/lang/String
    //   152: astore_1
    //   153: aload_1
    //   154: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   157: ifne -> 181
    //   160: aload_1
    //   161: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   164: invokevirtual longValue : ()J
    //   167: lstore #5
    //   169: aload_0
    //   170: getfield p : Ljava/lang/String;
    //   173: lload #5
    //   175: invokestatic a : (Ljava/lang/String;J)Z
    //   178: istore_2
    //   179: iload_2
    //   180: ireturn
    //   181: iconst_0
    //   182: istore #4
    //   184: iload #4
    //   186: ireturn
    //   187: astore_1
    //   188: goto -> 181
    //   191: iconst_1
    //   192: istore_3
    //   193: goto -> 198
    //   196: iconst_0
    //   197: istore_3
    //   198: iload_3
    //   199: ifne -> 100
    //   202: iconst_0
    //   203: ireturn
    // Exception table:
    //   from	to	target	type
    //   3	17	187	finally
    //   22	64	187	finally
    //   67	97	187	finally
    //   104	129	187	finally
    //   133	179	187	finally
  }
  
  private static String b(Map<String, String> paramMap) {
    String str = null;
    if (paramMap == null)
      return null; 
    try {
      return str;
    } finally {
      paramMap = null;
      y.a((Throwable)paramMap, "ht", "pnfh");
    } 
  }
  
  final aw a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, Map<String, String> paramMap, byte[] paramArrayOfbyte, int paramInt) throws j {
    // Byte code:
    //   0: aconst_null
    //   1: astore #27
    //   3: aconst_null
    //   4: astore #18
    //   6: aconst_null
    //   7: astore #17
    //   9: aconst_null
    //   10: astore #12
    //   12: aconst_null
    //   13: astore #13
    //   15: aconst_null
    //   16: astore #14
    //   18: aconst_null
    //   19: astore #15
    //   21: aconst_null
    //   22: astore #11
    //   24: aconst_null
    //   25: astore #19
    //   27: aconst_null
    //   28: astore #20
    //   30: aconst_null
    //   31: astore #21
    //   33: aconst_null
    //   34: astore #22
    //   36: aconst_null
    //   37: astore #23
    //   39: aconst_null
    //   40: astore #24
    //   42: aconst_null
    //   43: astore #25
    //   45: aconst_null
    //   46: astore #26
    //   48: aconst_null
    //   49: astore #16
    //   51: aconst_null
    //   52: astore #28
    //   54: iconst_1
    //   55: istore #9
    //   57: aload_1
    //   58: aload_2
    //   59: aload_0
    //   60: getfield p : Ljava/lang/String;
    //   63: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/loc/aw;
    //   66: astore #10
    //   68: aload #10
    //   70: ifnull -> 76
    //   73: aload #10
    //   75: areturn
    //   76: aload_1
    //   77: aload_2
    //   78: iload #7
    //   80: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   83: aload_0
    //   84: getfield p : Ljava/lang/String;
    //   87: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   90: astore #29
    //   92: iload #7
    //   94: iconst_2
    //   95: if_icmpeq -> 124
    //   98: iload #7
    //   100: iconst_3
    //   101: if_icmpeq -> 107
    //   104: goto -> 163
    //   107: aload_0
    //   108: sipush #5000
    //   111: putfield a : I
    //   114: aload_0
    //   115: sipush #5000
    //   118: putfield b : I
    //   121: goto -> 163
    //   124: aload_0
    //   125: aload_0
    //   126: getfield a : I
    //   129: sipush #5000
    //   132: isub
    //   133: sipush #5000
    //   136: invokestatic max : (II)I
    //   139: putfield a : I
    //   142: aload_0
    //   143: aload_0
    //   144: getfield b : I
    //   147: sipush #5000
    //   150: isub
    //   151: sipush #5000
    //   154: invokestatic max : (II)I
    //   157: putfield b : I
    //   160: goto -> 163
    //   163: aload #5
    //   165: astore #10
    //   167: aload #5
    //   169: ifnonnull -> 181
    //   172: new java/util/HashMap
    //   175: dup
    //   176: invokespecial <init> : ()V
    //   179: astore #10
    //   181: aload_0
    //   182: getfield j : Lcom/loc/at$b;
    //   185: invokevirtual a : ()Lcom/loc/at$c;
    //   188: astore_1
    //   189: aload_0
    //   190: aload #4
    //   192: putfield n : Ljava/lang/String;
    //   195: aload_1
    //   196: astore #5
    //   198: iload_3
    //   199: ifeq -> 224
    //   202: aload_1
    //   203: astore #5
    //   205: aload #4
    //   207: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   210: ifne -> 224
    //   213: aload_0
    //   214: getfield j : Lcom/loc/at$b;
    //   217: aload #4
    //   219: invokevirtual a : (Ljava/lang/String;)Lcom/loc/at$c;
    //   222: astore #5
    //   224: aload #29
    //   226: ldc_w '/v3/iasdkauth'
    //   229: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   232: ifne -> 281
    //   235: aload_0
    //   236: getfield p : Ljava/lang/String;
    //   239: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   242: ifne -> 281
    //   245: aload_0
    //   246: getfield p : Ljava/lang/String;
    //   249: invokestatic a : (Ljava/lang/String;)Z
    //   252: ifeq -> 281
    //   255: aload_0
    //   256: iconst_1
    //   257: putfield o : Z
    //   260: aload #10
    //   262: ldc_w 'lct'
    //   265: aload_0
    //   266: getfield p : Ljava/lang/String;
    //   269: invokestatic c : (Ljava/lang/String;)J
    //   272: invokestatic valueOf : (J)Ljava/lang/String;
    //   275: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: getstatic com/loc/aq.a : I
    //   284: istore #8
    //   286: ldc ''
    //   288: astore_2
    //   289: iload #8
    //   291: iconst_1
    //   292: if_icmpeq -> 298
    //   295: goto -> 302
    //   298: getstatic com/loc/aq.b : Ljava/lang/String;
    //   301: astore_2
    //   302: aload #29
    //   304: astore_1
    //   305: aload_2
    //   306: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   309: ifne -> 380
    //   312: aload #29
    //   314: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   317: astore #4
    //   319: aload #4
    //   321: invokevirtual getHost : ()Ljava/lang/String;
    //   324: astore_1
    //   325: aload #4
    //   327: invokevirtual buildUpon : ()Landroid/net/Uri$Builder;
    //   330: aload_2
    //   331: invokevirtual encodedAuthority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   334: invokevirtual build : ()Landroid/net/Uri;
    //   337: invokevirtual toString : ()Ljava/lang/String;
    //   340: astore #4
    //   342: aload #10
    //   344: ifnull -> 359
    //   347: aload #10
    //   349: ldc_w 'targetHost'
    //   352: aload_1
    //   353: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   358: pop
    //   359: aload #4
    //   361: astore_1
    //   362: aload_0
    //   363: getfield c : Z
    //   366: ifeq -> 380
    //   369: aload_0
    //   370: getfield j : Lcom/loc/at$b;
    //   373: aload_2
    //   374: invokevirtual b : (Ljava/lang/String;)V
    //   377: aload #4
    //   379: astore_1
    //   380: aload_1
    //   381: astore_2
    //   382: aload_0
    //   383: getfield c : Z
    //   386: ifeq -> 394
    //   389: aload_1
    //   390: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   393: astore_2
    //   394: new java/net/URL
    //   397: dup
    //   398: aload_2
    //   399: invokespecial <init> : (Ljava/lang/String;)V
    //   402: astore #4
    //   404: aload_0
    //   405: getfield l : Lcom/loc/aq$a;
    //   408: ifnull -> 1311
    //   411: aload_0
    //   412: getfield l : Lcom/loc/aq$a;
    //   415: invokeinterface a : ()Ljava/net/URLConnection;
    //   420: astore_1
    //   421: goto -> 424
    //   424: aload_1
    //   425: astore_2
    //   426: aload_1
    //   427: ifnonnull -> 456
    //   430: aload_0
    //   431: getfield e : Ljava/net/Proxy;
    //   434: ifnull -> 450
    //   437: aload #4
    //   439: aload_0
    //   440: getfield e : Ljava/net/Proxy;
    //   443: invokevirtual openConnection : (Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   446: astore_2
    //   447: goto -> 456
    //   450: aload #4
    //   452: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   455: astore_2
    //   456: aload_0
    //   457: getfield c : Z
    //   460: ifeq -> 555
    //   463: aload_2
    //   464: checkcast javax/net/ssl/HttpsURLConnection
    //   467: astore #4
    //   469: getstatic com/loc/l$f.a : Z
    //   472: ifeq -> 522
    //   475: aload_0
    //   476: invokespecial a : ()Lcom/loc/au;
    //   479: astore_1
    //   480: aload_1
    //   481: ifnull -> 500
    //   484: aload #4
    //   486: checkcast javax/net/ssl/HttpsURLConnection
    //   489: aload_1
    //   490: invokevirtual setSSLSocketFactory : (Ljavax/net/ssl/SSLSocketFactory;)V
    //   493: aload_1
    //   494: invokevirtual a : ()V
    //   497: goto -> 539
    //   500: aload #4
    //   502: checkcast javax/net/ssl/HttpsURLConnection
    //   505: astore_1
    //   506: aload_0
    //   507: getfield d : Ljavax/net/ssl/SSLContext;
    //   510: invokevirtual getSocketFactory : ()Ljavax/net/ssl/SSLSocketFactory;
    //   513: astore_2
    //   514: aload_1
    //   515: aload_2
    //   516: invokevirtual setSSLSocketFactory : (Ljavax/net/ssl/SSLSocketFactory;)V
    //   519: goto -> 539
    //   522: aload #4
    //   524: checkcast javax/net/ssl/HttpsURLConnection
    //   527: astore_1
    //   528: aload_0
    //   529: getfield d : Ljavax/net/ssl/SSLContext;
    //   532: invokevirtual getSocketFactory : ()Ljavax/net/ssl/SSLSocketFactory;
    //   535: astore_2
    //   536: goto -> 514
    //   539: aload #4
    //   541: checkcast javax/net/ssl/HttpsURLConnection
    //   544: aload #5
    //   546: invokevirtual setHostnameVerifier : (Ljavax/net/ssl/HostnameVerifier;)V
    //   549: aload #4
    //   551: astore_1
    //   552: goto -> 560
    //   555: aload_2
    //   556: checkcast java/net/HttpURLConnection
    //   559: astore_1
    //   560: getstatic android/os/Build$VERSION.SDK : Ljava/lang/String;
    //   563: ifnull -> 584
    //   566: getstatic android/os/Build$VERSION.SDK_INT : I
    //   569: bipush #13
    //   571: if_icmple -> 584
    //   574: aload_1
    //   575: ldc_w 'Connection'
    //   578: ldc_w 'close'
    //   581: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   584: aload_0
    //   585: aload #10
    //   587: aload_1
    //   588: invokespecial a : (Ljava/util/Map;Ljava/net/HttpURLConnection;)V
    //   591: aload_1
    //   592: ldc_w 'POST'
    //   595: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   598: aload_1
    //   599: iconst_0
    //   600: invokevirtual setUseCaches : (Z)V
    //   603: aload_1
    //   604: iconst_1
    //   605: invokevirtual setDoInput : (Z)V
    //   608: aload_1
    //   609: iconst_1
    //   610: invokevirtual setDoOutput : (Z)V
    //   613: new com/loc/at$a
    //   616: dup
    //   617: aload_1
    //   618: iload #7
    //   620: invokespecial <init> : (Ljava/net/HttpURLConnection;I)V
    //   623: astore_1
    //   624: aload #28
    //   626: astore #4
    //   628: aload #27
    //   630: astore #5
    //   632: aload #18
    //   634: astore #10
    //   636: aload #17
    //   638: astore #11
    //   640: aload_1
    //   641: getfield a : Ljava/net/HttpURLConnection;
    //   644: astore_2
    //   645: aload #6
    //   647: ifnull -> 789
    //   650: aload_2
    //   651: astore #4
    //   653: aload_2
    //   654: astore #5
    //   656: aload_2
    //   657: astore #10
    //   659: aload_2
    //   660: astore #11
    //   662: aload_2
    //   663: astore #12
    //   665: aload_2
    //   666: astore #13
    //   668: aload_2
    //   669: astore #14
    //   671: aload_2
    //   672: astore #15
    //   674: aload_2
    //   675: astore #16
    //   677: aload #6
    //   679: arraylength
    //   680: ifle -> 789
    //   683: aload_2
    //   684: astore #4
    //   686: aload_2
    //   687: astore #5
    //   689: aload_2
    //   690: astore #10
    //   692: aload_2
    //   693: astore #11
    //   695: aload_2
    //   696: astore #12
    //   698: aload_2
    //   699: astore #13
    //   701: aload_2
    //   702: astore #14
    //   704: aload_2
    //   705: astore #15
    //   707: aload_2
    //   708: astore #16
    //   710: new java/io/DataOutputStream
    //   713: dup
    //   714: aload_2
    //   715: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   718: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   721: astore #17
    //   723: aload_2
    //   724: astore #4
    //   726: aload_2
    //   727: astore #5
    //   729: aload_2
    //   730: astore #10
    //   732: aload_2
    //   733: astore #11
    //   735: aload_2
    //   736: astore #12
    //   738: aload_2
    //   739: astore #13
    //   741: aload_2
    //   742: astore #14
    //   744: aload_2
    //   745: astore #15
    //   747: aload_2
    //   748: astore #16
    //   750: aload #17
    //   752: aload #6
    //   754: invokevirtual write : ([B)V
    //   757: aload_2
    //   758: astore #4
    //   760: aload_2
    //   761: astore #5
    //   763: aload_2
    //   764: astore #10
    //   766: aload_2
    //   767: astore #11
    //   769: aload_2
    //   770: astore #12
    //   772: aload_2
    //   773: astore #13
    //   775: aload_2
    //   776: astore #14
    //   778: aload_2
    //   779: astore #15
    //   781: aload_2
    //   782: astore #16
    //   784: aload #17
    //   786: invokevirtual close : ()V
    //   789: aload_2
    //   790: astore #4
    //   792: aload_2
    //   793: astore #5
    //   795: aload_2
    //   796: astore #10
    //   798: aload_2
    //   799: astore #11
    //   801: aload_2
    //   802: astore #12
    //   804: aload_2
    //   805: astore #13
    //   807: aload_2
    //   808: astore #14
    //   810: aload_2
    //   811: astore #15
    //   813: aload_2
    //   814: astore #16
    //   816: aload_0
    //   817: aload_1
    //   818: invokespecial a : (Lcom/loc/at$a;)Lcom/loc/aw;
    //   821: astore #6
    //   823: aload_2
    //   824: ifnull -> 844
    //   827: aload_2
    //   828: invokevirtual disconnect : ()V
    //   831: aload #6
    //   833: areturn
    //   834: astore_1
    //   835: aload_1
    //   836: ldc 'ht'
    //   838: ldc_w 'mPt'
    //   841: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   844: aload #6
    //   846: areturn
    //   847: astore #6
    //   849: aload_1
    //   850: astore #5
    //   852: goto -> 920
    //   855: astore #6
    //   857: aload_1
    //   858: astore #4
    //   860: goto -> 961
    //   863: astore #5
    //   865: aload_1
    //   866: astore #4
    //   868: goto -> 1013
    //   871: astore #5
    //   873: aload_1
    //   874: astore #4
    //   876: goto -> 1067
    //   879: astore #5
    //   881: aload_1
    //   882: astore #4
    //   884: goto -> 1103
    //   887: astore #5
    //   889: aload_1
    //   890: astore #4
    //   892: goto -> 1139
    //   895: astore #5
    //   897: aload_1
    //   898: astore #4
    //   900: goto -> 1175
    //   903: astore #5
    //   905: aload_1
    //   906: astore #4
    //   908: goto -> 1211
    //   911: astore #6
    //   913: aconst_null
    //   914: astore #5
    //   916: aload #11
    //   918: astore #4
    //   920: aload #4
    //   922: astore_1
    //   923: iload #9
    //   925: istore #8
    //   927: aload #5
    //   929: astore_2
    //   930: aload #6
    //   932: ldc 'ht'
    //   934: ldc_w 'mPt'
    //   937: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   940: aload #4
    //   942: astore_1
    //   943: iload #9
    //   945: istore #8
    //   947: aload #5
    //   949: astore_2
    //   950: new com/loc/j
    //   953: dup
    //   954: ldc_w '未知的错误'
    //   957: invokespecial <init> : (Ljava/lang/String;)V
    //   960: athrow
    //   961: aload #5
    //   963: astore_1
    //   964: iload #9
    //   966: istore #8
    //   968: aload #4
    //   970: astore_2
    //   971: iconst_1
    //   972: aload #6
    //   974: invokevirtual g : ()Z
    //   977: ixor
    //   978: istore #9
    //   980: aload #5
    //   982: astore_1
    //   983: iload #9
    //   985: istore #8
    //   987: aload #4
    //   989: astore_2
    //   990: aload #6
    //   992: ldc 'ht'
    //   994: ldc_w 'mPt'
    //   997: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1000: aload #5
    //   1002: astore_1
    //   1003: iload #9
    //   1005: istore #8
    //   1007: aload #4
    //   1009: astore_2
    //   1010: aload #6
    //   1012: athrow
    //   1013: aload #10
    //   1015: astore_1
    //   1016: iload #9
    //   1018: istore #8
    //   1020: aload #4
    //   1022: astore_2
    //   1023: aload #5
    //   1025: invokevirtual printStackTrace : ()V
    //   1028: aload #10
    //   1030: astore_1
    //   1031: iload #9
    //   1033: istore #8
    //   1035: aload #4
    //   1037: astore_2
    //   1038: new com/loc/j
    //   1041: dup
    //   1042: ldc_w 'IO 操作异常 - IOException'
    //   1045: invokespecial <init> : (Ljava/lang/String;)V
    //   1048: athrow
    //   1049: aload #16
    //   1051: astore_1
    //   1052: iload #9
    //   1054: istore #8
    //   1056: new com/loc/j
    //   1059: dup
    //   1060: ldc_w '未知的错误'
    //   1063: invokespecial <init> : (Ljava/lang/String;)V
    //   1066: athrow
    //   1067: aload #11
    //   1069: astore_1
    //   1070: iload #9
    //   1072: istore #8
    //   1074: aload #4
    //   1076: astore_2
    //   1077: aload #5
    //   1079: invokevirtual printStackTrace : ()V
    //   1082: aload #11
    //   1084: astore_1
    //   1085: iload #9
    //   1087: istore #8
    //   1089: aload #4
    //   1091: astore_2
    //   1092: new com/loc/j
    //   1095: dup
    //   1096: ldc_w 'socket 连接超时 - SocketTimeoutException'
    //   1099: invokespecial <init> : (Ljava/lang/String;)V
    //   1102: athrow
    //   1103: aload #12
    //   1105: astore_1
    //   1106: iload #9
    //   1108: istore #8
    //   1110: aload #4
    //   1112: astore_2
    //   1113: aload #5
    //   1115: invokevirtual printStackTrace : ()V
    //   1118: aload #12
    //   1120: astore_1
    //   1121: iload #9
    //   1123: istore #8
    //   1125: aload #4
    //   1127: astore_2
    //   1128: new com/loc/j
    //   1131: dup
    //   1132: ldc_w 'socket 连接异常 - SocketException'
    //   1135: invokespecial <init> : (Ljava/lang/String;)V
    //   1138: athrow
    //   1139: aload #13
    //   1141: astore_1
    //   1142: iload #9
    //   1144: istore #8
    //   1146: aload #4
    //   1148: astore_2
    //   1149: aload #5
    //   1151: invokevirtual printStackTrace : ()V
    //   1154: aload #13
    //   1156: astore_1
    //   1157: iload #9
    //   1159: istore #8
    //   1161: aload #4
    //   1163: astore_2
    //   1164: new com/loc/j
    //   1167: dup
    //   1168: ldc_w '未知主机 - UnKnowHostException'
    //   1171: invokespecial <init> : (Ljava/lang/String;)V
    //   1174: athrow
    //   1175: aload #14
    //   1177: astore_1
    //   1178: iload #9
    //   1180: istore #8
    //   1182: aload #4
    //   1184: astore_2
    //   1185: aload #5
    //   1187: invokevirtual printStackTrace : ()V
    //   1190: aload #14
    //   1192: astore_1
    //   1193: iload #9
    //   1195: istore #8
    //   1197: aload #4
    //   1199: astore_2
    //   1200: new com/loc/j
    //   1203: dup
    //   1204: ldc_w 'url异常 - MalformedURLException'
    //   1207: invokespecial <init> : (Ljava/lang/String;)V
    //   1210: athrow
    //   1211: aload #15
    //   1213: astore_1
    //   1214: iload #9
    //   1216: istore #8
    //   1218: aload #4
    //   1220: astore_2
    //   1221: aload #5
    //   1223: invokevirtual printStackTrace : ()V
    //   1226: aload #15
    //   1228: astore_1
    //   1229: iload #9
    //   1231: istore #8
    //   1233: aload #4
    //   1235: astore_2
    //   1236: new com/loc/j
    //   1239: dup
    //   1240: ldc_w 'http连接失败 - ConnectionException'
    //   1243: invokespecial <init> : (Ljava/lang/String;)V
    //   1246: athrow
    //   1247: astore #4
    //   1249: iload #8
    //   1251: ifeq -> 1269
    //   1254: iload #7
    //   1256: invokestatic a : (I)V
    //   1259: aload_2
    //   1260: iconst_1
    //   1261: lconst_0
    //   1262: lconst_0
    //   1263: invokestatic a : (Lcom/loc/at$a;ZJJ)V
    //   1266: goto -> 1269
    //   1269: aload_1
    //   1270: ifnull -> 1290
    //   1273: aload_1
    //   1274: invokevirtual disconnect : ()V
    //   1277: goto -> 1290
    //   1280: astore_1
    //   1281: aload_1
    //   1282: ldc 'ht'
    //   1284: ldc_w 'mPt'
    //   1287: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1290: aload #4
    //   1292: athrow
    //   1293: astore_1
    //   1294: goto -> 1340
    //   1297: astore_1
    //   1298: goto -> 163
    //   1301: astore_2
    //   1302: aload_1
    //   1303: astore_2
    //   1304: goto -> 1049
    //   1307: astore_2
    //   1308: goto -> 1269
    //   1311: aconst_null
    //   1312: astore_1
    //   1313: goto -> 424
    //   1316: astore #6
    //   1318: aconst_null
    //   1319: astore #4
    //   1321: aload #19
    //   1323: astore #5
    //   1325: goto -> 961
    //   1328: astore #5
    //   1330: aconst_null
    //   1331: astore #4
    //   1333: aload #20
    //   1335: astore #10
    //   1337: goto -> 1013
    //   1340: aconst_null
    //   1341: astore_2
    //   1342: aload #21
    //   1344: astore #16
    //   1346: goto -> 1049
    //   1349: astore #5
    //   1351: aconst_null
    //   1352: astore #4
    //   1354: aload #22
    //   1356: astore #11
    //   1358: goto -> 1067
    //   1361: astore #5
    //   1363: aconst_null
    //   1364: astore #4
    //   1366: aload #23
    //   1368: astore #12
    //   1370: goto -> 1103
    //   1373: astore #5
    //   1375: aconst_null
    //   1376: astore #4
    //   1378: aload #24
    //   1380: astore #13
    //   1382: goto -> 1139
    //   1385: astore #5
    //   1387: aconst_null
    //   1388: astore #4
    //   1390: aload #25
    //   1392: astore #14
    //   1394: goto -> 1175
    //   1397: astore #5
    //   1399: aconst_null
    //   1400: astore #4
    //   1402: aload #26
    //   1404: astore #15
    //   1406: goto -> 1211
    // Exception table:
    //   from	to	target	type
    //   57	68	1397	java/net/ConnectException
    //   57	68	1385	java/net/MalformedURLException
    //   57	68	1373	java/net/UnknownHostException
    //   57	68	1361	java/net/SocketException
    //   57	68	1349	java/net/SocketTimeoutException
    //   57	68	1293	java/io/InterruptedIOException
    //   57	68	1328	java/io/IOException
    //   57	68	1316	com/loc/j
    //   57	68	911	finally
    //   76	92	1397	java/net/ConnectException
    //   76	92	1385	java/net/MalformedURLException
    //   76	92	1373	java/net/UnknownHostException
    //   76	92	1361	java/net/SocketException
    //   76	92	1349	java/net/SocketTimeoutException
    //   76	92	1293	java/io/InterruptedIOException
    //   76	92	1328	java/io/IOException
    //   76	92	1316	com/loc/j
    //   76	92	911	finally
    //   107	121	1297	finally
    //   124	160	1297	finally
    //   172	181	1397	java/net/ConnectException
    //   172	181	1385	java/net/MalformedURLException
    //   172	181	1373	java/net/UnknownHostException
    //   172	181	1361	java/net/SocketException
    //   172	181	1349	java/net/SocketTimeoutException
    //   172	181	1293	java/io/InterruptedIOException
    //   172	181	1328	java/io/IOException
    //   172	181	1316	com/loc/j
    //   172	181	911	finally
    //   181	195	1397	java/net/ConnectException
    //   181	195	1385	java/net/MalformedURLException
    //   181	195	1373	java/net/UnknownHostException
    //   181	195	1361	java/net/SocketException
    //   181	195	1349	java/net/SocketTimeoutException
    //   181	195	1293	java/io/InterruptedIOException
    //   181	195	1328	java/io/IOException
    //   181	195	1316	com/loc/j
    //   181	195	911	finally
    //   205	224	1397	java/net/ConnectException
    //   205	224	1385	java/net/MalformedURLException
    //   205	224	1373	java/net/UnknownHostException
    //   205	224	1361	java/net/SocketException
    //   205	224	1349	java/net/SocketTimeoutException
    //   205	224	1293	java/io/InterruptedIOException
    //   205	224	1328	java/io/IOException
    //   205	224	1316	com/loc/j
    //   205	224	911	finally
    //   224	281	1397	java/net/ConnectException
    //   224	281	1385	java/net/MalformedURLException
    //   224	281	1373	java/net/UnknownHostException
    //   224	281	1361	java/net/SocketException
    //   224	281	1349	java/net/SocketTimeoutException
    //   224	281	1293	java/io/InterruptedIOException
    //   224	281	1328	java/io/IOException
    //   224	281	1316	com/loc/j
    //   224	281	911	finally
    //   281	286	1397	java/net/ConnectException
    //   281	286	1385	java/net/MalformedURLException
    //   281	286	1373	java/net/UnknownHostException
    //   281	286	1361	java/net/SocketException
    //   281	286	1349	java/net/SocketTimeoutException
    //   281	286	1293	java/io/InterruptedIOException
    //   281	286	1328	java/io/IOException
    //   281	286	1316	com/loc/j
    //   281	286	911	finally
    //   298	302	1397	java/net/ConnectException
    //   298	302	1385	java/net/MalformedURLException
    //   298	302	1373	java/net/UnknownHostException
    //   298	302	1361	java/net/SocketException
    //   298	302	1349	java/net/SocketTimeoutException
    //   298	302	1293	java/io/InterruptedIOException
    //   298	302	1328	java/io/IOException
    //   298	302	1316	com/loc/j
    //   298	302	911	finally
    //   305	342	1397	java/net/ConnectException
    //   305	342	1385	java/net/MalformedURLException
    //   305	342	1373	java/net/UnknownHostException
    //   305	342	1361	java/net/SocketException
    //   305	342	1349	java/net/SocketTimeoutException
    //   305	342	1293	java/io/InterruptedIOException
    //   305	342	1328	java/io/IOException
    //   305	342	1316	com/loc/j
    //   305	342	911	finally
    //   347	359	1397	java/net/ConnectException
    //   347	359	1385	java/net/MalformedURLException
    //   347	359	1373	java/net/UnknownHostException
    //   347	359	1361	java/net/SocketException
    //   347	359	1349	java/net/SocketTimeoutException
    //   347	359	1293	java/io/InterruptedIOException
    //   347	359	1328	java/io/IOException
    //   347	359	1316	com/loc/j
    //   347	359	911	finally
    //   362	377	1397	java/net/ConnectException
    //   362	377	1385	java/net/MalformedURLException
    //   362	377	1373	java/net/UnknownHostException
    //   362	377	1361	java/net/SocketException
    //   362	377	1349	java/net/SocketTimeoutException
    //   362	377	1293	java/io/InterruptedIOException
    //   362	377	1328	java/io/IOException
    //   362	377	1316	com/loc/j
    //   362	377	911	finally
    //   382	394	1397	java/net/ConnectException
    //   382	394	1385	java/net/MalformedURLException
    //   382	394	1373	java/net/UnknownHostException
    //   382	394	1361	java/net/SocketException
    //   382	394	1349	java/net/SocketTimeoutException
    //   382	394	1293	java/io/InterruptedIOException
    //   382	394	1328	java/io/IOException
    //   382	394	1316	com/loc/j
    //   382	394	911	finally
    //   394	421	1397	java/net/ConnectException
    //   394	421	1385	java/net/MalformedURLException
    //   394	421	1373	java/net/UnknownHostException
    //   394	421	1361	java/net/SocketException
    //   394	421	1349	java/net/SocketTimeoutException
    //   394	421	1293	java/io/InterruptedIOException
    //   394	421	1328	java/io/IOException
    //   394	421	1316	com/loc/j
    //   394	421	911	finally
    //   430	447	1397	java/net/ConnectException
    //   430	447	1385	java/net/MalformedURLException
    //   430	447	1373	java/net/UnknownHostException
    //   430	447	1361	java/net/SocketException
    //   430	447	1349	java/net/SocketTimeoutException
    //   430	447	1293	java/io/InterruptedIOException
    //   430	447	1328	java/io/IOException
    //   430	447	1316	com/loc/j
    //   430	447	911	finally
    //   450	456	1397	java/net/ConnectException
    //   450	456	1385	java/net/MalformedURLException
    //   450	456	1373	java/net/UnknownHostException
    //   450	456	1361	java/net/SocketException
    //   450	456	1349	java/net/SocketTimeoutException
    //   450	456	1293	java/io/InterruptedIOException
    //   450	456	1328	java/io/IOException
    //   450	456	1316	com/loc/j
    //   450	456	911	finally
    //   456	480	1397	java/net/ConnectException
    //   456	480	1385	java/net/MalformedURLException
    //   456	480	1373	java/net/UnknownHostException
    //   456	480	1361	java/net/SocketException
    //   456	480	1349	java/net/SocketTimeoutException
    //   456	480	1293	java/io/InterruptedIOException
    //   456	480	1328	java/io/IOException
    //   456	480	1316	com/loc/j
    //   456	480	911	finally
    //   484	497	1397	java/net/ConnectException
    //   484	497	1385	java/net/MalformedURLException
    //   484	497	1373	java/net/UnknownHostException
    //   484	497	1361	java/net/SocketException
    //   484	497	1349	java/net/SocketTimeoutException
    //   484	497	1293	java/io/InterruptedIOException
    //   484	497	1328	java/io/IOException
    //   484	497	1316	com/loc/j
    //   484	497	911	finally
    //   500	514	1397	java/net/ConnectException
    //   500	514	1385	java/net/MalformedURLException
    //   500	514	1373	java/net/UnknownHostException
    //   500	514	1361	java/net/SocketException
    //   500	514	1349	java/net/SocketTimeoutException
    //   500	514	1293	java/io/InterruptedIOException
    //   500	514	1328	java/io/IOException
    //   500	514	1316	com/loc/j
    //   500	514	911	finally
    //   514	519	1397	java/net/ConnectException
    //   514	519	1385	java/net/MalformedURLException
    //   514	519	1373	java/net/UnknownHostException
    //   514	519	1361	java/net/SocketException
    //   514	519	1349	java/net/SocketTimeoutException
    //   514	519	1293	java/io/InterruptedIOException
    //   514	519	1328	java/io/IOException
    //   514	519	1316	com/loc/j
    //   514	519	911	finally
    //   522	536	1397	java/net/ConnectException
    //   522	536	1385	java/net/MalformedURLException
    //   522	536	1373	java/net/UnknownHostException
    //   522	536	1361	java/net/SocketException
    //   522	536	1349	java/net/SocketTimeoutException
    //   522	536	1293	java/io/InterruptedIOException
    //   522	536	1328	java/io/IOException
    //   522	536	1316	com/loc/j
    //   522	536	911	finally
    //   539	549	1397	java/net/ConnectException
    //   539	549	1385	java/net/MalformedURLException
    //   539	549	1373	java/net/UnknownHostException
    //   539	549	1361	java/net/SocketException
    //   539	549	1349	java/net/SocketTimeoutException
    //   539	549	1293	java/io/InterruptedIOException
    //   539	549	1328	java/io/IOException
    //   539	549	1316	com/loc/j
    //   539	549	911	finally
    //   555	560	1397	java/net/ConnectException
    //   555	560	1385	java/net/MalformedURLException
    //   555	560	1373	java/net/UnknownHostException
    //   555	560	1361	java/net/SocketException
    //   555	560	1349	java/net/SocketTimeoutException
    //   555	560	1293	java/io/InterruptedIOException
    //   555	560	1328	java/io/IOException
    //   555	560	1316	com/loc/j
    //   555	560	911	finally
    //   560	584	1397	java/net/ConnectException
    //   560	584	1385	java/net/MalformedURLException
    //   560	584	1373	java/net/UnknownHostException
    //   560	584	1361	java/net/SocketException
    //   560	584	1349	java/net/SocketTimeoutException
    //   560	584	1293	java/io/InterruptedIOException
    //   560	584	1328	java/io/IOException
    //   560	584	1316	com/loc/j
    //   560	584	911	finally
    //   584	624	1397	java/net/ConnectException
    //   584	624	1385	java/net/MalformedURLException
    //   584	624	1373	java/net/UnknownHostException
    //   584	624	1361	java/net/SocketException
    //   584	624	1349	java/net/SocketTimeoutException
    //   584	624	1293	java/io/InterruptedIOException
    //   584	624	1328	java/io/IOException
    //   584	624	1316	com/loc/j
    //   584	624	911	finally
    //   640	645	903	java/net/ConnectException
    //   640	645	895	java/net/MalformedURLException
    //   640	645	887	java/net/UnknownHostException
    //   640	645	879	java/net/SocketException
    //   640	645	871	java/net/SocketTimeoutException
    //   640	645	1301	java/io/InterruptedIOException
    //   640	645	863	java/io/IOException
    //   640	645	855	com/loc/j
    //   640	645	847	finally
    //   677	683	903	java/net/ConnectException
    //   677	683	895	java/net/MalformedURLException
    //   677	683	887	java/net/UnknownHostException
    //   677	683	879	java/net/SocketException
    //   677	683	871	java/net/SocketTimeoutException
    //   677	683	1301	java/io/InterruptedIOException
    //   677	683	863	java/io/IOException
    //   677	683	855	com/loc/j
    //   677	683	847	finally
    //   710	723	903	java/net/ConnectException
    //   710	723	895	java/net/MalformedURLException
    //   710	723	887	java/net/UnknownHostException
    //   710	723	879	java/net/SocketException
    //   710	723	871	java/net/SocketTimeoutException
    //   710	723	1301	java/io/InterruptedIOException
    //   710	723	863	java/io/IOException
    //   710	723	855	com/loc/j
    //   710	723	847	finally
    //   750	757	903	java/net/ConnectException
    //   750	757	895	java/net/MalformedURLException
    //   750	757	887	java/net/UnknownHostException
    //   750	757	879	java/net/SocketException
    //   750	757	871	java/net/SocketTimeoutException
    //   750	757	1301	java/io/InterruptedIOException
    //   750	757	863	java/io/IOException
    //   750	757	855	com/loc/j
    //   750	757	847	finally
    //   784	789	903	java/net/ConnectException
    //   784	789	895	java/net/MalformedURLException
    //   784	789	887	java/net/UnknownHostException
    //   784	789	879	java/net/SocketException
    //   784	789	871	java/net/SocketTimeoutException
    //   784	789	1301	java/io/InterruptedIOException
    //   784	789	863	java/io/IOException
    //   784	789	855	com/loc/j
    //   784	789	847	finally
    //   816	823	903	java/net/ConnectException
    //   816	823	895	java/net/MalformedURLException
    //   816	823	887	java/net/UnknownHostException
    //   816	823	879	java/net/SocketException
    //   816	823	871	java/net/SocketTimeoutException
    //   816	823	1301	java/io/InterruptedIOException
    //   816	823	863	java/io/IOException
    //   816	823	855	com/loc/j
    //   816	823	847	finally
    //   827	831	834	finally
    //   930	940	1247	finally
    //   950	961	1247	finally
    //   971	980	1247	finally
    //   990	1000	1247	finally
    //   1010	1013	1247	finally
    //   1023	1028	1247	finally
    //   1038	1049	1247	finally
    //   1056	1067	1247	finally
    //   1077	1082	1247	finally
    //   1092	1103	1247	finally
    //   1113	1118	1247	finally
    //   1128	1139	1247	finally
    //   1149	1154	1247	finally
    //   1164	1175	1247	finally
    //   1185	1190	1247	finally
    //   1200	1211	1247	finally
    //   1221	1226	1247	finally
    //   1236	1247	1247	finally
    //   1254	1266	1307	finally
    //   1273	1277	1280	finally
  }
  
  public static final class a {
    public HttpURLConnection a;
    
    public int b;
    
    public a(HttpURLConnection param1HttpURLConnection, int param1Int) {
      this.a = param1HttpURLConnection;
      this.b = param1Int;
    }
  }
  
  static final class b {
    private Vector<at.c> a = new Vector<at.c>();
    
    private volatile at.c b = new at.c((byte)0);
    
    private b() {}
    
    public final at.c a() {
      return this.b;
    }
    
    public final at.c a(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return this.b; 
      for (int i = 0; i < this.a.size(); i++) {
        at.c c2 = this.a.get(i);
        if (c2 != null && c2.a().equals(param1String))
          return c2; 
      } 
      at.c c1 = new at.c((byte)0);
      c1.b(param1String);
      this.a.add(c1);
      return c1;
    }
    
    public final void b(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return; 
      this.b.a(param1String);
    }
  }
  
  static final class c implements HostnameVerifier {
    private String a;
    
    private String b;
    
    private c() {}
    
    public final String a() {
      return this.b;
    }
    
    public final void a(String param1String) {
      this.a = param1String;
    }
    
    public final void b(String param1String) {
      this.b = param1String;
    }
    
    public final boolean verify(String param1String, SSLSession param1SSLSession) {
      HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
      return !TextUtils.isEmpty(this.a) ? this.a.equals(param1String) : (!TextUtils.isEmpty(this.b) ? hostnameVerifier.verify(this.b, param1SSLSession) : hostnameVerifier.verify(param1String, param1SSLSession));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */