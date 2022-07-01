package com.sina.weibo.sdk.net.openapi;

import android.content.Context;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

public class RefreshTokenApi {
  private static final String REFRESH_TOKEN_URL = "https://api.weibo.com/oauth2/access_token";
  
  private Context mContext;
  
  private RefreshTokenApi(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static RefreshTokenApi create(Context paramContext) {
    return new RefreshTokenApi(paramContext);
  }
  
  public void refreshToken(String paramString1, String paramString2, RequestListener paramRequestListener) {
    WeiboParameters weiboParameters = new WeiboParameters(paramString1);
    weiboParameters.put("client_id", paramString1);
    weiboParameters.put("grant_type", "refresh_token");
    weiboParameters.put("refresh_token", paramString2);
    (new AsyncWeiboRunner(this.mContext)).requestAsync("https://api.weibo.com/oauth2/access_token", weiboParameters, "POST", paramRequestListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\net\openapi\RefreshTokenApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */