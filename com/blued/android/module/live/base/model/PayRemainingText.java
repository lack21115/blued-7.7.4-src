package com.blued.android.module.live.base.model;

import java.io.Serializable;

public class PayRemainingText implements Serializable {
  public String exchange;
  
  public String goods;
  
  public String jump_url;
  
  public String sums;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PayRemainingText[exchange:");
    stringBuilder.append(this.exchange);
    stringBuilder.append(", goods");
    stringBuilder.append(this.goods);
    stringBuilder.append(", sums:");
    stringBuilder.append(this.sums);
    stringBuilder.append(", jump_url:");
    stringBuilder.append(this.jump_url);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\model\PayRemainingText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */