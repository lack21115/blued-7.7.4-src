package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class i extends b {
  private String a = ResourceLoaderUtil.getString("hms_update_title");
  
  protected AlertDialog a() {
    int j = ResourceLoaderUtil.getStringId("hms_update_message_new");
    int k = ResourceLoaderUtil.getStringId("hms_install");
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)f(), g());
    builder.setMessage(f().getString(j, new Object[] { this.a }));
    builder.setPositiveButton(k, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.e();
          }
        });
    builder.setNegativeButton(ResourceLoaderUtil.getStringId("hms_cancel"), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.b();
          }
        });
    return builder.create();
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */