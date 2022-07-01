package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zzac implements OnCompleteListener {
  private zzac(zzaa paramzzaa) {}
  
  public final void onComplete(Task paramTask) {
    this.zzfwu.zzfwa.lock();
    try {
      boolean bool = this.zzfwu.zzfwp;
      if (!bool)
        return; 
      if (paramTask.isSuccessful()) {
        this.zzfwu.zzfwq = (Map)new ArrayMap(this.zzfwu.zzfwg.size());
        for (zzz zzz : this.zzfwu.zzfwg.values())
          this.zzfwu.zzfwq.put(zzz.zzfsn, ConnectionResult.zzfqt); 
      } else {
        AvailabilityException availabilityException;
        if (paramTask.getException() instanceof AvailabilityException) {
          availabilityException = (AvailabilityException)paramTask.getException();
          if (this.zzfwu.zzfwn) {
            this.zzfwu.zzfwq = (Map)new ArrayMap(this.zzfwu.zzfwg.size());
            for (zzz zzz : this.zzfwu.zzfwg.values()) {
              zzh zzh = zzz.zzfsn;
              ConnectionResult connectionResult = availabilityException.getConnectionResult(zzz);
              if (zzaa.zza(this.zzfwu, zzz, connectionResult)) {
                this.zzfwu.zzfwq.put(zzh, new ConnectionResult(16));
                continue;
              } 
              this.zzfwu.zzfwq.put(zzh, connectionResult);
            } 
          } else {
            this.zzfwu.zzfwq = (Map)availabilityException.zzfse;
          } 
          this.zzfwu.zzfwt = zzaa.zzf(this.zzfwu);
        } else {
          Log.e("ConnectionlessGAC", "Unexpected availability exception", availabilityException.getException());
          this.zzfwu.zzfwq = Collections.emptyMap();
          this.zzfwu.zzfwt = new ConnectionResult(8);
        } 
      } 
      if (this.zzfwu.zzfwr != null) {
        this.zzfwu.zzfwq.putAll(this.zzfwu.zzfwr);
        this.zzfwu.zzfwt = zzaa.zzf(this.zzfwu);
      } 
      if (this.zzfwu.zzfwt == null) {
        zzaa.zzi(this.zzfwu);
        zzaa.zzj(this.zzfwu);
      } else {
        this.zzfwu.zzfwp = false;
        this.zzfwu.zzfwj.zzc(this.zzfwu.zzfwt);
      } 
      this.zzfwu.zzfwl.signalAll();
      return;
    } finally {
      this.zzfwu.zzfwa.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */