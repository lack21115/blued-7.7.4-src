package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

public class AssistActivity extends Activity {
  public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
  
  protected static final int FINISH_BY_TIMEOUT = 0;
  
  private static final String RESTART_FLAG = "RESTART_FLAG";
  
  private static final String TAG = "openSDK_LOG.AssistActivity";
  
  private boolean canFinishByTimeout = false;
  
  private boolean canStartTimeout = false;
  
  protected Handler handler = new Handler() {
      public void handleMessage(Message param1Message) {
        if (param1Message.what != 0)
          return; 
        if (!AssistActivity.this.isFinishing())
          AssistActivity.this.finish(); 
      }
    };
  
  private boolean isRestart = false;
  
  public static Intent getAssistActivityIntent(Context paramContext) {
    return new Intent(paramContext, AssistActivity.class);
  }
  
  private void openBrowser(Bundle paramBundle) {
    String str2;
    String str3 = paramBundle.getString("viaShareType");
    String str5 = paramBundle.getString("callbackAction");
    String str6 = paramBundle.getString("url");
    String str4 = paramBundle.getString("openId");
    String str7 = paramBundle.getString("appId");
    boolean bool = "shareToQQ".equals(str5);
    String str1 = "";
    if (bool) {
      str1 = "ANDROIDQQ.SHARETOQQ.XX";
      str2 = "10";
    } else if ("shareToQzone".equals(str5)) {
      str1 = "ANDROIDQQ.SHARETOQZ.XX";
      str2 = "11";
    } else {
      str2 = "";
    } 
    if (!Util.openBrowser((Context)this, str6)) {
      IUiListener iUiListener = UIListenerManager.getInstance().getListnerWithAction(str5);
      if (iUiListener != null)
        iUiListener.onError(new UiError(-6, "打开浏览器失败!", null)); 
      d.a().a(str4, str7, str1, str2, "3", "1", str3, "0", "2", "0");
      finish();
    } else {
      d.a().a(str4, str7, str1, str2, "3", "0", str3, "0", "2", "0");
    } 
    getIntent().removeExtra("shareH5");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("--onActivityResult--requestCode: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" | resultCode: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append("data = null ? ");
    if (paramIntent == null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    f.c("openSDK_LOG.AssistActivity", stringBuilder.toString());
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
      return; 
    if (paramIntent != null)
      paramIntent.putExtra("key_action", "action_login"); 
    setResultData(paramInt2, paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    int i;
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setRequestedOrientation(3);
    f.b("openSDK_LOG.AssistActivity", "--onCreate--");
    if (getIntent() == null) {
      f.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
      finish();
    } 
    Intent intent = (Intent)getIntent().getParcelableExtra("openSDK_LOG.AssistActivity.ExtraIntent");
    if (intent == null) {
      i = 0;
    } else {
      i = intent.getIntExtra("key_request_code", 0);
    } 
    Bundle bundle = getIntent().getBundleExtra("h5_share_data");
    if (paramBundle != null)
      this.isRestart = paramBundle.getBoolean("RESTART_FLAG"); 
    if (!this.isRestart) {
      if (bundle == null) {
        if (intent != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("--onCreate--activityIntent not null, will start activity, reqcode = ");
          stringBuilder.append(i);
          f.c("openSDK_LOG.AssistActivity", stringBuilder.toString());
          if (intent.getComponent() != null) {
            this.canFinishByTimeout = false;
            startActivityForResult(intent, i);
            return;
          } 
          this.canFinishByTimeout = true;
          this.canStartTimeout = false;
          startActivity(intent);
          return;
        } 
        f.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
        finish();
        return;
      } 
      f.d("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
      openBrowser(bundle);
      return;
    } 
    f.b("openSDK_LOG.AssistActivity", "is restart");
  }
  
  protected void onDestroy() {
    f.b("openSDK_LOG.AssistActivity", "-->onDestroy");
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent) {
    f.c("openSDK_LOG.AssistActivity", "--onNewIntent");
    super.onNewIntent(paramIntent);
    paramIntent.putExtra("key_action", "action_share");
    setResult(-1, paramIntent);
    if (!isFinishing()) {
      f.c("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
      finish();
    } 
  }
  
  protected void onPause() {
    f.b("openSDK_LOG.AssistActivity", "-->onPause");
    if (this.canFinishByTimeout)
      if (this.canStartTimeout) {
        this.handler.removeMessages(0);
      } else {
        this.canStartTimeout = true;
      }  
    super.onPause();
  }
  
  protected void onResume() {
    f.b("openSDK_LOG.AssistActivity", "-->onResume");
    super.onResume();
    Intent intent = getIntent();
    if (intent.getBooleanExtra("is_login", false))
      return; 
    if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.isRestart && !isFinishing())
      finish(); 
    if (this.canFinishByTimeout && this.canStartTimeout) {
      Message message = this.handler.obtainMessage(0);
      this.handler.sendMessageDelayed(message, 200L);
    } 
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    f.b("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
    paramBundle.putBoolean("RESTART_FLAG", true);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart() {
    f.b("openSDK_LOG.AssistActivity", "-->onStart");
    super.onStart();
  }
  
  protected void onStop() {
    f.b("openSDK_LOG.AssistActivity", "-->onStop");
    super.onStop();
  }
  
  public void setResultData(int paramInt, Intent paramIntent) {
    if (paramIntent == null) {
      f.d("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
      setResult(0, paramIntent);
      return;
    } 
    try {
      String str = paramIntent.getStringExtra("key_response");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("--setResultDataForLogin-- ");
      stringBuilder.append(str);
      f.b("openSDK_LOG.AssistActivity", stringBuilder.toString());
      if (!TextUtils.isEmpty(str)) {
        JSONObject jSONObject = new JSONObject(str);
        str = jSONObject.optString("openid");
        String str1 = jSONObject.optString("access_token");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str1)) {
          f.c("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
          setResult(-1, paramIntent);
          return;
        } 
        f.d("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
        setResult(0, paramIntent);
        return;
      } 
      f.d("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
      setResult(-1, paramIntent);
      return;
    } catch (Exception exception) {
      f.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\common\AssistActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */