package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {
  private List<FSize> C = new ArrayList<FSize>(16);
  
  private List<Boolean> D = new ArrayList<Boolean>(16);
  
  private List<FSize> E = new ArrayList<FSize>(16);
  
  public float a = 0.0F;
  
  public float b = 0.0F;
  
  public float c = 0.0F;
  
  public float d = 0.0F;
  
  private LegendEntry[] e = new LegendEntry[0];
  
  private LegendEntry[] f;
  
  private boolean g = false;
  
  private LegendHorizontalAlignment h = LegendHorizontalAlignment.a;
  
  private LegendVerticalAlignment i = LegendVerticalAlignment.c;
  
  private LegendOrientation j = LegendOrientation.a;
  
  private boolean k = false;
  
  private LegendDirection l = LegendDirection.a;
  
  private LegendForm m = LegendForm.d;
  
  private float n = 8.0F;
  
  private float o = 3.0F;
  
  private DashPathEffect p = null;
  
  private float q = 6.0F;
  
  private float r = 0.0F;
  
  private float s = 5.0F;
  
  private float t = 3.0F;
  
  private float u = 0.95F;
  
  private boolean v = false;
  
  public float a(Paint paramPaint) {
    float f3 = Utils.a(this.s);
    LegendEntry[] arrayOfLegendEntry = this.e;
    int j = arrayOfLegendEntry.length;
    float f1 = 0.0F;
    int i = 0;
    float f2;
    for (f2 = 0.0F; i < j; f2 = f4) {
      LegendEntry legendEntry = arrayOfLegendEntry[i];
      if (Float.isNaN(legendEntry.c)) {
        f4 = this.n;
      } else {
        f4 = legendEntry.c;
      } 
      float f5 = Utils.a(f4);
      float f4 = f2;
      if (f5 > f2)
        f4 = f5; 
      String str = legendEntry.a;
      if (str == null) {
        f2 = f1;
      } else {
        f5 = Utils.a(paramPaint, str);
        f2 = f1;
        if (f5 > f1)
          f2 = f5; 
      } 
      i++;
      f1 = f2;
    } 
    return f1 + f2 + f3;
  }
  
  public void a(Paint paramPaint, ViewPortHandler paramViewPortHandler) {
    // Byte code:
    //   0: aload_0
    //   1: getfield n : F
    //   4: invokestatic a : (F)F
    //   7: fstore #9
    //   9: aload_0
    //   10: getfield t : F
    //   13: invokestatic a : (F)F
    //   16: fstore #10
    //   18: aload_0
    //   19: getfield s : F
    //   22: invokestatic a : (F)F
    //   25: fstore #13
    //   27: aload_0
    //   28: getfield q : F
    //   31: invokestatic a : (F)F
    //   34: fstore #5
    //   36: aload_0
    //   37: getfield r : F
    //   40: invokestatic a : (F)F
    //   43: fstore #12
    //   45: aload_0
    //   46: getfield v : Z
    //   49: istore #22
    //   51: aload_0
    //   52: getfield e : [Lcom/github/mikephil/charting/components/LegendEntry;
    //   55: astore #23
    //   57: aload #23
    //   59: arraylength
    //   60: istore #21
    //   62: aload_0
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual a : (Landroid/graphics/Paint;)F
    //   68: putfield d : F
    //   71: aload_0
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual b : (Landroid/graphics/Paint;)F
    //   77: putfield c : F
    //   80: getstatic com/github/mikephil/charting/components/Legend$1.a : [I
    //   83: aload_0
    //   84: getfield j : Lcom/github/mikephil/charting/components/Legend$LegendOrientation;
    //   87: invokevirtual ordinal : ()I
    //   90: iaload
    //   91: istore #18
    //   93: iload #18
    //   95: iconst_1
    //   96: if_icmpeq -> 710
    //   99: iload #18
    //   101: iconst_2
    //   102: if_icmpeq -> 108
    //   105: goto -> 1032
    //   108: aload_1
    //   109: invokestatic a : (Landroid/graphics/Paint;)F
    //   112: fstore #14
    //   114: aload_1
    //   115: invokestatic b : (Landroid/graphics/Paint;)F
    //   118: fstore #15
    //   120: aload_2
    //   121: invokevirtual i : ()F
    //   124: fstore #16
    //   126: aload_0
    //   127: getfield u : F
    //   130: fstore #17
    //   132: aload_0
    //   133: getfield D : Ljava/util/List;
    //   136: invokeinterface clear : ()V
    //   141: aload_0
    //   142: getfield C : Ljava/util/List;
    //   145: invokeinterface clear : ()V
    //   150: aload_0
    //   151: getfield E : Ljava/util/List;
    //   154: invokeinterface clear : ()V
    //   159: iconst_0
    //   160: istore #18
    //   162: iconst_m1
    //   163: istore #20
    //   165: fconst_0
    //   166: fstore #4
    //   168: fconst_0
    //   169: fstore #8
    //   171: fconst_0
    //   172: fstore #11
    //   174: aload #23
    //   176: astore_2
    //   177: fload #9
    //   179: fstore #6
    //   181: iload #18
    //   183: iload #21
    //   185: if_icmpge -> 641
    //   188: aload_2
    //   189: iload #18
    //   191: aaload
    //   192: astore #23
    //   194: aload #23
    //   196: getfield b : Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   199: getstatic com/github/mikephil/charting/components/Legend$LegendForm.a : Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   202: if_acmpeq -> 211
    //   205: iconst_1
    //   206: istore #19
    //   208: goto -> 214
    //   211: iconst_0
    //   212: istore #19
    //   214: aload #23
    //   216: getfield c : F
    //   219: invokestatic isNaN : (F)Z
    //   222: ifeq -> 231
    //   225: fload #6
    //   227: fstore_3
    //   228: goto -> 240
    //   231: aload #23
    //   233: getfield c : F
    //   236: invokestatic a : (F)F
    //   239: fstore_3
    //   240: aload #23
    //   242: getfield a : Ljava/lang/String;
    //   245: astore #23
    //   247: aload_0
    //   248: getfield D : Ljava/util/List;
    //   251: iconst_0
    //   252: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   255: invokeinterface add : (Ljava/lang/Object;)Z
    //   260: pop
    //   261: iload #20
    //   263: iconst_m1
    //   264: if_icmpne -> 273
    //   267: fconst_0
    //   268: fstore #7
    //   270: goto -> 280
    //   273: fload #8
    //   275: fload #10
    //   277: fadd
    //   278: fstore #7
    //   280: aload #23
    //   282: ifnull -> 346
    //   285: aload_0
    //   286: getfield C : Ljava/util/List;
    //   289: aload_1
    //   290: aload #23
    //   292: invokestatic c : (Landroid/graphics/Paint;Ljava/lang/String;)Lcom/github/mikephil/charting/utils/FSize;
    //   295: invokeinterface add : (Ljava/lang/Object;)Z
    //   300: pop
    //   301: iload #19
    //   303: ifeq -> 314
    //   306: fload #13
    //   308: fload_3
    //   309: fadd
    //   310: fstore_3
    //   311: goto -> 316
    //   314: fconst_0
    //   315: fstore_3
    //   316: fload #7
    //   318: fload_3
    //   319: fadd
    //   320: aload_0
    //   321: getfield C : Ljava/util/List;
    //   324: iload #18
    //   326: invokeinterface get : (I)Ljava/lang/Object;
    //   331: checkcast com/github/mikephil/charting/utils/FSize
    //   334: getfield a : F
    //   337: fadd
    //   338: fstore_3
    //   339: iload #20
    //   341: istore #19
    //   343: goto -> 401
    //   346: aload_0
    //   347: getfield C : Ljava/util/List;
    //   350: astore #24
    //   352: aload #24
    //   354: fconst_0
    //   355: fconst_0
    //   356: invokestatic a : (FF)Lcom/github/mikephil/charting/utils/FSize;
    //   359: invokeinterface add : (Ljava/lang/Object;)Z
    //   364: pop
    //   365: iload #19
    //   367: ifeq -> 373
    //   370: goto -> 375
    //   373: fconst_0
    //   374: fstore_3
    //   375: fload #7
    //   377: fload_3
    //   378: fadd
    //   379: fstore #7
    //   381: fload #7
    //   383: fstore_3
    //   384: iload #20
    //   386: istore #19
    //   388: iload #20
    //   390: iconst_m1
    //   391: if_icmpne -> 401
    //   394: iload #18
    //   396: istore #19
    //   398: fload #7
    //   400: fstore_3
    //   401: aload #23
    //   403: ifnonnull -> 423
    //   406: fload #4
    //   408: fstore #8
    //   410: fload #11
    //   412: fstore #7
    //   414: iload #18
    //   416: iload #21
    //   418: iconst_1
    //   419: isub
    //   420: if_icmpne -> 609
    //   423: fload #11
    //   425: fconst_0
    //   426: fcmpl
    //   427: istore #20
    //   429: iload #20
    //   431: ifne -> 440
    //   434: fconst_0
    //   435: fstore #7
    //   437: goto -> 444
    //   440: fload #5
    //   442: fstore #7
    //   444: iload #22
    //   446: ifeq -> 542
    //   449: iload #20
    //   451: ifeq -> 542
    //   454: fload #16
    //   456: fload #17
    //   458: fmul
    //   459: fload #11
    //   461: fsub
    //   462: fload #7
    //   464: fload_3
    //   465: fadd
    //   466: fcmpl
    //   467: iflt -> 473
    //   470: goto -> 542
    //   473: aload_0
    //   474: getfield E : Ljava/util/List;
    //   477: fload #11
    //   479: fload #14
    //   481: invokestatic a : (FF)Lcom/github/mikephil/charting/utils/FSize;
    //   484: invokeinterface add : (Ljava/lang/Object;)Z
    //   489: pop
    //   490: fload #4
    //   492: fload #11
    //   494: invokestatic max : (FF)F
    //   497: fstore #7
    //   499: aload_0
    //   500: getfield D : Ljava/util/List;
    //   503: astore #24
    //   505: iload #19
    //   507: iconst_m1
    //   508: if_icmple -> 518
    //   511: iload #19
    //   513: istore #20
    //   515: goto -> 522
    //   518: iload #18
    //   520: istore #20
    //   522: aload #24
    //   524: iload #20
    //   526: iconst_1
    //   527: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   530: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   535: pop
    //   536: fload_3
    //   537: fstore #4
    //   539: goto -> 559
    //   542: fload #11
    //   544: fload #7
    //   546: fload_3
    //   547: fadd
    //   548: fadd
    //   549: fstore #8
    //   551: fload #4
    //   553: fstore #7
    //   555: fload #8
    //   557: fstore #4
    //   559: iload #18
    //   561: iload #21
    //   563: iconst_1
    //   564: isub
    //   565: if_icmpne -> 601
    //   568: aload_0
    //   569: getfield E : Ljava/util/List;
    //   572: fload #4
    //   574: fload #14
    //   576: invokestatic a : (FF)Lcom/github/mikephil/charting/utils/FSize;
    //   579: invokeinterface add : (Ljava/lang/Object;)Z
    //   584: pop
    //   585: fload #7
    //   587: fload #4
    //   589: invokestatic max : (FF)F
    //   592: fstore #8
    //   594: fload #4
    //   596: fstore #7
    //   598: goto -> 609
    //   601: fload #7
    //   603: fstore #8
    //   605: fload #4
    //   607: fstore #7
    //   609: aload #23
    //   611: ifnull -> 617
    //   614: iconst_m1
    //   615: istore #19
    //   617: iload #18
    //   619: iconst_1
    //   620: iadd
    //   621: istore #18
    //   623: iload #19
    //   625: istore #20
    //   627: fload #8
    //   629: fstore #4
    //   631: fload_3
    //   632: fstore #8
    //   634: fload #7
    //   636: fstore #11
    //   638: goto -> 181
    //   641: aload_0
    //   642: fload #4
    //   644: putfield a : F
    //   647: aload_0
    //   648: getfield E : Ljava/util/List;
    //   651: invokeinterface size : ()I
    //   656: i2f
    //   657: fstore_3
    //   658: aload_0
    //   659: getfield E : Ljava/util/List;
    //   662: invokeinterface size : ()I
    //   667: ifne -> 676
    //   670: iconst_0
    //   671: istore #18
    //   673: goto -> 689
    //   676: aload_0
    //   677: getfield E : Ljava/util/List;
    //   680: invokeinterface size : ()I
    //   685: iconst_1
    //   686: isub
    //   687: istore #18
    //   689: aload_0
    //   690: fload #14
    //   692: fload_3
    //   693: fmul
    //   694: fload #15
    //   696: fload #12
    //   698: fadd
    //   699: iload #18
    //   701: i2f
    //   702: fmul
    //   703: fadd
    //   704: putfield b : F
    //   707: goto -> 1032
    //   710: aload_1
    //   711: invokestatic a : (Landroid/graphics/Paint;)F
    //   714: fstore #11
    //   716: iconst_0
    //   717: istore #20
    //   719: fconst_0
    //   720: fstore_3
    //   721: fconst_0
    //   722: fstore #5
    //   724: iconst_0
    //   725: istore #18
    //   727: fconst_0
    //   728: fstore #4
    //   730: iload #20
    //   732: iload #21
    //   734: if_icmpge -> 1021
    //   737: aload #23
    //   739: iload #20
    //   741: aaload
    //   742: astore_2
    //   743: aload_2
    //   744: getfield b : Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   747: getstatic com/github/mikephil/charting/components/Legend$LegendForm.a : Lcom/github/mikephil/charting/components/Legend$LegendForm;
    //   750: if_acmpeq -> 759
    //   753: iconst_1
    //   754: istore #19
    //   756: goto -> 762
    //   759: iconst_0
    //   760: istore #19
    //   762: aload_2
    //   763: getfield c : F
    //   766: invokestatic isNaN : (F)Z
    //   769: ifeq -> 779
    //   772: fload #9
    //   774: fstore #6
    //   776: goto -> 788
    //   779: aload_2
    //   780: getfield c : F
    //   783: invokestatic a : (F)F
    //   786: fstore #6
    //   788: aload_2
    //   789: getfield a : Ljava/lang/String;
    //   792: astore_2
    //   793: iload #18
    //   795: ifne -> 801
    //   798: fconst_0
    //   799: fstore #4
    //   801: fload #4
    //   803: fstore #7
    //   805: iload #19
    //   807: ifeq -> 833
    //   810: fload #4
    //   812: fstore #7
    //   814: iload #18
    //   816: ifeq -> 826
    //   819: fload #4
    //   821: fload #10
    //   823: fadd
    //   824: fstore #7
    //   826: fload #7
    //   828: fload #6
    //   830: fadd
    //   831: fstore #7
    //   833: aload_2
    //   834: ifnull -> 971
    //   837: iload #19
    //   839: ifeq -> 868
    //   842: iload #18
    //   844: ifne -> 868
    //   847: fload #7
    //   849: fload #13
    //   851: fadd
    //   852: fstore #8
    //   854: fload_3
    //   855: fstore #4
    //   857: fload #5
    //   859: fstore #6
    //   861: iload #18
    //   863: istore #19
    //   865: goto -> 912
    //   868: fload_3
    //   869: fstore #4
    //   871: fload #5
    //   873: fstore #6
    //   875: iload #18
    //   877: istore #19
    //   879: fload #7
    //   881: fstore #8
    //   883: iload #18
    //   885: ifeq -> 912
    //   888: fload_3
    //   889: fload #7
    //   891: invokestatic max : (FF)F
    //   894: fstore #4
    //   896: fload #5
    //   898: fload #11
    //   900: fload #12
    //   902: fadd
    //   903: fadd
    //   904: fstore #6
    //   906: iconst_0
    //   907: istore #19
    //   909: fconst_0
    //   910: fstore #8
    //   912: fload #8
    //   914: aload_1
    //   915: aload_2
    //   916: invokestatic a : (Landroid/graphics/Paint;Ljava/lang/String;)I
    //   919: i2f
    //   920: fadd
    //   921: fstore #8
    //   923: fload #4
    //   925: fstore_3
    //   926: fload #6
    //   928: fstore #5
    //   930: iload #19
    //   932: istore #18
    //   934: fload #8
    //   936: fstore #7
    //   938: iload #20
    //   940: iload #21
    //   942: iconst_1
    //   943: isub
    //   944: if_icmpge -> 1001
    //   947: fload #6
    //   949: fload #11
    //   951: fload #12
    //   953: fadd
    //   954: fadd
    //   955: fstore #5
    //   957: fload #4
    //   959: fstore_3
    //   960: iload #19
    //   962: istore #18
    //   964: fload #8
    //   966: fstore #7
    //   968: goto -> 1001
    //   971: fload #7
    //   973: fload #6
    //   975: fadd
    //   976: fstore #4
    //   978: fload #4
    //   980: fstore #7
    //   982: iload #20
    //   984: iload #21
    //   986: iconst_1
    //   987: isub
    //   988: if_icmpge -> 998
    //   991: fload #4
    //   993: fload #10
    //   995: fadd
    //   996: fstore #7
    //   998: iconst_1
    //   999: istore #18
    //   1001: fload_3
    //   1002: fload #7
    //   1004: invokestatic max : (FF)F
    //   1007: fstore_3
    //   1008: iload #20
    //   1010: iconst_1
    //   1011: iadd
    //   1012: istore #20
    //   1014: fload #7
    //   1016: fstore #4
    //   1018: goto -> 730
    //   1021: aload_0
    //   1022: fload_3
    //   1023: putfield a : F
    //   1026: aload_0
    //   1027: fload #5
    //   1029: putfield b : F
    //   1032: aload_0
    //   1033: aload_0
    //   1034: getfield b : F
    //   1037: aload_0
    //   1038: getfield y : F
    //   1041: fadd
    //   1042: putfield b : F
    //   1045: aload_0
    //   1046: aload_0
    //   1047: getfield a : F
    //   1050: aload_0
    //   1051: getfield x : F
    //   1054: fadd
    //   1055: putfield a : F
    //   1058: return
  }
  
  public void a(List<LegendEntry> paramList) {
    this.e = paramList.<LegendEntry>toArray(new LegendEntry[paramList.size()]);
  }
  
  public LegendEntry[] a() {
    return this.e;
  }
  
  public float b(Paint paramPaint) {
    LegendEntry[] arrayOfLegendEntry = this.e;
    int j = arrayOfLegendEntry.length;
    float f = 0.0F;
    int i = 0;
    while (i < j) {
      float f1;
      String str = (arrayOfLegendEntry[i]).a;
      if (str == null) {
        f1 = f;
      } else {
        float f2 = Utils.b(paramPaint, str);
        f1 = f;
        if (f2 > f)
          f1 = f2; 
      } 
      i++;
      f = f1;
    } 
    return f;
  }
  
  public LegendEntry[] b() {
    return this.f;
  }
  
  public boolean c() {
    return this.g;
  }
  
  public LegendHorizontalAlignment d() {
    return this.h;
  }
  
  public LegendVerticalAlignment e() {
    return this.i;
  }
  
  public LegendOrientation f() {
    return this.j;
  }
  
  public boolean g() {
    return this.k;
  }
  
  public LegendDirection h() {
    return this.l;
  }
  
  public LegendForm i() {
    return this.m;
  }
  
  public float j() {
    return this.n;
  }
  
  public float k() {
    return this.o;
  }
  
  public DashPathEffect l() {
    return this.p;
  }
  
  public float m() {
    return this.q;
  }
  
  public float n() {
    return this.r;
  }
  
  public float o() {
    return this.s;
  }
  
  public float p() {
    return this.t;
  }
  
  public float q() {
    return this.u;
  }
  
  public List<FSize> r() {
    return this.C;
  }
  
  public List<Boolean> s() {
    return this.D;
  }
  
  public List<FSize> t() {
    return this.E;
  }
  
  public enum LegendDirection {
    a, b;
  }
  
  public enum LegendForm {
    a, b, c, d, e, f;
  }
  
  public enum LegendHorizontalAlignment {
    a, b, c;
  }
  
  public enum LegendOrientation {
    a, b;
  }
  
  public enum LegendVerticalAlignment {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\components\Legend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */