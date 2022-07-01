package com.facebook.stetho.common.android;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import javax.annotation.Nullable;

final class FragmentCompatFramework extends FragmentCompat<Fragment, DialogFragment, FragmentManager, Activity> {
  private static final DialogFragmentAccessorFramework sDialogFragmentAccessor;
  
  private static final FragmentAccessorFrameworkHoneycomb sFragmentAccessor;
  
  private static final FragmentActivityAccessorFramework sFragmentActivityAccessor;
  
  private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment>();
  
  static {
    sFragmentActivityAccessor = new FragmentActivityAccessorFramework();
    if (Build.VERSION.SDK_INT >= 17) {
      sFragmentAccessor = new FragmentAccessorFrameworkJellyBean();
    } else {
      sFragmentAccessor = new FragmentAccessorFrameworkHoneycomb();
    } 
    sDialogFragmentAccessor = new DialogFragmentAccessorFramework(sFragmentAccessor);
  }
  
  public DialogFragmentAccessorFramework forDialogFragment() {
    return sDialogFragmentAccessor;
  }
  
  public FragmentAccessorFrameworkHoneycomb forFragment() {
    return sFragmentAccessor;
  }
  
  public FragmentActivityAccessorFramework forFragmentActivity() {
    return sFragmentActivityAccessor;
  }
  
  public FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> forFragmentManager() {
    return sFragmentManagerAccessor;
  }
  
  public Class<DialogFragment> getDialogFragmentClass() {
    return DialogFragment.class;
  }
  
  public Class<Activity> getFragmentActivityClass() {
    return Activity.class;
  }
  
  public Class<Fragment> getFragmentClass() {
    return Fragment.class;
  }
  
  static class DialogFragmentAccessorFramework implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager> {
    private final FragmentAccessor<Fragment, FragmentManager> mFragmentAccessor;
    
    public DialogFragmentAccessorFramework(FragmentAccessor<Fragment, FragmentManager> param1FragmentAccessor) {
      this.mFragmentAccessor = param1FragmentAccessor;
    }
    
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment param1Fragment) {
      return this.mFragmentAccessor.getChildFragmentManager(param1Fragment);
    }
    
    public Dialog getDialog(DialogFragment param1DialogFragment) {
      return param1DialogFragment.getDialog();
    }
    
    @Nullable
    public FragmentManager getFragmentManager(Fragment param1Fragment) {
      return this.mFragmentAccessor.getFragmentManager(param1Fragment);
    }
    
    public int getId(Fragment param1Fragment) {
      return this.mFragmentAccessor.getId(param1Fragment);
    }
    
    public Resources getResources(Fragment param1Fragment) {
      return this.mFragmentAccessor.getResources(param1Fragment);
    }
    
    @Nullable
    public String getTag(Fragment param1Fragment) {
      return this.mFragmentAccessor.getTag(param1Fragment);
    }
    
    @Nullable
    public View getView(Fragment param1Fragment) {
      return this.mFragmentAccessor.getView(param1Fragment);
    }
  }
  
  static class FragmentAccessorFrameworkHoneycomb implements FragmentAccessor<Fragment, FragmentManager> {
    private FragmentAccessorFrameworkHoneycomb() {}
    
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment param1Fragment) {
      return null;
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
  
  static class FragmentAccessorFrameworkJellyBean extends FragmentAccessorFrameworkHoneycomb {
    private FragmentAccessorFrameworkJellyBean() {}
    
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment param1Fragment) {
      return param1Fragment.getChildFragmentManager();
    }
  }
  
  static class FragmentActivityAccessorFramework implements FragmentActivityAccessor<Activity, FragmentManager> {
    private FragmentActivityAccessorFramework() {}
    
    @Nullable
    public FragmentManager getFragmentManager(Activity param1Activity) {
      return param1Activity.getFragmentManager();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\FragmentCompatFramework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */