package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.HashMap;
import java.util.Map;

public class ConnectionErrorMessages {
  private static final Map<String, String> map = new HashMap<String, String>();
  
  public static String getErrorDialogButtonMessage(Activity paramActivity, int paramInt) {
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext()); 
    return (paramInt != 1) ? ((paramInt != 2) ? ResourceLoaderUtil.getString("hms_confirm") : ResourceLoaderUtil.getString("hms_update")) : ResourceLoaderUtil.getString("hms_install");
  }
  
  public static String getErrorMessage(Activity paramActivity, int paramInt) {
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext()); 
    String str2 = ResourceLoaderUtil.getString("hms_update_title");
    String str1 = str2;
    if (paramInt != 1) {
      str1 = str2;
      if (paramInt != 2)
        str1 = null; 
    } 
    return str1;
  }
  
  public static String getErrorTitle(Activity paramActivity, int paramInt) {
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext()); 
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 9) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected error code ");
            stringBuilder.append(paramInt);
            HMSLog.e("HuaweiApiAvailability", stringBuilder.toString());
            return null;
          } 
          HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
          return null;
        } 
        return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
      } 
      return ResourceLoaderUtil.getString("hms_update_message");
    } 
    return ResourceLoaderUtil.getString("hms_install_message");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\ConnectionErrorMessages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */