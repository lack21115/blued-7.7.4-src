package com.soft.blued.ui.user.model;

import com.soft.blued.ui.pay.model.BluedCoupon;
import java.util.List;

public class VIPBuyOptionForJsonParse {
  public _explain_list explain_list;
  
  public int has_payment_code;
  
  public int is_show_hori_items;
  
  public List<_rule_list> rule_list;
  
  public _vip_list svip_list;
  
  public _vip_list vip_list;
  
  public class _explain_list {
    public String svip;
    
    public String vip;
  }
  
  public class _rule_list {
    public String title;
    
    public String url;
  }
  
  public class _vip_list {
    public BluedCoupon default_coupon;
    
    public List<VIPBuyOption> list;
    
    public List<VIPRightDescForSelling> privilege;
    
    public List<VIPPrivilegeModel> privilege_list;
    
    public int stop_time;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\VIPBuyOptionForJsonParse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */