package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
  private static final SparseArray<PowerManager.WakeLock> a = new SparseArray();
  
  private static int b = 1;
  
  public static boolean completeWakefulIntent(Intent paramIntent) {
    int i = paramIntent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
    if (i == 0)
      return false; 
    synchronized (a) {
      PowerManager.WakeLock wakeLock = (PowerManager.WakeLock)a.get(i);
      if (wakeLock != null) {
        wakeLock.release();
        a.remove(i);
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No active wake lock id #");
      stringBuilder.append(i);
      Log.w("WakefulBroadcastReceiv.", stringBuilder.toString());
      return true;
    } 
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent) {
    synchronized (a) {
      int i = b;
      b++;
      if (b <= 0)
        b = 1; 
      paramIntent.putExtra("androidx.contentpager.content.wakelockid", i);
      ComponentName componentName = paramContext.startService(paramIntent);
      if (componentName == null)
        return null; 
      PowerManager powerManager = (PowerManager)paramContext.getSystemService("power");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("androidx.core:wake:");
      stringBuilder.append(componentName.flattenToShortString());
      PowerManager.WakeLock wakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
      wakeLock.setReferenceCounted(false);
      wakeLock.acquire(60000L);
      a.put(i, wakeLock);
      return componentName;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\legacy\content\WakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */