package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class d extends b {
  public AlertDialog a() {
    ProgressDialog progressDialog = new ProgressDialog((Context)f(), g());
    progressDialog.setMessage(ResourceLoaderUtil.getString("hms_checking"));
    progressDialog.setCanceledOnTouchOutside(false);
    return (AlertDialog)progressDialog;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */