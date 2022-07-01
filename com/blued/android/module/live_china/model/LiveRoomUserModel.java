package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.utils.CommonStringUtils;
import java.io.Serializable;
import java.util.List;

public class LiveRoomUserModel extends BluedEntityBaseExtra implements Serializable {
  public String age;
  
  public int allow_active;
  
  public int anchor_level;
  
  public String avatar;
  
  public List<AnchorMedal> badge;
  
  public String city_settled = "";
  
  public String description;
  
  public String email;
  
  public String height;
  
  public String hot;
  
  public int is_hide_city_settled;
  
  public int is_hide_distance;
  
  public int is_hide_last_operate;
  
  public int is_hide_vip_look;
  
  public int is_invisible_all;
  
  public int is_invisible_half;
  
  public int is_manager;
  
  public int is_show_vip_page;
  
  public int is_vip_annual;
  
  public String last_operate;
  
  public String liang_id;
  
  public int liang_type;
  
  public String location;
  
  public String name;
  
  public String note;
  
  public String relationship = "";
  
  public int rich_level;
  
  public String role;
  
  public String uid;
  
  public long uidL = 0L;
  
  public int vbadge;
  
  public int vip_exp_lvl;
  
  public int vip_grade;
  
  public String weight;
  
  public long getUid() {
    if (this.uidL <= 0L)
      this.uidL = CommonStringUtils.c(this.uid); 
    return this.uidL;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveRoomUserModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */