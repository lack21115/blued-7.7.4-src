package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

public interface IWeiboShareAPI {
  int getWeiboAppSupportAPI();
  
  boolean handleWeiboRequest(Intent paramIntent, IWeiboHandler.Request paramRequest);
  
  boolean handleWeiboResponse(Intent paramIntent, IWeiboHandler.Response paramResponse);
  
  boolean isSupportWeiboPay();
  
  boolean isWeiboAppInstalled();
  
  boolean isWeiboAppSupportAPI();
  
  boolean launchWeibo(Activity paramActivity);
  
  boolean launchWeiboPay(Activity paramActivity, String paramString);
  
  boolean launchWeiboPayLogin(Activity paramActivity, String paramString);
  
  boolean registerApp();
  
  boolean sendRequest(Activity paramActivity, BaseRequest paramBaseRequest);
  
  boolean sendRequest(Activity paramActivity, BaseRequest paramBaseRequest, AuthInfo paramAuthInfo, String paramString, WeiboAuthListener paramWeiboAuthListener);
  
  boolean sendResponse(BaseResponse paramBaseResponse);
  
  void shareMessageToWeiyou(Context paramContext, Bundle paramBundle);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\share\IWeiboShareAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */