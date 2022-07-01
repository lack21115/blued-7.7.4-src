package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

public class DialogRedirectImpl extends DialogRedirect {
  private final Activity activity;
  
  private final Intent intent;
  
  private final int requestCode;
  
  DialogRedirectImpl(Intent paramIntent, Activity paramActivity, int paramInt) {
    this.intent = paramIntent;
    this.activity = paramActivity;
    this.requestCode = paramInt;
  }
  
  public final void redirect() {
    Intent intent = this.intent;
    if (intent != null)
      this.activity.startActivityForResult(intent, this.requestCode); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\DialogRedirectImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */