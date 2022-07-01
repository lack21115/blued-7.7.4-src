package c.t.maploc.lite.tsa;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

final class ac extends PhoneStateListener {
  ac(ab paramab) {}
  
  public final void onCellLocationChanged(CellLocation paramCellLocation) {
    super.onCellLocationChanged(paramCellLocation);
    if (paramCellLocation == null)
      return; 
    try {
      if (ab.a(this.a, paramCellLocation)) {
        ab.b(this.a, paramCellLocation);
        ab.e(this.a);
      } else {
        (new StringBuilder("onCellLocationChanged: illegal cell or same cell ")).append(paramCellLocation);
      } 
      return;
    } finally {
      paramCellLocation = null;
    } 
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState) {
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null)
      return; 
    ServiceState serviceState = ab.a(this.a);
    if (serviceState == null || serviceState.getState() != paramServiceState.getState()) {
      ab.a(this.a, paramServiceState);
      ab.b(this.a);
    } 
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength) {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null)
      return; 
    try {
      SignalStrength signalStrength = ab.c(this.a);
      int i = ab.d(this.a);
      return;
    } finally {
      paramSignalStrength = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */