package com.soft.blued.ui.user.model;

import java.util.ArrayList;
import java.util.List;

public class AvatarWidgetList {
  public List<AvatarWidgetModel> modelList = new ArrayList<AvatarWidgetModel>();
  
  public void addItem(AvatarWidgetModel paramAvatarWidgetModel) {
    this.modelList.add(0, paramAvatarWidgetModel);
  }
  
  public AvatarWidgetModel findModel(int paramInt) {
    for (AvatarWidgetModel avatarWidgetModel : this.modelList) {
      if (paramInt == avatarWidgetModel.id)
        return avatarWidgetModel; 
    } 
    return null;
  }
  
  public List<AvatarWidgetModel> getModelList() {
    return this.modelList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\AvatarWidgetList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */