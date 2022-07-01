package com.facebook.stetho.common.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import javax.annotation.Nullable;

final class FragmentCompatSupportLib extends FragmentCompat<Fragment, DialogFragment, FragmentManager, FragmentActivity> {
  private static final DialogFragmentAccessorSupportLib sDialogFragmentAccessor;
  
  private static final FragmentAccessorSupportLib sFragmentAccessor = new FragmentAccessorSupportLib();
  
  private static final FragmentActivityAccessorSupportLib sFragmentActivityAccessor;
  
  private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor;
  
  static {
    sDialogFragmentAccessor = new DialogFragmentAccessorSupportLib();
    sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment>();
    sFragmentActivityAccessor = new FragmentActivityAccessorSupportLib();
  }
  
  public DialogFragmentAccessorSupportLib forDialogFragment() {
    return sDialogFragmentAccessor;
  }
  
  public FragmentAccessorSupportLib forFragment() {
    return sFragmentAccessor;
  }
  
  public FragmentActivityAccessorSupportLib forFragmentActivity() {
    return sFragmentActivityAccessor;
  }
  
  public FragmentManagerAccessor<FragmentManager, Fragment> forFragmentManager() {
    return sFragmentManagerAccessor;
  }
  
  public Class<DialogFragment> getDialogFragmentClass() {
    return DialogFragment.class;
  }
  
  public Class<FragmentActivity> getFragmentActivityClass() {
    return FragmentActivity.class;
  }
  
  public Class<Fragment> getFragmentClass() {
    return Fragment.class;
  }
  
  static class DialogFragmentAccessorSupportLib extends FragmentAccessorSupportLib implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> {
    private DialogFragmentAccessorSupportLib() {}
    
    public Dialog getDialog(DialogFragment param1DialogFragment) {
      return param1DialogFragment.getDialog();
    }
  }
  
  static class FragmentAccessorSupportLib implements FragmentAccessor<Fragment, FragmentManager> {
    private FragmentAccessorSupportLib() {}
    
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment param1Fragment) {
      return param1Fragment.getChildFragmentManager();
    }
    
    @Nullable
    public FragmentManager getFragmentManager(Fragment param1Fragment) {
      return param1Fragment.getFragmentManager();
    }
    
    public int getId(Fragment param1Fragment) {
      return param1Fragment.getId();
    }
    
    public Resources getResources(Fragment param1Fragment) {
      return param1Fragment.getResources();
    }
    
    @Nullable
    public String getTag(Fragment param1Fragment) {
      return param1Fragment.getTag();
    }
    
    @Nullable
    public View getView(Fragment param1Fragment) {
      return param1Fragment.getView();
    }
  }
  
  static class FragmentActivityAccessorSupportLib implements FragmentActivityAccessor<FragmentActivity, FragmentManager> {
    private FragmentActivityAccessorSupportLib() {}
    
    @Nullable
    public FragmentManager getFragmentManager(FragmentActivity param1FragmentActivity) {
      return param1FragmentActivity.getSupportFragmentManager();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\FragmentCompatSupportLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */