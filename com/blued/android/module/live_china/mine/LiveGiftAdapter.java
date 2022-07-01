package com.blued.android.module.live_china.mine;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.adapter.BaseGiftAdapter;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live.base.view.GiftHitLoadingView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.view.BackgroundTextView;

public class LiveGiftAdapter extends BaseGiftAdapter<LiveGiftModel> {
  private BaseFragment e;
  
  public LiveGiftAdapter(BaseFragment paramBaseFragment, int paramInt) {
    super(paramBaseFragment.getContext(), paramInt);
    this.e = paramBaseFragment;
  }
  
  private void a(View paramView) {
    LogUtils.c("Animation showItemSelectAnim");
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.2F, 0.04F, 0.83F, 0.96F));
    scaleAnimation.setDuration(700L);
    scaleAnimation.setAnimationListener(new Animation.AnimationListener(this, paramView) {
          public void onAnimationEnd(Animation param1Animation) {
            LiveGiftAdapter.a(this.b, this.a);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramView.startAnimation((Animation)scaleAnimation);
  }
  
  private void a(CommonRecycleAdapter.CommonAdapterHolder paramCommonAdapterHolder, LiveGiftModel paramLiveGiftModel) {
    int i = R.id.item_live_gift_price;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(CommonStringUtils.d(String.valueOf(paramLiveGiftModel.beans)));
    stringBuilder.append(this.b.getString(R.string.live_gift_bean));
    stringBuilder.append("/");
    stringBuilder.append(paramLiveGiftModel.expire);
    stringBuilder.append(this.b.getString(R.string.live_days));
    paramCommonAdapterHolder.a(i, stringBuilder.toString());
    if (paramLiveGiftModel.is_my == 1) {
      TextView textView = (TextView)paramCommonAdapterHolder.c(R.id.item_live_gift_effect_state);
      textView.setVisibility(0);
      paramCommonAdapterHolder.b(R.id.expiry_date_view, 0);
      paramCommonAdapterHolder.a(R.id.expiry_date_view, LiveTimeAndDateUtils.a(this.b, LiveTimeAndDateUtils.a(paramLiveGiftModel.expire_time)));
      paramCommonAdapterHolder.b(R.id.use_stage_mount, 8);
      if (paramLiveGiftModel.is_use == 1) {
        textView.setBackgroundResource(R.drawable.shape_common_round_orange_effect_gift);
        textView.setTextColor(Color.parseColor("#ffb02b"));
        textView.setText(this.b.getString(R.string.equipped));
        return;
      } 
      textView.setBackgroundResource(R.drawable.shape_common_round_white_effect_gift);
      textView.setTextColor(-1);
      textView.setText(this.b.getString(R.string.equippable));
      return;
    } 
    paramCommonAdapterHolder.b(R.id.item_live_gift_effect_state, 8);
    paramCommonAdapterHolder.b(R.id.expiry_date_view, 8);
    paramCommonAdapterHolder.b(R.id.use_stage_mount, 0);
    paramCommonAdapterHolder.a(R.id.use_stage_mount, this.b.getString(R.string.approach_mounts));
  }
  
  private void b(View paramView) {
    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.2F, 0.04F, 0.83F, 0.96F));
    scaleAnimation.setDuration(700L);
    scaleAnimation.setAnimationListener(new Animation.AnimationListener(this, paramView) {
          public void onAnimationEnd(Animation param1Animation) {
            LiveGiftAdapter.b(this.b, this.a);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramView.startAnimation((Animation)scaleAnimation);
  }
  
  private void b(CommonRecycleAdapter.CommonAdapterHolder paramCommonAdapterHolder, LiveGiftModel paramLiveGiftModel) {
    StringBuilder stringBuilder;
    if (paramLiveGiftModel.is_task == 1) {
      paramCommonAdapterHolder.a(R.id.item_live_gift_price, "任务专属");
    } else {
      int i = R.id.item_live_gift_price;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(CommonStringUtils.d(String.valueOf(paramLiveGiftModel.beans)));
      stringBuilder1.append(this.b.getString(R.string.live_gift_beans));
      paramCommonAdapterHolder.a(i, stringBuilder1.toString());
    } 
    paramCommonAdapterHolder.b(R.id.item_live_gift_week_star, 0);
    if (paramLiveGiftModel.is_fans_goods == 1) {
      paramCommonAdapterHolder.d(R.id.item_live_gift_week_star, R.drawable.live_fans_gift);
    } else if (paramLiveGiftModel.exclusive_icon == 1) {
      paramCommonAdapterHolder.d(R.id.item_live_gift_week_star, R.drawable.live_exclusive);
    } else if (paramLiveGiftModel.event_type == 1) {
      paramCommonAdapterHolder.d(R.id.item_live_gift_week_star, R.drawable.live_week_star_icon);
    } else {
      paramCommonAdapterHolder.b(R.id.item_live_gift_week_star, 8);
    } 
    GiftHitLoadingView giftHitLoadingView = (GiftHitLoadingView)paramCommonAdapterHolder.c(R.id.item_live_gift_hit_loading);
    if (paramLiveGiftModel.double_hit == 1) {
      giftHitLoadingView.setVisibility(0);
      if (paramLiveGiftModel.comboWaitTime > 0) {
        giftHitLoadingView.a(paramLiveGiftModel.comboWaitTime);
      } else {
        giftHitLoadingView.a();
      } 
    } else {
      giftHitLoadingView.setVisibility(8);
    } 
    ImageView imageView = (ImageView)paramCommonAdapterHolder.c(R.id.item_live_gift_state);
    if (paramLiveGiftModel.availability == -1) {
      imageView.setVisibility(0);
      imageView.setImageResource(R.drawable.upcoming_sale_icon);
    } else if (paramLiveGiftModel.count != 0) {
      imageView.setVisibility(8);
    } else if (paramLiveGiftModel.user_store_count > 0) {
      imageView.setVisibility(8);
    } else {
      imageView.setVisibility(0);
      imageView.setImageResource(R.drawable.sold_out_icon);
    } 
    BackgroundTextView backgroundTextView1 = (BackgroundTextView)paramCommonAdapterHolder.c(R.id.item_live_gift_inventory);
    if (paramLiveGiftModel.user_store_count == 0) {
      backgroundTextView1.setVisibility(8);
    } else {
      backgroundTextView1.setVisibility(0);
    } 
    if (paramLiveGiftModel.user_store_count > 1000000) {
      backgroundTextView1.setBadgeCount("100W+");
    } else if (paramLiveGiftModel.user_store_count == 1000000) {
      backgroundTextView1.setBadgeCount("100W");
    } else {
      backgroundTextView1.setBadgeCount(paramLiveGiftModel.user_store_count);
    } 
    backgroundTextView1 = (BackgroundTextView)paramCommonAdapterHolder.c(R.id.item_live_gift_level);
    BackgroundTextView backgroundTextView2 = (BackgroundTextView)paramCommonAdapterHolder.c(R.id.item_live_gift_fans_level);
    backgroundTextView1.a(6, Color.parseColor("#f65e4a"));
    if (paramLiveGiftModel.isSelected) {
      paramCommonAdapterHolder.w().setBackground(BluedSkinUtils.b(this.b, R.drawable.shape_live_gift_bg));
      if (paramLiveGiftModel.is_fans_goods == 1) {
        if (paramLiveGiftModel.fans_level > 0) {
          backgroundTextView2.a(6, Color.parseColor("#FF53B3"));
          backgroundTextView2.setVisibility(0);
          stringBuilder = new StringBuilder();
          stringBuilder.append("LV.");
          stringBuilder.append(paramLiveGiftModel.fans_level);
          backgroundTextView2.setBadgeCount(stringBuilder.toString());
        } 
        backgroundTextView1.setVisibility(8);
        return;
      } 
      if (paramLiveGiftModel.level > 0) {
        backgroundTextView1.setVisibility(0);
        stringBuilder = new StringBuilder();
        stringBuilder.append("LV.");
        stringBuilder.append(paramLiveGiftModel.level);
        backgroundTextView1.setBadgeCount(stringBuilder.toString());
      } 
      backgroundTextView2.setVisibility(8);
      return;
    } 
    stringBuilder.w().setBackground(null);
    backgroundTextView1.setVisibility(8);
    backgroundTextView2.setVisibility(8);
  }
  
  public int a(int paramInt) {
    return (this.a == 2) ? R.layout.item_live_effect_gift : R.layout.item_live_gift;
  }
  
  public void a(BaseGiftModel paramBaseGiftModel, int paramInt, CommonRecycleAdapter.CommonAdapterHolder paramCommonAdapterHolder) {
    LiveGiftModel liveGiftModel = (LiveGiftModel)paramBaseGiftModel;
    if (liveGiftModel == null)
      return; 
    paramCommonAdapterHolder.a(R.id.item_live_gift_name, liveGiftModel.name);
    ImageView imageView = (ImageView)paramCommonAdapterHolder.c(R.id.item_live_gift_view_iv);
    ImageLoader.a((IRequestHost)this.e.w_(), liveGiftModel.images_static).a(R.drawable.gift_default_icon).a(imageView);
    if (liveGiftModel.packageTabIndex != 2 && liveGiftModel.isSelected)
      a((View)imageView); 
    if (liveGiftModel.sendGiftStatus == 1) {
      paramCommonAdapterHolder.b(R.id.item_live_gift_progress, 0);
    } else {
      paramCommonAdapterHolder.b(R.id.item_live_gift_progress, 8);
    } 
    if (this.a == 2) {
      a(paramCommonAdapterHolder, liveGiftModel);
      return;
    } 
    b(paramCommonAdapterHolder, liveGiftModel);
  }
  
  public boolean a(View paramView, BaseGiftModel paramBaseGiftModel, int paramInt) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\mine\LiveGiftAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */