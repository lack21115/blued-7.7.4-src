package org.chromium.content.browser;

import android.os.Bundle;
import org.chromium.base.ContextUtils;

public class ChildProcessCreationParamsImpl {
  private static boolean sBindToCallerCheck;
  
  private static boolean sIgnoreVisibilityForImportance;
  
  private static boolean sInitialized;
  
  private static boolean sIsSandboxedServiceExternal;
  
  private static int sLibraryProcessType;
  
  private static String sPackageNameForService;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void addIntentExtras(Bundle paramBundle) {
    if (sInitialized)
      paramBundle.putInt("org.chromium.content.common.child_service_params.library_process_type", sLibraryProcessType); 
  }
  
  public static boolean getBindToCallerCheck() {
    return (sInitialized && sBindToCallerCheck);
  }
  
  public static boolean getIgnoreVisibilityForImportance() {
    return (sInitialized && sIgnoreVisibilityForImportance);
  }
  
  public static boolean getIsSandboxedServiceExternal() {
    return (sInitialized && sIsSandboxedServiceExternal);
  }
  
  public static int getLibraryProcessType(Bundle paramBundle) {
    return paramBundle.getInt("org.chromium.content.common.child_service_params.library_process_type", 2);
  }
  
  public static String getPackageNameForService() {
    return sInitialized ? sPackageNameForService : ContextUtils.sApplicationContext.getPackageName();
  }
  
  public static void set(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ChildProcessCreationParamsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */