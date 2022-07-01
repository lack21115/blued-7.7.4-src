package com.amap.api.services.busline;

import com.amap.api.col.s.i;

public class BusStationQuery implements Cloneable {
  private String a;
  
  private String b;
  
  private int c = 20;
  
  private int d = 1;
  
  public BusStationQuery(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
    if ((i.a(this.a) ^ true) == 0)
      (new IllegalArgumentException("Empty query")).printStackTrace(); 
  }
  
  public BusStationQuery clone() {
    BusStationQuery busStationQuery = new BusStationQuery(this.a, this.b);
    busStationQuery.setPageNumber(this.d);
    busStationQuery.setPageSize(this.c);
    return busStationQuery;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    String str = this.b;
    if (str == null) {
      if (((BusStationQuery)paramObject).b != null)
        return false; 
    } else if (!str.equals(((BusStationQuery)paramObject).b)) {
      return false;
    } 
    if (this.d != ((BusStationQuery)paramObject).d)
      return false; 
    if (this.c != ((BusStationQuery)paramObject).c)
      return false; 
    str = this.a;
    if (str == null) {
      if (((BusStationQuery)paramObject).a != null)
        return false; 
    } else if (!str.equals(((BusStationQuery)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public String getCity() {
    return this.b;
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
    String str = this.b;
    int j = 0;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    int k = this.d;
    int m = this.c;
    str = this.a;
    if (str != null)
      j = str.hashCode(); 
    return (((i + 31) * 31 + k) * 31 + m) * 31 + j;
  }
  
  public void setCity(String paramString) {
    this.b = paramString;
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
  
  public boolean weakEquals(BusStationQuery paramBusStationQuery) {
    if (this == paramBusStationQuery)
      return true; 
    if (paramBusStationQuery == null)
      return false; 
    String str = this.b;
    if (str == null) {
      if (paramBusStationQuery.b != null)
        return false; 
    } else if (!str.equals(paramBusStationQuery.b)) {
      return false;
    } 
    if (this.c != paramBusStationQuery.c)
      return false; 
    str = this.a;
    if (str == null) {
      if (paramBusStationQuery.a != null)
        return false; 
    } else if (!str.equals(paramBusStationQuery.a)) {
      return false;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\busline\BusStationQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */