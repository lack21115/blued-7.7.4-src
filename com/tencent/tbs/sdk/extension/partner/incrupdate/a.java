package com.tencent.tbs.sdk.extension.partner.incrupdate;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.patch.applier.ApplierConfig;
import com.tencent.tbs.patch.applier.ApplierService;
import com.tencent.tbs.sdk.extension.TbsSDKExtension;
import com.tencent.tbs.sdk.extension.partner.b.a.b;
import com.tencent.tbs.sdk.extension.partner.c.g;
import java.io.File;
import java.io.FileWriter;

public class a {
  private static int a = 100;
  
  private static String b = "";
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Bundle a(Context paramContext, Bundle paramBundle) {
    // Byte code:
    //   0: ldc 'TbsSDKExtension'
    //   2: ldc 'incrUpdate'
    //   4: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   7: pop
    //   8: bipush #100
    //   10: ldc 'success'
    //   12: invokestatic a : (ILjava/lang/String;)V
    //   15: ldc 'incrUpdate start'
    //   17: invokestatic a : (Ljava/lang/String;)V
    //   20: aload_0
    //   21: ifnull -> 1453
    //   24: aload_1
    //   25: ifnonnull -> 31
    //   28: goto -> 1453
    //   31: new android/os/Bundle
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #11
    //   40: aload #11
    //   42: ldc 'patch_result'
    //   44: iconst_1
    //   45: invokevirtual putInt : (Ljava/lang/String;I)V
    //   48: iconst_0
    //   49: istore #5
    //   51: aload_1
    //   52: ldc 'is_miniqb'
    //   54: iconst_0
    //   55: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   58: istore #6
    //   60: aload_1
    //   61: ldc 'operation'
    //   63: invokevirtual getInt : (Ljava/lang/String;)I
    //   66: istore #4
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore #7
    //   77: aload #7
    //   79: ldc 'operation:'
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload #7
    //   87: iload #4
    //   89: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload #7
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: invokestatic a : (Ljava/lang/String;)V
    //   101: iload #4
    //   103: iconst_3
    //   104: if_icmplt -> 1231
    //   107: iload #4
    //   109: sipush #10002
    //   112: if_icmple -> 1462
    //   115: goto -> 1231
    //   118: iload_2
    //   119: ifeq -> 172
    //   122: aload_1
    //   123: ldc 'old_core_ver'
    //   125: invokevirtual getInt : (Ljava/lang/String;)I
    //   128: istore_3
    //   129: aload_1
    //   130: ldc 'new_core_ver'
    //   132: invokevirtual getInt : (Ljava/lang/String;)I
    //   135: istore_2
    //   136: aload_1
    //   137: ldc 'old_apk_location'
    //   139: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   142: astore #8
    //   144: aload_1
    //   145: ldc 'new_apk_location'
    //   147: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   150: astore #9
    //   152: aload_1
    //   153: ldc 'diff_file_location'
    //   155: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   158: astore #7
    //   160: ldc 'full patch'
    //   162: invokestatic a : (Ljava/lang/String;)V
    //   165: goto -> 341
    //   168: astore_0
    //   169: goto -> 1245
    //   172: iload_3
    //   173: ifeq -> 328
    //   176: aload_0
    //   177: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/incrupdate/b;
    //   180: iload #6
    //   182: invokevirtual a : (Z)I
    //   185: istore_2
    //   186: new java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial <init> : ()V
    //   193: astore #7
    //   195: aload #7
    //   197: ldc 'continue patch,retryNum:'
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload #7
    //   205: iload_2
    //   206: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload #7
    //   212: invokevirtual toString : ()Ljava/lang/String;
    //   215: invokestatic a : (Ljava/lang/String;)V
    //   218: iload_2
    //   219: iconst_5
    //   220: if_icmple -> 256
    //   223: ldc 'incrUpdate retryNum > PATCH_NUM_RETRY!'
    //   225: invokestatic a : (Ljava/lang/String;)V
    //   228: ldc 'TbsSDKExtension'
    //   230: ldc 'incrUpdate retryNum > PATCH_NUM_RETRY!'
    //   232: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   235: pop
    //   236: aload_0
    //   237: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/incrupdate/b;
    //   240: iconst_0
    //   241: iload #6
    //   243: invokevirtual a : (IZ)V
    //   246: bipush #103
    //   248: ldc 'incrUpdate retryNum > PATCH_NUM_RETRY!'
    //   250: invokestatic a : (ILjava/lang/String;)V
    //   253: aload #11
    //   255: areturn
    //   256: aload_0
    //   257: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/incrupdate/b;
    //   260: iload_2
    //   261: iload #6
    //   263: invokevirtual a : (IZ)V
    //   266: aload_0
    //   267: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/incrupdate/b;
    //   270: iload #6
    //   272: invokevirtual b : (Z)Landroid/os/Bundle;
    //   275: astore #7
    //   277: aload #7
    //   279: ifnull -> 328
    //   282: aload #7
    //   284: ldc 'old_core_ver'
    //   286: invokevirtual getInt : (Ljava/lang/String;)I
    //   289: istore_3
    //   290: aload #7
    //   292: ldc 'new_core_ver'
    //   294: invokevirtual getInt : (Ljava/lang/String;)I
    //   297: istore_2
    //   298: aload #7
    //   300: ldc 'old_apk_location'
    //   302: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   305: astore #8
    //   307: aload #7
    //   309: ldc 'new_apk_location'
    //   311: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   314: astore #9
    //   316: aload #7
    //   318: ldc 'diff_file_location'
    //   320: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   323: astore #7
    //   325: goto -> 341
    //   328: iconst_0
    //   329: istore_3
    //   330: iconst_0
    //   331: istore_2
    //   332: aconst_null
    //   333: astore #8
    //   335: aconst_null
    //   336: astore #7
    //   338: aconst_null
    //   339: astore #9
    //   341: ldc 'TbsSDKExtension'
    //   343: ldc 'incrUpdate'
    //   345: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   348: pop
    //   349: new java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial <init> : ()V
    //   356: astore #10
    //   358: aload #10
    //   360: ldc 'incrUpdate old_core_ver='
    //   362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload #10
    //   368: iload_3
    //   369: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload #10
    //   375: invokevirtual toString : ()Ljava/lang/String;
    //   378: pop
    //   379: new java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial <init> : ()V
    //   386: astore #10
    //   388: aload #10
    //   390: ldc 'incrUpdate new_core_ver='
    //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload #10
    //   398: iload_2
    //   399: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload #10
    //   405: invokevirtual toString : ()Ljava/lang/String;
    //   408: pop
    //   409: new java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial <init> : ()V
    //   416: astore #10
    //   418: aload #10
    //   420: ldc 'incrUpdate old_apk_location='
    //   422: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload #10
    //   428: aload #8
    //   430: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload #10
    //   436: invokevirtual toString : ()Ljava/lang/String;
    //   439: pop
    //   440: new java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial <init> : ()V
    //   447: astore #10
    //   449: aload #10
    //   451: ldc 'incrUpdate new_apk_location='
    //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload #10
    //   459: aload #9
    //   461: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload #10
    //   467: invokevirtual toString : ()Ljava/lang/String;
    //   470: pop
    //   471: new java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial <init> : ()V
    //   478: astore #10
    //   480: aload #10
    //   482: ldc 'incrUpdate diff_file_location='
    //   484: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload #10
    //   490: aload #7
    //   492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload #10
    //   498: invokevirtual toString : ()Ljava/lang/String;
    //   501: pop
    //   502: new java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial <init> : ()V
    //   509: astore #10
    //   511: aload #10
    //   513: ldc 'patch filepath:old_core_ver='
    //   515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload #10
    //   521: iload_3
    //   522: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload #10
    //   528: ldc ', new_core_ver='
    //   530: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload #10
    //   536: iload_2
    //   537: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload #10
    //   543: ldc ', old_apk_location='
    //   545: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload #10
    //   551: aload #8
    //   553: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload #10
    //   559: ldc ', new_apk_location='
    //   561: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload #10
    //   567: aload #9
    //   569: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload #10
    //   575: ldc ', diff_file_location='
    //   577: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload #10
    //   583: aload #7
    //   585: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload #10
    //   591: invokevirtual toString : ()Ljava/lang/String;
    //   594: invokestatic a : (Ljava/lang/String;)V
    //   597: iload_3
    //   598: ifeq -> 1201
    //   601: iload_2
    //   602: ifeq -> 1201
    //   605: aload #8
    //   607: ifnull -> 1201
    //   610: aload #9
    //   612: ifnull -> 1201
    //   615: aload #7
    //   617: ifnonnull -> 1503
    //   620: goto -> 1201
    //   623: aload #8
    //   625: invokestatic c : (Ljava/lang/String;)Z
    //   628: ifne -> 657
    //   631: ldc 'TbsSDKExtension'
    //   633: ldc 'incrUpdate file not exist!'
    //   635: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   638: pop
    //   639: aload #11
    //   641: ldc 'patch_result'
    //   643: iconst_2
    //   644: invokevirtual putInt : (Ljava/lang/String;I)V
    //   647: bipush #104
    //   649: ldc 'backup package not exist'
    //   651: invokestatic a : (ILjava/lang/String;)V
    //   654: aload #11
    //   656: areturn
    //   657: aload #7
    //   659: invokestatic c : (Ljava/lang/String;)Z
    //   662: ifne -> 691
    //   665: ldc 'TbsSDKExtension'
    //   667: ldc 'incrUpdate file not exist!'
    //   669: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   672: pop
    //   673: aload #11
    //   675: ldc 'patch_result'
    //   677: iconst_2
    //   678: invokevirtual putInt : (Ljava/lang/String;I)V
    //   681: bipush #106
    //   683: ldc 'downloaded qbd not exist!'
    //   685: invokestatic a : (ILjava/lang/String;)V
    //   688: aload #11
    //   690: areturn
    //   691: aload_0
    //   692: aload #8
    //   694: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
    //   697: istore #4
    //   699: new java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial <init> : ()V
    //   706: astore #10
    //   708: aload #10
    //   710: ldc 'incrUpdate old_core_ver='
    //   712: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload #10
    //   718: iload_3
    //   719: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload #10
    //   725: invokevirtual toString : ()Ljava/lang/String;
    //   728: pop
    //   729: new java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial <init> : ()V
    //   736: astore #10
    //   738: aload #10
    //   740: ldc 'incrUpdate old_apk_core_ver='
    //   742: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload #10
    //   748: iload #4
    //   750: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload #10
    //   756: invokevirtual toString : ()Ljava/lang/String;
    //   759: pop
    //   760: iload_3
    //   761: iload #4
    //   763: if_icmpne -> 1125
    //   766: aload_0
    //   767: new java/io/File
    //   770: dup
    //   771: aload #8
    //   773: invokespecial <init> : (Ljava/lang/String;)V
    //   776: invokestatic a : (Landroid/content/Context;Ljava/io/File;)Z
    //   779: ifne -> 1518
    //   782: goto -> 1125
    //   785: aload #9
    //   787: aload #10
    //   789: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore #10
    //   794: new java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial <init> : ()V
    //   801: astore #12
    //   803: aload #12
    //   805: ldc 'incrUpdate tmp_apk_location='
    //   807: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload #12
    //   813: aload #10
    //   815: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload #12
    //   821: invokevirtual toString : ()Ljava/lang/String;
    //   824: pop
    //   825: aload_0
    //   826: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/incrupdate/b;
    //   829: aload_1
    //   830: iload #6
    //   832: invokevirtual a : (Landroid/os/Bundle;Z)V
    //   835: aload_0
    //   836: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/incrupdate/BSPatch;
    //   839: aload_0
    //   840: aload #8
    //   842: aload #10
    //   844: aload #7
    //   846: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   849: istore_3
    //   850: new java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial <init> : ()V
    //   857: astore_1
    //   858: aload_1
    //   859: ldc 'incrUpdate ret='
    //   861: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload_1
    //   866: iload_3
    //   867: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload_1
    //   872: ldc ','
    //   874: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload_1
    //   879: aload_0
    //   880: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/incrupdate/BSPatch;
    //   883: invokevirtual a : ()Ljava/lang/String;
    //   886: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload_1
    //   891: invokevirtual toString : ()Ljava/lang/String;
    //   894: invokestatic a : (Ljava/lang/String;)V
    //   897: iload_3
    //   898: ifne -> 1070
    //   901: aload_0
    //   902: aload #10
    //   904: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
    //   907: istore #4
    //   909: new java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial <init> : ()V
    //   916: astore_1
    //   917: aload_1
    //   918: ldc 'incrUpdate new_core_ver='
    //   920: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: pop
    //   924: aload_1
    //   925: iload_2
    //   926: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload_1
    //   931: invokevirtual toString : ()Ljava/lang/String;
    //   934: pop
    //   935: new java/lang/StringBuilder
    //   938: dup
    //   939: invokespecial <init> : ()V
    //   942: astore_1
    //   943: aload_1
    //   944: ldc 'incrUpdate new_apk_core_ver='
    //   946: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload_1
    //   951: iload #4
    //   953: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload_1
    //   958: invokevirtual toString : ()Ljava/lang/String;
    //   961: pop
    //   962: iload_2
    //   963: iload #4
    //   965: if_icmpne -> 1037
    //   968: aload_0
    //   969: new java/io/File
    //   972: dup
    //   973: aload #10
    //   975: invokespecial <init> : (Ljava/lang/String;)V
    //   978: invokestatic a : (Landroid/content/Context;Ljava/io/File;)Z
    //   981: ifne -> 987
    //   984: goto -> 1037
    //   987: aload #8
    //   989: invokestatic b : (Ljava/lang/String;)V
    //   992: aload #7
    //   994: invokestatic b : (Ljava/lang/String;)V
    //   997: aload #10
    //   999: aload #9
    //   1001: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   1004: ldc 'incrUpdate success!'
    //   1006: invokestatic a : (Ljava/lang/String;)V
    //   1009: aload #11
    //   1011: ldc 'patch_result'
    //   1013: iconst_0
    //   1014: invokevirtual putInt : (Ljava/lang/String;I)V
    //   1017: aload #11
    //   1019: ldc 'apk_path'
    //   1021: aload #9
    //   1023: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   1026: aload #11
    //   1028: ldc 'tbs_core_ver'
    //   1030: iload_2
    //   1031: invokevirtual putInt : (Ljava/lang/String;I)V
    //   1034: goto -> 1104
    //   1037: ldc 'TbsSDKExtension'
    //   1039: ldc 'incrUpdate new-apk-verify failed!'
    //   1041: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1044: pop
    //   1045: ldc 'incrUpdate new-apk-verify failed!'
    //   1047: invokestatic a : (Ljava/lang/String;)V
    //   1050: bipush #108
    //   1052: ldc 'incrUpdate new-apk-verify failed!'
    //   1054: invokestatic a : (ILjava/lang/String;)V
    //   1057: aload #10
    //   1059: invokestatic b : (Ljava/lang/String;)V
    //   1062: aload #7
    //   1064: invokestatic b : (Ljava/lang/String;)V
    //   1067: aload #11
    //   1069: areturn
    //   1070: ldc 'incrUpdate patch failed!'
    //   1072: invokestatic a : (Ljava/lang/String;)V
    //   1075: aload #10
    //   1077: invokestatic b : (Ljava/lang/String;)V
    //   1080: aload #7
    //   1082: invokestatic b : (Ljava/lang/String;)V
    //   1085: aload #8
    //   1087: invokestatic b : (Ljava/lang/String;)V
    //   1090: bipush #-2
    //   1092: iload_3
    //   1093: if_icmpne -> 1104
    //   1096: aload #11
    //   1098: ldc 'patch_result'
    //   1100: iconst_3
    //   1101: invokevirtual putInt : (Ljava/lang/String;I)V
    //   1104: iload_3
    //   1105: aload_0
    //   1106: invokestatic a : (Landroid/content/Context;)Lcom/tencent/tbs/sdk/extension/partner/incrupdate/BSPatch;
    //   1109: invokevirtual a : ()Ljava/lang/String;
    //   1112: invokestatic a : (ILjava/lang/String;)V
    //   1115: aload #11
    //   1117: areturn
    //   1118: astore_0
    //   1119: aload #10
    //   1121: astore_1
    //   1122: goto -> 1247
    //   1125: ldc 'TbsSDKExtension'
    //   1127: ldc 'incrUpdate old-apk-verify failed!'
    //   1129: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1132: pop
    //   1133: new java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial <init> : ()V
    //   1140: astore_0
    //   1141: aload_0
    //   1142: ldc 'backupoackage verify error:'
    //   1144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: iload_3
    //   1149: iload #4
    //   1151: if_icmpeq -> 1157
    //   1154: iconst_1
    //   1155: istore #5
    //   1157: aload_0
    //   1158: iload #5
    //   1160: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   1163: pop
    //   1164: bipush #107
    //   1166: aload_0
    //   1167: invokevirtual toString : ()Ljava/lang/String;
    //   1170: invokestatic a : (ILjava/lang/String;)V
    //   1173: aconst_null
    //   1174: invokestatic b : (Ljava/lang/String;)V
    //   1177: aload #7
    //   1179: invokestatic b : (Ljava/lang/String;)V
    //   1182: aload #8
    //   1184: invokestatic b : (Ljava/lang/String;)V
    //   1187: aload #11
    //   1189: areturn
    //   1190: aload_0
    //   1191: aload #8
    //   1193: aload #9
    //   1195: aload #7
    //   1197: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    //   1200: areturn
    //   1201: ldc 'TbsSDKExtension'
    //   1203: ldc 'incrUpdate init failed!'
    //   1205: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1208: pop
    //   1209: aload #11
    //   1211: ldc 'patch_result'
    //   1213: iconst_2
    //   1214: invokevirtual putInt : (Ljava/lang/String;I)V
    //   1217: bipush #104
    //   1219: ldc 'params error(version or location)'
    //   1221: invokestatic a : (ILjava/lang/String;)V
    //   1224: aload #11
    //   1226: areturn
    //   1227: astore_0
    //   1228: goto -> 1245
    //   1231: bipush #101
    //   1233: ldc 'operator not support'
    //   1235: invokestatic a : (ILjava/lang/String;)V
    //   1238: aload #11
    //   1240: areturn
    //   1241: astore_0
    //   1242: aconst_null
    //   1243: astore #7
    //   1245: aconst_null
    //   1246: astore_1
    //   1247: aload_0
    //   1248: invokevirtual printStackTrace : ()V
    //   1251: new java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial <init> : ()V
    //   1258: astore #8
    //   1260: aload #8
    //   1262: ldc 'incrUpdate Exception e='
    //   1264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: pop
    //   1268: aload #8
    //   1270: aload_0
    //   1271: invokevirtual getMessage : ()Ljava/lang/String;
    //   1274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: ldc 'TbsSDKExtension'
    //   1280: aload #8
    //   1282: invokevirtual toString : ()Ljava/lang/String;
    //   1285: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1288: pop
    //   1289: new java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial <init> : ()V
    //   1296: astore #8
    //   1298: aload #8
    //   1300: ldc 'incrUpdate Exception e='
    //   1302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload #8
    //   1308: aload_0
    //   1309: invokevirtual getMessage : ()Ljava/lang/String;
    //   1312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload #8
    //   1318: invokevirtual toString : ()Ljava/lang/String;
    //   1321: invokestatic a : (Ljava/lang/String;)V
    //   1324: new java/lang/StringBuilder
    //   1327: dup
    //   1328: invokespecial <init> : ()V
    //   1331: astore #8
    //   1333: aload #8
    //   1335: ldc 'exception:'
    //   1337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: pop
    //   1341: aload #8
    //   1343: aload_0
    //   1344: invokevirtual getMessage : ()Ljava/lang/String;
    //   1347: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: bipush #109
    //   1353: aload #8
    //   1355: invokevirtual toString : ()Ljava/lang/String;
    //   1358: invokestatic a : (ILjava/lang/String;)V
    //   1361: aload_1
    //   1362: invokestatic b : (Ljava/lang/String;)V
    //   1365: aload #7
    //   1367: invokestatic b : (Ljava/lang/String;)V
    //   1370: aload #11
    //   1372: areturn
    //   1373: astore_1
    //   1374: new java/lang/StringBuilder
    //   1377: dup
    //   1378: invokespecial <init> : ()V
    //   1381: astore #7
    //   1383: aload #7
    //   1385: ldc 'exception:'
    //   1387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: aload #7
    //   1393: aload_0
    //   1394: invokevirtual getMessage : ()Ljava/lang/String;
    //   1397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: pop
    //   1401: bipush #110
    //   1403: aload #7
    //   1405: invokevirtual toString : ()Ljava/lang/String;
    //   1408: invokestatic a : (ILjava/lang/String;)V
    //   1411: new java/lang/StringBuilder
    //   1414: dup
    //   1415: invokespecial <init> : ()V
    //   1418: astore #7
    //   1420: aload #7
    //   1422: ldc 'delete Throwable e='
    //   1424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: aload #7
    //   1430: aload_0
    //   1431: invokevirtual getMessage : ()Ljava/lang/String;
    //   1434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: pop
    //   1438: aload #7
    //   1440: invokevirtual toString : ()Ljava/lang/String;
    //   1443: invokestatic a : (Ljava/lang/String;)V
    //   1446: aload_1
    //   1447: invokevirtual printStackTrace : ()V
    //   1450: aload #11
    //   1452: areturn
    //   1453: bipush #101
    //   1455: ldc 'null host or bundle'
    //   1457: invokestatic a : (ILjava/lang/String;)V
    //   1460: aconst_null
    //   1461: areturn
    //   1462: iload #4
    //   1464: iconst_3
    //   1465: if_icmplt -> 1481
    //   1468: iload #4
    //   1470: sipush #10001
    //   1473: if_icmpgt -> 1481
    //   1476: iconst_1
    //   1477: istore_2
    //   1478: goto -> 1498
    //   1481: iload #4
    //   1483: sipush #10002
    //   1486: if_icmpne -> 1496
    //   1489: iconst_0
    //   1490: istore_2
    //   1491: iconst_1
    //   1492: istore_3
    //   1493: goto -> 118
    //   1496: iconst_0
    //   1497: istore_2
    //   1498: iconst_0
    //   1499: istore_3
    //   1500: goto -> 118
    //   1503: iload #4
    //   1505: iconst_4
    //   1506: if_icmpeq -> 1190
    //   1509: iload #4
    //   1511: iconst_5
    //   1512: if_icmpne -> 623
    //   1515: goto -> 1190
    //   1518: iload #6
    //   1520: ifeq -> 1530
    //   1523: ldc 'miniqb.tbs.temp'
    //   1525: astore #10
    //   1527: goto -> 785
    //   1530: ldc 'x5.tbs.temp'
    //   1532: astore #10
    //   1534: goto -> 785
    // Exception table:
    //   from	to	target	type
    //   60	101	1241	java/lang/Throwable
    //   122	160	1241	java/lang/Throwable
    //   160	165	168	java/lang/Throwable
    //   176	218	1241	java/lang/Throwable
    //   223	253	1241	java/lang/Throwable
    //   256	277	1241	java/lang/Throwable
    //   282	325	1241	java/lang/Throwable
    //   341	597	1227	java/lang/Throwable
    //   623	654	1227	java/lang/Throwable
    //   657	688	1227	java/lang/Throwable
    //   691	760	1227	java/lang/Throwable
    //   766	782	1227	java/lang/Throwable
    //   785	794	1227	java/lang/Throwable
    //   794	897	1118	java/lang/Throwable
    //   901	962	1118	java/lang/Throwable
    //   968	984	1118	java/lang/Throwable
    //   987	1034	1118	java/lang/Throwable
    //   1037	1067	1118	java/lang/Throwable
    //   1070	1090	1118	java/lang/Throwable
    //   1096	1104	1118	java/lang/Throwable
    //   1104	1115	1118	java/lang/Throwable
    //   1125	1148	1227	java/lang/Throwable
    //   1157	1187	1227	java/lang/Throwable
    //   1190	1201	1227	java/lang/Throwable
    //   1201	1224	1227	java/lang/Throwable
    //   1231	1238	1241	java/lang/Throwable
    //   1361	1370	1373	java/lang/Throwable
  }
  
  private static Bundle a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Bundle bundle = new Bundle();
    File file = new File(paramString1);
    if (!file.exists() || !file.isDirectory() || !(new File(file, "tbs.conf")).exists()) {
      a(112, "src dir not exist!!!");
      bundle.putInt("patch_result", -1);
      return bundle;
    } 
    try {
      ApplierService applierService = new ApplierService();
      applierService.setLogger(-1, -$$Lambda$a$HBRGH-RP3qqJ57Ivy-4sZDIDH78.INSTANCE);
      File file1 = new File(TbsSDKExtension.getTbsFolderDir(paramContext), "patch_tmp");
      ApplierConfig applierConfig = (new ApplierConfig.Builder()).sourceInput(paramString1, true).patchInput(paramString3).restoreOutput(paramString2, true).tempDir(file1.getAbsolutePath()).create();
      try {
        applierService.applySync(applierConfig);
        File[] arrayOfFile = (new File(paramString2)).listFiles();
        StringBuilder stringBuilder = new StringBuilder();
        if (arrayOfFile != null) {
          int j = arrayOfFile.length;
          applierConfig = null;
          int i;
          for (i = 0;; i++) {
            File file2;
            if (i < j) {
              File file3 = arrayOfFile[i];
              if (file3.isFile())
                if ("1".equals(file3.getName())) {
                  file2 = file3;
                } else {
                  String str = b.a(file3);
                  stringBuilder.append(file3.getName());
                  stringBuilder.append("=");
                  stringBuilder.append(str);
                  stringBuilder.append("\n");
                }  
            } else {
              if (file2 != null) {
                FileWriter fileWriter = new FileWriter(file2);
                fileWriter.write(stringBuilder.toString());
                fileWriter.close();
                bundle.putInt("patch_result", 0);
                return bundle;
              } 
              bundle.putInt("patch_result", -4);
              return bundle;
            } 
          } 
        } 
        bundle.putInt("patch_result", -5);
        return bundle;
      } catch (Throwable throwable) {
        throwable.printStackTrace();
        bundle.putInt("patch_result", -2);
        return bundle;
      } 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      bundle.putInt("patch_result", -3);
      return bundle;
    } 
  }
  
  public static void a(int paramInt, String paramString) {
    a = paramInt;
    b = paramString;
  }
  
  public static void a(Context paramContext) {
    int i = Integer.parseInt("044800");
    com.tencent.tbs.sdk.extension.partner.a.a.a(paramContext).b(a, b, i);
  }
  
  public static void a(String paramString) {
    g.a("TbsSDKExtension", paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */