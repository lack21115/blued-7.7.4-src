package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sina.sso.RemoteSSO;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.register.mobile.MobileRegisterActivity;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.SecurityHelper;
import com.sina.weibo.sdk.utils.Utility;
import java.util.HashMap;
import java.util.Iterator;

public class SsoHandler {
  public static final String AUTH_FAILED_MSG = "auth failed!!!!!";
  
  public static final String AUTH_FAILED_NOT_INSTALL_MSG = "not install weibo client!!!!!";
  
  private static final String DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME = "com.sina.weibo.remotessoservice";
  
  private static final int REQUEST_CODE_MOBILE_REGISTER = 40000;
  
  private static final int REQUEST_CODE_SSO_AUTH = 32973;
  
  private static final String TAG = "Weibo_SSO_login";
  
  private Activity mAuthActivity;
  
  private AuthInfo mAuthInfo;
  
  private WeiboAuthListener mAuthListener;
  
  private ServiceConnection mConnection = new ServiceConnection() {
      public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        RemoteSSO remoteSSO = RemoteSSO.Stub.asInterface(param1IBinder);
        try {
          String str1 = remoteSSO.getPackageName();
          String str2 = remoteSSO.getActivityName();
          SsoHandler.this.mAuthActivity.getApplicationContext().unbindService(SsoHandler.this.mConnection);
          if (!SsoHandler.this.startSingleSignOn(str1, str2)) {
            SsoHandler.this.mWebAuthHandler.anthorize(SsoHandler.this.mAuthListener);
            return;
          } 
        } catch (RemoteException remoteException) {
          remoteException.printStackTrace();
        } 
      }
      
      public void onServiceDisconnected(ComponentName param1ComponentName) {
        SsoHandler.this.mWebAuthHandler.anthorize(SsoHandler.this.mAuthListener);
      }
    };
  
  private int mSSOAuthRequestCode;
  
  private WebAuthHandler mWebAuthHandler;
  
  private WeiboAppManager.WeiboInfo mWeiboInfo;
  
  public SsoHandler(Activity paramActivity, AuthInfo paramAuthInfo) {
    this.mAuthActivity = paramActivity;
    this.mAuthInfo = paramAuthInfo;
    this.mWebAuthHandler = new WebAuthHandler((Context)paramActivity, paramAuthInfo);
    this.mWeiboInfo = WeiboAppManager.getInstance((Context)paramActivity).getWeiboInfo();
    AidTask.getInstance((Context)this.mAuthActivity).aidTaskInit(paramAuthInfo.getAppKey());
  }
  
  private void authorize(int paramInt, WeiboAuthListener paramWeiboAuthListener, AuthType paramAuthType) {
    this.mSSOAuthRequestCode = paramInt;
    this.mAuthListener = paramWeiboAuthListener;
    if (paramAuthType == AuthType.SsoOnly) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (paramAuthType == AuthType.WebOnly) {
      if (paramWeiboAuthListener != null)
        this.mWebAuthHandler.anthorize(paramWeiboAuthListener); 
      return;
    } 
    if (!bindRemoteSSOService(this.mAuthActivity.getApplicationContext()))
      if (paramInt != 0) {
        paramWeiboAuthListener = this.mAuthListener;
        if (paramWeiboAuthListener != null) {
          paramWeiboAuthListener.onWeiboException(new WeiboException("not install weibo client!!!!!"));
          return;
        } 
      } else {
        this.mWebAuthHandler.anthorize(this.mAuthListener);
      }  
  }
  
  private boolean bindRemoteSSOService(Context paramContext) {
    if (!isWeiboAppInstalled())
      return false; 
    String str = this.mWeiboInfo.getPackageName();
    Intent intent = new Intent("com.sina.weibo.remotessoservice");
    intent.setPackage(str);
    return paramContext.bindService(intent, this.mConnection, 1);
  }
  
  public static ComponentName isServiceExisted(Context paramContext, String paramString) {
    Iterator iterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647).iterator();
    while (true) {
      if (!iterator.hasNext())
        return null; 
      ComponentName componentName = ((ActivityManager.RunningServiceInfo)iterator.next()).service;
      if (componentName.getPackageName().equals(paramString)) {
        String str = componentName.getClassName();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString));
        stringBuilder.append(".business.RemoteSSOService");
        if (str.equals(stringBuilder.toString()))
          return componentName; 
      } 
    } 
  }
  
  private boolean startSingleSignOn(String paramString1, String paramString2) {
    Intent intent = new Intent();
    intent.setClassName(paramString1, paramString2);
    intent.putExtras(this.mWebAuthHandler.getAuthInfo().getAuthBundle());
    intent.putExtra("_weibo_command_type", 3);
    paramString1 = String.valueOf(System.currentTimeMillis());
    intent.putExtra("_weibo_transaction", paramString1);
    addEventLog((Context)this.mAuthActivity, paramString1, "sso");
    intent.putExtra("aid", Utility.getAid((Context)this.mAuthActivity, this.mAuthInfo.getAppKey()));
    if (!SecurityHelper.validateAppSignatureForIntent((Context)this.mAuthActivity, intent))
      return false; 
    paramString1 = Utility.getAid((Context)this.mAuthActivity, this.mAuthInfo.getAppKey());
    if (!TextUtils.isEmpty(paramString1))
      intent.putExtra("aid", paramString1); 
    try {
      this.mAuthActivity.startActivityForResult(intent, this.mSSOAuthRequestCode);
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
  
  public void authorize(WeiboAuthListener paramWeiboAuthListener) {
    authorize(32973, paramWeiboAuthListener, AuthType.ALL);
    WbAppActivator.getInstance((Context)this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
  }
  
  public void authorizeCallBack(int paramInt1, int paramInt2, Intent paramIntent) {
    Bundle bundle;
    StringBuilder stringBuilder = new StringBuilder("requestCode: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", resultCode: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", data: ");
    stringBuilder.append(paramIntent);
    LogUtil.d("Weibo_SSO_login", stringBuilder.toString());
    if (paramInt1 == this.mSSOAuthRequestCode) {
      if (paramInt2 == -1) {
        String str1;
        if (!SecurityHelper.checkResponseAppLegal((Context)this.mAuthActivity, this.mWeiboInfo, paramIntent))
          return; 
        String str3 = paramIntent.getStringExtra("error");
        String str2 = str3;
        if (str3 == null)
          str2 = paramIntent.getStringExtra("error_type"); 
        if (str2 != null) {
          if (str2.equals("access_denied") || str2.equals("OAuthAccessDeniedException")) {
            LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
            this.mAuthListener.onCancel();
            return;
          } 
          str3 = paramIntent.getStringExtra("error_description");
          str1 = str2;
          if (str3 != null) {
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str2));
            stringBuilder2.append(":");
            stringBuilder2.append(str3);
            str1 = stringBuilder2.toString();
          } 
          StringBuilder stringBuilder1 = new StringBuilder("Login failed: ");
          stringBuilder1.append(str1);
          LogUtil.d("Weibo_SSO_login", stringBuilder1.toString());
          this.mAuthListener.onWeiboException((WeiboException)new WeiboDialogException(str1, paramInt2, str3));
          return;
        } 
        bundle = str1.getExtras();
        Oauth2AccessToken oauth2AccessToken = Oauth2AccessToken.parseAccessToken(bundle);
        if (oauth2AccessToken != null && oauth2AccessToken.isSessionValid()) {
          StringBuilder stringBuilder1 = new StringBuilder("Login Success! ");
          stringBuilder1.append(oauth2AccessToken.toString());
          LogUtil.d("Weibo_SSO_login", stringBuilder1.toString());
          this.mAuthListener.onComplete(bundle);
          return;
        } 
        LogUtil.d("Weibo_SSO_login", "Failed to receive access token by SSO");
        this.mWebAuthHandler.anthorize(this.mAuthListener);
        return;
      } 
      if (paramInt2 == 0) {
        if (bundle != null) {
          stringBuilder = new StringBuilder("Login failed: ");
          stringBuilder.append(bundle.getStringExtra("error"));
          LogUtil.d("Weibo_SSO_login", stringBuilder.toString());
          this.mAuthListener.onWeiboException((WeiboException)new WeiboDialogException(bundle.getStringExtra("error"), bundle.getIntExtra("error_code", -1), bundle.getStringExtra("failing_url")));
          return;
        } 
        LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
        this.mAuthListener.onCancel();
        return;
      } 
    } else if (paramInt1 == 40000) {
      if (paramInt2 == -1) {
        bundle = bundle.getExtras();
        Oauth2AccessToken oauth2AccessToken = Oauth2AccessToken.parseAccessToken(bundle);
        if (oauth2AccessToken != null && oauth2AccessToken.isSessionValid()) {
          StringBuilder stringBuilder1 = new StringBuilder("Login Success! ");
          stringBuilder1.append(oauth2AccessToken.toString());
          LogUtil.d("Weibo_SSO_login", stringBuilder1.toString());
          this.mAuthListener.onComplete(bundle);
          return;
        } 
      } else if (paramInt2 == 0) {
        if (bundle != null) {
          stringBuilder = new StringBuilder("Login failed: ");
          stringBuilder.append(bundle.getStringExtra("error"));
          LogUtil.d("Weibo_SSO_login", stringBuilder.toString());
          String str2 = bundle.getStringExtra("error");
          String str1 = str2;
          if (str2 == null)
            str1 = bundle.getStringExtra("error_type"); 
          if (str1 != null) {
            this.mAuthListener.onWeiboException((WeiboException)new WeiboDialogException(bundle.getStringExtra("error"), bundle.getIntExtra("error_code", -1), bundle.getStringExtra("error_description")));
            return;
          } 
        } else {
          LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
          this.mAuthListener.onCancel();
        } 
      } 
    } 
  }
  
  public void authorizeClientSso(WeiboAuthListener paramWeiboAuthListener) {
    authorize(32973, paramWeiboAuthListener, AuthType.SsoOnly);
    WbAppActivator.getInstance((Context)this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
  }
  
  public void authorizeWeb(WeiboAuthListener paramWeiboAuthListener) {
    authorize(32973, paramWeiboAuthListener, AuthType.WebOnly);
    WbAppActivator.getInstance((Context)this.mAuthActivity, this.mAuthInfo.getAppKey()).activateApp();
  }
  
  public boolean isWeiboAppInstalled() {
    WeiboAppManager.WeiboInfo weiboInfo = this.mWeiboInfo;
    return (weiboInfo != null && weiboInfo.isLegal());
  }
  
  public void registerOrLoginByMobile(String paramString, WeiboAuthListener paramWeiboAuthListener) {
    this.mAuthListener = paramWeiboAuthListener;
    Intent intent = new Intent((Context)this.mAuthActivity, MobileRegisterActivity.class);
    Bundle bundle = this.mAuthInfo.getAuthBundle();
    bundle.putString("register_title", paramString);
    intent.putExtras(bundle);
    this.mAuthActivity.startActivityForResult(intent, 40000);
  }
  
  enum AuthType {
    ALL, SsoOnly, WebOnly;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\auth\sso\SsoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */