package com.soft.blued.customview;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module_share_china.R;

public class PopMenuFromCenter extends PopMenuFromBottom {
  public DismissListner h;
  
  public PopMenuFromCenter(Context paramContext, View paramView) {
    super(paramContext, paramView);
  }
  
  public void a(DismissListner paramDismissListner) {
    this.h = paramDismissListner;
  }
  
  public void a(boolean paramBoolean) {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(200L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.setVisibility(8);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
    AppInfo.n().postDelayed(new Runnable(this, paramBoolean) {
          public void run() {
            this.b.e.a();
            if (this.b.h != null)
              this.b.h.dissmiss(this.a); 
          }
        }320L);
  }
  
  public RelativeLayout.LayoutParams b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams.addRule(13);
    return layoutParams;
  }
  
  public void d() {
    a(false);
  }
  
  public void e() {
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.e.isShowing())
      this.e.a(); 
    this.e.showAtLocation(this.b, 17, 0, 0);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(400L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.setVisibility(0);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
  }
  
  public static interface DismissListner {
    void dissmiss(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\PopMenuFromCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */