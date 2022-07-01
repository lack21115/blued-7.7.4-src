package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class LogReport {
  private static final int CONNECTION_TIMEOUT = 25000;
  
  private static final String PRIVATE_CODE = "dqwef1864il4c9m6";
  
  private static final int SOCKET_TIMEOUT = 20000;
  
  private static String UPLOADTIME = "uploadtime";
  
  private static String mAid;
  
  private static String mAppkey;
  
  private static String mBaseUrl = "https://api.weibo.com/2/proxy/sdk/statistic.json";
  
  private static String mChannel;
  
  private static String mKeyHash;
  
  public static LogReport mLogReport;
  
  private static String mPackageName;
  
  private static JSONObject mParams;
  
  private static String mVersionName;
  
  public LogReport(Context paramContext) {
    try {
      if (mPackageName == null)
        mPackageName = paramContext.getPackageName(); 
      mAppkey = StatisticConfig.getAppkey(paramContext);
      checkAid(paramContext);
      mKeyHash = Utility.getSign(paramContext, mPackageName);
      mVersionName = LogBuilder.getVersion(paramContext);
      mChannel = StatisticConfig.getChannel(paramContext);
    } catch (Exception exception) {
      LogUtil.e("WBAgent", exception.toString());
    } 
    initCommonParams();
  }
  
  private static void checkAid(Context paramContext) {
    if (TextUtils.isEmpty(mAid))
      mAid = Utility.getAid(paramContext, mAppkey); 
    if (mParams == null)
      mParams = new JSONObject(); 
    try {
      mParams.put("aid", mAid);
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  private static HttpPost getNewHttpPost(String paramString, JSONObject paramJSONObject) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/statistic/LogReport
    //   2: monitorenter
    //   3: new org/apache/http/client/methods/HttpPost
    //   6: dup
    //   7: aload_0
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 'Content-Type'
    //   15: ldc 'application/x-www-form-urlencoded'
    //   17: invokevirtual setHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_1
    //   21: ldc 'Connection'
    //   23: ldc 'Keep-Alive'
    //   25: invokevirtual setHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   28: invokestatic isNeedGizp : ()Z
    //   31: ifeq -> 82
    //   34: ldc 'gzip'
    //   36: astore_0
    //   37: goto -> 40
    //   40: aload_1
    //   41: ldc 'Content-Encoding'
    //   43: aload_0
    //   44: invokevirtual addHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_1
    //   48: ldc 'Accept'
    //   50: ldc '*/*'
    //   52: invokevirtual addHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_1
    //   56: ldc 'Accept-Language'
    //   58: ldc 'en-us'
    //   60: invokevirtual addHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_1
    //   64: ldc 'Accept-Encoding'
    //   66: ldc 'gzip'
    //   68: invokevirtual addHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   71: ldc com/sina/weibo/sdk/statistic/LogReport
    //   73: monitorexit
    //   74: aload_1
    //   75: areturn
    //   76: astore_0
    //   77: ldc com/sina/weibo/sdk/statistic/LogReport
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    //   82: ldc 'charset=UTF-8'
    //   84: astore_0
    //   85: goto -> 40
    // Exception table:
    //   from	to	target	type
    //   3	34	76	finally
    //   40	71	76	finally
  }
  
  public static String getPackageName() {
    return mPackageName;
  }
  
  private static String getSign(String paramString1, String paramString2, long paramLong) {
    StringBuilder stringBuilder3 = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1))
      stringBuilder3.append(paramString1); 
    stringBuilder3.append(paramString2);
    stringBuilder3.append("dqwef1864il4c9m6");
    stringBuilder3.append(paramLong);
    paramString1 = MD5.hexdigest(stringBuilder3.toString());
    paramString1 = paramString1.substring(paramString1.length() - 6);
    StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(paramString1));
    stringBuilder2.append(paramString1.substring(0, 4));
    String str = MD5.hexdigest(stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(paramString1));
    stringBuilder1.append(str.substring(str.length() - 1));
    return stringBuilder1.toString();
  }
  
  public static long getTime(Context paramContext) {
    return paramContext.getSharedPreferences(UPLOADTIME, 0).getLong("lasttime", 0L);
  }
  
  private static byte[] gzipLogs(String paramString) {
    if (paramString == null || paramString.length() == 0)
      return null; 
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byte[] arrayOfByte = paramString.getBytes("utf-8");
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
      gZIPOutputStream.write(arrayOfByte);
      gZIPOutputStream.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return byteArrayOutputStream.toByteArray();
  }
  
  private static JSONObject initCommonParams() {
    if (mParams == null)
      mParams = new JSONObject(); 
    try {
      mParams.put("appkey", mAppkey);
      mParams.put("platform", "Android");
      mParams.put("packagename", mPackageName);
      mParams.put("key_hash", mKeyHash);
      mParams.put("version", mVersionName);
      mParams.put("channel", mChannel);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return mParams;
  }
  
  private static boolean isNetworkConnected(Context paramContext) {
    NetworkInfo networkInfo;
    if (paramContext == null) {
      LogUtil.e("WBAgent", "unexpected null context in isNetworkConnected");
      return false;
    } 
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
      return false; 
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = null;
    try {
      NetworkInfo networkInfo1 = connectivityManager.getActiveNetworkInfo();
      networkInfo = networkInfo1;
    } catch (NullPointerException nullPointerException) {}
    return (networkInfo != null) ? (!!networkInfo.isAvailable()) : false;
  }
  
  private static HttpResponse requestHttpExecute(String paramString1, String paramString2, JSONObject paramJSONObject, JSONArray paramJSONArray) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #12
    //   3: aconst_null
    //   4: astore #13
    //   6: aconst_null
    //   7: astore #7
    //   9: aconst_null
    //   10: astore #8
    //   12: aconst_null
    //   13: astore #9
    //   15: aconst_null
    //   16: astore #14
    //   18: aconst_null
    //   19: astore #6
    //   21: aconst_null
    //   22: astore #11
    //   24: invokestatic getNewHttpClient : ()Lorg/apache/http/client/HttpClient;
    //   27: astore #5
    //   29: aload_2
    //   30: astore #10
    //   32: aload_2
    //   33: ifnonnull -> 78
    //   36: aload #14
    //   38: astore_2
    //   39: aload #5
    //   41: astore #6
    //   43: invokestatic initCommonParams : ()Lorg/json/JSONObject;
    //   46: astore #10
    //   48: goto -> 78
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_0
    //   54: aload #7
    //   56: astore_1
    //   57: goto -> 840
    //   60: astore_3
    //   61: aconst_null
    //   62: astore_0
    //   63: aload #8
    //   65: astore_1
    //   66: goto -> 865
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_0
    //   72: aload #9
    //   74: astore_1
    //   75: goto -> 890
    //   78: aload #14
    //   80: astore_2
    //   81: aload #5
    //   83: astore #6
    //   85: aload #10
    //   87: ldc_w 'time'
    //   90: invokestatic currentTimeMillis : ()J
    //   93: ldc2_w 1000
    //   96: ldiv
    //   97: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   100: pop
    //   101: aload #14
    //   103: astore_2
    //   104: aload #5
    //   106: astore #6
    //   108: aload #10
    //   110: ldc_w 'length'
    //   113: aload_3
    //   114: invokevirtual length : ()I
    //   117: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload #14
    //   123: astore_2
    //   124: aload #5
    //   126: astore #6
    //   128: aload #10
    //   130: ldc_w 'sign'
    //   133: aload #10
    //   135: ldc 'aid'
    //   137: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   140: aload #10
    //   142: ldc 'appkey'
    //   144: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   147: aload #10
    //   149: ldc_w 'time'
    //   152: invokevirtual getLong : (Ljava/lang/String;)J
    //   155: invokestatic getSign : (Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   158: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload #14
    //   164: astore_2
    //   165: aload #5
    //   167: astore #6
    //   169: aload #10
    //   171: ldc_w 'content'
    //   174: aload_3
    //   175: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: aload #14
    //   181: astore_2
    //   182: aload #5
    //   184: astore #6
    //   186: new java/lang/StringBuilder
    //   189: dup
    //   190: ldc_w 'post content--- '
    //   193: invokespecial <init> : (Ljava/lang/String;)V
    //   196: astore_3
    //   197: aload #14
    //   199: astore_2
    //   200: aload #5
    //   202: astore #6
    //   204: aload_3
    //   205: aload #10
    //   207: invokevirtual toString : ()Ljava/lang/String;
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload #14
    //   216: astore_2
    //   217: aload #5
    //   219: astore #6
    //   221: ldc 'WBAgent'
    //   223: aload_3
    //   224: invokevirtual toString : ()Ljava/lang/String;
    //   227: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   230: goto -> 245
    //   233: astore_3
    //   234: aload #14
    //   236: astore_2
    //   237: aload #5
    //   239: astore #6
    //   241: aload_3
    //   242: invokevirtual printStackTrace : ()V
    //   245: aload #14
    //   247: astore_2
    //   248: aload #5
    //   250: astore #6
    //   252: aload_1
    //   253: ldc_w 'GET'
    //   256: invokevirtual equals : (Ljava/lang/Object;)Z
    //   259: istore #4
    //   261: iload #4
    //   263: ifeq -> 342
    //   266: aload #14
    //   268: astore_2
    //   269: aload #5
    //   271: astore #6
    //   273: new java/lang/StringBuilder
    //   276: dup
    //   277: aload_0
    //   278: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   281: invokespecial <init> : (Ljava/lang/String;)V
    //   284: astore_0
    //   285: aload #14
    //   287: astore_2
    //   288: aload #5
    //   290: astore #6
    //   292: aload_0
    //   293: ldc_w '?'
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload #14
    //   302: astore_2
    //   303: aload #5
    //   305: astore #6
    //   307: aload_0
    //   308: aload #10
    //   310: invokevirtual toString : ()Ljava/lang/String;
    //   313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload #14
    //   319: astore_2
    //   320: aload #5
    //   322: astore #6
    //   324: new org/apache/http/client/methods/HttpGet
    //   327: dup
    //   328: aload_0
    //   329: invokevirtual toString : ()Ljava/lang/String;
    //   332: invokespecial <init> : (Ljava/lang/String;)V
    //   335: astore #10
    //   337: aconst_null
    //   338: astore_0
    //   339: goto -> 634
    //   342: aload #14
    //   344: astore_2
    //   345: aload #5
    //   347: astore #6
    //   349: aload_1
    //   350: ldc_w 'POST'
    //   353: invokevirtual equals : (Ljava/lang/Object;)Z
    //   356: ifeq -> 958
    //   359: aload #14
    //   361: astore_2
    //   362: aload #5
    //   364: astore #6
    //   366: getstatic com/sina/weibo/sdk/statistic/LogReport.mAppkey : Ljava/lang/String;
    //   369: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   372: ifeq -> 397
    //   375: aload #14
    //   377: astore_2
    //   378: aload #5
    //   380: astore #6
    //   382: ldc 'WBAgent'
    //   384: ldc_w 'unexpected null AppKey'
    //   387: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload #5
    //   392: invokestatic shutdownHttpClient : (Lorg/apache/http/client/HttpClient;)V
    //   395: aconst_null
    //   396: areturn
    //   397: aload #14
    //   399: astore_2
    //   400: aload #5
    //   402: astore #6
    //   404: new java/lang/StringBuilder
    //   407: dup
    //   408: aload_0
    //   409: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   412: invokespecial <init> : (Ljava/lang/String;)V
    //   415: astore_0
    //   416: aload #14
    //   418: astore_2
    //   419: aload #5
    //   421: astore #6
    //   423: aload_0
    //   424: ldc_w '?'
    //   427: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload #14
    //   433: astore_2
    //   434: aload #5
    //   436: astore #6
    //   438: aload_0
    //   439: ldc_w 'source='
    //   442: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload #14
    //   448: astore_2
    //   449: aload #5
    //   451: astore #6
    //   453: aload_0
    //   454: getstatic com/sina/weibo/sdk/statistic/LogReport.mAppkey : Ljava/lang/String;
    //   457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload #14
    //   463: astore_2
    //   464: aload #5
    //   466: astore #6
    //   468: aload_0
    //   469: invokevirtual toString : ()Ljava/lang/String;
    //   472: aload #10
    //   474: invokestatic getNewHttpPost : (Ljava/lang/String;Lorg/json/JSONObject;)Lorg/apache/http/client/methods/HttpPost;
    //   477: astore #15
    //   479: aload #14
    //   481: astore_2
    //   482: aload #5
    //   484: astore #6
    //   486: new java/io/ByteArrayOutputStream
    //   489: dup
    //   490: invokespecial <init> : ()V
    //   493: astore_0
    //   494: aload_0
    //   495: astore #6
    //   497: aload #11
    //   499: astore_1
    //   500: aload_0
    //   501: astore #7
    //   503: aload #12
    //   505: astore_2
    //   506: aload_0
    //   507: astore #8
    //   509: aload #13
    //   511: astore_3
    //   512: aload_0
    //   513: astore #9
    //   515: invokestatic isNeedGizp : ()Z
    //   518: ifeq -> 557
    //   521: aload_0
    //   522: astore #6
    //   524: aload #11
    //   526: astore_1
    //   527: aload_0
    //   528: astore #7
    //   530: aload #12
    //   532: astore_2
    //   533: aload_0
    //   534: astore #8
    //   536: aload #13
    //   538: astore_3
    //   539: aload_0
    //   540: astore #9
    //   542: aload_0
    //   543: aload #10
    //   545: invokevirtual toString : ()Ljava/lang/String;
    //   548: invokestatic gzipLogs : (Ljava/lang/String;)[B
    //   551: invokevirtual write : ([B)V
    //   554: goto -> 590
    //   557: aload_0
    //   558: astore #6
    //   560: aload #11
    //   562: astore_1
    //   563: aload_0
    //   564: astore #7
    //   566: aload #12
    //   568: astore_2
    //   569: aload_0
    //   570: astore #8
    //   572: aload #13
    //   574: astore_3
    //   575: aload_0
    //   576: astore #9
    //   578: aload_0
    //   579: aload #10
    //   581: invokevirtual toString : ()Ljava/lang/String;
    //   584: invokevirtual getBytes : ()[B
    //   587: invokevirtual write : ([B)V
    //   590: aload_0
    //   591: astore #6
    //   593: aload #11
    //   595: astore_1
    //   596: aload_0
    //   597: astore #7
    //   599: aload #12
    //   601: astore_2
    //   602: aload_0
    //   603: astore #8
    //   605: aload #13
    //   607: astore_3
    //   608: aload_0
    //   609: astore #9
    //   611: aload #15
    //   613: new org/apache/http/entity/ByteArrayEntity
    //   616: dup
    //   617: aload_0
    //   618: invokevirtual toByteArray : ()[B
    //   621: invokespecial <init> : ([B)V
    //   624: invokevirtual setEntity : (Lorg/apache/http/HttpEntity;)V
    //   627: aload #15
    //   629: astore #10
    //   631: goto -> 634
    //   634: aload_0
    //   635: astore #6
    //   637: aload #11
    //   639: astore_1
    //   640: aload_0
    //   641: astore #7
    //   643: aload #12
    //   645: astore_2
    //   646: aload_0
    //   647: astore #8
    //   649: aload #13
    //   651: astore_3
    //   652: aload_0
    //   653: astore #9
    //   655: aload #5
    //   657: aload #10
    //   659: invokeinterface execute : (Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   664: astore #10
    //   666: aload_0
    //   667: astore #6
    //   669: aload #10
    //   671: astore_1
    //   672: aload_0
    //   673: astore #7
    //   675: aload #10
    //   677: astore_2
    //   678: aload_0
    //   679: astore #8
    //   681: aload #10
    //   683: astore_3
    //   684: aload_0
    //   685: astore #9
    //   687: new java/lang/StringBuilder
    //   690: dup
    //   691: ldc_w 'status code = '
    //   694: invokespecial <init> : (Ljava/lang/String;)V
    //   697: astore #11
    //   699: aload_0
    //   700: astore #6
    //   702: aload #10
    //   704: astore_1
    //   705: aload_0
    //   706: astore #7
    //   708: aload #10
    //   710: astore_2
    //   711: aload_0
    //   712: astore #8
    //   714: aload #10
    //   716: astore_3
    //   717: aload_0
    //   718: astore #9
    //   720: aload #11
    //   722: aload #10
    //   724: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   729: invokeinterface getStatusCode : ()I
    //   734: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload_0
    //   739: astore #6
    //   741: aload #10
    //   743: astore_1
    //   744: aload_0
    //   745: astore #7
    //   747: aload #10
    //   749: astore_2
    //   750: aload_0
    //   751: astore #8
    //   753: aload #10
    //   755: astore_3
    //   756: aload_0
    //   757: astore #9
    //   759: ldc 'WBAgent'
    //   761: aload #11
    //   763: invokevirtual toString : ()Ljava/lang/String;
    //   766: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload_0
    //   770: ifnull -> 777
    //   773: aload_0
    //   774: invokevirtual close : ()V
    //   777: aload #5
    //   779: invokestatic shutdownHttpClient : (Lorg/apache/http/client/HttpClient;)V
    //   782: aload #10
    //   784: areturn
    //   785: astore_0
    //   786: aload #6
    //   788: astore_2
    //   789: goto -> 929
    //   792: astore_3
    //   793: aload_1
    //   794: astore_0
    //   795: aload #7
    //   797: astore_1
    //   798: goto -> 840
    //   801: astore_3
    //   802: aload #8
    //   804: astore_1
    //   805: aload_2
    //   806: astore_0
    //   807: goto -> 865
    //   810: astore_2
    //   811: aload #9
    //   813: astore_1
    //   814: aload_3
    //   815: astore_0
    //   816: aload_2
    //   817: astore_3
    //   818: goto -> 890
    //   821: astore_0
    //   822: aconst_null
    //   823: astore #5
    //   825: aload #6
    //   827: astore_2
    //   828: goto -> 929
    //   831: astore_3
    //   832: aconst_null
    //   833: astore_0
    //   834: aload_0
    //   835: astore #5
    //   837: aload #7
    //   839: astore_1
    //   840: aload_1
    //   841: astore_2
    //   842: aload #5
    //   844: astore #6
    //   846: aload_3
    //   847: invokevirtual printStackTrace : ()V
    //   850: aload #5
    //   852: astore_2
    //   853: aload_0
    //   854: astore_3
    //   855: aload_1
    //   856: ifnull -> 918
    //   859: aload #5
    //   861: astore_2
    //   862: goto -> 912
    //   865: aload_1
    //   866: astore_2
    //   867: aload #5
    //   869: astore #6
    //   871: aload_3
    //   872: invokevirtual printStackTrace : ()V
    //   875: aload #5
    //   877: astore_2
    //   878: aload_0
    //   879: astore_3
    //   880: aload_1
    //   881: ifnull -> 918
    //   884: aload #5
    //   886: astore_2
    //   887: goto -> 912
    //   890: aload_1
    //   891: astore_2
    //   892: aload #5
    //   894: astore #6
    //   896: aload_3
    //   897: invokevirtual printStackTrace : ()V
    //   900: aload #5
    //   902: astore_2
    //   903: aload_0
    //   904: astore_3
    //   905: aload_1
    //   906: ifnull -> 918
    //   909: aload #5
    //   911: astore_2
    //   912: aload_1
    //   913: invokevirtual close : ()V
    //   916: aload_0
    //   917: astore_3
    //   918: aload_2
    //   919: invokestatic shutdownHttpClient : (Lorg/apache/http/client/HttpClient;)V
    //   922: aload_3
    //   923: areturn
    //   924: astore_0
    //   925: aload #6
    //   927: astore #5
    //   929: aload_2
    //   930: ifnull -> 937
    //   933: aload_2
    //   934: invokevirtual close : ()V
    //   937: aload #5
    //   939: invokestatic shutdownHttpClient : (Lorg/apache/http/client/HttpClient;)V
    //   942: aload_0
    //   943: athrow
    //   944: astore_0
    //   945: goto -> 777
    //   948: astore_1
    //   949: aload_0
    //   950: astore_3
    //   951: goto -> 918
    //   954: astore_1
    //   955: goto -> 937
    //   958: aconst_null
    //   959: astore #10
    //   961: aload #10
    //   963: astore_0
    //   964: goto -> 634
    //   967: astore_3
    //   968: aconst_null
    //   969: astore_0
    //   970: aload_0
    //   971: astore #5
    //   973: aload #8
    //   975: astore_1
    //   976: goto -> 865
    //   979: astore_3
    //   980: aconst_null
    //   981: astore_0
    //   982: aload_0
    //   983: astore #5
    //   985: aload #9
    //   987: astore_1
    //   988: goto -> 890
    // Exception table:
    //   from	to	target	type
    //   24	29	979	java/io/UnsupportedEncodingException
    //   24	29	967	org/apache/http/client/ClientProtocolException
    //   24	29	831	java/io/IOException
    //   24	29	821	finally
    //   43	48	69	java/io/UnsupportedEncodingException
    //   43	48	60	org/apache/http/client/ClientProtocolException
    //   43	48	51	java/io/IOException
    //   43	48	924	finally
    //   85	101	233	org/json/JSONException
    //   85	101	69	java/io/UnsupportedEncodingException
    //   85	101	60	org/apache/http/client/ClientProtocolException
    //   85	101	51	java/io/IOException
    //   85	101	924	finally
    //   108	121	233	org/json/JSONException
    //   108	121	69	java/io/UnsupportedEncodingException
    //   108	121	60	org/apache/http/client/ClientProtocolException
    //   108	121	51	java/io/IOException
    //   108	121	924	finally
    //   128	162	233	org/json/JSONException
    //   128	162	69	java/io/UnsupportedEncodingException
    //   128	162	60	org/apache/http/client/ClientProtocolException
    //   128	162	51	java/io/IOException
    //   128	162	924	finally
    //   169	179	233	org/json/JSONException
    //   169	179	69	java/io/UnsupportedEncodingException
    //   169	179	60	org/apache/http/client/ClientProtocolException
    //   169	179	51	java/io/IOException
    //   169	179	924	finally
    //   186	197	233	org/json/JSONException
    //   186	197	69	java/io/UnsupportedEncodingException
    //   186	197	60	org/apache/http/client/ClientProtocolException
    //   186	197	51	java/io/IOException
    //   186	197	924	finally
    //   204	214	233	org/json/JSONException
    //   204	214	69	java/io/UnsupportedEncodingException
    //   204	214	60	org/apache/http/client/ClientProtocolException
    //   204	214	51	java/io/IOException
    //   204	214	924	finally
    //   221	230	233	org/json/JSONException
    //   221	230	69	java/io/UnsupportedEncodingException
    //   221	230	60	org/apache/http/client/ClientProtocolException
    //   221	230	51	java/io/IOException
    //   221	230	924	finally
    //   241	245	69	java/io/UnsupportedEncodingException
    //   241	245	60	org/apache/http/client/ClientProtocolException
    //   241	245	51	java/io/IOException
    //   241	245	924	finally
    //   252	261	69	java/io/UnsupportedEncodingException
    //   252	261	60	org/apache/http/client/ClientProtocolException
    //   252	261	51	java/io/IOException
    //   252	261	924	finally
    //   273	285	69	java/io/UnsupportedEncodingException
    //   273	285	60	org/apache/http/client/ClientProtocolException
    //   273	285	51	java/io/IOException
    //   273	285	924	finally
    //   292	300	69	java/io/UnsupportedEncodingException
    //   292	300	60	org/apache/http/client/ClientProtocolException
    //   292	300	51	java/io/IOException
    //   292	300	924	finally
    //   307	317	69	java/io/UnsupportedEncodingException
    //   307	317	60	org/apache/http/client/ClientProtocolException
    //   307	317	51	java/io/IOException
    //   307	317	924	finally
    //   324	337	69	java/io/UnsupportedEncodingException
    //   324	337	60	org/apache/http/client/ClientProtocolException
    //   324	337	51	java/io/IOException
    //   324	337	924	finally
    //   349	359	69	java/io/UnsupportedEncodingException
    //   349	359	60	org/apache/http/client/ClientProtocolException
    //   349	359	51	java/io/IOException
    //   349	359	924	finally
    //   366	375	69	java/io/UnsupportedEncodingException
    //   366	375	60	org/apache/http/client/ClientProtocolException
    //   366	375	51	java/io/IOException
    //   366	375	924	finally
    //   382	390	69	java/io/UnsupportedEncodingException
    //   382	390	60	org/apache/http/client/ClientProtocolException
    //   382	390	51	java/io/IOException
    //   382	390	924	finally
    //   404	416	69	java/io/UnsupportedEncodingException
    //   404	416	60	org/apache/http/client/ClientProtocolException
    //   404	416	51	java/io/IOException
    //   404	416	924	finally
    //   423	431	69	java/io/UnsupportedEncodingException
    //   423	431	60	org/apache/http/client/ClientProtocolException
    //   423	431	51	java/io/IOException
    //   423	431	924	finally
    //   438	446	69	java/io/UnsupportedEncodingException
    //   438	446	60	org/apache/http/client/ClientProtocolException
    //   438	446	51	java/io/IOException
    //   438	446	924	finally
    //   453	461	69	java/io/UnsupportedEncodingException
    //   453	461	60	org/apache/http/client/ClientProtocolException
    //   453	461	51	java/io/IOException
    //   453	461	924	finally
    //   468	479	69	java/io/UnsupportedEncodingException
    //   468	479	60	org/apache/http/client/ClientProtocolException
    //   468	479	51	java/io/IOException
    //   468	479	924	finally
    //   486	494	69	java/io/UnsupportedEncodingException
    //   486	494	60	org/apache/http/client/ClientProtocolException
    //   486	494	51	java/io/IOException
    //   486	494	924	finally
    //   515	521	810	java/io/UnsupportedEncodingException
    //   515	521	801	org/apache/http/client/ClientProtocolException
    //   515	521	792	java/io/IOException
    //   515	521	785	finally
    //   542	554	810	java/io/UnsupportedEncodingException
    //   542	554	801	org/apache/http/client/ClientProtocolException
    //   542	554	792	java/io/IOException
    //   542	554	785	finally
    //   578	590	810	java/io/UnsupportedEncodingException
    //   578	590	801	org/apache/http/client/ClientProtocolException
    //   578	590	792	java/io/IOException
    //   578	590	785	finally
    //   611	627	810	java/io/UnsupportedEncodingException
    //   611	627	801	org/apache/http/client/ClientProtocolException
    //   611	627	792	java/io/IOException
    //   611	627	785	finally
    //   655	666	810	java/io/UnsupportedEncodingException
    //   655	666	801	org/apache/http/client/ClientProtocolException
    //   655	666	792	java/io/IOException
    //   655	666	785	finally
    //   687	699	810	java/io/UnsupportedEncodingException
    //   687	699	801	org/apache/http/client/ClientProtocolException
    //   687	699	792	java/io/IOException
    //   687	699	785	finally
    //   720	738	810	java/io/UnsupportedEncodingException
    //   720	738	801	org/apache/http/client/ClientProtocolException
    //   720	738	792	java/io/IOException
    //   720	738	785	finally
    //   759	769	810	java/io/UnsupportedEncodingException
    //   759	769	801	org/apache/http/client/ClientProtocolException
    //   759	769	792	java/io/IOException
    //   759	769	785	finally
    //   773	777	944	java/io/IOException
    //   846	850	924	finally
    //   871	875	924	finally
    //   896	900	924	finally
    //   912	916	948	java/io/IOException
    //   933	937	954	java/io/IOException
  }
  
  public static void setPackageName(String paramString) {
    mPackageName = paramString;
  }
  
  private static void shutdownHttpClient(HttpClient paramHttpClient) {
    if (paramHttpClient != null)
      try {
        paramHttpClient.getConnectionManager().closeExpiredConnections();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private static void updateTime(Context paramContext, Long paramLong) {
    SharedPreferences.Editor editor = paramContext.getSharedPreferences(UPLOADTIME, 0).edit();
    editor.putLong("lasttime", paramLong.longValue());
    editor.commit();
  }
  
  public static void uploadAppLogs(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/statistic/LogReport
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/statistic/LogReport.mLogReport : Lcom/sina/weibo/sdk/statistic/LogReport;
    //   6: ifnonnull -> 20
    //   9: new com/sina/weibo/sdk/statistic/LogReport
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/sina/weibo/sdk/statistic/LogReport.mLogReport : Lcom/sina/weibo/sdk/statistic/LogReport;
    //   20: aload_0
    //   21: invokestatic isNetworkConnected : (Landroid/content/Context;)Z
    //   24: ifne -> 50
    //   27: ldc 'WBAgent'
    //   29: ldc_w 'network is not connected'
    //   32: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   35: ldc_w 'app_logs'
    //   38: invokestatic getAppLogPath : (Ljava/lang/String;)Ljava/lang/String;
    //   41: aload_1
    //   42: iconst_1
    //   43: invokestatic writeToFile : (Ljava/lang/String;Ljava/lang/String;Z)V
    //   46: ldc com/sina/weibo/sdk/statistic/LogReport
    //   48: monitorexit
    //   49: return
    //   50: aload_1
    //   51: invokestatic getValidUploadLogs : (Ljava/lang/String;)Ljava/util/List;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnonnull -> 71
    //   59: ldc 'WBAgent'
    //   61: ldc_w 'applogs is null'
    //   64: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   67: ldc com/sina/weibo/sdk/statistic/LogReport
    //   69: monitorexit
    //   70: return
    //   71: new java/util/ArrayList
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore_1
    //   79: aload_0
    //   80: invokestatic checkAid : (Landroid/content/Context;)V
    //   83: aload_2
    //   84: invokeinterface iterator : ()Ljava/util/Iterator;
    //   89: astore_2
    //   90: aload_2
    //   91: invokeinterface hasNext : ()Z
    //   96: ifne -> 176
    //   99: ldc_w 'app_logs'
    //   102: invokestatic getAppLogPath : (Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic delete : (Ljava/lang/String;)Z
    //   108: pop
    //   109: aload_1
    //   110: invokeinterface size : ()I
    //   115: ifle -> 172
    //   118: aload_1
    //   119: invokeinterface iterator : ()Ljava/util/Iterator;
    //   124: astore_0
    //   125: aload_0
    //   126: invokeinterface hasNext : ()Z
    //   131: ifne -> 137
    //   134: goto -> 172
    //   137: aload_0
    //   138: invokeinterface next : ()Ljava/lang/Object;
    //   143: checkcast org/json/JSONArray
    //   146: astore_1
    //   147: ldc_w 'app_logs'
    //   150: invokestatic getAppLogPath : (Ljava/lang/String;)Ljava/lang/String;
    //   153: aload_1
    //   154: invokevirtual toString : ()Ljava/lang/String;
    //   157: iconst_1
    //   158: invokestatic writeToFile : (Ljava/lang/String;Ljava/lang/String;Z)V
    //   161: ldc 'WBAgent'
    //   163: ldc_w 'save failed_log'
    //   166: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   169: goto -> 125
    //   172: ldc com/sina/weibo/sdk/statistic/LogReport
    //   174: monitorexit
    //   175: return
    //   176: aload_2
    //   177: invokeinterface next : ()Ljava/lang/Object;
    //   182: checkcast org/json/JSONArray
    //   185: astore_3
    //   186: getstatic com/sina/weibo/sdk/statistic/LogReport.mBaseUrl : Ljava/lang/String;
    //   189: ldc_w 'POST'
    //   192: getstatic com/sina/weibo/sdk/statistic/LogReport.mParams : Lorg/json/JSONObject;
    //   195: aload_3
    //   196: invokestatic requestHttpExecute : (Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;)Lorg/apache/http/HttpResponse;
    //   199: astore #4
    //   201: aload #4
    //   203: ifnonnull -> 209
    //   206: goto -> 227
    //   209: aload #4
    //   211: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
    //   216: invokeinterface getStatusCode : ()I
    //   221: sipush #200
    //   224: if_icmpeq -> 246
    //   227: aload_1
    //   228: aload_3
    //   229: invokeinterface add : (Ljava/lang/Object;)Z
    //   234: pop
    //   235: ldc 'WBAgent'
    //   237: ldc_w 'upload applogs error'
    //   240: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -> 90
    //   246: aload_0
    //   247: invokestatic currentTimeMillis : ()J
    //   250: invokestatic valueOf : (J)Ljava/lang/Long;
    //   253: invokestatic updateTime : (Landroid/content/Context;Ljava/lang/Long;)V
    //   256: goto -> 90
    //   259: astore_0
    //   260: ldc com/sina/weibo/sdk/statistic/LogReport
    //   262: monitorexit
    //   263: aload_0
    //   264: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	259	finally
    //   20	46	259	finally
    //   50	55	259	finally
    //   59	67	259	finally
    //   71	90	259	finally
    //   90	125	259	finally
    //   125	134	259	finally
    //   137	169	259	finally
    //   176	201	259	finally
    //   209	227	259	finally
    //   227	243	259	finally
    //   246	256	259	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\statistic\LogReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */