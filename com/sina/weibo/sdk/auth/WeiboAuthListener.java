package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import com.sina.weibo.sdk.exception.WeiboException;

public interface WeiboAuthListener {
  void onCancel();
  
  void onComplete(Bundle paramBundle);
  
  void onWeiboException(WeiboException paramWeiboException);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\auth\WeiboAuthListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */