package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;

public class Barrier extends Helper {
  public static final int BOTTOM = 3;
  
  public static final int LEFT = 0;
  
  public static final int RIGHT = 1;
  
  public static final int TOP = 2;
  
  private int ah = 0;
  
  private ArrayList<ResolutionAnchor> ai = new ArrayList<ResolutionAnchor>(4);
  
  private boolean aj = true;
  
  public void addToSolver(LinearSystem paramLinearSystem) {
    // Byte code:
    //   0: aload_0
    //   1: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   4: iconst_0
    //   5: aload_0
    //   6: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   9: aastore
    //   10: aload_0
    //   11: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   14: iconst_2
    //   15: aload_0
    //   16: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   19: aastore
    //   20: aload_0
    //   21: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   24: iconst_1
    //   25: aload_0
    //   26: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   29: aastore
    //   30: aload_0
    //   31: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   34: iconst_3
    //   35: aload_0
    //   36: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   39: aastore
    //   40: iconst_0
    //   41: istore_2
    //   42: iload_2
    //   43: aload_0
    //   44: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   47: arraylength
    //   48: if_icmpge -> 77
    //   51: aload_0
    //   52: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   55: iload_2
    //   56: aaload
    //   57: aload_1
    //   58: aload_0
    //   59: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   62: iload_2
    //   63: aaload
    //   64: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   67: putfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   70: iload_2
    //   71: iconst_1
    //   72: iadd
    //   73: istore_2
    //   74: goto -> 42
    //   77: aload_0
    //   78: getfield ah : I
    //   81: istore_2
    //   82: iload_2
    //   83: iflt -> 609
    //   86: iload_2
    //   87: iconst_4
    //   88: if_icmpge -> 609
    //   91: aload_0
    //   92: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   95: aload_0
    //   96: getfield ah : I
    //   99: aaload
    //   100: astore #5
    //   102: iconst_0
    //   103: istore_2
    //   104: iload_2
    //   105: aload_0
    //   106: getfield ag : I
    //   109: if_icmpge -> 205
    //   112: aload_0
    //   113: getfield af : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   116: iload_2
    //   117: aaload
    //   118: astore #6
    //   120: aload_0
    //   121: getfield aj : Z
    //   124: ifne -> 138
    //   127: aload #6
    //   129: invokevirtual allowedInBarrier : ()Z
    //   132: ifne -> 138
    //   135: goto -> 198
    //   138: aload_0
    //   139: getfield ah : I
    //   142: istore_3
    //   143: iload_3
    //   144: ifeq -> 152
    //   147: iload_3
    //   148: iconst_1
    //   149: if_icmpne -> 169
    //   152: aload #6
    //   154: invokevirtual getHorizontalDimensionBehaviour : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   157: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   160: if_acmpne -> 169
    //   163: iconst_1
    //   164: istore #4
    //   166: goto -> 208
    //   169: aload_0
    //   170: getfield ah : I
    //   173: istore_3
    //   174: iload_3
    //   175: iconst_2
    //   176: if_icmpeq -> 184
    //   179: iload_3
    //   180: iconst_3
    //   181: if_icmpne -> 198
    //   184: aload #6
    //   186: invokevirtual getVerticalDimensionBehaviour : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   189: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   192: if_acmpne -> 198
    //   195: goto -> 163
    //   198: iload_2
    //   199: iconst_1
    //   200: iadd
    //   201: istore_2
    //   202: goto -> 104
    //   205: iconst_0
    //   206: istore #4
    //   208: aload_0
    //   209: getfield ah : I
    //   212: istore_2
    //   213: iload_2
    //   214: ifeq -> 241
    //   217: iload_2
    //   218: iconst_1
    //   219: if_icmpne -> 225
    //   222: goto -> 241
    //   225: aload_0
    //   226: invokevirtual getParent : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   229: invokevirtual getVerticalDimensionBehaviour : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   232: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   235: if_acmpne -> 257
    //   238: goto -> 254
    //   241: aload_0
    //   242: invokevirtual getParent : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   245: invokevirtual getHorizontalDimensionBehaviour : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   248: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   251: if_acmpne -> 257
    //   254: iconst_0
    //   255: istore #4
    //   257: iconst_0
    //   258: istore_2
    //   259: iload_2
    //   260: aload_0
    //   261: getfield ag : I
    //   264: if_icmpge -> 378
    //   267: aload_0
    //   268: getfield af : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   271: iload_2
    //   272: aaload
    //   273: astore #7
    //   275: aload_0
    //   276: getfield aj : Z
    //   279: ifne -> 293
    //   282: aload #7
    //   284: invokevirtual allowedInBarrier : ()Z
    //   287: ifne -> 293
    //   290: goto -> 371
    //   293: aload_1
    //   294: aload #7
    //   296: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   299: aload_0
    //   300: getfield ah : I
    //   303: aaload
    //   304: invokevirtual createObjectVariable : (Ljava/lang/Object;)Landroidx/constraintlayout/solver/SolverVariable;
    //   307: astore #6
    //   309: aload #7
    //   311: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   314: astore #7
    //   316: aload_0
    //   317: getfield ah : I
    //   320: istore_3
    //   321: aload #7
    //   323: iload_3
    //   324: aaload
    //   325: aload #6
    //   327: putfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   330: iload_3
    //   331: ifeq -> 358
    //   334: iload_3
    //   335: iconst_2
    //   336: if_icmpne -> 342
    //   339: goto -> 358
    //   342: aload_1
    //   343: aload #5
    //   345: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   348: aload #6
    //   350: iload #4
    //   352: invokevirtual addGreaterBarrier : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Z)V
    //   355: goto -> 371
    //   358: aload_1
    //   359: aload #5
    //   361: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   364: aload #6
    //   366: iload #4
    //   368: invokevirtual addLowerBarrier : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;Z)V
    //   371: iload_2
    //   372: iconst_1
    //   373: iadd
    //   374: istore_2
    //   375: goto -> 259
    //   378: aload_0
    //   379: getfield ah : I
    //   382: istore_2
    //   383: iload_2
    //   384: ifne -> 439
    //   387: aload_1
    //   388: aload_0
    //   389: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   392: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   395: aload_0
    //   396: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   399: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   402: iconst_0
    //   403: bipush #6
    //   405: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   408: pop
    //   409: iload #4
    //   411: ifne -> 609
    //   414: aload_1
    //   415: aload_0
    //   416: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   419: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   422: aload_0
    //   423: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   426: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   429: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   432: iconst_0
    //   433: iconst_5
    //   434: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   437: pop
    //   438: return
    //   439: iload_2
    //   440: iconst_1
    //   441: if_icmpne -> 496
    //   444: aload_1
    //   445: aload_0
    //   446: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   449: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   452: aload_0
    //   453: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   456: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   459: iconst_0
    //   460: bipush #6
    //   462: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   465: pop
    //   466: iload #4
    //   468: ifne -> 609
    //   471: aload_1
    //   472: aload_0
    //   473: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   476: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   479: aload_0
    //   480: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   483: getfield q : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   486: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   489: iconst_0
    //   490: iconst_5
    //   491: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   494: pop
    //   495: return
    //   496: iload_2
    //   497: iconst_2
    //   498: if_icmpne -> 553
    //   501: aload_1
    //   502: aload_0
    //   503: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   506: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   509: aload_0
    //   510: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   513: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   516: iconst_0
    //   517: bipush #6
    //   519: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   522: pop
    //   523: iload #4
    //   525: ifne -> 609
    //   528: aload_1
    //   529: aload_0
    //   530: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   533: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   536: aload_0
    //   537: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   540: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   543: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   546: iconst_0
    //   547: iconst_5
    //   548: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   551: pop
    //   552: return
    //   553: iload_2
    //   554: iconst_3
    //   555: if_icmpne -> 609
    //   558: aload_1
    //   559: aload_0
    //   560: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   563: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   566: aload_0
    //   567: getfield t : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   570: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   573: iconst_0
    //   574: bipush #6
    //   576: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   579: pop
    //   580: iload #4
    //   582: ifne -> 609
    //   585: aload_1
    //   586: aload_0
    //   587: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   590: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   593: aload_0
    //   594: getfield B : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   597: getfield r : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   600: getfield e : Landroidx/constraintlayout/solver/SolverVariable;
    //   603: iconst_0
    //   604: iconst_5
    //   605: invokevirtual addEquality : (Landroidx/constraintlayout/solver/SolverVariable;Landroidx/constraintlayout/solver/SolverVariable;II)Landroidx/constraintlayout/solver/ArrayRow;
    //   608: pop
    //   609: return
  }
  
  public boolean allowedInBarrier() {
    return true;
  }
  
  public boolean allowsGoneWidget() {
    return this.aj;
  }
  
  public void analyze(int paramInt) {
    ResolutionAnchor resolutionAnchor;
    if (this.B == null)
      return; 
    if (!((ConstraintWidgetContainer)this.B).optimizeFor(2))
      return; 
    paramInt = this.ah;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3)
            return; 
          resolutionAnchor = this.t.getResolutionNode();
        } else {
          resolutionAnchor = this.r.getResolutionNode();
        } 
      } else {
        resolutionAnchor = this.s.getResolutionNode();
      } 
    } else {
      resolutionAnchor = this.q.getResolutionNode();
    } 
    resolutionAnchor.setType(5);
    paramInt = this.ah;
    if (paramInt == 0 || paramInt == 1) {
      this.r.getResolutionNode().resolve((ResolutionAnchor)null, 0.0F);
      this.t.getResolutionNode().resolve((ResolutionAnchor)null, 0.0F);
    } else {
      this.q.getResolutionNode().resolve((ResolutionAnchor)null, 0.0F);
      this.s.getResolutionNode().resolve((ResolutionAnchor)null, 0.0F);
    } 
    this.ai.clear();
    for (paramInt = 0; paramInt < this.ag; paramInt++) {
      ConstraintWidget constraintWidget = this.af[paramInt];
      if (this.aj || constraintWidget.allowedInBarrier()) {
        ResolutionAnchor resolutionAnchor1;
        int i = this.ah;
        if (i != 0) {
          if (i != 1) {
            if (i != 2) {
              if (i != 3) {
                constraintWidget = null;
              } else {
                resolutionAnchor1 = constraintWidget.t.getResolutionNode();
              } 
            } else {
              resolutionAnchor1 = ((ConstraintWidget)resolutionAnchor1).r.getResolutionNode();
            } 
          } else {
            resolutionAnchor1 = ((ConstraintWidget)resolutionAnchor1).s.getResolutionNode();
          } 
        } else {
          resolutionAnchor1 = ((ConstraintWidget)resolutionAnchor1).q.getResolutionNode();
        } 
        if (resolutionAnchor1 != null) {
          this.ai.add(resolutionAnchor1);
          resolutionAnchor1.addDependent(resolutionAnchor);
        } 
      } 
    } 
  }
  
  public void resetResolutionNodes() {
    super.resetResolutionNodes();
    this.ai.clear();
  }
  
  public void resolve() {
    int i = this.ah;
    float f1 = Float.MAX_VALUE;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          ResolutionAnchor resolutionAnchor = this.t.getResolutionNode();
        } else {
          ResolutionAnchor resolutionAnchor = this.r.getResolutionNode();
          int k = this.ai.size();
          Object object1 = null;
          i = 0;
          float f = f1;
        } 
      } else {
        ResolutionAnchor resolutionAnchor = this.s.getResolutionNode();
      } 
      f1 = 0.0F;
    } else {
      ResolutionAnchor resolutionAnchor = this.q.getResolutionNode();
    } 
    int j = this.ai.size();
    Object object = null;
    i = 0;
    float f2 = f1;
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean) {
    this.aj = paramBoolean;
  }
  
  public void setBarrierType(int paramInt) {
    this.ah = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\Barrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */