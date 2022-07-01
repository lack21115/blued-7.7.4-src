package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.utils.Utility;

public class AuthInfo {
  private String mAppKey = "";
  
  private String mKeyHash = "";
  
  private String mPackageName = "";
  
  private String mRedirectUrl = "";
  
  private String mScope = "";
  
  public AuthInfo(Context paramContext, String paramString1, String paramString2, String paramString3) {
    this.mAppKey = paramString1;
    this.mRedirectUrl = paramString2;
    this.mScope = paramString3;
    this.mPackageName = paramContext.getPackageName();
    this.mKeyHash = Utility.getSign(paramContext, this.mPackageName);
  }
  
  public static AuthInfo parseBundleData(Context paramContext, Bundle paramBundle) {
    return new AuthInfo(paramContext, paramBundle.getString("appKey"), paramBundle.getString("redirectUri"), paramBundle.getString("scope"));
  }
  
  public String getAppKey() {
    return this.mAppKey;
  }
  
  public Bundle getAuthBundle() {
    Bundle bundle = new Bundle();
    bundle.putString("appKey", this.mAppKey);
    bundle.putString("redirectUri", this.mRedirectUrl);
    bundle.putString("scope", this.mScope);
    bundle.putString("packagename", this.mPackageName);
    bundle.putString("key_hash", this.mKeyHash);
    return bundle;
  }
  
  public String getKeyHash() {
    return this.mKeyHash;
  }
  
  public String getPackageName() {
    return this.mPackageName;
  }
  
  public String getRedirectUrl() {
    return this.mRedirectUrl;
  }
  
  public String getScope() {
    return this.mScope;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\auth\AuthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */