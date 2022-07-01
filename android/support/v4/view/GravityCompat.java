package android.support.v4.view;

import android.os.Build;
import android.view.Gravity;

public final class GravityCompat {
  public static int getAbsoluteGravity(int paramInt1, int paramInt2) {
    return (Build.VERSION.SDK_INT >= 17) ? Gravity.getAbsoluteGravity(paramInt1, paramInt2) : (paramInt1 & 0xFF7FFFFF);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\GravityCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */