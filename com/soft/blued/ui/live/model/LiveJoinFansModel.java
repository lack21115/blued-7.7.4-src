package com.soft.blued.ui.live.model;

import com.blued.android.module.live_china.model.LiveFansRelationModel;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

public class LiveJoinFansModel implements MultiItemEntity {
  public String anchor;
  
  public String anchor_name;
  
  public String avatar;
  
  public int brand_status;
  
  public int gift_count;
  
  public boolean isOpen;
  
  public int itemCusType = 0;
  
  public int level;
  
  public int level_next;
  
  public int live;
  
  public String name;
  
  public int next_level_relation;
  
  public List<LiveJoinFansPrivilegeModel> privilege_list;
  
  public int relation;
  
  public List<LiveFansRelationModel> relation_days;
  
  public int relation_level;
  
  public int relation_limit;
  
  public int relation_today;
  
  public int getItemType() {
    return this.itemCusType;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\model\LiveJoinFansModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */