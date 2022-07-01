package com.soft.blued.customview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;

public class CommonDialog implements View.OnClickListener {
  private Dialog a;
  
  private OnListener b;
  
  public void a() {
    Dialog dialog = this.a;
    if (dialog != null)
      dialog.cancel(); 
  }
  
  public void onClick(View paramView) {
    a();
    if (this.b == null)
      return; 
    switch (paramView.getId()) {
      default:
        return;
      case 2131296926:
        this.b.a();
        return;
      case 2131296925:
        this.b.b();
        return;
      case 2131296924:
        break;
    } 
    this.b.c();
  }
  
  public static interface OnListener {
    void a();
    
    void b();
    
    void c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CommonDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */