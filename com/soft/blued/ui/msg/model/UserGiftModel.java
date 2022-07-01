package com.soft.blued.ui.msg.model;

import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import java.util.List;

public class UserGiftModel {
  public PayPlatformDiscountModel._channel channel;
  
  public List<GiftGivingOptionForJsonParse> list;
  
  public GiftGivingOptionForJsonParse lucky_bag;
  
  public UserInfo users;
  
  public class UserInfo {
    public int beans;
    
    public int has_payment_code;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\UserGiftModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */