package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.adapter.BaseGiftAdapter;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.view.GiftHitLoadingView;
import com.blued.android.module.live.base.view.ProgressWheel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.view.BluedGradientStrokeView;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYGiftAdapter extends BaseGiftAdapter<YYGiftModel> {
  public YYGiftAdapter(BaseFragment paramBaseFragment, int paramInt) {
    super(paramBaseFragment.getContext(), paramInt);
  }
  
  private void a(CommonRecycleAdapter.CommonAdapterHolder paramCommonAdapterHolder, YYGiftModel paramYYGiftModel) {
    TextView textView = (TextView)paramCommonAdapterHolder.c(R.id.item_live_gift_price);
    ShapeTextView shapeTextView = (ShapeTextView)paramCommonAdapterHolder.c(R.id.item_live_gift_week_star);
    GiftHitLoadingView giftHitLoadingView = (GiftHitLoadingView)paramCommonAdapterHolder.c(R.id.item_live_gift_hit_loading);
    BluedGradientStrokeView bluedGradientStrokeView = (BluedGradientStrokeView)paramCommonAdapterHolder.c(R.id.select_view);
    CardView cardView = (CardView)paramCommonAdapterHolder.c(R.id.cv_conver);
    if (TextUtils.equals(paramYYGiftModel.is_free, "1")) {
      textView.setText(paramYYGiftModel.getFreeTime());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(CommonStringUtils.a(paramYYGiftModel.beans));
      stringBuilder.append(this.b.getString(R.string.yy_gift_beans));
      textView.setText(stringBuilder.toString());
    } 
    if (paramYYGiftModel.marker != null && !"".equals(paramYYGiftModel.marker)) {
      shapeTextView.setText(paramYYGiftModel.marker);
      shapeTextView.setVisibility(0);
    } else {
      shapeTextView.setVisibility(8);
    } 
    if (paramYYGiftModel.double_hit == 1 && !TextUtils.equals("1", paramYYGiftModel.is_free)) {
      giftHitLoadingView.setVisibility(0);
      if (paramYYGiftModel.comboWaitTime > 0) {
        giftHitLoadingView.a(paramYYGiftModel.comboWaitTime);
      } else {
        giftHitLoadingView.a();
      } 
    } else {
      giftHitLoadingView.setVisibility(8);
    } 
    if (paramYYGiftModel.isSelected) {
      bluedGradientStrokeView.setVisibility(0);
      cardView.setVisibility(0);
      return;
    } 
    bluedGradientStrokeView.setVisibility(8);
    cardView.setVisibility(8);
  }
  
  public int a(int paramInt) {
    return R.layout.item_yy_gift;
  }
  
  public void a(BaseGiftModel paramBaseGiftModel, int paramInt, CommonRecycleAdapter.CommonAdapterHolder paramCommonAdapterHolder) {
    YYGiftModel yYGiftModel = (YYGiftModel)paramBaseGiftModel;
    ImageView imageView = (ImageView)paramCommonAdapterHolder.c(R.id.item_live_gift_view_iv);
    TextView textView = (TextView)paramCommonAdapterHolder.c(R.id.item_live_gift_name);
    ProgressWheel progressWheel = (ProgressWheel)paramCommonAdapterHolder.c(R.id.item_live_gift_progress);
    textView.setText(yYGiftModel.name);
    ImageLoader.a(null, yYGiftModel.images_static).a(R.drawable.gift_default_icon).a(imageView);
    if (yYGiftModel.sendGiftStatus == 1 && !TextUtils.equals("1", yYGiftModel.is_free)) {
      progressWheel.setVisibility(0);
    } else {
      progressWheel.setVisibility(8);
    } 
    Logger.e("yy_gift", new Object[] { "bindViewData ... " });
    LiveEventBus.get("show_gift_item").post(yYGiftModel);
    a(paramCommonAdapterHolder, yYGiftModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYGiftAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */