package com.soft.blued.ui.find.view;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.soft.blued.ui.yy_room.fragment.YYChatRoomsFragment;

public class NearbyChatRoomView extends FrameLayout {
  public TextView a;
  
  public LinearLayout b;
  
  public LinearLayout c;
  
  public View d;
  
  public Context e;
  
  public NearbyChatRoomView(Context paramContext) {
    this(paramContext, null);
  }
  
  public NearbyChatRoomView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NearbyChatRoomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = paramContext;
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.d = LayoutInflater.from(paramContext).inflate(2131493987, (ViewGroup)this);
    this.a = (TextView)this.d.findViewById(2131299364);
    this.b = (LinearLayout)this.d.findViewById(2131299363);
    this.c = (LinearLayout)this.d.findViewById(2131299365);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYChatRoomsFragment.a(this.a.getContext(), "home_chat_room");
          }
        });
  }
  
  public void a() {
    this.d.setBackgroundResource(2131233478);
    ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
    layoutParams.width = DensityUtils.a(this.e, 174.0F);
    this.d.setLayoutParams(layoutParams);
    this.b.setVisibility(0);
    this.c.setVisibility(8);
    Log.v("drb", " -- showLongChatRoom GONE");
  }
  
  public void b() {
    this.d.setBackgroundResource(2131233480);
    ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
    layoutParams.width = DensityUtils.a(this.e, 64.0F);
    this.d.setLayoutParams(layoutParams);
    this.b.setVisibility(8);
    this.c.setVisibility(0);
    Log.v("drb", " -- showShortChatRoom VISIBLE");
  }
  
  public void c() {
    this.d.setBackgroundResource(2131233478);
    this.b.setVisibility(0);
    this.c.setVisibility(8);
    Log.v("drb", " -- openChatRoom GONE");
    new ObjectAnimator();
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { DensityUtils.a(this.e, 64.0F), DensityUtils.a(this.e, 174.0F) });
    valueAnimator.setDuration(100L);
    valueAnimator.setInterpolator((TimeInterpolator)new CubicInterpolator(0.36F, 0.79F, 0.33F, 0.99F));
    valueAnimator.addUpdateListener(new -$$Lambda$NearbyChatRoomView$xoe7K6T2uhhKFOQAOj81XH-R_Uo(this));
    valueAnimator.start();
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(100L);
    this.c.startAnimation((Animation)alphaAnimation);
  }
  
  public void d() {
    this.d.setBackgroundResource(2131233480);
    this.b.setVisibility(8);
    this.c.setVisibility(0);
    Log.v("drb", " -- retractChatRoom VISIBLE");
    new ObjectAnimator();
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { DensityUtils.a(this.e, 174.0F), DensityUtils.a(this.e, 64.0F) });
    valueAnimator.setDuration(100L);
    valueAnimator.setInterpolator((TimeInterpolator)new CubicInterpolator(0.36F, 0.79F, 0.33F, 0.99F));
    valueAnimator.addUpdateListener(new -$$Lambda$NearbyChatRoomView$0AyEweOyoDKj1T0djvpA4CHy4n0(this));
    valueAnimator.start();
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(100L);
    this.c.startAnimation((Animation)alphaAnimation);
  }
  
  public void setText(String paramString) {
    this.a.setText(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\view\NearbyChatRoomView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */