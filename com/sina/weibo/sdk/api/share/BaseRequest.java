package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.WeiboAppManager;

public abstract class BaseRequest extends Base {
  public String packageName;
  
  abstract boolean check(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, VersionCheckHandler paramVersionCheckHandler);
  
  public void fromBundle(Bundle paramBundle) {
    this.transaction = paramBundle.getString("_weibo_transaction");
    this.packageName = paramBundle.getString("_weibo_appPackage");
  }
  
  public void toBundle(Bundle paramBundle) {
    paramBundle.putInt("_weibo_command_type", getType());
    paramBundle.putString("_weibo_transaction", this.transaction);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\share\BaseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */