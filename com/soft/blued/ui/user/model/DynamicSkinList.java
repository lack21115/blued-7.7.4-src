package com.soft.blued.ui.user.model;

import java.util.ArrayList;
import java.util.List;

public class DynamicSkinList {
  public List<DynamicSkinModel> modelList = new ArrayList<DynamicSkinModel>();
  
  public void addItem(DynamicSkinModel paramDynamicSkinModel) {
    this.modelList.add(0, paramDynamicSkinModel);
  }
  
  public DynamicSkinModel findModel(int paramInt) {
    for (DynamicSkinModel dynamicSkinModel : this.modelList) {
      if (paramInt == dynamicSkinModel.id)
        return dynamicSkinModel; 
    } 
    return null;
  }
  
  public List<DynamicSkinModel> getModelList() {
    return this.modelList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\DynamicSkinList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */