package com.huawei.hianalytics.ab.bc.fg;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.bc.kl.de;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public abstract class ab {
  public static bc ab(String paramString, byte[] paramArrayOfbyte, Map<String, String> paramMap) {
    return ab(paramString, paramArrayOfbyte, paramMap, "POST");
  }
  
  public static bc ab(String paramString1, byte[] paramArrayOfbyte, Map<String, String> paramMap, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 19
    //   7: new com/huawei/hianalytics/ab/bc/fg/bc
    //   10: dup
    //   11: bipush #-100
    //   13: ldc ''
    //   15: invokespecial <init> : (ILjava/lang/String;)V
    //   18: areturn
    //   19: bipush #-102
    //   21: istore #4
    //   23: aconst_null
    //   24: astore #6
    //   26: aload_0
    //   27: aload_1
    //   28: arraylength
    //   29: aload_2
    //   30: aload_3
    //   31: invokestatic ab : (Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnonnull -> 69
    //   39: new com/huawei/hianalytics/ab/bc/fg/bc
    //   42: dup
    //   43: bipush #-101
    //   45: ldc ''
    //   47: invokespecial <init> : (ILjava/lang/String;)V
    //   50: astore_1
    //   51: aconst_null
    //   52: invokestatic ab : (Ljava/io/Closeable;)V
    //   55: aconst_null
    //   56: invokestatic ab : (Ljava/io/Closeable;)V
    //   59: aload_0
    //   60: ifnull -> 67
    //   63: aload_0
    //   64: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   67: aload_1
    //   68: areturn
    //   69: aload_0
    //   70: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   73: astore_2
    //   74: new java/io/BufferedOutputStream
    //   77: dup
    //   78: aload_2
    //   79: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   82: astore #8
    //   84: aload_0
    //   85: astore_3
    //   86: aload_2
    //   87: astore #6
    //   89: aload #8
    //   91: astore #7
    //   93: aload #8
    //   95: aload_1
    //   96: invokevirtual write : ([B)V
    //   99: aload_0
    //   100: astore_3
    //   101: aload_2
    //   102: astore #6
    //   104: aload #8
    //   106: astore #7
    //   108: aload #8
    //   110: invokevirtual flush : ()V
    //   113: aload_0
    //   114: astore_3
    //   115: aload_2
    //   116: astore #6
    //   118: aload #8
    //   120: astore #7
    //   122: aload_0
    //   123: invokevirtual getResponseCode : ()I
    //   126: istore #5
    //   128: aload_0
    //   129: astore_3
    //   130: aload_2
    //   131: astore #6
    //   133: aload #8
    //   135: astore #7
    //   137: new com/huawei/hianalytics/ab/bc/fg/bc
    //   140: dup
    //   141: iload #5
    //   143: aload_0
    //   144: invokestatic bc : (Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   147: invokespecial <init> : (ILjava/lang/String;)V
    //   150: astore_1
    //   151: aload #8
    //   153: invokestatic ab : (Ljava/io/Closeable;)V
    //   156: aload_2
    //   157: invokestatic ab : (Ljava/io/Closeable;)V
    //   160: aload_0
    //   161: ifnull -> 168
    //   164: aload_0
    //   165: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   168: aload_1
    //   169: areturn
    //   170: iload #5
    //   172: istore #4
    //   174: goto -> 293
    //   177: iload #5
    //   179: istore #4
    //   181: goto -> 356
    //   184: iload #5
    //   186: istore #4
    //   188: goto -> 419
    //   191: iload #5
    //   193: istore #4
    //   195: goto -> 482
    //   198: iload #5
    //   200: istore #4
    //   202: goto -> 545
    //   205: iload #5
    //   207: istore #4
    //   209: goto -> 608
    //   212: astore #7
    //   214: aload #6
    //   216: astore_1
    //   217: aload_0
    //   218: astore_3
    //   219: aload #7
    //   221: astore_0
    //   222: goto -> 734
    //   225: astore #7
    //   227: aconst_null
    //   228: astore_2
    //   229: aload #6
    //   231: astore_1
    //   232: aload_0
    //   233: astore_3
    //   234: aload #7
    //   236: astore_0
    //   237: goto -> 734
    //   240: aconst_null
    //   241: astore_2
    //   242: goto -> 290
    //   245: aconst_null
    //   246: astore_2
    //   247: goto -> 353
    //   250: aconst_null
    //   251: astore_2
    //   252: goto -> 416
    //   255: aconst_null
    //   256: astore_2
    //   257: goto -> 479
    //   260: aconst_null
    //   261: astore_2
    //   262: goto -> 542
    //   265: aconst_null
    //   266: astore_2
    //   267: goto -> 605
    //   270: aconst_null
    //   271: astore_2
    //   272: goto -> 668
    //   275: astore_0
    //   276: aconst_null
    //   277: astore_3
    //   278: aload_3
    //   279: astore_2
    //   280: aload #6
    //   282: astore_1
    //   283: goto -> 734
    //   286: aconst_null
    //   287: astore_0
    //   288: aload_0
    //   289: astore_2
    //   290: aconst_null
    //   291: astore #8
    //   293: aload_0
    //   294: astore_3
    //   295: aload_2
    //   296: astore #6
    //   298: aload #8
    //   300: astore #7
    //   302: ldc 'hmsSdk'
    //   304: ldc 'events PostRequest(byte[]): IOException occurred.'
    //   306: invokestatic fg : (Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_0
    //   310: astore_3
    //   311: aload_2
    //   312: astore #6
    //   314: aload #8
    //   316: astore #7
    //   318: new com/huawei/hianalytics/ab/bc/fg/bc
    //   321: dup
    //   322: iload #4
    //   324: ldc ''
    //   326: invokespecial <init> : (ILjava/lang/String;)V
    //   329: astore_1
    //   330: aload #8
    //   332: invokestatic ab : (Ljava/io/Closeable;)V
    //   335: aload_2
    //   336: invokestatic ab : (Ljava/io/Closeable;)V
    //   339: aload_0
    //   340: ifnull -> 347
    //   343: aload_0
    //   344: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   347: aload_1
    //   348: areturn
    //   349: aconst_null
    //   350: astore_0
    //   351: aload_0
    //   352: astore_2
    //   353: aconst_null
    //   354: astore #8
    //   356: aload_0
    //   357: astore_3
    //   358: aload_2
    //   359: astore #6
    //   361: aload #8
    //   363: astore #7
    //   365: ldc 'hmsSdk'
    //   367: ldc 'No address associated with hostname or No network'
    //   369: invokestatic fg : (Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_0
    //   373: astore_3
    //   374: aload_2
    //   375: astore #6
    //   377: aload #8
    //   379: astore #7
    //   381: new com/huawei/hianalytics/ab/bc/fg/bc
    //   384: dup
    //   385: iload #4
    //   387: ldc ''
    //   389: invokespecial <init> : (ILjava/lang/String;)V
    //   392: astore_1
    //   393: aload #8
    //   395: invokestatic ab : (Ljava/io/Closeable;)V
    //   398: aload_2
    //   399: invokestatic ab : (Ljava/io/Closeable;)V
    //   402: aload_0
    //   403: ifnull -> 410
    //   406: aload_0
    //   407: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   410: aload_1
    //   411: areturn
    //   412: aconst_null
    //   413: astore_0
    //   414: aload_0
    //   415: astore_2
    //   416: aconst_null
    //   417: astore #8
    //   419: aload_0
    //   420: astore_3
    //   421: aload_2
    //   422: astore #6
    //   424: aload #8
    //   426: astore #7
    //   428: ldc 'hmsSdk'
    //   430: ldc 'Network is unreachable or Connection refused'
    //   432: invokestatic fg : (Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload_0
    //   436: astore_3
    //   437: aload_2
    //   438: astore #6
    //   440: aload #8
    //   442: astore #7
    //   444: new com/huawei/hianalytics/ab/bc/fg/bc
    //   447: dup
    //   448: iload #4
    //   450: ldc ''
    //   452: invokespecial <init> : (ILjava/lang/String;)V
    //   455: astore_1
    //   456: aload #8
    //   458: invokestatic ab : (Ljava/io/Closeable;)V
    //   461: aload_2
    //   462: invokestatic ab : (Ljava/io/Closeable;)V
    //   465: aload_0
    //   466: ifnull -> 473
    //   469: aload_0
    //   470: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   473: aload_1
    //   474: areturn
    //   475: aconst_null
    //   476: astore_0
    //   477: aload_0
    //   478: astore_2
    //   479: aconst_null
    //   480: astore #8
    //   482: aload_0
    //   483: astore_3
    //   484: aload_2
    //   485: astore #6
    //   487: aload #8
    //   489: astore #7
    //   491: ldc 'hmsSdk'
    //   493: ldc 'Chain validation failed,Certificate expired'
    //   495: invokestatic fg : (Ljava/lang/String;Ljava/lang/String;)V
    //   498: aload_0
    //   499: astore_3
    //   500: aload_2
    //   501: astore #6
    //   503: aload #8
    //   505: astore #7
    //   507: new com/huawei/hianalytics/ab/bc/fg/bc
    //   510: dup
    //   511: iload #4
    //   513: ldc ''
    //   515: invokespecial <init> : (ILjava/lang/String;)V
    //   518: astore_1
    //   519: aload #8
    //   521: invokestatic ab : (Ljava/io/Closeable;)V
    //   524: aload_2
    //   525: invokestatic ab : (Ljava/io/Closeable;)V
    //   528: aload_0
    //   529: ifnull -> 536
    //   532: aload_0
    //   533: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   536: aload_1
    //   537: areturn
    //   538: aconst_null
    //   539: astore_0
    //   540: aload_0
    //   541: astore_2
    //   542: aconst_null
    //   543: astore #8
    //   545: aload_0
    //   546: astore_3
    //   547: aload_2
    //   548: astore #6
    //   550: aload #8
    //   552: astore #7
    //   554: ldc 'hmsSdk'
    //   556: ldc 'Certificate has not been verified,Request is restricted!'
    //   558: invokestatic fg : (Ljava/lang/String;Ljava/lang/String;)V
    //   561: aload_0
    //   562: astore_3
    //   563: aload_2
    //   564: astore #6
    //   566: aload #8
    //   568: astore #7
    //   570: new com/huawei/hianalytics/ab/bc/fg/bc
    //   573: dup
    //   574: iload #4
    //   576: ldc ''
    //   578: invokespecial <init> : (ILjava/lang/String;)V
    //   581: astore_1
    //   582: aload #8
    //   584: invokestatic ab : (Ljava/io/Closeable;)V
    //   587: aload_2
    //   588: invokestatic ab : (Ljava/io/Closeable;)V
    //   591: aload_0
    //   592: ifnull -> 599
    //   595: aload_0
    //   596: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   599: aload_1
    //   600: areturn
    //   601: aconst_null
    //   602: astore_0
    //   603: aload_0
    //   604: astore_2
    //   605: aconst_null
    //   606: astore #8
    //   608: aload_0
    //   609: astore_3
    //   610: aload_2
    //   611: astore #6
    //   613: aload #8
    //   615: astore #7
    //   617: ldc 'hmsSdk'
    //   619: ldc 'SecurityException with HttpClient. Please check INTERNET permission.'
    //   621: invokestatic fg : (Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload_0
    //   625: astore_3
    //   626: aload_2
    //   627: astore #6
    //   629: aload #8
    //   631: astore #7
    //   633: new com/huawei/hianalytics/ab/bc/fg/bc
    //   636: dup
    //   637: iload #4
    //   639: ldc ''
    //   641: invokespecial <init> : (ILjava/lang/String;)V
    //   644: astore_1
    //   645: aload #8
    //   647: invokestatic ab : (Ljava/io/Closeable;)V
    //   650: aload_2
    //   651: invokestatic ab : (Ljava/io/Closeable;)V
    //   654: aload_0
    //   655: ifnull -> 662
    //   658: aload_0
    //   659: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   662: aload_1
    //   663: areturn
    //   664: aconst_null
    //   665: astore_0
    //   666: aload_0
    //   667: astore_2
    //   668: aconst_null
    //   669: astore #8
    //   671: aload_0
    //   672: astore_3
    //   673: aload_2
    //   674: astore #6
    //   676: aload #8
    //   678: astore #7
    //   680: ldc 'hmsSdk'
    //   682: ldc 'PostRequest(byte[]): No ssl socket factory set!'
    //   684: invokestatic fg : (Ljava/lang/String;Ljava/lang/String;)V
    //   687: aload_0
    //   688: astore_3
    //   689: aload_2
    //   690: astore #6
    //   692: aload #8
    //   694: astore #7
    //   696: new com/huawei/hianalytics/ab/bc/fg/bc
    //   699: dup
    //   700: bipush #-101
    //   702: ldc ''
    //   704: invokespecial <init> : (ILjava/lang/String;)V
    //   707: astore_1
    //   708: aload #8
    //   710: invokestatic ab : (Ljava/io/Closeable;)V
    //   713: aload_2
    //   714: invokestatic ab : (Ljava/io/Closeable;)V
    //   717: aload_0
    //   718: ifnull -> 725
    //   721: aload_0
    //   722: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   725: aload_1
    //   726: areturn
    //   727: astore_0
    //   728: aload #7
    //   730: astore_1
    //   731: aload #6
    //   733: astore_2
    //   734: aload_1
    //   735: invokestatic ab : (Ljava/io/Closeable;)V
    //   738: aload_2
    //   739: invokestatic ab : (Ljava/io/Closeable;)V
    //   742: aload_3
    //   743: ifnull -> 750
    //   746: aload_3
    //   747: invokestatic ab : (Ljava/net/HttpURLConnection;)V
    //   750: aload_0
    //   751: athrow
    //   752: astore_0
    //   753: goto -> 664
    //   756: astore_0
    //   757: goto -> 601
    //   760: astore_0
    //   761: goto -> 538
    //   764: astore_0
    //   765: goto -> 475
    //   768: astore_0
    //   769: goto -> 412
    //   772: astore_0
    //   773: goto -> 349
    //   776: astore_0
    //   777: goto -> 286
    //   780: astore_1
    //   781: goto -> 270
    //   784: astore_1
    //   785: goto -> 265
    //   788: astore_1
    //   789: goto -> 260
    //   792: astore_1
    //   793: goto -> 255
    //   796: astore_1
    //   797: goto -> 250
    //   800: astore_1
    //   801: goto -> 245
    //   804: astore_1
    //   805: goto -> 240
    //   808: astore_1
    //   809: goto -> 668
    //   812: astore_1
    //   813: goto -> 605
    //   816: astore_1
    //   817: goto -> 542
    //   820: astore_1
    //   821: goto -> 479
    //   824: astore_1
    //   825: goto -> 416
    //   828: astore_1
    //   829: goto -> 353
    //   832: astore_1
    //   833: goto -> 290
    //   836: astore_1
    //   837: goto -> 671
    //   840: astore_1
    //   841: goto -> 608
    //   844: astore_1
    //   845: goto -> 545
    //   848: astore_1
    //   849: goto -> 482
    //   852: astore_1
    //   853: goto -> 419
    //   856: astore_1
    //   857: goto -> 356
    //   860: astore_1
    //   861: goto -> 293
    //   864: astore_1
    //   865: goto -> 205
    //   868: astore_1
    //   869: goto -> 198
    //   872: astore_1
    //   873: goto -> 191
    //   876: astore_1
    //   877: goto -> 184
    //   880: astore_1
    //   881: goto -> 177
    //   884: astore_1
    //   885: goto -> 170
    // Exception table:
    //   from	to	target	type
    //   26	35	752	com/huawei/hianalytics/ab/bc/fg/ab$ab
    //   26	35	756	java/lang/SecurityException
    //   26	35	760	javax/net/ssl/SSLPeerUnverifiedException
    //   26	35	764	javax/net/ssl/SSLHandshakeException
    //   26	35	768	java/net/ConnectException
    //   26	35	772	java/net/UnknownHostException
    //   26	35	776	java/io/IOException
    //   26	35	275	finally
    //   39	51	780	com/huawei/hianalytics/ab/bc/fg/ab$ab
    //   39	51	784	java/lang/SecurityException
    //   39	51	788	javax/net/ssl/SSLPeerUnverifiedException
    //   39	51	792	javax/net/ssl/SSLHandshakeException
    //   39	51	796	java/net/ConnectException
    //   39	51	800	java/net/UnknownHostException
    //   39	51	804	java/io/IOException
    //   39	51	225	finally
    //   69	74	780	com/huawei/hianalytics/ab/bc/fg/ab$ab
    //   69	74	784	java/lang/SecurityException
    //   69	74	788	javax/net/ssl/SSLPeerUnverifiedException
    //   69	74	792	javax/net/ssl/SSLHandshakeException
    //   69	74	796	java/net/ConnectException
    //   69	74	800	java/net/UnknownHostException
    //   69	74	804	java/io/IOException
    //   69	74	225	finally
    //   74	84	808	com/huawei/hianalytics/ab/bc/fg/ab$ab
    //   74	84	812	java/lang/SecurityException
    //   74	84	816	javax/net/ssl/SSLPeerUnverifiedException
    //   74	84	820	javax/net/ssl/SSLHandshakeException
    //   74	84	824	java/net/ConnectException
    //   74	84	828	java/net/UnknownHostException
    //   74	84	832	java/io/IOException
    //   74	84	212	finally
    //   93	99	836	com/huawei/hianalytics/ab/bc/fg/ab$ab
    //   93	99	840	java/lang/SecurityException
    //   93	99	844	javax/net/ssl/SSLPeerUnverifiedException
    //   93	99	848	javax/net/ssl/SSLHandshakeException
    //   93	99	852	java/net/ConnectException
    //   93	99	856	java/net/UnknownHostException
    //   93	99	860	java/io/IOException
    //   93	99	727	finally
    //   108	113	836	com/huawei/hianalytics/ab/bc/fg/ab$ab
    //   108	113	840	java/lang/SecurityException
    //   108	113	844	javax/net/ssl/SSLPeerUnverifiedException
    //   108	113	848	javax/net/ssl/SSLHandshakeException
    //   108	113	852	java/net/ConnectException
    //   108	113	856	java/net/UnknownHostException
    //   108	113	860	java/io/IOException
    //   108	113	727	finally
    //   122	128	836	com/huawei/hianalytics/ab/bc/fg/ab$ab
    //   122	128	840	java/lang/SecurityException
    //   122	128	844	javax/net/ssl/SSLPeerUnverifiedException
    //   122	128	848	javax/net/ssl/SSLHandshakeException
    //   122	128	852	java/net/ConnectException
    //   122	128	856	java/net/UnknownHostException
    //   122	128	860	java/io/IOException
    //   122	128	727	finally
    //   137	151	836	com/huawei/hianalytics/ab/bc/fg/ab$ab
    //   137	151	864	java/lang/SecurityException
    //   137	151	868	javax/net/ssl/SSLPeerUnverifiedException
    //   137	151	872	javax/net/ssl/SSLHandshakeException
    //   137	151	876	java/net/ConnectException
    //   137	151	880	java/net/UnknownHostException
    //   137	151	884	java/io/IOException
    //   137	151	727	finally
    //   302	309	727	finally
    //   318	330	727	finally
    //   365	372	727	finally
    //   381	393	727	finally
    //   428	435	727	finally
    //   444	456	727	finally
    //   491	498	727	finally
    //   507	519	727	finally
    //   554	561	727	finally
    //   570	582	727	finally
    //   617	624	727	finally
    //   633	645	727	finally
    //   680	687	727	finally
    //   696	708	727	finally
  }
  
  private static HttpURLConnection ab(String paramString1, int paramInt, Map<String, String> paramMap, String paramString2) {
    if (TextUtils.isEmpty(paramString1)) {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "CreateConnection: invalid urlPath.");
      return null;
    } 
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString1)).openConnection();
    ab(httpURLConnection);
    httpURLConnection.setRequestMethod(paramString2);
    httpURLConnection.setConnectTimeout(15000);
    httpURLConnection.setReadTimeout(15000);
    httpURLConnection.setDoOutput(true);
    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(paramInt));
    httpURLConnection.setRequestProperty("Connection", "close");
    if (paramMap != null) {
      if (paramMap.size() < 1)
        return httpURLConnection; 
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        String str = (String)entry.getKey();
        if (str == null || TextUtils.isEmpty(str))
          continue; 
        httpURLConnection.setRequestProperty(str, (String)entry.getValue());
      } 
    } 
    return httpURLConnection;
  }
  
  private static void ab(HttpURLConnection paramHttpURLConnection) {
    String str;
    HttpsURLConnection httpsURLConnection;
    if (paramHttpURLConnection instanceof HttpsURLConnection) {
      httpsURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      String str1 = null;
      try {
        SecureSSLSocketFactory secureSSLSocketFactory = SecureSSLSocketFactory.a(bc.fg());
        if (secureSSLSocketFactory != null) {
          httpsURLConnection.setSSLSocketFactory((SSLSocketFactory)secureSSLSocketFactory);
          httpsURLConnection.setHostnameVerifier((HostnameVerifier)new StrictHostnameVerifier());
          return;
        } 
        throw new ab("No ssl socket factory set");
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        str = "getSocketFactory(): Algorithm Exception!";
      } catch (KeyStoreException keyStoreException) {
        str = "getSocketFactory(): Key Store exception";
      } catch (GeneralSecurityException generalSecurityException) {
        str = "getSocketFactory(): General Security Exception";
      } catch (IOException iOException) {
        str = "getSocketFactory(): IO Exception!";
      } catch (IllegalAccessException illegalAccessException) {
        str = "getSocketFactory(): Illegal Access Exception ";
      } 
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", str);
      str = str1;
    } else {
      return;
    } 
    if (str != null) {
      httpsURLConnection.setSSLSocketFactory((SSLSocketFactory)str);
      httpsURLConnection.setHostnameVerifier((HostnameVerifier)new StrictHostnameVerifier());
      return;
    } 
    throw new ab("No ssl socket factory set");
  }
  
  private static String bc(HttpURLConnection paramHttpURLConnection) {
    InputStream inputStream2 = null;
    InputStream inputStream1 = null;
    try {
      InputStream inputStream = paramHttpURLConnection.getInputStream();
      inputStream1 = inputStream;
      inputStream2 = inputStream;
      return de.ab(inputStream);
    } catch (IOException iOException) {
      inputStream1 = inputStream2;
      int i = paramHttpURLConnection.getResponseCode();
      inputStream1 = inputStream2;
      StringBuilder stringBuilder = new StringBuilder();
      inputStream1 = inputStream2;
      stringBuilder.append("When Response Content From Connection inputStream operation exception! ");
      inputStream1 = inputStream2;
      stringBuilder.append(i);
      inputStream1 = inputStream2;
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", stringBuilder.toString());
      return "";
    } finally {
      de.ab(inputStream1);
    } 
  }
  
  static class ab extends Exception {
    ab(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\fg\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */