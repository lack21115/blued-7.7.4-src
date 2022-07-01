package c.t.maploc.lite.tsa;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

public final class ae extends t implements LocationListener, Runnable {
  public long a = 0L;
  
  private HandlerThread b;
  
  private Handler c;
  
  public ae(j paramj, l paraml) {
    super(paramj, paraml);
  }
  
  private static boolean a(double paramDouble) {
    return (Math.abs(Double.valueOf(paramDouble).longValue() - paramDouble) < Double.MIN_VALUE);
  }
  
  public final void a() {
    if (this.g.c())
      try {
        this.g.g.removeUpdates(this);
      } finally {
        Exception exception;
      }  
    HandlerThread handlerThread = this.b;
    if (handlerThread != null) {
      handlerThread.quit();
      this.b = null;
    } 
    this.a = 0L;
  }
  
  public final void a(Handler paramHandler) {
    this.b = new HandlerThread("gps_provider");
    this.b.start();
    this.c = new Handler(this.b.getLooper());
    this.c.post(this);
    this.a = 0L;
  }
  
  public final String b() {
    return "GpsPro";
  }
  
  public final Location c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Lc/t/maploc/lite/tsa/j;
    //   4: invokevirtual c : ()Z
    //   7: ifeq -> 26
    //   10: aload_0
    //   11: getfield g : Lc/t/maploc/lite/tsa/j;
    //   14: getfield g : Landroid/location/LocationManager;
    //   17: ldc 'network'
    //   19: invokevirtual getLastKnownLocation : (Ljava/lang/String;)Landroid/location/Location;
    //   22: astore_1
    //   23: goto -> 28
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_1
    //   29: astore_2
    //   30: aload_1
    //   31: ifnonnull -> 38
    //   34: getstatic c/t/maploc/lite/tsa/n.a : Landroid/location/Location;
    //   37: astore_2
    //   38: aload_2
    //   39: areturn
    //   40: astore_1
    //   41: goto -> 26
    // Exception table:
    //   from	to	target	type
    //   0	23	40	finally
  }
  
  public final boolean d() {
    LocationManager locationManager = this.g.g;
    if (locationManager != null)
      try {
        return locationManager.isProviderEnabled("gps");
      } finally {} 
    return false;
  }
  
  public final void onLocationChanged(Location paramLocation) {
    boolean bool;
    if (paramLocation != null) {
      try {
      
      } finally {
        paramLocation = null;
      } 
    } else {
      return;
    } 
    if (!bool)
      return; 
    this.a = System.currentTimeMillis();
    a(new n(paramLocation, this.a));
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public final void run() {
    if (this.g.c())
      try {
        return;
      } finally {
        Exception exception = null;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */