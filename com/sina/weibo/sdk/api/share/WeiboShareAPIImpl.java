package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.ShareRequestParam;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.exception.WeiboShareException;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;

class WeiboShareAPIImpl implements IWeiboShareAPI {
  private static final String TAG = WeiboShareAPIImpl.class.getName();
  
  private String mAppKey;
  
  private Context mContext;
  
  private Dialog mDownloadConfirmDialog = null;
  
  private IWeiboDownloadListener mDownloadListener;
  
  private boolean mNeedDownloadWeibo = true;
  
  private WeiboAppManager.WeiboInfo mWeiboInfo = null;
  
  public WeiboShareAPIImpl(Context paramContext, String paramString, boolean paramBoolean) {
    this.mContext = paramContext;
    this.mAppKey = paramString;
    this.mNeedDownloadWeibo = paramBoolean;
    this.mWeiboInfo = WeiboAppManager.getInstance(paramContext).getWeiboInfo();
    WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
    if (weiboInfo != null) {
      LogUtil.d(TAG, weiboInfo.toString());
    } else {
      LogUtil.d(TAG, "WeiboInfo is null");
    } 
    AidTask.getInstance(paramContext).aidTaskInit(paramString);
  }
  
  private WeiboMessage adapterMultiMessage2SingleMessage(WeiboMultiMessage paramWeiboMultiMessage) {
    if (paramWeiboMultiMessage == null)
      return new WeiboMessage(); 
    Bundle bundle = new Bundle();
    paramWeiboMultiMessage.toBundle(bundle);
    return new WeiboMessage(bundle);
  }
  
  private boolean checkEnvironment(boolean paramBoolean) throws WeiboShareException {
    if (!isWeiboAppInstalled()) {
      if (paramBoolean) {
        Dialog dialog = this.mDownloadConfirmDialog;
        if (dialog == null) {
          this.mDownloadConfirmDialog = WeiboDownloader.createDownloadConfirmDialog(this.mContext, this.mDownloadListener);
          this.mDownloadConfirmDialog.show();
        } else if (!dialog.isShowing()) {
          this.mDownloadConfirmDialog.show();
        } 
        return false;
      } 
      throw new WeiboShareException("Weibo is not installed!");
    } 
    if (isWeiboAppSupportAPI()) {
      if (ApiUtils.validateWeiboSign(this.mContext, this.mWeiboInfo.getPackageName()))
        return true; 
      throw new WeiboShareException("Weibo signature is incorrect!");
    } 
    throw new WeiboShareException("Weibo do not support share api!");
  }
  
  private boolean launchWeiboActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, Bundle paramBundle, String paramString4) {
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
    paramString1 = String.valueOf(System.currentTimeMillis());
    intent.putExtra("_weibo_transaction", paramString1);
    addEventLog((Context)paramActivity, paramString1, paramString4);
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
  
  private void registerWeiboDownloadListener(IWeiboDownloadListener paramIWeiboDownloadListener) {
    this.mDownloadListener = paramIWeiboDownloadListener;
  }
  
  private void sendBroadcast(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle) {
    Intent intent = new Intent(paramString1);
    String str = paramContext.getPackageName();
    intent.putExtra("_weibo_sdkVersion", "0031405000");
    intent.putExtra("_weibo_appPackage", str);
    intent.putExtra("_weibo_appKey", paramString2);
    intent.putExtra("_weibo_flag", 538116905);
    intent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(paramContext, str)));
    if (!TextUtils.isEmpty(paramString3))
      intent.setPackage(paramString3); 
    if (paramBundle != null)
      intent.putExtras(paramBundle); 
    paramString2 = TAG;
    StringBuilder stringBuilder = new StringBuilder("intent=");
    stringBuilder.append(intent);
    stringBuilder.append(", extra=");
    stringBuilder.append(intent.getExtras());
    LogUtil.d(paramString2, stringBuilder.toString());
    paramContext.sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
  }
  
  private boolean startShareWeiboActivity(Activity paramActivity, String paramString, BaseRequest paramBaseRequest, WeiboAuthListener paramWeiboAuthListener) {
    try {
      WbAppActivator.getInstance(this.mContext, this.mAppKey).activateApp();
      new Bundle();
      String str = paramActivity.getPackageName();
      ShareRequestParam shareRequestParam = new ShareRequestParam((Context)paramActivity);
      shareRequestParam.setToken(paramString);
      shareRequestParam.setAppKey(this.mAppKey);
      shareRequestParam.setAppPackage(str);
      shareRequestParam.setBaseRequest(paramBaseRequest);
      shareRequestParam.setSpecifyTitle("微博分享");
      shareRequestParam.setAuthListener(paramWeiboAuthListener);
      Intent intent = new Intent((Context)paramActivity, WeiboSdkBrowser.class);
      intent.putExtras(shareRequestParam.createRequestParamBundle());
      paramActivity.startActivity(intent);
      return true;
    } catch (ActivityNotFoundException activityNotFoundException) {
      return false;
    } 
  }
  
  public void addEventLog(Context paramContext, String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("other_app_action_start_time", paramString1);
    try {
      WBAgent.onEvent(paramContext, paramString2, hashMap);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public int getWeiboAppSupportAPI() {
    WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
    return (weiboInfo == null || !weiboInfo.isLegal()) ? -1 : this.mWeiboInfo.getSupportApi();
  }
  
  public boolean handleWeiboRequest(Intent paramIntent, IWeiboHandler.Request paramRequest) {
    if (paramIntent != null) {
      if (paramRequest == null)
        return false; 
      String str1 = paramIntent.getStringExtra("_weibo_appPackage");
      String str2 = paramIntent.getStringExtra("_weibo_transaction");
      if (TextUtils.isEmpty(str1)) {
        LogUtil.e(TAG, "handleWeiboRequest faild appPackage validateSign faild");
        paramRequest.onRequest(null);
        return false;
      } 
      if (TextUtils.isEmpty(str2)) {
        LogUtil.e(TAG, "handleWeiboRequest faild intent _weibo_transaction is null");
        paramRequest.onRequest(null);
        return false;
      } 
      if (!ApiUtils.validateWeiboSign(this.mContext, str1)) {
        LogUtil.e(TAG, "handleWeiboRequest faild appPackage validateSign faild");
        paramRequest.onRequest(null);
        return false;
      } 
      paramRequest.onRequest(new ProvideMessageForWeiboRequest(paramIntent.getExtras()));
      return true;
    } 
    return false;
  }
  
  public boolean handleWeiboResponse(Intent paramIntent, IWeiboHandler.Response paramResponse) {
    String str1 = paramIntent.getStringExtra("_weibo_appPackage");
    String str2 = paramIntent.getStringExtra("_weibo_transaction");
    if (TextUtils.isEmpty(str1)) {
      LogUtil.e(TAG, "handleWeiboResponse faild appPackage is null");
      return false;
    } 
    if (!(paramResponse instanceof Activity)) {
      LogUtil.e(TAG, "handleWeiboResponse faild handler is not Activity");
      return false;
    } 
    Activity activity = (Activity)paramResponse;
    String str3 = activity.getCallingPackage();
    String str4 = TAG;
    StringBuilder stringBuilder = new StringBuilder("handleWeiboResponse getCallingPackage : ");
    stringBuilder.append(str3);
    LogUtil.d(str4, stringBuilder.toString());
    if (TextUtils.isEmpty(str2)) {
      LogUtil.e(TAG, "handleWeiboResponse faild intent _weibo_transaction is null");
      return false;
    } 
    if (!ApiUtils.validateWeiboSign(this.mContext, str1) && !str1.equals(activity.getPackageName())) {
      LogUtil.e(TAG, "handleWeiboResponse faild appPackage validateSign faild");
      return false;
    } 
    paramResponse.onResponse(new SendMessageToWeiboResponse(paramIntent.getExtras()));
    return true;
  }
  
  public boolean isSupportWeiboPay() {
    return (getWeiboAppSupportAPI() >= 10353);
  }
  
  public boolean isWeiboAppInstalled() {
    WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
    return (weiboInfo != null && weiboInfo.isLegal());
  }
  
  public boolean isWeiboAppSupportAPI() {
    return (getWeiboAppSupportAPI() >= 10350);
  }
  
  public boolean launchWeibo(Activity paramActivity) {
    if (!isWeiboAppInstalled()) {
      LogUtil.e(TAG, "launchWeibo faild WeiboInfo is null");
      return false;
    } 
    try {
      paramActivity.startActivity(paramActivity.getPackageManager().getLaunchIntentForPackage(this.mWeiboInfo.getPackageName()));
      return true;
    } catch (Exception exception) {
      LogUtil.e(TAG, exception.getMessage());
      return false;
    } 
  }
  
  public boolean launchWeiboPay(Activity paramActivity, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("rawdata", paramString);
    bundle.putInt("_weibo_command_type", 4);
    bundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
    return launchWeiboActivity(paramActivity, "com.sina.weibo.sdk.action.ACTION_WEIBO_PAY_ACTIVITY", this.mWeiboInfo.getPackageName(), this.mAppKey, bundle, "pay");
  }
  
  public boolean launchWeiboPayLogin(Activity paramActivity, String paramString) {
    if (!Utility.isWeiBoVersionSupportNewPay((Context)paramActivity).booleanValue())
      return launchWeiboPay(paramActivity, paramString); 
    if (paramActivity == null) {
      LogUtil.e(TAG, "launchWeiboActivity fail, invalid arguments");
      return false;
    } 
    Bundle bundle = new Bundle();
    bundle.putString("rawdata", paramString);
    bundle.putInt("_weibo_command_type", 4);
    String str1 = String.valueOf(System.currentTimeMillis());
    bundle.putString("_weibo_transaction", str1);
    Intent intent = new Intent();
    intent.setPackage(this.mWeiboInfo.getPackageName());
    intent.setData(Uri.parse("sinaweibo://sdkdeliver"));
    String str2 = paramActivity.getPackageName();
    intent.putExtra("_weibo_sdkVersion", "0031405000");
    intent.putExtra("_weibo_appPackage", str2);
    intent.putExtra("_weibo_appKey", this.mAppKey);
    intent.putExtra("_weibo_flag", 538116905);
    intent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign((Context)paramActivity, str2)));
    intent.putExtra("sdk_real_action", "com.sina.weibo.sdk.action.ACTION_WEIBO_PAY_ACTIVITY");
    intent.putExtra("sdk_is_scheme", false);
    intent.putExtra("sdk_requestcode", 765);
    intent.putExtra("_weibo_transaction", str1);
    addEventLog((Context)paramActivity, str1, "pay");
    intent.putExtras(bundle);
    try {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder("launchWeiboActivity intent=");
      stringBuilder.append(intent);
      stringBuilder.append(", extra=");
      stringBuilder.append(intent.getExtras());
      LogUtil.d(str, stringBuilder.toString());
      paramActivity.startActivityForResult(intent, 765);
      return true;
    } catch (ActivityNotFoundException activityNotFoundException) {
      LogUtil.e(TAG, activityNotFoundException.getMessage());
      return false;
    } 
  }
  
  public boolean registerApp() {
    sendBroadcast(this.mContext, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER", this.mAppKey, null, null);
    return true;
  }
  
  public boolean sendRequest(Activity paramActivity, BaseRequest paramBaseRequest) {
    if (paramBaseRequest == null) {
      LogUtil.e(TAG, "sendRequest faild request is null");
      return false;
    } 
    try {
      boolean bool = checkEnvironment(this.mNeedDownloadWeibo);
      if (!bool)
        return false; 
      if (!paramBaseRequest.check(this.mContext, this.mWeiboInfo, new VersionCheckHandler())) {
        LogUtil.e(TAG, "sendRequest faild request check faild");
        return false;
      } 
      WbAppActivator.getInstance(this.mContext, this.mAppKey).activateApp();
      Bundle bundle = new Bundle();
      paramBaseRequest.toBundle(bundle);
      return launchWeiboActivity(paramActivity, "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY", this.mWeiboInfo.getPackageName(), this.mAppKey, bundle, "share");
    } catch (Exception exception) {
      LogUtil.e(TAG, exception.getMessage());
      return false;
    } 
  }
  
  public boolean sendRequest(Activity paramActivity, BaseRequest paramBaseRequest, AuthInfo paramAuthInfo, String paramString, WeiboAuthListener paramWeiboAuthListener) {
    if (paramBaseRequest == null) {
      LogUtil.e(TAG, "sendRequest faild request is null !");
      return false;
    } 
    if (isWeiboAppInstalled() && isWeiboAppSupportAPI()) {
      if (getWeiboAppSupportAPI() >= 10351)
        return sendRequest(paramActivity, paramBaseRequest); 
      if (paramBaseRequest instanceof SendMultiMessageToWeiboRequest) {
        paramBaseRequest = paramBaseRequest;
        SendMessageToWeiboRequest sendMessageToWeiboRequest = new SendMessageToWeiboRequest();
        sendMessageToWeiboRequest.packageName = ((SendMultiMessageToWeiboRequest)paramBaseRequest).packageName;
        sendMessageToWeiboRequest.transaction = ((SendMultiMessageToWeiboRequest)paramBaseRequest).transaction;
        sendMessageToWeiboRequest.message = adapterMultiMessage2SingleMessage(((SendMultiMessageToWeiboRequest)paramBaseRequest).multiMessage);
        return sendRequest(paramActivity, sendMessageToWeiboRequest);
      } 
      return sendRequest(paramActivity, paramBaseRequest);
    } 
    return startShareWeiboActivity(paramActivity, paramString, paramBaseRequest, paramWeiboAuthListener);
  }
  
  public boolean sendResponse(BaseResponse paramBaseResponse) {
    if (paramBaseResponse == null) {
      LogUtil.e(TAG, "sendResponse failed response null");
      return false;
    } 
    if (!paramBaseResponse.check(this.mContext, new VersionCheckHandler())) {
      LogUtil.e(TAG, "sendResponse check fail");
      return false;
    } 
    Bundle bundle = new Bundle();
    paramBaseResponse.toBundle(bundle);
    sendBroadcast(this.mContext, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_RESPONSE", this.mAppKey, paramBaseResponse.reqPackageName, bundle);
    return true;
  }
  
  public void shareMessageToWeiyou(Context paramContext, Bundle paramBundle) {
    Utility.shareMessagetoWeibo(paramContext, "sinaweibo://extendthirdshare", paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\share\WeiboShareAPIImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */