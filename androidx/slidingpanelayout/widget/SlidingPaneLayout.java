package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
  View a;
  
  float b;
  
  int c;
  
  boolean d;
  
  final ViewDragHelper e;
  
  boolean f;
  
  final ArrayList<DisableLayerRunnable> g = new ArrayList<DisableLayerRunnable>();
  
  private int h = -858993460;
  
  private int i;
  
  private Drawable j;
  
  private Drawable k;
  
  private final int l;
  
  private boolean m;
  
  private float n;
  
  private int o;
  
  private float p;
  
  private float q;
  
  private PanelSlideListener r;
  
  private boolean s = true;
  
  private final Rect t = new Rect();
  
  private Method u;
  
  private Field v;
  
  private boolean w;
  
  public SlidingPaneLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    this.l = (int)(32.0F * f + 0.5F);
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate((View)this, new AccessibilityDelegate(this));
    ViewCompat.setImportantForAccessibility((View)this, 1);
    this.e = ViewDragHelper.create(this, 0.5F, new DragHelperCallback(this));
    this.e.setMinVelocity(f * 400.0F);
  }
  
  private void a(float paramFloat) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Z
    //   4: istore #8
    //   6: aload_0
    //   7: getfield a : Landroid/view/View;
    //   10: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   13: checkcast androidx/slidingpanelayout/widget/SlidingPaneLayout$LayoutParams
    //   16: astore #10
    //   18: aload #10
    //   20: getfield b : Z
    //   23: istore #9
    //   25: iconst_0
    //   26: istore #4
    //   28: iload #9
    //   30: ifeq -> 62
    //   33: iload #8
    //   35: ifeq -> 47
    //   38: aload #10
    //   40: getfield rightMargin : I
    //   43: istore_3
    //   44: goto -> 53
    //   47: aload #10
    //   49: getfield leftMargin : I
    //   52: istore_3
    //   53: iload_3
    //   54: ifgt -> 62
    //   57: iconst_1
    //   58: istore_3
    //   59: goto -> 64
    //   62: iconst_0
    //   63: istore_3
    //   64: aload_0
    //   65: invokevirtual getChildCount : ()I
    //   68: istore #7
    //   70: iload #4
    //   72: iload #7
    //   74: if_icmpge -> 202
    //   77: aload_0
    //   78: iload #4
    //   80: invokevirtual getChildAt : (I)Landroid/view/View;
    //   83: astore #10
    //   85: aload #10
    //   87: aload_0
    //   88: getfield a : Landroid/view/View;
    //   91: if_acmpne -> 97
    //   94: goto -> 193
    //   97: aload_0
    //   98: getfield n : F
    //   101: fstore_2
    //   102: aload_0
    //   103: getfield o : I
    //   106: istore #5
    //   108: fconst_1
    //   109: fload_2
    //   110: fsub
    //   111: iload #5
    //   113: i2f
    //   114: fmul
    //   115: f2i
    //   116: istore #6
    //   118: aload_0
    //   119: fload_1
    //   120: putfield n : F
    //   123: iload #6
    //   125: fconst_1
    //   126: fload_1
    //   127: fsub
    //   128: iload #5
    //   130: i2f
    //   131: fmul
    //   132: f2i
    //   133: isub
    //   134: istore #6
    //   136: iload #6
    //   138: istore #5
    //   140: iload #8
    //   142: ifeq -> 150
    //   145: iload #6
    //   147: ineg
    //   148: istore #5
    //   150: aload #10
    //   152: iload #5
    //   154: invokevirtual offsetLeftAndRight : (I)V
    //   157: iload_3
    //   158: ifeq -> 193
    //   161: aload_0
    //   162: getfield n : F
    //   165: fstore_2
    //   166: iload #8
    //   168: ifeq -> 178
    //   171: fload_2
    //   172: fconst_1
    //   173: fsub
    //   174: fstore_2
    //   175: goto -> 182
    //   178: fconst_1
    //   179: fload_2
    //   180: fsub
    //   181: fstore_2
    //   182: aload_0
    //   183: aload #10
    //   185: fload_2
    //   186: aload_0
    //   187: getfield i : I
    //   190: invokespecial a : (Landroid/view/View;FI)V
    //   193: iload #4
    //   195: iconst_1
    //   196: iadd
    //   197: istore #4
    //   199: goto -> 70
    //   202: return
  }
  
  private void a(View paramView, float paramFloat, int paramInt) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat > 0.0F && paramInt != 0) {
      int i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (layoutParams.c == null)
        layoutParams.c = new Paint(); 
      layoutParams.c.setColorFilter((ColorFilter)new PorterDuffColorFilter(i << 24 | paramInt & 0xFFFFFF, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2)
        paramView.setLayerType(2, layoutParams.c); 
      e(paramView);
      return;
    } 
    if (paramView.getLayerType() != 0) {
      if (layoutParams.c != null)
        layoutParams.c.setColorFilter(null); 
      DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(this, paramView);
      this.g.add(disableLayerRunnable);
      ViewCompat.postOnAnimation((View)this, disableLayerRunnable);
    } 
  }
  
  private boolean a(View paramView, int paramInt) {
    if (this.s || a(0.0F, paramInt)) {
      this.f = false;
      return true;
    } 
    return false;
  }
  
  private boolean b(View paramView, int paramInt) {
    if (this.s || a(1.0F, paramInt)) {
      this.f = true;
      return true;
    } 
    return false;
  }
  
  private static boolean g(View paramView) {
    if (paramView.isOpaque())
      return true; 
    if (Build.VERSION.SDK_INT >= 18)
      return false; 
    Drawable drawable = paramView.getBackground();
    return (drawable != null) ? ((drawable.getOpacity() == -1)) : false;
  }
  
  void a() {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() == 4)
        view.setVisibility(0); 
    } 
  }
  
  void a(int paramInt) {
    if (this.a == null) {
      this.b = 0.0F;
      return;
    } 
    boolean bool = b();
    LayoutParams layoutParams = (LayoutParams)this.a.getLayoutParams();
    int j = this.a.getWidth();
    int i = paramInt;
    if (bool)
      i = getWidth() - paramInt - j; 
    if (bool) {
      paramInt = getPaddingRight();
    } else {
      paramInt = getPaddingLeft();
    } 
    if (bool) {
      j = layoutParams.rightMargin;
    } else {
      j = layoutParams.leftMargin;
    } 
    this.b = (i - paramInt + j) / this.c;
    if (this.o != 0)
      a(this.b); 
    if (layoutParams.b)
      a(this.a, this.b, this.h); 
    a(this.a);
  }
  
  void a(View paramView) {
    PanelSlideListener panelSlideListener = this.r;
    if (panelSlideListener != null)
      panelSlideListener.onPanelSlide(paramView, this.b); 
  }
  
  boolean a(float paramFloat, int paramInt) {
    if (!this.m)
      return false; 
    boolean bool = b();
    LayoutParams layoutParams = (LayoutParams)this.a.getLayoutParams();
    if (bool) {
      paramInt = getPaddingRight();
      int i = layoutParams.rightMargin;
      int j = this.a.getWidth();
      paramInt = (int)(getWidth() - (paramInt + i) + paramFloat * this.c + j);
    } else {
      paramInt = (int)((getPaddingLeft() + layoutParams.leftMargin) + paramFloat * this.c);
    } 
    ViewDragHelper viewDragHelper = this.e;
    View view = this.a;
    if (viewDragHelper.smoothSlideViewTo(view, paramInt, view.getTop())) {
      a();
      ViewCompat.postInvalidateOnAnimation((View)this);
      return true;
    } 
    return false;
  }
  
  void b(View paramView) {
    PanelSlideListener panelSlideListener = this.r;
    if (panelSlideListener != null)
      panelSlideListener.onPanelOpened(paramView); 
    sendAccessibilityEvent(32);
  }
  
  boolean b() {
    return (ViewCompat.getLayoutDirection((View)this) == 1);
  }
  
  void c(View paramView) {
    PanelSlideListener panelSlideListener = this.r;
    if (panelSlideListener != null)
      panelSlideListener.onPanelClosed(paramView); 
    sendAccessibilityEvent(32);
  }
  
  @Deprecated
  public boolean canSlide() {
    return this.m;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
  }
  
  public boolean closePane() {
    return a(this.a, 0);
  }
  
  public void computeScroll() {
    if (this.e.continueSettling(true)) {
      if (!this.m) {
        this.e.abort();
        return;
      } 
      ViewCompat.postInvalidateOnAnimation((View)this);
    } 
  }
  
  void d(View paramView) {
    int i;
    int j;
    byte b1;
    byte b2;
    byte b3;
    byte b4;
    boolean bool = b();
    if (bool) {
      i = getWidth() - getPaddingRight();
    } else {
      i = getPaddingLeft();
    } 
    if (bool) {
      j = getPaddingLeft();
    } else {
      j = getWidth() - getPaddingRight();
    } 
    int m = getPaddingTop();
    int n = getHeight();
    int i1 = getPaddingBottom();
    if (paramView != null && g(paramView)) {
      b1 = paramView.getLeft();
      b2 = paramView.getRight();
      b3 = paramView.getTop();
      b4 = paramView.getBottom();
    } else {
      b1 = 0;
      b2 = 0;
      b3 = 0;
      b4 = 0;
    } 
    int i2 = getChildCount();
    int k;
    for (k = 0; k < i2; k++) {
      View view = getChildAt(k);
      if (view == paramView)
        return; 
      if (view.getVisibility() != 8) {
        if (bool) {
          i3 = j;
        } else {
          i3 = i;
        } 
        int i4 = Math.max(i3, view.getLeft());
        int i5 = Math.max(m, view.getTop());
        if (bool) {
          i3 = i;
        } else {
          i3 = j;
        } 
        int i3 = Math.min(i3, view.getRight());
        int i6 = Math.min(n - i1, view.getBottom());
        if (i4 >= b1 && i5 >= b3 && i3 <= b2 && i6 <= b4) {
          i3 = 4;
        } else {
          i3 = 0;
        } 
        view.setVisibility(i3);
      } 
    } 
  }
  
  public void draw(Canvas paramCanvas) {
    Drawable drawable;
    View view;
    super.draw(paramCanvas);
    if (b()) {
      drawable = this.k;
    } else {
      drawable = this.j;
    } 
    if (getChildCount() > 1) {
      view = getChildAt(1);
    } else {
      view = null;
    } 
    if (view != null) {
      int i;
      int j;
      if (drawable == null)
        return; 
      int m = view.getTop();
      int n = view.getBottom();
      int k = drawable.getIntrinsicWidth();
      if (b()) {
        i = view.getRight();
        j = k + i;
      } else {
        j = view.getLeft();
        i = j;
        k = j - k;
        j = i;
        i = k;
      } 
      drawable.setBounds(i, m, j, n);
      drawable.draw(paramCanvas);
    } 
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save();
    if (this.m && !layoutParams.a && this.a != null) {
      paramCanvas.getClipBounds(this.t);
      if (b()) {
        Rect rect = this.t;
        rect.left = Math.max(rect.left, this.a.getRight());
      } else {
        Rect rect = this.t;
        rect.right = Math.min(rect.right, this.a.getLeft());
      } 
      paramCanvas.clipRect(this.t);
    } 
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  void e(View paramView) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #17
    //   5: if_icmplt -> 23
    //   8: aload_1
    //   9: aload_1
    //   10: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   13: checkcast androidx/slidingpanelayout/widget/SlidingPaneLayout$LayoutParams
    //   16: getfield c : Landroid/graphics/Paint;
    //   19: invokestatic setLayerPaint : (Landroid/view/View;Landroid/graphics/Paint;)V
    //   22: return
    //   23: getstatic android/os/Build$VERSION.SDK_INT : I
    //   26: bipush #16
    //   28: if_icmplt -> 170
    //   31: aload_0
    //   32: getfield w : Z
    //   35: ifne -> 109
    //   38: aload_0
    //   39: ldc android/view/View
    //   41: ldc_w 'getDisplayList'
    //   44: aconst_null
    //   45: checkcast [Ljava/lang/Class;
    //   48: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   51: putfield u : Ljava/lang/reflect/Method;
    //   54: goto -> 69
    //   57: astore_2
    //   58: ldc_w 'SlidingPaneLayout'
    //   61: ldc_w 'Couldn't fetch getDisplayList method; dimming won't work right.'
    //   64: aload_2
    //   65: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   68: pop
    //   69: aload_0
    //   70: ldc android/view/View
    //   72: ldc_w 'mRecreateDisplayList'
    //   75: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   78: putfield v : Ljava/lang/reflect/Field;
    //   81: aload_0
    //   82: getfield v : Ljava/lang/reflect/Field;
    //   85: iconst_1
    //   86: invokevirtual setAccessible : (Z)V
    //   89: goto -> 104
    //   92: astore_2
    //   93: ldc_w 'SlidingPaneLayout'
    //   96: ldc_w 'Couldn't fetch mRecreateDisplayList field; dimming will be slow.'
    //   99: aload_2
    //   100: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   103: pop
    //   104: aload_0
    //   105: iconst_1
    //   106: putfield w : Z
    //   109: aload_0
    //   110: getfield u : Ljava/lang/reflect/Method;
    //   113: ifnull -> 165
    //   116: aload_0
    //   117: getfield v : Ljava/lang/reflect/Field;
    //   120: astore_2
    //   121: aload_2
    //   122: ifnonnull -> 128
    //   125: goto -> 165
    //   128: aload_2
    //   129: aload_1
    //   130: iconst_1
    //   131: invokevirtual setBoolean : (Ljava/lang/Object;Z)V
    //   134: aload_0
    //   135: getfield u : Ljava/lang/reflect/Method;
    //   138: aload_1
    //   139: aconst_null
    //   140: checkcast [Ljava/lang/Object;
    //   143: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: goto -> 170
    //   150: astore_2
    //   151: ldc_w 'SlidingPaneLayout'
    //   154: ldc_w 'Error refreshing display list state'
    //   157: aload_2
    //   158: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   161: pop
    //   162: goto -> 170
    //   165: aload_1
    //   166: invokevirtual invalidate : ()V
    //   169: return
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual getLeft : ()I
    //   175: aload_1
    //   176: invokevirtual getTop : ()I
    //   179: aload_1
    //   180: invokevirtual getRight : ()I
    //   183: aload_1
    //   184: invokevirtual getBottom : ()I
    //   187: invokestatic postInvalidateOnAnimation : (Landroid/view/View;IIII)V
    //   190: return
    // Exception table:
    //   from	to	target	type
    //   38	54	57	java/lang/NoSuchMethodException
    //   69	89	92	java/lang/NoSuchFieldException
    //   128	147	150	java/lang/Exception
  }
  
  boolean f(View paramView) {
    boolean bool2 = false;
    if (paramView == null)
      return false; 
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    boolean bool1 = bool2;
    if (this.m) {
      bool1 = bool2;
      if (layoutParams.b) {
        bool1 = bool2;
        if (this.b > 0.0F)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return (ViewGroup.LayoutParams)new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams));
  }
  
  public int getCoveredFadeColor() {
    return this.i;
  }
  
  public int getParallaxDistance() {
    return this.o;
  }
  
  public int getSliderFadeColor() {
    return this.h;
  }
  
  public boolean isOpen() {
    return (!this.m || this.b == 1.0F);
  }
  
  public boolean isSlideable() {
    return this.m;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.s = true;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.s = true;
    int j = this.g.size();
    for (int i = 0; i < j; i++)
      ((DisableLayerRunnable)this.g.get(i)).run(); 
    this.g.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore #4
    //   6: aload_0
    //   7: getfield m : Z
    //   10: istore #6
    //   12: iconst_1
    //   13: istore #5
    //   15: iload #6
    //   17: ifne -> 70
    //   20: iload #4
    //   22: ifne -> 70
    //   25: aload_0
    //   26: invokevirtual getChildCount : ()I
    //   29: iconst_1
    //   30: if_icmple -> 70
    //   33: aload_0
    //   34: iconst_1
    //   35: invokevirtual getChildAt : (I)Landroid/view/View;
    //   38: astore #7
    //   40: aload #7
    //   42: ifnull -> 70
    //   45: aload_0
    //   46: aload_0
    //   47: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   50: aload #7
    //   52: aload_1
    //   53: invokevirtual getX : ()F
    //   56: f2i
    //   57: aload_1
    //   58: invokevirtual getY : ()F
    //   61: f2i
    //   62: invokevirtual isViewUnder : (Landroid/view/View;II)Z
    //   65: iconst_1
    //   66: ixor
    //   67: putfield f : Z
    //   70: aload_0
    //   71: getfield m : Z
    //   74: ifeq -> 280
    //   77: aload_0
    //   78: getfield d : Z
    //   81: ifeq -> 92
    //   84: iload #4
    //   86: ifeq -> 92
    //   89: goto -> 280
    //   92: iload #4
    //   94: iconst_3
    //   95: if_icmpeq -> 271
    //   98: iload #4
    //   100: iconst_1
    //   101: if_icmpne -> 107
    //   104: goto -> 271
    //   107: iload #4
    //   109: ifeq -> 184
    //   112: iload #4
    //   114: iconst_2
    //   115: if_icmpeq -> 121
    //   118: goto -> 244
    //   121: aload_1
    //   122: invokevirtual getX : ()F
    //   125: fstore_3
    //   126: aload_1
    //   127: invokevirtual getY : ()F
    //   130: fstore_2
    //   131: fload_3
    //   132: aload_0
    //   133: getfield p : F
    //   136: fsub
    //   137: invokestatic abs : (F)F
    //   140: fstore_3
    //   141: fload_2
    //   142: aload_0
    //   143: getfield q : F
    //   146: fsub
    //   147: invokestatic abs : (F)F
    //   150: fstore_2
    //   151: fload_3
    //   152: aload_0
    //   153: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   156: invokevirtual getTouchSlop : ()I
    //   159: i2f
    //   160: fcmpl
    //   161: ifle -> 244
    //   164: fload_2
    //   165: fload_3
    //   166: fcmpl
    //   167: ifle -> 244
    //   170: aload_0
    //   171: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   174: invokevirtual cancel : ()V
    //   177: aload_0
    //   178: iconst_1
    //   179: putfield d : Z
    //   182: iconst_0
    //   183: ireturn
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield d : Z
    //   189: aload_1
    //   190: invokevirtual getX : ()F
    //   193: fstore_2
    //   194: aload_1
    //   195: invokevirtual getY : ()F
    //   198: fstore_3
    //   199: aload_0
    //   200: fload_2
    //   201: putfield p : F
    //   204: aload_0
    //   205: fload_3
    //   206: putfield q : F
    //   209: aload_0
    //   210: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   213: aload_0
    //   214: getfield a : Landroid/view/View;
    //   217: fload_2
    //   218: f2i
    //   219: fload_3
    //   220: f2i
    //   221: invokevirtual isViewUnder : (Landroid/view/View;II)Z
    //   224: ifeq -> 244
    //   227: aload_0
    //   228: aload_0
    //   229: getfield a : Landroid/view/View;
    //   232: invokevirtual f : (Landroid/view/View;)Z
    //   235: ifeq -> 244
    //   238: iconst_1
    //   239: istore #4
    //   241: goto -> 247
    //   244: iconst_0
    //   245: istore #4
    //   247: aload_0
    //   248: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   251: aload_1
    //   252: invokevirtual shouldInterceptTouchEvent : (Landroid/view/MotionEvent;)Z
    //   255: ifne -> 268
    //   258: iload #4
    //   260: ifeq -> 265
    //   263: iconst_1
    //   264: ireturn
    //   265: iconst_0
    //   266: istore #5
    //   268: iload #5
    //   270: ireturn
    //   271: aload_0
    //   272: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   275: invokevirtual cancel : ()V
    //   278: iconst_0
    //   279: ireturn
    //   280: aload_0
    //   281: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   284: invokevirtual cancel : ()V
    //   287: aload_0
    //   288: aload_1
    //   289: invokespecial onInterceptTouchEvent : (Landroid/view/MotionEvent;)Z
    //   292: ireturn
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Z
    //   4: istore #14
    //   6: iload #14
    //   8: ifeq -> 22
    //   11: aload_0
    //   12: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   15: iconst_2
    //   16: invokevirtual setEdgeTrackingEnabled : (I)V
    //   19: goto -> 30
    //   22: aload_0
    //   23: getfield e : Landroidx/customview/widget/ViewDragHelper;
    //   26: iconst_1
    //   27: invokevirtual setEdgeTrackingEnabled : (I)V
    //   30: iload #4
    //   32: iload_2
    //   33: isub
    //   34: istore #9
    //   36: iload #14
    //   38: ifeq -> 49
    //   41: aload_0
    //   42: invokevirtual getPaddingRight : ()I
    //   45: istore_2
    //   46: goto -> 54
    //   49: aload_0
    //   50: invokevirtual getPaddingLeft : ()I
    //   53: istore_2
    //   54: iload #14
    //   56: ifeq -> 68
    //   59: aload_0
    //   60: invokevirtual getPaddingLeft : ()I
    //   63: istore #5
    //   65: goto -> 74
    //   68: aload_0
    //   69: invokevirtual getPaddingRight : ()I
    //   72: istore #5
    //   74: aload_0
    //   75: invokevirtual getPaddingTop : ()I
    //   78: istore #11
    //   80: aload_0
    //   81: invokevirtual getChildCount : ()I
    //   84: istore #10
    //   86: aload_0
    //   87: getfield s : Z
    //   90: ifeq -> 122
    //   93: aload_0
    //   94: getfield m : Z
    //   97: ifeq -> 113
    //   100: aload_0
    //   101: getfield f : Z
    //   104: ifeq -> 113
    //   107: fconst_1
    //   108: fstore #6
    //   110: goto -> 116
    //   113: fconst_0
    //   114: fstore #6
    //   116: aload_0
    //   117: fload #6
    //   119: putfield b : F
    //   122: iload_2
    //   123: istore_3
    //   124: iconst_0
    //   125: istore #7
    //   127: iload #7
    //   129: iload #10
    //   131: if_icmpge -> 429
    //   134: aload_0
    //   135: iload #7
    //   137: invokevirtual getChildAt : (I)Landroid/view/View;
    //   140: astore #15
    //   142: aload #15
    //   144: invokevirtual getVisibility : ()I
    //   147: bipush #8
    //   149: if_icmpne -> 155
    //   152: goto -> 420
    //   155: aload #15
    //   157: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   160: checkcast androidx/slidingpanelayout/widget/SlidingPaneLayout$LayoutParams
    //   163: astore #16
    //   165: aload #15
    //   167: invokevirtual getMeasuredWidth : ()I
    //   170: istore #12
    //   172: aload #16
    //   174: getfield a : Z
    //   177: ifeq -> 318
    //   180: aload #16
    //   182: getfield leftMargin : I
    //   185: istore #4
    //   187: aload #16
    //   189: getfield rightMargin : I
    //   192: istore #13
    //   194: iload #9
    //   196: iload #5
    //   198: isub
    //   199: istore #8
    //   201: iload_2
    //   202: iload #8
    //   204: aload_0
    //   205: getfield l : I
    //   208: isub
    //   209: invokestatic min : (II)I
    //   212: iload_3
    //   213: isub
    //   214: iload #4
    //   216: iload #13
    //   218: iadd
    //   219: isub
    //   220: istore #13
    //   222: aload_0
    //   223: iload #13
    //   225: putfield c : I
    //   228: iload #14
    //   230: ifeq -> 243
    //   233: aload #16
    //   235: getfield rightMargin : I
    //   238: istore #4
    //   240: goto -> 250
    //   243: aload #16
    //   245: getfield leftMargin : I
    //   248: istore #4
    //   250: iload_3
    //   251: iload #4
    //   253: iadd
    //   254: iload #13
    //   256: iadd
    //   257: iload #12
    //   259: iconst_2
    //   260: idiv
    //   261: iadd
    //   262: iload #8
    //   264: if_icmple -> 272
    //   267: iconst_1
    //   268: istore_1
    //   269: goto -> 274
    //   272: iconst_0
    //   273: istore_1
    //   274: aload #16
    //   276: iload_1
    //   277: putfield b : Z
    //   280: iload #13
    //   282: i2f
    //   283: aload_0
    //   284: getfield b : F
    //   287: fmul
    //   288: f2i
    //   289: istore #8
    //   291: iload #4
    //   293: iload #8
    //   295: iadd
    //   296: iload_3
    //   297: iadd
    //   298: istore_3
    //   299: aload_0
    //   300: iload #8
    //   302: i2f
    //   303: aload_0
    //   304: getfield c : I
    //   307: i2f
    //   308: fdiv
    //   309: putfield b : F
    //   312: iconst_0
    //   313: istore #4
    //   315: goto -> 356
    //   318: aload_0
    //   319: getfield m : Z
    //   322: ifeq -> 351
    //   325: aload_0
    //   326: getfield o : I
    //   329: istore_3
    //   330: iload_3
    //   331: ifeq -> 351
    //   334: fconst_1
    //   335: aload_0
    //   336: getfield b : F
    //   339: fsub
    //   340: iload_3
    //   341: i2f
    //   342: fmul
    //   343: f2i
    //   344: istore #4
    //   346: iload_2
    //   347: istore_3
    //   348: goto -> 356
    //   351: iload_2
    //   352: istore_3
    //   353: iconst_0
    //   354: istore #4
    //   356: iload #14
    //   358: ifeq -> 380
    //   361: iload #9
    //   363: iload_3
    //   364: isub
    //   365: iload #4
    //   367: iadd
    //   368: istore #8
    //   370: iload #8
    //   372: iload #12
    //   374: isub
    //   375: istore #4
    //   377: goto -> 393
    //   380: iload_3
    //   381: iload #4
    //   383: isub
    //   384: istore #4
    //   386: iload #4
    //   388: iload #12
    //   390: iadd
    //   391: istore #8
    //   393: aload #15
    //   395: iload #4
    //   397: iload #11
    //   399: iload #8
    //   401: aload #15
    //   403: invokevirtual getMeasuredHeight : ()I
    //   406: iload #11
    //   408: iadd
    //   409: invokevirtual layout : (IIII)V
    //   412: iload_2
    //   413: aload #15
    //   415: invokevirtual getWidth : ()I
    //   418: iadd
    //   419: istore_2
    //   420: iload #7
    //   422: iconst_1
    //   423: iadd
    //   424: istore #7
    //   426: goto -> 127
    //   429: aload_0
    //   430: getfield s : Z
    //   433: ifeq -> 530
    //   436: aload_0
    //   437: getfield m : Z
    //   440: ifeq -> 493
    //   443: aload_0
    //   444: getfield o : I
    //   447: ifeq -> 458
    //   450: aload_0
    //   451: aload_0
    //   452: getfield b : F
    //   455: invokespecial a : (F)V
    //   458: aload_0
    //   459: getfield a : Landroid/view/View;
    //   462: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   465: checkcast androidx/slidingpanelayout/widget/SlidingPaneLayout$LayoutParams
    //   468: getfield b : Z
    //   471: ifeq -> 522
    //   474: aload_0
    //   475: aload_0
    //   476: getfield a : Landroid/view/View;
    //   479: aload_0
    //   480: getfield b : F
    //   483: aload_0
    //   484: getfield h : I
    //   487: invokespecial a : (Landroid/view/View;FI)V
    //   490: goto -> 522
    //   493: iconst_0
    //   494: istore_2
    //   495: iload_2
    //   496: iload #10
    //   498: if_icmpge -> 522
    //   501: aload_0
    //   502: aload_0
    //   503: iload_2
    //   504: invokevirtual getChildAt : (I)Landroid/view/View;
    //   507: fconst_0
    //   508: aload_0
    //   509: getfield h : I
    //   512: invokespecial a : (Landroid/view/View;FI)V
    //   515: iload_2
    //   516: iconst_1
    //   517: iadd
    //   518: istore_2
    //   519: goto -> 495
    //   522: aload_0
    //   523: aload_0
    //   524: getfield a : Landroid/view/View;
    //   527: invokevirtual d : (Landroid/view/View;)V
    //   530: aload_0
    //   531: iconst_0
    //   532: putfield s : Z
    //   535: return
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    Object object;
    float f1;
    int k;
    int n;
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (m != 1073741824) {
      if (isInEditMode()) {
        if (m == Integer.MIN_VALUE) {
          k = i;
          n = j;
          paramInt1 = paramInt2;
        } else {
          k = i;
          n = j;
          paramInt1 = paramInt2;
          if (m == 0) {
            k = 300;
            n = j;
            paramInt1 = paramInt2;
          } 
        } 
      } else {
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
      } 
    } else {
      k = i;
      n = j;
      paramInt1 = paramInt2;
      if (j == 0)
        if (isInEditMode()) {
          k = i;
          n = j;
          paramInt1 = paramInt2;
          if (j == 0) {
            n = Integer.MIN_VALUE;
            paramInt1 = 300;
            k = i;
          } 
        } else {
          throw new IllegalStateException("Height must not be UNSPECIFIED");
        }  
    } 
    if (n != Integer.MIN_VALUE) {
      if (n != 1073741824) {
        paramInt1 = 0;
        paramInt2 = 0;
      } else {
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        paramInt2 = paramInt1;
      } 
    } else {
      paramInt2 = paramInt1 - getPaddingTop() - getPaddingBottom();
      paramInt1 = 0;
    } 
    int i2 = k - getPaddingLeft() - getPaddingRight();
    int i3 = getChildCount();
    if (i3 > 2)
      Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported."); 
    this.a = null;
    m = i2;
    int i1 = 0;
    int i4 = 0;
    float f2 = 0.0F;
    for (i = paramInt1; i1 < i3; i = paramInt1) {
      int i6;
      View view = getChildAt(i1);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (view.getVisibility() == 8) {
        layoutParams.b = false;
        Object object2 = object;
        paramInt1 = i;
        continue;
      } 
      Object object1 = object;
      if (layoutParams.weight > 0.0F) {
        f1 = object + layoutParams.weight;
        float f = f1;
        if (layoutParams.width == 0) {
          f = f1;
          paramInt1 = i;
          continue;
        } 
      } 
      paramInt1 = layoutParams.leftMargin + layoutParams.rightMargin;
      if (layoutParams.width == -2) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(i2 - paramInt1, -2147483648);
      } else if (layoutParams.width == -1) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(i2 - paramInt1, 1073741824);
      } else {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
      } 
      if (layoutParams.height == -2) {
        j = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
      } else if (layoutParams.height == -1) {
        j = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      } else {
        j = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
      } 
      view.measure(paramInt1, j);
      j = view.getMeasuredWidth();
      int i5 = view.getMeasuredHeight();
      paramInt1 = i;
      if (n == Integer.MIN_VALUE) {
        paramInt1 = i;
        if (i5 > i)
          paramInt1 = Math.min(i5, paramInt2); 
      } 
      m -= j;
      if (m < 0) {
        i6 = 1;
      } else {
        i6 = 0;
      } 
      layoutParams.a = i6;
      if (layoutParams.a)
        this.a = view; 
      i4 = i6 | i4;
      continue;
      i1++;
      object = SYNTHETIC_LOCAL_VARIABLE_3;
    } 
    if (i4 != 0 || f1 > 0.0F) {
      j = i2 - this.l;
      for (n = 0; n < i3; n++) {
        View view = getChildAt(n);
        if (view.getVisibility() != 8) {
          LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
          if (view.getVisibility() != 8) {
            if (layoutParams.width == 0 && layoutParams.weight > 0.0F) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            } 
            if (paramInt1 != 0) {
              i1 = 0;
            } else {
              i1 = view.getMeasuredWidth();
            } 
            if (i4 != 0 && view != this.a) {
              if (layoutParams.width < 0 && (i1 > j || layoutParams.weight > 0.0F)) {
                if (paramInt1 != 0) {
                  if (layoutParams.height == -2) {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
                  } else if (layoutParams.height == -1) {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                  } else {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                  } 
                } else {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824);
                } 
                view.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), paramInt1);
              } 
            } else if (layoutParams.weight > 0.0F) {
              if (layoutParams.width == 0) {
                if (layoutParams.height == -2) {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
                } else if (layoutParams.height == -1) {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                } else {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                } 
              } else {
                paramInt1 = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824);
              } 
              if (i4 != 0) {
                int i5 = i2 - layoutParams.leftMargin + layoutParams.rightMargin;
                int i6 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                if (i1 != i5)
                  view.measure(i6, paramInt1); 
              } else {
                int i5 = Math.max(0, m);
                view.measure(View.MeasureSpec.makeMeasureSpec(i1 + (int)(layoutParams.weight * i5 / f1), 1073741824), paramInt1);
              } 
            } 
          } 
        } 
      } 
    } 
    setMeasuredDimension(k, i + getPaddingTop() + getPaddingBottom());
    this.m = i4;
    if (this.e.getViewDragState() != 0 && i4 == 0)
      this.e.abort(); 
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    if (savedState.a) {
      openPane();
    } else {
      closePane();
    } 
    this.f = savedState.a;
  }
  
  protected Parcelable onSaveInstanceState() {
    boolean bool;
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    if (isSlideable()) {
      bool = isOpen();
    } else {
      bool = this.f;
    } 
    savedState.a = bool;
    return (Parcelable)savedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      this.s = true; 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!this.m)
      return super.onTouchEvent(paramMotionEvent); 
    this.e.processTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i != 0) {
      if (i != 1)
        return true; 
      if (f(this.a)) {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        float f3 = f1 - this.p;
        float f4 = f2 - this.q;
        i = this.e.getTouchSlop();
        if (f3 * f3 + f4 * f4 < (i * i) && this.e.isViewUnder(this.a, (int)f1, (int)f2)) {
          a(this.a, 0);
          return true;
        } 
      } 
    } else {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.p = f1;
      this.q = f2;
    } 
    return true;
  }
  
  public boolean openPane() {
    return b(this.a, 0);
  }
  
  public void requestChildFocus(View paramView1, View paramView2) {
    super.requestChildFocus(paramView1, paramView2);
    if (!isInTouchMode() && !this.m) {
      boolean bool;
      if (paramView1 == this.a) {
        bool = true;
      } else {
        bool = false;
      } 
      this.f = bool;
    } 
  }
  
  public void setCoveredFadeColor(int paramInt) {
    this.i = paramInt;
  }
  
  public void setPanelSlideListener(PanelSlideListener paramPanelSlideListener) {
    this.r = paramPanelSlideListener;
  }
  
  public void setParallaxDistance(int paramInt) {
    this.o = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable) {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable) {
    this.j = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable) {
    this.k = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(int paramInt) {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt) {
    setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt) {
    setShadowDrawableRight(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(int paramInt) {
    this.h = paramInt;
  }
  
  @Deprecated
  public void smoothSlideClosed() {
    closePane();
  }
  
  @Deprecated
  public void smoothSlideOpen() {
    openPane();
  }
  
  class AccessibilityDelegate extends AccessibilityDelegateCompat {
    private final Rect b = new Rect();
    
    AccessibilityDelegate(SlidingPaneLayout this$0) {}
    
    private void a(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat2) {
      Rect rect = this.b;
      param1AccessibilityNodeInfoCompat2.getBoundsInParent(rect);
      param1AccessibilityNodeInfoCompat1.setBoundsInParent(rect);
      param1AccessibilityNodeInfoCompat2.getBoundsInScreen(rect);
      param1AccessibilityNodeInfoCompat1.setBoundsInScreen(rect);
      param1AccessibilityNodeInfoCompat1.setVisibleToUser(param1AccessibilityNodeInfoCompat2.isVisibleToUser());
      param1AccessibilityNodeInfoCompat1.setPackageName(param1AccessibilityNodeInfoCompat2.getPackageName());
      param1AccessibilityNodeInfoCompat1.setClassName(param1AccessibilityNodeInfoCompat2.getClassName());
      param1AccessibilityNodeInfoCompat1.setContentDescription(param1AccessibilityNodeInfoCompat2.getContentDescription());
      param1AccessibilityNodeInfoCompat1.setEnabled(param1AccessibilityNodeInfoCompat2.isEnabled());
      param1AccessibilityNodeInfoCompat1.setClickable(param1AccessibilityNodeInfoCompat2.isClickable());
      param1AccessibilityNodeInfoCompat1.setFocusable(param1AccessibilityNodeInfoCompat2.isFocusable());
      param1AccessibilityNodeInfoCompat1.setFocused(param1AccessibilityNodeInfoCompat2.isFocused());
      param1AccessibilityNodeInfoCompat1.setAccessibilityFocused(param1AccessibilityNodeInfoCompat2.isAccessibilityFocused());
      param1AccessibilityNodeInfoCompat1.setSelected(param1AccessibilityNodeInfoCompat2.isSelected());
      param1AccessibilityNodeInfoCompat1.setLongClickable(param1AccessibilityNodeInfoCompat2.isLongClickable());
      param1AccessibilityNodeInfoCompat1.addAction(param1AccessibilityNodeInfoCompat2.getActions());
      param1AccessibilityNodeInfoCompat1.setMovementGranularities(param1AccessibilityNodeInfoCompat2.getMovementGranularities());
    }
    
    public boolean filter(View param1View) {
      return this.a.f(param1View);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(param1AccessibilityNodeInfoCompat);
      super.onInitializeAccessibilityNodeInfo(param1View, accessibilityNodeInfoCompat);
      a(param1AccessibilityNodeInfoCompat, accessibilityNodeInfoCompat);
      accessibilityNodeInfoCompat.recycle();
      param1AccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
      param1AccessibilityNodeInfoCompat.setSource(param1View);
      ViewParent viewParent = ViewCompat.getParentForAccessibility(param1View);
      if (viewParent instanceof View)
        param1AccessibilityNodeInfoCompat.setParent((View)viewParent); 
      int j = this.a.getChildCount();
      for (int i = 0; i < j; i++) {
        View view = this.a.getChildAt(i);
        if (!filter(view) && view.getVisibility() == 0) {
          ViewCompat.setImportantForAccessibility(view, 1);
          param1AccessibilityNodeInfoCompat.addChild(view);
        } 
      } 
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return !filter(param1View) ? super.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent) : false;
    }
  }
  
  class DisableLayerRunnable implements Runnable {
    final View a;
    
    DisableLayerRunnable(SlidingPaneLayout this$0, View param1View) {
      this.a = param1View;
    }
    
    public void run() {
      if (this.a.getParent() == this.b) {
        this.a.setLayerType(0, null);
        this.b.e(this.a);
      } 
      this.b.g.remove(this);
    }
  }
  
  class DragHelperCallback extends ViewDragHelper.Callback {
    DragHelperCallback(SlidingPaneLayout this$0) {}
    
    public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
      SlidingPaneLayout.LayoutParams layoutParams = (SlidingPaneLayout.LayoutParams)this.a.a.getLayoutParams();
      if (this.a.b()) {
        param1Int2 = this.a.getWidth() - this.a.getPaddingRight() + layoutParams.rightMargin + this.a.a.getWidth();
        int j = this.a.c;
        return Math.max(Math.min(param1Int1, param1Int2), param1Int2 - j);
      } 
      param1Int2 = this.a.getPaddingLeft() + layoutParams.leftMargin;
      int i = this.a.c;
      return Math.min(Math.max(param1Int1, param1Int2), i + param1Int2);
    }
    
    public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
      return param1View.getTop();
    }
    
    public int getViewHorizontalDragRange(View param1View) {
      return this.a.c;
    }
    
    public void onEdgeDragStarted(int param1Int1, int param1Int2) {
      this.a.e.captureChildView(this.a.a, param1Int2);
    }
    
    public void onViewCaptured(View param1View, int param1Int) {
      this.a.a();
    }
    
    public void onViewDragStateChanged(int param1Int) {
      if (this.a.e.getViewDragState() == 0) {
        if (this.a.b == 0.0F) {
          SlidingPaneLayout slidingPaneLayout1 = this.a;
          slidingPaneLayout1.d(slidingPaneLayout1.a);
          slidingPaneLayout1 = this.a;
          slidingPaneLayout1.c(slidingPaneLayout1.a);
          this.a.f = false;
          return;
        } 
        SlidingPaneLayout slidingPaneLayout = this.a;
        slidingPaneLayout.b(slidingPaneLayout.a);
        this.a.f = true;
      } 
    }
    
    public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.a.a(param1Int1);
      this.a.invalidate();
    }
    
    public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   4: checkcast androidx/slidingpanelayout/widget/SlidingPaneLayout$LayoutParams
      //   7: astore #7
      //   9: aload_0
      //   10: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   13: invokevirtual b : ()Z
      //   16: ifeq -> 109
      //   19: aload_0
      //   20: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   23: invokevirtual getPaddingRight : ()I
      //   26: aload #7
      //   28: getfield rightMargin : I
      //   31: iadd
      //   32: istore #5
      //   34: fload_2
      //   35: fconst_0
      //   36: fcmpg
      //   37: iflt -> 67
      //   40: iload #5
      //   42: istore #4
      //   44: fload_2
      //   45: fconst_0
      //   46: fcmpl
      //   47: ifne -> 79
      //   50: iload #5
      //   52: istore #4
      //   54: aload_0
      //   55: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   58: getfield b : F
      //   61: ldc 0.5
      //   63: fcmpl
      //   64: ifle -> 79
      //   67: iload #5
      //   69: aload_0
      //   70: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   73: getfield c : I
      //   76: iadd
      //   77: istore #4
      //   79: aload_0
      //   80: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   83: getfield a : Landroid/view/View;
      //   86: invokevirtual getWidth : ()I
      //   89: istore #5
      //   91: aload_0
      //   92: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   95: invokevirtual getWidth : ()I
      //   98: iload #4
      //   100: isub
      //   101: iload #5
      //   103: isub
      //   104: istore #4
      //   106: goto -> 176
      //   109: aload_0
      //   110: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   113: invokevirtual getPaddingLeft : ()I
      //   116: istore #4
      //   118: aload #7
      //   120: getfield leftMargin : I
      //   123: iload #4
      //   125: iadd
      //   126: istore #5
      //   128: fload_2
      //   129: fconst_0
      //   130: fcmpl
      //   131: istore #6
      //   133: iload #6
      //   135: ifgt -> 164
      //   138: iload #5
      //   140: istore #4
      //   142: iload #6
      //   144: ifne -> 176
      //   147: iload #5
      //   149: istore #4
      //   151: aload_0
      //   152: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   155: getfield b : F
      //   158: ldc 0.5
      //   160: fcmpl
      //   161: ifle -> 176
      //   164: iload #5
      //   166: aload_0
      //   167: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   170: getfield c : I
      //   173: iadd
      //   174: istore #4
      //   176: aload_0
      //   177: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   180: getfield e : Landroidx/customview/widget/ViewDragHelper;
      //   183: iload #4
      //   185: aload_1
      //   186: invokevirtual getTop : ()I
      //   189: invokevirtual settleCapturedViewAt : (II)Z
      //   192: pop
      //   193: aload_0
      //   194: getfield a : Landroidx/slidingpanelayout/widget/SlidingPaneLayout;
      //   197: invokevirtual invalidate : ()V
      //   200: return
    }
    
    public boolean tryCaptureView(View param1View, int param1Int) {
      return this.a.d ? false : ((SlidingPaneLayout.LayoutParams)param1View.getLayoutParams()).a;
    }
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    private static final int[] d = new int[] { 16843137 };
    
    boolean a;
    
    boolean b;
    
    Paint c;
    
    public float weight = 0.0F;
    
    public LayoutParams() {
      super(-1, -1);
    }
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, d);
      this.weight = typedArray.getFloat(0, 0.0F);
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
    }
  }
  
  public static interface PanelSlideListener {
    void onPanelClosed(View param1View);
    
    void onPanelOpened(View param1View);
    
    void onPanelSlide(View param1View, float param1Float);
  }
  
  static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public SlidingPaneLayout.SavedState createFromParcel(Parcel param2Parcel) {
          return new SlidingPaneLayout.SavedState(param2Parcel, null);
        }
        
        public SlidingPaneLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new SlidingPaneLayout.SavedState(param2Parcel, null);
        }
        
        public SlidingPaneLayout.SavedState[] newArray(int param2Int) {
          return new SlidingPaneLayout.SavedState[param2Int];
        }
      };
    
    boolean a;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      boolean bool;
      if (param1Parcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.a = bool;
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public SlidingPaneLayout.SavedState createFromParcel(Parcel param1Parcel) {
      return new SlidingPaneLayout.SavedState(param1Parcel, null);
    }
    
    public SlidingPaneLayout.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new SlidingPaneLayout.SavedState(param1Parcel, null);
    }
    
    public SlidingPaneLayout.SavedState[] newArray(int param1Int) {
      return new SlidingPaneLayout.SavedState[param1Int];
    }
  }
  
  public static class SimplePanelSlideListener implements PanelSlideListener {
    public void onPanelClosed(View param1View) {}
    
    public void onPanelOpened(View param1View) {}
    
    public void onPanelSlide(View param1View, float param1Float) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\slidingpanelayout\widget\SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */