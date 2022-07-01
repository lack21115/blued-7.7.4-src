package com.soft.blued.ui.find.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class SearchPositionListModel {
  List<SearchPositionModel> modelList = new ArrayList<SearchPositionModel>();
  
  public void addItem(SearchPositionModel paramSearchPositionModel) {
    this.modelList.add(0, paramSearchPositionModel);
  }
  
  public SearchPositionModel findModel(String paramString) {
    for (SearchPositionModel searchPositionModel : this.modelList) {
      if (TextUtils.equals(paramString, searchPositionModel.name))
        return searchPositionModel; 
    } 
    return null;
  }
  
  public List<SearchPositionModel> getModelList() {
    return this.modelList;
  }
  
  public void initTabModelList(List<SearchPositionModel> paramList) {
    if (paramList != null) {
      this.modelList.clear();
      this.modelList.addAll(paramList);
    } 
  }
  
  public void removeItem(SearchPositionModel paramSearchPositionModel) {
    this.modelList.remove(paramSearchPositionModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\SearchPositionListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */