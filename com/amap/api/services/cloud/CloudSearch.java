package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.s.aw;
import com.amap.api.col.s.i;
import com.amap.api.col.s.z;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.List;

public class CloudSearch {
  private ICloudSearch a;
  
  public CloudSearch(Context paramContext) {
    if (this.a == null)
      try {
        this.a = (ICloudSearch)new aw(paramContext);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void searchCloudAsyn(Query paramQuery) {
    ICloudSearch iCloudSearch = this.a;
    if (iCloudSearch != null)
      iCloudSearch.searchCloudAsyn(paramQuery); 
  }
  
  public void searchCloudDetailAsyn(String paramString1, String paramString2) {
    ICloudSearch iCloudSearch = this.a;
    if (iCloudSearch != null)
      iCloudSearch.searchCloudDetailAsyn(paramString1, paramString2); 
  }
  
  public void setOnCloudSearchListener(OnCloudSearchListener paramOnCloudSearchListener) {
    ICloudSearch iCloudSearch = this.a;
    if (iCloudSearch != null)
      iCloudSearch.setOnCloudSearchListener(paramOnCloudSearchListener); 
  }
  
  public static interface OnCloudSearchListener {
    void onCloudItemDetailSearched(CloudItemDetail param1CloudItemDetail, int param1Int);
    
    void onCloudSearched(CloudResult param1CloudResult, int param1Int);
  }
  
  public static class Query implements Cloneable {
    private String a;
    
    private int b = 1;
    
    private int c = 20;
    
    private String d;
    
    private CloudSearch.SearchBound e;
    
    private CloudSearch.Sortingrules f;
    
    private ArrayList<z> g = new ArrayList<z>();
    
    private List<String> h = new ArrayList<String>();
    
    private Query() {}
    
    public Query(String param1String1, String param1String2, CloudSearch.SearchBound param1SearchBound) throws AMapException {
      if (!i.a(param1String1) && param1SearchBound != null) {
        this.d = param1String1;
        this.a = param1String2;
        this.e = param1SearchBound;
        return;
      } 
      throw new AMapException("无效的参数 - IllegalArgumentException");
    }
    
    public void addFilterNum(String param1String1, String param1String2, String param1String3) {
      z z = new z(param1String1, param1String2, param1String3);
      this.g.add(z);
    }
    
    public void addFilterString(String param1String1, String param1String2) {
      if (param1String1 != null && param1String2 != null) {
        List<String> list = this.h;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1String1);
        stringBuilder.append(param1String2);
        list.add(stringBuilder.toString());
      } 
    }
    
    public Query clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        cloneNotSupportedException.printStackTrace();
      } 
      ArrayList arrayList = null;
      try {
        Query query = new Query(this.d, this.a, this.e);
        try {
          ArrayList<z> arrayList1;
          query.setPageNum(this.b);
          query.setPageSize(this.c);
          query.setSortingrules(getSortingrules());
          if (this.g == null) {
            arrayList1 = null;
          } else {
            arrayList1 = new ArrayList();
            arrayList1.addAll(this.g);
          } 
          query.g = arrayList1;
          if (this.h == null) {
            arrayList1 = arrayList;
          } else {
            arrayList1 = new ArrayList<z>();
            arrayList1.addAll(this.h);
          } 
          query.h = (List)arrayList1;
        } catch (AMapException null) {}
      } catch (AMapException aMapException) {
        Object object = null;
      } 
      aMapException.printStackTrace();
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object != null) {
        if (!(param1Object instanceof Query))
          return false; 
        if (param1Object == this)
          return true; 
        param1Object = param1Object;
        if (queryEquals((Query)param1Object) && ((Query)param1Object).b == this.b)
          return true; 
      } 
      return false;
    }
    
    public CloudSearch.SearchBound getBound() {
      return this.e;
    }
    
    public String getFilterNumString() {
      StringBuffer stringBuffer = new StringBuffer();
      try {
        int i;
        int j = this.g.size();
      } finally {
        Exception exception = null;
      } 
      return stringBuffer.toString();
    }
    
    public String getFilterString() {
      StringBuffer stringBuffer = new StringBuffer();
      try {
        int i;
        int j = this.h.size();
      } finally {
        Exception exception = null;
      } 
      return stringBuffer.toString();
    }
    
    public int getPageNum() {
      return this.b;
    }
    
    public int getPageSize() {
      return this.c;
    }
    
    public String getQueryString() {
      return this.a;
    }
    
    public CloudSearch.Sortingrules getSortingrules() {
      return this.f;
    }
    
    public String getTableID() {
      return this.d;
    }
    
    public int hashCode() {
      int i;
      int j;
      int k;
      int m;
      int n;
      ArrayList<z> arrayList = this.g;
      int i1 = 0;
      if (arrayList == null) {
        i = 0;
      } else {
        i = arrayList.hashCode();
      } 
      List<String> list = this.h;
      if (list == null) {
        j = 0;
      } else {
        j = list.hashCode();
      } 
      CloudSearch.SearchBound searchBound = this.e;
      if (searchBound == null) {
        k = 0;
      } else {
        k = searchBound.hashCode();
      } 
      int i2 = this.b;
      int i3 = this.c;
      String str2 = this.a;
      if (str2 == null) {
        m = 0;
      } else {
        m = str2.hashCode();
      } 
      CloudSearch.Sortingrules sortingrules = this.f;
      if (sortingrules == null) {
        n = 0;
      } else {
        n = sortingrules.hashCode();
      } 
      String str1 = this.d;
      if (str1 != null)
        i1 = str1.hashCode(); 
      return (((((((i + 31) * 31 + j) * 31 + k) * 31 + i2) * 31 + i3) * 31 + m) * 31 + n) * 31 + i1;
    }
    
    public boolean queryEquals(Query param1Query) {
      if (param1Query == null)
        return false; 
      if (param1Query == this)
        return true; 
      if (CloudSearch.a(param1Query.a, this.a) && CloudSearch.a(param1Query.getTableID(), getTableID()) && CloudSearch.a(param1Query.getFilterString(), getFilterString()) && CloudSearch.a(param1Query.getFilterNumString(), getFilterNumString()) && param1Query.c == this.c) {
        boolean bool;
        CloudSearch.SearchBound searchBound1 = param1Query.getBound();
        CloudSearch.SearchBound searchBound2 = getBound();
        if (searchBound1 == null && searchBound2 == null) {
          bool = true;
        } else if (searchBound1 != null && searchBound2 != null) {
          bool = searchBound1.equals(searchBound2);
        } else {
          bool = false;
        } 
        if (bool) {
          CloudSearch.Sortingrules sortingrules1 = param1Query.getSortingrules();
          CloudSearch.Sortingrules sortingrules2 = getSortingrules();
          if (sortingrules1 == null && sortingrules2 == null) {
            bool = true;
          } else if (sortingrules1 != null && sortingrules2 != null) {
            bool = sortingrules1.equals(sortingrules2);
          } else {
            bool = false;
          } 
          if (bool)
            return true; 
        } 
      } 
      return false;
    }
    
    public void setBound(CloudSearch.SearchBound param1SearchBound) {
      this.e = param1SearchBound;
    }
    
    public void setPageNum(int param1Int) {
      this.b = param1Int;
    }
    
    public void setPageSize(int param1Int) {
      if (param1Int <= 0) {
        this.c = 20;
        return;
      } 
      if (param1Int > 100) {
        this.c = 100;
        return;
      } 
      this.c = param1Int;
    }
    
    public void setSortingrules(CloudSearch.Sortingrules param1Sortingrules) {
      this.f = param1Sortingrules;
    }
    
    public void setTableID(String param1String) {
      this.d = param1String;
    }
  }
  
  public static class SearchBound implements Cloneable {
    public static final String BOUND_SHAPE = "Bound";
    
    public static final String LOCAL_SHAPE = "Local";
    
    public static final String POLYGON_SHAPE = "Polygon";
    
    public static final String RECTANGLE_SHAPE = "Rectangle";
    
    private LatLonPoint a;
    
    private LatLonPoint b;
    
    private int c;
    
    private LatLonPoint d;
    
    private String e = "Bound";
    
    private List<LatLonPoint> f;
    
    private String g;
    
    public SearchBound(LatLonPoint param1LatLonPoint, int param1Int) {
      this.c = param1Int;
      this.d = param1LatLonPoint;
    }
    
    public SearchBound(LatLonPoint param1LatLonPoint1, LatLonPoint param1LatLonPoint2) {
      this.a = param1LatLonPoint1;
      this.b = param1LatLonPoint2;
      param1LatLonPoint1 = this.a;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (param1LatLonPoint1 != null)
        if (this.b == null) {
          bool1 = bool2;
        } else {
          bool1 = bool2;
          if (param1LatLonPoint1.getLatitude() < this.b.getLatitude())
            if (this.a.getLongitude() >= this.b.getLongitude()) {
              bool1 = bool2;
            } else {
              bool1 = true;
            }  
        }  
      if (!bool1)
        (new IllegalArgumentException("invalid rect ")).printStackTrace(); 
    }
    
    public SearchBound(String param1String) {
      this.g = param1String;
    }
    
    public SearchBound(List<LatLonPoint> param1List) {
      this.f = param1List;
    }
    
    private List<LatLonPoint> a() {
      if (this.f == null)
        return null; 
      ArrayList<LatLonPoint> arrayList = new ArrayList();
      for (LatLonPoint latLonPoint : this.f)
        arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude())); 
      return arrayList;
    }
    
    public SearchBound clone() {
      try {
        super.clone();
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        cloneNotSupportedException.printStackTrace();
      } 
      return getShape().equals("Bound") ? new SearchBound(this.d, this.c) : (getShape().equals("Polygon") ? new SearchBound(a()) : (getShape().equals("Local") ? new SearchBound(this.g) : new SearchBound(this.a, this.b)));
    }
    
    public boolean equals(Object<LatLonPoint> param1Object) {
      if (param1Object != null) {
        if (!(param1Object instanceof SearchBound))
          return false; 
        param1Object = param1Object;
        if (!getShape().equalsIgnoreCase(param1Object.getShape()))
          return false; 
        if (getShape().equals("Bound"))
          return (((SearchBound)param1Object).d.equals(this.d) && ((SearchBound)param1Object).c == this.c); 
        if (getShape().equals("Polygon")) {
          param1Object = (Object<LatLonPoint>)((SearchBound)param1Object).f;
          List<LatLonPoint> list = this.f;
          if (param1Object == null && list == null)
            return true; 
          if (param1Object != null && list != null && param1Object.size() == list.size()) {
            int j = param1Object.size();
            int i = 0;
            while (true) {
              if (i < j) {
                if (((LatLonPoint)param1Object.get(i)).equals(list.get(i))) {
                  i++;
                  continue;
                } 
                break;
              } 
              return true;
            } 
          } 
          return false;
        } 
        if (getShape().equals("Local"))
          return ((SearchBound)param1Object).g.equals(this.g); 
        if (((SearchBound)param1Object).a.equals(this.a) && ((SearchBound)param1Object).b.equals(this.b))
          return true; 
      } 
      return false;
    }
    
    public LatLonPoint getCenter() {
      return this.d;
    }
    
    public String getCity() {
      return this.g;
    }
    
    public LatLonPoint getLowerLeft() {
      return this.a;
    }
    
    public List<LatLonPoint> getPolyGonList() {
      return this.f;
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
      int j;
      int k;
      int m;
      int n;
      LatLonPoint latLonPoint = this.d;
      int i1 = 0;
      if (latLonPoint == null) {
        i = 0;
      } else {
        i = latLonPoint.hashCode();
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
      List<LatLonPoint> list = this.f;
      if (list == null) {
        m = 0;
      } else {
        m = list.hashCode();
      } 
      int i2 = this.c;
      String str = this.e;
      if (str == null) {
        n = 0;
      } else {
        n = str.hashCode();
      } 
      str = this.g;
      if (str != null)
        i1 = str.hashCode(); 
      return ((((((i + 31) * 31 + j) * 31 + k) * 31 + m) * 31 + i2) * 31 + n) * 31 + i1;
    }
  }
  
  public static class Sortingrules {
    public static final int DISTANCE = 1;
    
    public static final int WEIGHT = 0;
    
    private int a = 0;
    
    private String b;
    
    private boolean c = true;
    
    public Sortingrules(int param1Int) {
      this.a = param1Int;
    }
    
    public Sortingrules(String param1String, boolean param1Boolean) {
      this.b = param1String;
      this.c = param1Boolean;
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      if (this.c != ((Sortingrules)param1Object).c)
        return false; 
      String str = this.b;
      if (str == null) {
        if (((Sortingrules)param1Object).b != null)
          return false; 
      } else if (!str.equals(((Sortingrules)param1Object).b)) {
        return false;
      } 
      return !(this.a != ((Sortingrules)param1Object).a);
    }
    
    public int hashCode() {
      char c;
      int i;
      if (this.c) {
        c = 'ӏ';
      } else {
        c = 'ӕ';
      } 
      String str = this.b;
      if (str == null) {
        i = 0;
      } else {
        i = str.hashCode();
      } 
      return ((c + 31) * 31 + i) * 31 + this.a;
    }
    
    public String toString() {
      if (i.a(this.b)) {
        int i = this.a;
        return (i == 0) ? "_weight:desc" : ((i == 1) ? "_distance:asc" : "");
      } 
      if (this.c) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.b);
        stringBuilder1.append(":asc");
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(":desc");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\cloud\CloudSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */