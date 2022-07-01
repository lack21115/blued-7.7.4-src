package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

public final class WindowCompat {
  public static final int FEATURE_ACTION_BAR = 8;
  
  public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
  
  public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
  
  public static <T extends View> T requireViewById(Window paramWindow, int paramInt) {
    if (Build.VERSION.SDK_INT >= 28)
      return (T)paramWindow.requireViewById(paramInt); 
    View view = paramWindow.findViewById(paramInt);
    if (view != null)
      return (T)view; 
    throw new IllegalArgumentException("ID does not reference a View inside this Window");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\WindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */