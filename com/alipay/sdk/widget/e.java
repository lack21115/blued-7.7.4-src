package com.alipay.sdk.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.alipay.sdk.util.c;

public class e {
  private static AlertDialog.Builder a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, String paramString3, DialogInterface.OnClickListener paramOnClickListener2) {
    AlertDialog.Builder builder = new AlertDialog.Builder(paramContext);
    if (!TextUtils.isEmpty(paramString3) && paramOnClickListener2 != null)
      builder.setPositiveButton(paramString3, paramOnClickListener2); 
    if (!TextUtils.isEmpty(paramString2) && paramOnClickListener1 != null)
      builder.setNegativeButton(paramString2, paramOnClickListener1); 
    return builder;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2) {
    AlertDialog.Builder builder = a(paramContext, paramString1, paramString3, paramOnClickListener1, paramString4, paramOnClickListener2);
    builder.setTitle(paramString1);
    builder.setMessage(paramString2);
    AlertDialog alertDialog = builder.create();
    alertDialog.setCanceledOnTouchOutside(false);
    alertDialog.setOnKeyListener(new f());
    try {
      return (Dialog)alertDialog;
    } finally {
      paramString1 = null;
      c.a("mspl", "showDialog ", (Throwable)paramString1);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */