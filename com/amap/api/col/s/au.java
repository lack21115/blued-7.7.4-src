package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

public final class au implements IBusLineSearch {
  private Context a;
  
  private BusLineSearch.OnBusLineSearchListener b;
  
  private BusLineQuery c;
  
  private BusLineQuery d;
  
  private int e;
  
  private ArrayList<BusLineResult> f = new ArrayList<BusLineResult>();
  
  private Handler g = null;
  
  public au(Context paramContext, BusLineQuery paramBusLineQuery) {
    this.a = paramContext.getApplicationContext();
    this.c = paramBusLineQuery;
    if (paramBusLineQuery != null)
      this.d = paramBusLineQuery.clone(); 
    this.g = s.a();
  }
  
  private boolean a(int paramInt) {
    return (paramInt < this.e && paramInt >= 0);
  }
  
  public final BusLineQuery getQuery() {
    return this.c;
  }
  
  public final BusLineResult searchBusLine() throws AMapException {
    try {
      q.a(this.a);
      if (this.d != null) {
        int i;
        BusLineQuery busLineQuery = this.c;
        byte b = 0;
        if (busLineQuery != null && !i.a(this.c.getQueryString())) {
          i = 1;
        } else {
          i = 0;
        } 
        if (i) {
          if (!this.c.weakEquals(this.d)) {
            this.d = this.c.clone();
            this.e = 0;
            if (this.f != null)
              this.f.clear(); 
          } 
          if (this.e == 0) {
            BusLineResult busLineResult2 = (BusLineResult)(new d(this.a, this.c.clone())).n_();
            this.f = new ArrayList<BusLineResult>();
            for (i = b; i < this.e; i++)
              this.f.add(null); 
            BusLineResult busLineResult1 = busLineResult2;
            if (this.e >= 0) {
              busLineResult1 = busLineResult2;
              if (a(this.c.getPageNumber())) {
                this.f.set(this.c.getPageNumber(), busLineResult2);
                return busLineResult2;
              } 
            } 
          } else {
            i = this.c.getPageNumber();
            if (a(i)) {
              BusLineResult busLineResult2 = this.f.get(i);
              BusLineResult busLineResult1 = busLineResult2;
              if (busLineResult2 == null) {
                busLineResult1 = (BusLineResult)(new d(this.a, this.c)).n_();
                this.f.set(this.c.getPageNumber(), busLineResult1);
                return busLineResult1;
              } 
            } else {
              throw new IllegalArgumentException("page out of range");
            } 
          } 
        } else {
          throw new AMapException("无效的参数 - IllegalArgumentException");
        } 
      } else {
        throw new AMapException("无效的参数 - IllegalArgumentException");
      } 
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "BusLineSearch", "searchBusLine");
      throw new AMapException(aMapException.getErrorMessage());
    } 
    return (BusLineResult)aMapException;
  }
  
  public final void searchBusLineAsyn() {
    try {
      return;
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener paramOnBusLineSearchListener) {
    this.b = paramOnBusLineSearchListener;
  }
  
  public final void setQuery(BusLineQuery paramBusLineQuery) {
    if (!this.c.weakEquals(paramBusLineQuery)) {
      this.c = paramBusLineQuery;
      this.d = paramBusLineQuery.clone();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */