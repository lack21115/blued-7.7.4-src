package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

public final class PoiResult {
  private int a;
  
  private ArrayList<PoiItem> b = new ArrayList<PoiItem>();
  
  private PoiSearch.Query c;
  
  private PoiSearch.SearchBound d;
  
  private List<String> e;
  
  private List<SuggestionCity> f;
  
  private int g;
  
  private PoiResult(PoiSearch.Query paramQuery, PoiSearch.SearchBound paramSearchBound, List<String> paramList, List<SuggestionCity> paramList1, int paramInt1, int paramInt2, ArrayList<PoiItem> paramArrayList) {
    this.c = paramQuery;
    this.d = paramSearchBound;
    this.e = paramList;
    this.f = paramList1;
    this.g = paramInt1;
    paramInt1 = this.g;
    this.a = (paramInt2 + paramInt1 - 1) / paramInt1;
    this.b = paramArrayList;
  }
  
  public static PoiResult createPagedResult(PoiSearch.Query paramQuery, PoiSearch.SearchBound paramSearchBound, List<String> paramList, List<SuggestionCity> paramList1, int paramInt1, int paramInt2, ArrayList<PoiItem> paramArrayList) {
    return new PoiResult(paramQuery, paramSearchBound, paramList, paramList1, paramInt1, paramInt2, paramArrayList);
  }
  
  public final PoiSearch.SearchBound getBound() {
    return this.d;
  }
  
  public final int getPageCount() {
    return this.a;
  }
  
  public final ArrayList<PoiItem> getPois() {
    return this.b;
  }
  
  public final PoiSearch.Query getQuery() {
    return this.c;
  }
  
  public final List<SuggestionCity> getSearchSuggestionCitys() {
    return this.f;
  }
  
  public final List<String> getSearchSuggestionKeywords() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\poisearch\PoiResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */