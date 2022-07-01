package com.blued.android.module.shortvideo.utils;

import android.app.Dialog;
import android.content.Context;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.shortvideo.R;

public class StvDialogUtils {
  public static final Dialog a(Context paramContext) {
    Dialog dialog = new Dialog(paramContext, R.style.SeventyTransBackgroud);
    dialog.setContentView(R.layout.stv_loading_layout);
    dialog.getWindow().setFlags(1024, 1024);
    dialog.setCanceledOnTouchOutside(false);
    return dialog;
  }
  
  public static final Dialog b(Context paramContext) {
    Dialog dialog = new Dialog(paramContext, R.style.SeventyTransBackgroud);
    dialog.setContentView(R.layout.stv_loading_layout);
    StatusBarHelper.a(dialog.getWindow());
    dialog.setCanceledOnTouchOutside(false);
    return dialog;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\StvDialogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */