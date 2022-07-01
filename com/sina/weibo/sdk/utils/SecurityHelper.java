package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.WeiboAppManager;

public class SecurityHelper {
  public static boolean checkResponseAppLegal(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, Intent paramIntent) {
    if (paramWeiboInfo != null && paramWeiboInfo.getSupportApi() <= 10352)
      return true; 
    if (paramWeiboInfo == null)
      return true; 
    if (paramIntent != null) {
      String str = paramIntent.getStringExtra("_weibo_appPackage");
    } else {
      paramWeiboInfo = null;
    } 
    return !(paramWeiboInfo == null || paramIntent.getStringExtra("_weibo_transaction") == null || !ApiUtils.validateWeiboSign(paramContext, (String)paramWeiboInfo));
  }
  
  public static boolean containSign(Signature[] paramArrayOfSignature, String paramString) {
    if (paramArrayOfSignature != null) {
      if (paramString == null)
        return false; 
      int j = paramArrayOfSignature.length;
      for (int i = 0;; i++) {
        if (i >= j)
          return false; 
        if (paramString.equals(MD5.hexdigest(paramArrayOfSignature[i].toByteArray())))
          return true; 
      } 
    } 
    return false;
  }
  
  public static boolean validateAppSignatureForIntent(Context paramContext, Intent paramIntent) {
    PackageManager packageManager = paramContext.getPackageManager();
    if (packageManager == null)
      return false; 
    ResolveInfo resolveInfo = packageManager.resolveActivity(paramIntent, 0);
    if (resolveInfo == null)
      return false; 
    String str = resolveInfo.activityInfo.packageName;
    try {
      return containSign((packageManager.getPackageInfo(str, 64)).signatures, "18da2bf10352443a00a5e046d9fca6bd");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      return false;
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\SecurityHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */