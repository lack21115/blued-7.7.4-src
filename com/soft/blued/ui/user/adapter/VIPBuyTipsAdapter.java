package com.soft.blued.ui.user.adapter;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;

public class VIPBuyTipsAdapter extends BaseQuickAdapter<VIPPrivilegeModel, BaseViewHolder> {
  private IRequestHost a;
  
  public VIPBuyTipsAdapter(IRequestHost paramIRequestHost) {
    super(2131493681, null);
    this.a = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, VIPPrivilegeModel paramVIPPrivilegeModel) {
    paramBaseViewHolder.a(2131301703, paramVIPPrivilegeModel.name);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131301704);
    ImageLoader.a(this.a, paramVIPPrivilegeModel.icon).a(2131234356).c().a(imageView);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\VIPBuyTipsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */