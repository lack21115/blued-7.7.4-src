package com.blued.android.module.live_china.model;

import com.blued.android.module.live.base.model.PayOption;
import java.util.List;

public class FirstChargeGift {
  public List<FirstChargeGiftItem> gifts;
  
  public List<PayOption._pay_list> pay_list;
  
  public static class FirstChargeGiftItem {
    public int amount;
    
    public String image;
    
    public int price;
    
    public String title;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\FirstChargeGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */