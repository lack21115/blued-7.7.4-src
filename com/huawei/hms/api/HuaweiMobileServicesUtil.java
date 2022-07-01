package com.huawei.hms.api;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;

public abstract class HuaweiMobileServicesUtil {
  public static final String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2) {
    return HuaweiApiAvailability.getInstance().getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    return HuaweiApiAvailability.getInstance().getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public static String getErrorString(int paramInt) {
    return HuaweiApiAvailability.getInstance().getErrorString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext) {
    return "";
  }
  
  public static Context getRemoteContext(Context paramContext) {
    try {
      return paramContext.createPackageContext(HMSPackageManager.getInstance(paramContext).getHMSPackageName(), 2);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static Resources getRemoteResource(Context paramContext) {
    try {
      return paramContext.getPackageManager().getResourcesForApplication(HMSPackageManager.getInstance(paramContext).getHMSPackageName());
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static int isHuaweiMobileServicesAvailable(Context paramContext) {
    return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(paramContext);
  }
  
  public static int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt) {
    Checker.checkNonNull(paramContext, "context must not be null.");
    if (Build.VERSION.SDK_INT < 16)
      return 21; 
    PackageManagerHelper packageManagerHelper = new PackageManagerHelper(paramContext);
    String str = HMSPackageManager.getInstance(paramContext).getHMSPackageName();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("hmsPackageName is ");
    stringBuilder2.append(str);
    HMSLog.i("HuaweiMobileServicesUtil", stringBuilder2.toString());
    PackageManagerHelper.PackageStates packageStates = packageManagerHelper.getPackageStates(str);
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates)) {
      HMSLog.i("HuaweiMobileServicesUtil", "HMS is not installed");
      return 1;
    } 
    if (PackageManagerHelper.PackageStates.DISABLED.equals(packageStates)) {
      HMSLog.i("HuaweiMobileServicesUtil", "HMS is disabled");
      return 3;
    } 
    packageStates = HMSPackageManager.getInstance(paramContext).getHMSPackageStates();
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates)) {
      String str1 = packageManagerHelper.getPackageSignature(str);
      if (!"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(str1) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(str1) && !"3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C".equalsIgnoreCase(str1))
        return 9; 
    } 
    int i = HMSPackageManager.getInstance(paramContext).getHmsVersionCode();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("connect versionCode:");
    stringBuilder1.append(i);
    HMSLog.i("HuaweiMobileServicesUtil", stringBuilder1.toString());
    if (HMSPackageManager.getInstance(paramContext).isApkUpdateNecessary(paramInt)) {
      HMSLog.i("HuaweiMobileServicesUtil", "The current version does not meet the minimum version requirements");
      return 2;
    } 
    return 0;
  }
  
  public static boolean isUserRecoverableError(int paramInt) {
    return HuaweiApiAvailability.getInstance().isUserResolvableError(paramInt);
  }
  
  public static boolean popupErrDlgFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public static boolean popupErrDlgFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramFragment, paramInt2, paramOnCancelListener);
  }
  
  public static void setApplication(Application paramApplication) {
    ActivityMgr.INST.init(paramApplication);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2) {
    return HuaweiApiAvailability.getInstance().showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public static void showErrorNotification(int paramInt, Context paramContext) {
    HuaweiApiAvailability.getInstance().showErrorNotification(paramContext, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\HuaweiMobileServicesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */