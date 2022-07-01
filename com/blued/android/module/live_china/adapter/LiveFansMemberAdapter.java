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
import java.util.List;

public class LiveFansMemberAdapter extends BaseQuickAdapter<LiveFansMemberModel, BaseViewHolder> {
  private Context a;
  
  public LiveFansMemberAdapter(Context paramContext) {
    super(R.layout.live_fans_member_item_view, null);
    this.a = paramContext;
  }
  
  public int a() {
    return (n() != null) ? n().size() : 0;
  }
  
  public LiveFansMemberModel a(int paramInt) {
    return (n() == null) ? null : ((paramInt < n().size() && paramInt >= 0) ? n().get(paramInt) : null);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, LiveFansMemberModel paramLiveFansMemberModel) {
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.tv_level);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(R.id.iv_level);
    if (paramLiveFansMemberModel.position == 0) {
      textView2.setVisibility(8);
      imageView3.setVisibility(0);
      imageView3.setImageResource(R.drawable.live_fans_top_one);
    } else if (paramLiveFansMemberModel.position == 1) {
      textView2.setVisibility(8);
      imageView3.setVisibility(0);
      imageView3.setImageResource(R.drawable.live_fans_top_two);
    } else if (paramLiveFansMemberModel.position == 2) {
      textView2.setVisibility(8);
      imageView3.setVisibility(0);
      imageView3.setImageResource(R.drawable.live_fans_top_three);
    } else {
      textView2.setVisibility(0);
      imageView3.setVisibility(8);
      if (paramLiveFansMemberModel.position < 9) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("0");
        stringBuilder1.append(paramLiveFansMemberModel.position + 1);
        textView2.setText(stringBuilder1.toString());
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("");
        stringBuilder1.append(paramLiveFansMemberModel.position + 1);
        textView2.setText(stringBuilder1.toString());
      } 
    } 
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(R.id.avatar);
    ImageLoader.a(null, paramLiveFansMemberModel.avatar).a(R.drawable.user_bg_round).c().a(imageView1);
    ((TextView)paramBaseViewHolder.d(R.id.tv_name)).setText(paramLiveFansMemberModel.fans_name);
    ((TextView)paramBaseViewHolder.d(R.id.tv_num)).setText(String.format(this.a.getString(R.string.live_fans_relation), new Object[] { Integer.valueOf(paramLiveFansMemberModel.relation) }));
    ((TextView)paramBaseViewHolder.d(R.id.tv_fans_name)).setText(paramLiveFansMemberModel.name);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.tv_level_num);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLiveFansMemberModel.level);
    stringBuilder.append("");
    textView1.setText(stringBuilder.toString());
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveFansMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */