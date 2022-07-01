package com.blued.android.core.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.core.utils.skin.BluedSkinPreferences;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener;

public class AppLifecycleCallbacks implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
  private static String b = "";
  
  private static boolean c = false;
  
  private static boolean d = false;
  
  private Activity a;
  
  public AppLifecycleCallbacks(Application paramApplication) {
    paramApplication.registerActivityLifecycleCallbacks(this);
    ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
  }
  
  private void a(Activity paramActivity) {
    if (paramActivity == null)
      return; 
    if (!BluedSkinUtils.a())
      return; 
    Log.e("AppLifecycleCallbacks", "changeSkin ... ");
    if (Build.VERSION.SDK_INT < 29)
      return; 
    if (!BluedSkinPreferences.a())
      return; 
    boolean bool = BluedSkinUtils.a(paramActivity);
    if (BluedSkinPreferences.b() == bool)
      return; 
    BluedSkinPreferences.b(bool);
    if (bool) {
      b(paramActivity);
      return;
    } 
    BluedSkinUtils.b();
  }
  
  public static void a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      b = paramString;
      c = false;
    } 
  }
  
  private void b(Activity paramActivity) {
    BluedSkinUtils.a("night.skin", new BluedSkinLoaderListener(this, paramActivity) {
          public void a() {}
          
          public void a(String param1String) {}
          
          public void b() {
            StatusBarHelper.a(this.a);
          }
        });
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {
    ActivityStack.a().a(paramActivity);
    a(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {
    ActivityStack.a().b(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {
    RecyclingImageLoader.c();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onActivityStarted:");
    stringBuilder.append(paramActivity.getClass().getName());
    Log.e("AppLifecycleCallbacks", stringBuilder.toString());
    this.a = paramActivity;
    if (!paramActivity.getClass().getName().equals(b) && !c) {
      c = true;
      onAppStart();
      return;
    } 
    onAppStart();
  }
  
  public void onActivityStopped(Activity paramActivity) {
    int i = UiUtils.a((Context)paramActivity) ^ true;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onActivityStopped appOnBackground = ");
    stringBuilder.append(i);
    Log.e("AppLifecycleCallbacks", stringBuilder.toString());
    if (i != 0)
      onAppStop(); 
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  public void onAppStart() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("-- onAppStart : ");
    stringBuilder.append(d);
    Log.e("AppLifecycleCallbacks", stringBuilder.toString());
    Activity activity = this.a;
    if (activity != null && activity.getClass().getName().equals(b))
      return; 
    if (!d) {
      d = true;
      Log.e("AppLifecycleCallbacks", "-- setAppInForeground");
      AppInfo.a(this.a);
    } 
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public void onAppStop() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("-- onAppStop : ");
    stringBuilder.append(d);
    Log.e("AppLifecycleCallbacks", stringBuilder.toString());
    if (d) {
      d = false;
      Log.e("AppLifecycleCallbacks", "-- setAppInBackground");
      AppInfo.h();
    } 
    this.a = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\AppLifecycleCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */