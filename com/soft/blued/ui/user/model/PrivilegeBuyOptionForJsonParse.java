package com.soft.blued.ui.user.model;

import java.util.List;

public class PrivilegeBuyOptionForJsonParse {
  public PayPlatformDiscountModel._channel channel;
  
  public List<ProductBean> product;
  
  public static class ProductBean extends GoodsOptionBasic {
    public int average_beans;
    
    public int average_price;
    
    public int buy_num;
    
    public boolean choosen;
    
    public String discount;
    
    public int discount_beans;
    
    public String discount_per;
    
    public int discount_price;
    
    public int is_recommend;
    
    public boolean showBeans;
    
    public int total_beans;
    
    public double total_price;
    
    public String unit;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\PrivilegeBuyOptionForJsonParse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */