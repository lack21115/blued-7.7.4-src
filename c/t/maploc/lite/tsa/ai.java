package c.t.maploc.lite.tsa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ai extends t implements Runnable, Comparator {
  public static boolean a = false;
  
  private static long c = 0L;
  
  private static boolean d = false;
  
  public long b = 30000L;
  
  private Handler e = null;
  
  private int f = 4;
  
  private long i = 0L;
  
  private BroadcastReceiver j = new aj(this);
  
  public ai(j paramj, l paraml) {
    super(paramj, paraml);
  }
  
  public static String a(Context paramContext) {
    String str = "{}";
    if (paramContext == null)
      return "{}"; 
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      String str1 = str;
      return str1;
    } finally {
      paramContext = null;
    } 
  }
  
  public static List a(WifiManager paramWifiManager) {
    List<?> list3 = null;
    List<?> list2 = null;
    if (paramWifiManager != null) {
      list2 = list3;
      try {
        List<?> list = paramWifiManager.getScanResults();
        list2 = list;
        a = false;
      } finally {
        paramWifiManager = null;
      } 
    } 
    List<?> list1 = list2;
    if (list2 == null)
      list1 = Collections.emptyList(); 
    return list1;
  }
  
  private void a(long paramLong) {
    Handler handler = this.e;
    if (handler != null) {
      handler.removeCallbacks(this);
      handler.postDelayed(this, paramLong);
    } 
  }
  
  private static boolean a(j paramj) {
    WifiManager wifiManager = paramj.f;
    boolean bool1 = false;
    boolean bool2 = false;
    if (wifiManager != null) {
      boolean bool = bool2;
      try {
        if (Build.VERSION.SDK_INT >= 23) {
          bool = bool2;
          if (Settings.Secure.getInt(paramj.a.getContentResolver(), "location_mode") == 0)
            return false; 
        } 
        bool = bool2;
        bool2 = wifiManager.isWifiEnabled();
      } finally {
        paramj = null;
        bool1 = bool;
      } 
    } 
    return bool1;
  }
  
  private static boolean b(WifiManager paramWifiManager) {
    // Byte code:
    //   0: ldc c/t/maploc/lite/tsa/ai
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_1
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_0
    //   8: ifnull -> 85
    //   11: iload_3
    //   12: istore_2
    //   13: invokestatic currentTimeMillis : ()J
    //   16: getstatic c/t/maploc/lite/tsa/ai.c : J
    //   19: lsub
    //   20: ldc2_w 3000
    //   23: lcmp
    //   24: ifle -> 51
    //   27: iload_3
    //   28: istore_2
    //   29: aload_0
    //   30: invokevirtual startScan : ()Z
    //   33: istore_1
    //   34: iload_1
    //   35: istore_2
    //   36: iload_1
    //   37: putstatic c/t/maploc/lite/tsa/ai.d : Z
    //   40: iload_1
    //   41: istore_2
    //   42: invokestatic currentTimeMillis : ()J
    //   45: putstatic c/t/maploc/lite/tsa/ai.c : J
    //   48: goto -> 85
    //   51: iload_3
    //   52: istore_2
    //   53: getstatic c/t/maploc/lite/tsa/ai.d : Z
    //   56: istore_1
    //   57: goto -> 85
    //   60: astore_0
    //   61: iload_2
    //   62: istore_1
    //   63: aload_0
    //   64: instanceof java/lang/SecurityException
    //   67: ifeq -> 85
    //   70: iconst_1
    //   71: putstatic c/t/maploc/lite/tsa/ai.a : Z
    //   74: iload_2
    //   75: istore_1
    //   76: goto -> 85
    //   79: astore_0
    //   80: ldc c/t/maploc/lite/tsa/ai
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    //   85: ldc c/t/maploc/lite/tsa/ai
    //   87: monitorexit
    //   88: iload_1
    //   89: ireturn
    // Exception table:
    //   from	to	target	type
    //   13	27	60	finally
    //   29	34	60	finally
    //   36	40	60	finally
    //   42	48	60	finally
    //   53	57	60	finally
    //   63	74	79	finally
  }
  
  private void d() {
    int i;
    try {
      byte b;
      if (this.g.b()) {
        b = this.g.f.getWifiState();
      } else {
        b = 4;
      } 
      this.f = b;
    } finally {
      Exception exception = null;
    } 
    if (i == 3) {
      a(0L);
      i = 1;
    } else if (i == 1) {
      boolean bool = false;
      i = bool;
      if (!a(this.g)) {
        this.e.sendEmptyMessage(2005);
        i = bool;
      } 
    } else {
      i = -1;
    } 
    int j = i;
    try {
    
    } finally {
      Exception exception = null;
    } 
    a(1, j);
  }
  
  public final void a() {
    Handler handler = this.e;
    if (handler != null) {
      handler.removeCallbacksAndMessages(null);
      this.e = null;
    } 
    try {
      this.g.a.unregisterReceiver(this.j);
    } finally {}
    this.i = 0L;
  }
  
  public final void a(Handler paramHandler) {
    this.e = paramHandler;
    paramHandler = this.e;
    if (paramHandler != null) {
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
      try {
        this.g.a.registerReceiver(this.j, intentFilter, null, paramHandler);
      } finally {}
    } 
    a(0L);
  }
  
  public final String b() {
    return "WifiPro";
  }
  
  public final boolean c() {
    return !a(this.g) ? false : b(this.g.f);
  }
  
  public final void run() {
    c();
    a(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */