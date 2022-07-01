package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacn {
  public static final Status zaa = new Status(8, "The connection to Google Play services was lost");
  
  final Set<BasePendingResult<?>> zab = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<BasePendingResult<?>, Boolean>()));
  
  private final zaco zac = new zacm(this);
  
  public final void zaa() {
    Set<BasePendingResult<?>> set = this.zab;
    int i = 0;
    BasePendingResult[] arrayOfBasePendingResult = set.<BasePendingResult>toArray(new BasePendingResult[0]);
    int j = arrayOfBasePendingResult.length;
    while (i < j) {
      BasePendingResult basePendingResult = arrayOfBasePendingResult[i];
      basePendingResult.zaa((zaco)null);
      if (basePendingResult.zaa())
        this.zab.remove(basePendingResult); 
      i++;
    } 
  }
  
  final void zaa(BasePendingResult<? extends Result> paramBasePendingResult) {
    this.zab.add(paramBasePendingResult);
    paramBasePendingResult.zaa(this.zac);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zacn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */