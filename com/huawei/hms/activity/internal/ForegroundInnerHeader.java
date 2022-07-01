package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ForegroundInnerHeader {
  private final String TAG = "ForegroundInnerHeader";
  
  private String action;
  
  private int apkVersion;
  
  private String responseCallbackKey;
  
  public void fromJson(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      this.apkVersion = JsonUtil.getIntValue(jSONObject, "apkVersion");
      this.action = JsonUtil.getStringValue(jSONObject, "action");
      this.responseCallbackKey = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
      return;
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fromJson failed: ");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("ForegroundInnerHeader", stringBuilder.toString());
      return;
    } 
  }
  
  public String getAction() {
    return this.action;
  }
  
  public int getApkVersion() {
    return this.apkVersion;
  }
  
  public String getResponseCallbackKey() {
    return this.responseCallbackKey;
  }
  
  public void setAction(String paramString) {
    this.action = paramString;
  }
  
  public void setApkVersion(int paramInt) {
    this.apkVersion = paramInt;
  }
  
  public void setResponseCallbackKey(String paramString) {
    this.responseCallbackKey = paramString;
  }
  
  public String toJson() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("apkVersion", this.apkVersion);
      jSONObject.put("action", this.action);
      jSONObject.put("responseCallbackKey", this.responseCallbackKey);
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ForegroundInnerHeader toJson failed: ");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("ForegroundInnerHeader", stringBuilder.toString());
    } 
    return jSONObject.toString();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("apkVersion:");
    stringBuilder.append(this.apkVersion);
    stringBuilder.append(", action:");
    stringBuilder.append(this.action);
    stringBuilder.append(", responseCallbackKey:");
    stringBuilder.append(this.responseCallbackKey);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\activity\internal\ForegroundInnerHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */