package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.b.d;
import com.tencent.open.utils.Global;
import com.tencent.tauth.IUiListener;

public class QQAvatar extends BaseApi {
  private IUiListener a;
  
  public QQAvatar(QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private Intent a(Activity paramActivity) {
    Intent intent = new Intent();
    intent.setClass((Context)paramActivity, ImageActivity.class);
    return intent;
  }
  
  private void a(Activity paramActivity, Bundle paramBundle, Intent paramIntent) {
    a(paramBundle);
    paramIntent.putExtra("key_action", "action_avatar");
    paramIntent.putExtra("key_params", paramBundle);
    UIListenerManager.getInstance().setListenerWithRequestcode(11102, this.a);
    startAssitActivity(paramActivity, paramIntent, 11102);
  }
  
  private void a(Bundle paramBundle) {
    if (this.mToken != null) {
      paramBundle.putString("appid", this.mToken.getAppId());
      if (this.mToken.isSessionValid()) {
        paramBundle.putString("keystr", this.mToken.getAccessToken());
        paramBundle.putString("keytype", "0x80");
      } 
      String str = this.mToken.getOpenId();
      if (str != null)
        paramBundle.putString("hopenid", str); 
      paramBundle.putString("platform", "androidqz");
      try {
        paramBundle.putString("pf", Global.getContext().getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
      } catch (Exception exception) {
        exception.printStackTrace();
        paramBundle.putString("pf", "openmobile_android");
      } 
    } 
    paramBundle.putString("sdkv", "2.9.4");
    paramBundle.putString("sdkp", "a");
  }
  
  public void setAvatar(Activity paramActivity, Uri paramUri, IUiListener paramIUiListener, int paramInt) {
    IUiListener iUiListener = this.a;
    if (iUiListener != null)
      iUiListener.onCancel(); 
    this.a = paramIUiListener;
    Bundle bundle = new Bundle();
    bundle.putString("picture", paramUri.toString());
    bundle.putInt("exitAnim", paramInt);
    bundle.putString("appid", this.mToken.getAppId());
    bundle.putString("access_token", this.mToken.getAccessToken());
    bundle.putLong("expires_in", this.mToken.getExpireTimeInSecond());
    bundle.putString("openid", this.mToken.getOpenId());
    Intent intent = a(paramActivity);
    if (hasActivityForIntent(intent)) {
      a(paramActivity, bundle, intent);
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDSDK.SETAVATAR.XX", "12", "18", "0");
      return;
    } 
    d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDSDK.SETAVATAR.XX", "12", "18", "1");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\avatar\QQAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */