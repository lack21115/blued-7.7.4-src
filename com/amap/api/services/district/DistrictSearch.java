package com.amap.api.services.district;

import android.content.Context;
import com.amap.api.col.s.ay;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistrictSearch;

public class DistrictSearch {
  private IDistrictSearch a;
  
  public DistrictSearch(Context paramContext) {
    if (this.a == null)
      try {
        this.a = (IDistrictSearch)new ay(paramContext);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public DistrictSearchQuery getQuery() {
    IDistrictSearch iDistrictSearch = this.a;
    return (iDistrictSearch != null) ? iDistrictSearch.getQuery() : null;
  }
  
  public DistrictResult searchDistrict() throws AMapException {
    IDistrictSearch iDistrictSearch = this.a;
    return (iDistrictSearch != null) ? iDistrictSearch.searchDistrict() : null;
  }
  
  public void searchDistrictAnsy() {
    IDistrictSearch iDistrictSearch = this.a;
    if (iDistrictSearch != null)
      iDistrictSearch.searchDistrictAnsy(); 
  }
  
  public void searchDistrictAsyn() {
    IDistrictSearch iDistrictSearch = this.a;
    if (iDistrictSearch != null)
      iDistrictSearch.searchDistrictAsyn(); 
  }
  
  public void setOnDistrictSearchListener(OnDistrictSearchListener paramOnDistrictSearchListener) {
    IDistrictSearch iDistrictSearch = this.a;
    if (iDistrictSearch != null)
      iDistrictSearch.setOnDistrictSearchListener(paramOnDistrictSearchListener); 
  }
  
  public void setQuery(DistrictSearchQuery paramDistrictSearchQuery) {
    IDistrictSearch iDistrictSearch = this.a;
    if (iDistrictSearch != null)
      iDistrictSearch.setQuery(paramDistrictSearchQuery); 
  }
  
  public static interface OnDistrictSearchListener {
    void onDistrictSearched(DistrictResult param1DistrictResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\district\DistrictSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */