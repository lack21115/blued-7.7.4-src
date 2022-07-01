package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
  OverScroller a;
  
  private Runnable b;
  
  private boolean c;
  
  private int d = -1;
  
  private int e;
  
  private int f = -1;
  
  private VelocityTracker g;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void c() {
    if (this.g == null)
      this.g = VelocityTracker.obtain(); 
  }
  
  int a() {
    return b();
  }
  
  int a(V paramV) {
    return paramV.getHeight();
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3) {
    int i = b();
    if (paramInt2 != 0 && i >= paramInt2 && i <= paramInt3) {
      paramInt1 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
      if (i != paramInt1) {
        a(paramInt1);
        return i - paramInt1;
      } 
    } 
    return 0;
  }
  
  void a(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, float paramFloat) {
    Runnable runnable = this.b;
    if (runnable != null) {
      paramV.removeCallbacks(runnable);
      this.b = null;
    } 
    if (this.a == null)
      this.a = new OverScroller(paramV.getContext()); 
    this.a.fling(0, b(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.a.computeScrollOffset()) {
      this.b = new FlingRunnable(this, paramCoordinatorLayout, paramV);
      ViewCompat.postOnAnimation((View)paramV, this.b);
      return true;
    } 
    a(paramCoordinatorLayout, paramV);
    return false;
  }
  
  int a_(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    return a(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }
  
  int b(V paramV) {
    return -paramV.getHeight();
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3) {
    return a(paramCoordinatorLayout, paramV, a() - paramInt1, paramInt2, paramInt3);
  }
  
  boolean c(V paramV) {
    return false;
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    if (this.f < 0)
      this.f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop(); 
    if (paramMotionEvent.getActionMasked() == 2 && this.c) {
      int i = this.d;
      if (i == -1)
        return false; 
      i = paramMotionEvent.findPointerIndex(i);
      if (i == -1)
        return false; 
      i = (int)paramMotionEvent.getY(i);
      if (Math.abs(i - this.e) > this.f) {
        this.e = i;
        return true;
      } 
    } 
    if (paramMotionEvent.getActionMasked() == 0) {
      boolean bool;
      this.d = -1;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (c(paramV) && paramCoordinatorLayout.isPointInChildBounds((View)paramV, i, j)) {
        bool = true;
      } else {
        bool = false;
      } 
      this.c = bool;
      if (this.c) {
        this.e = j;
        this.d = paramMotionEvent.getPointerId(0);
        c();
        OverScroller overScroller = this.a;
        if (overScroller != null && !overScroller.isFinished()) {
          this.a.abortAnimation();
          return true;
        } 
      } 
    } 
    VelocityTracker velocityTracker = this.g;
    if (velocityTracker != null)
      velocityTracker.addMovement(paramMotionEvent); 
    return false;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore #5
    //   6: iconst_1
    //   7: istore #7
    //   9: iload #5
    //   11: iconst_1
    //   12: if_icmpeq -> 143
    //   15: iload #5
    //   17: iconst_2
    //   18: if_icmpeq -> 80
    //   21: iload #5
    //   23: iconst_3
    //   24: if_icmpeq -> 205
    //   27: iload #5
    //   29: bipush #6
    //   31: if_icmpeq -> 37
    //   34: goto -> 137
    //   37: aload_3
    //   38: invokevirtual getActionIndex : ()I
    //   41: ifne -> 50
    //   44: iconst_1
    //   45: istore #5
    //   47: goto -> 53
    //   50: iconst_0
    //   51: istore #5
    //   53: aload_0
    //   54: aload_3
    //   55: iload #5
    //   57: invokevirtual getPointerId : (I)I
    //   60: putfield d : I
    //   63: aload_0
    //   64: aload_3
    //   65: iload #5
    //   67: invokevirtual getY : (I)F
    //   70: ldc 0.5
    //   72: fadd
    //   73: f2i
    //   74: putfield e : I
    //   77: goto -> 137
    //   80: aload_3
    //   81: aload_0
    //   82: getfield d : I
    //   85: invokevirtual findPointerIndex : (I)I
    //   88: istore #5
    //   90: iload #5
    //   92: iconst_m1
    //   93: if_icmpne -> 98
    //   96: iconst_0
    //   97: ireturn
    //   98: aload_3
    //   99: iload #5
    //   101: invokevirtual getY : (I)F
    //   104: f2i
    //   105: istore #5
    //   107: aload_0
    //   108: getfield e : I
    //   111: istore #6
    //   113: aload_0
    //   114: iload #5
    //   116: putfield e : I
    //   119: aload_0
    //   120: aload_1
    //   121: aload_2
    //   122: iload #6
    //   124: iload #5
    //   126: isub
    //   127: aload_0
    //   128: aload_2
    //   129: invokevirtual b : (Landroid/view/View;)I
    //   132: iconst_0
    //   133: invokevirtual b : (Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;III)I
    //   136: pop
    //   137: iconst_0
    //   138: istore #6
    //   140: goto -> 244
    //   143: aload_0
    //   144: getfield g : Landroid/view/VelocityTracker;
    //   147: astore #8
    //   149: aload #8
    //   151: ifnull -> 205
    //   154: aload #8
    //   156: aload_3
    //   157: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   160: aload_0
    //   161: getfield g : Landroid/view/VelocityTracker;
    //   164: sipush #1000
    //   167: invokevirtual computeCurrentVelocity : (I)V
    //   170: aload_0
    //   171: getfield g : Landroid/view/VelocityTracker;
    //   174: aload_0
    //   175: getfield d : I
    //   178: invokevirtual getYVelocity : (I)F
    //   181: fstore #4
    //   183: aload_0
    //   184: aload_1
    //   185: aload_2
    //   186: aload_0
    //   187: aload_2
    //   188: invokevirtual a : (Landroid/view/View;)I
    //   191: ineg
    //   192: iconst_0
    //   193: fload #4
    //   195: invokevirtual a : (Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;IIF)Z
    //   198: pop
    //   199: iconst_1
    //   200: istore #5
    //   202: goto -> 208
    //   205: iconst_0
    //   206: istore #5
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield c : Z
    //   213: aload_0
    //   214: iconst_m1
    //   215: putfield d : I
    //   218: aload_0
    //   219: getfield g : Landroid/view/VelocityTracker;
    //   222: astore_1
    //   223: iload #5
    //   225: istore #6
    //   227: aload_1
    //   228: ifnull -> 244
    //   231: aload_1
    //   232: invokevirtual recycle : ()V
    //   235: aload_0
    //   236: aconst_null
    //   237: putfield g : Landroid/view/VelocityTracker;
    //   240: iload #5
    //   242: istore #6
    //   244: aload_0
    //   245: getfield g : Landroid/view/VelocityTracker;
    //   248: astore_1
    //   249: aload_1
    //   250: ifnull -> 258
    //   253: aload_1
    //   254: aload_3
    //   255: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   258: aload_0
    //   259: getfield c : Z
    //   262: ifne -> 275
    //   265: iload #6
    //   267: ifeq -> 272
    //   270: iconst_1
    //   271: ireturn
    //   272: iconst_0
    //   273: istore #7
    //   275: iload #7
    //   277: ireturn
  }
  
  class FlingRunnable implements Runnable {
    private final CoordinatorLayout b;
    
    private final V c;
    
    FlingRunnable(HeaderBehavior this$0, CoordinatorLayout param1CoordinatorLayout, V param1V) {
      this.b = param1CoordinatorLayout;
      this.c = param1V;
    }
    
    public void run() {
      if (this.c != null && this.a.a != null) {
        if (this.a.a.computeScrollOffset()) {
          HeaderBehavior<V> headerBehavior = this.a;
          headerBehavior.a_(this.b, this.c, headerBehavior.a.getCurrY());
          ViewCompat.postOnAnimation((View)this.c, this);
          return;
        } 
        this.a.a(this.b, this.c);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\appbar\HeaderBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */