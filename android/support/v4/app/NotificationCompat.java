package android.support.v4.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;

public final class NotificationCompat {
  public static Bundle getExtras(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 19) ? paramNotification.extras : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification) : null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\NotificationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */