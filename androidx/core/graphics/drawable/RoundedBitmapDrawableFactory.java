package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {
  public static RoundedBitmapDrawable create(Resources paramResources, Bitmap paramBitmap) {
    return (RoundedBitmapDrawable)((Build.VERSION.SDK_INT >= 21) ? new RoundedBitmapDrawable21(paramResources, paramBitmap) : new DefaultRoundedBitmapDrawable(paramResources, paramBitmap));
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, InputStream paramInputStream) {
    RoundedBitmapDrawable roundedBitmapDrawable = create(paramResources, BitmapFactory.decodeStream(paramInputStream));
    if (roundedBitmapDrawable.getBitmap() == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RoundedBitmapDrawable cannot decode ");
      stringBuilder.append(paramInputStream);
      Log.w("RoundedBitmapDrawableFa", stringBuilder.toString());
    } 
    return roundedBitmapDrawable;
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, String paramString) {
    RoundedBitmapDrawable roundedBitmapDrawable = create(paramResources, BitmapFactory.decodeFile(paramString));
    if (roundedBitmapDrawable.getBitmap() == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RoundedBitmapDrawable cannot decode ");
      stringBuilder.append(paramString);
      Log.w("RoundedBitmapDrawableFa", stringBuilder.toString());
    } 
    return roundedBitmapDrawable;
  }
  
  static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
    DefaultRoundedBitmapDrawable(Resources param1Resources, Bitmap param1Bitmap) {
      super(param1Resources, param1Bitmap);
    }
    
    void a(int param1Int1, int param1Int2, int param1Int3, Rect param1Rect1, Rect param1Rect2) {
      GravityCompat.apply(param1Int1, param1Int2, param1Int3, param1Rect1, param1Rect2, 0);
    }
    
    public boolean hasMipMap() {
      return (this.a != null && BitmapCompat.hasMipMap(this.a));
    }
    
    public void setMipMap(boolean param1Boolean) {
      if (this.a != null) {
        BitmapCompat.setHasMipMap(this.a, param1Boolean);
        invalidateSelf();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\drawable\RoundedBitmapDrawableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */