package com.ss.android.downloadlib.b;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.ss.android.a.a.a.j;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.c;

public class a implements j {
  private static Dialog a(c paramc) {
    if (paramc == null)
      return null; 
    AlertDialog alertDialog = (new AlertDialog.Builder(paramc.a)).setTitle(paramc.b).setMessage(paramc.c).setPositiveButton(paramc.d, new DialogInterface.OnClickListener(paramc) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.h != null)
              this.a.h.a(param1DialogInterface); 
          }
        }).setNegativeButton(paramc.e, new DialogInterface.OnClickListener(paramc) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.h != null)
              this.a.h.b(param1DialogInterface); 
          }
        }).show();
    alertDialog.setCanceledOnTouchOutside(paramc.f);
    alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener(paramc) {
          public void onCancel(DialogInterface param1DialogInterface) {
            if (this.a.h != null)
              this.a.h.c(param1DialogInterface); 
          }
        });
    if (paramc.g != null)
      alertDialog.setIcon(paramc.g); 
    return (Dialog)alertDialog;
  }
  
  public void a(int paramInt1, Context paramContext, c paramc, String paramString, Drawable paramDrawable, int paramInt2) {
    Toast.makeText(paramContext, paramString, 0).show();
  }
  
  public Dialog b(c paramc) {
    return a(paramc);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */