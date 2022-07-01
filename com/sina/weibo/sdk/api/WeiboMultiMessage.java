package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.utils.LogUtil;

public final class WeiboMultiMessage {
  private static final String TAG = "WeiboMultiMessage";
  
  public ImageObject imageObject;
  
  public BaseMediaObject mediaObject;
  
  public TextObject textObject;
  
  public WeiboMultiMessage() {}
  
  public WeiboMultiMessage(Bundle paramBundle) {
    toBundle(paramBundle);
  }
  
  public boolean checkArgs() {
    TextObject textObject = this.textObject;
    if (textObject != null && !textObject.checkArgs()) {
      LogUtil.e("WeiboMultiMessage", "checkArgs fail, textObject is invalid");
      return false;
    } 
    ImageObject imageObject = this.imageObject;
    if (imageObject != null && !imageObject.checkArgs()) {
      LogUtil.e("WeiboMultiMessage", "checkArgs fail, imageObject is invalid");
      return false;
    } 
    BaseMediaObject baseMediaObject = this.mediaObject;
    if (baseMediaObject != null && !baseMediaObject.checkArgs()) {
      LogUtil.e("WeiboMultiMessage", "checkArgs fail, mediaObject is invalid");
      return false;
    } 
    if (this.textObject == null && this.imageObject == null && this.mediaObject == null) {
      LogUtil.e("WeiboMultiMessage", "checkArgs fail, textObject and imageObject and mediaObject is null");
      return false;
    } 
    return true;
  }
  
  public Bundle toBundle(Bundle paramBundle) {
    TextObject textObject = this.textObject;
    if (textObject != null) {
      paramBundle.putParcelable("_weibo_message_text", textObject);
      paramBundle.putString("_weibo_message_text_extra", this.textObject.toExtraMediaString());
    } 
    ImageObject imageObject = this.imageObject;
    if (imageObject != null) {
      paramBundle.putParcelable("_weibo_message_image", imageObject);
      paramBundle.putString("_weibo_message_image_extra", this.imageObject.toExtraMediaString());
    } 
    BaseMediaObject baseMediaObject = this.mediaObject;
    if (baseMediaObject != null) {
      paramBundle.putParcelable("_weibo_message_media", baseMediaObject);
      paramBundle.putString("_weibo_message_media_extra", this.mediaObject.toExtraMediaString());
    } 
    return paramBundle;
  }
  
  public WeiboMultiMessage toObject(Bundle paramBundle) {
    this.textObject = (TextObject)paramBundle.getParcelable("_weibo_message_text");
    TextObject textObject = this.textObject;
    if (textObject != null)
      textObject.toExtraMediaObject(paramBundle.getString("_weibo_message_text_extra")); 
    this.imageObject = (ImageObject)paramBundle.getParcelable("_weibo_message_image");
    ImageObject imageObject = this.imageObject;
    if (imageObject != null)
      imageObject.toExtraMediaObject(paramBundle.getString("_weibo_message_image_extra")); 
    this.mediaObject = (BaseMediaObject)paramBundle.getParcelable("_weibo_message_media");
    BaseMediaObject baseMediaObject = this.mediaObject;
    if (baseMediaObject != null)
      baseMediaObject.toExtraMediaObject(paramBundle.getString("_weibo_message_media_extra")); 
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\WeiboMultiMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */