package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
  private boolean a;
  
  private void a() {
    if (this.a) {
      super.dismissAllowingStateLoss();
      return;
    } 
    super.dismiss();
  }
  
  private void a(BottomSheetBehavior<?> paramBottomSheetBehavior, boolean paramBoolean) {
    this.a = paramBoolean;
    if (paramBottomSheetBehavior.d() == 5) {
      a();
      return;
    } 
    if (getDialog() instanceof BottomSheetDialog)
      ((BottomSheetDialog)getDialog()).d(); 
    paramBottomSheetBehavior.a(new BottomSheetDismissCallback());
    paramBottomSheetBehavior.d(5);
  }
  
  private boolean a(boolean paramBoolean) {
    Dialog dialog = getDialog();
    if (dialog instanceof BottomSheetDialog) {
      BottomSheetDialog bottomSheetDialog = (BottomSheetDialog)dialog;
      BottomSheetBehavior<FrameLayout> bottomSheetBehavior = bottomSheetDialog.a();
      if (bottomSheetBehavior.b() && bottomSheetDialog.b()) {
        a(bottomSheetBehavior, paramBoolean);
        return true;
      } 
    } 
    return false;
  }
  
  public void dismiss() {
    if (!a(false))
      super.dismiss(); 
  }
  
  public void dismissAllowingStateLoss() {
    if (!a(true))
      super.dismissAllowingStateLoss(); 
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    return (Dialog)new BottomSheetDialog(getContext(), getTheme());
  }
  
  class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
    private BottomSheetDismissCallback(BottomSheetDialogFragment this$0) {}
    
    public void a(View param1View, float param1Float) {}
    
    public void a(View param1View, int param1Int) {
      if (param1Int == 5)
        BottomSheetDialogFragment.a(this.a); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\bottomsheet\BottomSheetDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */