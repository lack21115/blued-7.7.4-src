package com.blued.android.sdk;

import android.content.Context;
import android.content.Intent;
import com.blued.android.sdk.a.f;
import com.blued.android.sdk.a.g;

public class BluedPay {
  public static void handleResponse(Intent paramIntent, PayCallback paramPayCallback) {
    if (paramPayCallback == null)
      return; 
    if ("com.blued.android.sdk.action.pay_result".equals(paramIntent.getAction()))
      (new f(paramPayCallback)).a(paramIntent); 
  }
  
  public static boolean pay(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt) {
    Intent intent = new Intent();
    intent.setAction("com.blued.android.sdk.action.pay");
    intent.addCategory("android.intent.category.DEFAULT");
    intent.setPackage("com.soft.blued");
    intent.putExtra("app_key", paramString1);
    intent.putExtra("pkg_name", paramContext.getPackageName());
    intent.putExtra("secret_key", paramString2);
    intent.putExtra("app_token", paramString3);
    intent.putExtra("goods_id", paramInt);
    if (g.a(paramContext, intent)) {
      intent.setFlags(67108864);
      paramContext.startActivity(intent);
      return true;
    } 
    g.a(paramContext);
    return false;
  }
  
  public static interface PayCallback {
    void onCancel();
    
    void onFailed(int param1Int);
    
    void onSuccess(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\BluedPay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */