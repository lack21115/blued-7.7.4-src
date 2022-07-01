package cn.shuzilm.core;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  public static final int MAIN_DU_ASYNCHRONOUS = 1;
  
  public static final int MAIN_DU_SYNCHRONOUS = 0;
  
  private static final ExecutorService a;
  
  private static boolean b;
  
  private static Context c;
  
  private static DUConnection d;
  
  private static int e;
  
  public static final Lock mLock = new ReentrantLock();
  
  static {
    a = Executors.newSingleThreadExecutor();
    b = false;
    c = null;
    d = new DUConnection();
    e = 0;
  }
  
  private static String a(Context paramContext) {
    return DUHelper.getQuickQueryID(paramContext);
  }
  
  private static String a(Context paramContext, String paramString) {
    b = true;
    c = paramContext;
    return DUHelper.startService(paramContext, d, paramString, 1);
  }
  
  public static void exitService() {
    try {
      c.unbindService(d);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static void getOpenAnmsID(Context paramContext, Listener paramListener) {
    DUHelper.ZVTFJRA(paramContext, paramListener);
  }
  
  public static void getOpenAnmsIDAsyn(DUListener paramDUListener) {
    if (b)
      a.execute(new u(paramDUListener)); 
  }
  
  public static String getQueryID(Context paramContext, String paramString1, String paramString2) {
    try {
      return DUHelper.getQueryID(paramContext, paramString1, paramString2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static String getQueryID(String paramString1, String paramString2, DUListener paramDUListener) {
    String str;
    Context context = c;
    if (context != null) {
      str = DUHelper.getQuickQueryID(context);
    } else {
      str = "";
    } 
    if (b)
      try {
        a.execute(new p(paramString1, paramString2, paramDUListener));
        return str;
      } catch (Exception exception) {
        exception.printStackTrace();
        return str;
      }  
    Log.e("[shuzilm]", "[NEED SERVICE ALIVE]");
    return str;
  }
  
  public static Map getQueryID(Context paramContext, String paramString1, String paramString2, int paramInt, Listener paramListener) {
    try {
      return DUHelper.getQueryID(paramContext, paramString1, paramString2, paramInt, paramListener);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static void go(Context paramContext, String paramString1, String paramString2) {
    try {
      DUHelper.go(paramContext, paramString1, paramString2);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void go(String paramString1, String paramString2) {
    if (b)
      try {
        a.execute(new s(paramString1, paramString2));
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static void init(Context paramContext, String paramString) {
    if (Looper.myLooper() == null)
      Looper.prepare(); 
    if (Looper.myLooper() != null)
      DUHelper.init(paramContext, paramString); 
  }
  
  public static void initService(Context paramContext, String paramString) {
    if (Looper.myLooper() == null)
      Looper.prepare(); 
    if (Looper.myLooper() != null)
      try {
        b = true;
        c = paramContext;
        mLock.lock();
        DUHelper.startService(paramContext, d, paramString, 0);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static Map onEvent(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, Listener paramListener) {
    try {
      return DUHelper.onEvent(paramContext, paramString1, paramString2, paramString3, paramInt, paramListener);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static void onEvent(String paramString1, String paramString2, String paramString3, DUListener paramDUListener) {
    if (b)
      try {
        a.execute(new t(paramString1, paramString2, paramString3, paramDUListener));
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        return;
      }  
    Log.e("[shuzilm]", "[NEED SERVICE ALIVE]");
  }
  
  public static void report(Context paramContext, String paramString1, String paramString2) {
    try {
      DUHelper.report(paramContext, paramString1, paramString2);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static int setConfig(String paramString1, String paramString2) {
    if (b) {
      try {
        a.execute(new r(paramString1, paramString2));
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } else {
      return DUHelper.setConfig((String)exception, paramString2);
    } 
    return e;
  }
  
  public static int setData(String paramString1, String paramString2) {
    if (b) {
      try {
        a.execute(new q(paramString1, paramString2));
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } else {
      return DUHelper.setData((String)exception, paramString2);
    } 
    return e;
  }
  
  public static void setWakeupCallback(WakeListener paramWakeListener, int paramInt) {
    if (paramWakeListener != null)
      DUService.callback = paramWakeListener; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\Main.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */