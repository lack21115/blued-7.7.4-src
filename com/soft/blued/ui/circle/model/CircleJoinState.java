package com.soft.blued.ui.circle.model;

public class CircleJoinState {
  public int admin_level;
  
  public int allow_join;
  
  public String circle_id;
  
  public String cover;
  
  public int is_applied;
  
  public String title;
  
  public CircleJoinState(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3) {
    this.circle_id = paramString1;
    this.title = paramString2;
    this.cover = paramString3;
    this.admin_level = paramInt1;
    this.allow_join = paramInt2;
    this.is_applied = paramInt3;
  }
  
  public boolean isJoin() {
    return (this.admin_level != 3);
  }
  
  public void setExitJoin() {
    this.admin_level = 3;
  }
  
  public void setJoin() {
    this.admin_level = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\model\CircleJoinState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */