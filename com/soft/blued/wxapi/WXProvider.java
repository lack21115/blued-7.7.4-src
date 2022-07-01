package com.soft.blued.wxapi;

import android.content.Context;
import android.content.Intent;

public class WXProvider {
  private static WXProvider a;
  
  private ILoginCallback b;
  
  public static WXProvider a() {
    if (a == null)
      a = new WXProvider(); 
    return a;
  }
  
  public void a(int paramInt, WXLoginBean paramWXLoginBean) {
    ILoginCallback iLoginCallback;
    if (paramInt != 0) {
      if (paramInt != 1) {
        iLoginCallback = this.b;
        if (iLoginCallback != null) {
          iLoginCallback.b();
          return;
        } 
      } else {
        iLoginCallback = this.b;
        if (iLoginCallback != null) {
          iLoginCallback.a();
          return;
        } 
      } 
    } else {
      ILoginCallback iLoginCallback1 = this.b;
      if (iLoginCallback1 != null)
        iLoginCallback1.a((WXLoginBean)iLoginCallback); 
    } 
  }
  
  public void a(Context paramContext) {
    Intent intent = new Intent(paramContext, WXEntryActivity.class);
    intent.putExtra("intent_mode", "intent_mode_login");
    paramContext.startActivity(intent);
  }
  
  public void a(ILoginCallback paramILoginCallback) {
    this.b = paramILoginCallback;
  }
  
  public void b() {
    this.b = null;
  }
  
  public static interface ILoginCallback {
    void a();
    
    void a(WXLoginBean param1WXLoginBean);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\wxapi\WXProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */