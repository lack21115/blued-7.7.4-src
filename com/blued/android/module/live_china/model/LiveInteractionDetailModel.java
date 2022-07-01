package com.blued.android.module.live_china.model;

public class LiveInteractionDetailModel {
  public String alert_message;
  
  public int enable;
  
  public int is_new;
  
  public String pic;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LiveInteractionDetailModel{pic='");
    stringBuilder.append(this.pic);
    stringBuilder.append('\'');
    stringBuilder.append(", is_new=");
    stringBuilder.append(this.is_new);
    stringBuilder.append(", enable=");
    stringBuilder.append(this.enable);
    stringBuilder.append(", alert_message='");
    stringBuilder.append(this.alert_message);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveInteractionDetailModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */