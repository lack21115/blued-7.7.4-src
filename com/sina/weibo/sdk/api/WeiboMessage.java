package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.utils.LogUtil;

public final class WeiboMessage {
  public BaseMediaObject mediaObject;
  
  public WeiboMessage() {}
  
  public WeiboMessage(Bundle paramBundle) {
    toBundle(paramBundle);
  }
  
  public boolean checkArgs() {
    BaseMediaObject baseMediaObject = this.mediaObject;
    if (baseMediaObject == null) {
      LogUtil.e("Weibo.WeiboMessage", "checkArgs fail, mediaObject is null");
      return false;
    } 
    if (baseMediaObject != null && !baseMediaObject.checkArgs()) {
      LogUtil.e("Weibo.WeiboMessage", "checkArgs fail, mediaObject is invalid");
      return false;
    } 
    return true;
  }
  
  public Bundle toBundle(Bundle paramBundle) {
    BaseMediaObject baseMediaObject = this.mediaObject;
    if (baseMediaObject != null) {
      paramBundle.putParcelable("_weibo_message_media", baseMediaObject);
      paramBundle.putString("_weibo_message_media_extra", this.mediaObject.toExtraMediaString());
    } 
    return paramBundle;
  }
  
  public WeiboMessage toObject(Bundle paramBundle) {
    this.mediaObject = (BaseMediaObject)paramBundle.getParcelable("_weibo_message_media");
    BaseMediaObject baseMediaObject = this.mediaObject;
    if (baseMediaObject != null)
      baseMediaObject.toExtraMediaObject(paramBundle.getString("_weibo_message_media_extra")); 
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\WeiboMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */