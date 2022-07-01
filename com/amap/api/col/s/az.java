package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

public final class az implements IGeocodeSearch {
  private Context a;
  
  private GeocodeSearch.OnGeocodeSearchListener b;
  
  private Handler c;
  
  public az(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    this.c = s.a();
  }
  
  public final RegeocodeAddress getFromLocation(RegeocodeQuery paramRegeocodeQuery) throws AMapException {
    try {
      boolean bool1;
      q.a(this.a);
      boolean bool2 = false;
      if (paramRegeocodeQuery == null) {
        bool1 = bool2;
      } else {
        bool1 = bool2;
        if (paramRegeocodeQuery.getPoint() != null)
          if (paramRegeocodeQuery.getLatLonType() == null) {
            bool1 = bool2;
          } else {
            bool1 = true;
          }  
      } 
      if (bool1)
        return (new ah(this.a, paramRegeocodeQuery)).n_(); 
      throw new AMapException("无效的参数 - IllegalArgumentException");
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "GeocodeSearch", "getFromLocationAsyn");
      throw aMapException;
    } 
  }
  
  public final void getFromLocationAsyn(RegeocodeQuery paramRegeocodeQuery) {
    try {
      return;
    } finally {
      paramRegeocodeQuery = null;
      i.a((Throwable)paramRegeocodeQuery, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
    } 
  }
  
  public final List<GeocodeAddress> getFromLocationName(GeocodeQuery paramGeocodeQuery) throws AMapException {
    try {
      q.a(this.a);
      if (paramGeocodeQuery != null)
        return (new n(this.a, paramGeocodeQuery)).n_(); 
      throw new AMapException("无效的参数 - IllegalArgumentException");
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "GeocodeSearch", "getFromLocationName");
      throw aMapException;
    } 
  }
  
  public final void getFromLocationNameAsyn(GeocodeQuery paramGeocodeQuery) {
    try {
      return;
    } finally {
      paramGeocodeQuery = null;
      i.a((Throwable)paramGeocodeQuery, "GeocodeSearch", "getFromLocationNameAsynThrowable");
    } 
  }
  
  public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener paramOnGeocodeSearchListener) {
    this.b = paramOnGeocodeSearchListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */