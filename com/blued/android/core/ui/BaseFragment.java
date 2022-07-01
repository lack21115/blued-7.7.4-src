package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Page;

public class BaseFragment extends Fragment implements BaseFragmentActivity.IOnBackPressedListener, BaseFragmentActivity.IOnKeyListener, PageTimeUtils.APMInterface {
  public String a;
  
  protected boolean b;
  
  protected boolean c = false;
  
  private ActivityFragmentActive d = new ActivityFragmentActive(getLifecycle());
  
  private boolean e = false;
  
  private String n() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[\"");
    stringBuilder.append(aW_());
    stringBuilder.append("\",");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public boolean V_() {
    return false;
  }
  
  public boolean W_() {
    return false;
  }
  
  public String X_() {
    return null;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    return false;
  }
  
  public boolean a(Runnable paramRunnable) {
    return UIRunnableManager.a(this.d, paramRunnable, 0L);
  }
  
  public boolean a(Runnable paramRunnable, long paramLong) {
    return UIRunnableManager.a(this.d, paramRunnable, paramLong);
  }
  
  public String aG_() {
    return getClass().getSimpleName();
  }
  
  protected String aW_() {
    return PageTimeUtils.a(this, aG_());
  }
  
  public boolean b(int paramInt, KeyEvent paramKeyEvent) {
    return false;
  }
  
  protected void f() {
    if (!x_())
      return; 
    try {
      Fragment fragment = getParentFragment();
      if (fragment != null) {
        fragment = getParentFragment();
        if (TextUtils.isEmpty(((BaseFragment)fragment).a)) {
          this.a = n();
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(((BaseFragment)fragment).a);
          stringBuilder.append(",");
          stringBuilder.append(n());
          this.a = stringBuilder.toString();
        } 
      } else {
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity)getActivity();
        if (UiUtils.a((Activity)baseFragmentActivity))
          if (TextUtils.isEmpty(baseFragmentActivity.b)) {
            this.a = n();
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(baseFragmentActivity.b);
            stringBuilder.append(",");
            stringBuilder.append(n());
            this.a = stringBuilder.toString();
          }  
      } 
      BaseActivity.a = this.a;
      Page page = BluedStatistics.d();
      String str1 = aW_();
      String str2 = Integer.toHexString(hashCode());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("[");
      stringBuilder2.append(this.a);
      stringBuilder2.append("]");
      page.a(str1, str2, stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("curPageRouterName: ");
      stringBuilder1.append(this.a);
      Log.a("BaseFragment", stringBuilder1.toString());
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public boolean j() {
    return true;
  }
  
  public void onAttach(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onAttach()");
    Log.a("BaseFragment", stringBuilder.toString());
    super.onAttach(paramActivity);
    if (this.d == null)
      this.d = new ActivityFragmentActive(getLifecycle()); 
    ImageLoaderHostManager.a(this.d, this);
    if (paramActivity instanceof BaseFragmentActivity) {
      BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity)paramActivity;
      baseFragmentActivity.a(this);
      baseFragmentActivity.a(this);
      baseFragmentActivity.a(j());
    } 
  }
  
  public void onAttach(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onAttach()");
    Log.a("BaseFragment", stringBuilder.toString());
    super.onAttach(paramContext);
    if (this.d == null)
      this.d = new ActivityFragmentActive(getLifecycle()); 
    ImageLoaderHostManager.a(this.d, this);
    if (paramContext instanceof BaseFragmentActivity) {
      BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity)paramContext;
      baseFragmentActivity.a(this);
      baseFragmentActivity.a(this);
      baseFragmentActivity.a(j());
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.e = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onCreateView()");
    Log.a("BaseFragment", stringBuilder.toString());
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onDestroy()");
    Log.a("BaseFragment", stringBuilder.toString());
    ActivityFragmentActive activityFragmentActive = this.d;
    if (activityFragmentActive != null) {
      HttpManager.a(activityFragmentActive);
      ImageLoaderHostManager.b(this.d);
      this.d.a();
      this.d = null;
    } 
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onDestroyView()");
    Log.a("BaseFragment", stringBuilder.toString());
    ActivityFragmentActive activityFragmentActive = this.d;
    if (activityFragmentActive != null)
      UIRunnableManager.a(activityFragmentActive); 
  }
  
  public void onDetach() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onDetach()");
    Log.a("BaseFragment", stringBuilder.toString());
    FragmentActivity fragmentActivity = getActivity();
    if (fragmentActivity instanceof BaseFragmentActivity) {
      BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity)fragmentActivity;
      if (this == baseFragmentActivity.d())
        baseFragmentActivity.a((BaseFragmentActivity.IOnBackPressedListener)null); 
      if (this == baseFragmentActivity.e())
        baseFragmentActivity.a((BaseFragmentActivity.IOnKeyListener)null); 
    } 
    super.onDetach();
  }
  
  public void onPause() {
    super.onPause();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onPause()");
    Log.a("BaseFragment", stringBuilder.toString());
    if (AppInfo.b() != null)
      AppInfo.b().b(aG_()); 
  }
  
  public void onResume() {
    super.onResume();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onResume()");
    Log.a("BaseFragment", stringBuilder.toString());
    RecyclingImageLoader.c();
    if (AppInfo.b() != null)
      AppInfo.b().a(aG_()); 
    if (!this.b) {
      f();
      return;
    } 
    if (this.c)
      f(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putString("router_name", this.a);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart() {
    super.onStart();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onStart()");
    Log.a("BaseFragment", stringBuilder.toString());
    if (getUserVisibleHint() && !W_())
      PageTimeUtils.a(this); 
  }
  
  public void onStop() {
    super.onStop();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onStop()");
    Log.a("BaseFragment", stringBuilder.toString());
    if (!W_())
      PageTimeUtils.b(this); 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void onViewStateRestored(Bundle paramBundle) {
    if (paramBundle != null)
      this.a = paramBundle.getString("router_name"); 
    super.onViewStateRestored(paramBundle);
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.b = true;
    this.c = paramBoolean;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" setUserVisibleHint(), isVisibleToUser:");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(", isCreated:");
    stringBuilder.append(this.e);
    Log.a("BaseFragment", stringBuilder.toString());
    if (!this.e)
      return; 
    if (paramBoolean)
      f(); 
    if (!W_()) {
      if (paramBoolean) {
        PageTimeUtils.a(this);
        return;
      } 
      PageTimeUtils.b(this);
    } 
  }
  
  public ActivityFragmentActive w_() {
    ActivityFragmentActive activityFragmentActive2 = this.d;
    ActivityFragmentActive activityFragmentActive1 = activityFragmentActive2;
    if (activityFragmentActive2 == null) {
      Log.e("BaseFragment", "current fragmentActive is null, but someone want to use it");
      activityFragmentActive1 = ActivityFragmentActive.a;
    } 
    return activityFragmentActive1;
  }
  
  protected boolean x_() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */