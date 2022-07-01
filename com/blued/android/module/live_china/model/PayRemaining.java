package com.blued.android.module.live_china.model;

import com.blued.android.module.live.base.model.BasePayRemaining;

public class PayRemaining extends BasePayRemaining {
  public int animation;
  
  public String ar_name;
  
  public String data;
  
  public long end_second;
  
  public String hongbao_id;
  
  public String image_url;
  
  public int is_anim;
  
  public String resource_url;
  
  public long start_second;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PayRemaining[image_url:");
    stringBuilder.append(this.image_url);
    stringBuilder.append(", hongbao_id:");
    stringBuilder.append(this.hongbao_id);
    stringBuilder.append(", start_second:");
    stringBuilder.append(this.start_second);
    stringBuilder.append(", start_second:");
    stringBuilder.append(this.end_second);
    stringBuilder.append(", is_anim:");
    stringBuilder.append(this.is_anim);
    stringBuilder.append(", animation:");
    stringBuilder.append(this.animation);
    stringBuilder.append(", ar_name:");
    stringBuilder.append(this.ar_name);
    stringBuilder.append(", resource_url:");
    stringBuilder.append(this.resource_url);
    stringBuilder.append(", data:");
    stringBuilder.append(this.data);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\PayRemaining.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */