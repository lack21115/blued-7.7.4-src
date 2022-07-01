package com.soft.blued.ui.live.model;

import com.soft.blued.ui.login_register.model.BluedLoginResult;

public class LiveRecommendModel {
  public String avatar;
  
  public boolean isShowed;
  
  public String lid;
  
  public int link_type;
  
  public String livePlay;
  
  public int liveType;
  
  public String name;
  
  public int pk;
  
  public String source;
  
  public String uid;
  
  public int vbadge;
  
  public LiveRecommendModel(BluedLoginResult paramBluedLoginResult) {
    this.avatar = paramBluedLoginResult.avatar;
    this.name = paramBluedLoginResult.name;
    this.vbadge = paramBluedLoginResult.vbadge;
    this.liveType = (int)System.currentTimeMillis() % 2;
    this.uid = paramBluedLoginResult.uid;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\model\LiveRecommendModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */