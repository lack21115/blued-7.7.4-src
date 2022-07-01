package com.soft.blued.ui.pay.model;

import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.model.FuGiftModel;
import java.util.List;

public class VIPPayResult {
  public String _;
  
  public int activity_id;
  
  public String exchange_id;
  
  public _extra extra;
  
  public int is_dialog;
  
  public int is_secret_dialog;
  
  public List<FuGiftModel> lucky_list;
  
  public int ops;
  
  public int status;
  
  public String tips;
  
  public UserBasicModel user_info;
  
  public class _extra {
    public String info_1;
    
    public String info_2;
    
    public String link;
    
    public int product_vip_grade;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\model\VIPPayResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */