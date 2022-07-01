package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.hms.utils.ResourceLoaderUtil;

public final class j {
  static abstract class a extends b {
    private a() {}
    
    public AlertDialog a() {
      AlertDialog.Builder builder = new AlertDialog.Builder((Context)f(), g());
      builder.setMessage(h());
      builder.setPositiveButton(i(), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param2DialogInterface, int param2Int) {
              this.a.e();
            }
          });
      return builder.create();
    }
    
    protected abstract int h();
    
    protected int i() {
      return ResourceLoaderUtil.getStringId("hms_confirm");
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    null(j this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.a.e();
    }
  }
  
  public static class b extends a {
    protected int h() {
      return ResourceLoaderUtil.getStringId("hms_check_failure");
    }
  }
  
  public static class c extends a {
    protected int h() {
      return ResourceLoaderUtil.getStringId("hms_download_failure");
    }
  }
  
  public static class d extends a {
    protected int h() {
      return ResourceLoaderUtil.getStringId("hms_download_no_space");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */