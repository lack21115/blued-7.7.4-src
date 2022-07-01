package com.soft.blued.ui.user.model;

import com.soft.blued.ui.find.model.AdvertFloatModel;
import java.util.List;

public class VIPCenterForJsonParse {
  public _banner_ad banner;
  
  public _banner_ad footer;
  
  public AdvertFloatModel market;
  
  public List<VIPRightOption> privilege;
  
  public List<NonVIPPriviledge> privilege_normal;
  
  public List<_upgrade> upgrade;
  
  public _user_info user_info;
  
  public UserLvlPriviledge user_lvl_privilege;
  
  public static interface IS_SHOW_LVL_LIST {
    public static final int HIDE = 0;
    
    public static final int SHOW_MY_RIGHT = 2;
    
    public static final int SHOW_WAITING_RIGHT = 1;
  }
  
  public static class NonVIPPriviledge {
    public List<VIPRightOption> privilege_list;
    
    public String title;
  }
  
  public static class UserLvlPriviledge {
    public int is_show_lvl_list;
    
    public List<VIPCenterForJsonParse._privilege_list> privilege_list;
    
    public String user_lvl_content;
  }
  
  public static class _banner {
    public boolean ifShowed = false;
    
    public String img;
    
    public String link;
  }
  
  public class _banner_ad {
    public List<VIPCenterForJsonParse._banner> svip;
    
    public List<VIPCenterForJsonParse._banner> vip;
  }
  
  public static class _privilege_list {
    public String corner;
    
    public String icon;
    
    public String title;
    
    public String unit;
  }
  
  public class _upgrade {
    public String description;
    
    public String icon;
    
    public int pid;
    
    public String tips;
    
    public String title;
  }
  
  public class _user_info {
    public long expire_time;
    
    public int expire_type;
    
    public int grade;
    
    public int is_show_expire;
    
    public int is_show_level;
    
    public int is_vip_annual;
    
    public long svip_endtime;
    
    public long vip_endtime;
    
    public int vip_exp_lvl;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\VIPCenterForJsonParse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */