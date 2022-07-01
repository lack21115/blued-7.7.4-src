package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Analyzer;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
  public static final int DESIGN_INFO_ID = 0;
  
  public static final String VERSION = "ConstraintLayout-1.1.3";
  
  SparseArray<View> a = new SparseArray();
  
  ConstraintWidgetContainer b = new ConstraintWidgetContainer();
  
  int c = -1;
  
  int d = -1;
  
  int e = 0;
  
  int f = 0;
  
  private ArrayList<ConstraintHelper> g = new ArrayList<ConstraintHelper>(4);
  
  private final ArrayList<ConstraintWidget> h = new ArrayList<ConstraintWidget>(100);
  
  private int i = 0;
  
  private int j = 0;
  
  private int k = Integer.MAX_VALUE;
  
  private int l = Integer.MAX_VALUE;
  
  private boolean m = true;
  
  private int n = 7;
  
  private ConstraintSet o = null;
  
  private int p = -1;
  
  private HashMap<String, Integer> q = new HashMap<String, Integer>();
  
  private int r = -1;
  
  private int s = -1;
  
  private Metrics t;
  
  public ConstraintLayout(Context paramContext) {
    super(paramContext);
    a((AttributeSet)null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private final ConstraintWidget a(int paramInt) {
    if (paramInt == 0)
      return (ConstraintWidget)this.b; 
    View view2 = (View)this.a.get(paramInt);
    View view1 = view2;
    if (view2 == null) {
      view2 = findViewById(paramInt);
      view1 = view2;
      if (view2 != null) {
        view1 = view2;
        if (view2 != this) {
          view1 = view2;
          if (view2.getParent() == this) {
            onViewAdded(view2);
            view1 = view2;
          } 
        } 
      } 
    } 
    return (ConstraintWidget)((view1 == this) ? this.b : ((view1 == null) ? null : ((LayoutParams)view1.getLayoutParams()).s));
  }
  
  private void a(int paramInt1, int paramInt2) {
    int j = getPaddingTop() + getPaddingBottom();
    int k = getPaddingLeft() + getPaddingRight();
    int m = getChildCount();
    int i;
    for (i = 0; i < m; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        ConstraintWidget constraintWidget = layoutParams.s;
        if (!layoutParams.f && !layoutParams.g) {
          int n;
          boolean bool;
          int i1;
          int i2;
          constraintWidget.setVisibility(view.getVisibility());
          int i3 = layoutParams.width;
          int i4 = layoutParams.height;
          if (layoutParams.c || layoutParams.d || (!layoutParams.c && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1 || (!layoutParams.d && (layoutParams.matchConstraintDefaultHeight == 1 || layoutParams.height == -1))) {
            n = 1;
          } else {
            n = 0;
          } 
          if (n) {
            boolean bool1;
            if (i3 == 0) {
              i1 = getChildMeasureSpec(paramInt1, k, -2);
              n = 1;
            } else if (i3 == -1) {
              i1 = getChildMeasureSpec(paramInt1, k, -1);
              n = 0;
            } else {
              if (i3 == -2) {
                n = 1;
              } else {
                n = 0;
              } 
              i1 = getChildMeasureSpec(paramInt1, k, i3);
            } 
            if (i4 == 0) {
              i2 = getChildMeasureSpec(paramInt2, j, -2);
              bool = true;
            } else if (i4 == -1) {
              i2 = getChildMeasureSpec(paramInt2, j, -1);
              bool = false;
            } else {
              if (i4 == -2) {
                bool = true;
              } else {
                bool = false;
              } 
              i2 = getChildMeasureSpec(paramInt2, j, i4);
            } 
            view.measure(i1, i2);
            Metrics metrics = this.t;
            if (metrics != null)
              metrics.measures++; 
            if (i3 == -2) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            constraintWidget.setWidthWrapContent(bool1);
            if (i4 == -2) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            constraintWidget.setHeightWrapContent(bool1);
            i1 = view.getMeasuredWidth();
            i2 = view.getMeasuredHeight();
          } else {
            n = 0;
            bool = false;
            i2 = i4;
            i1 = i3;
          } 
          constraintWidget.setWidth(i1);
          constraintWidget.setHeight(i2);
          if (n)
            constraintWidget.setWrapWidth(i1); 
          if (bool)
            constraintWidget.setWrapHeight(i2); 
          if (layoutParams.e) {
            n = view.getBaseline();
            if (n != -1)
              constraintWidget.setBaselineDistance(n); 
          } 
        } 
      } 
    } 
  }
  
  private void a(AttributeSet paramAttributeSet) {
    this.b.setCompanionWidget(this);
    this.a.put(getId(), this);
    this.o = null;
    if (paramAttributeSet != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = typedArray.getIndexCount();
      int i = 0;
      while (true) {
        if (i < j) {
          int k = typedArray.getIndex(i);
          if (k == R.styleable.ConstraintLayout_Layout_android_minWidth) {
            this.i = typedArray.getDimensionPixelOffset(k, this.i);
          } else if (k == R.styleable.ConstraintLayout_Layout_android_minHeight) {
            this.j = typedArray.getDimensionPixelOffset(k, this.j);
          } else if (k == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
            this.k = typedArray.getDimensionPixelOffset(k, this.k);
          } else if (k == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
            this.l = typedArray.getDimensionPixelOffset(k, this.l);
          } else if (k == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
            this.n = typedArray.getInt(k, this.n);
          } else if (k == R.styleable.ConstraintLayout_Layout_constraintSet) {
            k = typedArray.getResourceId(k, 0);
            try {
              this.o = new ConstraintSet();
              this.o.load(getContext(), k);
            } catch (android.content.res.Resources.NotFoundException notFoundException) {
              this.o = null;
            } 
            this.p = k;
          } 
          i++;
          continue;
        } 
        typedArray.recycle();
        this.b.setOptimizationLevel(this.n);
        return;
      } 
    } 
    this.b.setOptimizationLevel(this.n);
  }
  
  private void b() {
    boolean bool1;
    int j = getChildCount();
    boolean bool2 = false;
    int i = 0;
    while (true) {
      bool1 = bool2;
      if (i < j) {
        if (getChildAt(i).isLayoutRequested()) {
          bool1 = true;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (bool1) {
      this.h.clear();
      c();
    } 
  }
  
  private void b(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: astore #21
    //   3: aload_0
    //   4: invokevirtual getPaddingTop : ()I
    //   7: aload_0
    //   8: invokevirtual getPaddingBottom : ()I
    //   11: iadd
    //   12: istore #9
    //   14: aload_0
    //   15: invokevirtual getPaddingLeft : ()I
    //   18: aload_0
    //   19: invokevirtual getPaddingRight : ()I
    //   22: iadd
    //   23: istore #15
    //   25: aload_0
    //   26: invokevirtual getChildCount : ()I
    //   29: istore #10
    //   31: iconst_0
    //   32: istore_3
    //   33: lconst_1
    //   34: lstore #16
    //   36: iload_3
    //   37: iload #10
    //   39: if_icmpge -> 408
    //   42: aload #21
    //   44: iload_3
    //   45: invokevirtual getChildAt : (I)Landroid/view/View;
    //   48: astore #22
    //   50: aload #22
    //   52: invokevirtual getVisibility : ()I
    //   55: bipush #8
    //   57: if_icmpne -> 63
    //   60: goto -> 401
    //   63: aload #22
    //   65: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   68: checkcast androidx/constraintlayout/widget/ConstraintLayout$LayoutParams
    //   71: astore #23
    //   73: aload #23
    //   75: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   78: astore #24
    //   80: aload #23
    //   82: getfield f : Z
    //   85: ifne -> 401
    //   88: aload #23
    //   90: getfield g : Z
    //   93: ifeq -> 99
    //   96: goto -> 401
    //   99: aload #24
    //   101: aload #22
    //   103: invokevirtual getVisibility : ()I
    //   106: invokevirtual setVisibility : (I)V
    //   109: aload #23
    //   111: getfield width : I
    //   114: istore #6
    //   116: aload #23
    //   118: getfield height : I
    //   121: istore #7
    //   123: iload #6
    //   125: ifeq -> 382
    //   128: iload #7
    //   130: ifne -> 136
    //   133: goto -> 382
    //   136: iload #6
    //   138: bipush #-2
    //   140: if_icmpne -> 149
    //   143: iconst_1
    //   144: istore #4
    //   146: goto -> 152
    //   149: iconst_0
    //   150: istore #4
    //   152: iload_1
    //   153: iload #15
    //   155: iload #6
    //   157: invokestatic getChildMeasureSpec : (III)I
    //   160: istore #8
    //   162: iload #7
    //   164: bipush #-2
    //   166: if_icmpne -> 175
    //   169: iconst_1
    //   170: istore #5
    //   172: goto -> 178
    //   175: iconst_0
    //   176: istore #5
    //   178: aload #22
    //   180: iload #8
    //   182: iload_2
    //   183: iload #9
    //   185: iload #7
    //   187: invokestatic getChildMeasureSpec : (III)I
    //   190: invokevirtual measure : (II)V
    //   193: aload #21
    //   195: getfield t : Landroidx/constraintlayout/solver/Metrics;
    //   198: astore #25
    //   200: aload #25
    //   202: ifnull -> 217
    //   205: aload #25
    //   207: aload #25
    //   209: getfield measures : J
    //   212: lconst_1
    //   213: ladd
    //   214: putfield measures : J
    //   217: iload #6
    //   219: bipush #-2
    //   221: if_icmpne -> 230
    //   224: iconst_1
    //   225: istore #20
    //   227: goto -> 233
    //   230: iconst_0
    //   231: istore #20
    //   233: aload #24
    //   235: iload #20
    //   237: invokevirtual setWidthWrapContent : (Z)V
    //   240: iload #7
    //   242: bipush #-2
    //   244: if_icmpne -> 253
    //   247: iconst_1
    //   248: istore #20
    //   250: goto -> 256
    //   253: iconst_0
    //   254: istore #20
    //   256: aload #24
    //   258: iload #20
    //   260: invokevirtual setHeightWrapContent : (Z)V
    //   263: aload #22
    //   265: invokevirtual getMeasuredWidth : ()I
    //   268: istore #6
    //   270: aload #22
    //   272: invokevirtual getMeasuredHeight : ()I
    //   275: istore #7
    //   277: aload #24
    //   279: iload #6
    //   281: invokevirtual setWidth : (I)V
    //   284: aload #24
    //   286: iload #7
    //   288: invokevirtual setHeight : (I)V
    //   291: iload #4
    //   293: ifeq -> 303
    //   296: aload #24
    //   298: iload #6
    //   300: invokevirtual setWrapWidth : (I)V
    //   303: iload #5
    //   305: ifeq -> 315
    //   308: aload #24
    //   310: iload #7
    //   312: invokevirtual setWrapHeight : (I)V
    //   315: aload #23
    //   317: getfield e : Z
    //   320: ifeq -> 343
    //   323: aload #22
    //   325: invokevirtual getBaseline : ()I
    //   328: istore #4
    //   330: iload #4
    //   332: iconst_m1
    //   333: if_icmpeq -> 343
    //   336: aload #24
    //   338: iload #4
    //   340: invokevirtual setBaselineDistance : (I)V
    //   343: aload #23
    //   345: getfield c : Z
    //   348: ifeq -> 401
    //   351: aload #23
    //   353: getfield d : Z
    //   356: ifeq -> 401
    //   359: aload #24
    //   361: invokevirtual getResolutionWidth : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   364: iload #6
    //   366: invokevirtual resolve : (I)V
    //   369: aload #24
    //   371: invokevirtual getResolutionHeight : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   374: iload #7
    //   376: invokevirtual resolve : (I)V
    //   379: goto -> 401
    //   382: aload #24
    //   384: invokevirtual getResolutionWidth : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   387: invokevirtual invalidate : ()V
    //   390: aload #24
    //   392: invokevirtual getResolutionHeight : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   395: invokevirtual invalidate : ()V
    //   398: goto -> 401
    //   401: iload_3
    //   402: iconst_1
    //   403: iadd
    //   404: istore_3
    //   405: goto -> 33
    //   408: aload #21
    //   410: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   413: invokevirtual solveGraph : ()V
    //   416: iconst_0
    //   417: istore #11
    //   419: iload #11
    //   421: iload #10
    //   423: if_icmpge -> 1323
    //   426: aload #21
    //   428: iload #11
    //   430: invokevirtual getChildAt : (I)Landroid/view/View;
    //   433: astore #22
    //   435: aload #22
    //   437: invokevirtual getVisibility : ()I
    //   440: bipush #8
    //   442: if_icmpne -> 448
    //   445: goto -> 1306
    //   448: aload #22
    //   450: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   453: checkcast androidx/constraintlayout/widget/ConstraintLayout$LayoutParams
    //   456: astore #24
    //   458: aload #24
    //   460: getfield s : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
    //   463: astore #23
    //   465: aload #24
    //   467: getfield f : Z
    //   470: ifne -> 1306
    //   473: aload #24
    //   475: getfield g : Z
    //   478: ifeq -> 484
    //   481: goto -> 1306
    //   484: aload #23
    //   486: aload #22
    //   488: invokevirtual getVisibility : ()I
    //   491: invokevirtual setVisibility : (I)V
    //   494: aload #24
    //   496: getfield width : I
    //   499: istore #7
    //   501: aload #24
    //   503: getfield height : I
    //   506: istore #8
    //   508: iload #7
    //   510: ifeq -> 521
    //   513: iload #8
    //   515: ifeq -> 521
    //   518: goto -> 1306
    //   521: aload #23
    //   523: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.LEFT : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   526: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   529: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   532: astore #25
    //   534: aload #23
    //   536: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   539: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   542: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   545: astore #26
    //   547: aload #23
    //   549: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.LEFT : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   552: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   555: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   558: ifnull -> 581
    //   561: aload #23
    //   563: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   566: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   569: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   572: ifnull -> 581
    //   575: iconst_1
    //   576: istore #4
    //   578: goto -> 584
    //   581: iconst_0
    //   582: istore #4
    //   584: aload #23
    //   586: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.TOP : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   589: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   592: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   595: astore #27
    //   597: aload #23
    //   599: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   602: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   605: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   608: astore #28
    //   610: aload #23
    //   612: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.TOP : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   615: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   618: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   621: ifnull -> 644
    //   624: aload #23
    //   626: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   629: invokevirtual getAnchor : (Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;)Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   632: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   635: ifnull -> 644
    //   638: iconst_1
    //   639: istore #14
    //   641: goto -> 647
    //   644: iconst_0
    //   645: istore #14
    //   647: iload #7
    //   649: ifne -> 677
    //   652: iload #8
    //   654: ifne -> 677
    //   657: iload #4
    //   659: ifeq -> 677
    //   662: iload #14
    //   664: ifeq -> 677
    //   667: lconst_1
    //   668: lstore #16
    //   670: aload #21
    //   672: astore #22
    //   674: goto -> 1310
    //   677: aload #21
    //   679: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   682: invokevirtual getHorizontalDimensionBehaviour : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   685: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   688: if_acmpeq -> 697
    //   691: iconst_1
    //   692: istore #6
    //   694: goto -> 700
    //   697: iconst_0
    //   698: istore #6
    //   700: aload #21
    //   702: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   705: invokevirtual getVerticalDimensionBehaviour : ()Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   708: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   711: if_acmpeq -> 719
    //   714: iconst_1
    //   715: istore_3
    //   716: goto -> 721
    //   719: iconst_0
    //   720: istore_3
    //   721: iload #6
    //   723: ifne -> 734
    //   726: aload #23
    //   728: invokevirtual getResolutionWidth : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   731: invokevirtual invalidate : ()V
    //   734: iload_3
    //   735: ifne -> 746
    //   738: aload #23
    //   740: invokevirtual getResolutionHeight : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   743: invokevirtual invalidate : ()V
    //   746: iload #7
    //   748: ifne -> 845
    //   751: iload #6
    //   753: ifeq -> 822
    //   756: aload #23
    //   758: invokevirtual isSpreadWidth : ()Z
    //   761: ifeq -> 822
    //   764: iload #4
    //   766: ifeq -> 822
    //   769: aload #25
    //   771: invokevirtual isResolved : ()Z
    //   774: ifeq -> 822
    //   777: aload #26
    //   779: invokevirtual isResolved : ()Z
    //   782: ifeq -> 822
    //   785: aload #26
    //   787: invokevirtual getResolvedValue : ()F
    //   790: aload #25
    //   792: invokevirtual getResolvedValue : ()F
    //   795: fsub
    //   796: f2i
    //   797: istore #7
    //   799: aload #23
    //   801: invokevirtual getResolutionWidth : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   804: iload #7
    //   806: invokevirtual resolve : (I)V
    //   809: iload_1
    //   810: iload #15
    //   812: iload #7
    //   814: invokestatic getChildMeasureSpec : (III)I
    //   817: istore #5
    //   819: goto -> 860
    //   822: iload_1
    //   823: iload #15
    //   825: bipush #-2
    //   827: invokestatic getChildMeasureSpec : (III)I
    //   830: istore #5
    //   832: iconst_1
    //   833: istore #4
    //   835: iconst_0
    //   836: istore #12
    //   838: iload #7
    //   840: istore #13
    //   842: goto -> 908
    //   845: iload #7
    //   847: iconst_m1
    //   848: if_icmpne -> 874
    //   851: iload_1
    //   852: iload #15
    //   854: iconst_m1
    //   855: invokestatic getChildMeasureSpec : (III)I
    //   858: istore #5
    //   860: iconst_0
    //   861: istore #4
    //   863: iload #6
    //   865: istore #12
    //   867: iload #7
    //   869: istore #13
    //   871: goto -> 908
    //   874: iload #7
    //   876: bipush #-2
    //   878: if_icmpne -> 887
    //   881: iconst_1
    //   882: istore #4
    //   884: goto -> 890
    //   887: iconst_0
    //   888: istore #4
    //   890: iload_1
    //   891: iload #15
    //   893: iload #7
    //   895: invokestatic getChildMeasureSpec : (III)I
    //   898: istore #5
    //   900: iload #7
    //   902: istore #13
    //   904: iload #6
    //   906: istore #12
    //   908: iload #8
    //   910: ifne -> 1001
    //   913: iload_3
    //   914: ifeq -> 983
    //   917: aload #23
    //   919: invokevirtual isSpreadHeight : ()Z
    //   922: ifeq -> 983
    //   925: iload #14
    //   927: ifeq -> 983
    //   930: aload #27
    //   932: invokevirtual isResolved : ()Z
    //   935: ifeq -> 983
    //   938: aload #28
    //   940: invokevirtual isResolved : ()Z
    //   943: ifeq -> 983
    //   946: aload #28
    //   948: invokevirtual getResolvedValue : ()F
    //   951: aload #27
    //   953: invokevirtual getResolvedValue : ()F
    //   956: fsub
    //   957: f2i
    //   958: istore #8
    //   960: aload #23
    //   962: invokevirtual getResolutionHeight : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   965: iload #8
    //   967: invokevirtual resolve : (I)V
    //   970: iload_2
    //   971: iload #9
    //   973: iload #8
    //   975: invokestatic getChildMeasureSpec : (III)I
    //   978: istore #6
    //   980: goto -> 1016
    //   983: iload_2
    //   984: iload #9
    //   986: bipush #-2
    //   988: invokestatic getChildMeasureSpec : (III)I
    //   991: istore #6
    //   993: iconst_1
    //   994: istore_3
    //   995: iconst_0
    //   996: istore #7
    //   998: goto -> 1060
    //   1001: iload #8
    //   1003: iconst_m1
    //   1004: if_icmpne -> 1024
    //   1007: iload_2
    //   1008: iload #9
    //   1010: iconst_m1
    //   1011: invokestatic getChildMeasureSpec : (III)I
    //   1014: istore #6
    //   1016: iload_3
    //   1017: istore #7
    //   1019: iconst_0
    //   1020: istore_3
    //   1021: goto -> 1060
    //   1024: iload #8
    //   1026: bipush #-2
    //   1028: if_icmpne -> 1037
    //   1031: iconst_1
    //   1032: istore #6
    //   1034: goto -> 1040
    //   1037: iconst_0
    //   1038: istore #6
    //   1040: iload_2
    //   1041: iload #9
    //   1043: iload #8
    //   1045: invokestatic getChildMeasureSpec : (III)I
    //   1048: istore #14
    //   1050: iload_3
    //   1051: istore #7
    //   1053: iload #6
    //   1055: istore_3
    //   1056: iload #14
    //   1058: istore #6
    //   1060: aload #22
    //   1062: iload #5
    //   1064: iload #6
    //   1066: invokevirtual measure : (II)V
    //   1069: aload_0
    //   1070: astore #21
    //   1072: aload #21
    //   1074: getfield t : Landroidx/constraintlayout/solver/Metrics;
    //   1077: astore #25
    //   1079: aload #25
    //   1081: ifnull -> 1099
    //   1084: aload #25
    //   1086: aload #25
    //   1088: getfield measures : J
    //   1091: lconst_1
    //   1092: ladd
    //   1093: putfield measures : J
    //   1096: goto -> 1099
    //   1099: lconst_1
    //   1100: lstore #18
    //   1102: iload #13
    //   1104: bipush #-2
    //   1106: if_icmpne -> 1115
    //   1109: iconst_1
    //   1110: istore #20
    //   1112: goto -> 1118
    //   1115: iconst_0
    //   1116: istore #20
    //   1118: aload #23
    //   1120: iload #20
    //   1122: invokevirtual setWidthWrapContent : (Z)V
    //   1125: iload #8
    //   1127: bipush #-2
    //   1129: if_icmpne -> 1138
    //   1132: iconst_1
    //   1133: istore #20
    //   1135: goto -> 1141
    //   1138: iconst_0
    //   1139: istore #20
    //   1141: aload #23
    //   1143: iload #20
    //   1145: invokevirtual setHeightWrapContent : (Z)V
    //   1148: aload #22
    //   1150: invokevirtual getMeasuredWidth : ()I
    //   1153: istore #5
    //   1155: aload #22
    //   1157: invokevirtual getMeasuredHeight : ()I
    //   1160: istore #6
    //   1162: aload #23
    //   1164: iload #5
    //   1166: invokevirtual setWidth : (I)V
    //   1169: aload #23
    //   1171: iload #6
    //   1173: invokevirtual setHeight : (I)V
    //   1176: iload #4
    //   1178: ifeq -> 1188
    //   1181: aload #23
    //   1183: iload #5
    //   1185: invokevirtual setWrapWidth : (I)V
    //   1188: iload_3
    //   1189: ifeq -> 1199
    //   1192: aload #23
    //   1194: iload #6
    //   1196: invokevirtual setWrapHeight : (I)V
    //   1199: iload #12
    //   1201: ifeq -> 1217
    //   1204: aload #23
    //   1206: invokevirtual getResolutionWidth : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   1209: iload #5
    //   1211: invokevirtual resolve : (I)V
    //   1214: goto -> 1225
    //   1217: aload #23
    //   1219: invokevirtual getResolutionWidth : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   1222: invokevirtual remove : ()V
    //   1225: iload #7
    //   1227: ifeq -> 1243
    //   1230: aload #23
    //   1232: invokevirtual getResolutionHeight : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   1235: iload #6
    //   1237: invokevirtual resolve : (I)V
    //   1240: goto -> 1251
    //   1243: aload #23
    //   1245: invokevirtual getResolutionHeight : ()Landroidx/constraintlayout/solver/widgets/ResolutionDimension;
    //   1248: invokevirtual remove : ()V
    //   1251: aload #24
    //   1253: getfield e : Z
    //   1256: ifeq -> 1295
    //   1259: aload #22
    //   1261: invokevirtual getBaseline : ()I
    //   1264: istore_3
    //   1265: aload #21
    //   1267: astore #22
    //   1269: lload #18
    //   1271: lstore #16
    //   1273: iload_3
    //   1274: iconst_m1
    //   1275: if_icmpeq -> 1310
    //   1278: aload #23
    //   1280: iload_3
    //   1281: invokevirtual setBaselineDistance : (I)V
    //   1284: aload #21
    //   1286: astore #22
    //   1288: lload #18
    //   1290: lstore #16
    //   1292: goto -> 1310
    //   1295: aload #21
    //   1297: astore #22
    //   1299: lload #18
    //   1301: lstore #16
    //   1303: goto -> 1310
    //   1306: aload #21
    //   1308: astore #22
    //   1310: iload #11
    //   1312: iconst_1
    //   1313: iadd
    //   1314: istore #11
    //   1316: aload #22
    //   1318: astore #21
    //   1320: goto -> 419
    //   1323: return
  }
  
  private void c() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: invokestatic getMode : (I)I
    //   4: istore #6
    //   6: iload_1
    //   7: invokestatic getSize : (I)I
    //   10: istore_1
    //   11: iload_2
    //   12: invokestatic getMode : (I)I
    //   15: istore_3
    //   16: iload_2
    //   17: invokestatic getSize : (I)I
    //   20: istore_2
    //   21: aload_0
    //   22: invokevirtual getPaddingTop : ()I
    //   25: istore #4
    //   27: aload_0
    //   28: invokevirtual getPaddingBottom : ()I
    //   31: istore #5
    //   33: aload_0
    //   34: invokevirtual getPaddingLeft : ()I
    //   37: istore #7
    //   39: aload_0
    //   40: invokevirtual getPaddingRight : ()I
    //   43: istore #8
    //   45: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   48: astore #9
    //   50: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.FIXED : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   53: astore #10
    //   55: aload_0
    //   56: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   59: pop
    //   60: iload #6
    //   62: ldc_w -2147483648
    //   65: if_icmpeq -> 112
    //   68: iload #6
    //   70: ifeq -> 104
    //   73: iload #6
    //   75: ldc_w 1073741824
    //   78: if_icmpeq -> 86
    //   81: iconst_0
    //   82: istore_1
    //   83: goto -> 117
    //   86: aload_0
    //   87: getfield k : I
    //   90: iload_1
    //   91: invokestatic min : (II)I
    //   94: iload #7
    //   96: iload #8
    //   98: iadd
    //   99: isub
    //   100: istore_1
    //   101: goto -> 117
    //   104: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   107: astore #9
    //   109: goto -> 81
    //   112: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   115: astore #9
    //   117: iload_3
    //   118: ldc_w -2147483648
    //   121: if_icmpeq -> 166
    //   124: iload_3
    //   125: ifeq -> 158
    //   128: iload_3
    //   129: ldc_w 1073741824
    //   132: if_icmpeq -> 140
    //   135: iconst_0
    //   136: istore_2
    //   137: goto -> 171
    //   140: aload_0
    //   141: getfield l : I
    //   144: iload_2
    //   145: invokestatic min : (II)I
    //   148: iload #4
    //   150: iload #5
    //   152: iadd
    //   153: isub
    //   154: istore_2
    //   155: goto -> 171
    //   158: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   161: astore #10
    //   163: goto -> 135
    //   166: getstatic androidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour.WRAP_CONTENT : Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;
    //   169: astore #10
    //   171: aload_0
    //   172: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   175: iconst_0
    //   176: invokevirtual setMinWidth : (I)V
    //   179: aload_0
    //   180: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   183: iconst_0
    //   184: invokevirtual setMinHeight : (I)V
    //   187: aload_0
    //   188: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   191: aload #9
    //   193: invokevirtual setHorizontalDimensionBehaviour : (Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   196: aload_0
    //   197: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   200: iload_1
    //   201: invokevirtual setWidth : (I)V
    //   204: aload_0
    //   205: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   208: aload #10
    //   210: invokevirtual setVerticalDimensionBehaviour : (Landroidx/constraintlayout/solver/widgets/ConstraintWidget$DimensionBehaviour;)V
    //   213: aload_0
    //   214: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   217: iload_2
    //   218: invokevirtual setHeight : (I)V
    //   221: aload_0
    //   222: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   225: aload_0
    //   226: getfield i : I
    //   229: aload_0
    //   230: invokevirtual getPaddingLeft : ()I
    //   233: isub
    //   234: aload_0
    //   235: invokevirtual getPaddingRight : ()I
    //   238: isub
    //   239: invokevirtual setMinWidth : (I)V
    //   242: aload_0
    //   243: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintWidgetContainer;
    //   246: aload_0
    //   247: getfield j : I
    //   250: aload_0
    //   251: invokevirtual getPaddingTop : ()I
    //   254: isub
    //   255: aload_0
    //   256: invokevirtual getPaddingBottom : ()I
    //   259: isub
    //   260: invokevirtual setMinHeight : (I)V
    //   263: return
  }
  
  private void d() {
    int j = getChildCount();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view instanceof Placeholder)
        ((Placeholder)view).updatePostMeasure(this); 
    } 
    j = this.g.size();
    if (j > 0)
      for (i = bool; i < j; i++)
        ((ConstraintHelper)this.g.get(i)).updatePostMeasure(this);  
  }
  
  protected LayoutParams a() {
    return new LayoutParams(-2, -2);
  }
  
  protected void a(String paramString) {
    this.b.layout();
    Metrics metrics = this.t;
    if (metrics != null)
      metrics.resolutions++; 
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14)
      onViewAdded(paramView); 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    if (isInEditMode()) {
      int j = getChildCount();
      float f1 = getWidth();
      float f2 = getHeight();
      int i;
      for (i = 0; i < j; i++) {
        View view = getChildAt(i);
        if (view.getVisibility() != 8) {
          Object object = view.getTag();
          if (object != null && object instanceof String) {
            object = ((String)object).split(",");
            if (object.length == 4) {
              int m = Integer.parseInt((String)object[0]);
              int i1 = Integer.parseInt((String)object[1]);
              int n = Integer.parseInt((String)object[2]);
              int k = Integer.parseInt((String)object[3]);
              m = (int)(m / 1080.0F * f1);
              i1 = (int)(i1 / 1920.0F * f2);
              n = (int)(n / 1080.0F * f1);
              k = (int)(k / 1920.0F * f2);
              object = new Paint();
              object.setColor(-65536);
              float f3 = m;
              float f4 = i1;
              float f5 = (m + n);
              paramCanvas.drawLine(f3, f4, f5, f4, (Paint)object);
              float f6 = (i1 + k);
              paramCanvas.drawLine(f5, f4, f5, f6, (Paint)object);
              paramCanvas.drawLine(f5, f6, f3, f6, (Paint)object);
              paramCanvas.drawLine(f3, f6, f3, f4, (Paint)object);
              object.setColor(-16711936);
              paramCanvas.drawLine(f3, f4, f5, f6, (Paint)object);
              paramCanvas.drawLine(f3, f6, f5, f4, (Paint)object);
            } 
          } 
        } 
      } 
    } 
  }
  
  public void fillMetrics(Metrics paramMetrics) {
    this.t = paramMetrics;
    this.b.fillMetrics(paramMetrics);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public Object getDesignInformation(int paramInt, Object paramObject) {
    if (paramInt == 0 && paramObject instanceof String) {
      paramObject = paramObject;
      HashMap<String, Integer> hashMap = this.q;
      if (hashMap != null && hashMap.containsKey(paramObject))
        return this.q.get(paramObject); 
    } 
    return null;
  }
  
  public int getMaxHeight() {
    return this.l;
  }
  
  public int getMaxWidth() {
    return this.k;
  }
  
  public int getMinHeight() {
    return this.j;
  }
  
  public int getMinWidth() {
    return this.i;
  }
  
  public int getOptimizationLevel() {
    return this.b.getOptimizationLevel();
  }
  
  public View getViewById(int paramInt) {
    return (View)this.a.get(paramInt);
  }
  
  public final ConstraintWidget getViewWidget(View paramView) {
    return (ConstraintWidget)((paramView == this) ? this.b : ((paramView == null) ? null : ((LayoutParams)paramView.getLayoutParams()).s));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt3 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt2 = 0;
    for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++) {
      View view = getChildAt(paramInt1);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      ConstraintWidget constraintWidget = layoutParams.s;
      if ((view.getVisibility() != 8 || layoutParams.f || layoutParams.g || paramBoolean) && !layoutParams.h) {
        paramInt4 = constraintWidget.getDrawX();
        int i = constraintWidget.getDrawY();
        int j = constraintWidget.getWidth() + paramInt4;
        int k = constraintWidget.getHeight() + i;
        view.layout(paramInt4, i, j, k);
        if (view instanceof Placeholder) {
          view = ((Placeholder)view).getContent();
          if (view != null) {
            view.setVisibility(0);
            view.layout(paramInt4, i, j, k);
          } 
        } 
      } 
    } 
    paramInt3 = this.g.size();
    if (paramInt3 > 0)
      for (paramInt1 = paramInt2; paramInt1 < paramInt3; paramInt1++)
        ((ConstraintHelper)this.g.get(paramInt1)).updatePostLayout(this);  
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    int i;
    boolean bool;
    System.currentTimeMillis();
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int j = getPaddingLeft();
    int k = getPaddingTop();
    this.b.setX(j);
    this.b.setY(k);
    this.b.setMaxWidth(this.k);
    this.b.setMaxHeight(this.l);
    if (Build.VERSION.SDK_INT >= 17) {
      boolean bool1;
      ConstraintWidgetContainer constraintWidgetContainer = this.b;
      if (getLayoutDirection() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      constraintWidgetContainer.setRtl(bool1);
    } 
    c(paramInt1, paramInt2);
    int i5 = this.b.getWidth();
    int i4 = this.b.getHeight();
    if (this.m) {
      this.m = false;
      b();
      i = 1;
    } else {
      i = 0;
    } 
    if ((this.n & 0x8) == 8) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      this.b.preOptimize();
      this.b.optimizeForDimensions(i5, i4);
      b(paramInt1, paramInt2);
    } else {
      a(paramInt1, paramInt2);
    } 
    d();
    if (getChildCount() > 0 && i)
      Analyzer.determineGroups(this.b); 
    if (this.b.mGroupsWrapOptimized) {
      if (this.b.mHorizontalWrapOptimized && m == Integer.MIN_VALUE) {
        if (this.b.mWrapFixedWidth < n) {
          ConstraintWidgetContainer constraintWidgetContainer = this.b;
          constraintWidgetContainer.setWidth(constraintWidgetContainer.mWrapFixedWidth);
        } 
        this.b.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      } 
      if (this.b.mVerticalWrapOptimized && i1 == Integer.MIN_VALUE) {
        if (this.b.mWrapFixedHeight < i2) {
          ConstraintWidgetContainer constraintWidgetContainer = this.b;
          constraintWidgetContainer.setHeight(constraintWidgetContainer.mWrapFixedHeight);
        } 
        this.b.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      } 
    } 
    if ((this.n & 0x20) == 32) {
      i = this.b.getWidth();
      int i8 = this.b.getHeight();
      if (this.r != i && m == 1073741824)
        Analyzer.setPosition(this.b.mWidgetGroups, 0, i); 
      if (this.s != i8 && i1 == 1073741824)
        Analyzer.setPosition(this.b.mWidgetGroups, 1, i8); 
      if (this.b.mHorizontalWrapOptimized && this.b.mWrapFixedWidth > n)
        Analyzer.setPosition(this.b.mWidgetGroups, 0, n); 
      if (this.b.mVerticalWrapOptimized && this.b.mWrapFixedHeight > i2)
        Analyzer.setPosition(this.b.mWidgetGroups, 1, i2); 
    } 
    if (getChildCount() > 0)
      a("First pass"); 
    int i3 = this.h.size();
    int i6 = k + getPaddingBottom();
    int i7 = j + getPaddingRight();
    if (i3 > 0) {
      if (this.b.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        i1 = 1;
      } else {
        i1 = 0;
      } 
      if (this.b.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        i2 = 1;
      } else {
        i2 = 0;
      } 
      k = Math.max(this.b.getWidth(), this.i);
      j = Math.max(this.b.getHeight(), this.j);
      int i8 = 0;
      m = 0;
      i = 0;
      while (i8 < i3) {
        ConstraintWidget constraintWidget = this.h.get(i8);
        View view = (View)constraintWidget.getCompanionWidget();
        if (view != null) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          if (!layoutParams.g && !layoutParams.f) {
            int i9 = view.getVisibility();
            n = m;
            if (i9 != 8 && (!bool || !constraintWidget.getResolutionWidth().isResolved() || !constraintWidget.getResolutionHeight().isResolved())) {
              if (layoutParams.width == -2 && layoutParams.c) {
                m = getChildMeasureSpec(paramInt1, i7, layoutParams.width);
              } else {
                m = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824);
              } 
              if (layoutParams.height == -2 && layoutParams.d) {
                i9 = getChildMeasureSpec(paramInt2, i6, layoutParams.height);
              } else {
                i9 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824);
              } 
              view.measure(m, i9);
              Metrics metrics = this.t;
              if (metrics != null)
                metrics.additionalMeasures++; 
              int i10 = view.getMeasuredWidth();
              i9 = view.getMeasuredHeight();
              m = k;
              if (i10 != constraintWidget.getWidth()) {
                constraintWidget.setWidth(i10);
                if (bool)
                  constraintWidget.getResolutionWidth().resolve(i10); 
                m = k;
                if (i1 != 0) {
                  m = k;
                  if (constraintWidget.getRight() > k)
                    m = Math.max(k, constraintWidget.getRight() + constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin()); 
                } 
                n = 1;
              } 
              k = j;
              if (i9 != constraintWidget.getHeight()) {
                constraintWidget.setHeight(i9);
                if (bool)
                  constraintWidget.getResolutionHeight().resolve(i9); 
                k = j;
                if (i2 != 0) {
                  k = j;
                  if (constraintWidget.getBottom() > j)
                    k = Math.max(j, constraintWidget.getBottom() + constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin()); 
                } 
                n = 1;
              } 
              j = n;
              if (layoutParams.e) {
                i9 = view.getBaseline();
                j = n;
                if (i9 != -1) {
                  j = n;
                  if (i9 != constraintWidget.getBaselineDistance()) {
                    constraintWidget.setBaselineDistance(i9);
                    j = 1;
                  } 
                } 
              } 
              if (Build.VERSION.SDK_INT >= 11) {
                i = combineMeasuredStates(i, view.getMeasuredState());
                n = k;
                k = m;
                m = j;
              } else {
                n = k;
                k = m;
                m = j;
              } 
              continue;
            } 
          } 
        } 
        n = j;
        continue;
        i8++;
        j = n;
      } 
      n = i;
      if (m != 0) {
        this.b.setWidth(i5);
        this.b.setHeight(i4);
        if (bool)
          this.b.solveGraph(); 
        a("2nd pass");
        if (this.b.getWidth() < k) {
          this.b.setWidth(k);
          i = 1;
        } else {
          i = 0;
        } 
        if (this.b.getHeight() < j) {
          this.b.setHeight(j);
          i = 1;
        } 
        if (i != 0)
          a("3rd pass"); 
      } 
      j = 0;
      while (true) {
        i = n;
        if (j < i3) {
          ConstraintWidget constraintWidget = this.h.get(j);
          View view = (View)constraintWidget.getCompanionWidget();
          if (view != null && (view.getMeasuredWidth() != constraintWidget.getWidth() || view.getMeasuredHeight() != constraintWidget.getHeight()) && constraintWidget.getVisibility() != 8) {
            view.measure(View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824));
            Metrics metrics = this.t;
            if (metrics != null)
              metrics.additionalMeasures++; 
          } 
          j++;
          continue;
        } 
        break;
      } 
    } else {
      i = 0;
    } 
    j = this.b.getWidth() + i7;
    k = this.b.getHeight() + i6;
    if (Build.VERSION.SDK_INT >= 11) {
      paramInt1 = resolveSizeAndState(j, paramInt1, i);
      i = resolveSizeAndState(k, paramInt2, i << 16);
      paramInt2 = Math.min(this.k, paramInt1 & 0xFFFFFF);
      i = Math.min(this.l, i & 0xFFFFFF);
      paramInt1 = paramInt2;
      if (this.b.isWidthMeasuredTooSmall())
        paramInt1 = paramInt2 | 0x1000000; 
      paramInt2 = i;
      if (this.b.isHeightMeasuredTooSmall())
        paramInt2 = i | 0x1000000; 
      setMeasuredDimension(paramInt1, paramInt2);
      this.r = paramInt1;
      this.s = paramInt2;
      return;
    } 
    setMeasuredDimension(j, k);
    this.r = j;
    this.s = k;
  }
  
  public void onViewAdded(View paramView) {
    if (Build.VERSION.SDK_INT >= 14)
      super.onViewAdded(paramView); 
    ConstraintWidget constraintWidget = getViewWidget(paramView);
    if (paramView instanceof Guideline && !(constraintWidget instanceof Guideline)) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      layoutParams.s = (ConstraintWidget)new Guideline();
      layoutParams.f = true;
      ((Guideline)layoutParams.s).setOrientation(layoutParams.orientation);
    } 
    if (paramView instanceof ConstraintHelper) {
      ConstraintHelper constraintHelper = (ConstraintHelper)paramView;
      constraintHelper.validateParams();
      ((LayoutParams)paramView.getLayoutParams()).g = true;
      if (!this.g.contains(constraintHelper))
        this.g.add(constraintHelper); 
    } 
    this.a.put(paramView.getId(), paramView);
    this.m = true;
  }
  
  public void onViewRemoved(View paramView) {
    if (Build.VERSION.SDK_INT >= 14)
      super.onViewRemoved(paramView); 
    this.a.remove(paramView.getId());
    ConstraintWidget constraintWidget = getViewWidget(paramView);
    this.b.remove(constraintWidget);
    this.g.remove(paramView);
    this.h.remove(constraintWidget);
    this.m = true;
  }
  
  public void removeView(View paramView) {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14)
      onViewRemoved(paramView); 
  }
  
  public void requestLayout() {
    super.requestLayout();
    this.m = true;
    this.r = -1;
    this.s = -1;
    this.c = -1;
    this.d = -1;
    this.e = 0;
    this.f = 0;
  }
  
  public void setConstraintSet(ConstraintSet paramConstraintSet) {
    this.o = paramConstraintSet;
  }
  
  public void setDesignInformation(int paramInt, Object paramObject1, Object paramObject2) {
    if (paramInt == 0 && paramObject1 instanceof String && paramObject2 instanceof Integer) {
      if (this.q == null)
        this.q = new HashMap<String, Integer>(); 
      String str = (String)paramObject1;
      paramInt = str.indexOf("/");
      paramObject1 = str;
      if (paramInt != -1)
        paramObject1 = str.substring(paramInt + 1); 
      paramInt = ((Integer)paramObject2).intValue();
      this.q.put(paramObject1, Integer.valueOf(paramInt));
    } 
  }
  
  public void setId(int paramInt) {
    this.a.remove(getId());
    super.setId(paramInt);
    this.a.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt) {
    if (paramInt == this.l)
      return; 
    this.l = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt) {
    if (paramInt == this.k)
      return; 
    this.k = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt) {
    if (paramInt == this.j)
      return; 
    this.j = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt) {
    if (paramInt == this.i)
      return; 
    this.i = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt) {
    this.b.setOptimizationLevel(paramInt);
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public static final int BASELINE = 5;
    
    public static final int BOTTOM = 4;
    
    public static final int CHAIN_PACKED = 2;
    
    public static final int CHAIN_SPREAD = 0;
    
    public static final int CHAIN_SPREAD_INSIDE = 1;
    
    public static final int END = 7;
    
    public static final int HORIZONTAL = 0;
    
    public static final int LEFT = 1;
    
    public static final int MATCH_CONSTRAINT = 0;
    
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    
    public static final int PARENT_ID = 0;
    
    public static final int RIGHT = 2;
    
    public static final int START = 6;
    
    public static final int TOP = 3;
    
    public static final int UNSET = -1;
    
    public static final int VERTICAL = 1;
    
    float a = 0.0F;
    
    int b = 1;
    
    public int baselineToBaseline = -1;
    
    public int bottomToBottom = -1;
    
    public int bottomToTop = -1;
    
    boolean c = true;
    
    public float circleAngle = 0.0F;
    
    public int circleConstraint = -1;
    
    public int circleRadius = 0;
    
    public boolean constrainedHeight = false;
    
    public boolean constrainedWidth = false;
    
    boolean d = true;
    
    public String dimensionRatio = null;
    
    boolean e = false;
    
    public int editorAbsoluteX = -1;
    
    public int editorAbsoluteY = -1;
    
    public int endToEnd = -1;
    
    public int endToStart = -1;
    
    boolean f = false;
    
    boolean g = false;
    
    public int goneBottomMargin = -1;
    
    public int goneEndMargin = -1;
    
    public int goneLeftMargin = -1;
    
    public int goneRightMargin = -1;
    
    public int goneStartMargin = -1;
    
    public int goneTopMargin = -1;
    
    public int guideBegin = -1;
    
    public int guideEnd = -1;
    
    public float guidePercent = -1.0F;
    
    boolean h = false;
    
    public boolean helped = false;
    
    public float horizontalBias = 0.5F;
    
    public int horizontalChainStyle = 0;
    
    public float horizontalWeight = -1.0F;
    
    int i = -1;
    
    int j = -1;
    
    int k = -1;
    
    int l = -1;
    
    public int leftToLeft = -1;
    
    public int leftToRight = -1;
    
    int m = -1;
    
    public int matchConstraintDefaultHeight = 0;
    
    public int matchConstraintDefaultWidth = 0;
    
    public int matchConstraintMaxHeight = 0;
    
    public int matchConstraintMaxWidth = 0;
    
    public int matchConstraintMinHeight = 0;
    
    public int matchConstraintMinWidth = 0;
    
    public float matchConstraintPercentHeight = 1.0F;
    
    public float matchConstraintPercentWidth = 1.0F;
    
    int n = -1;
    
    float o = 0.5F;
    
    public int orientation = -1;
    
    int p;
    
    int q;
    
    float r;
    
    public int rightToLeft = -1;
    
    public int rightToRight = -1;
    
    ConstraintWidget s = new ConstraintWidget();
    
    public int startToEnd = -1;
    
    public int startToStart = -1;
    
    public int topToBottom = -1;
    
    public int topToTop = -1;
    
    public float verticalBias = 0.5F;
    
    public int verticalChainStyle = 0;
    
    public float verticalWeight = -1.0F;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: aload_2
      //   3: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;)V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield guideBegin : I
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield guideEnd : I
      //   16: aload_0
      //   17: ldc -1.0
      //   19: putfield guidePercent : F
      //   22: aload_0
      //   23: iconst_m1
      //   24: putfield leftToLeft : I
      //   27: aload_0
      //   28: iconst_m1
      //   29: putfield leftToRight : I
      //   32: aload_0
      //   33: iconst_m1
      //   34: putfield rightToLeft : I
      //   37: aload_0
      //   38: iconst_m1
      //   39: putfield rightToRight : I
      //   42: aload_0
      //   43: iconst_m1
      //   44: putfield topToTop : I
      //   47: aload_0
      //   48: iconst_m1
      //   49: putfield topToBottom : I
      //   52: aload_0
      //   53: iconst_m1
      //   54: putfield bottomToTop : I
      //   57: aload_0
      //   58: iconst_m1
      //   59: putfield bottomToBottom : I
      //   62: aload_0
      //   63: iconst_m1
      //   64: putfield baselineToBaseline : I
      //   67: aload_0
      //   68: iconst_m1
      //   69: putfield circleConstraint : I
      //   72: aload_0
      //   73: iconst_0
      //   74: putfield circleRadius : I
      //   77: aload_0
      //   78: fconst_0
      //   79: putfield circleAngle : F
      //   82: aload_0
      //   83: iconst_m1
      //   84: putfield startToEnd : I
      //   87: aload_0
      //   88: iconst_m1
      //   89: putfield startToStart : I
      //   92: aload_0
      //   93: iconst_m1
      //   94: putfield endToStart : I
      //   97: aload_0
      //   98: iconst_m1
      //   99: putfield endToEnd : I
      //   102: aload_0
      //   103: iconst_m1
      //   104: putfield goneLeftMargin : I
      //   107: aload_0
      //   108: iconst_m1
      //   109: putfield goneTopMargin : I
      //   112: aload_0
      //   113: iconst_m1
      //   114: putfield goneRightMargin : I
      //   117: aload_0
      //   118: iconst_m1
      //   119: putfield goneBottomMargin : I
      //   122: aload_0
      //   123: iconst_m1
      //   124: putfield goneStartMargin : I
      //   127: aload_0
      //   128: iconst_m1
      //   129: putfield goneEndMargin : I
      //   132: aload_0
      //   133: ldc 0.5
      //   135: putfield horizontalBias : F
      //   138: aload_0
      //   139: ldc 0.5
      //   141: putfield verticalBias : F
      //   144: aload_0
      //   145: aconst_null
      //   146: putfield dimensionRatio : Ljava/lang/String;
      //   149: aload_0
      //   150: fconst_0
      //   151: putfield a : F
      //   154: aload_0
      //   155: iconst_1
      //   156: putfield b : I
      //   159: aload_0
      //   160: ldc -1.0
      //   162: putfield horizontalWeight : F
      //   165: aload_0
      //   166: ldc -1.0
      //   168: putfield verticalWeight : F
      //   171: aload_0
      //   172: iconst_0
      //   173: putfield horizontalChainStyle : I
      //   176: aload_0
      //   177: iconst_0
      //   178: putfield verticalChainStyle : I
      //   181: aload_0
      //   182: iconst_0
      //   183: putfield matchConstraintDefaultWidth : I
      //   186: aload_0
      //   187: iconst_0
      //   188: putfield matchConstraintDefaultHeight : I
      //   191: aload_0
      //   192: iconst_0
      //   193: putfield matchConstraintMinWidth : I
      //   196: aload_0
      //   197: iconst_0
      //   198: putfield matchConstraintMinHeight : I
      //   201: aload_0
      //   202: iconst_0
      //   203: putfield matchConstraintMaxWidth : I
      //   206: aload_0
      //   207: iconst_0
      //   208: putfield matchConstraintMaxHeight : I
      //   211: aload_0
      //   212: fconst_1
      //   213: putfield matchConstraintPercentWidth : F
      //   216: aload_0
      //   217: fconst_1
      //   218: putfield matchConstraintPercentHeight : F
      //   221: aload_0
      //   222: iconst_m1
      //   223: putfield editorAbsoluteX : I
      //   226: aload_0
      //   227: iconst_m1
      //   228: putfield editorAbsoluteY : I
      //   231: aload_0
      //   232: iconst_m1
      //   233: putfield orientation : I
      //   236: aload_0
      //   237: iconst_0
      //   238: putfield constrainedWidth : Z
      //   241: aload_0
      //   242: iconst_0
      //   243: putfield constrainedHeight : Z
      //   246: aload_0
      //   247: iconst_1
      //   248: putfield c : Z
      //   251: aload_0
      //   252: iconst_1
      //   253: putfield d : Z
      //   256: aload_0
      //   257: iconst_0
      //   258: putfield e : Z
      //   261: aload_0
      //   262: iconst_0
      //   263: putfield f : Z
      //   266: aload_0
      //   267: iconst_0
      //   268: putfield g : Z
      //   271: aload_0
      //   272: iconst_0
      //   273: putfield h : Z
      //   276: aload_0
      //   277: iconst_m1
      //   278: putfield i : I
      //   281: aload_0
      //   282: iconst_m1
      //   283: putfield j : I
      //   286: aload_0
      //   287: iconst_m1
      //   288: putfield k : I
      //   291: aload_0
      //   292: iconst_m1
      //   293: putfield l : I
      //   296: aload_0
      //   297: iconst_m1
      //   298: putfield m : I
      //   301: aload_0
      //   302: iconst_m1
      //   303: putfield n : I
      //   306: aload_0
      //   307: ldc 0.5
      //   309: putfield o : F
      //   312: aload_0
      //   313: new androidx/constraintlayout/solver/widgets/ConstraintWidget
      //   316: dup
      //   317: invokespecial <init> : ()V
      //   320: putfield s : Landroidx/constraintlayout/solver/widgets/ConstraintWidget;
      //   323: aload_0
      //   324: iconst_0
      //   325: putfield helped : Z
      //   328: aload_1
      //   329: aload_2
      //   330: getstatic androidx/constraintlayout/widget/R$styleable.ConstraintLayout_Layout : [I
      //   333: invokevirtual obtainStyledAttributes : (Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   336: astore_1
      //   337: aload_1
      //   338: invokevirtual getIndexCount : ()I
      //   341: istore #7
      //   343: iconst_0
      //   344: istore #5
      //   346: iload #5
      //   348: iload #7
      //   350: if_icmpge -> 2039
      //   353: aload_1
      //   354: iload #5
      //   356: invokevirtual getIndex : (I)I
      //   359: istore #6
      //   361: getstatic androidx/constraintlayout/widget/ConstraintLayout$LayoutParams$Table.map : Landroid/util/SparseIntArray;
      //   364: iload #6
      //   366: invokevirtual get : (I)I
      //   369: tableswitch default -> 588, 0 -> 2030, 1 -> 2016, 2 -> 1980, 3 -> 1963, 4 -> 1918, 5 -> 1901, 6 -> 1884, 7 -> 1867, 8 -> 1831, 9 -> 1795, 10 -> 1759, 11 -> 1723, 12 -> 1687, 13 -> 1651, 14 -> 1615, 15 -> 1579, 16 -> 1543, 17 -> 1507, 18 -> 1471, 19 -> 1435, 20 -> 1399, 21 -> 1382, 22 -> 1365, 23 -> 1348, 24 -> 1331, 25 -> 1314, 26 -> 1297, 27 -> 1280, 28 -> 1263, 29 -> 1246, 30 -> 1229, 31 -> 1197, 32 -> 1165, 33 -> 1124, 34 -> 1083, 35 -> 1062, 36 -> 1021, 37 -> 980, 38 -> 959, 39 -> 2030, 40 -> 2030, 41 -> 2030, 42 -> 2030, 43 -> 588, 44 -> 687, 45 -> 670, 46 -> 653, 47 -> 639, 48 -> 625, 49 -> 608, 50 -> 591
      //   588: goto -> 2030
      //   591: aload_0
      //   592: aload_1
      //   593: iload #6
      //   595: aload_0
      //   596: getfield editorAbsoluteY : I
      //   599: invokevirtual getDimensionPixelOffset : (II)I
      //   602: putfield editorAbsoluteY : I
      //   605: goto -> 2030
      //   608: aload_0
      //   609: aload_1
      //   610: iload #6
      //   612: aload_0
      //   613: getfield editorAbsoluteX : I
      //   616: invokevirtual getDimensionPixelOffset : (II)I
      //   619: putfield editorAbsoluteX : I
      //   622: goto -> 2030
      //   625: aload_0
      //   626: aload_1
      //   627: iload #6
      //   629: iconst_0
      //   630: invokevirtual getInt : (II)I
      //   633: putfield verticalChainStyle : I
      //   636: goto -> 2030
      //   639: aload_0
      //   640: aload_1
      //   641: iload #6
      //   643: iconst_0
      //   644: invokevirtual getInt : (II)I
      //   647: putfield horizontalChainStyle : I
      //   650: goto -> 2030
      //   653: aload_0
      //   654: aload_1
      //   655: iload #6
      //   657: aload_0
      //   658: getfield verticalWeight : F
      //   661: invokevirtual getFloat : (IF)F
      //   664: putfield verticalWeight : F
      //   667: goto -> 2030
      //   670: aload_0
      //   671: aload_1
      //   672: iload #6
      //   674: aload_0
      //   675: getfield horizontalWeight : F
      //   678: invokevirtual getFloat : (IF)F
      //   681: putfield horizontalWeight : F
      //   684: goto -> 2030
      //   687: aload_0
      //   688: aload_1
      //   689: iload #6
      //   691: invokevirtual getString : (I)Ljava/lang/String;
      //   694: putfield dimensionRatio : Ljava/lang/String;
      //   697: aload_0
      //   698: ldc_w NaN
      //   701: putfield a : F
      //   704: aload_0
      //   705: iconst_m1
      //   706: putfield b : I
      //   709: aload_0
      //   710: getfield dimensionRatio : Ljava/lang/String;
      //   713: astore_2
      //   714: aload_2
      //   715: ifnull -> 2030
      //   718: aload_2
      //   719: invokevirtual length : ()I
      //   722: istore #8
      //   724: aload_0
      //   725: getfield dimensionRatio : Ljava/lang/String;
      //   728: bipush #44
      //   730: invokevirtual indexOf : (I)I
      //   733: istore #6
      //   735: iload #6
      //   737: ifle -> 802
      //   740: iload #6
      //   742: iload #8
      //   744: iconst_1
      //   745: isub
      //   746: if_icmpge -> 802
      //   749: aload_0
      //   750: getfield dimensionRatio : Ljava/lang/String;
      //   753: iconst_0
      //   754: iload #6
      //   756: invokevirtual substring : (II)Ljava/lang/String;
      //   759: astore_2
      //   760: aload_2
      //   761: ldc_w 'W'
      //   764: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
      //   767: ifeq -> 778
      //   770: aload_0
      //   771: iconst_0
      //   772: putfield b : I
      //   775: goto -> 793
      //   778: aload_2
      //   779: ldc_w 'H'
      //   782: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
      //   785: ifeq -> 793
      //   788: aload_0
      //   789: iconst_1
      //   790: putfield b : I
      //   793: iload #6
      //   795: iconst_1
      //   796: iadd
      //   797: istore #6
      //   799: goto -> 805
      //   802: iconst_0
      //   803: istore #6
      //   805: aload_0
      //   806: getfield dimensionRatio : Ljava/lang/String;
      //   809: bipush #58
      //   811: invokevirtual indexOf : (I)I
      //   814: istore #9
      //   816: iload #9
      //   818: iflt -> 931
      //   821: iload #9
      //   823: iload #8
      //   825: iconst_1
      //   826: isub
      //   827: if_icmpge -> 931
      //   830: aload_0
      //   831: getfield dimensionRatio : Ljava/lang/String;
      //   834: iload #6
      //   836: iload #9
      //   838: invokevirtual substring : (II)Ljava/lang/String;
      //   841: astore_2
      //   842: aload_0
      //   843: getfield dimensionRatio : Ljava/lang/String;
      //   846: iload #9
      //   848: iconst_1
      //   849: iadd
      //   850: invokevirtual substring : (I)Ljava/lang/String;
      //   853: astore #10
      //   855: aload_2
      //   856: invokevirtual length : ()I
      //   859: ifle -> 2030
      //   862: aload #10
      //   864: invokevirtual length : ()I
      //   867: ifle -> 2030
      //   870: aload_2
      //   871: invokestatic parseFloat : (Ljava/lang/String;)F
      //   874: fstore_3
      //   875: aload #10
      //   877: invokestatic parseFloat : (Ljava/lang/String;)F
      //   880: fstore #4
      //   882: fload_3
      //   883: fconst_0
      //   884: fcmpl
      //   885: ifle -> 2030
      //   888: fload #4
      //   890: fconst_0
      //   891: fcmpl
      //   892: ifle -> 2030
      //   895: aload_0
      //   896: getfield b : I
      //   899: iconst_1
      //   900: if_icmpne -> 917
      //   903: aload_0
      //   904: fload #4
      //   906: fload_3
      //   907: fdiv
      //   908: invokestatic abs : (F)F
      //   911: putfield a : F
      //   914: goto -> 2030
      //   917: aload_0
      //   918: fload_3
      //   919: fload #4
      //   921: fdiv
      //   922: invokestatic abs : (F)F
      //   925: putfield a : F
      //   928: goto -> 2030
      //   931: aload_0
      //   932: getfield dimensionRatio : Ljava/lang/String;
      //   935: iload #6
      //   937: invokevirtual substring : (I)Ljava/lang/String;
      //   940: astore_2
      //   941: aload_2
      //   942: invokevirtual length : ()I
      //   945: ifle -> 2030
      //   948: aload_0
      //   949: aload_2
      //   950: invokestatic parseFloat : (Ljava/lang/String;)F
      //   953: putfield a : F
      //   956: goto -> 2030
      //   959: aload_0
      //   960: fconst_0
      //   961: aload_1
      //   962: iload #6
      //   964: aload_0
      //   965: getfield matchConstraintPercentHeight : F
      //   968: invokevirtual getFloat : (IF)F
      //   971: invokestatic max : (FF)F
      //   974: putfield matchConstraintPercentHeight : F
      //   977: goto -> 2030
      //   980: aload_0
      //   981: aload_1
      //   982: iload #6
      //   984: aload_0
      //   985: getfield matchConstraintMaxHeight : I
      //   988: invokevirtual getDimensionPixelSize : (II)I
      //   991: putfield matchConstraintMaxHeight : I
      //   994: goto -> 2030
      //   997: aload_1
      //   998: iload #6
      //   1000: aload_0
      //   1001: getfield matchConstraintMaxHeight : I
      //   1004: invokevirtual getInt : (II)I
      //   1007: bipush #-2
      //   1009: if_icmpne -> 2030
      //   1012: aload_0
      //   1013: bipush #-2
      //   1015: putfield matchConstraintMaxHeight : I
      //   1018: goto -> 2030
      //   1021: aload_0
      //   1022: aload_1
      //   1023: iload #6
      //   1025: aload_0
      //   1026: getfield matchConstraintMinHeight : I
      //   1029: invokevirtual getDimensionPixelSize : (II)I
      //   1032: putfield matchConstraintMinHeight : I
      //   1035: goto -> 2030
      //   1038: aload_1
      //   1039: iload #6
      //   1041: aload_0
      //   1042: getfield matchConstraintMinHeight : I
      //   1045: invokevirtual getInt : (II)I
      //   1048: bipush #-2
      //   1050: if_icmpne -> 2030
      //   1053: aload_0
      //   1054: bipush #-2
      //   1056: putfield matchConstraintMinHeight : I
      //   1059: goto -> 2030
      //   1062: aload_0
      //   1063: fconst_0
      //   1064: aload_1
      //   1065: iload #6
      //   1067: aload_0
      //   1068: getfield matchConstraintPercentWidth : F
      //   1071: invokevirtual getFloat : (IF)F
      //   1074: invokestatic max : (FF)F
      //   1077: putfield matchConstraintPercentWidth : F
      //   1080: goto -> 2030
      //   1083: aload_0
      //   1084: aload_1
      //   1085: iload #6
      //   1087: aload_0
      //   1088: getfield matchConstraintMaxWidth : I
      //   1091: invokevirtual getDimensionPixelSize : (II)I
      //   1094: putfield matchConstraintMaxWidth : I
      //   1097: goto -> 2030
      //   1100: aload_1
      //   1101: iload #6
      //   1103: aload_0
      //   1104: getfield matchConstraintMaxWidth : I
      //   1107: invokevirtual getInt : (II)I
      //   1110: bipush #-2
      //   1112: if_icmpne -> 2030
      //   1115: aload_0
      //   1116: bipush #-2
      //   1118: putfield matchConstraintMaxWidth : I
      //   1121: goto -> 2030
      //   1124: aload_0
      //   1125: aload_1
      //   1126: iload #6
      //   1128: aload_0
      //   1129: getfield matchConstraintMinWidth : I
      //   1132: invokevirtual getDimensionPixelSize : (II)I
      //   1135: putfield matchConstraintMinWidth : I
      //   1138: goto -> 2030
      //   1141: aload_1
      //   1142: iload #6
      //   1144: aload_0
      //   1145: getfield matchConstraintMinWidth : I
      //   1148: invokevirtual getInt : (II)I
      //   1151: bipush #-2
      //   1153: if_icmpne -> 2030
      //   1156: aload_0
      //   1157: bipush #-2
      //   1159: putfield matchConstraintMinWidth : I
      //   1162: goto -> 2030
      //   1165: aload_0
      //   1166: aload_1
      //   1167: iload #6
      //   1169: iconst_0
      //   1170: invokevirtual getInt : (II)I
      //   1173: putfield matchConstraintDefaultHeight : I
      //   1176: aload_0
      //   1177: getfield matchConstraintDefaultHeight : I
      //   1180: iconst_1
      //   1181: if_icmpne -> 2030
      //   1184: ldc_w 'ConstraintLayout'
      //   1187: ldc_w 'layout_constraintHeight_default="wrap" is deprecated.\\nUse layout_height="WRAP_CONTENT" and layout_constrainedHeight="true" instead.'
      //   1190: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   1193: pop
      //   1194: goto -> 2030
      //   1197: aload_0
      //   1198: aload_1
      //   1199: iload #6
      //   1201: iconst_0
      //   1202: invokevirtual getInt : (II)I
      //   1205: putfield matchConstraintDefaultWidth : I
      //   1208: aload_0
      //   1209: getfield matchConstraintDefaultWidth : I
      //   1212: iconst_1
      //   1213: if_icmpne -> 2030
      //   1216: ldc_w 'ConstraintLayout'
      //   1219: ldc_w 'layout_constraintWidth_default="wrap" is deprecated.\\nUse layout_width="WRAP_CONTENT" and layout_constrainedWidth="true" instead.'
      //   1222: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
      //   1225: pop
      //   1226: goto -> 2030
      //   1229: aload_0
      //   1230: aload_1
      //   1231: iload #6
      //   1233: aload_0
      //   1234: getfield verticalBias : F
      //   1237: invokevirtual getFloat : (IF)F
      //   1240: putfield verticalBias : F
      //   1243: goto -> 2030
      //   1246: aload_0
      //   1247: aload_1
      //   1248: iload #6
      //   1250: aload_0
      //   1251: getfield horizontalBias : F
      //   1254: invokevirtual getFloat : (IF)F
      //   1257: putfield horizontalBias : F
      //   1260: goto -> 2030
      //   1263: aload_0
      //   1264: aload_1
      //   1265: iload #6
      //   1267: aload_0
      //   1268: getfield constrainedHeight : Z
      //   1271: invokevirtual getBoolean : (IZ)Z
      //   1274: putfield constrainedHeight : Z
      //   1277: goto -> 2030
      //   1280: aload_0
      //   1281: aload_1
      //   1282: iload #6
      //   1284: aload_0
      //   1285: getfield constrainedWidth : Z
      //   1288: invokevirtual getBoolean : (IZ)Z
      //   1291: putfield constrainedWidth : Z
      //   1294: goto -> 2030
      //   1297: aload_0
      //   1298: aload_1
      //   1299: iload #6
      //   1301: aload_0
      //   1302: getfield goneEndMargin : I
      //   1305: invokevirtual getDimensionPixelSize : (II)I
      //   1308: putfield goneEndMargin : I
      //   1311: goto -> 2030
      //   1314: aload_0
      //   1315: aload_1
      //   1316: iload #6
      //   1318: aload_0
      //   1319: getfield goneStartMargin : I
      //   1322: invokevirtual getDimensionPixelSize : (II)I
      //   1325: putfield goneStartMargin : I
      //   1328: goto -> 2030
      //   1331: aload_0
      //   1332: aload_1
      //   1333: iload #6
      //   1335: aload_0
      //   1336: getfield goneBottomMargin : I
      //   1339: invokevirtual getDimensionPixelSize : (II)I
      //   1342: putfield goneBottomMargin : I
      //   1345: goto -> 2030
      //   1348: aload_0
      //   1349: aload_1
      //   1350: iload #6
      //   1352: aload_0
      //   1353: getfield goneRightMargin : I
      //   1356: invokevirtual getDimensionPixelSize : (II)I
      //   1359: putfield goneRightMargin : I
      //   1362: goto -> 2030
      //   1365: aload_0
      //   1366: aload_1
      //   1367: iload #6
      //   1369: aload_0
      //   1370: getfield goneTopMargin : I
      //   1373: invokevirtual getDimensionPixelSize : (II)I
      //   1376: putfield goneTopMargin : I
      //   1379: goto -> 2030
      //   1382: aload_0
      //   1383: aload_1
      //   1384: iload #6
      //   1386: aload_0
      //   1387: getfield goneLeftMargin : I
      //   1390: invokevirtual getDimensionPixelSize : (II)I
      //   1393: putfield goneLeftMargin : I
      //   1396: goto -> 2030
      //   1399: aload_0
      //   1400: aload_1
      //   1401: iload #6
      //   1403: aload_0
      //   1404: getfield endToEnd : I
      //   1407: invokevirtual getResourceId : (II)I
      //   1410: putfield endToEnd : I
      //   1413: aload_0
      //   1414: getfield endToEnd : I
      //   1417: iconst_m1
      //   1418: if_icmpne -> 2030
      //   1421: aload_0
      //   1422: aload_1
      //   1423: iload #6
      //   1425: iconst_m1
      //   1426: invokevirtual getInt : (II)I
      //   1429: putfield endToEnd : I
      //   1432: goto -> 2030
      //   1435: aload_0
      //   1436: aload_1
      //   1437: iload #6
      //   1439: aload_0
      //   1440: getfield endToStart : I
      //   1443: invokevirtual getResourceId : (II)I
      //   1446: putfield endToStart : I
      //   1449: aload_0
      //   1450: getfield endToStart : I
      //   1453: iconst_m1
      //   1454: if_icmpne -> 2030
      //   1457: aload_0
      //   1458: aload_1
      //   1459: iload #6
      //   1461: iconst_m1
      //   1462: invokevirtual getInt : (II)I
      //   1465: putfield endToStart : I
      //   1468: goto -> 2030
      //   1471: aload_0
      //   1472: aload_1
      //   1473: iload #6
      //   1475: aload_0
      //   1476: getfield startToStart : I
      //   1479: invokevirtual getResourceId : (II)I
      //   1482: putfield startToStart : I
      //   1485: aload_0
      //   1486: getfield startToStart : I
      //   1489: iconst_m1
      //   1490: if_icmpne -> 2030
      //   1493: aload_0
      //   1494: aload_1
      //   1495: iload #6
      //   1497: iconst_m1
      //   1498: invokevirtual getInt : (II)I
      //   1501: putfield startToStart : I
      //   1504: goto -> 2030
      //   1507: aload_0
      //   1508: aload_1
      //   1509: iload #6
      //   1511: aload_0
      //   1512: getfield startToEnd : I
      //   1515: invokevirtual getResourceId : (II)I
      //   1518: putfield startToEnd : I
      //   1521: aload_0
      //   1522: getfield startToEnd : I
      //   1525: iconst_m1
      //   1526: if_icmpne -> 2030
      //   1529: aload_0
      //   1530: aload_1
      //   1531: iload #6
      //   1533: iconst_m1
      //   1534: invokevirtual getInt : (II)I
      //   1537: putfield startToEnd : I
      //   1540: goto -> 2030
      //   1543: aload_0
      //   1544: aload_1
      //   1545: iload #6
      //   1547: aload_0
      //   1548: getfield baselineToBaseline : I
      //   1551: invokevirtual getResourceId : (II)I
      //   1554: putfield baselineToBaseline : I
      //   1557: aload_0
      //   1558: getfield baselineToBaseline : I
      //   1561: iconst_m1
      //   1562: if_icmpne -> 2030
      //   1565: aload_0
      //   1566: aload_1
      //   1567: iload #6
      //   1569: iconst_m1
      //   1570: invokevirtual getInt : (II)I
      //   1573: putfield baselineToBaseline : I
      //   1576: goto -> 2030
      //   1579: aload_0
      //   1580: aload_1
      //   1581: iload #6
      //   1583: aload_0
      //   1584: getfield bottomToBottom : I
      //   1587: invokevirtual getResourceId : (II)I
      //   1590: putfield bottomToBottom : I
      //   1593: aload_0
      //   1594: getfield bottomToBottom : I
      //   1597: iconst_m1
      //   1598: if_icmpne -> 2030
      //   1601: aload_0
      //   1602: aload_1
      //   1603: iload #6
      //   1605: iconst_m1
      //   1606: invokevirtual getInt : (II)I
      //   1609: putfield bottomToBottom : I
      //   1612: goto -> 2030
      //   1615: aload_0
      //   1616: aload_1
      //   1617: iload #6
      //   1619: aload_0
      //   1620: getfield bottomToTop : I
      //   1623: invokevirtual getResourceId : (II)I
      //   1626: putfield bottomToTop : I
      //   1629: aload_0
      //   1630: getfield bottomToTop : I
      //   1633: iconst_m1
      //   1634: if_icmpne -> 2030
      //   1637: aload_0
      //   1638: aload_1
      //   1639: iload #6
      //   1641: iconst_m1
      //   1642: invokevirtual getInt : (II)I
      //   1645: putfield bottomToTop : I
      //   1648: goto -> 2030
      //   1651: aload_0
      //   1652: aload_1
      //   1653: iload #6
      //   1655: aload_0
      //   1656: getfield topToBottom : I
      //   1659: invokevirtual getResourceId : (II)I
      //   1662: putfield topToBottom : I
      //   1665: aload_0
      //   1666: getfield topToBottom : I
      //   1669: iconst_m1
      //   1670: if_icmpne -> 2030
      //   1673: aload_0
      //   1674: aload_1
      //   1675: iload #6
      //   1677: iconst_m1
      //   1678: invokevirtual getInt : (II)I
      //   1681: putfield topToBottom : I
      //   1684: goto -> 2030
      //   1687: aload_0
      //   1688: aload_1
      //   1689: iload #6
      //   1691: aload_0
      //   1692: getfield topToTop : I
      //   1695: invokevirtual getResourceId : (II)I
      //   1698: putfield topToTop : I
      //   1701: aload_0
      //   1702: getfield topToTop : I
      //   1705: iconst_m1
      //   1706: if_icmpne -> 2030
      //   1709: aload_0
      //   1710: aload_1
      //   1711: iload #6
      //   1713: iconst_m1
      //   1714: invokevirtual getInt : (II)I
      //   1717: putfield topToTop : I
      //   1720: goto -> 2030
      //   1723: aload_0
      //   1724: aload_1
      //   1725: iload #6
      //   1727: aload_0
      //   1728: getfield rightToRight : I
      //   1731: invokevirtual getResourceId : (II)I
      //   1734: putfield rightToRight : I
      //   1737: aload_0
      //   1738: getfield rightToRight : I
      //   1741: iconst_m1
      //   1742: if_icmpne -> 2030
      //   1745: aload_0
      //   1746: aload_1
      //   1747: iload #6
      //   1749: iconst_m1
      //   1750: invokevirtual getInt : (II)I
      //   1753: putfield rightToRight : I
      //   1756: goto -> 2030
      //   1759: aload_0
      //   1760: aload_1
      //   1761: iload #6
      //   1763: aload_0
      //   1764: getfield rightToLeft : I
      //   1767: invokevirtual getResourceId : (II)I
      //   1770: putfield rightToLeft : I
      //   1773: aload_0
      //   1774: getfield rightToLeft : I
      //   1777: iconst_m1
      //   1778: if_icmpne -> 2030
      //   1781: aload_0
      //   1782: aload_1
      //   1783: iload #6
      //   1785: iconst_m1
      //   1786: invokevirtual getInt : (II)I
      //   1789: putfield rightToLeft : I
      //   1792: goto -> 2030
      //   1795: aload_0
      //   1796: aload_1
      //   1797: iload #6
      //   1799: aload_0
      //   1800: getfield leftToRight : I
      //   1803: invokevirtual getResourceId : (II)I
      //   1806: putfield leftToRight : I
      //   1809: aload_0
      //   1810: getfield leftToRight : I
      //   1813: iconst_m1
      //   1814: if_icmpne -> 2030
      //   1817: aload_0
      //   1818: aload_1
      //   1819: iload #6
      //   1821: iconst_m1
      //   1822: invokevirtual getInt : (II)I
      //   1825: putfield leftToRight : I
      //   1828: goto -> 2030
      //   1831: aload_0
      //   1832: aload_1
      //   1833: iload #6
      //   1835: aload_0
      //   1836: getfield leftToLeft : I
      //   1839: invokevirtual getResourceId : (II)I
      //   1842: putfield leftToLeft : I
      //   1845: aload_0
      //   1846: getfield leftToLeft : I
      //   1849: iconst_m1
      //   1850: if_icmpne -> 2030
      //   1853: aload_0
      //   1854: aload_1
      //   1855: iload #6
      //   1857: iconst_m1
      //   1858: invokevirtual getInt : (II)I
      //   1861: putfield leftToLeft : I
      //   1864: goto -> 2030
      //   1867: aload_0
      //   1868: aload_1
      //   1869: iload #6
      //   1871: aload_0
      //   1872: getfield guidePercent : F
      //   1875: invokevirtual getFloat : (IF)F
      //   1878: putfield guidePercent : F
      //   1881: goto -> 2030
      //   1884: aload_0
      //   1885: aload_1
      //   1886: iload #6
      //   1888: aload_0
      //   1889: getfield guideEnd : I
      //   1892: invokevirtual getDimensionPixelOffset : (II)I
      //   1895: putfield guideEnd : I
      //   1898: goto -> 2030
      //   1901: aload_0
      //   1902: aload_1
      //   1903: iload #6
      //   1905: aload_0
      //   1906: getfield guideBegin : I
      //   1909: invokevirtual getDimensionPixelOffset : (II)I
      //   1912: putfield guideBegin : I
      //   1915: goto -> 2030
      //   1918: aload_0
      //   1919: aload_1
      //   1920: iload #6
      //   1922: aload_0
      //   1923: getfield circleAngle : F
      //   1926: invokevirtual getFloat : (IF)F
      //   1929: ldc_w 360.0
      //   1932: frem
      //   1933: putfield circleAngle : F
      //   1936: aload_0
      //   1937: getfield circleAngle : F
      //   1940: fstore_3
      //   1941: fload_3
      //   1942: fconst_0
      //   1943: fcmpg
      //   1944: ifge -> 2030
      //   1947: aload_0
      //   1948: ldc_w 360.0
      //   1951: fload_3
      //   1952: fsub
      //   1953: ldc_w 360.0
      //   1956: frem
      //   1957: putfield circleAngle : F
      //   1960: goto -> 2030
      //   1963: aload_0
      //   1964: aload_1
      //   1965: iload #6
      //   1967: aload_0
      //   1968: getfield circleRadius : I
      //   1971: invokevirtual getDimensionPixelSize : (II)I
      //   1974: putfield circleRadius : I
      //   1977: goto -> 2030
      //   1980: aload_0
      //   1981: aload_1
      //   1982: iload #6
      //   1984: aload_0
      //   1985: getfield circleConstraint : I
      //   1988: invokevirtual getResourceId : (II)I
      //   1991: putfield circleConstraint : I
      //   1994: aload_0
      //   1995: getfield circleConstraint : I
      //   1998: iconst_m1
      //   1999: if_icmpne -> 2030
      //   2002: aload_0
      //   2003: aload_1
      //   2004: iload #6
      //   2006: iconst_m1
      //   2007: invokevirtual getInt : (II)I
      //   2010: putfield circleConstraint : I
      //   2013: goto -> 2030
      //   2016: aload_0
      //   2017: aload_1
      //   2018: iload #6
      //   2020: aload_0
      //   2021: getfield orientation : I
      //   2024: invokevirtual getInt : (II)I
      //   2027: putfield orientation : I
      //   2030: iload #5
      //   2032: iconst_1
      //   2033: iadd
      //   2034: istore #5
      //   2036: goto -> 346
      //   2039: aload_1
      //   2040: invokevirtual recycle : ()V
      //   2043: aload_0
      //   2044: invokevirtual validate : ()V
      //   2047: return
      //   2048: astore_2
      //   2049: goto -> 2030
      //   2052: astore_2
      //   2053: goto -> 997
      //   2056: astore_2
      //   2057: goto -> 1038
      //   2060: astore_2
      //   2061: goto -> 1100
      //   2064: astore_2
      //   2065: goto -> 1141
      // Exception table:
      //   from	to	target	type
      //   870	882	2048	java/lang/NumberFormatException
      //   895	914	2048	java/lang/NumberFormatException
      //   917	928	2048	java/lang/NumberFormatException
      //   948	956	2048	java/lang/NumberFormatException
      //   980	994	2052	java/lang/Exception
      //   1021	1035	2056	java/lang/Exception
      //   1083	1097	2060	java/lang/Exception
      //   1124	1138	2064	java/lang/Exception
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.guideBegin = param1LayoutParams.guideBegin;
      this.guideEnd = param1LayoutParams.guideEnd;
      this.guidePercent = param1LayoutParams.guidePercent;
      this.leftToLeft = param1LayoutParams.leftToLeft;
      this.leftToRight = param1LayoutParams.leftToRight;
      this.rightToLeft = param1LayoutParams.rightToLeft;
      this.rightToRight = param1LayoutParams.rightToRight;
      this.topToTop = param1LayoutParams.topToTop;
      this.topToBottom = param1LayoutParams.topToBottom;
      this.bottomToTop = param1LayoutParams.bottomToTop;
      this.bottomToBottom = param1LayoutParams.bottomToBottom;
      this.baselineToBaseline = param1LayoutParams.baselineToBaseline;
      this.circleConstraint = param1LayoutParams.circleConstraint;
      this.circleRadius = param1LayoutParams.circleRadius;
      this.circleAngle = param1LayoutParams.circleAngle;
      this.startToEnd = param1LayoutParams.startToEnd;
      this.startToStart = param1LayoutParams.startToStart;
      this.endToStart = param1LayoutParams.endToStart;
      this.endToEnd = param1LayoutParams.endToEnd;
      this.goneLeftMargin = param1LayoutParams.goneLeftMargin;
      this.goneTopMargin = param1LayoutParams.goneTopMargin;
      this.goneRightMargin = param1LayoutParams.goneRightMargin;
      this.goneBottomMargin = param1LayoutParams.goneBottomMargin;
      this.goneStartMargin = param1LayoutParams.goneStartMargin;
      this.goneEndMargin = param1LayoutParams.goneEndMargin;
      this.horizontalBias = param1LayoutParams.horizontalBias;
      this.verticalBias = param1LayoutParams.verticalBias;
      this.dimensionRatio = param1LayoutParams.dimensionRatio;
      this.a = param1LayoutParams.a;
      this.b = param1LayoutParams.b;
      this.horizontalWeight = param1LayoutParams.horizontalWeight;
      this.verticalWeight = param1LayoutParams.verticalWeight;
      this.horizontalChainStyle = param1LayoutParams.horizontalChainStyle;
      this.verticalChainStyle = param1LayoutParams.verticalChainStyle;
      this.constrainedWidth = param1LayoutParams.constrainedWidth;
      this.constrainedHeight = param1LayoutParams.constrainedHeight;
      this.matchConstraintDefaultWidth = param1LayoutParams.matchConstraintDefaultWidth;
      this.matchConstraintDefaultHeight = param1LayoutParams.matchConstraintDefaultHeight;
      this.matchConstraintMinWidth = param1LayoutParams.matchConstraintMinWidth;
      this.matchConstraintMaxWidth = param1LayoutParams.matchConstraintMaxWidth;
      this.matchConstraintMinHeight = param1LayoutParams.matchConstraintMinHeight;
      this.matchConstraintMaxHeight = param1LayoutParams.matchConstraintMaxHeight;
      this.matchConstraintPercentWidth = param1LayoutParams.matchConstraintPercentWidth;
      this.matchConstraintPercentHeight = param1LayoutParams.matchConstraintPercentHeight;
      this.editorAbsoluteX = param1LayoutParams.editorAbsoluteX;
      this.editorAbsoluteY = param1LayoutParams.editorAbsoluteY;
      this.orientation = param1LayoutParams.orientation;
      this.c = param1LayoutParams.c;
      this.d = param1LayoutParams.d;
      this.e = param1LayoutParams.e;
      this.f = param1LayoutParams.f;
      this.i = param1LayoutParams.i;
      this.j = param1LayoutParams.j;
      this.k = param1LayoutParams.k;
      this.l = param1LayoutParams.l;
      this.m = param1LayoutParams.m;
      this.n = param1LayoutParams.n;
      this.o = param1LayoutParams.o;
      this.s = param1LayoutParams.s;
    }
    
    public void reset() {
      ConstraintWidget constraintWidget = this.s;
      if (constraintWidget != null)
        constraintWidget.reset(); 
    }
    
    public void resolveLayoutDirection(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: getfield leftMargin : I
      //   4: istore #4
      //   6: aload_0
      //   7: getfield rightMargin : I
      //   10: istore #5
      //   12: aload_0
      //   13: iload_1
      //   14: invokespecial resolveLayoutDirection : (I)V
      //   17: aload_0
      //   18: iconst_m1
      //   19: putfield k : I
      //   22: aload_0
      //   23: iconst_m1
      //   24: putfield l : I
      //   27: aload_0
      //   28: iconst_m1
      //   29: putfield i : I
      //   32: aload_0
      //   33: iconst_m1
      //   34: putfield j : I
      //   37: aload_0
      //   38: iconst_m1
      //   39: putfield m : I
      //   42: aload_0
      //   43: iconst_m1
      //   44: putfield n : I
      //   47: aload_0
      //   48: aload_0
      //   49: getfield goneLeftMargin : I
      //   52: putfield m : I
      //   55: aload_0
      //   56: aload_0
      //   57: getfield goneRightMargin : I
      //   60: putfield n : I
      //   63: aload_0
      //   64: aload_0
      //   65: getfield horizontalBias : F
      //   68: putfield o : F
      //   71: aload_0
      //   72: aload_0
      //   73: getfield guideBegin : I
      //   76: putfield p : I
      //   79: aload_0
      //   80: aload_0
      //   81: getfield guideEnd : I
      //   84: putfield q : I
      //   87: aload_0
      //   88: aload_0
      //   89: getfield guidePercent : F
      //   92: putfield r : F
      //   95: aload_0
      //   96: invokevirtual getLayoutDirection : ()I
      //   99: istore_1
      //   100: iconst_0
      //   101: istore_3
      //   102: iconst_1
      //   103: iload_1
      //   104: if_icmpne -> 112
      //   107: iconst_1
      //   108: istore_1
      //   109: goto -> 114
      //   112: iconst_0
      //   113: istore_1
      //   114: iload_1
      //   115: ifeq -> 344
      //   118: aload_0
      //   119: getfield startToEnd : I
      //   122: istore_1
      //   123: iload_1
      //   124: iconst_m1
      //   125: if_icmpeq -> 138
      //   128: aload_0
      //   129: iload_1
      //   130: putfield k : I
      //   133: iconst_1
      //   134: istore_1
      //   135: goto -> 161
      //   138: aload_0
      //   139: getfield startToStart : I
      //   142: istore #6
      //   144: iload_3
      //   145: istore_1
      //   146: iload #6
      //   148: iconst_m1
      //   149: if_icmpeq -> 161
      //   152: aload_0
      //   153: iload #6
      //   155: putfield l : I
      //   158: goto -> 133
      //   161: aload_0
      //   162: getfield endToStart : I
      //   165: istore_3
      //   166: iload_3
      //   167: iconst_m1
      //   168: if_icmpeq -> 178
      //   171: aload_0
      //   172: iload_3
      //   173: putfield j : I
      //   176: iconst_1
      //   177: istore_1
      //   178: aload_0
      //   179: getfield endToEnd : I
      //   182: istore_3
      //   183: iload_3
      //   184: iconst_m1
      //   185: if_icmpeq -> 195
      //   188: aload_0
      //   189: iload_3
      //   190: putfield i : I
      //   193: iconst_1
      //   194: istore_1
      //   195: aload_0
      //   196: getfield goneStartMargin : I
      //   199: istore_3
      //   200: iload_3
      //   201: iconst_m1
      //   202: if_icmpeq -> 210
      //   205: aload_0
      //   206: iload_3
      //   207: putfield n : I
      //   210: aload_0
      //   211: getfield goneEndMargin : I
      //   214: istore_3
      //   215: iload_3
      //   216: iconst_m1
      //   217: if_icmpeq -> 225
      //   220: aload_0
      //   221: iload_3
      //   222: putfield m : I
      //   225: iload_1
      //   226: ifeq -> 239
      //   229: aload_0
      //   230: fconst_1
      //   231: aload_0
      //   232: getfield horizontalBias : F
      //   235: fsub
      //   236: putfield o : F
      //   239: aload_0
      //   240: getfield f : Z
      //   243: ifeq -> 434
      //   246: aload_0
      //   247: getfield orientation : I
      //   250: iconst_1
      //   251: if_icmpne -> 434
      //   254: aload_0
      //   255: getfield guidePercent : F
      //   258: fstore_2
      //   259: fload_2
      //   260: ldc -1.0
      //   262: fcmpl
      //   263: ifeq -> 286
      //   266: aload_0
      //   267: fconst_1
      //   268: fload_2
      //   269: fsub
      //   270: putfield r : F
      //   273: aload_0
      //   274: iconst_m1
      //   275: putfield p : I
      //   278: aload_0
      //   279: iconst_m1
      //   280: putfield q : I
      //   283: goto -> 434
      //   286: aload_0
      //   287: getfield guideBegin : I
      //   290: istore_1
      //   291: iload_1
      //   292: iconst_m1
      //   293: if_icmpeq -> 315
      //   296: aload_0
      //   297: iload_1
      //   298: putfield q : I
      //   301: aload_0
      //   302: iconst_m1
      //   303: putfield p : I
      //   306: aload_0
      //   307: ldc -1.0
      //   309: putfield r : F
      //   312: goto -> 434
      //   315: aload_0
      //   316: getfield guideEnd : I
      //   319: istore_1
      //   320: iload_1
      //   321: iconst_m1
      //   322: if_icmpeq -> 434
      //   325: aload_0
      //   326: iload_1
      //   327: putfield p : I
      //   330: aload_0
      //   331: iconst_m1
      //   332: putfield q : I
      //   335: aload_0
      //   336: ldc -1.0
      //   338: putfield r : F
      //   341: goto -> 434
      //   344: aload_0
      //   345: getfield startToEnd : I
      //   348: istore_1
      //   349: iload_1
      //   350: iconst_m1
      //   351: if_icmpeq -> 359
      //   354: aload_0
      //   355: iload_1
      //   356: putfield j : I
      //   359: aload_0
      //   360: getfield startToStart : I
      //   363: istore_1
      //   364: iload_1
      //   365: iconst_m1
      //   366: if_icmpeq -> 374
      //   369: aload_0
      //   370: iload_1
      //   371: putfield i : I
      //   374: aload_0
      //   375: getfield endToStart : I
      //   378: istore_1
      //   379: iload_1
      //   380: iconst_m1
      //   381: if_icmpeq -> 389
      //   384: aload_0
      //   385: iload_1
      //   386: putfield k : I
      //   389: aload_0
      //   390: getfield endToEnd : I
      //   393: istore_1
      //   394: iload_1
      //   395: iconst_m1
      //   396: if_icmpeq -> 404
      //   399: aload_0
      //   400: iload_1
      //   401: putfield l : I
      //   404: aload_0
      //   405: getfield goneStartMargin : I
      //   408: istore_1
      //   409: iload_1
      //   410: iconst_m1
      //   411: if_icmpeq -> 419
      //   414: aload_0
      //   415: iload_1
      //   416: putfield m : I
      //   419: aload_0
      //   420: getfield goneEndMargin : I
      //   423: istore_1
      //   424: iload_1
      //   425: iconst_m1
      //   426: if_icmpeq -> 434
      //   429: aload_0
      //   430: iload_1
      //   431: putfield n : I
      //   434: aload_0
      //   435: getfield endToStart : I
      //   438: iconst_m1
      //   439: if_icmpne -> 602
      //   442: aload_0
      //   443: getfield endToEnd : I
      //   446: iconst_m1
      //   447: if_icmpne -> 602
      //   450: aload_0
      //   451: getfield startToStart : I
      //   454: iconst_m1
      //   455: if_icmpne -> 602
      //   458: aload_0
      //   459: getfield startToEnd : I
      //   462: iconst_m1
      //   463: if_icmpne -> 602
      //   466: aload_0
      //   467: getfield rightToLeft : I
      //   470: istore_1
      //   471: iload_1
      //   472: iconst_m1
      //   473: if_icmpeq -> 502
      //   476: aload_0
      //   477: iload_1
      //   478: putfield k : I
      //   481: aload_0
      //   482: getfield rightMargin : I
      //   485: ifgt -> 535
      //   488: iload #5
      //   490: ifle -> 535
      //   493: aload_0
      //   494: iload #5
      //   496: putfield rightMargin : I
      //   499: goto -> 535
      //   502: aload_0
      //   503: getfield rightToRight : I
      //   506: istore_1
      //   507: iload_1
      //   508: iconst_m1
      //   509: if_icmpeq -> 535
      //   512: aload_0
      //   513: iload_1
      //   514: putfield l : I
      //   517: aload_0
      //   518: getfield rightMargin : I
      //   521: ifgt -> 535
      //   524: iload #5
      //   526: ifle -> 535
      //   529: aload_0
      //   530: iload #5
      //   532: putfield rightMargin : I
      //   535: aload_0
      //   536: getfield leftToLeft : I
      //   539: istore_1
      //   540: iload_1
      //   541: iconst_m1
      //   542: if_icmpeq -> 569
      //   545: aload_0
      //   546: iload_1
      //   547: putfield i : I
      //   550: aload_0
      //   551: getfield leftMargin : I
      //   554: ifgt -> 602
      //   557: iload #4
      //   559: ifle -> 602
      //   562: aload_0
      //   563: iload #4
      //   565: putfield leftMargin : I
      //   568: return
      //   569: aload_0
      //   570: getfield leftToRight : I
      //   573: istore_1
      //   574: iload_1
      //   575: iconst_m1
      //   576: if_icmpeq -> 602
      //   579: aload_0
      //   580: iload_1
      //   581: putfield j : I
      //   584: aload_0
      //   585: getfield leftMargin : I
      //   588: ifgt -> 602
      //   591: iload #4
      //   593: ifle -> 602
      //   596: aload_0
      //   597: iload #4
      //   599: putfield leftMargin : I
      //   602: return
    }
    
    public void validate() {
      this.f = false;
      this.c = true;
      this.d = true;
      if (this.width == -2 && this.constrainedWidth) {
        this.c = false;
        this.matchConstraintDefaultWidth = 1;
      } 
      if (this.height == -2 && this.constrainedHeight) {
        this.d = false;
        this.matchConstraintDefaultHeight = 1;
      } 
      if (this.width == 0 || this.width == -1) {
        this.c = false;
        if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
          this.width = -2;
          this.constrainedWidth = true;
        } 
      } 
      if (this.height == 0 || this.height == -1) {
        this.d = false;
        if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
          this.height = -2;
          this.constrainedHeight = true;
        } 
      } 
      if (this.guidePercent != -1.0F || this.guideBegin != -1 || this.guideEnd != -1) {
        this.f = true;
        this.c = true;
        this.d = true;
        if (!(this.s instanceof Guideline))
          this.s = (ConstraintWidget)new Guideline(); 
        ((Guideline)this.s).setOrientation(this.orientation);
      } 
    }
    
    static class Table {
      public static final int ANDROID_ORIENTATION = 1;
      
      public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
      
      public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
      
      public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
      
      public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
      
      public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
      
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
      
      public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
      
      public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
      
      public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
      
      public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
      
      public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
      
      public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
      
      public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
      
      public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
      
      public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
      
      public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
      
      public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
      
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
      
      public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
      
      public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
      
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
      
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
      
      public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
      
      public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
      
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
      
      public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
      
      public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
      
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
      
      public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
      
      public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
      
      public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
      
      public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
      
      public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
      
      public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
      
      public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
      
      public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
      
      public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
      
      public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
      
      public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
      
      public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
      
      public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
      
      public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
      
      public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
      
      public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
      
      public static final int LAYOUT_GONE_MARGIN_END = 26;
      
      public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
      
      public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
      
      public static final int LAYOUT_GONE_MARGIN_START = 25;
      
      public static final int LAYOUT_GONE_MARGIN_TOP = 22;
      
      public static final int UNUSED = 0;
      
      public static final SparseIntArray map = new SparseIntArray();
      
      static {
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
        map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
        map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
        map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
        map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
        map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
      }
    }
  }
  
  static class Table {
    public static final int ANDROID_ORIENTATION = 1;
    
    public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
    
    public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
    
    public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
    
    public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
    
    public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
    
    public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
    
    public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
    
    public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
    
    public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
    
    public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
    
    public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
    
    public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
    
    public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
    
    public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
    
    public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
    
    public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
    
    public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
    
    public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
    
    public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
    
    public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
    
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
    
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
    
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
    
    public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
    
    public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
    
    public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
    
    public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
    
    public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
    
    public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
    
    public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
    
    public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
    
    public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
    
    public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
    
    public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
    
    public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
    
    public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
    
    public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
    
    public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
    
    public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
    
    public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
    
    public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
    
    public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
    
    public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
    
    public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
    
    public static final int LAYOUT_GONE_MARGIN_END = 26;
    
    public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
    
    public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
    
    public static final int LAYOUT_GONE_MARGIN_START = 25;
    
    public static final int LAYOUT_GONE_MARGIN_TOP = 22;
    
    public static final int UNUSED = 0;
    
    public static final SparseIntArray map = new SparseIntArray();
    
    static {
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
      map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
      map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
      map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
      map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
      map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\widget\ConstraintLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */