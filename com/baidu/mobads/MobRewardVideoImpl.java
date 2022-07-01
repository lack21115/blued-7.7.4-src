package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.mobads.f.b;
import com.baidu.mobads.f.g;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXRewardVideoAdContainer;
import com.baidu.mobads.production.rewardvideo.MobRewardVideoActivity;
import com.baidu.mobads.utils.q;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;

public class MobRewardVideoImpl {
  public static String activityName;
  
  private static Class<?> b;
  
  public static IXRewardVideoAdContainer mAdContainer;
  
  public static IXAdContainerContext mContext;
  
  public static boolean mVideoPlaying;
  
  private Activity a;
  
  private Object c;
  
  private Method[] d = null;
  
  public MobRewardVideoImpl(Activity paramActivity) {
    this.a = paramActivity;
  }
  
  private Class<?> a(String paramString) {
    q q = q.a();
    ClassLoader classLoader = getClass().getClassLoader();
    Exception exception2 = null;
    try {
      Class<?> clazz = Class.forName(paramString, true, (ClassLoader)new DexClassLoader(g.a((Context)this.a), this.a.getFilesDir().getAbsolutePath(), null, classLoader));
    } catch (Exception exception1) {
      q.e(exception1);
      exception1 = exception2;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("jar.path=, clz=");
    stringBuilder.append(exception1);
    q.i(stringBuilder.toString());
    return (Class<?>)exception1;
  }
  
  private void a(Bundle paramBundle) {
    DexClassLoader dexClassLoader = b.d();
    if (dexClassLoader == null) {
      try {
        b = a("com.baidu.mobads.container.rewardvideo.RemoteRewardActivity");
        this.d = b.getDeclaredMethods();
        this.c = b.getConstructor(new Class[] { Activity.class, IXAdContainerContext.class, IXRewardVideoAdContainer.class }).newInstance(new Object[] { this.a, mContext, mAdContainer });
      } catch (Exception exception) {}
    } else {
      b = Class.forName("com.baidu.mobads.container.rewardvideo.RemoteRewardActivity", true, (ClassLoader)exception);
      this.d = b.getDeclaredMethods();
      this.c = b.getConstructor(new Class[] { Activity.class, IXAdContainerContext.class, IXRewardVideoAdContainer.class }).newInstance(new Object[] { this.a, mContext, mAdContainer });
    } 
    a("onCreate", new Object[] { paramBundle });
  }
  
  private void a(String paramString, Object... paramVarArgs) {
    try {
      boolean bool;
      q q = q.a();
      if (paramVarArgs != null) {
        bool = paramVarArgs.length;
      } else {
        bool = false;
      } 
      q.d(new Object[] { paramString, Integer.valueOf(bool), paramVarArgs });
      Method method = b(paramString);
      if (method != null) {
        if (paramVarArgs == null || paramVarArgs.length == 0) {
          method.invoke(this.c, new Object[0]);
          return;
        } 
        method.invoke(this.c, paramVarArgs);
        return;
      } 
    } catch (Exception exception) {
      q.a().d(exception);
    } 
  }
  
  private Method b(String paramString) {
    Method[] arrayOfMethod = this.d;
    if (arrayOfMethod == null)
      return null; 
    int j = arrayOfMethod.length;
    for (int i = 0; i < j; i++) {
      Method method = arrayOfMethod[i];
      if (method.getName().equals(paramString)) {
        method.setAccessible(true);
        return method;
      } 
    } 
    return null;
  }
  
  private boolean b(String paramString, Object... paramVarArgs) {
    try {
      boolean bool;
      q q = q.a();
      if (paramVarArgs != null) {
        bool = paramVarArgs.length;
      } else {
        bool = false;
      } 
      q.d(new Object[] { paramString, Integer.valueOf(bool), paramVarArgs });
      Method method = b(paramString);
      if (method != null)
        return (paramVarArgs == null || paramVarArgs.length == 0) ? ((Boolean)method.invoke(this.c, new Object[0])).booleanValue() : ((Boolean)method.invoke(this.c, paramVarArgs)).booleanValue(); 
    } catch (Exception exception) {
      q.a().d(exception);
    } 
    return false;
  }
  
  public static Class<?> getActivityClass() {
    if (!TextUtils.isEmpty(activityName))
      try {
        return Class.forName(activityName);
      } catch (Exception exception) {
        q.a().e(exception);
      }  
    return MobRewardVideoActivity.class;
  }
  
  public static void setActivityName(String paramString) {
    activityName = paramString;
  }
  
  public void finish() {
    a("finish", new Object[0]);
  }
  
  public void onAttachedToWindow() {
    a("onAttachedToWindow", new Object[0]);
  }
  
  public boolean onBackPressed() {
    return b("onBackPressed", new Object[0]);
  }
  
  public void onCreate(Bundle paramBundle) {
    mVideoPlaying = true;
    IXAdContainerContext iXAdContainerContext = mContext;
    if (iXAdContainerContext != null && iXAdContainerContext.getAdInstanceInfo() != null)
      mContext.getAdInstanceInfo().setAdHasDisplayed(true); 
    a(paramBundle);
  }
  
  public void onDestroy() {
    mVideoPlaying = false;
    a("onDestroy", new Object[0]);
  }
  
  public void onDetachedFromWindow() {
    mVideoPlaying = false;
    a("onDetachedFromWindow", new Object[0]);
  }
  
  public void onPause() {
    a("onPause", new Object[0]);
  }
  
  public void onResume() {
    a("onResume", new Object[0]);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return b("onTouchEvent", new Object[] { paramMotionEvent });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    a("onWindowFocusChanged", new Object[] { Boolean.valueOf(paramBoolean) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\MobRewardVideoImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */