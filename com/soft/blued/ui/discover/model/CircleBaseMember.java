package com.soft.blued.ui.discover.model;

import com.brandongogetap.stickyheaders.exposed.StickyHeader;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

public class CircleBaseMember {
  public static final int MUTE_CLOSE = 0;
  
  public static final int MUTE_OPEN = 1;
  
  public int admin_level;
  
  public List<Member> admins;
  
  public int admins_num;
  
  public List<Member> members;
  
  public int members_num;
  
  public static class Member implements MultiItemEntity {
    public int adapterType = 0;
    
    public int admin_level;
    
    public String avatar;
    
    public int is_anonym;
    
    public int is_locked;
    
    public int is_mute;
    
    public String name;
    
    public int number;
    
    public String uid;
    
    public int getItemType() {
      return this.adapterType;
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
    
    public void setManager() {
      this.admin_level = 2;
    }
    
    public void setMember() {
      this.admin_level = 0;
    }
  }
  
  public static class MemberHeader extends Member implements StickyHeader {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\model\CircleBaseMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */