package com.soft.blued.ui.user.model;

import java.io.Serializable;

public class VIPBuyOption extends GoodsOptionBasic implements Serializable {
  public boolean choosen;
  
  public int default_checked;
  
  public String icon;
  
  public int is_hot;
  
  public _item item;
  
  public double money;
  
  public int month;
  
  public double original_money;
  
  public class _item implements Serializable {
    public String button;
    
    public String description;
    
    public String name;
    
    public String remark;
    
    public String tag;
    
    public String tag1;
    
    public String tag2;
    
    public String title;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\VIPBuyOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */