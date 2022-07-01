package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CircularAnim {
  public static class FullActivityBuilder {
    private Activity a;
    
    private View b;
    
    private float c;
    
    private CircularAnim.OnAnimationEndListener d;
    
    private int e;
    
    private int f;
    
    private void a() {
      this.d.a();
    }
  }
  
  class null extends AnimatorListenerAdapter {
    public void onAnimationEnd(Animator param1Animator) {
      super.onAnimationEnd(param1Animator);
      CircularAnim.FullActivityBuilder.a(this.g);
      CircularAnim.FullActivityBuilder.d(this.g).overridePendingTransition(CircularAnim.FullActivityBuilder.b(this.g), CircularAnim.FullActivityBuilder.c(this.g));
      CircularAnim.FullActivityBuilder.f(this.g).postDelayed(new Runnable(this) {
            public void run() {
              if (CircularAnim.FullActivityBuilder.d(this.a.g).isFinishing())
                return; 
              try {
                Animator animator = ViewAnimationUtils.createCircularReveal((View)this.a.a, this.a.b, this.a.c, this.a.d, CircularAnim.FullActivityBuilder.e(this.a.g));
                animator.setDuration(this.a.e);
                animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
                      public void onAnimationEnd(Animator param4Animator) {
                        super.onAnimationEnd(param4Animator);
                        try {
                          this.a.a.f.removeView((View)this.a.a.a);
                          return;
                        } catch (Exception exception) {
                          exception.printStackTrace();
                          return;
                        } 
                      }
                    });
                animator.start();
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                try {
                  this.a.f.removeView((View)this.a.a);
                  return;
                } catch (Exception exception1) {
                  exception1.printStackTrace();
                  return;
                } 
              } 
            }
          }1000L);
    }
  }
  
  class null implements Runnable {
    public void run() {
      if (CircularAnim.FullActivityBuilder.d(this.a.g).isFinishing())
        return; 
      try {
        Animator animator = ViewAnimationUtils.createCircularReveal((View)this.a.a, this.a.b, this.a.c, this.a.d, CircularAnim.FullActivityBuilder.e(this.a.g));
        animator.setDuration(this.a.e);
        animator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
              public void onAnimationEnd(Animator param4Animator) {
                super.onAnimationEnd(param4Animator);
                try {
                  this.a.a.f.removeView((View)this.a.a.a);
                  return;
                } catch (Exception exception) {
                  exception.printStackTrace();
                  return;
                } 
              }
            });
        animator.start();
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        try {
          this.a.f.removeView((View)this.a.a);
          return;
        } catch (Exception exception1) {
          exception1.printStackTrace();
          return;
        } 
      } 
    }
  }
  
  class null extends AnimatorListenerAdapter {
    public void onAnimationEnd(Animator param1Animator) {
      super.onAnimationEnd(param1Animator);
      try {
        this.a.a.f.removeView((View)this.a.a.a);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      } 
    }
  }
  
  public static interface OnAnimationEndListener {
    void a();
  }
  
  public static class VisibleBuilder {
    private View a;
    
    private boolean b;
    
    private CircularAnim.OnAnimationEndListener c;
    
    private void a() {
      if (this.b) {
        this.a.setVisibility(0);
      } else {
        this.a.setVisibility(4);
      } 
      CircularAnim.OnAnimationEndListener onAnimationEndListener = this.c;
      if (onAnimationEndListener != null)
        onAnimationEndListener.a(); 
    }
  }
  
  class null extends AnimatorListenerAdapter {
    public void onAnimationEnd(Animator param1Animator) {
      super.onAnimationEnd(param1Animator);
      CircularAnim.VisibleBuilder.a(this.a);
    }
  }
  
  class null extends AnimatorListenerAdapter {
    public void onAnimationEnd(Animator param1Animator) {
      super.onAnimationEnd(param1Animator);
      CircularAnim.VisibleBuilder.a(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CircularAnim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */