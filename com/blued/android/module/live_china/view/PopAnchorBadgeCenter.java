package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;

public class PopAnchorBadgeCenter extends PopAnchorBadge {
  public PopAnchorBadgeCenter(Context paramContext, String paramString, IRequestHost paramIRequestHost, PopAnchorBadge.DismissLisnter paramDismissLisnter) {
    super(paramContext, paramString, paramIRequestHost, paramDismissLisnter);
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3, PopAnchorBadge.DismissLisnter paramDismissLisnter, IRequestHost paramIRequestHost) {
    (new PopAnchorBadgeCenter(paramContext, paramString2, paramIRequestHost, paramDismissLisnter)).a(paramString3, paramString1);
  }
  
  public void a() {
    this.a = this.e.inflate(R.layout.anchor_badge_center, null);
  }
  
  public View b() {
    return this.e.inflate(R.layout.item_anchor_badge_center, null);
  }
  
  public void c() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.d();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.b.startAnimation((Animation)alphaAnimation);
  }
  
  public void f() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopAnchorBadgeCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */