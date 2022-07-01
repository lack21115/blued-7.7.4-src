package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMessage;

public class ProvideMessageForWeiboResponse extends BaseResponse {
  public WeiboMessage message;
  
  public ProvideMessageForWeiboResponse() {}
  
  public ProvideMessageForWeiboResponse(Bundle paramBundle) {
    fromBundle(paramBundle);
  }
  
  final boolean check(Context paramContext, VersionCheckHandler paramVersionCheckHandler) {
    return (this.message == null) ? false : ((paramVersionCheckHandler != null && !paramVersionCheckHandler.checkResponse(paramContext, this.reqPackageName, this.message)) ? false : this.message.checkArgs());
  }
  
  public void fromBundle(Bundle paramBundle) {
    super.fromBundle(paramBundle);
    this.message = new WeiboMessage(paramBundle);
  }
  
  public int getType() {
    return 2;
  }
  
  public void toBundle(Bundle paramBundle) {
    super.toBundle(paramBundle);
    paramBundle.putAll(this.message.toBundle(paramBundle));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\share\ProvideMessageForWeiboResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */