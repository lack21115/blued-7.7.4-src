package com.blued.android.module.live_china.view;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.res_china.R;

public class PopMenuFromCenter extends PopMenuFromBottom {
  public DismissListner g;
  
  public void a() {
    a(false);
  }
  
  public void a(boolean paramBoolean) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(200L);
    alphaAnimation.setFillAfter(true);
    this.a.startAnimation((Animation)alphaAnimation);
    this.b.setVisibility(8);
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_out));
    AppInfo.n().postDelayed(new Runnable(this, paramBoolean) {
          public void run() {
            this.b.d.a();
            if (this.b.g != null)
              this.b.g.a(this.a); 
          }
        }320L);
  }
  
  public static interface DismissListner {
    void a(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopMenuFromCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */