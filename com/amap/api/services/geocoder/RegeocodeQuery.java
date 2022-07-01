package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

public class RegeocodeQuery {
  private LatLonPoint a;
  
  private float b = 1000.0F;
  
  private String c = "autonavi";
  
  private String d = "";
  
  private String e = "distance";
  
  private String f = "base";
  
  public RegeocodeQuery(LatLonPoint paramLatLonPoint, float paramFloat, String paramString) {
    this.a = paramLatLonPoint;
    this.b = paramFloat;
    setLatLonType(paramString);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    String str2 = this.c;
    if (str2 == null) {
      if (((RegeocodeQuery)paramObject).c != null)
        return false; 
    } else if (!str2.equals(((RegeocodeQuery)paramObject).c)) {
      return false;
    } 
    LatLonPoint latLonPoint = this.a;
    if (latLonPoint == null) {
      if (((RegeocodeQuery)paramObject).a != null)
        return false; 
    } else if (!latLonPoint.equals(((RegeocodeQuery)paramObject).a)) {
      return false;
    } 
    if (Float.floatToIntBits(this.b) != Float.floatToIntBits(((RegeocodeQuery)paramObject).b))
      return false; 
    if (!this.e.equals(((RegeocodeQuery)paramObject).e))
      return false; 
    String str1 = this.f;
    if (str1 == null) {
      if (((RegeocodeQuery)paramObject).f != null)
        return false; 
    } else if (!str1.equals(((RegeocodeQuery)paramObject).f)) {
      return false;
    } 
    return true;
  }
  
  public String getExtensions() {
    return this.f;
  }
  
  public String getLatLonType() {
    return this.c;
  }
  
  public String getMode() {
    return this.e;
  }
  
  public String getPoiType() {
    return this.d;
  }
  
  public LatLonPoint getPoint() {
    return this.a;
  }
  
  public float getRadius() {
    return this.b;
  }
  
  public int hashCode() {
    int i;
    String str = this.c;
    int j = 0;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    LatLonPoint latLonPoint = this.a;
    if (latLonPoint != null)
      j = latLonPoint.hashCode(); 
    return ((i + 31) * 31 + j) * 31 + Float.floatToIntBits(this.b);
  }
  
  public void setExtensions(String paramString) {
    this.f = paramString;
  }
  
  public void setLatLonType(String paramString) {
    if (paramString != null && (paramString.equals("autonavi") || paramString.equals("gps")))
      this.c = paramString; 
  }
  
  public void setMode(String paramString) {
    this.e = paramString;
  }
  
  public void setPoiType(String paramString) {
    this.d = paramString;
  }
  
  public void setPoint(LatLonPoint paramLatLonPoint) {
    this.a = paramLatLonPoint;
  }
  
  public void setRadius(float paramFloat) {
    this.b = paramFloat;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\geocoder\RegeocodeQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */