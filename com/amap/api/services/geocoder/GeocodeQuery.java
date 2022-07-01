package com.amap.api.services.geocoder;

public class GeocodeQuery {
  private String a;
  
  private String b;
  
  private String c;
  
  public GeocodeQuery(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
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
      if (((GeocodeQuery)paramObject).b != null)
        return false; 
    } else if (!str.equals(((GeocodeQuery)paramObject).b)) {
      return false;
    } 
    str = this.a;
    if (str == null) {
      if (((GeocodeQuery)paramObject).a != null)
        return false; 
    } else if (!str.equals(((GeocodeQuery)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public String getCity() {
    return this.b;
  }
  
  public String getCountry() {
    return this.c;
  }
  
  public String getLocationName() {
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
    str = this.a;
    if (str != null)
      j = str.hashCode(); 
    return (i + 31) * 31 + j;
  }
  
  public void setCity(String paramString) {
    this.b = paramString;
  }
  
  public void setCountry(String paramString) {
    this.c = paramString;
  }
  
  public void setLocationName(String paramString) {
    this.a = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\GeocodeQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */