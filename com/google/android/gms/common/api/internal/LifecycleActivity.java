package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.Preconditions;

public class LifecycleActivity {
  private final Object zza;
  
  public LifecycleActivity(Activity paramActivity) {
    this.zza = Preconditions.checkNotNull(paramActivity, "Activity must not be null");
  }
  
  public LifecycleActivity(ContextWrapper paramContextWrapper) {
    throw new UnsupportedOperationException();
  }
  
  public Activity asActivity() {
    return (Activity)this.zza;
  }
  
  public FragmentActivity asFragmentActivity() {
    return (FragmentActivity)this.zza;
  }
  
  public Object asObject() {
    return this.zza;
  }
  
  public boolean isChimera() {
    return false;
  }
  
  public boolean isSupport() {
    return this.zza instanceof FragmentActivity;
  }
  
  public final boolean zza() {
    return this.zza instanceof Activity;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\LifecycleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */