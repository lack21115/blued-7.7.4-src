package com.squareup.okhttp;

import java.util.concurrent.TimeUnit;

public final class CacheControl {
  public static final CacheControl FORCE_CACHE;
  
  public static final CacheControl FORCE_NETWORK = (new Builder()).noCache().build();
  
  String headerValue;
  
  private final boolean isPrivate;
  
  private final boolean isPublic;
  
  private final int maxAgeSeconds;
  
  private final int maxStaleSeconds;
  
  private final int minFreshSeconds;
  
  private final boolean mustRevalidate;
  
  private final boolean noCache;
  
  private final boolean noStore;
  
  private final boolean noTransform;
  
  private final boolean onlyIfCached;
  
  private final int sMaxAgeSeconds;
  
  static {
    FORCE_CACHE = (new Builder()).onlyIfCached().maxStale(2147483647, TimeUnit.SECONDS).build();
  }
  
  private CacheControl(Builder paramBuilder) {
    this.noCache = paramBuilder.noCache;
    this.noStore = paramBuilder.noStore;
    this.maxAgeSeconds = paramBuilder.maxAgeSeconds;
    this.sMaxAgeSeconds = -1;
    this.isPrivate = false;
    this.isPublic = false;
    this.mustRevalidate = false;
    this.maxStaleSeconds = paramBuilder.maxStaleSeconds;
    this.minFreshSeconds = paramBuilder.minFreshSeconds;
    this.onlyIfCached = paramBuilder.onlyIfCached;
    this.noTransform = paramBuilder.noTransform;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString) {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPrivate = paramBoolean3;
    this.isPublic = paramBoolean4;
    this.mustRevalidate = paramBoolean5;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean6;
    this.noTransform = paramBoolean7;
    this.headerValue = paramString;
  }
  
  private String headerValue() {
    StringBuilder stringBuilder = new StringBuilder();
    if (this.noCache)
      stringBuilder.append("no-cache, "); 
    if (this.noStore)
      stringBuilder.append("no-store, "); 
    if (this.maxAgeSeconds != -1) {
      stringBuilder.append("max-age=");
      stringBuilder.append(this.maxAgeSeconds);
      stringBuilder.append(", ");
    } 
    if (this.sMaxAgeSeconds != -1) {
      stringBuilder.append("s-maxage=");
      stringBuilder.append(this.sMaxAgeSeconds);
      stringBuilder.append(", ");
    } 
    if (this.isPrivate)
      stringBuilder.append("private, "); 
    if (this.isPublic)
      stringBuilder.append("public, "); 
    if (this.mustRevalidate)
      stringBuilder.append("must-revalidate, "); 
    if (this.maxStaleSeconds != -1) {
      stringBuilder.append("max-stale=");
      stringBuilder.append(this.maxStaleSeconds);
      stringBuilder.append(", ");
    } 
    if (this.minFreshSeconds != -1) {
      stringBuilder.append("min-fresh=");
      stringBuilder.append(this.minFreshSeconds);
      stringBuilder.append(", ");
    } 
    if (this.onlyIfCached)
      stringBuilder.append("only-if-cached, "); 
    if (this.noTransform)
      stringBuilder.append("no-transform, "); 
    if (stringBuilder.length() == 0)
      return ""; 
    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    return stringBuilder.toString();
  }
  
  public static CacheControl parse(Headers paramHeaders) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual size : ()I
    //   4: istore #13
    //   6: iconst_0
    //   7: istore #7
    //   9: iconst_1
    //   10: istore_2
    //   11: aconst_null
    //   12: astore #28
    //   14: iconst_0
    //   15: istore #20
    //   17: iconst_0
    //   18: istore #19
    //   20: iconst_m1
    //   21: istore #6
    //   23: iconst_m1
    //   24: istore #5
    //   26: iconst_0
    //   27: istore #18
    //   29: iconst_0
    //   30: istore #17
    //   32: iconst_0
    //   33: istore #16
    //   35: iconst_m1
    //   36: istore #4
    //   38: iconst_m1
    //   39: istore_3
    //   40: iconst_0
    //   41: istore #14
    //   43: iconst_0
    //   44: istore #15
    //   46: aload_0
    //   47: astore #29
    //   49: iload #7
    //   51: iload #13
    //   53: if_icmpge -> 1103
    //   56: aload #29
    //   58: iload #7
    //   60: invokevirtual name : (I)Ljava/lang/String;
    //   63: astore #31
    //   65: aload #29
    //   67: iload #7
    //   69: invokevirtual value : (I)Ljava/lang/String;
    //   72: astore #30
    //   74: aload #31
    //   76: ldc 'Cache-Control'
    //   78: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   81: ifeq -> 99
    //   84: aload #28
    //   86: ifnull -> 92
    //   89: goto -> 158
    //   92: aload #30
    //   94: astore #28
    //   96: goto -> 160
    //   99: iload_2
    //   100: istore #12
    //   102: aload #28
    //   104: astore #29
    //   106: iload #20
    //   108: istore #21
    //   110: iload #19
    //   112: istore #22
    //   114: iload #6
    //   116: istore_1
    //   117: iload #5
    //   119: istore #8
    //   121: iload #18
    //   123: istore #23
    //   125: iload #17
    //   127: istore #24
    //   129: iload #16
    //   131: istore #25
    //   133: iload #4
    //   135: istore #9
    //   137: iload_3
    //   138: istore #10
    //   140: iload #14
    //   142: istore #26
    //   144: iload #15
    //   146: istore #27
    //   148: aload #31
    //   150: ldc 'Pragma'
    //   152: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   155: ifeq -> 1045
    //   158: iconst_0
    //   159: istore_2
    //   160: iconst_0
    //   161: istore #11
    //   163: iload_2
    //   164: istore #12
    //   166: aload #28
    //   168: astore #29
    //   170: iload #20
    //   172: istore #21
    //   174: iload #19
    //   176: istore #22
    //   178: iload #6
    //   180: istore_1
    //   181: iload #5
    //   183: istore #8
    //   185: iload #18
    //   187: istore #23
    //   189: iload #17
    //   191: istore #24
    //   193: iload #16
    //   195: istore #25
    //   197: iload #4
    //   199: istore #9
    //   201: iload_3
    //   202: istore #10
    //   204: iload #14
    //   206: istore #26
    //   208: iload #15
    //   210: istore #27
    //   212: iload #11
    //   214: aload #30
    //   216: invokevirtual length : ()I
    //   219: if_icmpge -> 1045
    //   222: aload #30
    //   224: iload #11
    //   226: ldc '=,;'
    //   228: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   231: istore_1
    //   232: aload #30
    //   234: iload #11
    //   236: iload_1
    //   237: invokevirtual substring : (II)Ljava/lang/String;
    //   240: invokevirtual trim : ()Ljava/lang/String;
    //   243: astore #31
    //   245: iload_1
    //   246: aload #30
    //   248: invokevirtual length : ()I
    //   251: if_icmpeq -> 370
    //   254: aload #30
    //   256: iload_1
    //   257: invokevirtual charAt : (I)C
    //   260: bipush #44
    //   262: if_icmpeq -> 370
    //   265: aload #30
    //   267: iload_1
    //   268: invokevirtual charAt : (I)C
    //   271: bipush #59
    //   273: if_icmpne -> 279
    //   276: goto -> 370
    //   279: aload #30
    //   281: iload_1
    //   282: iconst_1
    //   283: iadd
    //   284: invokestatic skipWhitespace : (Ljava/lang/String;I)I
    //   287: istore #8
    //   289: iload #8
    //   291: aload #30
    //   293: invokevirtual length : ()I
    //   296: if_icmpge -> 344
    //   299: aload #30
    //   301: iload #8
    //   303: invokevirtual charAt : (I)C
    //   306: bipush #34
    //   308: if_icmpne -> 344
    //   311: iload #8
    //   313: iconst_1
    //   314: iadd
    //   315: istore_1
    //   316: aload #30
    //   318: iload_1
    //   319: ldc '"'
    //   321: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   324: istore #8
    //   326: aload #30
    //   328: iload_1
    //   329: iload #8
    //   331: invokevirtual substring : (II)Ljava/lang/String;
    //   334: astore #29
    //   336: iload #8
    //   338: iconst_1
    //   339: iadd
    //   340: istore_1
    //   341: goto -> 377
    //   344: aload #30
    //   346: iload #8
    //   348: ldc ',;'
    //   350: invokestatic skipUntil : (Ljava/lang/String;ILjava/lang/String;)I
    //   353: istore_1
    //   354: aload #30
    //   356: iload #8
    //   358: iload_1
    //   359: invokevirtual substring : (II)Ljava/lang/String;
    //   362: invokevirtual trim : ()Ljava/lang/String;
    //   365: astore #29
    //   367: goto -> 377
    //   370: iload_1
    //   371: iconst_1
    //   372: iadd
    //   373: istore_1
    //   374: aconst_null
    //   375: astore #29
    //   377: ldc 'no-cache'
    //   379: aload #31
    //   381: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   384: ifeq -> 428
    //   387: iconst_1
    //   388: istore #21
    //   390: iload #19
    //   392: istore #22
    //   394: iload #6
    //   396: istore #8
    //   398: iload #5
    //   400: istore #9
    //   402: iload #18
    //   404: istore #23
    //   406: iload #17
    //   408: istore #24
    //   410: iload #16
    //   412: istore #25
    //   414: iload #4
    //   416: istore #10
    //   418: iload_3
    //   419: istore #12
    //   421: iload #14
    //   423: istore #26
    //   425: goto -> 1000
    //   428: ldc 'no-store'
    //   430: aload #31
    //   432: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   435: ifeq -> 479
    //   438: iconst_1
    //   439: istore #22
    //   441: iload #20
    //   443: istore #21
    //   445: iload #6
    //   447: istore #8
    //   449: iload #5
    //   451: istore #9
    //   453: iload #18
    //   455: istore #23
    //   457: iload #17
    //   459: istore #24
    //   461: iload #16
    //   463: istore #25
    //   465: iload #4
    //   467: istore #10
    //   469: iload_3
    //   470: istore #12
    //   472: iload #14
    //   474: istore #26
    //   476: goto -> 1000
    //   479: ldc 'max-age'
    //   481: aload #31
    //   483: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   486: ifeq -> 535
    //   489: aload #29
    //   491: iconst_m1
    //   492: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   495: istore #8
    //   497: iload #20
    //   499: istore #21
    //   501: iload #19
    //   503: istore #22
    //   505: iload #5
    //   507: istore #9
    //   509: iload #18
    //   511: istore #23
    //   513: iload #17
    //   515: istore #24
    //   517: iload #16
    //   519: istore #25
    //   521: iload #4
    //   523: istore #10
    //   525: iload_3
    //   526: istore #12
    //   528: iload #14
    //   530: istore #26
    //   532: goto -> 1000
    //   535: ldc 's-maxage'
    //   537: aload #31
    //   539: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   542: ifeq -> 591
    //   545: aload #29
    //   547: iconst_m1
    //   548: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   551: istore #9
    //   553: iload #20
    //   555: istore #21
    //   557: iload #19
    //   559: istore #22
    //   561: iload #6
    //   563: istore #8
    //   565: iload #18
    //   567: istore #23
    //   569: iload #17
    //   571: istore #24
    //   573: iload #16
    //   575: istore #25
    //   577: iload #4
    //   579: istore #10
    //   581: iload_3
    //   582: istore #12
    //   584: iload #14
    //   586: istore #26
    //   588: goto -> 1000
    //   591: ldc 'private'
    //   593: aload #31
    //   595: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   598: ifeq -> 642
    //   601: iconst_1
    //   602: istore #23
    //   604: iload #20
    //   606: istore #21
    //   608: iload #19
    //   610: istore #22
    //   612: iload #6
    //   614: istore #8
    //   616: iload #5
    //   618: istore #9
    //   620: iload #17
    //   622: istore #24
    //   624: iload #16
    //   626: istore #25
    //   628: iload #4
    //   630: istore #10
    //   632: iload_3
    //   633: istore #12
    //   635: iload #14
    //   637: istore #26
    //   639: goto -> 1000
    //   642: ldc 'public'
    //   644: aload #31
    //   646: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   649: ifeq -> 693
    //   652: iconst_1
    //   653: istore #24
    //   655: iload #20
    //   657: istore #21
    //   659: iload #19
    //   661: istore #22
    //   663: iload #6
    //   665: istore #8
    //   667: iload #5
    //   669: istore #9
    //   671: iload #18
    //   673: istore #23
    //   675: iload #16
    //   677: istore #25
    //   679: iload #4
    //   681: istore #10
    //   683: iload_3
    //   684: istore #12
    //   686: iload #14
    //   688: istore #26
    //   690: goto -> 1000
    //   693: ldc 'must-revalidate'
    //   695: aload #31
    //   697: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   700: ifeq -> 744
    //   703: iconst_1
    //   704: istore #25
    //   706: iload #20
    //   708: istore #21
    //   710: iload #19
    //   712: istore #22
    //   714: iload #6
    //   716: istore #8
    //   718: iload #5
    //   720: istore #9
    //   722: iload #18
    //   724: istore #23
    //   726: iload #17
    //   728: istore #24
    //   730: iload #4
    //   732: istore #10
    //   734: iload_3
    //   735: istore #12
    //   737: iload #14
    //   739: istore #26
    //   741: goto -> 1000
    //   744: ldc 'max-stale'
    //   746: aload #31
    //   748: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   751: ifeq -> 801
    //   754: aload #29
    //   756: ldc 2147483647
    //   758: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   761: istore #10
    //   763: iload #20
    //   765: istore #21
    //   767: iload #19
    //   769: istore #22
    //   771: iload #6
    //   773: istore #8
    //   775: iload #5
    //   777: istore #9
    //   779: iload #18
    //   781: istore #23
    //   783: iload #17
    //   785: istore #24
    //   787: iload #16
    //   789: istore #25
    //   791: iload_3
    //   792: istore #12
    //   794: iload #14
    //   796: istore #26
    //   798: goto -> 1000
    //   801: ldc 'min-fresh'
    //   803: aload #31
    //   805: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   808: ifeq -> 858
    //   811: aload #29
    //   813: iconst_m1
    //   814: invokestatic parseSeconds : (Ljava/lang/String;I)I
    //   817: istore #12
    //   819: iload #20
    //   821: istore #21
    //   823: iload #19
    //   825: istore #22
    //   827: iload #6
    //   829: istore #8
    //   831: iload #5
    //   833: istore #9
    //   835: iload #18
    //   837: istore #23
    //   839: iload #17
    //   841: istore #24
    //   843: iload #16
    //   845: istore #25
    //   847: iload #4
    //   849: istore #10
    //   851: iload #14
    //   853: istore #26
    //   855: goto -> 1000
    //   858: ldc 'only-if-cached'
    //   860: aload #31
    //   862: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   865: ifeq -> 909
    //   868: iconst_1
    //   869: istore #26
    //   871: iload #20
    //   873: istore #21
    //   875: iload #19
    //   877: istore #22
    //   879: iload #6
    //   881: istore #8
    //   883: iload #5
    //   885: istore #9
    //   887: iload #18
    //   889: istore #23
    //   891: iload #17
    //   893: istore #24
    //   895: iload #16
    //   897: istore #25
    //   899: iload #4
    //   901: istore #10
    //   903: iload_3
    //   904: istore #12
    //   906: goto -> 1000
    //   909: iload #20
    //   911: istore #21
    //   913: iload #19
    //   915: istore #22
    //   917: iload #6
    //   919: istore #8
    //   921: iload #5
    //   923: istore #9
    //   925: iload #18
    //   927: istore #23
    //   929: iload #17
    //   931: istore #24
    //   933: iload #16
    //   935: istore #25
    //   937: iload #4
    //   939: istore #10
    //   941: iload_3
    //   942: istore #12
    //   944: iload #14
    //   946: istore #26
    //   948: ldc 'no-transform'
    //   950: aload #31
    //   952: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   955: ifeq -> 1000
    //   958: iconst_1
    //   959: istore #15
    //   961: iload #14
    //   963: istore #26
    //   965: iload_3
    //   966: istore #12
    //   968: iload #4
    //   970: istore #10
    //   972: iload #16
    //   974: istore #25
    //   976: iload #17
    //   978: istore #24
    //   980: iload #18
    //   982: istore #23
    //   984: iload #5
    //   986: istore #9
    //   988: iload #6
    //   990: istore #8
    //   992: iload #19
    //   994: istore #22
    //   996: iload #20
    //   998: istore #21
    //   1000: iload_1
    //   1001: istore #11
    //   1003: iload #21
    //   1005: istore #20
    //   1007: iload #22
    //   1009: istore #19
    //   1011: iload #8
    //   1013: istore #6
    //   1015: iload #9
    //   1017: istore #5
    //   1019: iload #23
    //   1021: istore #18
    //   1023: iload #24
    //   1025: istore #17
    //   1027: iload #25
    //   1029: istore #16
    //   1031: iload #10
    //   1033: istore #4
    //   1035: iload #12
    //   1037: istore_3
    //   1038: iload #26
    //   1040: istore #14
    //   1042: goto -> 163
    //   1045: iload #7
    //   1047: iconst_1
    //   1048: iadd
    //   1049: istore #7
    //   1051: iload #12
    //   1053: istore_2
    //   1054: aload #29
    //   1056: astore #28
    //   1058: iload #21
    //   1060: istore #20
    //   1062: iload #22
    //   1064: istore #19
    //   1066: iload_1
    //   1067: istore #6
    //   1069: iload #8
    //   1071: istore #5
    //   1073: iload #23
    //   1075: istore #18
    //   1077: iload #24
    //   1079: istore #17
    //   1081: iload #25
    //   1083: istore #16
    //   1085: iload #9
    //   1087: istore #4
    //   1089: iload #10
    //   1091: istore_3
    //   1092: iload #26
    //   1094: istore #14
    //   1096: iload #27
    //   1098: istore #15
    //   1100: goto -> 46
    //   1103: iload_2
    //   1104: ifne -> 1113
    //   1107: aconst_null
    //   1108: astore #28
    //   1110: goto -> 1113
    //   1113: new com/squareup/okhttp/CacheControl
    //   1116: dup
    //   1117: iload #20
    //   1119: iload #19
    //   1121: iload #6
    //   1123: iload #5
    //   1125: iload #18
    //   1127: iload #17
    //   1129: iload #16
    //   1131: iload #4
    //   1133: iload_3
    //   1134: iload #14
    //   1136: iload #15
    //   1138: aload #28
    //   1140: invokespecial <init> : (ZZIIZZZIIZZLjava/lang/String;)V
    //   1143: areturn
  }
  
  public boolean isPrivate() {
    return this.isPrivate;
  }
  
  public boolean isPublic() {
    return this.isPublic;
  }
  
  public int maxAgeSeconds() {
    return this.maxAgeSeconds;
  }
  
  public int maxStaleSeconds() {
    return this.maxStaleSeconds;
  }
  
  public int minFreshSeconds() {
    return this.minFreshSeconds;
  }
  
  public boolean mustRevalidate() {
    return this.mustRevalidate;
  }
  
  public boolean noCache() {
    return this.noCache;
  }
  
  public boolean noStore() {
    return this.noStore;
  }
  
  public boolean noTransform() {
    return this.noTransform;
  }
  
  public boolean onlyIfCached() {
    return this.onlyIfCached;
  }
  
  public int sMaxAgeSeconds() {
    return this.sMaxAgeSeconds;
  }
  
  public String toString() {
    String str = this.headerValue;
    if (str != null)
      return str; 
    str = headerValue();
    this.headerValue = str;
    return str;
  }
  
  public static final class Builder {
    int maxAgeSeconds = -1;
    
    int maxStaleSeconds = -1;
    
    int minFreshSeconds = -1;
    
    boolean noCache;
    
    boolean noStore;
    
    boolean noTransform;
    
    boolean onlyIfCached;
    
    public CacheControl build() {
      return new CacheControl(this);
    }
    
    public Builder maxAge(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.maxAgeSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("maxAge < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder maxStale(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.maxStaleSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("maxStale < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder minFresh(int param1Int, TimeUnit param1TimeUnit) {
      if (param1Int >= 0) {
        long l = param1TimeUnit.toSeconds(param1Int);
        if (l > 2147483647L) {
          param1Int = Integer.MAX_VALUE;
        } else {
          param1Int = (int)l;
        } 
        this.minFreshSeconds = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("minFresh < 0: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder noCache() {
      this.noCache = true;
      return this;
    }
    
    public Builder noStore() {
      this.noStore = true;
      return this;
    }
    
    public Builder noTransform() {
      this.noTransform = true;
      return this;
    }
    
    public Builder onlyIfCached() {
      this.onlyIfCached = true;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\CacheControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */