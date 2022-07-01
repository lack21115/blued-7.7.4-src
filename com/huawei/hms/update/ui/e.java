package com.huawei.hms.update.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.hms.utils.ResourceLoaderUtil;

public final class e {
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
      builder.setNegativeButton(j(), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param2DialogInterface, int param2Int) {
              this.a.b();
            }
          });
      return builder.create();
    }
    
    protected abstract int h();
    
    protected abstract int i();
    
    protected abstract int j();
  }
  
  class null implements DialogInterface.OnClickListener {
    null(e this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.a.e();
    }
  }
  
  class null implements DialogInterface.OnClickListener {
    null(e this$0) {}
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.a.b();
    }
  }
  
  public static class b extends a {
    protected int h() {
      return ResourceLoaderUtil.getStringId("hms_update_nettype");
    }
    
    protected int i() {
      return ResourceLoaderUtil.getStringId("hms_update_continue");
    }
    
    protected int j() {
      return ResourceLoaderUtil.getStringId("hms_cancel");
    }
  }
  
  public static class c extends a {
    protected int h() {
      return ResourceLoaderUtil.getStringId("hms_download_retry");
    }
    
    protected int i() {
      return ResourceLoaderUtil.getStringId("hms_retry");
    }
    
    protected int j() {
      return ResourceLoaderUtil.getStringId("hms_cancel");
    }
  }
  
  public static class d extends a {
    protected int h() {
      return ResourceLoaderUtil.getStringId("hms_abort_message");
    }
    
    protected int i() {
      return ResourceLoaderUtil.getStringId("hms_abort");
    }
    
    protected int j() {
      return ResourceLoaderUtil.getStringId("hms_cancel");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */