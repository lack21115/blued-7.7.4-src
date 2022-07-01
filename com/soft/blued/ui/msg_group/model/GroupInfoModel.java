package com.soft.blued.ui.msg_group.model;

import android.os.Build;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class GroupInfoModel implements MultiItemEntity, Serializable {
  public List<GroupMemberModel> admin;
  
  public int allow_join;
  
  public int apply_status;
  
  public int at_message_is_mute;
  
  public int belong_circle;
  
  public String group_cover;
  
  public String group_desc;
  
  public int group_id;
  
  public int group_max_admin;
  
  public int group_max_population;
  
  public int group_now_population;
  
  public int group_role;
  
  public int group_status;
  
  public String group_title;
  
  public int itemType = 0;
  
  public int max_join;
  
  public int message_is_mute;
  
  public int notice_is_mute;
  
  public List<Integer> report_reason;
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.group_id == ((GroupInfoModel)paramObject).group_id);
    } 
    return false;
  }
  
  public int getItemType() {
    return this.itemType;
  }
  
  public int hashCode() {
    return (Build.VERSION.SDK_INT >= 19) ? Objects.hash(new Object[] { Integer.valueOf(this.group_id) }) : this.group_id;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\model\GroupInfoModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */