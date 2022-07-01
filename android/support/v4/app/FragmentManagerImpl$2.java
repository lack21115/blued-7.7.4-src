package android.support.v4.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

final class FragmentManagerImpl$2 extends FragmentManagerImpl$AnimationListenerWrapper {
  FragmentManagerImpl$2(Animation.AnimationListener paramAnimationListener) {
    super(paramAnimationListener, (byte)0);
  }
  
  public final void onAnimationEnd(Animation paramAnimation) {
    super.onAnimationEnd(paramAnimation);
    container.post(new FragmentManagerImpl$2$1(this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */