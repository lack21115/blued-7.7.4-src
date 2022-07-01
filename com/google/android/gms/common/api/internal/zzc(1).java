package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzc extends Fragment implements LifecycleFragment {
  private static WeakHashMap<FragmentActivity, WeakReference<zzc>> zza = new WeakHashMap<FragmentActivity, WeakReference<zzc>>();
  
  private Map<String, LifecycleCallback> zzb = Collections.synchronizedMap((Map<String, LifecycleCallback>)new ArrayMap());
  
  private int zzc = 0;
  
  private Bundle zzd;
  
  public static zzc zza(FragmentActivity paramFragmentActivity) {
    WeakReference<zzc> weakReference = zza.get(paramFragmentActivity);
    if (weakReference != null) {
      zzc zzc1 = weakReference.get();
      if (zzc1 != null)
        return zzc1; 
    } 
    try {
      zzc zzc2 = (zzc)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
      if (zzc2 != null) {
        zzc zzc3 = zzc2;
        if (zzc2.isRemoving()) {
          zzc3 = new zzc();
          paramFragmentActivity.getSupportFragmentManager().beginTransaction().add(zzc3, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
          zza.put(paramFragmentActivity, new WeakReference<zzc>(zzc3));
          return zzc3;
        } 
        zza.put(paramFragmentActivity, new WeakReference<zzc>(zzc3));
        return zzc3;
      } 
      zzc zzc1 = new zzc();
      paramFragmentActivity.getSupportFragmentManager().beginTransaction().add(zzc1, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
      zza.put(paramFragmentActivity, new WeakReference<zzc>(zzc1));
      return zzc1;
    } catch (ClassCastException classCastException) {
      throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", classCastException);
    } 
  }
  
  public final void addCallback(String paramString, LifecycleCallback paramLifecycleCallback) {
    if (!this.zzb.containsKey(paramString)) {
      this.zzb.put(paramString, paramLifecycleCallback);
      if (this.zzc > 0)
        (new zzi(Looper.getMainLooper())).post(new zzd(this, paramLifecycleCallback, paramString)); 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */