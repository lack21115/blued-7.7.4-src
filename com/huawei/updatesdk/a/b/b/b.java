package com.huawei.updatesdk.a.b.b;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.d;
import com.huawei.updatesdk.b.c.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class b extends AsyncTask<Void, Void, Void> {
  private String a = "com.huawei.appmarket";
  
  private HttpURLConnection b;
  
  private boolean c = false;
  
  private a d;
  
  private Handler e = new b(null);
  
  public b(a parama) {
    this.d = parama;
    if (!TextUtils.isEmpty(parama.c()))
      this.a = parama.c(); 
  }
  
  private void a(int paramInt1, long paramLong, String paramString, int paramInt2) {
    a a1 = new a();
    a1.a(paramInt1);
    a1.a(paramLong);
    a1.a(paramString);
    Handler handler = this.e;
    if (handler == null)
      return; 
    handler.sendMessage(handler.obtainMessage(paramInt2, a1));
  }
  
  private void a(a parama, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 267
    //   4: aload_1
    //   5: invokevirtual b : ()Ljava/lang/String;
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: ifeq -> 15
    //   14: return
    //   15: new java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore_3
    //   23: aload_3
    //   24: aload_2
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: ldc '/appmarket.apk'
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual toString : ()Ljava/lang/String;
    //   40: astore #6
    //   42: new java/io/File
    //   45: dup
    //   46: aload #6
    //   48: invokespecial <init> : (Ljava/lang/String;)V
    //   51: astore_3
    //   52: aconst_null
    //   53: astore #4
    //   55: aconst_null
    //   56: astore #5
    //   58: aconst_null
    //   59: astore_2
    //   60: new java/io/FileOutputStream
    //   63: dup
    //   64: aload_3
    //   65: invokespecial <init> : (Ljava/io/File;)V
    //   68: astore_3
    //   69: aload_0
    //   70: aload_1
    //   71: aload_3
    //   72: aload #6
    //   74: invokespecial a : (Lcom/huawei/updatesdk/a/b/b/a;Ljava/io/OutputStream;Ljava/lang/String;)Z
    //   77: ifne -> 94
    //   80: new java/io/File
    //   83: dup
    //   84: invokestatic e : ()Ljava/lang/String;
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: invokestatic a : (Ljava/io/File;)Z
    //   93: pop
    //   94: aload_3
    //   95: invokevirtual close : ()V
    //   98: return
    //   99: astore_1
    //   100: aload_3
    //   101: astore_2
    //   102: goto -> 247
    //   105: astore_2
    //   106: aload_3
    //   107: astore_1
    //   108: aload_2
    //   109: astore_3
    //   110: goto -> 129
    //   113: astore_2
    //   114: aload_3
    //   115: astore_1
    //   116: aload_2
    //   117: astore_3
    //   118: goto -> 187
    //   121: astore_1
    //   122: goto -> 247
    //   125: astore_3
    //   126: aload #4
    //   128: astore_1
    //   129: aload_1
    //   130: astore_2
    //   131: new java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial <init> : ()V
    //   138: astore #4
    //   140: aload_1
    //   141: astore_2
    //   142: aload #4
    //   144: ldc 'DOWNLOAD market package Exception error:'
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: astore_2
    //   152: aload #4
    //   154: aload_3
    //   155: invokevirtual toString : ()Ljava/lang/String;
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_1
    //   163: astore_2
    //   164: ldc 'DownloadMarketTask'
    //   166: aload #4
    //   168: invokevirtual toString : ()Ljava/lang/String;
    //   171: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_1
    //   175: ifnull -> 246
    //   178: aload_1
    //   179: invokevirtual close : ()V
    //   182: return
    //   183: astore_3
    //   184: aload #5
    //   186: astore_1
    //   187: aload_1
    //   188: astore_2
    //   189: new java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial <init> : ()V
    //   196: astore #4
    //   198: aload_1
    //   199: astore_2
    //   200: aload #4
    //   202: ldc 'DOWNLOAD market package FileNotFoundException error:'
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_1
    //   209: astore_2
    //   210: aload #4
    //   212: aload_3
    //   213: invokevirtual toString : ()Ljava/lang/String;
    //   216: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_1
    //   221: astore_2
    //   222: ldc 'DownloadMarketTask'
    //   224: aload #4
    //   226: invokevirtual toString : ()Ljava/lang/String;
    //   229: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_1
    //   233: ifnull -> 246
    //   236: goto -> 178
    //   239: ldc 'DownloadMarketTask'
    //   241: ldc 'Close FileOutputStream failed!'
    //   243: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   246: return
    //   247: aload_2
    //   248: ifnull -> 265
    //   251: aload_2
    //   252: invokevirtual close : ()V
    //   255: goto -> 265
    //   258: ldc 'DownloadMarketTask'
    //   260: ldc 'Close FileOutputStream failed!'
    //   262: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_1
    //   266: athrow
    //   267: return
    //   268: astore_1
    //   269: goto -> 239
    //   272: astore_2
    //   273: goto -> 258
    // Exception table:
    //   from	to	target	type
    //   60	69	183	java/io/FileNotFoundException
    //   60	69	125	java/lang/Exception
    //   60	69	121	finally
    //   69	94	113	java/io/FileNotFoundException
    //   69	94	105	java/lang/Exception
    //   69	94	99	finally
    //   94	98	268	java/io/IOException
    //   131	140	121	finally
    //   142	150	121	finally
    //   152	162	121	finally
    //   164	174	121	finally
    //   178	182	268	java/io/IOException
    //   189	198	121	finally
    //   200	208	121	finally
    //   210	220	121	finally
    //   222	232	121	finally
    //   251	255	272	java/io/IOException
  }
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream) {
    if (paramInputStream != null)
      try {
        paramInputStream.close();
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("downloadUrlToStream(String urlString,OutputStream outputStream) ");
        stringBuilder.append(iOException.toString());
        com.huawei.updatesdk.a.a.b.a.a.a.b("DownloadMarketTask", stringBuilder.toString());
      }  
    if (paramOutputStream != null)
      try {
        paramOutputStream.close();
        return;
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("downloadUrlToStream(String urlString,OutputStream outputStream) ");
        stringBuilder.append(iOException.toString());
        com.huawei.updatesdk.a.a.b.a.a.a.b("DownloadMarketTask", stringBuilder.toString());
      }  
  }
  
  private boolean a(a parama, OutputStream paramOutputStream, String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #8
    //   3: aconst_null
    //   4: astore #19
    //   6: aconst_null
    //   7: astore #16
    //   9: aconst_null
    //   10: astore #14
    //   12: aconst_null
    //   13: astore #17
    //   15: aconst_null
    //   16: astore #18
    //   18: aconst_null
    //   19: astore #20
    //   21: aconst_null
    //   22: astore #15
    //   24: ldc2_w -1
    //   27: lstore #12
    //   29: iconst_0
    //   30: istore #5
    //   32: iconst_0
    //   33: istore #6
    //   35: iconst_0
    //   36: istore #4
    //   38: aload_0
    //   39: invokestatic a : ()Lcom/huawei/updatesdk/a/b/b/c;
    //   42: aload_1
    //   43: invokevirtual b : ()Ljava/lang/String;
    //   46: invokevirtual a : (Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   49: putfield b : Ljava/net/HttpURLConnection;
    //   52: aload_0
    //   53: getfield b : Ljava/net/HttpURLConnection;
    //   56: astore #21
    //   58: aload #21
    //   60: ifnonnull -> 121
    //   63: aload_0
    //   64: getfield c : Z
    //   67: istore #8
    //   69: aload_0
    //   70: getfield a : Ljava/lang/String;
    //   73: astore_1
    //   74: iload #8
    //   76: ifeq -> 85
    //   79: iconst_3
    //   80: istore #4
    //   82: goto -> 88
    //   85: iconst_5
    //   86: istore #4
    //   88: aload_0
    //   89: iconst_0
    //   90: ldc2_w -1
    //   93: aload_1
    //   94: iload #4
    //   96: invokespecial a : (IJLjava/lang/String;I)V
    //   99: aload_0
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokespecial a : (Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   105: invokestatic a : ()Ljava/util/List;
    //   108: aload_0
    //   109: invokeinterface remove : (Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_0
    //   116: invokespecial d : ()V
    //   119: iconst_0
    //   120: ireturn
    //   121: aload_0
    //   122: getfield b : Ljava/net/HttpURLConnection;
    //   125: invokevirtual connect : ()V
    //   128: aload_0
    //   129: getfield b : Ljava/net/HttpURLConnection;
    //   132: invokevirtual getResponseCode : ()I
    //   135: istore #7
    //   137: sipush #200
    //   140: iload #7
    //   142: if_icmpeq -> 181
    //   145: sipush #206
    //   148: iload #7
    //   150: if_icmpeq -> 181
    //   153: aload_0
    //   154: getfield c : Z
    //   157: istore #8
    //   159: aload_0
    //   160: getfield a : Ljava/lang/String;
    //   163: astore_1
    //   164: iload #8
    //   166: ifeq -> 175
    //   169: iconst_3
    //   170: istore #4
    //   172: goto -> 88
    //   175: iconst_5
    //   176: istore #4
    //   178: goto -> 88
    //   181: aload_1
    //   182: invokevirtual e : ()J
    //   185: lstore #10
    //   187: new java/io/BufferedInputStream
    //   190: dup
    //   191: aload_0
    //   192: getfield b : Ljava/net/HttpURLConnection;
    //   195: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   198: sipush #8192
    //   201: invokespecial <init> : (Ljava/io/InputStream;I)V
    //   204: astore #14
    //   206: new java/io/BufferedOutputStream
    //   209: dup
    //   210: aload_2
    //   211: sipush #8192
    //   214: invokespecial <init> : (Ljava/io/OutputStream;I)V
    //   217: astore_2
    //   218: sipush #8192
    //   221: newarray byte
    //   223: astore #20
    //   225: lconst_0
    //   226: lstore #12
    //   228: iconst_0
    //   229: istore #4
    //   231: iload #4
    //   233: istore #5
    //   235: aload #14
    //   237: aload #20
    //   239: invokevirtual read : ([B)I
    //   242: istore #6
    //   244: iload #6
    //   246: iconst_m1
    //   247: if_icmpeq -> 350
    //   250: aload_2
    //   251: aload #20
    //   253: iconst_0
    //   254: iload #6
    //   256: invokevirtual write : ([BII)V
    //   259: iload #4
    //   261: iload #6
    //   263: iadd
    //   264: istore #4
    //   266: iload #4
    //   268: istore #5
    //   270: invokestatic currentTimeMillis : ()J
    //   273: lload #12
    //   275: lsub
    //   276: invokestatic abs : (J)J
    //   279: ldc2_w 1000
    //   282: lcmp
    //   283: ifle -> 343
    //   286: iload #4
    //   288: istore #5
    //   290: invokestatic currentTimeMillis : ()J
    //   293: lstore #12
    //   295: iload #4
    //   297: i2l
    //   298: lload #10
    //   300: lcmp
    //   301: ifeq -> 340
    //   304: iload #4
    //   306: istore #5
    //   308: aload_0
    //   309: getfield a : Ljava/lang/String;
    //   312: astore #21
    //   314: iload #4
    //   316: istore #5
    //   318: aload_0
    //   319: iload #4
    //   321: lload #10
    //   323: aload #21
    //   325: iconst_2
    //   326: invokespecial a : (IJLjava/lang/String;I)V
    //   329: goto -> 340
    //   332: astore_1
    //   333: iload #5
    //   335: istore #4
    //   337: goto -> 556
    //   340: goto -> 231
    //   343: goto -> 231
    //   346: astore_1
    //   347: goto -> 560
    //   350: aload_0
    //   351: aload #14
    //   353: aload_2
    //   354: invokespecial a : (Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   357: iload #4
    //   359: i2l
    //   360: lload #10
    //   362: lcmp
    //   363: ifne -> 432
    //   366: lload #10
    //   368: lconst_0
    //   369: lcmp
    //   370: ifle -> 432
    //   373: aload_1
    //   374: invokevirtual d : ()Ljava/lang/String;
    //   377: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   380: ifne -> 432
    //   383: aload_1
    //   384: invokevirtual d : ()Ljava/lang/String;
    //   387: aload_3
    //   388: ldc 'SHA-256'
    //   390: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   393: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   396: istore #9
    //   398: iload #9
    //   400: ifeq -> 432
    //   403: iconst_1
    //   404: istore #8
    //   406: goto -> 435
    //   409: astore_1
    //   410: aconst_null
    //   411: astore_2
    //   412: aload #19
    //   414: astore_3
    //   415: goto -> 620
    //   418: astore_1
    //   419: iconst_0
    //   420: istore #8
    //   422: aconst_null
    //   423: astore_2
    //   424: aload_1
    //   425: astore_3
    //   426: aload #17
    //   428: astore_1
    //   429: goto -> 676
    //   432: iconst_0
    //   433: istore #8
    //   435: iload #8
    //   437: ifeq -> 479
    //   440: aload_0
    //   441: getfield a : Ljava/lang/String;
    //   444: astore_1
    //   445: aload_0
    //   446: iload #4
    //   448: lload #10
    //   450: aload_1
    //   451: iconst_4
    //   452: invokespecial a : (IJLjava/lang/String;I)V
    //   455: goto -> 479
    //   458: astore_1
    //   459: goto -> 467
    //   462: astore_1
    //   463: goto -> 476
    //   466: astore_1
    //   467: aconst_null
    //   468: astore_3
    //   469: aload #18
    //   471: astore_2
    //   472: goto -> 772
    //   475: astore_1
    //   476: goto -> 422
    //   479: iload #8
    //   481: ifne -> 520
    //   484: aload_0
    //   485: getfield c : Z
    //   488: istore #9
    //   490: aload_0
    //   491: getfield a : Ljava/lang/String;
    //   494: astore_1
    //   495: iload #9
    //   497: ifeq -> 506
    //   500: iconst_3
    //   501: istore #5
    //   503: goto -> 509
    //   506: iconst_5
    //   507: istore #5
    //   509: aload_0
    //   510: iload #4
    //   512: lload #10
    //   514: aload_1
    //   515: iload #5
    //   517: invokespecial a : (IJLjava/lang/String;I)V
    //   520: aload_0
    //   521: aconst_null
    //   522: aconst_null
    //   523: invokespecial a : (Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   526: invokestatic a : ()Ljava/util/List;
    //   529: aload_0
    //   530: invokeinterface remove : (Ljava/lang/Object;)Z
    //   535: pop
    //   536: aload_0
    //   537: invokespecial d : ()V
    //   540: iload #8
    //   542: ireturn
    //   543: astore_1
    //   544: goto -> 615
    //   547: astore_1
    //   548: goto -> 631
    //   551: astore_1
    //   552: iload #5
    //   554: istore #4
    //   556: goto -> 560
    //   559: astore_1
    //   560: aload_1
    //   561: astore_3
    //   562: aload_2
    //   563: astore_1
    //   564: goto -> 582
    //   567: astore_2
    //   568: goto -> 575
    //   571: astore_2
    //   572: aconst_null
    //   573: astore #14
    //   575: aconst_null
    //   576: astore_1
    //   577: iconst_0
    //   578: istore #4
    //   580: aload_2
    //   581: astore_3
    //   582: aload_0
    //   583: aload #14
    //   585: aload_1
    //   586: invokespecial a : (Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   589: aload_3
    //   590: athrow
    //   591: astore_1
    //   592: aconst_null
    //   593: astore_2
    //   594: aload #15
    //   596: astore_3
    //   597: goto -> 620
    //   600: astore_1
    //   601: aconst_null
    //   602: astore #14
    //   604: aload #16
    //   606: astore_2
    //   607: goto -> 631
    //   610: astore_3
    //   611: aload_1
    //   612: astore_2
    //   613: aload_3
    //   614: astore_1
    //   615: aload_2
    //   616: astore_3
    //   617: aload #14
    //   619: astore_2
    //   620: aload_2
    //   621: astore #14
    //   623: goto -> 777
    //   626: astore_3
    //   627: aload_1
    //   628: astore_2
    //   629: aload_3
    //   630: astore_1
    //   631: aload_1
    //   632: astore_3
    //   633: aload_2
    //   634: astore_1
    //   635: aload #14
    //   637: astore_2
    //   638: goto -> 673
    //   641: astore_1
    //   642: aconst_null
    //   643: astore #14
    //   645: iload #6
    //   647: istore #4
    //   649: lload #12
    //   651: lstore #10
    //   653: aload #20
    //   655: astore_3
    //   656: goto -> 777
    //   659: astore_3
    //   660: aconst_null
    //   661: astore_2
    //   662: aload #14
    //   664: astore_1
    //   665: lload #12
    //   667: lstore #10
    //   669: iload #5
    //   671: istore #4
    //   673: iconst_0
    //   674: istore #8
    //   676: new java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial <init> : ()V
    //   683: astore #14
    //   685: aload #14
    //   687: ldc 'downloadUrlToStream(String urlString,OutputStream outputStream) '
    //   689: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload #14
    //   695: aload_3
    //   696: invokevirtual toString : ()Ljava/lang/String;
    //   699: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: ldc 'DownloadMarketTask'
    //   705: aload #14
    //   707: invokevirtual toString : ()Ljava/lang/String;
    //   710: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   713: iload #8
    //   715: ifne -> 754
    //   718: aload_0
    //   719: getfield c : Z
    //   722: istore #8
    //   724: aload_0
    //   725: getfield a : Ljava/lang/String;
    //   728: astore_3
    //   729: iload #8
    //   731: ifeq -> 740
    //   734: iconst_3
    //   735: istore #5
    //   737: goto -> 743
    //   740: iconst_5
    //   741: istore #5
    //   743: aload_0
    //   744: iload #4
    //   746: lload #10
    //   748: aload_3
    //   749: iload #5
    //   751: invokespecial a : (IJLjava/lang/String;I)V
    //   754: aload_0
    //   755: aload_2
    //   756: aload_1
    //   757: invokespecial a : (Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   760: goto -> 105
    //   763: astore #14
    //   765: aload_2
    //   766: astore_3
    //   767: aload_1
    //   768: astore_2
    //   769: aload #14
    //   771: astore_1
    //   772: aload_3
    //   773: astore #14
    //   775: aload_2
    //   776: astore_3
    //   777: iload #8
    //   779: ifne -> 818
    //   782: aload_0
    //   783: getfield c : Z
    //   786: istore #8
    //   788: aload_0
    //   789: getfield a : Ljava/lang/String;
    //   792: astore_2
    //   793: iload #8
    //   795: ifeq -> 804
    //   798: iconst_3
    //   799: istore #5
    //   801: goto -> 807
    //   804: iconst_5
    //   805: istore #5
    //   807: aload_0
    //   808: iload #4
    //   810: lload #10
    //   812: aload_2
    //   813: iload #5
    //   815: invokespecial a : (IJLjava/lang/String;I)V
    //   818: aload_0
    //   819: aload #14
    //   821: aload_3
    //   822: invokespecial a : (Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   825: invokestatic a : ()Ljava/util/List;
    //   828: aload_0
    //   829: invokeinterface remove : (Ljava/lang/Object;)Z
    //   834: pop
    //   835: aload_0
    //   836: invokespecial d : ()V
    //   839: aload_1
    //   840: athrow
    // Exception table:
    //   from	to	target	type
    //   38	58	659	java/lang/Exception
    //   38	58	641	finally
    //   121	137	659	java/lang/Exception
    //   121	137	641	finally
    //   181	187	659	java/lang/Exception
    //   181	187	641	finally
    //   187	206	571	finally
    //   206	218	567	finally
    //   218	225	559	finally
    //   235	244	551	finally
    //   250	259	346	finally
    //   270	286	551	finally
    //   290	295	551	finally
    //   308	314	551	finally
    //   318	329	332	finally
    //   350	357	547	java/lang/Exception
    //   350	357	543	finally
    //   373	398	418	java/lang/Exception
    //   373	398	409	finally
    //   440	445	475	java/lang/Exception
    //   440	445	466	finally
    //   445	455	462	java/lang/Exception
    //   445	455	458	finally
    //   582	589	626	java/lang/Exception
    //   582	589	610	finally
    //   589	591	600	java/lang/Exception
    //   589	591	591	finally
    //   676	713	763	finally
  }
  
  private void d() {
    HttpURLConnection httpURLConnection = this.b;
    if (httpURLConnection != null)
      httpURLConnection.disconnect(); 
  }
  
  private static String e() {
    String str = com.huawei.updatesdk.a.b.a.a.c().b();
    if (TextUtils.isEmpty(str))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("/updatesdk");
    str = stringBuilder.toString();
    File file = new File(str);
    return (!file.exists() && !file.mkdirs()) ? "" : str;
  }
  
  protected Void a(Void... paramVarArgs) {
    com.huawei.updatesdk.b.e.a.b.a(this);
    a(this.d, e());
    return null;
  }
  
  public void a() {
    (new Thread(new a(this))).start();
  }
  
  public void b() {
    this.e = null;
  }
  
  protected void onCancelled() {
    super.onCancelled();
    a();
  }
  
  class a implements Runnable {
    a(b this$0) {}
    
    public void run() {
      if (b.a(this.a) != null) {
        b.a(this.a, true);
        b.a(this.a).disconnect();
      } 
      d.a(new File(b.c()));
    }
  }
  
  static class b extends Handler {
    private b() {}
    
    public void handleMessage(Message param1Message) {
      Bundle bundle;
      super.handleMessage(param1Message);
      Object object = param1Message.obj;
      if (!(object instanceof a))
        return; 
      a a = (a)object;
      object = new Intent();
      com.huawei.updatesdk.a.b.c.b b1 = com.huawei.updatesdk.a.b.c.b.a((Intent)object);
      int i = param1Message.what;
      if (i != 2) {
        if (i != 3)
          if (i != 4) {
            if (i != 5)
              return; 
          } else {
            Context context = com.huawei.updatesdk.a.b.a.a.c().a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.c());
            stringBuilder.append("/appmarket.apk");
            com.huawei.updatesdk.b.d.a.a(context, stringBuilder.toString(), a.c());
          }  
        bundle = new Bundle();
        bundle.putInt("download_status_param", param1Message.what);
        object.putExtras(bundle);
        c.b().b(b1);
        return;
      } 
      object.putExtra("download_apk_size", bundle.e());
      object.putExtra("download_apk_already", bundle.a());
      c.b().a(b1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */