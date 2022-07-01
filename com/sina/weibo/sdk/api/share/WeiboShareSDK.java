package com.sina.weibo.sdk.api.share;

import android.content.Context;

public class WeiboShareSDK {
  public static IWeiboShareAPI createWeiboAPI(Context paramContext, String paramString) {
    return createWeiboAPI(paramContext, paramString, false);
  }
  
  public static IWeiboShareAPI createWeiboAPI(Context paramContext, String paramString, boolean paramBoolean) {
    return new WeiboShareAPIImpl(paramContext, paramString, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\share\WeiboShareSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */