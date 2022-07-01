package androidx.core.app;

import android.app.Service;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
  public static final int START_STICKY = 1;
  
  public static final int STOP_FOREGROUND_DETACH = 2;
  
  public static final int STOP_FOREGROUND_REMOVE = 1;
  
  public static void stopForeground(Service paramService, int paramInt) {
    if (Build.VERSION.SDK_INT >= 24) {
      paramService.stopForeground(paramInt);
      return;
    } 
    boolean bool = true;
    if ((paramInt & 0x1) == 0)
      bool = false; 
    paramService.stopForeground(bool);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface StopForegroundFlags {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\ServiceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */