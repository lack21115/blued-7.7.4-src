package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzae {
  final Map zzfww = Collections.synchronizedMap(new WeakHashMap<Object, Object>());
  
  final Map zzfwx = Collections.synchronizedMap(new WeakHashMap<Object, Object>());
  
  final void zza(boolean paramBoolean, Status paramStatus) {
    synchronized (this.zzfww) {
      Map map;
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(this.zzfww);
      synchronized (this.zzfwx) {
        null = new HashMap<Object, Object>(this.zzfwx);
        for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
          if (paramBoolean || ((Boolean)entry.getValue()).booleanValue())
            ((BasePendingResult)entry.getKey()).zzv(paramStatus); 
        } 
        for (Map.Entry<Object, Object> entry1 : null.entrySet()) {
          if (paramBoolean || ((Boolean)entry1.getValue()).booleanValue())
            ((TaskCompletionSource)entry1.getKey()).trySetException((Exception)new ApiException(paramStatus)); 
        } 
        return;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */