package com.soft.blued.ui.user.model;

public class PayPlatformDiscountModel {
  public _channel channel;
  
  public _vip vip;
  
  public static class _channel {
    public PayPlatformDiscountModel._discountDesc alipay;
    
    public PayPlatformDiscountModel._discountDesc huabei;
    
    public PayPlatformDiscountModel._discountDesc weixin;
  }
  
  public class _discountDesc {
    public String desc;
    
    public int is_choose;
  }
  
  public class _vip {
    public int contract;
    
    public int is_upgrade;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\PayPlatformDiscountModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */