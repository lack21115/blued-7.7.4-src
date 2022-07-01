package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

public final class ay implements IDistrictSearch {
  private static HashMap<Integer, DistrictResult> f;
  
  private Context a;
  
  private DistrictSearchQuery b;
  
  private DistrictSearch.OnDistrictSearchListener c;
  
  private DistrictSearchQuery d;
  
  private int e;
  
  private Handler g;
  
  public ay(Context paramContext) {
    this.a = paramContext.getApplicationContext();
    this.g = s.a();
  }
  
  public final DistrictSearchQuery getQuery() {
    return this.b;
  }
  
  public final DistrictResult searchDistrict() throws AMapException {
    try {
      boolean bool1;
      DistrictResult districtResult = new DistrictResult();
      q.a(this.a);
      DistrictSearchQuery districtSearchQuery = this.b;
      boolean bool2 = true;
      if (districtSearchQuery == null) {
        bool1 = false;
      } else {
        bool1 = true;
      } 
      if (!bool1)
        this.b = new DistrictSearchQuery(); 
      districtResult.setQuery(this.b.clone());
      if (!this.b.weakEquals(this.d)) {
        this.e = 0;
        this.d = this.b.clone();
        if (f != null)
          f.clear(); 
      } 
      if (this.e == 0) {
        DistrictResult districtResult1 = (new k(this.a, this.b.clone())).n_();
        if (districtResult1 == null)
          return districtResult1; 
        this.e = districtResult1.getPageCount();
        f = new HashMap<Integer, DistrictResult>();
        districtResult = districtResult1;
        if (this.b != null) {
          if (districtResult1 == null)
            return districtResult1; 
          districtResult = districtResult1;
          if (this.e > 0) {
            districtResult = districtResult1;
            if (this.e > this.b.getPageNum()) {
              f.put(Integer.valueOf(this.b.getPageNum()), districtResult1);
              return districtResult1;
            } 
          } 
        } 
      } else {
        int i = this.b.getPageNum();
        if (i < this.e && i >= 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        } 
        if (bool1) {
          DistrictResult districtResult1 = f.get(Integer.valueOf(i));
          districtResult = districtResult1;
          if (districtResult1 == null) {
            districtResult1 = (new k(this.a, this.b.clone())).n_();
            districtResult = districtResult1;
            if (this.b != null) {
              if (districtResult1 == null)
                return districtResult1; 
              districtResult = districtResult1;
              if (this.e > 0) {
                districtResult = districtResult1;
                if (this.e > this.b.getPageNum()) {
                  f.put(Integer.valueOf(this.b.getPageNum()), districtResult1);
                  return districtResult1;
                } 
              } 
            } 
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "DistrictSearch", "searchDistrict");
      throw aMapException;
    } 
    return (DistrictResult)aMapException;
  }
  
  public final void searchDistrictAnsy() {
    searchDistrictAsyn();
  }
  
  public final void searchDistrictAsyn() {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener paramOnDistrictSearchListener) {
    this.c = paramOnDistrictSearchListener;
  }
  
  public final void setQuery(DistrictSearchQuery paramDistrictSearchQuery) {
    this.b = paramDistrictSearchQuery;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */