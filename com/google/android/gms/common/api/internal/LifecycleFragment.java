package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

public interface LifecycleFragment {
  void addCallback(String paramString, LifecycleCallback paramLifecycleCallback);
  
  <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass);
  
  Activity getLifecycleActivity();
  
  boolean isCreated();
  
  boolean isStarted();
  
  void startActivityForResult(Intent paramIntent, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\LifecycleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */