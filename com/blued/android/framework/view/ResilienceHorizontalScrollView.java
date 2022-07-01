package com.blued.android.framework.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

public class ResilienceHorizontalScrollView extends HorizontalScrollView {
  private Rect a = new Rect();
  
  private View b;
  
  private boolean c = false;
  
  private boolean d = false;
  
  private boolean e = false;
  
  private float f;
  
  public ResilienceHorizontalScrollView(Context paramContext) {
    super(paramContext);
  }
  
  public ResilienceHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a() {
    return (this.b.getWidth() <= getWidth() + getScrollX());
  }
  
  private boolean b() {
    return (getScrollX() == 0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/view/View;
    //   4: ifnonnull -> 13
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   12: ireturn
    //   13: aload_1
    //   14: invokevirtual getAction : ()I
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq -> 295
    //   22: iconst_0
    //   23: istore_3
    //   24: iload_2
    //   25: iconst_1
    //   26: if_icmpeq -> 193
    //   29: iload_2
    //   30: iconst_2
    //   31: if_icmpeq -> 37
    //   34: goto -> 319
    //   37: aload_0
    //   38: getfield e : Z
    //   41: ifne -> 78
    //   44: aload_0
    //   45: getfield d : Z
    //   48: ifne -> 78
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual getX : ()F
    //   56: putfield f : F
    //   59: aload_0
    //   60: aload_0
    //   61: invokespecial b : ()Z
    //   64: putfield e : Z
    //   67: aload_0
    //   68: aload_0
    //   69: invokespecial a : ()Z
    //   72: putfield d : Z
    //   75: goto -> 319
    //   78: aload_1
    //   79: invokevirtual getX : ()F
    //   82: aload_0
    //   83: getfield f : F
    //   86: fsub
    //   87: f2i
    //   88: istore #4
    //   90: aload_0
    //   91: getfield e : Z
    //   94: ifeq -> 102
    //   97: iload #4
    //   99: ifgt -> 132
    //   102: aload_0
    //   103: getfield d : Z
    //   106: ifeq -> 114
    //   109: iload #4
    //   111: iflt -> 132
    //   114: iload_3
    //   115: istore_2
    //   116: aload_0
    //   117: getfield d : Z
    //   120: ifeq -> 134
    //   123: iload_3
    //   124: istore_2
    //   125: aload_0
    //   126: getfield e : Z
    //   129: ifeq -> 134
    //   132: iconst_1
    //   133: istore_2
    //   134: iload_2
    //   135: ifeq -> 319
    //   138: iload #4
    //   140: i2f
    //   141: ldc 0.5
    //   143: fmul
    //   144: f2i
    //   145: istore_2
    //   146: aload_0
    //   147: getfield b : Landroid/view/View;
    //   150: aload_0
    //   151: getfield a : Landroid/graphics/Rect;
    //   154: getfield left : I
    //   157: iload_2
    //   158: iadd
    //   159: aload_0
    //   160: getfield a : Landroid/graphics/Rect;
    //   163: getfield top : I
    //   166: aload_0
    //   167: getfield a : Landroid/graphics/Rect;
    //   170: getfield right : I
    //   173: iload_2
    //   174: iadd
    //   175: aload_0
    //   176: getfield a : Landroid/graphics/Rect;
    //   179: getfield bottom : I
    //   182: invokevirtual layout : (IIII)V
    //   185: aload_0
    //   186: iconst_1
    //   187: putfield c : Z
    //   190: goto -> 319
    //   193: aload_0
    //   194: getfield c : Z
    //   197: ifne -> 203
    //   200: goto -> 319
    //   203: aload_0
    //   204: getfield b : Landroid/view/View;
    //   207: invokevirtual animate : ()Landroid/view/ViewPropertyAnimator;
    //   210: ldc2_w 200
    //   213: invokevirtual setDuration : (J)Landroid/view/ViewPropertyAnimator;
    //   216: new android/view/animation/OvershootInterpolator
    //   219: dup
    //   220: ldc 1.5
    //   222: invokespecial <init> : (F)V
    //   225: invokevirtual setInterpolator : (Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;
    //   228: aload_0
    //   229: getfield a : Landroid/graphics/Rect;
    //   232: getfield left : I
    //   235: i2f
    //   236: invokevirtual x : (F)Landroid/view/ViewPropertyAnimator;
    //   239: invokevirtual start : ()V
    //   242: aload_0
    //   243: getfield b : Landroid/view/View;
    //   246: aload_0
    //   247: getfield a : Landroid/graphics/Rect;
    //   250: getfield left : I
    //   253: aload_0
    //   254: getfield a : Landroid/graphics/Rect;
    //   257: getfield top : I
    //   260: aload_0
    //   261: getfield a : Landroid/graphics/Rect;
    //   264: getfield right : I
    //   267: aload_0
    //   268: getfield a : Landroid/graphics/Rect;
    //   271: getfield bottom : I
    //   274: invokevirtual layout : (IIII)V
    //   277: aload_0
    //   278: iconst_0
    //   279: putfield e : Z
    //   282: aload_0
    //   283: iconst_0
    //   284: putfield d : Z
    //   287: aload_0
    //   288: iconst_0
    //   289: putfield c : Z
    //   292: goto -> 319
    //   295: aload_0
    //   296: aload_0
    //   297: invokespecial b : ()Z
    //   300: putfield e : Z
    //   303: aload_0
    //   304: aload_0
    //   305: invokespecial a : ()Z
    //   308: putfield d : Z
    //   311: aload_0
    //   312: aload_1
    //   313: invokevirtual getX : ()F
    //   316: putfield f : F
    //   319: aload_0
    //   320: aload_1
    //   321: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   324: ireturn
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    if (getChildCount() > 0)
      this.b = getChildAt(0); 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View view = this.b;
    if (view == null)
      return; 
    this.a.set(view.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\ResilienceHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */