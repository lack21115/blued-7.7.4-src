package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

public class GameRequestParam extends BrowserRequestParamBase {
  private String mAppKey;
  
  private WeiboAuthListener mAuthListener;
  
  private String mAuthListenerKey;
  
  private String mToken;
  
  public GameRequestParam(Context paramContext) {
    super(paramContext);
  }
  
  private String buildUrl(String paramString) {
    Uri.Builder builder = Uri.parse(paramString).buildUpon();
    builder.appendQueryParameter("version", "0031405000");
    if (!TextUtils.isEmpty(this.mAppKey))
      builder.appendQueryParameter("source", this.mAppKey); 
    if (!TextUtils.isEmpty(this.mToken))
      builder.appendQueryParameter("access_token", this.mToken); 
    return builder.build().toString();
  }
  
  public void execRequest(Activity paramActivity, int paramInt) {}
  
  public String getAppKey() {
    return this.mAppKey;
  }
  
  public WeiboAuthListener getAuthListener() {
    return this.mAuthListener;
  }
  
  public String getAuthListenerKey() {
    return this.mAuthListenerKey;
  }
  
  public String getToken() {
    return this.mToken;
  }
  
  public void onCreateRequestParamBundle(Bundle paramBundle) {
    paramBundle.putString("access_token", this.mToken);
    paramBundle.putString("source", this.mAppKey);
    WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
    if (this.mAuthListener != null) {
      this.mAuthListenerKey = weiboCallbackManager.genCallbackKey();
      weiboCallbackManager.setWeiboAuthListener(this.mAuthListenerKey, this.mAuthListener);
      paramBundle.putString("key_listener", this.mAuthListenerKey);
    } 
  }
  
  protected void onSetupRequestParam(Bundle paramBundle) {
    this.mAppKey = paramBundle.getString("source");
    this.mToken = paramBundle.getString("access_token");
    this.mAuthListenerKey = paramBundle.getString("key_listener");
    if (!TextUtils.isEmpty(this.mAuthListenerKey))
      this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey); 
    this.mUrl = buildUrl(this.mUrl);
  }
  
  public void setAppKey(String paramString) {
    this.mAppKey = paramString;
  }
  
  public void setAuthListener(WeiboAuthListener paramWeiboAuthListener) {
    this.mAuthListener = paramWeiboAuthListener;
  }
  
  public void setToken(String paramString) {
    this.mToken = paramString;
  }
  
  public static interface WidgetRequestCallback {
    void onWebViewResult(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\GameRequestParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */