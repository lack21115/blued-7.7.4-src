package com.facebook.stetho.common.android;

import android.app.Activity;
import android.view.View;
import javax.annotation.Nullable;

public final class FragmentCompatUtil {
  @Nullable
  public static Object findFragmentForView(View paramView) {
    Activity activity = ViewUtil.tryGetActivity(paramView);
    return (activity == null) ? null : findFragmentForViewInActivity(activity, paramView);
  }
  
  @Nullable
  private static Object findFragmentForViewInActivity(Activity paramActivity, View paramView) {
    FragmentCompat fragmentCompat = FragmentCompat.getSupportLibInstance();
    if (fragmentCompat != null && fragmentCompat.getFragmentActivityClass().isInstance(paramActivity)) {
      Object object = findFragmentForViewInActivity(fragmentCompat, paramActivity, paramView);
      if (object != null)
        return object; 
    } 
    fragmentCompat = FragmentCompat.getFrameworkInstance();
    if (fragmentCompat != null) {
      Object object = findFragmentForViewInActivity(fragmentCompat, paramActivity, paramView);
      if (object != null)
        return object; 
    } 
    return null;
  }
  
  private static Object findFragmentForViewInActivity(FragmentCompat paramFragmentCompat, Activity paramActivity, View paramView) {
    paramActivity = paramFragmentCompat.forFragmentActivity().getFragmentManager(paramActivity);
    return (paramActivity != null) ? findFragmentForViewInFragmentManager(paramFragmentCompat, paramActivity, paramView) : null;
  }
  
  @Nullable
  private static Object findFragmentForViewInFragment(FragmentCompat paramFragmentCompat, Object paramObject, View paramView) {
    FragmentAccessor fragmentAccessor = paramFragmentCompat.forFragment();
    if (fragmentAccessor.getView(paramObject) == paramView)
      return paramObject; 
    paramObject = fragmentAccessor.getChildFragmentManager(paramObject);
    return (paramObject != null) ? findFragmentForViewInFragmentManager(paramFragmentCompat, paramObject, paramView) : null;
  }
  
  @Nullable
  private static Object findFragmentForViewInFragmentManager(FragmentCompat paramFragmentCompat, Object paramObject, View paramView) {
    paramObject = paramFragmentCompat.forFragmentManager().getAddedFragments(paramObject);
    if (paramObject != null) {
      int i = 0;
      int j = paramObject.size();
      while (i < j) {
        Object object = findFragmentForViewInFragment(paramFragmentCompat, paramObject.get(i), paramView);
        if (object != null)
          return object; 
        i++;
      } 
    } 
    return null;
  }
  
  public static boolean isDialogFragment(Object paramObject) {
    FragmentCompat fragmentCompat = FragmentCompat.getSupportLibInstance();
    if (fragmentCompat != null && fragmentCompat.getDialogFragmentClass().isInstance(paramObject))
      return true; 
    fragmentCompat = FragmentCompat.getFrameworkInstance();
    return (fragmentCompat != null && fragmentCompat.getDialogFragmentClass().isInstance(paramObject));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\android\FragmentCompatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */