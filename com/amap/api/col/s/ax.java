package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

public class ax implements IDistanceSearch {
  private static final String a = ax.class.getSimpleName();
  
  private Context b;
  
  private Handler c;
  
  private DistanceSearch.OnDistanceSearchListener d;
  
  public ax(Context paramContext) {
    this.b = paramContext.getApplicationContext();
    this.c = s.a();
  }
  
  public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery paramDistanceQuery) throws AMapException {
    DistanceResult distanceResult;
    try {
      q.a(this.b);
      if (paramDistanceQuery != null) {
        boolean bool1;
        LatLonPoint latLonPoint = paramDistanceQuery.getDestination();
        boolean bool2 = true;
        if (latLonPoint == null) {
          bool1 = bool2;
        } else {
          bool1 = bool2;
          if (paramDistanceQuery.getOrigins() != null)
            if (paramDistanceQuery.getOrigins().size() <= 0) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }  
        } 
        if (!bool1) {
          paramDistanceQuery = paramDistanceQuery.clone();
          distanceResult = (new j(this.b, paramDistanceQuery)).n_();
          if (distanceResult != null) {
            distanceResult.setDistanceQuery(paramDistanceQuery);
            return distanceResult;
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } else {
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, a, "calculateWalkRoute");
      throw aMapException;
    } 
    return distanceResult;
  }
  
  public void calculateRouteDistanceAsyn(DistanceSearch.DistanceQuery paramDistanceQuery) {
    an.a().a(new Runnable(this, paramDistanceQuery) {
          public final void run() {
            Message message = s.a().obtainMessage();
            message.what = 400;
            message.arg1 = 16;
            Bundle bundle = new Bundle();
            DistanceResult distanceResult1 = null;
            DistanceResult distanceResult2 = null;
            try {
              DistanceResult distanceResult = this.b.calculateRouteDistance(this.a);
              distanceResult2 = distanceResult;
              distanceResult1 = distanceResult;
              bundle.putInt("errorCode", 1000);
              distanceResult1 = distanceResult;
            } catch (AMapException aMapException) {
              distanceResult2 = distanceResult1;
            } finally {}
            message.obj = ax.a(this.b);
            bundle.putParcelable("result", (Parcelable)distanceResult1);
            message.setData(bundle);
            ax.b(this.b).sendMessage(message);
          }
        });
  }
  
  public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener paramOnDistanceSearchListener) {
    this.d = paramOnDistanceSearchListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */