package com.soft.blued.ui.welcome.model;

import com.soft.blued.ui.feed.model.BluedADExtra;

public class SplashEntity {
  public String third_id;
  
  public ShowEntity today;
  
  public ShowEntity tomorrow;
  
  public static class ShowEntity extends BluedADExtra {
    public String image;
    
    public String splash_time;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\model\SplashEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */