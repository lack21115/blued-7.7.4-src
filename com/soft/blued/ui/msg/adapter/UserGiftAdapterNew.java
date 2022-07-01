package com.soft.blued.ui.msg.adapter;

import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg.customview.GiftGivingOptionViewNew;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.util.List;

public class UserGiftAdapterNew extends BaseQuickAdapter<GiftGivingOptionForJsonParse, BaseViewHolder> {
  public int a = 2;
  
  private IRequestHost b;
  
  public UserGiftAdapterNew(IRequestHost paramIRequestHost, List<GiftGivingOptionForJsonParse> paramList) {
    super(2131493630, paramList);
    this.b = paramIRequestHost;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse) {
    GiftGivingOptionViewNew giftGivingOptionViewNew = (GiftGivingOptionViewNew)paramBaseViewHolder.d(2131297239);
    giftGivingOptionViewNew.a = this.a;
    giftGivingOptionViewNew.a(this.b, paramGiftGivingOptionForJsonParse, paramGiftGivingOptionForJsonParse.chosen);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\UserGiftAdapterNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */