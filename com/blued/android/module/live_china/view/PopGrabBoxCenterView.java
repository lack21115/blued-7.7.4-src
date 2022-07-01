package com.blued.android.module.live_china.view;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;

public class PopGrabBoxCenterView extends PopGrabBoxView {
  public PopGrabBoxCenterView(BaseFragment paramBaseFragment, IRequestHost paramIRequestHost, PopGrabBoxView.DismissLisnter paramDismissLisnter) {
    super(paramBaseFragment, paramIRequestHost, paramDismissLisnter);
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString1, String paramString2, PopGrabBoxView.DismissLisnter paramDismissLisnter, IRequestHost paramIRequestHost) {
    (new PopGrabBoxCenterView(paramBaseFragment, paramIRequestHost, paramDismissLisnter)).a(paramString1, paramString2);
  }
  
  public void a() {
    this.a = this.f.inflate(R.layout.pop_grab_box_center, null);
  }
  
  public void b() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.e();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.b.startAnimation((Animation)alphaAnimation);
  }
  
  public void c() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopGrabBoxCenterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */