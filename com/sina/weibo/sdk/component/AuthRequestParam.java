package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

public class AuthRequestParam extends BrowserRequestParamBase {
  public static final String EXTRA_KEY_AUTHINFO = "key_authinfo";
  
  public static final String EXTRA_KEY_LISTENER = "key_listener";
  
  private AuthInfo mAuthInfo;
  
  private WeiboAuthListener mAuthListener;
  
  private String mAuthListenerKey;
  
  public AuthRequestParam(Context paramContext) {
    super(paramContext);
  }
  
  public void execRequest(Activity paramActivity, int paramInt) {
    if (paramInt == 3) {
      WeiboAuthListener weiboAuthListener = this.mAuthListener;
      if (weiboAuthListener != null)
        weiboAuthListener.onCancel(); 
      WeiboSdkBrowser.closeBrowser(paramActivity, this.mAuthListenerKey, null);
    } 
  }
  
  public AuthInfo getAuthInfo() {
    return this.mAuthInfo;
  }
  
  public WeiboAuthListener getAuthListener() {
    return this.mAuthListener;
  }
  
  public String getAuthListenerKey() {
    return this.mAuthListenerKey;
  }
  
  public void onCreateRequestParamBundle(Bundle paramBundle) {
    AuthInfo authInfo = this.mAuthInfo;
    if (authInfo != null)
      paramBundle.putBundle("key_authinfo", authInfo.getAuthBundle()); 
    if (this.mAuthListener != null) {
      WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
      this.mAuthListenerKey = weiboCallbackManager.genCallbackKey();
      weiboCallbackManager.setWeiboAuthListener(this.mAuthListenerKey, this.mAuthListener);
      paramBundle.putString("key_listener", this.mAuthListenerKey);
    } 
  }
  
  protected void onSetupRequestParam(Bundle paramBundle) {
    Bundle bundle = paramBundle.getBundle("key_authinfo");
    if (bundle != null)
      this.mAuthInfo = AuthInfo.parseBundleData(this.mContext, bundle); 
    this.mAuthListenerKey = paramBundle.getString("key_listener");
    if (!TextUtils.isEmpty(this.mAuthListenerKey))
      this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey); 
  }
  
  public void setAuthInfo(AuthInfo paramAuthInfo) {
    this.mAuthInfo = paramAuthInfo;
  }
  
  public void setAuthListener(WeiboAuthListener paramWeiboAuthListener) {
    this.mAuthListener = paramWeiboAuthListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\AuthRequestParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */