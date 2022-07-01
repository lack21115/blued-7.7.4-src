package com.sina.weibo.sdk.api.pay;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.share.IWeiboDownloadListener;
import com.sina.weibo.sdk.exception.WeiboShareException;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;

public class WeiboPayImpl {
  private static final String TAG = WeiboPayImpl.class.getName();
  
  private String mAppKey;
  
  private Context mContext;
  
  private Dialog mDownloadConfirmDialog = null;
  
  private IWeiboDownloadListener mDownloadListener;
  
  private boolean mNeedDownloadWeibo = true;
  
  private WeiboAppManager.WeiboInfo mWeiboInfo = null;
  
  public WeiboPayImpl(Context paramContext, String paramString, boolean paramBoolean) {
    this.mContext = paramContext;
    this.mAppKey = paramString;
    this.mWeiboInfo = WeiboAppManager.getInstance(paramContext).getWeiboInfo();
    WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
    if (weiboInfo != null) {
      LogUtil.d(TAG, weiboInfo.toString());
    } else {
      LogUtil.d(TAG, "WeiboInfo is null");
    } 
    AidTask.getInstance(paramContext).aidTaskInit(paramString);
  }
  
  private boolean checkEnvironment(boolean paramBoolean) throws WeiboShareException {
    return true;
  }
  
  private boolean launchWeiboActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, Bundle paramBundle) {
    if (paramActivity == null || TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2) || TextUtils.isEmpty(paramString3)) {
      LogUtil.e(TAG, "launchWeiboActivity fail, invalid arguments");
      return false;
    } 
    Intent intent = new Intent();
    intent.setPackage(paramString2);
    intent.setAction(paramString1);
    paramString1 = paramActivity.getPackageName();
    intent.putExtra("_weibo_sdkVersion", "0031405000");
    intent.putExtra("_weibo_appPackage", paramString1);
    intent.putExtra("_weibo_appKey", paramString3);
    intent.putExtra("_weibo_flag", 538116905);
    intent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign((Context)paramActivity, paramString1)));
    if (paramBundle != null)
      intent.putExtras(paramBundle); 
    try {
      paramString1 = TAG;
      StringBuilder stringBuilder = new StringBuilder("launchWeiboActivity intent=");
      stringBuilder.append(intent);
      stringBuilder.append(", extra=");
      stringBuilder.append(intent.getExtras());
      LogUtil.d(paramString1, stringBuilder.toString());
      paramActivity.startActivityForResult(intent, 765);
      return true;
    } catch (ActivityNotFoundException activityNotFoundException) {
      LogUtil.e(TAG, activityNotFoundException.getMessage());
      return false;
    } 
  }
  
  public int getWeiboAppSupportAPI() {
    WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
    return (weiboInfo == null || !weiboInfo.isLegal()) ? -1 : this.mWeiboInfo.getSupportApi();
  }
  
  public boolean isSupportWeiboPay() {
    return (getWeiboAppSupportAPI() >= 10353);
  }
  
  public boolean isWeiboAppInstalled() {
    return true;
  }
  
  public boolean isWeiboAppSupportAPI() {
    return (getWeiboAppSupportAPI() >= 10350);
  }
  
  public boolean launchWeiboPay(Activity paramActivity, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("rawdata", paramString);
    bundle.putInt("_weibo_command_type", 4);
    bundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
    return launchWeiboActivity(paramActivity, "com.sina.weibo.sdk.action.ACTION_WEIBO_PAY_ACTIVITY", this.mWeiboInfo.getPackageName(), this.mAppKey, bundle);
  }
  
  public void registerWeiboDownloadListener(IWeiboDownloadListener paramIWeiboDownloadListener) {
    this.mDownloadListener = paramIWeiboDownloadListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\pay\WeiboPayImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */