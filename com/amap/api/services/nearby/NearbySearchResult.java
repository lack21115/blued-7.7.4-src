package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

public class NearbySearchResult {
  private List<NearbyInfo> a = new ArrayList<NearbyInfo>();
  
  private int b = 0;
  
  public List<NearbyInfo> getNearbyInfoList() {
    return this.a;
  }
  
  public int getTotalNum() {
    return this.b;
  }
  
  public void setNearbyInfoList(List<NearbyInfo> paramList) {
    this.a = paramList;
    this.b = paramList.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\nearby\NearbySearchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */