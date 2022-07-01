package com.soft.blued.customview;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.blued.android.core.AppInfo;
import com.blued.android.module_share_china.R;

public class PopMenuFromBottom extends PopMenu {
  private Float h = Float.valueOf(0.5F);
  
  public PopMenuFromBottom(Context paramContext, View paramView) {
    super(paramContext, paramView);
  }
  
  public void a(View paramView) {
    if (this.d instanceof FragmentActivity && ((FragmentActivity)this.d).getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED)
      return; 
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.e.isShowing())
      this.e.a(); 
    PopMenu.MyPopupWindow myPopupWindow = this.e;
    View view = paramView;
    if (paramView == null)
      view = this.b; 
    myPopupWindow.showAtLocation(view, 81, 0, 0);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, this.h.floatValue());
    alphaAnimation.setDuration(400L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.setVisibility(0);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.pop_down_in));
  }
  
  public RelativeLayout.LayoutParams b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams.addRule(12);
    return layoutParams;
  }
  
  public int c() {
    return 0;
  }
  
  public void d() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(this.h.floatValue(), 0.0F);
    alphaAnimation.setDuration(200L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.setVisibility(8);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.pop_down_out));
    AppInfo.n().postDelayed(new -$$Lambda$PopMenuFromBottom$IK6A8-otKZI1uiQf1nO_j7GTL-8(this), 320L);
  }
  
  public void e() {
    a((View)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\PopMenuFromBottom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */