package com.blued.android.module.live.base.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.blued.android.module.common.view.LifecycleDialog;
import com.blued.android.module.res_china.R;

public class LiveAlterDialog {
  public static Dialog a(Context paramContext, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener, View.OnClickListener paramOnClickListener, boolean paramBoolean1, boolean paramBoolean2) {
    View view = LayoutInflater.from(paramContext).inflate(paramInt, null);
    LifecycleDialog lifecycleDialog = new LifecycleDialog(paramContext);
    lifecycleDialog.setContentView(view);
    lifecycleDialog.setCanceledOnTouchOutside(paramBoolean2);
    Window window = lifecycleDialog.getWindow();
    window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    window.clearFlags(131072);
    lifecycleDialog.show();
    if (view.findViewById(R.id.tv_ok) != null)
      view.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener(lifecycleDialog, paramOnClickListener) {
            public void onClick(View param1View) {
              this.a.cancel();
              View.OnClickListener onClickListener = this.b;
              if (onClickListener != null)
                onClickListener.onClick(param1View); 
            }
          }); 
    if (view.findViewById(R.id.close) != null)
      view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener(lifecycleDialog) {
            public void onClick(View param1View) {
              this.a.cancel();
            }
          }); 
    return (Dialog)lifecycleDialog;
  }
  
  public static Dialog a(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2) {
    View view = LayoutInflater.from(paramContext).inflate(paramInt, null);
    LifecycleDialog lifecycleDialog = new LifecycleDialog(paramContext);
    lifecycleDialog.setContentView(view);
    lifecycleDialog.setCanceledOnTouchOutside(paramBoolean2);
    Window window = lifecycleDialog.getWindow();
    window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    window.clearFlags(131072);
    lifecycleDialog.show();
    if (view.findViewById(R.id.tv_ok) != null)
      view.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener(lifecycleDialog, paramOnClickListener2) {
            public void onClick(View param1View) {
              this.a.cancel();
              View.OnClickListener onClickListener = this.b;
              if (onClickListener != null)
                onClickListener.onClick(param1View); 
            }
          }); 
    if (view.findViewById(R.id.close) != null)
      view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener(lifecycleDialog, paramOnClickListener1) {
            public void onClick(View param1View) {
              this.a.cancel();
              View.OnClickListener onClickListener = this.b;
              if (onClickListener != null)
                onClickListener.onClick(param1View); 
            }
          }); 
    return (Dialog)lifecycleDialog;
  }
  
  public static Dialog a(Context paramContext, View paramView, DialogInterface.OnCancelListener paramOnCancelListener, View.OnClickListener paramOnClickListener, boolean paramBoolean1, boolean paramBoolean2) {
    View view = paramView;
    if (paramView == null)
      view = new View(paramContext); 
    LifecycleDialog lifecycleDialog = new LifecycleDialog(paramContext);
    lifecycleDialog.setContentView(view);
    lifecycleDialog.setCanceledOnTouchOutside(paramBoolean2);
    Window window = lifecycleDialog.getWindow();
    window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    window.clearFlags(131072);
    lifecycleDialog.show();
    if (view.findViewById(R.id.tv_ok) != null)
      view.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener(lifecycleDialog, paramOnClickListener) {
            public void onClick(View param1View) {
              this.a.cancel();
              View.OnClickListener onClickListener = this.b;
              if (onClickListener != null)
                onClickListener.onClick(param1View); 
            }
          }); 
    if (view.findViewById(R.id.close) != null)
      view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener(lifecycleDialog) {
            public void onClick(View param1View) {
              this.a.cancel();
            }
          }); 
    return (Dialog)lifecycleDialog;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\bas\\utils\LiveAlterDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */