package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zaz;
import java.util.Iterator;
import java.util.Set;

public final class zaaa implements zaaw {
  private final zaaz zaa;
  
  private boolean zab = false;
  
  public zaaa(zaaz paramzaaz) {
    this.zaa = paramzaaz;
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T paramT) {
    return (T)zab((BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>)paramT);
  }
  
  public final void zaa() {}
  
  public final void zaa(int paramInt) {
    this.zaa.zaa((ConnectionResult)null);
    this.zaa.zae.zaa(paramInt, this.zab);
  }
  
  public final void zaa(Bundle paramBundle) {}
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T paramT) {
    try {
      Api.zaa zaa;
      this.zaa.zad.zae.zaa((BasePendingResult<? extends Result>)paramT);
      zaar zaar = this.zaa.zad;
      Api.AnyClientKey anyClientKey = paramT.getClientKey();
      Api.Client client2 = zaar.zab.get(anyClientKey);
      Preconditions.checkNotNull(client2, "Appropriate Api was not requested.");
      if (!client2.isConnected() && this.zaa.zab.containsKey(paramT.getClientKey())) {
        paramT.setFailedResult(new Status(17));
        return paramT;
      } 
      Api.Client client1 = client2;
      if (client2 instanceof zaz) {
        zaz zaz = (zaz)client2;
        zaa = zaz.zaa();
      } 
      paramT.run(zaa);
      return paramT;
    } catch (DeadObjectException deadObjectException) {
      this.zaa.zaa(new zaad(this, this));
      return paramT;
    } 
  }
  
  public final boolean zab() {
    if (this.zab)
      return false; 
    Set<zaci> set = this.zaa.zad.zad;
    if (set != null && !set.isEmpty()) {
      this.zab = true;
      Iterator<zaci> iterator = set.iterator();
      while (iterator.hasNext())
        ((zaci)iterator.next()).zaa(); 
      return false;
    } 
    this.zaa.zaa((ConnectionResult)null);
    return true;
  }
  
  public final void zac() {
    if (this.zab) {
      this.zab = false;
      this.zaa.zaa(new zaac(this, this));
    } 
  }
  
  final void zad() {
    if (this.zab) {
      this.zab = false;
      this.zaa.zad.zae.zaa();
      zab();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */