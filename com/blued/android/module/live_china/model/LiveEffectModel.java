package com.blued.android.module.live_china.model;

public class LiveEffectModel {
  public int beans;
  
  public long effect_id;
  
  public long expire;
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof LiveEffectModel))
      return false; 
    paramObject = paramObject;
    return (((LiveEffectModel)paramObject).effect_id == this.effect_id && ((LiveEffectModel)paramObject).beans == this.beans && ((LiveEffectModel)paramObject).expire == this.expire);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveEffectModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */