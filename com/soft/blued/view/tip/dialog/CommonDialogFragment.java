package com.soft.blued.view.tip.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;

public abstract class CommonDialogFragment extends BaseDialogFragment {
  public abstract void a(View paramView);
  
  public abstract int f();
  
  public int g() {
    return AppInfo.m;
  }
  
  public int k() {
    return AppInfo.l;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    Dialog dialog = new Dialog((Context)getActivity(), 2131820782);
    if (Build.VERSION.SDK_INT >= 19)
      dialog.getWindow().addFlags(67108864); 
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(48);
    getDialog().requestWindowFeature(1);
    Window window = getDialog().getWindow();
    window.setGravity(80);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.windowAnimations = 2131820772;
    window.setAttributes(layoutParams);
    window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    window.setLayout(k(), g());
    if (f() != 0) {
      View view = paramLayoutInflater.inflate(f(), (ViewGroup)window.findViewById(16908290), false);
      a(view);
      return view;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\dialog\CommonDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */