package com.soft.blued.ui.circle.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.soft.blued.view.tip.dialog.BottomSheetDialogFragment;

public class AnonymousHelpDialogFragment extends BottomSheetDialogFragment {
  private Context a;
  
  private View b;
  
  public static void a(FragmentManager paramFragmentManager) {
    (new AnonymousHelpDialogFragment()).show(paramFragmentManager, AnonymousHelpDialogFragment.class.getSimpleName());
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setStyle(0, 2131820776);
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt) {
    super.setupDialog(paramDialog, paramInt);
    this.a = getContext();
    this.b = View.inflate(getContext(), 2131492976, null);
    paramDialog.setContentView(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\AnonymousHelpDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */