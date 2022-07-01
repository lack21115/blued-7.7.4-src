package com.soft.blued.ui.find.model;

import com.soft.blued.ui.feed.model.BluedADExtra;
import java.io.Serializable;

public class UserBasicModel extends BluedADExtra implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public String age;
  
  public String avatar;
  
  public String blued_pic;
  
  public int call_tip;
  
  public String description;
  
  public String distance;
  
  public String distanceStr;
  
  public String email;
  
  public int expire_type;
  
  public int game_type;
  
  public String height;
  
  public String hot;
  
  public int is_call;
  
  public int is_filter_ads;
  
  public int is_find_on_map;
  
  public int is_global_view_secretly;
  
  public int is_hide_city_settled;
  
  public int is_hide_distance;
  
  public int is_hide_last_operate;
  
  public int is_hide_vip_look;
  
  public int is_invisible_all;
  
  public int is_invisible_half;
  
  public int is_official;
  
  public int is_quietly;
  
  public int is_reactive_recommend;
  
  public int is_recommend;
  
  public int is_shadow;
  
  public int is_show_vip_page;
  
  public int is_traceless_access;
  
  public int is_vip_annual;
  
  public String last_operate;
  
  public String last_operate_str;
  
  public String last_operate_time_stamp;
  
  public String location;
  
  public String name;
  
  public String note;
  
  public int online_state;
  
  public int photos_count;
  
  public String role;
  
  public int theme_pendant;
  
  public String uid;
  
  public int vbadge;
  
  public int vip_exp_lvl;
  
  public int vip_grade;
  
  public String weekstar;
  
  public String weight;
  
  public UserBasicModel() {}
  
  public UserBasicModel(String paramString) {
    this.uid = paramString;
  }
  
  public static interface VIP_GRADE {
    public static final int NONE = 0;
    
    public static final int SVIP = 2;
    
    public static final int VIP = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\UserBasicModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */