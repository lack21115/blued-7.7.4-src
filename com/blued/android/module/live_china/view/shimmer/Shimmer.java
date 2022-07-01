package com.blued.android.module.live_china.view.shimmer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class Shimmer {
  private int a = -1;
  
  private long b = 1000L;
  
  private long c = 0L;
  
  private int d = 0;
  
  private Animator.AnimatorListener e;
  
  private ObjectAnimator f;
  
  public void a() {
    ObjectAnimator objectAnimator = this.f;
    if (objectAnimator != null)
      objectAnimator.cancel(); 
  }
  
  public <V extends View & ShimmerViewBase> void a(V paramV) {
    if (b())
      return; 
    Runnable runnable = new Runnable(this, (View)paramV) {
        public void run() {
          ((ShimmerViewBase)this.a).setShimmering(true);
          float f1 = this.a.getWidth();
          int i = Shimmer.a(this.b);
          float f2 = 0.0F;
          if (i == 1) {
            f1 = this.a.getWidth();
          } else {
            f2 = f1;
            f1 = 0.0F;
          } 
          Shimmer.a(this.b, ObjectAnimator.ofFloat(this.a, "gradientX", new float[] { f1, f2 }));
          Shimmer.c(this.b).setRepeatCount(Shimmer.b(this.b));
          Shimmer.c(this.b).setDuration(Shimmer.d(this.b));
          Shimmer.c(this.b).setStartDelay(Shimmer.e(this.b));
          Shimmer.c(this.b).addListener(new Animator.AnimatorListener(this) {
                public void onAnimationCancel(Animator param2Animator) {}
                
                public void onAnimationEnd(Animator param2Animator) {
                  ((ShimmerViewBase)this.a.a).setShimmering(false);
                  this.a.a.postInvalidateOnAnimation();
                  Shimmer.a(this.a.b, null);
                }
                
                public void onAnimationRepeat(Animator param2Animator) {}
                
                public void onAnimationStart(Animator param2Animator) {}
              });
          if (Shimmer.f(this.b) != null)
            Shimmer.c(this.b).addListener(Shimmer.f(this.b)); 
          Shimmer.c(this.b).start();
        }
      };
    ShimmerViewBase shimmerViewBase = (ShimmerViewBase)paramV;
    if (!shimmerViewBase.a()) {
      shimmerViewBase.setAnimationSetupCallback(new ShimmerViewHelper.AnimationSetupCallback(this, runnable) {
            public void a(View param1View) {
              this.a.run();
            }
          });
      return;
    } 
    runnable.run();
  }
  
  public boolean b() {
    ObjectAnimator objectAnimator = this.f;
    return (objectAnimator != null && objectAnimator.isRunning());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\shimmer\Shimmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */