package com.soft.blued.ui.msg.model;

import com.blued.android.core.BlueAppLocal;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.io.Serializable;

public class MsgExtraGift implements Serializable {
  public GiftInfo gift_like;
  
  public MsgSourceEntity msgSource;
  
  public String getGiftName() {
    if (this.gift_like == null)
      return ""; 
    String str = BlueAppLocal.c().getLanguage();
    return str.equals("en") ? this.gift_like.gift_name_en : (str.equals("zh") ? this.gift_like.gift_name_cn : this.gift_like.gift_name_tw);
  }
  
  public static class GiftInfo implements Serializable {
    public GiftGivingOptionForJsonParse.CardGift cardGift;
    
    public String giftId;
    
    public int giftTye;
    
    public String gift_name_cn;
    
    public String gift_name_en;
    
    public String gift_name_tw;
    
    public String gift_url;
    
    public String img_url;
    
    public float money;
    
    public String toNickName;
    
    public int topTime;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgExtraGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */