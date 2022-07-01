package com.blued.android.module.live_china.view;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import com.blued.android.core.AppInfo;
import com.blued.android.module.res_china.R;

public class PopMenuFromBottom extends PopMenu {
  private Float g;
  
  public void a() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(this.g.floatValue(), 0.0F);
    alphaAnimation.setDuration(200L);
    alphaAnimation.setFillAfter(true);
    this.a.startAnimation((Animation)alphaAnimation);
    this.b.setVisibility(8);
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.pop_down_out));
    AppInfo.n().postDelayed(new -$$Lambda$PopMenuFromBottom$QIJjk8h1NtYn0LUoc_Aozst8PAI(this), 320L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopMenuFromBottom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */