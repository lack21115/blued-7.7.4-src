package c.t.maploc.lite.tsa;

import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class af extends t {
  TelephonyManager a = null;
  
  volatile m b = null;
  
  ServiceState c = null;
  
  boolean d = false;
  
  Handler e = null;
  
  PhoneStateListener f = new ag(this);
  
  private List i;
  
  private long j = 0L;
  
  public af(j paramj, l paraml) {
    super(paramj, paraml);
    this.a = this.g.e;
  }
  
  private void a(int paramInt) {
    try {
      if (this.a != null)
        return; 
    } finally {
      Exception exception = null;
      StringBuilder stringBuilder = new StringBuilder("listenCellState: failed! flags=");
      stringBuilder.append(paramInt);
    } 
  }
  
  private void b(int paramInt) {
    Handler handler = this.e;
    if (handler != null)
      handler.obtainMessage(paramInt).sendToTarget(); 
  }
  
  public final void a() {
    a(0);
    Handler handler = this.e;
    if (handler != null) {
      handler.removeCallbacksAndMessages(null);
      this.e = null;
    } 
    this.c = null;
  }
  
  public final void a(Handler paramHandler) {
    this.e = new ah(this, paramHandler.getLooper(), (byte)0);
    if (this.i == null)
      this.i = new ArrayList(); 
    this.i.clear();
    this.j = 0L;
    b(1);
    this.d = false;
    a(1025);
  }
  
  public final String b() {
    return "NewCellPro";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */