package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzb extends Fragment implements LifecycleFragment {
  private static WeakHashMap<Activity, WeakReference<zzb>> zza = new WeakHashMap<Activity, WeakReference<zzb>>();
  
  private Map<String, LifecycleCallback> zzb = Collections.synchronizedMap((Map<String, LifecycleCallback>)new ArrayMap());
  
  private int zzc = 0;
  
  private Bundle zzd;
  
  public static zzb zza(Activity paramActivity) {
    WeakReference<zzb> weakReference = zza.get(paramActivity);
    if (weakReference != null) {
      zzb zzb1 = weakReference.get();
      if (zzb1 != null)
        return zzb1; 
    } 
    try {
      zzb zzb2 = (zzb)paramActivity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
      if (zzb2 != null) {
        zzb zzb3 = zzb2;
        if (zzb2.isRemoving()) {
          zzb3 = new zzb();
          paramActivity.getFragmentManager().beginTransaction().add(zzb3, "LifecycleFragmentImpl").commitAllowingStateLoss();
          zza.put(paramActivity, new WeakReference<zzb>(zzb3));
          return zzb3;
        } 
        zza.put(paramActivity, new WeakReference<zzb>(zzb3));
        return zzb3;
      } 
      zzb zzb1 = new zzb();
      paramActivity.getFragmentManager().beginTransaction().add(zzb1, "LifecycleFragmentImpl").commitAllowingStateLoss();
      zza.put(paramActivity, new WeakReference<zzb>(zzb1));
      return zzb1;
    } catch (ClassCastException classCastException) {
      throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", classCastException);
    } 
  }
  
  public final void addCallback(String paramString, LifecycleCallback paramLifecycleCallback) {
    if (!this.zzb.containsKey(paramString)) {
      this.zzb.put(paramString, paramLifecycleCallback);
      if (this.zzc > 0)
        (new zzi(Looper.getMainLooper())).post(new zza(this, paramLifecycleCallback, paramString)); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 59);
    stringBuilder.append("LifecycleCallback with tag ");
    stringBuilder.append(paramString);
    stringBuilder.append(" already added to this fragment.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString); 
  }
  
  public final <T extends LifecycleCallback> T getCallbackOrNull(String paramString, Class<T> paramClass) {
    return paramClass.cast(this.zzb.get(paramString));
  }
  
  public final Activity getLifecycleActivity() {
    return getActivity();
  }
  
  public final boolean isCreated() {
    return (this.zzc > 0);
  }
  
  public final boolean isStarted() {
    return (this.zzc >= 2);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent); 
  }
  
  public final void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.zzc = 1;
    this.zzd = paramBundle;
    for (Map.Entry<String, LifecycleCallback> entry : this.zzb.entrySet()) {
      LifecycleCallback lifecycleCallback = (LifecycleCallback)entry.getValue();
      if (paramBundle != null) {
        Bundle bundle = paramBundle.getBundle((String)entry.getKey());
      } else {
        entry = null;
      } 
      lifecycleCallback.onCreate((Bundle)entry);
    } 
  }
  
  public final void onDestroy() {
    super.onDestroy();
    this.zzc = 5;
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onDestroy(); 
  }
  
  public final void onResume() {
    super.onResume();
    this.zzc = 3;
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onResume(); 
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null)
      return; 
    for (Map.Entry<String, LifecycleCallback> entry : this.zzb.entrySet()) {
      Bundle bundle = new Bundle();
      ((LifecycleCallback)entry.getValue()).onSaveInstanceState(bundle);
      paramBundle.putBundle((String)entry.getKey(), bundle);
    } 
  }
  
  public final void onStart() {
    super.onStart();
    this.zzc = 2;
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onStart(); 
  }
  
  public final void onStop() {
    super.onStop();
    this.zzc = 4;
    Iterator<LifecycleCallback> iterator = this.zzb.values().iterator();
    while (iterator.hasNext())
      ((LifecycleCallback)iterator.next()).onStop(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */