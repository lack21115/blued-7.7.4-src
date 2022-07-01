package com.amap.api.services.cloud;

import java.util.ArrayList;

public final class CloudResult {
  private int a;
  
  private ArrayList<CloudItem> b;
  
  private int c;
  
  private int d;
  
  private CloudSearch.Query e;
  
  private CloudSearch.SearchBound f;
  
  private CloudResult(CloudSearch.Query paramQuery, int paramInt1, CloudSearch.SearchBound paramSearchBound, int paramInt2, ArrayList<CloudItem> paramArrayList) {
    this.e = paramQuery;
    this.c = paramInt1;
    this.d = paramInt2;
    paramInt1 = this.c;
    paramInt2 = this.d;
    this.a = (paramInt1 + paramInt2 - 1) / paramInt2;
    this.b = paramArrayList;
    this.f = paramSearchBound;
  }
  
  public static CloudResult createPagedResult(CloudSearch.Query paramQuery, int paramInt1, CloudSearch.SearchBound paramSearchBound, int paramInt2, ArrayList<CloudItem> paramArrayList) {
    return new CloudResult(paramQuery, paramInt1, paramSearchBound, paramInt2, paramArrayList);
  }
  
  public final CloudSearch.SearchBound getBound() {
    return this.f;
  }
  
  public final ArrayList<CloudItem> getClouds() {
    return this.b;
  }
  
  public final int getPageCount() {
    return this.a;
  }
  
  public final CloudSearch.Query getQuery() {
    return this.e;
  }
  
  public final int getTotalCount() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\cloud\CloudResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */