package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zat implements zabn {
  private zat(zas paramzas) {}
  
  public final void zaa(int paramInt, boolean paramBoolean) {
    zas.zaa(this.zaa).lock();
    try {
      if (zas.zac(this.zaa)) {
        zas.zaa(this.zaa, false);
        zas.zaa(this.zaa, paramInt, paramBoolean);
        return;
      } 
      zas.zaa(this.zaa, true);
      zas.zaf(this.zaa).onConnectionSuspended(paramInt);
      return;
    } finally {
      zas.zaa(this.zaa).unlock();
    } 
  }
  
  public final void zaa(Bundle paramBundle) {
    zas.zaa(this.zaa).lock();
    try {
      zas.zab(this.zaa, ConnectionResult.RESULT_SUCCESS);
      zas.zab(this.zaa);
      return;
    } finally {
      zas.zaa(this.zaa).unlock();
    } 
  }
  
  public final void zaa(ConnectionResult paramConnectionResult) {
    zas.zaa(this.zaa).lock();
    try {
      zas.zab(this.zaa, paramConnectionResult);
      zas.zab(this.zaa);
      return;
    } finally {
      zas.zaa(this.zaa).unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */