package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public class ContextCompat {
  private static final Object a = new Object();
  
  private static TypedValue b;
  
  private static File a(File paramFile) {
    // Byte code:
    //   0: ldc androidx/core/content/ContextCompat
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual exists : ()Z
    //   7: ifne -> 70
    //   10: aload_0
    //   11: invokevirtual mkdirs : ()Z
    //   14: ifne -> 70
    //   17: aload_0
    //   18: invokevirtual exists : ()Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifeq -> 31
    //   26: ldc androidx/core/content/ContextCompat
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: new java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore_2
    //   39: aload_2
    //   40: ldc 'Unable to create files subdir '
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: aload_0
    //   48: invokevirtual getPath : ()Ljava/lang/String;
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 'ContextCompat'
    //   57: aload_2
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: ldc androidx/core/content/ContextCompat
    //   67: monitorexit
    //   68: aconst_null
    //   69: areturn
    //   70: ldc androidx/core/content/ContextCompat
    //   72: monitorexit
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: ldc androidx/core/content/ContextCompat
    //   78: monitorexit
    //   79: aload_0
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	75	finally
    //   31	65	75	finally
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString) {
    if (paramString != null)
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()); 
    throw new IllegalArgumentException("permission is null");
  }
  
  public static Context createDeviceProtectedStorageContext(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 24) ? paramContext.createDeviceProtectedStorageContext() : null;
  }
  
  public static File getCodeCacheDir(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 21) ? paramContext.getCodeCacheDir() : a(new File((paramContext.getApplicationInfo()).dataDir, "code_cache"));
  }
  
  public static int getColor(Context paramContext, int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? paramContext.getColor(paramInt) : paramContext.getResources().getColor(paramInt);
  }
  
  public static ColorStateList getColorStateList(Context paramContext, int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? paramContext.getColorStateList(paramInt) : paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static File getDataDir(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 24)
      return paramContext.getDataDir(); 
    String str = (paramContext.getApplicationInfo()).dataDir;
    return (str != null) ? new File(str) : null;
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21)
      return paramContext.getDrawable(paramInt); 
    if (Build.VERSION.SDK_INT >= 16)
      return paramContext.getResources().getDrawable(paramInt); 
    synchronized (a) {
      if (b == null)
        b = new TypedValue(); 
      paramContext.getResources().getValue(paramInt, b, true);
      paramInt = b.resourceId;
      return paramContext.getResources().getDrawable(paramInt);
    } 
  }
  
  public static File[] getExternalCacheDirs(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 19) ? paramContext.getExternalCacheDirs() : new File[] { paramContext.getExternalCacheDir() };
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString) {
    return (Build.VERSION.SDK_INT >= 19) ? paramContext.getExternalFilesDirs(paramString) : new File[] { paramContext.getExternalFilesDir(paramString) };
  }
  
  public static Executor getMainExecutor(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 28) ? paramContext.getMainExecutor() : new MainHandlerExecutor(new Handler(paramContext.getMainLooper()));
  }
  
  public static File getNoBackupFilesDir(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 21) ? paramContext.getNoBackupFilesDir() : a(new File((paramContext.getApplicationInfo()).dataDir, "no_backup"));
  }
  
  public static File[] getObbDirs(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 19) ? paramContext.getObbDirs() : new File[] { paramContext.getObbDir() };
  }
  
  public static <T> T getSystemService(Context paramContext, Class<T> paramClass) {
    if (Build.VERSION.SDK_INT >= 23)
      return (T)paramContext.getSystemService(paramClass); 
    String str = getSystemServiceName(paramContext, paramClass);
    return (T)((str != null) ? paramContext.getSystemService(str) : null);
  }
  
  public static String getSystemServiceName(Context paramContext, Class<?> paramClass) {
    return (Build.VERSION.SDK_INT >= 23) ? paramContext.getSystemServiceName(paramClass) : LegacyServiceMapHolder.a.get(paramClass);
  }
  
  public static boolean isDeviceProtectedStorage(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 24) ? paramContext.isDeviceProtectedStorage() : false;
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent) {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.startActivities(paramArrayOfIntent, paramBundle);
    } else {
      paramContext.startActivities(paramArrayOfIntent);
    } 
    return true;
  }
  
  public static void startActivity(Context paramContext, Intent paramIntent, Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.startActivity(paramIntent, paramBundle);
      return;
    } 
    paramContext.startActivity(paramIntent);
  }
  
  public static void startForegroundService(Context paramContext, Intent paramIntent) {
    if (Build.VERSION.SDK_INT >= 26) {
      paramContext.startForegroundService(paramIntent);
      return;
    } 
    paramContext.startService(paramIntent);
  }
  
  static final class LegacyServiceMapHolder {
    static final HashMap<Class<?>, String> a = new HashMap<Class<?>, String>();
    
    static {
      if (Build.VERSION.SDK_INT >= 22) {
        a.put(SubscriptionManager.class, "telephony_subscription_service");
        a.put(UsageStatsManager.class, "usagestats");
      } 
      if (Build.VERSION.SDK_INT >= 21) {
        a.put(AppWidgetManager.class, "appwidget");
        a.put(BatteryManager.class, "batterymanager");
        a.put(CameraManager.class, "camera");
        a.put(JobScheduler.class, "jobscheduler");
        a.put(LauncherApps.class, "launcherapps");
        a.put(MediaProjectionManager.class, "media_projection");
        a.put(MediaSessionManager.class, "media_session");
        a.put(RestrictionsManager.class, "restrictions");
        a.put(TelecomManager.class, "telecom");
        a.put(TvInputManager.class, "tv_input");
      } 
      if (Build.VERSION.SDK_INT >= 19) {
        a.put(AppOpsManager.class, "appops");
        a.put(CaptioningManager.class, "captioning");
        a.put(ConsumerIrManager.class, "consumer_ir");
        a.put(PrintManager.class, "print");
      } 
      if (Build.VERSION.SDK_INT >= 18)
        a.put(BluetoothManager.class, "bluetooth"); 
      if (Build.VERSION.SDK_INT >= 17) {
        a.put(DisplayManager.class, "display");
        a.put(UserManager.class, "user");
      } 
      if (Build.VERSION.SDK_INT >= 16) {
        a.put(InputManager.class, "input");
        a.put(MediaRouter.class, "media_router");
        a.put(NsdManager.class, "servicediscovery");
      } 
      a.put(AccessibilityManager.class, "accessibility");
      a.put(AccountManager.class, "account");
      a.put(ActivityManager.class, "activity");
      a.put(AlarmManager.class, "alarm");
      a.put(AudioManager.class, "audio");
      a.put(ClipboardManager.class, "clipboard");
      a.put(ConnectivityManager.class, "connectivity");
      a.put(DevicePolicyManager.class, "device_policy");
      a.put(DownloadManager.class, "download");
      a.put(DropBoxManager.class, "dropbox");
      a.put(InputMethodManager.class, "input_method");
      a.put(KeyguardManager.class, "keyguard");
      a.put(LayoutInflater.class, "layout_inflater");
      a.put(LocationManager.class, "location");
      a.put(NfcManager.class, "nfc");
      a.put(NotificationManager.class, "notification");
      a.put(PowerManager.class, "power");
      a.put(SearchManager.class, "search");
      a.put(SensorManager.class, "sensor");
      a.put(StorageManager.class, "storage");
      a.put(TelephonyManager.class, "phone");
      a.put(TextServicesManager.class, "textservices");
      a.put(UiModeManager.class, "uimode");
      a.put(UsbManager.class, "usb");
      a.put(Vibrator.class, "vibrator");
      a.put(WallpaperManager.class, "wallpaper");
      a.put(WifiP2pManager.class, "wifip2p");
      a.put(WifiManager.class, "wifi");
      a.put(WindowManager.class, "window");
    }
  }
  
  static class MainHandlerExecutor implements Executor {
    private final Handler a;
    
    MainHandlerExecutor(Handler param1Handler) {
      this.a = param1Handler;
    }
    
    public void execute(Runnable param1Runnable) {
      if (this.a.post(param1Runnable))
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append(" is shutting down");
      throw new RejectedExecutionException(stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\content\ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */