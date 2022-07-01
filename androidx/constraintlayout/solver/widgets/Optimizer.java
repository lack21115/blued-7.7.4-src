package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

public class Optimizer {
  public static final int OPTIMIZATION_BARRIER = 2;
  
  public static final int OPTIMIZATION_CHAIN = 4;
  
  public static final int OPTIMIZATION_DIMENSIONS = 8;
  
  public static final int OPTIMIZATION_DIRECT = 1;
  
  public static final int OPTIMIZATION_GROUPS = 32;
  
  public static final int OPTIMIZATION_NONE = 0;
  
  public static final int OPTIMIZATION_RATIO = 16;
  
  public static final int OPTIMIZATION_STANDARD = 7;
  
  static boolean[] a = new boolean[3];
  
  static void a(int paramInt, ConstraintWidget paramConstraintWidget) {
    int i;
    paramConstraintWidget.updateResolutionNodes();
    ResolutionAnchor resolutionAnchor1 = paramConstraintWidget.q.getResolutionNode();
    ResolutionAnchor resolutionAnchor2 = paramConstraintWidget.r.getResolutionNode();
    ResolutionAnchor resolutionAnchor3 = paramConstraintWidget.s.getResolutionNode();
    ResolutionAnchor resolutionAnchor4 = paramConstraintWidget.t.getResolutionNode();
    if ((paramInt & 0x8) == 8) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (paramConstraintWidget.A[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && a(paramConstraintWidget, 0)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (resolutionAnchor1.g != 4 && resolutionAnchor3.g != 4)
      if (paramConstraintWidget.A[0] == ConstraintWidget.DimensionBehaviour.FIXED || (i && paramConstraintWidget.getVisibility() == 8)) {
        if (paramConstraintWidget.q.c == null && paramConstraintWidget.s.c == null) {
          resolutionAnchor1.setType(1);
          resolutionAnchor3.setType(1);
          if (paramInt != 0) {
            resolutionAnchor3.dependsOn(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor3.dependsOn(resolutionAnchor1, paramConstraintWidget.getWidth());
          } 
        } else if (paramConstraintWidget.q.c != null && paramConstraintWidget.s.c == null) {
          resolutionAnchor1.setType(1);
          resolutionAnchor3.setType(1);
          if (paramInt != 0) {
            resolutionAnchor3.dependsOn(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor3.dependsOn(resolutionAnchor1, paramConstraintWidget.getWidth());
          } 
        } else if (paramConstraintWidget.q.c == null && paramConstraintWidget.s.c != null) {
          resolutionAnchor1.setType(1);
          resolutionAnchor3.setType(1);
          resolutionAnchor1.dependsOn(resolutionAnchor3, -paramConstraintWidget.getWidth());
          if (paramInt != 0) {
            resolutionAnchor1.dependsOn(resolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor1.dependsOn(resolutionAnchor3, -paramConstraintWidget.getWidth());
          } 
        } else if (paramConstraintWidget.q.c != null && paramConstraintWidget.s.c != null) {
          resolutionAnchor1.setType(2);
          resolutionAnchor3.setType(2);
          if (paramInt != 0) {
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor1);
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor3);
            resolutionAnchor1.setOpposite(resolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
            resolutionAnchor3.setOpposite(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor1.setOpposite(resolutionAnchor3, -paramConstraintWidget.getWidth());
            resolutionAnchor3.setOpposite(resolutionAnchor1, paramConstraintWidget.getWidth());
          } 
        } 
      } else if (i) {
        i = paramConstraintWidget.getWidth();
        resolutionAnchor1.setType(1);
        resolutionAnchor3.setType(1);
        if (paramConstraintWidget.q.c == null && paramConstraintWidget.s.c == null) {
          if (paramInt != 0) {
            resolutionAnchor3.dependsOn(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor3.dependsOn(resolutionAnchor1, i);
          } 
        } else if (paramConstraintWidget.q.c != null && paramConstraintWidget.s.c == null) {
          if (paramInt != 0) {
            resolutionAnchor3.dependsOn(resolutionAnchor1, 1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor3.dependsOn(resolutionAnchor1, i);
          } 
        } else if (paramConstraintWidget.q.c == null && paramConstraintWidget.s.c != null) {
          if (paramInt != 0) {
            resolutionAnchor1.dependsOn(resolutionAnchor3, -1, paramConstraintWidget.getResolutionWidth());
          } else {
            resolutionAnchor1.dependsOn(resolutionAnchor3, -i);
          } 
        } else if (paramConstraintWidget.q.c != null && paramConstraintWidget.s.c != null) {
          if (paramInt != 0) {
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor1);
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor3);
          } 
          if (paramConstraintWidget.E == 0.0F) {
            resolutionAnchor1.setType(3);
            resolutionAnchor3.setType(3);
            resolutionAnchor1.setOpposite(resolutionAnchor3, 0.0F);
            resolutionAnchor3.setOpposite(resolutionAnchor1, 0.0F);
          } else {
            resolutionAnchor1.setType(2);
            resolutionAnchor3.setType(2);
            resolutionAnchor1.setOpposite(resolutionAnchor3, -i);
            resolutionAnchor3.setOpposite(resolutionAnchor1, i);
            paramConstraintWidget.setWidth(i);
          } 
        } 
      }  
    if (paramConstraintWidget.A[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && a(paramConstraintWidget, 1)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (resolutionAnchor2.g != 4 && resolutionAnchor4.g != 4) {
      if (paramConstraintWidget.A[1] == ConstraintWidget.DimensionBehaviour.FIXED || (i != 0 && paramConstraintWidget.getVisibility() == 8)) {
        if (paramConstraintWidget.r.c == null && paramConstraintWidget.t.c == null) {
          resolutionAnchor2.setType(1);
          resolutionAnchor4.setType(1);
          if (paramInt != 0) {
            resolutionAnchor4.dependsOn(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor4.dependsOn(resolutionAnchor2, paramConstraintWidget.getHeight());
          } 
          if (paramConstraintWidget.u.c != null) {
            paramConstraintWidget.u.getResolutionNode().setType(1);
            resolutionAnchor2.dependsOn(1, paramConstraintWidget.u.getResolutionNode(), -paramConstraintWidget.M);
            return;
          } 
        } else if (paramConstraintWidget.r.c != null && paramConstraintWidget.t.c == null) {
          resolutionAnchor2.setType(1);
          resolutionAnchor4.setType(1);
          if (paramInt != 0) {
            resolutionAnchor4.dependsOn(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor4.dependsOn(resolutionAnchor2, paramConstraintWidget.getHeight());
          } 
          if (paramConstraintWidget.M > 0) {
            paramConstraintWidget.u.getResolutionNode().dependsOn(1, resolutionAnchor2, paramConstraintWidget.M);
            return;
          } 
        } else if (paramConstraintWidget.r.c == null && paramConstraintWidget.t.c != null) {
          resolutionAnchor2.setType(1);
          resolutionAnchor4.setType(1);
          if (paramInt != 0) {
            resolutionAnchor2.dependsOn(resolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
          } else {
            resolutionAnchor2.dependsOn(resolutionAnchor4, -paramConstraintWidget.getHeight());
          } 
          if (paramConstraintWidget.M > 0) {
            paramConstraintWidget.u.getResolutionNode().dependsOn(1, resolutionAnchor2, paramConstraintWidget.M);
            return;
          } 
        } else if (paramConstraintWidget.r.c != null && paramConstraintWidget.t.c != null) {
          resolutionAnchor2.setType(2);
          resolutionAnchor4.setType(2);
          if (paramInt != 0) {
            resolutionAnchor2.setOpposite(resolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
            resolutionAnchor4.setOpposite(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
            paramConstraintWidget.getResolutionHeight().addDependent(resolutionAnchor2);
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor4);
          } else {
            resolutionAnchor2.setOpposite(resolutionAnchor4, -paramConstraintWidget.getHeight());
            resolutionAnchor4.setOpposite(resolutionAnchor2, paramConstraintWidget.getHeight());
          } 
          if (paramConstraintWidget.M > 0)
            paramConstraintWidget.u.getResolutionNode().dependsOn(1, resolutionAnchor2, paramConstraintWidget.M); 
        } 
        return;
      } 
      if (i != 0) {
        i = paramConstraintWidget.getHeight();
        resolutionAnchor2.setType(1);
        resolutionAnchor4.setType(1);
        if (paramConstraintWidget.r.c == null && paramConstraintWidget.t.c == null) {
          if (paramInt != 0) {
            resolutionAnchor4.dependsOn(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
            return;
          } 
          resolutionAnchor4.dependsOn(resolutionAnchor2, i);
          return;
        } 
        if (paramConstraintWidget.r.c != null && paramConstraintWidget.t.c == null) {
          if (paramInt != 0) {
            resolutionAnchor4.dependsOn(resolutionAnchor2, 1, paramConstraintWidget.getResolutionHeight());
            return;
          } 
          resolutionAnchor4.dependsOn(resolutionAnchor2, i);
          return;
        } 
        if (paramConstraintWidget.r.c == null && paramConstraintWidget.t.c != null) {
          if (paramInt != 0) {
            resolutionAnchor2.dependsOn(resolutionAnchor4, -1, paramConstraintWidget.getResolutionHeight());
            return;
          } 
          resolutionAnchor2.dependsOn(resolutionAnchor4, -i);
          return;
        } 
        if (paramConstraintWidget.r.c != null && paramConstraintWidget.t.c != null) {
          if (paramInt != 0) {
            paramConstraintWidget.getResolutionHeight().addDependent(resolutionAnchor2);
            paramConstraintWidget.getResolutionWidth().addDependent(resolutionAnchor4);
          } 
          if (paramConstraintWidget.E == 0.0F) {
            resolutionAnchor2.setType(3);
            resolutionAnchor4.setType(3);
            resolutionAnchor2.setOpposite(resolutionAnchor4, 0.0F);
            resolutionAnchor4.setOpposite(resolutionAnchor2, 0.0F);
            return;
          } 
          resolutionAnchor2.setType(2);
          resolutionAnchor4.setType(2);
          resolutionAnchor2.setOpposite(resolutionAnchor4, -i);
          resolutionAnchor4.setOpposite(resolutionAnchor2, i);
          paramConstraintWidget.setHeight(i);
          if (paramConstraintWidget.M > 0) {
            paramConstraintWidget.u.getResolutionNode().dependsOn(1, resolutionAnchor2, paramConstraintWidget.M);
            return;
          } 
        } 
      } 
    } 
  }
  
  static void a(ConstraintWidget paramConstraintWidget, int paramInt1, int paramInt2) {
    int i = paramInt1 * 2;
    int j = i + 1;
    (paramConstraintWidget.y[i].getResolutionNode()).e = (paramConstraintWidget.getParent()).q.getResolutionNode();
    (paramConstraintWidget.y[i].getResolutionNode()).f = paramInt2;
    (paramConstraintWidget.y[i].getResolutionNode()).i = 1;
    (paramConstraintWidget.y[j].getResolutionNode()).e = paramConstraintWidget.y[i].getResolutionNode();
    (paramConstraintWidget.y[j].getResolutionNode()).f = paramConstraintWidget.getLength(paramInt1);
    (paramConstraintWidget.y[j].getResolutionNode()).i = 1;
  }
  
  static void a(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget) {
    if (paramConstraintWidgetContainer.A[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && paramConstraintWidget.A[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
      int i = paramConstraintWidget.q.mMargin;
      int j = paramConstraintWidgetContainer.getWidth() - paramConstraintWidget.s.mMargin;
      paramConstraintWidget.q.e = paramLinearSystem.createObjectVariable(paramConstraintWidget.q);
      paramConstraintWidget.s.e = paramLinearSystem.createObjectVariable(paramConstraintWidget.s);
      paramLinearSystem.addEquality(paramConstraintWidget.q.e, i);
      paramLinearSystem.addEquality(paramConstraintWidget.s.e, j);
      paramConstraintWidget.mHorizontalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(i, j);
    } 
    if (paramConstraintWidgetContainer.A[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && paramConstraintWidget.A[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
      int i = paramConstraintWidget.r.mMargin;
      int j = paramConstraintWidgetContainer.getHeight() - paramConstraintWidget.t.mMargin;
      paramConstraintWidget.r.e = paramLinearSystem.createObjectVariable(paramConstraintWidget.r);
      paramConstraintWidget.t.e = paramLinearSystem.createObjectVariable(paramConstraintWidget.t);
      paramLinearSystem.addEquality(paramConstraintWidget.r.e, i);
      paramLinearSystem.addEquality(paramConstraintWidget.t.e, j);
      if (paramConstraintWidget.M > 0 || paramConstraintWidget.getVisibility() == 8) {
        paramConstraintWidget.u.e = paramLinearSystem.createObjectVariable(paramConstraintWidget.u);
        paramLinearSystem.addEquality(paramConstraintWidget.u.e, paramConstraintWidget.M + i);
      } 
      paramConstraintWidget.mVerticalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i, j);
    } 
  }
  
  private static boolean a(ConstraintWidget paramConstraintWidget, int paramInt) {
    ConstraintWidget.DimensionBehaviour[] arrayOfDimensionBehaviour;
    if (paramConstraintWidget.A[paramInt] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      return false; 
    float f = paramConstraintWidget.E;
    boolean bool = true;
    if (f != 0.0F) {
      arrayOfDimensionBehaviour = paramConstraintWidget.A;
      if (paramInt == 0) {
        paramInt = bool;
      } else {
        paramInt = 0;
      } 
      if (arrayOfDimensionBehaviour[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
      return false;
    } 
    if (paramInt == 0) {
      if (((ConstraintWidget)arrayOfDimensionBehaviour).c != 0)
        return false; 
      if (((ConstraintWidget)arrayOfDimensionBehaviour).f != 0 || ((ConstraintWidget)arrayOfDimensionBehaviour).g != 0)
        return false; 
    } else {
      return (((ConstraintWidget)arrayOfDimensionBehaviour).d != 0) ? false : ((((ConstraintWidget)arrayOfDimensionBehaviour).i == 0) ? (!(((ConstraintWidget)arrayOfDimensionBehaviour).j != 0)) : false);
    } 
    return true;
  }
  
  static boolean a(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt1, int paramInt2, ChainHead paramChainHead) {
    // Byte code:
    //   0: aload #4
    //   2: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   5: astore #19
    //   7: aload #4
    //   9: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   12: astore #20
    //   14: aload #4
    //   16: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   19: astore #22
    //   21: aload #4
    //   23: getfield d : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   26: astore #23
    //   28: aload #4
    //   30: getfield e : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   33: astore #21
    //   35: aload #4
    //   37: getfield k : F
    //   40: fstore #11
    //   42: aload #4
    //   44: getfield f : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   47: astore #24
    //   49: aload #4
    //   51: getfield g : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   54: astore #4
    //   56: aload_0
    //   57: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   60: iload_2
    //   61: aaload
    //   62: astore_0
    //   63: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   66: astore_0
    //   67: iload_2
    //   68: ifne -> 151
    //   71: aload #21
    //   73: getfield W : I
    //   76: ifne -> 85
    //   79: iconst_1
    //   80: istore #12
    //   82: goto -> 88
    //   85: iconst_0
    //   86: istore #12
    //   88: aload #21
    //   90: getfield W : I
    //   93: iconst_1
    //   94: if_icmpne -> 103
    //   97: iconst_1
    //   98: istore #13
    //   100: goto -> 106
    //   103: iconst_0
    //   104: istore #13
    //   106: iload #12
    //   108: istore #15
    //   110: iload #13
    //   112: istore #14
    //   114: aload #21
    //   116: getfield W : I
    //   119: iconst_2
    //   120: if_icmpne -> 141
    //   123: iload #13
    //   125: istore #14
    //   127: iload #12
    //   129: istore #15
    //   131: iconst_1
    //   132: istore #12
    //   134: iload #15
    //   136: istore #13
    //   138: goto -> 214
    //   141: iconst_0
    //   142: istore #12
    //   144: iload #15
    //   146: istore #13
    //   148: goto -> 214
    //   151: aload #21
    //   153: getfield X : I
    //   156: ifne -> 165
    //   159: iconst_1
    //   160: istore #12
    //   162: goto -> 168
    //   165: iconst_0
    //   166: istore #12
    //   168: aload #21
    //   170: getfield X : I
    //   173: iconst_1
    //   174: if_icmpne -> 183
    //   177: iconst_1
    //   178: istore #13
    //   180: goto -> 186
    //   183: iconst_0
    //   184: istore #13
    //   186: iload #12
    //   188: istore #15
    //   190: iload #13
    //   192: istore #14
    //   194: aload #21
    //   196: getfield X : I
    //   199: iconst_2
    //   200: if_icmpne -> 141
    //   203: iload #12
    //   205: istore #15
    //   207: iload #13
    //   209: istore #14
    //   211: goto -> 131
    //   214: aload #19
    //   216: astore #4
    //   218: iconst_0
    //   219: istore #16
    //   221: iconst_0
    //   222: istore #17
    //   224: iconst_0
    //   225: istore #15
    //   227: fconst_0
    //   228: fstore #9
    //   230: fconst_0
    //   231: fstore #7
    //   233: iload #17
    //   235: ifne -> 605
    //   238: iload #15
    //   240: istore #18
    //   242: fload #9
    //   244: fstore #5
    //   246: fload #7
    //   248: fstore #6
    //   250: aload #4
    //   252: invokevirtual getVisibility : ()I
    //   255: bipush #8
    //   257: if_icmpeq -> 381
    //   260: iload #15
    //   262: iconst_1
    //   263: iadd
    //   264: istore #18
    //   266: iload_2
    //   267: ifne -> 280
    //   270: aload #4
    //   272: invokevirtual getWidth : ()I
    //   275: istore #15
    //   277: goto -> 287
    //   280: aload #4
    //   282: invokevirtual getHeight : ()I
    //   285: istore #15
    //   287: fload #9
    //   289: iload #15
    //   291: i2f
    //   292: fadd
    //   293: fstore #5
    //   295: fload #5
    //   297: fstore #6
    //   299: aload #4
    //   301: aload #22
    //   303: if_acmpeq -> 322
    //   306: fload #5
    //   308: aload #4
    //   310: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   313: iload_3
    //   314: aaload
    //   315: invokevirtual getMargin : ()I
    //   318: i2f
    //   319: fadd
    //   320: fstore #6
    //   322: fload #6
    //   324: fstore #5
    //   326: aload #4
    //   328: aload #23
    //   330: if_acmpeq -> 351
    //   333: fload #6
    //   335: aload #4
    //   337: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   340: iload_3
    //   341: iconst_1
    //   342: iadd
    //   343: aaload
    //   344: invokevirtual getMargin : ()I
    //   347: i2f
    //   348: fadd
    //   349: fstore #5
    //   351: fload #7
    //   353: aload #4
    //   355: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   358: iload_3
    //   359: aaload
    //   360: invokevirtual getMargin : ()I
    //   363: i2f
    //   364: fadd
    //   365: aload #4
    //   367: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   370: iload_3
    //   371: iconst_1
    //   372: iadd
    //   373: aaload
    //   374: invokevirtual getMargin : ()I
    //   377: i2f
    //   378: fadd
    //   379: fstore #6
    //   381: aload #4
    //   383: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   386: iload_3
    //   387: aaload
    //   388: astore_0
    //   389: iload #16
    //   391: istore #15
    //   393: aload #4
    //   395: invokevirtual getVisibility : ()I
    //   398: bipush #8
    //   400: if_icmpeq -> 498
    //   403: iload #16
    //   405: istore #15
    //   407: aload #4
    //   409: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   412: iload_2
    //   413: aaload
    //   414: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   417: if_acmpne -> 498
    //   420: iload #16
    //   422: iconst_1
    //   423: iadd
    //   424: istore #15
    //   426: iload_2
    //   427: ifne -> 458
    //   430: aload #4
    //   432: getfield c : I
    //   435: ifeq -> 440
    //   438: iconst_0
    //   439: ireturn
    //   440: aload #4
    //   442: getfield f : I
    //   445: ifne -> 456
    //   448: aload #4
    //   450: getfield g : I
    //   453: ifeq -> 486
    //   456: iconst_0
    //   457: ireturn
    //   458: aload #4
    //   460: getfield d : I
    //   463: ifeq -> 468
    //   466: iconst_0
    //   467: ireturn
    //   468: aload #4
    //   470: getfield i : I
    //   473: ifne -> 496
    //   476: aload #4
    //   478: getfield j : I
    //   481: ifeq -> 486
    //   484: iconst_0
    //   485: ireturn
    //   486: aload #4
    //   488: getfield E : F
    //   491: fconst_0
    //   492: fcmpl
    //   493: ifeq -> 498
    //   496: iconst_0
    //   497: ireturn
    //   498: aload #4
    //   500: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   503: iload_3
    //   504: iconst_1
    //   505: iadd
    //   506: aaload
    //   507: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   510: astore_0
    //   511: aload_0
    //   512: ifnull -> 555
    //   515: aload_0
    //   516: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   519: astore_0
    //   520: aload_0
    //   521: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   524: iload_3
    //   525: aaload
    //   526: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   529: ifnull -> 555
    //   532: aload_0
    //   533: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   536: iload_3
    //   537: aaload
    //   538: getfield c : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   541: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   544: aload #4
    //   546: if_acmpeq -> 552
    //   549: goto -> 555
    //   552: goto -> 557
    //   555: aconst_null
    //   556: astore_0
    //   557: aload_0
    //   558: ifnull -> 583
    //   561: iload #15
    //   563: istore #16
    //   565: aload_0
    //   566: astore #4
    //   568: iload #18
    //   570: istore #15
    //   572: fload #5
    //   574: fstore #9
    //   576: fload #6
    //   578: fstore #7
    //   580: goto -> 233
    //   583: iconst_1
    //   584: istore #17
    //   586: iload #15
    //   588: istore #16
    //   590: iload #18
    //   592: istore #15
    //   594: fload #5
    //   596: fstore #9
    //   598: fload #6
    //   600: fstore #7
    //   602: goto -> 233
    //   605: aload #19
    //   607: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   610: iload_3
    //   611: aaload
    //   612: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   615: astore #21
    //   617: aload #20
    //   619: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   622: astore_0
    //   623: iload_3
    //   624: iconst_1
    //   625: iadd
    //   626: istore #17
    //   628: aload_0
    //   629: iload #17
    //   631: aaload
    //   632: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   635: astore_0
    //   636: aload #21
    //   638: getfield c : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   641: ifnull -> 1862
    //   644: aload_0
    //   645: getfield c : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   648: ifnonnull -> 654
    //   651: goto -> 1862
    //   654: aload #21
    //   656: getfield c : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   659: getfield i : I
    //   662: iconst_1
    //   663: if_icmpne -> 1860
    //   666: aload_0
    //   667: getfield c : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   670: getfield i : I
    //   673: iconst_1
    //   674: if_icmpeq -> 680
    //   677: goto -> 1860
    //   680: iload #16
    //   682: ifle -> 694
    //   685: iload #16
    //   687: iload #15
    //   689: if_icmpeq -> 694
    //   692: iconst_0
    //   693: ireturn
    //   694: iload #12
    //   696: ifne -> 718
    //   699: iload #13
    //   701: ifne -> 718
    //   704: iload #14
    //   706: ifeq -> 712
    //   709: goto -> 718
    //   712: fconst_0
    //   713: fstore #5
    //   715: goto -> 768
    //   718: aload #22
    //   720: ifnull -> 739
    //   723: aload #22
    //   725: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   728: iload_3
    //   729: aaload
    //   730: invokevirtual getMargin : ()I
    //   733: i2f
    //   734: fstore #6
    //   736: goto -> 742
    //   739: fconst_0
    //   740: fstore #6
    //   742: fload #6
    //   744: fstore #5
    //   746: aload #23
    //   748: ifnull -> 768
    //   751: fload #6
    //   753: aload #23
    //   755: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   758: iload #17
    //   760: aaload
    //   761: invokevirtual getMargin : ()I
    //   764: i2f
    //   765: fadd
    //   766: fstore #5
    //   768: aload #21
    //   770: getfield c : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   773: getfield f : F
    //   776: fstore #8
    //   778: aload_0
    //   779: getfield c : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   782: getfield f : F
    //   785: fstore #6
    //   787: fload #8
    //   789: fload #6
    //   791: fcmpg
    //   792: ifge -> 805
    //   795: fload #6
    //   797: fload #8
    //   799: fsub
    //   800: fstore #6
    //   802: goto -> 812
    //   805: fload #8
    //   807: fload #6
    //   809: fsub
    //   810: fstore #6
    //   812: fload #6
    //   814: fload #9
    //   816: fsub
    //   817: fstore #10
    //   819: iload #16
    //   821: ifle -> 1138
    //   824: iload #16
    //   826: iload #15
    //   828: if_icmpne -> 1138
    //   831: aload #4
    //   833: invokevirtual getParent : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   836: ifnull -> 857
    //   839: aload #4
    //   841: invokevirtual getParent : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   844: getfield A : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   847: iload_2
    //   848: aaload
    //   849: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   852: if_acmpne -> 857
    //   855: iconst_0
    //   856: ireturn
    //   857: fload #10
    //   859: fload #9
    //   861: fadd
    //   862: fload #7
    //   864: fsub
    //   865: fstore #6
    //   867: aload #19
    //   869: astore_0
    //   870: aload_0
    //   871: ifnull -> 1136
    //   874: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   877: ifnull -> 931
    //   880: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   883: astore #4
    //   885: aload #4
    //   887: aload #4
    //   889: getfield nonresolvedWidgets : J
    //   892: lconst_1
    //   893: lsub
    //   894: putfield nonresolvedWidgets : J
    //   897: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   900: astore #4
    //   902: aload #4
    //   904: aload #4
    //   906: getfield resolvedWidgets : J
    //   909: lconst_1
    //   910: ladd
    //   911: putfield resolvedWidgets : J
    //   914: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   917: astore #4
    //   919: aload #4
    //   921: aload #4
    //   923: getfield chainConnectionResolved : J
    //   926: lconst_1
    //   927: ladd
    //   928: putfield chainConnectionResolved : J
    //   931: aload_0
    //   932: getfield ac : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   935: iload_2
    //   936: aaload
    //   937: astore #4
    //   939: aload #4
    //   941: ifnonnull -> 954
    //   944: fload #8
    //   946: fstore #5
    //   948: aload_0
    //   949: aload #20
    //   951: if_acmpne -> 1126
    //   954: fload #6
    //   956: iload #16
    //   958: i2f
    //   959: fdiv
    //   960: fstore #5
    //   962: fload #11
    //   964: fconst_0
    //   965: fcmpl
    //   966: ifle -> 1002
    //   969: aload_0
    //   970: getfield aa : [F
    //   973: iload_2
    //   974: faload
    //   975: ldc_w -1.0
    //   978: fcmpl
    //   979: ifne -> 988
    //   982: fconst_0
    //   983: fstore #5
    //   985: goto -> 1002
    //   988: aload_0
    //   989: getfield aa : [F
    //   992: iload_2
    //   993: faload
    //   994: fload #6
    //   996: fmul
    //   997: fload #11
    //   999: fdiv
    //   1000: fstore #5
    //   1002: aload_0
    //   1003: invokevirtual getVisibility : ()I
    //   1006: bipush #8
    //   1008: if_icmpne -> 1014
    //   1011: fconst_0
    //   1012: fstore #5
    //   1014: fload #8
    //   1016: aload_0
    //   1017: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1020: iload_3
    //   1021: aaload
    //   1022: invokevirtual getMargin : ()I
    //   1025: i2f
    //   1026: fadd
    //   1027: fstore #7
    //   1029: aload_0
    //   1030: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1033: iload_3
    //   1034: aaload
    //   1035: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1038: aload #21
    //   1040: getfield e : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1043: fload #7
    //   1045: invokevirtual resolve : (Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;F)V
    //   1048: aload_0
    //   1049: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1052: iload #17
    //   1054: aaload
    //   1055: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1058: astore #19
    //   1060: aload #21
    //   1062: getfield e : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1065: astore #22
    //   1067: fload #7
    //   1069: fload #5
    //   1071: fadd
    //   1072: fstore #5
    //   1074: aload #19
    //   1076: aload #22
    //   1078: fload #5
    //   1080: invokevirtual resolve : (Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;F)V
    //   1083: aload_0
    //   1084: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1087: iload_3
    //   1088: aaload
    //   1089: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1092: aload_1
    //   1093: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   1096: aload_0
    //   1097: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1100: iload #17
    //   1102: aaload
    //   1103: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1106: aload_1
    //   1107: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   1110: fload #5
    //   1112: aload_0
    //   1113: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1116: iload #17
    //   1118: aaload
    //   1119: invokevirtual getMargin : ()I
    //   1122: i2f
    //   1123: fadd
    //   1124: fstore #5
    //   1126: aload #4
    //   1128: astore_0
    //   1129: fload #5
    //   1131: fstore #8
    //   1133: goto -> 870
    //   1136: iconst_1
    //   1137: ireturn
    //   1138: fload #10
    //   1140: fconst_0
    //   1141: fcmpg
    //   1142: ifge -> 1154
    //   1145: iconst_1
    //   1146: istore #12
    //   1148: iconst_0
    //   1149: istore #13
    //   1151: iconst_0
    //   1152: istore #14
    //   1154: iload #12
    //   1156: ifeq -> 1408
    //   1159: aload #19
    //   1161: astore_0
    //   1162: fload #8
    //   1164: fload #10
    //   1166: fload #5
    //   1168: fsub
    //   1169: aload_0
    //   1170: iload_2
    //   1171: invokevirtual getBiasPercent : (I)F
    //   1174: fmul
    //   1175: fadd
    //   1176: fstore #5
    //   1178: aload_0
    //   1179: ifnull -> 1421
    //   1182: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   1185: ifnull -> 1239
    //   1188: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   1191: astore #4
    //   1193: aload #4
    //   1195: aload #4
    //   1197: getfield nonresolvedWidgets : J
    //   1200: lconst_1
    //   1201: lsub
    //   1202: putfield nonresolvedWidgets : J
    //   1205: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   1208: astore #4
    //   1210: aload #4
    //   1212: aload #4
    //   1214: getfield resolvedWidgets : J
    //   1217: lconst_1
    //   1218: ladd
    //   1219: putfield resolvedWidgets : J
    //   1222: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   1225: astore #4
    //   1227: aload #4
    //   1229: aload #4
    //   1231: getfield chainConnectionResolved : J
    //   1234: lconst_1
    //   1235: ladd
    //   1236: putfield chainConnectionResolved : J
    //   1239: aload_0
    //   1240: getfield ac : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   1243: iload_2
    //   1244: aaload
    //   1245: astore #4
    //   1247: aload #4
    //   1249: ifnonnull -> 1262
    //   1252: fload #5
    //   1254: fstore #6
    //   1256: aload_0
    //   1257: aload #20
    //   1259: if_acmpne -> 1398
    //   1262: iload_2
    //   1263: ifne -> 1275
    //   1266: aload_0
    //   1267: invokevirtual getWidth : ()I
    //   1270: istore #12
    //   1272: goto -> 1281
    //   1275: aload_0
    //   1276: invokevirtual getHeight : ()I
    //   1279: istore #12
    //   1281: iload #12
    //   1283: i2f
    //   1284: fstore #6
    //   1286: fload #5
    //   1288: aload_0
    //   1289: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1292: iload_3
    //   1293: aaload
    //   1294: invokevirtual getMargin : ()I
    //   1297: i2f
    //   1298: fadd
    //   1299: fstore #5
    //   1301: aload_0
    //   1302: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1305: iload_3
    //   1306: aaload
    //   1307: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1310: aload #21
    //   1312: getfield e : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1315: fload #5
    //   1317: invokevirtual resolve : (Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;F)V
    //   1320: aload_0
    //   1321: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1324: iload #17
    //   1326: aaload
    //   1327: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1330: astore #19
    //   1332: aload #21
    //   1334: getfield e : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1337: astore #22
    //   1339: fload #5
    //   1341: fload #6
    //   1343: fadd
    //   1344: fstore #5
    //   1346: aload #19
    //   1348: aload #22
    //   1350: fload #5
    //   1352: invokevirtual resolve : (Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;F)V
    //   1355: aload_0
    //   1356: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1359: iload_3
    //   1360: aaload
    //   1361: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1364: aload_1
    //   1365: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   1368: aload_0
    //   1369: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1372: iload #17
    //   1374: aaload
    //   1375: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1378: aload_1
    //   1379: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   1382: fload #5
    //   1384: aload_0
    //   1385: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1388: iload #17
    //   1390: aaload
    //   1391: invokevirtual getMargin : ()I
    //   1394: i2f
    //   1395: fadd
    //   1396: fstore #6
    //   1398: aload #4
    //   1400: astore_0
    //   1401: fload #6
    //   1403: fstore #5
    //   1405: goto -> 1178
    //   1408: iload #13
    //   1410: ifne -> 1423
    //   1413: iload #14
    //   1415: ifeq -> 1421
    //   1418: goto -> 1423
    //   1421: iconst_1
    //   1422: ireturn
    //   1423: iload #13
    //   1425: ifeq -> 1438
    //   1428: fload #10
    //   1430: fload #5
    //   1432: fsub
    //   1433: fstore #6
    //   1435: goto -> 1450
    //   1438: fload #10
    //   1440: fstore #6
    //   1442: iload #14
    //   1444: ifeq -> 1450
    //   1447: goto -> 1428
    //   1450: fload #6
    //   1452: iload #15
    //   1454: iconst_1
    //   1455: iadd
    //   1456: i2f
    //   1457: fdiv
    //   1458: fstore #7
    //   1460: iload #14
    //   1462: ifeq -> 1491
    //   1465: iload #15
    //   1467: iconst_1
    //   1468: if_icmple -> 1481
    //   1471: iload #15
    //   1473: iconst_1
    //   1474: isub
    //   1475: i2f
    //   1476: fstore #5
    //   1478: goto -> 1484
    //   1481: fconst_2
    //   1482: fstore #5
    //   1484: fload #6
    //   1486: fload #5
    //   1488: fdiv
    //   1489: fstore #7
    //   1491: aload #19
    //   1493: invokevirtual getVisibility : ()I
    //   1496: bipush #8
    //   1498: if_icmpeq -> 1511
    //   1501: fload #8
    //   1503: fload #7
    //   1505: fadd
    //   1506: fstore #5
    //   1508: goto -> 1515
    //   1511: fload #8
    //   1513: fstore #5
    //   1515: fload #5
    //   1517: fstore #6
    //   1519: iload #14
    //   1521: ifeq -> 1550
    //   1524: fload #5
    //   1526: fstore #6
    //   1528: iload #15
    //   1530: iconst_1
    //   1531: if_icmple -> 1550
    //   1534: aload #22
    //   1536: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1539: iload_3
    //   1540: aaload
    //   1541: invokevirtual getMargin : ()I
    //   1544: i2f
    //   1545: fload #8
    //   1547: fadd
    //   1548: fstore #6
    //   1550: aload #19
    //   1552: astore_0
    //   1553: fload #6
    //   1555: fstore #5
    //   1557: iload #13
    //   1559: ifeq -> 1593
    //   1562: aload #19
    //   1564: astore_0
    //   1565: fload #6
    //   1567: fstore #5
    //   1569: aload #22
    //   1571: ifnull -> 1593
    //   1574: fload #6
    //   1576: aload #22
    //   1578: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1581: iload_3
    //   1582: aaload
    //   1583: invokevirtual getMargin : ()I
    //   1586: i2f
    //   1587: fadd
    //   1588: fstore #5
    //   1590: aload #19
    //   1592: astore_0
    //   1593: aload_0
    //   1594: ifnull -> 1421
    //   1597: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   1600: ifnull -> 1654
    //   1603: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   1606: astore #4
    //   1608: aload #4
    //   1610: aload #4
    //   1612: getfield nonresolvedWidgets : J
    //   1615: lconst_1
    //   1616: lsub
    //   1617: putfield nonresolvedWidgets : J
    //   1620: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   1623: astore #4
    //   1625: aload #4
    //   1627: aload #4
    //   1629: getfield resolvedWidgets : J
    //   1632: lconst_1
    //   1633: ladd
    //   1634: putfield resolvedWidgets : J
    //   1637: getstatic androidx/constraintlayout/solver/LinearSystem.sMetrics : Landroidx/constraintlayout/solver/Metrics;
    //   1640: astore #4
    //   1642: aload #4
    //   1644: aload #4
    //   1646: getfield chainConnectionResolved : J
    //   1649: lconst_1
    //   1650: ladd
    //   1651: putfield chainConnectionResolved : J
    //   1654: aload_0
    //   1655: getfield ac : [Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   1658: iload_2
    //   1659: aaload
    //   1660: astore #4
    //   1662: aload #4
    //   1664: ifnonnull -> 1687
    //   1667: fload #5
    //   1669: fstore #6
    //   1671: aload_0
    //   1672: aload #20
    //   1674: if_acmpne -> 1680
    //   1677: goto -> 1687
    //   1680: fload #6
    //   1682: fstore #5
    //   1684: goto -> 1854
    //   1687: iload_2
    //   1688: ifne -> 1700
    //   1691: aload_0
    //   1692: invokevirtual getWidth : ()I
    //   1695: istore #12
    //   1697: goto -> 1706
    //   1700: aload_0
    //   1701: invokevirtual getHeight : ()I
    //   1704: istore #12
    //   1706: iload #12
    //   1708: i2f
    //   1709: fstore #8
    //   1711: fload #5
    //   1713: fstore #6
    //   1715: aload_0
    //   1716: aload #22
    //   1718: if_acmpeq -> 1736
    //   1721: fload #5
    //   1723: aload_0
    //   1724: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1727: iload_3
    //   1728: aaload
    //   1729: invokevirtual getMargin : ()I
    //   1732: i2f
    //   1733: fadd
    //   1734: fstore #6
    //   1736: aload_0
    //   1737: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1740: iload_3
    //   1741: aaload
    //   1742: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1745: aload #21
    //   1747: getfield e : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1750: fload #6
    //   1752: invokevirtual resolve : (Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;F)V
    //   1755: aload_0
    //   1756: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1759: iload #17
    //   1761: aaload
    //   1762: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1765: aload #21
    //   1767: getfield e : Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1770: fload #6
    //   1772: fload #8
    //   1774: fadd
    //   1775: invokevirtual resolve : (Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;F)V
    //   1778: aload_0
    //   1779: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1782: iload_3
    //   1783: aaload
    //   1784: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1787: aload_1
    //   1788: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   1791: aload_0
    //   1792: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1795: iload #17
    //   1797: aaload
    //   1798: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   1801: aload_1
    //   1802: invokevirtual a : (Landroidx/constraintlayout/solver/LinearSystem;)V
    //   1805: fload #6
    //   1807: fload #8
    //   1809: aload_0
    //   1810: getfield y : [Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   1813: iload #17
    //   1815: aaload
    //   1816: invokevirtual getMargin : ()I
    //   1819: i2f
    //   1820: fadd
    //   1821: fadd
    //   1822: fstore #8
    //   1824: fload #8
    //   1826: fstore #6
    //   1828: aload #4
    //   1830: ifnull -> 1680
    //   1833: fload #8
    //   1835: fstore #5
    //   1837: aload #4
    //   1839: invokevirtual getVisibility : ()I
    //   1842: bipush #8
    //   1844: if_icmpeq -> 1854
    //   1847: fload #8
    //   1849: fload #7
    //   1851: fadd
    //   1852: fstore #5
    //   1854: aload #4
    //   1856: astore_0
    //   1857: goto -> 1593
    //   1860: iconst_0
    //   1861: ireturn
    //   1862: iconst_0
    //   1863: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\Optimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */