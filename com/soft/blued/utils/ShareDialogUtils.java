package com.soft.blued.utils;

import android.app.Dialog;
import android.content.Context;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module_share_china.R;

public class ShareDialogUtils {
  public static final Dialog a(Context paramContext) {
    return a(paramContext, true);
  }
  
  public static final Dialog a(Context paramContext, boolean paramBoolean) {
    Dialog dialog = new Dialog(paramContext, R.style.TranslucentBackground);
    dialog.setContentView(R.layout.share_common_loading_layout);
    StatusBarHelper.a(dialog.getWindow());
    dialog.setCancelable(paramBoolean);
    return dialog;
  }
  
  public static void a(Dialog paramDialog) {
    if (paramDialog != null)
      try {
        if (!paramDialog.isShowing())
          return; 
      } finally {
        paramDialog = null;
      }  
  }
  
  public static void b(Dialog paramDialog) {
    if (paramDialog != null)
      try {
        if (paramDialog.isShowing())
          return; 
      } finally {
        paramDialog = null;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\ShareDialogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */