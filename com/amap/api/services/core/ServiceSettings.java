package com.amap.api.services.core;

import com.amap.api.col.s.bk;
import com.amap.api.col.s.bo;
import com.amap.api.col.s.i;

public class ServiceSettings {
  public static final String CHINESE = "zh-CN";
  
  public static final String ENGLISH = "en";
  
  public static final int HTTP = 1;
  
  public static final int HTTPS = 2;
  
  private static ServiceSettings c;
  
  private String a = "zh-CN";
  
  private int b = 1;
  
  private int d = 20000;
  
  private int e = 20000;
  
  public static ServiceSettings getInstance() {
    if (c == null)
      c = new ServiceSettings(); 
    return c;
  }
  
  public void destroyInnerAsynThreadPool() {
    try {
      return;
    } finally {
      Exception exception = null;
      i.a(exception, "ServiceSettings", "destroyInnerAsynThreadPool");
    } 
  }
  
  public int getConnectionTimeOut() {
    return this.d;
  }
  
  public String getLanguage() {
    return this.a;
  }
  
  public int getProtocol() {
    return this.b;
  }
  
  public int getSoTimeOut() {
    return this.e;
  }
  
  public void setApiKey(String paramString) {
    bk.a(paramString);
  }
  
  public void setConnectionTimeOut(int paramInt) {
    if (paramInt < 5000) {
      this.d = 5000;
      return;
    } 
    if (paramInt > 30000) {
      this.d = 30000;
      return;
    } 
    this.d = paramInt;
  }
  
  public void setLanguage(String paramString) {
    this.a = paramString;
  }
  
  public void setProtocol(int paramInt) {
    boolean bool;
    this.b = paramInt;
    bo bo = bo.a();
    if (this.b == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    bo.a(bool);
  }
  
  public void setSoTimeOut(int paramInt) {
    if (paramInt < 5000) {
      this.e = 5000;
      return;
    } 
    if (paramInt > 30000) {
      this.e = 30000;
      return;
    } 
    this.e = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\core\ServiceSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */