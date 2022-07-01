package com.bytedance.embedapplog.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.util.UriConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public static JSONObject a;
  
  static final String[] b;
  
  public static final String[] c;
  
  private static final String[] d = new String[] { "GET", "POST" };
  
  private static final String[] e = new String[] { "aid", "app_version", "tt_data", "device_id" };
  
  private static UriConfig f;
  
  static {
    b = new String[] { "aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform" };
    c = new String[] { "tt_data", "device_platform" };
    f = UriConfig.creatUriConfig(0);
  }
  
  public static int a(String[] paramArrayOfString, byte[] paramArrayOfbyte, h paramh) {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: iconst_2
    //   5: invokespecial <init> : (I)V
    //   8: astore #10
    //   10: invokestatic getEncryptAndCompress : ()Z
    //   13: ifeq -> 29
    //   16: aload #10
    //   18: ldc 'Content-Type'
    //   20: ldc 'application/octet-stream;tt-data=a'
    //   22: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: pop
    //   26: goto -> 39
    //   29: aload #10
    //   31: ldc 'Content-Type'
    //   33: ldc 'application/json; charset=utf-8'
    //   35: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: pop
    //   39: aload_0
    //   40: arraylength
    //   41: istore #4
    //   43: iconst_0
    //   44: istore #6
    //   46: aconst_null
    //   47: astore #9
    //   49: iconst_0
    //   50: istore_3
    //   51: iload_3
    //   52: iload #4
    //   54: if_icmpge -> 87
    //   57: iconst_1
    //   58: aload_0
    //   59: iload_3
    //   60: aaload
    //   61: aload #10
    //   63: aload_1
    //   64: invokestatic a : (ILjava/lang/String;Ljava/util/HashMap;[B)Ljava/lang/String;
    //   67: astore #9
    //   69: aload #9
    //   71: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   74: ifne -> 80
    //   77: goto -> 87
    //   80: iload_3
    //   81: iconst_1
    //   82: iadd
    //   83: istore_3
    //   84: goto -> 51
    //   87: aload #9
    //   89: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   92: ifne -> 195
    //   95: new org/json/JSONObject
    //   98: dup
    //   99: aload #9
    //   101: invokespecial <init> : (Ljava/lang/String;)V
    //   104: astore_0
    //   105: aload_0
    //   106: ldc 'http_code'
    //   108: invokevirtual optInt : (Ljava/lang/String;)I
    //   111: istore #4
    //   113: iload #4
    //   115: istore_3
    //   116: aload_0
    //   117: astore_1
    //   118: iload #4
    //   120: sipush #200
    //   123: if_icmpne -> 211
    //   126: ldc 'ss_app_log'
    //   128: aload_0
    //   129: ldc 'magic_tag'
    //   131: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   134: invokevirtual equals : (Ljava/lang/Object;)Z
    //   137: ifeq -> 177
    //   140: ldc 'success'
    //   142: aload_0
    //   143: ldc 'message'
    //   145: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   148: invokevirtual equals : (Ljava/lang/Object;)Z
    //   151: ifeq -> 163
    //   154: sipush #200
    //   157: istore_3
    //   158: aload_0
    //   159: astore_1
    //   160: goto -> 211
    //   163: ldc '101'
    //   165: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   168: invokevirtual intValue : ()I
    //   171: istore_3
    //   172: aload_0
    //   173: astore_1
    //   174: goto -> 211
    //   177: ldc '102'
    //   179: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   182: invokevirtual intValue : ()I
    //   185: istore_3
    //   186: aload_0
    //   187: astore_1
    //   188: goto -> 211
    //   191: astore_1
    //   192: goto -> 203
    //   195: aconst_null
    //   196: astore_0
    //   197: goto -> 207
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_1
    //   204: invokestatic a : (Ljava/lang/Throwable;)V
    //   207: iconst_0
    //   208: istore_3
    //   209: aload_0
    //   210: astore_1
    //   211: iload_3
    //   212: sipush #200
    //   215: if_icmpne -> 453
    //   218: aload_1
    //   219: ldc 'server_time'
    //   221: invokevirtual optLong : (Ljava/lang/String;)J
    //   224: lstore #7
    //   226: lload #7
    //   228: lconst_0
    //   229: lcmp
    //   230: ifle -> 276
    //   233: new org/json/JSONObject
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: astore_0
    //   241: aload_0
    //   242: ldc 'server_time'
    //   244: lload #7
    //   246: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   249: pop
    //   250: aload_0
    //   251: ldc 'local_time'
    //   253: invokestatic currentTimeMillis : ()J
    //   256: ldc2_w 1000
    //   259: ldiv
    //   260: invokevirtual put : (Ljava/lang/String;J)Lorg/json/JSONObject;
    //   263: pop
    //   264: aload_0
    //   265: putstatic com/bytedance/embedapplog/c/a.a : Lorg/json/JSONObject;
    //   268: goto -> 276
    //   271: astore_0
    //   272: aload_0
    //   273: invokestatic a : (Ljava/lang/Throwable;)V
    //   276: aload_1
    //   277: ldc 'blacklist'
    //   279: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   282: astore_1
    //   283: aload_1
    //   284: ifnull -> 453
    //   287: aload_1
    //   288: ldc 'v1'
    //   290: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   293: astore #9
    //   295: aload #9
    //   297: ifnull -> 310
    //   300: aload #9
    //   302: invokevirtual length : ()I
    //   305: istore #4
    //   307: goto -> 313
    //   310: iconst_0
    //   311: istore #4
    //   313: new java/util/HashSet
    //   316: dup
    //   317: iload #4
    //   319: invokespecial <init> : (I)V
    //   322: astore_0
    //   323: iconst_0
    //   324: istore #5
    //   326: iload #5
    //   328: iload #4
    //   330: if_icmpge -> 367
    //   333: aload #9
    //   335: iload #5
    //   337: aconst_null
    //   338: invokevirtual optString : (ILjava/lang/String;)Ljava/lang/String;
    //   341: astore #10
    //   343: aload #10
    //   345: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   348: ifne -> 358
    //   351: aload_0
    //   352: aload #10
    //   354: invokevirtual add : (Ljava/lang/Object;)Z
    //   357: pop
    //   358: iload #5
    //   360: iconst_1
    //   361: iadd
    //   362: istore #5
    //   364: goto -> 326
    //   367: aload_1
    //   368: ldc 'v3'
    //   370: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   373: astore_1
    //   374: aload_1
    //   375: ifnull -> 387
    //   378: aload_1
    //   379: invokevirtual length : ()I
    //   382: istore #4
    //   384: goto -> 390
    //   387: iconst_0
    //   388: istore #4
    //   390: new java/util/HashSet
    //   393: dup
    //   394: iload #4
    //   396: invokespecial <init> : (I)V
    //   399: astore #9
    //   401: iload #6
    //   403: istore #5
    //   405: iload #5
    //   407: iload #4
    //   409: if_icmpge -> 446
    //   412: aload_1
    //   413: iload #5
    //   415: aconst_null
    //   416: invokevirtual optString : (ILjava/lang/String;)Ljava/lang/String;
    //   419: astore #10
    //   421: aload #10
    //   423: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   426: ifne -> 437
    //   429: aload #9
    //   431: aload #10
    //   433: invokevirtual add : (Ljava/lang/Object;)Z
    //   436: pop
    //   437: iload #5
    //   439: iconst_1
    //   440: iadd
    //   441: istore #5
    //   443: goto -> 405
    //   446: aload_2
    //   447: aload_0
    //   448: aload #9
    //   450: invokevirtual a : (Ljava/util/HashSet;Ljava/util/HashSet;)V
    //   453: iload_3
    //   454: ireturn
    // Exception table:
    //   from	to	target	type
    //   87	105	200	org/json/JSONException
    //   105	113	191	org/json/JSONException
    //   126	154	191	org/json/JSONException
    //   163	172	191	org/json/JSONException
    //   177	186	191	org/json/JSONException
    //   218	226	271	java/lang/Exception
    //   233	268	271	java/lang/Exception
  }
  
  public static UriConfig a() {
    return f;
  }
  
  public static String a(int paramInt, String paramString, HashMap<String, String> paramHashMap, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   3: ifeq -> 215
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #4
    //   15: aload #4
    //   17: ldc 'http: '
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload #4
    //   25: aload_1
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #4
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: aconst_null
    //   36: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   39: aload_2
    //   40: ifnull -> 177
    //   43: aload_2
    //   44: invokevirtual entrySet : ()Ljava/util/Set;
    //   47: invokeinterface iterator : ()Ljava/util/Iterator;
    //   52: astore #4
    //   54: aload #4
    //   56: invokeinterface hasNext : ()Z
    //   61: ifeq -> 177
    //   64: aload #4
    //   66: invokeinterface next : ()Ljava/lang/Object;
    //   71: checkcast java/util/Map$Entry
    //   74: astore #5
    //   76: aload #5
    //   78: invokeinterface getKey : ()Ljava/lang/Object;
    //   83: checkcast java/lang/CharSequence
    //   86: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   89: ifne -> 54
    //   92: aload #5
    //   94: invokeinterface getValue : ()Ljava/lang/Object;
    //   99: checkcast java/lang/CharSequence
    //   102: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   105: ifne -> 54
    //   108: new java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial <init> : ()V
    //   115: astore #6
    //   117: aload #6
    //   119: ldc 'http headers key:'
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload #6
    //   127: aload #5
    //   129: invokeinterface getKey : ()Ljava/lang/Object;
    //   134: checkcast java/lang/String
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload #6
    //   143: ldc ' value:'
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #6
    //   151: aload #5
    //   153: invokeinterface getValue : ()Ljava/lang/Object;
    //   158: checkcast java/lang/String
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #6
    //   167: invokevirtual toString : ()Ljava/lang/String;
    //   170: aconst_null
    //   171: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -> 54
    //   177: aload_3
    //   178: ifnull -> 215
    //   181: new java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial <init> : ()V
    //   188: astore #4
    //   190: aload #4
    //   192: ldc 'http data length:'
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload #4
    //   200: aload_3
    //   201: arraylength
    //   202: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload #4
    //   208: invokevirtual toString : ()Ljava/lang/String;
    //   211: aconst_null
    //   212: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: new java/net/URL
    //   218: dup
    //   219: aload_1
    //   220: invokespecial <init> : (Ljava/lang/String;)V
    //   223: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   226: checkcast java/net/HttpURLConnection
    //   229: astore #4
    //   231: iload_0
    //   232: ifne -> 244
    //   235: aload #4
    //   237: iconst_0
    //   238: invokevirtual setDoOutput : (Z)V
    //   241: goto -> 262
    //   244: iload_0
    //   245: iconst_1
    //   246: if_icmpne -> 258
    //   249: aload #4
    //   251: iconst_1
    //   252: invokevirtual setDoOutput : (Z)V
    //   255: goto -> 262
    //   258: aconst_null
    //   259: invokestatic a : (Ljava/lang/Throwable;)V
    //   262: aload #4
    //   264: getstatic com/bytedance/embedapplog/c/a.d : [Ljava/lang/String;
    //   267: iload_0
    //   268: aaload
    //   269: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   272: aload_2
    //   273: ifnull -> 375
    //   276: aload_2
    //   277: invokevirtual isEmpty : ()Z
    //   280: ifne -> 375
    //   283: aload_2
    //   284: invokevirtual entrySet : ()Ljava/util/Set;
    //   287: invokeinterface iterator : ()Ljava/util/Iterator;
    //   292: astore_1
    //   293: aload_1
    //   294: invokeinterface hasNext : ()Z
    //   299: ifeq -> 375
    //   302: aload_1
    //   303: invokeinterface next : ()Ljava/lang/Object;
    //   308: checkcast java/util/Map$Entry
    //   311: astore_2
    //   312: aload_2
    //   313: invokeinterface getKey : ()Ljava/lang/Object;
    //   318: checkcast java/lang/CharSequence
    //   321: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   324: ifne -> 368
    //   327: aload_2
    //   328: invokeinterface getValue : ()Ljava/lang/Object;
    //   333: checkcast java/lang/CharSequence
    //   336: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   339: ifne -> 368
    //   342: aload #4
    //   344: aload_2
    //   345: invokeinterface getKey : ()Ljava/lang/Object;
    //   350: checkcast java/lang/String
    //   353: aload_2
    //   354: invokeinterface getValue : ()Ljava/lang/Object;
    //   359: checkcast java/lang/String
    //   362: invokevirtual addRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   365: goto -> 293
    //   368: aconst_null
    //   369: invokestatic a : (Ljava/lang/Throwable;)V
    //   372: goto -> 293
    //   375: aload #4
    //   377: ldc_w 'Accept-Encoding'
    //   380: ldc_w 'gzip'
    //   383: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload_3
    //   387: ifnull -> 891
    //   390: aload_3
    //   391: arraylength
    //   392: ifle -> 891
    //   395: new java/io/DataOutputStream
    //   398: dup
    //   399: aload #4
    //   401: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   404: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   407: astore_1
    //   408: aload_1
    //   409: astore_2
    //   410: aload_1
    //   411: aload_3
    //   412: invokevirtual write : ([B)V
    //   415: aload_1
    //   416: astore_2
    //   417: aload_1
    //   418: invokevirtual flush : ()V
    //   421: aload_1
    //   422: astore_2
    //   423: aload_1
    //   424: invokevirtual close : ()V
    //   427: goto -> 430
    //   430: aload_1
    //   431: astore_2
    //   432: aload #4
    //   434: invokevirtual getResponseCode : ()I
    //   437: istore_0
    //   438: iload_0
    //   439: sipush #200
    //   442: if_icmpne -> 651
    //   445: aload_1
    //   446: astore_2
    //   447: aload #4
    //   449: invokevirtual getContentLength : ()I
    //   452: sipush #10240
    //   455: if_icmpge -> 638
    //   458: aload_1
    //   459: astore_2
    //   460: aload #4
    //   462: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   465: astore #5
    //   467: aload_1
    //   468: astore_2
    //   469: ldc_w 'gzip'
    //   472: aload #4
    //   474: invokevirtual getContentEncoding : ()Ljava/lang/String;
    //   477: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   480: ifeq -> 514
    //   483: aload_1
    //   484: astore_2
    //   485: new java/io/BufferedReader
    //   488: dup
    //   489: new java/io/InputStreamReader
    //   492: dup
    //   493: new java/util/zip/GZIPInputStream
    //   496: dup
    //   497: aload #5
    //   499: invokespecial <init> : (Ljava/io/InputStream;)V
    //   502: invokespecial <init> : (Ljava/io/InputStream;)V
    //   505: invokespecial <init> : (Ljava/io/Reader;)V
    //   508: astore_3
    //   509: aload_3
    //   510: astore_2
    //   511: goto -> 535
    //   514: aload_1
    //   515: astore_2
    //   516: new java/io/BufferedReader
    //   519: dup
    //   520: new java/io/InputStreamReader
    //   523: dup
    //   524: aload #5
    //   526: invokespecial <init> : (Ljava/io/InputStream;)V
    //   529: invokespecial <init> : (Ljava/io/Reader;)V
    //   532: astore_3
    //   533: aload_3
    //   534: astore_2
    //   535: new java/lang/StringBuilder
    //   538: dup
    //   539: aload #5
    //   541: invokevirtual available : ()I
    //   544: invokespecial <init> : (I)V
    //   547: astore_3
    //   548: aload_2
    //   549: invokevirtual readLine : ()Ljava/lang/String;
    //   552: astore #4
    //   554: aload #4
    //   556: ifnull -> 577
    //   559: aload_3
    //   560: aload #4
    //   562: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_3
    //   567: ldc_w '\\n'
    //   570: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: goto -> 548
    //   577: aload_3
    //   578: invokevirtual toString : ()Ljava/lang/String;
    //   581: astore #5
    //   583: new org/json/JSONObject
    //   586: dup
    //   587: aload #5
    //   589: invokespecial <init> : (Ljava/lang/String;)V
    //   592: astore_3
    //   593: aload_3
    //   594: ldc 'http_code'
    //   596: sipush #200
    //   599: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   602: pop
    //   603: aload_3
    //   604: invokevirtual toString : ()Ljava/lang/String;
    //   607: astore #4
    //   609: aload_2
    //   610: astore_3
    //   611: aload #4
    //   613: astore_2
    //   614: goto -> 712
    //   617: astore_3
    //   618: goto -> 625
    //   621: astore_3
    //   622: aconst_null
    //   623: astore #5
    //   625: aload_2
    //   626: astore #4
    //   628: aload_3
    //   629: astore_2
    //   630: aload_1
    //   631: astore_3
    //   632: aload #5
    //   634: astore_1
    //   635: goto -> 780
    //   638: aload_1
    //   639: astore_2
    //   640: aconst_null
    //   641: invokestatic a : (Ljava/lang/Throwable;)V
    //   644: aconst_null
    //   645: astore_3
    //   646: aload_3
    //   647: astore_2
    //   648: goto -> 712
    //   651: aload_1
    //   652: astore_2
    //   653: new org/json/JSONObject
    //   656: dup
    //   657: invokespecial <init> : ()V
    //   660: ldc 'http_code'
    //   662: iload_0
    //   663: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   666: invokevirtual toString : ()Ljava/lang/String;
    //   669: astore #5
    //   671: new java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial <init> : ()V
    //   678: astore_2
    //   679: aload_2
    //   680: ldc_w 'HttpCode:'
    //   683: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload_2
    //   688: iload_0
    //   689: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: new java/lang/RuntimeException
    //   696: dup
    //   697: aload_2
    //   698: invokevirtual toString : ()Ljava/lang/String;
    //   701: invokespecial <init> : (Ljava/lang/String;)V
    //   704: invokevirtual printStackTrace : ()V
    //   707: aload #5
    //   709: astore_2
    //   710: aconst_null
    //   711: astore_3
    //   712: aload_1
    //   713: ifnull -> 723
    //   716: aload_1
    //   717: invokevirtual close : ()V
    //   720: goto -> 723
    //   723: aload_2
    //   724: astore_1
    //   725: aload_3
    //   726: ifnull -> 805
    //   729: aload_3
    //   730: invokevirtual close : ()V
    //   733: aload_2
    //   734: astore_1
    //   735: goto -> 805
    //   738: aload_2
    //   739: astore_1
    //   740: goto -> 805
    //   743: astore_2
    //   744: aconst_null
    //   745: astore #4
    //   747: aload_1
    //   748: astore_3
    //   749: aload #5
    //   751: astore_1
    //   752: goto -> 780
    //   755: astore #5
    //   757: aconst_null
    //   758: astore #4
    //   760: aload #4
    //   762: astore_1
    //   763: aload_2
    //   764: astore_3
    //   765: aload #5
    //   767: astore_2
    //   768: goto -> 780
    //   771: astore_2
    //   772: aconst_null
    //   773: astore_3
    //   774: aload_3
    //   775: astore #4
    //   777: aload #4
    //   779: astore_1
    //   780: aload_2
    //   781: invokestatic a : (Ljava/lang/Throwable;)V
    //   784: aload_3
    //   785: ifnull -> 795
    //   788: aload_3
    //   789: invokevirtual close : ()V
    //   792: goto -> 795
    //   795: aload #4
    //   797: ifnull -> 805
    //   800: aload #4
    //   802: invokevirtual close : ()V
    //   805: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   808: ifeq -> 841
    //   811: new java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial <init> : ()V
    //   818: astore_2
    //   819: aload_2
    //   820: ldc_w 'http response: '
    //   823: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload_2
    //   828: aload_1
    //   829: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload_2
    //   834: invokevirtual toString : ()Ljava/lang/String;
    //   837: aconst_null
    //   838: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   841: aload_1
    //   842: areturn
    //   843: astore_1
    //   844: aload_3
    //   845: ifnull -> 855
    //   848: aload_3
    //   849: invokevirtual close : ()V
    //   852: goto -> 855
    //   855: aload #4
    //   857: ifnull -> 865
    //   860: aload #4
    //   862: invokevirtual close : ()V
    //   865: aload_1
    //   866: athrow
    //   867: astore_1
    //   868: goto -> 723
    //   871: astore_1
    //   872: goto -> 738
    //   875: astore_2
    //   876: goto -> 795
    //   879: astore_2
    //   880: goto -> 805
    //   883: astore_2
    //   884: goto -> 855
    //   887: astore_2
    //   888: goto -> 865
    //   891: aconst_null
    //   892: astore_1
    //   893: goto -> 430
    // Exception table:
    //   from	to	target	type
    //   215	231	771	finally
    //   235	241	771	finally
    //   249	255	771	finally
    //   258	262	771	finally
    //   262	272	771	finally
    //   276	293	771	finally
    //   293	365	771	finally
    //   368	372	771	finally
    //   375	386	771	finally
    //   390	408	771	finally
    //   410	415	755	finally
    //   417	421	755	finally
    //   423	427	755	finally
    //   432	438	755	finally
    //   447	458	755	finally
    //   460	467	755	finally
    //   469	483	755	finally
    //   485	509	755	finally
    //   516	533	755	finally
    //   535	548	621	finally
    //   548	554	621	finally
    //   559	574	621	finally
    //   577	583	621	finally
    //   583	609	617	finally
    //   640	644	755	finally
    //   653	671	755	finally
    //   671	707	743	finally
    //   716	720	867	java/io/IOException
    //   729	733	871	java/io/IOException
    //   780	784	843	finally
    //   788	792	875	java/io/IOException
    //   800	805	879	java/io/IOException
    //   848	852	883	java/io/IOException
    //   860	865	887	java/io/IOException
  }
  
  private static String a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    if (!AppLog.getEncryptAndCompress())
      return paramString; 
    Uri uri = Uri.parse(paramString);
    paramString = uri.getQuery();
    ArrayList<Pair> arrayList = new ArrayList();
    for (String str1 : e) {
      String str2 = uri.getQueryParameter(str1);
      if (!TextUtils.isEmpty(str2))
        arrayList.add(new Pair(str1, str2)); 
    } 
    Uri.Builder builder = uri.buildUpon();
    builder.clearQuery();
    for (Pair pair : arrayList)
      builder.appendQueryParameter((String)pair.first, (String)pair.second); 
    builder.appendQueryParameter("tt_info", new String(Base64.encode(AppLog.toEncryptByte(paramString), 8)));
    return builder.build().toString();
  }
  
  public static String a(String paramString, String[] paramArrayOfString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    Uri uri = Uri.parse(paramString);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramArrayOfString.length);
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str1 = paramArrayOfString[i];
      String str2 = uri.getQueryParameter(str1);
      if (!TextUtils.isEmpty(str2))
        hashMap.put(str1, str2); 
    } 
    Uri.Builder builder = uri.buildUpon();
    builder.clearQuery();
    for (String str : hashMap.keySet())
      builder.appendQueryParameter(str, (String)hashMap.get(str)); 
    return builder.build().toString();
  }
  
  public static JSONObject a(String paramString, JSONObject paramJSONObject) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(2);
    if (AppLog.getEncryptAndCompress()) {
      hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
    } else {
      hashMap.put("Content-Type", "application/json; charset=utf-8");
    } 
    paramString = a(1, a(paramString), (HashMap)hashMap, AppLog.toEncryptByte(paramJSONObject.toString()));
    if (paramString != null)
      try {
        return new JSONObject(paramString);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
    return null;
  }
  
  public static void a(int paramInt) {
    f = UriConfig.creatUriConfig(paramInt);
  }
  
  protected static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2) {
    if (paramStringBuilder != null && !TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      if (paramStringBuilder.toString().indexOf('?') < 0) {
        paramStringBuilder.append("?");
      } else {
        paramStringBuilder.append("&");
      } 
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append("=");
      paramStringBuilder.append(Uri.encode(paramString2));
    } 
  }
  
  public static boolean b(String paramString, JSONObject paramJSONObject) {
    StringBuilder stringBuilder2 = new StringBuilder(paramString);
    float f2 = TimeZone.getDefault().getRawOffset() * 1.0F / 3600000.0F;
    float f1 = f2;
    if (f2 < -12.0F)
      f1 = -12.0F; 
    f2 = f1;
    if (f1 > 12.0F)
      f2 = 12.0F; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(f2);
    stringBuilder1.append("");
    a(stringBuilder2, "timezone", stringBuilder1.toString());
    JSONArray jSONArray2 = paramJSONObject.optJSONArray("sim_serial_number");
    if (jSONArray2 != null)
      try {
        String str = ((JSONObject)jSONArray2.get(0)).optString("sim_serial_number");
        int i;
        for (i = 1; i < jSONArray2.length(); i++) {
          String str3 = ((JSONObject)jSONArray2.get(i)).optString("sim_serial_number");
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append(",");
          stringBuilder.append(str3);
          str = stringBuilder.toString();
        } 
        a(stringBuilder2, "sim_serial_number", str);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
    String str1 = a(stringBuilder2.toString());
    jSONArray2 = null;
    String str2 = a(0, str1, null, null);
    JSONArray jSONArray1 = jSONArray2;
    if (str2 != null)
      try {
        JSONObject jSONObject = new JSONObject(str2);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONArray1 = jSONArray2;
      }  
    return (jSONArray1 != null && "success".equals(jSONArray1.optString("message", "")));
  }
  
  public static JSONObject c(String paramString, JSONObject paramJSONObject) {
    byte[] arrayOfByte = paramJSONObject.toString().getBytes();
    boolean bool = true;
    paramString = a(1, paramString, null, arrayOfByte);
    if (paramString != null) {
      try {
        JSONObject jSONObject = new JSONObject(paramString);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      if (jSONException == null || !"ss_app_log".equals(jSONException.optString("magic_tag", "")))
        bool = false; 
      return bool ? jSONException.optJSONObject("config") : null;
    } 
    paramString = null;
  }
  
  public static JSONObject d(String paramString, JSONObject paramJSONObject) {
    byte[] arrayOfByte = paramJSONObject.toString().getBytes();
    boolean bool = true;
    paramString = a(1, paramString, null, arrayOfByte);
    if (paramString != null) {
      try {
        JSONObject jSONObject = new JSONObject(paramString);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        jSONException = null;
      } 
      if (jSONException == null || !"success".equals(jSONException.optString("message", "")))
        bool = false; 
      return bool ? jSONException.optJSONObject("data") : null;
    } 
    paramString = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */