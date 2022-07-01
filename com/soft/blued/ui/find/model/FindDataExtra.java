package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.soft.blued.ui.feed.model.BluedADExtra;
import java.util.List;

public class FindDataExtra extends BluedEntityBaseExtra {
  public List<_adms> adms;
  
  public BluedADExtra adms_activity;
  
  public List<_adms_user> adms_user;
  
  public GuideMap guide_map;
  
  public String next_min_dist;
  
  public String next_skip_uid;
  
  public String selected_refresh_hint;
  
  public class GuideMap {
    public String code;
    
    public String image;
    
    public int is_open;
  }
  
  public static class _adms {
    public List<UserFindResult> data;
    
    public int line;
  }
  
  public static class _adms_user extends UserBasicModel {
    public int layer;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\FindDataExtra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */