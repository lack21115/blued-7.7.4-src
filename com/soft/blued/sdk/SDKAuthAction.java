package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.sdk.model.SDKAuthModel;
import com.soft.blued.sdk.ui.SDKWebAuthFragment;
import com.soft.blued.utils.Logger;

public class SDKAuthAction extends SDKBaseAction {
  private SDKActionCallback f;
  
  public SDKAuthAction(Intent paramIntent) {
    super(paramIntent);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2) {
    PayHttpUtils.a((HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<SDKAuthModel>>(this, paramContext) {
          private SDKAuthModel c;
          
          private int d = 0;
          
          private String e = null;
          
          public void a(BluedEntityA<SDKAuthModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
              this.c = param1BluedEntityA.data.get(0); 
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            Pair pair = BluedHttpUtils.a(param1Throwable, param1Int, param1String);
            if (pair != null) {
              this.d = ((Integer)pair.first).intValue();
              this.e = (String)pair.second;
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            SDKAuthModel sDKAuthModel = this.c;
            if (sDKAuthModel != null) {
              this.b.a(this.a, 0, 0, this.e, sDKAuthModel.access_token, this.c.expire, this.c.package_name);
              return;
            } 
            this.b.a(this.a, 1, this.d, this.e, (String)null, 0, (String)null);
          }
        }null, paramString1);
  }
  
  private void b(Context paramContext, String paramString1, String paramString2) {
    SDKWebAuthFragment.a(paramContext, paramString1, paramString2, this.a);
  }
  
  private Intent d() {
    Intent intent = new Intent("com.blued.android.sdk.action.auth_result", null);
    intent.addCategory("android.intent.category.DEFAULT");
    intent.setPackage(this.e);
    intent.setFlags(67108864);
    return intent;
  }
  
  protected void a(Context paramContext) {
    String str = AppInfo.d().getPackageName();
    if (!TextUtils.isEmpty(this.e) && this.e.equals(str)) {
      a(paramContext, this.c, this.d);
      return;
    } 
    b(paramContext, this.c, this.d);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3) {
    Intent intent;
    Logger.a("SDKAction", new Object[] { 
          "authFinish, result:", Integer.valueOf(paramInt1), ", errorCode:", Integer.valueOf(paramInt2), ", errorMsg:", paramString1, ", token:", paramString2, ", expireTime:", Integer.valueOf(paramInt3), 
          ", pkgName:", paramString3 });
    if (c())
      return; 
    int j = paramInt1;
    int i = paramInt2;
    String str = paramString1;
    if (paramInt1 == 0) {
      j = paramInt1;
      i = paramInt2;
      str = paramString1;
      if (!this.e.equals(paramString3)) {
        j = paramInt1;
        i = paramInt2;
        str = paramString1;
        if (!"com.blued".equals(paramString3)) {
          i = 101;
          str = "包名不匹配";
          j = 1;
        } 
      } 
    } 
    SDKActionCallback sDKActionCallback = this.f;
    if (sDKActionCallback == null) {
      intent = d();
      intent.putExtra("extra_result_int", j);
      if (j == 1) {
        intent.putExtra("extra_error_code_int", i);
      } else if (j == 0) {
        intent.putExtra("extra_auth_token_string", paramString2);
        intent.putExtra("extra_auth_expire_int", paramInt3);
      } 
      if (AppMethods.a(intent))
        paramContext.startActivity(intent); 
    } else if (j == 0) {
      SDKAuthModel sDKAuthModel = new SDKAuthModel();
      sDKAuthModel.access_token = paramString2;
      sDKAuthModel.expire = paramInt3;
      sDKAuthModel.package_name = paramString3;
      this.f.a(sDKAuthModel);
    } else {
      intent.a(i, str);
    } 
    b();
  }
  
  protected void b(Context paramContext) {
    a(paramContext, 2, 0, (String)null, (String)null, 0, (String)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sdk\SDKAuthAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */