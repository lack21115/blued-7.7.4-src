package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

public final class DisplayManagerCompat {
  public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
  
  private static final WeakHashMap<Context, DisplayManagerCompat> a = new WeakHashMap<Context, DisplayManagerCompat>();
  
  private final Context b;
  
  private DisplayManagerCompat(Context paramContext) {
    this.b = paramContext;
  }
  
  public static DisplayManagerCompat getInstance(Context paramContext) {
    synchronized (a) {
      DisplayManagerCompat displayManagerCompat2 = a.get(paramContext);
      DisplayManagerCompat displayManagerCompat1 = displayManagerCompat2;
      if (displayManagerCompat2 == null) {
        displayManagerCompat1 = new DisplayManagerCompat(paramContext);
        a.put(paramContext, displayManagerCompat1);
      } 
      return displayManagerCompat1;
    } 
  }
  
  public Display getDisplay(int paramInt) {
    if (Build.VERSION.SDK_INT >= 17)
      return ((DisplayManager)this.b.getSystemService("display")).getDisplay(paramInt); 
    Display display = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
    return (display.getDisplayId() == paramInt) ? display : null;
  }
  
  public Display[] getDisplays() {
    return (Build.VERSION.SDK_INT >= 17) ? ((DisplayManager)this.b.getSystemService("display")).getDisplays() : new Display[] { ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay() };
  }
  
  public Display[] getDisplays(String paramString) {
    return (Build.VERSION.SDK_INT >= 17) ? ((DisplayManager)this.b.getSystemService("display")).getDisplays(paramString) : ((paramString == null) ? new Display[0] : new Display[] { ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay() });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\hardware\display\DisplayManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */