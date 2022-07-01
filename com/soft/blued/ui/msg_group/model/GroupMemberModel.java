package com.soft.blued.ui.msg_group.model;

import com.soft.blued.ui.find.model.BluedRecommendUsers;
import java.io.Serializable;

public class GroupMemberModel extends BluedRecommendUsers implements Serializable {
  public int group_role;
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return this.uid.equals(((GroupMemberModel)paramObject).uid);
  }
  
  public int hashCode() {
    return this.uid.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\model\GroupMemberModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */