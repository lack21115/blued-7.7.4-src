package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

public class SDKBrowserAction extends SDKBaseAction {
  private final String f;
  
  public SDKBrowserAction(Intent paramIntent) {
    super(paramIntent);
    this.f = paramIntent.getStringExtra("url");
  }
  
  protected void a(Context paramContext) {
    if (!TextUtils.isEmpty(this.f))
      WebViewShowInfoFragment.show(paramContext, this.f, -1); 
    b();
  }
  
  protected void b(Context paramContext) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sdk\SDKBrowserAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */