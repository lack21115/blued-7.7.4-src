package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import java.util.Objects;

public class WindowInsetsCompat {
  private final Object a;
  
  public WindowInsetsCompat(WindowInsetsCompat paramWindowInsetsCompat) {
    int i = Build.VERSION.SDK_INT;
    WindowInsetsCompat windowInsetsCompat = null;
    if (i >= 20) {
      WindowInsets windowInsets;
      if (paramWindowInsetsCompat == null) {
        paramWindowInsetsCompat = windowInsetsCompat;
      } else {
        windowInsets = new WindowInsets((WindowInsets)paramWindowInsetsCompat.a);
      } 
      this.a = windowInsets;
      return;
    } 
    this.a = null;
  }
  
  WindowInsetsCompat(Object paramObject) {
    this.a = paramObject;
  }
  
  public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets paramWindowInsets) {
    return new WindowInsetsCompat(Objects.requireNonNull(paramWindowInsets));
  }
  
  public WindowInsetsCompat consumeDisplayCutout() {
    return (Build.VERSION.SDK_INT >= 28) ? new WindowInsetsCompat(((WindowInsets)this.a).consumeDisplayCutout()) : this;
  }
  
  public WindowInsetsCompat consumeStableInsets() {
    return (Build.VERSION.SDK_INT >= 21) ? new WindowInsetsCompat(((WindowInsets)this.a).consumeStableInsets()) : null;
  }
  
  public WindowInsetsCompat consumeSystemWindowInsets() {
    return (Build.VERSION.SDK_INT >= 20) ? new WindowInsetsCompat(((WindowInsets)this.a).consumeSystemWindowInsets()) : null;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof WindowInsetsCompat))
      return false; 
    paramObject = paramObject;
    return ObjectsCompat.equals(this.a, ((WindowInsetsCompat)paramObject).a);
  }
  
  public DisplayCutoutCompat getDisplayCutout() {
    return (Build.VERSION.SDK_INT >= 28) ? DisplayCutoutCompat.a(((WindowInsets)this.a).getDisplayCutout()) : null;
  }
  
  public Insets getMandatorySystemGestureInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.a).getMandatorySystemGestureInsets()) : getSystemWindowInsets();
  }
  
  public int getStableInsetBottom() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.a).getStableInsetBottom() : 0;
  }
  
  public int getStableInsetLeft() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.a).getStableInsetLeft() : 0;
  }
  
  public int getStableInsetRight() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.a).getStableInsetRight() : 0;
  }
  
  public int getStableInsetTop() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.a).getStableInsetTop() : 0;
  }
  
  public Insets getStableInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.a).getStableInsets()) : Insets.of(getStableInsetLeft(), getStableInsetTop(), getStableInsetRight(), getStableInsetBottom());
  }
  
  public Insets getSystemGestureInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.a).getSystemGestureInsets()) : getSystemWindowInsets();
  }
  
  public int getSystemWindowInsetBottom() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).getSystemWindowInsetBottom() : 0;
  }
  
  public int getSystemWindowInsetLeft() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).getSystemWindowInsetLeft() : 0;
  }
  
  public int getSystemWindowInsetRight() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).getSystemWindowInsetRight() : 0;
  }
  
  public int getSystemWindowInsetTop() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).getSystemWindowInsetTop() : 0;
  }
  
  public Insets getSystemWindowInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.a).getSystemWindowInsets()) : Insets.of(getSystemWindowInsetLeft(), getSystemWindowInsetTop(), getSystemWindowInsetRight(), getSystemWindowInsetBottom());
  }
  
  public Insets getTappableElementInsets() {
    return (Build.VERSION.SDK_INT >= 29) ? Insets.wrap(((WindowInsets)this.a).getTappableElementInsets()) : getSystemWindowInsets();
  }
  
  public boolean hasInsets() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).hasInsets() : false;
  }
  
  public boolean hasStableInsets() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.a).hasStableInsets() : false;
  }
  
  public boolean hasSystemWindowInsets() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).hasSystemWindowInsets() : false;
  }
  
  public int hashCode() {
    Object object = this.a;
    return (object == null) ? 0 : object.hashCode();
  }
  
  public boolean isConsumed() {
    return (Build.VERSION.SDK_INT >= 21) ? ((WindowInsets)this.a).isConsumed() : false;
  }
  
  public boolean isRound() {
    return (Build.VERSION.SDK_INT >= 20) ? ((WindowInsets)this.a).isRound() : false;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (Build.VERSION.SDK_INT >= 20) ? new WindowInsetsCompat(((WindowInsets)this.a).replaceSystemWindowInsets(paramInt1, paramInt2, paramInt3, paramInt4)) : null;
  }
  
  public WindowInsetsCompat replaceSystemWindowInsets(Rect paramRect) {
    return (Build.VERSION.SDK_INT >= 21) ? new WindowInsetsCompat(((WindowInsets)this.a).replaceSystemWindowInsets(paramRect)) : null;
  }
  
  public WindowInsets toWindowInsets() {
    return (WindowInsets)this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\WindowInsetsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */