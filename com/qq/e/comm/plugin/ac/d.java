package com.qq.e.comm.plugin.ac;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.c.a.b;
import com.qq.e.comm.plugin.util.y;

public class d {
  private final Activity a;
  
  private final int b;
  
  private final b c;
  
  private AlertDialog d;
  
  public d(Activity paramActivity, int paramInt, b paramb) {
    this.a = paramActivity;
    this.b = paramInt;
    this.c = paramb;
    c();
  }
  
  private void c() {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.a, bool);
    builder.setTitle("温馨提示").setMessage(d()).setPositiveButton("确认", new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (d.a(this.a) != null)
              d.a(this.a).b(); 
          }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (d.a(this.a) != null)
              d.a(this.a).a(); 
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            if (d.a(this.a) != null)
              d.a(this.a).a(); 
          }
        });
    this.d = builder.create();
  }
  
  private String d() {
    if (com.qq.e.comm.plugin.a.d.d.c(this.b))
      return "开始安装应用?"; 
    NetworkType networkType = GDTADManager.getInstance().getDeviceStatus().getNetworkType();
    return (networkType == NetworkType.WIFI) ? "当前为wifi网络，开始下载应用？" : ((networkType == NetworkType.NET_2G) ? "当前为2G网络，开始下载应用？" : ((networkType == NetworkType.NET_3G) ? "当前为3G网络，开始下载应用？" : ((networkType == NetworkType.NET_4G) ? "当前为4G网络，开始下载应用？" : "当前为非wifi网络，开始下载应用？")));
  }
  
  public void a() {
    y.a(new Runnable(this) {
          public void run() {
            this.a.b();
            if (d.b(this.a) != null)
              d.b(this.a).show(); 
          }
        });
  }
  
  public void b() {
    AlertDialog alertDialog = this.d;
    if (alertDialog != null && alertDialog.isShowing())
      this.d.dismiss(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */