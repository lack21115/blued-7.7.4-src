package com.android.webview.chromium;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Trace;
import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Method;

final class WebViewDelegateFactory$Api21CompatibilityDelegate implements WebViewDelegateFactory$WebViewDelegate {
  private final Method mAddAssetPathMethod;
  
  private final Method mAddChangeCallbackMethod;
  
  private final Method mCallDrawGLFunctionMethod;
  
  private final Method mCurrentApplicationMethod;
  
  private final Method mDetachFunctorMethod;
  
  private final Method mGetAssignedPackageIdentifiersMethod;
  
  private final Method mGetLoadedPackageInfoMethod;
  
  private final Method mGetStringMethod;
  
  private final Method mGetViewRootImplMethod;
  
  private final Method mInvokeFunctorMethod;
  
  private final Method mIsTagEnabledMethod;
  
  WebViewDelegateFactory$Api21CompatibilityDelegate() {
    try {
      this.mIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", new Class[] { long.class });
      this.mAddChangeCallbackMethod = Class.forName("android.os.SystemProperties").getMethod("addChangeCallback", new Class[] { Runnable.class });
      this.mGetViewRootImplMethod = View.class.getMethod("getViewRootImpl", new Class[0]);
      this.mInvokeFunctorMethod = Class.forName("android.view.ViewRootImpl").getMethod("invokeFunctor", new Class[] { long.class, boolean.class });
      this.mDetachFunctorMethod = Class.forName("android.view.ViewRootImpl").getMethod("detachFunctor", new Class[] { long.class });
      this.mCallDrawGLFunctionMethod = Class.forName("android.view.HardwareCanvas").getMethod("callDrawGLFunction", new Class[] { long.class });
      this.mGetAssignedPackageIdentifiersMethod = AssetManager.class.getMethod("getAssignedPackageIdentifiers", new Class[0]);
      this.mAddAssetPathMethod = AssetManager.class.getMethod("addAssetPath", new Class[] { String.class });
      this.mCurrentApplicationMethod = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
      this.mGetStringMethod = Class.forName("android.net.http.ErrorStrings").getMethod("getString", new Class[] { int.class, Context.class });
      this.mGetLoadedPackageInfoMethod = Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]);
      return;
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final void addWebViewAssetPath(Context paramContext) {
    try {
      PackageInfo packageInfo = (PackageInfo)this.mGetLoadedPackageInfoMethod.invoke(null, new Object[0]);
      this.mAddAssetPathMethod.invoke(paramContext.getResources().getAssets(), new Object[] { packageInfo.applicationInfo.sourceDir });
      return;
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final void callDrawGlFunction(Canvas paramCanvas, long paramLong) {
    try {
      this.mCallDrawGLFunctionMethod.invoke(paramCanvas, new Object[] { Long.valueOf(paramLong) });
      return;
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final void callDrawGlFunction(Canvas paramCanvas, long paramLong, Runnable paramRunnable) {
    throw new RuntimeException("Call not supported");
  }
  
  public final boolean canInvokeDrawGlFunctor(View paramView) {
    try {
      Object object = this.mGetViewRootImplMethod.invoke(paramView, new Object[0]);
      return (object != null);
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final void detachDrawGlFunctor(View paramView, long paramLong) {
    try {
      Object object = this.mGetViewRootImplMethod.invoke(paramView, new Object[0]);
      if (object != null)
        this.mDetachFunctorMethod.invoke(object, new Object[] { Long.valueOf(paramLong) }); 
      return;
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final Application getApplication() {
    try {
      return (Application)this.mCurrentApplicationMethod.invoke(null, new Object[0]);
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final String getDataDirectorySuffix() {
    return null;
  }
  
  public final String getErrorString(Context paramContext, int paramInt) {
    try {
      return (String)this.mGetStringMethod.invoke(null, new Object[] { Integer.valueOf(paramInt), paramContext });
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final int getPackageId(Resources paramResources, String paramString) {
    try {
      Method method = this.mGetAssignedPackageIdentifiersMethod;
      AssetManager assetManager = paramResources.getAssets();
      int i = 0;
      SparseArray sparseArray = (SparseArray)method.invoke(assetManager, new Object[0]);
      while (i < sparseArray.size()) {
        if (paramString.equals(sparseArray.valueAt(i)))
          return sparseArray.keyAt(i); 
        i++;
      } 
      StringBuilder stringBuilder = new StringBuilder("Package not found: ");
      stringBuilder.append(paramString);
      throw new RuntimeException(stringBuilder.toString());
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final void invokeDrawGlFunctor(View paramView, long paramLong, boolean paramBoolean) {
    try {
      Object object = this.mGetViewRootImplMethod.invoke(paramView, new Object[0]);
      if (object != null)
        this.mInvokeFunctorMethod.invoke(object, new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }); 
      return;
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final boolean isMultiProcessEnabled() {
    throw new UnsupportedOperationException();
  }
  
  public final boolean isTraceTagEnabled() {
    try {
      return ((Boolean)this.mIsTagEnabledMethod.invoke(null, new Object[] { Long.valueOf(16L) })).booleanValue();
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
  
  public final void setOnTraceEnabledChangeListener(WebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener paramWebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener) {
    try {
      this.mAddChangeCallbackMethod.invoke(null, new Object[] { new WebViewDelegateFactory$Api21CompatibilityDelegate$1(this, paramWebViewDelegateFactory$WebViewDelegate$OnTraceEnabledChangeListener) });
      return;
    } catch (Exception exception) {
      throw new RuntimeException("Invalid reflection", exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewDelegateFactory$Api21CompatibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */