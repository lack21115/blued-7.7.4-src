package com.soft.blued;

import android.content.Context;
import com.wrapper.proxyapplication.WrapperProxyApplication;

public class MyWrapperProxyApplication extends WrapperProxyApplication {
  public MyWrapperProxyApplication() {
    throw new VerifyError("bad dex opcode");
  }
  
  protected void initProxyApplication(Context paramContext) {
    throw new VerifyError("bad dex opcode");
  }
  
  public void onCreate() {
    super.onCreate();
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\soft\blued\MyWrapperProxyApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */