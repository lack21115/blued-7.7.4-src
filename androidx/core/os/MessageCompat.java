package androidx.core.os;

import android.os.Build;
import android.os.Message;

public final class MessageCompat {
  private static boolean a = true;
  
  private static boolean b = true;
  
  public static boolean isAsynchronous(Message paramMessage) {
    if (Build.VERSION.SDK_INT >= 22)
      return paramMessage.isAsynchronous(); 
    if (b && Build.VERSION.SDK_INT >= 16)
      try {
        return paramMessage.isAsynchronous();
      } catch (NoSuchMethodError noSuchMethodError) {
        b = false;
      }  
    return false;
  }
  
  public static void setAsynchronous(Message paramMessage, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 22) {
      paramMessage.setAsynchronous(paramBoolean);
      return;
    } 
    if (a && Build.VERSION.SDK_INT >= 16)
      try {
        paramMessage.setAsynchronous(paramBoolean);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        a = false;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\os\MessageCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */