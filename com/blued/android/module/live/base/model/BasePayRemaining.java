package com.blued.android.module.live.base.model;

import java.io.Serializable;

public class BasePayRemaining implements Serializable {
  public String _;
  
  public long beans;
  
  public long beans_count;
  
  public long beans_current;
  
  public long bonus;
  
  public String errorMessage;
  
  public int free_number;
  
  public int hit_count;
  
  public long hit_id;
  
  public String order_id;
  
  public int sendGiftStatus;
  
  public int status;
  
  public PayRemainingText text;
  
  public String tips;
  
  public String token;
  
  public String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BasePayRemaining[beans:");
    stringBuilder.append(this.beans);
    stringBuilder.append(", bonus:");
    stringBuilder.append(this.bonus);
    stringBuilder.append(", status:");
    stringBuilder.append(this.status);
    stringBuilder.append(", token:");
    stringBuilder.append(this.token);
    stringBuilder.append(", hit_id:");
    stringBuilder.append(this.hit_id);
    stringBuilder.append(", hit_count:");
    stringBuilder.append(this.hit_count);
    stringBuilder.append(", beans_count:");
    stringBuilder.append(this.beans_count);
    stringBuilder.append(", beans_current:");
    stringBuilder.append(this.beans_current);
    stringBuilder.append(", free_number:");
    stringBuilder.append(this.free_number);
    stringBuilder.append(", tips:");
    stringBuilder.append(this.tips);
    stringBuilder.append(", sendGiftStatus:");
    stringBuilder.append(this.sendGiftStatus);
    stringBuilder.append(", text:");
    PayRemainingText payRemainingText = this.text;
    if (payRemainingText != null) {
      str = payRemainingText.toString();
    } else {
      str = "null";
    } 
    stringBuilder.append(str);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\model\BasePayRemaining.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */