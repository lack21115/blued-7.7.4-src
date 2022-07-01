package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

public abstract class DialogRedirect implements DialogInterface.OnClickListener {
  public static DialogRedirect getInstance(Activity paramActivity, Intent paramIntent, int paramInt) {
    return new DialogRedirectImpl(paramIntent, paramActivity, paramInt);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    try {
      redirect();
      return;
    } finally {
      null = null;
    } 
  }
  
  protected abstract void redirect();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\DialogRedirect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */