package org.chromium.components.minidump_uploader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.components.minidump_uploader.util.CrashReportingPermissionManager;
import org.chromium.components.minidump_uploader.util.HttpURLConnectionFactory;
import org.chromium.components.minidump_uploader.util.HttpURLConnectionFactoryImpl;

public final class MinidumpUploadCallable implements Callable {
  private final File mFileToUpload;
  
  private final HttpURLConnectionFactory mHttpURLConnectionFactory;
  
  private final File mLogfile;
  
  private final CrashReportingPermissionManager mPermManager;
  
  public MinidumpUploadCallable(File paramFile1, File paramFile2, CrashReportingPermissionManager paramCrashReportingPermissionManager) {
    this(paramFile1, paramFile2, (HttpURLConnectionFactory)new HttpURLConnectionFactoryImpl(), paramCrashReportingPermissionManager);
    ContextUtils.Holder.access$100().edit().remove("crash_day_dump_upload_count").remove("crash_dump_last_upload_day").remove("crash_dump_last_upload_week").remove("crash_dump_week_upload_size").apply();
  }
  
  private MinidumpUploadCallable(File paramFile1, File paramFile2, HttpURLConnectionFactory paramHttpURLConnectionFactory, CrashReportingPermissionManager paramCrashReportingPermissionManager) {
    this.mFileToUpload = paramFile1;
    this.mLogfile = paramFile2;
    this.mHttpURLConnectionFactory = paramHttpURLConnectionFactory;
    this.mPermManager = paramCrashReportingPermissionManager;
  }
  
  private Boolean handleExecutionResponse(HttpURLConnection paramHttpURLConnection) {
    boolean bool;
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200 || i == 201 || i == 202) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      String str;
      HttpURLConnection httpURLConnection = null;
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      streamCopy(paramHttpURLConnection.getInputStream(), byteArrayOutputStream);
      paramHttpURLConnection = httpURLConnection;
      if (byteArrayOutputStream.size() > 0)
        str = byteArrayOutputStream.toString(); 
      if (str == null)
        str = "unknown"; 
      StringBuilder stringBuilder = new StringBuilder("Minidump ");
      stringBuilder.append(this.mFileToUpload.getName());
      stringBuilder.append(" uploaded successfully, id: ");
      stringBuilder.append(str);
      Log.i("MDUploadCallable", stringBuilder.toString(), new Object[0]);
      CrashFileManager.markUploadSuccess(this.mFileToUpload);
      try {
        FileWriter fileWriter = new FileWriter(this.mLogfile, true);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(System.currentTimeMillis() / 1000L);
        stringBuilder1.append(",");
        stringBuilder1.append(str);
        stringBuilder1.append('\n');
        try {
          fileWriter.write(stringBuilder1.toString());
        } finally {
          fileWriter.close();
        } 
      } catch (IOException iOException) {
        Log.e("MDUploadCallable", "Fail to write uploaded entry to log file", new Object[0]);
      } 
      return Boolean.valueOf(true);
    } 
    Log.i("MDUploadCallable", String.format(Locale.US, "Failed to upload %s with code: %d (%s).", new Object[] { this.mFileToUpload.getName(), Integer.valueOf(i), iOException.getResponseMessage() }), new Object[0]);
    return Boolean.valueOf(false);
  }
  
  private static void streamCopy(InputStream paramInputStream, OutputStream paramOutputStream) {
    byte[] arrayOfByte = new byte[4096];
    for (int i = paramInputStream.read(arrayOfByte); i >= 0; i = paramInputStream.read(arrayOfByte))
      paramOutputStream.write(arrayOfByte, 0, i); 
    paramInputStream.close();
    paramOutputStream.close();
  }
  
  public final Integer call() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mPermManager : Lorg/chromium/components/minidump_uploader/util/CrashReportingPermissionManager;
    //   4: invokeinterface isUploadEnabledForTests : ()Z
    //   9: ifeq -> 26
    //   12: ldc 'MDUploadCallable'
    //   14: ldc 'Minidump upload enabled for tests, skipping other checks.'
    //   16: iconst_0
    //   17: anewarray java/lang/Object
    //   20: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: goto -> 134
    //   26: aload_0
    //   27: getfield mFileToUpload : Ljava/io/File;
    //   30: invokestatic isForcedUpload : (Ljava/io/File;)Z
    //   33: ifne -> 134
    //   36: aload_0
    //   37: getfield mPermManager : Lorg/chromium/components/minidump_uploader/util/CrashReportingPermissionManager;
    //   40: invokeinterface isUsageAndCrashReportingPermittedByUser : ()Z
    //   45: ifne -> 71
    //   48: ldc 'MDUploadCallable'
    //   50: ldc 'Minidump upload is not permitted by user. Marking file as skipped for cleanup to prevent future uploads.'
    //   52: iconst_0
    //   53: anewarray java/lang/Object
    //   56: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield mFileToUpload : Ljava/io/File;
    //   63: invokestatic markUploadSkipped : (Ljava/io/File;)V
    //   66: iconst_2
    //   67: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   70: areturn
    //   71: aload_0
    //   72: getfield mPermManager : Lorg/chromium/components/minidump_uploader/util/CrashReportingPermissionManager;
    //   75: invokeinterface isClientInMetricsSample : ()Z
    //   80: ifne -> 106
    //   83: ldc 'MDUploadCallable'
    //   85: ldc 'Minidump upload skipped due to sampling.  Marking file as skipped for cleanup to prevent future uploads.'
    //   87: iconst_0
    //   88: anewarray java/lang/Object
    //   91: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_0
    //   95: getfield mFileToUpload : Ljava/io/File;
    //   98: invokestatic markUploadSkipped : (Ljava/io/File;)V
    //   101: iconst_3
    //   102: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   105: areturn
    //   106: aload_0
    //   107: getfield mPermManager : Lorg/chromium/components/minidump_uploader/util/CrashReportingPermissionManager;
    //   110: invokeinterface isNetworkAvailableForCrashUploads : ()Z
    //   115: ifne -> 134
    //   118: ldc 'MDUploadCallable'
    //   120: ldc 'Minidump cannot currently be uploaded due to network constraints.'
    //   122: iconst_0
    //   123: anewarray java/lang/Object
    //   126: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: iconst_1
    //   130: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   133: areturn
    //   134: aload_0
    //   135: getfield mHttpURLConnectionFactory : Lorg/chromium/components/minidump_uploader/util/HttpURLConnectionFactory;
    //   138: ldc 'https://clients2.google.com/cr/report'
    //   140: invokeinterface createHttpURLConnection : (Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   145: astore #7
    //   147: aload #7
    //   149: ifnonnull -> 157
    //   152: iconst_1
    //   153: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   156: areturn
    //   157: aconst_null
    //   158: astore #5
    //   160: aconst_null
    //   161: astore #6
    //   163: aload #6
    //   165: astore_3
    //   166: new java/io/BufferedReader
    //   169: dup
    //   170: new java/io/FileReader
    //   173: dup
    //   174: aload_0
    //   175: getfield mFileToUpload : Ljava/io/File;
    //   178: invokespecial <init> : (Ljava/io/File;)V
    //   181: invokespecial <init> : (Ljava/io/Reader;)V
    //   184: astore #4
    //   186: aload #6
    //   188: astore_3
    //   189: aload #4
    //   191: invokevirtual readLine : ()Ljava/lang/String;
    //   194: astore #8
    //   196: aload #6
    //   198: astore_3
    //   199: aload #4
    //   201: invokevirtual close : ()V
    //   204: aload #8
    //   206: ifnull -> 437
    //   209: aload #6
    //   211: astore_3
    //   212: aload #8
    //   214: invokevirtual trim : ()Ljava/lang/String;
    //   217: invokevirtual isEmpty : ()Z
    //   220: ifeq -> 226
    //   223: goto -> 437
    //   226: aload #6
    //   228: astore_3
    //   229: aload #8
    //   231: invokevirtual trim : ()Ljava/lang/String;
    //   234: astore #4
    //   236: aload #6
    //   238: astore_3
    //   239: aload #4
    //   241: ldc_w '--'
    //   244: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   247: ifeq -> 377
    //   250: aload #6
    //   252: astore_3
    //   253: aload #4
    //   255: invokevirtual length : ()I
    //   258: bipush #10
    //   260: if_icmpge -> 266
    //   263: goto -> 377
    //   266: aload #6
    //   268: astore_3
    //   269: aload #4
    //   271: ldc_w '^[a-zA-Z0-9-]*$'
    //   274: invokevirtual matches : (Ljava/lang/String;)Z
    //   277: ifne -> 363
    //   280: aload #6
    //   282: astore_3
    //   283: new java/lang/StringBuilder
    //   286: dup
    //   287: ldc_w 'Ignoring invalidly bound crash dump ''
    //   290: invokespecial <init> : (Ljava/lang/String;)V
    //   293: astore #8
    //   295: aload #6
    //   297: astore_3
    //   298: aload #8
    //   300: aload_0
    //   301: getfield mFileToUpload : Ljava/io/File;
    //   304: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload #6
    //   310: astore_3
    //   311: aload #8
    //   313: ldc_w '' due to invalid boundary characters: ''
    //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload #6
    //   322: astore_3
    //   323: aload #8
    //   325: aload #4
    //   327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload #6
    //   333: astore_3
    //   334: aload #8
    //   336: ldc_w '''
    //   339: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload #6
    //   345: astore_3
    //   346: ldc 'MDUploadCallable'
    //   348: aload #8
    //   350: invokevirtual toString : ()Ljava/lang/String;
    //   353: iconst_0
    //   354: anewarray java/lang/Object
    //   357: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: goto -> 751
    //   363: aload #6
    //   365: astore_3
    //   366: aload #4
    //   368: iconst_2
    //   369: invokevirtual substring : (I)Ljava/lang/String;
    //   372: astore #4
    //   374: goto -> 754
    //   377: aload #6
    //   379: astore_3
    //   380: new java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 'Ignoring invalidly bound crash dump: ''
    //   387: invokespecial <init> : (Ljava/lang/String;)V
    //   390: astore #4
    //   392: aload #6
    //   394: astore_3
    //   395: aload #4
    //   397: aload_0
    //   398: getfield mFileToUpload : Ljava/io/File;
    //   401: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload #6
    //   407: astore_3
    //   408: aload #4
    //   410: ldc_w '''
    //   413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload #6
    //   419: astore_3
    //   420: ldc 'MDUploadCallable'
    //   422: aload #4
    //   424: invokevirtual toString : ()Ljava/lang/String;
    //   427: iconst_0
    //   428: anewarray java/lang/Object
    //   431: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: goto -> 751
    //   437: aload #6
    //   439: astore_3
    //   440: new java/lang/StringBuilder
    //   443: dup
    //   444: ldc_w 'Ignoring invalid crash dump: ''
    //   447: invokespecial <init> : (Ljava/lang/String;)V
    //   450: astore #4
    //   452: aload #6
    //   454: astore_3
    //   455: aload #4
    //   457: aload_0
    //   458: getfield mFileToUpload : Ljava/io/File;
    //   461: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload #6
    //   467: astore_3
    //   468: aload #4
    //   470: ldc_w '''
    //   473: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload #6
    //   479: astore_3
    //   480: ldc 'MDUploadCallable'
    //   482: aload #4
    //   484: invokevirtual toString : ()Ljava/lang/String;
    //   487: iconst_0
    //   488: anewarray java/lang/Object
    //   491: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   494: goto -> 751
    //   497: aload #6
    //   499: astore_3
    //   500: aload #7
    //   502: iconst_1
    //   503: invokevirtual setDoOutput : (Z)V
    //   506: aload #6
    //   508: astore_3
    //   509: aload #7
    //   511: ldc_w 'Connection'
    //   514: ldc_w 'Keep-Alive'
    //   517: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload #6
    //   522: astore_3
    //   523: aload #7
    //   525: ldc_w 'Content-Encoding'
    //   528: ldc_w 'gzip'
    //   531: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload #6
    //   536: astore_3
    //   537: aload #7
    //   539: ldc_w 'Content-Type'
    //   542: ldc_w 'multipart/form-data; boundary=%s'
    //   545: iconst_1
    //   546: anewarray java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload #4
    //   553: aastore
    //   554: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   557: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   560: iconst_1
    //   561: istore_1
    //   562: iload_1
    //   563: ifne -> 576
    //   566: aload #7
    //   568: invokevirtual disconnect : ()V
    //   571: iconst_1
    //   572: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   575: areturn
    //   576: aload #6
    //   578: astore_3
    //   579: new java/io/FileInputStream
    //   582: dup
    //   583: aload_0
    //   584: getfield mFileToUpload : Ljava/io/File;
    //   587: invokespecial <init> : (Ljava/io/File;)V
    //   590: astore #4
    //   592: aload #4
    //   594: new java/util/zip/GZIPOutputStream
    //   597: dup
    //   598: aload #7
    //   600: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   603: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   606: invokestatic streamCopy : (Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   609: aload_0
    //   610: aload #7
    //   612: invokespecial handleExecutionResponse : (Ljava/net/HttpURLConnection;)Ljava/lang/Boolean;
    //   615: invokevirtual booleanValue : ()Z
    //   618: istore_2
    //   619: aload #7
    //   621: invokevirtual disconnect : ()V
    //   624: aload #4
    //   626: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   629: iload_2
    //   630: iconst_1
    //   631: ixor
    //   632: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   635: areturn
    //   636: astore #5
    //   638: aload #4
    //   640: astore_3
    //   641: goto -> 735
    //   644: astore #5
    //   646: goto -> 662
    //   649: astore #5
    //   651: goto -> 735
    //   654: astore_3
    //   655: aload #5
    //   657: astore #4
    //   659: aload_3
    //   660: astore #5
    //   662: aload #4
    //   664: astore_3
    //   665: new java/lang/StringBuilder
    //   668: dup
    //   669: ldc_w 'Error while uploading '
    //   672: invokespecial <init> : (Ljava/lang/String;)V
    //   675: astore #6
    //   677: aload #4
    //   679: astore_3
    //   680: aload #6
    //   682: aload_0
    //   683: getfield mFileToUpload : Ljava/io/File;
    //   686: invokevirtual getName : ()Ljava/lang/String;
    //   689: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload #4
    //   695: astore_3
    //   696: ldc 'MDUploadCallable'
    //   698: aload #6
    //   700: invokevirtual toString : ()Ljava/lang/String;
    //   703: iconst_1
    //   704: anewarray java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: aload #5
    //   711: aastore
    //   712: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   715: aload #7
    //   717: invokevirtual disconnect : ()V
    //   720: aload #4
    //   722: ifnull -> 730
    //   725: aload #4
    //   727: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   730: iconst_1
    //   731: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   734: areturn
    //   735: aload #7
    //   737: invokevirtual disconnect : ()V
    //   740: aload_3
    //   741: ifnull -> 748
    //   744: aload_3
    //   745: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   748: aload #5
    //   750: athrow
    //   751: aconst_null
    //   752: astore #4
    //   754: aload #4
    //   756: ifnonnull -> 497
    //   759: iconst_0
    //   760: istore_1
    //   761: goto -> 562
    // Exception table:
    //   from	to	target	type
    //   166	186	654	java/io/IOException
    //   166	186	654	java/lang/ArrayIndexOutOfBoundsException
    //   166	186	649	finally
    //   189	196	654	java/io/IOException
    //   189	196	654	java/lang/ArrayIndexOutOfBoundsException
    //   189	196	649	finally
    //   199	204	654	java/io/IOException
    //   199	204	654	java/lang/ArrayIndexOutOfBoundsException
    //   199	204	649	finally
    //   212	223	654	java/io/IOException
    //   212	223	654	java/lang/ArrayIndexOutOfBoundsException
    //   212	223	649	finally
    //   229	236	654	java/io/IOException
    //   229	236	654	java/lang/ArrayIndexOutOfBoundsException
    //   229	236	649	finally
    //   239	250	654	java/io/IOException
    //   239	250	654	java/lang/ArrayIndexOutOfBoundsException
    //   239	250	649	finally
    //   253	263	654	java/io/IOException
    //   253	263	654	java/lang/ArrayIndexOutOfBoundsException
    //   253	263	649	finally
    //   269	280	654	java/io/IOException
    //   269	280	654	java/lang/ArrayIndexOutOfBoundsException
    //   269	280	649	finally
    //   283	295	654	java/io/IOException
    //   283	295	654	java/lang/ArrayIndexOutOfBoundsException
    //   283	295	649	finally
    //   298	308	654	java/io/IOException
    //   298	308	654	java/lang/ArrayIndexOutOfBoundsException
    //   298	308	649	finally
    //   311	320	654	java/io/IOException
    //   311	320	654	java/lang/ArrayIndexOutOfBoundsException
    //   311	320	649	finally
    //   323	331	654	java/io/IOException
    //   323	331	654	java/lang/ArrayIndexOutOfBoundsException
    //   323	331	649	finally
    //   334	343	654	java/io/IOException
    //   334	343	654	java/lang/ArrayIndexOutOfBoundsException
    //   334	343	649	finally
    //   346	360	654	java/io/IOException
    //   346	360	654	java/lang/ArrayIndexOutOfBoundsException
    //   346	360	649	finally
    //   366	374	654	java/io/IOException
    //   366	374	654	java/lang/ArrayIndexOutOfBoundsException
    //   366	374	649	finally
    //   380	392	654	java/io/IOException
    //   380	392	654	java/lang/ArrayIndexOutOfBoundsException
    //   380	392	649	finally
    //   395	405	654	java/io/IOException
    //   395	405	654	java/lang/ArrayIndexOutOfBoundsException
    //   395	405	649	finally
    //   408	417	654	java/io/IOException
    //   408	417	654	java/lang/ArrayIndexOutOfBoundsException
    //   408	417	649	finally
    //   420	434	654	java/io/IOException
    //   420	434	654	java/lang/ArrayIndexOutOfBoundsException
    //   420	434	649	finally
    //   440	452	654	java/io/IOException
    //   440	452	654	java/lang/ArrayIndexOutOfBoundsException
    //   440	452	649	finally
    //   455	465	654	java/io/IOException
    //   455	465	654	java/lang/ArrayIndexOutOfBoundsException
    //   455	465	649	finally
    //   468	477	654	java/io/IOException
    //   468	477	654	java/lang/ArrayIndexOutOfBoundsException
    //   468	477	649	finally
    //   480	494	654	java/io/IOException
    //   480	494	654	java/lang/ArrayIndexOutOfBoundsException
    //   480	494	649	finally
    //   500	506	654	java/io/IOException
    //   500	506	654	java/lang/ArrayIndexOutOfBoundsException
    //   500	506	649	finally
    //   509	520	654	java/io/IOException
    //   509	520	654	java/lang/ArrayIndexOutOfBoundsException
    //   509	520	649	finally
    //   523	534	654	java/io/IOException
    //   523	534	654	java/lang/ArrayIndexOutOfBoundsException
    //   523	534	649	finally
    //   537	560	654	java/io/IOException
    //   537	560	654	java/lang/ArrayIndexOutOfBoundsException
    //   537	560	649	finally
    //   579	592	654	java/io/IOException
    //   579	592	654	java/lang/ArrayIndexOutOfBoundsException
    //   579	592	649	finally
    //   592	619	644	java/io/IOException
    //   592	619	644	java/lang/ArrayIndexOutOfBoundsException
    //   592	619	636	finally
    //   665	677	649	finally
    //   680	693	649	finally
    //   696	715	649	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\minidump_uploader\MinidumpUploadCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */