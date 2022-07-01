package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zzad implements OnCompleteListener {
  public final void onComplete(Task paramTask) {
    this.zzfwu.zzfwa.lock();
    try {
      boolean bool = this.zzfwu.zzfwp;
      if (!bool)
        return; 
      if (paramTask.isSuccessful()) {
        this.zzfwu.zzfwr = (Map)new ArrayMap(this.zzfwu.zzfwh.size());
        for (zzz zzz : this.zzfwu.zzfwh.values())
          this.zzfwu.zzfwr.put(zzz.zzfsn, ConnectionResult.zzfqt); 
      } else {
        AvailabilityException availabilityException;
        if (paramTask.getException() instanceof AvailabilityException) {
          availabilityException = (AvailabilityException)paramTask.getException();
          if (this.zzfwu.zzfwn) {
            this.zzfwu.zzfwr = (Map)new ArrayMap(this.zzfwu.zzfwh.size());
            for (zzz zzz : this.zzfwu.zzfwh.values()) {
              zzh zzh = zzz.zzfsn;
              ConnectionResult connectionResult = availabilityException.getConnectionResult(zzz);
              if (zzaa.zza(this.zzfwu, zzz, connectionResult)) {
                this.zzfwu.zzfwr.put(zzh, new ConnectionResult(16));
                continue;
              } 
              this.zzfwu.zzfwr.put(zzh, connectionResult);
            } 
          } else {
            this.zzfwu.zzfwr = (Map)availabilityException.zzfse;
          } 
        } else {
          Log.e("ConnectionlessGAC", "Unexpected availability exception", availabilityException.getException());
          this.zzfwu.zzfwr = Collections.emptyMap();
        } 
      } 
      if (this.zzfwu.isConnected()) {
        this.zzfwu.zzfwq.putAll(this.zzfwu.zzfwr);
        if (zzaa.zzf(this.zzfwu) == null) {
          zzaa.zzi(this.zzfwu);
          zzaa.zzj(this.zzfwu);
          this.zzfwu.zzfwl.signalAll();
        } 
      } 
      return;
    } finally {
      this.zzfwu.zzfwa.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */