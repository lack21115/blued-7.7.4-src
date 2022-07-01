package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

public class ViewDragHelper {
  public static final int DIRECTION_ALL = 3;
  
  public static final int DIRECTION_HORIZONTAL = 1;
  
  public static final int DIRECTION_VERTICAL = 2;
  
  public static final int EDGE_ALL = 15;
  
  public static final int EDGE_BOTTOM = 8;
  
  public static final int EDGE_LEFT = 1;
  
  public static final int EDGE_RIGHT = 2;
  
  public static final int EDGE_TOP = 4;
  
  public static final int INVALID_POINTER = -1;
  
  public static final int STATE_DRAGGING = 1;
  
  public static final int STATE_IDLE = 0;
  
  public static final int STATE_SETTLING = 2;
  
  private static final Interpolator v = new Interpolator() {
      public float getInterpolation(float param1Float) {
        param1Float--;
        return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
      }
    };
  
  private int a;
  
  private int b;
  
  private int c = -1;
  
  private float[] d;
  
  private float[] e;
  
  private float[] f;
  
  private float[] g;
  
  private int[] h;
  
  private int[] i;
  
  private int[] j;
  
  private int k;
  
  private VelocityTracker l;
  
  private float m;
  
  private float n;
  
  private int o;
  
  private int p;
  
  private OverScroller q;
  
  private final Callback r;
  
  private View s;
  
  private boolean t;
  
  private final ViewGroup u;
  
  private final Runnable w = new Runnable(this) {
      public void run() {
        this.a.a(0);
      }
    };
  
  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, Callback paramCallback) {
    if (paramViewGroup != null) {
      if (paramCallback != null) {
        this.u = paramViewGroup;
        this.r = paramCallback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
        this.o = (int)((paramContext.getResources().getDisplayMetrics()).density * 20.0F + 0.5F);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(paramContext, v);
        return;
      } 
      throw new IllegalArgumentException("Callback may not be null");
    } 
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  private float a(float paramFloat) {
    return (float)Math.sin(((paramFloat - 0.5F) * 0.47123894F));
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    float f = Math.abs(paramFloat1);
    return (f < paramFloat2) ? 0.0F : ((f > paramFloat3) ? ((paramFloat1 > 0.0F) ? paramFloat3 : -paramFloat3) : paramFloat1);
  }
  
  private int a(int paramInt1, int paramInt2) {
    if (paramInt1 < this.u.getLeft() + this.o) {
      j = 1;
    } else {
      j = 0;
    } 
    int i = j;
    if (paramInt2 < this.u.getTop() + this.o)
      i = j | 0x4; 
    int j = i;
    if (paramInt1 > this.u.getRight() - this.o)
      j = i | 0x2; 
    paramInt1 = j;
    if (paramInt2 > this.u.getBottom() - this.o)
      paramInt1 = j | 0x8; 
    return paramInt1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 == 0)
      return 0; 
    int i = this.u.getWidth();
    int j = i / 2;
    float f2 = Math.min(1.0F, Math.abs(paramInt1) / i);
    float f1 = j;
    f2 = a(f2);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {
      paramInt1 = Math.round(Math.abs((f1 + f2 * f1) / paramInt2) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F);
    } 
    return Math.min(paramInt1, 600);
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f1;
    float f2;
    paramInt3 = b(paramInt3, (int)this.n, (int)this.m);
    paramInt4 = b(paramInt4, (int)this.n, (int)this.m);
    int i = Math.abs(paramInt1);
    int j = Math.abs(paramInt2);
    int k = Math.abs(paramInt3);
    int m = Math.abs(paramInt4);
    int n = k + m;
    int i1 = i + j;
    if (paramInt3 != 0) {
      f1 = k;
      f2 = n;
    } else {
      f1 = i;
      f2 = i1;
    } 
    float f3 = f1 / f2;
    if (paramInt4 != 0) {
      f1 = m;
      f2 = n;
    } else {
      f1 = j;
      f2 = i1;
    } 
    f1 /= f2;
    paramInt1 = a(paramInt1, paramInt3, this.r.getViewHorizontalDragRange(paramView));
    paramInt2 = a(paramInt2, paramInt4, this.r.getViewVerticalDragRange(paramView));
    return (int)(paramInt1 * f3 + paramInt2 * f1);
  }
  
  private void a() {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat == null)
      return; 
    Arrays.fill(arrayOfFloat, 0.0F);
    Arrays.fill(this.e, 0.0F);
    Arrays.fill(this.f, 0.0F);
    Arrays.fill(this.g, 0.0F);
    Arrays.fill(this.h, 0);
    Arrays.fill(this.i, 0);
    Arrays.fill(this.j, 0);
    this.k = 0;
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    this.t = true;
    this.r.onViewReleased(this.s, paramFloat1, paramFloat2);
    this.t = false;
    if (this.a == 1)
      a(0); 
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt) {
    c(paramInt);
    float[] arrayOfFloat = this.d;
    this.f[paramInt] = paramFloat1;
    arrayOfFloat[paramInt] = paramFloat1;
    arrayOfFloat = this.e;
    this.g[paramInt] = paramFloat2;
    arrayOfFloat[paramInt] = paramFloat2;
    this.h[paramInt] = a((int)paramFloat1, (int)paramFloat2);
    this.k |= 1 << paramInt;
  }
  
  private void a(MotionEvent paramMotionEvent) {
    int j = paramMotionEvent.getPointerCount();
    int i;
    for (i = 0; i < j; i++) {
      int k = paramMotionEvent.getPointerId(i);
      if (d(k)) {
        float f1 = paramMotionEvent.getX(i);
        float f2 = paramMotionEvent.getY(i);
        this.f[k] = f1;
        this.g[k] = f2;
      } 
    } 
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    int i = this.h[paramInt1];
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((i & paramInt2) == paramInt2) {
      bool1 = bool2;
      if ((this.p & paramInt2) != 0) {
        bool1 = bool2;
        if ((this.j[paramInt1] & paramInt2) != paramInt2) {
          bool1 = bool2;
          if ((this.i[paramInt1] & paramInt2) != paramInt2) {
            i = this.b;
            if (paramFloat1 <= i && paramFloat2 <= i)
              return false; 
            if (paramFloat1 < paramFloat2 * 0.5F && this.r.onEdgeLock(paramInt2)) {
              int[] arrayOfInt = this.j;
              arrayOfInt[paramInt1] = arrayOfInt[paramInt1] | paramInt2;
              return false;
            } 
            bool1 = bool2;
            if ((this.i[paramInt1] & paramInt2) == 0) {
              bool1 = bool2;
              if (paramFloat1 > this.b)
                bool1 = true; 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = this.s.getLeft();
    int j = this.s.getTop();
    paramInt1 -= i;
    paramInt2 -= j;
    if (paramInt1 == 0 && paramInt2 == 0) {
      this.q.abortAnimation();
      a(0);
      return false;
    } 
    paramInt3 = a(this.s, paramInt1, paramInt2, paramInt3, paramInt4);
    this.q.startScroll(i, j, paramInt1, paramInt2, paramInt3);
    a(2);
    return true;
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2) {
    int i;
    boolean bool1;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramView == null)
      return false; 
    if (this.r.getViewHorizontalDragRange(paramView) > 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (this.r.getViewVerticalDragRange(paramView) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (i && bool1) {
      i = this.b;
      if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 > (i * i))
        bool2 = true; 
      return bool2;
    } 
    if (i != 0) {
      bool2 = bool4;
      if (Math.abs(paramFloat1) > this.b)
        bool2 = true; 
      return bool2;
    } 
    bool2 = bool3;
    if (bool1) {
      bool2 = bool3;
      if (Math.abs(paramFloat2) > this.b)
        bool2 = true; 
    } 
    return bool2;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3) {
    int i = Math.abs(paramInt1);
    return (i < paramInt2) ? 0 : ((i > paramInt3) ? ((paramInt1 > 0) ? paramInt3 : -paramInt3) : paramInt1);
  }
  
  private void b() {
    this.l.computeCurrentVelocity(1000, this.m);
    a(a(this.l.getXVelocity(this.c), this.n, this.m), a(this.l.getYVelocity(this.c), this.n, this.m));
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt) {
    int j = 1;
    if (!a(paramFloat1, paramFloat2, paramInt, 1))
      j = 0; 
    int i = j;
    if (a(paramFloat2, paramFloat1, paramInt, 4))
      i = j | 0x4; 
    j = i;
    if (a(paramFloat1, paramFloat2, paramInt, 2))
      j = i | 0x2; 
    i = j;
    if (a(paramFloat2, paramFloat1, paramInt, 8))
      i = j | 0x8; 
    if (i != 0) {
      int[] arrayOfInt = this.i;
      arrayOfInt[paramInt] = arrayOfInt[paramInt] | i;
      this.r.onEdgeDragStarted(i, paramInt);
    } 
  }
  
  private void b(int paramInt) {
    if (this.d != null) {
      if (!isPointerDown(paramInt))
        return; 
      this.d[paramInt] = 0.0F;
      this.e[paramInt] = 0.0F;
      this.f[paramInt] = 0.0F;
      this.g[paramInt] = 0.0F;
      this.h[paramInt] = 0;
      this.i[paramInt] = 0;
      this.j[paramInt] = 0;
      this.k = 1 << paramInt & this.k;
    } 
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int j = this.s.getLeft();
    int k = this.s.getTop();
    int i = paramInt1;
    if (paramInt3 != 0) {
      i = this.r.clampViewPositionHorizontal(this.s, paramInt1, paramInt3);
      ViewCompat.offsetLeftAndRight(this.s, i - j);
    } 
    paramInt1 = paramInt2;
    if (paramInt4 != 0) {
      paramInt1 = this.r.clampViewPositionVertical(this.s, paramInt2, paramInt4);
      ViewCompat.offsetTopAndBottom(this.s, paramInt1 - k);
    } 
    if (paramInt3 != 0 || paramInt4 != 0)
      this.r.onViewPositionChanged(this.s, i, paramInt1, i - j, paramInt1 - k); 
  }
  
  private void c(int paramInt) {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat == null || arrayOfFloat.length <= paramInt) {
      arrayOfFloat = new float[++paramInt];
      float[] arrayOfFloat1 = new float[paramInt];
      float[] arrayOfFloat2 = new float[paramInt];
      float[] arrayOfFloat3 = new float[paramInt];
      int[] arrayOfInt1 = new int[paramInt];
      int[] arrayOfInt2 = new int[paramInt];
      int[] arrayOfInt3 = new int[paramInt];
      float[] arrayOfFloat4 = this.d;
      if (arrayOfFloat4 != null) {
        System.arraycopy(arrayOfFloat4, 0, arrayOfFloat, 0, arrayOfFloat4.length);
        arrayOfFloat4 = this.e;
        System.arraycopy(arrayOfFloat4, 0, arrayOfFloat1, 0, arrayOfFloat4.length);
        arrayOfFloat4 = this.f;
        System.arraycopy(arrayOfFloat4, 0, arrayOfFloat2, 0, arrayOfFloat4.length);
        arrayOfFloat4 = this.g;
        System.arraycopy(arrayOfFloat4, 0, arrayOfFloat3, 0, arrayOfFloat4.length);
        int[] arrayOfInt = this.h;
        System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, arrayOfInt.length);
        arrayOfInt = this.i;
        System.arraycopy(arrayOfInt, 0, arrayOfInt2, 0, arrayOfInt.length);
        arrayOfInt = this.j;
        System.arraycopy(arrayOfInt, 0, arrayOfInt3, 0, arrayOfInt.length);
      } 
      this.d = arrayOfFloat;
      this.e = arrayOfFloat1;
      this.f = arrayOfFloat2;
      this.g = arrayOfFloat3;
      this.h = arrayOfInt1;
      this.i = arrayOfInt2;
      this.j = arrayOfInt3;
    } 
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, Callback paramCallback) {
    ViewDragHelper viewDragHelper = create(paramViewGroup, paramCallback);
    viewDragHelper.b = (int)(viewDragHelper.b * 1.0F / paramFloat);
    return viewDragHelper;
  }
  
  public static ViewDragHelper create(ViewGroup paramViewGroup, Callback paramCallback) {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }
  
  private boolean d(int paramInt) {
    if (!isPointerDown(paramInt)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Ignoring pointerId=");
      stringBuilder.append(paramInt);
      stringBuilder.append(" because ACTION_DOWN was not received ");
      stringBuilder.append("for this pointer before ACTION_MOVE. It likely happened because ");
      stringBuilder.append(" ViewDragHelper did not receive all the events in the event stream.");
      Log.e("ViewDragHelper", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  void a(int paramInt) {
    this.u.removeCallbacks(this.w);
    if (this.a != paramInt) {
      this.a = paramInt;
      this.r.onViewDragStateChanged(paramInt);
      if (this.a == 0)
        this.s = null; 
    } 
  }
  
  boolean a(View paramView, int paramInt) {
    if (paramView == this.s && this.c == paramInt)
      return true; 
    if (paramView != null && this.r.tryCaptureView(paramView, paramInt)) {
      this.c = paramInt;
      captureChildView(paramView, paramInt);
      return true;
    } 
    return false;
  }
  
  public void abort() {
    cancel();
    if (this.a == 2) {
      int i = this.q.getCurrX();
      int j = this.q.getCurrY();
      this.q.abortAnimation();
      int k = this.q.getCurrX();
      int m = this.q.getCurrY();
      this.r.onViewPositionChanged(this.s, k, m, k - i, m - j);
    } 
    a(0);
  }
  
  public void cancel() {
    this.c = -1;
    a();
    VelocityTracker velocityTracker = this.l;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.l = null;
    } 
  }
  
  public void captureChildView(View paramView, int paramInt) {
    if (paramView.getParent() == this.u) {
      this.s = paramView;
      this.c = paramInt;
      this.r.onViewCaptured(paramView, paramInt);
      a(1);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
    stringBuilder.append(this.u);
    stringBuilder.append(")");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean checkTouchSlop(int paramInt) {
    int j = this.d.length;
    for (int i = 0; i < j; i++) {
      if (checkTouchSlop(paramInt, i))
        return true; 
    } 
    return false;
  }
  
  public boolean checkTouchSlop(int paramInt1, int paramInt2) {
    boolean bool1;
    boolean bool = isPointerDown(paramInt2);
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    if (!bool)
      return false; 
    if ((paramInt1 & 0x1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((paramInt1 & 0x2) == 2) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    float f1 = this.f[paramInt2] - this.d[paramInt2];
    float f2 = this.g[paramInt2] - this.e[paramInt2];
    if (bool1 && paramInt1 != 0) {
      paramInt1 = this.b;
      if (f1 * f1 + f2 * f2 > (paramInt1 * paramInt1))
        bool2 = true; 
      return bool2;
    } 
    if (bool1) {
      bool2 = bool4;
      if (Math.abs(f1) > this.b)
        bool2 = true; 
      return bool2;
    } 
    bool2 = bool3;
    if (paramInt1 != 0) {
      bool2 = bool3;
      if (Math.abs(f2) > this.b)
        bool2 = true; 
    } 
    return bool2;
  }
  
  public boolean continueSettling(boolean paramBoolean) {
    int i = this.a;
    boolean bool = false;
    if (i == 2) {
      boolean bool2 = this.q.computeScrollOffset();
      i = this.q.getCurrX();
      int j = this.q.getCurrY();
      int k = i - this.s.getLeft();
      int m = j - this.s.getTop();
      if (k != 0)
        ViewCompat.offsetLeftAndRight(this.s, k); 
      if (m != 0)
        ViewCompat.offsetTopAndBottom(this.s, m); 
      if (k != 0 || m != 0)
        this.r.onViewPositionChanged(this.s, i, j, k, m); 
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
        if (i == this.q.getFinalX()) {
          bool1 = bool2;
          if (j == this.q.getFinalY()) {
            this.q.abortAnimation();
            bool1 = false;
          } 
        } 
      } 
      if (!bool1)
        if (paramBoolean) {
          this.u.post(this.w);
        } else {
          a(0);
        }  
    } 
    paramBoolean = bool;
    if (this.a == 2)
      paramBoolean = true; 
    return paramBoolean;
  }
  
  public View findTopChildUnder(int paramInt1, int paramInt2) {
    for (int i = this.u.getChildCount() - 1; i >= 0; i--) {
      View view = this.u.getChildAt(this.r.getOrderedChildIndex(i));
      if (paramInt1 >= view.getLeft() && paramInt1 < view.getRight() && paramInt2 >= view.getTop() && paramInt2 < view.getBottom())
        return view; 
    } 
    return null;
  }
  
  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.t) {
      this.q.fling(this.s.getLeft(), this.s.getTop(), (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c), paramInt1, paramInt3, paramInt2, paramInt4);
      a(2);
      return;
    } 
    throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
  }
  
  public int getActivePointerId() {
    return this.c;
  }
  
  public View getCapturedView() {
    return this.s;
  }
  
  public int getEdgeSize() {
    return this.o;
  }
  
  public float getMinVelocity() {
    return this.n;
  }
  
  public int getTouchSlop() {
    return this.b;
  }
  
  public int getViewDragState() {
    return this.a;
  }
  
  public boolean isCapturedViewUnder(int paramInt1, int paramInt2) {
    return isViewUnder(this.s, paramInt1, paramInt2);
  }
  
  public boolean isEdgeTouched(int paramInt) {
    int j = this.h.length;
    for (int i = 0; i < j; i++) {
      if (isEdgeTouched(paramInt, i))
        return true; 
    } 
    return false;
  }
  
  public boolean isEdgeTouched(int paramInt1, int paramInt2) {
    return (isPointerDown(paramInt2) && (paramInt1 & this.h[paramInt2]) != 0);
  }
  
  public boolean isPointerDown(int paramInt) {
    return ((1 << paramInt & this.k) != 0);
  }
  
  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2) {
    boolean bool2 = false;
    if (paramView == null)
      return false; 
    boolean bool1 = bool2;
    if (paramInt1 >= paramView.getLeft()) {
      bool1 = bool2;
      if (paramInt1 < paramView.getRight()) {
        bool1 = bool2;
        if (paramInt2 >= paramView.getTop()) {
          bool1 = bool2;
          if (paramInt2 < paramView.getBottom())
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  public void processTouchEvent(MotionEvent paramMotionEvent) {
    int m = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.getActionIndex();
    if (m == 0)
      cancel(); 
    if (this.l == null)
      this.l = VelocityTracker.obtain(); 
    this.l.addMovement(paramMotionEvent);
    int j = 0;
    int i = 0;
    if (m != 0) {
      if (m != 1) {
        if (m != 2) {
          if (m != 3) {
            if (m != 5) {
              if (m != 6)
                return; 
              j = paramMotionEvent.getPointerId(k);
              if (this.a == 1 && j == this.c) {
                k = paramMotionEvent.getPointerCount();
                while (true) {
                  if (i < k) {
                    m = paramMotionEvent.getPointerId(i);
                    if (m != this.c) {
                      float f3 = paramMotionEvent.getX(i);
                      float f4 = paramMotionEvent.getY(i);
                      View view1 = findTopChildUnder((int)f3, (int)f4);
                      View view2 = this.s;
                      if (view1 == view2 && a(view2, m)) {
                        i = this.c;
                        break;
                      } 
                    } 
                    i++;
                    continue;
                  } 
                  i = -1;
                  break;
                } 
                if (i == -1)
                  b(); 
              } 
              b(j);
              return;
            } 
            i = paramMotionEvent.getPointerId(k);
            float f1 = paramMotionEvent.getX(k);
            float f2 = paramMotionEvent.getY(k);
            a(f1, f2, i);
            if (this.a == 0) {
              a(findTopChildUnder((int)f1, (int)f2), i);
              j = this.h[i];
              k = this.p;
              if ((j & k) != 0) {
                this.r.onEdgeTouched(j & k, i);
                return;
              } 
            } else if (isCapturedViewUnder((int)f1, (int)f2)) {
              a(this.s, i);
              return;
            } 
          } else {
            if (this.a == 1)
              a(0.0F, 0.0F); 
            cancel();
            return;
          } 
        } else {
          if (this.a == 1) {
            if (!d(this.c))
              return; 
            i = paramMotionEvent.findPointerIndex(this.c);
            float f1 = paramMotionEvent.getX(i);
            float f2 = paramMotionEvent.getY(i);
            float[] arrayOfFloat = this.f;
            j = this.c;
            i = (int)(f1 - arrayOfFloat[j]);
            j = (int)(f2 - this.g[j]);
            b(this.s.getLeft() + i, this.s.getTop() + j, i, j);
            a(paramMotionEvent);
            return;
          } 
          k = paramMotionEvent.getPointerCount();
          for (i = j; i < k; i++) {
            j = paramMotionEvent.getPointerId(i);
            if (d(j)) {
              float f1 = paramMotionEvent.getX(i);
              float f2 = paramMotionEvent.getY(i);
              float f3 = f1 - this.d[j];
              float f4 = f2 - this.e[j];
              b(f3, f4, j);
              if (this.a == 1)
                break; 
              View view = findTopChildUnder((int)f1, (int)f2);
              if (a(view, f3, f4) && a(view, j))
                break; 
            } 
          } 
          a(paramMotionEvent);
          return;
        } 
      } else {
        if (this.a == 1)
          b(); 
        cancel();
        return;
      } 
    } else {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      View view = findTopChildUnder((int)f1, (int)f2);
      a(f1, f2, i);
      a(view, i);
      j = this.h[i];
      k = this.p;
      if ((j & k) != 0)
        this.r.onEdgeTouched(j & k, i); 
    } 
  }
  
  public void setEdgeTrackingEnabled(int paramInt) {
    this.p = paramInt;
  }
  
  public void setMinVelocity(float paramFloat) {
    this.n = paramFloat;
  }
  
  public boolean settleCapturedViewAt(int paramInt1, int paramInt2) {
    if (this.t)
      return a(paramInt1, paramInt2, (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c)); 
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore #6
    //   6: aload_1
    //   7: invokevirtual getActionIndex : ()I
    //   10: istore #7
    //   12: iload #6
    //   14: ifne -> 21
    //   17: aload_0
    //   18: invokevirtual cancel : ()V
    //   21: aload_0
    //   22: getfield l : Landroid/view/VelocityTracker;
    //   25: ifnonnull -> 35
    //   28: aload_0
    //   29: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   32: putfield l : Landroid/view/VelocityTracker;
    //   35: aload_0
    //   36: getfield l : Landroid/view/VelocityTracker;
    //   39: aload_1
    //   40: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   43: iload #6
    //   45: ifeq -> 524
    //   48: iload #6
    //   50: iconst_1
    //   51: if_icmpeq -> 517
    //   54: iload #6
    //   56: iconst_2
    //   57: if_icmpeq -> 210
    //   60: iload #6
    //   62: iconst_3
    //   63: if_icmpeq -> 517
    //   66: iload #6
    //   68: iconst_5
    //   69: if_icmpeq -> 95
    //   72: iload #6
    //   74: bipush #6
    //   76: if_icmpeq -> 82
    //   79: goto -> 619
    //   82: aload_0
    //   83: aload_1
    //   84: iload #7
    //   86: invokevirtual getPointerId : (I)I
    //   89: invokespecial b : (I)V
    //   92: goto -> 79
    //   95: aload_1
    //   96: iload #7
    //   98: invokevirtual getPointerId : (I)I
    //   101: istore #6
    //   103: aload_1
    //   104: iload #7
    //   106: invokevirtual getX : (I)F
    //   109: fstore_2
    //   110: aload_1
    //   111: iload #7
    //   113: invokevirtual getY : (I)F
    //   116: fstore_3
    //   117: aload_0
    //   118: fload_2
    //   119: fload_3
    //   120: iload #6
    //   122: invokespecial a : (FFI)V
    //   125: aload_0
    //   126: getfield a : I
    //   129: istore #7
    //   131: iload #7
    //   133: ifne -> 176
    //   136: aload_0
    //   137: getfield h : [I
    //   140: iload #6
    //   142: iaload
    //   143: istore #7
    //   145: aload_0
    //   146: getfield p : I
    //   149: istore #8
    //   151: iload #7
    //   153: iload #8
    //   155: iand
    //   156: ifeq -> 79
    //   159: aload_0
    //   160: getfield r : Landroidx/customview/widget/ViewDragHelper$Callback;
    //   163: iload #7
    //   165: iload #8
    //   167: iand
    //   168: iload #6
    //   170: invokevirtual onEdgeTouched : (II)V
    //   173: goto -> 79
    //   176: iload #7
    //   178: iconst_2
    //   179: if_icmpne -> 79
    //   182: aload_0
    //   183: fload_2
    //   184: f2i
    //   185: fload_3
    //   186: f2i
    //   187: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   190: astore_1
    //   191: aload_1
    //   192: aload_0
    //   193: getfield s : Landroid/view/View;
    //   196: if_acmpne -> 79
    //   199: aload_0
    //   200: aload_1
    //   201: iload #6
    //   203: invokevirtual a : (Landroid/view/View;I)Z
    //   206: pop
    //   207: goto -> 79
    //   210: aload_0
    //   211: getfield d : [F
    //   214: ifnull -> 79
    //   217: aload_0
    //   218: getfield e : [F
    //   221: ifnonnull -> 227
    //   224: goto -> 79
    //   227: aload_1
    //   228: invokevirtual getPointerCount : ()I
    //   231: istore #8
    //   233: iconst_0
    //   234: istore #6
    //   236: iload #6
    //   238: iload #8
    //   240: if_icmpge -> 509
    //   243: aload_1
    //   244: iload #6
    //   246: invokevirtual getPointerId : (I)I
    //   249: istore #9
    //   251: aload_0
    //   252: iload #9
    //   254: invokespecial d : (I)Z
    //   257: ifne -> 263
    //   260: goto -> 500
    //   263: aload_1
    //   264: iload #6
    //   266: invokevirtual getX : (I)F
    //   269: fstore_2
    //   270: aload_1
    //   271: iload #6
    //   273: invokevirtual getY : (I)F
    //   276: fstore_3
    //   277: fload_2
    //   278: aload_0
    //   279: getfield d : [F
    //   282: iload #9
    //   284: faload
    //   285: fsub
    //   286: fstore #4
    //   288: fload_3
    //   289: aload_0
    //   290: getfield e : [F
    //   293: iload #9
    //   295: faload
    //   296: fsub
    //   297: fstore #5
    //   299: aload_0
    //   300: fload_2
    //   301: f2i
    //   302: fload_3
    //   303: f2i
    //   304: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   307: astore #17
    //   309: aload #17
    //   311: ifnull -> 333
    //   314: aload_0
    //   315: aload #17
    //   317: fload #4
    //   319: fload #5
    //   321: invokespecial a : (Landroid/view/View;FF)Z
    //   324: ifeq -> 333
    //   327: iconst_1
    //   328: istore #7
    //   330: goto -> 336
    //   333: iconst_0
    //   334: istore #7
    //   336: iload #7
    //   338: ifeq -> 460
    //   341: aload #17
    //   343: invokevirtual getLeft : ()I
    //   346: istore #10
    //   348: fload #4
    //   350: f2i
    //   351: istore #11
    //   353: aload_0
    //   354: getfield r : Landroidx/customview/widget/ViewDragHelper$Callback;
    //   357: aload #17
    //   359: iload #10
    //   361: iload #11
    //   363: iadd
    //   364: iload #11
    //   366: invokevirtual clampViewPositionHorizontal : (Landroid/view/View;II)I
    //   369: istore #11
    //   371: aload #17
    //   373: invokevirtual getTop : ()I
    //   376: istore #12
    //   378: fload #5
    //   380: f2i
    //   381: istore #13
    //   383: aload_0
    //   384: getfield r : Landroidx/customview/widget/ViewDragHelper$Callback;
    //   387: aload #17
    //   389: iload #12
    //   391: iload #13
    //   393: iadd
    //   394: iload #13
    //   396: invokevirtual clampViewPositionVertical : (Landroid/view/View;II)I
    //   399: istore #13
    //   401: aload_0
    //   402: getfield r : Landroidx/customview/widget/ViewDragHelper$Callback;
    //   405: aload #17
    //   407: invokevirtual getViewHorizontalDragRange : (Landroid/view/View;)I
    //   410: istore #14
    //   412: aload_0
    //   413: getfield r : Landroidx/customview/widget/ViewDragHelper$Callback;
    //   416: aload #17
    //   418: invokevirtual getViewVerticalDragRange : (Landroid/view/View;)I
    //   421: istore #15
    //   423: iload #14
    //   425: ifeq -> 440
    //   428: iload #14
    //   430: ifle -> 460
    //   433: iload #11
    //   435: iload #10
    //   437: if_icmpne -> 460
    //   440: iload #15
    //   442: ifeq -> 509
    //   445: iload #15
    //   447: ifle -> 460
    //   450: iload #13
    //   452: iload #12
    //   454: if_icmpne -> 460
    //   457: goto -> 509
    //   460: aload_0
    //   461: fload #4
    //   463: fload #5
    //   465: iload #9
    //   467: invokespecial b : (FFI)V
    //   470: aload_0
    //   471: getfield a : I
    //   474: iconst_1
    //   475: if_icmpne -> 481
    //   478: goto -> 509
    //   481: iload #7
    //   483: ifeq -> 500
    //   486: aload_0
    //   487: aload #17
    //   489: iload #9
    //   491: invokevirtual a : (Landroid/view/View;I)Z
    //   494: ifeq -> 500
    //   497: goto -> 509
    //   500: iload #6
    //   502: iconst_1
    //   503: iadd
    //   504: istore #6
    //   506: goto -> 236
    //   509: aload_0
    //   510: aload_1
    //   511: invokespecial a : (Landroid/view/MotionEvent;)V
    //   514: goto -> 79
    //   517: aload_0
    //   518: invokevirtual cancel : ()V
    //   521: goto -> 79
    //   524: aload_1
    //   525: invokevirtual getX : ()F
    //   528: fstore_2
    //   529: aload_1
    //   530: invokevirtual getY : ()F
    //   533: fstore_3
    //   534: aload_1
    //   535: iconst_0
    //   536: invokevirtual getPointerId : (I)I
    //   539: istore #6
    //   541: aload_0
    //   542: fload_2
    //   543: fload_3
    //   544: iload #6
    //   546: invokespecial a : (FFI)V
    //   549: aload_0
    //   550: fload_2
    //   551: f2i
    //   552: fload_3
    //   553: f2i
    //   554: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   557: astore_1
    //   558: aload_1
    //   559: aload_0
    //   560: getfield s : Landroid/view/View;
    //   563: if_acmpne -> 582
    //   566: aload_0
    //   567: getfield a : I
    //   570: iconst_2
    //   571: if_icmpne -> 582
    //   574: aload_0
    //   575: aload_1
    //   576: iload #6
    //   578: invokevirtual a : (Landroid/view/View;I)Z
    //   581: pop
    //   582: aload_0
    //   583: getfield h : [I
    //   586: iload #6
    //   588: iaload
    //   589: istore #7
    //   591: aload_0
    //   592: getfield p : I
    //   595: istore #8
    //   597: iload #7
    //   599: iload #8
    //   601: iand
    //   602: ifeq -> 619
    //   605: aload_0
    //   606: getfield r : Landroidx/customview/widget/ViewDragHelper$Callback;
    //   609: iload #7
    //   611: iload #8
    //   613: iand
    //   614: iload #6
    //   616: invokevirtual onEdgeTouched : (II)V
    //   619: iconst_0
    //   620: istore #16
    //   622: aload_0
    //   623: getfield a : I
    //   626: iconst_1
    //   627: if_icmpne -> 633
    //   630: iconst_1
    //   631: istore #16
    //   633: iload #16
    //   635: ireturn
  }
  
  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2) {
    this.s = paramView;
    this.c = -1;
    boolean bool = a(paramInt1, paramInt2, 0, 0);
    if (!bool && this.a == 0 && this.s != null)
      this.s = null; 
    return bool;
  }
  
  public static abstract class Callback {
    public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
      return 0;
    }
    
    public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
      return 0;
    }
    
    public int getOrderedChildIndex(int param1Int) {
      return param1Int;
    }
    
    public int getViewHorizontalDragRange(View param1View) {
      return 0;
    }
    
    public int getViewVerticalDragRange(View param1View) {
      return 0;
    }
    
    public void onEdgeDragStarted(int param1Int1, int param1Int2) {}
    
    public boolean onEdgeLock(int param1Int) {
      return false;
    }
    
    public void onEdgeTouched(int param1Int1, int param1Int2) {}
    
    public void onViewCaptured(View param1View, int param1Int) {}
    
    public void onViewDragStateChanged(int param1Int) {}
    
    public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    public void onViewReleased(View param1View, float param1Float1, float param1Float2) {}
    
    public abstract boolean tryCaptureView(View param1View, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\customview\widget\ViewDragHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */