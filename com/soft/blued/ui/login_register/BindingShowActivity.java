package com.soft.blued.ui.login_register;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.view.tip.CommonAlertDialog;

public class BindingShowActivity extends BaseFragmentActivity {
  private String c = BindingShowActivity.class.getSimpleName();
  
  private void h() {
    CommonAlertDialog.a((Context)this, "", getResources().getString(2131757830), getResources().getString(2131757825), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            TerminalActivity.d((Context)this.a, LinkMobileFragment.class, null);
            this.a.finish();
          }
        }getResources().getString(2131757826), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.finish();
          }
        },  new DialogInterface.OnDismissListener(this) {
          public void onDismiss(DialogInterface param1DialogInterface) {
            this.a.finish();
          }
        });
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\BindingShowActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */