package com.loc;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;

public final class ei {
  private static boolean A = false;
  
  private static int B = 0;
  
  private static boolean C = false;
  
  private static boolean D = false;
  
  private static boolean E = false;
  
  private static boolean F = false;
  
  private static long G = 0L;
  
  private static boolean H = false;
  
  private static int I = 0;
  
  private static boolean J = false;
  
  private static int K = 0;
  
  private static boolean L = false;
  
  private static String M;
  
  private static long N = 0L;
  
  static long a = 0L;
  
  public static volatile long b = 0L;
  
  static boolean c = false;
  
  public static boolean d = false;
  
  public static boolean e = false;
  
  public static int f = 0;
  
  public static int g = 0;
  
  private static volatile boolean h = false;
  
  private static boolean i = true;
  
  private static int j = 1000;
  
  private static int k = 200;
  
  private static boolean l = false;
  
  private static int m = 20;
  
  private static int n = 0;
  
  private static volatile int o = 0;
  
  private static boolean p = true;
  
  private static boolean q = true;
  
  private static int r = -1;
  
  private static long s;
  
  private static ArrayList<String> t = new ArrayList<String>();
  
  private static ArrayList<String> u = new ArrayList<String>();
  
  private static volatile boolean v = false;
  
  private static boolean w = true;
  
  private static long x = 300000L;
  
  private static boolean y = false;
  
  private static double z = 0.618D;
  
  static {
    A = true;
    B = 80;
    a = 3600000L;
    C = false;
    D = true;
    E = false;
    b = 0L;
    c = true;
    F = true;
    G = -1L;
    H = true;
    I = 1;
    J = true;
    K = 5;
    L = false;
    M = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    N = 0L;
    d = false;
    e = false;
    f = 20480;
    g = 10800000;
  }
  
  public static void a(Context paramContext) {
    if (h)
      return; 
    h = true;
    l.a(paramContext, ej.c(), ej.d(), new l.a(paramContext) {
          public final void a(l.b param1b) {
            ei.a(this.a, param1b);
          }
        });
  }
  
  public static boolean a() {
    return i;
  }
  
  public static boolean a(long paramLong) {
    if (!w)
      return false; 
    long l1 = ep.a();
    long l2 = x;
    return (l2 < 0L || l1 - paramLong < l2);
  }
  
  static boolean a(Context paramContext, l.b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'pref'
    //   3: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   6: astore #4
    //   8: aload_1
    //   9: getfield g : Lcom/loc/l$b$a;
    //   12: astore #5
    //   14: aload #5
    //   16: ifnull -> 252
    //   19: aload #5
    //   21: getfield a : Z
    //   24: putstatic com/loc/ei.i : Z
    //   27: aload #4
    //   29: ldc 'exception'
    //   31: getstatic com/loc/ei.i : Z
    //   34: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   37: aload #5
    //   39: getfield c : Lorg/json/JSONObject;
    //   42: astore #5
    //   44: aload #5
    //   46: ifnull -> 154
    //   49: aload #5
    //   51: ldc 'fn'
    //   53: getstatic com/loc/ei.j : I
    //   56: invokevirtual optInt : (Ljava/lang/String;I)I
    //   59: putstatic com/loc/ei.j : I
    //   62: aload #5
    //   64: ldc 'mpn'
    //   66: getstatic com/loc/ei.k : I
    //   69: invokevirtual optInt : (Ljava/lang/String;I)I
    //   72: istore_2
    //   73: iload_2
    //   74: putstatic com/loc/ei.k : I
    //   77: iload_2
    //   78: sipush #500
    //   81: if_icmple -> 90
    //   84: sipush #500
    //   87: putstatic com/loc/ei.k : I
    //   90: getstatic com/loc/ei.k : I
    //   93: bipush #30
    //   95: if_icmpge -> 103
    //   98: bipush #30
    //   100: putstatic com/loc/ei.k : I
    //   103: aload #5
    //   105: ldc 'igu'
    //   107: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   110: getstatic com/loc/ei.l : Z
    //   113: invokestatic a : (Ljava/lang/String;Z)Z
    //   116: putstatic com/loc/ei.l : Z
    //   119: aload #5
    //   121: ldc 'ms'
    //   123: getstatic com/loc/ei.m : I
    //   126: invokevirtual optInt : (Ljava/lang/String;I)I
    //   129: putstatic com/loc/ei.m : I
    //   132: aload #5
    //   134: ldc 'rot'
    //   136: iconst_0
    //   137: invokevirtual optInt : (Ljava/lang/String;I)I
    //   140: putstatic com/loc/ei.o : I
    //   143: aload #5
    //   145: ldc 'pms'
    //   147: iconst_0
    //   148: invokevirtual optInt : (Ljava/lang/String;I)I
    //   151: putstatic com/loc/ei.n : I
    //   154: getstatic com/loc/ei.j : I
    //   157: getstatic com/loc/ei.l : Z
    //   160: getstatic com/loc/ei.m : I
    //   163: getstatic com/loc/ei.n : I
    //   166: invokestatic a : (IZII)V
    //   169: getstatic com/loc/ei.l : Z
    //   172: getstatic com/loc/ei.n : I
    //   175: invokestatic a : (ZI)V
    //   178: aload #4
    //   180: ldc 'fn'
    //   182: getstatic com/loc/ei.j : I
    //   185: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   188: aload #4
    //   190: ldc 'mpn'
    //   192: getstatic com/loc/ei.k : I
    //   195: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   198: aload #4
    //   200: ldc 'igu'
    //   202: getstatic com/loc/ei.l : Z
    //   205: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   208: aload #4
    //   210: ldc 'ms'
    //   212: getstatic com/loc/ei.m : I
    //   215: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   218: aload #4
    //   220: ldc 'rot'
    //   222: getstatic com/loc/ei.o : I
    //   225: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   228: aload #4
    //   230: ldc 'pms'
    //   232: getstatic com/loc/ei.n : I
    //   235: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   238: goto -> 252
    //   241: astore #5
    //   243: aload #5
    //   245: ldc 'AuthUtil'
    //   247: ldc 'loadConfigDataUploadException'
    //   249: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: invokestatic c : (Landroid/content/Context;)V
    //   256: aload_1
    //   257: getfield f : Lorg/json/JSONObject;
    //   260: astore_1
    //   261: aload_1
    //   262: ifnonnull -> 277
    //   265: aload #4
    //   267: ifnull -> 275
    //   270: aload #4
    //   272: invokestatic a : (Landroid/content/SharedPreferences$Editor;)V
    //   275: iconst_1
    //   276: ireturn
    //   277: aload_1
    //   278: ldc '13S'
    //   280: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   283: astore #5
    //   285: aload #5
    //   287: ifnull -> 521
    //   290: aload #5
    //   292: ldc_w 'at'
    //   295: bipush #123
    //   297: invokevirtual optInt : (Ljava/lang/String;I)I
    //   300: bipush #60
    //   302: imul
    //   303: sipush #1000
    //   306: imul
    //   307: i2l
    //   308: putstatic com/loc/ei.a : J
    //   311: aload #4
    //   313: ldc_w '13S_at'
    //   316: getstatic com/loc/ei.a : J
    //   319: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;J)V
    //   322: goto -> 337
    //   325: astore #6
    //   327: aload #6
    //   329: ldc 'AuthUtil'
    //   331: ldc_w 'requestSdkAuthInterval'
    //   334: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload #5
    //   339: ifnull -> 385
    //   342: aload #5
    //   344: ldc_w 're'
    //   347: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   350: getstatic com/loc/ei.c : Z
    //   353: invokestatic a : (Ljava/lang/String;Z)Z
    //   356: putstatic com/loc/ei.c : Z
    //   359: aload #4
    //   361: ldc_w 'fr'
    //   364: getstatic com/loc/ei.c : Z
    //   367: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   370: goto -> 385
    //   373: astore #6
    //   375: aload #6
    //   377: ldc 'AuthUtil'
    //   379: ldc_w 'checkReLocationAble'
    //   382: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload #5
    //   387: ldc_w 'nla'
    //   390: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   393: getstatic com/loc/ei.D : Z
    //   396: invokestatic a : (Ljava/lang/String;Z)Z
    //   399: putstatic com/loc/ei.D : Z
    //   402: aload #4
    //   404: ldc_w '13S_nla'
    //   407: getstatic com/loc/ei.D : Z
    //   410: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   413: aload #5
    //   415: ldc_w 'asw'
    //   418: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   421: getstatic com/loc/ei.F : Z
    //   424: invokestatic a : (Ljava/lang/String;Z)Z
    //   427: putstatic com/loc/ei.F : Z
    //   430: aload #4
    //   432: ldc_w 'asw'
    //   435: getstatic com/loc/ei.F : Z
    //   438: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   441: aload #5
    //   443: ldc_w 'mlpl'
    //   446: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   449: astore #5
    //   451: aload #5
    //   453: ifnull -> 496
    //   456: aload #5
    //   458: invokevirtual length : ()I
    //   461: ifle -> 496
    //   464: aload_0
    //   465: ifnull -> 496
    //   468: aload #4
    //   470: ldc_w '13S_mlpl'
    //   473: aload #5
    //   475: invokevirtual toString : ()Ljava/lang/String;
    //   478: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   481: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload_0
    //   485: aload #5
    //   487: invokestatic a : (Landroid/content/Context;Lorg/json/JSONArray;)Z
    //   490: putstatic com/loc/ei.E : Z
    //   493: goto -> 521
    //   496: iconst_0
    //   497: putstatic com/loc/ei.E : Z
    //   500: aload #4
    //   502: ldc_w '13S_mlpl'
    //   505: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;)V
    //   508: goto -> 521
    //   511: astore_0
    //   512: aload_0
    //   513: ldc 'AuthUtil'
    //   515: ldc_w 'loadConfigAbleStatus'
    //   518: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload_1
    //   522: ldc_w '11G'
    //   525: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   528: astore_0
    //   529: aload_0
    //   530: ifnull -> 668
    //   533: aload_0
    //   534: ldc_w 'able'
    //   537: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   540: getstatic com/loc/ei.w : Z
    //   543: invokestatic a : (Ljava/lang/String;Z)Z
    //   546: istore_3
    //   547: iload_3
    //   548: putstatic com/loc/ei.w : Z
    //   551: iload_3
    //   552: ifeq -> 573
    //   555: aload_0
    //   556: ldc_w 'c'
    //   559: sipush #300
    //   562: invokevirtual optInt : (Ljava/lang/String;I)I
    //   565: sipush #1000
    //   568: imul
    //   569: i2l
    //   570: putstatic com/loc/ei.x : J
    //   573: aload_0
    //   574: ldc_w 'fa'
    //   577: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   580: getstatic com/loc/ei.y : Z
    //   583: invokestatic a : (Ljava/lang/String;Z)Z
    //   586: putstatic com/loc/ei.y : Z
    //   589: dconst_1
    //   590: ldc2_w 0.2
    //   593: aload_0
    //   594: ldc 'ms'
    //   596: invokevirtual optDouble : (Ljava/lang/String;)D
    //   599: invokestatic max : (DD)D
    //   602: invokestatic min : (DD)D
    //   605: putstatic com/loc/ei.z : D
    //   608: aload #4
    //   610: ldc_w 'ca'
    //   613: getstatic com/loc/ei.w : Z
    //   616: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   619: aload #4
    //   621: ldc_w 'ct'
    //   624: getstatic com/loc/ei.x : J
    //   627: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;J)V
    //   630: aload #4
    //   632: ldc_w '11G_fa'
    //   635: getstatic com/loc/ei.y : Z
    //   638: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   641: aload #4
    //   643: ldc_w '11G_ms'
    //   646: getstatic com/loc/ei.z : D
    //   649: invokestatic valueOf : (D)Ljava/lang/String;
    //   652: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/String;)V
    //   655: goto -> 668
    //   658: astore_0
    //   659: aload_0
    //   660: ldc 'AuthUtil'
    //   662: ldc_w 'loadConfigDataCacheAble'
    //   665: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload_1
    //   669: ldc_w '13J'
    //   672: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   675: astore_0
    //   676: aload_0
    //   677: ifnull -> 750
    //   680: aload_0
    //   681: ldc_w 'able'
    //   684: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   687: getstatic com/loc/ei.A : Z
    //   690: invokestatic a : (Ljava/lang/String;Z)Z
    //   693: istore_3
    //   694: iload_3
    //   695: putstatic com/loc/ei.A : Z
    //   698: iload_3
    //   699: ifeq -> 715
    //   702: aload_0
    //   703: ldc_w 'c'
    //   706: getstatic com/loc/ei.B : I
    //   709: invokevirtual optInt : (Ljava/lang/String;I)I
    //   712: putstatic com/loc/ei.B : I
    //   715: aload #4
    //   717: ldc_w '13J_able'
    //   720: getstatic com/loc/ei.A : Z
    //   723: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   726: aload #4
    //   728: ldc_w '13J_c'
    //   731: getstatic com/loc/ei.B : I
    //   734: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   737: goto -> 750
    //   740: astore_0
    //   741: aload_0
    //   742: ldc 'AuthUtil'
    //   744: ldc_w 'loadConfigDataGpsGeoAble'
    //   747: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   750: aload_1
    //   751: ldc_w '15O'
    //   754: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   757: astore_0
    //   758: aload_0
    //   759: ifnull -> 849
    //   762: aload_0
    //   763: ldc_w 'able'
    //   766: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   769: iconst_0
    //   770: invokestatic a : (Ljava/lang/String;Z)Z
    //   773: ifeq -> 832
    //   776: aload_0
    //   777: ldc_w 'fl'
    //   780: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   783: astore #5
    //   785: aload #5
    //   787: ifnull -> 812
    //   790: aload #5
    //   792: invokevirtual length : ()I
    //   795: ifle -> 812
    //   798: aload #5
    //   800: invokevirtual toString : ()Ljava/lang/String;
    //   803: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   806: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   809: ifeq -> 832
    //   812: aload_0
    //   813: ldc_w 'iv'
    //   816: bipush #30
    //   818: invokevirtual optInt : (Ljava/lang/String;I)I
    //   821: sipush #1000
    //   824: imul
    //   825: i2l
    //   826: putstatic com/loc/ei.G : J
    //   829: goto -> 838
    //   832: ldc2_w -1
    //   835: putstatic com/loc/ei.G : J
    //   838: aload #4
    //   840: ldc_w 'awsi'
    //   843: getstatic com/loc/ei.G : J
    //   846: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;J)V
    //   849: aload_1
    //   850: ldc_w '15U'
    //   853: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   856: astore_0
    //   857: aload_0
    //   858: ifnull -> 931
    //   861: aload_0
    //   862: ldc_w 'able'
    //   865: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   868: getstatic com/loc/ei.H : Z
    //   871: invokestatic a : (Ljava/lang/String;Z)Z
    //   874: istore_3
    //   875: aload_0
    //   876: ldc_w 'yn'
    //   879: getstatic com/loc/ei.I : I
    //   882: invokevirtual optInt : (Ljava/lang/String;I)I
    //   885: istore_2
    //   886: aload_0
    //   887: ldc_w 'sysTime'
    //   890: getstatic com/loc/ei.N : J
    //   893: invokevirtual optLong : (Ljava/lang/String;J)J
    //   896: putstatic com/loc/ei.N : J
    //   899: aload #4
    //   901: ldc_w '15ua'
    //   904: iload_3
    //   905: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   908: aload #4
    //   910: ldc_w '15un'
    //   913: iload_2
    //   914: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   917: aload #4
    //   919: ldc_w '15ust'
    //   922: getstatic com/loc/ei.N : J
    //   925: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;J)V
    //   928: goto -> 931
    //   931: aload_1
    //   932: ifnull -> 1071
    //   935: aload_1
    //   936: ldc_w '17Y'
    //   939: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   942: astore_0
    //   943: aload_0
    //   944: ifnull -> 1071
    //   947: aload_0
    //   948: ldc_w 'able'
    //   951: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   954: getstatic com/loc/ei.d : Z
    //   957: invokestatic a : (Ljava/lang/String;Z)Z
    //   960: putstatic com/loc/ei.d : Z
    //   963: aload #4
    //   965: ldc_w '17ya'
    //   968: getstatic com/loc/ei.d : Z
    //   971: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   974: aload_0
    //   975: ldc_w 'mup'
    //   978: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   981: getstatic com/loc/ei.e : Z
    //   984: invokestatic a : (Ljava/lang/String;Z)Z
    //   987: putstatic com/loc/ei.e : Z
    //   990: aload #4
    //   992: ldc_w '17ym'
    //   995: getstatic com/loc/ei.e : Z
    //   998: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   1001: aload_0
    //   1002: ldc_w 'max'
    //   1005: bipush #20
    //   1007: invokevirtual optInt : (Ljava/lang/String;I)I
    //   1010: istore_2
    //   1011: iload_2
    //   1012: ifle -> 1032
    //   1015: aload #4
    //   1017: ldc_w '17yx'
    //   1020: iload_2
    //   1021: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   1024: iload_2
    //   1025: sipush #1024
    //   1028: imul
    //   1029: putstatic com/loc/ei.f : I
    //   1032: aload_0
    //   1033: ldc_w 'inv'
    //   1036: iconst_3
    //   1037: invokevirtual optInt : (Ljava/lang/String;I)I
    //   1040: istore_2
    //   1041: iload_2
    //   1042: ifle -> 1071
    //   1045: aload #4
    //   1047: ldc_w '17yi'
    //   1050: iload_2
    //   1051: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   1054: iload_2
    //   1055: bipush #60
    //   1057: imul
    //   1058: bipush #60
    //   1060: imul
    //   1061: sipush #1000
    //   1064: imul
    //   1065: putstatic com/loc/ei.g : I
    //   1068: goto -> 1071
    //   1071: aload_1
    //   1072: ifnull -> 1213
    //   1075: aload_1
    //   1076: ldc_w '17J'
    //   1079: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   1082: astore_0
    //   1083: aload_0
    //   1084: ifnull -> 1213
    //   1087: aload_0
    //   1088: ldc_w 'able'
    //   1091: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1094: iconst_0
    //   1095: invokestatic a : (Ljava/lang/String;Z)Z
    //   1098: istore_3
    //   1099: iload_3
    //   1100: putstatic com/loc/ei.J : Z
    //   1103: aload #4
    //   1105: ldc_w 'ok9'
    //   1108: iload_3
    //   1109: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Z)V
    //   1112: iload_3
    //   1113: ifeq -> 1213
    //   1116: aload_0
    //   1117: ldc_w 'auth'
    //   1120: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1123: astore_1
    //   1124: aload_0
    //   1125: ldc_w 'ht'
    //   1128: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1131: putstatic com/loc/ei.M : Ljava/lang/String;
    //   1134: aload #4
    //   1136: ldc_w 'ok11'
    //   1139: getstatic com/loc/ei.M : Ljava/lang/String;
    //   1142: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/String;)V
    //   1145: aload_1
    //   1146: iconst_0
    //   1147: invokestatic a : (Ljava/lang/String;Z)Z
    //   1150: pop
    //   1151: aload_0
    //   1152: ldc_w 'nr'
    //   1155: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1158: iconst_0
    //   1159: invokestatic a : (Ljava/lang/String;Z)Z
    //   1162: putstatic com/loc/ei.L : Z
    //   1165: aload_0
    //   1166: ldc_w 'tm'
    //   1169: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1172: astore_0
    //   1173: aload_0
    //   1174: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1177: ifne -> 1213
    //   1180: aload_0
    //   1181: invokestatic parseInt : (Ljava/lang/String;)I
    //   1184: istore_2
    //   1185: iload_2
    //   1186: ifle -> 1213
    //   1189: iload_2
    //   1190: bipush #20
    //   1192: if_icmpge -> 1213
    //   1195: iload_2
    //   1196: putstatic com/loc/ei.K : I
    //   1199: aload #4
    //   1201: ldc_w 'ok10'
    //   1204: getstatic com/loc/ei.K : I
    //   1207: invokestatic a : (Landroid/content/SharedPreferences$Editor;Ljava/lang/String;I)V
    //   1210: goto -> 1213
    //   1213: aload #4
    //   1215: ifnull -> 1223
    //   1218: aload #4
    //   1220: invokestatic a : (Landroid/content/SharedPreferences$Editor;)V
    //   1223: iconst_1
    //   1224: ireturn
    //   1225: aconst_null
    //   1226: astore_0
    //   1227: aload_0
    //   1228: ifnull -> 1235
    //   1231: aload_0
    //   1232: invokestatic a : (Landroid/content/SharedPreferences$Editor;)V
    //   1235: iconst_0
    //   1236: ireturn
    //   1237: astore_0
    //   1238: goto -> 1225
    //   1241: astore_0
    //   1242: aload #4
    //   1244: astore_0
    //   1245: goto -> 1227
    //   1248: astore_0
    //   1249: iconst_1
    //   1250: ireturn
    //   1251: astore #6
    //   1253: goto -> 413
    //   1256: astore #6
    //   1258: goto -> 441
    //   1261: astore_0
    //   1262: goto -> 521
    //   1265: astore_0
    //   1266: goto -> 849
    //   1269: astore_0
    //   1270: goto -> 931
    //   1273: astore_0
    //   1274: goto -> 1071
    //   1277: astore_0
    //   1278: goto -> 1213
    //   1281: astore_0
    //   1282: iconst_1
    //   1283: ireturn
    //   1284: astore_0
    //   1285: iconst_0
    //   1286: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	8	1237	finally
    //   8	14	241	finally
    //   19	44	241	finally
    //   49	77	241	finally
    //   84	90	241	finally
    //   90	103	241	finally
    //   103	154	241	finally
    //   154	238	241	finally
    //   243	252	1241	finally
    //   252	261	1241	finally
    //   270	275	1248	finally
    //   277	285	511	finally
    //   290	322	325	finally
    //   327	337	511	finally
    //   342	370	373	finally
    //   375	385	511	finally
    //   385	413	1251	finally
    //   413	441	1256	finally
    //   441	451	1261	finally
    //   456	464	1261	finally
    //   468	493	1261	finally
    //   496	508	1261	finally
    //   512	521	1241	finally
    //   521	529	658	finally
    //   533	551	658	finally
    //   555	573	658	finally
    //   573	655	658	finally
    //   659	668	1241	finally
    //   668	676	740	finally
    //   680	698	740	finally
    //   702	715	740	finally
    //   715	737	740	finally
    //   741	750	1241	finally
    //   750	758	1265	finally
    //   762	785	1265	finally
    //   790	812	1265	finally
    //   812	829	1265	finally
    //   832	838	1265	finally
    //   838	849	1265	finally
    //   849	857	1269	finally
    //   861	928	1269	finally
    //   935	943	1273	finally
    //   947	1011	1273	finally
    //   1015	1032	1273	finally
    //   1032	1041	1273	finally
    //   1045	1068	1273	finally
    //   1075	1083	1277	finally
    //   1087	1112	1277	finally
    //   1116	1185	1277	finally
    //   1195	1210	1277	finally
    //   1218	1223	1281	finally
    //   1231	1235	1284	finally
  }
  
  private static boolean a(Context paramContext, JSONArray paramJSONArray) {
    if (paramJSONArray != null)
      try {
        return false;
      } finally {
        paramContext = null;
      }  
    return false;
  }
  
  public static int b() {
    return k;
  }
  
  public static void b(Context paramContext) {
    // Byte code:
    //   0: getstatic com/loc/ei.v : Z
    //   3: ifeq -> 7
    //   6: return
    //   7: iconst_1
    //   8: putstatic com/loc/ei.v : Z
    //   11: aload_0
    //   12: ldc 'pref'
    //   14: ldc 'exception'
    //   16: getstatic com/loc/ei.i : Z
    //   19: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   22: putstatic com/loc/ei.i : Z
    //   25: aload_0
    //   26: invokestatic c : (Landroid/content/Context;)V
    //   29: goto -> 42
    //   32: astore_1
    //   33: aload_1
    //   34: ldc 'AuthUtil'
    //   36: ldc_w 'loadLastAbleState p1'
    //   39: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: ldc 'pref'
    //   45: ldc 'fn'
    //   47: getstatic com/loc/ei.j : I
    //   50: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   53: putstatic com/loc/ei.j : I
    //   56: aload_0
    //   57: ldc 'pref'
    //   59: ldc 'mpn'
    //   61: getstatic com/loc/ei.k : I
    //   64: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   67: putstatic com/loc/ei.k : I
    //   70: aload_0
    //   71: ldc 'pref'
    //   73: ldc 'igu'
    //   75: getstatic com/loc/ei.l : Z
    //   78: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   81: putstatic com/loc/ei.l : Z
    //   84: aload_0
    //   85: ldc 'pref'
    //   87: ldc 'ms'
    //   89: getstatic com/loc/ei.m : I
    //   92: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   95: putstatic com/loc/ei.m : I
    //   98: aload_0
    //   99: ldc 'pref'
    //   101: ldc 'rot'
    //   103: iconst_0
    //   104: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   107: putstatic com/loc/ei.o : I
    //   110: aload_0
    //   111: ldc 'pref'
    //   113: ldc 'pms'
    //   115: iconst_0
    //   116: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   119: putstatic com/loc/ei.n : I
    //   122: getstatic com/loc/ei.j : I
    //   125: getstatic com/loc/ei.l : Z
    //   128: getstatic com/loc/ei.m : I
    //   131: getstatic com/loc/ei.n : I
    //   134: invokestatic a : (IZII)V
    //   137: getstatic com/loc/ei.l : Z
    //   140: getstatic com/loc/ei.n : I
    //   143: invokestatic a : (ZI)V
    //   146: aload_0
    //   147: ldc 'pref'
    //   149: ldc_w 'ca'
    //   152: getstatic com/loc/ei.w : Z
    //   155: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   158: putstatic com/loc/ei.w : Z
    //   161: aload_0
    //   162: ldc 'pref'
    //   164: ldc_w 'ct'
    //   167: getstatic com/loc/ei.x : J
    //   170: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   173: putstatic com/loc/ei.x : J
    //   176: aload_0
    //   177: ldc 'pref'
    //   179: ldc_w '11G_fa'
    //   182: getstatic com/loc/ei.y : Z
    //   185: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   188: putstatic com/loc/ei.y : Z
    //   191: aload_0
    //   192: ldc 'pref'
    //   194: ldc_w '11G_ms'
    //   197: getstatic com/loc/ei.z : D
    //   200: invokestatic valueOf : (D)Ljava/lang/String;
    //   203: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   206: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   209: invokevirtual doubleValue : ()D
    //   212: putstatic com/loc/ei.z : D
    //   215: ldc2_w 0.2
    //   218: getstatic com/loc/ei.z : D
    //   221: invokestatic max : (DD)D
    //   224: putstatic com/loc/ei.z : D
    //   227: aload_0
    //   228: ldc 'pref'
    //   230: ldc_w 'fr'
    //   233: getstatic com/loc/ei.c : Z
    //   236: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   239: putstatic com/loc/ei.c : Z
    //   242: aload_0
    //   243: ldc 'pref'
    //   245: ldc_w 'asw'
    //   248: getstatic com/loc/ei.F : Z
    //   251: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   254: putstatic com/loc/ei.F : Z
    //   257: aload_0
    //   258: ldc 'pref'
    //   260: ldc_w 'awsi'
    //   263: getstatic com/loc/ei.G : J
    //   266: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   269: putstatic com/loc/ei.G : J
    //   272: aload_0
    //   273: ldc 'pref'
    //   275: ldc_w '15ua'
    //   278: getstatic com/loc/ei.H : Z
    //   281: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   284: putstatic com/loc/ei.H : Z
    //   287: aload_0
    //   288: ldc 'pref'
    //   290: ldc_w '15un'
    //   293: getstatic com/loc/ei.I : I
    //   296: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   299: putstatic com/loc/ei.I : I
    //   302: aload_0
    //   303: ldc 'pref'
    //   305: ldc_w '15ust'
    //   308: getstatic com/loc/ei.N : J
    //   311: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   314: putstatic com/loc/ei.N : J
    //   317: aload_0
    //   318: ldc 'pref'
    //   320: ldc_w 'ok9'
    //   323: getstatic com/loc/ei.J : Z
    //   326: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   329: putstatic com/loc/ei.J : Z
    //   332: aload_0
    //   333: ldc 'pref'
    //   335: ldc_w 'ok10'
    //   338: getstatic com/loc/ei.K : I
    //   341: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   344: putstatic com/loc/ei.K : I
    //   347: aload_0
    //   348: ldc 'pref'
    //   350: ldc_w 'ok11'
    //   353: getstatic com/loc/ei.M : Ljava/lang/String;
    //   356: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   359: putstatic com/loc/ei.M : Ljava/lang/String;
    //   362: aload_0
    //   363: ldc 'pref'
    //   365: ldc_w '17ya'
    //   368: iconst_0
    //   369: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   372: putstatic com/loc/ei.d : Z
    //   375: aload_0
    //   376: ldc 'pref'
    //   378: ldc_w '17ym'
    //   381: iconst_0
    //   382: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   385: putstatic com/loc/ei.e : Z
    //   388: aload_0
    //   389: ldc 'pref'
    //   391: ldc_w '17yi'
    //   394: iconst_2
    //   395: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   398: bipush #60
    //   400: imul
    //   401: bipush #60
    //   403: imul
    //   404: sipush #1000
    //   407: imul
    //   408: putstatic com/loc/ei.g : I
    //   411: aload_0
    //   412: ldc 'pref'
    //   414: ldc_w '17yx'
    //   417: bipush #100
    //   419: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   422: sipush #1024
    //   425: imul
    //   426: putstatic com/loc/ei.f : I
    //   429: invokestatic b : ()J
    //   432: putstatic com/loc/ei.b : J
    //   435: aload_0
    //   436: ldc 'pref'
    //   438: ldc_w '13S_at'
    //   441: getstatic com/loc/ei.a : J
    //   444: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   447: putstatic com/loc/ei.a : J
    //   450: aload_0
    //   451: ldc 'pref'
    //   453: ldc_w '13S_nla'
    //   456: getstatic com/loc/ei.D : Z
    //   459: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   462: putstatic com/loc/ei.D : Z
    //   465: aload_0
    //   466: ldc 'pref'
    //   468: ldc_w '13J_able'
    //   471: getstatic com/loc/ei.A : Z
    //   474: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   477: putstatic com/loc/ei.A : Z
    //   480: aload_0
    //   481: ldc 'pref'
    //   483: ldc_w '13J_c'
    //   486: getstatic com/loc/ei.B : I
    //   489: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)I
    //   492: putstatic com/loc/ei.B : I
    //   495: aload_0
    //   496: invokestatic b : (Landroid/content/Context;)V
    //   499: aload_0
    //   500: ldc 'pref'
    //   502: ldc_w '13S_mlpl'
    //   505: aconst_null
    //   506: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   509: astore_1
    //   510: aload_1
    //   511: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   514: ifne -> 535
    //   517: aload_0
    //   518: new org/json/JSONArray
    //   521: dup
    //   522: aload_1
    //   523: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   526: invokespecial <init> : (Ljava/lang/String;)V
    //   529: invokestatic a : (Landroid/content/Context;Lorg/json/JSONArray;)Z
    //   532: putstatic com/loc/ei.E : Z
    //   535: return
    //   536: astore_1
    //   537: goto -> 146
    //   540: astore_1
    //   541: goto -> 227
    //   544: astore_1
    //   545: goto -> 242
    //   548: astore_1
    //   549: goto -> 257
    //   552: astore_1
    //   553: goto -> 272
    //   556: astore_1
    //   557: goto -> 317
    //   560: astore_1
    //   561: goto -> 362
    //   564: astore_1
    //   565: goto -> 429
    //   568: astore_1
    //   569: goto -> 495
    //   572: astore_0
    //   573: return
    // Exception table:
    //   from	to	target	type
    //   11	29	32	finally
    //   42	146	536	finally
    //   146	227	540	finally
    //   227	242	544	finally
    //   242	257	548	finally
    //   257	272	552	finally
    //   272	317	556	finally
    //   317	362	560	finally
    //   362	429	564	finally
    //   429	495	568	finally
    //   499	535	572	finally
  }
  
  public static int c() {
    if (o < 0)
      o = 0; 
    return o;
  }
  
  public static void c(Context paramContext) {
    try {
      t t = ej.c();
      t.a(i);
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  public static long d() {
    return x;
  }
  
  public static boolean e() {
    return w;
  }
  
  public static boolean f() {
    return y;
  }
  
  public static double g() {
    return z;
  }
  
  public static boolean h() {
    return A;
  }
  
  public static int i() {
    return B;
  }
  
  public static boolean j() {
    return D;
  }
  
  public static boolean k() {
    return E;
  }
  
  public static boolean l() {
    return c;
  }
  
  public static boolean m() {
    return F;
  }
  
  public static long n() {
    return G;
  }
  
  public static boolean o() {
    return L;
  }
  
  public static boolean p() {
    return J;
  }
  
  public static int q() {
    return K;
  }
  
  public static String r() {
    return u.c(M);
  }
  
  public static boolean s() {
    return (H && I > 0);
  }
  
  public static int t() {
    return I;
  }
  
  public static long u() {
    return N;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */