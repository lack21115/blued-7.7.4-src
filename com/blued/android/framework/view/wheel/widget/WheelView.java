package com.blued.android.framework.view.wheel.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WheelView extends View {
  private static final int[] c = new int[] { -15658735, 11184810, 11184810 };
  
  boolean a = false;
  
  WheelScroller.ScrollingListener b = new WheelScroller.ScrollingListener(this) {
      public void a() {
        WheelView.a(this.a, true);
        this.a.a();
      }
      
      public void a(int param1Int) {
        WheelView.a(this.a, param1Int);
        int i = this.a.getHeight();
        if (WheelView.a(this.a) > i) {
          WheelView.b(this.a, i);
          WheelView.b(this.a).a();
          return;
        } 
        param1Int = WheelView.a(this.a);
        i = -i;
        if (param1Int < i) {
          WheelView.b(this.a, i);
          WheelView.b(this.a).a();
        } 
      }
      
      public void b() {
        if (WheelView.c(this.a)) {
          this.a.b();
          WheelView.a(this.a, false);
        } 
        WheelView.b(this.a, 0);
        this.a.invalidate();
      }
      
      public void c() {
        if (Math.abs(WheelView.a(this.a)) > 1)
          WheelView.b(this.a).a(WheelView.a(this.a), 0); 
      }
    };
  
  private int d = 0;
  
  private int e = 5;
  
  private int f = 0;
  
  private Drawable g;
  
  private GradientDrawable h;
  
  private GradientDrawable i;
  
  private WheelScroller j;
  
  private boolean k;
  
  private int l;
  
  private LinearLayout m;
  
  private int n;
  
  private WheelViewAdapter o;
  
  private WheelRecycle p = new WheelRecycle(this);
  
  private List<OnWheelChangedListener> q = new LinkedList<OnWheelChangedListener>();
  
  private List<OnWheelScrollListener> r = new LinkedList<OnWheelScrollListener>();
  
  private List<OnWheelClickedListener> s = new LinkedList<OnWheelClickedListener>();
  
  private DataSetObserver t = new DataSetObserver(this) {
      public void onChanged() {
        this.a.a(false);
      }
      
      public void onInvalidated() {
        this.a.a(true);
      }
    };
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(LinearLayout paramLinearLayout) {
    if (paramLinearLayout != null && paramLinearLayout.getChildAt(0) != null)
      this.f = paramLinearLayout.getChildAt(0).getMeasuredHeight(); 
    int i = this.f;
    return Math.max(this.e * i - i * 10 / 50, getSuggestedMinimumHeight());
  }
  
  private void a(Context paramContext) {
    this.j = new WheelScroller(getContext(), this.b);
  }
  
  private void a(Canvas paramCanvas) {
    paramCanvas.save();
    paramCanvas.translate(10.0F, (-((this.d - this.n) * getItemHeight() + (getItemHeight() - getHeight()) / 2) + this.l));
    this.m.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private void b(int paramInt) {
    int i;
    this.l += paramInt;
    int n = getItemHeight();
    int j = this.l / n;
    int k = this.d - j;
    int i1 = this.o.a();
    paramInt = this.l % n;
    int m = paramInt;
    if (Math.abs(paramInt) <= n / 2)
      m = 0; 
    if (this.a && i1 > 0) {
      if (m > 0) {
        i = k - 1;
        paramInt = j + 1;
      } else {
        paramInt = j;
        i = k;
        if (m < 0) {
          i = k + 1;
          paramInt = j - 1;
        } 
      } 
      while (i < 0)
        i += i1; 
      i %= i1;
    } else if (k < 0) {
      paramInt = this.d;
      i = 0;
    } else if (k >= i1) {
      paramInt = this.d - i1 + 1;
      i = i1 - 1;
    } else if (k > 0 && m > 0) {
      i = k - 1;
      paramInt = j + 1;
    } else {
      paramInt = j;
      i = k;
      if (k < i1 - 1) {
        paramInt = j;
        i = k;
        if (m < 0) {
          i = k + 1;
          paramInt = j - 1;
        } 
      } 
    } 
    j = this.l;
    if (i != this.d) {
      a(i, false);
    } else {
      invalidate();
    } 
    this.l = j - paramInt * n;
    if (this.l > getHeight())
      this.l = this.l % getHeight() + getHeight(); 
  }
  
  private void b(Canvas paramCanvas) {
    int i = getHeight() / 2;
    int j = (int)((getItemHeight() / 2) * 1.2D);
    this.g.setBounds(0, i - j, getWidth(), i + j);
    this.g.draw(paramCanvas);
  }
  
  private boolean b(int paramInt, boolean paramBoolean) {
    View view = d(paramInt);
    if (view != null) {
      if (paramBoolean) {
        this.m.addView(view, 0);
      } else {
        this.m.addView(view);
      } 
      return true;
    } 
    return false;
  }
  
  private int c(int paramInt1, int paramInt2) {
    d();
    this.m.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.m.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i = this.m.getMeasuredWidth();
    if (paramInt2 != 1073741824) {
      i = Math.max(i + 20, getSuggestedMinimumWidth());
      if (paramInt2 != Integer.MIN_VALUE || paramInt1 >= i)
        paramInt1 = i; 
    } 
    this.m.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramInt1;
  }
  
  private boolean c(int paramInt) {
    WheelViewAdapter wheelViewAdapter = this.o;
    return (wheelViewAdapter != null && wheelViewAdapter.a() > 0 && (this.a || (paramInt >= 0 && paramInt < this.o.a())));
  }
  
  private View d(int paramInt) {
    WheelViewAdapter wheelViewAdapter = this.o;
    if (wheelViewAdapter == null || wheelViewAdapter.a() == 0)
      return null; 
    int j = this.o.a();
    int i = paramInt;
    if (!c(paramInt))
      return this.o.a(this.p.b(), (ViewGroup)this.m); 
    while (i < 0)
      i += j; 
    return this.o.a(i % j, this.p.a(), (ViewGroup)this.m);
  }
  
  private void d() {
    if (this.g == null)
      this.g = getContext().getResources().getDrawable(R.drawable.horizontal_line); 
    if (this.h == null)
      this.h = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, c); 
    if (this.i == null)
      this.i = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, c); 
  }
  
  private void d(int paramInt1, int paramInt2) {
    this.m.layout(0, 0, paramInt1 - 20, paramInt2);
  }
  
  private boolean e() {
    boolean bool1;
    ItemsRange itemsRange = getItemsRange();
    LinearLayout linearLayout = this.m;
    if (linearLayout != null) {
      int k = this.p.a(linearLayout, this.n, itemsRange);
      if (this.n != k) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.n = k;
    } else {
      g();
      bool1 = true;
    } 
    boolean bool2 = bool1;
    if (!bool1)
      if (this.n != itemsRange.a() || this.m.getChildCount() != itemsRange.c()) {
        bool2 = true;
      } else {
        bool2 = false;
      }  
    if (this.n > itemsRange.a() && this.n <= itemsRange.b()) {
      for (int k = this.n - 1; k >= itemsRange.a() && b(k, true); k--)
        this.n = k; 
    } else {
      this.n = itemsRange.a();
    } 
    int j = this.n;
    int i = this.m.getChildCount();
    while (i < itemsRange.c()) {
      int k = j;
      if (!b(this.n + i, false)) {
        k = j;
        if (this.m.getChildCount() == 0)
          k = j + 1; 
      } 
      i++;
      j = k;
    } 
    this.n = j;
    return bool2;
  }
  
  private void f() {
    if (e()) {
      c(getWidth(), 1073741824);
      d(getWidth(), getHeight());
    } 
  }
  
  private void g() {
    if (this.m == null) {
      this.m = new LinearLayout(getContext());
      this.m.setOrientation(1);
    } 
  }
  
  private int getItemHeight() {
    int i = this.f;
    if (i != 0)
      return i; 
    LinearLayout linearLayout = this.m;
    if (linearLayout != null && linearLayout.getChildAt(0) != null) {
      this.f = this.m.getChildAt(0).getHeight();
      return this.f;
    } 
    return getHeight() / this.e;
  }
  
  private ItemsRange getItemsRange() {
    if (getItemHeight() == 0)
      return null; 
    int i = this.d;
    int j;
    for (j = 1; getItemHeight() * j < getHeight(); j += 2)
      i--; 
    int n = this.l;
    int m = i;
    int k = j;
    if (n != 0) {
      k = i;
      if (n > 0)
        k = i - 1; 
      i = this.l / getItemHeight();
      m = k - i;
      k = (int)((j + 1) + Math.asin(i));
    } 
    return new ItemsRange(m, k);
  }
  
  private void h() {
    LinearLayout linearLayout = this.m;
    if (linearLayout != null) {
      this.p.a(linearLayout, this.n, new ItemsRange());
    } else {
      g();
    } 
    int j = this.e / 2;
    for (int i = this.d + j; i >= this.d - j; i--) {
      if (b(i, true))
        this.n = i; 
    } 
  }
  
  protected void a() {
    Iterator<OnWheelScrollListener> iterator = this.r.iterator();
    while (iterator.hasNext())
      ((OnWheelScrollListener)iterator.next()).a(this); 
  }
  
  protected void a(int paramInt) {
    Iterator<OnWheelClickedListener> iterator = this.s.iterator();
    while (iterator.hasNext())
      ((OnWheelClickedListener)iterator.next()).a(this, paramInt); 
  }
  
  protected void a(int paramInt1, int paramInt2) {
    Iterator<OnWheelChangedListener> iterator = this.q.iterator();
    while (iterator.hasNext())
      ((OnWheelChangedListener)iterator.next()).a(this, paramInt1, paramInt2); 
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield o : Lcom/blued/android/framework/view/wheel/widget/adapters/WheelViewAdapter;
    //   4: astore #7
    //   6: aload #7
    //   8: ifnull -> 176
    //   11: aload #7
    //   13: invokeinterface a : ()I
    //   18: ifne -> 22
    //   21: return
    //   22: aload_0
    //   23: getfield o : Lcom/blued/android/framework/view/wheel/widget/adapters/WheelViewAdapter;
    //   26: invokeinterface a : ()I
    //   31: istore #5
    //   33: iload_1
    //   34: iflt -> 45
    //   37: iload_1
    //   38: istore_3
    //   39: iload_1
    //   40: iload #5
    //   42: if_icmplt -> 69
    //   45: aload_0
    //   46: getfield a : Z
    //   49: ifeq -> 176
    //   52: iload_1
    //   53: ifge -> 64
    //   56: iload_1
    //   57: iload #5
    //   59: iadd
    //   60: istore_1
    //   61: goto -> 52
    //   64: iload_1
    //   65: iload #5
    //   67: irem
    //   68: istore_3
    //   69: aload_0
    //   70: getfield d : I
    //   73: istore #6
    //   75: iload_3
    //   76: iload #6
    //   78: if_icmpeq -> 176
    //   81: iload_2
    //   82: ifeq -> 152
    //   85: iload_3
    //   86: iload #6
    //   88: isub
    //   89: istore #4
    //   91: iload #4
    //   93: istore_1
    //   94: aload_0
    //   95: getfield a : Z
    //   98: ifeq -> 145
    //   101: iload #5
    //   103: iload_3
    //   104: iload #6
    //   106: invokestatic min : (II)I
    //   109: iadd
    //   110: iload_3
    //   111: aload_0
    //   112: getfield d : I
    //   115: invokestatic max : (II)I
    //   118: isub
    //   119: istore_3
    //   120: iload #4
    //   122: istore_1
    //   123: iload_3
    //   124: iload #4
    //   126: invokestatic abs : (I)I
    //   129: if_icmpge -> 145
    //   132: iload #4
    //   134: ifge -> 142
    //   137: iload_3
    //   138: istore_1
    //   139: goto -> 145
    //   142: iload_3
    //   143: ineg
    //   144: istore_1
    //   145: aload_0
    //   146: iload_1
    //   147: iconst_0
    //   148: invokevirtual b : (II)V
    //   151: return
    //   152: aload_0
    //   153: iconst_0
    //   154: putfield l : I
    //   157: aload_0
    //   158: iload_3
    //   159: putfield d : I
    //   162: aload_0
    //   163: iload #6
    //   165: aload_0
    //   166: getfield d : I
    //   169: invokevirtual a : (II)V
    //   172: aload_0
    //   173: invokevirtual invalidate : ()V
    //   176: return
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.p.c();
      LinearLayout linearLayout = this.m;
      if (linearLayout != null)
        linearLayout.removeAllViews(); 
      this.l = 0;
    } else {
      LinearLayout linearLayout = this.m;
      if (linearLayout != null)
        this.p.a(linearLayout, this.n, new ItemsRange()); 
    } 
    invalidate();
  }
  
  protected void b() {
    Iterator<OnWheelScrollListener> iterator = this.r.iterator();
    while (iterator.hasNext())
      ((OnWheelScrollListener)iterator.next()).b(this); 
  }
  
  public void b(int paramInt1, int paramInt2) {
    int i = getItemHeight();
    int j = this.l;
    this.j.a(paramInt1 * i - j, paramInt2);
  }
  
  public boolean c() {
    return this.a;
  }
  
  public int getCurrentItem() {
    return this.d;
  }
  
  public WheelViewAdapter getViewAdapter() {
    return this.o;
  }
  
  public int getVisibleItems() {
    return this.e;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    WheelViewAdapter wheelViewAdapter = this.o;
    if (wheelViewAdapter != null && wheelViewAdapter.a() > 0) {
      f();
      a(paramCanvas);
      b(paramCanvas);
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    d(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    h();
    j = c(k, j);
    if (i != 1073741824) {
      paramInt2 = a(this.m);
      if (i == Integer.MIN_VALUE) {
        paramInt1 = Math.min(paramInt2, paramInt1);
      } else {
        paramInt1 = paramInt2;
      } 
    } 
    setMeasuredDimension(j, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (isEnabled()) {
      if (getViewAdapter() == null)
        return true; 
      int i = paramMotionEvent.getAction();
      if (i != 1) {
        if (i == 2 && getParent() != null)
          getParent().requestDisallowInterceptTouchEvent(true); 
      } else if (!this.k) {
        i = (int)paramMotionEvent.getY() - getHeight() / 2;
        if (i > 0) {
          i += getItemHeight() / 2;
        } else {
          i -= getItemHeight() / 2;
        } 
        i /= getItemHeight();
        if (i != 0 && c(this.d + i))
          a(this.d + i); 
      } 
      return this.j.a(paramMotionEvent);
    } 
    return true;
  }
  
  public void setCurrentItem(int paramInt) {
    a(paramInt, false);
  }
  
  public void setCyclic(boolean paramBoolean) {
    this.a = paramBoolean;
    a(false);
  }
  
  public void setInterpolator(Interpolator paramInterpolator) {
    this.j.a(paramInterpolator);
  }
  
  public void setViewAdapter(WheelViewAdapter paramWheelViewAdapter) {
    WheelViewAdapter wheelViewAdapter = this.o;
    if (wheelViewAdapter != null)
      wheelViewAdapter.b(this.t); 
    this.o = paramWheelViewAdapter;
    paramWheelViewAdapter = this.o;
    if (paramWheelViewAdapter != null)
      paramWheelViewAdapter.a(this.t); 
    a(true);
  }
  
  public void setVisibleItems(int paramInt) {
    this.e = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\wheel\widget\WheelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */