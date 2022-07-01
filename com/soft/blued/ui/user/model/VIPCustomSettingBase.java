package com.soft.blued.ui.user.model;

import java.io.Serializable;

public class VIPCustomSettingBase implements Serializable {
  public String front_cover;
  
  public int id;
  
  public boolean isDefault;
  
  public int is_termination;
  
  public boolean lastSelected;
  
  public String name;
  
  public int selected;
  
  public long start_time;
  
  public long stop_time;
  
  public int version;
  
  public int vip_status;
  
  public VIPCustomSettingBase() {}
  
  public VIPCustomSettingBase(int paramInt, boolean paramBoolean) {
    this.selected = paramInt;
    this.isDefault = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\VIPCustomSettingBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */