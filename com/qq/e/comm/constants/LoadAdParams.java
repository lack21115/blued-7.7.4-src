package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

public class LoadAdParams {
  private int a;
  
  private LoginType b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private int f;
  
  private String g;
  
  private Map h;
  
  private boolean i;
  
  private JSONObject j;
  
  public int getBlockEffectValue() {
    return this.f;
  }
  
  public JSONObject getExtraInfo() {
    return this.j;
  }
  
  public int getFlowSourceId() {
    return this.a;
  }
  
  public String getLoginAppId() {
    return this.c;
  }
  
  public String getLoginOpenid() {
    return this.d;
  }
  
  public LoginType getLoginType() {
    return this.b;
  }
  
  public Map getPassThroughInfo() {
    return this.h;
  }
  
  public String getPassThroughInfoJsonString() {
    try {
      if (this.h != null && this.h.size() > 0)
        return (new JSONObject(this.h)).toString(); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public String getUin() {
    return this.e;
  }
  
  public String getWXAppId() {
    return this.g;
  }
  
  public boolean isHotStart() {
    return this.i;
  }
  
  public void setBlockEffectValue(int paramInt) {
    this.f = paramInt;
  }
  
  public void setExtraInfo(JSONObject paramJSONObject) {
    this.j = paramJSONObject;
  }
  
  public void setFlowSourceId(int paramInt) {
    this.a = paramInt;
  }
  
  public void setHotStart(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void setLoginAppId(String paramString) {
    this.c = paramString;
  }
  
  public void setLoginOpenid(String paramString) {
    this.d = paramString;
  }
  
  public void setLoginType(LoginType paramLoginType) {
    this.b = paramLoginType;
  }
  
  public void setPassThroughInfo(Map paramMap) {
    this.h = paramMap;
  }
  
  public void setUin(String paramString) {
    this.e = paramString;
  }
  
  public void setWXAppId(String paramString) {
    this.g = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("LoadAdParams{flowSourceId=");
    stringBuilder.append(this.a);
    stringBuilder.append(", loginType=");
    stringBuilder.append(this.b);
    stringBuilder.append(", loginAppId=");
    stringBuilder.append(this.c);
    stringBuilder.append(", loginOpenid=");
    stringBuilder.append(this.d);
    stringBuilder.append(", uin=");
    stringBuilder.append(this.e);
    stringBuilder.append(", blockEffect=");
    stringBuilder.append(this.f);
    stringBuilder.append(", passThroughInfo=");
    stringBuilder.append(this.h);
    stringBuilder.append(", extraInfo=");
    stringBuilder.append(this.j);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\constants\LoadAdParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */