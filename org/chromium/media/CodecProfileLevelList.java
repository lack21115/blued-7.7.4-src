package org.chromium.media;

import android.media.MediaCodecInfo;
import java.util.ArrayList;
import java.util.List;

final class CodecProfileLevelList {
  final List mList = new ArrayList();
  
  public final boolean addCodecProfileLevel(String paramString, MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'vp9'
    //   3: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   6: istore #6
    //   8: bipush #6
    //   10: istore #4
    //   12: iload #6
    //   14: ifeq -> 24
    //   17: bipush #7
    //   19: istore #5
    //   21: goto -> 72
    //   24: aload_1
    //   25: ldc 'vp8'
    //   27: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   30: ifeq -> 40
    //   33: bipush #6
    //   35: istore #5
    //   37: goto -> 72
    //   40: aload_1
    //   41: ldc 'avc'
    //   43: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   46: ifeq -> 55
    //   49: iconst_1
    //   50: istore #5
    //   52: goto -> 72
    //   55: aload_1
    //   56: ldc 'hevc'
    //   58: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   61: istore #6
    //   63: iload #6
    //   65: ifeq -> 303
    //   68: bipush #8
    //   70: istore #5
    //   72: aload_0
    //   73: getfield mList : Ljava/util/List;
    //   76: astore_1
    //   77: aload_2
    //   78: getfield profile : I
    //   81: istore_3
    //   82: iload #5
    //   84: iconst_1
    //   85: if_icmpeq -> 405
    //   88: iload #5
    //   90: bipush #6
    //   92: if_icmpeq -> 393
    //   95: iload #5
    //   97: bipush #8
    //   99: if_icmpeq -> 346
    //   102: iload_3
    //   103: iconst_4
    //   104: if_icmpeq -> 339
    //   107: iload_3
    //   108: bipush #8
    //   110: if_icmpeq -> 332
    //   113: iload_3
    //   114: sipush #4096
    //   117: if_icmpeq -> 339
    //   120: iload_3
    //   121: sipush #8192
    //   124: if_icmpeq -> 332
    //   127: iload_3
    //   128: tableswitch default -> 315, 1 -> 325, 2 -> 318
    //   152: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   155: dup
    //   156: iconst_0
    //   157: invokespecial <init> : (B)V
    //   160: athrow
    //   161: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   164: dup
    //   165: iconst_0
    //   166: invokespecial <init> : (B)V
    //   169: athrow
    //   170: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   173: dup
    //   174: iconst_0
    //   175: invokespecial <init> : (B)V
    //   178: athrow
    //   179: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   182: dup
    //   183: iconst_0
    //   184: invokespecial <init> : (B)V
    //   187: athrow
    //   188: aload_2
    //   189: getfield level : I
    //   192: istore_3
    //   193: iload #5
    //   195: iconst_1
    //   196: if_icmpeq -> 1063
    //   199: iload #5
    //   201: tableswitch default -> 498, 6 -> 1006, 7 -> 804, 8 -> 501
    //   228: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   231: dup
    //   232: iconst_0
    //   233: invokespecial <init> : (B)V
    //   236: athrow
    //   237: goto -> 240
    //   240: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   243: dup
    //   244: iconst_0
    //   245: invokespecial <init> : (B)V
    //   248: athrow
    //   249: goto -> 252
    //   252: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   255: dup
    //   256: iconst_0
    //   257: invokespecial <init> : (B)V
    //   260: athrow
    //   261: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   264: dup
    //   265: iconst_0
    //   266: invokespecial <init> : (B)V
    //   269: athrow
    //   270: goto -> 294
    //   273: aload_1
    //   274: new org/chromium/media/CodecProfileLevelList$CodecProfileLevelAdapter
    //   277: dup
    //   278: iload #5
    //   280: iload #4
    //   282: iload_3
    //   283: invokespecial <init> : (III)V
    //   286: invokeinterface add : (Ljava/lang/Object;)Z
    //   291: pop
    //   292: iconst_1
    //   293: ireturn
    //   294: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   297: dup
    //   298: iconst_0
    //   299: invokespecial <init> : (B)V
    //   302: athrow
    //   303: new org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   306: dup
    //   307: iconst_0
    //   308: invokespecial <init> : (B)V
    //   311: athrow
    //   312: astore_1
    //   313: iconst_0
    //   314: ireturn
    //   315: goto -> 152
    //   318: bipush #13
    //   320: istore #4
    //   322: goto -> 188
    //   325: bipush #12
    //   327: istore #4
    //   329: goto -> 188
    //   332: bipush #15
    //   334: istore #4
    //   336: goto -> 188
    //   339: bipush #14
    //   341: istore #4
    //   343: goto -> 188
    //   346: iload_3
    //   347: sipush #4096
    //   350: if_icmpeq -> 386
    //   353: iload_3
    //   354: tableswitch default -> 376, 1 -> 379, 2 -> 386
    //   376: goto -> 161
    //   379: bipush #16
    //   381: istore #4
    //   383: goto -> 188
    //   386: bipush #17
    //   388: istore #4
    //   390: goto -> 188
    //   393: iload_3
    //   394: iconst_1
    //   395: if_icmpne -> 170
    //   398: bipush #11
    //   400: istore #4
    //   402: goto -> 188
    //   405: iload_3
    //   406: iconst_4
    //   407: if_icmpeq -> 492
    //   410: iload_3
    //   411: bipush #8
    //   413: if_icmpeq -> 486
    //   416: iload_3
    //   417: bipush #16
    //   419: if_icmpeq -> 480
    //   422: iload_3
    //   423: bipush #32
    //   425: if_icmpeq -> 474
    //   428: iload_3
    //   429: bipush #64
    //   431: if_icmpeq -> 471
    //   434: iload_3
    //   435: tableswitch default -> 456, 1 -> 465, 2 -> 459
    //   456: goto -> 179
    //   459: iconst_1
    //   460: istore #4
    //   462: goto -> 188
    //   465: iconst_0
    //   466: istore #4
    //   468: goto -> 188
    //   471: goto -> 188
    //   474: iconst_5
    //   475: istore #4
    //   477: goto -> 188
    //   480: iconst_4
    //   481: istore #4
    //   483: goto -> 188
    //   486: iconst_3
    //   487: istore #4
    //   489: goto -> 188
    //   492: iconst_2
    //   493: istore #4
    //   495: goto -> 188
    //   498: goto -> 228
    //   501: iload_3
    //   502: lookupswitch default -> 720, 1 -> 801, 2 -> 801, 4 -> 795, 8 -> 795, 16 -> 789, 32 -> 789, 64 -> 783, 128 -> 783, 256 -> 777, 512 -> 777, 1024 -> 771, 2048 -> 771, 4096 -> 765, 8192 -> 765, 16384 -> 758, 32768 -> 758, 65536 -> 751, 131072 -> 751, 262144 -> 744, 524288 -> 744, 1048576 -> 737, 2097152 -> 737, 4194304 -> 730, 8388608 -> 730, 16777216 -> 723, 33554432 -> 723
    //   720: goto -> 237
    //   723: sipush #186
    //   726: istore_3
    //   727: goto -> 273
    //   730: sipush #183
    //   733: istore_3
    //   734: goto -> 273
    //   737: sipush #180
    //   740: istore_3
    //   741: goto -> 273
    //   744: sipush #156
    //   747: istore_3
    //   748: goto -> 273
    //   751: sipush #153
    //   754: istore_3
    //   755: goto -> 273
    //   758: sipush #150
    //   761: istore_3
    //   762: goto -> 273
    //   765: bipush #123
    //   767: istore_3
    //   768: goto -> 273
    //   771: bipush #120
    //   773: istore_3
    //   774: goto -> 273
    //   777: bipush #93
    //   779: istore_3
    //   780: goto -> 273
    //   783: bipush #90
    //   785: istore_3
    //   786: goto -> 273
    //   789: bipush #63
    //   791: istore_3
    //   792: goto -> 273
    //   795: bipush #60
    //   797: istore_3
    //   798: goto -> 273
    //   801: goto -> 1255
    //   804: iload_3
    //   805: lookupswitch default -> 928, 1 -> 1003, 2 -> 1000, 4 -> 994, 8 -> 988, 16 -> 985, 32 -> 979, 64 -> 973, 128 -> 967, 256 -> 961, 512 -> 955, 1024 -> 949, 2048 -> 943, 4096 -> 937, 8192 -> 931
    //   928: goto -> 249
    //   931: bipush #62
    //   933: istore_3
    //   934: goto -> 273
    //   937: bipush #61
    //   939: istore_3
    //   940: goto -> 273
    //   943: bipush #60
    //   945: istore_3
    //   946: goto -> 273
    //   949: bipush #52
    //   951: istore_3
    //   952: goto -> 273
    //   955: bipush #51
    //   957: istore_3
    //   958: goto -> 273
    //   961: bipush #50
    //   963: istore_3
    //   964: goto -> 273
    //   967: bipush #41
    //   969: istore_3
    //   970: goto -> 273
    //   973: bipush #40
    //   975: istore_3
    //   976: goto -> 273
    //   979: bipush #31
    //   981: istore_3
    //   982: goto -> 273
    //   985: goto -> 1255
    //   988: bipush #21
    //   990: istore_3
    //   991: goto -> 273
    //   994: bipush #20
    //   996: istore_3
    //   997: goto -> 273
    //   1000: goto -> 1291
    //   1003: goto -> 1297
    //   1006: iload_3
    //   1007: iconst_4
    //   1008: if_icmpeq -> 1058
    //   1011: iload_3
    //   1012: bipush #8
    //   1014: if_icmpeq -> 1053
    //   1017: iload_3
    //   1018: tableswitch default -> 1040, 1 -> 1048, 2 -> 1043
    //   1040: goto -> 261
    //   1043: iconst_1
    //   1044: istore_3
    //   1045: goto -> 273
    //   1048: iconst_0
    //   1049: istore_3
    //   1050: goto -> 273
    //   1053: iconst_3
    //   1054: istore_3
    //   1055: goto -> 273
    //   1058: iconst_2
    //   1059: istore_3
    //   1060: goto -> 273
    //   1063: iload_3
    //   1064: lookupswitch default -> 1204, 1 -> 1297, 4 -> 1291, 8 -> 1285, 16 -> 1279, 32 -> 1273, 64 -> 1267, 128 -> 1261, 256 -> 1255, 512 -> 1249, 1024 -> 1243, 2048 -> 1237, 4096 -> 1231, 8192 -> 1225, 16384 -> 1219, 32768 -> 1213, 65536 -> 1207
    //   1204: goto -> 270
    //   1207: bipush #52
    //   1209: istore_3
    //   1210: goto -> 273
    //   1213: bipush #51
    //   1215: istore_3
    //   1216: goto -> 273
    //   1219: bipush #50
    //   1221: istore_3
    //   1222: goto -> 273
    //   1225: bipush #42
    //   1227: istore_3
    //   1228: goto -> 273
    //   1231: bipush #41
    //   1233: istore_3
    //   1234: goto -> 273
    //   1237: bipush #40
    //   1239: istore_3
    //   1240: goto -> 273
    //   1243: bipush #32
    //   1245: istore_3
    //   1246: goto -> 273
    //   1249: bipush #31
    //   1251: istore_3
    //   1252: goto -> 273
    //   1255: bipush #30
    //   1257: istore_3
    //   1258: goto -> 273
    //   1261: bipush #22
    //   1263: istore_3
    //   1264: goto -> 273
    //   1267: bipush #21
    //   1269: istore_3
    //   1270: goto -> 273
    //   1273: bipush #20
    //   1275: istore_3
    //   1276: goto -> 273
    //   1279: bipush #13
    //   1281: istore_3
    //   1282: goto -> 273
    //   1285: bipush #12
    //   1287: istore_3
    //   1288: goto -> 273
    //   1291: bipush #11
    //   1293: istore_3
    //   1294: goto -> 273
    //   1297: bipush #10
    //   1299: istore_3
    //   1300: goto -> 273
    //   1303: astore_1
    //   1304: iconst_0
    //   1305: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	8	312	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   24	33	312	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   40	49	312	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   55	63	312	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   72	82	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   152	161	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   161	170	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   170	179	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   179	188	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   188	193	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   228	237	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   240	249	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   252	261	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   261	270	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   273	292	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   294	303	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
    //   303	312	1303	org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\CodecProfileLevelList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */