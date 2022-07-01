package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYEmojiModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class YYEmojiAdapter extends BaseQuickAdapter<YYEmojiModel, BaseViewHolder> {
  private IRequestHost a;
  
  public YYEmojiAdapter(IRequestHost paramIRequestHost) {
    super(R.layout.item_yy_expression_layout);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYEmojiModel paramYYEmojiModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_image);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_name);
    ImageLoader.a(this.a, paramYYEmojiModel.pic).a(R.drawable.icon_finger_guessing).a(imageView);
    textView.setText(paramYYEmojiModel.name);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYEmojiAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */