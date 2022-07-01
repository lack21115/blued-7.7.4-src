package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public abstract class d {
  public static String a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap) {
    // Byte code:
    //   0: aload_2
    //   1: ifnull -> 756
    //   4: aload_1
    //   5: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   8: ifne -> 756
    //   11: aload_2
    //   12: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   15: ifeq -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: iconst_m1
    //   21: istore #4
    //   23: aload_0
    //   24: aload_1
    //   25: aload_3
    //   26: getstatic com/huawei/hms/opendevice/d$a.b : Lcom/huawei/hms/opendevice/d$a;
    //   29: invokevirtual a : ()Ljava/lang/String;
    //   32: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnonnull -> 65
    //   40: aconst_null
    //   41: invokestatic a : (Ljava/io/OutputStream;)V
    //   44: aconst_null
    //   45: invokestatic a : (Ljava/io/InputStream;)V
    //   48: aconst_null
    //   49: invokestatic a : (Ljava/io/InputStream;)V
    //   52: aload_0
    //   53: invokestatic a : (Ljava/net/HttpURLConnection;)V
    //   56: ldc 'PushHttpClient'
    //   58: ldc 'close connection'
    //   60: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   63: aconst_null
    //   64: areturn
    //   65: new java/io/BufferedOutputStream
    //   68: dup
    //   69: aload_0
    //   70: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   73: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   76: astore_1
    //   77: iload #4
    //   79: istore #5
    //   81: iload #4
    //   83: istore #6
    //   85: iload #4
    //   87: istore #7
    //   89: aload_1
    //   90: aload_2
    //   91: ldc 'UTF-8'
    //   93: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   96: invokevirtual write : ([B)V
    //   99: iload #4
    //   101: istore #5
    //   103: iload #4
    //   105: istore #6
    //   107: iload #4
    //   109: istore #7
    //   111: aload_1
    //   112: invokevirtual flush : ()V
    //   115: iload #4
    //   117: istore #5
    //   119: iload #4
    //   121: istore #6
    //   123: iload #4
    //   125: istore #7
    //   127: aload_0
    //   128: invokevirtual getResponseCode : ()I
    //   131: istore #4
    //   133: iload #4
    //   135: istore #5
    //   137: iload #4
    //   139: istore #6
    //   141: iload #4
    //   143: istore #7
    //   145: new java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial <init> : ()V
    //   152: astore_2
    //   153: iload #4
    //   155: istore #5
    //   157: iload #4
    //   159: istore #6
    //   161: iload #4
    //   163: istore #7
    //   165: aload_2
    //   166: ldc 'http post response code: '
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: iload #4
    //   174: istore #5
    //   176: iload #4
    //   178: istore #6
    //   180: iload #4
    //   182: istore #7
    //   184: aload_2
    //   185: iload #4
    //   187: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: iload #4
    //   193: istore #5
    //   195: iload #4
    //   197: istore #6
    //   199: iload #4
    //   201: istore #7
    //   203: ldc 'PushHttpClient'
    //   205: aload_2
    //   206: invokevirtual toString : ()Ljava/lang/String;
    //   209: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   212: iload #4
    //   214: sipush #400
    //   217: if_icmplt -> 240
    //   220: iload #4
    //   222: istore #5
    //   224: iload #4
    //   226: istore #6
    //   228: iload #4
    //   230: istore #7
    //   232: aload_0
    //   233: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   236: astore_2
    //   237: goto -> 257
    //   240: iload #4
    //   242: istore #5
    //   244: iload #4
    //   246: istore #6
    //   248: iload #4
    //   250: istore #7
    //   252: aload_0
    //   253: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   256: astore_2
    //   257: new java/io/BufferedInputStream
    //   260: dup
    //   261: aload_2
    //   262: invokespecial <init> : (Ljava/io/InputStream;)V
    //   265: astore #11
    //   267: aload_0
    //   268: astore_3
    //   269: aload_1
    //   270: astore #8
    //   272: aload_2
    //   273: astore #9
    //   275: aload #11
    //   277: astore #10
    //   279: aload #11
    //   281: invokestatic a : (Ljava/io/InputStream;)Ljava/lang/String;
    //   284: astore #12
    //   286: aload_1
    //   287: invokestatic a : (Ljava/io/OutputStream;)V
    //   290: aload_2
    //   291: invokestatic a : (Ljava/io/InputStream;)V
    //   294: aload #11
    //   296: invokestatic a : (Ljava/io/InputStream;)V
    //   299: aload_0
    //   300: invokestatic a : (Ljava/net/HttpURLConnection;)V
    //   303: ldc 'PushHttpClient'
    //   305: ldc 'close connection'
    //   307: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload #12
    //   312: areturn
    //   313: astore_3
    //   314: aconst_null
    //   315: astore #10
    //   317: goto -> 730
    //   320: aconst_null
    //   321: astore_3
    //   322: aload_0
    //   323: astore #12
    //   325: aload_3
    //   326: astore_0
    //   327: goto -> 436
    //   330: aconst_null
    //   331: astore_3
    //   332: aload_0
    //   333: astore #12
    //   335: aload_3
    //   336: astore_0
    //   337: goto -> 522
    //   340: aconst_null
    //   341: astore_3
    //   342: aload_0
    //   343: astore #12
    //   345: aload_3
    //   346: astore_0
    //   347: goto -> 608
    //   350: astore_3
    //   351: aconst_null
    //   352: astore #10
    //   354: aload #10
    //   356: astore_2
    //   357: goto -> 730
    //   360: aconst_null
    //   361: astore_2
    //   362: iload #7
    //   364: istore #4
    //   366: aload_0
    //   367: astore #12
    //   369: goto -> 434
    //   372: aconst_null
    //   373: astore_2
    //   374: iload #6
    //   376: istore #4
    //   378: goto -> 842
    //   381: aconst_null
    //   382: astore_2
    //   383: iload #5
    //   385: istore #4
    //   387: goto -> 858
    //   390: astore_3
    //   391: aconst_null
    //   392: astore_2
    //   393: aload_2
    //   394: astore #10
    //   396: aload #10
    //   398: astore_1
    //   399: goto -> 730
    //   402: goto -> 427
    //   405: goto -> 838
    //   408: goto -> 854
    //   411: astore_3
    //   412: aconst_null
    //   413: astore_1
    //   414: aload_1
    //   415: astore_2
    //   416: aload_2
    //   417: astore #10
    //   419: aload #10
    //   421: astore_0
    //   422: goto -> 730
    //   425: aconst_null
    //   426: astore_0
    //   427: aconst_null
    //   428: astore_1
    //   429: aconst_null
    //   430: astore_2
    //   431: aload_0
    //   432: astore #12
    //   434: aload_2
    //   435: astore_0
    //   436: aload #12
    //   438: astore_3
    //   439: aload_1
    //   440: astore #8
    //   442: aload_2
    //   443: astore #9
    //   445: aload_0
    //   446: astore #10
    //   448: new java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial <init> : ()V
    //   455: astore #11
    //   457: aload #12
    //   459: astore_3
    //   460: aload_1
    //   461: astore #8
    //   463: aload_2
    //   464: astore #9
    //   466: aload_0
    //   467: astore #10
    //   469: aload #11
    //   471: ldc 'http execute encounter unknown exception - http code:'
    //   473: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload #12
    //   479: astore_3
    //   480: aload_1
    //   481: astore #8
    //   483: aload_2
    //   484: astore #9
    //   486: aload_0
    //   487: astore #10
    //   489: aload #11
    //   491: iload #4
    //   493: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload #12
    //   499: astore_3
    //   500: aload_1
    //   501: astore #8
    //   503: aload_2
    //   504: astore #9
    //   506: aload_0
    //   507: astore #10
    //   509: ldc 'PushHttpClient'
    //   511: aload #11
    //   513: invokevirtual toString : ()Ljava/lang/String;
    //   516: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   519: goto -> 691
    //   522: aload #12
    //   524: astore_3
    //   525: aload_1
    //   526: astore #8
    //   528: aload_2
    //   529: astore #9
    //   531: aload_0
    //   532: astore #10
    //   534: new java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial <init> : ()V
    //   541: astore #11
    //   543: aload #12
    //   545: astore_3
    //   546: aload_1
    //   547: astore #8
    //   549: aload_2
    //   550: astore #9
    //   552: aload_0
    //   553: astore #10
    //   555: aload #11
    //   557: ldc 'http execute encounter RuntimeException - http code:'
    //   559: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload #12
    //   565: astore_3
    //   566: aload_1
    //   567: astore #8
    //   569: aload_2
    //   570: astore #9
    //   572: aload_0
    //   573: astore #10
    //   575: aload #11
    //   577: iload #4
    //   579: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload #12
    //   585: astore_3
    //   586: aload_1
    //   587: astore #8
    //   589: aload_2
    //   590: astore #9
    //   592: aload_0
    //   593: astore #10
    //   595: ldc 'PushHttpClient'
    //   597: aload #11
    //   599: invokevirtual toString : ()Ljava/lang/String;
    //   602: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   605: goto -> 691
    //   608: aload #12
    //   610: astore_3
    //   611: aload_1
    //   612: astore #8
    //   614: aload_2
    //   615: astore #9
    //   617: aload_0
    //   618: astore #10
    //   620: new java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial <init> : ()V
    //   627: astore #11
    //   629: aload #12
    //   631: astore_3
    //   632: aload_1
    //   633: astore #8
    //   635: aload_2
    //   636: astore #9
    //   638: aload_0
    //   639: astore #10
    //   641: aload #11
    //   643: ldc 'http execute encounter IOException - http code:'
    //   645: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload #12
    //   651: astore_3
    //   652: aload_1
    //   653: astore #8
    //   655: aload_2
    //   656: astore #9
    //   658: aload_0
    //   659: astore #10
    //   661: aload #11
    //   663: iload #4
    //   665: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload #12
    //   671: astore_3
    //   672: aload_1
    //   673: astore #8
    //   675: aload_2
    //   676: astore #9
    //   678: aload_0
    //   679: astore #10
    //   681: ldc 'PushHttpClient'
    //   683: aload #11
    //   685: invokevirtual toString : ()Ljava/lang/String;
    //   688: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)V
    //   691: aload_1
    //   692: invokestatic a : (Ljava/io/OutputStream;)V
    //   695: aload_2
    //   696: invokestatic a : (Ljava/io/InputStream;)V
    //   699: aload_0
    //   700: invokestatic a : (Ljava/io/InputStream;)V
    //   703: aload #12
    //   705: invokestatic a : (Ljava/net/HttpURLConnection;)V
    //   708: ldc 'PushHttpClient'
    //   710: ldc 'close connection'
    //   712: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   715: aconst_null
    //   716: areturn
    //   717: astore #11
    //   719: aload #9
    //   721: astore_2
    //   722: aload #8
    //   724: astore_1
    //   725: aload_3
    //   726: astore_0
    //   727: aload #11
    //   729: astore_3
    //   730: aload_1
    //   731: invokestatic a : (Ljava/io/OutputStream;)V
    //   734: aload_2
    //   735: invokestatic a : (Ljava/io/InputStream;)V
    //   738: aload #10
    //   740: invokestatic a : (Ljava/io/InputStream;)V
    //   743: aload_0
    //   744: invokestatic a : (Ljava/net/HttpURLConnection;)V
    //   747: ldc 'PushHttpClient'
    //   749: ldc 'close connection'
    //   751: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   754: aload_3
    //   755: athrow
    //   756: aconst_null
    //   757: areturn
    //   758: astore_0
    //   759: goto -> 852
    //   762: astore_0
    //   763: goto -> 836
    //   766: astore_0
    //   767: goto -> 425
    //   770: astore_1
    //   771: goto -> 408
    //   774: astore_1
    //   775: goto -> 405
    //   778: astore_1
    //   779: goto -> 402
    //   782: astore_2
    //   783: goto -> 381
    //   786: astore_2
    //   787: goto -> 372
    //   790: astore_2
    //   791: goto -> 360
    //   794: astore_3
    //   795: goto -> 340
    //   798: astore_3
    //   799: goto -> 330
    //   802: astore_3
    //   803: goto -> 320
    //   806: astore_3
    //   807: aload_0
    //   808: astore #12
    //   810: aload #11
    //   812: astore_0
    //   813: goto -> 608
    //   816: astore_3
    //   817: aload_0
    //   818: astore #12
    //   820: aload #11
    //   822: astore_0
    //   823: goto -> 522
    //   826: astore_3
    //   827: aload_0
    //   828: astore #12
    //   830: aload #11
    //   832: astore_0
    //   833: goto -> 436
    //   836: aconst_null
    //   837: astore_0
    //   838: aconst_null
    //   839: astore_1
    //   840: aconst_null
    //   841: astore_2
    //   842: aload_2
    //   843: astore_3
    //   844: aload_0
    //   845: astore #12
    //   847: aload_3
    //   848: astore_0
    //   849: goto -> 522
    //   852: aconst_null
    //   853: astore_0
    //   854: aconst_null
    //   855: astore_1
    //   856: aconst_null
    //   857: astore_2
    //   858: aload_2
    //   859: astore_3
    //   860: aload_0
    //   861: astore #12
    //   863: aload_3
    //   864: astore_0
    //   865: goto -> 608
    // Exception table:
    //   from	to	target	type
    //   23	36	758	java/io/IOException
    //   23	36	762	java/lang/RuntimeException
    //   23	36	766	java/lang/Exception
    //   23	36	411	finally
    //   65	77	770	java/io/IOException
    //   65	77	774	java/lang/RuntimeException
    //   65	77	778	java/lang/Exception
    //   65	77	390	finally
    //   89	99	782	java/io/IOException
    //   89	99	786	java/lang/RuntimeException
    //   89	99	790	java/lang/Exception
    //   89	99	350	finally
    //   111	115	782	java/io/IOException
    //   111	115	786	java/lang/RuntimeException
    //   111	115	790	java/lang/Exception
    //   111	115	350	finally
    //   127	133	782	java/io/IOException
    //   127	133	786	java/lang/RuntimeException
    //   127	133	790	java/lang/Exception
    //   127	133	350	finally
    //   145	153	782	java/io/IOException
    //   145	153	786	java/lang/RuntimeException
    //   145	153	790	java/lang/Exception
    //   145	153	350	finally
    //   165	172	782	java/io/IOException
    //   165	172	786	java/lang/RuntimeException
    //   165	172	790	java/lang/Exception
    //   165	172	350	finally
    //   184	191	782	java/io/IOException
    //   184	191	786	java/lang/RuntimeException
    //   184	191	790	java/lang/Exception
    //   184	191	350	finally
    //   203	212	782	java/io/IOException
    //   203	212	786	java/lang/RuntimeException
    //   203	212	790	java/lang/Exception
    //   203	212	350	finally
    //   232	237	782	java/io/IOException
    //   232	237	786	java/lang/RuntimeException
    //   232	237	790	java/lang/Exception
    //   232	237	350	finally
    //   252	257	782	java/io/IOException
    //   252	257	786	java/lang/RuntimeException
    //   252	257	790	java/lang/Exception
    //   252	257	350	finally
    //   257	267	794	java/io/IOException
    //   257	267	798	java/lang/RuntimeException
    //   257	267	802	java/lang/Exception
    //   257	267	313	finally
    //   279	286	806	java/io/IOException
    //   279	286	816	java/lang/RuntimeException
    //   279	286	826	java/lang/Exception
    //   279	286	717	finally
    //   448	457	717	finally
    //   469	477	717	finally
    //   489	497	717	finally
    //   509	519	717	finally
    //   534	543	717	finally
    //   555	563	717	finally
    //   575	583	717	finally
    //   595	605	717	finally
    //   620	629	717	finally
    //   641	649	717	finally
    //   661	669	717	finally
    //   681	691	717	finally
  }
  
  public static HttpURLConnection a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2) throws Exception {
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString1)).openConnection();
    a(paramContext, httpURLConnection);
    httpURLConnection.setRequestMethod(paramString2);
    httpURLConnection.setConnectTimeout(15000);
    httpURLConnection.setReadTimeout(15000);
    httpURLConnection.setDoOutput(true);
    httpURLConnection.setDoInput(true);
    httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
    httpURLConnection.setRequestProperty("Connection", "close");
    if (paramMap != null) {
      if (paramMap.size() < 1)
        return httpURLConnection; 
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        String str;
        paramString2 = (String)entry.getKey();
        if (paramString2 == null || TextUtils.isEmpty(paramString2))
          continue; 
        if (entry.getValue() == null) {
          str = "";
        } else {
          str = (String)str.getValue();
        } 
        httpURLConnection.setRequestProperty(paramString2, URLEncoder.encode(str, "UTF-8"));
      } 
    } 
    return httpURLConnection;
  }
  
  public static void a(Context paramContext, HttpURLConnection paramHttpURLConnection) throws Exception {
    if (paramHttpURLConnection instanceof HttpsURLConnection) {
      HttpURLConnection httpURLConnection;
      HttpsURLConnection httpsURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      paramHttpURLConnection = null;
      try {
        SecureSSLSocketFactory secureSSLSocketFactory = SecureSSLSocketFactory.a(paramContext);
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        HMSLog.w("PushHttpClient", "Get SocketFactory Algorithm Exception.");
        httpURLConnection = paramHttpURLConnection;
      } catch (KeyStoreException keyStoreException) {
        HMSLog.w("PushHttpClient", "Get SocketFactory Key Store exception.");
        httpURLConnection = paramHttpURLConnection;
      } catch (GeneralSecurityException generalSecurityException) {
        HMSLog.w("PushHttpClient", "Get SocketFactory General Security Exception.");
        httpURLConnection = paramHttpURLConnection;
      } catch (IOException iOException) {
        HMSLog.w("PushHttpClient", "Get SocketFactory IO Exception.");
        httpURLConnection = paramHttpURLConnection;
      } catch (IllegalAccessException illegalAccessException) {
        HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Access Exception.");
        httpURLConnection = paramHttpURLConnection;
      } catch (IllegalArgumentException illegalArgumentException) {
        HMSLog.w("PushHttpClient", "Get SocketFactory Illegal Argument Exception.");
        httpURLConnection = paramHttpURLConnection;
      } 
      if (httpURLConnection != null) {
        httpsURLConnection.setSSLSocketFactory((SSLSocketFactory)httpURLConnection);
        httpsURLConnection.setHostnameVerifier((HostnameVerifier)SecureSSLSocketFactory.b);
        return;
      } 
      throw new Exception("No ssl socket factory set.");
    } 
  }
  
  public enum a {
    a("GET"),
    b("POST");
    
    public String d;
    
    a(String param1String1) {
      this.d = param1String1;
    }
    
    public String a() {
      return this.d;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\opendevice\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */