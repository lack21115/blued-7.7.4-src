package com.blued.android.chat.core.worker.link;

import com.blued.android.chat.core.pack.BasePackage;

public interface LinkListener {
  void onLinkReceive(BasePackage paramBasePackage);
  
  void onLinkSendFailed(BasePackage paramBasePackage, String paramString);
  
  void onLinkSendSuccess(BasePackage paramBasePackage);
  
  void onLinkStateChanged(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\link\LinkListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */