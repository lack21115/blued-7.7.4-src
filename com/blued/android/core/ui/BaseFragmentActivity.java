package com.blued.android.core.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.core.utils.swipeback.SwipeBackActivityHelper;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Page;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import skin.support.SkinCompatManager;
import skin.support.content.res.SkinCompatResources;

public class BaseFragmentActivity extends AppCompatActivity implements PageTimeUtils.APMInterface, BluedSkinSupportable {
  public static String a = "";
  
  public String b;
  
  private SwipeBackActivityHelper c;
  
  private ActivityFragmentActive d = new ActivityFragmentActive(getLifecycle());
  
  private IOnBackPressedListener e = null;
  
  private IOnKeyListener f = null;
  
  private boolean h() {
    boolean bool = false;
    try {
      TypedArray typedArray = obtainStyledAttributes((int[])Class.forName("com.android.internal.R$styleable").getField("Window").get((Object)null));
      Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[] { TypedArray.class });
      method.setAccessible(true);
      boolean bool1 = ((Boolean)method.invoke((Object)null, new Object[] { typedArray })).booleanValue();
      try {
        method.setAccessible(false);
        return bool1;
      } catch (Exception null) {
        bool = bool1;
      } 
    } catch (Exception exception) {}
    exception.printStackTrace();
    return bool;
  }
  
  private boolean i() {
    try {
      Field field = Activity.class.getDeclaredField("mActivityInfo");
      field.setAccessible(true);
      ((ActivityInfo)field.get(this)).screenOrientation = -1;
      field.setAccessible(false);
      return true;
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  private void j() {
    if (TextUtils.isEmpty(this.b))
      if (TextUtils.isEmpty(BaseActivity.a)) {
        this.b = k();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BaseActivity.a);
        stringBuilder.append(",");
        stringBuilder.append(k());
        this.b = stringBuilder.toString();
      }  
    BaseActivity.a = this.b;
    Page page = BluedStatistics.d();
    String str1 = c();
    String str2 = Integer.toHexString(hashCode());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[");
    stringBuilder2.append(this.b);
    stringBuilder2.append("]");
    page.a(str1, str2, stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("curPageRouterName: ");
    stringBuilder1.append(this.b);
    Log.a("BaseFragmentActivity", stringBuilder1.toString());
  }
  
  private String k() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[\"");
    stringBuilder.append(c());
    stringBuilder.append("\",");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private String l() {
    return getClass().getSimpleName();
  }
  
  public String X_() {
    return null;
  }
  
  public ActivityFragmentActive a() {
    ActivityFragmentActive activityFragmentActive2 = this.d;
    ActivityFragmentActive activityFragmentActive1 = activityFragmentActive2;
    if (activityFragmentActive2 == null) {
      Log.e("BaseFragmentActivity", "current activityActive is null, but someone want to use it");
      activityFragmentActive1 = ActivityFragmentActive.a;
    } 
    return activityFragmentActive1;
  }
  
  public void a(IOnBackPressedListener paramIOnBackPressedListener) {
    this.e = paramIOnBackPressedListener;
  }
  
  public void a(IOnKeyListener paramIOnKeyListener) {
    this.f = paramIOnKeyListener;
  }
  
  public void a(boolean paramBoolean) {
    if (this.c != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getClass().getName());
      stringBuilder.append(" setSwipeBackEnable(");
      stringBuilder.append(paramBoolean);
      stringBuilder.append(")");
      Log.c("BaseFragmentActivity", stringBuilder.toString());
      this.c.a(paramBoolean);
    } 
  }
  
  public void attachBaseContext(Context paramContext) {
    if (AppInfo.b() != null) {
      super.attachBaseContext(AppInfo.b().a(paramContext));
      return;
    } 
    super.attachBaseContext(paramContext);
  }
  
  protected String c() {
    return PageTimeUtils.a(this, l());
  }
  
  public IOnBackPressedListener d() {
    return this.e;
  }
  
  public IOnKeyListener e() {
    return this.f;
  }
  
  public boolean f() {
    return false;
  }
  
  public <T extends View> T findViewById(int paramInt) {
    View view = super.findViewById(paramInt);
    if (view == null) {
      SwipeBackActivityHelper swipeBackActivityHelper = this.c;
      if (swipeBackActivityHelper != null)
        return (T)swipeBackActivityHelper.a(paramInt); 
    } 
    return (T)view;
  }
  
  public void g() {
    if (SkinCompatManager.a() != null)
      StatusBarHelper.c((Activity)this, SkinCompatResources.a().d()); 
  }
  
  public AppCompatDelegate getDelegate() {
    return SkinAppCompatDelegateImpl.get((Activity)this, (AppCompatCallback)this);
  }
  
  public void onAttachFragment(Fragment paramFragment) {
    super.onAttachFragment(paramFragment);
    a = paramFragment.getClass().getSimpleName();
  }
  
  public void onAttachFragment(Fragment paramFragment) {
    super.onAttachFragment(paramFragment);
    a = paramFragment.getClass().getSimpleName();
  }
  
  public void onBackPressed() {
    IOnBackPressedListener iOnBackPressedListener = this.e;
    if (iOnBackPressedListener != null && iOnBackPressedListener.V_())
      return; 
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle) {
    if (Build.VERSION.SDK_INT == 26 && h()) {
      boolean bool = i();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onCreate fixOrientation when Oreo, result = ");
      stringBuilder1.append(bool);
      Log.c("BaseFragmentActivity", stringBuilder1.toString());
    } 
    super.onCreate(paramBundle);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onCreate()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
    ImageLoaderHostManager.a(this.d, this);
    AppInfo.b((Activity)this);
    this.c = new SwipeBackActivityHelper();
    this.c.a((Activity)this);
    if (!StatusBarHelper.a())
      return; 
    if (SkinCompatManager.a() != null)
      StatusBarHelper.c((Activity)this, BluedSkinUtils.c()); 
  }
  
  public void onDestroy() {
    super.onDestroy();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onDestroy()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
    ActivityFragmentActive activityFragmentActive = this.d;
    if (activityFragmentActive != null) {
      HttpManager.a(activityFragmentActive);
      UIRunnableManager.a(this.d);
      ImageLoaderHostManager.b(this.d);
      this.d.a();
      this.d = null;
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    IOnKeyListener iOnKeyListener = this.f;
    return (iOnKeyListener != null && iOnKeyListener.a(paramInt, paramKeyEvent)) ? true : super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    IOnKeyListener iOnKeyListener = this.f;
    return (iOnKeyListener != null && iOnKeyListener.b(paramInt, paramKeyEvent)) ? true : super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause() {
    super.onPause();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onPause()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
  }
  
  public void onPostCreate(Bundle paramBundle) {
    super.onPostCreate(paramBundle);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onPostCreate()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
    SwipeBackActivityHelper swipeBackActivityHelper = this.c;
    if (swipeBackActivityHelper != null)
      swipeBackActivityHelper.b((Activity)this); 
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    if (AppInfo.b() != null)
      AppInfo.b().a((Context)this, paramInt, paramArrayOfString, paramArrayOfint); 
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle) {
    super.onRestoreInstanceState(paramBundle);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onRestoreInstanceState()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
    if (paramBundle != null)
      this.b = paramBundle.getString("router_name"); 
    if (AppInfo.b() != null)
      AppInfo.b().a((Context)this, paramBundle); 
  }
  
  public void onResume() {
    super.onResume();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onResume()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
    if (getSupportFragmentManager() != null) {
      List list = getSupportFragmentManager().getFragments();
      if (list == null || list.size() == 0) {
        j();
        return;
      } 
      if (TextUtils.isEmpty(this.b)) {
        this.b = BaseActivity.a;
        return;
      } 
    } else {
      j();
    } 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    bundle.putString("router_name", this.b);
    super.onSaveInstanceState(bundle);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onSaveInstanceState()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
    if (AppInfo.b() != null)
      AppInfo.b().a(bundle); 
  }
  
  public void onStart() {
    super.onStart();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onStart()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
    if (!f())
      PageTimeUtils.a(this); 
  }
  
  public void onStop() {
    super.onStop();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onStop()");
    Log.a("BaseFragmentActivity", stringBuilder.toString());
    if (!f())
      PageTimeUtils.b(this); 
  }
  
  public static interface IOnBackPressedListener {
    boolean V_();
  }
  
  public static interface IOnKeyListener {
    boolean a(int param1Int, KeyEvent param1KeyEvent);
    
    boolean b(int param1Int, KeyEvent param1KeyEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\BaseFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */