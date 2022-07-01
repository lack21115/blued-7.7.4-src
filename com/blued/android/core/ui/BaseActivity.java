package com.blued.android.core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoaderHostManager;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PageTimeUtils;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Page;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseActivity extends Activity implements LifecycleOwner, PageTimeUtils.APMInterface {
  public static String a = "";
  
  public String b;
  
  protected Intent c = null;
  
  public LifecycleRegistry d = new LifecycleRegistry(this);
  
  private ActivityFragmentActive e = new ActivityFragmentActive(getLifecycle());
  
  private boolean d() {
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
  
  private boolean e() {
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
  
  private String f() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[\"");
    stringBuilder.append(a());
    stringBuilder.append("\",");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private String g() {
    return getClass().getSimpleName();
  }
  
  public String X_() {
    return null;
  }
  
  protected String a() {
    return PageTimeUtils.a(this, g());
  }
  
  protected void attachBaseContext(Context paramContext) {
    if (AppInfo.b() != null) {
      super.attachBaseContext(AppInfo.b().a(paramContext));
      return;
    } 
    super.attachBaseContext(paramContext);
  }
  
  public boolean c() {
    return false;
  }
  
  public Lifecycle getLifecycle() {
    return (Lifecycle)this.d;
  }
  
  public void onCreate(Bundle paramBundle) {
    if (Build.VERSION.SDK_INT == 26 && d()) {
      boolean bool = e();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onCreate fixOrientation when Oreo, result = ");
      stringBuilder1.append(bool);
      Log.c("BaseActivity", stringBuilder1.toString());
    } 
    super.onCreate(paramBundle);
    this.d.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onCreate()");
    Log.a("BaseActivity", stringBuilder.toString());
    requestWindowFeature(1);
    ImageLoaderHostManager.a(this.e, this);
    AppInfo.b(this);
    this.c = getIntent();
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onCreate()");
    Log.a("BaseActivity", stringBuilder.toString());
    ActivityFragmentActive activityFragmentActive = this.e;
    if (activityFragmentActive != null) {
      HttpManager.a(activityFragmentActive);
      UIRunnableManager.a(this.e);
      ImageLoaderHostManager.b(this.e);
      this.e.a();
      this.e = null;
    } 
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onNewIntent()");
    Log.a("BaseActivity", stringBuilder.toString());
    this.c = paramIntent;
  }
  
  public void onPause() {
    super.onPause();
    this.d.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
  }
  
  protected void onPostCreate(Bundle paramBundle) {
    super.onPostCreate(paramBundle);
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
    Log.a("BaseActivity", stringBuilder.toString());
    if (paramBundle != null)
      this.b = paramBundle.getString("router_name"); 
    if (AppInfo.b() != null)
      AppInfo.b().a((Context)this, paramBundle); 
  }
  
  public void onResume() {
    super.onResume();
    this.d.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    if (TextUtils.isEmpty(this.b))
      if (TextUtils.isEmpty(a)) {
        this.b = f();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(",");
        stringBuilder.append(f());
        this.b = stringBuilder.toString();
      }  
    a = this.b;
    Page page = BluedStatistics.d();
    String str1 = a();
    String str2 = Integer.toHexString(hashCode());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("[");
    stringBuilder2.append(this.b);
    stringBuilder2.append("]");
    page.a(str1, str2, stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("curPageRouterName: ");
    stringBuilder1.append(this.b);
    Log.a("BaseActivity", stringBuilder1.toString());
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    bundle.putString("router_name", this.b);
    super.onSaveInstanceState(bundle);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onSaveInstanceState()");
    Log.a("BaseActivity", stringBuilder.toString());
    if (AppInfo.b() != null)
      AppInfo.b().a(bundle); 
  }
  
  protected void onStart() {
    super.onStart();
    this.d.handleLifecycleEvent(Lifecycle.Event.ON_START);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onStart()");
    Log.a("BaseActivity", stringBuilder.toString());
    if (!c())
      PageTimeUtils.a(this); 
  }
  
  protected void onStop() {
    super.onStop();
    this.d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" onStop()");
    Log.a("BaseActivity", stringBuilder.toString());
    if (!c())
      PageTimeUtils.b(this); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */