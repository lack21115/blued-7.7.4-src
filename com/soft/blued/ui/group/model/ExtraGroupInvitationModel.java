package com.soft.blued.ui.group.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.List;

public class ExtraGroupInvitationModel extends BluedEntityBaseExtra {
  public List<GroupInvitaion> iid;
  
  public class GroupInvitaion {
    public String iid;
    
    public String uid;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\model\ExtraGroupInvitationModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */