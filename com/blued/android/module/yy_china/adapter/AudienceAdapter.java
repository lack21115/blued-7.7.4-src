package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class AudienceAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {
  private BaseYYStudioFragment a;
  
  public AudienceAdapter(Context paramContext, BaseYYStudioFragment paramBaseYYStudioFragment) {
    super(R.layout.item_audience_layout, new ArrayList());
    this.k = paramContext;
    this.a = paramBaseYYStudioFragment;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYAudienceModel paramYYAudienceModel) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_audience_header);
    ImageLoader.a((IRequestHost)this.a.w_(), paramYYAudienceModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\AudienceAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */