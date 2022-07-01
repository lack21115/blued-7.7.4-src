package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
  protected final LifecycleFragment mLifecycleFragment;
  
  public LifecycleCallback(LifecycleFragment paramLifecycleFragment) {
    this.mLifecycleFragment = paramLifecycleFragment;
  }
  
  private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity paramLifecycleActivity) {
    throw new IllegalStateException("Method not available in SDK.");
  }
  
  public static LifecycleFragment getFragment(Activity paramActivity) {
    return getFragment(new LifecycleActivity(paramActivity));
  }
  
  public static LifecycleFragment getFragment(ContextWrapper paramContextWrapper) {
    throw new UnsupportedOperationException();
  }
  
  protected static LifecycleFragment getFragment(LifecycleActivity paramLifecycleActivity) {
    if (paramLifecycleActivity.isSupport())
      return zzc.zza(paramLifecycleActivity.asFragmentActivity()); 
    if (paramLifecycleActivity.zza())
      return zzb.zza(paramLifecycleActivity.asActivity()); 
    throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public Activity getActivity() {
    return this.mLifecycleFragment.getLifecycleActivity();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\LifecycleCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */