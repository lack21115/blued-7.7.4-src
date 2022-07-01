package com.blued.android.module.yy_china.model;

import com.blued.android.module.live.base.model.BasePayRemaining;

public class YYPayGoodsModel extends BasePayRemaining {
  public int free_count;
  
  public long users_sums_left;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("YYPayGoodsModel{users_sums_left='");
    stringBuilder.append(this.users_sums_left);
    stringBuilder.append('\'');
    stringBuilder.append(", hit_id='");
    stringBuilder.append(this.hit_id);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYPayGoodsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */