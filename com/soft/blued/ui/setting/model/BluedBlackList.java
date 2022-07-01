package com.soft.blued.ui.setting.model;

import com.soft.blued.ui.find.model.UserBasicModel;

public class BluedBlackList extends UserBasicModel implements Cloneable {
  public String black_time;
  
  public String city_settled;
  
  public String status;
  
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      cloneNotSupportedException.printStackTrace();
      return null;
    } 
  }
  
  public class privacySettingEntity {
    public int black_allowed_count;
    
    public int black_count;
    
    public int forbid_selected_viewing;
    
    public int is_access_followers;
    
    public int is_access_follows;
    
    public int is_access_groups;
    
    public int is_global_view_secretly;
    
    public int is_hide_city_settled;
    
    public int is_hide_distance;
    
    public int is_hide_last_operate;
    
    public int is_invisible_all;
    
    public int is_invisible_half;
    
    public int is_invisible_map;
    
    public int is_live_push;
    
    public int is_open_private_photos;
    
    public int is_sync_avatar;
    
    public int is_traceless_access;
    
    public int is_un_disturb;
    
    public String stealth_distance;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\model\BluedBlackList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */