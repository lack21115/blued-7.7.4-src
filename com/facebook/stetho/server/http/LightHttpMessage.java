package com.facebook.stetho.server.http;

import java.util.ArrayList;

public class LightHttpMessage {
  public final ArrayList<String> headerNames = new ArrayList<String>();
  
  public final ArrayList<String> headerValues = new ArrayList<String>();
  
  public void addHeader(String paramString1, String paramString2) {
    this.headerNames.add(paramString1);
    this.headerValues.add(paramString2);
  }
  
  public String getFirstHeaderValue(String paramString) {
    int j = this.headerNames.size();
    for (int i = 0; i < j; i++) {
      if (paramString.equals(this.headerNames.get(i)))
        return this.headerValues.get(i); 
    } 
    return null;
  }
  
  public void reset() {
    this.headerNames.clear();
    this.headerValues.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */