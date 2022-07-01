package com.baidu.mobads.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import java.util.List;

public class f implements IXAdActivityUtils {
  public Boolean isFullScreen(Activity paramActivity) {
    if (paramActivity != null) {
      try {
        if (((paramActivity.getWindow().getAttributes()).flags & 0x400) == 1024) {
          boolean bool1 = true;
          return Boolean.valueOf(bool1);
        } 
      } catch (Exception exception) {
        return Boolean.valueOf(false);
      } 
    } else {
      return Boolean.valueOf(false);
    } 
    boolean bool = false;
    return Boolean.valueOf(bool);
  }
  
  public void showAlertDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {
    if (paramActivity == null)
      return; 
    try {
      (new AlertDialog.Builder((Context)paramActivity)).setCancelable(paramBoolean).setTitle(paramString1).setMessage(paramString2).setPositiveButton(paramString3, paramOnClickListener1).setNegativeButton(paramString4, paramOnClickListener2).create().show();
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return;
    } 
  }
  
  public boolean webviewMultiProcess(Activity paramActivity) {
    boolean bool = false;
    null = bool;
    if (paramActivity != null) {
      List list = paramActivity.getPackageManager().queryIntentActivities(new Intent((Context)paramActivity, AppActivity.getActivityClass()), 0);
      null = bool;
      if (list != null) {
        null = bool;
        if (list.size() > 0) {
          String str = ((ResolveInfo)list.get(0)).activityInfo.processName;
          null = bool;
          if (!TextUtils.isEmpty(str)) {
            if (!str.contains(":")) {
              null = bool;
              return str.endsWith("webview") ? true : null;
            } 
          } else {
            return null;
          } 
        } else {
          return null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */