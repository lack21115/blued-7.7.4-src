package com.blued.android.module.chat.http;

import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedUIHttpResponse;

public class ModuleChatHttpUtils {
  private static final String TAG = ModuleChatHttpUtils.class.getSimpleName();
  
  private static ModuleChatHttpUtils instance;
  
  private IModuleChatHttp mImpl;
  
  public static ModuleChatHttpUtils getInstance() {
    if (instance == null)
      instance = new ModuleChatHttpUtils(); 
    return instance;
  }
  
  public void getChatRelationData(BluedUIHttpResponse paramBluedUIHttpResponse, Long[] paramArrayOfLong) {
    IModuleChatHttp iModuleChatHttp = this.mImpl;
    if (iModuleChatHttp != null)
      iModuleChatHttp.getChatRelationData((StringHttpResponseHandler)paramBluedUIHttpResponse, paramArrayOfLong); 
  }
  
  public void setHttpImpl(IModuleChatHttp paramIModuleChatHttp) {
    this.mImpl = paramIModuleChatHttp;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\http\ModuleChatHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */