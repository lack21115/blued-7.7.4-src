package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveGiftManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.FirstChargeGift;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LiveChargeDlgFragment extends LiveBaseDialogFragment {
  private ImageView A;
  
  private ImageView B;
  
  private ImageView C;
  
  private ImageView D;
  
  private int E = 0;
  
  private int[] F = new int[2];
  
  private int[] G = new int[2];
  
  private int[] H = new int[2];
  
  private int[] I = new int[2];
  
  private int[] J = new int[2];
  
  private final List<FirstChargeGift.FirstChargeGiftItem> K = new ArrayList<FirstChargeGift.FirstChargeGiftItem>();
  
  private boolean L = false;
  
  private AtomicBoolean M = new AtomicBoolean(false);
  
  private View i;
  
  private View j;
  
  private View k;
  
  private View l;
  
  private View m;
  
  private ImageView n;
  
  private ImageView o;
  
  private ImageView p;
  
  private List<ImageView> q = new ArrayList<ImageView>();
  
  private List<View> r = new ArrayList<View>();
  
  private ImageView s;
  
  private ImageView t;
  
  private ImageView u;
  
  private ImageView v;
  
  private ImageView w;
  
  private View x;
  
  private List<View> y = new ArrayList<View>();
  
  private ImageView z;
  
  private void A() {
    LiveRoomInfo.a().a(getContext(), 8);
  }
  
  private void a(int paramInt) {
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(400L);
    scaleAnimation.setAnimationListener(new Animation.AnimationListener(this, paramInt) {
          public void onAnimationEnd(Animation param1Animation) {
            LiveChargeDlgFragment.b(this.b, this.a);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    ((ImageView)this.q.get(paramInt)).startAnimation((Animation)scaleAnimation);
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2) {
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, paramFloat1 * -1.0F, 1, 0.0F, 1, paramFloat2 * -1.0F);
    translateAnimation.setDuration(420L);
    translateAnimation.setRepeatMode(2);
    translateAnimation.setStartOffset((paramInt2 + 340));
    ((View)this.r.get(paramInt1)).startAnimation((Animation)translateAnimation);
  }
  
  private void a(View paramView, int[] paramArrayOfint) {
    AnimationSet animationSet = new AnimationSet(true);
    TranslateAnimation translateAnimation = new TranslateAnimation(0.0F, (AppInfo.l - DisplayUtil.a(getContext(), 53.0F) - paramArrayOfint[0]), 0.0F, (AppInfo.m - DisplayUtil.a(getContext(), 50.0F) - paramArrayOfint[1]));
    translateAnimation.setDuration(880L);
    translateAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.66F, 0.01F, 0.75F, 0.99F));
    translateAnimation.setAnimationListener(new Animation.AnimationListener(this, paramView) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.setVisibility(8);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            this.a.setVisibility(0);
          }
        });
    animationSet.addAnimation((Animation)translateAnimation);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.1F);
    alphaAnimation.setDuration(880L);
    animationSet.addAnimation((Animation)alphaAnimation);
    paramView.startAnimation((Animation)animationSet);
  }
  
  private void a(PayOption._pay_list param_pay_list) {
    if (param_pay_list == null)
      return; 
    this.M.set(false);
    LiveMsgSendManager.a().b("set isAutoClose false");
    LogUtils.c("set isAutoClose false");
    LiveRoomInfo.a().a((Context)getActivity(), param_pay_list, "LiveFirstCharge");
  }
  
  private void a(FirstChargeGift paramFirstChargeGift) {
    if (paramFirstChargeGift != null) {
      if (this.L)
        return; 
      if (!TypeUtils.a(paramFirstChargeGift.gifts)) {
        this.K.addAll(paramFirstChargeGift.gifts);
        z();
      } 
      if (!TypeUtils.a(paramFirstChargeGift.pay_list))
        for (int i = 0; i < Math.min(paramFirstChargeGift.pay_list.size(), this.y.size()); i++) {
          PayOption._pay_list _pay_list = paramFirstChargeGift.pay_list.get(i);
          TextView textView = (TextView)((View)this.y.get(i)).findViewById(R.id.item_live_charge_pay_bean_num);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(CommonStringUtils.a(_pay_list.money * _pay_list.ratio));
          stringBuilder.append(getString(R.string.Live_SendPresent_wandou));
          textView.setText(stringBuilder.toString());
          textView = (TextView)((View)this.y.get(i)).findViewById(R.id.item_live_charge_pay_bean_money);
          stringBuilder = new StringBuilder();
          stringBuilder.append(CommonStringUtils.a(_pay_list.money));
          stringBuilder.append(getString(R.string.Live_SendPresent_RMB));
          textView.setText(stringBuilder.toString());
          ((View)this.y.get(i)).setOnClickListener(new -$$Lambda$LiveChargeDlgFragment$kpl_tUO0_2IlbumfMA7tYbJvDlk(this, _pay_list));
        }  
      a(new -$$Lambda$LiveChargeDlgFragment$alb1_7vu1nEfS4lV12KySBzwAxQ(this), 200L);
    } 
  }
  
  private void a(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBoolean);
    stringBuilder.append(", from:");
    stringBuilder.append(this.E);
    LogUtils.c(stringBuilder.toString());
    if (paramBoolean) {
      LiveDataManager.a().a("live_gift");
      LiveDataManager.a().c("");
      LiveGiftManager.a().a(false);
      a(new -$$Lambda$LiveChargeDlgFragment$q20WSCCrJRmdfgacQj_vm33-h4I(this), 300L);
    } 
  }
  
  private void b(int paramInt) {
    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(400L);
    scaleAnimation.setAnimationListener(new Animation.AnimationListener(this, paramInt) {
          public void onAnimationEnd(Animation param1Animation) {
            LiveChargeDlgFragment.a(this.b, this.a);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    ((ImageView)this.q.get(paramInt)).startAnimation((Animation)scaleAnimation);
  }
  
  private void j() {
    this.n.setOnClickListener(new -$$Lambda$LiveChargeDlgFragment$wEGjEsvTcSsjS42pJ6sn86em2ao(this));
    this.b.findViewById(R.id.live_charge_success_close).setOnClickListener(new -$$Lambda$LiveChargeDlgFragment$dZM0PbkIe0YltxfwdHqXPJC_Vng(this));
    this.b.findViewById(R.id.live_charge_success_confirm).setOnClickListener(new -$$Lambda$LiveChargeDlgFragment$LvHTuW8nU9Y_cFSb5z1bdHckXC8(this));
    this.b.findViewById(R.id.live_charge_more_layout).setOnClickListener(new -$$Lambda$LiveChargeDlgFragment$cUf7tDGhES5yKgkyxXbAL6BIu3A(this));
    this.b.setOnClickListener(new -$$Lambda$LiveChargeDlgFragment$djMwenpmLOVWLHsW3lgJinL3IT4(this));
    LiveEventBus.get(LiveEventBusUtil.d, Boolean.class).observe((LifecycleOwner)this, new -$$Lambda$LiveChargeDlgFragment$73VVAWubbgXGmbTIdIx4FrrXuPo(this));
    LiveEventBus.get(LiveEventBusUtil.f, FirstChargeGift.class).observe((LifecycleOwner)this, new -$$Lambda$LiveChargeDlgFragment$9M8s4lGk6Jycp7qLm-V4f0HUGfA(this));
  }
  
  private void k() {
    if (!this.L)
      dismissAllowingStateLoss(); 
  }
  
  private void l() {
    this.L = true;
    this.k.setVisibility(4);
    this.n.setVisibility(4);
    this.m.setVisibility(4);
    this.j.setVisibility(0);
    this.s.setVisibility(8);
    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(60L);
    animationSet.addAnimation((Animation)alphaAnimation);
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.05F);
    translateAnimation.setDuration(240L);
    animationSet.addAnimation((Animation)translateAnimation);
    translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.05F, 1, 0.0F);
    translateAnimation.setDuration(120L);
    translateAnimation.setStartOffset(240L);
    animationSet.addAnimation((Animation)translateAnimation);
    this.j.startAnimation((Animation)animationSet);
    m();
  }
  
  private void m() {
    AnimationSet animationSet = new AnimationSet(true);
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -0.04F);
    translateAnimation.setDuration(120L);
    animationSet.addAnimation((Animation)translateAnimation);
    translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.04F, 1, 0.0F);
    translateAnimation.setDuration(90L);
    translateAnimation.setStartOffset(120L);
    animationSet.addAnimation((Animation)translateAnimation);
    animationSet.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.a(new -$$Lambda$LiveChargeDlgFragment$1$dASv55Ar12bxpI8M6skB4kHR0I4(this), 90L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    animationSet.setStartOffset(240L);
    this.l.startAnimation((Animation)animationSet);
  }
  
  private void n() {
    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(90L);
    animationSet.addAnimation((Animation)alphaAnimation);
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    translateAnimation.setDuration(210L);
    animationSet.addAnimation((Animation)translateAnimation);
    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8F, 1.1F, 0.8F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(210L);
    scaleAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            LiveChargeDlgFragment.c(this.a).setVisibility(0);
            LiveChargeDlgFragment.d(this.a).setVisibility(0);
            LiveChargeDlgFragment.e(this.a).setVisibility(0);
            LiveChargeDlgFragment.f(this.a);
            LiveChargeDlgFragment.g(this.a);
            LiveChargeDlgFragment.h(this.a);
            LiveChargeDlgFragment.i(this.a);
            this.a.a(new -$$Lambda$LiveChargeDlgFragment$2$odf5YXbfWt2ODp2Xj9MWz1PfRCk(this), 1300L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            LiveChargeDlgFragment.b(this.a).setVisibility(0);
            LiveChargeDlgFragment.c(this.a).setVisibility(4);
            LiveChargeDlgFragment.d(this.a).setVisibility(4);
            LiveChargeDlgFragment.e(this.a).setVisibility(4);
          }
        });
    animationSet.addAnimation((Animation)scaleAnimation);
    scaleAnimation = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(210L);
    scaleAnimation.setStartOffset(210L);
    animationSet.addAnimation((Animation)scaleAnimation);
    this.k.startAnimation((Animation)animationSet);
    r();
  }
  
  private void o() {
    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(210L);
    animationSet.addAnimation((Animation)alphaAnimation);
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.61F, 1, 0.0F, 1, 1.68F, 1, 0.0F);
    translateAnimation.setDuration(210L);
    animationSet.addAnimation((Animation)translateAnimation);
    this.u.startAnimation((Animation)animationSet);
  }
  
  private void p() {
    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(330L);
    animationSet.addAnimation((Animation)alphaAnimation);
    TranslateAnimation translateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.1F, 1, 0.0F, 1, 0.0F);
    translateAnimation.setDuration(210L);
    animationSet.addAnimation((Animation)translateAnimation);
    translateAnimation = new TranslateAnimation(1, 0.1F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    translateAnimation.setDuration(120L);
    translateAnimation.setStartOffset(210L);
    animationSet.addAnimation((Animation)translateAnimation);
    this.v.startAnimation((Animation)animationSet);
  }
  
  private void q() {
    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(330L);
    animationSet.addAnimation((Animation)alphaAnimation);
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.5F, 1, -0.11F, 1, 0.0F, 1, 0.0F);
    translateAnimation.setDuration(210L);
    animationSet.addAnimation((Animation)translateAnimation);
    translateAnimation = new TranslateAnimation(1, -0.11F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
    translateAnimation.setDuration(120L);
    translateAnimation.setStartOffset(210L);
    animationSet.addAnimation((Animation)translateAnimation);
    this.w.startAnimation((Animation)animationSet);
  }
  
  private void r() {
    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(90L);
    animationSet.addAnimation((Animation)alphaAnimation);
    RotateAnimation rotateAnimation1 = new RotateAnimation(0.0F, 15.0F, 1, 1.0F, 1, 1.0F);
    rotateAnimation1.setDuration(90L);
    rotateAnimation1.setStartOffset(90L);
    rotateAnimation1.setFillAfter(true);
    animationSet.addAnimation((Animation)rotateAnimation1);
    RotateAnimation rotateAnimation2 = new RotateAnimation(15.0F, 0.0F, 1, 1.0F, 1, 1.0F);
    rotateAnimation2.setDuration(210L);
    rotateAnimation1.setStartOffset(210L);
    animationSet.addAnimation((Animation)rotateAnimation2);
    this.t.startAnimation((Animation)animationSet);
  }
  
  private void s() {
    a(0, 0, 0.06F, 0.1F);
    a(1, 60, 0.02F, 0.1F);
    a(2, 120, -0.02F, 0.1F);
    a(3, 180, -0.06F, 0.1F);
  }
  
  private void t() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(240L);
    alphaAnimation.setStartOffset(30L);
    this.m.startAnimation((Animation)alphaAnimation);
    this.m.setVisibility(0);
    u();
  }
  
  private void u() {
    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation2.setDuration(120L);
    animationSet.addAnimation((Animation)alphaAnimation2);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.7F, 1.0F, 1.7F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(330L);
    animationSet.addAnimation((Animation)scaleAnimation);
    RotateAnimation rotateAnimation = new RotateAnimation(0.0F, -9.0F, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setDuration(120L);
    rotateAnimation.setStartOffset(450L);
    animationSet.addAnimation((Animation)rotateAnimation);
    rotateAnimation = new RotateAnimation(-9.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setDuration(120L);
    rotateAnimation.setStartOffset(570L);
    animationSet.addAnimation((Animation)rotateAnimation);
    rotateAnimation = new RotateAnimation(0.0F, -9.0F, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setDuration(120L);
    rotateAnimation.setStartOffset(690L);
    animationSet.addAnimation((Animation)rotateAnimation);
    rotateAnimation = new RotateAnimation(-9.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    rotateAnimation.setDuration(120L);
    rotateAnimation.setStartOffset(810L);
    animationSet.addAnimation((Animation)rotateAnimation);
    AlphaAnimation alphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation1.setDuration(390L);
    alphaAnimation1.setStartOffset(1420L);
    alphaAnimation1.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            LogUtils.c("ShowHandAnim end");
            LiveChargeDlgFragment.k(this.a).setVisibility(8);
            ImageView imageView = LiveChargeDlgFragment.l(this.a);
            int i = 0;
            imageView.setVisibility(0);
            LiveChargeDlgFragment.a(this.a, false);
            while (i < LiveChargeDlgFragment.m(this.a).size()) {
              LiveChargeDlgFragment.a(this.a, i);
              i++;
            } 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            LiveChargeDlgFragment.k(this.a).setVisibility(0);
          }
        });
    animationSet.addAnimation((Animation)alphaAnimation1);
    this.s.startAnimation((Animation)animationSet);
    a(new -$$Lambda$LiveChargeDlgFragment$zF1Am45BOsxTi6Moy_JFEHV97Yc(this), 450L);
  }
  
  private void v() {
    AnimationSet animationSet = new AnimationSet(true);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(120L);
    scaleAnimation.setFillEnabled(true);
    scaleAnimation.setFillBefore(true);
    scaleAnimation.setFillAfter(false);
    animationSet.addAnimation((Animation)scaleAnimation);
    scaleAnimation = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(120L);
    scaleAnimation.setStartOffset(120L);
    animationSet.addAnimation((Animation)scaleAnimation);
    scaleAnimation = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(120L);
    scaleAnimation.setStartOffset(240L);
    animationSet.addAnimation((Animation)scaleAnimation);
    scaleAnimation = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(120L);
    scaleAnimation.setStartOffset(360L);
    scaleAnimation.setFillEnabled(true);
    scaleAnimation.setFillBefore(false);
    scaleAnimation.setFillAfter(true);
    animationSet.addAnimation((Animation)scaleAnimation);
    ((View)this.y.get(2)).startAnimation((Animation)animationSet);
  }
  
  private void w() {
    if (this.E == 1) {
      this.M.set(true);
      LogUtils.c("set isAutoClose true");
      LiveMsgSendManager.a().b("set isAutoClose true");
      a(new -$$Lambda$LiveChargeDlgFragment$X2LXmKei-ocXAiO9P0z7-1sjYtU(this), 8000L);
    } 
  }
  
  private void x() {
    ((View)this.r.get(0)).getLocationInWindow(this.F);
    ((View)this.r.get(1)).getLocationInWindow(this.G);
    ((View)this.r.get(2)).getLocationInWindow(this.H);
    ((View)this.r.get(3)).getLocationInWindow(this.I);
    this.D.getLocationInWindow(this.J);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.z.getLayoutParams();
    int[] arrayOfInt = this.F;
    layoutParams.leftMargin = arrayOfInt[0];
    layoutParams.topMargin = arrayOfInt[1];
    this.z.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.A.getLayoutParams();
    arrayOfInt = this.G;
    layoutParams.leftMargin = arrayOfInt[0];
    layoutParams.topMargin = arrayOfInt[1];
    this.A.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.B.getLayoutParams();
    arrayOfInt = this.H;
    layoutParams.leftMargin = arrayOfInt[0];
    layoutParams.topMargin = arrayOfInt[1];
    this.B.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.C.getLayoutParams();
    arrayOfInt = this.I;
    layoutParams.leftMargin = arrayOfInt[0];
    layoutParams.topMargin = arrayOfInt[1];
    this.C.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(120L);
    animationSet.addAnimation((Animation)alphaAnimation);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setDuration(120L);
    scaleAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            LiveChargeDlgFragment.n(this.a).setVisibility(8);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    animationSet.addAnimation((Animation)scaleAnimation);
    this.j.startAnimation((Animation)animationSet);
    a((View)this.z, this.F);
    a((View)this.A, this.G);
    a((View)this.B, this.H);
    a((View)this.C, this.I);
    a(new -$$Lambda$LiveChargeDlgFragment$bRY-BRGAPL3Kfv1r75yAF60QfcI(this), 800L);
  }
  
  private void y() {
    this.D.setVisibility(0);
    AnimationSet animationSet = new AnimationSet(true);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.85F, 1, 0.0F, 1, 1.0F);
    scaleAnimation.setFillEnabled(true);
    scaleAnimation.setFillBefore(true);
    scaleAnimation.setFillAfter(false);
    scaleAnimation.setDuration(200L);
    scaleAnimation.setStartOffset(200L);
    animationSet.addAnimation((Animation)scaleAnimation);
    scaleAnimation = new ScaleAnimation(1.0F, 1.0F, 0.85F, 1.0F, 1, 0.0F, 1, 1.0F);
    scaleAnimation.setDuration(180L);
    scaleAnimation.setStartOffset(400L);
    animationSet.addAnimation((Animation)scaleAnimation);
    scaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.95F, 1, 0.0F, 1, 1.0F);
    scaleAnimation.setDuration(160L);
    scaleAnimation.setStartOffset(580L);
    animationSet.addAnimation((Animation)scaleAnimation);
    scaleAnimation = new ScaleAnimation(1.0F, 1.0F, 0.95F, 1.0F, 1, 0.0F, 1, 1.0F);
    scaleAnimation.setDuration(120L);
    scaleAnimation.setStartOffset(740L);
    scaleAnimation.setFillEnabled(true);
    scaleAnimation.setFillBefore(false);
    scaleAnimation.setFillAfter(true);
    animationSet.addAnimation((Animation)scaleAnimation);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    alphaAnimation.setDuration(200L);
    animationSet.addAnimation((Animation)alphaAnimation);
    animationSet.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.a(new -$$Lambda$LiveChargeDlgFragment$8$ZRwIANsO4UB_G76YXVdLM34M8pU(this), 200L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.D.startAnimation((Animation)animationSet);
  }
  
  private void z() {
    for (int i = 0; i < Math.min(this.r.size(), this.K.size()); i++) {
      FirstChargeGift.FirstChargeGiftItem firstChargeGiftItem = this.K.get(i);
      TextView textView = (TextView)((View)this.r.get(i)).findViewById(R.id.live_charge_gift_name);
      ImageView imageView2 = (ImageView)((View)this.r.get(i)).findViewById(R.id.live_charge_gift_icon);
      if (firstChargeGiftItem.price > 0) {
        textView.setText(String.valueOf(firstChargeGiftItem.price));
        imageView2.setVisibility(0);
      } else {
        textView.setText(firstChargeGiftItem.title);
        textView.setTextColor(Color.parseColor("#5745FC"));
        imageView2.setVisibility(8);
      } 
      textView = (TextView)((View)this.r.get(i)).findViewById(R.id.live_charge_gift_count);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("x");
      stringBuilder.append(firstChargeGiftItem.amount);
      textView.setText(stringBuilder.toString());
      ImageView imageView1 = (ImageView)((View)this.r.get(i)).findViewById(R.id.live_charge_gift_iv);
      ImageLoader.a((IRequestHost)a(), firstChargeGiftItem.image).a(R.drawable.defaultpicture).a(imageView1);
    } 
    if (this.K.size() > 0)
      ImageLoader.a((IRequestHost)a(), ((FirstChargeGift.FirstChargeGiftItem)this.K.get(0)).image).a(this.z); 
    if (this.K.size() > 1)
      ImageLoader.a((IRequestHost)a(), ((FirstChargeGift.FirstChargeGiftItem)this.K.get(1)).image).a(this.A); 
    if (this.K.size() > 2)
      ImageLoader.a((IRequestHost)a(), ((FirstChargeGift.FirstChargeGiftItem)this.K.get(2)).image).a(this.B); 
    if (this.K.size() > 3)
      ImageLoader.a((IRequestHost)a(), ((FirstChargeGift.FirstChargeGiftItem)this.K.get(3)).image).a(this.C); 
  }
  
  public boolean V_() {
    if (this.E == 1) {
      k();
      return true;
    } 
    return false;
  }
  
  public int f() {
    return R.layout.fragment_live_charge;
  }
  
  public void g() {
    this.i = this.b.findViewById(R.id.live_charge_mask_view);
    this.j = this.b.findViewById(R.id.live_charge_content_layout);
    this.k = this.b.findViewById(R.id.live_charge_title_layout);
    this.l = this.b.findViewById(R.id.live_charge_middle_layout);
    this.m = this.b.findViewById(R.id.live_charge_price_layout);
    this.n = (ImageView)this.b.findViewById(R.id.live_charge_close);
    this.o = (ImageView)this.b.findViewById(R.id.live_charge_title_iv);
    this.p = (ImageView)this.b.findViewById(R.id.live_charge_title_bg_iv);
    View view1 = this.b.findViewById(R.id.live_charge_gift_one_layout);
    View view2 = this.b.findViewById(R.id.live_charge_gift_two_layout);
    View view3 = this.b.findViewById(R.id.live_charge_gift_three_layout);
    View view4 = this.b.findViewById(R.id.live_charge_gift_four_layout);
    this.r.add(view1);
    this.r.add(view2);
    this.r.add(view3);
    this.r.add(view4);
    this.q.add(view1.findViewById(R.id.live_charge_gift_iv));
    this.q.add(view2.findViewById(R.id.live_charge_gift_iv));
    this.q.add(view3.findViewById(R.id.live_charge_gift_iv));
    this.q.add(view4.findViewById(R.id.live_charge_gift_iv));
    this.y.add(this.b.findViewById(R.id.item_live_charge_pay_one));
    this.y.add(this.b.findViewById(R.id.item_live_charge_pay_two));
    this.y.add(this.b.findViewById(R.id.item_live_charge_pay_three));
    this.y.add(this.b.findViewById(R.id.item_live_charge_pay_four));
    this.s = (ImageView)this.b.findViewById(R.id.live_charge_hand_iv);
    this.t = (ImageView)this.b.findViewById(R.id.live_charge_limit_time_iv);
    this.u = (ImageView)this.b.findViewById(R.id.live_charge_gold_iv);
    this.v = (ImageView)this.b.findViewById(R.id.live_charge_yio_iv);
    this.w = (ImageView)this.b.findViewById(R.id.live_charge_gift_iv);
    this.z = (ImageView)this.b.findViewById(R.id.live_charge_gift_anim_one_iv);
    this.A = (ImageView)this.b.findViewById(R.id.live_charge_gift_anim_two_iv);
    this.B = (ImageView)this.b.findViewById(R.id.live_charge_gift_anim_three_iv);
    this.C = (ImageView)this.b.findViewById(R.id.live_charge_gift_anim_four_iv);
    this.D = (ImageView)this.b.findViewById(R.id.live_charge_gift_bag_iv);
    this.j.setVisibility(4);
    this.x = this.b.findViewById(R.id.live_charge_success_layout);
    this.x.setVisibility(8);
  }
  
  public void h() {
    this.E = this.c.getInt("from");
  }
  
  public void i() {
    if (LiveRoomManager.a().z() == null || TypeUtils.a((LiveRoomManager.a().z()).pay_list)) {
      LiveRoomHttpUtils.h(new BluedUIHttpResponse<BluedEntityA<FirstChargeGift>>(this, (IRequestHost)a()) {
            protected void a(BluedEntityA<FirstChargeGift> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
                LiveRoomManager.a().a((FirstChargeGift)param1BluedEntityA.getSingleData());
                LiveChargeDlgFragment.a(this.a, (FirstChargeGift)param1BluedEntityA.getSingleData());
                return;
              } 
              this.a.dismissAllowingStateLoss();
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              this.a.dismissAllowingStateLoss();
              return super.onUIFailure(param1Int, param1String);
            }
          }(IRequestHost)a());
      return;
    } 
    a(LiveRoomManager.a().z());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    j();
    i();
    w();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveChargeDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */