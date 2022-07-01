package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class zav {
  private final Map<BasePendingResult<?>, Boolean> zaa = Collections.synchronizedMap(new WeakHashMap<BasePendingResult<?>, Boolean>());
  
  private final Map<TaskCompletionSource<?>, Boolean> zab = Collections.synchronizedMap(new WeakHashMap<TaskCompletionSource<?>, Boolean>());
  
  private final void zaa(boolean paramBoolean, Status paramStatus) {
    synchronized (this.zaa) {
      Map<TaskCompletionSource<?>, Boolean> map;
      HashMap<BasePendingResult<?>, Boolean> hashMap = new HashMap<BasePendingResult<?>, Boolean>(this.zaa);
      synchronized (this.zab) {
        null = (Map)new HashMap<Object, Boolean>(this.zab);
        for (Map.Entry<BasePendingResult<?>, Boolean> entry : hashMap.entrySet()) {
          if (paramBoolean || ((Boolean)entry.getValue()).booleanValue())
            ((BasePendingResult)entry.getKey()).forceFailureUnlessReady(paramStatus); 
        } 
        for (Map.Entry<BasePendingResult<?>, Boolean> entry1 : null.entrySet()) {
          if (paramBoolean || ((Boolean)entry1.getValue()).booleanValue())
            ((TaskCompletionSource)entry1.getKey()).trySetException((Exception)new ApiException(paramStatus)); 
        } 
        return;
      } 
    } 
  }
  
  final void zaa(int paramInt, String paramString) {
    StringBuilder stringBuilder = new StringBuilder("The connection to Google Play services was lost");
    if (paramInt == 1) {
      stringBuilder.append(" due to service disconnection.");
    } else if (paramInt == 3) {
      stringBuilder.append(" due to dead object exception.");
    } 
    if (paramString != null) {
      stringBuilder.append(" Last reason for disconnect: ");
      stringBuilder.append(paramString);
    } 
    zaa(true, new Status(20, stringBuilder.toString()));
  }
  
  final void zaa(BasePendingResult<? extends Result> paramBasePendingResult, boolean paramBoolean) {
    this.zaa.put(paramBasePendingResult, Boolean.valueOf(paramBoolean));
    paramBasePendingResult.addStatusListener(new zax(this, paramBasePendingResult));
  }
  
  final <TResult> void zaa(TaskCompletionSource<TResult> paramTaskCompletionSource, boolean paramBoolean) {
    this.zab.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new zaw(this, paramTaskCompletionSource));
  }
  
  final boolean zaa() {
    return (!this.zaa.isEmpty() || !this.zab.isEmpty());
  }
  
  public final void zab() {
    zaa(false, GoogleApiManager.zaa);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */