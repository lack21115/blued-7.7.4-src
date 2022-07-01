package com.tencent.liteav;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public class m {
  private String a = "";
  
  private String b = "";
  
  private int c = 0;
  
  private String d = "";
  
  private String e = "";
  
  private long f = 0L;
  
  private String a(String paramString) {
    if (paramString.contains("#EXT-TX-TS-START-TIME")) {
      int i = paramString.indexOf("#EXT-TX-TS-START-TIME:") + 22;
      if (i > 0) {
        paramString = paramString.substring(i);
        i = paramString.indexOf("#");
        if (i > 0)
          return paramString.substring(0, i).replaceAll("\r\n", ""); 
      } 
    } 
    return null;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, a parama) {
    if (paramString1 == null || paramString1.isEmpty())
      return -1; 
    this.d = TXCCommonUtil.getAppID();
    if (TextUtils.isEmpty(this.d))
      return -2; 
    AsyncTask.execute(new Runnable(this, paramInt, paramString2, paramString1, parama) {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: getfield e : Lcom/tencent/liteav/m;
            //   4: invokestatic currentTimeMillis : ()J
            //   7: invokestatic a : (Lcom/tencent/liteav/m;J)J
            //   10: pop2
            //   11: aload_0
            //   12: getfield e : Lcom/tencent/liteav/m;
            //   15: astore #5
            //   17: ldc ''
            //   19: astore #6
            //   21: aload #5
            //   23: ldc ''
            //   25: invokestatic a : (Lcom/tencent/liteav/m;Ljava/lang/String;)Ljava/lang/String;
            //   28: pop
            //   29: aload_0
            //   30: getfield e : Lcom/tencent/liteav/m;
            //   33: aload_0
            //   34: getfield a : I
            //   37: invokestatic a : (Lcom/tencent/liteav/m;I)I
            //   40: pop
            //   41: aload_0
            //   42: getfield e : Lcom/tencent/liteav/m;
            //   45: aload_0
            //   46: getfield b : Ljava/lang/String;
            //   49: invokestatic b : (Lcom/tencent/liteav/m;Ljava/lang/String;)Ljava/lang/String;
            //   52: pop
            //   53: aload_0
            //   54: getfield e : Lcom/tencent/liteav/m;
            //   57: aload_0
            //   58: getfield c : Ljava/lang/String;
            //   61: invokestatic getStreamIDByStreamUrl : (Ljava/lang/String;)Ljava/lang/String;
            //   64: invokestatic a : (Lcom/tencent/liteav/m;Ljava/lang/String;)Ljava/lang/String;
            //   67: pop
            //   68: aload_0
            //   69: getfield e : Lcom/tencent/liteav/m;
            //   72: aload_0
            //   73: getfield c : Ljava/lang/String;
            //   76: invokestatic getAppNameByStreamUrl : (Ljava/lang/String;)Ljava/lang/String;
            //   79: invokestatic c : (Lcom/tencent/liteav/m;Ljava/lang/String;)Ljava/lang/String;
            //   82: pop
            //   83: aload_0
            //   84: getfield e : Lcom/tencent/liteav/m;
            //   87: invokestatic a : (Lcom/tencent/liteav/m;)Ljava/lang/String;
            //   90: ifnonnull -> 103
            //   93: aload_0
            //   94: getfield e : Lcom/tencent/liteav/m;
            //   97: ldc 'live'
            //   99: invokestatic c : (Lcom/tencent/liteav/m;Ljava/lang/String;)Ljava/lang/String;
            //   102: pop
            //   103: aload_0
            //   104: getfield e : Lcom/tencent/liteav/m;
            //   107: invokestatic b : (Lcom/tencent/liteav/m;)I
            //   110: ifge -> 157
            //   113: ldc 'http://%s/timeshift/%s/%s/timeshift.m3u8?delay=0'
            //   115: iconst_3
            //   116: anewarray java/lang/Object
            //   119: dup
            //   120: iconst_0
            //   121: aload_0
            //   122: getfield e : Lcom/tencent/liteav/m;
            //   125: invokestatic c : (Lcom/tencent/liteav/m;)Ljava/lang/String;
            //   128: aastore
            //   129: dup
            //   130: iconst_1
            //   131: aload_0
            //   132: getfield e : Lcom/tencent/liteav/m;
            //   135: invokestatic a : (Lcom/tencent/liteav/m;)Ljava/lang/String;
            //   138: aastore
            //   139: dup
            //   140: iconst_2
            //   141: aload_0
            //   142: getfield e : Lcom/tencent/liteav/m;
            //   145: invokestatic d : (Lcom/tencent/liteav/m;)Ljava/lang/String;
            //   148: aastore
            //   149: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
            //   152: astore #5
            //   154: goto -> 211
            //   157: ldc 'http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0'
            //   159: iconst_4
            //   160: anewarray java/lang/Object
            //   163: dup
            //   164: iconst_0
            //   165: aload_0
            //   166: getfield e : Lcom/tencent/liteav/m;
            //   169: invokestatic c : (Lcom/tencent/liteav/m;)Ljava/lang/String;
            //   172: aastore
            //   173: dup
            //   174: iconst_1
            //   175: aload_0
            //   176: getfield e : Lcom/tencent/liteav/m;
            //   179: invokestatic b : (Lcom/tencent/liteav/m;)I
            //   182: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   185: aastore
            //   186: dup
            //   187: iconst_2
            //   188: aload_0
            //   189: getfield e : Lcom/tencent/liteav/m;
            //   192: invokestatic d : (Lcom/tencent/liteav/m;)Ljava/lang/String;
            //   195: aastore
            //   196: dup
            //   197: iconst_3
            //   198: aload_0
            //   199: getfield e : Lcom/tencent/liteav/m;
            //   202: invokestatic e : (Lcom/tencent/liteav/m;)Ljava/lang/String;
            //   205: aastore
            //   206: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
            //   209: astore #5
            //   211: new java/net/URL
            //   214: dup
            //   215: aload #5
            //   217: invokespecial <init> : (Ljava/lang/String;)V
            //   220: invokevirtual openConnection : ()Ljava/net/URLConnection;
            //   223: checkcast java/net/HttpURLConnection
            //   226: astore #5
            //   228: aload #5
            //   230: iconst_1
            //   231: invokevirtual setDoOutput : (Z)V
            //   234: aload #5
            //   236: iconst_1
            //   237: invokevirtual setDoInput : (Z)V
            //   240: aload #5
            //   242: iconst_0
            //   243: invokevirtual setUseCaches : (Z)V
            //   246: aload #5
            //   248: sipush #5000
            //   251: invokevirtual setConnectTimeout : (I)V
            //   254: aload #5
            //   256: sipush #5000
            //   259: invokevirtual setReadTimeout : (I)V
            //   262: aload #5
            //   264: ldc 'GET'
            //   266: invokevirtual setRequestMethod : (Ljava/lang/String;)V
            //   269: aload #5
            //   271: ldc 'Charsert'
            //   273: ldc 'UTF-8'
            //   275: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
            //   278: aload #5
            //   280: ldc 'Content-Type'
            //   282: ldc 'text/plain;'
            //   284: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
            //   287: new java/io/BufferedReader
            //   290: dup
            //   291: new java/io/InputStreamReader
            //   294: dup
            //   295: aload #5
            //   297: invokevirtual getInputStream : ()Ljava/io/InputStream;
            //   300: invokespecial <init> : (Ljava/io/InputStream;)V
            //   303: invokespecial <init> : (Ljava/io/Reader;)V
            //   306: astore #7
            //   308: aload #6
            //   310: astore #5
            //   312: aload #7
            //   314: invokevirtual readLine : ()Ljava/lang/String;
            //   317: astore #6
            //   319: aload #6
            //   321: ifnull -> 359
            //   324: new java/lang/StringBuilder
            //   327: dup
            //   328: invokespecial <init> : ()V
            //   331: astore #8
            //   333: aload #8
            //   335: aload #5
            //   337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   340: pop
            //   341: aload #8
            //   343: aload #6
            //   345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   348: pop
            //   349: aload #8
            //   351: invokevirtual toString : ()Ljava/lang/String;
            //   354: astore #5
            //   356: goto -> 312
            //   359: new java/lang/StringBuilder
            //   362: dup
            //   363: invokespecial <init> : ()V
            //   366: astore #6
            //   368: aload #6
            //   370: ldc 'prepareSeekTime: receive response, strResponse = '
            //   372: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   375: pop
            //   376: aload #6
            //   378: aload #5
            //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   383: pop
            //   384: ldc 'TXCTimeShiftUtil'
            //   386: aload #6
            //   388: invokevirtual toString : ()Ljava/lang/String;
            //   391: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
            //   394: aload_0
            //   395: getfield e : Lcom/tencent/liteav/m;
            //   398: aload #5
            //   400: invokestatic d : (Lcom/tencent/liteav/m;Ljava/lang/String;)Ljava/lang/String;
            //   403: astore #5
            //   405: aload #5
            //   407: ifnull -> 481
            //   410: aload_0
            //   411: getfield e : Lcom/tencent/liteav/m;
            //   414: aload #5
            //   416: invokestatic parseLong : (Ljava/lang/String;)J
            //   419: ldc2_w 1000
            //   422: lmul
            //   423: invokestatic a : (Lcom/tencent/liteav/m;J)J
            //   426: pop2
            //   427: goto -> 481
            //   430: astore #5
            //   432: aload_0
            //   433: getfield e : Lcom/tencent/liteav/m;
            //   436: invokestatic currentTimeMillis : ()J
            //   439: invokestatic a : (Lcom/tencent/liteav/m;J)J
            //   442: pop2
            //   443: new java/lang/StringBuilder
            //   446: dup
            //   447: invokespecial <init> : ()V
            //   450: astore #6
            //   452: aload #6
            //   454: ldc 'prepareSeekTime error '
            //   456: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   459: pop
            //   460: aload #6
            //   462: aload #5
            //   464: invokevirtual toString : ()Ljava/lang/String;
            //   467: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   470: pop
            //   471: ldc 'TXCTimeShiftUtil'
            //   473: aload #6
            //   475: invokevirtual toString : ()Ljava/lang/String;
            //   478: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
            //   481: invokestatic currentTimeMillis : ()J
            //   484: lstore_1
            //   485: new java/lang/StringBuilder
            //   488: dup
            //   489: invokespecial <init> : ()V
            //   492: astore #5
            //   494: aload #5
            //   496: ldc 'live start time:'
            //   498: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   501: pop
            //   502: aload #5
            //   504: aload_0
            //   505: getfield e : Lcom/tencent/liteav/m;
            //   508: invokestatic f : (Lcom/tencent/liteav/m;)J
            //   511: invokevirtual append : (J)Ljava/lang/StringBuilder;
            //   514: pop
            //   515: aload #5
            //   517: ldc ',currentTime:'
            //   519: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   522: pop
            //   523: aload #5
            //   525: lload_1
            //   526: invokevirtual append : (J)Ljava/lang/StringBuilder;
            //   529: pop
            //   530: aload #5
            //   532: ldc ',diff:'
            //   534: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   537: pop
            //   538: aload #5
            //   540: lload_1
            //   541: aload_0
            //   542: getfield e : Lcom/tencent/liteav/m;
            //   545: invokestatic f : (Lcom/tencent/liteav/m;)J
            //   548: lsub
            //   549: invokevirtual append : (J)Ljava/lang/StringBuilder;
            //   552: pop
            //   553: ldc 'TXCTimeShiftUtil'
            //   555: aload #5
            //   557: invokevirtual toString : ()Ljava/lang/String;
            //   560: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
            //   563: aload_0
            //   564: getfield e : Lcom/tencent/liteav/m;
            //   567: invokestatic f : (Lcom/tencent/liteav/m;)J
            //   570: lstore_3
            //   571: aload_0
            //   572: getfield d : Lcom/tencent/liteav/m$a;
            //   575: ifnull -> 603
            //   578: new android/os/Handler
            //   581: dup
            //   582: invokestatic getMainLooper : ()Landroid/os/Looper;
            //   585: invokespecial <init> : (Landroid/os/Looper;)V
            //   588: new com/tencent/liteav/m$1$1
            //   591: dup
            //   592: aload_0
            //   593: lload_1
            //   594: lload_3
            //   595: lsub
            //   596: invokespecial <init> : (Lcom/tencent/liteav/m$1;J)V
            //   599: invokevirtual post : (Ljava/lang/Runnable;)Z
            //   602: pop
            //   603: return
            // Exception table:
            //   from	to	target	type
            //   211	308	430	java/lang/Exception
            //   312	319	430	java/lang/Exception
            //   324	356	430	java/lang/Exception
            //   359	405	430	java/lang/Exception
            //   410	427	430	java/lang/Exception
          }
        });
    return 0;
  }
  
  public long a() {
    return System.currentTimeMillis() - this.f;
  }
  
  public String a(long paramLong) {
    String str = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date(this.f + paramLong * 1000L));
    int i = this.c;
    if (i < 0) {
      paramLong = (System.currentTimeMillis() - this.f - paramLong) / 1000L;
      return String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=%d", new Object[] { this.a, this.e, this.b, Long.valueOf(paramLong) });
    } 
    return String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[] { this.a, Integer.valueOf(i), this.b, str, this.d });
  }
  
  public static interface a {
    void a(long param1Long);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */