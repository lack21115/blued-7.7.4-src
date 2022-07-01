package com.soft.blued.customview;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

public class WebViewProgressBar extends ProgressBar {
  private static int b = 95;
  
  private static int c = 100;
  
  private Context a;
  
  private ValueAnimator d;
  
  public WebViewProgressBar(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public WebViewProgressBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WebViewProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void setRealProgress(int paramInt) {
    super.setProgress(paramInt);
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
    this.d = ValueAnimator.ofInt(new int[] { 0, b });
    this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            WebViewProgressBar.a(this.a, i);
          }
        });
    this.d.setDuration(10000L);
    this.d.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    setMax(c);
    setProgressDrawable(this.a.getResources().getDrawable(2131231318));
    this.d.start();
  }
  
  public void setProgress(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: getstatic com/soft/blued/customview/WebViewProgressBar.b : I
    //   6: if_icmplt -> 103
    //   9: aload_0
    //   10: getfield d : Landroid/animation/ValueAnimator;
    //   13: invokevirtual isRunning : ()Z
    //   16: ifeq -> 26
    //   19: aload_0
    //   20: getfield d : Landroid/animation/ValueAnimator;
    //   23: invokevirtual cancel : ()V
    //   26: aload_0
    //   27: invokevirtual getProgress : ()I
    //   30: istore_2
    //   31: aload_0
    //   32: iconst_2
    //   33: newarray int
    //   35: dup
    //   36: iconst_0
    //   37: iload_2
    //   38: iastore
    //   39: dup
    //   40: iconst_1
    //   41: iload_2
    //   42: iload_1
    //   43: iload_2
    //   44: isub
    //   45: iadd
    //   46: iastore
    //   47: invokestatic ofInt : ([I)Landroid/animation/ValueAnimator;
    //   50: putfield d : Landroid/animation/ValueAnimator;
    //   53: aload_0
    //   54: getfield d : Landroid/animation/ValueAnimator;
    //   57: new com/soft/blued/customview/WebViewProgressBar$2
    //   60: dup
    //   61: aload_0
    //   62: invokespecial <init> : (Lcom/soft/blued/customview/WebViewProgressBar;)V
    //   65: invokevirtual addUpdateListener : (Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    //   68: aload_0
    //   69: getfield d : Landroid/animation/ValueAnimator;
    //   72: ldc2_w 200
    //   75: invokevirtual setDuration : (J)Landroid/animation/ValueAnimator;
    //   78: pop
    //   79: aload_0
    //   80: getfield d : Landroid/animation/ValueAnimator;
    //   83: new android/view/animation/DecelerateInterpolator
    //   86: dup
    //   87: invokespecial <init> : ()V
    //   90: invokevirtual setInterpolator : (Landroid/animation/TimeInterpolator;)V
    //   93: aload_0
    //   94: getfield d : Landroid/animation/ValueAnimator;
    //   97: invokevirtual start : ()V
    //   100: goto -> 108
    //   103: aload_0
    //   104: iconst_0
    //   105: invokevirtual setVisibility : (I)V
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: astore_3
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_3
    //   115: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	111	finally
    //   26	100	111	finally
    //   103	108	111	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\WebViewProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */