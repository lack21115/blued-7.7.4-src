package com.baidu.mobads.openad.b;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

class e implements IOAdEventListener {
  e(d paramd) {}
  
  public void run(IOAdEvent paramIOAdEvent) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   3: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   6: ldc 'OAdDownloadManager'
    //   8: ldc '网络状态已经改变'
    //   10: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: aload_0
    //   17: getfield a : Lcom/baidu/mobads/openad/b/d;
    //   20: getfield a : Landroid/content/Context;
    //   23: ldc 'connectivity'
    //   25: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast android/net/ConnectivityManager
    //   31: invokevirtual getActiveNetworkInfo : ()Landroid/net/NetworkInfo;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull -> 363
    //   39: aload_3
    //   40: invokevirtual isConnected : ()Z
    //   43: ifeq -> 363
    //   46: aload_3
    //   47: invokevirtual getTypeName : ()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_3
    //   52: invokevirtual getType : ()I
    //   55: istore_2
    //   56: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   59: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   62: astore_3
    //   63: new java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial <init> : ()V
    //   70: astore #4
    //   72: aload #4
    //   74: ldc '当前网络名称：'
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload #4
    //   82: aload_1
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload #4
    //   89: ldc '; 网络类型：'
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload #4
    //   97: iload_2
    //   98: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_3
    //   103: ldc 'OAdDownloadManager'
    //   105: aload #4
    //   107: invokevirtual toString : ()Ljava/lang/String;
    //   110: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aload_0
    //   117: getfield a : Lcom/baidu/mobads/openad/b/d;
    //   120: invokevirtual getAllAdsApkDownloaderes : ()Ljava/util/ArrayList;
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull -> 436
    //   128: aload_1
    //   129: invokeinterface iterator : ()Ljava/util/Iterator;
    //   134: astore_1
    //   135: aload_1
    //   136: invokeinterface hasNext : ()Z
    //   141: ifeq -> 436
    //   144: aload_1
    //   145: invokeinterface next : ()Ljava/lang/Object;
    //   150: checkcast com/baidu/mobads/openad/interfaces/download/IOAdDownloader
    //   153: astore_3
    //   154: iload_2
    //   155: iconst_1
    //   156: if_icmpne -> 219
    //   159: aload_3
    //   160: invokeinterface getState : ()Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   165: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   168: if_acmpeq -> 191
    //   171: aload_3
    //   172: invokeinterface getState : ()Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   177: astore #4
    //   179: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.PAUSED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   182: astore #5
    //   184: aload #4
    //   186: aload #5
    //   188: if_acmpne -> 135
    //   191: aload_3
    //   192: invokeinterface resume : ()V
    //   197: goto -> 135
    //   200: astore_3
    //   201: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   204: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   207: ldc 'OAdDownloadManager'
    //   209: aload_3
    //   210: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   215: pop
    //   216: goto -> 135
    //   219: iload_2
    //   220: ifne -> 135
    //   223: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   226: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   229: ldc 'OAdDownloadManager'
    //   231: ldc 'mobile net work'
    //   233: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   238: pop
    //   239: aload_3
    //   240: invokeinterface getPackageName : ()Ljava/lang/String;
    //   245: invokestatic a : (Ljava/lang/String;)Lcom/baidu/mobads/openad/b/b;
    //   248: astore #4
    //   250: aload #4
    //   252: ifnull -> 135
    //   255: aload #4
    //   257: invokevirtual a : ()Lcom/baidu/mobads/command/a;
    //   260: astore #4
    //   262: aload #4
    //   264: ifnull -> 135
    //   267: aload #4
    //   269: getfield s : Z
    //   272: ifeq -> 335
    //   275: aload_3
    //   276: invokeinterface getState : ()Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   281: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   284: if_acmpeq -> 307
    //   287: aload_3
    //   288: invokeinterface getState : ()Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   293: astore #4
    //   295: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.PAUSED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   298: astore #5
    //   300: aload #4
    //   302: aload #5
    //   304: if_acmpne -> 135
    //   307: aload_3
    //   308: invokeinterface resume : ()V
    //   313: goto -> 135
    //   316: astore_3
    //   317: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   320: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   323: ldc 'OAdDownloadManager'
    //   325: aload_3
    //   326: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   331: pop
    //   332: goto -> 135
    //   335: aload_3
    //   336: invokeinterface pause : ()V
    //   341: goto -> 135
    //   344: astore_3
    //   345: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   348: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   351: ldc 'OAdDownloadManager'
    //   353: aload_3
    //   354: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   359: pop
    //   360: goto -> 135
    //   363: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   366: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   369: ldc 'OAdDownloadManager'
    //   371: ldc '没有可用网络'
    //   373: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   378: pop
    //   379: return
    //   380: astore_1
    //   381: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   384: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   387: ldc 'OAdDownloadManager'
    //   389: aload_1
    //   390: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   395: pop
    //   396: invokestatic a : ()Lcom/baidu/mobads/b/a;
    //   399: astore_3
    //   400: new java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial <init> : ()V
    //   407: astore #4
    //   409: aload #4
    //   411: ldc 'create apk downloader failed: '
    //   413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload #4
    //   419: aload_1
    //   420: invokevirtual toString : ()Ljava/lang/String;
    //   423: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_3
    //   428: aload #4
    //   430: invokevirtual toString : ()Ljava/lang/String;
    //   433: invokevirtual a : (Ljava/lang/String;)V
    //   436: return
    // Exception table:
    //   from	to	target	type
    //   0	35	380	java/lang/Exception
    //   39	124	380	java/lang/Exception
    //   128	135	380	java/lang/Exception
    //   135	154	380	java/lang/Exception
    //   159	184	380	java/lang/Exception
    //   191	197	200	java/lang/Exception
    //   201	216	380	java/lang/Exception
    //   223	250	380	java/lang/Exception
    //   255	262	380	java/lang/Exception
    //   267	300	380	java/lang/Exception
    //   307	313	316	java/lang/Exception
    //   317	332	380	java/lang/Exception
    //   335	341	344	java/lang/Exception
    //   345	360	380	java/lang/Exception
    //   363	379	380	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */