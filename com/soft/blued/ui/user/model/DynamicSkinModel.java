package com.soft.blued.ui.user.model;

public class DynamicSkinModel extends VIPCustomSettingBase {
  public String theme;
  
  public DynamicSkinModel(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
    this.selected = paramInt;
    this.isDefault = paramBoolean1;
    this.lastSelected = paramBoolean2;
  }
  
  public void update(DynamicSkinModel paramDynamicSkinModel) {
    this.id = paramDynamicSkinModel.id;
    this.version = paramDynamicSkinModel.version;
    this.vip_status = paramDynamicSkinModel.vip_status;
    this.theme = paramDynamicSkinModel.theme;
    this.front_cover = paramDynamicSkinModel.front_cover;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\DynamicSkinModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */