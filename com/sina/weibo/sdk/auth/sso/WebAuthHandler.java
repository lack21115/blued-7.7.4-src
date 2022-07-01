package com.sina.weibo.sdk.auth.sso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.AuthRequestParam;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;

class WebAuthHandler {
  private static final String NETWORK_NOT_AVAILABLE_EN = "Network is not available";
  
  private static final String NETWORK_NOT_AVAILABLE_ZH_CN = "无法连接到网络，请检查网络配置";
  
  private static final String NETWORK_NOT_AVAILABLE_ZH_TW = "無法連接到網络，請檢查網络配置";
  
  private static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
  
  private static final int OBTAIN_AUTH_CODE = 0;
  
  private static final int OBTAIN_AUTH_TOKEN = 1;
  
  private static final String TAG = WebAuthHandler.class.getName();
  
  private AuthInfo mAuthInfo;
  
  private Context mContext;
  
  public WebAuthHandler(Context paramContext, AuthInfo paramAuthInfo) {
    this.mContext = paramContext;
    this.mAuthInfo = paramAuthInfo;
  }
  
  private void startDialog(WeiboAuthListener paramWeiboAuthListener, int paramInt) {
    if (paramWeiboAuthListener == null)
      return; 
    WeiboParameters weiboParameters = new WeiboParameters(this.mAuthInfo.getAppKey());
    weiboParameters.put("client_id", this.mAuthInfo.getAppKey());
    weiboParameters.put("redirect_uri", this.mAuthInfo.getRedirectUrl());
    weiboParameters.put("scope", this.mAuthInfo.getScope());
    weiboParameters.put("response_type", "code");
    weiboParameters.put("version", "0031405000");
    String str2 = Utility.getAid(this.mContext, this.mAuthInfo.getAppKey());
    if (!TextUtils.isEmpty(str2))
      weiboParameters.put("aid", str2); 
    if (1 == paramInt) {
      weiboParameters.put("packagename", this.mAuthInfo.getPackageName());
      weiboParameters.put("key_hash", this.mAuthInfo.getKeyHash());
    } 
    StringBuilder stringBuilder = new StringBuilder("https://open.weibo.cn/oauth2/authorize?");
    stringBuilder.append(weiboParameters.encodeUrl());
    String str1 = stringBuilder.toString();
    if (!NetworkHelper.hasInternetPermission(this.mContext)) {
      UIUtils.showAlert(this.mContext, "Error", "Application requires permission to access the Internet");
      return;
    } 
    AuthRequestParam authRequestParam = new AuthRequestParam(this.mContext);
    authRequestParam.setAuthInfo(this.mAuthInfo);
    authRequestParam.setAuthListener(paramWeiboAuthListener);
    authRequestParam.setUrl(str1);
    authRequestParam.setSpecifyTitle("微博登录");
    Bundle bundle = authRequestParam.createRequestParamBundle();
    Intent intent = new Intent(this.mContext, WeiboSdkBrowser.class);
    intent.putExtras(bundle);
    this.mContext.startActivity(intent);
  }
  
  public void anthorize(WeiboAuthListener paramWeiboAuthListener) {
    authorize(paramWeiboAuthListener, 1);
  }
  
  public void authorize(WeiboAuthListener paramWeiboAuthListener, int paramInt) {
    startDialog(paramWeiboAuthListener, paramInt);
  }
  
  public AuthInfo getAuthInfo() {
    return this.mAuthInfo;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\auth\sso\WebAuthHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */