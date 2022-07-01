package com.blued.android.framework.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.R;

public class ConfirmDialog implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, View.OnClickListener {
  private Dialog a = null;
  
  private Context b;
  
  private View c = null;
  
  private OperationListener d = null;
  
  private boolean e = true;
  
  private Drawable f;
  
  private Drawable g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private boolean l = true;
  
  public ConfirmDialog(Context paramContext) {
    this.b = paramContext;
  }
  
  private void a(Window paramWindow) {
    if (paramWindow != null && paramWindow.getDecorView() != null) {
      if (Build.VERSION.SDK_INT >= 21) {
        paramWindow.getDecorView().setSystemUiVisibility(1280);
        paramWindow.addFlags(-2147483648);
        paramWindow.setStatusBarColor(0);
      } 
      paramWindow.setBackgroundDrawableResource(17170445);
    } 
  }
  
  private void a(Operation paramOperation) {
    OperationListener operationListener = this.d;
    if (operationListener != null) {
      operationListener.a(paramOperation);
      this.l = false;
      a();
    } 
  }
  
  private void b(View paramView) {
    ImageView imageView = (ImageView)paramView.findViewById(R.id.confirm_dialog_imageview_close_icon);
    if (imageView != null)
      if (this.e) {
        imageView.setVisibility(8);
      } else {
        imageView.setImageDrawable(this.g);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
      }  
    imageView = (ImageView)paramView.findViewById(R.id.confirm_dialog_imageview_top_picture);
    if (imageView != null) {
      Drawable drawable = this.f;
      if (drawable == null) {
        imageView.setVisibility(8);
      } else {
        imageView.setImageDrawable(drawable);
        imageView.setVisibility(0);
      } 
    } 
    TextView textView2 = (TextView)paramView.findViewById(R.id.confirm_dialog_textview_title);
    if (textView2 != null)
      if (TextUtils.isEmpty(this.h)) {
        textView2.setVisibility(8);
      } else {
        textView2.setText(this.h);
        textView2.setVisibility(0);
      }  
    textView2 = (TextView)paramView.findViewById(R.id.confirm_dialog_textview_message);
    if (textView2 != null)
      if (TextUtils.isEmpty(this.i)) {
        textView2.setVisibility(8);
      } else {
        textView2.setText(this.i);
        textView2.setVisibility(0);
      }  
    textView2 = (TextView)paramView.findViewById(R.id.confirm_dialog_textview_positive);
    if (textView2 != null)
      if (TextUtils.isEmpty(this.j)) {
        textView2.setVisibility(8);
      } else {
        textView2.setText(this.j);
        textView2.setVisibility(0);
        textView2.setOnClickListener(this);
      }  
    TextView textView1 = (TextView)paramView.findViewById(R.id.confirm_dialog_textview_nagative);
    if (textView1 != null) {
      if (TextUtils.isEmpty(this.k)) {
        textView1.setVisibility(8);
        return;
      } 
      textView1.setText(this.k);
      textView1.setVisibility(0);
      textView1.setOnClickListener(this);
    } 
  }
  
  public ConfirmDialog a(View paramView) {
    this.c = paramView;
    return this;
  }
  
  public ConfirmDialog a(OperationListener paramOperationListener) {
    this.d = paramOperationListener;
    return this;
  }
  
  public ConfirmDialog a(boolean paramBoolean) {
    this.e = paramBoolean;
    return this;
  }
  
  public void a() {
    Dialog dialog = this.a;
    if (dialog != null && dialog.isShowing()) {
      this.a.dismiss();
      this.a = null;
    } 
  }
  
  public void b() {
    if (this.c == null)
      return; 
    this.a = new Dialog(this.b);
    this.a.requestWindowFeature(1);
    this.a.setContentView(this.c);
    this.a.setCancelable(this.e);
    this.a.setCanceledOnTouchOutside(this.e);
    if (this.e)
      this.a.setOnCancelListener(this); 
    this.a.setOnDismissListener(this);
    a(this.a.getWindow());
    b(this.c);
    this.a.show();
  }
  
  public boolean c() {
    Dialog dialog = this.a;
    return (dialog != null && dialog.isShowing());
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    OperationListener operationListener = this.d;
    if (operationListener != null) {
      operationListener.a(Operation.d);
      this.l = false;
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.confirm_dialog_textview_positive) {
      a(Operation.a);
      return;
    } 
    if (paramView.getId() == R.id.confirm_dialog_textview_nagative) {
      a(Operation.b);
      return;
    } 
    if (paramView.getId() == R.id.confirm_dialog_imageview_close_icon)
      a(Operation.c); 
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    OperationListener operationListener = this.d;
    if (operationListener != null && this.l)
      operationListener.a(Operation.e); 
  }
  
  public enum Operation {
    a, b, c, d, e;
  }
  
  public static interface OperationListener {
    void a(ConfirmDialog.Operation param1Operation);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\dialog\ConfirmDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */