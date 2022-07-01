package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestHeader implements IMessageEntity {
  private static final String TAG = "RequestHeader";
  
  @Packed
  private int apiLevel;
  
  @Packed
  private String api_name;
  
  @Packed
  private String app_id = "";
  
  @Packed
  private int kitSdkVersion;
  
  private Parcelable parcelable;
  
  @Packed
  private String pkg_name;
  
  @Packed
  private int sdk_version = 50004301;
  
  @Packed
  private String session_id;
  
  @Packed
  private String srv_name;
  
  @Packed
  private String transaction_id;
  
  @Packed
  private String version = "4.0";
  
  public boolean fromJson(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      this.version = JsonUtil.getStringValue(jSONObject, "version");
      this.srv_name = JsonUtil.getStringValue(jSONObject, "srv_name");
      this.api_name = JsonUtil.getStringValue(jSONObject, "api_name");
      this.app_id = JsonUtil.getStringValue(jSONObject, "app_id");
      this.pkg_name = JsonUtil.getStringValue(jSONObject, "pkg_name");
      this.sdk_version = JsonUtil.getIntValue(jSONObject, "sdk_version");
      this.kitSdkVersion = JsonUtil.getIntValue(jSONObject, "kitSdkVersion");
      this.apiLevel = JsonUtil.getIntValue(jSONObject, "apiLevel");
      this.session_id = JsonUtil.getStringValue(jSONObject, "session_id");
      this.transaction_id = JsonUtil.getStringValue(jSONObject, "transaction_id");
      return true;
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fromJson failed: ");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("RequestHeader", stringBuilder.toString());
      return false;
    } 
  }
  
  public String getActualAppID() {
    if (TextUtils.isEmpty(this.app_id))
      return ""; 
    String[] arrayOfString = this.app_id.split("\\|");
    return (arrayOfString.length == 0) ? "" : ((arrayOfString.length == 1) ? arrayOfString[0] : arrayOfString[1]);
  }
  
  public int getApiLevel() {
    return this.apiLevel;
  }
  
  public String getApiName() {
    return this.api_name;
  }
  
  public String getAppID() {
    return this.app_id;
  }
  
  public int getKitSdkVersion() {
    return this.kitSdkVersion;
  }
  
  public Parcelable getParcelable() {
    return this.parcelable;
  }
  
  public String getPkgName() {
    return this.pkg_name;
  }
  
  public int getSdkVersion() {
    return this.sdk_version;
  }
  
  public String getSessionId() {
    return this.session_id;
  }
  
  public String getSrvName() {
    return this.srv_name;
  }
  
  public String getTransactionId() {
    return this.transaction_id;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public void setApiLevel(int paramInt) {
    this.apiLevel = paramInt;
  }
  
  public void setApiName(String paramString) {
    this.api_name = paramString;
  }
  
  public void setAppID(String paramString) {
    this.app_id = paramString;
  }
  
  public void setKitSdkVersion(int paramInt) {
    this.kitSdkVersion = paramInt;
  }
  
  public void setParcelable(Parcelable paramParcelable) {
    this.parcelable = paramParcelable;
  }
  
  public void setPkgName(String paramString) {
    this.pkg_name = paramString;
  }
  
  public void setSdkVersion(int paramInt) {
    this.sdk_version = paramInt;
  }
  
  public void setSessionId(String paramString) {
    this.session_id = paramString;
  }
  
  public void setSrvName(String paramString) {
    this.srv_name = paramString;
  }
  
  public void setTransactionId(String paramString) {
    this.transaction_id = paramString;
  }
  
  public void setVersion(String paramString) {
    this.version = paramString;
  }
  
  public String toJson() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("version", this.version);
      jSONObject.put("srv_name", this.srv_name);
      jSONObject.put("api_name", this.api_name);
      jSONObject.put("app_id", this.app_id);
      jSONObject.put("pkg_name", this.pkg_name);
      jSONObject.put("sdk_version", this.sdk_version);
      jSONObject.put("kitSdkVersion", this.kitSdkVersion);
      jSONObject.put("apiLevel", this.apiLevel);
      if (!TextUtils.isEmpty(this.session_id))
        jSONObject.put("session_id", this.session_id); 
      jSONObject.put("transaction_id", this.transaction_id);
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("toJson failed: ");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("RequestHeader", stringBuilder.toString());
    } 
    return jSONObject.toString();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("api_name:");
    stringBuilder.append(this.api_name);
    stringBuilder.append(", app_id:");
    stringBuilder.append(this.app_id);
    stringBuilder.append(", pkg_name:");
    stringBuilder.append(this.pkg_name);
    stringBuilder.append(", sdk_version:");
    stringBuilder.append(this.sdk_version);
    stringBuilder.append(", session_id:*, transaction_id:");
    stringBuilder.append(this.transaction_id);
    stringBuilder.append(", kitSdkVersion:");
    stringBuilder.append(this.kitSdkVersion);
    stringBuilder.append(", apiLevel:");
    stringBuilder.append(this.apiLevel);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\RequestHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */