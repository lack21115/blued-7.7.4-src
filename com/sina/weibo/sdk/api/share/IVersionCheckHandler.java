package com.sina.weibo.sdk.api.share;

import android.content.Context;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

interface IVersionCheckHandler {
  boolean checkRequest(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, WeiboMessage paramWeiboMessage);
  
  boolean checkRequest(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, WeiboMultiMessage paramWeiboMultiMessage);
  
  boolean checkResponse(Context paramContext, String paramString, WeiboMessage paramWeiboMessage);
  
  boolean checkResponse(Context paramContext, String paramString, WeiboMultiMessage paramWeiboMultiMessage);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\share\IVersionCheckHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */