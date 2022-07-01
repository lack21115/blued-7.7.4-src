package com.soft.blued.ui.live.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveClassifyTabModel {
  List<LiveTabModel> tabModelList = new ArrayList<LiveTabModel>();
  
  public void addItem(LiveTabModel paramLiveTabModel) {
    this.tabModelList.add(paramLiveTabModel);
  }
  
  public LiveTabModel findTabModel(String paramString) {
    for (LiveTabModel liveTabModel : this.tabModelList) {
      if (TextUtils.equals(paramString, liveTabModel.id))
        return liveTabModel; 
    } 
    return null;
  }
  
  public List<LiveTabModel> getTabModelList() {
    return this.tabModelList;
  }
  
  public void initTabModelList(List<LiveTabModel> paramList) {
    if (paramList != null) {
      this.tabModelList.clear();
      this.tabModelList.addAll(paramList);
    } 
  }
  
  public void removeItem(LiveTabModel paramLiveTabModel) {
    this.tabModelList.remove(paramLiveTabModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\model\LiveClassifyTabModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */