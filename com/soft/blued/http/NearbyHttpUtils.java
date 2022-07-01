package com.soft.blued.http;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.AesCrypto;
import com.google.gson.Gson;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.MapToken;
import com.soft.blued.ui.find.model.NearbyModule;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.List;
import java.util.Map;

public class NearbyHttpUtils {
  public static FilterEntity a(Context paramContext, FilterEntity paramFilterEntity) {
    // Byte code:
    //   0: invokestatic G : ()Z
    //   3: ifeq -> 2180
    //   6: invokestatic aD : ()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpeq -> 20
    //   15: iload_2
    //   16: iconst_2
    //   17: if_icmpeq -> 25
    //   20: iconst_0
    //   21: istore_2
    //   22: goto -> 27
    //   25: iconst_1
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq -> 51
    //   31: aload_0
    //   32: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   35: ldc 2130903080
    //   37: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   40: astore #7
    //   42: aload_0
    //   43: invokestatic a : (Landroid/content/Context;)[Ljava/lang/String;
    //   46: astore #10
    //   48: goto -> 73
    //   51: aload_0
    //   52: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   55: ldc 2130903075
    //   57: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   60: astore #7
    //   62: aload_0
    //   63: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   66: ldc 2130903115
    //   68: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   71: astore #10
    //   73: aload_0
    //   74: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   77: ldc 2130903040
    //   79: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   82: astore #11
    //   84: invokestatic H : ()Ljava/lang/String;
    //   87: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   90: ifne -> 101
    //   93: invokestatic H : ()Ljava/lang/String;
    //   96: astore #9
    //   98: goto -> 105
    //   101: ldc ''
    //   103: astore #9
    //   105: invokestatic J : ()Ljava/lang/String;
    //   108: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   111: ifne -> 521
    //   114: invokestatic J : ()Ljava/lang/String;
    //   117: astore #8
    //   119: aload #8
    //   121: invokestatic e : (Ljava/lang/String;)Z
    //   124: ifne -> 518
    //   127: aload #8
    //   129: ldc '-'
    //   131: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   134: arraylength
    //   135: iconst_2
    //   136: if_icmpne -> 518
    //   139: aload #8
    //   141: ldc '-'
    //   143: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   146: astore #8
    //   148: aload #8
    //   150: iconst_0
    //   151: aaload
    //   152: invokestatic parseInt : (Ljava/lang/String;)I
    //   155: istore #4
    //   157: aload #8
    //   159: iconst_1
    //   160: aaload
    //   161: invokestatic parseInt : (Ljava/lang/String;)I
    //   164: istore #5
    //   166: iload #4
    //   168: aload #11
    //   170: arraylength
    //   171: if_icmpge -> 185
    //   174: iload #5
    //   176: istore_3
    //   177: iload #5
    //   179: aload #11
    //   181: arraylength
    //   182: if_icmplt -> 233
    //   185: aload #11
    //   187: arraylength
    //   188: iconst_1
    //   189: isub
    //   190: istore_3
    //   191: new java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial <init> : ()V
    //   198: astore #8
    //   200: aload #8
    //   202: iconst_0
    //   203: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload #8
    //   209: ldc '-'
    //   211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload #8
    //   217: iload_3
    //   218: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload #8
    //   224: invokevirtual toString : ()Ljava/lang/String;
    //   227: invokestatic i : (Ljava/lang/String;)V
    //   230: iconst_0
    //   231: istore #4
    //   233: aload #11
    //   235: iload #4
    //   237: aaload
    //   238: astore #8
    //   240: aload #11
    //   242: iload_3
    //   243: aaload
    //   244: astore #12
    //   246: aload_0
    //   247: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   250: ldc 2131759104
    //   252: invokevirtual getString : (I)Ljava/lang/String;
    //   255: astore #13
    //   257: aload #8
    //   259: aload #13
    //   261: invokevirtual equals : (Ljava/lang/Object;)Z
    //   264: ifeq -> 332
    //   267: aload #12
    //   269: aload #13
    //   271: invokevirtual equals : (Ljava/lang/Object;)Z
    //   274: ifeq -> 332
    //   277: new java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial <init> : ()V
    //   284: astore #8
    //   286: aload #8
    //   288: aload #11
    //   290: aload #11
    //   292: arraylength
    //   293: iconst_2
    //   294: isub
    //   295: aaload
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload #8
    //   302: ldc '-'
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload #8
    //   310: aload #11
    //   312: aload #11
    //   314: arraylength
    //   315: iconst_2
    //   316: isub
    //   317: aaload
    //   318: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload #8
    //   324: invokevirtual toString : ()Ljava/lang/String;
    //   327: astore #8
    //   329: goto -> 525
    //   332: aload #8
    //   334: aload #13
    //   336: invokevirtual equals : (Ljava/lang/Object;)Z
    //   339: ifeq -> 377
    //   342: new java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial <init> : ()V
    //   349: astore #8
    //   351: aload #8
    //   353: ldc '0-'
    //   355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload #8
    //   361: aload #12
    //   363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload #8
    //   369: invokevirtual toString : ()Ljava/lang/String;
    //   372: astore #8
    //   374: goto -> 525
    //   377: aload #12
    //   379: aload #13
    //   381: invokevirtual equals : (Ljava/lang/Object;)Z
    //   384: ifeq -> 422
    //   387: new java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial <init> : ()V
    //   394: astore #11
    //   396: aload #11
    //   398: aload #8
    //   400: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload #11
    //   406: ldc '-300'
    //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload #11
    //   414: invokevirtual toString : ()Ljava/lang/String;
    //   417: astore #8
    //   419: goto -> 525
    //   422: aload #8
    //   424: aload #12
    //   426: invokevirtual equals : (Ljava/lang/Object;)Z
    //   429: ifeq -> 475
    //   432: new java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial <init> : ()V
    //   439: astore #11
    //   441: aload #11
    //   443: aload #8
    //   445: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload #11
    //   451: ldc '-'
    //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload #11
    //   459: aload #12
    //   461: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload #11
    //   467: invokevirtual toString : ()Ljava/lang/String;
    //   470: astore #8
    //   472: goto -> 525
    //   475: new java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial <init> : ()V
    //   482: astore #11
    //   484: aload #11
    //   486: aload #8
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload #11
    //   494: ldc '-'
    //   496: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload #11
    //   502: aload #12
    //   504: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload #11
    //   510: invokevirtual toString : ()Ljava/lang/String;
    //   513: astore #8
    //   515: goto -> 525
    //   518: goto -> 525
    //   521: ldc ''
    //   523: astore #8
    //   525: iload_2
    //   526: ifeq -> 537
    //   529: invokestatic L : ()Ljava/lang/String;
    //   532: astore #11
    //   534: goto -> 542
    //   537: invokestatic K : ()Ljava/lang/String;
    //   540: astore #11
    //   542: aload #11
    //   544: invokestatic e : (Ljava/lang/String;)Z
    //   547: ifne -> 1387
    //   550: aload #11
    //   552: ldc '-'
    //   554: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   557: arraylength
    //   558: iconst_2
    //   559: if_icmpne -> 1387
    //   562: aload #11
    //   564: ldc '-'
    //   566: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   569: astore #11
    //   571: aload #11
    //   573: iconst_0
    //   574: aaload
    //   575: invokestatic parseInt : (Ljava/lang/String;)I
    //   578: istore_3
    //   579: aload #11
    //   581: iconst_1
    //   582: aaload
    //   583: invokestatic parseInt : (Ljava/lang/String;)I
    //   586: istore #4
    //   588: iload_3
    //   589: aload #7
    //   591: arraylength
    //   592: iconst_1
    //   593: isub
    //   594: if_icmpgt -> 626
    //   597: iload #4
    //   599: aload #7
    //   601: arraylength
    //   602: iconst_1
    //   603: isub
    //   604: if_icmple -> 610
    //   607: goto -> 626
    //   610: aload #7
    //   612: iload_3
    //   613: aaload
    //   614: astore #12
    //   616: aload #7
    //   618: iload #4
    //   620: aaload
    //   621: astore #11
    //   623: goto -> 721
    //   626: aload #7
    //   628: iconst_0
    //   629: aaload
    //   630: astore #12
    //   632: aload #7
    //   634: aload #7
    //   636: arraylength
    //   637: iconst_1
    //   638: isub
    //   639: aaload
    //   640: astore #11
    //   642: iload_2
    //   643: ifeq -> 685
    //   646: new java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial <init> : ()V
    //   653: astore #13
    //   655: aload #13
    //   657: ldc '0-'
    //   659: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload #13
    //   665: aload #7
    //   667: arraylength
    //   668: iconst_1
    //   669: isub
    //   670: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload #13
    //   676: invokevirtual toString : ()Ljava/lang/String;
    //   679: invokestatic k : (Ljava/lang/String;)V
    //   682: goto -> 721
    //   685: new java/lang/StringBuilder
    //   688: dup
    //   689: invokespecial <init> : ()V
    //   692: astore #13
    //   694: aload #13
    //   696: ldc '0-'
    //   698: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload #13
    //   704: aload #7
    //   706: arraylength
    //   707: iconst_1
    //   708: isub
    //   709: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload #13
    //   715: invokevirtual toString : ()Ljava/lang/String;
    //   718: invokestatic j : (Ljava/lang/String;)V
    //   721: aload_0
    //   722: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   725: ldc 2131759104
    //   727: invokevirtual getString : (I)Ljava/lang/String;
    //   730: astore #13
    //   732: iload_3
    //   733: ifne -> 841
    //   736: iload #4
    //   738: ifne -> 841
    //   741: iload_2
    //   742: ifeq -> 794
    //   745: aload #7
    //   747: iconst_1
    //   748: aaload
    //   749: invokestatic c : (Ljava/lang/String;)I
    //   752: istore_3
    //   753: new java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial <init> : ()V
    //   760: astore #7
    //   762: aload #7
    //   764: iload_3
    //   765: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload #7
    //   771: ldc '-'
    //   773: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: aload #7
    //   779: iload_3
    //   780: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload #7
    //   786: invokevirtual toString : ()Ljava/lang/String;
    //   789: astore #7
    //   791: goto -> 1391
    //   794: new java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial <init> : ()V
    //   801: astore #11
    //   803: aload #11
    //   805: aload #7
    //   807: iconst_1
    //   808: aaload
    //   809: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload #11
    //   815: ldc '-'
    //   817: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload #11
    //   823: aload #7
    //   825: iconst_1
    //   826: aaload
    //   827: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload #11
    //   833: invokevirtual toString : ()Ljava/lang/String;
    //   836: astore #7
    //   838: goto -> 1391
    //   841: iload_3
    //   842: aload #7
    //   844: arraylength
    //   845: iconst_1
    //   846: isub
    //   847: if_icmpne -> 972
    //   850: iload #4
    //   852: aload #7
    //   854: arraylength
    //   855: iconst_1
    //   856: isub
    //   857: if_icmpne -> 972
    //   860: iload_2
    //   861: ifeq -> 917
    //   864: aload #7
    //   866: aload #7
    //   868: arraylength
    //   869: iconst_2
    //   870: isub
    //   871: aaload
    //   872: invokestatic c : (Ljava/lang/String;)I
    //   875: istore_3
    //   876: new java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial <init> : ()V
    //   883: astore #7
    //   885: aload #7
    //   887: iload_3
    //   888: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: aload #7
    //   894: ldc '-'
    //   896: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload #7
    //   902: iload_3
    //   903: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload #7
    //   909: invokevirtual toString : ()Ljava/lang/String;
    //   912: astore #7
    //   914: goto -> 1391
    //   917: new java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial <init> : ()V
    //   924: astore #11
    //   926: aload #11
    //   928: aload #7
    //   930: aload #7
    //   932: arraylength
    //   933: iconst_2
    //   934: isub
    //   935: aaload
    //   936: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload #11
    //   942: ldc '-'
    //   944: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: aload #11
    //   950: aload #7
    //   952: aload #7
    //   954: arraylength
    //   955: iconst_2
    //   956: isub
    //   957: aaload
    //   958: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: aload #11
    //   964: invokevirtual toString : ()Ljava/lang/String;
    //   967: astore #7
    //   969: goto -> 1391
    //   972: aload #12
    //   974: aload #13
    //   976: invokevirtual equals : (Ljava/lang/Object;)Z
    //   979: ifeq -> 995
    //   982: aload #11
    //   984: aload #13
    //   986: invokevirtual equals : (Ljava/lang/Object;)Z
    //   989: ifeq -> 995
    //   992: goto -> 1387
    //   995: aload #12
    //   997: aload #13
    //   999: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1002: ifeq -> 1084
    //   1005: iload_2
    //   1006: ifeq -> 1049
    //   1009: aload #11
    //   1011: invokestatic c : (Ljava/lang/String;)I
    //   1014: istore_3
    //   1015: new java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial <init> : ()V
    //   1022: astore #7
    //   1024: aload #7
    //   1026: ldc '0-'
    //   1028: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: aload #7
    //   1034: iload_3
    //   1035: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload #7
    //   1041: invokevirtual toString : ()Ljava/lang/String;
    //   1044: astore #7
    //   1046: goto -> 1391
    //   1049: new java/lang/StringBuilder
    //   1052: dup
    //   1053: invokespecial <init> : ()V
    //   1056: astore #7
    //   1058: aload #7
    //   1060: ldc '0-'
    //   1062: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: aload #7
    //   1068: aload #11
    //   1070: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload #7
    //   1076: invokevirtual toString : ()Ljava/lang/String;
    //   1079: astore #7
    //   1081: goto -> 1391
    //   1084: aload #11
    //   1086: aload #13
    //   1088: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1091: ifeq -> 1173
    //   1094: iload_2
    //   1095: ifeq -> 1138
    //   1098: aload #12
    //   1100: invokestatic c : (Ljava/lang/String;)I
    //   1103: istore_3
    //   1104: new java/lang/StringBuilder
    //   1107: dup
    //   1108: invokespecial <init> : ()V
    //   1111: astore #7
    //   1113: aload #7
    //   1115: iload_3
    //   1116: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload #7
    //   1122: ldc '-500'
    //   1124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload #7
    //   1130: invokevirtual toString : ()Ljava/lang/String;
    //   1133: astore #7
    //   1135: goto -> 1391
    //   1138: new java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial <init> : ()V
    //   1145: astore #7
    //   1147: aload #7
    //   1149: aload #12
    //   1151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload #7
    //   1157: ldc '-500'
    //   1159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: pop
    //   1163: aload #7
    //   1165: invokevirtual toString : ()Ljava/lang/String;
    //   1168: astore #7
    //   1170: goto -> 1391
    //   1173: aload #12
    //   1175: aload #11
    //   1177: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1180: ifeq -> 1285
    //   1183: iload_2
    //   1184: ifeq -> 1242
    //   1187: aload #12
    //   1189: invokestatic c : (Ljava/lang/String;)I
    //   1192: istore_3
    //   1193: aload #11
    //   1195: invokestatic c : (Ljava/lang/String;)I
    //   1198: istore #4
    //   1200: new java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial <init> : ()V
    //   1207: astore #7
    //   1209: aload #7
    //   1211: iload_3
    //   1212: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: aload #7
    //   1218: ldc '-'
    //   1220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: aload #7
    //   1226: iload #4
    //   1228: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload #7
    //   1234: invokevirtual toString : ()Ljava/lang/String;
    //   1237: astore #7
    //   1239: goto -> 1391
    //   1242: new java/lang/StringBuilder
    //   1245: dup
    //   1246: invokespecial <init> : ()V
    //   1249: astore #7
    //   1251: aload #7
    //   1253: aload #12
    //   1255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: pop
    //   1259: aload #7
    //   1261: ldc '-'
    //   1263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: aload #7
    //   1269: aload #11
    //   1271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: pop
    //   1275: aload #7
    //   1277: invokevirtual toString : ()Ljava/lang/String;
    //   1280: astore #7
    //   1282: goto -> 1391
    //   1285: iload_2
    //   1286: ifeq -> 1344
    //   1289: aload #12
    //   1291: invokestatic c : (Ljava/lang/String;)I
    //   1294: istore_3
    //   1295: aload #11
    //   1297: invokestatic c : (Ljava/lang/String;)I
    //   1300: istore #4
    //   1302: new java/lang/StringBuilder
    //   1305: dup
    //   1306: invokespecial <init> : ()V
    //   1309: astore #7
    //   1311: aload #7
    //   1313: iload_3
    //   1314: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1317: pop
    //   1318: aload #7
    //   1320: ldc '-'
    //   1322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload #7
    //   1328: iload #4
    //   1330: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload #7
    //   1336: invokevirtual toString : ()Ljava/lang/String;
    //   1339: astore #7
    //   1341: goto -> 1391
    //   1344: new java/lang/StringBuilder
    //   1347: dup
    //   1348: invokespecial <init> : ()V
    //   1351: astore #7
    //   1353: aload #7
    //   1355: aload #12
    //   1357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload #7
    //   1363: ldc '-'
    //   1365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: aload #7
    //   1371: aload #11
    //   1373: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: pop
    //   1377: aload #7
    //   1379: invokevirtual toString : ()Ljava/lang/String;
    //   1382: astore #7
    //   1384: goto -> 1391
    //   1387: ldc ''
    //   1389: astore #7
    //   1391: iload_2
    //   1392: ifeq -> 1403
    //   1395: invokestatic N : ()Ljava/lang/String;
    //   1398: astore #11
    //   1400: goto -> 1408
    //   1403: invokestatic M : ()Ljava/lang/String;
    //   1406: astore #11
    //   1408: aload #11
    //   1410: invokestatic e : (Ljava/lang/String;)Z
    //   1413: ifne -> 2086
    //   1416: aload #11
    //   1418: ldc '-'
    //   1420: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1423: arraylength
    //   1424: iconst_2
    //   1425: if_icmpne -> 2086
    //   1428: aload #11
    //   1430: ldc '-'
    //   1432: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1435: astore #11
    //   1437: aload #11
    //   1439: iconst_0
    //   1440: aaload
    //   1441: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   1444: invokevirtual intValue : ()I
    //   1447: istore_3
    //   1448: aload #11
    //   1450: iconst_1
    //   1451: aaload
    //   1452: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   1455: invokevirtual intValue : ()I
    //   1458: istore #4
    //   1460: iload_3
    //   1461: aload #10
    //   1463: arraylength
    //   1464: iconst_1
    //   1465: isub
    //   1466: if_icmpgt -> 1498
    //   1469: iload #4
    //   1471: aload #10
    //   1473: arraylength
    //   1474: iconst_1
    //   1475: isub
    //   1476: if_icmple -> 1482
    //   1479: goto -> 1498
    //   1482: aload #10
    //   1484: iload_3
    //   1485: aaload
    //   1486: astore #11
    //   1488: aload #10
    //   1490: iload #4
    //   1492: aaload
    //   1493: astore #12
    //   1495: goto -> 1593
    //   1498: aload #10
    //   1500: iconst_0
    //   1501: aaload
    //   1502: astore #11
    //   1504: aload #10
    //   1506: aload #10
    //   1508: arraylength
    //   1509: iconst_1
    //   1510: isub
    //   1511: aaload
    //   1512: astore #12
    //   1514: iload_2
    //   1515: ifeq -> 1557
    //   1518: new java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial <init> : ()V
    //   1525: astore #13
    //   1527: aload #13
    //   1529: ldc '0-'
    //   1531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: pop
    //   1535: aload #13
    //   1537: aload #10
    //   1539: arraylength
    //   1540: iconst_1
    //   1541: isub
    //   1542: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1545: pop
    //   1546: aload #13
    //   1548: invokevirtual toString : ()Ljava/lang/String;
    //   1551: invokestatic m : (Ljava/lang/String;)V
    //   1554: goto -> 1593
    //   1557: new java/lang/StringBuilder
    //   1560: dup
    //   1561: invokespecial <init> : ()V
    //   1564: astore #13
    //   1566: aload #13
    //   1568: ldc '0-'
    //   1570: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: pop
    //   1574: aload #13
    //   1576: aload #10
    //   1578: arraylength
    //   1579: iconst_1
    //   1580: isub
    //   1581: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1584: pop
    //   1585: aload #13
    //   1587: invokevirtual toString : ()Ljava/lang/String;
    //   1590: invokestatic l : (Ljava/lang/String;)V
    //   1593: aload_0
    //   1594: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1597: ldc 2131759104
    //   1599: invokevirtual getString : (I)Ljava/lang/String;
    //   1602: astore_0
    //   1603: iload_3
    //   1604: ifne -> 1655
    //   1607: iload #4
    //   1609: ifne -> 1655
    //   1612: aload #10
    //   1614: iconst_1
    //   1615: aaload
    //   1616: invokestatic d : (Ljava/lang/String;)I
    //   1619: istore_2
    //   1620: new java/lang/StringBuilder
    //   1623: dup
    //   1624: invokespecial <init> : ()V
    //   1627: astore_0
    //   1628: aload_0
    //   1629: iload_2
    //   1630: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1633: pop
    //   1634: aload_0
    //   1635: ldc '-'
    //   1637: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: pop
    //   1641: aload_0
    //   1642: iload_2
    //   1643: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1646: pop
    //   1647: aload_0
    //   1648: invokevirtual toString : ()Ljava/lang/String;
    //   1651: astore_0
    //   1652: goto -> 2089
    //   1655: iload_3
    //   1656: aload #10
    //   1658: arraylength
    //   1659: iconst_1
    //   1660: isub
    //   1661: if_icmpne -> 1723
    //   1664: iload #4
    //   1666: aload #10
    //   1668: arraylength
    //   1669: iconst_1
    //   1670: isub
    //   1671: if_icmpne -> 1723
    //   1674: new java/lang/StringBuilder
    //   1677: dup
    //   1678: invokespecial <init> : ()V
    //   1681: astore_0
    //   1682: aload_0
    //   1683: aload #10
    //   1685: aload #10
    //   1687: arraylength
    //   1688: iconst_2
    //   1689: isub
    //   1690: aaload
    //   1691: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: pop
    //   1695: aload_0
    //   1696: ldc '-'
    //   1698: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: pop
    //   1702: aload_0
    //   1703: aload #10
    //   1705: aload #10
    //   1707: arraylength
    //   1708: iconst_2
    //   1709: isub
    //   1710: aaload
    //   1711: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: pop
    //   1715: aload_0
    //   1716: invokevirtual toString : ()Ljava/lang/String;
    //   1719: astore_0
    //   1720: goto -> 2089
    //   1723: aload #11
    //   1725: aload_0
    //   1726: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1729: ifeq -> 1744
    //   1732: aload #12
    //   1734: aload_0
    //   1735: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1738: ifeq -> 1744
    //   1741: goto -> 2086
    //   1744: aload #11
    //   1746: aload_0
    //   1747: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1750: ifeq -> 1822
    //   1753: iload_2
    //   1754: ifeq -> 1792
    //   1757: aload #12
    //   1759: invokestatic d : (Ljava/lang/String;)I
    //   1762: istore_2
    //   1763: new java/lang/StringBuilder
    //   1766: dup
    //   1767: invokespecial <init> : ()V
    //   1770: astore_0
    //   1771: aload_0
    //   1772: ldc '0-'
    //   1774: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: pop
    //   1778: aload_0
    //   1779: iload_2
    //   1780: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1783: pop
    //   1784: aload_0
    //   1785: invokevirtual toString : ()Ljava/lang/String;
    //   1788: astore_0
    //   1789: goto -> 2089
    //   1792: new java/lang/StringBuilder
    //   1795: dup
    //   1796: invokespecial <init> : ()V
    //   1799: astore_0
    //   1800: aload_0
    //   1801: ldc '0-'
    //   1803: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: pop
    //   1807: aload_0
    //   1808: aload #12
    //   1810: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: pop
    //   1814: aload_0
    //   1815: invokevirtual toString : ()Ljava/lang/String;
    //   1818: astore_0
    //   1819: goto -> 2089
    //   1822: aload #12
    //   1824: aload_0
    //   1825: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1828: ifeq -> 1900
    //   1831: iload_2
    //   1832: ifeq -> 1870
    //   1835: aload #11
    //   1837: invokestatic d : (Ljava/lang/String;)I
    //   1840: istore_2
    //   1841: new java/lang/StringBuilder
    //   1844: dup
    //   1845: invokespecial <init> : ()V
    //   1848: astore_0
    //   1849: aload_0
    //   1850: iload_2
    //   1851: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1854: pop
    //   1855: aload_0
    //   1856: ldc '-1000'
    //   1858: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: pop
    //   1862: aload_0
    //   1863: invokevirtual toString : ()Ljava/lang/String;
    //   1866: astore_0
    //   1867: goto -> 2089
    //   1870: new java/lang/StringBuilder
    //   1873: dup
    //   1874: invokespecial <init> : ()V
    //   1877: astore_0
    //   1878: aload_0
    //   1879: aload #11
    //   1881: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: pop
    //   1885: aload_0
    //   1886: ldc '-1000'
    //   1888: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1891: pop
    //   1892: aload_0
    //   1893: invokevirtual toString : ()Ljava/lang/String;
    //   1896: astore_0
    //   1897: goto -> 2089
    //   1900: aload #11
    //   1902: aload #12
    //   1904: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1907: ifeq -> 1998
    //   1910: iload_2
    //   1911: ifeq -> 1961
    //   1914: aload #11
    //   1916: invokestatic d : (Ljava/lang/String;)I
    //   1919: istore_2
    //   1920: aload #12
    //   1922: invokestatic d : (Ljava/lang/String;)I
    //   1925: istore_3
    //   1926: new java/lang/StringBuilder
    //   1929: dup
    //   1930: invokespecial <init> : ()V
    //   1933: astore_0
    //   1934: aload_0
    //   1935: iload_2
    //   1936: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1939: pop
    //   1940: aload_0
    //   1941: ldc '-'
    //   1943: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: pop
    //   1947: aload_0
    //   1948: iload_3
    //   1949: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1952: pop
    //   1953: aload_0
    //   1954: invokevirtual toString : ()Ljava/lang/String;
    //   1957: astore_0
    //   1958: goto -> 2089
    //   1961: new java/lang/StringBuilder
    //   1964: dup
    //   1965: invokespecial <init> : ()V
    //   1968: astore_0
    //   1969: aload_0
    //   1970: aload #11
    //   1972: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: pop
    //   1976: aload_0
    //   1977: ldc '-'
    //   1979: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: pop
    //   1983: aload_0
    //   1984: aload #12
    //   1986: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1989: pop
    //   1990: aload_0
    //   1991: invokevirtual toString : ()Ljava/lang/String;
    //   1994: astore_0
    //   1995: goto -> 2089
    //   1998: iload_2
    //   1999: ifeq -> 2049
    //   2002: aload #11
    //   2004: invokestatic d : (Ljava/lang/String;)I
    //   2007: istore_2
    //   2008: aload #12
    //   2010: invokestatic d : (Ljava/lang/String;)I
    //   2013: istore_3
    //   2014: new java/lang/StringBuilder
    //   2017: dup
    //   2018: invokespecial <init> : ()V
    //   2021: astore_0
    //   2022: aload_0
    //   2023: iload_2
    //   2024: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2027: pop
    //   2028: aload_0
    //   2029: ldc '-'
    //   2031: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: pop
    //   2035: aload_0
    //   2036: iload_3
    //   2037: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2040: pop
    //   2041: aload_0
    //   2042: invokevirtual toString : ()Ljava/lang/String;
    //   2045: astore_0
    //   2046: goto -> 2089
    //   2049: new java/lang/StringBuilder
    //   2052: dup
    //   2053: invokespecial <init> : ()V
    //   2056: astore_0
    //   2057: aload_0
    //   2058: aload #11
    //   2060: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2063: pop
    //   2064: aload_0
    //   2065: ldc '-'
    //   2067: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2070: pop
    //   2071: aload_0
    //   2072: aload #12
    //   2074: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2077: pop
    //   2078: aload_0
    //   2079: invokevirtual toString : ()Ljava/lang/String;
    //   2082: astore_0
    //   2083: goto -> 2089
    //   2086: ldc ''
    //   2088: astore_0
    //   2089: invokestatic O : ()Z
    //   2092: istore #6
    //   2094: ldc '1'
    //   2096: astore #12
    //   2098: iload #6
    //   2100: ifeq -> 2110
    //   2103: ldc '1'
    //   2105: astore #10
    //   2107: goto -> 2114
    //   2110: ldc ''
    //   2112: astore #10
    //   2114: invokestatic P : ()Z
    //   2117: ifeq -> 2127
    //   2120: ldc '1'
    //   2122: astore #11
    //   2124: goto -> 2131
    //   2127: ldc ''
    //   2129: astore #11
    //   2131: invokestatic Q : ()Z
    //   2134: ifeq -> 2140
    //   2137: goto -> 2144
    //   2140: ldc ''
    //   2142: astore #12
    //   2144: invokestatic T : ()Ljava/lang/String;
    //   2147: astore #13
    //   2149: invokestatic R : ()Ljava/lang/String;
    //   2152: astore #17
    //   2154: invokestatic W : ()Z
    //   2157: istore #6
    //   2159: invokestatic X : ()Ljava/lang/String;
    //   2162: astore #18
    //   2164: invokestatic Y : ()Ljava/lang/String;
    //   2167: astore #19
    //   2169: aload #8
    //   2171: astore #14
    //   2173: aload #9
    //   2175: astore #16
    //   2177: goto -> 2263
    //   2180: iconst_0
    //   2181: istore #6
    //   2183: ldc ''
    //   2185: astore #15
    //   2187: aload #15
    //   2189: astore_0
    //   2190: aload_0
    //   2191: astore #7
    //   2193: aload #7
    //   2195: astore #8
    //   2197: aload #8
    //   2199: astore #9
    //   2201: aload #9
    //   2203: astore #10
    //   2205: aload #10
    //   2207: astore #11
    //   2209: aload #11
    //   2211: astore #12
    //   2213: aload #12
    //   2215: astore #13
    //   2217: aload #13
    //   2219: astore #14
    //   2221: aload #14
    //   2223: astore #19
    //   2225: aload #14
    //   2227: astore #18
    //   2229: aload #13
    //   2231: astore #17
    //   2233: aload #12
    //   2235: astore #16
    //   2237: aload #11
    //   2239: astore #14
    //   2241: aload #10
    //   2243: astore #13
    //   2245: aload #9
    //   2247: astore #11
    //   2249: aload #8
    //   2251: astore #12
    //   2253: aload #7
    //   2255: astore #10
    //   2257: aload_0
    //   2258: astore #7
    //   2260: aload #15
    //   2262: astore_0
    //   2263: aload_1
    //   2264: getfield longitude : Ljava/lang/String;
    //   2267: invokestatic e : (Ljava/lang/String;)Z
    //   2270: ifeq -> 2280
    //   2273: aload_1
    //   2274: invokestatic s : ()Ljava/lang/String;
    //   2277: putfield longitude : Ljava/lang/String;
    //   2280: aload_1
    //   2281: getfield latitude : Ljava/lang/String;
    //   2284: invokestatic e : (Ljava/lang/String;)Z
    //   2287: ifeq -> 2297
    //   2290: aload_1
    //   2291: invokestatic t : ()Ljava/lang/String;
    //   2294: putfield latitude : Ljava/lang/String;
    //   2297: aload_1
    //   2298: aload #16
    //   2300: putfield role : Ljava/lang/String;
    //   2303: aload_1
    //   2304: aload #14
    //   2306: putfield age : Ljava/lang/String;
    //   2309: aload_1
    //   2310: aload #7
    //   2312: putfield height : Ljava/lang/String;
    //   2315: aload_1
    //   2316: aload_0
    //   2317: putfield weight : Ljava/lang/String;
    //   2320: aload_1
    //   2321: aload #10
    //   2323: putfield has_avatar : Ljava/lang/String;
    //   2326: aload_1
    //   2327: aload #11
    //   2329: putfield ai_photo : Ljava/lang/String;
    //   2332: aload_1
    //   2333: ldc ''
    //   2335: putfield online : Ljava/lang/String;
    //   2338: aload_1
    //   2339: aload #12
    //   2341: putfield verified : Ljava/lang/String;
    //   2344: aload_1
    //   2345: aload #13
    //   2347: putfield tagsid : Ljava/lang/String;
    //   2350: aload_1
    //   2351: aload #17
    //   2353: putfield mate : Ljava/lang/String;
    //   2356: aload_1
    //   2357: ldc ''
    //   2359: putfield nickName : Ljava/lang/String;
    //   2362: aload_1
    //   2363: iload #6
    //   2365: putfield if_vip_only : Z
    //   2368: aload_1
    //   2369: aload #18
    //   2371: putfield geo_reach : Ljava/lang/String;
    //   2374: aload_1
    //   2375: aload #19
    //   2377: putfield time_span : Ljava/lang/String;
    //   2380: aload_1
    //   2381: areturn
  }
  
  public static String a(FilterEntity paramFilterEntity) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    Gson gson = AppInfo.f();
    if (paramFilterEntity.if_vip_only)
      arrayMap.put("is_vip", "1"); 
    if (!StringUtils.e(paramFilterEntity.role))
      arrayMap.put("role", paramFilterEntity.role); 
    if (!StringUtils.e(paramFilterEntity.age))
      arrayMap.put("age", paramFilterEntity.age); 
    if (!StringUtils.e(paramFilterEntity.height))
      arrayMap.put("height", paramFilterEntity.height); 
    if (!StringUtils.e(paramFilterEntity.weight))
      arrayMap.put("weight", paramFilterEntity.weight); 
    if (!StringUtils.e(paramFilterEntity.has_avatar))
      arrayMap.put("has_avatar", paramFilterEntity.has_avatar); 
    if (!StringUtils.e(paramFilterEntity.online))
      arrayMap.put("online", paramFilterEntity.online); 
    if (!StringUtils.e(paramFilterEntity.verified))
      arrayMap.put("vbadge", "4"); 
    if (!StringUtils.e(paramFilterEntity.nickName))
      arrayMap.put("name", paramFilterEntity.nickName); 
    if (!StringUtils.e(paramFilterEntity.tagsid))
      arrayMap.put("tags", paramFilterEntity.tagsid); 
    if (!StringUtils.e(paramFilterEntity.mate) && !paramFilterEntity.mate.contains("0") && !paramFilterEntity.mate.contains("-1"))
      arrayMap.put("mate", paramFilterEntity.mate); 
    if (BluedConfig.b().f() && !StringUtils.e(paramFilterEntity.ai_photo))
      arrayMap.put("is_human_face", paramFilterEntity.ai_photo); 
    if (!StringUtils.e(paramFilterEntity.geo_reach))
      arrayMap.put("geo_reach", paramFilterEntity.geo_reach); 
    if (!StringUtils.e(paramFilterEntity.time_span))
      arrayMap.put("time_span", paramFilterEntity.time_span); 
    if (UserHttpUtils.d && "recommend".equals(paramFilterEntity.sort_by)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(UserHttpUtils.a);
      stringBuilder.append("");
      arrayMap.put("repeat", stringBuilder.toString());
      UserHttpUtils.a++;
    } 
    return gson.toJson(arrayMap);
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, FilterEntity paramFilterEntity, String paramString, IRequestHost paramIRequestHost) {
    if (UserInfo.a().i() != null && (BluedConfig.b().j()).is_filter_vip == 0) {
      BluedPreferences.e(false);
      BluedPreferences.s("");
      BluedPreferences.t("");
      BluedPreferences.d(false);
    } 
    b(paramContext, paramBluedUIHttpResponse, a(paramContext, paramFilterEntity), paramString, paramIRequestHost);
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/floats");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/moment?type=conf&c=");
    stringBuilder.append(paramString);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, String paramString1, String paramString2) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/joy");
    String str2 = stringBuilder.toString();
    paramString1 = str2;
    if (!StringUtils.e(paramString2)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append("?filter=");
      stringBuilder1.append(paramString2);
      str1 = stringBuilder1.toString();
    } 
    HttpManager.a(str1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, List<NearbyModule> paramList) {
    if (paramList != null && paramList.size() > 0) {
      int i = 0;
      String str;
      for (str = ""; i < paramList.size(); str = str1) {
        String str1 = str;
        if (((NearbyModule)paramList.get(i)).is_show == 1) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str);
          if (StringUtils.e(str)) {
            str = "";
          } else {
            str = ",";
          } 
          stringBuilder1.append(str);
          stringBuilder1.append(((NearbyModule)paramList.get(i)).cid);
          str1 = stringBuilder1.toString();
        } 
        i++;
      } 
      Map<String, String> map = BluedHttpTools.a();
      map.put("custom", str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(BluedHttpUrl.n());
      stringBuilder.append("/users/custom");
      HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
    } 
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/custom?from=");
    stringBuilder.append(paramString);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, boolean paramBoolean) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/confirm_mobile");
    String str2 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    map.put("is_use", str1);
    HttpManager.b(str2, (HttpResponseHandler)paramBluedUIHttpResponse).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, FilterEntity paramFilterEntity, String paramString, IRequestHost paramIRequestHost) {
    String str1;
    if (BluedPreferences.G() != UserHttpUtils.b && !BluedPreferences.G() && "recommend".equals(paramFilterEntity.sort_by)) {
      UserHttpUtils.d = true;
      UserHttpUtils.a = 1;
    } 
    FilterEntity filterEntity = paramFilterEntity;
    if (UserHttpUtils.d) {
      filterEntity = paramFilterEntity;
      if ("recommend".equals(paramFilterEntity.sort_by)) {
        filterEntity = paramFilterEntity;
        if (!BluedPreferences.G()) {
          filterEntity = paramFilterEntity;
          if (UserHttpUtils.a <= 5)
            filterEntity = UserHttpUtils.c; 
        } 
      } 
    } 
    Map<String, String> map = BluedHttpTools.a();
    if (!StringUtils.e(filterEntity.f))
      map.put("f", filterEntity.f); 
    map.put("sort_by", filterEntity.sort_by);
    map.put("latitude", filterEntity.latitude);
    map.put("longitude", filterEntity.longitude);
    MapToken mapToken = new MapToken();
    mapToken.lat = filterEntity.latitude;
    mapToken.lon = filterEntity.longitude;
    mapToken.time = System.currentTimeMillis();
    String str2 = AppInfo.f().toJson(mapToken);
    Logger.a("maptoken", str2);
    try {
      map.put("extra_info", AesCrypto.b(str2));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    map.put("source", filterEntity.source);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(filterEntity.cid);
    stringBuilder2.append("");
    map.put("cid", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(filterEntity.scroll_type);
    stringBuilder2.append("");
    map.put("scroll_type", stringBuilder2.toString());
    if (filterEntity.if_grid) {
      str1 = "grid";
    } else {
      str1 = "list";
    } 
    map.put("from", str1);
    if (filterEntity.column == 3) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(filterEntity.column);
      stringBuilder.append("");
      map.put("column", stringBuilder.toString());
    } 
    map.put("filters", a(filterEntity));
    map.put("start", filterEntity.start);
    map.put("limit", filterEntity.limit);
    map.put("next_min_dist", filterEntity.next_min_dist);
    map.put("next_skip_uid", filterEntity.next_skip_uid);
    if (!StringUtils.e(filterEntity.custom))
      map.put("custom", filterEntity.custom); 
    if (!StringUtils.e(paramString))
      map.put("exclude_id", paramString); 
    if (!StringUtils.e(filterEntity.is_map_ok_click))
      map.put("action", filterEntity.is_map_ok_click); 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/users");
    HttpManager.a(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
    UserHttpUtils.b = BluedPreferences.G();
    if ("recommend".equals(filterEntity.sort_by) && BluedPreferences.G())
      UserHttpUtils.c = filterEntity; 
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/map");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/confirm_mobile");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\NearbyHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */