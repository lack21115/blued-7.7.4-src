package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYSoundModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class YYSoundAdapter extends BaseQuickAdapter<YYSoundModel, BaseViewHolder> {
  private IRequestHost a;
  
  public YYSoundAdapter(IRequestHost paramIRequestHost) {
    super(R.layout.item_yy_expression_layout);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYSoundModel paramYYSoundModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_image);
    TextView textView = (TextView)paramBaseViewHolder.d(R.id.tv_name);
    ImageLoader.a(this.a, paramYYSoundModel.pic).a(R.drawable.icon_finger_guessing).a(imageView);
    textView.setText(paramYYSoundModel.name);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYSoundAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */