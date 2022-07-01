package com.baidu.mobads.production;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.b.a;
import com.baidu.mobads.command.a.a;
import com.baidu.mobads.command.c.c;
import com.baidu.mobads.e.a;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class p implements IXAdContainerEventListener {
  private Context a;
  
  private final b b;
  
  private AtomicBoolean c;
  
  private AtomicBoolean d;
  
  private AtomicBoolean e;
  
  private AtomicBoolean f;
  
  private IXAdContainer g;
  
  private IXAdInstanceInfo h;
  
  private h i;
  
  private t j;
  
  private IXAdResource k;
  
  private int l = 0;
  
  private int m = 2;
  
  private int n = 15;
  
  private int o = 0;
  
  private int p = 2;
  
  private int q = 15;
  
  public p(Context paramContext, b paramb) {
    this.a = paramContext;
    this.b = paramb;
    this.c = new AtomicBoolean(false);
    this.d = new AtomicBoolean(false);
    this.e = new AtomicBoolean(false);
    this.f = new AtomicBoolean(false);
  }
  
  private void a() {
    b b1 = this.b;
    if (b1 != null && this.j != null) {
      h h1 = this.i;
      if (h1 != null && this.h != null) {
        if (this.k == null)
          return; 
        h1.sendDownloadAdLog(b1.getApplicationContext(), 525, "click", this.b.getProdInfo().getProdType(), this.h.getAppPackageName(), this.i.getAppId(this.b.getApplicationContext()), this.b.getProdInfo().getAdPlacementId(), this.j.getPhoneOSBrand(), Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
        (new a(this.b, this.h, this.k)).a();
      } 
    } 
  }
  
  private void a(Context paramContext, String paramString) {
    try {
      this.o = 0;
      Timer timer = new Timer();
      timer.schedule(new r(this, (IXAdPackageUtils)XAdSDKFoundationFacade.getInstance().getPackageUtils(), paramContext, paramString, timer), 0L, 1000L);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void a(Context paramContext, String paramString1, String paramString2) {
    try {
      this.l = 0;
      Timer timer = new Timer();
      timer.schedule(new q(this, (IXAdPackageUtils)XAdSDKFoundationFacade.getInstance().getPackageUtils(), paramContext, paramString2, timer, paramString1), 0L, 1000L);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void a(Set<String> paramSet) {
    a a = new a();
    Iterator<String> iterator = paramSet.iterator();
    while (iterator.hasNext()) {
      b b1 = new b(iterator.next(), "");
      b1.e = 1;
      a.a(b1, Boolean.valueOf(true));
    } 
  }
  
  public boolean a(HashMap<String, Object> paramHashMap, IXNonLinearAdSlot paramIXNonLinearAdSlot, IXAdResource paramIXAdResource, IXAdInstanceInfo paramIXAdInstanceInfo) {
    if (paramHashMap != null && paramHashMap.containsKey("lpShoubaiStyle") && paramHashMap.get("lpShoubaiStyle").equals("video_and_web")) {
      c c = new c(paramIXNonLinearAdSlot, paramIXAdInstanceInfo, paramIXAdResource, paramIXAdInstanceInfo.getWebUrl());
      c.f = (String)paramHashMap.get("lpShoubaiStyle");
      c.g = (String)paramHashMap.get("lpMurlStyle");
      c.a();
      return true;
    } 
    return false;
  }
  
  public void onAdClicked(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   4: invokevirtual getCommonUtils : ()Lcom/baidu/mobads/utils/h;
    //   7: putfield i : Lcom/baidu/mobads/utils/h;
    //   10: aload_0
    //   11: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   14: invokevirtual getSystemUtils : ()Lcom/baidu/mobads/interfaces/utils/IXAdSystemUtils;
    //   17: checkcast com/baidu/mobads/utils/t
    //   20: putfield j : Lcom/baidu/mobads/utils/t;
    //   23: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   26: invokevirtual getAdConstants : ()Lcom/baidu/mobads/utils/l;
    //   29: astore #11
    //   31: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   34: invokevirtual getPackageUtils : ()Lcom/baidu/mobads/utils/r;
    //   37: astore #13
    //   39: aload_0
    //   40: getfield b : Lcom/baidu/mobads/production/b;
    //   43: astore #10
    //   45: aload_0
    //   46: aload_1
    //   47: putfield g : Lcom/baidu/mobads/interfaces/IXAdContainer;
    //   50: aload_0
    //   51: aload_2
    //   52: putfield h : Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;
    //   55: aload_0
    //   56: aload_1
    //   57: invokeinterface getAdContainerContext : ()Lcom/baidu/mobads/interfaces/IXAdContainerContext;
    //   62: invokeinterface getAdResource : ()Lcom/baidu/mobads/interfaces/IXAdResource;
    //   67: putfield k : Lcom/baidu/mobads/interfaces/IXAdResource;
    //   70: iconst_0
    //   71: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   74: astore #9
    //   76: aload_2
    //   77: invokeinterface getClickThroughUrl : ()Ljava/lang/String;
    //   82: astore #12
    //   84: aload_2
    //   85: invokeinterface getActionType : ()I
    //   90: istore #7
    //   92: new java/util/ArrayList
    //   95: dup
    //   96: invokespecial <init> : ()V
    //   99: astore #8
    //   101: aload_2
    //   102: invokeinterface getThirdClickTrackingUrls : ()Ljava/util/List;
    //   107: astore #14
    //   109: iconst_0
    //   110: istore #5
    //   112: iload #5
    //   114: aload #14
    //   116: invokeinterface size : ()I
    //   121: if_icmpge -> 167
    //   124: aload #8
    //   126: aload #14
    //   128: iload #5
    //   130: invokeinterface get : (I)Ljava/lang/Object;
    //   135: checkcast java/lang/String
    //   138: ldc_w '\$\{PROGRESS\}'
    //   141: aload_1
    //   142: invokeinterface getPlayheadTime : ()D
    //   147: d2i
    //   148: invokestatic valueOf : (I)Ljava/lang/String;
    //   151: invokevirtual replaceAll : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual add : (Ljava/lang/Object;)Z
    //   157: pop
    //   158: iload #5
    //   160: iconst_1
    //   161: iadd
    //   162: istore #5
    //   164: goto -> 112
    //   167: new java/util/HashSet
    //   170: dup
    //   171: invokespecial <init> : ()V
    //   174: astore #14
    //   176: aload #14
    //   178: aload #8
    //   180: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   185: pop
    //   186: aload_0
    //   187: aload #14
    //   189: invokespecial a : (Ljava/util/Set;)V
    //   192: iload #7
    //   194: aload #11
    //   196: invokeinterface getActTypeOpenExternalApp : ()I
    //   201: if_icmpne -> 583
    //   204: new org/json/JSONObject
    //   207: dup
    //   208: aload #12
    //   210: invokespecial <init> : (Ljava/lang/String;)V
    //   213: astore #8
    //   215: goto -> 272
    //   218: new org/json/JSONObject
    //   221: dup
    //   222: aload_2
    //   223: invokeinterface getAppOpenStrs : ()Ljava/lang/String;
    //   228: invokespecial <init> : (Ljava/lang/String;)V
    //   231: astore #8
    //   233: new com/baidu/mobads/openad/d/a
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: astore #9
    //   242: new com/baidu/mobads/openad/d/b
    //   245: dup
    //   246: aload #12
    //   248: ldc ''
    //   250: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   253: astore #12
    //   255: aload #12
    //   257: iconst_1
    //   258: putfield e : I
    //   261: aload #9
    //   263: aload #12
    //   265: iconst_1
    //   266: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   269: invokevirtual a : (Lcom/baidu/mobads/openad/d/b;Ljava/lang/Boolean;)V
    //   272: aload #8
    //   274: ldc_w 'page'
    //   277: ldc ''
    //   279: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   282: astore #9
    //   284: aload #13
    //   286: aload #10
    //   288: invokeinterface getApplicationContext : ()Landroid/content/Context;
    //   293: aload #9
    //   295: aload_2
    //   296: invokeinterface getAppPackageName : ()Ljava/lang/String;
    //   301: sipush #366
    //   304: aload #8
    //   306: ldc_w 'fb_act'
    //   309: iconst_0
    //   310: invokevirtual optInt : (Ljava/lang/String;I)I
    //   313: aload #8
    //   315: ldc_w 'version'
    //   318: iconst_0
    //   319: invokevirtual optInt : (Ljava/lang/String;I)I
    //   322: invokeinterface sendAPOInfo : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;III)Z
    //   327: ifeq -> 359
    //   330: aload_3
    //   331: invokevirtual booleanValue : ()Z
    //   334: ifeq -> 555
    //   337: new com/baidu/mobads/command/b/a
    //   340: dup
    //   341: aload #10
    //   343: aload_2
    //   344: aload_0
    //   345: getfield k : Lcom/baidu/mobads/interfaces/IXAdResource;
    //   348: aload #9
    //   350: invokespecial <init> : (Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;Lcom/baidu/mobads/interfaces/IXAdResource;Ljava/lang/String;)V
    //   353: invokevirtual a : ()V
    //   356: goto -> 555
    //   359: aload #8
    //   361: ldc_w 'fb_act'
    //   364: iconst_0
    //   365: invokevirtual optInt : (Ljava/lang/String;I)I
    //   368: istore #5
    //   370: new com/baidu/mobads/vo/XAdInstanceInfo
    //   373: dup
    //   374: aload_2
    //   375: invokeinterface getOriginJsonObject : ()Lorg/json/JSONObject;
    //   380: invokespecial <init> : (Lorg/json/JSONObject;)V
    //   383: astore #12
    //   385: iload #5
    //   387: aload #11
    //   389: invokeinterface getActTypeLandingPage : ()I
    //   394: if_icmpne -> 454
    //   397: aload #12
    //   399: aload #11
    //   401: invokeinterface getActTypeLandingPage : ()I
    //   406: invokevirtual setActionType : (I)V
    //   409: aload #12
    //   411: aload #8
    //   413: ldc_w 'fallback'
    //   416: ldc ''
    //   418: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   421: invokevirtual setClickThroughUrl : (Ljava/lang/String;)V
    //   424: aload #12
    //   426: aload_2
    //   427: invokeinterface getTitle : ()Ljava/lang/String;
    //   432: invokevirtual setTitle : (Ljava/lang/String;)V
    //   435: aload #12
    //   437: iconst_1
    //   438: invokevirtual setInapp : (Z)V
    //   441: aload_0
    //   442: aload_1
    //   443: aload #12
    //   445: aload_3
    //   446: aload #4
    //   448: invokevirtual onAdClicked : (Lcom/baidu/mobads/interfaces/IXAdContainer;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;Ljava/lang/Boolean;Ljava/util/HashMap;)V
    //   451: goto -> 555
    //   454: iload #5
    //   456: aload #11
    //   458: invokeinterface getActTypeDownload : ()I
    //   463: if_icmpne -> 555
    //   466: aload #12
    //   468: aload #11
    //   470: invokeinterface getActTypeDownload : ()I
    //   475: invokevirtual setActionType : (I)V
    //   478: aload #12
    //   480: aload #8
    //   482: ldc_w 'fallback'
    //   485: ldc ''
    //   487: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   490: invokevirtual setClickThroughUrl : (Ljava/lang/String;)V
    //   493: aload #12
    //   495: aload_2
    //   496: invokeinterface getTitle : ()Ljava/lang/String;
    //   501: invokevirtual setTitle : (Ljava/lang/String;)V
    //   504: aload #12
    //   506: aload_2
    //   507: invokeinterface getQueryKey : ()Ljava/lang/String;
    //   512: invokevirtual setQueryKey : (Ljava/lang/String;)V
    //   515: aload #12
    //   517: iconst_1
    //   518: invokevirtual setInapp : (Z)V
    //   521: aload #12
    //   523: iconst_1
    //   524: invokevirtual setAPOOpen : (Z)V
    //   527: aload #12
    //   529: aload #9
    //   531: invokevirtual setPage : (Ljava/lang/String;)V
    //   534: aload #12
    //   536: aload_2
    //   537: invokeinterface getAppPackageName : ()Ljava/lang/String;
    //   542: invokevirtual setAppPackageName : (Ljava/lang/String;)V
    //   545: aload_0
    //   546: aload_1
    //   547: aload #12
    //   549: aload_3
    //   550: aload #4
    //   552: invokevirtual onAdClicked : (Lcom/baidu/mobads/interfaces/IXAdContainer;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;Ljava/lang/Boolean;Ljava/util/HashMap;)V
    //   555: aload_0
    //   556: aload #10
    //   558: invokeinterface getApplicationContext : ()Landroid/content/Context;
    //   563: aload #9
    //   565: aload_2
    //   566: invokeinterface getAppPackageName : ()Ljava/lang/String;
    //   571: invokespecial a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   574: iconst_1
    //   575: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   578: astore #8
    //   580: goto -> 1113
    //   583: iconst_0
    //   584: istore #6
    //   586: iload #7
    //   588: aload #11
    //   590: invokeinterface getActTypeDownload : ()I
    //   595: if_icmpne -> 640
    //   598: aload #9
    //   600: astore #8
    //   602: aload_0
    //   603: aload #4
    //   605: aload #10
    //   607: aload_0
    //   608: getfield k : Lcom/baidu/mobads/interfaces/IXAdResource;
    //   611: aload_2
    //   612: invokevirtual a : (Ljava/util/HashMap;Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;Lcom/baidu/mobads/interfaces/IXAdResource;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;)Z
    //   615: ifne -> 1113
    //   618: aload #9
    //   620: astore #8
    //   622: aload_3
    //   623: invokevirtual booleanValue : ()Z
    //   626: ifeq -> 1113
    //   629: aload_0
    //   630: invokespecial a : ()V
    //   633: aload #9
    //   635: astore #8
    //   637: goto -> 1113
    //   640: iload #7
    //   642: aload #11
    //   644: invokeinterface getActTypeLandingPage : ()I
    //   649: if_icmpeq -> 964
    //   652: iload #7
    //   654: aload #11
    //   656: invokeinterface getActTypeOpenMap : ()I
    //   661: if_icmpne -> 667
    //   664: goto -> 964
    //   667: iload #7
    //   669: aload #11
    //   671: invokeinterface getActTypeMakeCall : ()I
    //   676: if_icmpeq -> 740
    //   679: iload #7
    //   681: aload #11
    //   683: invokeinterface getActTypeSendSMS : ()I
    //   688: if_icmpeq -> 740
    //   691: iload #7
    //   693: aload #11
    //   695: invokeinterface getActTypeSendMail : ()I
    //   700: if_icmpne -> 706
    //   703: goto -> 740
    //   706: iload #7
    //   708: aload #11
    //   710: invokeinterface getActTypeNothing2Do : ()I
    //   715: if_icmpne -> 725
    //   718: aload #9
    //   720: astore #8
    //   722: goto -> 1113
    //   725: aload #11
    //   727: invokeinterface getActTypeRichMedia : ()I
    //   732: pop
    //   733: aload #9
    //   735: astore #8
    //   737: goto -> 1113
    //   740: iconst_1
    //   741: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   744: astore #4
    //   746: aload_3
    //   747: invokevirtual booleanValue : ()Z
    //   750: ifeq -> 772
    //   753: new com/baidu/mobads/command/b/a
    //   756: dup
    //   757: aload #10
    //   759: aload_2
    //   760: aload_0
    //   761: getfield k : Lcom/baidu/mobads/interfaces/IXAdResource;
    //   764: aload #12
    //   766: invokespecial <init> : (Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;Lcom/baidu/mobads/interfaces/IXAdResource;Ljava/lang/String;)V
    //   769: invokevirtual a : ()V
    //   772: aload #4
    //   774: astore #8
    //   776: iload #7
    //   778: aload #11
    //   780: invokeinterface getActTypeMakeCall : ()I
    //   785: if_icmpne -> 1113
    //   788: aload #10
    //   790: invokeinterface getApplicationContext : ()Landroid/content/Context;
    //   795: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   798: astore_1
    //   799: new android/content/Intent
    //   802: dup
    //   803: ldc_w 'android.intent.action.VIEW'
    //   806: invokespecial <init> : (Ljava/lang/String;)V
    //   809: astore_3
    //   810: aload_3
    //   811: aload #12
    //   813: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   816: invokevirtual setData : (Landroid/net/Uri;)Landroid/content/Intent;
    //   819: pop
    //   820: aload_1
    //   821: aload_3
    //   822: bipush #64
    //   824: invokevirtual queryIntentActivities : (Landroid/content/Intent;I)Ljava/util/List;
    //   827: astore_3
    //   828: aload #4
    //   830: astore #8
    //   832: aload_3
    //   833: ifnull -> 1113
    //   836: aload #4
    //   838: astore #8
    //   840: aload_3
    //   841: invokeinterface size : ()I
    //   846: ifle -> 1113
    //   849: aconst_null
    //   850: astore_1
    //   851: iconst_0
    //   852: istore #5
    //   854: iload #5
    //   856: aload_3
    //   857: invokeinterface size : ()I
    //   862: if_icmpge -> 933
    //   865: iload #5
    //   867: iconst_1
    //   868: if_icmplt -> 906
    //   871: aload_1
    //   872: ifnull -> 906
    //   875: aload_1
    //   876: aload_3
    //   877: iload #5
    //   879: invokeinterface get : (I)Ljava/lang/Object;
    //   884: checkcast android/content/pm/ResolveInfo
    //   887: getfield activityInfo : Landroid/content/pm/ActivityInfo;
    //   890: getfield processName : Ljava/lang/String;
    //   893: invokevirtual equals : (Ljava/lang/Object;)Z
    //   896: ifne -> 906
    //   899: iload #6
    //   901: istore #5
    //   903: goto -> 936
    //   906: aload_3
    //   907: iload #5
    //   909: invokeinterface get : (I)Ljava/lang/Object;
    //   914: checkcast android/content/pm/ResolveInfo
    //   917: getfield activityInfo : Landroid/content/pm/ActivityInfo;
    //   920: getfield processName : Ljava/lang/String;
    //   923: astore_1
    //   924: iload #5
    //   926: iconst_1
    //   927: iadd
    //   928: istore #5
    //   930: goto -> 854
    //   933: iconst_1
    //   934: istore #5
    //   936: aload #4
    //   938: astore #8
    //   940: iload #5
    //   942: ifeq -> 1113
    //   945: aload_0
    //   946: aload #10
    //   948: invokeinterface getApplicationContext : ()Landroid/content/Context;
    //   953: aload_1
    //   954: invokespecial a : (Landroid/content/Context;Ljava/lang/String;)V
    //   957: aload #4
    //   959: astore #8
    //   961: goto -> 1113
    //   964: aload_0
    //   965: getfield b : Lcom/baidu/mobads/production/b;
    //   968: invokevirtual getProdInfo : ()Lcom/baidu/mobads/interfaces/IXAdProdInfo;
    //   971: invokeinterface getProdType : ()Ljava/lang/String;
    //   976: aload #11
    //   978: invokeinterface getProductionTypeSplash : ()Ljava/lang/String;
    //   983: if_acmpeq -> 992
    //   986: iconst_1
    //   987: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   990: astore #9
    //   992: aload #9
    //   994: astore #8
    //   996: aload_3
    //   997: invokevirtual booleanValue : ()Z
    //   1000: ifeq -> 1113
    //   1003: aload_2
    //   1004: invokeinterface isInapp : ()Z
    //   1009: ifeq -> 1089
    //   1012: aload #9
    //   1014: astore #8
    //   1016: aload_0
    //   1017: aload #4
    //   1019: aload #10
    //   1021: aload_0
    //   1022: getfield k : Lcom/baidu/mobads/interfaces/IXAdResource;
    //   1025: aload_2
    //   1026: invokevirtual a : (Ljava/util/HashMap;Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;Lcom/baidu/mobads/interfaces/IXAdResource;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;)Z
    //   1029: ifne -> 1113
    //   1032: new com/baidu/mobads/command/c/c
    //   1035: dup
    //   1036: aload #10
    //   1038: aload_2
    //   1039: aload_0
    //   1040: getfield k : Lcom/baidu/mobads/interfaces/IXAdResource;
    //   1043: aload #12
    //   1045: invokespecial <init> : (Lcom/baidu/mobads/interfaces/IXNonLinearAdSlot;Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;Lcom/baidu/mobads/interfaces/IXAdResource;Ljava/lang/String;)V
    //   1048: astore_1
    //   1049: aload #4
    //   1051: ifnull -> 1078
    //   1054: aload #4
    //   1056: ldc 'lpShoubaiStyle'
    //   1058: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   1061: ifeq -> 1078
    //   1064: aload_1
    //   1065: aload #4
    //   1067: ldc 'lpShoubaiStyle'
    //   1069: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1072: checkcast java/lang/String
    //   1075: putfield f : Ljava/lang/String;
    //   1078: aload_1
    //   1079: invokevirtual a : ()V
    //   1082: aload #9
    //   1084: astore #8
    //   1086: goto -> 1113
    //   1089: aload_0
    //   1090: getfield i : Lcom/baidu/mobads/utils/h;
    //   1093: aload_1
    //   1094: invokeinterface getAdContainerContext : ()Lcom/baidu/mobads/interfaces/IXAdContainerContext;
    //   1099: invokeinterface getApplicationContext : ()Landroid/content/Context;
    //   1104: aload #12
    //   1106: invokevirtual browserOutside : (Landroid/content/Context;Ljava/lang/String;)V
    //   1109: aload #9
    //   1111: astore #8
    //   1113: aload #8
    //   1115: invokevirtual booleanValue : ()Z
    //   1118: ifeq -> 1138
    //   1121: aload_0
    //   1122: getfield b : Lcom/baidu/mobads/production/b;
    //   1125: new com/baidu/mobads/e/a
    //   1128: dup
    //   1129: ldc_w 'AdClickThru'
    //   1132: invokespecial <init> : (Ljava/lang/String;)V
    //   1135: invokevirtual dispatchEvent : (Lcom/baidu/mobads/openad/interfaces/event/IOAdEvent;)V
    //   1138: new com/baidu/mobads/e/a
    //   1141: dup
    //   1142: ldc_w 'AdUserClick'
    //   1145: invokespecial <init> : (Ljava/lang/String;)V
    //   1148: astore_1
    //   1149: aload_1
    //   1150: aload_2
    //   1151: invokevirtual setData : (Lcom/baidu/mobads/interfaces/IXAdInstanceInfo;)V
    //   1154: aload_0
    //   1155: getfield b : Lcom/baidu/mobads/production/b;
    //   1158: aload_1
    //   1159: invokevirtual dispatchEvent : (Lcom/baidu/mobads/openad/interfaces/event/IOAdEvent;)V
    //   1162: return
    //   1163: astore #8
    //   1165: goto -> 218
    //   1168: astore_1
    //   1169: return
    // Exception table:
    //   from	to	target	type
    //   204	215	1163	java/lang/Exception
    //   218	272	1168	java/lang/Exception
  }
  
  public void onAdCustomEvent(String paramString, IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (paramString.equals("onrvideocachesucc")) {
      this.b.dispatchEvent((IOAdEvent)new a("AdRvdieoCacheSucc", paramHashMap));
      return;
    } 
    if (paramString.equals("onrvideocachefailed")) {
      this.b.dispatchEvent((IOAdEvent)new a("AdRvdieoCacheFailed", paramHashMap));
      return;
    } 
    if (paramString.equals("playCompletion")) {
      this.b.dispatchEvent((IOAdEvent)new a("PlayCompletion", paramHashMap));
      return;
    } 
    if (paramString.equals("AdRvdieoPlayError")) {
      this.b.dispatchEvent((IOAdEvent)new a("AdRvdieoPlayError", paramHashMap));
      return;
    } 
    if (paramString.equals("AdStatusChange"))
      this.b.dispatchEvent((IOAdEvent)new a("AdStatusChange", paramHashMap)); 
  }
  
  public void onAdDurationChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdError(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (!this.e.get()) {
      if (paramHashMap != null) {
        l l = XAdSDKFoundationFacade.getInstance().getAdConstants();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramHashMap.get(l.getInfoKeyErrorCode()));
        stringBuilder.append(",");
        stringBuilder.append(paramHashMap.get(l.getInfoKeyErrorMessage()));
        stringBuilder.append(",");
        stringBuilder.append(paramHashMap.get(l.getInfoKeyErrorModule()));
        String str = stringBuilder.toString();
        a.a().a(str);
      } 
      this.e.set(true);
      this.b.dispatchEvent((IOAdEvent)new a("AdError", paramHashMap));
    } 
  }
  
  public void onAdExpandedChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdImpression(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    a(paramIXAdInstanceInfo.getImpressionUrls());
    a a = new a("AdImpression");
    a.setData(paramIXAdInstanceInfo);
    this.b.dispatchEvent((IOAdEvent)a);
  }
  
  public void onAdInteraction(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdLinearChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdLoaded(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.b.c(paramIXAdContainer, paramHashMap);
      return;
    } 
    (new Handler(this.a.getMainLooper())).post(new s(this, paramIXAdContainer, paramHashMap));
  }
  
  public void onAdPaused(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    this.b.dispatchEvent((IOAdEvent)new a("AdPaused"));
  }
  
  public void onAdPlaying(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    this.b.dispatchEvent((IOAdEvent)new a("AdPlaying"));
  }
  
  public void onAdRemainingTimeChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdSizeChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdSkippableStateChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdSkipped(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdStarted(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.b.d(paramIXAdContainer, paramHashMap);
      return;
    } 
    (new Handler(this.a.getMainLooper())).post(new t(this, paramIXAdContainer, paramHashMap));
  }
  
  public void onAdStoped(IXAdContainer paramIXAdContainer, IXAdInstanceInfo paramIXAdInstanceInfo, Boolean paramBoolean1, Boolean paramBoolean2, HashMap<String, Object> paramHashMap) {
    IXAdContainerContext iXAdContainerContext;
    if (paramIXAdInstanceInfo != null) {
      HashSet<String> hashSet = new HashSet();
      hashSet.addAll(paramIXAdInstanceInfo.getCloseTrackers());
      a(hashSet);
    } 
    if (paramBoolean2.booleanValue()) {
      iXAdContainerContext = paramIXAdContainer.getAdContainerContext();
      this.b.a(iXAdContainerContext.getAdResponseInfo(), iXAdContainerContext.getAdInstanceInfo());
      return;
    } 
    this.b.e((IXAdContainer)iXAdContainerContext, paramHashMap);
    this.b.dispatchEvent((IOAdEvent)new a("AdStopped", paramHashMap));
  }
  
  public void onAdUserAcceptInvitation(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdUserClosed(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    this.b.dispatchEvent((IOAdEvent)new a("AdUserClose"));
  }
  
  public void onAdUserMinimize(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdVideoComplete(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdVideoFirstQuartile(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdVideoMidpoint(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdVideoStart(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdVideoThirdQuartile(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
  
  public void onAdVolumeChange(IXAdContainer paramIXAdContainer, Boolean paramBoolean, HashMap<String, Object> paramHashMap) {
    if (this.e.get());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */