package androidx.core.graphics;

import android.graphics.Bitmap;
import android.os.Build;

public final class BitmapCompat {
  public static int getAllocationByteCount(Bitmap paramBitmap) {
    return (Build.VERSION.SDK_INT >= 19) ? paramBitmap.getAllocationByteCount() : paramBitmap.getByteCount();
  }
  
  public static boolean hasMipMap(Bitmap paramBitmap) {
    return (Build.VERSION.SDK_INT >= 18) ? paramBitmap.hasMipMap() : false;
  }
  
  public static void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 18)
      paramBitmap.setHasMipMap(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\BitmapCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */