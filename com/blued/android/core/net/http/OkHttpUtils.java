package com.blued.android.core.net.http;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.exception.OkHttpException;
import com.blued.android.core.net.http.ssl.HttpsIPAccessUtils;
import com.blued.android.core.utils.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
  static OkHttpClient a;
  
  private static final WeakHashMap<IRequestHost, List<WeakReference<Call>>> b = new WeakHashMap<IRequestHost, List<WeakReference<Call>>>();
  
  public static void a() {
    if (a == null) {
      int j = Runtime.getRuntime().availableProcessors();
      int i = 4;
      if (j > 4) {
        i = Runtime.getRuntime().availableProcessors();
      } else if (Build.VERSION.SDK_INT >= 26) {
        i = 8;
      } 
      Dispatcher dispatcher = new Dispatcher();
      dispatcher.a(i);
      OkHttpClient.Builder builder = (new OkHttpClient.Builder()).a(SyncOkHttpDns.a()).a(dispatcher);
      HttpsIPAccessUtils.a(builder);
      a = builder.b();
    } 
  }
  
  public static void a(HttpRequestWrapper paramHttpRequestWrapper) {
    Call call = (new OkHttpUrlRequest()).a(paramHttpRequestWrapper);
    paramHttpRequestWrapper.a(call);
    IRequestHost iRequestHost = paramHttpRequestWrapper.e();
    if (call != null && iRequestHost != null)
      synchronized (b) {
        List<WeakReference<Call>> list2 = b.get(iRequestHost);
        List<WeakReference<Call>> list1 = list2;
        if (list2 == null) {
          list1 = new LinkedList();
          b.put(iRequestHost, list1);
        } 
        list1.add(new WeakReference<Call>(call));
        return;
      }  
  }
  
  public static void a(IRequestHost paramIRequestHost) {
    synchronized (b) {
      List list = b.get(paramIRequestHost);
      if (list != null) {
        Iterator<WeakReference<Call>> iterator = list.iterator();
        while (iterator.hasNext()) {
          Call call = ((WeakReference<Call>)iterator.next()).get();
          if (call != null)
            call.c(); 
        } 
        list.clear();
      } 
      b.remove(paramIRequestHost);
      return;
    } 
  }
  
  public static void a(String paramString, BinaryHttpResponseHandler paramBinaryHttpResponseHandler) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramBinaryHttpResponseHandler == null)
        return; 
      try {
        paramBinaryHttpResponseHandler.sendStartMessage();
        Request request = (new Request.Builder()).a(paramString).d();
        Response response = a.a(request).b();
        if (!Thread.currentThread().isInterrupted())
          paramBinaryHttpResponseHandler.sendResponseMessage(paramString, response); 
      } catch (IOException iOException) {
      
      } catch (Exception exception) {
        exception.printStackTrace();
        paramBinaryHttpResponseHandler.sendFailureMessage(paramString, exception, -2001, null);
      } catch (OutOfMemoryError outOfMemoryError) {
        outOfMemoryError.printStackTrace();
        paramBinaryHttpResponseHandler.sendFailureMessage(paramString, outOfMemoryError, -3001, null);
      } finally {}
    } else {
      return;
    } 
    paramBinaryHttpResponseHandler.sendFinishMessage();
  }
  
  public static void a(String paramString1, String paramString2, FileHttpResponseHandler paramFileHttpResponseHandler, IRequestHost paramIRequestHost) throws OkHttpException {
    if (TextUtils.isEmpty(paramString1)) {
      if (paramFileHttpResponseHandler != null)
        paramFileHttpResponseHandler.sendFailureMessage(paramString1, new Exception("url is empty"), -1002, null); 
      return;
    } 
    if (Base64ImageUrlDownloader.a(paramString1)) {
      Base64ImageUrlDownloader.a(paramString1, paramString2, paramFileHttpResponseHandler, paramIRequestHost);
      return;
    } 
    try {
      Request request = (new Request.Builder()).a(paramString1).b("Accept", "image/webp, */*").d();
      a.a(request).a(new Callback(paramFileHttpResponseHandler, paramString1, paramString2, paramIRequestHost) {
            public void onFailure(Call param1Call, IOException param1IOException) {
              FileHttpResponseHandler fileHttpResponseHandler = this.a;
              if (fileHttpResponseHandler != null)
                fileHttpResponseHandler.sendFailureMessage(this.b, param1IOException, StatusCode.a(param1IOException), null); 
            }
            
            public void onResponse(Call param1Call, Response param1Response) {
              OkHttpUtils.a(param1Response, this.b, this.c, this.a, this.d);
            }
          });
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      if (paramFileHttpResponseHandler != null)
        paramFileHttpResponseHandler.sendFailureMessage(paramString1, exception, -2001, null); 
      return;
    } 
  }
  
  public static void b(String paramString1, String paramString2, FileHttpResponseHandler paramFileHttpResponseHandler, IRequestHost paramIRequestHost) throws OkHttpException {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2;
    Response response;
    if (!TextUtils.isEmpty(paramString1)) {
      try {
        Request request = (new Request.Builder()).a(paramString1).b("Accept", "image/webp, */*").d();
        response = a.a(request).b();
      } catch (IOException iOException) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("okHttp failed, exception:");
        stringBuilder2.append(iOException);
        Log.e("HttpManager", stringBuilder2.toString());
        throw new OkHttpException(iOException);
      } catch (Exception null) {
        if (Base64ImageUrlDownloader.a((String)iOException)) {
          Base64ImageUrlDownloader.a((String)iOException, (String)stringBuilder2, paramFileHttpResponseHandler, paramIRequestHost);
          return;
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("okHttp failed, exception:");
        stringBuilder1.append(response);
        Log.e("HttpManager", stringBuilder1.toString());
        throw new OkHttpException(response);
      } 
    } else {
      response = null;
    } 
    b(response, (String)stringBuilder1, (String)stringBuilder2, paramFileHttpResponseHandler, paramIRequestHost);
  }
  
  private static void b(Response paramResponse, String paramString1, String paramString2, FileHttpResponseHandler paramFileHttpResponseHandler, IRequestHost paramIRequestHost) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 30
    //   7: aload_3
    //   8: ifnull -> 29
    //   11: aload_3
    //   12: aload_1
    //   13: new java/lang/Exception
    //   16: dup
    //   17: ldc 'url is empty'
    //   19: invokespecial <init> : (Ljava/lang/String;)V
    //   22: sipush #-1002
    //   25: aconst_null
    //   26: invokevirtual sendFailureMessage : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   29: return
    //   30: aload_0
    //   31: invokevirtual h : ()Lokhttp3/ResponseBody;
    //   34: astore #15
    //   36: aload_0
    //   37: ifnull -> 874
    //   40: aload #15
    //   42: ifnonnull -> 48
    //   45: goto -> 874
    //   48: aload_0
    //   49: invokevirtual d : ()Z
    //   52: ifne -> 103
    //   55: aload_3
    //   56: ifnull -> 97
    //   59: aload_0
    //   60: invokevirtual e : ()Ljava/lang/String;
    //   63: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   66: ifeq -> 74
    //   69: aconst_null
    //   70: astore_2
    //   71: goto -> 86
    //   74: new java/lang/Exception
    //   77: dup
    //   78: aload_0
    //   79: invokevirtual e : ()Ljava/lang/String;
    //   82: invokespecial <init> : (Ljava/lang/String;)V
    //   85: astore_2
    //   86: aload_3
    //   87: aload_1
    //   88: aload_2
    //   89: aload_0
    //   90: invokevirtual c : ()I
    //   93: aconst_null
    //   94: invokevirtual sendFailureMessage : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   97: aload #15
    //   99: invokevirtual close : ()V
    //   102: return
    //   103: aload #15
    //   105: invokevirtual b : ()J
    //   108: lstore #8
    //   110: aload_3
    //   111: ifnull -> 140
    //   114: aload_3
    //   115: aload_0
    //   116: invokevirtual c : ()I
    //   119: lload #8
    //   121: invokevirtual onAccept : (IJ)Z
    //   124: ifne -> 140
    //   127: aload_3
    //   128: ldc_w 'responseHandler not accept'
    //   131: invokevirtual sendCancelMessage : (Ljava/lang/String;)V
    //   134: aload #15
    //   136: invokevirtual close : ()V
    //   139: return
    //   140: new java/io/File
    //   143: dup
    //   144: aload_2
    //   145: invokespecial <init> : (Ljava/lang/String;)V
    //   148: astore #16
    //   150: aload #16
    //   152: invokevirtual exists : ()Z
    //   155: ifne -> 164
    //   158: aload #16
    //   160: invokevirtual createNewFile : ()Z
    //   163: pop
    //   164: new java/io/FileOutputStream
    //   167: dup
    //   168: aload #16
    //   170: invokespecial <init> : (Ljava/io/File;)V
    //   173: astore_2
    //   174: aload #15
    //   176: invokevirtual d : ()Ljava/io/InputStream;
    //   179: astore #13
    //   181: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   184: sipush #1024
    //   187: invokevirtual a : (I)[B
    //   190: astore #14
    //   192: iconst_0
    //   193: istore #5
    //   195: aload #13
    //   197: astore #10
    //   199: aload #14
    //   201: astore #11
    //   203: aload_2
    //   204: astore #12
    //   206: aload #13
    //   208: aload #14
    //   210: invokevirtual read : ([B)I
    //   213: istore #6
    //   215: iload #6
    //   217: iconst_m1
    //   218: if_icmpeq -> 459
    //   221: aload #4
    //   223: ifnull -> 300
    //   226: aload #13
    //   228: astore #10
    //   230: aload #14
    //   232: astore #11
    //   234: aload_2
    //   235: astore #12
    //   237: aload #4
    //   239: invokeinterface isActive : ()Z
    //   244: ifne -> 300
    //   247: aload_3
    //   248: ifnull -> 269
    //   251: aload #13
    //   253: astore #10
    //   255: aload #14
    //   257: astore #11
    //   259: aload_2
    //   260: astore #12
    //   262: aload_3
    //   263: ldc_w 'requestHost isnot active'
    //   266: invokevirtual sendCancelMessage : (Ljava/lang/String;)V
    //   269: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   272: aload #14
    //   274: invokevirtual a : ([B)V
    //   277: aload #13
    //   279: invokestatic b : (Ljava/io/InputStream;)V
    //   282: aload_2
    //   283: invokestatic a : (Ljava/io/OutputStream;)V
    //   286: aload #15
    //   288: invokevirtual close : ()V
    //   291: aload_3
    //   292: ifnull -> 299
    //   295: aload_3
    //   296: invokevirtual sendFinishMessage : ()V
    //   299: return
    //   300: aload_3
    //   301: ifnull -> 371
    //   304: aload #13
    //   306: astore #10
    //   308: aload #14
    //   310: astore #11
    //   312: aload_2
    //   313: astore #12
    //   315: aload_3
    //   316: invokevirtual isCancelled : ()Z
    //   319: ifeq -> 371
    //   322: aload #13
    //   324: astore #10
    //   326: aload #14
    //   328: astore #11
    //   330: aload_2
    //   331: astore #12
    //   333: aload_3
    //   334: ldc_w 'requestHost is cancelled'
    //   337: invokevirtual sendCancelMessage : (Ljava/lang/String;)V
    //   340: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   343: aload #14
    //   345: invokevirtual a : ([B)V
    //   348: aload #13
    //   350: invokestatic b : (Ljava/io/InputStream;)V
    //   353: aload_2
    //   354: invokestatic a : (Ljava/io/OutputStream;)V
    //   357: aload #15
    //   359: invokevirtual close : ()V
    //   362: aload_3
    //   363: ifnull -> 370
    //   366: aload_3
    //   367: invokevirtual sendFinishMessage : ()V
    //   370: return
    //   371: aload #13
    //   373: astore #10
    //   375: aload #14
    //   377: astore #11
    //   379: aload_2
    //   380: astore #12
    //   382: aload_2
    //   383: aload #14
    //   385: iconst_0
    //   386: iload #6
    //   388: invokevirtual write : ([BII)V
    //   391: iload #5
    //   393: iload #6
    //   395: iadd
    //   396: istore #6
    //   398: aload #13
    //   400: astore #10
    //   402: aload #14
    //   404: astore #11
    //   406: aload_2
    //   407: astore #12
    //   409: iload #6
    //   411: i2f
    //   412: fconst_1
    //   413: fmul
    //   414: lload #8
    //   416: l2f
    //   417: fdiv
    //   418: ldc_w 100.0
    //   421: fmul
    //   422: f2i
    //   423: istore #7
    //   425: iload #6
    //   427: istore #5
    //   429: aload_3
    //   430: ifnull -> 195
    //   433: aload #13
    //   435: astore #10
    //   437: aload #14
    //   439: astore #11
    //   441: aload_2
    //   442: astore #12
    //   444: aload_3
    //   445: iload #7
    //   447: iload #6
    //   449: invokevirtual sendProgressMessage : (II)V
    //   452: iload #6
    //   454: istore #5
    //   456: goto -> 195
    //   459: aload #13
    //   461: astore #10
    //   463: aload #14
    //   465: astore #11
    //   467: aload_2
    //   468: astore #12
    //   470: aload_2
    //   471: invokevirtual flush : ()V
    //   474: aload_3
    //   475: ifnull -> 500
    //   478: aload #13
    //   480: astore #10
    //   482: aload #14
    //   484: astore #11
    //   486: aload_2
    //   487: astore #12
    //   489: aload_3
    //   490: aload_1
    //   491: aload_0
    //   492: invokevirtual c : ()I
    //   495: aload #16
    //   497: invokevirtual sendSuccessMessage : (Ljava/lang/String;ILjava/lang/Object;)V
    //   500: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   503: aload #14
    //   505: invokevirtual a : ([B)V
    //   508: aload #13
    //   510: invokestatic b : (Ljava/io/InputStream;)V
    //   513: aload_2
    //   514: invokestatic a : (Ljava/io/OutputStream;)V
    //   517: aload #15
    //   519: invokevirtual close : ()V
    //   522: aload_3
    //   523: ifnull -> 837
    //   526: goto -> 833
    //   529: astore_0
    //   530: goto -> 610
    //   533: astore_0
    //   534: goto -> 688
    //   537: astore_0
    //   538: goto -> 766
    //   541: astore_0
    //   542: aconst_null
    //   543: astore #11
    //   545: aload #13
    //   547: astore #10
    //   549: goto -> 842
    //   552: astore_0
    //   553: aconst_null
    //   554: astore #14
    //   556: goto -> 610
    //   559: astore_0
    //   560: aconst_null
    //   561: astore #14
    //   563: goto -> 688
    //   566: astore_0
    //   567: aconst_null
    //   568: astore #14
    //   570: goto -> 766
    //   573: astore_0
    //   574: goto -> 592
    //   577: astore_0
    //   578: goto -> 604
    //   581: astore_0
    //   582: goto -> 682
    //   585: astore_0
    //   586: goto -> 760
    //   589: astore_0
    //   590: aconst_null
    //   591: astore_2
    //   592: aconst_null
    //   593: astore #10
    //   595: aconst_null
    //   596: astore #11
    //   598: goto -> 842
    //   601: astore_0
    //   602: aconst_null
    //   603: astore_2
    //   604: aconst_null
    //   605: astore #13
    //   607: aconst_null
    //   608: astore #14
    //   610: aload #13
    //   612: astore #10
    //   614: aload #14
    //   616: astore #11
    //   618: aload_2
    //   619: astore #12
    //   621: aload_0
    //   622: invokevirtual printStackTrace : ()V
    //   625: aload_3
    //   626: ifnull -> 650
    //   629: aload #13
    //   631: astore #10
    //   633: aload #14
    //   635: astore #11
    //   637: aload_2
    //   638: astore #12
    //   640: aload_3
    //   641: aload_1
    //   642: aload_0
    //   643: sipush #-3001
    //   646: aconst_null
    //   647: invokevirtual sendFailureMessage : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   650: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   653: aload #14
    //   655: invokevirtual a : ([B)V
    //   658: aload #13
    //   660: invokestatic b : (Ljava/io/InputStream;)V
    //   663: aload_2
    //   664: invokestatic a : (Ljava/io/OutputStream;)V
    //   667: aload #15
    //   669: invokevirtual close : ()V
    //   672: aload_3
    //   673: ifnull -> 837
    //   676: goto -> 833
    //   679: astore_0
    //   680: aconst_null
    //   681: astore_2
    //   682: aconst_null
    //   683: astore #13
    //   685: aconst_null
    //   686: astore #14
    //   688: aload #13
    //   690: astore #10
    //   692: aload #14
    //   694: astore #11
    //   696: aload_2
    //   697: astore #12
    //   699: aload_0
    //   700: invokevirtual printStackTrace : ()V
    //   703: aload_3
    //   704: ifnull -> 728
    //   707: aload #13
    //   709: astore #10
    //   711: aload #14
    //   713: astore #11
    //   715: aload_2
    //   716: astore #12
    //   718: aload_3
    //   719: aload_1
    //   720: aload_0
    //   721: sipush #-2001
    //   724: aconst_null
    //   725: invokevirtual sendFailureMessage : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   728: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   731: aload #14
    //   733: invokevirtual a : ([B)V
    //   736: aload #13
    //   738: invokestatic b : (Ljava/io/InputStream;)V
    //   741: aload_2
    //   742: invokestatic a : (Ljava/io/OutputStream;)V
    //   745: aload #15
    //   747: invokevirtual close : ()V
    //   750: aload_3
    //   751: ifnull -> 837
    //   754: goto -> 833
    //   757: astore_0
    //   758: aconst_null
    //   759: astore_2
    //   760: aconst_null
    //   761: astore #13
    //   763: aconst_null
    //   764: astore #14
    //   766: aload #13
    //   768: astore #10
    //   770: aload #14
    //   772: astore #11
    //   774: aload_2
    //   775: astore #12
    //   777: aload_0
    //   778: invokevirtual printStackTrace : ()V
    //   781: aload_3
    //   782: ifnull -> 807
    //   785: aload #13
    //   787: astore #10
    //   789: aload #14
    //   791: astore #11
    //   793: aload_2
    //   794: astore #12
    //   796: aload_3
    //   797: aload_1
    //   798: aload_0
    //   799: aload_0
    //   800: invokestatic a : (Ljava/io/IOException;)I
    //   803: aconst_null
    //   804: invokevirtual sendFailureMessage : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   807: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   810: aload #14
    //   812: invokevirtual a : ([B)V
    //   815: aload #13
    //   817: invokestatic b : (Ljava/io/InputStream;)V
    //   820: aload_2
    //   821: invokestatic a : (Ljava/io/OutputStream;)V
    //   824: aload #15
    //   826: invokevirtual close : ()V
    //   829: aload_3
    //   830: ifnull -> 837
    //   833: aload_3
    //   834: invokevirtual sendFinishMessage : ()V
    //   837: return
    //   838: astore_0
    //   839: aload #12
    //   841: astore_2
    //   842: getstatic com/blued/android/core/utils/ByteArrayPool.a : Lcom/blued/android/core/utils/ByteArrayPool;
    //   845: aload #11
    //   847: invokevirtual a : ([B)V
    //   850: aload #10
    //   852: invokestatic b : (Ljava/io/InputStream;)V
    //   855: aload_2
    //   856: invokestatic a : (Ljava/io/OutputStream;)V
    //   859: aload #15
    //   861: invokevirtual close : ()V
    //   864: aload_3
    //   865: ifnull -> 872
    //   868: aload_3
    //   869: invokevirtual sendFinishMessage : ()V
    //   872: aload_0
    //   873: athrow
    //   874: aload_3
    //   875: ifnull -> 897
    //   878: aload_3
    //   879: aload_1
    //   880: new java/lang/Exception
    //   883: dup
    //   884: ldc_w 'response is null'
    //   887: invokespecial <init> : (Ljava/lang/String;)V
    //   890: sipush #-1001
    //   893: aconst_null
    //   894: invokevirtual sendFailureMessage : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   897: return
    // Exception table:
    //   from	to	target	type
    //   140	164	757	java/io/IOException
    //   140	164	679	java/lang/Exception
    //   140	164	601	java/lang/OutOfMemoryError
    //   140	164	589	finally
    //   164	174	757	java/io/IOException
    //   164	174	679	java/lang/Exception
    //   164	174	601	java/lang/OutOfMemoryError
    //   164	174	589	finally
    //   174	181	585	java/io/IOException
    //   174	181	581	java/lang/Exception
    //   174	181	577	java/lang/OutOfMemoryError
    //   174	181	573	finally
    //   181	192	566	java/io/IOException
    //   181	192	559	java/lang/Exception
    //   181	192	552	java/lang/OutOfMemoryError
    //   181	192	541	finally
    //   206	215	537	java/io/IOException
    //   206	215	533	java/lang/Exception
    //   206	215	529	java/lang/OutOfMemoryError
    //   206	215	838	finally
    //   237	247	537	java/io/IOException
    //   237	247	533	java/lang/Exception
    //   237	247	529	java/lang/OutOfMemoryError
    //   237	247	838	finally
    //   262	269	537	java/io/IOException
    //   262	269	533	java/lang/Exception
    //   262	269	529	java/lang/OutOfMemoryError
    //   262	269	838	finally
    //   315	322	537	java/io/IOException
    //   315	322	533	java/lang/Exception
    //   315	322	529	java/lang/OutOfMemoryError
    //   315	322	838	finally
    //   333	340	537	java/io/IOException
    //   333	340	533	java/lang/Exception
    //   333	340	529	java/lang/OutOfMemoryError
    //   333	340	838	finally
    //   382	391	537	java/io/IOException
    //   382	391	533	java/lang/Exception
    //   382	391	529	java/lang/OutOfMemoryError
    //   382	391	838	finally
    //   409	425	537	java/io/IOException
    //   409	425	533	java/lang/Exception
    //   409	425	529	java/lang/OutOfMemoryError
    //   409	425	838	finally
    //   444	452	537	java/io/IOException
    //   444	452	533	java/lang/Exception
    //   444	452	529	java/lang/OutOfMemoryError
    //   444	452	838	finally
    //   470	474	537	java/io/IOException
    //   470	474	533	java/lang/Exception
    //   470	474	529	java/lang/OutOfMemoryError
    //   470	474	838	finally
    //   489	500	537	java/io/IOException
    //   489	500	533	java/lang/Exception
    //   489	500	529	java/lang/OutOfMemoryError
    //   489	500	838	finally
    //   621	625	838	finally
    //   640	650	838	finally
    //   699	703	838	finally
    //   718	728	838	finally
    //   777	781	838	finally
    //   796	807	838	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\OkHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */