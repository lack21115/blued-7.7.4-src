package c.t.maploc.lite.tsa;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class j {
  private static j i;
  
  public final Context a;
  
  public final k b;
  
  public final ExecutorService c;
  
  final PackageManager d;
  
  public final TelephonyManager e;
  
  public final WifiManager f;
  
  public final LocationManager g;
  
  public final SharedPreferences h;
  
  private j(Context paramContext) {
    this.a = paramContext;
    this.d = this.a.getPackageManager();
    this.e = (TelephonyManager)this.a.getSystemService("phone");
    this.f = (WifiManager)this.a.getApplicationContext().getSystemService("wifi");
    this.g = (LocationManager)this.a.getSystemService("location");
    this.h = this.a.getSharedPreferences("loc_sdk_lite", 0);
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    if (Build.VERSION.SDK_INT >= 9)
      threadPoolExecutor.allowCoreThreadTimeOut(true); 
    this.c = threadPoolExecutor;
    this.b = new k(this);
    this.b.e();
  }
  
  public static j a(Context paramContext) {
    // Byte code:
    //   0: getstatic c/t/maploc/lite/tsa/j.i : Lc/t/maploc/lite/tsa/j;
    //   3: ifnonnull -> 38
    //   6: ldc c/t/maploc/lite/tsa/j
    //   8: monitorenter
    //   9: getstatic c/t/maploc/lite/tsa/j.i : Lc/t/maploc/lite/tsa/j;
    //   12: ifnonnull -> 26
    //   15: new c/t/maploc/lite/tsa/j
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic c/t/maploc/lite/tsa/j.i : Lc/t/maploc/lite/tsa/j;
    //   26: ldc c/t/maploc/lite/tsa/j
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc c/t/maploc/lite/tsa/j
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic c/t/maploc/lite/tsa/j.i : Lc/t/maploc/lite/tsa/j;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public final boolean a() {
    return (this.e != null);
  }
  
  public final boolean b() {
    return (this.f != null);
  }
  
  public final boolean c() {
    return (this.g != null);
  }
  
  public final String d() {
    Exception exception;
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)this.a.getSystemService("connectivity");
    } finally {
      exception = null;
    } 
    if (exception == null)
      return "NONE"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(exception.getTypeName().toUpperCase());
    stringBuilder.append("[");
    stringBuilder.append(exception.getSubtypeName());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */