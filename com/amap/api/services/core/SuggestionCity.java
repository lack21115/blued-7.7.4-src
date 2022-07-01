package com.amap.api.services.core;

public class SuggestionCity {
  private String a;
  
  private String b;
  
  private String c;
  
  private int d;
  
  protected SuggestionCity() {}
  
  public SuggestionCity(String paramString1, String paramString2, String paramString3, int paramInt) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramInt;
  }
  
  public String getAdCode() {
    return this.c;
  }
  
  public String getCityCode() {
    return this.b;
  }
  
  public String getCityName() {
    return this.a;
  }
  
  public int getSuggestionNum() {
    return this.d;
  }
  
  public void setAdCode(String paramString) {
    this.c = paramString;
  }
  
  public void setCityCode(String paramString) {
    this.b = paramString;
  }
  
  public void setCityName(String paramString) {
    this.a = paramString;
  }
  
  public void setSuggestionNum(int paramInt) {
    this.d = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\core\SuggestionCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */