package com.cmic.sso.sdk.auth;

import android.content.Context;
import org.json.JSONObject;

public interface LoginClickListener {
  void onLoginClickComplete(Context paramContext, JSONObject paramJSONObject);
  
  void onLoginClickStart(Context paramContext, JSONObject paramJSONObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\auth\LoginClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */