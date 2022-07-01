package com.soft.blued.ui.pay.model;

import java.io.Serializable;

public class BluedCoupon implements Serializable {
  public String discount_desc;
  
  public int discount_type;
  
  public String end_time;
  
  public int id;
  
  public boolean ifChoosed = false;
  
  public boolean ifShowUrlVisited = false;
  
  public int is_available;
  
  public double money;
  
  public String name;
  
  public String not_available_desc;
  
  public String start_time;
  
  public String tag;
  
  public int type;
  
  public static interface COUPON_DISCOUNT_TYPE {
    public static final int CASH = 0;
    
    public static final int RATE = 1;
  }
  
  public static interface COUPON_PRODUCT_TYPE {
    public static final int ALL = 9;
    
    public static final int HELLO = 4;
    
    public static final int NONE = 0;
    
    public static final int SUPER_EXPLOSURE = 3;
    
    public static final int SVIP = 2;
    
    public static final int VIP = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\model\BluedCoupon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */