package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PageTimeUtils;
import java.lang.reflect.Field;

public class BaseDialogFragment extends DialogFragment implements DialogInterface.OnKeyListener, BaseFragmentActivity.IOnBackPressedListener, PageTimeUtils.APMInterface {
  private ActivityFragmentActive a = new ActivityFragmentActive(getLifecycle());
  
  private DialogInterface.OnDismissListener b;
  
  public boolean V_() {
    try {
      dismissAllowingStateLoss();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return false;
  }
  
  public String X_() {
    return null;
  }
  
  public ActivityFragmentActive a() {
    ActivityFragmentActive activityFragmentActive2 = this.a;
    ActivityFragmentActive activityFragmentActive1 = activityFragmentActive2;
    if (activityFragmentActive2 == null) {
      Log.e("BaseDialogFragment", "current fragmentActive is null, but someone want to use it");
      activityFragmentActive1 = ActivityFragmentActive.a;
    } 
    return activityFragmentActive1;
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener) {
    this.b = paramOnDismissListener;
  }
  
  public boolean a(Runnable paramRunnable) {
    return UIRunnableManager.a(this.a, paramRunnable, 0L);
  }
  
  public boolean a(Runnable paramRunnable, long paramLong) {
    return UIRunnableManager.a(this.a, paramRunnable, paramLong);
  }
  
  public String d() {
    return getClass().getSimpleName();
  }
  
  public boolean e() {
    return false;
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    ImageLoaderHostManager.a(this.a, this);
    if (paramActivity instanceof BaseFragmentActivity)
      ((BaseFragmentActivity)paramActivity).a(false); 
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    ImageLoaderHostManager.a(this.a, this);
    if (paramContext instanceof BaseFragmentActivity)
      ((BaseFragmentActivity)paramContext).a(false); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onCreateView()");
    Log.a("BaseDialogFragment", stringBuilder.toString());
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onDestroy()");
    Log.a("BaseDialogFragment", stringBuilder.toString());
    ActivityFragmentActive activityFragmentActive = this.a;
    if (activityFragmentActive != null) {
      HttpManager.a(activityFragmentActive);
      ImageLoaderHostManager.b(this.a);
      this.a.a();
      this.a = null;
    } 
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onDestroyView()");
    Log.a("BaseDialogFragment", stringBuilder.toString());
    ActivityFragmentActive activityFragmentActive = this.a;
    if (activityFragmentActive != null)
      UIRunnableManager.a(activityFragmentActive); 
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    super.onDismiss(paramDialogInterface);
    DialogInterface.OnDismissListener onDismissListener = this.b;
    if (onDismissListener != null)
      onDismissListener.onDismiss(paramDialogInterface); 
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      V_();
      return true;
    } 
    return false;
  }
  
  public void onPause() {
    super.onPause();
    if (AppInfo.b() != null)
      AppInfo.b().b(d()); 
  }
  
  public void onResume() {
    super.onResume();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onResume()");
    Log.a("BaseDialogFragment", stringBuilder.toString());
    RecyclingImageLoader.c();
    if (AppInfo.b() != null)
      AppInfo.b().a(d()); 
  }
  
  public void onStart() {
    super.onStart();
    if (!e())
      PageTimeUtils.a(this); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onStart()");
    Log.a("BaseDialogFragment", stringBuilder.toString());
  }
  
  public void onStop() {
    super.onStop();
    if (!e())
      PageTimeUtils.b(this); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onStop()");
    Log.a("BaseDialogFragment", stringBuilder.toString());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    if (getDialog() != null)
      getDialog().setOnKeyListener(this); 
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" setUserVisibleHint(), isVisibleToUser:");
    stringBuilder.append(paramBoolean);
    Log.a("BaseDialogFragment", stringBuilder.toString());
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    try {
      Field field = DialogFragment.class.getDeclaredField("mDismissed");
      field.setAccessible(true);
      field.set(this, Boolean.valueOf(false));
      field = DialogFragment.class.getDeclaredField("mShownByMe");
      field.setAccessible(true);
      field.set(this, Boolean.valueOf(true));
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
    } 
    FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
    fragmentTransaction.add((Fragment)this, paramString);
    fragmentTransaction.commitAllowingStateLoss();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\BaseDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */