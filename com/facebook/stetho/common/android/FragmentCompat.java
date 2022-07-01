package com.facebook.stetho.common.android;

import android.app.Activity;
import android.os.Build;
import com.facebook.stetho.common.ReflectionUtil;
import java.lang.reflect.Field;
import java.util.List;
import javax.annotation.Nullable;

public abstract class FragmentCompat<FRAGMENT, DIALOG_FRAGMENT, FRAGMENT_MANAGER, FRAGMENT_ACTIVITY extends Activity> {
  private static FragmentCompat sFrameworkInstance;
  
  private static final boolean sHasSupportFragment;
  
  private static FragmentCompat sSupportInstance;
  
  static {
    boolean bool;
    if (ReflectionUtil.tryGetClassForName("androidx.fragment.app.Fragment") != null) {
      bool = true;
    } else {
      bool = false;
    } 
    sHasSupportFragment = bool;
  }
  
  @Nullable
  public static FragmentCompat getFrameworkInstance() {
    if (sFrameworkInstance == null && Build.VERSION.SDK_INT >= 11)
      sFrameworkInstance = new FragmentCompatFramework(); 
    return sFrameworkInstance;
  }
  
  @Nullable
  public static FragmentCompat getSupportLibInstance() {
    if (sSupportInstance == null && sHasSupportFragment)
      sSupportInstance = new FragmentCompatSupportLib(); 
    return sSupportInstance;
  }
  
  public abstract DialogFragmentAccessor<DIALOG_FRAGMENT, FRAGMENT, FRAGMENT_MANAGER> forDialogFragment();
  
  public abstract FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER> forFragment();
  
  public abstract FragmentActivityAccessor<FRAGMENT_ACTIVITY, FRAGMENT_MANAGER> forFragmentActivity();
  
  public abstract FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT> forFragmentManager();
  
  public abstract Class<DIALOG_FRAGMENT> getDialogFragmentClass();
  
  public abstract Class<FRAGMENT_ACTIVITY> getFragmentActivityClass();
  
  public abstract Class<FRAGMENT> getFragmentClass();
  
  static class FragmentManagerAccessorViaReflection<FRAGMENT_MANAGER, FRAGMENT> implements FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT> {
    @Nullable
    private Field mFieldMAdded;
    
    @Nullable
    public List<FRAGMENT> getAddedFragments(FRAGMENT_MANAGER param1FRAGMENT_MANAGER) {
      if (this.mFieldMAdded == null) {
        Field field1 = ReflectionUtil.tryGetDeclaredField(param1FRAGMENT_MANAGER.getClass(), "mAdded");
        if (field1 != null) {
          field1.setAccessible(true);
          this.mFieldMAdded = field1;
        } 
      } 
      Field field = this.mFieldMAdded;
      return (field != null) ? (List<FRAGMENT>)ReflectionUtil.getFieldValue(field, param1FRAGMENT_MANAGER) : null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\FragmentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */