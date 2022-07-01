package com.soft.blued.ui.msg.adapter;

import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg.customview.GiftGivingOptionViewNew;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import java.util.List;

public class UserGiftPackageAdapter extends BaseQuickAdapter<UserGiftPackageModel, BaseViewHolder> {
  public int a = 2;
  
  private IRequestHost b;
  
  public UserGiftPackageAdapter(IRequestHost paramIRequestHost, List<UserGiftPackageModel> paramList) {
    super(2131493630, paramList);
    this.b = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, UserGiftPackageModel paramUserGiftPackageModel) {
    GiftGivingOptionViewNew giftGivingOptionViewNew = (GiftGivingOptionViewNew)paramBaseViewHolder.d(2131297239);
    giftGivingOptionViewNew.a = this.a;
    giftGivingOptionViewNew.a(this.b, paramUserGiftPackageModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\UserGiftPackageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */