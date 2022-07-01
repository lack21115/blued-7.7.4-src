package com.soft.blued.ui.msg.adapter;

import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.msg.model.GiftVoucherModel;
import com.soft.blued.utils.TimeAndDateUtils;

public class GiftVoucherAdapter extends BaseQuickAdapter<GiftVoucherModel, BaseViewHolder> {
  public double a;
  
  public GiftVoucherAdapter() {
    super(2131493534);
  }
  
  private boolean a(double paramDouble, GiftVoucherModel paramGiftVoucherModel) {
    return (paramGiftVoucherModel.isExpire || paramGiftVoucherModel.money < paramDouble);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, GiftVoucherModel paramGiftVoucherModel) {
    int i = ContextCompat.getColor(this.k, 2131100842);
    int j = ContextCompat.getColor(this.k, 2131100838);
    int k = ContextCompat.getColor(this.k, 2131100716);
    BaseViewHolder baseViewHolder = paramBaseViewHolder.a(2131301409, paramGiftVoucherModel.title);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((int)paramGiftVoucherModel.money);
    stringBuilder2.append("");
    baseViewHolder.a(2131301046, stringBuilder2.toString());
    if (paramGiftVoucherModel.isExpire) {
      paramBaseViewHolder.a(2131301355, this.k.getString(2131756590));
    } else {
      paramBaseViewHolder.a(2131301355, this.k.getString(2131756550));
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramGiftVoucherModel.start_timestamp);
    stringBuilder1.append("");
    String str1 = TimeAndDateUtils.a(stringBuilder1.toString(), "yyyy.MM.dd");
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramGiftVoucherModel.end_timestamp);
    stringBuilder2.append("");
    String str2 = TimeAndDateUtils.a(stringBuilder2.toString(), "yyyy.MM.dd");
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(this.k.getString(2131758546));
    stringBuilder3.append(":");
    stringBuilder3.append(str1);
    stringBuilder3.append("-");
    stringBuilder3.append(str2);
    paramBaseViewHolder.a(2131300697, stringBuilder3.toString());
    if (a(this.a, paramGiftVoucherModel)) {
      paramBaseViewHolder.f(2131301409, i).f(2131300697, i).f(2131301355, i).f(2131301046, i).f(2131299740, i);
    } else {
      paramBaseViewHolder.f(2131301409, j).f(2131300697, j).f(2131301355, j).f(2131301046, j).f(2131299740, j);
    } 
    if (paramGiftVoucherModel.isChecked) {
      paramBaseViewHolder.f(2131301046, k).f(2131299740, k);
      paramBaseViewHolder.e(2131296768, 2131232308);
      paramBaseViewHolder.c(2131297722, 2131232307);
    } else {
      if (a(this.a, paramGiftVoucherModel)) {
        i = 2131232304;
      } else {
        i = 2131232305;
      } 
      paramBaseViewHolder.e(2131296768, i);
      paramBaseViewHolder.c(2131297722, 2131232306);
    } 
    paramBaseViewHolder.c(2131297722, a(this.a, paramGiftVoucherModel) ^ true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\adapter\GiftVoucherAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */