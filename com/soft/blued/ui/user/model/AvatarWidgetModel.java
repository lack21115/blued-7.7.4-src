package com.soft.blued.ui.user.model;

public class AvatarWidgetModel extends VIPCustomSettingBase {
  public String theme;
  
  public AvatarWidgetModel(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
    this.selected = paramInt;
    this.isDefault = paramBoolean1;
    this.lastSelected = paramBoolean2;
  }
  
  public void update(AvatarWidgetModel paramAvatarWidgetModel) {
    this.id = paramAvatarWidgetModel.id;
    this.version = paramAvatarWidgetModel.version;
    this.vip_status = paramAvatarWidgetModel.vip_status;
    this.theme = paramAvatarWidgetModel.theme;
    this.front_cover = paramAvatarWidgetModel.front_cover;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\AvatarWidgetModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */