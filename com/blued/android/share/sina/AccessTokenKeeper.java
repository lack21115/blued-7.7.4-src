package com.blued.android.share.sina;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

public class AccessTokenKeeper {
  private static final String KEY_ACCESS_TOKEN = "access_token";
  
  private static final String KEY_EXPIRES_IN = "expires_in";
  
  private static final String KEY_UID = "uid";
  
  private static final String PREFERENCES_NAME = "com_weibo_sdk_android";
  
  public static void clear(Context paramContext) {
    if (paramContext == null)
      return; 
    SharedPreferences.Editor editor = paramContext.getSharedPreferences("com_weibo_sdk_android", 32768).edit();
    editor.clear();
    editor.commit();
  }
  
  public static Oauth2AccessToken readAccessToken(Context paramContext) {
    if (paramContext == null)
      return null; 
    Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("com_weibo_sdk_android", 32768);
    oauth2AccessToken.setUid(sharedPreferences.getString("uid", ""));
    oauth2AccessToken.setToken(sharedPreferences.getString("access_token", ""));
    oauth2AccessToken.setExpiresTime(sharedPreferences.getLong("expires_in", 0L));
    return oauth2AccessToken;
  }
  
  public static void writeAccessToken(Context paramContext, Oauth2AccessToken paramOauth2AccessToken) {
    if (paramContext != null) {
      if (paramOauth2AccessToken == null)
        return; 
      SharedPreferences.Editor editor = paramContext.getSharedPreferences("com_weibo_sdk_android", 32768).edit();
      editor.putString("uid", paramOauth2AccessToken.getUid());
      editor.putString("access_token", paramOauth2AccessToken.getToken());
      editor.putLong("expires_in", paramOauth2AccessToken.getExpiresTime());
      editor.commit();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\sina\AccessTokenKeeper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */