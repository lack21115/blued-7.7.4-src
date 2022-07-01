package com.soft.blued.ui.msg.model;

import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;

public class UserGiftPackageModel extends Selectable {
  public long created_timestamp;
  
  public long end_time;
  
  public GiftGivingOptionForJsonParse gift_detail;
  
  public int gift_id;
  
  public int id;
  
  public int num;
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.id == ((UserGiftPackageModel)paramObject).id);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.id;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\UserGiftPackageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */