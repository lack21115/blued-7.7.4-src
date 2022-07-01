package com.huawei.hms.support.api.entity.auth;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

public class AuthorizationInfo implements IMessageEntity {
  @Packed
  private String accessToken;
  
  @Packed
  private String appID;
  
  @Packed
  private String clientID;
  
  @Packed
  private String clientSecret;
  
  @Packed
  private long expiredTime;
  
  @Packed
  private String openID;
  
  @Packed
  private String refreshToken;
  
  @Packed
  private List<String> scopeList;
  
  public String getAccessToken() {
    return this.accessToken;
  }
  
  public String getAppID() {
    return this.appID;
  }
  
  public String getClientID() {
    return this.clientID;
  }
  
  public String getClientSecret() {
    return this.clientSecret;
  }
  
  public long getExpiredTime() {
    return this.expiredTime;
  }
  
  public String getOpenId() {
    return this.openID;
  }
  
  public String getRefreshToken() {
    return this.refreshToken;
  }
  
  public List<String> getScopeList() {
    return this.scopeList;
  }
  
  public boolean isTokenExpire() {
    return (System.currentTimeMillis() > this.expiredTime);
  }
  
  public boolean isValid() {
    return TextUtils.isEmpty(this.appID);
  }
  
  public void setAccessToken(String paramString) {
    this.accessToken = paramString;
  }
  
  public void setAppID(String paramString) {
    this.appID = paramString;
  }
  
  public void setClientID(String paramString) {
    this.clientID = paramString;
  }
  
  public void setClientSecret(String paramString) {
    this.clientSecret = paramString;
  }
  
  public void setExpiredTime(long paramLong) {
    this.expiredTime = paramLong;
  }
  
  public void setOpenID(String paramString) {
    this.openID = paramString;
  }
  
  public void setRefreshToken(String paramString) {
    this.refreshToken = paramString;
  }
  
  public void setScopeList(List<String> paramList) {
    this.scopeList = paramList;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("appID:");
    stringBuilder.append(this.appID);
    stringBuilder.append(", expiredTime:");
    stringBuilder.append(this.expiredTime);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\AuthorizationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */