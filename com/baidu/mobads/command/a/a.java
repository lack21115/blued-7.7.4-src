package com.baidu.mobads.command.a;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import com.baidu.mobads.command.b;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.production.b;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import java.io.File;

public class a extends b {
  public a(IXNonLinearAdSlot paramIXNonLinearAdSlot, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdResource paramIXAdResource) {
    super(paramIXNonLinearAdSlot, paramIXAdInstanceInfo, paramIXAdResource);
  }
  
  public static IXAppInfo a(com.baidu.mobads.command.a parama) {
    IXAppInfo iXAppInfo;
    IXAdContainerFactory iXAdContainerFactory = null;
    if (parama != null) {
      iXAdContainerFactory = b.j();
      if (iXAdContainerFactory == null)
        return null; 
      iXAppInfo = iXAdContainerFactory.createAppInfo();
      iXAppInfo.setAdId(parama.g());
      iXAppInfo.setAppSize(parama.e());
      iXAppInfo.setClickTime(parama.c());
      iXAppInfo.setPackageName(parama.d());
      iXAppInfo.setQk(parama.h());
      iXAppInfo.setProd(parama.i());
      iXAppInfo.setTooLarge(parama.f());
    } 
    return iXAppInfo;
  }
  
  private void b(com.baidu.mobads.command.a parama) {
    if (b.j() != null) {
      IXAppInfo iXAppInfo = a(parama);
      if (iXAppInfo != null) {
        b.j().getXMonitorActivation(this.a, this.e).addAppInfoForMonitor(iXAppInfo);
        return;
      } 
      this.e.e("addAppInfoForMonitor error, appInfo is null");
    } 
  }
  
  private boolean b() {
    return XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(this.a, this.c.getAppPackageName());
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   4: ifnonnull -> 8
    //   7: return
    //   8: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   11: invokevirtual getCommonUtils : ()Lcom/baidu/mobads/utils/h;
    //   14: astore #6
    //   16: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   19: invokevirtual getURIUitls : ()Lcom/baidu/mobads/interfaces/utils/IXAdURIUitls;
    //   22: astore #5
    //   24: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   27: invokevirtual getSystemUtils : ()Lcom/baidu/mobads/interfaces/utils/IXAdSystemUtils;
    //   30: astore #7
    //   32: aload_0
    //   33: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   36: invokeinterface getAppPackageName : ()Ljava/lang/String;
    //   41: astore_3
    //   42: aload_0
    //   43: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   46: astore_2
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #4
    //   56: aload #4
    //   58: ldc 'download pkg = '
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #4
    //   66: aload_3
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #4
    //   73: ldc '， DownloadURL= '
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload #4
    //   81: aload_0
    //   82: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   85: invokeinterface getClickThroughUrl : ()Ljava/lang/String;
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: ldc 'XAdDownloadAPKCommand'
    //   97: aload #4
    //   99: invokevirtual toString : ()Ljava/lang/String;
    //   102: invokeinterface i : (Ljava/lang/String;Ljava/lang/String;)I
    //   107: pop
    //   108: ldc ''
    //   110: astore_2
    //   111: aload_3
    //   112: ifnull -> 127
    //   115: aload_3
    //   116: astore #4
    //   118: aload_3
    //   119: ldc ''
    //   121: invokevirtual equals : (Ljava/lang/Object;)Z
    //   124: ifeq -> 175
    //   127: aload_3
    //   128: astore #4
    //   130: aload_0
    //   131: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   134: invokeinterface getOriginClickUrl : ()Ljava/lang/String;
    //   139: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   142: ifne -> 175
    //   145: aload_0
    //   146: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   149: ldc 'XAdDownloadAPKCommand'
    //   151: ldc 'start to download but package is empty'
    //   153: invokeinterface i : (Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: aload #6
    //   161: aload_0
    //   162: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   165: invokeinterface getOriginClickUrl : ()Ljava/lang/String;
    //   170: invokevirtual getMD5 : (Ljava/lang/String;)Ljava/lang/String;
    //   173: astore #4
    //   175: aload_0
    //   176: getfield a : Landroid/content/Context;
    //   179: invokestatic a : (Landroid/content/Context;)Lcom/baidu/mobads/openad/b/d;
    //   182: aload #4
    //   184: invokevirtual getAdsApkDownloader : (Ljava/lang/String;)Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader;
    //   187: astore #8
    //   189: aload #4
    //   191: invokestatic a : (Ljava/lang/String;)Lcom/baidu/mobads/openad/b/b;
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull -> 571
    //   199: aload #8
    //   201: ifnull -> 571
    //   204: aload_3
    //   205: invokevirtual a : ()Lcom/baidu/mobads/command/a;
    //   208: astore_3
    //   209: aload #8
    //   211: invokeinterface getState : ()Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   216: astore #9
    //   218: aload_0
    //   219: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   222: astore #10
    //   224: new java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial <init> : ()V
    //   231: astore #11
    //   233: aload #11
    //   235: ldc 'startDownload>> downloader exist: state='
    //   237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload #11
    //   243: aload #9
    //   245: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload #10
    //   251: ldc 'XAdDownloadAPKCommand'
    //   253: aload #11
    //   255: invokevirtual toString : ()Ljava/lang/String;
    //   258: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   263: pop
    //   264: aload #9
    //   266: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.CANCELLED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   269: if_acmpeq -> 547
    //   272: aload #9
    //   274: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.ERROR : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   277: if_acmpeq -> 547
    //   280: aload #9
    //   282: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.PAUSED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   285: if_acmpne -> 291
    //   288: goto -> 547
    //   291: aload #9
    //   293: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.COMPLETED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   296: if_acmpne -> 369
    //   299: aload_0
    //   300: aload_0
    //   301: getfield a : Landroid/content/Context;
    //   304: aload_3
    //   305: invokevirtual a : (Landroid/content/Context;Lcom/baidu/mobads/command/a;)Z
    //   308: ifeq -> 333
    //   311: aload #5
    //   313: aload_0
    //   314: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   317: invokeinterface getClickThroughUrl : ()Ljava/lang/String;
    //   322: invokeinterface pintHttpInNewThread : (Ljava/lang/String;)V
    //   327: aload_0
    //   328: aload_3
    //   329: invokespecial b : (Lcom/baidu/mobads/command/a;)V
    //   332: return
    //   333: aload #8
    //   335: invokeinterface cancel : ()V
    //   340: aload #8
    //   342: invokeinterface removeObservers : ()V
    //   347: aload #4
    //   349: invokestatic b : (Ljava/lang/String;)Lcom/baidu/mobads/openad/b/b;
    //   352: pop
    //   353: aload_0
    //   354: getfield a : Landroid/content/Context;
    //   357: invokestatic a : (Landroid/content/Context;)Lcom/baidu/mobads/openad/b/d;
    //   360: aload #4
    //   362: invokevirtual removeAdsApkDownloader : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   365: pop
    //   366: goto -> 609
    //   369: aload #9
    //   371: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.DOWNLOADING : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   374: if_acmpeq -> 385
    //   377: aload #9
    //   379: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.INITING : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   382: if_acmpne -> 609
    //   385: aload_0
    //   386: getfield a : Landroid/content/Context;
    //   389: astore #5
    //   391: aload_0
    //   392: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   395: ifnull -> 1562
    //   398: aload_0
    //   399: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   402: invokeinterface getProdInfo : ()Lcom/baidu/mobads/interfaces/IXAdProdInfo;
    //   407: invokeinterface getProdType : ()Ljava/lang/String;
    //   412: astore_3
    //   413: goto -> 416
    //   416: aload #6
    //   418: aload_0
    //   419: getfield a : Landroid/content/Context;
    //   422: invokevirtual getAppId : (Landroid/content/Context;)Ljava/lang/String;
    //   425: astore #9
    //   427: aload_0
    //   428: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   431: ifnull -> 449
    //   434: aload_0
    //   435: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   438: invokeinterface getAdRequestInfo : ()Lcom/baidu/mobads/interfaces/IXAdRequestInfo;
    //   443: invokeinterface getApid : ()Ljava/lang/String;
    //   448: astore_2
    //   449: aload #6
    //   451: aload #5
    //   453: sipush #529
    //   456: ldc_w 'downloading'
    //   459: aload_3
    //   460: aload #4
    //   462: aload #9
    //   464: aload_2
    //   465: aload #7
    //   467: invokeinterface getPhoneOSBrand : ()Ljava/lang/String;
    //   472: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   475: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   478: getstatic android/os/Build$VERSION.SDK_INT : I
    //   481: invokevirtual sendDownloadAdLog : (Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   484: aload_0
    //   485: getfield a : Landroid/content/Context;
    //   488: astore_2
    //   489: new java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial <init> : ()V
    //   496: astore_3
    //   497: aload_3
    //   498: aload #8
    //   500: invokeinterface getTitle : ()Ljava/lang/String;
    //   505: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_3
    //   510: aload #8
    //   512: invokeinterface getState : ()Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   517: invokevirtual getMessage : ()Ljava/lang/String;
    //   520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload_0
    //   525: aload_2
    //   526: aload_3
    //   527: invokevirtual toString : ()Ljava/lang/String;
    //   530: iconst_0
    //   531: aload_0
    //   532: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   535: invokeinterface isPopNotif : ()Z
    //   540: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   543: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;ILjava/lang/Boolean;)V
    //   546: return
    //   547: aload #8
    //   549: invokeinterface resume : ()V
    //   554: aload #5
    //   556: aload_0
    //   557: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   560: invokeinterface getClickThroughUrl : ()Ljava/lang/String;
    //   565: invokeinterface pintHttpInNewThread : (Ljava/lang/String;)V
    //   570: return
    //   571: aload #8
    //   573: ifnull -> 590
    //   576: aload #8
    //   578: invokeinterface cancel : ()V
    //   583: aload #8
    //   585: invokeinterface removeObservers : ()V
    //   590: aload #4
    //   592: invokestatic b : (Ljava/lang/String;)Lcom/baidu/mobads/openad/b/b;
    //   595: pop
    //   596: aload_0
    //   597: getfield a : Landroid/content/Context;
    //   600: invokestatic a : (Landroid/content/Context;)Lcom/baidu/mobads/openad/b/d;
    //   603: aload #4
    //   605: invokevirtual removeAdsApkDownloader : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   608: pop
    //   609: aload_0
    //   610: getfield a : Landroid/content/Context;
    //   613: aload #4
    //   615: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Lcom/baidu/mobads/command/a;
    //   618: astore_3
    //   619: aload_3
    //   620: ifnull -> 670
    //   623: aload_3
    //   624: getfield g : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   627: getstatic com/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus.COMPLETED : Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader$DownloadStatus;
    //   630: if_acmpne -> 651
    //   633: aload_0
    //   634: aload_0
    //   635: getfield a : Landroid/content/Context;
    //   638: aload_3
    //   639: invokevirtual a : (Landroid/content/Context;Lcom/baidu/mobads/command/a;)Z
    //   642: ifeq -> 651
    //   645: aload_0
    //   646: aload_3
    //   647: invokespecial b : (Lcom/baidu/mobads/command/a;)V
    //   650: return
    //   651: aload #5
    //   653: aload_0
    //   654: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   657: invokeinterface getClickThroughUrl : ()Ljava/lang/String;
    //   662: invokeinterface pintHttpInNewThread : (Ljava/lang/String;)V
    //   667: goto -> 1113
    //   670: aload_0
    //   671: invokespecial b : ()Z
    //   674: ifeq -> 836
    //   677: aload_0
    //   678: getfield a : Landroid/content/Context;
    //   681: astore #8
    //   683: aload_0
    //   684: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   687: ifnull -> 1568
    //   690: aload_0
    //   691: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   694: invokeinterface getProdInfo : ()Lcom/baidu/mobads/interfaces/IXAdProdInfo;
    //   699: invokeinterface getProdType : ()Ljava/lang/String;
    //   704: astore_3
    //   705: goto -> 708
    //   708: aload #6
    //   710: aload_0
    //   711: getfield a : Landroid/content/Context;
    //   714: invokevirtual getAppId : (Landroid/content/Context;)Ljava/lang/String;
    //   717: astore #9
    //   719: aload_0
    //   720: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   723: ifnull -> 741
    //   726: aload_0
    //   727: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   730: invokeinterface getAdRequestInfo : ()Lcom/baidu/mobads/interfaces/IXAdRequestInfo;
    //   735: invokeinterface getApid : ()Ljava/lang/String;
    //   740: astore_2
    //   741: aload #6
    //   743: aload #8
    //   745: sipush #529
    //   748: ldc_w 'alreadyinstalled1'
    //   751: aload_3
    //   752: aload #4
    //   754: aload #9
    //   756: aload_2
    //   757: aload #7
    //   759: invokeinterface getPhoneOSBrand : ()Ljava/lang/String;
    //   764: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   767: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   770: getstatic android/os/Build$VERSION.SDK_INT : I
    //   773: invokevirtual sendDownloadAdLog : (Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   776: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   779: invokevirtual getPackageUtils : ()Lcom/baidu/mobads/utils/r;
    //   782: aload_0
    //   783: getfield a : Landroid/content/Context;
    //   786: aload_0
    //   787: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   790: invokeinterface getAppPackageName : ()Ljava/lang/String;
    //   795: invokevirtual openApp : (Landroid/content/Context;Ljava/lang/String;)V
    //   798: aload #5
    //   800: aload_0
    //   801: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   804: invokeinterface getClickThroughUrl : ()Ljava/lang/String;
    //   809: invokeinterface pintHttpInNewThread : (Ljava/lang/String;)V
    //   814: invokestatic j : ()Lcom/baidu/mobads/interfaces/IXAdContainerFactory;
    //   817: aload_0
    //   818: getfield a : Landroid/content/Context;
    //   821: aload_0
    //   822: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   825: invokeinterface getXMonitorActivation : (Landroid/content/Context;Lcom/baidu/mobads/interfaces/utils/IXAdLogger;)Lcom/baidu/mobads/interfaces/download/activate/IXMonitorActivation;
    //   830: invokeinterface startMonitor : ()V
    //   835: return
    //   836: aload_0
    //   837: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   840: invokeinterface getAppName : ()Ljava/lang/String;
    //   845: astore #5
    //   847: aload #5
    //   849: ifnull -> 865
    //   852: aload #5
    //   854: astore_3
    //   855: aload #5
    //   857: ldc ''
    //   859: invokevirtual equals : (Ljava/lang/Object;)Z
    //   862: ifeq -> 897
    //   865: aload_0
    //   866: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   869: invokeinterface getTitle : ()Ljava/lang/String;
    //   874: astore #5
    //   876: aload #5
    //   878: ifnull -> 1574
    //   881: aload #5
    //   883: astore_3
    //   884: aload #5
    //   886: ldc ''
    //   888: invokevirtual equals : (Ljava/lang/Object;)Z
    //   891: ifeq -> 897
    //   894: goto -> 1574
    //   897: new com/baidu/mobads/command/a
    //   900: dup
    //   901: aload #4
    //   903: aload_3
    //   904: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   907: astore_3
    //   908: aload_3
    //   909: aload_0
    //   910: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   913: invokeinterface getQueryKey : ()Ljava/lang/String;
    //   918: aload_0
    //   919: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   922: invokeinterface getAdId : ()Ljava/lang/String;
    //   927: aload_0
    //   928: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   931: invokeinterface getClickThroughUrl : ()Ljava/lang/String;
    //   936: aload_0
    //   937: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   940: invokeinterface isAutoOpen : ()Z
    //   945: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   948: aload_3
    //   949: aload_0
    //   950: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   953: invokeinterface isPopNotif : ()Z
    //   958: putfield m : Z
    //   961: new java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial <init> : ()V
    //   968: astore #5
    //   970: aload #5
    //   972: aload #6
    //   974: aload_3
    //   975: getfield j : Ljava/lang/String;
    //   978: invokevirtual getMD5 : (Ljava/lang/String;)Ljava/lang/String;
    //   981: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload #5
    //   987: ldc_w '.apk'
    //   990: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: pop
    //   994: aload_3
    //   995: aload #5
    //   997: invokevirtual toString : ()Ljava/lang/String;
    //   1000: aload_0
    //   1001: getfield a : Landroid/content/Context;
    //   1004: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   1007: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1010: aload_0
    //   1011: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1014: ifnull -> 1049
    //   1017: aload_3
    //   1018: aload_0
    //   1019: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1022: invokeinterface getAdRequestInfo : ()Lcom/baidu/mobads/interfaces/IXAdRequestInfo;
    //   1027: invokeinterface getApid : ()Ljava/lang/String;
    //   1032: aload_0
    //   1033: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1036: invokeinterface getProdInfo : ()Lcom/baidu/mobads/interfaces/IXAdProdInfo;
    //   1041: invokeinterface getProdType : ()Ljava/lang/String;
    //   1046: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1049: aload_3
    //   1050: aload #4
    //   1052: invokestatic c : (Ljava/lang/String;)I
    //   1055: putfield f : I
    //   1058: aload_0
    //   1059: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   1062: invokeinterface isActionOnlyWifi : ()Z
    //   1067: ifne -> 1581
    //   1070: iconst_1
    //   1071: istore_1
    //   1072: goto -> 1075
    //   1075: aload_3
    //   1076: iload_1
    //   1077: putfield s : Z
    //   1080: aload_3
    //   1081: invokestatic currentTimeMillis : ()J
    //   1084: invokevirtual a : (J)V
    //   1087: aload_3
    //   1088: aload_0
    //   1089: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   1092: invokeinterface getAppSize : ()J
    //   1097: invokevirtual b : (J)V
    //   1100: aload_3
    //   1101: aload_0
    //   1102: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   1105: invokeinterface isTooLarge : ()Z
    //   1110: invokevirtual a : (Z)V
    //   1113: aload_3
    //   1114: invokestatic currentTimeMillis : ()J
    //   1117: putfield t : J
    //   1120: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   1123: aload_0
    //   1124: getfield a : Landroid/content/Context;
    //   1127: invokevirtual getDownloaderManager : (Landroid/content/Context;)Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloaderManager;
    //   1130: new java/net/URL
    //   1133: dup
    //   1134: aload_3
    //   1135: getfield j : Ljava/lang/String;
    //   1138: invokespecial <init> : (Ljava/lang/String;)V
    //   1141: aload_3
    //   1142: getfield c : Ljava/lang/String;
    //   1145: aload_3
    //   1146: getfield b : Ljava/lang/String;
    //   1149: iconst_3
    //   1150: aload_3
    //   1151: getfield a : Ljava/lang/String;
    //   1154: aload_3
    //   1155: getfield i : Ljava/lang/String;
    //   1158: invokeinterface createAdsApkDownloader : (Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader;
    //   1163: astore #5
    //   1165: aload_0
    //   1166: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   1169: invokeinterface getAPOOpen : ()Z
    //   1174: iconst_1
    //   1175: if_icmpne -> 1225
    //   1178: aload_0
    //   1179: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   1182: invokeinterface getPage : ()Ljava/lang/String;
    //   1187: ifnull -> 1225
    //   1190: aload_0
    //   1191: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   1194: invokeinterface getPage : ()Ljava/lang/String;
    //   1199: ldc ''
    //   1201: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1204: ifne -> 1225
    //   1207: aload_3
    //   1208: iconst_1
    //   1209: putfield w : Z
    //   1212: aload_3
    //   1213: aload_0
    //   1214: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   1217: invokeinterface getPage : ()Ljava/lang/String;
    //   1222: putfield x : Ljava/lang/String;
    //   1225: aload #5
    //   1227: new com/baidu/mobads/openad/b/b
    //   1230: dup
    //   1231: aload_0
    //   1232: getfield a : Landroid/content/Context;
    //   1235: aload_3
    //   1236: invokespecial <init> : (Landroid/content/Context;Lcom/baidu/mobads/command/a;)V
    //   1239: invokeinterface addObserver : (Ljava/util/Observer;)V
    //   1244: aload_3
    //   1245: getfield s : Z
    //   1248: ifne -> 1399
    //   1251: aload #7
    //   1253: aload_0
    //   1254: getfield a : Landroid/content/Context;
    //   1257: invokeinterface isWifiConnected : (Landroid/content/Context;)Ljava/lang/Boolean;
    //   1262: invokevirtual booleanValue : ()Z
    //   1265: ifne -> 1399
    //   1268: aload_0
    //   1269: getfield a : Landroid/content/Context;
    //   1272: astore #8
    //   1274: aload_0
    //   1275: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1278: ifnull -> 1586
    //   1281: aload_0
    //   1282: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1285: invokeinterface getProdInfo : ()Lcom/baidu/mobads/interfaces/IXAdProdInfo;
    //   1290: invokeinterface getProdType : ()Ljava/lang/String;
    //   1295: astore_3
    //   1296: goto -> 1299
    //   1299: aload #6
    //   1301: aload_0
    //   1302: getfield a : Landroid/content/Context;
    //   1305: invokevirtual getAppId : (Landroid/content/Context;)Ljava/lang/String;
    //   1308: astore #9
    //   1310: aload_0
    //   1311: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1314: ifnull -> 1332
    //   1317: aload_0
    //   1318: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1321: invokeinterface getAdRequestInfo : ()Lcom/baidu/mobads/interfaces/IXAdRequestInfo;
    //   1326: invokeinterface getApid : ()Ljava/lang/String;
    //   1331: astore_2
    //   1332: aload #6
    //   1334: aload #8
    //   1336: sipush #529
    //   1339: ldc_w 'waitwifi'
    //   1342: aload_3
    //   1343: aload #4
    //   1345: aload #9
    //   1347: aload_2
    //   1348: aload #7
    //   1350: invokeinterface getPhoneOSBrand : ()Ljava/lang/String;
    //   1355: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   1358: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   1361: getstatic android/os/Build$VERSION.SDK_INT : I
    //   1364: invokevirtual sendDownloadAdLog : (Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   1367: aload #5
    //   1369: invokeinterface pause : ()V
    //   1374: aload_0
    //   1375: aload_0
    //   1376: getfield a : Landroid/content/Context;
    //   1379: ldc_w '将在连入Wifi后开始下载'
    //   1382: iconst_0
    //   1383: aload_0
    //   1384: getfield c : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   1387: invokeinterface isPopNotif : ()Z
    //   1392: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   1395: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;ILjava/lang/Boolean;)V
    //   1398: return
    //   1399: aload_0
    //   1400: getfield a : Landroid/content/Context;
    //   1403: astore #8
    //   1405: aload_0
    //   1406: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1409: ifnull -> 1592
    //   1412: aload_0
    //   1413: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1416: invokeinterface getProdInfo : ()Lcom/baidu/mobads/interfaces/IXAdProdInfo;
    //   1421: invokeinterface getProdType : ()Ljava/lang/String;
    //   1426: astore_3
    //   1427: goto -> 1430
    //   1430: aload #6
    //   1432: aload_0
    //   1433: getfield a : Landroid/content/Context;
    //   1436: invokevirtual getAppId : (Landroid/content/Context;)Ljava/lang/String;
    //   1439: astore #9
    //   1441: aload_0
    //   1442: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1445: ifnull -> 1463
    //   1448: aload_0
    //   1449: getfield b : Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;
    //   1452: invokeinterface getAdRequestInfo : ()Lcom/baidu/mobads/interfaces/IXAdRequestInfo;
    //   1457: invokeinterface getApid : ()Ljava/lang/String;
    //   1462: astore_2
    //   1463: aload #6
    //   1465: aload #8
    //   1467: sipush #527
    //   1470: ldc_w 'realstart'
    //   1473: aload_3
    //   1474: aload #4
    //   1476: aload #9
    //   1478: aload_2
    //   1479: aload #7
    //   1481: invokeinterface getPhoneOSBrand : ()Ljava/lang/String;
    //   1486: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   1489: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   1492: getstatic android/os/Build$VERSION.SDK_INT : I
    //   1495: invokevirtual sendDownloadAdLog : (Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   1498: aload #5
    //   1500: invokeinterface start : ()V
    //   1505: return
    //   1506: astore_2
    //   1507: aload_0
    //   1508: getfield e : Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   1511: ldc 'XAdDownloadAPKCommand'
    //   1513: aload_2
    //   1514: invokeinterface e : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1519: pop
    //   1520: invokestatic a : ()Lcom/baidu/mobads/b/a;
    //   1523: astore_3
    //   1524: new java/lang/StringBuilder
    //   1527: dup
    //   1528: invokespecial <init> : ()V
    //   1531: astore #4
    //   1533: aload #4
    //   1535: ldc_w 'ad app download failed: '
    //   1538: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: pop
    //   1542: aload #4
    //   1544: aload_2
    //   1545: invokevirtual toString : ()Ljava/lang/String;
    //   1548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: aload_3
    //   1553: aload #4
    //   1555: invokevirtual toString : ()Ljava/lang/String;
    //   1558: invokevirtual a : (Ljava/lang/String;)V
    //   1561: return
    //   1562: ldc ''
    //   1564: astore_3
    //   1565: goto -> 416
    //   1568: ldc ''
    //   1570: astore_3
    //   1571: goto -> 708
    //   1574: ldc_w '您点击的应用'
    //   1577: astore_3
    //   1578: goto -> 897
    //   1581: iconst_0
    //   1582: istore_1
    //   1583: goto -> 1075
    //   1586: ldc ''
    //   1588: astore_3
    //   1589: goto -> 1299
    //   1592: ldc ''
    //   1594: astore_3
    //   1595: goto -> 1430
    // Exception table:
    //   from	to	target	type
    //   32	108	1506	java/lang/Exception
    //   118	127	1506	java/lang/Exception
    //   130	175	1506	java/lang/Exception
    //   175	195	1506	java/lang/Exception
    //   204	288	1506	java/lang/Exception
    //   291	332	1506	java/lang/Exception
    //   333	366	1506	java/lang/Exception
    //   369	385	1506	java/lang/Exception
    //   385	413	1506	java/lang/Exception
    //   416	427	1506	java/lang/Exception
    //   427	449	1506	java/lang/Exception
    //   449	546	1506	java/lang/Exception
    //   547	570	1506	java/lang/Exception
    //   576	590	1506	java/lang/Exception
    //   590	609	1506	java/lang/Exception
    //   609	619	1506	java/lang/Exception
    //   623	650	1506	java/lang/Exception
    //   651	667	1506	java/lang/Exception
    //   670	705	1506	java/lang/Exception
    //   708	719	1506	java/lang/Exception
    //   719	741	1506	java/lang/Exception
    //   741	835	1506	java/lang/Exception
    //   836	847	1506	java/lang/Exception
    //   855	865	1506	java/lang/Exception
    //   865	876	1506	java/lang/Exception
    //   884	894	1506	java/lang/Exception
    //   897	1049	1506	java/lang/Exception
    //   1049	1070	1506	java/lang/Exception
    //   1075	1113	1506	java/lang/Exception
    //   1113	1225	1506	java/lang/Exception
    //   1225	1296	1506	java/lang/Exception
    //   1299	1310	1506	java/lang/Exception
    //   1310	1332	1506	java/lang/Exception
    //   1332	1398	1506	java/lang/Exception
    //   1399	1427	1506	java/lang/Exception
    //   1430	1441	1506	java/lang/Exception
    //   1441	1463	1506	java/lang/Exception
    //   1463	1505	1506	java/lang/Exception
  }
  
  public void a(Context paramContext, String paramString, int paramInt, Boolean paramBoolean) {
    if (paramBoolean.booleanValue())
      Toast.makeText(paramContext, paramString, paramInt).show(); 
  }
  
  protected boolean a(Context paramContext, com.baidu.mobads.command.a parama) {
    String str3;
    boolean bool = XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(paramContext, parama.i);
    h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
    IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
    String str2 = "";
    if (bool) {
      Context context1 = this.a;
      if (this.b != null) {
        str3 = this.b.getProdInfo().getProdType();
      } else {
        str3 = "";
      } 
      String str6 = parama.i;
      String str7 = h.getAppId(this.a);
      if (this.b != null)
        str2 = this.b.getAdRequestInfo().getApid(); 
      h.sendDownloadAdLog(context1, 529, "alreadyinstalled", str3, str6, str7, str2, iXAdSystemUtils.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
      XAdSDKFoundationFacade.getInstance().getPackageUtils().openApp(paramContext, parama.i);
      return true;
    } 
    Context context = this.a;
    if (this.b != null) {
      str3 = this.b.getProdInfo().getProdType();
    } else {
      str3 = "";
    } 
    String str4 = parama.i;
    String str5 = h.getAppId(this.a);
    if (this.b != null)
      str2 = this.b.getAdRequestInfo().getApid(); 
    h.sendDownloadAdLog(context, 529, "alreadydownloaded", str3, str4, str5, str2, iXAdSystemUtils.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parama.c);
    stringBuilder.append(parama.b);
    String str1 = stringBuilder.toString();
    File file = new File(str1);
    if (file.exists() && file.length() > 0L) {
      XAdSDKFoundationFacade.getInstance().getPackageUtils().b(paramContext, str1);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */