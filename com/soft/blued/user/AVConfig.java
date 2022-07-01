package com.soft.blued.user;

import com.blued.android.core.AppInfo;
import com.google.gson.Gson;
import com.soft.blued.ui.login_register.model.AVConfigModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;

public class AVConfig {
  private static AVConfig b;
  
  public boolean a = false;
  
  private AVConfigModel c;
  
  private AVConfig() {
    Gson gson = AppInfo.f();
    String str = BluedPreferences.E();
    if (!StringUtils.e(str))
      try {
        this.c = (AVConfigModel)gson.fromJson(str, AVConfigModel.class);
        return;
      } catch (Exception exception) {
        this.c = new AVConfigModel();
        return;
      }  
    this.c = new AVConfigModel();
  }
  
  public static AVConfig a() {
    // Byte code:
    //   0: ldc com/soft/blued/user/AVConfig
    //   2: monitorenter
    //   3: getstatic com/soft/blued/user/AVConfig.b : Lcom/soft/blued/user/AVConfig;
    //   6: ifnonnull -> 19
    //   9: new com/soft/blued/user/AVConfig
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/soft/blued/user/AVConfig.b : Lcom/soft/blued/user/AVConfig;
    //   19: getstatic com/soft/blued/user/AVConfig.b : Lcom/soft/blued/user/AVConfig;
    //   22: astore_0
    //   23: ldc com/soft/blued/user/AVConfig
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/soft/blued/user/AVConfig
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public void a(AVConfigModel paramAVConfigModel, boolean paramBoolean) {
    Logger.b("ljx updateAVConfig", new Object[] { paramAVConfigModel });
    this.a = paramBoolean;
    try {
      String str = AppInfo.f().toJson(paramAVConfigModel);
      Logger.b("ljx json", new Object[] { str });
      this.c = paramAVConfigModel;
      BluedPreferences.f(str);
      return;
    } catch (Exception exception) {
      BluedPreferences.f("");
      return;
    } 
  }
  
  public AVConfigModel b() {
    Logger.b("ljx getAvConfig", new Object[] { this.c });
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\user\AVConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */