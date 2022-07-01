package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.GiftHitListener;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;

public class GiftBaseHitView extends LinearLayout {
  private String a = GiftBaseHitView.class.getSimpleName();
  
  private View b;
  
  private ImageView c;
  
  private ShapeTextView d;
  
  private TextView e;
  
  private TextView f;
  
  private ImageView g;
  
  private LinearLayout h;
  
  private TextView i;
  
  private GiftHitListener j;
  
  private YYImModel k;
  
  private YYMsgGiftExtra l;
  
  private int m;
  
  private int n;
  
  private boolean o = false;
  
  private Runnable p = new Runnable(this) {
      public void run() {
        if (GiftBaseHitView.a(this.a) != null) {
          this.a.setVisibility(8);
          GiftBaseHitView.a(this.a).b(this.a);
        } 
      }
    };
  
  public GiftBaseHitView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public GiftBaseHitView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GiftBaseHitView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.b = LayoutInflater.from(paramContext).inflate(R.layout.item_yy_msg_gift_hit, (ViewGroup)this, true);
    this.c = (ImageView)this.b.findViewById(R.id.iv_user_img);
    this.d = (ShapeTextView)this.b.findViewById(R.id.tv_role);
    this.e = (TextView)this.b.findViewById(R.id.tv_source_name);
    this.f = (TextView)this.b.findViewById(R.id.tv_target_name);
    this.g = (ImageView)this.b.findViewById(R.id.iv_gift);
    this.h = (LinearLayout)this.b.findViewById(R.id.ll_hit);
    this.i = (TextView)this.b.findViewById(R.id.tv_hit_count);
  }
  
  private void b() {
    if (this.k == null) {
      setVisibility(8);
      GiftHitListener giftHitListener = this.j;
      if (giftHitListener != null)
        giftHitListener.b(this); 
      return;
    } 
    setVisibility(0);
    ImageLoader.a(null, this.k.source_profile.getAvatar()).c().a(R.drawable.user_bg_round).a(this.c);
    this.d.setVisibility(0);
    if (TextUtils.equals("2", this.k.source_profile.chat_anchor)) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, R.color.syc_8F38FD);
      this.d.setText(getContext().getResources().getString(R.string.yy_role_manager));
    } else if (TextUtils.equals("1", this.k.source_profile.chat_anchor)) {
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, R.color.syc_3883FD);
      this.d.setText(getContext().getResources().getString(R.string.yy_role_host));
    } else {
      this.d.setVisibility(8);
    } 
    this.e.setText(this.k.source_profile.getName());
    TextView textView = this.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("送给  ");
    stringBuilder.append(this.k.target_profile.getName());
    textView.setText(stringBuilder.toString());
    ImageLoader.a(null, this.l.gift_icon).a(R.drawable.gift_default_icon).a(this.g);
    if (this.m <= 0) {
      this.h.setVisibility(8);
    } else {
      this.h.setVisibility(0);
      textView = this.i;
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.m);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
    } 
    c();
  }
  
  private void c() {
    this.o = true;
    Animation animation = AnimationUtils.loadAnimation(AppInfo.d(), R.anim.live_msg_gift_in_from_left);
    setAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.post(new Runnable(this) {
                  public void run() {
                    if (GiftBaseHitView.b(this.a.a) <= 0 && GiftBaseHitView.a(this.a.a) != null) {
                      GiftBaseHitView.a(this.a.a).a(this.a.a);
                      GiftBaseHitView.c(this.a.a);
                      return;
                    } 
                    GiftBaseHitView.d(this.a.a);
                  }
                });
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  private void d() {
    this.o = true;
    removeCallbacks(this.p);
    TextView textView = this.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.m);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    AnimationSet animationSet = new AnimationSet(false);
    if (this.l.hit_batch == 1 && this.m != this.n) {
      ScaleAnimation scaleAnimation = new ScaleAnimation(1.3F, 1.0F, 1.3F, 1.0F, 1, 0.5F, 1, 0.5F);
      scaleAnimation.setDuration(100L);
      animationSet.addAnimation((Animation)scaleAnimation);
    } else {
      ScaleAnimation scaleAnimation1 = new ScaleAnimation(2.0F, 0.5F, 2.0F, 0.5F, 1, 0.5F, 1, 0.5F);
      ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, 1, 0.5F, 1, 0.5F);
      scaleAnimation1.setDuration(250L);
      scaleAnimation2.setStartOffset(250L);
      scaleAnimation2.setDuration(100L);
      animationSet.addAnimation((Animation)scaleAnimation1);
      animationSet.addAnimation((Animation)scaleAnimation2);
    } 
    animationSet.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.post(new Runnable(this) {
                  public void run() {
                    if (GiftBaseHitView.b(this.a.a) < GiftBaseHitView.e(this.a.a)) {
                      GiftBaseHitView.f(this.a.a);
                      GiftBaseHitView.d(this.a.a);
                      return;
                    } 
                    if (GiftBaseHitView.a(this.a.a) != null) {
                      GiftBaseHitView.a(this.a.a).a(this.a.a);
                      GiftBaseHitView.c(this.a.a);
                    } 
                  }
                });
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.h.startAnimation((Animation)animationSet);
  }
  
  private void e() {
    this.o = false;
    removeCallbacks(this.p);
    postDelayed(this.p, 2000L);
  }
  
  public YYMsgGiftExtra a(String paramString) {
    YYMsgGiftExtra yYMsgGiftExtra = new YYMsgGiftExtra();
    if (paramString != null)
      yYMsgGiftExtra = (YYMsgGiftExtra)AppInfo.f().fromJson(paramString, YYMsgGiftExtra.class); 
    return yYMsgGiftExtra;
  }
  
  public void a() {
    setGiftHitListener((GiftHitListener)null);
    this.n = 0;
  }
  
  public boolean a(YYImModel paramYYImModel) {
    if (this.k != null) {
      YYMsgGiftExtra yYMsgGiftExtra = this.l;
      if (yYMsgGiftExtra != null && yYMsgGiftExtra.hit_batch != 1 && this.l.hit_id == MsgPackHelper.getLongValue(paramYYImModel.msgMapExtra, "hit_id") && TextUtils.equals(paramYYImModel.source_profile.getUid(), this.k.source_profile.getUid()) && TextUtils.equals(paramYYImModel.target_profile.getUid(), this.k.target_profile.getUid()) && this.l.hit_id != 0L) {
        int i = MsgPackHelper.getIntValue(paramYYImModel.msgMapExtra, "hit_count");
        if (i > this.n) {
          this.n = i;
          if (!this.o) {
            this.m++;
            d();
          } 
        } 
        return true;
      } 
    } 
    return false;
  }
  
  public void setGiftHitListener(GiftHitListener paramGiftHitListener) {
    this.j = paramGiftHitListener;
  }
  
  public void setHitModel(YYImModel paramYYImModel) {
    this.k = paramYYImModel;
    this.l = a(paramYYImModel.getMsgExtra());
    if (this.l.hit_batch == 1) {
      this.m = 1;
    } else if (this.l.hit_id == 0L) {
      this.m = 0;
    } else {
      this.m = this.l.hit_count;
    } 
    this.n = this.l.hit_count;
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\GiftBaseHitView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */