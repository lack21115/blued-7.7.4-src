package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

public final class bd implements IRoutePOISearch {
  private RoutePOISearchQuery a;
  
  private Context b;
  
  private RoutePOISearch.OnRoutePOISearchListener c;
  
  private Handler d = null;
  
  public bd(Context paramContext, RoutePOISearchQuery paramRoutePOISearchQuery) {
    this.b = paramContext;
    this.a = paramRoutePOISearchQuery;
    this.d = s.a();
  }
  
  public final RoutePOISearchQuery getQuery() {
    return this.a;
  }
  
  public final RoutePOISearchResult searchRoutePOI() throws AMapException {
    try {
      q.a(this.b);
      RoutePOISearchQuery routePOISearchQuery = this.a;
      boolean bool = false;
      if (routePOISearchQuery != null && this.a.getSearchType() != null && (this.a.getFrom() != null || this.a.getTo() != null || this.a.getPolylines() != null))
        bool = true; 
      if (bool) {
        routePOISearchQuery = this.a.clone();
        return (new aj(this.b, routePOISearchQuery)).n_();
      } 
      throw new AMapException("无效的参数 - IllegalArgumentException");
    } catch (AMapException aMapException) {
      i.a((Throwable)aMapException, "RoutePOISearchCore", "searchRoutePOI");
      throw aMapException;
    } 
  }
  
  public final void searchRoutePOIAsyn() {
    an.a().a(new Runnable(this) {
          public final void run() {
            Message message = bd.a(this.a).obtainMessage();
            message.arg1 = 14;
            Bundle bundle = new Bundle();
            RoutePOISearchResult routePOISearchResult1 = null;
            RoutePOISearchResult routePOISearchResult2 = null;
            try {
              RoutePOISearchResult routePOISearchResult = this.a.searchRoutePOI();
              routePOISearchResult2 = routePOISearchResult;
              routePOISearchResult1 = routePOISearchResult;
              bundle.putInt("errorCode", 1000);
              s.j j = new s.j();
              routePOISearchResult1 = routePOISearchResult;
            } catch (AMapException aMapException) {
              routePOISearchResult2 = routePOISearchResult1;
            } finally {}
            ((s.j)routePOISearchResult2).b = bd.b(this.a);
            ((s.j)routePOISearchResult2).a = routePOISearchResult1;
            message.obj = routePOISearchResult2;
            message.setData(bundle);
            bd.a(this.a).sendMessage(message);
          }
        });
  }
  
  public final void setQuery(RoutePOISearchQuery paramRoutePOISearchQuery) {
    this.a = paramRoutePOISearchQuery;
  }
  
  public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener paramOnRoutePOISearchListener) {
    this.c = paramOnRoutePOISearchListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */