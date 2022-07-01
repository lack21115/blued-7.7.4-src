package com.blued.android.framework.view.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class StickyGridHeadersGridView extends GridView implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener {
  static final String a;
  
  private static final String i;
  
  private AdapterView.OnItemClickListener A;
  
  private AdapterView.OnItemLongClickListener B;
  
  private AdapterView.OnItemSelectedListener C;
  
  private PerformHeaderClick D;
  
  private AbsListView.OnScrollListener E;
  
  private int F = 0;
  
  private View G;
  
  private Runnable H;
  
  private int I;
  
  private int J;
  
  public CheckForHeaderLongPress b;
  
  public CheckForHeaderTap c;
  
  protected StickyGridHeadersBaseAdapterWrapper d;
  
  protected boolean e;
  
  protected int f;
  
  protected int g;
  
  boolean h = false;
  
  private boolean j = true;
  
  private final Rect k = new Rect();
  
  private boolean l;
  
  private boolean m;
  
  private int n;
  
  private long o = -1L;
  
  private DataSetObserver p = new DataSetObserver(this) {
      public void onChanged() {
        StickyGridHeadersGridView.a(this.a);
      }
      
      public void onInvalidated() {
        StickyGridHeadersGridView.a(this.a);
      }
    };
  
  private int q;
  
  private boolean r;
  
  private int s;
  
  private boolean t = true;
  
  private float u;
  
  private int v;
  
  private boolean w;
  
  private int x = 1;
  
  private OnHeaderClickListener y;
  
  private OnHeaderLongClickListener z;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Error supporting platform ");
    stringBuilder.append(Build.VERSION.SDK_INT);
    stringBuilder.append(".");
    i = stringBuilder.toString();
    a = StickyGridHeadersGridView.class.getSimpleName();
  }
  
  public StickyGridHeadersGridView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public StickyGridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public StickyGridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.w)
      this.v = -1; 
    this.I = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private int a(float paramFloat) {
    if (this.G != null && paramFloat <= this.q)
      return -2; 
    int i = 0;
    int j = getFirstVisiblePosition();
    while (j <= getLastVisiblePosition()) {
      if (getItemIdAtPosition(j) == -1L) {
        View view = getChildAt(i);
        int m = view.getBottom();
        int n = view.getTop();
        if (paramFloat <= m && paramFloat >= n)
          return i; 
      } 
      int k = this.x;
      j += k;
      i += k;
    } 
    return -1;
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent, int paramInt) {
    if (paramInt == -2)
      return paramMotionEvent; 
    long l1 = paramMotionEvent.getDownTime();
    long l2 = paramMotionEvent.getEventTime();
    int n = paramMotionEvent.getAction();
    int i1 = paramMotionEvent.getPointerCount();
    int[] arrayOfInt = b(paramMotionEvent);
    MotionEvent.PointerCoords[] arrayOfPointerCoords = a(paramMotionEvent);
    int i2 = paramMotionEvent.getMetaState();
    float f1 = paramMotionEvent.getXPrecision();
    float f2 = paramMotionEvent.getYPrecision();
    int m = paramMotionEvent.getDeviceId();
    int i = paramMotionEvent.getEdgeFlags();
    int j = paramMotionEvent.getSource();
    int i3 = paramMotionEvent.getFlags();
    View view = getChildAt(paramInt);
    int k = 0;
    paramInt = m;
    while (k < i1) {
      MotionEvent.PointerCoords pointerCoords = arrayOfPointerCoords[k];
      pointerCoords.y -= view.getTop();
      k++;
    } 
    return MotionEvent.obtain(l1, l2, n, i1, arrayOfInt, arrayOfPointerCoords, i2, f1, f2, paramInt, i, j, i3);
  }
  
  private static MotionEvent.PointerCoords[] a(MotionEvent paramMotionEvent) {
    int j = paramMotionEvent.getPointerCount();
    MotionEvent.PointerCoords[] arrayOfPointerCoords = new MotionEvent.PointerCoords[j];
    for (int i = 0; i < j; i++) {
      arrayOfPointerCoords[i] = new MotionEvent.PointerCoords();
      paramMotionEvent.getPointerCoords(i, arrayOfPointerCoords[i]);
    } 
    return arrayOfPointerCoords;
  }
  
  private long b(int paramInt) {
    return (paramInt == -2) ? this.o : this.d.b(getFirstVisiblePosition() + paramInt);
  }
  
  private void b() {
    int i;
    int j;
    if (this.G == null)
      return; 
    if (this.r) {
      i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    } 
    ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
    if (layoutParams != null && layoutParams.height > 0) {
      j = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
    } else {
      j = View.MeasureSpec.makeMeasureSpec(0, 0);
    } 
    this.G.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.G.measure(i, j);
    if (this.r) {
      this.G.layout(getLeft(), 0, getRight(), this.G.getMeasuredHeight());
      return;
    } 
    this.G.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.G.getMeasuredHeight());
  }
  
  private static int[] b(MotionEvent paramMotionEvent) {
    int j = paramMotionEvent.getPointerCount();
    int[] arrayOfInt = new int[j];
    for (int i = 0; i < j; i++)
      arrayOfInt[i] = paramMotionEvent.getPointerId(i); 
    return arrayOfInt;
  }
  
  private void c() {
    this.q = 0;
    c((View)null);
    this.o = Long.MIN_VALUE;
  }
  
  private void c(int paramInt) {
    StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.d;
    if (stickyGridHeadersBaseAdapterWrapper != null && stickyGridHeadersBaseAdapterWrapper.getCount() != 0) {
      if (!this.j)
        return; 
      if (getChildAt(0) == null)
        return; 
      int k = paramInt - this.x;
      int j = k;
      if (k < 0)
        j = paramInt; 
      int m = this.x + paramInt;
      k = m;
      if (m >= this.d.getCount())
        k = paramInt; 
      m = this.J;
      if (m == 0) {
        long l = this.d.b(paramInt);
      } else {
        long l;
        if (m < 0) {
          this.d.b(paramInt);
          if (getChildAt(this.x).getTop() <= 0) {
            l = this.d.b(k);
          } else {
            l = this.d.b(paramInt);
            k = paramInt;
          } 
          j = k;
        } else {
          k = getChildAt(0).getTop();
          if (k > 0 && k < this.J) {
            l = this.d.b(j);
          } else {
            l = this.d.b(paramInt);
            j = paramInt;
          } 
        } 
        if (this.o != l) {
          c(this.d.a(j, this.G, (ViewGroup)this));
          b();
          this.o = l;
        } 
        int n = getChildCount();
        if (n != 0) {
          View view;
          stickyGridHeadersBaseAdapterWrapper = null;
          k = 0;
          for (m = 99999; k < n; m = i1) {
            int i1;
            View view1;
            View view2 = getChildAt(k);
            if (this.l) {
              j = view2.getTop() - getPaddingTop();
            } else {
              j = view2.getTop();
            } 
            if (j < 0) {
              StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper1 = stickyGridHeadersBaseAdapterWrapper;
              i1 = m;
            } else {
              StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper1 = stickyGridHeadersBaseAdapterWrapper;
              i1 = m;
              if (this.d.getItemId(getPositionForView(view2)) == -1L) {
                stickyGridHeadersBaseAdapterWrapper1 = stickyGridHeadersBaseAdapterWrapper;
                i1 = m;
                if (j < m) {
                  view1 = view2;
                  i1 = j;
                } 
              } 
            } 
            k += this.x;
            view = view1;
          } 
          j = getHeaderHeight();
          if (view != null) {
            if (paramInt == 0 && getChildAt(0).getTop() > 0 && !this.l) {
              this.q = 0;
              return;
            } 
            if (this.l) {
              this.q = Math.min(view.getTop(), getPaddingTop() + j);
              if (this.q < getPaddingTop()) {
                paramInt = j + getPaddingTop();
              } else {
                paramInt = this.q;
              } 
              this.q = paramInt;
              return;
            } 
            this.q = Math.min(view.getTop(), j);
            k = this.q;
            paramInt = k;
            if (k < 0)
              paramInt = j; 
            this.q = paramInt;
            return;
          } 
          this.q = j;
          if (this.l)
            this.q += getPaddingTop(); 
        } 
        return;
      } 
    } else {
      return;
    } 
    int i = paramInt;
  }
  
  private void c(View paramView) {
    b(this.G);
    a(paramView);
    this.G = paramView;
  }
  
  private int getHeaderHeight() {
    View view = this.G;
    return (view != null) ? view.getMeasuredHeight() : 0;
  }
  
  public View a(int paramInt) {
    if (paramInt == -2)
      return this.G; 
    try {
      return (View)getChildAt(paramInt).getTag();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  void a(View paramView) {
    if (paramView == null)
      return; 
    try {
      Field field = View.class.getDeclaredField("mAttachInfo");
      field.setAccessible(true);
      Method method = View.class.getDeclaredMethod("dispatchAttachedToWindow", new Class[] { Class.forName("android.view.View$AttachInfo"), int.class });
      method.setAccessible(true);
      method.invoke(paramView, new Object[] { field.get(this), Integer.valueOf(8) });
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimePlatformSupportException(this, noSuchMethodException);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new RuntimePlatformSupportException(this, classNotFoundException);
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new RuntimePlatformSupportException(this, illegalArgumentException);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimePlatformSupportException(this, illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimePlatformSupportException(this, invocationTargetException);
    } catch (NoSuchFieldException noSuchFieldException) {
      throw new RuntimePlatformSupportException(this, noSuchFieldException);
    } 
  }
  
  public boolean a(View paramView, long paramLong) {
    if (this.y != null) {
      playSoundEffect(0);
      if (paramView != null)
        paramView.sendAccessibilityEvent(1); 
      this.y.a((AdapterView<?>)this, paramView, paramLong);
      return true;
    } 
    return false;
  }
  
  void b(View paramView) {
    if (paramView == null)
      return; 
    try {
      Method method = View.class.getDeclaredMethod("dispatchDetachedFromWindow", new Class[0]);
      method.setAccessible(true);
      method.invoke(paramView, new Object[0]);
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimePlatformSupportException(this, noSuchMethodException);
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new RuntimePlatformSupportException(this, illegalArgumentException);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimePlatformSupportException(this, illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new RuntimePlatformSupportException(this, invocationTargetException);
    } 
  }
  
  public boolean b(View paramView, long paramLong) {
    boolean bool;
    OnHeaderLongClickListener onHeaderLongClickListener = this.z;
    if (onHeaderLongClickListener != null) {
      bool = onHeaderLongClickListener.a((AdapterView<?>)this, paramView, paramLong);
    } else {
      bool = false;
    } 
    if (bool) {
      if (paramView != null)
        paramView.sendAccessibilityEvent(2); 
      performHapticFeedback(0);
    } 
    return bool;
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    int i;
    if (Build.VERSION.SDK_INT < 8)
      c(getFirstVisiblePosition()); 
    View view = this.G;
    if (view != null && this.j && view.getVisibility() == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    int m = getHeaderHeight();
    int n = this.q - m;
    if (i && this.t) {
      if (this.r) {
        Rect rect1 = this.k;
        rect1.left = 0;
        rect1.right = getWidth();
      } else {
        this.k.left = getPaddingLeft();
        this.k.right = getWidth() - getPaddingRight();
      } 
      Rect rect = this.k;
      rect.top = this.q;
      rect.bottom = getHeight();
      paramCanvas.save();
      paramCanvas.clipRect(this.k);
    } 
    super.dispatchDraw(paramCanvas);
    ArrayList<Integer> arrayList = new ArrayList();
    int k = getFirstVisiblePosition();
    int j;
    for (j = 0; k <= getLastVisiblePosition(); j += i1) {
      if (getItemIdAtPosition(k) == -1L)
        arrayList.add(Integer.valueOf(j)); 
      int i1 = this.x;
      k += i1;
    } 
    j = 0;
    while (true) {
      if (j < arrayList.size()) {
        View view1 = getChildAt(((Integer)arrayList.get(j)).intValue());
        try {
          View view2 = (View)view1.getTag();
          if (((StickyGridHeadersBaseAdapterWrapper.HeaderFillerView)view1).getHeaderId() == this.o && view1.getTop() < 0 && this.j) {
            k = 1;
          } else {
            k = 0;
          } 
          if (view2.getVisibility() == 0 && k == 0) {
            if (this.r) {
              k = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
            } else {
              k = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
            } 
            int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
            view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view2.measure(k, i1);
            if (this.r) {
              view2.layout(getLeft(), 0, getRight(), view1.getHeight());
            } else {
              view2.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), view1.getHeight());
            } 
            if (this.r) {
              Rect rect1 = this.k;
              rect1.left = 0;
              rect1.right = getWidth();
            } else {
              this.k.left = getPaddingLeft();
              this.k.right = getWidth() - getPaddingRight();
            } 
            this.k.bottom = view1.getBottom();
            this.k.top = view1.getTop();
            paramCanvas.save();
            paramCanvas.clipRect(this.k);
            if (this.r) {
              paramCanvas.translate(0.0F, view1.getTop());
            } else {
              paramCanvas.translate(getPaddingLeft(), view1.getTop());
            } 
            view2.draw(paramCanvas);
            paramCanvas.restore();
          } 
          j++;
          continue;
        } catch (Exception exception) {
          break;
        } 
      } 
      if (i && this.t) {
        exception.restore();
      } else if (!i) {
        return;
      } 
      if (this.r) {
        i = getWidth();
      } else {
        i = getWidth() - getPaddingLeft() - getPaddingRight();
      } 
      if (this.G.getWidth() != i) {
        if (this.r) {
          i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
        } else {
          i = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
        } 
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.G.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.G.measure(i, j);
        if (this.r) {
          this.G.layout(getLeft(), 0, getRight(), this.G.getHeight());
        } else {
          this.G.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.G.getHeight());
        } 
      } 
      if (this.r) {
        Rect rect1 = this.k;
        rect1.left = 0;
        rect1.right = getWidth();
      } else {
        this.k.left = getPaddingLeft();
        this.k.right = getWidth() - getPaddingRight();
      } 
      Rect rect = this.k;
      rect.bottom = n + m;
      if (this.l) {
        rect.top = getPaddingTop();
      } else {
        rect.top = 0;
      } 
      exception.save();
      exception.clipRect(this.k);
      if (this.r) {
        exception.translate(0.0F, n);
      } else {
        exception.translate(getPaddingLeft(), n);
      } 
      if (this.q != m)
        exception.saveLayerAlpha(0.0F, 0.0F, exception.getWidth(), exception.getHeight(), this.q * 255 / m, 31); 
      this.G.draw((Canvas)exception);
      if (this.q != m)
        exception.restore(); 
      exception.restore();
      return;
    } 
  }
  
  public View getStickiedHeader() {
    return this.G;
  }
  
  public boolean getStickyHeaderIsTranscluent() {
    return this.t ^ true;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    this.A.onItemClick(paramAdapterView, paramView, (this.d.c(paramInt)).b, paramLong);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    return this.B.onItemLongClick(paramAdapterView, paramView, (this.d.c(paramInt)).b, paramLong);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    this.C.onItemSelected(paramAdapterView, paramView, (this.d.c(paramInt)).b, paramLong);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = this.v;
    if (i == -1) {
      byte b;
      if (this.n > 0) {
        int j = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        i = j / this.n;
        if (i > 0) {
          while (true) {
            b = i;
            if (i != 1) {
              b = i;
              if (this.n * i + (i - 1) * this.s > j) {
                i--;
                continue;
              } 
            } 
            break;
          } 
        } else {
          b = 1;
        } 
      } else {
        b = 2;
      } 
      this.x = b;
    } else {
      this.x = i;
    } 
    StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.d;
    if (stickyGridHeadersBaseAdapterWrapper != null)
      stickyGridHeadersBaseAdapterWrapper.a(this.x); 
    b();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {
    this.C.onNothingSelected(paramAdapterView);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.j = savedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.j;
    return (Parcelable)savedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    AbsListView.OnScrollListener onScrollListener = this.E;
    if (onScrollListener != null)
      onScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3); 
    if (Build.VERSION.SDK_INT >= 8)
      c(paramInt1); 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    AbsListView.OnScrollListener onScrollListener = this.E;
    if (onScrollListener != null)
      onScrollListener.onScrollStateChanged(paramAbsListView, paramInt); 
    this.F = paramInt;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    Runnable runnable;
    View view;
    int i = paramMotionEvent.getAction();
    boolean bool = this.h;
    if (bool) {
      View view1;
      View view2 = a(this.f);
      int j = this.f;
      if (j == -2) {
        view1 = view2;
      } else {
        view1 = getChildAt(j);
      } 
      if (i == 1 || i == 3)
        this.h = false; 
      if (view2 != null) {
        view2.dispatchTouchEvent(a(paramMotionEvent, this.f));
        view2.invalidate();
        view2.postDelayed(new Runnable(this, view1) {
              public void run() {
                this.b.invalidate(0, this.a.getTop(), this.b.getWidth(), this.a.getTop() + this.a.getHeight());
              }
            }ViewConfiguration.getPressedStateDuration());
        invalidate(0, view1.getTop(), getWidth(), view1.getTop() + view1.getHeight());
      } 
    } 
    i &= 0xFF;
    if (i != 0) {
      if (i != 1) {
        if (i == 2 && this.f != -1 && Math.abs(paramMotionEvent.getY() - this.u) > this.I) {
          this.g = -1;
          View view1 = a(this.f);
          if (view1 != null) {
            view1.setPressed(false);
            view1.invalidate();
          } 
          Handler handler = getHandler();
          if (handler != null)
            handler.removeCallbacks(this.b); 
          this.f = -1;
        } 
      } else {
        i = this.g;
        if (i == -2) {
          this.g = -1;
          return true;
        } 
        if (i != -1) {
          i = this.f;
          if (i == -1)
            return super.onTouchEvent(paramMotionEvent); 
          View view1 = a(i);
          if (!bool && view1 != null) {
            if (this.g != 0)
              view1.setPressed(false); 
            if (this.D == null)
              this.D = new PerformHeaderClick(); 
            PerformHeaderClick performHeaderClick = this.D;
            performHeaderClick.a = this.f;
            performHeaderClick.a();
            i = this.g;
            if (i == 0 || i == 1) {
              Handler handler = getHandler();
              if (handler != null) {
                if (this.g == 0) {
                  CheckForHeaderTap checkForHeaderTap = this.c;
                } else {
                  runnable = this.b;
                } 
                handler.removeCallbacks(runnable);
              } 
              if (!this.e) {
                this.g = 1;
                view1.setPressed(true);
                setPressed(true);
                runnable = this.H;
                if (runnable != null)
                  removeCallbacks(runnable); 
                this.H = new Runnable(this, view1, performHeaderClick) {
                    public void run() {
                      StickyGridHeadersGridView stickyGridHeadersGridView = this.c;
                      stickyGridHeadersGridView.f = -1;
                      StickyGridHeadersGridView.a(stickyGridHeadersGridView, (Runnable)null);
                      this.c.g = -1;
                      this.a.setPressed(false);
                      this.c.setPressed(false);
                      this.a.invalidate();
                      this.c.invalidate(0, this.a.getTop(), this.c.getWidth(), this.a.getHeight());
                      if (!this.c.e)
                        this.b.run(); 
                    }
                  };
                postDelayed(this.H, ViewConfiguration.getPressedStateDuration());
              } else {
                this.g = -1;
              } 
              this.g = -1;
              return true;
            } 
            if (!this.e)
              performHeaderClick.run(); 
          } 
          this.g = -1;
          return true;
        } 
      } 
    } else {
      if (this.c == null)
        this.c = new CheckForHeaderTap(this); 
      postDelayed(this.c, ViewConfiguration.getTapTimeout());
      float f = (int)runnable.getY();
      this.u = f;
      this.f = a(f);
      i = this.f;
      if (i != -1 && this.F != 2) {
        View view1 = a(i);
        if (view1 != null) {
          if (view1.dispatchTouchEvent(a((MotionEvent)runnable, this.f))) {
            this.h = true;
            view1.setPressed(true);
          } 
          view1.invalidate();
          i = this.f;
          view = view1;
          if (i != -2)
            view = getChildAt(i); 
          invalidate(0, view.getTop(), getWidth(), view.getTop() + view.getHeight());
        } 
        this.g = 0;
        return true;
      } 
    } 
    return super.onTouchEvent((MotionEvent)view);
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.d;
    if (stickyGridHeadersBaseAdapterWrapper != null) {
      DataSetObserver dataSetObserver = this.p;
      if (dataSetObserver != null)
        stickyGridHeadersBaseAdapterWrapper.unregisterDataSetObserver(dataSetObserver); 
    } 
    if (!this.m)
      this.l = true; 
    if (paramListAdapter instanceof StickyGridHeadersBaseAdapter) {
      paramListAdapter = paramListAdapter;
    } else if (paramListAdapter instanceof StickyGridHeadersSimpleAdapter) {
      paramListAdapter = new StickyGridHeadersSimpleAdapterWrapper((StickyGridHeadersSimpleAdapter)paramListAdapter);
    } else {
      paramListAdapter = new StickyGridHeadersListAdapterWrapper(paramListAdapter);
    } 
    this.d = new StickyGridHeadersBaseAdapterWrapper(getContext(), this, (StickyGridHeadersBaseAdapter)paramListAdapter);
    this.d.registerDataSetObserver(this.p);
    c();
    super.setAdapter((ListAdapter)this.d);
  }
  
  public void setAreHeadersSticky(boolean paramBoolean) {
    if (paramBoolean != this.j) {
      this.j = paramBoolean;
      requestLayout();
    } 
  }
  
  public void setClipToPadding(boolean paramBoolean) {
    super.setClipToPadding(paramBoolean);
    this.l = paramBoolean;
    this.m = true;
  }
  
  public void setColumnWidth(int paramInt) {
    super.setColumnWidth(paramInt);
    this.n = paramInt;
  }
  
  public void setHeadersIgnorePadding(boolean paramBoolean) {
    this.r = paramBoolean;
  }
  
  public void setHorizontalSpacing(int paramInt) {
    super.setHorizontalSpacing(paramInt);
    this.s = paramInt;
  }
  
  public void setNumColumns(int paramInt) {
    super.setNumColumns(paramInt);
    this.w = true;
    this.v = paramInt;
    if (paramInt != -1) {
      StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.d;
      if (stickyGridHeadersBaseAdapterWrapper != null)
        stickyGridHeadersBaseAdapterWrapper.a(paramInt); 
    } 
  }
  
  public void setOnHeaderClickListener(OnHeaderClickListener paramOnHeaderClickListener) {
    this.y = paramOnHeaderClickListener;
  }
  
  public void setOnHeaderLongClickListener(OnHeaderLongClickListener paramOnHeaderLongClickListener) {
    if (!isLongClickable())
      setLongClickable(true); 
    this.z = paramOnHeaderLongClickListener;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.A = paramOnItemClickListener;
    super.setOnItemClickListener(this);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener) {
    this.B = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
    this.C = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
    this.E = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean) {
    this.t = paramBoolean ^ true;
  }
  
  public void setVerticalSpacing(int paramInt) {
    super.setVerticalSpacing(paramInt);
    this.J = paramInt;
  }
  
  class CheckForHeaderLongPress extends WindowRunnable implements Runnable {
    private CheckForHeaderLongPress(StickyGridHeadersGridView this$0) {}
    
    public void run() {
      StickyGridHeadersGridView stickyGridHeadersGridView = this.a;
      View view = stickyGridHeadersGridView.a(stickyGridHeadersGridView.f);
      if (view != null) {
        boolean bool;
        StickyGridHeadersGridView stickyGridHeadersGridView1 = this.a;
        long l = StickyGridHeadersGridView.a(stickyGridHeadersGridView1, stickyGridHeadersGridView1.f);
        if (b() && !this.a.e) {
          bool = this.a.b(view, l);
        } else {
          bool = false;
        } 
        if (bool) {
          stickyGridHeadersGridView1 = this.a;
          stickyGridHeadersGridView1.g = -2;
          stickyGridHeadersGridView1.setPressed(false);
          view.setPressed(false);
          return;
        } 
        this.a.g = 2;
      } 
    }
  }
  
  final class CheckForHeaderTap implements Runnable {
    CheckForHeaderTap(StickyGridHeadersGridView this$0) {}
    
    public void run() {
      if (this.a.g == 0) {
        StickyGridHeadersGridView stickyGridHeadersGridView = this.a;
        stickyGridHeadersGridView.g = 1;
        View view = stickyGridHeadersGridView.a(stickyGridHeadersGridView.f);
        if (view != null && !this.a.h) {
          if (!this.a.e) {
            view.setPressed(true);
            this.a.setPressed(true);
            this.a.refreshDrawableState();
            int i = ViewConfiguration.getLongPressTimeout();
            if (this.a.isLongClickable()) {
              if (this.a.b == null) {
                StickyGridHeadersGridView stickyGridHeadersGridView2 = this.a;
                stickyGridHeadersGridView2.b = new StickyGridHeadersGridView.CheckForHeaderLongPress();
              } 
              this.a.b.a();
              StickyGridHeadersGridView stickyGridHeadersGridView1 = this.a;
              stickyGridHeadersGridView1.postDelayed(stickyGridHeadersGridView1.b, i);
              return;
            } 
            this.a.g = 2;
            return;
          } 
          this.a.g = 2;
        } 
      } 
    }
  }
  
  public static interface OnHeaderClickListener {
    void a(AdapterView<?> param1AdapterView, View param1View, long param1Long);
  }
  
  public static interface OnHeaderLongClickListener {
    boolean a(AdapterView<?> param1AdapterView, View param1View, long param1Long);
  }
  
  class PerformHeaderClick extends WindowRunnable implements Runnable {
    int a;
    
    private PerformHeaderClick(StickyGridHeadersGridView this$0) {}
    
    public void run() {
      if (this.b.e)
        return; 
      if (this.b.d != null && this.b.d.getCount() > 0) {
        int i = this.a;
        if (i != -1 && i < this.b.d.getCount() && b()) {
          View view = this.b.a(this.a);
          if (view != null) {
            StickyGridHeadersGridView stickyGridHeadersGridView = this.b;
            stickyGridHeadersGridView.a(view, StickyGridHeadersGridView.a(stickyGridHeadersGridView, this.a));
          } 
        } 
      } 
    }
  }
  
  class RuntimePlatformSupportException extends RuntimeException {
    public RuntimePlatformSupportException(StickyGridHeadersGridView this$0, Exception param1Exception) {
      super(StickyGridHeadersGridView.a(), param1Exception);
    }
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public StickyGridHeadersGridView.SavedState a(Parcel param2Parcel) {
          return new StickyGridHeadersGridView.SavedState(param2Parcel);
        }
        
        public StickyGridHeadersGridView.SavedState[] a(int param2Int) {
          return new StickyGridHeadersGridView.SavedState[param2Int];
        }
      };
    
    boolean a;
    
    private SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      boolean bool;
      if (param1Parcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.a = bool;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("StickyGridHeadersGridView.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" areHeadersSticky=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeByte((byte)this.a);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public StickyGridHeadersGridView.SavedState a(Parcel param1Parcel) {
      return new StickyGridHeadersGridView.SavedState(param1Parcel);
    }
    
    public StickyGridHeadersGridView.SavedState[] a(int param1Int) {
      return new StickyGridHeadersGridView.SavedState[param1Int];
    }
  }
  
  class WindowRunnable {
    private int a;
    
    private WindowRunnable(StickyGridHeadersGridView this$0) {}
    
    public void a() {
      this.a = StickyGridHeadersGridView.b(this.c);
    }
    
    public boolean b() {
      return (this.c.hasWindowFocus() && StickyGridHeadersGridView.c(this.c) == this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickygridheaders\StickyGridHeadersGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */