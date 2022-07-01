package org.chromium.android_webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;
import java.util.ArrayList;
import org.chromium.base.Log;

@TargetApi(26)
public final class AwAutofillManager {
  static boolean sIsLoggable;
  
  AutofillManager mAutofillManager;
  
  boolean mDestroyed;
  
  boolean mDisabled;
  
  ArrayList mInputUIObservers;
  
  boolean mIsAutofillInputUIShowing;
  
  AwAutofillManager$AutofillInputUIMonitor mMonitor;
  
  public AwAutofillManager(Context paramContext) {
    boolean bool;
    updateLogStat();
    if (sIsLoggable)
      log("constructor"); 
    this.mAutofillManager = (AutofillManager)paramContext.getSystemService(AutofillManager.class);
    if (this.mAutofillManager == null || !this.mAutofillManager.isEnabled()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mDisabled = bool;
    if (this.mDisabled) {
      if (sIsLoggable)
        log("disabled"); 
      return;
    } 
    this.mMonitor = new AwAutofillManager$AutofillInputUIMonitor(this);
    this.mAutofillManager.registerCallback(this.mMonitor);
  }
  
  public static void log(String paramString) {
    Log.i("AwAutofillManager", paramString, new Object[0]);
  }
  
  static void updateLogStat() {
    sIsLoggable = Log.isLoggable("AwAutofillManager", 3);
  }
  
  final boolean checkAndWarnIfDestroyed() {
    if (this.mDestroyed)
      Log.w("AwAutofillManager", "Application attempted to call on a destroyed AwAutofillManager", new Object[] { new Throwable() }); 
    return this.mDestroyed;
  }
  
  public final void notifyVirtualViewEntered(View paramView, int paramInt, Rect paramRect) {
    if (this.mDisabled) {
      Log.w("AwAutofillManager", "WebView autofill is disabled because WebView isn't created with activity context.", new Object[0]);
      return;
    } 
    if (checkAndWarnIfDestroyed())
      return; 
    if (sIsLoggable)
      log("notifyVirtualViewEntered"); 
    this.mAutofillManager.notifyViewEntered(paramView, paramInt, paramRect);
  }
  
  public final void notifyVirtualViewExited(View paramView, int paramInt) {
    if (!this.mDisabled) {
      if (checkAndWarnIfDestroyed())
        return; 
      if (sIsLoggable)
        log("notifyVirtualViewExited"); 
      this.mAutofillManager.notifyViewExited(paramView, paramInt);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */