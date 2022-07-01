package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

public final class CursorWindowCompat {
  public static CursorWindow create(String paramString, long paramLong) {
    return (Build.VERSION.SDK_INT >= 28) ? new CursorWindow(paramString, paramLong) : ((Build.VERSION.SDK_INT >= 15) ? new CursorWindow(paramString) : new CursorWindow(false));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\database\CursorWindowCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */