package com.baidu.mobads.vo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.constants.a;
import com.baidu.mobads.f.g;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;

public abstract class d implements IXAdRequestInfo {
  private String a;
  
  protected String b;
  
  protected String c;
  
  protected Context d;
  
  protected Activity e;
  
  protected IXAdConstants4PDK.SlotType f;
  
  protected IXAdProdInfo g;
  
  protected IXAdConstants h;
  
  protected IXAdURIUitls i;
  
  protected boolean j;
  
  protected IXAdActivityUtils k;
  
  private String l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private String p;
  
  private String q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private boolean u;
  
  private long v;
  
  public d(Context paramContext, Activity paramActivity, IXAdConstants4PDK.SlotType paramSlotType) {
    Activity activity;
    Context context;
    this.c = "TODO";
    this.a = "android";
    this.l = "";
    this.o = XAdSDKFoundationFacade.getInstance().getAdConstants().getAdCreativeTypeImage();
    this.p = "LP,DL";
    this.q = "";
    this.s = 0;
    this.u = true;
    this.v = System.currentTimeMillis();
    this.b = "";
    this.h = (IXAdConstants)XAdSDKFoundationFacade.getInstance().getAdConstants();
    this.i = XAdSDKFoundationFacade.getInstance().getURIUitls();
    this.k = XAdSDKFoundationFacade.getInstance().getActivityUtils();
    if (paramContext instanceof Activity) {
      activity = (Activity)paramContext;
    } else {
      activity = null;
    } 
    this.e = activity;
    if (activity == null) {
      context = paramContext;
    } else {
      context = context.getApplicationContext();
    } 
    this.d = context;
    if (this.e == null && paramActivity != null)
      this.e = paramActivity; 
    this.j = this.k.webviewMultiProcess(this.e);
    this.f = paramSlotType;
    this.g = new b(this, this.f);
    c(this.f.getValue());
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    if ("0.0".equals(a.c)) {
      double d1 = g.b(paramContext);
      if (d1 > 0.0D)
        a.c = String.valueOf(d1); 
    } 
  }
  
  protected abstract HashMap<String, String> a();
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public String b() {
    HashMap<String, String> hashMap = e();
    hashMap.putAll(a());
    return XAdSDKFoundationFacade.getInstance().getURIUitls().getRequestAdUrl(this.b, hashMap);
  }
  
  public void b(String paramString) {
    this.p = paramString;
  }
  
  public void c(String paramString) {
    this.q = paramString;
  }
  
  public IXAdProdInfo d() {
    return this.g;
  }
  
  public void d(int paramInt) {
    this.m = paramInt;
  }
  
  public void d(String paramString) {
    this.l = paramString;
  }
  
  protected HashMap<String, String> e() {
    // Byte code:
    //   0: ldc ''
    //   2: astore #5
    //   4: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   7: invokevirtual getSystemUtils : ()Lcom/baidu/mobads/interfaces/utils/IXAdSystemUtils;
    //   10: astore #7
    //   12: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   15: invokevirtual getCommonUtils : ()Lcom/baidu/mobads/utils/h;
    //   18: astore #8
    //   20: new java/util/HashMap
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore #6
    //   29: new java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #4
    //   38: aload #4
    //   40: ldc ''
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #4
    //   48: aload #7
    //   50: aload_0
    //   51: getfield d : Landroid/content/Context;
    //   54: invokeinterface getNetworkCatagory : (Landroid/content/Context;)I
    //   59: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #6
    //   65: ldc 'net'
    //   67: aload #4
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: new java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial <init> : ()V
    //   83: astore #4
    //   85: aload #4
    //   87: ldc ''
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload #4
    //   95: aload_0
    //   96: invokevirtual getN : ()I
    //   99: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload #6
    //   105: ldc 'n'
    //   107: aload #4
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: new java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial <init> : ()V
    //   123: astore #4
    //   125: aload #4
    //   127: ldc ''
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload #4
    //   135: aload_0
    //   136: invokevirtual getAt : ()I
    //   139: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload #6
    //   145: ldc 'at'
    //   147: aload #4
    //   149: invokevirtual toString : ()Ljava/lang/String;
    //   152: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: new java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: astore #4
    //   165: aload #4
    //   167: aload_0
    //   168: invokevirtual f : ()Ljava/lang/String;
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload #4
    //   177: ldc '_'
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload #4
    //   185: getstatic com/baidu/mobads/constants/a.c : Ljava/lang/String;
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #4
    //   194: ldc '_'
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload #4
    //   202: ldc '4.1.30'
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload #6
    //   210: ldc 'v'
    //   212: aload #4
    //   214: invokevirtual toString : ()Ljava/lang/String;
    //   217: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   220: pop
    //   221: aload #6
    //   223: ldc 'cs'
    //   225: ldc ''
    //   227: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: aload #6
    //   233: ldc 'pk'
    //   235: aload #8
    //   237: aload_0
    //   238: getfield d : Landroid/content/Context;
    //   241: invokeinterface getAppPackage : (Landroid/content/Context;)Ljava/lang/String;
    //   246: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload #6
    //   252: ldc 'trftp'
    //   254: ldc_w 'sdk_8.8283'
    //   257: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload #8
    //   263: aload_0
    //   264: getfield d : Landroid/content/Context;
    //   267: invokeinterface getAppId : (Landroid/content/Context;)Ljava/lang/String;
    //   272: astore #4
    //   274: new java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial <init> : ()V
    //   281: astore #9
    //   283: aload #9
    //   285: aload #4
    //   287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload #9
    //   293: ldc_w '_cpr'
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload #6
    //   302: ldc_w 'q'
    //   305: aload #9
    //   307: invokevirtual toString : ()Ljava/lang/String;
    //   310: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   313: pop
    //   314: aload #6
    //   316: ldc_w 'appid'
    //   319: aload #4
    //   321: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   324: pop
    //   325: aload #6
    //   327: ldc_w 'tp'
    //   330: getstatic android/os/Build.MODEL : Ljava/lang/String;
    //   333: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   336: pop
    //   337: aload #6
    //   339: ldc_w 'brd'
    //   342: aload #7
    //   344: invokeinterface getPhoneOSBrand : ()Ljava/lang/String;
    //   349: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   352: pop
    //   353: aload #8
    //   355: aload_0
    //   356: getfield d : Landroid/content/Context;
    //   359: invokeinterface getDisplayMetrics : (Landroid/content/Context;)Landroid/util/DisplayMetrics;
    //   364: astore #4
    //   366: new java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial <init> : ()V
    //   373: astore #9
    //   375: aload #9
    //   377: ldc ''
    //   379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload #9
    //   385: aload #4
    //   387: getfield density : F
    //   390: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload #6
    //   396: ldc_w 'den'
    //   399: aload #9
    //   401: invokevirtual toString : ()Ljava/lang/String;
    //   404: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   407: pop
    //   408: new java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial <init> : ()V
    //   415: astore #9
    //   417: aload #9
    //   419: ldc ''
    //   421: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload #9
    //   427: aload_0
    //   428: invokevirtual getW : ()I
    //   431: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload #6
    //   437: ldc_w 'w'
    //   440: aload #9
    //   442: invokevirtual toString : ()Ljava/lang/String;
    //   445: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   448: pop
    //   449: new java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial <init> : ()V
    //   456: astore #9
    //   458: aload #9
    //   460: ldc ''
    //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload #9
    //   468: aload_0
    //   469: invokevirtual getH : ()I
    //   472: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload #6
    //   478: ldc_w 'h'
    //   481: aload #9
    //   483: invokevirtual toString : ()Ljava/lang/String;
    //   486: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   489: pop
    //   490: aload #8
    //   492: aload_0
    //   493: getfield d : Landroid/content/Context;
    //   496: invokeinterface getScreenRect : (Landroid/content/Context;)Landroid/graphics/Rect;
    //   501: astore #9
    //   503: new java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial <init> : ()V
    //   510: astore #10
    //   512: aload #10
    //   514: ldc ''
    //   516: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload #10
    //   522: aload #9
    //   524: invokevirtual width : ()I
    //   527: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload #6
    //   533: ldc_w 'sw'
    //   536: aload #10
    //   538: invokevirtual toString : ()Ljava/lang/String;
    //   541: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   544: pop
    //   545: new java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial <init> : ()V
    //   552: astore #10
    //   554: aload #10
    //   556: ldc ''
    //   558: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload #10
    //   564: aload #9
    //   566: invokevirtual height : ()I
    //   569: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload #6
    //   575: ldc_w 'sh'
    //   578: aload #10
    //   580: invokevirtual toString : ()Ljava/lang/String;
    //   583: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   586: pop
    //   587: aload #6
    //   589: ldc_w 'lw'
    //   592: aload_0
    //   593: invokevirtual getW : ()I
    //   596: i2f
    //   597: aload #4
    //   599: getfield density : F
    //   602: fdiv
    //   603: invokestatic round : (F)I
    //   606: invokestatic valueOf : (I)Ljava/lang/String;
    //   609: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   612: pop
    //   613: aload #6
    //   615: ldc_w 'lh'
    //   618: aload_0
    //   619: invokevirtual getH : ()I
    //   622: i2f
    //   623: aload #4
    //   625: getfield density : F
    //   628: fdiv
    //   629: invokestatic round : (F)I
    //   632: invokestatic valueOf : (I)Ljava/lang/String;
    //   635: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: pop
    //   639: aload #6
    //   641: ldc_w 'sn'
    //   644: aload #7
    //   646: aload_0
    //   647: getfield d : Landroid/content/Context;
    //   650: invokeinterface getSn : (Landroid/content/Context;)Ljava/lang/String;
    //   655: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   658: pop
    //   659: iconst_0
    //   660: istore_2
    //   661: aload #7
    //   663: aload_0
    //   664: getfield d : Landroid/content/Context;
    //   667: invokeinterface getCell : (Landroid/content/Context;)Ljava/util/List;
    //   672: astore #4
    //   674: aload #4
    //   676: invokeinterface size : ()I
    //   681: ifle -> 781
    //   684: new java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial <init> : ()V
    //   691: astore #9
    //   693: iconst_0
    //   694: istore_1
    //   695: iload_1
    //   696: aload #4
    //   698: invokeinterface size : ()I
    //   703: if_icmpge -> 763
    //   706: aload #4
    //   708: iload_1
    //   709: invokeinterface get : (I)Ljava/lang/Object;
    //   714: checkcast [Ljava/lang/String;
    //   717: astore #10
    //   719: aload #9
    //   721: ldc_w '%s_%s_%s|'
    //   724: iconst_3
    //   725: anewarray java/lang/Object
    //   728: dup
    //   729: iconst_0
    //   730: aload #10
    //   732: iconst_0
    //   733: aaload
    //   734: aastore
    //   735: dup
    //   736: iconst_1
    //   737: aload #10
    //   739: iconst_1
    //   740: aaload
    //   741: aastore
    //   742: dup
    //   743: iconst_2
    //   744: aload #10
    //   746: iconst_2
    //   747: aaload
    //   748: aastore
    //   749: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   752: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: iload_1
    //   757: iconst_1
    //   758: iadd
    //   759: istore_1
    //   760: goto -> 695
    //   763: aload #9
    //   765: iconst_0
    //   766: aload #9
    //   768: invokevirtual length : ()I
    //   771: iconst_1
    //   772: isub
    //   773: invokevirtual substring : (II)Ljava/lang/String;
    //   776: astore #4
    //   778: goto -> 785
    //   781: ldc ''
    //   783: astore #4
    //   785: aload #6
    //   787: ldc_w 'cid'
    //   790: aload #4
    //   792: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   795: pop
    //   796: aload #6
    //   798: ldc_w 'nop'
    //   801: aload #7
    //   803: aload_0
    //   804: getfield d : Landroid/content/Context;
    //   807: invokeinterface getNetworkOperator : (Landroid/content/Context;)Ljava/lang/String;
    //   812: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   815: pop
    //   816: aload #6
    //   818: ldc_w 'im'
    //   821: aload #8
    //   823: aload_0
    //   824: getfield d : Landroid/content/Context;
    //   827: invokeinterface getSubscriberId : (Landroid/content/Context;)Ljava/lang/String;
    //   832: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   835: pop
    //   836: aload #7
    //   838: aload_0
    //   839: getfield d : Landroid/content/Context;
    //   842: invokeinterface getGPS : (Landroid/content/Context;)[D
    //   847: astore #4
    //   849: aload #4
    //   851: ifnull -> 903
    //   854: invokestatic currentTimeMillis : ()J
    //   857: pop2
    //   858: ldc_w '%s_%s_%s'
    //   861: iconst_3
    //   862: anewarray java/lang/Object
    //   865: dup
    //   866: iconst_0
    //   867: aload #4
    //   869: iconst_0
    //   870: daload
    //   871: invokestatic valueOf : (D)Ljava/lang/Double;
    //   874: aastore
    //   875: dup
    //   876: iconst_1
    //   877: aload #4
    //   879: iconst_1
    //   880: daload
    //   881: invokestatic valueOf : (D)Ljava/lang/Double;
    //   884: aastore
    //   885: dup
    //   886: iconst_2
    //   887: aload #4
    //   889: iconst_2
    //   890: daload
    //   891: invokestatic valueOf : (D)Ljava/lang/Double;
    //   894: aastore
    //   895: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   898: astore #4
    //   900: goto -> 907
    //   903: ldc ''
    //   905: astore #4
    //   907: aload #6
    //   909: ldc_w 'g'
    //   912: aload #4
    //   914: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   917: pop
    //   918: aload #7
    //   920: aload_0
    //   921: getfield d : Landroid/content/Context;
    //   924: invokeinterface getWIFI : (Landroid/content/Context;)Ljava/util/List;
    //   929: astore #4
    //   931: aload #4
    //   933: invokeinterface size : ()I
    //   938: ifle -> 1031
    //   941: new java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial <init> : ()V
    //   948: astore #9
    //   950: iconst_0
    //   951: istore_1
    //   952: iload_1
    //   953: aload #4
    //   955: invokeinterface size : ()I
    //   960: if_icmpge -> 1013
    //   963: aload #4
    //   965: iload_1
    //   966: invokeinterface get : (I)Ljava/lang/Object;
    //   971: checkcast [Ljava/lang/String;
    //   974: astore #10
    //   976: aload #9
    //   978: ldc_w '%s_%s|'
    //   981: iconst_2
    //   982: anewarray java/lang/Object
    //   985: dup
    //   986: iconst_0
    //   987: aload #10
    //   989: iconst_0
    //   990: aaload
    //   991: aastore
    //   992: dup
    //   993: iconst_1
    //   994: aload #10
    //   996: iconst_1
    //   997: aaload
    //   998: aastore
    //   999: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1002: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: iload_1
    //   1007: iconst_1
    //   1008: iadd
    //   1009: istore_1
    //   1010: goto -> 952
    //   1013: aload #9
    //   1015: iconst_0
    //   1016: aload #9
    //   1018: invokevirtual length : ()I
    //   1021: iconst_1
    //   1022: isub
    //   1023: invokevirtual substring : (II)Ljava/lang/String;
    //   1026: astore #4
    //   1028: goto -> 1035
    //   1031: ldc ''
    //   1033: astore #4
    //   1035: aload #6
    //   1037: ldc_w 'wi'
    //   1040: aload #4
    //   1042: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: pop
    //   1046: new java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial <init> : ()V
    //   1053: astore #4
    //   1055: aload #4
    //   1057: ldc ''
    //   1059: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: iload_2
    //   1064: istore_1
    //   1065: ldc_w 'wifi'
    //   1068: aload #7
    //   1070: aload_0
    //   1071: getfield d : Landroid/content/Context;
    //   1074: invokeinterface getNetworkType : (Landroid/content/Context;)Ljava/lang/String;
    //   1079: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1082: ifeq -> 1087
    //   1085: iconst_1
    //   1086: istore_1
    //   1087: aload #4
    //   1089: iload_1
    //   1090: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1093: pop
    //   1094: aload #6
    //   1096: ldc_w 'swi'
    //   1099: aload #4
    //   1101: invokevirtual toString : ()Ljava/lang/String;
    //   1104: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1107: pop
    //   1108: aload #7
    //   1110: aload_0
    //   1111: getfield d : Landroid/content/Context;
    //   1114: invokeinterface isTablet : (Landroid/content/Context;)Z
    //   1119: istore_3
    //   1120: iload_3
    //   1121: ifeq -> 1714
    //   1124: ldc_w '1'
    //   1127: astore #4
    //   1129: goto -> 1132
    //   1132: aload #6
    //   1134: ldc_w 'tab'
    //   1137: aload #4
    //   1139: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1142: pop
    //   1143: new java/lang/StringBuilder
    //   1146: dup
    //   1147: invokespecial <init> : ()V
    //   1150: astore #4
    //   1152: aload #4
    //   1154: aload #7
    //   1156: invokeinterface getAppSDC : ()Ljava/lang/String;
    //   1161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: pop
    //   1165: aload #4
    //   1167: ldc_w ','
    //   1170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload #4
    //   1176: aload #7
    //   1178: invokeinterface getMem : ()Ljava/lang/String;
    //   1183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: aload #6
    //   1189: ldc_w 'sdc'
    //   1192: aload #4
    //   1194: invokevirtual toString : ()Ljava/lang/String;
    //   1197: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1200: pop
    //   1201: aload #6
    //   1203: ldc_w 'act'
    //   1206: aload_0
    //   1207: invokevirtual getAct : ()Ljava/lang/String;
    //   1210: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1213: pop
    //   1214: aload #6
    //   1216: ldc_w 'prod'
    //   1219: aload_0
    //   1220: invokevirtual getProd : ()Ljava/lang/String;
    //   1223: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1226: pop
    //   1227: aload #6
    //   1229: ldc_w 'os'
    //   1232: ldc 'android'
    //   1234: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1237: pop
    //   1238: aload #6
    //   1240: ldc_w 'osv'
    //   1243: getstatic android/os/Build$VERSION.RELEASE : Ljava/lang/String;
    //   1246: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1249: pop
    //   1250: new java/lang/StringBuilder
    //   1253: dup
    //   1254: invokespecial <init> : ()V
    //   1257: astore #4
    //   1259: aload #4
    //   1261: ldc ''
    //   1263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: aload #4
    //   1269: getstatic android/os/Build$VERSION.SDK_INT : I
    //   1272: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload #6
    //   1278: ldc_w 'bdr'
    //   1281: aload #4
    //   1283: invokevirtual toString : ()Ljava/lang/String;
    //   1286: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1289: pop
    //   1290: aload #6
    //   1292: ldc_w 'apinfo'
    //   1295: aload #8
    //   1297: aload_0
    //   1298: getfield d : Landroid/content/Context;
    //   1301: invokeinterface getBaiduMapsInfo : (Landroid/content/Context;)Ljava/lang/String;
    //   1306: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1309: pop
    //   1310: aload #6
    //   1312: ldc_w 'apid'
    //   1315: aload_0
    //   1316: invokevirtual getApid : ()Ljava/lang/String;
    //   1319: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1322: pop
    //   1323: aload #6
    //   1325: ldc_w 'chid'
    //   1328: aload #8
    //   1330: invokeinterface getChannelId : ()Ljava/lang/String;
    //   1335: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1338: pop
    //   1339: aload #6
    //   1341: ldc_w 'apt'
    //   1344: ldc_w '0'
    //   1347: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1350: pop
    //   1351: new java/lang/StringBuilder
    //   1354: dup
    //   1355: invokespecial <init> : ()V
    //   1358: astore #4
    //   1360: aload #4
    //   1362: ldc ''
    //   1364: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: pop
    //   1368: aload #4
    //   1370: aload_0
    //   1371: invokevirtual getAp : ()I
    //   1374: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: aload #6
    //   1380: ldc_w 'ap'
    //   1383: aload #4
    //   1385: invokevirtual toString : ()Ljava/lang/String;
    //   1388: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1391: pop
    //   1392: aload #6
    //   1394: ldc_w 'nt'
    //   1397: aload #7
    //   1399: aload_0
    //   1400: getfield d : Landroid/content/Context;
    //   1403: invokeinterface getNetType : (Landroid/content/Context;)Ljava/lang/String;
    //   1408: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1411: pop
    //   1412: aload #6
    //   1414: ldc_w 'udid'
    //   1417: ldc ''
    //   1419: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1422: pop
    //   1423: new java/lang/StringBuilder
    //   1426: dup
    //   1427: invokespecial <init> : ()V
    //   1430: astore #4
    //   1432: aload #4
    //   1434: ldc ''
    //   1436: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload #4
    //   1442: aload_0
    //   1443: invokevirtual getSes : ()J
    //   1446: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: aload #6
    //   1452: ldc_w 'ses'
    //   1455: aload #4
    //   1457: invokevirtual toString : ()Ljava/lang/String;
    //   1460: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1463: pop
    //   1464: aload #6
    //   1466: ldc_w 'android_id'
    //   1469: aload #7
    //   1471: aload_0
    //   1472: getfield d : Landroid/content/Context;
    //   1475: invokeinterface getAndroidId : (Landroid/content/Context;)Ljava/lang/String;
    //   1480: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1483: pop
    //   1484: aload #6
    //   1486: ldc_w 'imei'
    //   1489: aload #7
    //   1491: aload_0
    //   1492: getfield d : Landroid/content/Context;
    //   1495: invokeinterface getIMEI : (Landroid/content/Context;)Ljava/lang/String;
    //   1500: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1503: pop
    //   1504: aload #6
    //   1506: ldc_w 'mac'
    //   1509: aload #7
    //   1511: aload_0
    //   1512: getfield d : Landroid/content/Context;
    //   1515: invokeinterface getMacAddress : (Landroid/content/Context;)Ljava/lang/String;
    //   1520: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1523: pop
    //   1524: aload #6
    //   1526: ldc_w 'cuid'
    //   1529: aload #7
    //   1531: aload_0
    //   1532: getfield d : Landroid/content/Context;
    //   1535: invokeinterface getCUID : (Landroid/content/Context;)Ljava/lang/String;
    //   1540: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1543: pop
    //   1544: aload #6
    //   1546: ldc_w 'snfrom'
    //   1549: aload #7
    //   1551: aload_0
    //   1552: getfield d : Landroid/content/Context;
    //   1555: invokeinterface getSnFrom : (Landroid/content/Context;)Ljava/lang/String;
    //   1560: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1563: pop
    //   1564: aload #6
    //   1566: ldc_w 'p_ver'
    //   1569: ldc_w '8.8283'
    //   1572: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1575: pop
    //   1576: aload #6
    //   1578: ldc_w 'req_id'
    //   1581: aload #8
    //   1583: aload_0
    //   1584: getfield d : Landroid/content/Context;
    //   1587: aload_0
    //   1588: invokevirtual getApid : ()Ljava/lang/String;
    //   1591: invokeinterface createRequestId : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1596: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1599: pop
    //   1600: aload #5
    //   1602: astore #4
    //   1604: aload #7
    //   1606: aload_0
    //   1607: getfield d : Landroid/content/Context;
    //   1610: invokeinterface isWifiConnected : (Landroid/content/Context;)Ljava/lang/Boolean;
    //   1615: invokevirtual booleanValue : ()Z
    //   1618: ifeq -> 1634
    //   1621: aload #7
    //   1623: aload_0
    //   1624: getfield d : Landroid/content/Context;
    //   1627: invokeinterface getWifiConnected : (Landroid/content/Context;)Ljava/lang/String;
    //   1632: astore #4
    //   1634: aload #6
    //   1636: ldc_w 'cssid'
    //   1639: aload #4
    //   1641: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1644: pop
    //   1645: aload #6
    //   1647: ldc_w 'msa'
    //   1650: iconst_1
    //   1651: invokestatic valueOf : (I)Ljava/lang/String;
    //   1654: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1657: pop
    //   1658: invokestatic getSupportHttps : ()Ljava/lang/String;
    //   1661: getstatic com/baidu/mobads/AdSettings$b.c : Lcom/baidu/mobads/AdSettings$b;
    //   1664: invokevirtual a : ()Ljava/lang/String;
    //   1667: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1670: ifeq -> 1691
    //   1673: aload #6
    //   1675: ldc_w 'rpt'
    //   1678: getstatic com/baidu/mobads/AdSettings$b.c : Lcom/baidu/mobads/AdSettings$b;
    //   1681: invokevirtual a : ()Ljava/lang/String;
    //   1684: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   1687: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1690: pop
    //   1691: aload #6
    //   1693: areturn
    //   1694: astore #4
    //   1696: aload #6
    //   1698: areturn
    //   1699: astore #4
    //   1701: goto -> 781
    //   1704: astore #4
    //   1706: goto -> 903
    //   1709: astore #4
    //   1711: goto -> 1031
    //   1714: ldc_w '0'
    //   1717: astore #4
    //   1719: goto -> 1132
    // Exception table:
    //   from	to	target	type
    //   29	659	1694	java/lang/Exception
    //   661	693	1699	java/lang/Exception
    //   695	756	1699	java/lang/Exception
    //   763	778	1699	java/lang/Exception
    //   785	836	1694	java/lang/Exception
    //   836	849	1704	java/lang/Exception
    //   854	900	1704	java/lang/Exception
    //   907	918	1694	java/lang/Exception
    //   918	950	1709	java/lang/Exception
    //   952	1006	1709	java/lang/Exception
    //   1013	1028	1709	java/lang/Exception
    //   1035	1063	1694	java/lang/Exception
    //   1065	1085	1694	java/lang/Exception
    //   1087	1120	1694	java/lang/Exception
    //   1132	1600	1694	java/lang/Exception
    //   1604	1634	1694	java/lang/Exception
    //   1634	1691	1694	java/lang/Exception
  }
  
  public void e(int paramInt) {
    this.n = paramInt;
  }
  
  public String f() {
    return this.a;
  }
  
  public void f(int paramInt) {
    this.r = paramInt;
  }
  
  public void g(int paramInt) {
    this.t = paramInt;
  }
  
  public String getAct() {
    return this.p;
  }
  
  public int getAp() {
    return this.s;
  }
  
  public String getApid() {
    return this.l;
  }
  
  public int getApt() {
    return this.r;
  }
  
  public int getAt() {
    return this.o;
  }
  
  public int getH() {
    return this.n;
  }
  
  public int getN() {
    return this.t;
  }
  
  public String getProd() {
    return this.q;
  }
  
  public long getSes() {
    return this.v;
  }
  
  public String getSex() {
    return "";
  }
  
  public String getUk() {
    return "";
  }
  
  public int getW() {
    return this.m;
  }
  
  public String getZip() {
    return "";
  }
  
  public void h(int paramInt) {
    this.s = paramInt;
  }
  
  public void i(int paramInt) {
    this.o = paramInt;
  }
  
  public boolean isCanClick() {
    return this.u;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\vo\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */