package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFunctionModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class LiveFunctionAdapter extends BaseMultiItemQuickAdapter<LiveFunctionModel, BaseViewHolder> {
  private Context a;
  
  public LiveFunctionAdapter(Context paramContext) {
    super(new ArrayList());
    this.a = paramContext;
    b(0, R.layout.live_multi_function_item_type_normal);
    b(1, R.layout.live_multi_function_item_type_top_card);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, LiveFunctionModel paramLiveFunctionModel) {
    ((ImageView)paramBaseViewHolder.d(R.id.iv_icon)).setImageResource(paramLiveFunctionModel.icon);
    ((TextView)paramBaseViewHolder.d(R.id.tv_name)).setText(paramLiveFunctionModel.name);
    View view = paramBaseViewHolder.d(R.id.tv_dot);
    if (paramLiveFunctionModel.dot == 0) {
      view.setVisibility(8);
    } else {
      view.setVisibility(0);
    } 
    paramBaseViewHolder.c(R.id.ll_items_view);
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, LiveFunctionModel paramLiveFunctionModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.live_iv_top_card);
    imageView.setImageResource(paramLiveFunctionModel.icon);
    QBadgeContainer qBadgeContainer = (QBadgeContainer)paramBaseViewHolder.d(R.id.ll_top_card_count);
    qBadgeContainer.a((View)imageView);
    qBadgeContainer.d(8388659);
    qBadgeContainer.a(8.0F, true);
    qBadgeContainer.a(paramLiveFunctionModel.count);
    ((TextView)paramBaseViewHolder.d(R.id.tv_top_card_name)).setText(paramLiveFunctionModel.name);
    View view = paramBaseViewHolder.d(R.id.tv_top_card_red_dot);
    if (paramLiveFunctionModel.dot == 0) {
      view.setVisibility(8);
    } else {
      view.setVisibility(0);
    } 
    paramBaseViewHolder.c(R.id.ll_items_view);
  }
  
  public LiveFunctionModel a(int paramInt) {
    List<LiveFunctionModel> list = n();
    if (list == null)
      return null; 
    for (int i = 0; i < list.size(); i++) {
      if (((LiveFunctionModel)list.get(i)).function_type == paramInt)
        return list.get(i); 
    } 
    return null;
  }
  
  public void a(int paramInt, LiveFunctionModel paramLiveFunctionModel) {
    List<LiveFunctionModel> list = n();
    if (list == null)
      return; 
    if (paramInt >= 0 && paramInt < list.size())
      list.add(paramInt, paramLiveFunctionModel); 
    if (paramInt >= list.size())
      list.add(paramLiveFunctionModel); 
    notifyDataSetChanged();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveFunctionModel paramLiveFunctionModel) {
    if (paramBaseViewHolder != null) {
      int i = paramBaseViewHolder.getItemViewType();
      if (i != 0) {
        if (i != 1)
          return; 
        c(paramBaseViewHolder, paramLiveFunctionModel);
        return;
      } 
      b(paramBaseViewHolder, paramLiveFunctionModel);
    } 
  }
  
  public void a(List<LiveFunctionModel> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("models.szie:");
    stringBuilder.append(paramList.size());
    Log.i("==abc", stringBuilder.toString());
    c(paramList);
    c(false);
  }
  
  public LiveFunctionModel b(int paramInt) {
    return (n() == null) ? null : ((paramInt < n().size() && paramInt >= 0) ? n().get(paramInt) : null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveFunctionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */