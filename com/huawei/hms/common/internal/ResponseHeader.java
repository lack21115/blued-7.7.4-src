package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseHeader implements ResponseErrorCode, IMessageEntity {
  private static final String TAG = "ResponseHeader";
  
  @Packed
  private String api_name;
  
  @Packed
  private String app_id = "";
  
  @Packed
  private int error_code;
  
  @Packed
  private String error_reason;
  
  private Parcelable parcelable;
  
  @Packed
  private String pkg_name;
  
  @Packed
  private String resolution;
  
  @Packed
  private String session_id;
  
  @Packed
  private String srv_name;
  
  @Packed
  private int status_code;
  
  @Packed
  private String transaction_id;
  
  public ResponseHeader() {}
  
  public ResponseHeader(int paramInt1, int paramInt2, String paramString) {
    this.status_code = paramInt1;
    this.error_code = paramInt2;
    this.error_reason = paramString;
  }
  
  public boolean fromJson(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      this.status_code = JsonUtil.getIntValue(jSONObject, "status_code");
      this.error_code = JsonUtil.getIntValue(jSONObject, "error_code");
      this.error_reason = JsonUtil.getStringValue(jSONObject, "error_reason");
      this.srv_name = JsonUtil.getStringValue(jSONObject, "srv_name");
      this.api_name = JsonUtil.getStringValue(jSONObject, "api_name");
      this.app_id = JsonUtil.getStringValue(jSONObject, "app_id");
      this.pkg_name = JsonUtil.getStringValue(jSONObject, "pkg_name");
      this.session_id = JsonUtil.getStringValue(jSONObject, "session_id");
      this.transaction_id = JsonUtil.getStringValue(jSONObject, "transaction_id");
      this.resolution = JsonUtil.getStringValue(jSONObject, "resolution");
      return true;
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fromJson failed: ");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("ResponseHeader", stringBuilder.toString());
      return false;
    } 
  }
  
  public String getActualAppID() {
    if (TextUtils.isEmpty(this.app_id))
      return ""; 
    String[] arrayOfString = this.app_id.split("\\|");
    return (arrayOfString.length == 0) ? "" : ((arrayOfString.length == 1) ? arrayOfString[0] : arrayOfString[1]);
  }
  
  public String getApiName() {
    return this.api_name;
  }
  
  public String getAppID() {
    return this.app_id;
  }
  
  public int getErrorCode() {
    return this.error_code;
  }
  
  public String getErrorReason() {
    return this.error_reason;
  }
  
  public Parcelable getParcelable() {
    return this.parcelable;
  }
  
  public String getPkgName() {
    return this.pkg_name;
  }
  
  public String getResolution() {
    return this.resolution;
  }
  
  public String getSessionId() {
    return this.session_id;
  }
  
  public String getSrvName() {
    return this.srv_name;
  }
  
  public int getStatusCode() {
    return this.status_code;
  }
  
  public String getTransactionId() {
    return this.transaction_id;
  }
  
  public boolean isSuccess() {
    return (this.status_code == 0);
  }
  
  public void setApiName(String paramString) {
    this.api_name = paramString;
  }
  
  public void setAppID(String paramString) {
    this.app_id = paramString;
  }
  
  public void setErrorCode(int paramInt) {
    this.error_code = paramInt;
  }
  
  public void setErrorReason(String paramString) {
    this.error_reason = paramString;
  }
  
  public void setParcelable(Parcelable paramParcelable) {
    this.parcelable = paramParcelable;
  }
  
  public void setPkgName(String paramString) {
    this.pkg_name = paramString;
  }
  
  public void setResolution(String paramString) {
    this.resolution = paramString;
  }
  
  public void setSessionId(String paramString) {
    this.session_id = paramString;
  }
  
  public void setSrvName(String paramString) {
    this.srv_name = paramString;
  }
  
  public void setStatusCode(int paramInt) {
    this.status_code = paramInt;
  }
  
  public void setTransactionId(String paramString) {
    this.transaction_id = paramString;
  }
  
  public String toJson() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("status_code", this.status_code);
      jSONObject.put("error_code", this.error_code);
      jSONObject.put("error_reason", this.error_reason);
      jSONObject.put("srv_name", this.srv_name);
      jSONObject.put("api_name", this.api_name);
      jSONObject.put("app_id", this.app_id);
      jSONObject.put("pkg_name", this.pkg_name);
      if (!TextUtils.isEmpty(this.session_id))
        jSONObject.put("session_id", this.session_id); 
      jSONObject.put("transaction_id", this.transaction_id);
      jSONObject.put("resolution", this.resolution);
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("toJson failed: ");
      stringBuilder.append(jSONException.getMessage());
      HMSLog.e("ResponseHeader", stringBuilder.toString());
    } 
    return jSONObject.toString();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("status_code:");
    stringBuilder.append(this.status_code);
    stringBuilder.append(", error_code");
    stringBuilder.append(this.error_code);
    stringBuilder.append(", api_name:");
    stringBuilder.append(this.api_name);
    stringBuilder.append(", app_id:");
    stringBuilder.append(this.app_id);
    stringBuilder.append(", pkg_name:");
    stringBuilder.append(this.pkg_name);
    stringBuilder.append(", session_id:*, transaction_id:");
    stringBuilder.append(this.transaction_id);
    stringBuilder.append(", resolution:");
    stringBuilder.append(this.resolution);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\ResponseHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */