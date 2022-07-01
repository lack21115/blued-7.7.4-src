package com.baidu.mobads.interfaces.utils;

import android.app.Activity;
import android.content.DialogInterface;

public interface IXAdActivityUtils {
  Boolean isFullScreen(Activity paramActivity);
  
  void showAlertDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2);
  
  boolean webviewMultiProcess(Activity paramActivity);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IXAdActivityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */