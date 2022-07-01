package com.soft.blued.ui.user.model;

import com.soft.blued.user.BluedConfig;

public class VIPRightOption {
  public String description;
  
  public String icon;
  
  public int is_new;
  
  public int is_on;
  
  public int is_svip;
  
  public int pid;
  
  public String title;
  
  public static int getOnOffStatus(int paramInt) {
    if (paramInt != 0) {
      boolean bool = true;
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4) {
              if (paramInt != 5) {
                if (paramInt != 11) {
                  if (paramInt != 13) {
                    if (paramInt != 25)
                      return (paramInt != 27) ? -1 : (BluedConfig.b().k()).is_filter_ads; 
                    if ((BluedConfig.b().j()).is_hide_vip_look == 1) {
                      paramInt = bool;
                      if ((BluedConfig.b().k()).is_hide_vip_look == 1)
                        paramInt = 0; 
                      return paramInt;
                    } 
                    return 0;
                  } 
                  return (BluedConfig.b().k()).is_global_view_secretly;
                } 
                return (BluedConfig.b().k()).is_traceless_access;
              } 
              return (BluedConfig.b().k()).is_show_vip_page;
            } 
            return (BluedConfig.b().k()).is_invisible_all;
          } 
          return (BluedConfig.b().k()).is_invisible_half;
        } 
        return (BluedConfig.b().k()).is_hide_city_settled;
      } 
      return (BluedConfig.b().k()).is_hide_distance;
    } 
    return (BluedConfig.b().k()).is_hide_last_operate;
  }
  
  public int getRightType() {
    int i = this.pid;
    return (i != 0 && i != 1 && i != 2 && i != 3 && i != 11 && i != 13 && i != 25 && i != 27) ? 1 : 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\VIPRightOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */