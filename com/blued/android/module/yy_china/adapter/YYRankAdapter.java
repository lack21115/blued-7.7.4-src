package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.YYRankItemFragment;
import com.blued.android.module.yy_china.model.YYRankModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class YYRankAdapter extends BaseQuickAdapter<YYRankModel, BaseViewHolder> {
  private YYRankItemFragment a;
  
  public YYRankAdapter(YYRankItemFragment paramYYRankItemFragment) {
    super(R.layout.item_yy_rank_layout, new ArrayList());
    this.a = paramYYRankItemFragment;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYRankModel paramYYRankModel) {
    TextView textView3 = (TextView)paramBaseViewHolder.d(R.id.tv_rank);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.tv_wandou);
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.tv_nickname);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_header);
    int i = paramBaseViewHolder.getAdapterPosition();
    if (i == 0) {
      textView3.setTextColor(paramBaseViewHolder.itemView.getContext().getResources().getColor(R.color.syc_00E0AB));
    } else if (i == 1) {
      textView3.setTextColor(paramBaseViewHolder.itemView.getContext().getResources().getColor(R.color.syc_3883FD));
    } else {
      textView3.setTextColor(paramBaseViewHolder.itemView.getContext().getResources().getColor(R.color.syc_dark_b));
    } 
    textView3.setText(String.valueOf(i + 4));
    ImageLoader.a((IRequestHost)this.a.w_(), paramYYRankModel.avatar).a(R.drawable.user_bg_round).a(imageView);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramYYRankModel.beans);
    stringBuilder.append("豌豆");
    textView1.setText(stringBuilder.toString());
    textView2.setText(paramYYRankModel.name);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYRankAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */