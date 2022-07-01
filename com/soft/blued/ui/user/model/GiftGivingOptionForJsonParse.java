package com.soft.blued.ui.user.model;

import com.soft.blued.ui.msg.model.GiftVoucherModel;
import java.util.List;

public class GiftGivingOptionForJsonParse extends GoodsOptionBasic {
  public GiftVoucherModel currentVoucher;
  
  public String description;
  
  public String effects;
  
  public CardGift extra_info;
  
  public String gift_id;
  
  public String gift_name_cn;
  
  public String gift_name_en;
  
  public String gift_name_tw;
  
  public String icon;
  
  public int is_default;
  
  public int is_free;
  
  public int is_stock;
  
  public String label;
  
  public float money;
  
  public int number;
  
  public List<String> rules;
  
  public String rules_title;
  
  public int seconds;
  
  public int single_beans;
  
  public float single_money;
  
  public int state;
  
  public int type = 1;
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return this.gift_id.equals(((GiftGivingOptionForJsonParse)paramObject).gift_id);
  }
  
  public int hashCode() {
    return this.gift_id.hashCode();
  }
  
  public static class CardGift {
    public String after_effects;
    
    public String background_image;
    
    public String card_type;
    
    public String from;
    
    public String text;
    
    public String text_background_color;
    
    public String text_color;
    
    public String text_en_us;
    
    public String text_zh_cn;
    
    public String text_zh_tw;
    
    public String to;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\GiftGivingOptionForJsonParse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */