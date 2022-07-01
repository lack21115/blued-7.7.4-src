package com.geetest.onelogin.d;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

public class a implements Serializable {
  private String appName;
  
  private String deviceHeight;
  
  private String deviceSystemName;
  
  private String deviceSystemVersion;
  
  private String deviceWidth;
  
  private String model;
  
  private String netInfo;
  
  private String networkType;
  
  private String op;
  
  private String operator;
  
  private String packageName;
  
  private String packageSign;
  
  private String versionCode;
  
  private String versionName;
  
  private String a(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "$null"; 
    return str;
  }
  
  public String getAppName() {
    return this.appName;
  }
  
  public String getDeviceHeight() {
    return this.deviceHeight;
  }
  
  public String getDeviceSystemName() {
    return this.deviceSystemName;
  }
  
  public String getDeviceSystemVersion() {
    return this.deviceSystemVersion;
  }
  
  public String getDeviceWidth() {
    return this.deviceWidth;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public String getNetInfo() {
    return this.netInfo;
  }
  
  public String getNetworkType() {
    return this.networkType;
  }
  
  public String getOp() {
    return this.op;
  }
  
  public String getOperator() {
    return this.operator;
  }
  
  public String getPackageName() {
    return this.packageName;
  }
  
  public String getPackageSign() {
    return this.packageSign;
  }
  
  public String getVersionCode() {
    return this.versionCode;
  }
  
  public String getVersionName() {
    return this.versionName;
  }
  
  public void setAppName(String paramString) {
    this.appName = paramString;
  }
  
  public void setDeviceHeight(String paramString) {
    this.deviceHeight = paramString;
  }
  
  public void setDeviceSystemName(String paramString) {
    this.deviceSystemName = paramString;
  }
  
  public void setDeviceSystemVersion(String paramString) {
    this.deviceSystemVersion = paramString;
  }
  
  public void setDeviceWidth(String paramString) {
    this.deviceWidth = paramString;
  }
  
  public void setModel(String paramString) {
    this.model = paramString;
  }
  
  public void setNetInfo(String paramString) {
    this.netInfo = paramString;
  }
  
  public void setNetworkType(String paramString) {
    this.networkType = paramString;
  }
  
  public void setOp(String paramString) {
    this.op = paramString;
  }
  
  public void setOperator(String paramString) {
    this.operator = paramString;
  }
  
  public void setPackageName(String paramString) {
    this.packageName = paramString;
  }
  
  public void setPackageSign(String paramString) {
    this.packageSign = paramString;
  }
  
  public void setVersionCode(String paramString) {
    this.versionCode = paramString;
  }
  
  public void setVersionName(String paramString) {
    this.versionName = paramString;
  }
  
  public JSONObject toJSONObject() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("app", a(this.appName));
      jSONObject.put("build", a(this.versionCode));
      jSONObject.put("release", a(this.versionName));
      jSONObject.put("vendor", a(this.packageName));
      jSONObject.put("packagesign", a(this.packageSign));
      jSONObject.put("d_m", a(this.model));
      jSONObject.put("d_s_v", a(this.deviceSystemVersion));
      jSONObject.put("radio", a(this.networkType));
      jSONObject.put("d_s_h", a(this.deviceHeight));
      jSONObject.put("d_s_w", a(this.deviceWidth));
      jSONObject.put("d_s_n", a(this.deviceSystemName));
      jSONObject.put("op", a(this.op));
      jSONObject.put("operator", a(this.operator));
      jSONObject.put("n_i", a(this.netInfo));
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */