package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import com.blued.android.core.AppMethods;
import com.soft.blued.sdk.ui.SDKPayFragment;
import com.soft.blued.utils.Logger;

public class SDKPayAction extends SDKBaseAction {
  private int f = 0;
  
  private String g;
  
  public SDKPayAction(Intent paramIntent) {
    super(paramIntent);
    this.f = paramIntent.getIntExtra("goods_id", 0);
    this.g = paramIntent.getStringExtra("app_token");
    Logger.a("SDKAction", new Object[] { "goodsId:", Integer.valueOf(this.f), ", appToken:", this.g });
  }
  
  private Intent d() {
    Intent intent = new Intent("com.blued.android.sdk.action.pay_result", null);
    intent.addCategory("android.intent.category.DEFAULT");
    intent.setPackage(this.e);
    intent.setFlags(67108864);
    return intent;
  }
  
  protected void a(Context paramContext) {
    Logger.a("SDKAction", new Object[] { "startAction, action:", this });
    SDKPayFragment.a(paramContext, this.a, this.f, this.c, this.d, null, null, this.g, null);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
    Logger.a("SDKAction", new Object[] { "payFinish, result:", Integer.valueOf(paramInt1), ", errorCode:", Integer.valueOf(paramInt2), ", balance:", Integer.valueOf(paramInt3), ", action:", this });
    if (c())
      return; 
    Intent intent = d();
    intent.putExtra("extra_result_int", paramInt1);
    if (paramInt1 == 1) {
      intent.putExtra("extra_error_code_int", paramInt2);
    } else if (paramInt1 == 0) {
      intent.putExtra("extra_pay_balance_int", paramInt3);
    } 
    if (AppMethods.a(intent))
      paramContext.startActivity(intent); 
    b();
  }
  
  protected void b(Context paramContext) {
    Logger.a("SDKAction", new Object[] { "cancelAction, action:", this });
    a(paramContext, 2, 0, 0);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[goodsId:");
    stringBuilder.append(this.f);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sdk\SDKPayAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */