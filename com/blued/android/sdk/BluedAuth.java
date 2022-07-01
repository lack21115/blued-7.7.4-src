package com.blued.android.sdk;

import android.content.Context;
import android.content.Intent;
import com.blued.android.sdk.a.b;
import com.blued.android.sdk.a.c;
import com.blued.android.sdk.a.d;
import com.blued.android.sdk.a.e;
import com.blued.android.sdk.a.g;
import com.blued.android.sdk.model.BluedEntity;
import com.blued.android.sdk.model.ModelCallback;
import com.blued.android.sdk.model.TokenModel;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

public class BluedAuth {
  public static void handleResponse(Intent paramIntent, AuthCallback paramAuthCallback) {
    if (paramAuthCallback == null)
      return; 
    if ("com.blued.android.sdk.action.auth_result".equals(paramIntent.getAction()))
      (new b(paramAuthCallback)).a(paramIntent); 
  }
  
  public static boolean startAuth(Context paramContext, String paramString1, String paramString2) {
    Intent intent = new Intent();
    intent.setAction("com.blued.android.sdk.action.auth");
    intent.addCategory("android.intent.category.DEFAULT");
    intent.setPackage("com.soft.blued");
    intent.putExtra("app_key", paramString1);
    intent.putExtra("secret_key", paramString2);
    intent.putExtra("pkg_name", paramContext.getPackageName());
    if (g.a(paramContext, intent)) {
      intent.setFlags(67108864);
      paramContext.startActivity(intent);
      return true;
    } 
    g.a(paramContext);
    return false;
  }
  
  public static void updateToken(String paramString1, String paramString2, String paramString3, ModelCallback<TokenModel> paramModelCallback) {
    String str = String.valueOf(System.currentTimeMillis() / 1000L);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("T", str);
    hashMap.put("access_token", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d.a());
    stringBuilder.append("/oauth2/refresh");
    c.a(e.a(stringBuilder.toString(), hashMap), e.a(paramString1, paramString2, paramString3, str), (new TypeToken<BluedEntity<TokenModel>>() {
        
        },  ).getType(), paramModelCallback);
  }
  
  public static interface AuthCallback {
    void onCancel();
    
    void onFailed(int param1Int);
    
    void onSuccess(String param1String, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\BluedAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */