package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

final class zaah implements BaseGmsClient.ConnectionProgressReportCallbacks {
  private final WeakReference<zaaf> zaa;
  
  private final Api<?> zab;
  
  private final boolean zac;
  
  public zaah(zaaf paramzaaf, Api<?> paramApi, boolean paramBoolean) {
    this.zaa = new WeakReference<zaaf>(paramzaaf);
    this.zab = paramApi;
    this.zac = paramBoolean;
  }
  
  public final void onReportServiceBinding(ConnectionResult paramConnectionResult) {
    boolean bool;
    zaaf zaaf = this.zaa.get();
    if (zaaf == null)
      return; 
    if (Looper.myLooper() == (zaaf.zad(zaaf)).zad.getLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zaaf.zac(zaaf).lock();
    try {
      bool = zaaf.zaa(zaaf, 0);
      if (!bool)
        return; 
      if (!paramConnectionResult.isSuccess())
        zaaf.zaa(zaaf, paramConnectionResult, this.zab, this.zac); 
      if (zaaf.zal(zaaf))
        zaaf.zak(zaaf); 
      return;
    } finally {
      zaaf.zac(zaaf).unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */