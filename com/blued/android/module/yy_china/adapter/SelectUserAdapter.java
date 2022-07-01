package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class SelectUserAdapter extends BaseQuickAdapter<YYSeatMemberModel, BaseViewHolder> {
  public SelectUserAdapter() {
    super(R.layout.item_yy_select_user, new ArrayList());
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYSeatMemberModel paramYYSeatMemberModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_user_img);
    ((TextView)paramBaseViewHolder.d(R.id.tv_user_name)).setText(paramYYSeatMemberModel.getName());
    ImageLoader.a(null, paramYYSeatMemberModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\SelectUserAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */