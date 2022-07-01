package com.google.android.gms.common.api.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

public final class zaj {
  private final ArrayMap<ApiKey<?>, ConnectionResult> zaa = new ArrayMap();
  
  private final ArrayMap<ApiKey<?>, String> zab = new ArrayMap();
  
  private final TaskCompletionSource<Map<ApiKey<?>, String>> zac = new TaskCompletionSource();
  
  private int zad;
  
  private boolean zae = false;
  
  public zaj(Iterable<? extends HasApiKey<?>> paramIterable) {
    for (HasApiKey<?> hasApiKey : paramIterable)
      this.zaa.put(hasApiKey.getApiKey(), null); 
    this.zad = this.zaa.keySet().size();
  }
  
  public final Set<ApiKey<?>> zaa() {
    return this.zaa.keySet();
  }
  
  public final void zaa(ApiKey<?> paramApiKey, ConnectionResult paramConnectionResult, String paramString) {
    this.zaa.put(paramApiKey, paramConnectionResult);
    this.zab.put(paramApiKey, paramString);
    this.zad--;
    if (!paramConnectionResult.isSuccess())
      this.zae = true; 
    if (this.zad == 0) {
      if (this.zae) {
        AvailabilityException availabilityException = new AvailabilityException(this.zaa);
        this.zac.setException((Exception)availabilityException);
        return;
      } 
      this.zac.setResult(this.zab);
    } 
  }
  
  public final Task<Map<ApiKey<?>, String>> zab() {
    return this.zac.getTask();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */