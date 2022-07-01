package com.qq.e.comm.plugin.ac;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.qq.e.comm.plugin.c.a.b;
import com.qq.e.comm.plugin.util.y;

public class c {
  private Activity a;
  
  private String b;
  
  private b c;
  
  private AlertDialog d;
  
  public c(Activity paramActivity, String paramString, b paramb) {
    this.a = paramActivity;
    this.b = paramString;
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
    String str2 = this.b;
    String str1 = str2;
    if (str2 == null)
      str1 = "APP"; 
    builder.setMessage(String.format("前往“%s”了解更多", new Object[] { str1 })).setCancelable(false).setPositiveButton("前往", new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            c.b(this.a).setOnDismissListener(null);
            c.a(this.a).b();
          }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            c.b(this.a).setOnDismissListener(null);
            c.a(this.a).a();
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            c.a(this.a).a();
          }
        });
    this.d = builder.create();
    this.d.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
          public void onDismiss(DialogInterface param1DialogInterface) {
            c.a(this.a).c();
          }
        });
  }
  
  public void a() {
    y.a(new Runnable(this) {
          public void run() {
            this.a.b();
            if (c.b(this.a) != null && !c.c(this.a).isFinishing())
              c.b(this.a).show(); 
          }
        });
  }
  
  public void b() {
    AlertDialog alertDialog = this.d;
    if (alertDialog != null && alertDialog.isShowing())
      this.d.dismiss(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */