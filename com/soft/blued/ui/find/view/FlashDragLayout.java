package com.soft.blued.ui.find.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.utils.Logger;

public class FlashDragLayout extends RelativeLayout implements GestureDetector.OnGestureListener {
  private static int e = 100;
  
  GestureDetector a = new GestureDetector(this);
  
  private View b;
  
  private int c;
  
  private int d;
  
  private boolean f = true;
  
  private boolean g;
  
  private int h = 0;
  
  private float i = 100.0F;
  
  private int j;
  
  private OnDragChangedListener k;
  
  public FlashDragLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/view/View;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield b : Landroid/view/View;
    //   18: invokevirtual getX : ()F
    //   21: f2i
    //   22: istore_2
    //   23: iload_1
    //   24: iload_2
    //   25: iadd
    //   26: istore_1
    //   27: iload_1
    //   28: ifgt -> 42
    //   31: aload_0
    //   32: getfield b : Landroid/view/View;
    //   35: fconst_0
    //   36: invokevirtual setX : (F)V
    //   39: goto -> 110
    //   42: iload_1
    //   43: aload_0
    //   44: getfield c : I
    //   47: if_icmplt -> 65
    //   50: aload_0
    //   51: getfield b : Landroid/view/View;
    //   54: aload_0
    //   55: getfield c : I
    //   58: i2f
    //   59: invokevirtual setX : (F)V
    //   62: goto -> 110
    //   65: aload_0
    //   66: getfield b : Landroid/view/View;
    //   69: iload_1
    //   70: i2f
    //   71: invokevirtual setX : (F)V
    //   74: aload_0
    //   75: getfield k : Lcom/soft/blued/ui/find/view/FlashDragLayout$OnDragChangedListener;
    //   78: ifnull -> 110
    //   81: aload_0
    //   82: getfield k : Lcom/soft/blued/ui/find/view/FlashDragLayout$OnDragChangedListener;
    //   85: fconst_1
    //   86: iload_2
    //   87: i2f
    //   88: aload_0
    //   89: getfield i : F
    //   92: aload_0
    //   93: getfield c : I
    //   96: i2f
    //   97: fdiv
    //   98: fmul
    //   99: aload_0
    //   100: getfield i : F
    //   103: fdiv
    //   104: fsub
    //   105: invokeinterface a : (F)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_3
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_3
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	113	finally
    //   14	23	113	finally
    //   31	39	113	finally
    //   42	62	113	finally
    //   65	110	113	finally
  }
  
  private void b() {
    this.c = LiveFloatManager.a().C();
    this.d = LiveFloatManager.a().D();
    this.j = DensityUtils.a(getContext(), 50.0F);
    setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            this.a.a.onTouchEvent(param1MotionEvent);
            try {
              int i = param1MotionEvent.getAction();
              if (i != 0 && i == 1)
                if (param1MotionEvent.getX() < FlashDragLayout.a(this.a) && param1MotionEvent.getY() < FlashDragLayout.a(this.a)) {
                  this.a.a();
                } else if (FlashDragLayout.b(this.a).getX() > (FlashDragLayout.c(this.a) / 2)) {
                  this.a.a(1, 300);
                } else {
                  this.a.a(0, 300);
                }  
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
            return FlashDragLayout.d(this.a);
          }
        });
  }
  
  public void a() {
    int i = this.h;
    if (i == 0) {
      a(0, 300);
      return;
    } 
    if (i == 1)
      a(1, 300); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Z
    //   6: istore #5
    //   8: iload #5
    //   10: ifeq -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield g : Z
    //   21: aload_0
    //   22: getfield b : Landroid/view/View;
    //   25: invokevirtual getX : ()F
    //   28: f2i
    //   29: istore #4
    //   31: iload_1
    //   32: ifne -> 40
    //   35: iconst_0
    //   36: istore_3
    //   37: goto -> 45
    //   40: aload_0
    //   41: getfield c : I
    //   44: istore_3
    //   45: iconst_2
    //   46: newarray float
    //   48: dup
    //   49: iconst_0
    //   50: fconst_0
    //   51: fastore
    //   52: dup
    //   53: iconst_1
    //   54: fconst_1
    //   55: fastore
    //   56: invokestatic ofFloat : ([F)Landroid/animation/ValueAnimator;
    //   59: astore #6
    //   61: aload #6
    //   63: new android/view/animation/DecelerateInterpolator
    //   66: dup
    //   67: invokespecial <init> : ()V
    //   70: invokevirtual setInterpolator : (Landroid/animation/TimeInterpolator;)V
    //   73: aload #6
    //   75: iload_2
    //   76: i2l
    //   77: invokevirtual setDuration : (J)Landroid/animation/ValueAnimator;
    //   80: pop
    //   81: aload #6
    //   83: new com/soft/blued/ui/find/view/FlashDragLayout$2
    //   86: dup
    //   87: aload_0
    //   88: iload_3
    //   89: iload #4
    //   91: isub
    //   92: iload #4
    //   94: invokespecial <init> : (Lcom/soft/blued/ui/find/view/FlashDragLayout;II)V
    //   97: invokevirtual addUpdateListener : (Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    //   100: aload #6
    //   102: new com/soft/blued/ui/find/view/FlashDragLayout$3
    //   105: dup
    //   106: aload_0
    //   107: iload_1
    //   108: invokespecial <init> : (Lcom/soft/blued/ui/find/view/FlashDragLayout;I)V
    //   111: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   114: aload #6
    //   116: invokevirtual start : ()V
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: astore #6
    //   124: aload_0
    //   125: monitorexit
    //   126: aload #6
    //   128: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	122	finally
    //   16	31	122	finally
    //   40	45	122	finally
    //   45	119	122	finally
  }
  
  public boolean onDown(MotionEvent paramMotionEvent) {
    return false;
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    this.b = getChildAt(0);
    View view = this.b;
    if (view != null)
      view.setX(LiveFloatManager.a().C()); 
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() > e && Math.abs(paramFloat1) > 200.0F) {
      Logger.b("xpz", new Object[] { "onFling down" });
      a(0, 300);
      return false;
    } 
    if (paramMotionEvent2.getX() - paramMotionEvent1.getX() > e && Math.abs(paramFloat1) > 200.0F)
      a(1, 300); 
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    return this.f ? true : super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    a(-((int)paramFloat1));
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
    return false;
  }
  
  public void setOnDragChangedListener(OnDragChangedListener paramOnDragChangedListener) {
    this.k = paramOnDragChangedListener;
  }
  
  public static interface OnDragChangedListener {
    void a(float param1Float);
    
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\view\FlashDragLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */