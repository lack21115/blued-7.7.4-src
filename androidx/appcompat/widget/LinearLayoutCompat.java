package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
  public static final int HORIZONTAL = 0;
  
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  
  public static final int SHOW_DIVIDER_END = 4;
  
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  
  public static final int SHOW_DIVIDER_NONE = 0;
  
  public static final int VERTICAL = 1;
  
  private boolean a = true;
  
  private int b = -1;
  
  private int c = 0;
  
  private int d;
  
  private int e = 8388659;
  
  private int f;
  
  private float g;
  
  private boolean h;
  
  private int[] i;
  
  private int[] j;
  
  private Drawable k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  public LinearLayoutCompat(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt, 0);
    paramInt = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0)
      setOrientation(paramInt); 
    paramInt = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0)
      setGravity(paramInt); 
    boolean bool = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool)
      setBaselineAligned(bool); 
    this.g = tintTypedArray.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0F);
    this.b = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    this.h = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(tintTypedArray.getDrawable(R.styleable.LinearLayoutCompat_divider));
    this.n = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    this.o = tintTypedArray.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    tintTypedArray.recycle();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramView.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
  }
  
  private void c(int paramInt1, int paramInt2) {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (int i = 0; i < paramInt1; i++) {
      View view = b(i);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.width == -1) {
          int k = layoutParams.height;
          layoutParams.height = view.getMeasuredHeight();
          measureChildWithMargins(view, j, 0, paramInt2, 0);
          layoutParams.height = k;
        } 
      } 
    } 
  }
  
  private void d(int paramInt1, int paramInt2) {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    for (int i = 0; i < paramInt1; i++) {
      View view = b(i);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.height == -1) {
          int k = layoutParams.width;
          layoutParams.width = view.getMeasuredWidth();
          measureChildWithMargins(view, paramInt2, 0, j, 0);
          layoutParams.width = k;
        } 
      } 
    } 
  }
  
  int a(View paramView) {
    return 0;
  }
  
  int a(View paramView, int paramInt) {
    return 0;
  }
  
  void a(int paramInt1, int paramInt2) {
    this.f = 0;
    int i2 = getVirtualChildCount();
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i9 = this.b;
    boolean bool1 = this.h;
    float f = 0.0F;
    int i = 0;
    int i4 = 0;
    int m = 0;
    int n = 0;
    int k = 0;
    int i1 = 0;
    int i3 = 0;
    int j = 1;
    boolean bool = false;
    while (i1 < i2) {
      View view = b(i1);
      if (view == null) {
        this.f += d(i1);
      } else if (view.getVisibility() == 8) {
        i1 += a(view, i1);
      } else {
        if (c(i1))
          this.f += this.m; 
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        f += layoutParams.weight;
        if (i5 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0F) {
          i3 = this.f;
          this.f = Math.max(i3, layoutParams.topMargin + i3 + layoutParams.bottomMargin);
          i3 = 1;
        } else {
          if (layoutParams.height == 0 && layoutParams.weight > 0.0F) {
            layoutParams.height = -2;
            i11 = 0;
          } else {
            i11 = Integer.MIN_VALUE;
          } 
          if (f == 0.0F) {
            i12 = this.f;
          } else {
            i12 = 0;
          } 
          a(view, i1, paramInt1, 0, paramInt2, i12);
          if (i11 != Integer.MIN_VALUE)
            layoutParams.height = i11; 
          int i11 = view.getMeasuredHeight();
          int i12 = this.f;
          this.f = Math.max(i12, i12 + i11 + layoutParams.topMargin + layoutParams.bottomMargin + b(view));
          if (bool1)
            m = Math.max(i11, m); 
        } 
        int i10 = i1;
        if (i9 >= 0 && i9 == i10 + 1)
          this.c = this.f; 
        if (i10 >= i9 || layoutParams.weight <= 0.0F) {
          if (i8 != 1073741824 && layoutParams.width == -1) {
            i1 = 1;
            bool = true;
          } else {
            i1 = 0;
          } 
          int i11 = layoutParams.leftMargin + layoutParams.rightMargin;
          int i12 = view.getMeasuredWidth() + i11;
          i4 = Math.max(i4, i12);
          int i13 = View.combineMeasuredStates(i, view.getMeasuredState());
          if (j && layoutParams.width == -1) {
            i = 1;
          } else {
            i = 0;
          } 
          if (layoutParams.weight > 0.0F) {
            if (i1 == 0)
              i11 = i12; 
            n = Math.max(n, i11);
            j = k;
            k = n;
          } else {
            if (i1 == 0)
              i11 = i12; 
            j = Math.max(k, i11);
            k = n;
          } 
          i11 = a(view, i10);
          i1 = i;
          n = k;
          k = j;
          i = i13;
          i11 += i10;
          j = i1;
          i1 = i11;
        } else {
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        } 
      } 
      i1++;
    } 
    if (this.f > 0 && c(i2))
      this.f += this.m; 
    if (bool1 && (i5 == Integer.MIN_VALUE || i5 == 0)) {
      this.f = 0;
      for (i1 = 0; i1 < i2; i1++) {
        View view = b(i1);
        if (view == null) {
          this.f += d(i1);
        } else if (view.getVisibility() == 8) {
          i1 += a(view, i1);
        } else {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          int i10 = this.f;
          this.f = Math.max(i10, i10 + m + layoutParams.topMargin + layoutParams.bottomMargin + b(view));
        } 
      } 
    } 
    this.f += getPaddingTop() + getPaddingBottom();
    int i7 = View.resolveSizeAndState(Math.max(this.f, getSuggestedMinimumHeight()), paramInt2, 0);
    int i6 = (0xFFFFFF & i7) - this.f;
    if (i3 != 0 || (i6 != 0 && f > 0.0F)) {
      float f1 = this.g;
      if (f1 > 0.0F)
        f = f1; 
      this.f = 0;
      i1 = 0;
      n = i6;
      m = i4;
      while (i1 < i2) {
        View view = b(i1);
        if (view.getVisibility() != 8) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          f1 = layoutParams.weight;
          if (f1 > 0.0F) {
            i4 = (int)(n * f1 / f);
            i6 = getPaddingLeft();
            int i10 = getPaddingRight();
            i3 = n - i4;
            n = layoutParams.leftMargin;
            int i11 = layoutParams.rightMargin;
            i9 = layoutParams.width;
            f -= f1;
            i6 = getChildMeasureSpec(paramInt1, i6 + i10 + n + i11, i9);
            if (layoutParams.height != 0 || i5 != 1073741824) {
              i4 = view.getMeasuredHeight() + i4;
              n = i4;
              if (i4 < 0)
                n = 0; 
              view.measure(i6, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
            } else {
              if (i4 > 0) {
                n = i4;
              } else {
                n = 0;
              } 
              view.measure(i6, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
            } 
            i = View.combineMeasuredStates(i, view.getMeasuredState() & 0xFFFFFF00);
            n = i3;
          } 
          i4 = layoutParams.leftMargin + layoutParams.rightMargin;
          i6 = view.getMeasuredWidth() + i4;
          i3 = Math.max(m, i6);
          if (i8 != 1073741824 && layoutParams.width == -1) {
            m = 1;
          } else {
            m = 0;
          } 
          if (m != 0) {
            m = i4;
          } else {
            m = i6;
          } 
          k = Math.max(k, m);
          if (j != 0 && layoutParams.width == -1) {
            j = 1;
          } else {
            j = 0;
          } 
          m = this.f;
          this.f = Math.max(m, view.getMeasuredHeight() + m + layoutParams.topMargin + layoutParams.bottomMargin + b(view));
          m = i3;
        } 
        i1++;
      } 
      this.f += getPaddingTop() + getPaddingBottom();
      n = k;
      k = i;
      i = n;
    } else {
      n = Math.max(k, n);
      if (bool1 && i5 != 1073741824)
        for (k = 0; k < i2; k++) {
          View view = b(k);
          if (view != null && view.getVisibility() != 8 && ((LayoutParams)view.getLayoutParams()).weight > 0.0F)
            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824)); 
        }  
      k = i;
      i = n;
      m = i4;
    } 
    if (j != 0 || i8 == 1073741824)
      i = m; 
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), paramInt1, k), i7);
    if (bool)
      c(i2, paramInt2); 
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    int n = getVirtualChildCount();
    int i1 = this.e;
    paramInt1 = i1 & 0x70;
    if (paramInt1 != 16) {
      if (paramInt1 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.f;
      } 
    } else {
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - this.f) / 2;
    } 
    paramInt2 = 0;
    while (paramInt2 < n) {
      View view = b(paramInt2);
      if (view == null) {
        paramInt3 = paramInt1 + d(paramInt2);
        paramInt4 = paramInt2;
      } else {
        paramInt3 = paramInt1;
        paramInt4 = paramInt2;
        if (view.getVisibility() != 8) {
          int i3 = view.getMeasuredWidth();
          int i2 = view.getMeasuredHeight();
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          paramInt4 = layoutParams.gravity;
          paramInt3 = paramInt4;
          if (paramInt4 < 0)
            paramInt3 = i1 & 0x800007; 
          paramInt3 = GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection((View)this)) & 0x7;
          if (paramInt3 != 1) {
            if (paramInt3 != 5) {
              paramInt3 = layoutParams.leftMargin + i;
            } else {
              paramInt3 = j - k - i3;
              paramInt4 = layoutParams.rightMargin;
              paramInt3 -= paramInt4;
            } 
          } else {
            paramInt3 = (j - i - m - i3) / 2 + i + layoutParams.leftMargin;
            paramInt4 = layoutParams.rightMargin;
            paramInt3 -= paramInt4;
          } 
          paramInt4 = paramInt1;
          if (c(paramInt2))
            paramInt4 = paramInt1 + this.m; 
          paramInt1 = paramInt4 + layoutParams.topMargin;
          a(view, paramInt3, paramInt1 + a(view), i3, i2);
          paramInt3 = layoutParams.bottomMargin;
          i3 = b(view);
          paramInt4 = paramInt2 + a(view, paramInt2);
          paramInt3 = paramInt1 + i2 + paramInt3 + i3;
        } 
      } 
      paramInt2 = paramInt4 + 1;
      paramInt1 = paramInt3;
    } 
  }
  
  void a(Canvas paramCanvas) {
    int j = getVirtualChildCount();
    int i;
    for (i = 0; i < j; i++) {
      View view = b(i);
      if (view != null && view.getVisibility() != 8 && c(i)) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        a(paramCanvas, view.getTop() - layoutParams.topMargin - this.m);
      } 
    } 
    if (c(j)) {
      View view = b(j - 1);
      if (view == null) {
        i = getHeight() - getPaddingBottom() - this.m;
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        i = view.getBottom() + layoutParams.bottomMargin;
      } 
      a(paramCanvas, i);
    } 
  }
  
  void a(Canvas paramCanvas, int paramInt) {
    this.k.setBounds(getPaddingLeft() + this.o, paramInt, getWidth() - getPaddingRight() - this.o, this.m + paramInt);
    this.k.draw(paramCanvas);
  }
  
  void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  int b(View paramView) {
    return 0;
  }
  
  View b(int paramInt) {
    return getChildAt(paramInt);
  }
  
  protected LayoutParams b() {
    int i = this.d;
    return (i == 0) ? new LayoutParams(-2, -2) : ((i == 1) ? new LayoutParams(-1, -2) : null);
  }
  
  protected LayoutParams b(ViewGroup.LayoutParams paramLayoutParams) {
    return new LayoutParams(paramLayoutParams);
  }
  
  void b(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield f : I
    //   5: aload_0
    //   6: invokevirtual getVirtualChildCount : ()I
    //   9: istore #16
    //   11: iload_1
    //   12: invokestatic getMode : (I)I
    //   15: istore #21
    //   17: iload_2
    //   18: invokestatic getMode : (I)I
    //   21: istore #20
    //   23: aload_0
    //   24: getfield i : [I
    //   27: ifnull -> 37
    //   30: aload_0
    //   31: getfield j : [I
    //   34: ifnonnull -> 51
    //   37: aload_0
    //   38: iconst_4
    //   39: newarray int
    //   41: putfield i : [I
    //   44: aload_0
    //   45: iconst_4
    //   46: newarray int
    //   48: putfield j : [I
    //   51: aload_0
    //   52: getfield i : [I
    //   55: astore #27
    //   57: aload_0
    //   58: getfield j : [I
    //   61: astore #25
    //   63: aload #27
    //   65: iconst_3
    //   66: iconst_m1
    //   67: iastore
    //   68: aload #27
    //   70: iconst_2
    //   71: iconst_m1
    //   72: iastore
    //   73: aload #27
    //   75: iconst_1
    //   76: iconst_m1
    //   77: iastore
    //   78: aload #27
    //   80: iconst_0
    //   81: iconst_m1
    //   82: iastore
    //   83: aload #25
    //   85: iconst_3
    //   86: iconst_m1
    //   87: iastore
    //   88: aload #25
    //   90: iconst_2
    //   91: iconst_m1
    //   92: iastore
    //   93: aload #25
    //   95: iconst_1
    //   96: iconst_m1
    //   97: iastore
    //   98: aload #25
    //   100: iconst_0
    //   101: iconst_m1
    //   102: iastore
    //   103: aload_0
    //   104: getfield a : Z
    //   107: istore #23
    //   109: aload_0
    //   110: getfield h : Z
    //   113: istore #24
    //   115: iload #21
    //   117: ldc 1073741824
    //   119: if_icmpne -> 128
    //   122: iconst_1
    //   123: istore #15
    //   125: goto -> 131
    //   128: iconst_0
    //   129: istore #15
    //   131: fconst_0
    //   132: fstore_3
    //   133: iconst_0
    //   134: istore #8
    //   136: iconst_0
    //   137: istore #7
    //   139: iconst_0
    //   140: istore #13
    //   142: iconst_0
    //   143: istore #6
    //   145: iconst_0
    //   146: istore #11
    //   148: iconst_0
    //   149: istore #12
    //   151: iconst_0
    //   152: istore #9
    //   154: iconst_1
    //   155: istore #5
    //   157: iconst_0
    //   158: istore #10
    //   160: iload #8
    //   162: iload #16
    //   164: if_icmpge -> 848
    //   167: aload_0
    //   168: iload #8
    //   170: invokevirtual b : (I)Landroid/view/View;
    //   173: astore #26
    //   175: aload #26
    //   177: ifnonnull -> 198
    //   180: aload_0
    //   181: aload_0
    //   182: getfield f : I
    //   185: aload_0
    //   186: iload #8
    //   188: invokevirtual d : (I)I
    //   191: iadd
    //   192: putfield f : I
    //   195: goto -> 839
    //   198: aload #26
    //   200: invokevirtual getVisibility : ()I
    //   203: bipush #8
    //   205: if_icmpne -> 224
    //   208: iload #8
    //   210: aload_0
    //   211: aload #26
    //   213: iload #8
    //   215: invokevirtual a : (Landroid/view/View;I)I
    //   218: iadd
    //   219: istore #8
    //   221: goto -> 195
    //   224: aload_0
    //   225: iload #8
    //   227: invokevirtual c : (I)Z
    //   230: ifeq -> 246
    //   233: aload_0
    //   234: aload_0
    //   235: getfield f : I
    //   238: aload_0
    //   239: getfield l : I
    //   242: iadd
    //   243: putfield f : I
    //   246: aload #26
    //   248: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   251: checkcast androidx/appcompat/widget/LinearLayoutCompat$LayoutParams
    //   254: astore #28
    //   256: fload_3
    //   257: aload #28
    //   259: getfield weight : F
    //   262: fadd
    //   263: fstore_3
    //   264: iload #21
    //   266: ldc 1073741824
    //   268: if_icmpne -> 380
    //   271: aload #28
    //   273: getfield width : I
    //   276: ifne -> 380
    //   279: aload #28
    //   281: getfield weight : F
    //   284: fconst_0
    //   285: fcmpl
    //   286: ifle -> 380
    //   289: iload #15
    //   291: ifeq -> 317
    //   294: aload_0
    //   295: aload_0
    //   296: getfield f : I
    //   299: aload #28
    //   301: getfield leftMargin : I
    //   304: aload #28
    //   306: getfield rightMargin : I
    //   309: iadd
    //   310: iadd
    //   311: putfield f : I
    //   314: goto -> 346
    //   317: aload_0
    //   318: getfield f : I
    //   321: istore #14
    //   323: aload_0
    //   324: iload #14
    //   326: aload #28
    //   328: getfield leftMargin : I
    //   331: iload #14
    //   333: iadd
    //   334: aload #28
    //   336: getfield rightMargin : I
    //   339: iadd
    //   340: invokestatic max : (II)I
    //   343: putfield f : I
    //   346: iload #23
    //   348: ifeq -> 374
    //   351: iconst_0
    //   352: iconst_0
    //   353: invokestatic makeMeasureSpec : (II)I
    //   356: istore #14
    //   358: aload #26
    //   360: iload #14
    //   362: iload #14
    //   364: invokevirtual measure : (II)V
    //   367: iload #7
    //   369: istore #14
    //   371: goto -> 562
    //   374: iconst_1
    //   375: istore #12
    //   377: goto -> 566
    //   380: aload #28
    //   382: getfield width : I
    //   385: ifne -> 411
    //   388: aload #28
    //   390: getfield weight : F
    //   393: fconst_0
    //   394: fcmpl
    //   395: ifle -> 411
    //   398: aload #28
    //   400: bipush #-2
    //   402: putfield width : I
    //   405: iconst_0
    //   406: istore #14
    //   408: goto -> 415
    //   411: ldc -2147483648
    //   413: istore #14
    //   415: fload_3
    //   416: fconst_0
    //   417: fcmpl
    //   418: ifne -> 430
    //   421: aload_0
    //   422: getfield f : I
    //   425: istore #17
    //   427: goto -> 433
    //   430: iconst_0
    //   431: istore #17
    //   433: aload_0
    //   434: aload #26
    //   436: iload #8
    //   438: iload_1
    //   439: iload #17
    //   441: iload_2
    //   442: iconst_0
    //   443: invokevirtual a : (Landroid/view/View;IIIII)V
    //   446: iload #14
    //   448: ldc -2147483648
    //   450: if_icmpeq -> 460
    //   453: aload #28
    //   455: iload #14
    //   457: putfield width : I
    //   460: aload #26
    //   462: invokevirtual getMeasuredWidth : ()I
    //   465: istore #17
    //   467: iload #15
    //   469: ifeq -> 505
    //   472: aload_0
    //   473: aload_0
    //   474: getfield f : I
    //   477: aload #28
    //   479: getfield leftMargin : I
    //   482: iload #17
    //   484: iadd
    //   485: aload #28
    //   487: getfield rightMargin : I
    //   490: iadd
    //   491: aload_0
    //   492: aload #26
    //   494: invokevirtual b : (Landroid/view/View;)I
    //   497: iadd
    //   498: iadd
    //   499: putfield f : I
    //   502: goto -> 544
    //   505: aload_0
    //   506: getfield f : I
    //   509: istore #14
    //   511: aload_0
    //   512: iload #14
    //   514: iload #14
    //   516: iload #17
    //   518: iadd
    //   519: aload #28
    //   521: getfield leftMargin : I
    //   524: iadd
    //   525: aload #28
    //   527: getfield rightMargin : I
    //   530: iadd
    //   531: aload_0
    //   532: aload #26
    //   534: invokevirtual b : (Landroid/view/View;)I
    //   537: iadd
    //   538: invokestatic max : (II)I
    //   541: putfield f : I
    //   544: iload #7
    //   546: istore #14
    //   548: iload #24
    //   550: ifeq -> 562
    //   553: iload #17
    //   555: iload #7
    //   557: invokestatic max : (II)I
    //   560: istore #14
    //   562: iload #14
    //   564: istore #7
    //   566: iload #8
    //   568: istore #18
    //   570: iload #20
    //   572: ldc 1073741824
    //   574: if_icmpeq -> 595
    //   577: aload #28
    //   579: getfield height : I
    //   582: iconst_m1
    //   583: if_icmpne -> 595
    //   586: iconst_1
    //   587: istore #8
    //   589: iconst_1
    //   590: istore #10
    //   592: goto -> 598
    //   595: iconst_0
    //   596: istore #8
    //   598: aload #28
    //   600: getfield topMargin : I
    //   603: aload #28
    //   605: getfield bottomMargin : I
    //   608: iadd
    //   609: istore #14
    //   611: aload #26
    //   613: invokevirtual getMeasuredHeight : ()I
    //   616: iload #14
    //   618: iadd
    //   619: istore #17
    //   621: iload #9
    //   623: aload #26
    //   625: invokevirtual getMeasuredState : ()I
    //   628: invokestatic combineMeasuredStates : (II)I
    //   631: istore #19
    //   633: iload #23
    //   635: ifeq -> 722
    //   638: aload #26
    //   640: invokevirtual getBaseline : ()I
    //   643: istore #22
    //   645: iload #22
    //   647: iconst_m1
    //   648: if_icmpeq -> 722
    //   651: aload #28
    //   653: getfield gravity : I
    //   656: ifge -> 668
    //   659: aload_0
    //   660: getfield e : I
    //   663: istore #9
    //   665: goto -> 675
    //   668: aload #28
    //   670: getfield gravity : I
    //   673: istore #9
    //   675: iload #9
    //   677: bipush #112
    //   679: iand
    //   680: iconst_4
    //   681: ishr
    //   682: bipush #-2
    //   684: iand
    //   685: iconst_1
    //   686: ishr
    //   687: istore #9
    //   689: aload #27
    //   691: iload #9
    //   693: aload #27
    //   695: iload #9
    //   697: iaload
    //   698: iload #22
    //   700: invokestatic max : (II)I
    //   703: iastore
    //   704: aload #25
    //   706: iload #9
    //   708: aload #25
    //   710: iload #9
    //   712: iaload
    //   713: iload #17
    //   715: iload #22
    //   717: isub
    //   718: invokestatic max : (II)I
    //   721: iastore
    //   722: iload #13
    //   724: iload #17
    //   726: invokestatic max : (II)I
    //   729: istore #13
    //   731: iload #5
    //   733: ifeq -> 751
    //   736: aload #28
    //   738: getfield height : I
    //   741: iconst_m1
    //   742: if_icmpne -> 751
    //   745: iconst_1
    //   746: istore #5
    //   748: goto -> 754
    //   751: iconst_0
    //   752: istore #5
    //   754: aload #28
    //   756: getfield weight : F
    //   759: fconst_0
    //   760: fcmpl
    //   761: ifle -> 788
    //   764: iload #8
    //   766: ifeq -> 772
    //   769: goto -> 776
    //   772: iload #17
    //   774: istore #14
    //   776: iload #11
    //   778: iload #14
    //   780: invokestatic max : (II)I
    //   783: istore #8
    //   785: goto -> 810
    //   788: iload #8
    //   790: ifeq -> 797
    //   793: iload #14
    //   795: istore #17
    //   797: iload #6
    //   799: iload #17
    //   801: invokestatic max : (II)I
    //   804: istore #6
    //   806: iload #11
    //   808: istore #8
    //   810: aload_0
    //   811: aload #26
    //   813: iload #18
    //   815: invokevirtual a : (Landroid/view/View;I)I
    //   818: istore #11
    //   820: iload #19
    //   822: istore #9
    //   824: iload #11
    //   826: iload #18
    //   828: iadd
    //   829: istore #14
    //   831: iload #8
    //   833: istore #11
    //   835: iload #14
    //   837: istore #8
    //   839: iload #8
    //   841: iconst_1
    //   842: iadd
    //   843: istore #8
    //   845: goto -> 160
    //   848: iload #13
    //   850: istore #8
    //   852: aload_0
    //   853: getfield f : I
    //   856: ifle -> 881
    //   859: aload_0
    //   860: iload #16
    //   862: invokevirtual c : (I)Z
    //   865: ifeq -> 881
    //   868: aload_0
    //   869: aload_0
    //   870: getfield f : I
    //   873: aload_0
    //   874: getfield l : I
    //   877: iadd
    //   878: putfield f : I
    //   881: aload #27
    //   883: iconst_1
    //   884: iaload
    //   885: iconst_m1
    //   886: if_icmpne -> 919
    //   889: aload #27
    //   891: iconst_0
    //   892: iaload
    //   893: iconst_m1
    //   894: if_icmpne -> 919
    //   897: aload #27
    //   899: iconst_2
    //   900: iaload
    //   901: iconst_m1
    //   902: if_icmpne -> 919
    //   905: aload #27
    //   907: iconst_3
    //   908: iaload
    //   909: iconst_m1
    //   910: if_icmpeq -> 916
    //   913: goto -> 919
    //   916: goto -> 977
    //   919: iload #8
    //   921: aload #27
    //   923: iconst_3
    //   924: iaload
    //   925: aload #27
    //   927: iconst_0
    //   928: iaload
    //   929: aload #27
    //   931: iconst_1
    //   932: iaload
    //   933: aload #27
    //   935: iconst_2
    //   936: iaload
    //   937: invokestatic max : (II)I
    //   940: invokestatic max : (II)I
    //   943: invokestatic max : (II)I
    //   946: aload #25
    //   948: iconst_3
    //   949: iaload
    //   950: aload #25
    //   952: iconst_0
    //   953: iaload
    //   954: aload #25
    //   956: iconst_1
    //   957: iaload
    //   958: aload #25
    //   960: iconst_2
    //   961: iaload
    //   962: invokestatic max : (II)I
    //   965: invokestatic max : (II)I
    //   968: invokestatic max : (II)I
    //   971: iadd
    //   972: invokestatic max : (II)I
    //   975: istore #8
    //   977: iload #9
    //   979: istore #13
    //   981: iload #8
    //   983: istore #14
    //   985: iload #24
    //   987: ifeq -> 1178
    //   990: iload #21
    //   992: ldc -2147483648
    //   994: if_icmpeq -> 1006
    //   997: iload #8
    //   999: istore #14
    //   1001: iload #21
    //   1003: ifne -> 1178
    //   1006: aload_0
    //   1007: iconst_0
    //   1008: putfield f : I
    //   1011: iconst_0
    //   1012: istore #9
    //   1014: iload #8
    //   1016: istore #14
    //   1018: iload #9
    //   1020: iload #16
    //   1022: if_icmpge -> 1178
    //   1025: aload_0
    //   1026: iload #9
    //   1028: invokevirtual b : (I)Landroid/view/View;
    //   1031: astore #26
    //   1033: aload #26
    //   1035: ifnonnull -> 1056
    //   1038: aload_0
    //   1039: aload_0
    //   1040: getfield f : I
    //   1043: aload_0
    //   1044: iload #9
    //   1046: invokevirtual d : (I)I
    //   1049: iadd
    //   1050: putfield f : I
    //   1053: goto -> 1079
    //   1056: aload #26
    //   1058: invokevirtual getVisibility : ()I
    //   1061: bipush #8
    //   1063: if_icmpne -> 1082
    //   1066: iload #9
    //   1068: aload_0
    //   1069: aload #26
    //   1071: iload #9
    //   1073: invokevirtual a : (Landroid/view/View;I)I
    //   1076: iadd
    //   1077: istore #9
    //   1079: goto -> 1169
    //   1082: aload #26
    //   1084: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1087: checkcast androidx/appcompat/widget/LinearLayoutCompat$LayoutParams
    //   1090: astore #28
    //   1092: iload #15
    //   1094: ifeq -> 1130
    //   1097: aload_0
    //   1098: aload_0
    //   1099: getfield f : I
    //   1102: aload #28
    //   1104: getfield leftMargin : I
    //   1107: iload #7
    //   1109: iadd
    //   1110: aload #28
    //   1112: getfield rightMargin : I
    //   1115: iadd
    //   1116: aload_0
    //   1117: aload #26
    //   1119: invokevirtual b : (Landroid/view/View;)I
    //   1122: iadd
    //   1123: iadd
    //   1124: putfield f : I
    //   1127: goto -> 1079
    //   1130: aload_0
    //   1131: getfield f : I
    //   1134: istore #14
    //   1136: aload_0
    //   1137: iload #14
    //   1139: iload #14
    //   1141: iload #7
    //   1143: iadd
    //   1144: aload #28
    //   1146: getfield leftMargin : I
    //   1149: iadd
    //   1150: aload #28
    //   1152: getfield rightMargin : I
    //   1155: iadd
    //   1156: aload_0
    //   1157: aload #26
    //   1159: invokevirtual b : (Landroid/view/View;)I
    //   1162: iadd
    //   1163: invokestatic max : (II)I
    //   1166: putfield f : I
    //   1169: iload #9
    //   1171: iconst_1
    //   1172: iadd
    //   1173: istore #9
    //   1175: goto -> 1014
    //   1178: aload_0
    //   1179: aload_0
    //   1180: getfield f : I
    //   1183: aload_0
    //   1184: invokevirtual getPaddingLeft : ()I
    //   1187: aload_0
    //   1188: invokevirtual getPaddingRight : ()I
    //   1191: iadd
    //   1192: iadd
    //   1193: putfield f : I
    //   1196: aload_0
    //   1197: getfield f : I
    //   1200: aload_0
    //   1201: invokevirtual getSuggestedMinimumWidth : ()I
    //   1204: invokestatic max : (II)I
    //   1207: iload_1
    //   1208: iconst_0
    //   1209: invokestatic resolveSizeAndState : (III)I
    //   1212: istore #18
    //   1214: ldc_w 16777215
    //   1217: iload #18
    //   1219: iand
    //   1220: aload_0
    //   1221: getfield f : I
    //   1224: isub
    //   1225: istore #17
    //   1227: iload #12
    //   1229: ifne -> 1365
    //   1232: iload #17
    //   1234: ifeq -> 1246
    //   1237: fload_3
    //   1238: fconst_0
    //   1239: fcmpl
    //   1240: ifle -> 1246
    //   1243: goto -> 1365
    //   1246: iload #6
    //   1248: iload #11
    //   1250: invokestatic max : (II)I
    //   1253: istore #9
    //   1255: iload #24
    //   1257: ifeq -> 1350
    //   1260: iload #21
    //   1262: ldc 1073741824
    //   1264: if_icmpeq -> 1350
    //   1267: iconst_0
    //   1268: istore #6
    //   1270: iload #6
    //   1272: iload #16
    //   1274: if_icmpge -> 1350
    //   1277: aload_0
    //   1278: iload #6
    //   1280: invokevirtual b : (I)Landroid/view/View;
    //   1283: astore #25
    //   1285: aload #25
    //   1287: ifnull -> 1341
    //   1290: aload #25
    //   1292: invokevirtual getVisibility : ()I
    //   1295: bipush #8
    //   1297: if_icmpne -> 1303
    //   1300: goto -> 1341
    //   1303: aload #25
    //   1305: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1308: checkcast androidx/appcompat/widget/LinearLayoutCompat$LayoutParams
    //   1311: getfield weight : F
    //   1314: fconst_0
    //   1315: fcmpl
    //   1316: ifle -> 1341
    //   1319: aload #25
    //   1321: iload #7
    //   1323: ldc 1073741824
    //   1325: invokestatic makeMeasureSpec : (II)I
    //   1328: aload #25
    //   1330: invokevirtual getMeasuredHeight : ()I
    //   1333: ldc 1073741824
    //   1335: invokestatic makeMeasureSpec : (II)I
    //   1338: invokevirtual measure : (II)V
    //   1341: iload #6
    //   1343: iconst_1
    //   1344: iadd
    //   1345: istore #6
    //   1347: goto -> 1270
    //   1350: iload #16
    //   1352: istore #8
    //   1354: iload #14
    //   1356: istore #7
    //   1358: iload #9
    //   1360: istore #6
    //   1362: goto -> 2111
    //   1365: aload_0
    //   1366: getfield g : F
    //   1369: fstore #4
    //   1371: fload #4
    //   1373: fconst_0
    //   1374: fcmpl
    //   1375: ifle -> 1381
    //   1378: fload #4
    //   1380: fstore_3
    //   1381: aload #27
    //   1383: iconst_3
    //   1384: iconst_m1
    //   1385: iastore
    //   1386: aload #27
    //   1388: iconst_2
    //   1389: iconst_m1
    //   1390: iastore
    //   1391: aload #27
    //   1393: iconst_1
    //   1394: iconst_m1
    //   1395: iastore
    //   1396: aload #27
    //   1398: iconst_0
    //   1399: iconst_m1
    //   1400: iastore
    //   1401: aload #25
    //   1403: iconst_3
    //   1404: iconst_m1
    //   1405: iastore
    //   1406: aload #25
    //   1408: iconst_2
    //   1409: iconst_m1
    //   1410: iastore
    //   1411: aload #25
    //   1413: iconst_1
    //   1414: iconst_m1
    //   1415: iastore
    //   1416: aload #25
    //   1418: iconst_0
    //   1419: iconst_m1
    //   1420: iastore
    //   1421: aload_0
    //   1422: iconst_0
    //   1423: putfield f : I
    //   1426: iconst_m1
    //   1427: istore #11
    //   1429: iconst_0
    //   1430: istore #12
    //   1432: iload #5
    //   1434: istore #8
    //   1436: iload #16
    //   1438: istore #7
    //   1440: iload #6
    //   1442: istore #9
    //   1444: iload #13
    //   1446: istore #5
    //   1448: iload #17
    //   1450: istore #6
    //   1452: iload #12
    //   1454: istore #13
    //   1456: iload #13
    //   1458: iload #7
    //   1460: if_icmpge -> 1973
    //   1463: aload_0
    //   1464: iload #13
    //   1466: invokevirtual b : (I)Landroid/view/View;
    //   1469: astore #26
    //   1471: aload #26
    //   1473: ifnull -> 1964
    //   1476: aload #26
    //   1478: invokevirtual getVisibility : ()I
    //   1481: bipush #8
    //   1483: if_icmpne -> 1489
    //   1486: goto -> 1964
    //   1489: aload #26
    //   1491: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1494: checkcast androidx/appcompat/widget/LinearLayoutCompat$LayoutParams
    //   1497: astore #28
    //   1499: aload #28
    //   1501: getfield weight : F
    //   1504: fstore #4
    //   1506: fload #4
    //   1508: fconst_0
    //   1509: fcmpl
    //   1510: ifle -> 1673
    //   1513: iload #6
    //   1515: i2f
    //   1516: fload #4
    //   1518: fmul
    //   1519: fload_3
    //   1520: fdiv
    //   1521: f2i
    //   1522: istore #14
    //   1524: iload_2
    //   1525: aload_0
    //   1526: invokevirtual getPaddingTop : ()I
    //   1529: aload_0
    //   1530: invokevirtual getPaddingBottom : ()I
    //   1533: iadd
    //   1534: aload #28
    //   1536: getfield topMargin : I
    //   1539: iadd
    //   1540: aload #28
    //   1542: getfield bottomMargin : I
    //   1545: iadd
    //   1546: aload #28
    //   1548: getfield height : I
    //   1551: invokestatic getChildMeasureSpec : (III)I
    //   1554: istore #17
    //   1556: aload #28
    //   1558: getfield width : I
    //   1561: ifne -> 1606
    //   1564: iload #21
    //   1566: ldc 1073741824
    //   1568: if_icmpeq -> 1574
    //   1571: goto -> 1606
    //   1574: iload #14
    //   1576: ifle -> 1586
    //   1579: iload #14
    //   1581: istore #12
    //   1583: goto -> 1589
    //   1586: iconst_0
    //   1587: istore #12
    //   1589: aload #26
    //   1591: iload #12
    //   1593: ldc 1073741824
    //   1595: invokestatic makeMeasureSpec : (II)I
    //   1598: iload #17
    //   1600: invokevirtual measure : (II)V
    //   1603: goto -> 1642
    //   1606: aload #26
    //   1608: invokevirtual getMeasuredWidth : ()I
    //   1611: iload #14
    //   1613: iadd
    //   1614: istore #16
    //   1616: iload #16
    //   1618: istore #12
    //   1620: iload #16
    //   1622: ifge -> 1628
    //   1625: iconst_0
    //   1626: istore #12
    //   1628: aload #26
    //   1630: iload #12
    //   1632: ldc 1073741824
    //   1634: invokestatic makeMeasureSpec : (II)I
    //   1637: iload #17
    //   1639: invokevirtual measure : (II)V
    //   1642: iload #5
    //   1644: aload #26
    //   1646: invokevirtual getMeasuredState : ()I
    //   1649: ldc_w -16777216
    //   1652: iand
    //   1653: invokestatic combineMeasuredStates : (II)I
    //   1656: istore #5
    //   1658: fload_3
    //   1659: fload #4
    //   1661: fsub
    //   1662: fstore_3
    //   1663: iload #6
    //   1665: iload #14
    //   1667: isub
    //   1668: istore #6
    //   1670: goto -> 1673
    //   1673: iload #15
    //   1675: ifeq -> 1714
    //   1678: aload_0
    //   1679: aload_0
    //   1680: getfield f : I
    //   1683: aload #26
    //   1685: invokevirtual getMeasuredWidth : ()I
    //   1688: aload #28
    //   1690: getfield leftMargin : I
    //   1693: iadd
    //   1694: aload #28
    //   1696: getfield rightMargin : I
    //   1699: iadd
    //   1700: aload_0
    //   1701: aload #26
    //   1703: invokevirtual b : (Landroid/view/View;)I
    //   1706: iadd
    //   1707: iadd
    //   1708: putfield f : I
    //   1711: goto -> 1756
    //   1714: aload_0
    //   1715: getfield f : I
    //   1718: istore #12
    //   1720: aload_0
    //   1721: iload #12
    //   1723: aload #26
    //   1725: invokevirtual getMeasuredWidth : ()I
    //   1728: iload #12
    //   1730: iadd
    //   1731: aload #28
    //   1733: getfield leftMargin : I
    //   1736: iadd
    //   1737: aload #28
    //   1739: getfield rightMargin : I
    //   1742: iadd
    //   1743: aload_0
    //   1744: aload #26
    //   1746: invokevirtual b : (Landroid/view/View;)I
    //   1749: iadd
    //   1750: invokestatic max : (II)I
    //   1753: putfield f : I
    //   1756: iload #20
    //   1758: ldc 1073741824
    //   1760: if_icmpeq -> 1778
    //   1763: aload #28
    //   1765: getfield height : I
    //   1768: iconst_m1
    //   1769: if_icmpne -> 1778
    //   1772: iconst_1
    //   1773: istore #12
    //   1775: goto -> 1781
    //   1778: iconst_0
    //   1779: istore #12
    //   1781: aload #28
    //   1783: getfield topMargin : I
    //   1786: aload #28
    //   1788: getfield bottomMargin : I
    //   1791: iadd
    //   1792: istore #17
    //   1794: aload #26
    //   1796: invokevirtual getMeasuredHeight : ()I
    //   1799: iload #17
    //   1801: iadd
    //   1802: istore #16
    //   1804: iload #11
    //   1806: iload #16
    //   1808: invokestatic max : (II)I
    //   1811: istore #14
    //   1813: iload #12
    //   1815: ifeq -> 1825
    //   1818: iload #17
    //   1820: istore #11
    //   1822: goto -> 1829
    //   1825: iload #16
    //   1827: istore #11
    //   1829: iload #9
    //   1831: iload #11
    //   1833: invokestatic max : (II)I
    //   1836: istore #11
    //   1838: iload #8
    //   1840: ifeq -> 1858
    //   1843: aload #28
    //   1845: getfield height : I
    //   1848: iconst_m1
    //   1849: if_icmpne -> 1858
    //   1852: iconst_1
    //   1853: istore #8
    //   1855: goto -> 1861
    //   1858: iconst_0
    //   1859: istore #8
    //   1861: iload #23
    //   1863: ifeq -> 1953
    //   1866: aload #26
    //   1868: invokevirtual getBaseline : ()I
    //   1871: istore #12
    //   1873: iload #12
    //   1875: iconst_m1
    //   1876: if_icmpeq -> 1953
    //   1879: aload #28
    //   1881: getfield gravity : I
    //   1884: ifge -> 1896
    //   1887: aload_0
    //   1888: getfield e : I
    //   1891: istore #9
    //   1893: goto -> 1903
    //   1896: aload #28
    //   1898: getfield gravity : I
    //   1901: istore #9
    //   1903: iload #9
    //   1905: bipush #112
    //   1907: iand
    //   1908: iconst_4
    //   1909: ishr
    //   1910: bipush #-2
    //   1912: iand
    //   1913: iconst_1
    //   1914: ishr
    //   1915: istore #9
    //   1917: aload #27
    //   1919: iload #9
    //   1921: aload #27
    //   1923: iload #9
    //   1925: iaload
    //   1926: iload #12
    //   1928: invokestatic max : (II)I
    //   1931: iastore
    //   1932: aload #25
    //   1934: iload #9
    //   1936: aload #25
    //   1938: iload #9
    //   1940: iaload
    //   1941: iload #16
    //   1943: iload #12
    //   1945: isub
    //   1946: invokestatic max : (II)I
    //   1949: iastore
    //   1950: goto -> 1953
    //   1953: iload #11
    //   1955: istore #9
    //   1957: iload #14
    //   1959: istore #11
    //   1961: goto -> 1964
    //   1964: iload #13
    //   1966: iconst_1
    //   1967: iadd
    //   1968: istore #13
    //   1970: goto -> 1456
    //   1973: aload_0
    //   1974: aload_0
    //   1975: getfield f : I
    //   1978: aload_0
    //   1979: invokevirtual getPaddingLeft : ()I
    //   1982: aload_0
    //   1983: invokevirtual getPaddingRight : ()I
    //   1986: iadd
    //   1987: iadd
    //   1988: putfield f : I
    //   1991: aload #27
    //   1993: iconst_1
    //   1994: iaload
    //   1995: iconst_m1
    //   1996: if_icmpne -> 2033
    //   1999: aload #27
    //   2001: iconst_0
    //   2002: iaload
    //   2003: iconst_m1
    //   2004: if_icmpne -> 2033
    //   2007: aload #27
    //   2009: iconst_2
    //   2010: iaload
    //   2011: iconst_m1
    //   2012: if_icmpne -> 2033
    //   2015: aload #27
    //   2017: iconst_3
    //   2018: iaload
    //   2019: iconst_m1
    //   2020: if_icmpeq -> 2026
    //   2023: goto -> 2033
    //   2026: iload #11
    //   2028: istore #6
    //   2030: goto -> 2091
    //   2033: iload #11
    //   2035: aload #27
    //   2037: iconst_3
    //   2038: iaload
    //   2039: aload #27
    //   2041: iconst_0
    //   2042: iaload
    //   2043: aload #27
    //   2045: iconst_1
    //   2046: iaload
    //   2047: aload #27
    //   2049: iconst_2
    //   2050: iaload
    //   2051: invokestatic max : (II)I
    //   2054: invokestatic max : (II)I
    //   2057: invokestatic max : (II)I
    //   2060: aload #25
    //   2062: iconst_3
    //   2063: iaload
    //   2064: aload #25
    //   2066: iconst_0
    //   2067: iaload
    //   2068: aload #25
    //   2070: iconst_1
    //   2071: iaload
    //   2072: aload #25
    //   2074: iconst_2
    //   2075: iaload
    //   2076: invokestatic max : (II)I
    //   2079: invokestatic max : (II)I
    //   2082: invokestatic max : (II)I
    //   2085: iadd
    //   2086: invokestatic max : (II)I
    //   2089: istore #6
    //   2091: iload #5
    //   2093: istore #13
    //   2095: iload #8
    //   2097: istore #5
    //   2099: iload #7
    //   2101: istore #8
    //   2103: iload #6
    //   2105: istore #7
    //   2107: iload #9
    //   2109: istore #6
    //   2111: iload #5
    //   2113: ifne -> 2126
    //   2116: iload #20
    //   2118: ldc 1073741824
    //   2120: if_icmpeq -> 2126
    //   2123: goto -> 2130
    //   2126: iload #7
    //   2128: istore #6
    //   2130: aload_0
    //   2131: iload #18
    //   2133: iload #13
    //   2135: ldc_w -16777216
    //   2138: iand
    //   2139: ior
    //   2140: iload #6
    //   2142: aload_0
    //   2143: invokevirtual getPaddingTop : ()I
    //   2146: aload_0
    //   2147: invokevirtual getPaddingBottom : ()I
    //   2150: iadd
    //   2151: iadd
    //   2152: aload_0
    //   2153: invokevirtual getSuggestedMinimumHeight : ()I
    //   2156: invokestatic max : (II)I
    //   2159: iload_2
    //   2160: iload #13
    //   2162: bipush #16
    //   2164: ishl
    //   2165: invokestatic resolveSizeAndState : (III)I
    //   2168: invokevirtual setMeasuredDimension : (II)V
    //   2171: iload #10
    //   2173: ifeq -> 2183
    //   2176: aload_0
    //   2177: iload #8
    //   2179: iload_1
    //   2180: invokespecial d : (II)V
    //   2183: return
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b1;
    byte b2;
    boolean bool1 = ViewUtils.isLayoutRtl((View)this);
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2;
    int m = getPaddingBottom();
    int n = getPaddingBottom();
    int i = getVirtualChildCount();
    paramInt4 = this.e;
    paramInt2 = paramInt4 & 0x70;
    boolean bool2 = this.a;
    int[] arrayOfInt1 = this.i;
    int[] arrayOfInt2 = this.j;
    paramInt4 = GravityCompat.getAbsoluteGravity(0x800007 & paramInt4, ViewCompat.getLayoutDirection((View)this));
    if (paramInt4 != 1) {
      if (paramInt4 != 5) {
        paramInt1 = getPaddingLeft();
      } else {
        paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - this.f;
      } 
    } else {
      paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - this.f) / 2;
    } 
    if (bool1) {
      b1 = i - 1;
      b2 = -1;
    } else {
      b1 = 0;
      b2 = 1;
    } 
    paramInt4 = 0;
    paramInt3 = j;
    while (paramInt4 < i) {
      int i1 = b1 + b2 * paramInt4;
      View view = b(i1);
      if (view == null) {
        paramInt1 += d(i1);
      } else if (view.getVisibility() != 8) {
        int i5 = view.getMeasuredWidth();
        int i6 = view.getMeasuredHeight();
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (bool2 && layoutParams.height != -1) {
          i3 = view.getBaseline();
        } else {
          i3 = -1;
        } 
        int i4 = layoutParams.gravity;
        int i2 = i4;
        if (i4 < 0)
          i2 = paramInt2; 
        i2 &= 0x70;
        if (i2 != 16) {
          if (i2 != 48) {
            if (i2 != 80) {
              i2 = paramInt3;
            } else {
              i4 = k - m - i6 - layoutParams.bottomMargin;
              i2 = i4;
              if (i3 != -1) {
                i2 = view.getMeasuredHeight();
                i2 = i4 - arrayOfInt2[2] - i2 - i3;
              } 
            } 
          } else {
            i4 = layoutParams.topMargin + paramInt3;
            i2 = i4;
            if (i3 != -1)
              i2 = i4 + arrayOfInt1[1] - i3; 
          } 
        } else {
          i2 = (k - j - n - i6) / 2 + paramInt3 + layoutParams.topMargin - layoutParams.bottomMargin;
        } 
        int i3 = paramInt1;
        if (c(i1))
          i3 = paramInt1 + this.l; 
        paramInt1 = layoutParams.leftMargin + i3;
        a(view, paramInt1 + a(view), i2, i5, i6);
        i2 = layoutParams.rightMargin;
        i3 = b(view);
        paramInt4 += a(view, i1);
        paramInt1 += i5 + i2 + i3;
      } 
      paramInt4++;
    } 
  }
  
  void b(Canvas paramCanvas) {
    int j = getVirtualChildCount();
    boolean bool = ViewUtils.isLayoutRtl((View)this);
    int i;
    for (i = 0; i < j; i++) {
      View view = b(i);
      if (view != null && view.getVisibility() != 8 && c(i)) {
        int k;
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (bool) {
          k = view.getRight() + layoutParams.rightMargin;
        } else {
          k = view.getLeft() - layoutParams.leftMargin - this.l;
        } 
        b(paramCanvas, k);
      } 
    } 
    if (c(j)) {
      View view = b(j - 1);
      if (view == null) {
        if (bool) {
          i = getPaddingLeft();
        } else {
          i = getWidth() - getPaddingRight();
          int k = this.l;
          i -= k;
        } 
      } else {
        int k;
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (bool) {
          i = view.getLeft() - layoutParams.leftMargin;
          k = this.l;
        } else {
          i = view.getRight() + layoutParams.rightMargin;
          b(paramCanvas, i);
        } 
        i -= k;
      } 
    } else {
      return;
    } 
    b(paramCanvas, i);
  }
  
  void b(Canvas paramCanvas, int paramInt) {
    this.k.setBounds(paramInt, getPaddingTop() + this.o, this.l + paramInt, getHeight() - getPaddingBottom() - this.o);
    this.k.draw(paramCanvas);
  }
  
  protected boolean c(int paramInt) {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 0) {
      if ((this.n & 0x1) != 0)
        bool1 = true; 
      return bool1;
    } 
    if (paramInt == getChildCount()) {
      bool1 = bool2;
      if ((this.n & 0x4) != 0)
        bool1 = true; 
      return bool1;
    } 
    if ((this.n & 0x2) != 0)
      while (--paramInt >= 0) {
        if (getChildAt(paramInt).getVisibility() != 8)
          return true; 
        paramInt--;
      }  
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  int d(int paramInt) {
    return 0;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getBaseline() {
    if (this.b < 0)
      return super.getBaseline(); 
    int i = getChildCount();
    int j = this.b;
    if (i > j) {
      View view = getChildAt(j);
      int k = view.getBaseline();
      if (k == -1) {
        if (this.b == 0)
          return -1; 
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
      } 
      j = this.c;
      i = j;
      if (this.d == 1) {
        int m = this.e & 0x70;
        i = j;
        if (m != 48)
          if (m != 16) {
            if (m != 80) {
              i = j;
            } else {
              i = getBottom() - getTop() - getPaddingBottom() - this.f;
            } 
          } else {
            i = j + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.f) / 2;
          }  
      } 
      return i + ((LayoutParams)view.getLayoutParams()).topMargin + k;
    } 
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
  }
  
  public int getBaselineAlignedChildIndex() {
    return this.b;
  }
  
  public Drawable getDividerDrawable() {
    return this.k;
  }
  
  public int getDividerPadding() {
    return this.o;
  }
  
  public int getDividerWidth() {
    return this.l;
  }
  
  public int getGravity() {
    return this.e;
  }
  
  public int getOrientation() {
    return this.d;
  }
  
  public int getShowDividers() {
    return this.n;
  }
  
  int getVirtualChildCount() {
    return getChildCount();
  }
  
  public float getWeightSum() {
    return this.g;
  }
  
  public boolean isBaselineAligned() {
    return this.a;
  }
  
  public boolean isMeasureWithLargestChildEnabled() {
    return this.h;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.k == null)
      return; 
    if (this.d == 1) {
      a(paramCanvas);
      return;
    } 
    b(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.d == 1) {
      a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.d == 1) {
      a(paramInt1, paramInt2);
      return;
    } 
    b(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt) {
    if (paramInt >= 0 && paramInt < getChildCount()) {
      this.b = paramInt;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("base aligned child index out of range (0, ");
    stringBuilder.append(getChildCount());
    stringBuilder.append(")");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setDividerDrawable(Drawable paramDrawable) {
    if (paramDrawable == this.k)
      return; 
    this.k = paramDrawable;
    boolean bool = false;
    if (paramDrawable != null) {
      this.l = paramDrawable.getIntrinsicWidth();
      this.m = paramDrawable.getIntrinsicHeight();
    } else {
      this.l = 0;
      this.m = 0;
    } 
    if (paramDrawable == null)
      bool = true; 
    setWillNotDraw(bool);
    requestLayout();
  }
  
  public void setDividerPadding(int paramInt) {
    this.o = paramInt;
  }
  
  public void setGravity(int paramInt) {
    if (this.e != paramInt) {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0)
        i = paramInt | 0x800003; 
      paramInt = i;
      if ((i & 0x70) == 0)
        paramInt = i | 0x30; 
      this.e = paramInt;
      requestLayout();
    } 
  }
  
  public void setHorizontalGravity(int paramInt) {
    paramInt &= 0x800007;
    int i = this.e;
    if ((0x800007 & i) != paramInt) {
      this.e = paramInt | 0xFF7FFFF8 & i;
      requestLayout();
    } 
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void setOrientation(int paramInt) {
    if (this.d != paramInt) {
      this.d = paramInt;
      requestLayout();
    } 
  }
  
  public void setShowDividers(int paramInt) {
    if (paramInt != this.n)
      requestLayout(); 
    this.n = paramInt;
  }
  
  public void setVerticalGravity(int paramInt) {
    paramInt &= 0x70;
    int i = this.e;
    if ((i & 0x70) != paramInt) {
      this.e = paramInt | i & 0xFFFFFF8F;
      requestLayout();
    } 
  }
  
  public void setWeightSum(float paramFloat) {
    this.g = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DividerMode {}
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public int gravity = -1;
    
    public float weight;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.weight = 0.0F;
    }
    
    public LayoutParams(int param1Int1, int param1Int2, float param1Float) {
      super(param1Int1, param1Int2);
      this.weight = param1Float;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.LinearLayoutCompat_Layout);
      this.weight = typedArray.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      this.gravity = typedArray.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      typedArray.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.weight = param1LayoutParams.weight;
      this.gravity = param1LayoutParams.gravity;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OrientationMode {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\LinearLayoutCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */