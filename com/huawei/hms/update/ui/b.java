package com.huawei.hms.update.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;

public abstract class b {
  private AlertDialog a;
  
  private a b;
  
  private static int a(Context paramContext) {
    return (paramContext == null) ? 0 : paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  protected abstract AlertDialog a();
  
  public void a(a parama) {
    this.b = parama;
    if (f() == null || f().isFinishing()) {
      HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
      return;
    } 
    this.a = a();
    this.a.setCanceledOnTouchOutside(false);
    this.a.setOnCancelListener(new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            this.a.d();
          }
        });
    this.a.show();
  }
  
  public void b() {
    AlertDialog alertDialog = this.a;
    if (alertDialog != null)
      alertDialog.cancel(); 
  }
  
  public void c() {
    AlertDialog alertDialog = this.a;
    if (alertDialog != null)
      alertDialog.dismiss(); 
  }
  
  protected void d() {
    a a1 = this.b;
    if (a1 != null)
      a1.a(this); 
  }
  
  protected void e() {
    a a1 = this.b;
    if (a1 != null)
      a1.b(this); 
  }
  
  protected Activity f() {
    a a1 = this.b;
    return (a1 != null) ? a1.b() : null;
  }
  
  protected int g() {
    return (a((Context)f()) != 0 && Build.VERSION.SDK_INT >= 16) ? 0 : 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\updat\\ui\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */