package com.ss.android.socialbase.appdownloader.d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.c.b;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;

public class a extends b {
  private AlertDialog.Builder a;
  
  public a(Context paramContext) {
    this.a = new AlertDialog.Builder(paramContext);
  }
  
  public j a() {
    return new a(this.a);
  }
  
  public k a(int paramInt) {
    AlertDialog.Builder builder = this.a;
    if (builder != null)
      builder.setTitle(paramInt); 
    return (k)this;
  }
  
  public k a(int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
    AlertDialog.Builder builder = this.a;
    if (builder != null)
      builder.setPositiveButton(paramInt, paramOnClickListener); 
    return (k)this;
  }
  
  public k a(DialogInterface.OnCancelListener paramOnCancelListener) {
    AlertDialog.Builder builder = this.a;
    if (builder != null)
      builder.setOnCancelListener(paramOnCancelListener); 
    return (k)this;
  }
  
  public k a(String paramString) {
    AlertDialog.Builder builder = this.a;
    if (builder != null)
      builder.setMessage(paramString); 
    return (k)this;
  }
  
  public k b(int paramInt, DialogInterface.OnClickListener paramOnClickListener) {
    AlertDialog.Builder builder = this.a;
    if (builder != null)
      builder.setNegativeButton(paramInt, paramOnClickListener); 
    return (k)this;
  }
  
  static class a implements j {
    private AlertDialog a;
    
    public a(AlertDialog.Builder param1Builder) {
      if (param1Builder != null)
        this.a = param1Builder.show(); 
    }
    
    public void a() {
      AlertDialog alertDialog = this.a;
      if (alertDialog != null)
        alertDialog.show(); 
    }
    
    public boolean b() {
      AlertDialog alertDialog = this.a;
      return (alertDialog != null) ? alertDialog.isShowing() : false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */