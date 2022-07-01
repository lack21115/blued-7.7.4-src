package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.Iterator;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zaao implements zaaw {
  @NotOnlyInitialized
  private final zaaz zaa;
  
  public zaao(zaaz paramzaaz) {
    this.zaa = paramzaaz;
  }
  
  public final <A extends Api.AnyClient, R extends com.google.android.gms.common.api.Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T paramT) {
    this.zaa.zad.zaa.add((BaseImplementation.ApiMethodImpl<?, ?>)paramT);
    return paramT;
  }
  
  public final void zaa() {
    Iterator<Api.Client> iterator = this.zaa.zaa.values().iterator();
    while (iterator.hasNext())
      ((Api.Client)iterator.next()).disconnect(); 
    this.zaa.zad.zac = Collections.emptySet();
  }
  
  public final void zaa(int paramInt) {}
  
  public final void zaa(Bundle paramBundle) {}
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends com.google.android.gms.common.api.Result, A>> T zab(T paramT) {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final boolean zab() {
    return true;
  }
  
  public final void zac() {
    this.zaa.zah();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */