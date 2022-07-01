package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Process;
import java.util.ArrayList;
import java.util.List;

public class o {
  private static String a(Context paramContext) {
    try {
      int i = Process.myPid();
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      if (activityManager != null)
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
          if (runningAppProcessInfo.pid == i)
            return runningAppProcessInfo.processName; 
        }  
    } finally {}
    return "unknown";
  }
  
  private static List<a> a(Context paramContext, int paramInt) {
    ArrayList<a> arrayList;
    XmlResourceParser xmlResourceParser;
    try {
      arrayList = new ArrayList();
      xmlResourceParser = paramContext.getResources().getXml(paramInt);
      paramInt = xmlResourceParser.getEventType();
    } finally {
      paramContext = null;
    } 
  }
  
  public static void a() {
    // Byte code:
    //   0: invokestatic a : ()Landroid/content/Context;
    //   3: astore #9
    //   5: aload #9
    //   7: ifnonnull -> 11
    //   10: return
    //   11: invokestatic c : ()Z
    //   14: ifne -> 18
    //   17: return
    //   18: aload #9
    //   20: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   23: astore #10
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #11
    //   34: aload #11
    //   36: ldc '==当前进程名：'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload #11
    //   44: aload #10
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc 'TTAdSdk-InitChecker'
    //   52: aload #11
    //   54: invokevirtual toString : ()Ljava/lang/String;
    //   57: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   60: ldc 'TTAdSdk-InitChecker'
    //   62: ldc '==穿山甲sdk接入，环境为debug，初始化配置检测开始=='
    //   64: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload #9
    //   69: invokevirtual getPackageName : ()Ljava/lang/String;
    //   72: astore #10
    //   74: aload #9
    //   76: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   79: getfield targetSdkVersion : I
    //   82: istore_3
    //   83: aload #9
    //   85: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   88: astore #11
    //   90: aload #11
    //   92: aload #9
    //   94: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   97: getfield processName : Ljava/lang/String;
    //   100: aload #9
    //   102: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   105: getfield uid : I
    //   108: ldc 131072
    //   110: invokevirtual queryContentProviders : (Ljava/lang/String;II)Ljava/util/List;
    //   113: invokeinterface iterator : ()Ljava/util/Iterator;
    //   118: astore #12
    //   120: iconst_0
    //   121: istore_2
    //   122: iconst_0
    //   123: istore_1
    //   124: iconst_0
    //   125: istore_0
    //   126: aload #12
    //   128: invokeinterface hasNext : ()Z
    //   133: ifeq -> 739
    //   136: aload #12
    //   138: invokeinterface next : ()Ljava/lang/Object;
    //   143: checkcast android/content/pm/ProviderInfo
    //   146: astore #13
    //   148: ldc 'com.bytedance.sdk.openadsdk.multipro.TTMultiProvider'
    //   150: aload #13
    //   152: getfield name : Ljava/lang/String;
    //   155: invokevirtual equals : (Ljava/lang/Object;)Z
    //   158: ifeq -> 239
    //   161: new java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial <init> : ()V
    //   168: astore #14
    //   170: aload #14
    //   172: aload #10
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload #14
    //   180: ldc '.TTMultiProvider'
    //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload #14
    //   188: invokevirtual toString : ()Ljava/lang/String;
    //   191: astore #14
    //   193: aload #14
    //   195: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   198: ifne -> 227
    //   201: aload #14
    //   203: aload #13
    //   205: getfield authority : Ljava/lang/String;
    //   208: invokevirtual equals : (Ljava/lang/Object;)Z
    //   211: ifne -> 217
    //   214: goto -> 227
    //   217: ldc 'TTAdSdk-InitChecker'
    //   219: ldc 'AndroidManifest.xml中TTMultiProvider配置正常'
    //   221: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   224: goto -> 234
    //   227: ldc 'TTAdSdk-InitChecker'
    //   229: ldc 'AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档'
    //   231: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   234: iconst_1
    //   235: istore_1
    //   236: goto -> 126
    //   239: aload #13
    //   241: getfield authority : Ljava/lang/String;
    //   244: astore #14
    //   246: new java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial <init> : ()V
    //   253: astore #15
    //   255: aload #15
    //   257: aload #10
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload #15
    //   265: ldc '.TTFileProvider'
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload #14
    //   273: aload #15
    //   275: invokevirtual toString : ()Ljava/lang/String;
    //   278: invokevirtual equals : (Ljava/lang/Object;)Z
    //   281: ifeq -> 126
    //   284: getstatic android/os/Build$VERSION.SDK_INT : I
    //   287: bipush #24
    //   289: if_icmplt -> 664
    //   292: iload_3
    //   293: bipush #24
    //   295: if_icmpge -> 301
    //   298: goto -> 664
    //   301: aload #13
    //   303: getfield exported : Z
    //   306: ifeq -> 316
    //   309: ldc 'TTAdSdk-InitChecker'
    //   311: ldc 'AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档'
    //   313: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload #13
    //   318: getfield grantUriPermissions : Z
    //   321: ifne -> 331
    //   324: ldc 'TTAdSdk-InitChecker'
    //   326: ldc 'AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档'
    //   328: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload #9
    //   333: aload #11
    //   335: new android/content/ComponentName
    //   338: dup
    //   339: aload #10
    //   341: aload #13
    //   343: getfield name : Ljava/lang/String;
    //   346: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   349: sipush #128
    //   352: invokevirtual getProviderInfo : (Landroid/content/ComponentName;I)Landroid/content/pm/ProviderInfo;
    //   355: getfield metaData : Landroid/os/Bundle;
    //   358: ldc 'android.support.FILE_PROVIDER_PATHS'
    //   360: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   363: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   366: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   369: invokevirtual intValue : ()I
    //   372: invokestatic a : (Landroid/content/Context;I)Ljava/util/List;
    //   375: astore #15
    //   377: aload #15
    //   379: ifnull -> 638
    //   382: aload #15
    //   384: invokeinterface isEmpty : ()Z
    //   389: ifne -> 638
    //   392: invokestatic c : ()Ljava/util/List;
    //   395: astore #14
    //   397: invokestatic d : ()Ljava/util/List;
    //   400: astore #13
    //   402: aload #15
    //   404: invokeinterface iterator : ()Ljava/util/Iterator;
    //   409: astore #15
    //   411: aload #15
    //   413: invokeinterface hasNext : ()Z
    //   418: ifeq -> 461
    //   421: aload #15
    //   423: invokeinterface next : ()Ljava/lang/Object;
    //   428: checkcast com/bytedance/sdk/openadsdk/utils/o$a
    //   431: astore #16
    //   433: aload #16
    //   435: ifnull -> 411
    //   438: aload #14
    //   440: aload #16
    //   442: invokeinterface remove : (Ljava/lang/Object;)Z
    //   447: pop
    //   448: aload #13
    //   450: aload #16
    //   452: invokeinterface remove : (Ljava/lang/Object;)Z
    //   457: pop
    //   458: goto -> 411
    //   461: aload #14
    //   463: invokeinterface isEmpty : ()Z
    //   468: ifeq -> 492
    //   471: aload #13
    //   473: invokeinterface isEmpty : ()Z
    //   478: ifeq -> 492
    //   481: ldc 'TTAdSdk-InitChecker'
    //   483: ldc_w 'AndroidManifest.xml中TTFileProvider配置正常'
    //   486: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   489: goto -> 734
    //   492: aload #14
    //   494: invokeinterface iterator : ()Ljava/util/Iterator;
    //   499: astore #14
    //   501: aload #14
    //   503: invokeinterface hasNext : ()Z
    //   508: ifeq -> 565
    //   511: aload #14
    //   513: invokeinterface next : ()Ljava/lang/Object;
    //   518: checkcast com/bytedance/sdk/openadsdk/utils/o$a
    //   521: astore #15
    //   523: new java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial <init> : ()V
    //   530: astore #16
    //   532: aload #16
    //   534: ldc_w '    TTFileProvider缺少必要路径：'
    //   537: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload #16
    //   543: aload #15
    //   545: invokevirtual toString : ()Ljava/lang/String;
    //   548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: ldc 'TTAdSdk-InitChecker'
    //   554: aload #16
    //   556: invokevirtual toString : ()Ljava/lang/String;
    //   559: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   562: goto -> 501
    //   565: aload #13
    //   567: invokeinterface iterator : ()Ljava/util/Iterator;
    //   572: astore #13
    //   574: aload #13
    //   576: invokeinterface hasNext : ()Z
    //   581: ifeq -> 734
    //   584: aload #13
    //   586: invokeinterface next : ()Ljava/lang/Object;
    //   591: checkcast com/bytedance/sdk/openadsdk/utils/o$a
    //   594: astore #14
    //   596: new java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial <init> : ()V
    //   603: astore #15
    //   605: aload #15
    //   607: ldc_w '    TTFileProvider缺少可选路径：'
    //   610: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload #15
    //   616: aload #14
    //   618: invokevirtual toString : ()Ljava/lang/String;
    //   621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: ldc 'TTAdSdk-InitChecker'
    //   627: aload #15
    //   629: invokevirtual toString : ()Ljava/lang/String;
    //   632: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   635: goto -> 574
    //   638: ldc 'TTAdSdk-InitChecker'
    //   640: ldc_w 'AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档'
    //   643: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   646: goto -> 734
    //   649: astore #13
    //   651: ldc 'TTAdSdk-InitChecker'
    //   653: ldc_w 'AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档'
    //   656: aload #13
    //   658: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   661: goto -> 734
    //   664: new java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial <init> : ()V
    //   671: astore #13
    //   673: aload #13
    //   675: ldc_w 'TTFileProvider不需要适配：target='
    //   678: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload #13
    //   684: iload_3
    //   685: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   688: pop
    //   689: aload #13
    //   691: ldc_w '&phone='
    //   694: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload #13
    //   700: getstatic android/os/Build$VERSION.SDK_INT : I
    //   703: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload #13
    //   709: ldc_w ', require='
    //   712: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload #13
    //   718: bipush #24
    //   720: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: ldc 'TTAdSdk-InitChecker'
    //   726: aload #13
    //   728: invokevirtual toString : ()Ljava/lang/String;
    //   731: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   734: iconst_1
    //   735: istore_0
    //   736: goto -> 126
    //   739: aload #11
    //   741: aload #10
    //   743: sipush #4096
    //   746: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   749: getfield requestedPermissions : [Ljava/lang/String;
    //   752: astore #10
    //   754: aload #10
    //   756: ifnull -> 905
    //   759: aload #10
    //   761: arraylength
    //   762: ifle -> 905
    //   765: invokestatic b : ()Ljava/util/List;
    //   768: astore #11
    //   770: aload #10
    //   772: arraylength
    //   773: istore #4
    //   775: iload_2
    //   776: iload #4
    //   778: if_icmpge -> 805
    //   781: aload #10
    //   783: iload_2
    //   784: aaload
    //   785: astore #12
    //   787: aload #12
    //   789: ifnull -> 1214
    //   792: aload #11
    //   794: aload #12
    //   796: invokeinterface remove : (Ljava/lang/Object;)Z
    //   801: pop
    //   802: goto -> 1214
    //   805: aload #11
    //   807: invokeinterface isEmpty : ()Z
    //   812: ifeq -> 826
    //   815: ldc 'TTAdSdk-InitChecker'
    //   817: ldc_w 'AndroidManifest.xml中权限配置正常'
    //   820: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   823: goto -> 928
    //   826: aload #11
    //   828: invokeinterface iterator : ()Ljava/util/Iterator;
    //   833: astore #10
    //   835: aload #10
    //   837: invokeinterface hasNext : ()Z
    //   842: ifeq -> 928
    //   845: aload #10
    //   847: invokeinterface next : ()Ljava/lang/Object;
    //   852: checkcast java/lang/String
    //   855: astore #11
    //   857: new java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial <init> : ()V
    //   864: astore #12
    //   866: aload #12
    //   868: ldc_w '    可能缺少权限：'
    //   871: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: aload #12
    //   877: aload #11
    //   879: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload #12
    //   885: ldc_w '，请参考接入文档'
    //   888: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: ldc 'TTAdSdk-InitChecker'
    //   894: aload #12
    //   896: invokevirtual toString : ()Ljava/lang/String;
    //   899: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   902: goto -> 835
    //   905: ldc 'TTAdSdk-InitChecker'
    //   907: ldc_w 'AndroidManifest.xml中uses-permission配置丢失，请参考接入文档'
    //   910: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   913: goto -> 928
    //   916: astore #10
    //   918: ldc 'TTAdSdk-InitChecker'
    //   920: ldc_w 'AndroidManifest.xml中uses-permission配置错误，请参考接入文档'
    //   923: aload #10
    //   925: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   928: getstatic android/os/Build$VERSION.SDK_INT : I
    //   931: bipush #23
    //   933: if_icmplt -> 1096
    //   936: iload_3
    //   937: bipush #23
    //   939: if_icmpge -> 945
    //   942: goto -> 1096
    //   945: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/core/f/d;
    //   948: aload #9
    //   950: ldc_w 'android.permission.READ_PHONE_STATE'
    //   953: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   956: istore #5
    //   958: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/core/f/d;
    //   961: aload #9
    //   963: ldc_w 'android.permission.ACCESS_COARSE_LOCATION'
    //   966: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   969: istore #6
    //   971: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/core/f/d;
    //   974: aload #9
    //   976: ldc_w 'android.permission.ACCESS_FINE_LOCATION'
    //   979: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   982: istore #7
    //   984: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/core/f/d;
    //   987: aload #9
    //   989: ldc_w 'android.permission.WRITE_EXTERNAL_STORAGE'
    //   992: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   995: istore #8
    //   997: iload #5
    //   999: ifne -> 1013
    //   1002: ldc 'TTAdSdk-InitChecker'
    //   1004: ldc_w '动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE'
    //   1007: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1010: goto -> 1021
    //   1013: ldc 'TTAdSdk-InitChecker'
    //   1015: ldc_w '动态权限正常：android.permission.READ_PHONE_STATE'
    //   1018: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1021: iload #6
    //   1023: ifne -> 1037
    //   1026: ldc 'TTAdSdk-InitChecker'
    //   1028: ldc_w '动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION'
    //   1031: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1034: goto -> 1045
    //   1037: ldc 'TTAdSdk-InitChecker'
    //   1039: ldc_w '动态权限正常：android.permission.ACCESS_COARSE_LOCATION'
    //   1042: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1045: iload #7
    //   1047: ifne -> 1061
    //   1050: ldc 'TTAdSdk-InitChecker'
    //   1052: ldc_w '动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION'
    //   1055: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1058: goto -> 1069
    //   1061: ldc 'TTAdSdk-InitChecker'
    //   1063: ldc_w '动态权限正常：android.permission.ACCESS_FINE_LOCATION'
    //   1066: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1069: iload #8
    //   1071: ifne -> 1085
    //   1074: ldc 'TTAdSdk-InitChecker'
    //   1076: ldc_w '动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE'
    //   1079: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1082: goto -> 1181
    //   1085: ldc 'TTAdSdk-InitChecker'
    //   1087: ldc_w '动态权限正常：android.permission.WRITE_EXTERNAL_STORAGE'
    //   1090: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1093: goto -> 1181
    //   1096: new java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial <init> : ()V
    //   1103: astore #9
    //   1105: aload #9
    //   1107: ldc_w '动态权限不需要适配：target='
    //   1110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: pop
    //   1114: aload #9
    //   1116: iload_3
    //   1117: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1120: pop
    //   1121: aload #9
    //   1123: ldc_w '&phone='
    //   1126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: aload #9
    //   1132: getstatic android/os/Build$VERSION.SDK_INT : I
    //   1135: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1138: pop
    //   1139: aload #9
    //   1141: ldc_w ', require='
    //   1144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: aload #9
    //   1150: bipush #23
    //   1152: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1155: pop
    //   1156: ldc 'TTAdSdk-InitChecker'
    //   1158: aload #9
    //   1160: invokevirtual toString : ()Ljava/lang/String;
    //   1163: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1166: goto -> 1181
    //   1169: astore #9
    //   1171: ldc 'TTAdSdk-InitChecker'
    //   1173: ldc_w '动态权限获取异常，请检查并详细阅读接入文档'
    //   1176: aload #9
    //   1178: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1181: iload_1
    //   1182: ifne -> 1193
    //   1185: ldc 'TTAdSdk-InitChecker'
    //   1187: ldc_w '××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××'
    //   1190: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1193: iload_0
    //   1194: ifne -> 1205
    //   1197: ldc 'TTAdSdk-InitChecker'
    //   1199: ldc_w '××您没有配置TTFileProvider，请参考接入文档，否则影响转化××'
    //   1202: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1205: ldc 'TTAdSdk-InitChecker'
    //   1207: ldc_w '==穿山甲sdk初始化配置检测结束=='
    //   1210: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1213: return
    //   1214: iload_2
    //   1215: iconst_1
    //   1216: iadd
    //   1217: istore_2
    //   1218: goto -> 775
    // Exception table:
    //   from	to	target	type
    //   331	377	649	finally
    //   382	411	649	finally
    //   411	433	649	finally
    //   438	458	649	finally
    //   461	489	649	finally
    //   492	501	649	finally
    //   501	562	649	finally
    //   565	574	649	finally
    //   574	635	649	finally
    //   638	646	649	finally
    //   739	754	916	finally
    //   759	775	916	finally
    //   792	802	916	finally
    //   805	823	916	finally
    //   826	835	916	finally
    //   835	902	916	finally
    //   905	913	916	finally
    //   928	936	1169	finally
    //   945	997	1169	finally
    //   1002	1010	1169	finally
    //   1013	1021	1169	finally
    //   1026	1034	1169	finally
    //   1037	1045	1169	finally
    //   1050	1058	1169	finally
    //   1061	1069	1169	finally
    //   1074	1082	1169	finally
    //   1085	1093	1169	finally
    //   1096	1166	1169	finally
  }
  
  private static List<String> b() {
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("android.permission.INTERNET");
    arrayList.add("android.permission.ACCESS_NETWORK_STATE");
    arrayList.add("android.permission.ACCESS_WIFI_STATE");
    arrayList.add("android.permission.READ_PHONE_STATE");
    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
    arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
    arrayList.add("android.permission.GET_TASKS");
    arrayList.add("android.permission.WAKE_LOCK");
    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
    return arrayList;
  }
  
  private static List<a> c() {
    ArrayList<a> arrayList = new ArrayList();
    arrayList.add(new a("external-path", "tt_external_download", "Download"));
    arrayList.add(new a("external-files-path", "tt_external_files_download", "Download"));
    arrayList.add(new a("files-path", "tt_internal_file_download", "Download"));
    arrayList.add(new a("cache-path", "tt_internal_cache_download", "Download"));
    return arrayList;
  }
  
  private static List<a> d() {
    ArrayList<a> arrayList = new ArrayList();
    arrayList.add(new a("external-path", "tt_external_root", "."));
    return arrayList;
  }
  
  static class a {
    String a;
    
    String b;
    
    String c;
    
    a(String param1String1, String param1String2, String param1String3) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1String3;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof a) {
        param1Object = param1Object;
        String str = this.a;
        if (str != null && str.equals(((a)param1Object).a)) {
          str = this.c;
          if (str != null && str.equals(((a)param1Object).c))
            return true; 
        } 
        return false;
      } 
      return super.equals(param1Object);
    }
    
    public String toString() {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(this.a);
        stringBuilder.append(" name=\"");
        stringBuilder.append(this.b);
        stringBuilder.append("\" path=\"");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
      } finally {
        Exception exception = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */