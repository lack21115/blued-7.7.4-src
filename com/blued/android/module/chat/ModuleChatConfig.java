package com.blued.android.module.chat;

import com.blued.android.module.chat.db.SessionSettingDBOper;
import com.blued.android.module.chat.http.IModuleChatHttp;
import com.blued.android.module.chat.http.ModuleChatHttpUtils;
import com.blued.android.module.chat.manager.SessionDataManager;

public class ModuleChatConfig {
  private static ModuleChatConfig instance;
  
  private String TAG = ModuleChatConfig.class.getSimpleName();
  
  public static ModuleChatConfig getInstance() {
    if (instance == null)
      instance = new ModuleChatConfig(); 
    return instance;
  }
  
  public void setHttpImpl(IModuleChatHttp paramIModuleChatHttp) {
    ModuleChatHttpUtils.getInstance().setHttpImpl(paramIModuleChatHttp);
  }
  
  public void setSessionSettingDBOperImpl(SessionSettingDBOper paramSessionSettingDBOper) {
    SessionDataManager.getInstance().init(paramSessionSettingDBOper);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\ModuleChatConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */