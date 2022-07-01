package com.tencent.connect.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseApi {
  protected static final String ACTION_CHECK_TOKEN = "action_check_token";
  
  protected static final String ACTIVITY_AGENT = "com.tencent.open.agent.AgentActivity";
  
  protected static final String ACTIVITY_ENCRY_TOKEN = "com.tencent.open.agent.EncryTokenActivity";
  
  protected static final String DEFAULT_PF = "openmobile_android";
  
  private static final String KEY_REQUEST_CODE = "key_request_code";
  
  private static final int MSG_COMPLETE = 0;
  
  protected static final String PARAM_ENCRY_EOKEN = "encry_token";
  
  protected static final String PLATFORM = "desktop_m_qq";
  
  protected static final String PREFERENCE_PF = "pfStore";
  
  private static final String TAG = "openSDK_LOG.BaseApi";
  
  protected static final String VERSION = "android";
  
  public static String businessId;
  
  public static String installChannel;
  
  public static boolean isOEM = false;
  
  public static String registerChannel;
  
  protected ProgressDialog mProgressDialog;
  
  protected QQAuth mQQAuth;
  
  public QQToken mToken;
  
  public BaseApi(QQAuth paramQQAuth, QQToken paramQQToken) {
    this.mQQAuth = paramQQAuth;
    this.mToken = paramQQToken;
  }
  
  public BaseApi(QQToken paramQQToken) {
    this(null, paramQQToken);
  }
  
  private Intent getAssitIntent(Activity paramActivity, Intent paramIntent) {
    Intent intent = new Intent(paramActivity.getApplicationContext(), AssistActivity.class);
    intent.putExtra("is_login", true);
    intent.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", (Parcelable)paramIntent);
    return intent;
  }
  
  public Bundle composeActivityParams() {
    StringBuilder stringBuilder;
    Bundle bundle = new Bundle();
    bundle.putString("appid", this.mToken.getAppId());
    if (this.mToken.isSessionValid()) {
      bundle.putString("keystr", this.mToken.getAccessToken());
      bundle.putString("keytype", "0x80");
    } 
    String str = this.mToken.getOpenId();
    if (str != null)
      bundle.putString("hopenid", str); 
    bundle.putString("platform", "androidqz");
    SharedPreferences sharedPreferences = Global.getContext().getSharedPreferences("pfStore", 0);
    if (isOEM) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("desktop_m_qq-");
      stringBuilder.append(installChannel);
      stringBuilder.append("-");
      stringBuilder.append("android");
      stringBuilder.append("-");
      stringBuilder.append(registerChannel);
      stringBuilder.append("-");
      stringBuilder.append(businessId);
      bundle.putString("pf", stringBuilder.toString());
    } else {
      bundle.putString("pf", stringBuilder.getString("pf", "openmobile_android"));
      bundle.putString("pf", "openmobile_android");
    } 
    bundle.putString("sdkv", "2.9.4");
    bundle.putString("sdkp", "a");
    return bundle;
  }
  
  protected Bundle composeCGIParams() {
    StringBuilder stringBuilder;
    Bundle bundle = new Bundle();
    bundle.putString("format", "json");
    bundle.putString("status_os", Build.VERSION.RELEASE);
    bundle.putString("status_machine", Build.MODEL);
    bundle.putString("status_version", Build.VERSION.SDK);
    bundle.putString("sdkv", "2.9.4");
    bundle.putString("sdkp", "a");
    QQToken qQToken = this.mToken;
    if (qQToken != null && qQToken.isSessionValid()) {
      bundle.putString("access_token", this.mToken.getAccessToken());
      bundle.putString("oauth_consumer_key", this.mToken.getAppId());
      bundle.putString("openid", this.mToken.getOpenId());
      bundle.putString("appid_for_getting_config", this.mToken.getAppId());
    } 
    SharedPreferences sharedPreferences = Global.getContext().getSharedPreferences("pfStore", 0);
    if (isOEM) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("desktop_m_qq-");
      stringBuilder.append(installChannel);
      stringBuilder.append("-");
      stringBuilder.append("android");
      stringBuilder.append("-");
      stringBuilder.append(registerChannel);
      stringBuilder.append("-");
      stringBuilder.append(businessId);
      bundle.putString("pf", stringBuilder.toString());
      return bundle;
    } 
    bundle.putString("pf", stringBuilder.getString("pf", "openmobile_android"));
    return bundle;
  }
  
  protected Intent getAgentIntent() {
    return getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
  }
  
  protected Intent getAgentIntentWithTarget(String paramString) {
    Intent intent1;
    Intent intent2 = new Intent();
    Intent intent3 = getTargetActivityIntent(paramString);
    paramString = null;
    if (intent3 == null)
      return null; 
    if (intent3.getComponent() != null) {
      intent2.setClassName(intent3.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
      intent1 = intent2;
    } 
    return intent1;
  }
  
  protected String getCommonDownloadQQUrl(String paramString) {
    Bundle bundle = composeCGIParams();
    StringBuilder stringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString))
      bundle.putString("need_version", paramString); 
    stringBuilder.append("http://openmobile.qq.com/oauth2.0/m_jump_by_version?");
    stringBuilder.append(Util.encodeUrl(bundle));
    return stringBuilder.toString();
  }
  
  protected Intent getTargetActivityIntent(String paramString) {
    Intent intent = new Intent();
    if (Util.isTablet(Global.getContext())) {
      intent.setClassName("com.tencent.minihd.qq", paramString);
      if (SystemUtils.isActivityExist(Global.getContext(), intent))
        return intent; 
    } 
    intent.setClassName("com.tencent.mobileqq", paramString);
    return SystemUtils.isActivityExist(Global.getContext(), intent) ? intent : null;
  }
  
  protected void handleDownloadLastestQQ(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://qzs.qq.com/open/mobile/login/qzsjump.html?");
    stringBuilder.append(Util.encodeUrl(paramBundle));
    (new TDialog((Context)paramActivity, "", stringBuilder.toString(), null, this.mToken)).show();
  }
  
  protected boolean hasActivityForIntent(Intent paramIntent) {
    return (paramIntent != null) ? SystemUtils.isActivityExist(Global.getContext(), paramIntent) : false;
  }
  
  public void releaseResource() {}
  
  protected void showProgressDialog(Context paramContext, String paramString1, String paramString2) {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
      str = "请稍候"; 
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2))
      paramString1 = "正在加载..."; 
    this.mProgressDialog = ProgressDialog.show(paramContext, str, paramString1);
    this.mProgressDialog.setCancelable(true);
  }
  
  protected void startAssistActivity(Activity paramActivity, int paramInt, Intent paramIntent, boolean paramBoolean) {
    Intent intent = new Intent(paramActivity.getApplicationContext(), AssistActivity.class);
    if (paramBoolean)
      intent.putExtra("is_qq_mobile_share", true); 
    intent.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", (Parcelable)paramIntent);
    paramActivity.startActivityForResult(intent, paramInt);
  }
  
  protected void startAssistActivity(Activity paramActivity, Bundle paramBundle, int paramInt, Intent paramIntent) {
    Intent intent = new Intent(paramActivity.getApplicationContext(), AssistActivity.class);
    intent.putExtra("h5_share_data", paramBundle);
    intent.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", (Parcelable)paramIntent);
    paramActivity.startActivityForResult(intent, paramInt);
  }
  
  protected void startAssitActivity(Activity paramActivity, Intent paramIntent, int paramInt) {
    paramIntent.putExtra("key_request_code", paramInt);
    paramActivity.startActivityForResult(getAssitIntent(paramActivity, paramIntent), paramInt);
  }
  
  protected void startAssitActivity(Fragment paramFragment, Intent paramIntent, int paramInt) {
    paramIntent.putExtra("key_request_code", paramInt);
    paramFragment.startActivityForResult(getAssitIntent((Activity)paramFragment.getActivity(), paramIntent), paramInt);
  }
  
  public class TempRequestListener implements IRequestListener {
    private final Handler mHandler;
    
    private final IUiListener mListener;
    
    public TempRequestListener(IUiListener param1IUiListener) {
      this.mListener = param1IUiListener;
      this.mHandler = new Handler(Global.getContext().getMainLooper()) {
          public void handleMessage(Message param2Message) {
            if (param2Message.what == 0) {
              BaseApi.TempRequestListener.this.mListener.onComplete(param2Message.obj);
              return;
            } 
            BaseApi.TempRequestListener.this.mListener.onError(new UiError(param2Message.what, (String)param2Message.obj, null));
          }
        };
    }
    
    public void onComplete(JSONObject param1JSONObject) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1JSONObject;
      message.what = 0;
      this.mHandler.sendMessage(message);
    }
    
    public void onConnectTimeoutException(ConnectTimeoutException param1ConnectTimeoutException) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1ConnectTimeoutException.getMessage();
      message.what = -7;
      this.mHandler.sendMessage(message);
    }
    
    public void onHttpStatusException(HttpUtils.HttpStatusException param1HttpStatusException) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1HttpStatusException.getMessage();
      message.what = -9;
      this.mHandler.sendMessage(message);
    }
    
    public void onIOException(IOException param1IOException) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1IOException.getMessage();
      message.what = -2;
      this.mHandler.sendMessage(message);
    }
    
    public void onJSONException(JSONException param1JSONException) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1JSONException.getMessage();
      message.what = -4;
      this.mHandler.sendMessage(message);
    }
    
    public void onMalformedURLException(MalformedURLException param1MalformedURLException) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1MalformedURLException.getMessage();
      message.what = -3;
      this.mHandler.sendMessage(message);
    }
    
    public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException param1NetworkUnavailableException) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1NetworkUnavailableException.getMessage();
      message.what = -10;
      this.mHandler.sendMessage(message);
    }
    
    public void onSocketTimeoutException(SocketTimeoutException param1SocketTimeoutException) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1SocketTimeoutException.getMessage();
      message.what = -8;
      this.mHandler.sendMessage(message);
    }
    
    public void onUnknowException(Exception param1Exception) {
      Message message = this.mHandler.obtainMessage();
      message.obj = param1Exception.getMessage();
      message.what = -6;
      this.mHandler.sendMessage(message);
    }
  }
  
  class null extends Handler {
    null(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      if (param1Message.what == 0) {
        this.this$1.mListener.onComplete(param1Message.obj);
        return;
      } 
      this.this$1.mListener.onError(new UiError(param1Message.what, (String)param1Message.obj, null));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\common\BaseApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */