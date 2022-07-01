package com.huawei.hms.security;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.api.HuaweiServicesNotAvailableException;
import com.huawei.hms.api.HuaweiServicesRepairableException;

public class SecComponentInstallWizard {
  public static final String PROVIDER_NAME = "HmsCore_OpenSSL";
  
  public static void install(Context paramContext) throws HuaweiServicesNotAvailableException, HuaweiServicesRepairableException {}
  
  public static interface SecComponentInstallWizardListener {
    void onFailed(int param1Int, Intent param1Intent);
    
    void onSuccess();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\security\SecComponentInstallWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */