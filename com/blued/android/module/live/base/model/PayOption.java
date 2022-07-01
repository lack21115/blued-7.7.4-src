package com.blued.android.module.live.base.model;

import java.util.List;

public class PayOption {
  public int has_payment_code;
  
  public List<_pay_list> pay_list;
  
  public class _item {
    public String description = "";
    
    public String name = "";
  }
  
  public static class _pay_list {
    public float bonus;
    
    public boolean choosed;
    
    public String google_id;
    
    public int id;
    
    public PayOption._item item;
    
    public double money;
    
    public int pretax;
    
    public double ratio;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\model\PayOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */