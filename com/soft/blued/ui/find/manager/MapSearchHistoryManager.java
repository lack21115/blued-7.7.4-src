package com.soft.blued.ui.find.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.soft.blued.ui.find.model.SearchPositionListModel;
import com.soft.blued.ui.find.model.SearchPositionModel;
import com.soft.blued.utils.BluedPreferences;

public class MapSearchHistoryManager {
  private static MapSearchHistoryManager a = new MapSearchHistoryManager();
  
  public static MapSearchHistoryManager a() {
    return a;
  }
  
  public void a(SearchPositionModel paramSearchPositionModel) {
    SearchPositionListModel searchPositionListModel = b();
    if (searchPositionListModel == null)
      return; 
    SearchPositionModel searchPositionModel = searchPositionListModel.findModel(paramSearchPositionModel.name);
    if (searchPositionModel == null) {
      searchPositionListModel.addItem(paramSearchPositionModel);
    } else {
      searchPositionModel.update(paramSearchPositionModel);
    } 
    BluedPreferences.d(AppInfo.f().toJson(searchPositionListModel));
  }
  
  public SearchPositionListModel b() {
    String str = BluedPreferences.y();
    return TextUtils.isEmpty(str) ? new SearchPositionListModel() : (SearchPositionListModel)AppInfo.f().fromJson(str, SearchPositionListModel.class);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\manager\MapSearchHistoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */