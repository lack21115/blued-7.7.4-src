package com.soft.blued.ui.find.model;

import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.List;

public class BluedMyVisitorList extends UserBasicModel implements Cloneable {
  public String fuzzy_profile_picture;
  
  public int is_interested;
  
  public int is_vip;
  
  public String last_visit_time;
  
  public List<ProfilePicture> profile_picture;
  
  public TTNativeAd ttNativeAdData;
  
  public String visited_time;
  
  public String visitors_time;
  
  public BluedMyVisitorList clone() {
    try {
      return (BluedMyVisitorList)super.clone();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static class ProfilePicture extends BluedMyVisitorList {
    public String url;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\BluedMyVisitorList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */