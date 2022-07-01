package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.s.bc;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import java.util.List;

public class PoiSearch {
  public static final String CHINESE = "zh-CN";
  
  public static final String ENGLISH = "en";
  
  public static final String EXTENSIONS_ALL = "all";
  
  public static final String EXTENSIONS_BASE = "base";
  
  private IPoiSearch a = null;
  
  public PoiSearch(Context paramContext, Query paramQuery) {
    if (this.a == null)
      try {
        this.a = (IPoiSearch)new bc(paramContext, paramQuery);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public SearchBound getBound() {
    IPoiSearch iPoiSearch = this.a;
    return (iPoiSearch != null) ? iPoiSearch.getBound() : null;
  }
  
  public String getLanguage() {
    IPoiSearch iPoiSearch = this.a;
    return (iPoiSearch != null) ? iPoiSearch.getLanguage() : null;
  }
  
  public Query getQuery() {
    IPoiSearch iPoiSearch = this.a;
    return (iPoiSearch != null) ? iPoiSearch.getQuery() : null;
  }
  
  public PoiResult searchPOI() throws AMapException {
    IPoiSearch iPoiSearch = this.a;
    return (iPoiSearch != null) ? iPoiSearch.searchPOI() : null;
  }
  
  public void searchPOIAsyn() {
    IPoiSearch iPoiSearch = this.a;
    if (iPoiSearch != null)
      iPoiSearch.searchPOIAsyn(); 
  }
  
  public PoiItem searchPOIId(String paramString) throws AMapException {
    IPoiSearch iPoiSearch = this.a;
    return (iPoiSearch != null) ? iPoiSearch.searchPOIId(paramString) : null;
  }
  
  public void searchPOIIdAsyn(String paramString) {
    IPoiSearch iPoiSearch = this.a;
    if (iPoiSearch != null)
      iPoiSearch.searchPOIIdAsyn(paramString); 
  }
  
  public void setBound(SearchBound paramSearchBound) {
    IPoiSearch iPoiSearch = this.a;
    if (iPoiSearch != null)
      iPoiSearch.setBound(paramSearchBound); 
  }
  
  public void setLanguage(String paramString) {
    IPoiSearch iPoiSearch = this.a;
    if (iPoiSearch != null)
      iPoiSearch.setLanguage(paramString); 
  }
  
  public void setOnPoiSearchListener(OnPoiSearchListener paramOnPoiSearchListener) {
    IPoiSearch iPoiSearch = this.a;
    if (iPoiSearch != null)
      iPoiSearch.setOnPoiSearchListener(paramOnPoiSearchListener); 
  }
  
  public void setQuery(Query paramQuery) {
    IPoiSearch iPoiSearch = this.a;
    if (iPoiSearch != null)
      iPoiSearch.setQuery(paramQuery); 
  }
  
  public static interface OnPoiSearchListener {
    void onPoiItemSearched(PoiItem param1PoiItem, int param1Int);
    
    void onPoiSearched(PoiResult param1PoiResult, int param1Int);
  }
  
  public static class Query implements Cloneable {
    private String a;
    
    private String b;
    
    private String c;
    
    private int d = 1;
    
    private int e = 20;
    
    private String f = "zh-CN";
    
    private boolean g = false;
    
    private boolean h = false;
    
    private String i;
    
    private boolean j = true;
    
    private LatLonPoint k;
    
    private boolean l = true;
    
    private String m = "base";
    
    public Query(String param1String1, String param1String2) {
      this(param1String1, param1String2, null);
    }
    
    public Query(String param1String1, String param1String2, String param1String3) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1String3;
    }
    
    public Query clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "PoiSearch", "queryclone");
      } 
      Query query = new Query(this.a, this.b, this.c);
      query.setPageNum(this.d);
      query.setPageSize(this.e);
      query.setQueryLanguage(this.f);
      query.setCityLimit(this.g);
      query.requireSubPois(this.h);
      query.setBuilding(this.i);
      query.setLocation(this.k);
      query.setDistanceSort(this.j);
      query.setSpecial(this.l);
      query.setExtensions(this.m);
      return query;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      String str = this.b;
      if (str == null) {
        if (((Query)param1Object).b != null)
          return false; 
      } else if (!str.equals(((Query)param1Object).b)) {
        return false;
      } 
      str = this.c;
      if (str == null) {
        if (((Query)param1Object).c != null)
          return false; 
      } else if (!str.equals(((Query)param1Object).c)) {
        return false;
      } 
      str = this.f;
      if (str == null) {
        if (((Query)param1Object).f != null)
          return false; 
      } else if (!str.equals(((Query)param1Object).f)) {
        return false;
      } 
      if (this.d != ((Query)param1Object).d)
        return false; 
      if (this.e != ((Query)param1Object).e)
        return false; 
      str = this.a;
      if (str == null) {
        if (((Query)param1Object).a != null)
          return false; 
      } else if (!str.equals(((Query)param1Object).a)) {
        return false;
      } 
      str = this.i;
      if (str == null) {
        if (((Query)param1Object).i != null)
          return false; 
      } else if (!str.equals(((Query)param1Object).i)) {
        return false;
      } 
      if (this.g != ((Query)param1Object).g)
        return false; 
      if (this.h != ((Query)param1Object).h)
        return false; 
      if (this.l != ((Query)param1Object).l)
        return false; 
      str = this.m;
      if (str == null) {
        if (((Query)param1Object).m != null)
          return false; 
      } else if (!str.equals(((Query)param1Object).m)) {
        return false;
      } 
      return true;
    }
    
    public String getBuilding() {
      return this.i;
    }
    
    public String getCategory() {
      String str = this.b;
      return (str == null || str.equals("00") || this.b.equals("00|")) ? "" : this.b;
    }
    
    public String getCity() {
      return this.c;
    }
    
    public boolean getCityLimit() {
      return this.g;
    }
    
    public String getExtensions() {
      return this.m;
    }
    
    public LatLonPoint getLocation() {
      return this.k;
    }
    
    public int getPageNum() {
      return this.d;
    }
    
    public int getPageSize() {
      return this.e;
    }
    
    protected String getQueryLanguage() {
      return this.f;
    }
    
    public String getQueryString() {
      return this.a;
    }
    
    public int hashCode() {
      int i;
      int j;
      char c1;
      int k;
      int m;
      String str = this.b;
      int n = 0;
      if (str == null) {
        i = 0;
      } else {
        i = str.hashCode();
      } 
      str = this.c;
      if (str == null) {
        j = 0;
      } else {
        j = str.hashCode();
      } 
      boolean bool = this.g;
      char c2 = 'ӏ';
      if (bool) {
        c1 = 'ӏ';
      } else {
        c1 = 'ӕ';
      } 
      if (!this.h)
        c2 = 'ӕ'; 
      str = this.f;
      if (str == null) {
        k = 0;
      } else {
        k = str.hashCode();
      } 
      int i1 = this.d;
      int i2 = this.e;
      str = this.a;
      if (str == null) {
        m = 0;
      } else {
        m = str.hashCode();
      } 
      str = this.i;
      if (str != null)
        n = str.hashCode(); 
      return ((((((((i + 31) * 31 + j) * 31 + c1) * 31 + c2) * 31 + k) * 31 + i1) * 31 + i2) * 31 + m) * 31 + n;
    }
    
    public boolean isDistanceSort() {
      return this.j;
    }
    
    public boolean isRequireSubPois() {
      return this.h;
    }
    
    public boolean isSpecial() {
      return this.l;
    }
    
    public boolean queryEquals(Query param1Query) {
      return (param1Query == null) ? false : ((param1Query == this) ? true : ((PoiSearch.a(param1Query.a, this.a) && PoiSearch.a(param1Query.b, this.b) && PoiSearch.a(param1Query.f, this.f) && PoiSearch.a(param1Query.c, this.c) && PoiSearch.a(param1Query.m, this.m) && PoiSearch.a(param1Query.i, this.i) && param1Query.g == this.g && param1Query.e == this.e && param1Query.j == this.j && param1Query.l == this.l)));
    }
    
    public void requireSubPois(boolean param1Boolean) {
      this.h = param1Boolean;
    }
    
    public void setBuilding(String param1String) {
      this.i = param1String;
    }
    
    public void setCityLimit(boolean param1Boolean) {
      this.g = param1Boolean;
    }
    
    public void setDistanceSort(boolean param1Boolean) {
      this.j = param1Boolean;
    }
    
    public void setExtensions(String param1String) {
      this.m = param1String;
    }
    
    public void setLocation(LatLonPoint param1LatLonPoint) {
      this.k = param1LatLonPoint;
    }
    
    public void setPageNum(int param1Int) {
      int i = param1Int;
      if (param1Int <= 0)
        i = 1; 
      this.d = i;
    }
    
    public void setPageSize(int param1Int) {
      if (param1Int <= 0) {
        this.e = 20;
        return;
      } 
      if (param1Int > 30) {
        this.e = 30;
        return;
      } 
      this.e = param1Int;
    }
    
    public void setQueryLanguage(String param1String) {
      if ("en".equals(param1String)) {
        this.f = "en";
        return;
      } 
      this.f = "zh-CN";
    }
    
    public void setSpecial(boolean param1Boolean) {
      this.l = param1Boolean;
    }
  }
  
  public static class SearchBound implements Cloneable {
    public static final String BOUND_SHAPE = "Bound";
    
    public static final String ELLIPSE_SHAPE = "Ellipse";
    
    public static final String POLYGON_SHAPE = "Polygon";
    
    public static final String RECTANGLE_SHAPE = "Rectangle";
    
    private LatLonPoint a;
    
    private LatLonPoint b;
    
    private int c = 1500;
    
    private LatLonPoint d;
    
    private String e;
    
    private boolean f = true;
    
    private List<LatLonPoint> g;
    
    public SearchBound(LatLonPoint param1LatLonPoint, int param1Int) {
      this.e = "Bound";
      this.c = param1Int;
      this.d = param1LatLonPoint;
    }
    
    public SearchBound(LatLonPoint param1LatLonPoint, int param1Int, boolean param1Boolean) {
      this.e = "Bound";
      this.c = param1Int;
      this.d = param1LatLonPoint;
      this.f = param1Boolean;
    }
    
    public SearchBound(LatLonPoint param1LatLonPoint1, LatLonPoint param1LatLonPoint2) {
      this.e = "Rectangle";
      this.a = param1LatLonPoint1;
      this.b = param1LatLonPoint2;
      if (this.a.getLatitude() >= this.b.getLatitude() || this.a.getLongitude() >= this.b.getLongitude())
        (new IllegalArgumentException("invalid rect ")).printStackTrace(); 
      this.d = new LatLonPoint((this.a.getLatitude() + this.b.getLatitude()) / 2.0D, (this.a.getLongitude() + this.b.getLongitude()) / 2.0D);
    }
    
    private SearchBound(LatLonPoint param1LatLonPoint1, LatLonPoint param1LatLonPoint2, int param1Int, LatLonPoint param1LatLonPoint3, String param1String, List<LatLonPoint> param1List, boolean param1Boolean) {
      this.a = param1LatLonPoint1;
      this.b = param1LatLonPoint2;
      this.c = param1Int;
      this.d = param1LatLonPoint3;
      this.e = param1String;
      this.g = param1List;
      this.f = param1Boolean;
    }
    
    public SearchBound(List<LatLonPoint> param1List) {
      this.e = "Polygon";
      this.g = param1List;
    }
    
    public SearchBound clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        i.a(cloneNotSupportedException, "PoiSearch", "SearchBoundClone");
      } 
      return new SearchBound(this.a, this.b, this.c, this.d, this.e, this.g, this.f);
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      LatLonPoint latLonPoint = this.d;
      if (latLonPoint == null) {
        if (((SearchBound)param1Object).d != null)
          return false; 
      } else if (!latLonPoint.equals(((SearchBound)param1Object).d)) {
        return false;
      } 
      if (this.f != ((SearchBound)param1Object).f)
        return false; 
      latLonPoint = this.a;
      if (latLonPoint == null) {
        if (((SearchBound)param1Object).a != null)
          return false; 
      } else if (!latLonPoint.equals(((SearchBound)param1Object).a)) {
        return false;
      } 
      latLonPoint = this.b;
      if (latLonPoint == null) {
        if (((SearchBound)param1Object).b != null)
          return false; 
      } else if (!latLonPoint.equals(((SearchBound)param1Object).b)) {
        return false;
      } 
      List<LatLonPoint> list = this.g;
      if (list == null) {
        if (((SearchBound)param1Object).g != null)
          return false; 
      } else if (!list.equals(((SearchBound)param1Object).g)) {
        return false;
      } 
      if (this.c != ((SearchBound)param1Object).c)
        return false; 
      String str = this.e;
      if (str == null) {
        if (((SearchBound)param1Object).e != null)
          return false; 
      } else if (!str.equals(((SearchBound)param1Object).e)) {
        return false;
      } 
      return true;
    }
    
    public LatLonPoint getCenter() {
      return this.d;
    }
    
    public LatLonPoint getLowerLeft() {
      return this.a;
    }
    
    public List<LatLonPoint> getPolyGonList() {
      return this.g;
    }
    
    public int getRange() {
      return this.c;
    }
    
    public String getShape() {
      return this.e;
    }
    
    public LatLonPoint getUpperRight() {
      return this.b;
    }
    
    public int hashCode() {
      int i;
      char c;
      int j;
      int k;
      int m;
      LatLonPoint latLonPoint = this.d;
      int n = 0;
      if (latLonPoint == null) {
        i = 0;
      } else {
        i = latLonPoint.hashCode();
      } 
      if (this.f) {
        c = 'ӏ';
      } else {
        c = 'ӕ';
      } 
      latLonPoint = this.a;
      if (latLonPoint == null) {
        j = 0;
      } else {
        j = latLonPoint.hashCode();
      } 
      latLonPoint = this.b;
      if (latLonPoint == null) {
        k = 0;
      } else {
        k = latLonPoint.hashCode();
      } 
      List<LatLonPoint> list = this.g;
      if (list == null) {
        m = 0;
      } else {
        m = list.hashCode();
      } 
      int i1 = this.c;
      String str = this.e;
      if (str != null)
        n = str.hashCode(); 
      return ((((((i + 31) * 31 + c) * 31 + j) * 31 + k) * 31 + m) * 31 + i1) * 31 + n;
    }
    
    public boolean isDistanceSort() {
      return this.f;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\poisearch\PoiSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */