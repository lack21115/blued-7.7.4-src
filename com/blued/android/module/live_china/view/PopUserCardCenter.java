package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;

public class PopUserCardCenter extends PopUserCard {
  private PopUserCard.UserCardOnclickListner P;
  
  private IRequestHost Q;
  
  public PopUserCardCenter(Context paramContext, IRequestHost paramIRequestHost, String paramString, Long paramLong, Short paramShort, PopUserCard.UserCardOnclickListner paramUserCardOnclickListner) {
    super(paramContext, paramIRequestHost, paramString, paramLong, paramShort, paramUserCardOnclickListner);
    this.P = paramUserCardOnclickListner;
    this.Q = paramIRequestHost;
  }
  
  public void a(String paramString1, String paramString2) {
    PopAnchorBadgeCenter.b(this.c, paramString2, b(), paramString1, new PopAnchorBadge.DismissLisnter(this) {
          public void a() {
            PopUserCardCenter.a(this.a).a();
          }
          
          public void b() {
            PopUserCardCenter.a(this.a).c();
          }
        },  this.Q);
  }
  
  public void c() {
    this.y = this.d.inflate(R.layout.item_pop_usercard_center, null);
    this.q = (LinearLayout)this.y.findViewById(R.id.ll_userinfo);
    this.q.setBackground(this.c.getResources().getDrawable(R.drawable.shape_usercard_bg_all_radius));
  }
  
  public void o() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.a.startAnimation((Animation)alphaAnimation);
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_out));
  }
  
  public void p() {
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_center_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.n();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.a.startAnimation((Animation)alphaAnimation);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopUserCardCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */