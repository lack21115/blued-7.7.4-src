package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class ConstraintWidget {
  public static final int CHAIN_PACKED = 2;
  
  public static final int CHAIN_SPREAD = 0;
  
  public static final int CHAIN_SPREAD_INSIDE = 1;
  
  public static float DEFAULT_BIAS = 0.5F;
  
  public static final int GONE = 8;
  
  public static final int HORIZONTAL = 0;
  
  public static final int INVISIBLE = 4;
  
  public static final int MATCH_CONSTRAINT_PERCENT = 2;
  
  public static final int MATCH_CONSTRAINT_RATIO = 3;
  
  public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
  
  public static final int MATCH_CONSTRAINT_SPREAD = 0;
  
  public static final int MATCH_CONSTRAINT_WRAP = 1;
  
  public static final int UNKNOWN = -1;
  
  public static final int VERTICAL = 1;
  
  public static final int VISIBLE = 0;
  
  protected DimensionBehaviour[] A = new DimensionBehaviour[] { DimensionBehaviour.FIXED, DimensionBehaviour.FIXED };
  
  ConstraintWidget B = null;
  
  int C = 0;
  
  int D = 0;
  
  protected float E = 0.0F;
  
  protected int F = -1;
  
  protected int G = 0;
  
  protected int H = 0;
  
  int I = 0;
  
  int J = 0;
  
  protected int K = 0;
  
  protected int L = 0;
  
  int M = 0;
  
  protected int N;
  
  protected int O;
  
  float P;
  
  float Q;
  
  boolean R;
  
  boolean S;
  
  boolean T;
  
  boolean U;
  
  boolean V;
  
  int W;
  
  int X;
  
  boolean Y;
  
  boolean Z;
  
  ResolutionDimension a;
  
  float[] aa;
  
  protected ConstraintWidget[] ab;
  
  protected ConstraintWidget[] ac;
  
  ConstraintWidget ad;
  
  ConstraintWidget ae;
  
  private int[] af = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
  
  private float ag = 0.0F;
  
  private int ah = 0;
  
  private int ai = 0;
  
  private int aj = 0;
  
  private int ak = 0;
  
  private int al;
  
  private int am;
  
  private Object an;
  
  private int ao;
  
  private int ap;
  
  private String aq;
  
  private String ar;
  
  ResolutionDimension b;
  
  int c = 0;
  
  int d = 0;
  
  int[] e = new int[2];
  
  int f = 0;
  
  int g = 0;
  
  float h = 1.0F;
  
  int i = 0;
  
  int j = 0;
  
  float k = 1.0F;
  
  boolean l;
  
  boolean m;
  
  public int mHorizontalResolution = -1;
  
  public int mVerticalResolution = -1;
  
  int n = -1;
  
  float o = 1.0F;
  
  ConstraintWidgetGroup p = null;
  
  ConstraintAnchor q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
  
  ConstraintAnchor r = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
  
  ConstraintAnchor s = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
  
  ConstraintAnchor t = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
  
  ConstraintAnchor u = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
  
  ConstraintAnchor v = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
  
  ConstraintAnchor w = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
  
  ConstraintAnchor x = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
  
  protected ConstraintAnchor[] y = new ConstraintAnchor[] { this.q, this.s, this.r, this.t, this.u, this.x };
  
  protected ArrayList<ConstraintAnchor> z = new ArrayList<ConstraintAnchor>();
  
  public ConstraintWidget() {
    float f = DEFAULT_BIAS;
    this.P = f;
    this.Q = f;
    this.ao = 0;
    this.ap = 0;
    this.aq = null;
    this.ar = null;
    this.T = false;
    this.U = false;
    this.V = false;
    this.W = 0;
    this.X = 0;
    this.aa = new float[] { -1.0F, -1.0F };
    this.ab = new ConstraintWidget[] { null, null };
    this.ac = new ConstraintWidget[] { null, null };
    this.ad = null;
    this.ae = null;
    c();
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2) {
    this(0, 0, paramInt1, paramInt2);
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f = DEFAULT_BIAS;
    this.P = f;
    this.Q = f;
    this.ao = 0;
    this.ap = 0;
    this.aq = null;
    this.ar = null;
    this.T = false;
    this.U = false;
    this.V = false;
    this.W = 0;
    this.X = 0;
    this.aa = new float[] { -1.0F, -1.0F };
    this.ab = new ConstraintWidget[] { null, null };
    this.ac = new ConstraintWidget[] { null, null };
    this.ad = null;
    this.ae = null;
    this.G = paramInt1;
    this.H = paramInt2;
    this.C = paramInt3;
    this.D = paramInt4;
    c();
    forceUpdateDrawPosition();
  }
  
  private void a(LinearSystem paramLinearSystem, boolean paramBoolean1, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, DimensionBehaviour paramDimensionBehaviour, boolean paramBoolean2, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, float paramFloat2, boolean paramBoolean5) {
    // Byte code:
    //   0: aload_1
    //   1: aload #7
    //   3: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   6: astore #30
    //   8: aload_1
    //   9: aload #8
    //   11: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   14: astore #26
    //   16: aload_1
    //   17: aload #7
    //   19: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   22: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   25: astore #28
    //   27: aload_1
    //   28: aload #8
    //   30: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   33: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   36: astore #29
    //   38: aload_1
    //   39: getfield graphOptimizer : Z
    //   42: ifeq -> 128
    //   45: aload #7
    //   47: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   50: getfield i : I
    //   53: iconst_1
    //   54: if_icmpne -> 128
    //   57: aload #8
    //   59: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   62: getfield i : I
    //   65: iconst_1
    //   66: if_icmpne -> 128
    //   69: invokestatic getMetrics : ()Landroidx/constraintlayout/solver/Metrics;
    //   72: ifnull -> 89
    //   75: invokestatic getMetrics : ()Landroidx/constraintlayout/solver/Metrics;
    //   78: astore_3
    //   79: aload_3
    //   80: aload_3
    //   81: getfield resolvedWidgets : J
    //   84: lconst_1
    //   85: ladd
    //   86: putfield resolvedWidgets : J
    //   89: aload #7
    //   91: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   94: aload_1
    //   95: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   98: aload #8
    //   100: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   103: aload_1
    //   104: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   107: iload #15
    //   109: ifne -> 127
    //   112: iload_2
    //   113: ifeq -> 127
    //   116: aload_1
    //   117: aload #4
    //   119: aload #26
    //   121: iconst_0
    //   122: bipush #6
    //   124: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   127: return
    //   128: invokestatic getMetrics : ()Landroidx/constraintlayout/solver/Metrics;
    //   131: ifnull -> 151
    //   134: invokestatic getMetrics : ()Landroidx/constraintlayout/solver/Metrics;
    //   137: astore #27
    //   139: aload #27
    //   141: aload #27
    //   143: getfield nonresolvedWidgets : J
    //   146: lconst_1
    //   147: ladd
    //   148: putfield nonresolvedWidgets : J
    //   151: aload #7
    //   153: invokevirtual isConnected : ()Z
    //   156: istore #23
    //   158: aload #8
    //   160: invokevirtual isConnected : ()Z
    //   163: istore #24
    //   165: aload_0
    //   166: getfield x : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   169: invokevirtual isConnected : ()Z
    //   172: istore #25
    //   174: iload #23
    //   176: ifeq -> 185
    //   179: iconst_1
    //   180: istore #22
    //   182: goto -> 188
    //   185: iconst_0
    //   186: istore #22
    //   188: iload #22
    //   190: istore #21
    //   192: iload #24
    //   194: ifeq -> 203
    //   197: iload #22
    //   199: iconst_1
    //   200: iadd
    //   201: istore #21
    //   203: iload #21
    //   205: istore #22
    //   207: iload #25
    //   209: ifeq -> 218
    //   212: iload #21
    //   214: iconst_1
    //   215: iadd
    //   216: istore #22
    //   218: iload #14
    //   220: ifeq -> 229
    //   223: iconst_3
    //   224: istore #21
    //   226: goto -> 233
    //   229: iload #16
    //   231: istore #21
    //   233: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$1.b : [I
    //   236: aload #5
    //   238: invokevirtual ordinal : ()I
    //   241: iaload
    //   242: istore #16
    //   244: iload #16
    //   246: iconst_1
    //   247: if_icmpeq -> 268
    //   250: iload #16
    //   252: iconst_2
    //   253: if_icmpeq -> 268
    //   256: iload #16
    //   258: iconst_3
    //   259: if_icmpeq -> 268
    //   262: iload #16
    //   264: iconst_4
    //   265: if_icmpeq -> 274
    //   268: iconst_0
    //   269: istore #16
    //   271: goto -> 286
    //   274: iload #21
    //   276: iconst_4
    //   277: if_icmpne -> 283
    //   280: goto -> 268
    //   283: iconst_1
    //   284: istore #16
    //   286: aload_0
    //   287: getfield ap : I
    //   290: bipush #8
    //   292: if_icmpne -> 304
    //   295: iconst_0
    //   296: istore #10
    //   298: iconst_0
    //   299: istore #16
    //   301: goto -> 304
    //   304: iload #20
    //   306: ifeq -> 364
    //   309: iload #23
    //   311: ifne -> 335
    //   314: iload #24
    //   316: ifne -> 335
    //   319: iload #25
    //   321: ifne -> 335
    //   324: aload_1
    //   325: aload #30
    //   327: iload #9
    //   329: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;I)V
    //   332: goto -> 364
    //   335: iload #23
    //   337: ifeq -> 364
    //   340: iload #24
    //   342: ifne -> 364
    //   345: aload_1
    //   346: aload #30
    //   348: aload #28
    //   350: aload #7
    //   352: invokevirtual getMargin : ()I
    //   355: bipush #6
    //   357: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   360: pop
    //   361: goto -> 364
    //   364: iload #16
    //   366: ifne -> 448
    //   369: iload #6
    //   371: ifeq -> 424
    //   374: aload_1
    //   375: aload #26
    //   377: aload #30
    //   379: iconst_0
    //   380: iconst_3
    //   381: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   384: pop
    //   385: iload #11
    //   387: ifle -> 402
    //   390: aload_1
    //   391: aload #26
    //   393: aload #30
    //   395: iload #11
    //   397: bipush #6
    //   399: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   402: iload #12
    //   404: ldc 2147483647
    //   406: if_icmpge -> 421
    //   409: aload_1
    //   410: aload #26
    //   412: aload #30
    //   414: iload #12
    //   416: bipush #6
    //   418: invokevirtual addLowerThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   421: goto -> 437
    //   424: aload_1
    //   425: aload #26
    //   427: aload #30
    //   429: iload #10
    //   431: bipush #6
    //   433: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   436: pop
    //   437: iload #18
    //   439: istore #12
    //   441: iload #17
    //   443: istore #10
    //   445: goto -> 825
    //   448: iload #17
    //   450: bipush #-2
    //   452: if_icmpne -> 462
    //   455: iload #10
    //   457: istore #12
    //   459: goto -> 466
    //   462: iload #17
    //   464: istore #12
    //   466: iload #18
    //   468: istore #9
    //   470: iload #18
    //   472: bipush #-2
    //   474: if_icmpne -> 481
    //   477: iload #10
    //   479: istore #9
    //   481: iload #10
    //   483: istore #17
    //   485: iload #12
    //   487: ifle -> 511
    //   490: aload_1
    //   491: aload #26
    //   493: aload #30
    //   495: iload #12
    //   497: bipush #6
    //   499: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   502: iload #10
    //   504: iload #12
    //   506: invokestatic max : (II)I
    //   509: istore #17
    //   511: iload #17
    //   513: istore #18
    //   515: iload #9
    //   517: ifle -> 541
    //   520: aload_1
    //   521: aload #26
    //   523: aload #30
    //   525: iload #9
    //   527: bipush #6
    //   529: invokevirtual addLowerThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   532: iload #17
    //   534: iload #9
    //   536: invokestatic min : (II)I
    //   539: istore #18
    //   541: iload #21
    //   543: iconst_1
    //   544: if_icmpne -> 602
    //   547: iload_2
    //   548: ifeq -> 567
    //   551: aload_1
    //   552: aload #26
    //   554: aload #30
    //   556: iload #18
    //   558: bipush #6
    //   560: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   563: pop
    //   564: goto -> 735
    //   567: iload #15
    //   569: ifeq -> 587
    //   572: aload_1
    //   573: aload #26
    //   575: aload #30
    //   577: iload #18
    //   579: iconst_4
    //   580: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   583: pop
    //   584: goto -> 735
    //   587: aload_1
    //   588: aload #26
    //   590: aload #30
    //   592: iload #18
    //   594: iconst_1
    //   595: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   598: pop
    //   599: goto -> 735
    //   602: iload #21
    //   604: iconst_2
    //   605: if_icmpne -> 735
    //   608: aload #7
    //   610: invokevirtual getType : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   613: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.TOP : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   616: if_acmpeq -> 672
    //   619: aload #7
    //   621: invokevirtual getType : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   624: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   627: if_acmpne -> 633
    //   630: goto -> 672
    //   633: aload_1
    //   634: aload_0
    //   635: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   638: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.LEFT : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   641: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   644: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   647: astore #5
    //   649: aload_0
    //   650: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   653: astore #27
    //   655: aload_1
    //   656: aload #27
    //   658: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   661: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   664: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   667: astore #27
    //   669: goto -> 708
    //   672: aload_1
    //   673: aload_0
    //   674: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   677: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.TOP : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   680: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   683: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   686: astore #5
    //   688: aload_0
    //   689: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   692: astore #27
    //   694: aload_1
    //   695: aload #27
    //   697: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   700: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   703: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   706: astore #27
    //   708: aload_1
    //   709: aload_1
    //   710: invokevirtual createRow : ()Landroidx/constraintlayout/solver/ArrayRow;
    //   713: aload #26
    //   715: aload #30
    //   717: aload #27
    //   719: aload #5
    //   721: fload #19
    //   723: invokevirtual createRowDimensionRatio : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;F)Landroidx/constraintlayout/solver/ArrayRow;
    //   726: invokevirtual addConstraint : (Landroidx/constraintlayout/solver/ArrayRow;)V
    //   729: iconst_0
    //   730: istore #10
    //   732: goto -> 739
    //   735: iload #16
    //   737: istore #10
    //   739: iload #10
    //   741: ifeq -> 809
    //   744: iload #22
    //   746: iconst_2
    //   747: if_icmpeq -> 809
    //   750: iload #14
    //   752: ifne -> 809
    //   755: iload #12
    //   757: iload #18
    //   759: invokestatic max : (II)I
    //   762: istore #16
    //   764: iload #16
    //   766: istore #10
    //   768: iload #9
    //   770: ifle -> 782
    //   773: iload #9
    //   775: iload #16
    //   777: invokestatic min : (II)I
    //   780: istore #10
    //   782: aload_1
    //   783: aload #26
    //   785: aload #30
    //   787: iload #10
    //   789: bipush #6
    //   791: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   794: pop
    //   795: iload #12
    //   797: istore #10
    //   799: iconst_0
    //   800: istore #16
    //   802: iload #9
    //   804: istore #12
    //   806: goto -> 825
    //   809: iload #12
    //   811: istore #17
    //   813: iload #9
    //   815: istore #12
    //   817: iload #10
    //   819: istore #16
    //   821: iload #17
    //   823: istore #10
    //   825: aload #28
    //   827: astore #5
    //   829: iload #20
    //   831: ifeq -> 1436
    //   834: iload #15
    //   836: ifeq -> 842
    //   839: goto -> 1436
    //   842: iload #23
    //   844: ifne -> 874
    //   847: iload #24
    //   849: ifne -> 874
    //   852: iload #25
    //   854: ifne -> 874
    //   857: iload_2
    //   858: ifeq -> 1418
    //   861: aload_1
    //   862: aload #4
    //   864: aload #26
    //   866: iconst_0
    //   867: iconst_5
    //   868: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   871: goto -> 1418
    //   874: iload #23
    //   876: ifeq -> 901
    //   879: iload #24
    //   881: ifne -> 901
    //   884: iload_2
    //   885: ifeq -> 1418
    //   888: aload_1
    //   889: aload #4
    //   891: aload #26
    //   893: iconst_0
    //   894: iconst_5
    //   895: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   898: goto -> 1418
    //   901: iload #23
    //   903: ifne -> 944
    //   906: iload #24
    //   908: ifeq -> 944
    //   911: aload_1
    //   912: aload #26
    //   914: aload #29
    //   916: aload #8
    //   918: invokevirtual getMargin : ()I
    //   921: ineg
    //   922: bipush #6
    //   924: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   927: pop
    //   928: iload_2
    //   929: ifeq -> 1418
    //   932: aload_1
    //   933: aload #30
    //   935: aload_3
    //   936: iconst_0
    //   937: iconst_5
    //   938: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   941: goto -> 1418
    //   944: iload #23
    //   946: ifeq -> 1418
    //   949: iload #24
    //   951: ifeq -> 1418
    //   954: iload #16
    //   956: ifeq -> 1178
    //   959: iload_2
    //   960: ifeq -> 979
    //   963: iload #11
    //   965: ifne -> 979
    //   968: aload_1
    //   969: aload #26
    //   971: aload #30
    //   973: iconst_0
    //   974: bipush #6
    //   976: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   979: iload #21
    //   981: ifne -> 1074
    //   984: iload #12
    //   986: ifgt -> 1007
    //   989: iload #10
    //   991: ifle -> 997
    //   994: goto -> 1007
    //   997: bipush #6
    //   999: istore #11
    //   1001: iconst_0
    //   1002: istore #9
    //   1004: goto -> 1013
    //   1007: iconst_4
    //   1008: istore #11
    //   1010: iconst_1
    //   1011: istore #9
    //   1013: aload_1
    //   1014: aload #30
    //   1016: aload #5
    //   1018: aload #7
    //   1020: invokevirtual getMargin : ()I
    //   1023: iload #11
    //   1025: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   1028: pop
    //   1029: aload_1
    //   1030: aload #26
    //   1032: aload #29
    //   1034: aload #8
    //   1036: invokevirtual getMargin : ()I
    //   1039: ineg
    //   1040: iload #11
    //   1042: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   1045: pop
    //   1046: iload #12
    //   1048: ifgt -> 1065
    //   1051: iload #10
    //   1053: ifle -> 1059
    //   1056: goto -> 1065
    //   1059: iconst_0
    //   1060: istore #11
    //   1062: goto -> 1068
    //   1065: iconst_1
    //   1066: istore #11
    //   1068: iconst_5
    //   1069: istore #10
    //   1071: goto -> 1090
    //   1074: iload #21
    //   1076: iconst_1
    //   1077: if_icmpne -> 1093
    //   1080: iconst_1
    //   1081: istore #11
    //   1083: bipush #6
    //   1085: istore #10
    //   1087: iconst_1
    //   1088: istore #9
    //   1090: goto -> 1187
    //   1093: iload #21
    //   1095: iconst_3
    //   1096: if_icmpne -> 1172
    //   1099: iload #14
    //   1101: ifne -> 1124
    //   1104: aload_0
    //   1105: getfield n : I
    //   1108: iconst_m1
    //   1109: if_icmpeq -> 1124
    //   1112: iload #12
    //   1114: ifgt -> 1124
    //   1117: bipush #6
    //   1119: istore #9
    //   1121: goto -> 1127
    //   1124: iconst_4
    //   1125: istore #9
    //   1127: aload_1
    //   1128: aload #30
    //   1130: aload #5
    //   1132: aload #7
    //   1134: invokevirtual getMargin : ()I
    //   1137: iload #9
    //   1139: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   1142: pop
    //   1143: aload_1
    //   1144: aload #26
    //   1146: aload #29
    //   1148: aload #8
    //   1150: invokevirtual getMargin : ()I
    //   1153: ineg
    //   1154: iload #9
    //   1156: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   1159: pop
    //   1160: iconst_1
    //   1161: istore #11
    //   1163: iconst_5
    //   1164: istore #10
    //   1166: iconst_1
    //   1167: istore #9
    //   1169: goto -> 1187
    //   1172: iconst_0
    //   1173: istore #11
    //   1175: goto -> 1181
    //   1178: iconst_1
    //   1179: istore #11
    //   1181: iconst_5
    //   1182: istore #10
    //   1184: iconst_0
    //   1185: istore #9
    //   1187: aload #5
    //   1189: astore #27
    //   1191: iload #11
    //   1193: ifeq -> 1302
    //   1196: aload #7
    //   1198: invokevirtual getMargin : ()I
    //   1201: istore #11
    //   1203: aload #8
    //   1205: invokevirtual getMargin : ()I
    //   1208: istore #12
    //   1210: iconst_1
    //   1211: istore #6
    //   1213: aload_1
    //   1214: aload #30
    //   1216: aload #27
    //   1218: iload #11
    //   1220: fload #13
    //   1222: aload #29
    //   1224: aload #26
    //   1226: iload #12
    //   1228: iload #10
    //   1230: invokevirtual addCentering : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;IFLandroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   1233: aload #7
    //   1235: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1238: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   1241: instanceof androidx/constraintlayout/solver/widgets/Barrier
    //   1244: istore #14
    //   1246: aload #8
    //   1248: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1251: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   1254: instanceof androidx/constraintlayout/solver/widgets/Barrier
    //   1257: istore #15
    //   1259: iload #14
    //   1261: ifeq -> 1285
    //   1264: iload #15
    //   1266: ifne -> 1285
    //   1269: iload_2
    //   1270: istore #6
    //   1272: iconst_1
    //   1273: istore #14
    //   1275: iconst_5
    //   1276: istore #11
    //   1278: bipush #6
    //   1280: istore #10
    //   1282: goto -> 1314
    //   1285: iload #14
    //   1287: ifne -> 1302
    //   1290: iload #15
    //   1292: ifeq -> 1302
    //   1295: bipush #6
    //   1297: istore #11
    //   1299: goto -> 1308
    //   1302: iload_2
    //   1303: istore #6
    //   1305: iconst_5
    //   1306: istore #11
    //   1308: iload_2
    //   1309: istore #14
    //   1311: iconst_5
    //   1312: istore #10
    //   1314: aload #26
    //   1316: astore #5
    //   1318: iload #9
    //   1320: ifeq -> 1331
    //   1323: bipush #6
    //   1325: istore #11
    //   1327: bipush #6
    //   1329: istore #10
    //   1331: iload #16
    //   1333: ifne -> 1341
    //   1336: iload #6
    //   1338: ifne -> 1346
    //   1341: iload #9
    //   1343: ifeq -> 1361
    //   1346: aload_1
    //   1347: aload #30
    //   1349: aload #27
    //   1351: aload #7
    //   1353: invokevirtual getMargin : ()I
    //   1356: iload #11
    //   1358: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   1361: iload #16
    //   1363: ifne -> 1371
    //   1366: iload #14
    //   1368: ifne -> 1376
    //   1371: iload #9
    //   1373: ifeq -> 1392
    //   1376: aload_1
    //   1377: aload #5
    //   1379: aload #29
    //   1381: aload #8
    //   1383: invokevirtual getMargin : ()I
    //   1386: ineg
    //   1387: iload #10
    //   1389: invokevirtual addLowerThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   1392: iload_2
    //   1393: ifeq -> 1412
    //   1396: aload_1
    //   1397: aload #30
    //   1399: aload_3
    //   1400: iconst_0
    //   1401: bipush #6
    //   1403: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   1406: aload #5
    //   1408: astore_3
    //   1409: goto -> 1421
    //   1412: aload #5
    //   1414: astore_3
    //   1415: goto -> 1421
    //   1418: aload #26
    //   1420: astore_3
    //   1421: iload_2
    //   1422: ifeq -> 1435
    //   1425: aload_1
    //   1426: aload #4
    //   1428: aload_3
    //   1429: iconst_0
    //   1430: bipush #6
    //   1432: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   1435: return
    //   1436: iload #22
    //   1438: iconst_2
    //   1439: if_icmpge -> 1467
    //   1442: iload_2
    //   1443: ifeq -> 1467
    //   1446: aload_1
    //   1447: aload #30
    //   1449: aload_3
    //   1450: iconst_0
    //   1451: bipush #6
    //   1453: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   1456: aload_1
    //   1457: aload #4
    //   1459: aload #26
    //   1461: iconst_0
    //   1462: bipush #6
    //   1464: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   1467: return
  }
  
  private boolean b(int paramInt) {
    paramInt *= 2;
    if ((this.y[paramInt]).c != null) {
      ConstraintAnchor constraintAnchor = (this.y[paramInt]).c.c;
      ConstraintAnchor[] arrayOfConstraintAnchor = this.y;
      if (constraintAnchor != arrayOfConstraintAnchor[paramInt])
        if ((arrayOfConstraintAnchor[++paramInt]).c != null && (this.y[paramInt]).c.c == this.y[paramInt])
          return true;  
    } 
    return false;
  }
  
  private void c() {
    this.z.add(this.q);
    this.z.add(this.r);
    this.z.add(this.s);
    this.z.add(this.t);
    this.z.add(this.v);
    this.z.add(this.w);
    this.z.add(this.x);
    this.z.add(this.u);
  }
  
  protected int a() {
    return this.G + this.K;
  }
  
  int a(int paramInt) {
    return (paramInt == 0) ? this.I : ((paramInt == 1) ? this.J : 0);
  }
  
  void a(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      this.I = paramInt1;
      return;
    } 
    if (paramInt2 == 1)
      this.J = paramInt1; 
  }
  
  public void addToSolver(LinearSystem paramLinearSystem) {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   5: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   8: astore #23
    //   10: aload_1
    //   11: aload_0
    //   12: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   15: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   18: astore #21
    //   20: aload_1
    //   21: aload_0
    //   22: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   25: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   28: astore #22
    //   30: aload_1
    //   31: aload_0
    //   32: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   35: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   38: astore #20
    //   40: aload_1
    //   41: aload_0
    //   42: getfield u : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   45: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   48: astore #17
    //   50: aload_0
    //   51: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   54: astore #18
    //   56: aload #18
    //   58: ifnull -> 325
    //   61: aload #18
    //   63: ifnull -> 85
    //   66: aload #18
    //   68: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   71: iconst_0
    //   72: aaload
    //   73: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   76: if_acmpne -> 85
    //   79: iconst_1
    //   80: istore #10
    //   82: goto -> 88
    //   85: iconst_0
    //   86: istore #10
    //   88: aload_0
    //   89: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   92: astore #18
    //   94: aload #18
    //   96: ifnull -> 118
    //   99: aload #18
    //   101: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   104: iconst_1
    //   105: aaload
    //   106: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   109: if_acmpne -> 118
    //   112: iconst_1
    //   113: istore #11
    //   115: goto -> 121
    //   118: iconst_0
    //   119: istore #11
    //   121: aload_0
    //   122: iconst_0
    //   123: invokespecial b : (I)Z
    //   126: ifeq -> 147
    //   129: aload_0
    //   130: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   133: checkcast androidx/constraintlayout/solver/widgets/ConstraintWidgetContainer
    //   136: aload_0
    //   137: iconst_0
    //   138: invokevirtual a : (Landroidx/constraintlayout/solver/widgets/ConstraintWidget;I)V
    //   141: iconst_1
    //   142: istore #12
    //   144: goto -> 153
    //   147: aload_0
    //   148: invokevirtual isInHorizontalChain : ()Z
    //   151: istore #12
    //   153: aload_0
    //   154: iconst_1
    //   155: invokespecial b : (I)Z
    //   158: ifeq -> 179
    //   161: aload_0
    //   162: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   165: checkcast androidx/constraintlayout/solver/widgets/ConstraintWidgetContainer
    //   168: aload_0
    //   169: iconst_1
    //   170: invokevirtual a : (Landroidx/constraintlayout/solver/widgets/ConstraintWidget;I)V
    //   173: iconst_1
    //   174: istore #13
    //   176: goto -> 185
    //   179: aload_0
    //   180: invokevirtual isInVerticalChain : ()Z
    //   183: istore #13
    //   185: iload #10
    //   187: ifeq -> 238
    //   190: aload_0
    //   191: getfield ap : I
    //   194: bipush #8
    //   196: if_icmpeq -> 238
    //   199: aload_0
    //   200: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   203: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   206: ifnonnull -> 238
    //   209: aload_0
    //   210: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   213: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   216: ifnonnull -> 238
    //   219: aload_1
    //   220: aload_1
    //   221: aload_0
    //   222: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   225: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   228: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   231: aload #21
    //   233: iconst_0
    //   234: iconst_1
    //   235: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   238: iload #11
    //   240: ifeq -> 298
    //   243: aload_0
    //   244: getfield ap : I
    //   247: bipush #8
    //   249: if_icmpeq -> 298
    //   252: aload_0
    //   253: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   256: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   259: ifnonnull -> 298
    //   262: aload_0
    //   263: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   266: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   269: ifnonnull -> 298
    //   272: aload_0
    //   273: getfield u : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   276: ifnonnull -> 298
    //   279: aload_1
    //   280: aload_1
    //   281: aload_0
    //   282: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   285: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   288: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   291: aload #20
    //   293: iconst_0
    //   294: iconst_1
    //   295: invokevirtual addGreaterThan : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)V
    //   298: iload #12
    //   300: istore #14
    //   302: iload #13
    //   304: istore #15
    //   306: iload #10
    //   308: istore #12
    //   310: iload #11
    //   312: istore #10
    //   314: iload #14
    //   316: istore #13
    //   318: iload #15
    //   320: istore #11
    //   322: goto -> 337
    //   325: iconst_0
    //   326: istore #12
    //   328: iconst_0
    //   329: istore #10
    //   331: iconst_0
    //   332: istore #13
    //   334: iconst_0
    //   335: istore #11
    //   337: aload_0
    //   338: getfield C : I
    //   341: istore #4
    //   343: aload_0
    //   344: getfield N : I
    //   347: istore #5
    //   349: iload #4
    //   351: istore_3
    //   352: iload #4
    //   354: iload #5
    //   356: if_icmpge -> 362
    //   359: iload #5
    //   361: istore_3
    //   362: aload_0
    //   363: getfield D : I
    //   366: istore #5
    //   368: aload_0
    //   369: getfield O : I
    //   372: istore #6
    //   374: iload #5
    //   376: istore #4
    //   378: iload #5
    //   380: iload #6
    //   382: if_icmpge -> 389
    //   385: iload #6
    //   387: istore #4
    //   389: aload_0
    //   390: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   393: iconst_0
    //   394: aaload
    //   395: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   398: if_acmpeq -> 407
    //   401: iconst_1
    //   402: istore #14
    //   404: goto -> 410
    //   407: iconst_0
    //   408: istore #14
    //   410: aload_0
    //   411: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   414: iconst_1
    //   415: aaload
    //   416: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   419: if_acmpeq -> 428
    //   422: iconst_1
    //   423: istore #15
    //   425: goto -> 431
    //   428: iconst_0
    //   429: istore #15
    //   431: aload_0
    //   432: aload_0
    //   433: getfield F : I
    //   436: putfield n : I
    //   439: aload_0
    //   440: getfield E : F
    //   443: fstore_2
    //   444: aload_0
    //   445: fload_2
    //   446: putfield o : F
    //   449: aload_0
    //   450: getfield c : I
    //   453: istore #8
    //   455: aload_0
    //   456: getfield d : I
    //   459: istore #7
    //   461: fload_2
    //   462: fconst_0
    //   463: fcmpl
    //   464: ifle -> 803
    //   467: aload_0
    //   468: getfield ap : I
    //   471: bipush #8
    //   473: if_icmpeq -> 803
    //   476: iload #8
    //   478: istore #5
    //   480: aload_0
    //   481: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   484: iconst_0
    //   485: aaload
    //   486: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   489: if_acmpne -> 504
    //   492: iload #8
    //   494: istore #5
    //   496: iload #8
    //   498: ifne -> 504
    //   501: iconst_3
    //   502: istore #5
    //   504: iload #7
    //   506: istore #6
    //   508: aload_0
    //   509: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   512: iconst_1
    //   513: aaload
    //   514: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   517: if_acmpne -> 532
    //   520: iload #7
    //   522: istore #6
    //   524: iload #7
    //   526: ifne -> 532
    //   529: iconst_3
    //   530: istore #6
    //   532: aload_0
    //   533: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   536: iconst_0
    //   537: aaload
    //   538: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   541: if_acmpne -> 583
    //   544: aload_0
    //   545: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   548: iconst_1
    //   549: aaload
    //   550: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   553: if_acmpne -> 583
    //   556: iload #5
    //   558: iconst_3
    //   559: if_icmpne -> 583
    //   562: iload #6
    //   564: iconst_3
    //   565: if_icmpne -> 583
    //   568: aload_0
    //   569: iload #12
    //   571: iload #10
    //   573: iload #14
    //   575: iload #15
    //   577: invokevirtual setupDimensionRatio : (ZZZZ)V
    //   580: goto -> 768
    //   583: aload_0
    //   584: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   587: iconst_0
    //   588: aaload
    //   589: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   592: if_acmpne -> 663
    //   595: iload #5
    //   597: iconst_3
    //   598: if_icmpne -> 663
    //   601: aload_0
    //   602: iconst_0
    //   603: putfield n : I
    //   606: aload_0
    //   607: getfield o : F
    //   610: aload_0
    //   611: getfield D : I
    //   614: i2f
    //   615: fmul
    //   616: f2i
    //   617: istore #7
    //   619: aload_0
    //   620: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   623: iconst_1
    //   624: aaload
    //   625: astore #18
    //   627: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   630: astore #19
    //   632: aload #18
    //   634: aload #19
    //   636: if_acmpeq -> 660
    //   639: iload #4
    //   641: istore #8
    //   643: iload #6
    //   645: istore #4
    //   647: iconst_4
    //   648: istore_3
    //   649: iload #7
    //   651: istore #5
    //   653: iload #8
    //   655: istore #6
    //   657: goto -> 817
    //   660: goto -> 771
    //   663: aload_0
    //   664: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   667: iconst_1
    //   668: aaload
    //   669: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   672: if_acmpne -> 768
    //   675: iload #6
    //   677: iconst_3
    //   678: if_icmpne -> 768
    //   681: aload_0
    //   682: iconst_1
    //   683: putfield n : I
    //   686: aload_0
    //   687: getfield F : I
    //   690: iconst_m1
    //   691: if_icmpne -> 704
    //   694: aload_0
    //   695: fconst_1
    //   696: aload_0
    //   697: getfield o : F
    //   700: fdiv
    //   701: putfield o : F
    //   704: aload_0
    //   705: getfield o : F
    //   708: aload_0
    //   709: getfield C : I
    //   712: i2f
    //   713: fmul
    //   714: f2i
    //   715: istore #7
    //   717: aload_0
    //   718: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   721: iconst_0
    //   722: aaload
    //   723: astore #18
    //   725: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   728: astore #19
    //   730: iload #5
    //   732: istore #9
    //   734: iload_3
    //   735: istore #8
    //   737: iload #8
    //   739: istore #4
    //   741: iload #7
    //   743: istore_3
    //   744: aload #18
    //   746: aload #19
    //   748: if_acmpeq -> 778
    //   751: iconst_4
    //   752: istore #4
    //   754: iload #9
    //   756: istore_3
    //   757: iload #8
    //   759: istore #5
    //   761: iload #7
    //   763: istore #6
    //   765: goto -> 817
    //   768: iload_3
    //   769: istore #7
    //   771: iload #4
    //   773: istore_3
    //   774: iload #7
    //   776: istore #4
    //   778: iconst_1
    //   779: istore #7
    //   781: iload #5
    //   783: istore #8
    //   785: iload #6
    //   787: istore #5
    //   789: iload #7
    //   791: istore #6
    //   793: iload #4
    //   795: istore #9
    //   797: iload_3
    //   798: istore #7
    //   800: goto -> 839
    //   803: iload #4
    //   805: istore #6
    //   807: iload #7
    //   809: istore #4
    //   811: iload_3
    //   812: istore #5
    //   814: iload #8
    //   816: istore_3
    //   817: iconst_0
    //   818: istore #8
    //   820: iload #6
    //   822: istore #7
    //   824: iload #5
    //   826: istore #9
    //   828: iload #8
    //   830: istore #6
    //   832: iload #4
    //   834: istore #5
    //   836: iload_3
    //   837: istore #8
    //   839: aload_0
    //   840: getfield e : [I
    //   843: astore #18
    //   845: aload #18
    //   847: iconst_0
    //   848: iload #8
    //   850: iastore
    //   851: aload #18
    //   853: iconst_1
    //   854: iload #5
    //   856: iastore
    //   857: iload #6
    //   859: ifeq -> 882
    //   862: aload_0
    //   863: getfield n : I
    //   866: istore_3
    //   867: iload_3
    //   868: ifeq -> 876
    //   871: iload_3
    //   872: iconst_m1
    //   873: if_icmpne -> 882
    //   876: iconst_1
    //   877: istore #14
    //   879: goto -> 885
    //   882: iconst_0
    //   883: istore #14
    //   885: aload_0
    //   886: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   889: iconst_0
    //   890: aaload
    //   891: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   894: if_acmpne -> 910
    //   897: aload_0
    //   898: instanceof androidx/constraintlayout/solver/widgets/ConstraintWidgetContainer
    //   901: ifeq -> 910
    //   904: iconst_1
    //   905: istore #15
    //   907: goto -> 913
    //   910: iconst_0
    //   911: istore #15
    //   913: aload_0
    //   914: getfield x : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   917: invokevirtual isConnected : ()Z
    //   920: iconst_1
    //   921: ixor
    //   922: istore #16
    //   924: aload_0
    //   925: getfield mHorizontalResolution : I
    //   928: iconst_2
    //   929: if_icmpeq -> 1058
    //   932: aload_0
    //   933: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   936: astore #18
    //   938: aload #18
    //   940: ifnull -> 957
    //   943: aload_1
    //   944: aload #18
    //   946: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   949: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   952: astore #18
    //   954: goto -> 960
    //   957: aconst_null
    //   958: astore #18
    //   960: aload_0
    //   961: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   964: astore #19
    //   966: aload #19
    //   968: ifnull -> 985
    //   971: aload_1
    //   972: aload #19
    //   974: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   977: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   980: astore #19
    //   982: goto -> 988
    //   985: aconst_null
    //   986: astore #19
    //   988: aload_0
    //   989: aload_1
    //   990: iload #12
    //   992: aload #19
    //   994: aload #18
    //   996: aload_0
    //   997: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1000: iconst_0
    //   1001: aaload
    //   1002: iload #15
    //   1004: aload_0
    //   1005: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1008: aload_0
    //   1009: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1012: aload_0
    //   1013: getfield G : I
    //   1016: iload #9
    //   1018: aload_0
    //   1019: getfield N : I
    //   1022: aload_0
    //   1023: getfield af : [I
    //   1026: iconst_0
    //   1027: iaload
    //   1028: aload_0
    //   1029: getfield P : F
    //   1032: iload #14
    //   1034: iload #13
    //   1036: iload #8
    //   1038: aload_0
    //   1039: getfield f : I
    //   1042: aload_0
    //   1043: getfield g : I
    //   1046: aload_0
    //   1047: getfield h : F
    //   1050: iload #16
    //   1052: invokespecial a : (Landroidx/constraintlayout/solver/LinearSystem;ZLandroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;ZLandroidx/constraintlayout/solver/widgets/ConstraintAnchor;Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;IIIIFZZIIIFZ)V
    //   1055: goto -> 1058
    //   1058: aload #22
    //   1060: astore #18
    //   1062: aload_0
    //   1063: getfield mVerticalResolution : I
    //   1066: iconst_2
    //   1067: if_icmpne -> 1071
    //   1070: return
    //   1071: aload_0
    //   1072: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1075: iconst_1
    //   1076: aaload
    //   1077: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1080: if_acmpne -> 1096
    //   1083: aload_0
    //   1084: instanceof androidx/constraintlayout/solver/widgets/ConstraintWidgetContainer
    //   1087: ifeq -> 1096
    //   1090: iconst_1
    //   1091: istore #12
    //   1093: goto -> 1099
    //   1096: iconst_0
    //   1097: istore #12
    //   1099: iload #6
    //   1101: ifeq -> 1125
    //   1104: aload_0
    //   1105: getfield n : I
    //   1108: istore_3
    //   1109: iload_3
    //   1110: iconst_1
    //   1111: if_icmpeq -> 1119
    //   1114: iload_3
    //   1115: iconst_m1
    //   1116: if_icmpne -> 1125
    //   1119: iconst_1
    //   1120: istore #13
    //   1122: goto -> 1128
    //   1125: iconst_0
    //   1126: istore #13
    //   1128: aload_0
    //   1129: getfield M : I
    //   1132: ifle -> 1221
    //   1135: aload_0
    //   1136: getfield u : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1139: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1142: getfield i : I
    //   1145: iconst_1
    //   1146: if_icmpne -> 1163
    //   1149: aload_0
    //   1150: getfield u : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1153: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1156: aload_1
    //   1157: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   1160: goto -> 1221
    //   1163: aload_1
    //   1164: astore #19
    //   1166: aload #19
    //   1168: aload #17
    //   1170: aload #18
    //   1172: aload_0
    //   1173: invokevirtual getBaselineDistance : ()I
    //   1176: bipush #6
    //   1178: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   1181: pop
    //   1182: aload_0
    //   1183: getfield u : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1186: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1189: ifnull -> 1221
    //   1192: aload #19
    //   1194: aload #17
    //   1196: aload #19
    //   1198: aload_0
    //   1199: getfield u : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1202: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1205: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   1208: iconst_0
    //   1209: bipush #6
    //   1211: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   1214: pop
    //   1215: iconst_0
    //   1216: istore #14
    //   1218: goto -> 1225
    //   1221: iload #16
    //   1223: istore #14
    //   1225: aload_1
    //   1226: astore #22
    //   1228: aload #18
    //   1230: astore #19
    //   1232: aload_0
    //   1233: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   1236: astore #17
    //   1238: aload #17
    //   1240: ifnull -> 1258
    //   1243: aload #22
    //   1245: aload #17
    //   1247: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1250: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   1253: astore #17
    //   1255: goto -> 1261
    //   1258: aconst_null
    //   1259: astore #17
    //   1261: aload_0
    //   1262: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   1265: astore #18
    //   1267: aload #18
    //   1269: ifnull -> 1287
    //   1272: aload #22
    //   1274: aload #18
    //   1276: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1279: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   1282: astore #18
    //   1284: goto -> 1290
    //   1287: aconst_null
    //   1288: astore #18
    //   1290: aload_0
    //   1291: aload_1
    //   1292: iload #10
    //   1294: aload #18
    //   1296: aload #17
    //   1298: aload_0
    //   1299: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   1302: iconst_1
    //   1303: aaload
    //   1304: iload #12
    //   1306: aload_0
    //   1307: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1310: aload_0
    //   1311: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1314: aload_0
    //   1315: getfield H : I
    //   1318: iload #7
    //   1320: aload_0
    //   1321: getfield O : I
    //   1324: aload_0
    //   1325: getfield af : [I
    //   1328: iconst_1
    //   1329: iaload
    //   1330: aload_0
    //   1331: getfield Q : F
    //   1334: iload #13
    //   1336: iload #11
    //   1338: iload #5
    //   1340: aload_0
    //   1341: getfield i : I
    //   1344: aload_0
    //   1345: getfield j : I
    //   1348: aload_0
    //   1349: getfield k : F
    //   1352: iload #14
    //   1354: invokespecial a : (Landroidx/constraintlayout/solver/LinearSystem;ZLandroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;ZLandroidx/constraintlayout/solver/widgets/ConstraintAnchor;Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;IIIIFZZIIIFZ)V
    //   1357: iload #6
    //   1359: ifeq -> 1418
    //   1362: aload_0
    //   1363: astore #17
    //   1365: aload #17
    //   1367: getfield n : I
    //   1370: iconst_1
    //   1371: if_icmpne -> 1396
    //   1374: aload_1
    //   1375: aload #20
    //   1377: aload #19
    //   1379: aload #21
    //   1381: aload #23
    //   1383: aload #17
    //   1385: getfield o : F
    //   1388: bipush #6
    //   1390: invokevirtual addRatio : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;FI)V
    //   1393: goto -> 1418
    //   1396: aload_1
    //   1397: aload #21
    //   1399: aload #23
    //   1401: aload #20
    //   1403: aload #19
    //   1405: aload #17
    //   1407: getfield o : F
    //   1410: bipush #6
    //   1412: invokevirtual addRatio : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;FI)V
    //   1415: goto -> 1418
    //   1418: aload_0
    //   1419: astore #17
    //   1421: aload #17
    //   1423: getfield x : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1426: invokevirtual isConnected : ()Z
    //   1429: ifeq -> 1471
    //   1432: aload_1
    //   1433: aload #17
    //   1435: aload #17
    //   1437: getfield x : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1440: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1443: invokevirtual getOwner : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   1446: aload #17
    //   1448: getfield ag : F
    //   1451: ldc_w 90.0
    //   1454: fadd
    //   1455: f2d
    //   1456: invokestatic toRadians : (D)D
    //   1459: d2f
    //   1460: aload #17
    //   1462: getfield x : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1465: invokevirtual getMargin : ()I
    //   1468: invokevirtual addCenterPoint : (Landroidx/constraintlayout/solver/widgets/ConstraintWidget;Landroidx/constraintlayout/solver/widgets/ConstraintWidget;FI)V
    //   1471: return
  }
  
  public boolean allowedInBarrier() {
    return (this.ap != 8);
  }
  
  public void analyze(int paramInt) {
    Optimizer.a(paramInt, this);
  }
  
  protected int b() {
    return this.H + this.L;
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2) {
    connect(paramType1, paramConstraintWidget, paramType2, 0, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt) {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt, ConstraintAnchor.Strength paramStrength) {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, paramStrength, 0);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2) {
    ConstraintAnchor constraintAnchor;
    ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
    boolean bool = false;
    if (paramType1 == type) {
      if (paramType2 == ConstraintAnchor.Type.CENTER) {
        ConstraintAnchor constraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
        constraintAnchor = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor constraintAnchor2 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor constraintAnchor3 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        bool = true;
        if ((constraintAnchor1 != null && constraintAnchor1.isConnected()) || (constraintAnchor != null && constraintAnchor.isConnected())) {
          paramInt1 = 0;
        } else {
          connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, ConstraintAnchor.Type.LEFT, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.RIGHT, paramConstraintWidget, ConstraintAnchor.Type.RIGHT, 0, paramStrength, paramInt2);
          paramInt1 = 1;
        } 
        if ((constraintAnchor2 != null && constraintAnchor2.isConnected()) || (constraintAnchor3 != null && constraintAnchor3.isConnected())) {
          bool = false;
        } else {
          connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, ConstraintAnchor.Type.TOP, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, ConstraintAnchor.Type.BOTTOM, 0, paramStrength, paramInt2);
        } 
        if (paramInt1 != 0 && bool) {
          getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0, paramInt2);
          return;
        } 
        if (paramInt1 != 0) {
          getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, paramInt2);
          return;
        } 
        if (bool) {
          getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, paramInt2);
          return;
        } 
      } else {
        if (constraintAnchor == ConstraintAnchor.Type.LEFT || constraintAnchor == ConstraintAnchor.Type.RIGHT) {
          connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, (ConstraintAnchor.Type)constraintAnchor, 0, paramStrength, paramInt2);
          paramType1 = ConstraintAnchor.Type.RIGHT;
          try {
            connect(paramType1, paramConstraintWidget, (ConstraintAnchor.Type)constraintAnchor, 0, paramStrength, paramInt2);
            getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor((ConstraintAnchor.Type)constraintAnchor), 0, paramInt2);
            return;
          } finally {}
        } 
        if (constraintAnchor == ConstraintAnchor.Type.TOP || constraintAnchor == ConstraintAnchor.Type.BOTTOM) {
          connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, (ConstraintAnchor.Type)constraintAnchor, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, (ConstraintAnchor.Type)constraintAnchor, 0, paramStrength, paramInt2);
          getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor((ConstraintAnchor.Type)constraintAnchor), 0, paramInt2);
          return;
        } 
      } 
    } else {
      ConstraintAnchor constraintAnchor1;
      if (paramType1 == ConstraintAnchor.Type.CENTER_X && (constraintAnchor == ConstraintAnchor.Type.LEFT || constraintAnchor == ConstraintAnchor.Type.RIGHT)) {
        constraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
        constraintAnchor2 = paramConstraintWidget.getAnchor((ConstraintAnchor.Type)constraintAnchor);
        constraintAnchor = getAnchor(ConstraintAnchor.Type.RIGHT);
        constraintAnchor1.connect(constraintAnchor2, 0, paramInt2);
        constraintAnchor.connect(constraintAnchor2, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintAnchor2, 0, paramInt2);
        return;
      } 
      if (constraintAnchor1 == ConstraintAnchor.Type.CENTER_Y && (constraintAnchor == ConstraintAnchor.Type.TOP || constraintAnchor == ConstraintAnchor.Type.BOTTOM)) {
        constraintAnchor1 = constraintAnchor2.getAnchor((ConstraintAnchor.Type)constraintAnchor);
        getAnchor(ConstraintAnchor.Type.TOP).connect(constraintAnchor1, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintAnchor1, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintAnchor1, 0, paramInt2);
        return;
      } 
      if (constraintAnchor1 == ConstraintAnchor.Type.CENTER_X && constraintAnchor == ConstraintAnchor.Type.CENTER_X) {
        getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintAnchor2.getAnchor(ConstraintAnchor.Type.LEFT), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintAnchor2.getAnchor(ConstraintAnchor.Type.RIGHT), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintAnchor2.getAnchor((ConstraintAnchor.Type)constraintAnchor), 0, paramInt2);
        return;
      } 
      if (constraintAnchor1 == ConstraintAnchor.Type.CENTER_Y && constraintAnchor == ConstraintAnchor.Type.CENTER_Y) {
        getAnchor(ConstraintAnchor.Type.TOP).connect(constraintAnchor2.getAnchor(ConstraintAnchor.Type.TOP), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintAnchor2.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintAnchor2.getAnchor((ConstraintAnchor.Type)constraintAnchor), 0, paramInt2);
        return;
      } 
      ConstraintAnchor constraintAnchor3 = getAnchor((ConstraintAnchor.Type)constraintAnchor1);
      ConstraintAnchor constraintAnchor2 = constraintAnchor2.getAnchor((ConstraintAnchor.Type)constraintAnchor);
      if (constraintAnchor3.isValidConnection(constraintAnchor2)) {
        if (constraintAnchor1 == ConstraintAnchor.Type.BASELINE) {
          constraintAnchor1 = getAnchor(ConstraintAnchor.Type.TOP);
          constraintAnchor = getAnchor(ConstraintAnchor.Type.BOTTOM);
          if (constraintAnchor1 != null)
            constraintAnchor1.reset(); 
          paramInt1 = bool;
          if (constraintAnchor != null) {
            constraintAnchor.reset();
            paramInt1 = bool;
          } 
        } else if (constraintAnchor1 == ConstraintAnchor.Type.TOP || constraintAnchor1 == ConstraintAnchor.Type.BOTTOM) {
          constraintAnchor = getAnchor(ConstraintAnchor.Type.BASELINE);
          if (constraintAnchor != null)
            constraintAnchor.reset(); 
          constraintAnchor = getAnchor(ConstraintAnchor.Type.CENTER);
          if (constraintAnchor.getTarget() != constraintAnchor2)
            constraintAnchor.reset(); 
          constraintAnchor1 = getAnchor((ConstraintAnchor.Type)constraintAnchor1).getOpposite();
          constraintAnchor = getAnchor(ConstraintAnchor.Type.CENTER_Y);
          if (constraintAnchor.isConnected()) {
            constraintAnchor1.reset();
            constraintAnchor.reset();
          } 
        } else if (constraintAnchor1 == ConstraintAnchor.Type.LEFT || constraintAnchor1 == ConstraintAnchor.Type.RIGHT) {
          constraintAnchor = getAnchor(ConstraintAnchor.Type.CENTER);
          if (constraintAnchor.getTarget() != constraintAnchor2)
            constraintAnchor.reset(); 
          constraintAnchor1 = getAnchor((ConstraintAnchor.Type)constraintAnchor1).getOpposite();
          constraintAnchor = getAnchor(ConstraintAnchor.Type.CENTER_X);
          if (constraintAnchor.isConnected()) {
            constraintAnchor1.reset();
            constraintAnchor.reset();
          } 
        } 
        constraintAnchor3.connect(constraintAnchor2, paramInt1, paramStrength, paramInt2);
        constraintAnchor2.getOwner().connectedTo(constraintAnchor3.getOwner());
      } 
    } 
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt) {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt, ConstraintAnchor.Strength.STRONG, 0);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2) {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt1, ConstraintAnchor.Strength.STRONG, paramInt2);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2) {
    if (paramConstraintAnchor1.getOwner() == this)
      connect(paramConstraintAnchor1.getType(), paramConstraintAnchor2.getOwner(), paramConstraintAnchor2.getType(), paramInt1, paramStrength, paramInt2); 
  }
  
  public void connectCircularConstraint(ConstraintWidget paramConstraintWidget, float paramFloat, int paramInt) {
    immediateConnect(ConstraintAnchor.Type.CENTER, paramConstraintWidget, ConstraintAnchor.Type.CENTER, paramInt, 0);
    this.ag = paramFloat;
  }
  
  public void connectedTo(ConstraintWidget paramConstraintWidget) {}
  
  public void createObjectVariables(LinearSystem paramLinearSystem) {
    paramLinearSystem.createObjectVariable(this.q);
    paramLinearSystem.createObjectVariable(this.r);
    paramLinearSystem.createObjectVariable(this.s);
    paramLinearSystem.createObjectVariable(this.t);
    if (this.M > 0)
      paramLinearSystem.createObjectVariable(this.u); 
  }
  
  public void disconnectUnlockedWidget(ConstraintWidget paramConstraintWidget) {
    ArrayList<ConstraintAnchor> arrayList = getAnchors();
    int j = arrayList.size();
    for (int i = 0; i < j; i++) {
      ConstraintAnchor constraintAnchor = arrayList.get(i);
      if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == paramConstraintWidget && constraintAnchor.getConnectionCreator() == 2)
        constraintAnchor.reset(); 
    } 
  }
  
  public void disconnectWidget(ConstraintWidget paramConstraintWidget) {
    ArrayList<ConstraintAnchor> arrayList = getAnchors();
    int j = arrayList.size();
    for (int i = 0; i < j; i++) {
      ConstraintAnchor constraintAnchor = arrayList.get(i);
      if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == paramConstraintWidget)
        constraintAnchor.reset(); 
    } 
  }
  
  public void forceUpdateDrawPosition() {
    int i = this.G;
    int j = this.H;
    int k = this.C;
    int m = this.D;
    this.ah = i;
    this.ai = j;
    this.aj = k + i - i;
    this.ak = m + j - j;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType) {
    switch (null.a[paramType.ordinal()]) {
      default:
        throw new AssertionError(paramType.name());
      case 9:
        return null;
      case 8:
        return this.w;
      case 7:
        return this.v;
      case 6:
        return this.x;
      case 5:
        return this.u;
      case 4:
        return this.t;
      case 3:
        return this.s;
      case 2:
        return this.r;
      case 1:
        break;
    } 
    return this.q;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors() {
    return this.z;
  }
  
  public int getBaselineDistance() {
    return this.M;
  }
  
  public float getBiasPercent(int paramInt) {
    return (paramInt == 0) ? this.P : ((paramInt == 1) ? this.Q : -1.0F);
  }
  
  public int getBottom() {
    return getY() + this.D;
  }
  
  public Object getCompanionWidget() {
    return this.an;
  }
  
  public int getContainerItemSkip() {
    return this.ao;
  }
  
  public String getDebugName() {
    return this.aq;
  }
  
  public DimensionBehaviour getDimensionBehaviour(int paramInt) {
    return (paramInt == 0) ? getHorizontalDimensionBehaviour() : ((paramInt == 1) ? getVerticalDimensionBehaviour() : null);
  }
  
  public float getDimensionRatio() {
    return this.E;
  }
  
  public int getDimensionRatioSide() {
    return this.F;
  }
  
  public int getDrawBottom() {
    return getDrawY() + this.ak;
  }
  
  public int getDrawHeight() {
    return this.ak;
  }
  
  public int getDrawRight() {
    return getDrawX() + this.aj;
  }
  
  public int getDrawWidth() {
    return this.aj;
  }
  
  public int getDrawX() {
    return this.ah + this.K;
  }
  
  public int getDrawY() {
    return this.ai + this.L;
  }
  
  public int getHeight() {
    return (this.ap == 8) ? 0 : this.D;
  }
  
  public float getHorizontalBiasPercent() {
    return this.P;
  }
  
  public ConstraintWidget getHorizontalChainControlWidget() {
    ConstraintWidget constraintWidget;
    if (isInHorizontalChain()) {
      ConstraintWidget constraintWidget1 = this;
      ConstraintAnchor constraintAnchor = null;
      while (true) {
        constraintWidget = (ConstraintWidget)constraintAnchor;
        if (constraintAnchor == null) {
          constraintWidget = (ConstraintWidget)constraintAnchor;
          if (constraintWidget1 != null) {
            ConstraintWidget constraintWidget2;
            ConstraintAnchor constraintAnchor1;
            constraintWidget = (ConstraintWidget)constraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT);
            if (constraintWidget == null) {
              constraintWidget = null;
            } else {
              constraintWidget = (ConstraintWidget)constraintWidget.getTarget();
            } 
            if (constraintWidget == null) {
              constraintWidget = null;
            } else {
              constraintWidget2 = constraintWidget.getOwner();
            } 
            if (constraintWidget2 == getParent())
              return constraintWidget1; 
            if (constraintWidget2 == null) {
              constraintAnchor1 = null;
            } else {
              constraintAnchor1 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            } 
            if (constraintAnchor1 != null && constraintAnchor1.getOwner() != constraintWidget1) {
              ConstraintWidget constraintWidget3 = constraintWidget1;
              continue;
            } 
            constraintWidget1 = constraintWidget2;
            continue;
          } 
        } 
        break;
      } 
    } else {
      constraintWidget = null;
    } 
    return constraintWidget;
  }
  
  public int getHorizontalChainStyle() {
    return this.W;
  }
  
  public DimensionBehaviour getHorizontalDimensionBehaviour() {
    return this.A[0];
  }
  
  public int getInternalDrawBottom() {
    return this.ai + this.ak;
  }
  
  public int getInternalDrawRight() {
    return this.ah + this.aj;
  }
  
  public int getLeft() {
    return getX();
  }
  
  public int getLength(int paramInt) {
    return (paramInt == 0) ? getWidth() : ((paramInt == 1) ? getHeight() : 0);
  }
  
  public int getMaxHeight() {
    return this.af[1];
  }
  
  public int getMaxWidth() {
    return this.af[0];
  }
  
  public int getMinHeight() {
    return this.O;
  }
  
  public int getMinWidth() {
    return this.N;
  }
  
  public int getOptimizerWrapHeight() {
    int i = this.D;
    int j = i;
    if (this.A[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
      if (this.d == 1) {
        i = Math.max(this.i, i);
      } else {
        i = this.i;
        if (i > 0) {
          this.D = i;
        } else {
          i = 0;
        } 
      } 
      int k = this.j;
      j = i;
      if (k > 0) {
        j = i;
        if (k < i)
          j = k; 
      } 
    } 
    return j;
  }
  
  public int getOptimizerWrapWidth() {
    int i = this.C;
    int j = i;
    if (this.A[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
      if (this.c == 1) {
        i = Math.max(this.f, i);
      } else {
        i = this.f;
        if (i > 0) {
          this.C = i;
        } else {
          i = 0;
        } 
      } 
      int k = this.g;
      j = i;
      if (k > 0) {
        j = i;
        if (k < i)
          j = k; 
      } 
    } 
    return j;
  }
  
  public ConstraintWidget getParent() {
    return this.B;
  }
  
  public ResolutionDimension getResolutionHeight() {
    if (this.b == null)
      this.b = new ResolutionDimension(); 
    return this.b;
  }
  
  public ResolutionDimension getResolutionWidth() {
    if (this.a == null)
      this.a = new ResolutionDimension(); 
    return this.a;
  }
  
  public int getRight() {
    return getX() + this.C;
  }
  
  public WidgetContainer getRootWidgetContainer() {
    ConstraintWidget constraintWidget;
    for (constraintWidget = this; constraintWidget.getParent() != null; constraintWidget = constraintWidget.getParent());
    return (constraintWidget instanceof WidgetContainer) ? (WidgetContainer)constraintWidget : null;
  }
  
  public int getTop() {
    return getY();
  }
  
  public String getType() {
    return this.ar;
  }
  
  public float getVerticalBiasPercent() {
    return this.Q;
  }
  
  public ConstraintWidget getVerticalChainControlWidget() {
    ConstraintWidget constraintWidget;
    if (isInVerticalChain()) {
      ConstraintWidget constraintWidget1 = this;
      ConstraintAnchor constraintAnchor = null;
      while (true) {
        constraintWidget = (ConstraintWidget)constraintAnchor;
        if (constraintAnchor == null) {
          constraintWidget = (ConstraintWidget)constraintAnchor;
          if (constraintWidget1 != null) {
            ConstraintWidget constraintWidget2;
            ConstraintAnchor constraintAnchor1;
            constraintWidget = (ConstraintWidget)constraintWidget1.getAnchor(ConstraintAnchor.Type.TOP);
            if (constraintWidget == null) {
              constraintWidget = null;
            } else {
              constraintWidget = (ConstraintWidget)constraintWidget.getTarget();
            } 
            if (constraintWidget == null) {
              constraintWidget = null;
            } else {
              constraintWidget2 = constraintWidget.getOwner();
            } 
            if (constraintWidget2 == getParent())
              return constraintWidget1; 
            if (constraintWidget2 == null) {
              constraintAnchor1 = null;
            } else {
              constraintAnchor1 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            } 
            if (constraintAnchor1 != null && constraintAnchor1.getOwner() != constraintWidget1) {
              ConstraintWidget constraintWidget3 = constraintWidget1;
              continue;
            } 
            constraintWidget1 = constraintWidget2;
            continue;
          } 
        } 
        break;
      } 
    } else {
      constraintWidget = null;
    } 
    return constraintWidget;
  }
  
  public int getVerticalChainStyle() {
    return this.X;
  }
  
  public DimensionBehaviour getVerticalDimensionBehaviour() {
    return this.A[1];
  }
  
  public int getVisibility() {
    return this.ap;
  }
  
  public int getWidth() {
    return (this.ap == 8) ? 0 : this.C;
  }
  
  public int getWrapHeight() {
    return this.am;
  }
  
  public int getWrapWidth() {
    return this.al;
  }
  
  public int getX() {
    return this.G;
  }
  
  public int getY() {
    return this.H;
  }
  
  public boolean hasAncestor(ConstraintWidget paramConstraintWidget) {
    ConstraintWidget constraintWidget2 = getParent();
    if (constraintWidget2 == paramConstraintWidget)
      return true; 
    ConstraintWidget constraintWidget1 = constraintWidget2;
    if (constraintWidget2 == paramConstraintWidget.getParent())
      return false; 
    while (constraintWidget1 != null) {
      if (constraintWidget1 == paramConstraintWidget)
        return true; 
      if (constraintWidget1 == paramConstraintWidget.getParent())
        return true; 
      constraintWidget1 = constraintWidget1.getParent();
    } 
    return false;
  }
  
  public boolean hasBaseline() {
    return (this.M > 0);
  }
  
  public void immediateConnect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, int paramInt2) {
    getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType2), paramInt1, paramInt2, ConstraintAnchor.Strength.STRONG, 0, true);
  }
  
  public boolean isFullyResolved() {
    return ((this.q.getResolutionNode()).i == 1 && (this.s.getResolutionNode()).i == 1 && (this.r.getResolutionNode()).i == 1 && (this.t.getResolutionNode()).i == 1);
  }
  
  public boolean isHeightWrapContent() {
    return this.m;
  }
  
  public boolean isInHorizontalChain() {
    return ((this.q.c != null && this.q.c.c == this.q) || (this.s.c != null && this.s.c.c == this.s));
  }
  
  public boolean isInVerticalChain() {
    return ((this.r.c != null && this.r.c.c == this.r) || (this.t.c != null && this.t.c.c == this.t));
  }
  
  public boolean isInsideConstraintLayout() {
    ConstraintWidget constraintWidget2 = getParent();
    ConstraintWidget constraintWidget1 = constraintWidget2;
    if (constraintWidget2 == null)
      return false; 
    while (constraintWidget1 != null) {
      if (constraintWidget1 instanceof ConstraintWidgetContainer)
        return true; 
      constraintWidget1 = constraintWidget1.getParent();
    } 
    return false;
  }
  
  public boolean isRoot() {
    return (this.B == null);
  }
  
  public boolean isRootContainer() {
    if (this instanceof ConstraintWidgetContainer) {
      ConstraintWidget constraintWidget = this.B;
      if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer))
        return true; 
    } 
    return false;
  }
  
  public boolean isSpreadHeight() {
    return (this.d == 0 && this.E == 0.0F && this.i == 0 && this.j == 0 && this.A[1] == DimensionBehaviour.MATCH_CONSTRAINT);
  }
  
  public boolean isSpreadWidth() {
    int i = this.c;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 0) {
      bool1 = bool2;
      if (this.E == 0.0F) {
        bool1 = bool2;
        if (this.f == 0) {
          bool1 = bool2;
          if (this.g == 0) {
            bool1 = bool2;
            if (this.A[0] == DimensionBehaviour.MATCH_CONSTRAINT)
              bool1 = true; 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public boolean isWidthWrapContent() {
    return this.l;
  }
  
  public void reset() {
    this.q.reset();
    this.r.reset();
    this.s.reset();
    this.t.reset();
    this.u.reset();
    this.v.reset();
    this.w.reset();
    this.x.reset();
    this.B = null;
    this.ag = 0.0F;
    this.C = 0;
    this.D = 0;
    this.E = 0.0F;
    this.F = -1;
    this.G = 0;
    this.H = 0;
    this.ah = 0;
    this.ai = 0;
    this.aj = 0;
    this.ak = 0;
    this.K = 0;
    this.L = 0;
    this.M = 0;
    this.N = 0;
    this.O = 0;
    this.al = 0;
    this.am = 0;
    float f = DEFAULT_BIAS;
    this.P = f;
    this.Q = f;
    this.A[0] = DimensionBehaviour.FIXED;
    this.A[1] = DimensionBehaviour.FIXED;
    this.an = null;
    this.ao = 0;
    this.ap = 0;
    this.ar = null;
    this.R = false;
    this.S = false;
    this.W = 0;
    this.X = 0;
    this.Y = false;
    this.Z = false;
    float[] arrayOfFloat = this.aa;
    arrayOfFloat[0] = -1.0F;
    arrayOfFloat[1] = -1.0F;
    this.mHorizontalResolution = -1;
    this.mVerticalResolution = -1;
    int[] arrayOfInt = this.af;
    arrayOfInt[0] = Integer.MAX_VALUE;
    arrayOfInt[1] = Integer.MAX_VALUE;
    this.c = 0;
    this.d = 0;
    this.h = 1.0F;
    this.k = 1.0F;
    this.g = Integer.MAX_VALUE;
    this.j = Integer.MAX_VALUE;
    this.f = 0;
    this.i = 0;
    this.n = -1;
    this.o = 1.0F;
    ResolutionDimension resolutionDimension = this.a;
    if (resolutionDimension != null)
      resolutionDimension.reset(); 
    resolutionDimension = this.b;
    if (resolutionDimension != null)
      resolutionDimension.reset(); 
    this.p = null;
    this.T = false;
    this.U = false;
    this.V = false;
  }
  
  public void resetAllConstraints() {
    resetAnchors();
    setVerticalBiasPercent(DEFAULT_BIAS);
    setHorizontalBiasPercent(DEFAULT_BIAS);
    if (this instanceof ConstraintWidgetContainer)
      return; 
    if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT)
      if (getWidth() == getWrapWidth()) {
        setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
      } else if (getWidth() > getMinWidth()) {
        setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
      }  
    if (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
      if (getHeight() == getWrapHeight()) {
        setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
        return;
      } 
      if (getHeight() > getMinHeight())
        setVerticalDimensionBehaviour(DimensionBehaviour.FIXED); 
    } 
  }
  
  public void resetAnchor(ConstraintAnchor paramConstraintAnchor) {
    if (getParent() != null && getParent() instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())
      return; 
    ConstraintAnchor constraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
    ConstraintAnchor constraintAnchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor constraintAnchor3 = getAnchor(ConstraintAnchor.Type.TOP);
    ConstraintAnchor constraintAnchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor constraintAnchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
    ConstraintAnchor constraintAnchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor constraintAnchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
    if (paramConstraintAnchor == constraintAnchor5) {
      if (constraintAnchor1.isConnected() && constraintAnchor2.isConnected() && constraintAnchor1.getTarget() == constraintAnchor2.getTarget()) {
        constraintAnchor1.reset();
        constraintAnchor2.reset();
      } 
      if (constraintAnchor3.isConnected() && constraintAnchor4.isConnected() && constraintAnchor3.getTarget() == constraintAnchor4.getTarget()) {
        constraintAnchor3.reset();
        constraintAnchor4.reset();
      } 
      this.P = 0.5F;
      this.Q = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor6) {
      if (constraintAnchor1.isConnected() && constraintAnchor2.isConnected() && constraintAnchor1.getTarget().getOwner() == constraintAnchor2.getTarget().getOwner()) {
        constraintAnchor1.reset();
        constraintAnchor2.reset();
      } 
      this.P = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor7) {
      if (constraintAnchor3.isConnected() && constraintAnchor4.isConnected() && constraintAnchor3.getTarget().getOwner() == constraintAnchor4.getTarget().getOwner()) {
        constraintAnchor3.reset();
        constraintAnchor4.reset();
      } 
      this.Q = 0.5F;
    } else if (paramConstraintAnchor == constraintAnchor1 || paramConstraintAnchor == constraintAnchor2) {
      if (constraintAnchor1.isConnected() && constraintAnchor1.getTarget() == constraintAnchor2.getTarget())
        constraintAnchor5.reset(); 
    } else if ((paramConstraintAnchor == constraintAnchor3 || paramConstraintAnchor == constraintAnchor4) && constraintAnchor3.isConnected() && constraintAnchor3.getTarget() == constraintAnchor4.getTarget()) {
      constraintAnchor5.reset();
    } 
    paramConstraintAnchor.reset();
  }
  
  public void resetAnchors() {
    ConstraintWidget constraintWidget = getParent();
    if (constraintWidget != null && constraintWidget instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())
      return; 
    int i = 0;
    int j = this.z.size();
    while (i < j) {
      ((ConstraintAnchor)this.z.get(i)).reset();
      i++;
    } 
  }
  
  public void resetAnchors(int paramInt) {
    ConstraintWidget constraintWidget = getParent();
    if (constraintWidget != null && constraintWidget instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())
      return; 
    int i = 0;
    int j = this.z.size();
    while (i < j) {
      ConstraintAnchor constraintAnchor = this.z.get(i);
      if (paramInt == constraintAnchor.getConnectionCreator()) {
        if (constraintAnchor.isVerticalAnchor()) {
          setVerticalBiasPercent(DEFAULT_BIAS);
        } else {
          setHorizontalBiasPercent(DEFAULT_BIAS);
        } 
        constraintAnchor.reset();
      } 
      i++;
    } 
  }
  
  public void resetResolutionNodes() {
    for (int i = 0; i < 6; i++)
      this.y[i].getResolutionNode().reset(); 
  }
  
  public void resetSolverVariables(Cache paramCache) {
    this.q.resetSolverVariable(paramCache);
    this.r.resetSolverVariable(paramCache);
    this.s.resetSolverVariable(paramCache);
    this.t.resetSolverVariable(paramCache);
    this.u.resetSolverVariable(paramCache);
    this.x.resetSolverVariable(paramCache);
    this.v.resetSolverVariable(paramCache);
    this.w.resetSolverVariable(paramCache);
  }
  
  public void resolve() {}
  
  public void setBaselineDistance(int paramInt) {
    this.M = paramInt;
  }
  
  public void setCompanionWidget(Object paramObject) {
    this.an = paramObject;
  }
  
  public void setContainerItemSkip(int paramInt) {
    if (paramInt >= 0) {
      this.ao = paramInt;
      return;
    } 
    this.ao = 0;
  }
  
  public void setDebugName(String paramString) {
    this.aq = paramString;
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString) {
    this.aq = paramString;
    SolverVariable solverVariable4 = paramLinearSystem.createObjectVariable(this.q);
    SolverVariable solverVariable3 = paramLinearSystem.createObjectVariable(this.r);
    SolverVariable solverVariable2 = paramLinearSystem.createObjectVariable(this.s);
    SolverVariable solverVariable1 = paramLinearSystem.createObjectVariable(this.t);
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramString);
    stringBuilder4.append(".left");
    solverVariable4.setName(stringBuilder4.toString());
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramString);
    stringBuilder3.append(".top");
    solverVariable3.setName(stringBuilder3.toString());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append(".right");
    solverVariable2.setName(stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramString);
    stringBuilder1.append(".bottom");
    solverVariable1.setName(stringBuilder1.toString());
    if (this.M > 0) {
      SolverVariable solverVariable = paramLinearSystem.createObjectVariable(this.u);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(".baseline");
      solverVariable.setName(stringBuilder.toString());
    } 
  }
  
  public void setDimension(int paramInt1, int paramInt2) {
    this.C = paramInt1;
    paramInt1 = this.C;
    int i = this.N;
    if (paramInt1 < i)
      this.C = i; 
    this.D = paramInt2;
    paramInt1 = this.D;
    paramInt2 = this.O;
    if (paramInt1 < paramInt2)
      this.D = paramInt2; 
  }
  
  public void setDimensionRatio(float paramFloat, int paramInt) {
    this.E = paramFloat;
    this.F = paramInt;
  }
  
  public void setDimensionRatio(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 261
    //   4: aload_1
    //   5: invokevirtual length : ()I
    //   8: ifne -> 14
    //   11: goto -> 261
    //   14: iconst_m1
    //   15: istore #6
    //   17: aload_1
    //   18: invokevirtual length : ()I
    //   21: istore #8
    //   23: aload_1
    //   24: bipush #44
    //   26: invokevirtual indexOf : (I)I
    //   29: istore #9
    //   31: iconst_0
    //   32: istore #7
    //   34: iload #6
    //   36: istore #4
    //   38: iload #7
    //   40: istore #5
    //   42: iload #9
    //   44: ifle -> 114
    //   47: iload #6
    //   49: istore #4
    //   51: iload #7
    //   53: istore #5
    //   55: iload #9
    //   57: iload #8
    //   59: iconst_1
    //   60: isub
    //   61: if_icmpge -> 114
    //   64: aload_1
    //   65: iconst_0
    //   66: iload #9
    //   68: invokevirtual substring : (II)Ljava/lang/String;
    //   71: astore #10
    //   73: aload #10
    //   75: ldc_w 'W'
    //   78: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   81: ifeq -> 90
    //   84: iconst_0
    //   85: istore #4
    //   87: goto -> 108
    //   90: iload #6
    //   92: istore #4
    //   94: aload #10
    //   96: ldc_w 'H'
    //   99: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   102: ifeq -> 108
    //   105: iconst_1
    //   106: istore #4
    //   108: iload #9
    //   110: iconst_1
    //   111: iadd
    //   112: istore #5
    //   114: aload_1
    //   115: bipush #58
    //   117: invokevirtual indexOf : (I)I
    //   120: istore #6
    //   122: iload #6
    //   124: iflt -> 219
    //   127: iload #6
    //   129: iload #8
    //   131: iconst_1
    //   132: isub
    //   133: if_icmpge -> 219
    //   136: aload_1
    //   137: iload #5
    //   139: iload #6
    //   141: invokevirtual substring : (II)Ljava/lang/String;
    //   144: astore #10
    //   146: aload_1
    //   147: iload #6
    //   149: iconst_1
    //   150: iadd
    //   151: invokevirtual substring : (I)Ljava/lang/String;
    //   154: astore_1
    //   155: aload #10
    //   157: invokevirtual length : ()I
    //   160: ifle -> 241
    //   163: aload_1
    //   164: invokevirtual length : ()I
    //   167: ifle -> 241
    //   170: aload #10
    //   172: invokestatic parseFloat : (Ljava/lang/String;)F
    //   175: fstore_2
    //   176: aload_1
    //   177: invokestatic parseFloat : (Ljava/lang/String;)F
    //   180: fstore_3
    //   181: fload_2
    //   182: fconst_0
    //   183: fcmpl
    //   184: ifle -> 241
    //   187: fload_3
    //   188: fconst_0
    //   189: fcmpl
    //   190: ifle -> 241
    //   193: iload #4
    //   195: iconst_1
    //   196: if_icmpne -> 209
    //   199: fload_3
    //   200: fload_2
    //   201: fdiv
    //   202: invokestatic abs : (F)F
    //   205: fstore_2
    //   206: goto -> 243
    //   209: fload_2
    //   210: fload_3
    //   211: fdiv
    //   212: invokestatic abs : (F)F
    //   215: fstore_2
    //   216: goto -> 243
    //   219: aload_1
    //   220: iload #5
    //   222: invokevirtual substring : (I)Ljava/lang/String;
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual length : ()I
    //   230: ifle -> 241
    //   233: aload_1
    //   234: invokestatic parseFloat : (Ljava/lang/String;)F
    //   237: fstore_2
    //   238: goto -> 243
    //   241: fconst_0
    //   242: fstore_2
    //   243: fload_2
    //   244: fconst_0
    //   245: fcmpl
    //   246: ifle -> 260
    //   249: aload_0
    //   250: fload_2
    //   251: putfield E : F
    //   254: aload_0
    //   255: iload #4
    //   257: putfield F : I
    //   260: return
    //   261: aload_0
    //   262: fconst_0
    //   263: putfield E : F
    //   266: return
    //   267: astore_1
    //   268: goto -> 241
    // Exception table:
    //   from	to	target	type
    //   170	181	267	java/lang/NumberFormatException
    //   199	206	267	java/lang/NumberFormatException
    //   209	216	267	java/lang/NumberFormatException
    //   233	238	267	java/lang/NumberFormatException
  }
  
  public void setDrawHeight(int paramInt) {
    this.ak = paramInt;
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2) {
    this.ah = paramInt1 - this.K;
    this.ai = paramInt2 - this.L;
    this.G = this.ah;
    this.H = this.ai;
  }
  
  public void setDrawWidth(int paramInt) {
    this.aj = paramInt;
  }
  
  public void setDrawX(int paramInt) {
    this.ah = paramInt - this.K;
    this.G = this.ah;
  }
  
  public void setDrawY(int paramInt) {
    this.ai = paramInt - this.L;
    this.H = this.ai;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt3 == 0) {
      setHorizontalDimension(paramInt1, paramInt2);
    } else if (paramInt3 == 1) {
      setVerticalDimension(paramInt1, paramInt2);
    } 
    this.U = true;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: iload_3
    //   1: iload_1
    //   2: isub
    //   3: istore #5
    //   5: iload #4
    //   7: iload_2
    //   8: isub
    //   9: istore_3
    //   10: aload_0
    //   11: iload_1
    //   12: putfield G : I
    //   15: aload_0
    //   16: iload_2
    //   17: putfield H : I
    //   20: aload_0
    //   21: getfield ap : I
    //   24: bipush #8
    //   26: if_icmpne -> 40
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield C : I
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield D : I
    //   39: return
    //   40: aload_0
    //   41: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   44: iconst_0
    //   45: aaload
    //   46: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   49: if_acmpne -> 66
    //   52: aload_0
    //   53: getfield C : I
    //   56: istore_1
    //   57: iload #5
    //   59: iload_1
    //   60: if_icmpge -> 66
    //   63: goto -> 69
    //   66: iload #5
    //   68: istore_1
    //   69: aload_0
    //   70: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   73: iconst_1
    //   74: aaload
    //   75: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   78: if_acmpne -> 94
    //   81: aload_0
    //   82: getfield D : I
    //   85: istore_2
    //   86: iload_3
    //   87: iload_2
    //   88: if_icmpge -> 94
    //   91: goto -> 96
    //   94: iload_3
    //   95: istore_2
    //   96: aload_0
    //   97: iload_1
    //   98: putfield C : I
    //   101: aload_0
    //   102: iload_2
    //   103: putfield D : I
    //   106: aload_0
    //   107: getfield D : I
    //   110: istore_1
    //   111: aload_0
    //   112: getfield O : I
    //   115: istore_2
    //   116: iload_1
    //   117: iload_2
    //   118: if_icmpge -> 126
    //   121: aload_0
    //   122: iload_2
    //   123: putfield D : I
    //   126: aload_0
    //   127: getfield C : I
    //   130: istore_1
    //   131: aload_0
    //   132: getfield N : I
    //   135: istore_2
    //   136: iload_1
    //   137: iload_2
    //   138: if_icmpge -> 146
    //   141: aload_0
    //   142: iload_2
    //   143: putfield C : I
    //   146: aload_0
    //   147: iconst_1
    //   148: putfield U : Z
    //   151: return
  }
  
  public void setGoneMargin(ConstraintAnchor.Type paramType, int paramInt) {
    int i = null.a[paramType.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          this.t.d = paramInt;
          return;
        } 
        this.s.d = paramInt;
        return;
      } 
      this.r.d = paramInt;
      return;
    } 
    this.q.d = paramInt;
  }
  
  public void setHeight(int paramInt) {
    this.D = paramInt;
    paramInt = this.D;
    int i = this.O;
    if (paramInt < i)
      this.D = i; 
  }
  
  public void setHeightWrapContent(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public void setHorizontalBiasPercent(float paramFloat) {
    this.P = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt) {
    this.W = paramInt;
  }
  
  public void setHorizontalDimension(int paramInt1, int paramInt2) {
    this.G = paramInt1;
    this.C = paramInt2 - paramInt1;
    paramInt1 = this.C;
    paramInt2 = this.N;
    if (paramInt1 < paramInt2)
      this.C = paramInt2; 
  }
  
  public void setHorizontalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour) {
    this.A[0] = paramDimensionBehaviour;
    if (paramDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT)
      setWidth(this.al); 
  }
  
  public void setHorizontalMatchStyle(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    this.c = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramFloat;
    if (paramFloat < 1.0F && this.c == 0)
      this.c = 2; 
  }
  
  public void setHorizontalWeight(float paramFloat) {
    this.aa[0] = paramFloat;
  }
  
  public void setLength(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      setWidth(paramInt1);
      return;
    } 
    if (paramInt2 == 1)
      setHeight(paramInt1); 
  }
  
  public void setMaxHeight(int paramInt) {
    this.af[1] = paramInt;
  }
  
  public void setMaxWidth(int paramInt) {
    this.af[0] = paramInt;
  }
  
  public void setMinHeight(int paramInt) {
    if (paramInt < 0) {
      this.O = 0;
      return;
    } 
    this.O = paramInt;
  }
  
  public void setMinWidth(int paramInt) {
    if (paramInt < 0) {
      this.N = 0;
      return;
    } 
    this.N = paramInt;
  }
  
  public void setOffset(int paramInt1, int paramInt2) {
    this.K = paramInt1;
    this.L = paramInt2;
  }
  
  public void setOrigin(int paramInt1, int paramInt2) {
    this.G = paramInt1;
    this.H = paramInt2;
  }
  
  public void setParent(ConstraintWidget paramConstraintWidget) {
    this.B = paramConstraintWidget;
  }
  
  public void setType(String paramString) {
    this.ar = paramString;
  }
  
  public void setVerticalBiasPercent(float paramFloat) {
    this.Q = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt) {
    this.X = paramInt;
  }
  
  public void setVerticalDimension(int paramInt1, int paramInt2) {
    this.H = paramInt1;
    this.D = paramInt2 - paramInt1;
    paramInt1 = this.D;
    paramInt2 = this.O;
    if (paramInt1 < paramInt2)
      this.D = paramInt2; 
  }
  
  public void setVerticalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour) {
    this.A[1] = paramDimensionBehaviour;
    if (paramDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT)
      setHeight(this.am); 
  }
  
  public void setVerticalMatchStyle(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    this.d = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramFloat;
    if (paramFloat < 1.0F && this.d == 0)
      this.d = 2; 
  }
  
  public void setVerticalWeight(float paramFloat) {
    this.aa[1] = paramFloat;
  }
  
  public void setVisibility(int paramInt) {
    this.ap = paramInt;
  }
  
  public void setWidth(int paramInt) {
    this.C = paramInt;
    paramInt = this.C;
    int i = this.N;
    if (paramInt < i)
      this.C = i; 
  }
  
  public void setWidthWrapContent(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void setWrapHeight(int paramInt) {
    this.am = paramInt;
  }
  
  public void setWrapWidth(int paramInt) {
    this.al = paramInt;
  }
  
  public void setX(int paramInt) {
    this.G = paramInt;
  }
  
  public void setY(int paramInt) {
    this.H = paramInt;
  }
  
  public void setupDimensionRatio(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    if (this.n == -1)
      if (paramBoolean3 && !paramBoolean4) {
        this.n = 0;
      } else if (!paramBoolean3 && paramBoolean4) {
        this.n = 1;
        if (this.F == -1)
          this.o = 1.0F / this.o; 
      }  
    if (this.n == 0 && (!this.r.isConnected() || !this.t.isConnected())) {
      this.n = 1;
    } else if (this.n == 1 && (!this.q.isConnected() || !this.s.isConnected())) {
      this.n = 0;
    } 
    if (this.n == -1 && (!this.r.isConnected() || !this.t.isConnected() || !this.q.isConnected() || !this.s.isConnected()))
      if (this.r.isConnected() && this.t.isConnected()) {
        this.n = 0;
      } else if (this.q.isConnected() && this.s.isConnected()) {
        this.o = 1.0F / this.o;
        this.n = 1;
      }  
    if (this.n == -1)
      if (paramBoolean1 && !paramBoolean2) {
        this.n = 0;
      } else if (!paramBoolean1 && paramBoolean2) {
        this.o = 1.0F / this.o;
        this.n = 1;
      }  
    if (this.n == -1)
      if (this.f > 0 && this.i == 0) {
        this.n = 0;
      } else if (this.f == 0 && this.i > 0) {
        this.o = 1.0F / this.o;
        this.n = 1;
      }  
    if (this.n == -1 && paramBoolean1 && paramBoolean2) {
      this.o = 1.0F / this.o;
      this.n = 1;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    String str1 = this.ar;
    String str2 = "";
    if (str1 != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("type: ");
      stringBuilder1.append(this.ar);
      stringBuilder1.append(" ");
      String str = stringBuilder1.toString();
    } else {
      str1 = "";
    } 
    stringBuilder.append(str1);
    str1 = str2;
    if (this.aq != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("id: ");
      stringBuilder1.append(this.aq);
      stringBuilder1.append(" ");
      str1 = stringBuilder1.toString();
    } 
    stringBuilder.append(str1);
    stringBuilder.append("(");
    stringBuilder.append(this.G);
    stringBuilder.append(", ");
    stringBuilder.append(this.H);
    stringBuilder.append(") - (");
    stringBuilder.append(this.C);
    stringBuilder.append(" x ");
    stringBuilder.append(this.D);
    stringBuilder.append(") wrap: (");
    stringBuilder.append(this.al);
    stringBuilder.append(" x ");
    stringBuilder.append(this.am);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public void updateDrawPosition() {
    int i = this.G;
    int j = this.H;
    int k = this.C;
    int m = this.D;
    this.ah = i;
    this.ai = j;
    this.aj = k + i - i;
    this.ak = m + j - j;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem) {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   5: invokevirtual getObjectVariableValue : (Ljava/lang/Object;)I
    //   8: istore_3
    //   9: aload_1
    //   10: aload_0
    //   11: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   14: invokevirtual getObjectVariableValue : (Ljava/lang/Object;)I
    //   17: istore #4
    //   19: aload_1
    //   20: aload_0
    //   21: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   24: invokevirtual getObjectVariableValue : (Ljava/lang/Object;)I
    //   27: istore #5
    //   29: aload_1
    //   30: aload_0
    //   31: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   34: invokevirtual getObjectVariableValue : (Ljava/lang/Object;)I
    //   37: istore #6
    //   39: iload #5
    //   41: iload_3
    //   42: isub
    //   43: iflt -> 115
    //   46: iload #6
    //   48: iload #4
    //   50: isub
    //   51: iflt -> 115
    //   54: iload_3
    //   55: ldc_w -2147483648
    //   58: if_icmpeq -> 115
    //   61: iload_3
    //   62: ldc 2147483647
    //   64: if_icmpeq -> 115
    //   67: iload #4
    //   69: ldc_w -2147483648
    //   72: if_icmpeq -> 115
    //   75: iload #4
    //   77: ldc 2147483647
    //   79: if_icmpeq -> 115
    //   82: iload #5
    //   84: ldc_w -2147483648
    //   87: if_icmpeq -> 115
    //   90: iload #5
    //   92: ldc 2147483647
    //   94: if_icmpeq -> 115
    //   97: iload #6
    //   99: ldc_w -2147483648
    //   102: if_icmpeq -> 115
    //   105: iload #6
    //   107: istore_2
    //   108: iload #6
    //   110: ldc 2147483647
    //   112: if_icmpne -> 125
    //   115: iconst_0
    //   116: istore_2
    //   117: iconst_0
    //   118: istore_3
    //   119: iconst_0
    //   120: istore #4
    //   122: iconst_0
    //   123: istore #5
    //   125: aload_0
    //   126: iload_3
    //   127: iload #4
    //   129: iload #5
    //   131: iload_2
    //   132: invokevirtual setFrame : (IIII)V
    //   135: return
  }
  
  public void updateResolutionNodes() {
    for (int i = 0; i < 6; i++)
      this.y[i].getResolutionNode().update(); 
  }
  
  public enum ContentAlignment {
    BEGIN, BOTTOM, END, LEFT, MIDDLE, RIGHT, TOP, VERTICAL_MIDDLE;
    
    static {
      BOTTOM = new ContentAlignment("BOTTOM", 5);
      LEFT = new ContentAlignment("LEFT", 6);
      RIGHT = new ContentAlignment("RIGHT", 7);
      a = new ContentAlignment[] { BEGIN, MIDDLE, END, TOP, VERTICAL_MIDDLE, BOTTOM, LEFT, RIGHT };
    }
  }
  
  public enum DimensionBehaviour {
    FIXED, MATCH_CONSTRAINT, MATCH_PARENT, WRAP_CONTENT;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ConstraintWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */