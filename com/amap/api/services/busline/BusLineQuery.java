package com.amap.api.services.busline;

public class BusLineQuery implements Cloneable {
  private String a;
  
  private String b;
  
  private int c = 20;
  
  private int d = 1;
  
  private SearchType e;
  
  private String f = "base";
  
  public BusLineQuery(String paramString1, SearchType paramSearchType, String paramString2) {
    this.a = paramString1;
    this.e = paramSearchType;
    this.b = paramString2;
  }
  
  public BusLineQuery clone() {
    BusLineQuery busLineQuery = new BusLineQuery(this.a, this.e, this.b);
    busLineQuery.setPageNumber(this.d);
    busLineQuery.setPageSize(this.c);
    busLineQuery.setExtensions(this.f);
    return busLineQuery;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.e != ((BusLineQuery)paramObject).e)
      return false; 
    String str = this.b;
    if (str == null) {
      if (((BusLineQuery)paramObject).b != null)
        return false; 
    } else if (!str.equals(((BusLineQuery)paramObject).b)) {
      return false;
    } 
    if (this.d != ((BusLineQuery)paramObject).d)
      return false; 
    if (this.c != ((BusLineQuery)paramObject).c)
      return false; 
    str = this.a;
    if (str == null) {
      if (((BusLineQuery)paramObject).a != null)
        return false; 
    } else if (!str.equals(((BusLineQuery)paramObject).a)) {
      return false;
    } 
    str = this.f;
    if (str == null) {
      if (((BusLineQuery)paramObject).f != null)
        return false; 
    } else if (!str.equals(((BusLineQuery)paramObject).f)) {
      return false;
    } 
    return true;
  }
  
  public SearchType getCategory() {
    return this.e;
  }
  
  public String getCity() {
    return this.b;
  }
  
  public String getExtensions() {
    return this.f;
  }
  
  public int getPageNumber() {
    return this.d;
  }
  
  public int getPageSize() {
    return this.c;
  }
  
  public String getQueryString() {
    return this.a;
  }
  
  public int hashCode() {
    int i;
    int j;
    int k;
    SearchType searchType = this.e;
    int m = 0;
    if (searchType == null) {
      i = 0;
    } else {
      i = searchType.hashCode();
    } 
    String str = this.b;
    if (str == null) {
      j = 0;
    } else {
      j = str.hashCode();
    } 
    int n = this.d;
    int i1 = this.c;
    str = this.a;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    } 
    str = this.f;
    if (str != null)
      m = str.hashCode(); 
    return (((((i + 31) * 31 + j) * 31 + n) * 31 + i1) * 31 + k) * 31 + m;
  }
  
  public void setCategory(SearchType paramSearchType) {
    this.e = paramSearchType;
  }
  
  public void setCity(String paramString) {
    this.b = paramString;
  }
  
  public void setExtensions(String paramString) {
    this.f = paramString;
  }
  
  public void setPageNumber(int paramInt) {
    int i = paramInt;
    if (paramInt <= 0)
      i = 1; 
    this.d = i;
  }
  
  public void setPageSize(int paramInt) {
    this.c = paramInt;
  }
  
  public void setQueryString(String paramString) {
    this.a = paramString;
  }
  
  public boolean weakEquals(BusLineQuery paramBusLineQuery) {
    if (this == paramBusLineQuery)
      return true; 
    if (paramBusLineQuery == null)
      return false; 
    if (this.a == null) {
      if (paramBusLineQuery.getQueryString() != null)
        return false; 
    } else if (!paramBusLineQuery.getQueryString().equals(this.a)) {
      return false;
    } 
    if (this.b == null) {
      if (paramBusLineQuery.getCity() != null)
        return false; 
    } else if (!paramBusLineQuery.getCity().equals(this.b)) {
      return false;
    } 
    return (this.c != paramBusLineQuery.getPageSize()) ? false : (!(paramBusLineQuery.getCategory().compareTo(this.e) != 0));
  }
  
  public enum SearchType {
    BY_LINE_ID, BY_LINE_NAME;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\busline\BusLineQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */