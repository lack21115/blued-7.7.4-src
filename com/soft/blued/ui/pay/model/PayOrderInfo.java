package com.soft.blued.ui.pay.model;

public class PayOrderInfo {
  public class AlipayOrder {
    public String info;
    
    public String orderinfo;
    
    public String sign;
    
    public String sign_type;
  }
  
  public static class WXpayOrder {
    public String appid;
    
    public String noncestr;
    
    public String packageValue;
    
    public String partnerid;
    
    public String prepayid;
    
    public String sign;
    
    public String timestamp;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\model\PayOrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */