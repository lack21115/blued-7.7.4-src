package com.soft.blued.ui.circle.model;

import android.text.TextUtils;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import java.io.Serializable;
import java.util.List;

public class MyCircleModel implements Serializable, Cloneable {
  private static final long serialVersionUID = 1L;
  
  public int active_list_is_show;
  
  public int active_list_open;
  
  public String[] active_list_top;
  
  public int admin_level;
  
  public int all_groups_full;
  
  public int allow_join;
  
  public List<MyCircleModel> circleModelList;
  
  public String circle_id;
  
  public int classify_id;
  
  public String cover;
  
  public int cover_is_auditing;
  
  public String description;
  
  public String feed_big_num;
  
  public int feed_num;
  
  public List<GroupInfoModel> groups;
  
  public int has_mute;
  
  public boolean isDraw;
  
  public boolean isHotBase;
  
  public boolean isShowUrlVisited;
  
  public int is_applied;
  
  public int is_disclosure;
  
  public int is_essence;
  
  @Deprecated
  public int is_member;
  
  public int label;
  
  public String last_update_time;
  
  public String members_big_num;
  
  public int members_num;
  
  public int show_groups;
  
  public String title;
  
  public MyCircleModel() {}
  
  public MyCircleModel(String paramString, boolean paramBoolean) {
    this.title = paramString;
    this.isHotBase = paramBoolean;
  }
  
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      cloneNotSupportedException.printStackTrace();
      return null;
    } 
  }
  
  public CircleJoinState getJoinState() {
    return new CircleJoinState(this.circle_id, this.title, this.cover, this.admin_level, this.allow_join, this.is_applied);
  }
  
  public boolean isJoin() {
    return (this.admin_level != 3);
  }
  
  public boolean isManager() {
    return (this.admin_level == 2);
  }
  
  public boolean isMember() {
    return (this.admin_level == 0);
  }
  
  public boolean isNotMember() {
    return (this.admin_level == 3);
  }
  
  public boolean isOwner() {
    return (this.admin_level == 1);
  }
  
  public boolean isPrivateCircle() {
    return (this.allow_join == 0 && this.is_disclosure == 0);
  }
  
  public void setExitJoin() {
    this.admin_level = 3;
  }
  
  public void setJoin() {
    this.admin_level = 0;
  }
  
  public void setJoinState(CircleJoinState paramCircleJoinState) {
    if (paramCircleJoinState != null && !TextUtils.isEmpty(this.circle_id) && this.circle_id.equals(paramCircleJoinState.circle_id)) {
      this.admin_level = paramCircleJoinState.admin_level;
      this.allow_join = paramCircleJoinState.allow_join;
      this.is_applied = paramCircleJoinState.is_applied;
    } 
  }
  
  public void setManager() {
    this.admin_level = 2;
  }
  
  public void setMember() {
    this.admin_level = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\model\MyCircleModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */