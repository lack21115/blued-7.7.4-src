package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;

public class SDKAccessActivity extends BaseFragmentActivity {
  private void a(Intent paramIntent) {
    if (paramIntent == null) {
      finish();
      return;
    } 
    SDKBaseAction sDKBaseAction = SDKBaseAction.a(paramIntent);
    Logger.a("SDKAction", new Object[] { "AccessActivity receive a action:", sDKBaseAction });
    if (sDKBaseAction != null) {
      SDKActionManager.a(sDKBaseAction);
      if (!UserInfo.a().j()) {
        FirstActivity.a((Context)this);
        finish();
        return;
      } 
      sDKBaseAction.c((Context)this);
      return;
    } 
    finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    a(getIntent());
  }
  
  public void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sdk\SDKAccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */