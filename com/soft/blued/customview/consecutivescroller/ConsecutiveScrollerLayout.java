package com.soft.blued.customview.consecutivescroller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import skin.support.widget.SkinCompatBackgroundHelper;
import skin.support.widget.SkinCompatSupportable;

public class ConsecutiveScrollerLayout extends ViewGroup implements NestedScrollingChild2, NestedScrollingParent2, ScrollingView, SkinCompatSupportable {
  static final Interpolator b = new Interpolator() {
      public float getInterpolation(float param1Float) {
        param1Float--;
        return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
      }
    };
  
  private int A = 0;
  
  private EdgeEffect B;
  
  private EdgeEffect C;
  
  private int D;
  
  private boolean E;
  
  private int F = 0;
  
  private View G;
  
  private final List<View> H = new ArrayList<View>();
  
  private final List<View> I = new ArrayList<View>();
  
  private int J = 0;
  
  private final List<View> K = new ArrayList<View>();
  
  private int L = 0;
  
  private OnStickyChangeListener M;
  
  private OnPermanentStickyChangeListener N;
  
  private int O = 0;
  
  private SkinCompatBackgroundHelper P = new SkinCompatBackgroundHelper((View)this);
  
  protected OnScrollChangeListener a;
  
  private int c;
  
  private int d;
  
  private OverScroller e;
  
  private VelocityTracker f;
  
  private VelocityTracker g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private float n;
  
  private final int[] o = new int[2];
  
  private boolean p = false;
  
  private int q = 0;
  
  private int r;
  
  private NestedScrollingParentHelper s;
  
  private NestedScrollingChildHelper t;
  
  private final int[] u = new int[2];
  
  private final int[] v = new int[2];
  
  private View w;
  
  private int x;
  
  private int y = -1;
  
  private int z = 0;
  
  public ConsecutiveScrollerLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ConsecutiveScrollerLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ConsecutiveScrollerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.P.a(paramAttributeSet, 0);
    TypedArray typedArray = null;
    try {
      TypedArray typedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConsecutiveScrollerLayout);
      typedArray = typedArray1;
      this.E = typedArray1.getBoolean(0, false);
      if (typedArray1 != null)
        typedArray1.recycle(); 
      this.e = new OverScroller(getContext(), b);
      ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
      this.h = viewConfiguration.getScaledMaximumFlingVelocity();
      this.i = viewConfiguration.getScaledMinimumFlingVelocity();
      this.j = ViewConfiguration.getTouchSlop();
      setWillNotDraw(false);
      setVerticalScrollBarEnabled(true);
      this.s = new NestedScrollingParentHelper(this);
      this.t = new NestedScrollingChildHelper((View)this);
      setNestedScrollingEnabled(true);
      return;
    } finally {
      if (typedArray != null)
        typedArray.recycle(); 
    } 
  }
  
  private int a(int paramInt1, int paramInt2) {
    int i;
    int k = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824) {
      i = j;
    } else {
      i = paramInt2;
      if (k == Integer.MIN_VALUE)
        i = Math.min(paramInt2, j); 
    } 
    return resolveSizeAndState(Math.max(i, getSuggestedMinimumWidth()), paramInt1, 0);
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = null.a[layoutParams.d.ordinal()];
    return (i != 1) ? ((i != 2) ? (paramInt2 + layoutParams.leftMargin) : (layoutParams.leftMargin + paramInt2 + (paramInt1 - paramView.getMeasuredWidth() - paramInt2 - layoutParams.leftMargin - paramInt3 - layoutParams.rightMargin) / 2)) : (paramInt1 - paramView.getMeasuredWidth() - paramInt3 - layoutParams.rightMargin);
  }
  
  private int a(List<View> paramList, int paramInt) {
    int i = 0;
    int j = 0;
    while (i < paramInt) {
      j += ((View)paramList.get(i)).getMeasuredHeight();
      i++;
    } 
    return j;
  }
  
  private void a(int paramInt) {
    if (Math.abs(paramInt) > this.i) {
      float f = paramInt;
      if (!dispatchNestedPreFling(0.0F, f)) {
        boolean bool;
        if ((paramInt < 0 && !d()) || (paramInt > 0 && !e())) {
          bool = true;
        } else {
          bool = false;
        } 
        dispatchNestedFling(0.0F, f, bool);
        this.e.fling(0, this.c, 1, paramInt, -2147483648, -2147483648, -2147483648, 2147483647);
        startNestedScroll(2, 1);
        setScrollState(2);
        this.D = this.c;
        invalidate();
      } 
    } 
  }
  
  private void a(View paramView) {
    paramView.setVerticalScrollBarEnabled(false);
    paramView.setHorizontalScrollBarEnabled(false);
    paramView.setOverScrollMode(2);
    ViewCompat.setNestedScrollingEnabled(paramView, false);
  }
  
  private void a(View paramView, int paramInt) {
    AbsListView absListView;
    paramView = ScrollUtils.h(paramView);
    if (paramView instanceof AbsListView) {
      absListView = (AbsListView)paramView;
      if (Build.VERSION.SDK_INT >= 19) {
        absListView.scrollListBy(paramInt);
        return;
      } 
    } else {
      boolean bool;
      if (absListView instanceof RecyclerView) {
        bool = ScrollUtils.a((RecyclerView)absListView);
      } else {
        bool = false;
      } 
      absListView.scrollBy(0, paramInt);
      if (bool) {
        RecyclerView recyclerView = (RecyclerView)absListView;
        recyclerView.postDelayed(new Runnable(this, recyclerView) {
              public void run() {
                ScrollUtils.b(this.a);
              }
            }0L);
      } 
    } 
  }
  
  private void a(View paramView1, View paramView2) {
    OnStickyChangeListener onStickyChangeListener = this.M;
    if (onStickyChangeListener != null)
      onStickyChangeListener.a(paramView1, paramView2); 
  }
  
  private void a(List<View> paramList) {
    OnPermanentStickyChangeListener onPermanentStickyChangeListener = this.N;
    if (onPermanentStickyChangeListener != null)
      onPermanentStickyChangeListener.a(paramList); 
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    View view = this.w;
    if (view != null && paramBoolean1) {
      if (indexOfChild(view) != -1)
        e(this.w.getTop() + this.x); 
    } else {
      e(getScrollY());
    } 
    this.w = null;
    this.x = 0;
    b(true, paramBoolean2);
    s();
    t();
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.findPointerIndex(this.r);
    return (i < 0 || i >= paramMotionEvent.getPointerCount()) ? false : d(ScrollUtils.a((View)this, paramMotionEvent, i), ScrollUtils.b((View)this, paramMotionEvent, i));
  }
  
  private int b(View paramView) {
    int i = paramView.getMeasuredWidth();
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    return i + layoutParams.leftMargin + layoutParams.rightMargin;
  }
  
  private void b(int paramInt) {
    if (paramInt > 0) {
      c(paramInt);
      return;
    } 
    if (paramInt < 0)
      d(paramInt); 
  }
  
  private void b(int paramInt1, int paramInt2) {
    OnScrollChangeListener onScrollChangeListener = this.a;
    if (onScrollChangeListener != null)
      onScrollChangeListener.a((View)this, paramInt1, paramInt2, this.O); 
  }
  
  private void b(View paramView, int paramInt) {
    paramView.setY((getStickyY() - paramInt));
    paramView.setClickable(true);
  }
  
  private void b(List<View> paramList) {
    this.I.clear();
    for (int i = 0; i < paramList.size(); i++) {
      View view = paramList.get(i);
      int j = a(paramList, i);
      if (getScrollY() > 0 && view.getTop() <= getStickyY() + j) {
        view.setY((getStickyY() + j));
        view.setClickable(true);
        this.I.add(view);
      } 
    } 
    if (!w()) {
      this.H.clear();
      this.H.addAll(this.I);
      this.I.clear();
      a(this.H);
    } 
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2) {
    int j;
    if (!paramBoolean2 && (this.p || !this.e.isFinished() || this.y != -1))
      return; 
    int m = this.c;
    View view = b();
    if (view == null)
      return; 
    int k = indexOfChild(view);
    if (paramBoolean1) {
      int n = ScrollUtils.e(view);
      j = view.getTop() - getScrollY();
      if (n > 0 && j < 0) {
        n = Math.min(n, -j);
        e(getScrollY() - n);
        a(view, n);
      } 
    } 
    int i = 0;
    while (true) {
      j = k;
      if (i < k) {
        view = getChildAt(i);
        if (ScrollUtils.g(view)) {
          List<View> list;
          if (view instanceof IConsecutiveScroller) {
            list = ((IConsecutiveScroller)view).getScrolledViews();
            if (list != null && !list.isEmpty()) {
              int n = list.size();
              for (j = 0; j < n; j++)
                d(list.get(j)); 
            } 
          } else {
            d((View)list);
          } 
        } 
        i++;
        continue;
      } 
      break;
    } 
    label63: while (true) {
      k = j + 1;
      if (k < getChildCount()) {
        view = getChildAt(k);
        j = k;
        if (ScrollUtils.g(view)) {
          List<View> list;
          if (k == getChildCount() - 1 && view instanceof ConsecutiveViewPager && getScrollY() >= this.d) {
            j = k;
            continue;
          } 
          if (view instanceof IConsecutiveScroller) {
            list = ((IConsecutiveScroller)view).getScrolledViews();
            j = k;
            if (list != null) {
              j = k;
              if (!list.isEmpty()) {
                int n = list.size();
                i = 0;
                while (true) {
                  j = k;
                  if (i < n) {
                    c(list.get(i));
                    i++;
                    continue;
                  } 
                  continue label63;
                } 
                break;
              } 
            } 
            continue;
          } 
          c((View)list);
          j = k;
        } 
        continue;
      } 
      l();
      if (paramBoolean1) {
        i = this.c;
        if (m != i)
          b(i, m); 
      } 
      t();
      return;
    } 
  }
  
  private View c(int paramInt1, int paramInt2) {
    for (View view : getNonGoneChildren()) {
      if (ScrollUtils.b(view, paramInt1, paramInt2))
        return view; 
    } 
    return null;
  }
  
  private void c(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : I
    //   4: istore #7
    //   6: iload_1
    //   7: istore_2
    //   8: aload_0
    //   9: getfield y : I
    //   12: istore_1
    //   13: iconst_0
    //   14: istore #6
    //   16: iload_1
    //   17: iconst_m1
    //   18: if_icmpeq -> 105
    //   21: aload_0
    //   22: iload_1
    //   23: invokevirtual getChildAt : (I)Landroid/view/View;
    //   26: invokevirtual getTop : ()I
    //   29: istore_3
    //   30: aload_0
    //   31: getfield A : I
    //   34: istore_1
    //   35: iload_3
    //   36: iload_1
    //   37: isub
    //   38: istore_3
    //   39: iload_1
    //   40: ifge -> 55
    //   43: aload_0
    //   44: aload_0
    //   45: getfield y : I
    //   48: invokespecial f : (I)I
    //   51: istore_1
    //   52: goto -> 57
    //   55: iconst_0
    //   56: istore_1
    //   57: aload_0
    //   58: invokevirtual getScrollY : ()I
    //   61: aload_0
    //   62: invokevirtual getPaddingTop : ()I
    //   65: iadd
    //   66: iload_1
    //   67: iadd
    //   68: iload_3
    //   69: if_icmpge -> 82
    //   72: iload_1
    //   73: istore #4
    //   75: aload_0
    //   76: invokevirtual e : ()Z
    //   79: ifeq -> 110
    //   82: aload_0
    //   83: iconst_m1
    //   84: putfield y : I
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield z : I
    //   92: aload_0
    //   93: iconst_0
    //   94: putfield A : I
    //   97: aload_0
    //   98: iconst_0
    //   99: invokevirtual setScrollState : (I)V
    //   102: goto -> 312
    //   105: iconst_0
    //   106: istore_3
    //   107: iconst_0
    //   108: istore #4
    //   110: iload #6
    //   112: istore_1
    //   113: iload_2
    //   114: istore #5
    //   116: aload_0
    //   117: invokevirtual e : ()Z
    //   120: ifne -> 300
    //   123: aload_0
    //   124: invokevirtual getScrollY : ()I
    //   127: aload_0
    //   128: getfield d : I
    //   131: if_icmpge -> 143
    //   134: aload_0
    //   135: invokevirtual b : ()Landroid/view/View;
    //   138: astore #8
    //   140: goto -> 149
    //   143: aload_0
    //   144: invokespecial getBottomView : ()Landroid/view/View;
    //   147: astore #8
    //   149: iload #6
    //   151: istore_1
    //   152: iload_2
    //   153: istore #5
    //   155: aload #8
    //   157: ifnull -> 300
    //   160: aload_0
    //   161: invokevirtual awakenScrollBars : ()Z
    //   164: pop
    //   165: aload #8
    //   167: invokestatic e : (Landroid/view/View;)I
    //   170: istore_1
    //   171: iload_1
    //   172: ifle -> 223
    //   175: iload_2
    //   176: iload_1
    //   177: invokestatic min : (II)I
    //   180: istore #5
    //   182: iload #5
    //   184: istore_1
    //   185: aload_0
    //   186: getfield y : I
    //   189: iconst_m1
    //   190: if_icmpeq -> 213
    //   193: iload #5
    //   195: iload_3
    //   196: aload_0
    //   197: invokevirtual getScrollY : ()I
    //   200: aload_0
    //   201: invokevirtual getPaddingTop : ()I
    //   204: iadd
    //   205: iload #4
    //   207: iadd
    //   208: isub
    //   209: invokestatic min : (II)I
    //   212: istore_1
    //   213: aload_0
    //   214: aload #8
    //   216: iload_1
    //   217: invokespecial a : (Landroid/view/View;I)V
    //   220: goto -> 285
    //   223: iload_2
    //   224: aload #8
    //   226: invokevirtual getBottom : ()I
    //   229: aload_0
    //   230: invokevirtual getPaddingTop : ()I
    //   233: isub
    //   234: aload_0
    //   235: invokevirtual getScrollY : ()I
    //   238: isub
    //   239: invokestatic min : (II)I
    //   242: istore #5
    //   244: iload #5
    //   246: istore_1
    //   247: aload_0
    //   248: getfield y : I
    //   251: iconst_m1
    //   252: if_icmpeq -> 275
    //   255: iload #5
    //   257: iload_3
    //   258: aload_0
    //   259: invokevirtual getScrollY : ()I
    //   262: aload_0
    //   263: invokevirtual getPaddingTop : ()I
    //   266: iadd
    //   267: iload #4
    //   269: iadd
    //   270: isub
    //   271: invokestatic min : (II)I
    //   274: istore_1
    //   275: aload_0
    //   276: aload_0
    //   277: invokevirtual getScrollY : ()I
    //   280: iload_1
    //   281: iadd
    //   282: invokespecial e : (I)V
    //   285: aload_0
    //   286: aload_0
    //   287: getfield c : I
    //   290: iload_1
    //   291: iadd
    //   292: putfield c : I
    //   295: iload_2
    //   296: iload_1
    //   297: isub
    //   298: istore #5
    //   300: iload_1
    //   301: ifle -> 312
    //   304: iload #5
    //   306: istore_2
    //   307: iload #5
    //   309: ifgt -> 8
    //   312: aload_0
    //   313: getfield c : I
    //   316: istore_1
    //   317: iload #7
    //   319: iload_1
    //   320: if_icmpeq -> 330
    //   323: aload_0
    //   324: iload_1
    //   325: iload #7
    //   327: invokespecial b : (II)V
    //   330: return
  }
  
  private void c(View paramView) {
    int i;
    do {
      i = 0;
      int j = ScrollUtils.d(paramView);
      if (j >= 0)
        continue; 
      i = ScrollUtils.a(paramView);
      a(paramView, j);
      i -= ScrollUtils.a(paramView);
    } while (i != 0);
  }
  
  private void d(int paramInt) {
    int j = this.c;
    int i = paramInt;
    while (true) {
      byte b1;
      byte b2;
      paramInt = this.y;
      int m = 0;
      if (paramInt != -1) {
        b1 = getChildAt(paramInt).getTop() - this.A;
        b2 = f(this.y);
        if (getScrollY() + getPaddingTop() + b2 <= b1 || d()) {
          this.y = -1;
          this.z = 0;
          this.A = 0;
          setScrollState(0);
          break;
        } 
      } else {
        b1 = 0;
        b2 = 0;
      } 
      paramInt = m;
      int k = i;
      if (!d()) {
        View view = c();
        paramInt = m;
        k = i;
        if (view != null) {
          awakenScrollBars();
          paramInt = ScrollUtils.d(view);
          if (paramInt < 0) {
            k = Math.max(i, paramInt);
            paramInt = k;
            if (this.y != -1)
              paramInt = Math.max(k, b1 - getScrollY() + getPaddingTop() + b2); 
            a(view, paramInt);
          } else {
            m = getScrollY();
            k = Math.max(Math.max(i, view.getTop() + getPaddingBottom() - m - getHeight()), -m);
            paramInt = k;
            if (this.y != -1)
              paramInt = Math.max(k, b1 - getScrollY() + getPaddingTop() + b2); 
            e(m + paramInt);
          } 
          this.c += paramInt;
          k = i - paramInt;
        } 
      } 
      if (paramInt < 0) {
        i = k;
        if (k >= 0)
          break; 
        continue;
      } 
      break;
    } 
    paramInt = this.c;
    if (j != paramInt)
      b(paramInt, j); 
  }
  
  private void d(View paramView) {
    int i;
    do {
      i = 0;
      int j = ScrollUtils.e(paramView);
      if (j <= 0)
        continue; 
      i = ScrollUtils.a(paramView);
      a(paramView, j);
      i -= ScrollUtils.a(paramView);
    } while (i != 0);
  }
  
  private boolean d(int paramInt1, int paramInt2) {
    View view = c(paramInt1, paramInt2);
    return (view != null) ? ScrollUtils.g(view) : false;
  }
  
  private void e(int paramInt) {
    int i;
    if (paramInt < 0) {
      i = 0;
    } else {
      int j = this.d;
      i = paramInt;
      if (paramInt > j)
        i = j; 
    } 
    super.scrollTo(0, i);
  }
  
  private void e(int paramInt1, int paramInt2) {
    int i = this.c;
    b(paramInt1);
    i = this.c - i;
    this.t.dispatchNestedScroll(0, i, 0, paramInt1 - i, null, paramInt2);
  }
  
  private boolean e(View paramView) {
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    return (layoutParams instanceof LayoutParams) ? ((LayoutParams)layoutParams).c : false;
  }
  
  private int f(int paramInt) {
    List<View> list = getNonGoneChildren();
    int j = list.size();
    int i;
    for (i = 0; paramInt < j; i = k) {
      View view = list.get(paramInt);
      int k = i;
      if (view.getVisibility() != 8) {
        k = i;
        if (ScrollUtils.g(view))
          k = i + ScrollUtils.a(view); 
      } 
      paramInt++;
    } 
    return i;
  }
  
  private void f() {
    int j;
    ArrayList<View> arrayList = new ArrayList();
    int k = getChildCount();
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < k) {
        View view = getChildAt(i);
        if (!e(view))
          arrayList.add(view); 
        i++;
        continue;
      } 
      break;
    } 
    while (j < k) {
      View view = getChildAt(j);
      if (e(view))
        arrayList.add(view); 
      j++;
    } 
    this.K.clear();
    this.K.addAll(arrayList);
  }
  
  private View getBottomView() {
    List<View> list = getEffectiveChildren();
    return !list.isEmpty() ? list.get(list.size() - 1) : null;
  }
  
  private List<View> getEffectiveChildren() {
    ArrayList<View> arrayList = new ArrayList();
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8 && view.getHeight() > 0)
        arrayList.add(view); 
    } 
    return arrayList;
  }
  
  private List<View> getNonGoneChildren() {
    ArrayList<View> arrayList = new ArrayList();
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8)
        arrayList.add(view); 
    } 
    return arrayList;
  }
  
  private int getScrollRange() {
    int j = getChildCount();
    int i = 0;
    if (j > 0)
      i = Math.max(0, computeVerticalScrollRange() - getHeight() - getPaddingTop() - getPaddingBottom()); 
    return i;
  }
  
  private List<View> getStickyChildren() {
    ArrayList<View> arrayList = new ArrayList();
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() != 8 && e(view))
        arrayList.add(view); 
    } 
    return arrayList;
  }
  
  private int getStickyY() {
    return getScrollY() + getPaddingTop() + this.F;
  }
  
  private void h() {
    this.w = x();
    if (this.w != null)
      this.x = getScrollY() - this.w.getTop(); 
  }
  
  private boolean i() {
    return (!d() || !e());
  }
  
  private void j() {
    EdgeEffect edgeEffect = this.B;
    if (edgeEffect != null) {
      edgeEffect.onRelease();
      this.C.onRelease();
    } 
  }
  
  private void k() {
    if (getOverScrollMode() != 2) {
      if (this.B == null) {
        Context context = getContext();
        this.B = new EdgeEffect(context);
        this.C = new EdgeEffect(context);
        return;
      } 
    } else {
      this.B = null;
      this.C = null;
    } 
  }
  
  private void l() {
    this.c = computeVerticalScrollOffset();
  }
  
  private void m() {
    VelocityTracker velocityTracker = this.f;
    if (velocityTracker == null) {
      this.f = VelocityTracker.obtain();
      return;
    } 
    velocityTracker.clear();
  }
  
  private void n() {
    VelocityTracker velocityTracker = this.f;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.f = null;
    } 
  }
  
  private void o() {
    VelocityTracker velocityTracker = this.g;
    if (velocityTracker == null) {
      this.g = VelocityTracker.obtain();
      return;
    } 
    velocityTracker.clear();
  }
  
  private void p() {
    if (this.g == null)
      this.g = VelocityTracker.obtain(); 
  }
  
  private void q() {
    VelocityTracker velocityTracker = this.g;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.g = null;
    } 
  }
  
  private void r() {
    this.e.abortAnimation();
    stopNestedScroll(1);
    if (this.y == -1)
      setScrollState(0); 
  }
  
  private void s() {
    Iterator<View> iterator = getNonGoneChildren().iterator();
    while (iterator.hasNext())
      ((View)iterator.next()).setTranslationY(0.0F); 
  }
  
  private void t() {
    List<View> list = getStickyChildren();
    if (!list.isEmpty()) {
      View view1;
      View view2;
      int j = list.size();
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++)
        ((View)list.get(i)).setTranslationY(0.0F); 
      if (this.E) {
        u();
        b(list);
        return;
      } 
      v();
      i = --j;
      while (true) {
        view2 = null;
        if (i >= 0) {
          View view = list.get(i);
          if (getScrollY() > 0 && view.getTop() <= getStickyY()) {
            View view4 = view;
            if (i != j) {
              view2 = list.get(i + 1);
              view4 = view;
            } 
            break;
          } 
          i--;
          continue;
        } 
        view1 = null;
        break;
      } 
      View view3 = this.G;
      if (view1 != null) {
        i = bool;
        if (view2 != null)
          i = Math.max(0, view1.getHeight() - view2.getTop() - getStickyY()); 
        b(view1, i);
      } 
      if (view3 != view1) {
        this.G = view1;
        a(view3, view1);
        return;
      } 
    } else {
      u();
      v();
    } 
  }
  
  private void u() {
    View view = this.G;
    if (view != null) {
      this.G = null;
      a(view, (View)null);
    } 
  }
  
  private void v() {
    if (!this.H.isEmpty()) {
      this.H.clear();
      a(this.H);
    } 
  }
  
  private boolean w() {
    if (this.I.size() == this.H.size()) {
      int j = this.I.size();
      for (int i = 0; i < j; i++) {
        if (this.I.get(i) != this.H.get(i))
          return false; 
      } 
      return true;
    } 
    return false;
  }
  
  private View x() {
    int j = getScrollY() + getPaddingTop();
    List<View> list = getNonGoneChildren();
    int k = list.size();
    for (int i = 0; i < k; i++) {
      View view = list.get(i);
      if (view.getTop() <= j && view.getBottom() >= j)
        return view; 
    } 
    return null;
  }
  
  protected LayoutParams a() {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams a(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
    return new LayoutParams(paramLayoutParams);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    if (paramLayoutParams instanceof LayoutParams)
      LayoutParamsUtils.a((LayoutParams)paramLayoutParams); 
    super.addView(paramView, paramInt, paramLayoutParams);
    if (ScrollUtils.g(paramView)) {
      a(paramView);
      if (paramView instanceof IConsecutiveScroller) {
        List<View> list = ((IConsecutiveScroller)paramView).getScrolledViews();
        if (list != null && !list.isEmpty()) {
          int i = list.size();
          for (paramInt = 0; paramInt < i; paramInt++)
            a(list.get(paramInt)); 
        } 
      } 
    } 
    if (paramView instanceof ViewGroup)
      ((ViewGroup)paramView).setClipToPadding(false); 
  }
  
  public View b() {
    int j = getScrollY() + getPaddingTop();
    List<View> list = getEffectiveChildren();
    int k = list.size();
    for (int i = 0; i < k; i++) {
      View view = list.get(i);
      if (view.getTop() <= j && view.getBottom() > j)
        return view; 
    } 
    return null;
  }
  
  public View c() {
    int j = getHeight() - getPaddingBottom() + getScrollY();
    List<View> list = getEffectiveChildren();
    int k = list.size();
    for (int i = 0; i < k; i++) {
      View view = list.get(i);
      if (view.getTop() < j && view.getBottom() >= j)
        return view; 
    } 
    return null;
  }
  
  public boolean canScrollVertically(int paramInt) {
    return (paramInt > 0) ? (e() ^ true) : (d() ^ true);
  }
  
  public int computeHorizontalScrollExtent() {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset() {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange() {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll() {
    // Byte code:
    //   0: aload_0
    //   1: getfield y : I
    //   4: iconst_m1
    //   5: if_icmpeq -> 27
    //   8: aload_0
    //   9: getfield z : I
    //   12: istore_1
    //   13: iload_1
    //   14: ifeq -> 27
    //   17: aload_0
    //   18: iload_1
    //   19: invokespecial b : (I)V
    //   22: aload_0
    //   23: invokevirtual invalidate : ()V
    //   26: return
    //   27: aload_0
    //   28: getfield e : Landroid/widget/OverScroller;
    //   31: invokevirtual computeScrollOffset : ()Z
    //   34: ifeq -> 291
    //   37: aload_0
    //   38: getfield e : Landroid/widget/OverScroller;
    //   41: invokevirtual getCurrY : ()I
    //   44: istore_2
    //   45: iload_2
    //   46: aload_0
    //   47: getfield D : I
    //   50: isub
    //   51: istore_1
    //   52: aload_0
    //   53: iload_2
    //   54: putfield D : I
    //   57: aload_0
    //   58: getfield v : [I
    //   61: astore #5
    //   63: iconst_1
    //   64: istore_3
    //   65: aload #5
    //   67: iconst_1
    //   68: iconst_0
    //   69: iastore
    //   70: aload_0
    //   71: iconst_0
    //   72: iload_1
    //   73: aload #5
    //   75: aconst_null
    //   76: iconst_1
    //   77: invokevirtual dispatchNestedPreScroll : (II[I[II)Z
    //   80: pop
    //   81: iload_1
    //   82: aload_0
    //   83: getfield v : [I
    //   86: iconst_1
    //   87: iaload
    //   88: isub
    //   89: istore_1
    //   90: aload_0
    //   91: getfield c : I
    //   94: istore_2
    //   95: aload_0
    //   96: iload_1
    //   97: invokespecial b : (I)V
    //   100: aload_0
    //   101: getfield c : I
    //   104: iload_2
    //   105: isub
    //   106: istore #4
    //   108: iload_1
    //   109: iload #4
    //   111: isub
    //   112: istore_2
    //   113: iload_2
    //   114: ifge -> 124
    //   117: aload_0
    //   118: invokevirtual d : ()Z
    //   121: ifne -> 139
    //   124: iload_2
    //   125: istore_1
    //   126: iload_2
    //   127: ifle -> 163
    //   130: iload_2
    //   131: istore_1
    //   132: aload_0
    //   133: invokevirtual e : ()Z
    //   136: ifeq -> 163
    //   139: aload_0
    //   140: iconst_0
    //   141: iload #4
    //   143: iconst_0
    //   144: iload_2
    //   145: aload_0
    //   146: getfield u : [I
    //   149: iconst_1
    //   150: invokevirtual dispatchNestedScroll : (IIII[II)Z
    //   153: pop
    //   154: iload_2
    //   155: aload_0
    //   156: getfield u : [I
    //   159: iconst_1
    //   160: iaload
    //   161: iadd
    //   162: istore_1
    //   163: iload_1
    //   164: ifge -> 174
    //   167: aload_0
    //   168: invokevirtual d : ()Z
    //   171: ifne -> 185
    //   174: iload_1
    //   175: ifle -> 287
    //   178: aload_0
    //   179: invokevirtual e : ()Z
    //   182: ifeq -> 287
    //   185: aload_0
    //   186: invokevirtual getOverScrollMode : ()I
    //   189: istore #4
    //   191: iload_3
    //   192: istore_2
    //   193: iload #4
    //   195: ifeq -> 218
    //   198: iload #4
    //   200: iconst_1
    //   201: if_icmpne -> 216
    //   204: aload_0
    //   205: invokespecial getScrollRange : ()I
    //   208: ifle -> 216
    //   211: iload_3
    //   212: istore_2
    //   213: goto -> 218
    //   216: iconst_0
    //   217: istore_2
    //   218: iload_2
    //   219: ifeq -> 283
    //   222: aload_0
    //   223: invokespecial k : ()V
    //   226: iload_1
    //   227: ifge -> 258
    //   230: aload_0
    //   231: getfield B : Landroid/widget/EdgeEffect;
    //   234: invokevirtual isFinished : ()Z
    //   237: ifeq -> 283
    //   240: aload_0
    //   241: getfield B : Landroid/widget/EdgeEffect;
    //   244: aload_0
    //   245: getfield e : Landroid/widget/OverScroller;
    //   248: invokevirtual getCurrVelocity : ()F
    //   251: f2i
    //   252: invokevirtual onAbsorb : (I)V
    //   255: goto -> 283
    //   258: aload_0
    //   259: getfield C : Landroid/widget/EdgeEffect;
    //   262: invokevirtual isFinished : ()Z
    //   265: ifeq -> 283
    //   268: aload_0
    //   269: getfield C : Landroid/widget/EdgeEffect;
    //   272: aload_0
    //   273: getfield e : Landroid/widget/OverScroller;
    //   276: invokevirtual getCurrVelocity : ()F
    //   279: f2i
    //   280: invokevirtual onAbsorb : (I)V
    //   283: aload_0
    //   284: invokespecial r : ()V
    //   287: aload_0
    //   288: invokevirtual invalidate : ()V
    //   291: aload_0
    //   292: getfield O : I
    //   295: iconst_2
    //   296: if_icmpne -> 320
    //   299: aload_0
    //   300: getfield e : Landroid/widget/OverScroller;
    //   303: invokevirtual isFinished : ()Z
    //   306: ifeq -> 320
    //   309: aload_0
    //   310: iconst_0
    //   311: iconst_0
    //   312: invokespecial b : (ZZ)V
    //   315: aload_0
    //   316: iconst_0
    //   317: invokevirtual setScrollState : (I)V
    //   320: return
  }
  
  public int computeVerticalScrollExtent() {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  public int computeVerticalScrollOffset() {
    int j = getScrollY();
    List<View> list = getNonGoneChildren();
    int k = list.size();
    int i = 0;
    while (i < k) {
      View view = list.get(i);
      int m = j;
      if (ScrollUtils.g(view))
        m = j + ScrollUtils.a(view); 
      i++;
      j = m;
    } 
    return j;
  }
  
  public int computeVerticalScrollRange() {
    List<View> list = getNonGoneChildren();
    int k = list.size();
    int j = 0;
    int i;
    for (i = 0;; i += m) {
      int m;
      if (j < k) {
        View view = list.get(j);
        if (!ScrollUtils.g(view)) {
          m = view.getHeight();
        } else {
          if (ScrollUtils.f(view)) {
            view = ScrollUtils.h(view);
            i += ScrollUtils.b(view) + view.getPaddingTop() + view.getPaddingBottom();
          } else {
            m = view.getHeight();
            i += m;
          } 
          j++;
          continue;
        } 
      } else {
        break;
      } 
    } 
    return i;
  }
  
  public boolean d() {
    List<View> list = getEffectiveChildren();
    int i = list.size();
    boolean bool2 = true;
    boolean bool1 = true;
    if (i > 0) {
      View view = list.get(0);
      if (getScrollY() > 0 || ScrollUtils.a(view, -1))
        bool1 = false; 
      bool2 = bool1;
      if (bool1) {
        int j = 0;
        while (true) {
          bool2 = bool1;
          if (j < i) {
            view = list.get(j);
            if (view instanceof ConsecutiveViewPager) {
              ConsecutiveViewPager consecutiveViewPager = (ConsecutiveViewPager)view;
              if (consecutiveViewPager.getAdjustHeight() > 0 && ScrollUtils.g((View)consecutiveViewPager) && ScrollUtils.a((View)consecutiveViewPager, -1))
                return false; 
            } 
            j++;
            continue;
          } 
          break;
        } 
      } 
    } 
    return bool2;
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return this.t.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    return this.t.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, 0);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt3) {
    return this.t.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, paramInt3);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return this.t.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, int paramInt5) {
    return this.t.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, paramInt5);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionIndex : ()I
    //   4: istore_2
    //   5: aload_0
    //   6: getfield q : I
    //   9: iconst_2
    //   10: if_icmpne -> 25
    //   13: aload_1
    //   14: aload_1
    //   15: invokevirtual getX : ()F
    //   18: aload_0
    //   19: getfield n : F
    //   22: invokevirtual setLocation : (FF)V
    //   25: aload_1
    //   26: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
    //   29: astore #6
    //   31: aload #6
    //   33: invokevirtual getActionMasked : ()I
    //   36: ifne -> 44
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield L : I
    //   44: aload #6
    //   46: fconst_0
    //   47: aload_0
    //   48: getfield L : I
    //   51: i2f
    //   52: invokevirtual offsetLocation : (FF)V
    //   55: aload_1
    //   56: invokevirtual getActionMasked : ()I
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq -> 719
    //   64: iload_3
    //   65: iconst_1
    //   66: if_icmpeq -> 529
    //   69: iload_3
    //   70: iconst_2
    //   71: if_icmpeq -> 338
    //   74: iload_3
    //   75: iconst_3
    //   76: if_icmpeq -> 529
    //   79: iload_3
    //   80: iconst_5
    //   81: if_icmpeq -> 234
    //   84: iload_3
    //   85: bipush #6
    //   87: if_icmpeq -> 93
    //   90: goto -> 820
    //   93: aload_0
    //   94: getfield r : I
    //   97: aload_1
    //   98: iload_2
    //   99: invokevirtual getPointerId : (I)I
    //   102: if_icmpne -> 218
    //   105: iload_2
    //   106: ifne -> 114
    //   109: iconst_1
    //   110: istore_2
    //   111: goto -> 116
    //   114: iconst_0
    //   115: istore_2
    //   116: iload_2
    //   117: iflt -> 216
    //   120: iload_2
    //   121: aload_1
    //   122: invokevirtual getPointerCount : ()I
    //   125: if_icmplt -> 130
    //   128: iconst_0
    //   129: ireturn
    //   130: aload_0
    //   131: aload_1
    //   132: iload_2
    //   133: invokevirtual getPointerId : (I)I
    //   136: putfield r : I
    //   139: aload_0
    //   140: aload_1
    //   141: iload_2
    //   142: invokevirtual getY : (I)F
    //   145: f2i
    //   146: putfield m : I
    //   149: aload_0
    //   150: aload_1
    //   151: iload_2
    //   152: invokevirtual getX : (I)F
    //   155: f2i
    //   156: putfield l : I
    //   159: aload_0
    //   160: getfield o : [I
    //   163: iconst_0
    //   164: aload_0
    //   165: aload_1
    //   166: iload_2
    //   167: invokestatic a : (Landroid/view/View;Landroid/view/MotionEvent;I)I
    //   170: iastore
    //   171: aload_0
    //   172: getfield o : [I
    //   175: iconst_1
    //   176: aload_0
    //   177: aload_1
    //   178: iload_2
    //   179: invokestatic b : (Landroid/view/View;Landroid/view/MotionEvent;I)I
    //   182: iastore
    //   183: aload_0
    //   184: getfield g : Landroid/view/VelocityTracker;
    //   187: astore #7
    //   189: aload #7
    //   191: ifnull -> 199
    //   194: aload #7
    //   196: invokevirtual clear : ()V
    //   199: aload_0
    //   200: getfield g : Landroid/view/VelocityTracker;
    //   203: ifnull -> 218
    //   206: aload_0
    //   207: getfield f : Landroid/view/VelocityTracker;
    //   210: invokevirtual clear : ()V
    //   213: goto -> 218
    //   216: iconst_0
    //   217: ireturn
    //   218: aload_0
    //   219: invokespecial p : ()V
    //   222: aload_0
    //   223: getfield g : Landroid/view/VelocityTracker;
    //   226: aload #6
    //   228: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   231: goto -> 820
    //   234: aload_0
    //   235: aload_1
    //   236: iload_2
    //   237: invokevirtual getPointerId : (I)I
    //   240: putfield r : I
    //   243: aload_0
    //   244: aload_1
    //   245: iload_2
    //   246: invokevirtual getY : (I)F
    //   249: f2i
    //   250: putfield m : I
    //   253: aload_0
    //   254: aload_1
    //   255: iload_2
    //   256: invokevirtual getX : (I)F
    //   259: f2i
    //   260: putfield l : I
    //   263: aload_0
    //   264: iconst_0
    //   265: invokevirtual requestDisallowInterceptTouchEvent : (Z)V
    //   268: aload_0
    //   269: getfield o : [I
    //   272: iconst_0
    //   273: aload_0
    //   274: aload_1
    //   275: iload_2
    //   276: invokestatic a : (Landroid/view/View;Landroid/view/MotionEvent;I)I
    //   279: iastore
    //   280: aload_0
    //   281: getfield o : [I
    //   284: iconst_1
    //   285: aload_0
    //   286: aload_1
    //   287: iload_2
    //   288: invokestatic b : (Landroid/view/View;Landroid/view/MotionEvent;I)I
    //   291: iastore
    //   292: aload_0
    //   293: getfield g : Landroid/view/VelocityTracker;
    //   296: astore #7
    //   298: aload #7
    //   300: ifnull -> 308
    //   303: aload #7
    //   305: invokevirtual clear : ()V
    //   308: aload_0
    //   309: getfield g : Landroid/view/VelocityTracker;
    //   312: ifnull -> 322
    //   315: aload_0
    //   316: getfield f : Landroid/view/VelocityTracker;
    //   319: invokevirtual clear : ()V
    //   322: aload_0
    //   323: invokespecial p : ()V
    //   326: aload_0
    //   327: getfield g : Landroid/view/VelocityTracker;
    //   330: aload #6
    //   332: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   335: goto -> 820
    //   338: aload_0
    //   339: invokespecial p : ()V
    //   342: aload_0
    //   343: getfield g : Landroid/view/VelocityTracker;
    //   346: aload #6
    //   348: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   351: aload_1
    //   352: aload_0
    //   353: getfield r : I
    //   356: invokevirtual findPointerIndex : (I)I
    //   359: istore_2
    //   360: iload_2
    //   361: iflt -> 527
    //   364: iload_2
    //   365: aload_1
    //   366: invokevirtual getPointerCount : ()I
    //   369: if_icmplt -> 374
    //   372: iconst_0
    //   373: ireturn
    //   374: aload_1
    //   375: iload_2
    //   376: invokevirtual getY : (I)F
    //   379: f2i
    //   380: aload_0
    //   381: getfield m : I
    //   384: isub
    //   385: istore_3
    //   386: aload_1
    //   387: iload_2
    //   388: invokevirtual getX : (I)F
    //   391: f2i
    //   392: aload_0
    //   393: getfield l : I
    //   396: isub
    //   397: istore #4
    //   399: aload_0
    //   400: aload_1
    //   401: invokespecial a : (Landroid/view/MotionEvent;)Z
    //   404: ifne -> 428
    //   407: aload_0
    //   408: getfield o : [I
    //   411: astore #7
    //   413: aload_0
    //   414: aload #7
    //   416: iconst_0
    //   417: iaload
    //   418: aload #7
    //   420: iconst_1
    //   421: iaload
    //   422: invokespecial d : (II)Z
    //   425: ifeq -> 504
    //   428: aload_0
    //   429: getfield q : I
    //   432: ifne -> 504
    //   435: iload #4
    //   437: invokestatic abs : (I)I
    //   440: iload_3
    //   441: invokestatic abs : (I)I
    //   444: if_icmple -> 479
    //   447: iload #4
    //   449: invokestatic abs : (I)I
    //   452: aload_0
    //   453: getfield j : I
    //   456: if_icmplt -> 495
    //   459: aload_0
    //   460: iconst_2
    //   461: putfield q : I
    //   464: aload_1
    //   465: aload_1
    //   466: invokevirtual getX : ()F
    //   469: aload_0
    //   470: getfield n : F
    //   473: invokevirtual setLocation : (FF)V
    //   476: goto -> 495
    //   479: iload_3
    //   480: invokestatic abs : (I)I
    //   483: aload_0
    //   484: getfield j : I
    //   487: if_icmplt -> 495
    //   490: aload_0
    //   491: iconst_1
    //   492: putfield q : I
    //   495: aload_0
    //   496: getfield q : I
    //   499: ifne -> 504
    //   502: iconst_1
    //   503: ireturn
    //   504: aload_0
    //   505: aload_1
    //   506: iload_2
    //   507: invokevirtual getY : (I)F
    //   510: f2i
    //   511: putfield m : I
    //   514: aload_0
    //   515: aload_1
    //   516: iload_2
    //   517: invokevirtual getX : (I)F
    //   520: f2i
    //   521: putfield l : I
    //   524: goto -> 820
    //   527: iconst_0
    //   528: ireturn
    //   529: aload_0
    //   530: getfield g : Landroid/view/VelocityTracker;
    //   533: astore #7
    //   535: aload #7
    //   537: ifnull -> 680
    //   540: aload #7
    //   542: aload #6
    //   544: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   547: aload_0
    //   548: getfield g : Landroid/view/VelocityTracker;
    //   551: sipush #1000
    //   554: aload_0
    //   555: getfield h : I
    //   558: i2f
    //   559: invokevirtual computeCurrentVelocity : (IF)V
    //   562: aload_0
    //   563: getfield g : Landroid/view/VelocityTracker;
    //   566: invokevirtual getYVelocity : ()F
    //   569: f2i
    //   570: istore_3
    //   571: aload_0
    //   572: invokespecial q : ()V
    //   575: aload_0
    //   576: aload_1
    //   577: iload_2
    //   578: invokestatic a : (Landroid/view/View;Landroid/view/MotionEvent;I)I
    //   581: istore #4
    //   583: aload_0
    //   584: aload_1
    //   585: iload_2
    //   586: invokestatic b : (Landroid/view/View;Landroid/view/MotionEvent;I)I
    //   589: istore_2
    //   590: aload_0
    //   591: iload #4
    //   593: iload_2
    //   594: invokespecial c : (II)Landroid/view/View;
    //   597: invokestatic f : (Landroid/view/View;)Z
    //   600: istore #5
    //   602: aload_0
    //   603: getfield q : I
    //   606: iconst_1
    //   607: if_icmpeq -> 641
    //   610: iload #5
    //   612: ifeq -> 641
    //   615: iload_3
    //   616: invokestatic abs : (I)I
    //   619: aload_0
    //   620: getfield i : I
    //   623: if_icmplt -> 641
    //   626: aload_0
    //   627: iload #4
    //   629: iload_2
    //   630: invokestatic c : (Landroid/view/View;II)Z
    //   633: ifne -> 641
    //   636: aload_1
    //   637: iconst_3
    //   638: invokevirtual setAction : (I)V
    //   641: aload_0
    //   642: getfield q : I
    //   645: ifne -> 680
    //   648: aload_0
    //   649: invokestatic i : (Landroid/view/View;)Z
    //   652: ifne -> 680
    //   655: aload_0
    //   656: aload_1
    //   657: invokespecial a : (Landroid/view/MotionEvent;)Z
    //   660: ifeq -> 680
    //   663: iload_3
    //   664: invokestatic abs : (I)I
    //   667: aload_0
    //   668: getfield i : I
    //   671: if_icmplt -> 680
    //   674: aload_0
    //   675: iload_3
    //   676: ineg
    //   677: invokespecial a : (I)V
    //   680: aload_0
    //   681: iconst_0
    //   682: putfield m : I
    //   685: aload_0
    //   686: iconst_0
    //   687: putfield l : I
    //   690: aload_0
    //   691: iconst_0
    //   692: putfield p : Z
    //   695: aload_0
    //   696: iconst_0
    //   697: putfield q : I
    //   700: aload_0
    //   701: getfield o : [I
    //   704: astore #7
    //   706: aload #7
    //   708: iconst_0
    //   709: iconst_0
    //   710: iastore
    //   711: aload #7
    //   713: iconst_1
    //   714: iconst_0
    //   715: iastore
    //   716: goto -> 820
    //   719: aload_0
    //   720: invokespecial r : ()V
    //   723: aload_0
    //   724: iconst_0
    //   725: iconst_0
    //   726: invokespecial b : (ZZ)V
    //   729: aload_0
    //   730: iconst_1
    //   731: putfield p : Z
    //   734: aload_0
    //   735: iconst_0
    //   736: putfield q : I
    //   739: aload_0
    //   740: aload_1
    //   741: invokevirtual getY : ()F
    //   744: putfield n : F
    //   747: aload_0
    //   748: aload_1
    //   749: iload_2
    //   750: invokevirtual getPointerId : (I)I
    //   753: putfield r : I
    //   756: aload_0
    //   757: aload_1
    //   758: iload_2
    //   759: invokevirtual getY : (I)F
    //   762: f2i
    //   763: putfield m : I
    //   766: aload_0
    //   767: aload_1
    //   768: iload_2
    //   769: invokevirtual getX : (I)F
    //   772: f2i
    //   773: putfield l : I
    //   776: aload_0
    //   777: invokespecial o : ()V
    //   780: aload_0
    //   781: getfield g : Landroid/view/VelocityTracker;
    //   784: aload #6
    //   786: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   789: aload_0
    //   790: iconst_2
    //   791: iconst_0
    //   792: invokevirtual startNestedScroll : (II)Z
    //   795: pop
    //   796: aload_0
    //   797: getfield o : [I
    //   800: iconst_0
    //   801: aload_0
    //   802: aload_1
    //   803: iload_2
    //   804: invokestatic a : (Landroid/view/View;Landroid/view/MotionEvent;I)I
    //   807: iastore
    //   808: aload_0
    //   809: getfield o : [I
    //   812: iconst_1
    //   813: aload_0
    //   814: aload_1
    //   815: iload_2
    //   816: invokestatic b : (Landroid/view/View;Landroid/view/MotionEvent;I)I
    //   819: iastore
    //   820: aload #6
    //   822: invokevirtual recycle : ()V
    //   825: aload_0
    //   826: aload_1
    //   827: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   830: istore #5
    //   832: aload_1
    //   833: invokevirtual getActionMasked : ()I
    //   836: istore_2
    //   837: iload_2
    //   838: iconst_1
    //   839: if_icmpeq -> 850
    //   842: iload_2
    //   843: iconst_3
    //   844: if_icmpeq -> 850
    //   847: iload #5
    //   849: ireturn
    //   850: aload_0
    //   851: invokespecial n : ()V
    //   854: aload_0
    //   855: getfield e : Landroid/widget/OverScroller;
    //   858: invokevirtual isFinished : ()Z
    //   861: ifeq -> 869
    //   864: aload_0
    //   865: iconst_0
    //   866: invokevirtual setScrollState : (I)V
    //   869: iload #5
    //   871: ireturn
  }
  
  public void draw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial draw : (Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: getfield J : I
    //   9: aload_0
    //   10: invokevirtual getScrollY : ()I
    //   13: if_icmpeq -> 28
    //   16: aload_0
    //   17: aload_0
    //   18: invokevirtual getScrollY : ()I
    //   21: putfield J : I
    //   24: aload_0
    //   25: invokespecial t : ()V
    //   28: aload_0
    //   29: getfield B : Landroid/widget/EdgeEffect;
    //   32: ifnull -> 384
    //   35: aload_0
    //   36: invokevirtual getScrollY : ()I
    //   39: istore #7
    //   41: aload_0
    //   42: getfield B : Landroid/widget/EdgeEffect;
    //   45: invokevirtual isFinished : ()Z
    //   48: istore #10
    //   50: iconst_0
    //   51: istore #6
    //   53: iload #10
    //   55: ifne -> 202
    //   58: aload_1
    //   59: invokevirtual save : ()I
    //   62: istore #8
    //   64: aload_0
    //   65: invokevirtual getWidth : ()I
    //   68: istore_2
    //   69: aload_0
    //   70: invokevirtual getHeight : ()I
    //   73: istore #4
    //   75: getstatic android/os/Build$VERSION.SDK_INT : I
    //   78: bipush #21
    //   80: if_icmplt -> 98
    //   83: aload_0
    //   84: invokevirtual getClipToPadding : ()Z
    //   87: ifeq -> 93
    //   90: goto -> 98
    //   93: iconst_0
    //   94: istore_3
    //   95: goto -> 117
    //   98: iload_2
    //   99: aload_0
    //   100: invokevirtual getPaddingLeft : ()I
    //   103: aload_0
    //   104: invokevirtual getPaddingRight : ()I
    //   107: iadd
    //   108: isub
    //   109: istore_2
    //   110: aload_0
    //   111: invokevirtual getPaddingLeft : ()I
    //   114: iconst_0
    //   115: iadd
    //   116: istore_3
    //   117: getstatic android/os/Build$VERSION.SDK_INT : I
    //   120: bipush #21
    //   122: if_icmplt -> 158
    //   125: aload_0
    //   126: invokevirtual getClipToPadding : ()Z
    //   129: ifeq -> 158
    //   132: iload #4
    //   134: aload_0
    //   135: invokevirtual getPaddingTop : ()I
    //   138: aload_0
    //   139: invokevirtual getPaddingBottom : ()I
    //   142: iadd
    //   143: isub
    //   144: istore #4
    //   146: aload_0
    //   147: invokevirtual getPaddingTop : ()I
    //   150: iload #7
    //   152: iadd
    //   153: istore #5
    //   155: goto -> 162
    //   158: iload #7
    //   160: istore #5
    //   162: aload_1
    //   163: iload_3
    //   164: i2f
    //   165: iload #5
    //   167: i2f
    //   168: invokevirtual translate : (FF)V
    //   171: aload_0
    //   172: getfield B : Landroid/widget/EdgeEffect;
    //   175: iload_2
    //   176: iload #4
    //   178: invokevirtual setSize : (II)V
    //   181: aload_0
    //   182: getfield B : Landroid/widget/EdgeEffect;
    //   185: aload_1
    //   186: invokevirtual draw : (Landroid/graphics/Canvas;)Z
    //   189: ifeq -> 196
    //   192: aload_0
    //   193: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   196: aload_1
    //   197: iload #8
    //   199: invokevirtual restoreToCount : (I)V
    //   202: aload_0
    //   203: getfield C : Landroid/widget/EdgeEffect;
    //   206: invokevirtual isFinished : ()Z
    //   209: ifne -> 384
    //   212: aload_1
    //   213: invokevirtual save : ()I
    //   216: istore #9
    //   218: aload_0
    //   219: invokevirtual getWidth : ()I
    //   222: istore #4
    //   224: aload_0
    //   225: invokevirtual getHeight : ()I
    //   228: istore #8
    //   230: iload #7
    //   232: iload #8
    //   234: iadd
    //   235: istore #7
    //   237: getstatic android/os/Build$VERSION.SDK_INT : I
    //   240: bipush #21
    //   242: if_icmplt -> 258
    //   245: iload #6
    //   247: istore_3
    //   248: iload #4
    //   250: istore_2
    //   251: aload_0
    //   252: invokevirtual getClipToPadding : ()Z
    //   255: ifeq -> 278
    //   258: iload #4
    //   260: aload_0
    //   261: invokevirtual getPaddingLeft : ()I
    //   264: aload_0
    //   265: invokevirtual getPaddingRight : ()I
    //   268: iadd
    //   269: isub
    //   270: istore_2
    //   271: iconst_0
    //   272: aload_0
    //   273: invokevirtual getPaddingLeft : ()I
    //   276: iadd
    //   277: istore_3
    //   278: iload #7
    //   280: istore #5
    //   282: iload #8
    //   284: istore #4
    //   286: getstatic android/os/Build$VERSION.SDK_INT : I
    //   289: bipush #21
    //   291: if_icmplt -> 332
    //   294: iload #7
    //   296: istore #5
    //   298: iload #8
    //   300: istore #4
    //   302: aload_0
    //   303: invokevirtual getClipToPadding : ()Z
    //   306: ifeq -> 332
    //   309: iload #8
    //   311: aload_0
    //   312: invokevirtual getPaddingTop : ()I
    //   315: aload_0
    //   316: invokevirtual getPaddingBottom : ()I
    //   319: iadd
    //   320: isub
    //   321: istore #4
    //   323: iload #7
    //   325: aload_0
    //   326: invokevirtual getPaddingBottom : ()I
    //   329: isub
    //   330: istore #5
    //   332: aload_1
    //   333: iload_3
    //   334: iload_2
    //   335: isub
    //   336: i2f
    //   337: iload #5
    //   339: i2f
    //   340: invokevirtual translate : (FF)V
    //   343: aload_1
    //   344: ldc_w 180.0
    //   347: iload_2
    //   348: i2f
    //   349: fconst_0
    //   350: invokevirtual rotate : (FFF)V
    //   353: aload_0
    //   354: getfield C : Landroid/widget/EdgeEffect;
    //   357: iload_2
    //   358: iload #4
    //   360: invokevirtual setSize : (II)V
    //   363: aload_0
    //   364: getfield C : Landroid/widget/EdgeEffect;
    //   367: aload_1
    //   368: invokevirtual draw : (Landroid/graphics/Canvas;)Z
    //   371: ifeq -> 378
    //   374: aload_0
    //   375: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   378: aload_1
    //   379: iload #9
    //   381: invokevirtual restoreToCount : (I)V
    //   384: return
  }
  
  public boolean e() {
    List<View> list = getEffectiveChildren();
    int i = list.size();
    boolean bool = true;
    if (i > 0) {
      View view = list.get(list.size() - 1);
      if (getScrollY() >= this.d && !ScrollUtils.a(view, 1))
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public void g() {
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.P;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(); 
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    return (this.K.size() > paramInt2) ? indexOfChild(this.K.get(paramInt2)) : super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public View getCurrentStickyView() {
    return this.G;
  }
  
  public List<View> getCurrentStickyViews() {
    return this.H;
  }
  
  public int getNestedScrollAxes() {
    return this.s.getNestedScrollAxes();
  }
  
  public OnPermanentStickyChangeListener getOnPermanentStickyChangeListener() {
    return this.N;
  }
  
  public OnStickyChangeListener getOnStickyChangeListener() {
    return this.M;
  }
  
  public OnScrollChangeListener getOnVerticalScrollChangeListener() {
    return this.a;
  }
  
  public int getOwnScrollY() {
    return this.c;
  }
  
  public int getScrollState() {
    return this.O;
  }
  
  public int getStickyOffset() {
    return this.F;
  }
  
  public boolean hasNestedScrollingParent(int paramInt) {
    return this.t.hasNestedScrollingParent(paramInt);
  }
  
  public boolean isNestedScrollingEnabled() {
    return this.t.isNestedScrollingEnabled();
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    LayoutParamsUtils.a((LayoutParams)paramView.getLayoutParams());
    super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 3)
            return super.onInterceptTouchEvent(paramMotionEvent); 
        } else {
          if (this.q != 2)
            if (!a(paramMotionEvent)) {
              int[] arrayOfInt = this.o;
              if (d(arrayOfInt[0], arrayOfInt[1]))
                return true; 
            } else {
              return true;
            }  
          return super.onInterceptTouchEvent(paramMotionEvent);
        }  
      stopNestedScroll(0);
    } else {
      m();
      this.f.addMovement(paramMotionEvent);
    } 
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.d = 0;
    paramInt1 = getPaddingTop();
    paramInt4 = getPaddingLeft();
    int i = getPaddingRight();
    int j = getMeasuredWidth();
    List<View> list = getNonGoneChildren();
    int k = list.size();
    paramInt2 = 0;
    while (paramInt2 < k) {
      View view = list.get(paramInt2);
      paramInt3 = view.getMeasuredHeight() + paramInt1;
      int m = a(view, j, paramInt4, i);
      view.layout(m, paramInt1, view.getMeasuredWidth() + m, paramInt3);
      this.d += view.getHeight();
      paramInt2++;
      paramInt1 = paramInt3;
    } 
    this.d -= getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    if (this.d < 0)
      this.d = 0; 
    a(paramBoolean, false);
    f();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    h();
    List<View> list = getNonGoneChildren();
    int m = list.size();
    int j = 0;
    int k = 0;
    int i = 0;
    while (j < m) {
      View view = list.get(j);
      measureChildWithMargins(view, paramInt1, 0, paramInt2, 0);
      k = Math.max(k, b(view));
      i += view.getMeasuredHeight();
      j++;
    } 
    setMeasuredDimension(a(paramInt1, k + getPaddingLeft() + getPaddingRight()), a(paramInt2, i + getPaddingTop() + getPaddingBottom()));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (!paramBoolean) {
      dispatchNestedFling(0.0F, paramFloat2, true);
      a((int)paramFloat2);
      return true;
    } 
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfint, 0);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint, (int[])null, paramInt3);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    e(paramInt4, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    e(paramInt4, paramInt5);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    this.s.onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
    b(false, false);
    startNestedScroll(2, paramInt2);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    return onStartNestedScroll(paramView1, paramView2, paramInt, 0);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    ViewGroup.LayoutParams layoutParams = paramView1.getLayoutParams();
    boolean bool = layoutParams instanceof LayoutParams;
    boolean bool2 = false;
    if (bool) {
      bool = ((LayoutParams)layoutParams).b;
    } else {
      bool = false;
    } 
    boolean bool1 = bool2;
    if (bool) {
      bool1 = bool2;
      if ((paramInt1 & 0x2) != 0)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public void onStopNestedScroll(View paramView) {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(View paramView, int paramInt) {
    this.s.onStopNestedScroll(paramView, paramInt);
    stopNestedScroll(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic i : (Landroid/view/View;)Z
    //   4: istore #9
    //   6: iconst_0
    //   7: istore #4
    //   9: iload #9
    //   11: ifeq -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_1
    //   17: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
    //   20: astore #10
    //   22: aload_1
    //   23: invokevirtual getActionMasked : ()I
    //   26: ifne -> 34
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield L : I
    //   34: aload #10
    //   36: fconst_0
    //   37: aload_0
    //   38: getfield L : I
    //   41: i2f
    //   42: invokevirtual offsetLocation : (FF)V
    //   45: aload_1
    //   46: aload_0
    //   47: getfield r : I
    //   50: invokevirtual findPointerIndex : (I)I
    //   53: istore #5
    //   55: iload #5
    //   57: iflt -> 661
    //   60: iload #5
    //   62: aload_1
    //   63: invokevirtual getPointerCount : ()I
    //   66: if_icmplt -> 71
    //   69: iconst_0
    //   70: ireturn
    //   71: aload_1
    //   72: invokevirtual getActionMasked : ()I
    //   75: istore_2
    //   76: iload_2
    //   77: ifeq -> 621
    //   80: iload_2
    //   81: iconst_1
    //   82: if_icmpeq -> 546
    //   85: iload_2
    //   86: iconst_2
    //   87: if_icmpeq -> 109
    //   90: iload_2
    //   91: iconst_3
    //   92: if_icmpeq -> 546
    //   95: iload_2
    //   96: iconst_5
    //   97: if_icmpeq -> 628
    //   100: iload_2
    //   101: bipush #6
    //   103: if_icmpeq -> 628
    //   106: goto -> 639
    //   109: aload_0
    //   110: getfield k : I
    //   113: ifne -> 129
    //   116: aload_0
    //   117: aload_1
    //   118: iload #5
    //   120: invokevirtual getY : (I)F
    //   123: f2i
    //   124: putfield k : I
    //   127: iconst_1
    //   128: ireturn
    //   129: aload_0
    //   130: getfield v : [I
    //   133: iconst_1
    //   134: iconst_0
    //   135: iastore
    //   136: aload_1
    //   137: iload #5
    //   139: invokevirtual getY : (I)F
    //   142: f2i
    //   143: istore #6
    //   145: aload_0
    //   146: getfield k : I
    //   149: iload #6
    //   151: isub
    //   152: istore_3
    //   153: iload_3
    //   154: istore_2
    //   155: aload_0
    //   156: iconst_0
    //   157: iload_3
    //   158: aload_0
    //   159: getfield v : [I
    //   162: aload_0
    //   163: getfield u : [I
    //   166: iconst_0
    //   167: invokevirtual dispatchNestedPreScroll : (II[I[II)Z
    //   170: ifeq -> 209
    //   173: iload_3
    //   174: aload_0
    //   175: getfield v : [I
    //   178: iconst_1
    //   179: iaload
    //   180: isub
    //   181: istore_2
    //   182: aload_1
    //   183: fconst_0
    //   184: aload_0
    //   185: getfield u : [I
    //   188: iconst_1
    //   189: iaload
    //   190: i2f
    //   191: invokevirtual offsetLocation : (FF)V
    //   194: aload_0
    //   195: aload_0
    //   196: getfield L : I
    //   199: aload_0
    //   200: getfield u : [I
    //   203: iconst_1
    //   204: iaload
    //   205: iadd
    //   206: putfield L : I
    //   209: aload_0
    //   210: iload #6
    //   212: aload_0
    //   213: getfield u : [I
    //   216: iconst_1
    //   217: iaload
    //   218: isub
    //   219: putfield k : I
    //   222: aload_0
    //   223: getfield c : I
    //   226: istore #6
    //   228: aload_0
    //   229: getfield O : I
    //   232: iconst_1
    //   233: if_icmpeq -> 266
    //   236: aload_0
    //   237: invokespecial i : ()Z
    //   240: ifeq -> 255
    //   243: iload_2
    //   244: invokestatic abs : (I)I
    //   247: ifle -> 255
    //   250: iconst_1
    //   251: istore_3
    //   252: goto -> 257
    //   255: iconst_0
    //   256: istore_3
    //   257: iload_3
    //   258: ifeq -> 266
    //   261: aload_0
    //   262: iconst_1
    //   263: invokevirtual setScrollState : (I)V
    //   266: aload_0
    //   267: getfield O : I
    //   270: iconst_1
    //   271: if_icmpne -> 279
    //   274: aload_0
    //   275: iload_2
    //   276: invokespecial b : (I)V
    //   279: aload_0
    //   280: getfield c : I
    //   283: iload #6
    //   285: isub
    //   286: istore #7
    //   288: iload_2
    //   289: iload #7
    //   291: isub
    //   292: istore_3
    //   293: iload_3
    //   294: istore_2
    //   295: aload_0
    //   296: iconst_0
    //   297: iload #7
    //   299: iconst_0
    //   300: iload_3
    //   301: aload_0
    //   302: getfield u : [I
    //   305: iconst_0
    //   306: invokevirtual dispatchNestedScroll : (IIII[II)Z
    //   309: ifeq -> 361
    //   312: aload_0
    //   313: getfield u : [I
    //   316: astore #11
    //   318: iload_3
    //   319: aload #11
    //   321: iconst_1
    //   322: iaload
    //   323: iadd
    //   324: istore_2
    //   325: aload_0
    //   326: aload_0
    //   327: getfield k : I
    //   330: aload #11
    //   332: iconst_1
    //   333: iaload
    //   334: isub
    //   335: putfield k : I
    //   338: aload_0
    //   339: aload_0
    //   340: getfield L : I
    //   343: aload #11
    //   345: iconst_1
    //   346: iaload
    //   347: iadd
    //   348: putfield L : I
    //   351: aload_1
    //   352: fconst_0
    //   353: aload #11
    //   355: iconst_1
    //   356: iaload
    //   357: i2f
    //   358: invokevirtual offsetLocation : (FF)V
    //   361: aload_0
    //   362: invokespecial getScrollRange : ()I
    //   365: istore #7
    //   367: aload_0
    //   368: invokevirtual getOverScrollMode : ()I
    //   371: istore #8
    //   373: iload #8
    //   375: ifeq -> 395
    //   378: iload #4
    //   380: istore_3
    //   381: iload #8
    //   383: iconst_1
    //   384: if_icmpne -> 397
    //   387: iload #4
    //   389: istore_3
    //   390: iload #7
    //   392: ifle -> 397
    //   395: iconst_1
    //   396: istore_3
    //   397: iload_3
    //   398: ifeq -> 639
    //   401: aload_0
    //   402: invokespecial k : ()V
    //   405: iload #6
    //   407: iload_2
    //   408: iadd
    //   409: istore_3
    //   410: iload_3
    //   411: ifge -> 461
    //   414: aload_0
    //   415: getfield B : Landroid/widget/EdgeEffect;
    //   418: iload_2
    //   419: i2f
    //   420: aload_0
    //   421: invokevirtual getHeight : ()I
    //   424: i2f
    //   425: fdiv
    //   426: aload_1
    //   427: iload #5
    //   429: invokevirtual getX : (I)F
    //   432: aload_0
    //   433: invokevirtual getWidth : ()I
    //   436: i2f
    //   437: fdiv
    //   438: invokestatic onPull : (Landroid/widget/EdgeEffect;FF)V
    //   441: aload_0
    //   442: getfield C : Landroid/widget/EdgeEffect;
    //   445: invokevirtual isFinished : ()Z
    //   448: ifne -> 513
    //   451: aload_0
    //   452: getfield C : Landroid/widget/EdgeEffect;
    //   455: invokevirtual onRelease : ()V
    //   458: goto -> 513
    //   461: iload_3
    //   462: iload #7
    //   464: if_icmple -> 513
    //   467: aload_0
    //   468: getfield C : Landroid/widget/EdgeEffect;
    //   471: iload_2
    //   472: i2f
    //   473: aload_0
    //   474: invokevirtual getHeight : ()I
    //   477: i2f
    //   478: fdiv
    //   479: fconst_1
    //   480: aload_1
    //   481: iload #5
    //   483: invokevirtual getX : (I)F
    //   486: aload_0
    //   487: invokevirtual getWidth : ()I
    //   490: i2f
    //   491: fdiv
    //   492: fsub
    //   493: invokestatic onPull : (Landroid/widget/EdgeEffect;FF)V
    //   496: aload_0
    //   497: getfield B : Landroid/widget/EdgeEffect;
    //   500: invokevirtual isFinished : ()Z
    //   503: ifne -> 513
    //   506: aload_0
    //   507: getfield B : Landroid/widget/EdgeEffect;
    //   510: invokevirtual onRelease : ()V
    //   513: aload_0
    //   514: getfield B : Landroid/widget/EdgeEffect;
    //   517: astore_1
    //   518: aload_1
    //   519: ifnull -> 639
    //   522: aload_1
    //   523: invokevirtual isFinished : ()Z
    //   526: ifeq -> 539
    //   529: aload_0
    //   530: getfield C : Landroid/widget/EdgeEffect;
    //   533: invokevirtual isFinished : ()Z
    //   536: ifne -> 639
    //   539: aload_0
    //   540: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   543: goto -> 639
    //   546: aload_0
    //   547: invokespecial j : ()V
    //   550: aload_0
    //   551: iconst_0
    //   552: putfield k : I
    //   555: aload_0
    //   556: getfield f : Landroid/view/VelocityTracker;
    //   559: astore_1
    //   560: aload_1
    //   561: ifnull -> 639
    //   564: aload_1
    //   565: aload #10
    //   567: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   570: aload_0
    //   571: getfield f : Landroid/view/VelocityTracker;
    //   574: sipush #1000
    //   577: aload_0
    //   578: getfield h : I
    //   581: i2f
    //   582: invokevirtual computeCurrentVelocity : (IF)V
    //   585: aload_0
    //   586: getfield f : Landroid/view/VelocityTracker;
    //   589: invokevirtual getYVelocity : ()F
    //   592: f2i
    //   593: istore_2
    //   594: aload_0
    //   595: getfield h : I
    //   598: istore_3
    //   599: aload_0
    //   600: iload_3
    //   601: ineg
    //   602: iload_2
    //   603: iload_3
    //   604: invokestatic min : (II)I
    //   607: invokestatic max : (II)I
    //   610: ineg
    //   611: invokespecial a : (I)V
    //   614: aload_0
    //   615: invokespecial n : ()V
    //   618: goto -> 639
    //   621: aload_0
    //   622: iconst_2
    //   623: iconst_0
    //   624: invokevirtual startNestedScroll : (II)Z
    //   627: pop
    //   628: aload_0
    //   629: aload_1
    //   630: iload #5
    //   632: invokevirtual getY : (I)F
    //   635: f2i
    //   636: putfield k : I
    //   639: aload_0
    //   640: getfield f : Landroid/view/VelocityTracker;
    //   643: astore_1
    //   644: aload_1
    //   645: ifnull -> 654
    //   648: aload_1
    //   649: aload #10
    //   651: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   654: aload #10
    //   656: invokevirtual recycle : ()V
    //   659: iconst_1
    //   660: ireturn
    //   661: iconst_0
    //   662: ireturn
  }
  
  public void scrollBy(int paramInt1, int paramInt2) {
    scrollTo(0, this.c + paramInt2);
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {
    b(paramInt2 - this.c);
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.P;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    this.t.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnPermanentStickyChangeListener(OnPermanentStickyChangeListener paramOnPermanentStickyChangeListener) {
    this.N = paramOnPermanentStickyChangeListener;
  }
  
  @Deprecated
  public void setOnScrollChangeListener(View.OnScrollChangeListener paramOnScrollChangeListener) {}
  
  public void setOnStickyChangeListener(OnStickyChangeListener paramOnStickyChangeListener) {
    this.M = paramOnStickyChangeListener;
  }
  
  public void setOnVerticalScrollChangeListener(OnScrollChangeListener paramOnScrollChangeListener) {
    this.a = paramOnScrollChangeListener;
  }
  
  public void setPermanent(boolean paramBoolean) {
    if (this.E != paramBoolean) {
      this.E = paramBoolean;
      t();
    } 
  }
  
  void setScrollState(int paramInt) {
    if (paramInt == this.O)
      return; 
    this.O = paramInt;
    paramInt = this.c;
    b(paramInt, paramInt);
  }
  
  public void setStickyOffset(int paramInt) {
    if (this.F != paramInt) {
      this.F = paramInt;
      t();
    } 
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2) {
    return this.t.startNestedScroll(paramInt1, paramInt2);
  }
  
  public void stopNestedScroll() {
    stopNestedScroll(0);
  }
  
  public void stopNestedScroll(int paramInt) {
    this.t.stopNestedScroll();
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public boolean a = true;
    
    public boolean b = true;
    
    public boolean c = false;
    
    public Align d = Align.a;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray1 = null;
      TypedArray typedArray2 = null;
      try {
        TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.ConsecutiveScrollerLayout_Layout);
        typedArray2 = typedArray;
        typedArray1 = typedArray;
        this.a = typedArray.getBoolean(1, true);
        typedArray2 = typedArray;
        typedArray1 = typedArray;
        this.c = typedArray.getBoolean(3, false);
        typedArray2 = typedArray;
        typedArray1 = typedArray;
        this.b = typedArray.getBoolean(2, true);
        typedArray2 = typedArray;
        typedArray1 = typedArray;
        this.d = Align.a(typedArray.getInt(0, 1));
        if (typedArray != null)
          typedArray.recycle(); 
      } catch (Exception exception) {
        TypedArray typedArray;
        typedArray2 = typedArray1;
        exception.printStackTrace();
        if (typedArray1 != null) {
          typedArray = typedArray1;
        } else {
          return;
        } 
        typedArray.recycle();
      } finally {}
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public enum Align {
      a(1),
      b(2),
      c(3);
      
      int d;
      
      Align(int param2Int1) {
        this.d = param2Int1;
      }
      
      static Align a(int param2Int) {
        return (param2Int != 1) ? ((param2Int != 2) ? ((param2Int != 3) ? a : c) : b) : a;
      }
    }
  }
  
  public enum Align {
    a(1),
    b(2),
    c(3);
    
    int d;
    
    Align(int param1Int1) {
      this.d = param1Int1;
    }
    
    static Align a(int param1Int) {
      return (param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? a : c) : b) : a;
    }
  }
  
  public static interface OnPermanentStickyChangeListener {
    void a(List<View> param1List);
  }
  
  public static interface OnScrollChangeListener {
    void a(View param1View, int param1Int1, int param1Int2, int param1Int3);
  }
  
  public static interface OnStickyChangeListener {
    void a(View param1View1, View param1View2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\consecutivescroller\ConsecutiveScrollerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */