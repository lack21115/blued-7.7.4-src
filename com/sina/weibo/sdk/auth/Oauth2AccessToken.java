package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth2AccessToken {
  public static final String KEY_ACCESS_TOKEN = "access_token";
  
  public static final String KEY_EXPIRES_IN = "expires_in";
  
  public static final String KEY_PHONE_NUM = "phone_num";
  
  public static final String KEY_REFRESH_TOKEN = "refresh_token";
  
  public static final String KEY_UID = "uid";
  
  private String mAccessToken = "";
  
  private long mExpiresTime = 0L;
  
  private String mPhoneNum = "";
  
  private String mRefreshToken = "";
  
  private String mUid = "";
  
  public Oauth2AccessToken() {}
  
  @Deprecated
  public Oauth2AccessToken(String paramString) {
    if (paramString != null && paramString.indexOf("{") >= 0)
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        setUid(jSONObject.optString("uid"));
        setToken(jSONObject.optString("access_token"));
        setExpiresIn(jSONObject.optString("expires_in"));
        setRefreshToken(jSONObject.optString("refresh_token"));
        setPhoneNum(jSONObject.optString("phone_num"));
        return;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
  }
  
  public Oauth2AccessToken(String paramString1, String paramString2) {
    this.mAccessToken = paramString1;
    this.mExpiresTime = System.currentTimeMillis();
    if (paramString2 != null)
      this.mExpiresTime += Long.parseLong(paramString2) * 1000L; 
  }
  
  private static String getString(Bundle paramBundle, String paramString1, String paramString2) {
    if (paramBundle != null) {
      String str = paramBundle.getString(paramString1);
      return (str != null) ? str : paramString2;
    } 
    return paramString2;
  }
  
  public static Oauth2AccessToken parseAccessToken(Bundle paramBundle) {
    if (paramBundle != null) {
      Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
      oauth2AccessToken.setUid(getString(paramBundle, "uid", ""));
      oauth2AccessToken.setToken(getString(paramBundle, "access_token", ""));
      oauth2AccessToken.setExpiresIn(getString(paramBundle, "expires_in", ""));
      oauth2AccessToken.setRefreshToken(getString(paramBundle, "refresh_token", ""));
      oauth2AccessToken.setPhoneNum(getString(paramBundle, "phone_num", ""));
      return oauth2AccessToken;
    } 
    return null;
  }
  
  public static Oauth2AccessToken parseAccessToken(String paramString) {
    if (!TextUtils.isEmpty(paramString) && paramString.indexOf("{") >= 0)
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        oauth2AccessToken.setUid(jSONObject.optString("uid"));
        oauth2AccessToken.setToken(jSONObject.optString("access_token"));
        oauth2AccessToken.setExpiresIn(jSONObject.optString("expires_in"));
        oauth2AccessToken.setRefreshToken(jSONObject.optString("refresh_token"));
        oauth2AccessToken.setPhoneNum(jSONObject.optString("phone_num"));
        return oauth2AccessToken;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
    return null;
  }
  
  private void setPhoneNum(String paramString) {
    this.mPhoneNum = paramString;
  }
  
  public long getExpiresTime() {
    return this.mExpiresTime;
  }
  
  public String getPhoneNum() {
    return this.mPhoneNum;
  }
  
  public String getRefreshToken() {
    return this.mRefreshToken;
  }
  
  public String getToken() {
    return this.mAccessToken;
  }
  
  public String getUid() {
    return this.mUid;
  }
  
  public boolean isSessionValid() {
    return TextUtils.isEmpty(this.mAccessToken) ^ true;
  }
  
  public void setExpiresIn(String paramString) {
    if (!TextUtils.isEmpty(paramString) && !paramString.equals("0"))
      setExpiresTime(System.currentTimeMillis() + Long.parseLong(paramString) * 1000L); 
  }
  
  public void setExpiresTime(long paramLong) {
    this.mExpiresTime = paramLong;
  }
  
  public void setRefreshToken(String paramString) {
    this.mRefreshToken = paramString;
  }
  
  public void setToken(String paramString) {
    this.mAccessToken = paramString;
  }
  
  public void setUid(String paramString) {
    this.mUid = paramString;
  }
  
  public Bundle toBundle() {
    Bundle bundle = new Bundle();
    bundle.putString("uid", this.mUid);
    bundle.putString("access_token", this.mAccessToken);
    bundle.putString("refresh_token", this.mRefreshToken);
    bundle.putString("expires_in", Long.toString(this.mExpiresTime));
    bundle.putString("phone_num", this.mPhoneNum);
    return bundle;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("uid: ");
    stringBuilder.append(this.mUid);
    stringBuilder.append(", ");
    stringBuilder.append("access_token");
    stringBuilder.append(": ");
    stringBuilder.append(this.mAccessToken);
    stringBuilder.append(", ");
    stringBuilder.append("refresh_token");
    stringBuilder.append(": ");
    stringBuilder.append(this.mRefreshToken);
    stringBuilder.append(", ");
    stringBuilder.append("phone_num");
    stringBuilder.append(": ");
    stringBuilder.append(this.mPhoneNum);
    stringBuilder.append(", ");
    stringBuilder.append("expires_in");
    stringBuilder.append(": ");
    stringBuilder.append(Long.toString(this.mExpiresTime));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\auth\Oauth2AccessToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */