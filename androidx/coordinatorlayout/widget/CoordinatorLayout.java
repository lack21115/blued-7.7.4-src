package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
  static final String a;
  
  static final Class<?>[] b = new Class[] { Context.class, AttributeSet.class };
  
  static final ThreadLocal<Map<String, Constructor<Behavior>>> c = new ThreadLocal<Map<String, Constructor<Behavior>>>();
  
  static final Comparator<View> d;
  
  private static final Pools.Pool<Rect> f = (Pools.Pool<Rect>)new Pools.SynchronizedPool(12);
  
  ViewGroup.OnHierarchyChangeListener e;
  
  private final List<View> g;
  
  private final DirectedAcyclicGraph<View> h;
  
  private final List<View> i;
  
  private final List<View> j;
  
  private Paint k;
  
  private final int[] l;
  
  private final int[] m;
  
  private boolean n;
  
  private boolean o;
  
  private int[] p;
  
  private View q;
  
  private View r;
  
  private OnPreDrawListener s;
  
  private boolean t;
  
  private WindowInsetsCompat u;
  
  private boolean v;
  
  private Drawable w;
  
  private OnApplyWindowInsetsListener x;
  
  private final NestedScrollingParentHelper y;
  
  public CoordinatorLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.coordinatorLayoutStyle);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray;
    this.g = new ArrayList<View>();
    this.h = new DirectedAcyclicGraph<View>();
    this.i = new ArrayList<View>();
    this.j = new ArrayList<View>();
    this.l = new int[2];
    this.m = new int[2];
    this.y = new NestedScrollingParentHelper(this);
    boolean bool = false;
    if (paramInt == 0) {
      typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
    } else {
      typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout, paramInt, 0);
    } 
    if (Build.VERSION.SDK_INT >= 29)
      if (paramInt == 0) {
        saveAttributeDataForStyleable(paramContext, R.styleable.CoordinatorLayout, paramAttributeSet, typedArray, 0, R.style.Widget_Support_CoordinatorLayout);
      } else {
        saveAttributeDataForStyleable(paramContext, R.styleable.CoordinatorLayout, paramAttributeSet, typedArray, paramInt, 0);
      }  
    paramInt = typedArray.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
    if (paramInt != 0) {
      Resources resources = paramContext.getResources();
      this.p = resources.getIntArray(paramInt);
      float f = (resources.getDisplayMetrics()).density;
      int i = this.p.length;
      for (paramInt = bool; paramInt < i; paramInt++) {
        int[] arrayOfInt = this.p;
        arrayOfInt[paramInt] = (int)(arrayOfInt[paramInt] * f);
      } 
    } 
    this.w = typedArray.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
    typedArray.recycle();
    g();
    super.setOnHierarchyChangeListener(new HierarchyChangeListener(this));
    if (ViewCompat.getImportantForAccessibility((View)this) == 0)
      ViewCompat.setImportantForAccessibility((View)this, 1); 
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 < paramInt2) ? paramInt2 : ((paramInt1 > paramInt3) ? paramInt3 : paramInt1);
  }
  
  static Behavior a(Context paramContext, AttributeSet paramAttributeSet, String paramString) {
    String str;
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (paramString.startsWith(".")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } else if (paramString.indexOf('.') >= 0) {
      str = paramString;
    } else {
      str = paramString;
      if (!TextUtils.isEmpty(a)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append('.');
        stringBuilder.append(paramString);
        str = stringBuilder.toString();
      } 
    } 
    try {
      Map<Object, Object> map2 = (Map)c.get();
      Map<Object, Object> map1 = map2;
      if (map2 == null) {
        map1 = new HashMap<Object, Object>();
        c.set(map1);
      } 
      Constructor<?> constructor2 = (Constructor)map1.get(str);
      Constructor<?> constructor1 = constructor2;
      if (constructor2 == null) {
        constructor1 = Class.forName(str, false, paramContext.getClassLoader()).getConstructor(b);
        constructor1.setAccessible(true);
        map1.put(str, constructor1);
      } 
      return (Behavior)constructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not inflate Behavior subclass ");
      stringBuilder.append(str);
      throw new RuntimeException(stringBuilder.toString(), exception);
    } 
  }
  
  private static void a(Rect paramRect) {
    paramRect.setEmpty();
    f.release(paramRect);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = GravityCompat.getAbsoluteGravity(d(layoutParams.gravity), paramInt2);
    int i2 = i & 0x7;
    int i1 = i & 0x70;
    int n = getWidth();
    int m = getHeight();
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    i = paramInt1;
    if (paramInt2 == 1)
      i = n - paramInt1; 
    paramInt1 = b(i) - j;
    paramInt2 = 0;
    if (i2 != 1) {
      if (i2 == 5)
        paramInt1 += j; 
    } else {
      paramInt1 += j / 2;
    } 
    if (i1 != 16) {
      if (i1 == 80)
        paramInt2 = k + 0; 
    } else {
      paramInt2 = 0 + k / 2;
    } 
    paramInt1 = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(paramInt1, n - getPaddingRight() - j - layoutParams.rightMargin));
    paramInt2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(paramInt2, m - getPaddingBottom() - k - layoutParams.bottomMargin));
    paramView.layout(paramInt1, paramInt2, j + paramInt1, k + paramInt2);
  }
  
  private void a(View paramView, int paramInt1, Rect paramRect1, Rect paramRect2, LayoutParams paramLayoutParams, int paramInt2, int paramInt3) {
    int i = GravityCompat.getAbsoluteGravity(e(paramLayoutParams.gravity), paramInt1);
    paramInt1 = GravityCompat.getAbsoluteGravity(c(paramLayoutParams.anchorGravity), paramInt1);
    int m = i & 0x7;
    int k = i & 0x70;
    int j = paramInt1 & 0x7;
    i = paramInt1 & 0x70;
    if (j != 1) {
      if (j != 5) {
        paramInt1 = paramRect1.left;
      } else {
        paramInt1 = paramRect1.right;
      } 
    } else {
      paramInt1 = paramRect1.left + paramRect1.width() / 2;
    } 
    if (i != 16) {
      if (i != 80) {
        i = paramRect1.top;
      } else {
        i = paramRect1.bottom;
      } 
    } else {
      i = paramRect1.top + paramRect1.height() / 2;
    } 
    if (m != 1) {
      j = paramInt1;
      if (m != 5)
        j = paramInt1 - paramInt2; 
    } else {
      j = paramInt1 - paramInt2 / 2;
    } 
    if (k != 16) {
      paramInt1 = i;
      if (k != 80)
        paramInt1 = i - paramInt3; 
    } else {
      paramInt1 = i - paramInt3 / 2;
    } 
    paramRect2.set(j, paramInt1, paramInt2 + j, paramInt3 + paramInt1);
  }
  
  private void a(View paramView, Rect paramRect, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isLaidOut : (Landroid/view/View;)Z
    //   4: ifne -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual getWidth : ()I
    //   12: ifle -> 452
    //   15: aload_1
    //   16: invokevirtual getHeight : ()I
    //   19: ifgt -> 23
    //   22: return
    //   23: aload_1
    //   24: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   27: checkcast androidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams
    //   30: astore #9
    //   32: aload #9
    //   34: invokevirtual getBehavior : ()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;
    //   37: astore #10
    //   39: invokestatic e : ()Landroid/graphics/Rect;
    //   42: astore #7
    //   44: invokestatic e : ()Landroid/graphics/Rect;
    //   47: astore #8
    //   49: aload #8
    //   51: aload_1
    //   52: invokevirtual getLeft : ()I
    //   55: aload_1
    //   56: invokevirtual getTop : ()I
    //   59: aload_1
    //   60: invokevirtual getRight : ()I
    //   63: aload_1
    //   64: invokevirtual getBottom : ()I
    //   67: invokevirtual set : (IIII)V
    //   70: aload #10
    //   72: ifnull -> 156
    //   75: aload #10
    //   77: aload_0
    //   78: aload_1
    //   79: aload #7
    //   81: invokevirtual getInsetDodgeRect : (Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/graphics/Rect;)Z
    //   84: ifeq -> 156
    //   87: aload #8
    //   89: aload #7
    //   91: invokevirtual contains : (Landroid/graphics/Rect;)Z
    //   94: ifeq -> 100
    //   97: goto -> 163
    //   100: new java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial <init> : ()V
    //   107: astore_1
    //   108: aload_1
    //   109: ldc_w 'Rect should be within the child's bounds. Rect:'
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: aload #7
    //   119: invokevirtual toShortString : ()Ljava/lang/String;
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: ldc_w ' | Bounds:'
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: aload #8
    //   137: invokevirtual toShortString : ()Ljava/lang/String;
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: new java/lang/IllegalArgumentException
    //   147: dup
    //   148: aload_1
    //   149: invokevirtual toString : ()Ljava/lang/String;
    //   152: invokespecial <init> : (Ljava/lang/String;)V
    //   155: athrow
    //   156: aload #7
    //   158: aload #8
    //   160: invokevirtual set : (Landroid/graphics/Rect;)V
    //   163: aload #8
    //   165: invokestatic a : (Landroid/graphics/Rect;)V
    //   168: aload #7
    //   170: invokevirtual isEmpty : ()Z
    //   173: ifeq -> 182
    //   176: aload #7
    //   178: invokestatic a : (Landroid/graphics/Rect;)V
    //   181: return
    //   182: aload #9
    //   184: getfield dodgeInsetEdges : I
    //   187: iload_3
    //   188: invokestatic getAbsoluteGravity : (II)I
    //   191: istore #5
    //   193: iload #5
    //   195: bipush #48
    //   197: iand
    //   198: bipush #48
    //   200: if_icmpne -> 245
    //   203: aload #7
    //   205: getfield top : I
    //   208: aload #9
    //   210: getfield topMargin : I
    //   213: isub
    //   214: aload #9
    //   216: getfield e : I
    //   219: isub
    //   220: istore_3
    //   221: iload_3
    //   222: aload_2
    //   223: getfield top : I
    //   226: if_icmpge -> 245
    //   229: aload_0
    //   230: aload_1
    //   231: aload_2
    //   232: getfield top : I
    //   235: iload_3
    //   236: isub
    //   237: invokespecial d : (Landroid/view/View;I)V
    //   240: iconst_1
    //   241: istore_3
    //   242: goto -> 247
    //   245: iconst_0
    //   246: istore_3
    //   247: iload_3
    //   248: istore #4
    //   250: iload #5
    //   252: bipush #80
    //   254: iand
    //   255: bipush #80
    //   257: if_icmpne -> 311
    //   260: aload_0
    //   261: invokevirtual getHeight : ()I
    //   264: aload #7
    //   266: getfield bottom : I
    //   269: isub
    //   270: aload #9
    //   272: getfield bottomMargin : I
    //   275: isub
    //   276: aload #9
    //   278: getfield e : I
    //   281: iadd
    //   282: istore #6
    //   284: iload_3
    //   285: istore #4
    //   287: iload #6
    //   289: aload_2
    //   290: getfield bottom : I
    //   293: if_icmpge -> 311
    //   296: aload_0
    //   297: aload_1
    //   298: iload #6
    //   300: aload_2
    //   301: getfield bottom : I
    //   304: isub
    //   305: invokespecial d : (Landroid/view/View;I)V
    //   308: iconst_1
    //   309: istore #4
    //   311: iload #4
    //   313: ifne -> 322
    //   316: aload_0
    //   317: aload_1
    //   318: iconst_0
    //   319: invokespecial d : (Landroid/view/View;I)V
    //   322: iload #5
    //   324: iconst_3
    //   325: iand
    //   326: iconst_3
    //   327: if_icmpne -> 372
    //   330: aload #7
    //   332: getfield left : I
    //   335: aload #9
    //   337: getfield leftMargin : I
    //   340: isub
    //   341: aload #9
    //   343: getfield d : I
    //   346: isub
    //   347: istore_3
    //   348: iload_3
    //   349: aload_2
    //   350: getfield left : I
    //   353: if_icmpge -> 372
    //   356: aload_0
    //   357: aload_1
    //   358: aload_2
    //   359: getfield left : I
    //   362: iload_3
    //   363: isub
    //   364: invokespecial c : (Landroid/view/View;I)V
    //   367: iconst_1
    //   368: istore_3
    //   369: goto -> 374
    //   372: iconst_0
    //   373: istore_3
    //   374: iload_3
    //   375: istore #4
    //   377: iload #5
    //   379: iconst_5
    //   380: iand
    //   381: iconst_5
    //   382: if_icmpne -> 436
    //   385: aload_0
    //   386: invokevirtual getWidth : ()I
    //   389: aload #7
    //   391: getfield right : I
    //   394: isub
    //   395: aload #9
    //   397: getfield rightMargin : I
    //   400: isub
    //   401: aload #9
    //   403: getfield d : I
    //   406: iadd
    //   407: istore #5
    //   409: iload_3
    //   410: istore #4
    //   412: iload #5
    //   414: aload_2
    //   415: getfield right : I
    //   418: if_icmpge -> 436
    //   421: aload_0
    //   422: aload_1
    //   423: iload #5
    //   425: aload_2
    //   426: getfield right : I
    //   429: isub
    //   430: invokespecial c : (Landroid/view/View;I)V
    //   433: iconst_1
    //   434: istore #4
    //   436: iload #4
    //   438: ifne -> 447
    //   441: aload_0
    //   442: aload_1
    //   443: iconst_0
    //   444: invokespecial c : (Landroid/view/View;I)V
    //   447: aload #7
    //   449: invokestatic a : (Landroid/graphics/Rect;)V
    //   452: return
  }
  
  private void a(View paramView1, View paramView2, int paramInt) {
    Rect rect1 = e();
    Rect rect2 = e();
    try {
      a(paramView2, rect1);
      a(paramView1, paramInt, rect1, rect2);
      paramView1.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
      return;
    } finally {
      a(rect1);
      a(rect2);
    } 
  }
  
  private void a(LayoutParams paramLayoutParams, Rect paramRect, int paramInt1, int paramInt2) {
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + paramLayoutParams.leftMargin, Math.min(paramRect.left, j - getPaddingRight() - paramInt1 - paramLayoutParams.rightMargin));
    i = Math.max(getPaddingTop() + paramLayoutParams.topMargin, Math.min(paramRect.top, i - getPaddingBottom() - paramInt2 - paramLayoutParams.bottomMargin));
    paramRect.set(j, i, paramInt1 + j, paramInt2 + i);
  }
  
  private void a(List<View> paramList) {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int j = getChildCount();
    for (int i = j - 1; i >= 0; i--) {
      int k;
      if (bool) {
        k = getChildDrawingOrder(j, i);
      } else {
        k = i;
      } 
      paramList.add(getChildAt(k));
    } 
    Comparator<View> comparator = d;
    if (comparator != null)
      Collections.sort(paramList, comparator); 
  }
  
  private void a(boolean paramBoolean) {
    int j = getChildCount();
    int i;
    for (i = 0; i < j; i++) {
      View view = getChildAt(i);
      Behavior<View> behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
      if (behavior != null) {
        long l = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        if (paramBoolean) {
          behavior.onInterceptTouchEvent(this, view, motionEvent);
        } else {
          behavior.onTouchEvent(this, view, motionEvent);
        } 
        motionEvent.recycle();
      } 
    } 
    for (i = 0; i < j; i++)
      ((LayoutParams)getChildAt(i).getLayoutParams()).d(); 
    this.q = null;
    this.n = false;
  }
  
  private boolean a(MotionEvent paramMotionEvent, int paramInt) {
    boolean bool2;
    int j = paramMotionEvent.getActionMasked();
    List<View> list = this.i;
    a(list);
    int k = list.size();
    LayoutParams layoutParams = null;
    int i = 0;
    boolean bool1 = false;
    boolean bool = false;
    while (true) {
      bool2 = bool1;
      if (i < k) {
        MotionEvent motionEvent;
        LayoutParams layoutParams1;
        View view = list.get(i);
        LayoutParams layoutParams2 = (LayoutParams)view.getLayoutParams();
        Behavior<View> behavior = layoutParams2.getBehavior();
        boolean bool3 = true;
        if ((bool1 || bool) && j != 0) {
          bool2 = bool1;
          bool3 = bool;
          layoutParams2 = layoutParams;
          if (behavior != null) {
            layoutParams2 = layoutParams;
            if (layoutParams == null) {
              long l = SystemClock.uptimeMillis();
              motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            } 
            if (paramInt != 0) {
              if (paramInt != 1) {
                bool2 = bool1;
                bool3 = bool;
              } else {
                behavior.onTouchEvent(this, view, motionEvent);
                bool2 = bool1;
                bool3 = bool;
              } 
            } else {
              behavior.onInterceptTouchEvent(this, view, motionEvent);
              bool2 = bool1;
              bool3 = bool;
            } 
          } 
        } else {
          bool2 = bool1;
          if (!bool1) {
            bool2 = bool1;
            if (behavior != null) {
              if (paramInt != 0) {
                if (paramInt == 1)
                  bool1 = behavior.onTouchEvent(this, view, paramMotionEvent); 
              } else {
                bool1 = behavior.onInterceptTouchEvent(this, view, paramMotionEvent);
              } 
              bool2 = bool1;
              if (bool1) {
                this.q = view;
                bool2 = bool1;
              } 
            } 
          } 
          bool1 = motionEvent.c();
          boolean bool4 = motionEvent.a(this, view);
          if (bool4 && !bool1) {
            bool = bool3;
          } else {
            bool = false;
          } 
          if (bool4 && !bool)
            break; 
          layoutParams1 = layoutParams;
          bool3 = bool;
        } 
        i++;
        bool1 = bool2;
        bool = bool3;
        layoutParams = layoutParams1;
        continue;
      } 
      break;
    } 
    list.clear();
    return bool2;
  }
  
  private int b(int paramInt) {
    StringBuilder stringBuilder;
    int[] arrayOfInt = this.p;
    if (arrayOfInt == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("No keylines defined for ");
      stringBuilder.append(this);
      stringBuilder.append(" - attempted index lookup ");
      stringBuilder.append(paramInt);
      Log.e("CoordinatorLayout", stringBuilder.toString());
      return 0;
    } 
    if (paramInt < 0 || paramInt >= stringBuilder.length) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Keyline index ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" out of range for ");
      stringBuilder.append(this);
      Log.e("CoordinatorLayout", stringBuilder.toString());
      return 0;
    } 
    return stringBuilder[paramInt];
  }
  
  private WindowInsetsCompat b(WindowInsetsCompat paramWindowInsetsCompat) {
    if (paramWindowInsetsCompat.isConsumed())
      return paramWindowInsetsCompat; 
    int i = 0;
    int j = getChildCount();
    WindowInsetsCompat windowInsetsCompat;
    for (windowInsetsCompat = paramWindowInsetsCompat; i < j; windowInsetsCompat = paramWindowInsetsCompat) {
      View view = getChildAt(i);
      paramWindowInsetsCompat = windowInsetsCompat;
      if (ViewCompat.getFitsSystemWindows(view)) {
        Behavior<View> behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
        paramWindowInsetsCompat = windowInsetsCompat;
        if (behavior != null) {
          windowInsetsCompat = behavior.onApplyWindowInsets(this, view, windowInsetsCompat);
          paramWindowInsetsCompat = windowInsetsCompat;
          if (windowInsetsCompat.isConsumed())
            return windowInsetsCompat; 
        } 
      } 
      i++;
    } 
    return windowInsetsCompat;
  }
  
  private void b(View paramView, int paramInt) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect rect1 = e();
    rect1.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, getWidth() - getPaddingRight() - layoutParams.rightMargin, getHeight() - getPaddingBottom() - layoutParams.bottomMargin);
    if (this.u != null && ViewCompat.getFitsSystemWindows((View)this) && !ViewCompat.getFitsSystemWindows(paramView)) {
      rect1.left += this.u.getSystemWindowInsetLeft();
      rect1.top += this.u.getSystemWindowInsetTop();
      rect1.right -= this.u.getSystemWindowInsetRight();
      rect1.bottom -= this.u.getSystemWindowInsetBottom();
    } 
    Rect rect2 = e();
    GravityCompat.apply(c(layoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), rect1, rect2, paramInt);
    paramView.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    a(rect1);
    a(rect2);
  }
  
  private boolean b(View paramView) {
    return this.h.hasOutgoingEdges(paramView);
  }
  
  private static int c(int paramInt) {
    int i = paramInt;
    if ((paramInt & 0x7) == 0)
      i = paramInt | 0x800003; 
    paramInt = i;
    if ((i & 0x70) == 0)
      paramInt = i | 0x30; 
    return paramInt;
  }
  
  private void c(View paramView, int paramInt) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (layoutParams.d != paramInt) {
      ViewCompat.offsetLeftAndRight(paramView, paramInt - layoutParams.d);
      layoutParams.d = paramInt;
    } 
  }
  
  private static int d(int paramInt) {
    int i = paramInt;
    if (paramInt == 0)
      i = 8388661; 
    return i;
  }
  
  private void d(View paramView, int paramInt) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (layoutParams.e != paramInt) {
      ViewCompat.offsetTopAndBottom(paramView, paramInt - layoutParams.e);
      layoutParams.e = paramInt;
    } 
  }
  
  private static int e(int paramInt) {
    int i = paramInt;
    if (paramInt == 0)
      i = 17; 
    return i;
  }
  
  private static Rect e() {
    Rect rect2 = (Rect)f.acquire();
    Rect rect1 = rect2;
    if (rect2 == null)
      rect1 = new Rect(); 
    return rect1;
  }
  
  private void f() {
    this.g.clear();
    this.h.clear();
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      LayoutParams layoutParams = a(view);
      layoutParams.b(this, view);
      this.h.addNode(view);
      for (int k = 0; k < j; k++) {
        if (k != i) {
          View view1 = getChildAt(k);
          if (layoutParams.a(this, view, view1)) {
            if (!this.h.contains(view1))
              this.h.addNode(view1); 
            this.h.addEdge(view1, view);
          } 
        } 
      } 
    } 
    this.g.addAll(this.h.getSortedList());
    Collections.reverse(this.g);
  }
  
  private void g() {
    if (Build.VERSION.SDK_INT < 21)
      return; 
    if (ViewCompat.getFitsSystemWindows((View)this)) {
      if (this.x == null)
        this.x = new OnApplyWindowInsetsListener(this) {
            public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
              return this.a.a(param1WindowInsetsCompat);
            }
          }; 
      ViewCompat.setOnApplyWindowInsetsListener((View)this, this.x);
      setSystemUiVisibility(1280);
      return;
    } 
    ViewCompat.setOnApplyWindowInsetsListener((View)this, null);
  }
  
  LayoutParams a(View paramView) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!layoutParams.b) {
      DefaultBehavior defaultBehavior;
      if (paramView instanceof AttachedBehavior) {
        behavior = ((AttachedBehavior)paramView).getBehavior();
        if (behavior == null)
          Log.e("CoordinatorLayout", "Attached behavior class is null"); 
        layoutParams.setBehavior(behavior);
        layoutParams.b = true;
        return layoutParams;
      } 
      Class<?> clazz = behavior.getClass();
      Behavior behavior = null;
      while (clazz != null) {
        DefaultBehavior defaultBehavior1 = clazz.<DefaultBehavior>getAnnotation(DefaultBehavior.class);
        defaultBehavior = defaultBehavior1;
        if (defaultBehavior1 == null) {
          clazz = clazz.getSuperclass();
          defaultBehavior = defaultBehavior1;
        } 
      } 
      if (defaultBehavior != null)
        try {
          layoutParams.setBehavior(defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Default behavior class ");
          stringBuilder.append(defaultBehavior.value().getName());
          stringBuilder.append(" could not be instantiated. Did you forget a default constructor?");
          Log.e("CoordinatorLayout", stringBuilder.toString(), exception);
        }  
      layoutParams.b = true;
    } 
    return layoutParams;
  }
  
  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams) ? new LayoutParams((LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams));
  }
  
  final WindowInsetsCompat a(WindowInsetsCompat paramWindowInsetsCompat) {
    WindowInsetsCompat windowInsetsCompat = paramWindowInsetsCompat;
    if (!ObjectsCompat.equals(this.u, paramWindowInsetsCompat)) {
      boolean bool1;
      this.u = paramWindowInsetsCompat;
      boolean bool2 = true;
      if (paramWindowInsetsCompat != null && paramWindowInsetsCompat.getSystemWindowInsetTop() > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.v = bool1;
      if (!this.v && getBackground() == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      setWillNotDraw(bool1);
      windowInsetsCompat = b(paramWindowInsetsCompat);
      requestLayout();
    } 
    return windowInsetsCompat;
  }
  
  final void a(int paramInt) {
    int j = ViewCompat.getLayoutDirection((View)this);
    int k = this.g.size();
    Rect rect1 = e();
    Rect rect2 = e();
    Rect rect3 = e();
    for (int i = 0; i < k; i++) {
      View view = this.g.get(i);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (paramInt == 0 && view.getVisibility() == 8)
        continue; 
      int m;
      for (m = 0; m < i; m++) {
        View view1 = this.g.get(m);
        if (layoutParams.g == view1)
          a(view, j); 
      } 
      a(view, true, rect2);
      if (layoutParams.insetEdge != 0 && !rect2.isEmpty()) {
        m = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, j);
        int n = m & 0x70;
        if (n != 48) {
          if (n == 80)
            rect1.bottom = Math.max(rect1.bottom, getHeight() - rect2.top); 
        } else {
          rect1.top = Math.max(rect1.top, rect2.bottom);
        } 
        m &= 0x7;
        if (m != 3) {
          if (m == 5)
            rect1.right = Math.max(rect1.right, getWidth() - rect2.left); 
        } else {
          rect1.left = Math.max(rect1.left, rect2.right);
        } 
      } 
      if (layoutParams.dodgeInsetEdges != 0 && view.getVisibility() == 0)
        a(view, rect1, j); 
      if (paramInt != 2) {
        c(view, rect3);
        if (rect3.equals(rect2))
          continue; 
        b(view, rect2);
      } 
      for (m = i + 1; m < k; m++) {
        View view1 = this.g.get(m);
        LayoutParams layoutParams1 = (LayoutParams)view1.getLayoutParams();
        Behavior<View> behavior = layoutParams1.getBehavior();
        if (behavior != null && behavior.layoutDependsOn(this, view1, view))
          if (paramInt == 0 && layoutParams1.e()) {
            layoutParams1.f();
          } else {
            boolean bool;
            if (paramInt != 2) {
              bool = behavior.onDependentViewChanged(this, view1, view);
            } else {
              behavior.onDependentViewRemoved(this, view1, view);
              bool = true;
            } 
            if (paramInt == 1)
              layoutParams1.a(bool); 
          }  
      } 
      continue;
    } 
    a(rect1);
    a(rect2);
    a(rect3);
  }
  
  void a(View paramView, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   4: checkcast androidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams
    //   7: astore #6
    //   9: aload #6
    //   11: getfield f : Landroid/view/View;
    //   14: ifnull -> 212
    //   17: invokestatic e : ()Landroid/graphics/Rect;
    //   20: astore #7
    //   22: invokestatic e : ()Landroid/graphics/Rect;
    //   25: astore #8
    //   27: invokestatic e : ()Landroid/graphics/Rect;
    //   30: astore #9
    //   32: aload_0
    //   33: aload #6
    //   35: getfield f : Landroid/view/View;
    //   38: aload #7
    //   40: invokevirtual a : (Landroid/view/View;Landroid/graphics/Rect;)V
    //   43: iconst_0
    //   44: istore_3
    //   45: aload_0
    //   46: aload_1
    //   47: iconst_0
    //   48: aload #8
    //   50: invokevirtual a : (Landroid/view/View;ZLandroid/graphics/Rect;)V
    //   53: aload_1
    //   54: invokevirtual getMeasuredWidth : ()I
    //   57: istore #4
    //   59: aload_1
    //   60: invokevirtual getMeasuredHeight : ()I
    //   63: istore #5
    //   65: aload_0
    //   66: aload_1
    //   67: iload_2
    //   68: aload #7
    //   70: aload #9
    //   72: aload #6
    //   74: iload #4
    //   76: iload #5
    //   78: invokespecial a : (Landroid/view/View;ILandroid/graphics/Rect;Landroid/graphics/Rect;Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;II)V
    //   81: aload #9
    //   83: getfield left : I
    //   86: aload #8
    //   88: getfield left : I
    //   91: if_icmpne -> 109
    //   94: iload_3
    //   95: istore_2
    //   96: aload #9
    //   98: getfield top : I
    //   101: aload #8
    //   103: getfield top : I
    //   106: if_icmpeq -> 111
    //   109: iconst_1
    //   110: istore_2
    //   111: aload_0
    //   112: aload #6
    //   114: aload #9
    //   116: iload #4
    //   118: iload #5
    //   120: invokespecial a : (Landroidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams;Landroid/graphics/Rect;II)V
    //   123: aload #9
    //   125: getfield left : I
    //   128: aload #8
    //   130: getfield left : I
    //   133: isub
    //   134: istore_3
    //   135: aload #9
    //   137: getfield top : I
    //   140: aload #8
    //   142: getfield top : I
    //   145: isub
    //   146: istore #4
    //   148: iload_3
    //   149: ifeq -> 157
    //   152: aload_1
    //   153: iload_3
    //   154: invokestatic offsetLeftAndRight : (Landroid/view/View;I)V
    //   157: iload #4
    //   159: ifeq -> 168
    //   162: aload_1
    //   163: iload #4
    //   165: invokestatic offsetTopAndBottom : (Landroid/view/View;I)V
    //   168: iload_2
    //   169: ifeq -> 197
    //   172: aload #6
    //   174: invokevirtual getBehavior : ()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;
    //   177: astore #10
    //   179: aload #10
    //   181: ifnull -> 197
    //   184: aload #10
    //   186: aload_0
    //   187: aload_1
    //   188: aload #6
    //   190: getfield f : Landroid/view/View;
    //   193: invokevirtual onDependentViewChanged : (Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;)Z
    //   196: pop
    //   197: aload #7
    //   199: invokestatic a : (Landroid/graphics/Rect;)V
    //   202: aload #8
    //   204: invokestatic a : (Landroid/graphics/Rect;)V
    //   207: aload #9
    //   209: invokestatic a : (Landroid/graphics/Rect;)V
    //   212: return
  }
  
  void a(View paramView, int paramInt, Rect paramRect1, Rect paramRect2) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    a(paramView, paramInt, paramRect1, paramRect2, layoutParams, i, j);
    a(layoutParams, paramRect2, i, j);
  }
  
  void a(View paramView, Rect paramRect) {
    ViewGroupUtils.getDescendantRect(this, paramView, paramRect);
  }
  
  void a(View paramView, boolean paramBoolean, Rect paramRect) {
    if (paramView.isLayoutRequested() || paramView.getVisibility() == 8) {
      paramRect.setEmpty();
      return;
    } 
    if (paramBoolean) {
      a(paramView, paramRect);
      return;
    } 
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  void ao_() {
    boolean bool1;
    int j = getChildCount();
    boolean bool2 = false;
    int i = 0;
    while (true) {
      bool1 = bool2;
      if (i < j) {
        if (b(getChildAt(i))) {
          bool1 = true;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (bool1 != this.t) {
      if (bool1) {
        b();
        return;
      } 
      ap_();
    } 
  }
  
  void ap_() {
    if (this.o && this.s != null)
      getViewTreeObserver().removeOnPreDrawListener(this.s); 
    this.t = false;
  }
  
  void b() {
    if (this.o) {
      if (this.s == null)
        this.s = new OnPreDrawListener(this); 
      getViewTreeObserver().addOnPreDrawListener(this.s);
    } 
    this.t = true;
  }
  
  void b(View paramView, Rect paramRect) {
    ((LayoutParams)paramView.getLayoutParams()).a(paramRect);
  }
  
  void c(View paramView, Rect paramRect) {
    paramRect.set(((LayoutParams)paramView.getLayoutParams()).a());
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
  }
  
  protected LayoutParams d() {
    return new LayoutParams(-2, -2);
  }
  
  public void dispatchDependentViewsChanged(View paramView) {
    List<View> list = this.h.getIncomingEdges(paramView);
    if (list != null && !list.isEmpty())
      for (int i = 0; i < list.size(); i++) {
        View view = list.get(i);
        Behavior<View> behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
        if (behavior != null)
          behavior.onDependentViewChanged(this, view, paramView); 
      }  
  }
  
  public boolean doViewsOverlap(View paramView1, View paramView2) {
    int i = paramView1.getVisibility();
    boolean bool = false;
    if (i == 0 && paramView2.getVisibility() == 0) {
      Rect rect2 = e();
      if (paramView1.getParent() != this) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      a(paramView1, bool1, rect2);
      Rect rect1 = e();
      if (paramView2.getParent() != this) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      a(paramView2, bool1, rect1);
      boolean bool1 = bool;
      try {
        if (rect2.left <= rect1.right) {
          bool1 = bool;
          if (rect2.top <= rect1.bottom) {
            bool1 = bool;
            if (rect2.right >= rect1.left) {
              i = rect2.bottom;
              int j = rect1.top;
              bool1 = bool;
              if (i >= j)
                bool1 = true; 
            } 
          } 
        } 
        return bool1;
      } finally {
        a(rect2);
        a(rect1);
      } 
    } 
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (layoutParams.a != null) {
      float f = layoutParams.a.getScrimOpacity(this, paramView);
      if (f > 0.0F) {
        if (this.k == null)
          this.k = new Paint(); 
        this.k.setColor(layoutParams.a.getScrimColor(this, paramView));
        this.k.setAlpha(a(Math.round(f * 255.0F), 0, 255));
        int i = paramCanvas.save();
        if (paramView.isOpaque())
          paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom(), Region.Op.DIFFERENCE); 
        paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), (getWidth() - getPaddingRight()), (getHeight() - getPaddingBottom()), this.k);
        paramCanvas.restoreToCount(i);
      } 
    } 
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable drawable = this.w;
    byte b = 0;
    int i = b;
    if (drawable != null) {
      i = b;
      if (drawable.isStateful())
        i = false | drawable.setState(arrayOfInt); 
    } 
    if (i != 0)
      invalidate(); 
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public List<View> getDependencies(View paramView) {
    List<View> list = this.h.getOutgoingEdges(paramView);
    this.j.clear();
    if (list != null)
      this.j.addAll(list); 
    return this.j;
  }
  
  final List<View> getDependencySortedChildren() {
    f();
    return Collections.unmodifiableList(this.g);
  }
  
  public List<View> getDependents(View paramView) {
    List<? extends View> list = this.h.getIncomingEdges(paramView);
    this.j.clear();
    if (list != null)
      this.j.addAll(list); 
    return this.j;
  }
  
  public final WindowInsetsCompat getLastWindowInsets() {
    return this.u;
  }
  
  public int getNestedScrollAxes() {
    return this.y.getNestedScrollAxes();
  }
  
  public Drawable getStatusBarBackground() {
    return this.w;
  }
  
  protected int getSuggestedMinimumHeight() {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth() {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public boolean isPointInChildBounds(View paramView, int paramInt1, int paramInt2) {
    Rect rect = e();
    a(paramView, rect);
    try {
      return rect.contains(paramInt1, paramInt2);
    } finally {
      a(rect);
    } 
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    a(false);
    if (this.t) {
      if (this.s == null)
        this.s = new OnPreDrawListener(this); 
      getViewTreeObserver().addOnPreDrawListener(this.s);
    } 
    if (this.u == null && ViewCompat.getFitsSystemWindows((View)this))
      ViewCompat.requestApplyInsets((View)this); 
    this.o = true;
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    a(false);
    if (this.t && this.s != null)
      getViewTreeObserver().removeOnPreDrawListener(this.s); 
    View view = this.r;
    if (view != null)
      onStopNestedScroll(view); 
    this.o = false;
  }
  
  public void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.v && this.w != null) {
      boolean bool;
      WindowInsetsCompat windowInsetsCompat = this.u;
      if (windowInsetsCompat != null) {
        bool = windowInsetsCompat.getSystemWindowInsetTop();
      } else {
        bool = false;
      } 
      if (bool) {
        this.w.setBounds(0, 0, getWidth(), bool);
        this.w.draw(paramCanvas);
      } 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
      a(true); 
    boolean bool = a(paramMotionEvent, 0);
    if (i == 1 || i == 3)
      a(true); 
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt2 = ViewCompat.getLayoutDirection((View)this);
    paramInt3 = this.g.size();
    for (paramInt1 = 0; paramInt1 < paramInt3; paramInt1++) {
      View view = this.g.get(paramInt1);
      if (view.getVisibility() != 8) {
        Behavior<View> behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
        if (behavior == null || !behavior.onLayoutChild(this, view, paramInt2))
          onLayoutChild(view, paramInt2); 
      } 
    } 
  }
  
  public void onLayoutChild(View paramView, int paramInt) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!layoutParams.b()) {
      if (layoutParams.f != null) {
        a(paramView, layoutParams.f, paramInt);
        return;
      } 
      if (layoutParams.keyline >= 0) {
        a(paramView, layoutParams.keyline, paramInt);
        return;
      } 
      b(paramView, paramInt);
      return;
    } 
    throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial f : ()V
    //   4: aload_0
    //   5: invokevirtual ao_ : ()V
    //   8: aload_0
    //   9: invokevirtual getPaddingLeft : ()I
    //   12: istore #13
    //   14: aload_0
    //   15: invokevirtual getPaddingTop : ()I
    //   18: istore #14
    //   20: aload_0
    //   21: invokevirtual getPaddingRight : ()I
    //   24: istore #15
    //   26: aload_0
    //   27: invokevirtual getPaddingBottom : ()I
    //   30: istore #16
    //   32: aload_0
    //   33: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   36: istore #17
    //   38: iload #17
    //   40: iconst_1
    //   41: if_icmpne -> 50
    //   44: iconst_1
    //   45: istore #5
    //   47: goto -> 53
    //   50: iconst_0
    //   51: istore #5
    //   53: iload_1
    //   54: invokestatic getMode : (I)I
    //   57: istore #18
    //   59: iload_1
    //   60: invokestatic getSize : (I)I
    //   63: istore #19
    //   65: iload_2
    //   66: invokestatic getMode : (I)I
    //   69: istore #20
    //   71: iload_2
    //   72: invokestatic getSize : (I)I
    //   75: istore #21
    //   77: aload_0
    //   78: invokevirtual getSuggestedMinimumWidth : ()I
    //   81: istore #10
    //   83: aload_0
    //   84: invokevirtual getSuggestedMinimumHeight : ()I
    //   87: istore #4
    //   89: aload_0
    //   90: getfield u : Landroidx/core/view/WindowInsetsCompat;
    //   93: ifnull -> 109
    //   96: aload_0
    //   97: invokestatic getFitsSystemWindows : (Landroid/view/View;)Z
    //   100: ifeq -> 109
    //   103: iconst_1
    //   104: istore #6
    //   106: goto -> 112
    //   109: iconst_0
    //   110: istore #6
    //   112: aload_0
    //   113: getfield g : Ljava/util/List;
    //   116: invokeinterface size : ()I
    //   121: istore #7
    //   123: iconst_0
    //   124: istore #9
    //   126: iconst_0
    //   127: istore #8
    //   129: iload #8
    //   131: iload #7
    //   133: if_icmpge -> 506
    //   136: aload_0
    //   137: getfield g : Ljava/util/List;
    //   140: iload #8
    //   142: invokeinterface get : (I)Ljava/lang/Object;
    //   147: checkcast android/view/View
    //   150: astore #25
    //   152: aload #25
    //   154: invokevirtual getVisibility : ()I
    //   157: bipush #8
    //   159: if_icmpne -> 165
    //   162: goto -> 497
    //   165: aload #25
    //   167: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   170: checkcast androidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams
    //   173: astore #24
    //   175: aload #24
    //   177: getfield keyline : I
    //   180: iflt -> 287
    //   183: iload #18
    //   185: ifeq -> 287
    //   188: aload_0
    //   189: aload #24
    //   191: getfield keyline : I
    //   194: invokespecial b : (I)I
    //   197: istore_3
    //   198: aload #24
    //   200: getfield gravity : I
    //   203: invokestatic d : (I)I
    //   206: iload #17
    //   208: invokestatic getAbsoluteGravity : (II)I
    //   211: bipush #7
    //   213: iand
    //   214: istore #11
    //   216: iload #11
    //   218: iconst_3
    //   219: if_icmpne -> 227
    //   222: iload #5
    //   224: ifeq -> 238
    //   227: iload #11
    //   229: iconst_5
    //   230: if_icmpne -> 253
    //   233: iload #5
    //   235: ifeq -> 253
    //   238: iconst_0
    //   239: iload #19
    //   241: iload #15
    //   243: isub
    //   244: iload_3
    //   245: isub
    //   246: invokestatic max : (II)I
    //   249: istore_3
    //   250: goto -> 289
    //   253: iload #11
    //   255: iconst_5
    //   256: if_icmpne -> 264
    //   259: iload #5
    //   261: ifeq -> 275
    //   264: iload #11
    //   266: iconst_3
    //   267: if_icmpne -> 287
    //   270: iload #5
    //   272: ifeq -> 287
    //   275: iconst_0
    //   276: iload_3
    //   277: iload #13
    //   279: isub
    //   280: invokestatic max : (II)I
    //   283: istore_3
    //   284: goto -> 289
    //   287: iconst_0
    //   288: istore_3
    //   289: iload #4
    //   291: istore #12
    //   293: iload #6
    //   295: ifeq -> 375
    //   298: aload #25
    //   300: invokestatic getFitsSystemWindows : (Landroid/view/View;)Z
    //   303: ifne -> 375
    //   306: aload_0
    //   307: getfield u : Landroidx/core/view/WindowInsetsCompat;
    //   310: invokevirtual getSystemWindowInsetLeft : ()I
    //   313: istore #4
    //   315: aload_0
    //   316: getfield u : Landroidx/core/view/WindowInsetsCompat;
    //   319: invokevirtual getSystemWindowInsetRight : ()I
    //   322: istore #23
    //   324: aload_0
    //   325: getfield u : Landroidx/core/view/WindowInsetsCompat;
    //   328: invokevirtual getSystemWindowInsetTop : ()I
    //   331: istore #11
    //   333: aload_0
    //   334: getfield u : Landroidx/core/view/WindowInsetsCompat;
    //   337: invokevirtual getSystemWindowInsetBottom : ()I
    //   340: istore #22
    //   342: iload #19
    //   344: iload #4
    //   346: iload #23
    //   348: iadd
    //   349: isub
    //   350: iload #18
    //   352: invokestatic makeMeasureSpec : (II)I
    //   355: istore #4
    //   357: iload #21
    //   359: iload #11
    //   361: iload #22
    //   363: iadd
    //   364: isub
    //   365: iload #20
    //   367: invokestatic makeMeasureSpec : (II)I
    //   370: istore #11
    //   372: goto -> 381
    //   375: iload_1
    //   376: istore #4
    //   378: iload_2
    //   379: istore #11
    //   381: aload #24
    //   383: invokevirtual getBehavior : ()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;
    //   386: astore #26
    //   388: aload #26
    //   390: ifnull -> 413
    //   393: aload #26
    //   395: aload_0
    //   396: aload #25
    //   398: iload #4
    //   400: iload_3
    //   401: iload #11
    //   403: iconst_0
    //   404: invokevirtual onMeasureChild : (Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;IIII)Z
    //   407: ifne -> 425
    //   410: goto -> 413
    //   413: aload_0
    //   414: aload #25
    //   416: iload #4
    //   418: iload_3
    //   419: iload #11
    //   421: iconst_0
    //   422: invokevirtual onMeasureChild : (Landroid/view/View;IIII)V
    //   425: iload #10
    //   427: iload #13
    //   429: iload #15
    //   431: iadd
    //   432: aload #25
    //   434: invokevirtual getMeasuredWidth : ()I
    //   437: iadd
    //   438: aload #24
    //   440: getfield leftMargin : I
    //   443: iadd
    //   444: aload #24
    //   446: getfield rightMargin : I
    //   449: iadd
    //   450: invokestatic max : (II)I
    //   453: istore #10
    //   455: iload #12
    //   457: iload #14
    //   459: iload #16
    //   461: iadd
    //   462: aload #25
    //   464: invokevirtual getMeasuredHeight : ()I
    //   467: iadd
    //   468: aload #24
    //   470: getfield topMargin : I
    //   473: iadd
    //   474: aload #24
    //   476: getfield bottomMargin : I
    //   479: iadd
    //   480: invokestatic max : (II)I
    //   483: istore #4
    //   485: iload #9
    //   487: aload #25
    //   489: invokevirtual getMeasuredState : ()I
    //   492: invokestatic combineMeasuredStates : (II)I
    //   495: istore #9
    //   497: iload #8
    //   499: iconst_1
    //   500: iadd
    //   501: istore #8
    //   503: goto -> 129
    //   506: aload_0
    //   507: iload #10
    //   509: iload_1
    //   510: ldc_w -16777216
    //   513: iload #9
    //   515: iand
    //   516: invokestatic resolveSizeAndState : (III)I
    //   519: iload #4
    //   521: iload_2
    //   522: iload #9
    //   524: bipush #16
    //   526: ishl
    //   527: invokestatic resolveSizeAndState : (III)I
    //   530: invokevirtual setMeasuredDimension : (II)V
    //   533: return
  }
  
  public void onMeasureChild(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    int j = getChildCount();
    int i = 0;
    boolean bool;
    for (bool = false; i < j; bool = bool1) {
      boolean bool1;
      View view = getChildAt(i);
      if (view.getVisibility() == 8) {
        bool1 = bool;
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.b(0)) {
          bool1 = bool;
        } else {
          Behavior<View> behavior = layoutParams.getBehavior();
          bool1 = bool;
          if (behavior != null)
            bool1 = bool | behavior.onNestedFling(this, view, paramView, paramFloat1, paramFloat2, paramBoolean); 
        } 
      } 
      i++;
    } 
    if (bool)
      a(1); 
    return bool;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    int j = getChildCount();
    int i = 0;
    boolean bool;
    for (bool = false; i < j; bool = bool1) {
      boolean bool1;
      View view = getChildAt(i);
      if (view.getVisibility() == 8) {
        bool1 = bool;
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.b(0)) {
          bool1 = bool;
        } else {
          Behavior<View> behavior = layoutParams.getBehavior();
          bool1 = bool;
          if (behavior != null)
            bool1 = bool | behavior.onNestedPreFling(this, view, paramView, paramFloat1, paramFloat2); 
        } 
      } 
      i++;
    } 
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfint, 0);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
    int m = getChildCount();
    boolean bool = false;
    int j = 0;
    int k = 0;
    int i;
    for (i = 0; j < m; i = n) {
      int n;
      int i1;
      View view = getChildAt(j);
      if (view.getVisibility() == 8) {
        i1 = k;
        n = i;
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.b(paramInt3)) {
          i1 = k;
          n = i;
        } else {
          Behavior<View> behavior = layoutParams.getBehavior();
          i1 = k;
          n = i;
          if (behavior != null) {
            int[] arrayOfInt2 = this.l;
            arrayOfInt2[0] = 0;
            arrayOfInt2[1] = 0;
            behavior.onNestedPreScroll(this, view, paramView, paramInt1, paramInt2, arrayOfInt2, paramInt3);
            int[] arrayOfInt1 = this.l;
            if (paramInt1 > 0) {
              n = Math.max(k, arrayOfInt1[0]);
            } else {
              n = Math.min(k, arrayOfInt1[0]);
            } 
            arrayOfInt1 = this.l;
            if (paramInt2 > 0) {
              i = Math.max(i, arrayOfInt1[1]);
            } else {
              i = Math.min(i, arrayOfInt1[1]);
            } 
            i1 = n;
            n = i;
            bool = true;
          } 
        } 
      } 
      j++;
      k = i1;
    } 
    paramArrayOfint[0] = k;
    paramArrayOfint[1] = i;
    if (bool)
      a(1); 
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0, this.m);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint) {
    int m = getChildCount();
    boolean bool = false;
    int j = 0;
    int k = 0;
    int i;
    for (i = 0; j < m; i = n) {
      int n;
      int i1;
      View view = getChildAt(j);
      if (view.getVisibility() == 8) {
        i1 = k;
        n = i;
      } else {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.b(paramInt5)) {
          i1 = k;
          n = i;
        } else {
          Behavior<View> behavior = layoutParams.getBehavior();
          i1 = k;
          n = i;
          if (behavior != null) {
            int[] arrayOfInt2 = this.l;
            arrayOfInt2[0] = 0;
            arrayOfInt2[1] = 0;
            behavior.onNestedScroll(this, view, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, arrayOfInt2);
            int[] arrayOfInt1 = this.l;
            if (paramInt3 > 0) {
              n = Math.max(k, arrayOfInt1[0]);
            } else {
              n = Math.min(k, arrayOfInt1[0]);
            } 
            if (paramInt4 > 0) {
              i = Math.max(i, this.l[1]);
            } else {
              i = Math.min(i, this.l[1]);
            } 
            i1 = n;
            n = i;
            bool = true;
          } 
        } 
      } 
      j++;
      k = i1;
    } 
    paramArrayOfint[0] = paramArrayOfint[0] + k;
    paramArrayOfint[1] = paramArrayOfint[1] + i;
    if (bool)
      a(1); 
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    this.y.onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
    this.r = paramView2;
    int j = getChildCount();
    int i;
    for (i = 0; i < j; i++) {
      View view = getChildAt(i);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (layoutParams.b(paramInt2)) {
        Behavior<View> behavior = layoutParams.getBehavior();
        if (behavior != null)
          behavior.onNestedScrollAccepted(this, view, paramView1, paramView2, paramInt1, paramInt2); 
      } 
    } 
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    SparseArray<Parcelable> sparseArray = savedState.a;
    int i = 0;
    int j = getChildCount();
    while (i < j) {
      View view = getChildAt(i);
      int k = view.getId();
      Behavior<View> behavior = a(view).getBehavior();
      if (k != -1 && behavior != null) {
        Parcelable parcelable = (Parcelable)sparseArray.get(k);
        if (parcelable != null)
          behavior.onRestoreInstanceState(this, view, parcelable); 
      } 
      i++;
    } 
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    SparseArray<Parcelable> sparseArray = new SparseArray();
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      int k = view.getId();
      Behavior<View> behavior = ((LayoutParams)view.getLayoutParams()).getBehavior();
      if (k != -1 && behavior != null) {
        Parcelable parcelable = behavior.onSaveInstanceState(this, view);
        if (parcelable != null)
          sparseArray.append(k, parcelable); 
      } 
    } 
    savedState.a = sparseArray;
    return (Parcelable)savedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    return onStartNestedScroll(paramView1, paramView2, paramInt, 0);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    int j = getChildCount();
    int i = 0;
    boolean bool = false;
    while (i < j) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        Behavior<View> behavior = layoutParams.getBehavior();
        if (behavior != null) {
          boolean bool1 = behavior.onStartNestedScroll(this, view, paramView1, paramView2, paramInt1, paramInt2);
          layoutParams.a(paramInt2, bool1);
          bool |= bool1;
        } else {
          layoutParams.a(paramInt2, false);
        } 
      } 
      i++;
    } 
    return bool;
  }
  
  public void onStopNestedScroll(View paramView) {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(View paramView, int paramInt) {
    this.y.onStopNestedScroll(paramView, paramInt);
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      if (layoutParams.b(paramInt)) {
        Behavior<View> behavior = layoutParams.getBehavior();
        if (behavior != null)
          behavior.onStopNestedScroll(this, view, paramView, paramInt); 
        layoutParams.a(paramInt);
        layoutParams.f();
      } 
    } 
    this.r = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore_2
    //   5: aload_0
    //   6: getfield q : Landroid/view/View;
    //   9: ifnonnull -> 29
    //   12: aload_0
    //   13: aload_1
    //   14: iconst_1
    //   15: invokespecial a : (Landroid/view/MotionEvent;I)Z
    //   18: istore_3
    //   19: iload_3
    //   20: istore #4
    //   22: iload_3
    //   23: ifeq -> 76
    //   26: goto -> 31
    //   29: iconst_0
    //   30: istore_3
    //   31: aload_0
    //   32: getfield q : Landroid/view/View;
    //   35: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   38: checkcast androidx/coordinatorlayout/widget/CoordinatorLayout$LayoutParams
    //   41: invokevirtual getBehavior : ()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;
    //   44: astore #8
    //   46: iload_3
    //   47: istore #4
    //   49: aload #8
    //   51: ifnull -> 76
    //   54: aload #8
    //   56: aload_0
    //   57: aload_0
    //   58: getfield q : Landroid/view/View;
    //   61: aload_1
    //   62: invokevirtual onTouchEvent : (Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z
    //   65: istore #5
    //   67: iload_3
    //   68: istore #4
    //   70: iload #5
    //   72: istore_3
    //   73: goto -> 78
    //   76: iconst_0
    //   77: istore_3
    //   78: aload_0
    //   79: getfield q : Landroid/view/View;
    //   82: astore #9
    //   84: aconst_null
    //   85: astore #8
    //   87: aload #9
    //   89: ifnonnull -> 107
    //   92: iload_3
    //   93: aload_0
    //   94: aload_1
    //   95: invokespecial onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   98: ior
    //   99: istore #5
    //   101: aload #8
    //   103: astore_1
    //   104: goto -> 144
    //   107: iload_3
    //   108: istore #5
    //   110: aload #8
    //   112: astore_1
    //   113: iload #4
    //   115: ifeq -> 144
    //   118: invokestatic uptimeMillis : ()J
    //   121: lstore #6
    //   123: lload #6
    //   125: lload #6
    //   127: iconst_3
    //   128: fconst_0
    //   129: fconst_0
    //   130: iconst_0
    //   131: invokestatic obtain : (JJIFFI)Landroid/view/MotionEvent;
    //   134: astore_1
    //   135: aload_0
    //   136: aload_1
    //   137: invokespecial onTouchEvent : (Landroid/view/MotionEvent;)Z
    //   140: pop
    //   141: iload_3
    //   142: istore #5
    //   144: aload_1
    //   145: ifnull -> 152
    //   148: aload_1
    //   149: invokevirtual recycle : ()V
    //   152: iload_2
    //   153: iconst_1
    //   154: if_icmpeq -> 162
    //   157: iload_2
    //   158: iconst_3
    //   159: if_icmpne -> 167
    //   162: aload_0
    //   163: iconst_0
    //   164: invokespecial a : (Z)V
    //   167: iload #5
    //   169: ireturn
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
    Behavior<View> behavior = ((LayoutParams)paramView.getLayoutParams()).getBehavior();
    return (behavior != null && behavior.onRequestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean)) ? true : super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean && !this.n) {
      a(false);
      this.n = true;
    } 
  }
  
  public void setFitsSystemWindows(boolean paramBoolean) {
    super.setFitsSystemWindows(paramBoolean);
    g();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener) {
    this.e = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable) {
    Drawable drawable = this.w;
    if (drawable != paramDrawable) {
      Drawable drawable1 = null;
      if (drawable != null)
        drawable.setCallback(null); 
      if (paramDrawable != null)
        drawable1 = paramDrawable.mutate(); 
      this.w = drawable1;
      paramDrawable = this.w;
      if (paramDrawable != null) {
        boolean bool;
        if (paramDrawable.isStateful())
          this.w.setState(getDrawableState()); 
        DrawableCompat.setLayoutDirection(this.w, ViewCompat.getLayoutDirection((View)this));
        paramDrawable = this.w;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        paramDrawable.setVisible(bool, false);
        this.w.setCallback((Drawable.Callback)this);
      } 
      ViewCompat.postInvalidateOnAnimation((View)this);
    } 
  }
  
  public void setStatusBarBackgroundColor(int paramInt) {
    setStatusBarBackground((Drawable)new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    setStatusBarBackground(drawable);
  }
  
  public void setVisibility(int paramInt) {
    boolean bool;
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Drawable drawable = this.w;
    if (drawable != null && drawable.isVisible() != bool)
      this.w.setVisible(bool, false); 
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.w);
  }
  
  static {
    Package package_ = CoordinatorLayout.class.getPackage();
    if (package_ != null) {
      String str = package_.getName();
    } else {
      package_ = null;
    } 
    a = (String)package_;
    if (Build.VERSION.SDK_INT >= 21) {
      d = new ViewElevationComparator();
    } else {
      d = null;
    } 
  }
  
  public static interface AttachedBehavior {
    CoordinatorLayout.Behavior getBehavior();
  }
  
  public static abstract class Behavior<V extends View> {
    public Behavior() {}
    
    public Behavior(Context param1Context, AttributeSet param1AttributeSet) {}
    
    public static Object getTag(View param1View) {
      return ((CoordinatorLayout.LayoutParams)param1View.getLayoutParams()).i;
    }
    
    public static void setTag(View param1View, Object param1Object) {
      ((CoordinatorLayout.LayoutParams)param1View.getLayoutParams()).i = param1Object;
    }
    
    public boolean blocksInteractionBelow(CoordinatorLayout param1CoordinatorLayout, V param1V) {
      return (getScrimOpacity(param1CoordinatorLayout, param1V) > 0.0F);
    }
    
    public boolean getInsetDodgeRect(CoordinatorLayout param1CoordinatorLayout, V param1V, Rect param1Rect) {
      return false;
    }
    
    public int getScrimColor(CoordinatorLayout param1CoordinatorLayout, V param1V) {
      return -16777216;
    }
    
    public float getScrimOpacity(CoordinatorLayout param1CoordinatorLayout, V param1V) {
      return 0.0F;
    }
    
    public boolean layoutDependsOn(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View) {
      return false;
    }
    
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout param1CoordinatorLayout, V param1V, WindowInsetsCompat param1WindowInsetsCompat) {
      return param1WindowInsetsCompat;
    }
    
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams param1LayoutParams) {}
    
    public boolean onDependentViewChanged(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View) {
      return false;
    }
    
    public void onDependentViewRemoved(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View) {}
    
    public void onDetachedFromLayoutParams() {}
    
    public boolean onInterceptTouchEvent(CoordinatorLayout param1CoordinatorLayout, V param1V, MotionEvent param1MotionEvent) {
      return false;
    }
    
    public boolean onLayoutChild(CoordinatorLayout param1CoordinatorLayout, V param1V, int param1Int) {
      return false;
    }
    
    public boolean onMeasureChild(CoordinatorLayout param1CoordinatorLayout, V param1V, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      return false;
    }
    
    public boolean onNestedFling(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, float param1Float1, float param1Float2, boolean param1Boolean) {
      return false;
    }
    
    public boolean onNestedPreFling(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, float param1Float1, float param1Float2) {
      return false;
    }
    
    @Deprecated
    public void onNestedPreScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint) {}
    
    public void onNestedPreScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint, int param1Int3) {
      if (param1Int3 == 0)
        onNestedPreScroll(param1CoordinatorLayout, param1V, param1View, param1Int1, param1Int2, param1ArrayOfint); 
    }
    
    @Deprecated
    public void onNestedScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    @Deprecated
    public void onNestedScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
      if (param1Int5 == 0)
        onNestedScroll(param1CoordinatorLayout, param1V, param1View, param1Int1, param1Int2, param1Int3, param1Int4); 
    }
    
    public void onNestedScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int[] param1ArrayOfint) {
      param1ArrayOfint[0] = param1ArrayOfint[0] + param1Int3;
      param1ArrayOfint[1] = param1ArrayOfint[1] + param1Int4;
      onNestedScroll(param1CoordinatorLayout, param1V, param1View, param1Int1, param1Int2, param1Int3, param1Int4, param1Int5);
    }
    
    @Deprecated
    public void onNestedScrollAccepted(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View1, View param1View2, int param1Int) {}
    
    public void onNestedScrollAccepted(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View1, View param1View2, int param1Int1, int param1Int2) {
      if (param1Int2 == 0)
        onNestedScrollAccepted(param1CoordinatorLayout, param1V, param1View1, param1View2, param1Int1); 
    }
    
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout param1CoordinatorLayout, V param1V, Rect param1Rect, boolean param1Boolean) {
      return false;
    }
    
    public void onRestoreInstanceState(CoordinatorLayout param1CoordinatorLayout, V param1V, Parcelable param1Parcelable) {}
    
    public Parcelable onSaveInstanceState(CoordinatorLayout param1CoordinatorLayout, V param1V) {
      return (Parcelable)View.BaseSavedState.EMPTY_STATE;
    }
    
    @Deprecated
    public boolean onStartNestedScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View1, View param1View2, int param1Int) {
      return false;
    }
    
    public boolean onStartNestedScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View1, View param1View2, int param1Int1, int param1Int2) {
      return (param1Int2 == 0) ? onStartNestedScroll(param1CoordinatorLayout, param1V, param1View1, param1View2, param1Int1) : false;
    }
    
    @Deprecated
    public void onStopNestedScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View) {}
    
    public void onStopNestedScroll(CoordinatorLayout param1CoordinatorLayout, V param1V, View param1View, int param1Int) {
      if (param1Int == 0)
        onStopNestedScroll(param1CoordinatorLayout, param1V, param1View); 
    }
    
    public boolean onTouchEvent(CoordinatorLayout param1CoordinatorLayout, V param1V, MotionEvent param1MotionEvent) {
      return false;
    }
  }
  
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface DefaultBehavior {
    Class<? extends CoordinatorLayout.Behavior> value();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DispatchChangeEvent {}
  
  class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
    HierarchyChangeListener(CoordinatorLayout this$0) {}
    
    public void onChildViewAdded(View param1View1, View param1View2) {
      if (this.a.e != null)
        this.a.e.onChildViewAdded(param1View1, param1View2); 
    }
    
    public void onChildViewRemoved(View param1View1, View param1View2) {
      this.a.a(2);
      if (this.a.e != null)
        this.a.e.onChildViewRemoved(param1View1, param1View2); 
    }
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    CoordinatorLayout.Behavior a;
    
    public int anchorGravity = 0;
    
    boolean b = false;
    
    int c = -1;
    
    int d;
    
    public int dodgeInsetEdges = 0;
    
    int e;
    
    View f;
    
    View g;
    
    public int gravity = 0;
    
    final Rect h = new Rect();
    
    Object i;
    
    public int insetEdge = 0;
    
    private boolean j;
    
    private boolean k;
    
    public int keyline = -1;
    
    private boolean l;
    
    private boolean m;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.CoordinatorLayout_Layout);
      this.gravity = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
      this.c = typedArray.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
      this.anchorGravity = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
      this.keyline = typedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
      this.insetEdge = typedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
      this.dodgeInsetEdges = typedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
      this.b = typedArray.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
      if (this.b)
        this.a = CoordinatorLayout.a(param1Context, param1AttributeSet, typedArray.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior)); 
      typedArray.recycle();
      CoordinatorLayout.Behavior behavior = this.a;
      if (behavior != null)
        behavior.onAttachedToLayoutParams(this); 
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    private void a(View param1View, CoordinatorLayout param1CoordinatorLayout) {
      this.f = param1CoordinatorLayout.findViewById(this.c);
      View view = this.f;
      if (view != null) {
        if (view == param1CoordinatorLayout) {
          if (param1CoordinatorLayout.isInEditMode()) {
            this.g = null;
            this.f = null;
            return;
          } 
          throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        } 
        for (ViewParent viewParent = view.getParent(); viewParent != param1CoordinatorLayout && viewParent != null; viewParent = viewParent.getParent()) {
          if (viewParent == param1View) {
            if (param1CoordinatorLayout.isInEditMode()) {
              this.g = null;
              this.f = null;
              return;
            } 
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
          } 
          if (viewParent instanceof View)
            view = (View)viewParent; 
        } 
        this.g = view;
        return;
      } 
      if (param1CoordinatorLayout.isInEditMode()) {
        this.g = null;
        this.f = null;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
      stringBuilder.append(param1CoordinatorLayout.getResources().getResourceName(this.c));
      stringBuilder.append(" to anchor view ");
      stringBuilder.append(param1View);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    private boolean a(View param1View, int param1Int) {
      int i = GravityCompat.getAbsoluteGravity(((LayoutParams)param1View.getLayoutParams()).insetEdge, param1Int);
      return (i != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, param1Int) & i) == i);
    }
    
    private boolean b(View param1View, CoordinatorLayout param1CoordinatorLayout) {
      if (this.f.getId() != this.c)
        return false; 
      View view = this.f;
      for (ViewParent viewParent = view.getParent(); viewParent != param1CoordinatorLayout; viewParent = viewParent.getParent()) {
        if (viewParent == null || viewParent == param1View) {
          this.g = null;
          this.f = null;
          return false;
        } 
        if (viewParent instanceof View)
          view = (View)viewParent; 
      } 
      this.g = view;
      return true;
    }
    
    Rect a() {
      return this.h;
    }
    
    void a(int param1Int) {
      a(param1Int, false);
    }
    
    void a(int param1Int, boolean param1Boolean) {
      if (param1Int != 0) {
        if (param1Int != 1)
          return; 
        this.l = param1Boolean;
        return;
      } 
      this.k = param1Boolean;
    }
    
    void a(Rect param1Rect) {
      this.h.set(param1Rect);
    }
    
    void a(boolean param1Boolean) {
      this.m = param1Boolean;
    }
    
    boolean a(CoordinatorLayout param1CoordinatorLayout, View param1View) {
      boolean bool1;
      boolean bool2 = this.j;
      if (bool2)
        return true; 
      CoordinatorLayout.Behavior<View> behavior = this.a;
      if (behavior != null) {
        bool1 = behavior.blocksInteractionBelow(param1CoordinatorLayout, param1View);
      } else {
        bool1 = false;
      } 
      bool1 |= bool2;
      this.j = bool1;
      return bool1;
    }
    
    boolean a(CoordinatorLayout param1CoordinatorLayout, View param1View1, View param1View2) {
      if (param1View2 != this.g && !a(param1View2, ViewCompat.getLayoutDirection((View)param1CoordinatorLayout))) {
        CoordinatorLayout.Behavior<View> behavior = this.a;
        if (behavior == null || !behavior.layoutDependsOn(param1CoordinatorLayout, param1View1, param1View2))
          return false; 
      } 
      return true;
    }
    
    View b(CoordinatorLayout param1CoordinatorLayout, View param1View) {
      if (this.c == -1) {
        this.g = null;
        this.f = null;
        return null;
      } 
      if (this.f == null || !b(param1View, param1CoordinatorLayout))
        a(param1View, param1CoordinatorLayout); 
      return this.f;
    }
    
    boolean b() {
      return (this.f == null && this.c != -1);
    }
    
    boolean b(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? false : this.l) : this.k;
    }
    
    boolean c() {
      if (this.a == null)
        this.j = false; 
      return this.j;
    }
    
    void d() {
      this.j = false;
    }
    
    boolean e() {
      return this.m;
    }
    
    void f() {
      this.m = false;
    }
    
    void g() {
      this.g = null;
      this.f = null;
    }
    
    public int getAnchorId() {
      return this.c;
    }
    
    public CoordinatorLayout.Behavior getBehavior() {
      return this.a;
    }
    
    public void setAnchorId(int param1Int) {
      g();
      this.c = param1Int;
    }
    
    public void setBehavior(CoordinatorLayout.Behavior param1Behavior) {
      CoordinatorLayout.Behavior behavior = this.a;
      if (behavior != param1Behavior) {
        if (behavior != null)
          behavior.onDetachedFromLayoutParams(); 
        this.a = param1Behavior;
        this.i = null;
        this.b = true;
        if (param1Behavior != null)
          param1Behavior.onAttachedToLayoutParams(this); 
      } 
    }
  }
  
  class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
    OnPreDrawListener(CoordinatorLayout this$0) {}
    
    public boolean onPreDraw() {
      this.a.a(0);
      return true;
    }
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public CoordinatorLayout.SavedState createFromParcel(Parcel param2Parcel) {
          return new CoordinatorLayout.SavedState(param2Parcel, null);
        }
        
        public CoordinatorLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new CoordinatorLayout.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public CoordinatorLayout.SavedState[] newArray(int param2Int) {
          return new CoordinatorLayout.SavedState[param2Int];
        }
      };
    
    SparseArray<Parcelable> a;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      int j = param1Parcel.readInt();
      int[] arrayOfInt = new int[j];
      param1Parcel.readIntArray(arrayOfInt);
      Parcelable[] arrayOfParcelable = param1Parcel.readParcelableArray(param1ClassLoader);
      this.a = new SparseArray(j);
      for (int i = 0; i < j; i++)
        this.a.append(arrayOfInt[i], arrayOfParcelable[i]); 
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      byte b;
      super.writeToParcel(param1Parcel, param1Int);
      SparseArray<Parcelable> sparseArray = this.a;
      int i = 0;
      if (sparseArray != null) {
        b = sparseArray.size();
      } else {
        b = 0;
      } 
      param1Parcel.writeInt(b);
      int[] arrayOfInt = new int[b];
      Parcelable[] arrayOfParcelable = new Parcelable[b];
      while (i < b) {
        arrayOfInt[i] = this.a.keyAt(i);
        arrayOfParcelable[i] = (Parcelable)this.a.valueAt(i);
        i++;
      } 
      param1Parcel.writeIntArray(arrayOfInt);
      param1Parcel.writeParcelableArray(arrayOfParcelable, param1Int);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public CoordinatorLayout.SavedState createFromParcel(Parcel param1Parcel) {
      return new CoordinatorLayout.SavedState(param1Parcel, null);
    }
    
    public CoordinatorLayout.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new CoordinatorLayout.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public CoordinatorLayout.SavedState[] newArray(int param1Int) {
      return new CoordinatorLayout.SavedState[param1Int];
    }
  }
  
  static class ViewElevationComparator implements Comparator<View> {
    public int compare(View param1View1, View param1View2) {
      float f1 = ViewCompat.getZ(param1View1);
      float f2 = ViewCompat.getZ(param1View2);
      return (f1 > f2) ? -1 : ((f1 < f2) ? 1 : 0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\coordinatorlayout\widget\CoordinatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */