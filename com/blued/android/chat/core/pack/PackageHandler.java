package com.blued.android.chat.core.pack;

public interface PackageHandler {
  void onReceive(BasePackage paramBasePackage);
  
  void onSendFailed(BasePackage paramBasePackage, String paramString);
  
  void onSendSuccess(BasePackage paramBasePackage);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\PackageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */