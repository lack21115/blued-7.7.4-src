package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

public class InputtipsQuery implements Cloneable {
  private String a;
  
  private String b;
  
  private boolean c = false;
  
  private String d = null;
  
  private LatLonPoint e;
  
  public InputtipsQuery(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String getCity() {
    return this.b;
  }
  
  public boolean getCityLimit() {
    return this.c;
  }
  
  public String getKeyword() {
    return this.a;
  }
  
  public LatLonPoint getLocation() {
    return this.e;
  }
  
  public String getType() {
    return this.d;
  }
  
  public void setCityLimit(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void setLocation(LatLonPoint paramLatLonPoint) {
    this.e = paramLatLonPoint;
  }
  
  public void setType(String paramString) {
    this.d = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\help\InputtipsQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */