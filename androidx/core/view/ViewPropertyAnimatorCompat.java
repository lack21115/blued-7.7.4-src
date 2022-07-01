package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
  Runnable a = null;
  
  Runnable b = null;
  
  int c = -1;
  
  private WeakReference<View> d;
  
  ViewPropertyAnimatorCompat(View paramView) {
    this.d = new WeakReference<View>(paramView);
  }
  
  private void a(View paramView, ViewPropertyAnimatorListener paramViewPropertyAnimatorListener) {
    if (paramViewPropertyAnimatorListener != null) {
      paramView.animate().setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramViewPropertyAnimatorListener, paramView) {
            public void onAnimationCancel(Animator param1Animator) {
              this.a.onAnimationCancel(this.b);
            }
            
            public void onAnimationEnd(Animator param1Animator) {
              this.a.onAnimationEnd(this.b);
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.a.onAnimationStart(this.b);
            }
          });
      return;
    } 
    paramView.animate().setListener(null);
  }
  
  public ViewPropertyAnimatorCompat alpha(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().alpha(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat alphaBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().alphaBy(paramFloat); 
    return this;
  }
  
  public void cancel() {
    View view = this.d.get();
    if (view != null)
      view.animate().cancel(); 
  }
  
  public long getDuration() {
    View view = this.d.get();
    return (view != null) ? view.animate().getDuration() : 0L;
  }
  
  public Interpolator getInterpolator() {
    View view = this.d.get();
    return (view != null && Build.VERSION.SDK_INT >= 18) ? (Interpolator)view.animate().getInterpolator() : null;
  }
  
  public long getStartDelay() {
    View view = this.d.get();
    return (view != null) ? view.animate().getStartDelay() : 0L;
  }
  
  public ViewPropertyAnimatorCompat rotation(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().rotation(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().rotationBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationX(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().rotationX(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationXBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().rotationXBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationY(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().rotationY(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat rotationYBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().rotationYBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleX(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().scaleX(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleXBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().scaleXBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleY(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().scaleY(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat scaleYBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().scaleYBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setDuration(long paramLong) {
    View view = this.d.get();
    if (view != null)
      view.animate().setDuration(paramLong); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setInterpolator(Interpolator paramInterpolator) {
    View view = this.d.get();
    if (view != null)
      view.animate().setInterpolator((TimeInterpolator)paramInterpolator); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener) {
    View view = this.d.get();
    if (view != null) {
      if (Build.VERSION.SDK_INT >= 16) {
        a(view, paramViewPropertyAnimatorListener);
        return this;
      } 
      view.setTag(2113929216, paramViewPropertyAnimatorListener);
      a(view, new ViewPropertyAnimatorListenerApi14(this));
    } 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setStartDelay(long paramLong) {
    View view = this.d.get();
    if (view != null)
      view.animate().setStartDelay(paramLong); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener) {
    View view = this.d.get();
    if (view != null && Build.VERSION.SDK_INT >= 19) {
      ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
      if (paramViewPropertyAnimatorUpdateListener != null)
        animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(this, paramViewPropertyAnimatorUpdateListener, view) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.a.onAnimationUpdate(this.b);
            }
          }; 
      view.animate().setUpdateListener(animatorUpdateListener);
    } 
    return this;
  }
  
  public void start() {
    View view = this.d.get();
    if (view != null)
      view.animate().start(); 
  }
  
  public ViewPropertyAnimatorCompat translationX(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().translationX(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationXBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().translationXBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationY(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().translationY(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationYBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().translationYBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationZ(float paramFloat) {
    View view = this.d.get();
    if (view != null && Build.VERSION.SDK_INT >= 21)
      view.animate().translationZ(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat translationZBy(float paramFloat) {
    View view = this.d.get();
    if (view != null && Build.VERSION.SDK_INT >= 21)
      view.animate().translationZBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat withEndAction(Runnable paramRunnable) {
    View view = this.d.get();
    if (view != null) {
      if (Build.VERSION.SDK_INT >= 16) {
        view.animate().withEndAction(paramRunnable);
        return this;
      } 
      a(view, new ViewPropertyAnimatorListenerApi14(this));
      this.b = paramRunnable;
    } 
    return this;
  }
  
  public ViewPropertyAnimatorCompat withLayer() {
    View view = this.d.get();
    if (view != null) {
      if (Build.VERSION.SDK_INT >= 16) {
        view.animate().withLayer();
        return this;
      } 
      this.c = view.getLayerType();
      a(view, new ViewPropertyAnimatorListenerApi14(this));
    } 
    return this;
  }
  
  public ViewPropertyAnimatorCompat withStartAction(Runnable paramRunnable) {
    View view = this.d.get();
    if (view != null) {
      if (Build.VERSION.SDK_INT >= 16) {
        view.animate().withStartAction(paramRunnable);
        return this;
      } 
      a(view, new ViewPropertyAnimatorListenerApi14(this));
      this.a = paramRunnable;
    } 
    return this;
  }
  
  public ViewPropertyAnimatorCompat x(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().x(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat xBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().xBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat y(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().y(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat yBy(float paramFloat) {
    View view = this.d.get();
    if (view != null)
      view.animate().yBy(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat z(float paramFloat) {
    View view = this.d.get();
    if (view != null && Build.VERSION.SDK_INT >= 21)
      view.animate().z(paramFloat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompat zBy(float paramFloat) {
    View view = this.d.get();
    if (view != null && Build.VERSION.SDK_INT >= 21)
      view.animate().zBy(paramFloat); 
    return this;
  }
  
  static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
    ViewPropertyAnimatorCompat a;
    
    boolean b;
    
    ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat param1ViewPropertyAnimatorCompat) {
      this.a = param1ViewPropertyAnimatorCompat;
    }
    
    public void onAnimationCancel(View param1View) {
      Object object = param1View.getTag(2113929216);
      if (object instanceof ViewPropertyAnimatorListener) {
        object = object;
      } else {
        object = null;
      } 
      if (object != null)
        object.onAnimationCancel(param1View); 
    }
    
    public void onAnimationEnd(View param1View) {
      int i = this.a.c;
      ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
      if (i > -1) {
        param1View.setLayerType(this.a.c, null);
        this.a.c = -1;
      } 
      if (Build.VERSION.SDK_INT >= 16 || !this.b) {
        if (this.a.b != null) {
          Runnable runnable = this.a.b;
          this.a.b = null;
          runnable.run();
        } 
        Object object = param1View.getTag(2113929216);
        if (object instanceof ViewPropertyAnimatorListener)
          viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
        if (viewPropertyAnimatorListener != null)
          viewPropertyAnimatorListener.onAnimationEnd(param1View); 
        this.b = true;
      } 
    }
    
    public void onAnimationStart(View param1View) {
      this.b = false;
      int i = this.a.c;
      ViewPropertyAnimatorListener viewPropertyAnimatorListener = null;
      if (i > -1)
        param1View.setLayerType(2, null); 
      if (this.a.a != null) {
        Runnable runnable = this.a.a;
        this.a.a = null;
        runnable.run();
      } 
      Object object = param1View.getTag(2113929216);
      if (object instanceof ViewPropertyAnimatorListener)
        viewPropertyAnimatorListener = (ViewPropertyAnimatorListener)object; 
      if (viewPropertyAnimatorListener != null)
        viewPropertyAnimatorListener.onAnimationStart(param1View); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\ViewPropertyAnimatorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */