package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class LiveFansRecordMemberAdapter extends BaseQuickAdapter<LiveFansMemberModel, BaseViewHolder> {
  private Context a;
  
  public LiveFansRecordMemberAdapter(Context paramContext) {
    super(R.layout.live_fans_record_member_item_view, new ArrayList());
    this.a = paramContext;
  }
  
  public int a() {
    return (n() != null) ? n().size() : 0;
  }
  
  public LiveFansMemberModel a(int paramInt) {
    return (n() == null) ? null : ((paramInt < n().size() && paramInt >= 0) ? n().get(paramInt) : null);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveFansMemberModel paramLiveFansMemberModel) {
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(R.id.avatar);
    ImageLoader.a(null, paramLiveFansMemberModel.avatar).a(R.drawable.user_bg_round).c().a(imageView1);
    imageView1 = (ImageView)paramBaseViewHolder.d(R.id.iv_fans_new);
    if (paramLiveFansMemberModel.is_new == 1) {
      imageView1.setVisibility(0);
    } else {
      imageView1.setVisibility(8);
    } 
    ((TextView)paramBaseViewHolder.d(R.id.tv_name)).setText(paramLiveFansMemberModel.fans_name);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_num);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLiveFansMemberModel.relation);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    ((TextView)paramBaseViewHolder.d(R.id.tv_fans_name)).setText(paramLiveFansMemberModel.name);
    textView = (TextView)paramBaseViewHolder.d(R.id.tv_level_num);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramLiveFansMemberModel.level);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    View view = paramBaseViewHolder.d(R.id.ll_level);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(R.id.iv_heart);
    if (paramLiveFansMemberModel.brand_status == 1) {
      view.setBackgroundResource(R.drawable.live_fans_level_open_small_bg);
      imageView2.setImageResource(R.drawable.live_fans_level_open_small_heart);
    } else {
      view.setBackgroundResource(R.drawable.live_fans_level_disopen_small_bg);
      imageView2.setImageResource(R.drawable.live_fans_level_disopen_small_heart);
    } 
    paramBaseViewHolder.c(R.id.ll_items_view);
  }
  
  public void a(List<LiveFansMemberModel> paramList) {
    for (int i = 0; i < paramList.size(); i++)
      ((LiveFansMemberModel)paramList.get(i)).position = i; 
    c(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveFansRecordMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */