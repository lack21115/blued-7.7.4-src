package com.soft.blued.ui.setting.model;

public class BluedIcon {
  private int iconResourceId;
  
  private boolean isChecked;
  
  private String launcherName;
  
  public BluedIcon(int paramInt, boolean paramBoolean, String paramString) {
    this.iconResourceId = paramInt;
    this.isChecked = paramBoolean;
    this.launcherName = paramString;
  }
  
  public int getIconResourceId() {
    return this.iconResourceId;
  }
  
  public String getLauncherName() {
    return this.launcherName;
  }
  
  public boolean isChecked() {
    return this.isChecked;
  }
  
  public void setChecked(boolean paramBoolean) {
    this.isChecked = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\model\BluedIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */