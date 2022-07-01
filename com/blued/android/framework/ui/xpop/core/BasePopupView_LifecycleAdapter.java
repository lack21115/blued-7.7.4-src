package com.blued.android.framework.ui.xpop.core;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class BasePopupView_LifecycleAdapter implements GeneratedAdapter {
  final BasePopupView a;
  
  BasePopupView_LifecycleAdapter(BasePopupView paramBasePopupView) {
    this.a = paramBasePopupView;
  }
  
  public void callMethods(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, boolean paramBoolean, MethodCallsLogger paramMethodCallsLogger) {
    boolean bool;
    if (paramMethodCallsLogger != null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (paramBoolean)
      return; 
    if (paramEvent == Lifecycle.Event.ON_DESTROY && (!bool || paramMethodCallsLogger.approveCall("onDestroy", 1)))
      this.a.onDestroy(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\core\BasePopupView_LifecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */