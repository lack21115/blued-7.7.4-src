package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

public class SendMultiMessageToWeiboRequest extends BaseRequest {
  public WeiboMultiMessage multiMessage;
  
  public SendMultiMessageToWeiboRequest() {}
  
  public SendMultiMessageToWeiboRequest(Bundle paramBundle) {
    fromBundle(paramBundle);
  }
  
  final boolean check(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, VersionCheckHandler paramVersionCheckHandler) {
    return (this.multiMessage != null && paramWeiboInfo != null) ? (!paramWeiboInfo.isLegal() ? false : ((paramVersionCheckHandler != null && !paramVersionCheckHandler.checkRequest(paramContext, paramWeiboInfo, this.multiMessage)) ? false : this.multiMessage.checkArgs())) : false;
  }
  
  public void fromBundle(Bundle paramBundle) {
    super.fromBundle(paramBundle);
    this.multiMessage = new WeiboMultiMessage(paramBundle);
  }
  
  public int getType() {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle) {
    super.toBundle(paramBundle);
    paramBundle.putAll(this.multiMessage.toBundle(paramBundle));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\share\SendMultiMessageToWeiboRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */