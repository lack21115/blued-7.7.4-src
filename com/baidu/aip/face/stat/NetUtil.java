package com.baidu.aip.face.stat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;

public class NetUtil {
  private static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
      public boolean verify(String param1String, SSLSession param1SSLSession) {
        return true;
      }
    };
  
  private static final String TAG = "NetUtil";
  
  private NetUtil() {
    throw new RuntimeException("This class instance can not be created.");
  }
  
  public static boolean isConnected(Context paramContext) {
    if (paramContext == null)
      return false; 
    boolean bool = true;
    if (Build.VERSION.SDK_INT > 23) {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      bool = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(16);
    } 
    return bool;
  }
  
  private static void trustAllHosts() {
    X509TrustManager x509TrustManager = new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
        
        public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
        
        public X509Certificate[] getAcceptedIssuers() {
          return new X509Certificate[0];
        }
      };
    try {
      SSLContext sSLContext = SSLContext.getInstance("TLS");
      SecureRandom secureRandom = new SecureRandom();
      sSLContext.init(null, new TrustManager[] { x509TrustManager }, secureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static <T> void uploadData(RequestAdapter<T> paramRequestAdapter) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getRetryCount : ()I
    //   4: istore_1
    //   5: aconst_null
    //   6: astore #6
    //   8: aconst_null
    //   9: astore #4
    //   11: aload #4
    //   13: astore_3
    //   14: iconst_0
    //   15: istore_2
    //   16: new java/net/URL
    //   19: dup
    //   20: aload_0
    //   21: invokevirtual getURL : ()Ljava/lang/String;
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: astore #5
    //   29: invokestatic trustAllHosts : ()V
    //   32: aload #5
    //   34: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   37: checkcast java/net/HttpURLConnection
    //   40: astore #5
    //   42: aload #4
    //   44: astore #13
    //   46: aload_3
    //   47: astore #9
    //   49: aload #4
    //   51: astore #14
    //   53: aload_3
    //   54: astore #10
    //   56: aload #4
    //   58: astore #15
    //   60: aload_3
    //   61: astore #11
    //   63: aload #4
    //   65: astore #16
    //   67: aload_3
    //   68: astore #12
    //   70: aload #4
    //   72: astore #6
    //   74: aload_3
    //   75: astore #7
    //   77: aload #5
    //   79: astore #8
    //   81: aload #5
    //   83: aload_0
    //   84: invokevirtual getConnectTimeout : ()I
    //   87: invokevirtual setConnectTimeout : (I)V
    //   90: aload #4
    //   92: astore #13
    //   94: aload_3
    //   95: astore #9
    //   97: aload #4
    //   99: astore #14
    //   101: aload_3
    //   102: astore #10
    //   104: aload #4
    //   106: astore #15
    //   108: aload_3
    //   109: astore #11
    //   111: aload #4
    //   113: astore #16
    //   115: aload_3
    //   116: astore #12
    //   118: aload #4
    //   120: astore #6
    //   122: aload_3
    //   123: astore #7
    //   125: aload #5
    //   127: astore #8
    //   129: aload #5
    //   131: iconst_1
    //   132: invokevirtual setDoInput : (Z)V
    //   135: aload #4
    //   137: astore #13
    //   139: aload_3
    //   140: astore #9
    //   142: aload #4
    //   144: astore #14
    //   146: aload_3
    //   147: astore #10
    //   149: aload #4
    //   151: astore #15
    //   153: aload_3
    //   154: astore #11
    //   156: aload #4
    //   158: astore #16
    //   160: aload_3
    //   161: astore #12
    //   163: aload #4
    //   165: astore #6
    //   167: aload_3
    //   168: astore #7
    //   170: aload #5
    //   172: astore #8
    //   174: aload #5
    //   176: iconst_1
    //   177: invokevirtual setDoOutput : (Z)V
    //   180: aload #4
    //   182: astore #13
    //   184: aload_3
    //   185: astore #9
    //   187: aload #4
    //   189: astore #14
    //   191: aload_3
    //   192: astore #10
    //   194: aload #4
    //   196: astore #15
    //   198: aload_3
    //   199: astore #11
    //   201: aload #4
    //   203: astore #16
    //   205: aload_3
    //   206: astore #12
    //   208: aload #4
    //   210: astore #6
    //   212: aload_3
    //   213: astore #7
    //   215: aload #5
    //   217: astore #8
    //   219: aload #5
    //   221: ldc 'Content-Type'
    //   223: ldc 'application/json'
    //   225: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload #4
    //   230: astore #13
    //   232: aload_3
    //   233: astore #9
    //   235: aload #4
    //   237: astore #14
    //   239: aload_3
    //   240: astore #10
    //   242: aload #4
    //   244: astore #15
    //   246: aload_3
    //   247: astore #11
    //   249: aload #4
    //   251: astore #16
    //   253: aload_3
    //   254: astore #12
    //   256: aload #4
    //   258: astore #6
    //   260: aload_3
    //   261: astore #7
    //   263: aload #5
    //   265: astore #8
    //   267: aload #5
    //   269: aload_0
    //   270: invokevirtual getReadTimeout : ()I
    //   273: invokevirtual setReadTimeout : (I)V
    //   276: aload #4
    //   278: astore #13
    //   280: aload_3
    //   281: astore #9
    //   283: aload #4
    //   285: astore #14
    //   287: aload_3
    //   288: astore #10
    //   290: aload #4
    //   292: astore #15
    //   294: aload_3
    //   295: astore #11
    //   297: aload #4
    //   299: astore #16
    //   301: aload_3
    //   302: astore #12
    //   304: aload #4
    //   306: astore #6
    //   308: aload_3
    //   309: astore #7
    //   311: aload #5
    //   313: astore #8
    //   315: aload #5
    //   317: aload_0
    //   318: invokevirtual getRequestMethod : ()Ljava/lang/String;
    //   321: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   324: aload #4
    //   326: astore #13
    //   328: aload_3
    //   329: astore #9
    //   331: aload #4
    //   333: astore #14
    //   335: aload_3
    //   336: astore #10
    //   338: aload #4
    //   340: astore #15
    //   342: aload_3
    //   343: astore #11
    //   345: aload #4
    //   347: astore #16
    //   349: aload_3
    //   350: astore #12
    //   352: aload #4
    //   354: astore #6
    //   356: aload_3
    //   357: astore #7
    //   359: aload #5
    //   361: astore #8
    //   363: aload #5
    //   365: iconst_0
    //   366: invokevirtual setUseCaches : (Z)V
    //   369: aload #4
    //   371: astore #13
    //   373: aload_3
    //   374: astore #9
    //   376: aload #4
    //   378: astore #14
    //   380: aload_3
    //   381: astore #10
    //   383: aload #4
    //   385: astore #15
    //   387: aload_3
    //   388: astore #11
    //   390: aload #4
    //   392: astore #16
    //   394: aload_3
    //   395: astore #12
    //   397: aload #4
    //   399: astore #6
    //   401: aload_3
    //   402: astore #7
    //   404: aload #5
    //   406: astore #8
    //   408: aload #5
    //   410: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   413: astore #4
    //   415: aload #4
    //   417: astore #13
    //   419: aload_3
    //   420: astore #9
    //   422: aload #4
    //   424: astore #14
    //   426: aload_3
    //   427: astore #10
    //   429: aload #4
    //   431: astore #15
    //   433: aload_3
    //   434: astore #11
    //   436: aload #4
    //   438: astore #16
    //   440: aload_3
    //   441: astore #12
    //   443: aload #4
    //   445: astore #6
    //   447: aload_3
    //   448: astore #7
    //   450: aload #5
    //   452: astore #8
    //   454: aload #4
    //   456: aload_0
    //   457: invokevirtual getRequestString : ()Ljava/lang/String;
    //   460: ldc 'UTF-8'
    //   462: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   465: invokevirtual write : ([B)V
    //   468: aload #4
    //   470: astore #13
    //   472: aload_3
    //   473: astore #9
    //   475: aload #4
    //   477: astore #14
    //   479: aload_3
    //   480: astore #10
    //   482: aload #4
    //   484: astore #15
    //   486: aload_3
    //   487: astore #11
    //   489: aload #4
    //   491: astore #16
    //   493: aload_3
    //   494: astore #12
    //   496: aload #4
    //   498: astore #6
    //   500: aload_3
    //   501: astore #7
    //   503: aload #5
    //   505: astore #8
    //   507: aload #4
    //   509: invokevirtual flush : ()V
    //   512: aload #4
    //   514: astore #13
    //   516: aload_3
    //   517: astore #9
    //   519: aload #4
    //   521: astore #14
    //   523: aload_3
    //   524: astore #10
    //   526: aload #4
    //   528: astore #15
    //   530: aload_3
    //   531: astore #11
    //   533: aload #4
    //   535: astore #16
    //   537: aload_3
    //   538: astore #12
    //   540: aload #4
    //   542: astore #6
    //   544: aload_3
    //   545: astore #7
    //   547: aload #5
    //   549: astore #8
    //   551: aload #5
    //   553: invokevirtual getResponseCode : ()I
    //   556: sipush #200
    //   559: if_icmpeq -> 765
    //   562: aload #4
    //   564: astore #13
    //   566: aload_3
    //   567: astore #9
    //   569: aload #4
    //   571: astore #14
    //   573: aload_3
    //   574: astore #10
    //   576: aload #4
    //   578: astore #15
    //   580: aload_3
    //   581: astore #11
    //   583: aload #4
    //   585: astore #16
    //   587: aload_3
    //   588: astore #12
    //   590: aload #4
    //   592: astore #6
    //   594: aload_3
    //   595: astore #7
    //   597: aload #5
    //   599: astore #8
    //   601: new java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial <init> : ()V
    //   608: astore #17
    //   610: aload #4
    //   612: astore #13
    //   614: aload_3
    //   615: astore #9
    //   617: aload #4
    //   619: astore #14
    //   621: aload_3
    //   622: astore #10
    //   624: aload #4
    //   626: astore #15
    //   628: aload_3
    //   629: astore #11
    //   631: aload #4
    //   633: astore #16
    //   635: aload_3
    //   636: astore #12
    //   638: aload #4
    //   640: astore #6
    //   642: aload_3
    //   643: astore #7
    //   645: aload #5
    //   647: astore #8
    //   649: aload #17
    //   651: ldc 'ResponseCode: '
    //   653: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload #4
    //   659: astore #13
    //   661: aload_3
    //   662: astore #9
    //   664: aload #4
    //   666: astore #14
    //   668: aload_3
    //   669: astore #10
    //   671: aload #4
    //   673: astore #15
    //   675: aload_3
    //   676: astore #11
    //   678: aload #4
    //   680: astore #16
    //   682: aload_3
    //   683: astore #12
    //   685: aload #4
    //   687: astore #6
    //   689: aload_3
    //   690: astore #7
    //   692: aload #5
    //   694: astore #8
    //   696: aload #17
    //   698: aload #5
    //   700: invokevirtual getResponseCode : ()I
    //   703: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload #4
    //   709: astore #13
    //   711: aload_3
    //   712: astore #9
    //   714: aload #4
    //   716: astore #14
    //   718: aload_3
    //   719: astore #10
    //   721: aload #4
    //   723: astore #15
    //   725: aload_3
    //   726: astore #11
    //   728: aload #4
    //   730: astore #16
    //   732: aload_3
    //   733: astore #12
    //   735: aload #4
    //   737: astore #6
    //   739: aload_3
    //   740: astore #7
    //   742: aload #5
    //   744: astore #8
    //   746: new java/lang/IllegalStateException
    //   749: dup
    //   750: aload #17
    //   752: invokevirtual toString : ()Ljava/lang/String;
    //   755: invokespecial <init> : (Ljava/lang/String;)V
    //   758: pop
    //   759: aload_3
    //   760: astore #8
    //   762: goto -> 857
    //   765: aload #4
    //   767: astore #13
    //   769: aload_3
    //   770: astore #9
    //   772: aload #4
    //   774: astore #14
    //   776: aload_3
    //   777: astore #10
    //   779: aload #4
    //   781: astore #15
    //   783: aload_3
    //   784: astore #11
    //   786: aload #4
    //   788: astore #16
    //   790: aload_3
    //   791: astore #12
    //   793: aload #4
    //   795: astore #6
    //   797: aload_3
    //   798: astore #7
    //   800: aload #5
    //   802: astore #8
    //   804: aload #5
    //   806: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   809: astore_3
    //   810: aload #4
    //   812: astore #13
    //   814: aload_3
    //   815: astore #9
    //   817: aload #4
    //   819: astore #14
    //   821: aload_3
    //   822: astore #10
    //   824: aload #4
    //   826: astore #15
    //   828: aload_3
    //   829: astore #11
    //   831: aload #4
    //   833: astore #16
    //   835: aload_3
    //   836: astore #12
    //   838: aload #4
    //   840: astore #6
    //   842: aload_3
    //   843: astore #7
    //   845: aload #5
    //   847: astore #8
    //   849: aload_0
    //   850: aload_3
    //   851: invokevirtual parseResponse : (Ljava/io/InputStream;)V
    //   854: aload_3
    //   855: astore #8
    //   857: aload #4
    //   859: ifnull -> 870
    //   862: aload #4
    //   864: invokevirtual close : ()V
    //   867: goto -> 870
    //   870: aload #8
    //   872: ifnull -> 883
    //   875: aload #8
    //   877: invokevirtual close : ()V
    //   880: goto -> 883
    //   883: aload #4
    //   885: astore #7
    //   887: aload #8
    //   889: astore_3
    //   890: aload #5
    //   892: astore #6
    //   894: aload #5
    //   896: ifnull -> 1207
    //   899: aload #8
    //   901: astore_3
    //   902: goto -> 1194
    //   905: astore_3
    //   906: aload #13
    //   908: astore #4
    //   910: goto -> 973
    //   913: astore_3
    //   914: aload #14
    //   916: astore #4
    //   918: aload #10
    //   920: astore #9
    //   922: goto -> 1053
    //   925: astore_3
    //   926: aload #15
    //   928: astore #4
    //   930: aload #11
    //   932: astore #9
    //   934: goto -> 1133
    //   937: astore #9
    //   939: aload #16
    //   941: astore #4
    //   943: aload #12
    //   945: astore_3
    //   946: goto -> 1220
    //   949: astore_0
    //   950: aload #6
    //   952: astore #8
    //   954: goto -> 1301
    //   957: astore #7
    //   959: aload #6
    //   961: astore #5
    //   963: aload #7
    //   965: astore #6
    //   967: aload_3
    //   968: astore #9
    //   970: aload #6
    //   972: astore_3
    //   973: aload #4
    //   975: astore #6
    //   977: aload #9
    //   979: astore #7
    //   981: aload #5
    //   983: astore #8
    //   985: aload_3
    //   986: invokevirtual printStackTrace : ()V
    //   989: aload #4
    //   991: ifnull -> 1002
    //   994: aload #4
    //   996: invokevirtual close : ()V
    //   999: goto -> 1002
    //   1002: aload #9
    //   1004: ifnull -> 1015
    //   1007: aload #9
    //   1009: invokevirtual close : ()V
    //   1012: goto -> 1015
    //   1015: aload #4
    //   1017: astore #7
    //   1019: aload #9
    //   1021: astore_3
    //   1022: aload #5
    //   1024: astore #6
    //   1026: aload #5
    //   1028: ifnull -> 1207
    //   1031: aload #9
    //   1033: astore_3
    //   1034: goto -> 1194
    //   1037: astore #7
    //   1039: aload #6
    //   1041: astore #5
    //   1043: aload #7
    //   1045: astore #6
    //   1047: aload_3
    //   1048: astore #9
    //   1050: aload #6
    //   1052: astore_3
    //   1053: aload #4
    //   1055: astore #6
    //   1057: aload #9
    //   1059: astore #7
    //   1061: aload #5
    //   1063: astore #8
    //   1065: aload_3
    //   1066: invokevirtual printStackTrace : ()V
    //   1069: aload #4
    //   1071: ifnull -> 1082
    //   1074: aload #4
    //   1076: invokevirtual close : ()V
    //   1079: goto -> 1082
    //   1082: aload #9
    //   1084: ifnull -> 1095
    //   1087: aload #9
    //   1089: invokevirtual close : ()V
    //   1092: goto -> 1095
    //   1095: aload #4
    //   1097: astore #7
    //   1099: aload #9
    //   1101: astore_3
    //   1102: aload #5
    //   1104: astore #6
    //   1106: aload #5
    //   1108: ifnull -> 1207
    //   1111: aload #9
    //   1113: astore_3
    //   1114: goto -> 1194
    //   1117: astore #7
    //   1119: aload #6
    //   1121: astore #5
    //   1123: aload #7
    //   1125: astore #6
    //   1127: aload_3
    //   1128: astore #9
    //   1130: aload #6
    //   1132: astore_3
    //   1133: aload #4
    //   1135: astore #6
    //   1137: aload #9
    //   1139: astore #7
    //   1141: aload #5
    //   1143: astore #8
    //   1145: aload_3
    //   1146: invokevirtual printStackTrace : ()V
    //   1149: aload #4
    //   1151: ifnull -> 1162
    //   1154: aload #4
    //   1156: invokevirtual close : ()V
    //   1159: goto -> 1162
    //   1162: aload #9
    //   1164: ifnull -> 1175
    //   1167: aload #9
    //   1169: invokevirtual close : ()V
    //   1172: goto -> 1175
    //   1175: aload #4
    //   1177: astore #7
    //   1179: aload #9
    //   1181: astore_3
    //   1182: aload #5
    //   1184: astore #6
    //   1186: aload #5
    //   1188: ifnull -> 1207
    //   1191: aload #9
    //   1193: astore_3
    //   1194: aload #5
    //   1196: invokevirtual disconnect : ()V
    //   1199: aload #5
    //   1201: astore #6
    //   1203: aload #4
    //   1205: astore #7
    //   1207: aload #7
    //   1209: astore #4
    //   1211: goto -> 1276
    //   1214: astore #9
    //   1216: aload #6
    //   1218: astore #5
    //   1220: aload #4
    //   1222: astore #6
    //   1224: aload_3
    //   1225: astore #7
    //   1227: aload #5
    //   1229: astore #8
    //   1231: aload #9
    //   1233: invokevirtual printStackTrace : ()V
    //   1236: aload #4
    //   1238: ifnull -> 1249
    //   1241: aload #4
    //   1243: invokevirtual close : ()V
    //   1246: goto -> 1249
    //   1249: aload_3
    //   1250: ifnull -> 1260
    //   1253: aload_3
    //   1254: invokevirtual close : ()V
    //   1257: goto -> 1260
    //   1260: aload #5
    //   1262: ifnull -> 1270
    //   1265: aload #5
    //   1267: invokevirtual disconnect : ()V
    //   1270: iconst_1
    //   1271: istore_2
    //   1272: aload #5
    //   1274: astore #6
    //   1276: iload_2
    //   1277: ifeq -> 1292
    //   1280: iload_1
    //   1281: ifgt -> 1285
    //   1284: return
    //   1285: iload_1
    //   1286: iconst_1
    //   1287: isub
    //   1288: istore_1
    //   1289: goto -> 14
    //   1292: return
    //   1293: astore_0
    //   1294: aload #7
    //   1296: astore_3
    //   1297: aload #6
    //   1299: astore #4
    //   1301: aload #4
    //   1303: ifnull -> 1314
    //   1306: aload #4
    //   1308: invokevirtual close : ()V
    //   1311: goto -> 1314
    //   1314: aload_3
    //   1315: ifnull -> 1325
    //   1318: aload_3
    //   1319: invokevirtual close : ()V
    //   1322: goto -> 1325
    //   1325: aload #8
    //   1327: ifnull -> 1335
    //   1330: aload #8
    //   1332: invokevirtual disconnect : ()V
    //   1335: aload_0
    //   1336: athrow
    //   1337: astore_3
    //   1338: goto -> 870
    //   1341: astore_3
    //   1342: goto -> 883
    //   1345: astore_3
    //   1346: goto -> 1002
    //   1349: astore_3
    //   1350: goto -> 1015
    //   1353: astore_3
    //   1354: goto -> 1082
    //   1357: astore_3
    //   1358: goto -> 1095
    //   1361: astore_3
    //   1362: goto -> 1162
    //   1365: astore_3
    //   1366: goto -> 1175
    //   1369: astore #6
    //   1371: goto -> 1249
    //   1374: astore #6
    //   1376: goto -> 1260
    //   1379: astore #4
    //   1381: goto -> 1314
    //   1384: astore_3
    //   1385: goto -> 1325
    // Exception table:
    //   from	to	target	type
    //   16	42	1214	java/net/SocketTimeoutException
    //   16	42	1117	java/io/IOException
    //   16	42	1037	org/json/JSONException
    //   16	42	957	java/lang/Exception
    //   16	42	949	finally
    //   81	90	937	java/net/SocketTimeoutException
    //   81	90	925	java/io/IOException
    //   81	90	913	org/json/JSONException
    //   81	90	905	java/lang/Exception
    //   81	90	1293	finally
    //   129	135	937	java/net/SocketTimeoutException
    //   129	135	925	java/io/IOException
    //   129	135	913	org/json/JSONException
    //   129	135	905	java/lang/Exception
    //   129	135	1293	finally
    //   174	180	937	java/net/SocketTimeoutException
    //   174	180	925	java/io/IOException
    //   174	180	913	org/json/JSONException
    //   174	180	905	java/lang/Exception
    //   174	180	1293	finally
    //   219	228	937	java/net/SocketTimeoutException
    //   219	228	925	java/io/IOException
    //   219	228	913	org/json/JSONException
    //   219	228	905	java/lang/Exception
    //   219	228	1293	finally
    //   267	276	937	java/net/SocketTimeoutException
    //   267	276	925	java/io/IOException
    //   267	276	913	org/json/JSONException
    //   267	276	905	java/lang/Exception
    //   267	276	1293	finally
    //   315	324	937	java/net/SocketTimeoutException
    //   315	324	925	java/io/IOException
    //   315	324	913	org/json/JSONException
    //   315	324	905	java/lang/Exception
    //   315	324	1293	finally
    //   363	369	937	java/net/SocketTimeoutException
    //   363	369	925	java/io/IOException
    //   363	369	913	org/json/JSONException
    //   363	369	905	java/lang/Exception
    //   363	369	1293	finally
    //   408	415	937	java/net/SocketTimeoutException
    //   408	415	925	java/io/IOException
    //   408	415	913	org/json/JSONException
    //   408	415	905	java/lang/Exception
    //   408	415	1293	finally
    //   454	468	937	java/net/SocketTimeoutException
    //   454	468	925	java/io/IOException
    //   454	468	913	org/json/JSONException
    //   454	468	905	java/lang/Exception
    //   454	468	1293	finally
    //   507	512	937	java/net/SocketTimeoutException
    //   507	512	925	java/io/IOException
    //   507	512	913	org/json/JSONException
    //   507	512	905	java/lang/Exception
    //   507	512	1293	finally
    //   551	562	937	java/net/SocketTimeoutException
    //   551	562	925	java/io/IOException
    //   551	562	913	org/json/JSONException
    //   551	562	905	java/lang/Exception
    //   551	562	1293	finally
    //   601	610	937	java/net/SocketTimeoutException
    //   601	610	925	java/io/IOException
    //   601	610	913	org/json/JSONException
    //   601	610	905	java/lang/Exception
    //   601	610	1293	finally
    //   649	657	937	java/net/SocketTimeoutException
    //   649	657	925	java/io/IOException
    //   649	657	913	org/json/JSONException
    //   649	657	905	java/lang/Exception
    //   649	657	1293	finally
    //   696	707	937	java/net/SocketTimeoutException
    //   696	707	925	java/io/IOException
    //   696	707	913	org/json/JSONException
    //   696	707	905	java/lang/Exception
    //   696	707	1293	finally
    //   746	759	937	java/net/SocketTimeoutException
    //   746	759	925	java/io/IOException
    //   746	759	913	org/json/JSONException
    //   746	759	905	java/lang/Exception
    //   746	759	1293	finally
    //   804	810	937	java/net/SocketTimeoutException
    //   804	810	925	java/io/IOException
    //   804	810	913	org/json/JSONException
    //   804	810	905	java/lang/Exception
    //   804	810	1293	finally
    //   849	854	937	java/net/SocketTimeoutException
    //   849	854	925	java/io/IOException
    //   849	854	913	org/json/JSONException
    //   849	854	905	java/lang/Exception
    //   849	854	1293	finally
    //   862	867	1337	java/io/IOException
    //   875	880	1341	java/io/IOException
    //   985	989	1293	finally
    //   994	999	1345	java/io/IOException
    //   1007	1012	1349	java/io/IOException
    //   1065	1069	1293	finally
    //   1074	1079	1353	java/io/IOException
    //   1087	1092	1357	java/io/IOException
    //   1145	1149	1293	finally
    //   1154	1159	1361	java/io/IOException
    //   1167	1172	1365	java/io/IOException
    //   1231	1236	1293	finally
    //   1241	1246	1369	java/io/IOException
    //   1253	1257	1374	java/io/IOException
    //   1306	1311	1379	java/io/IOException
    //   1318	1322	1384	java/io/IOException
  }
  
  public static abstract class RequestAdapter<T> {
    private static final int CONNECT_TIMEOUT = 5000;
    
    private static final int READ_TIMEOUT = 5000;
    
    private static final String REQUEST_METHOD = "POST";
    
    public static final int RESPONSE_STATUS_ERROR_IO = 2;
    
    public static final int RESPONSE_STATUS_ERROR_PARSE_JSON = 3;
    
    public static final int RESPONSE_STATUS_ERROR_RESPONSE_CODE = 4;
    
    public static final int RESPONSE_STATUS_ERROR_TIMEOUT = 1;
    
    public static final int RESPONSE_STATUS_ERROR_UNKNOWN = 5;
    
    public static final int RESPONSE_STATUS_NORMAL = 0;
    
    private static final int RETRY_COUNT = 2;
    
    public int getConnectTimeout() {
      return 5000;
    }
    
    public int getReadTimeout() {
      return 5000;
    }
    
    public String getRequestMethod() {
      return "POST";
    }
    
    public abstract String getRequestString();
    
    public int getRetryCount() {
      return 0;
    }
    
    public abstract String getURL();
    
    public abstract void parseResponse(InputStream param1InputStream) throws IOException, JSONException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\stat\NetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */