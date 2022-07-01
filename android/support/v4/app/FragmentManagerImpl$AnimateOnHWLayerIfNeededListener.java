package android.support.v4.app;

import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation;

final class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener extends FragmentManagerImpl$AnimationListenerWrapper {
  View mView;
  
  FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(View paramView, Animation.AnimationListener paramAnimationListener) {
    super(paramAnimationListener, (byte)0);
    this.mView = paramView;
  }
  
  public final void onAnimationEnd(Animation paramAnimation) {
    if (ViewCompat.isAttachedToWindow(this.mView) || Build.VERSION.SDK_INT >= 24) {
      this.mView.post(new FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$1(this));
    } else {
      this.mView.setLayerType(0, null);
    } 
    super.onAnimationEnd(paramAnimation);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$AnimateOnHWLayerIfNeededListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */