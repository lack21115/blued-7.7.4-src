package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.List;

public final class DisplayCutoutCompat {
  private final Object a;
  
  public DisplayCutoutCompat(Rect paramRect, List<Rect> paramList) {
    this(paramRect);
  }
  
  private DisplayCutoutCompat(Object paramObject) {
    this.a = paramObject;
  }
  
  static DisplayCutoutCompat a(Object paramObject) {
    return (paramObject == null) ? null : new DisplayCutoutCompat(paramObject);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      DisplayCutoutCompat displayCutoutCompat = (DisplayCutoutCompat)paramObject;
      paramObject = this.a;
      Object object = displayCutoutCompat.a;
      return (paramObject == null) ? ((object == null)) : paramObject.equals(object);
    } 
    return false;
  }
  
  public List<Rect> getBoundingRects() {
    return (Build.VERSION.SDK_INT >= 28) ? ((DisplayCutout)this.a).getBoundingRects() : null;
  }
  
  public int getSafeInsetBottom() {
    return (Build.VERSION.SDK_INT >= 28) ? ((DisplayCutout)this.a).getSafeInsetBottom() : 0;
  }
  
  public int getSafeInsetLeft() {
    return (Build.VERSION.SDK_INT >= 28) ? ((DisplayCutout)this.a).getSafeInsetLeft() : 0;
  }
  
  public int getSafeInsetRight() {
    return (Build.VERSION.SDK_INT >= 28) ? ((DisplayCutout)this.a).getSafeInsetRight() : 0;
  }
  
  public int getSafeInsetTop() {
    return (Build.VERSION.SDK_INT >= 28) ? ((DisplayCutout)this.a).getSafeInsetTop() : 0;
  }
  
  public int hashCode() {
    Object object = this.a;
    return (object == null) ? 0 : object.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DisplayCutoutCompat{");
    stringBuilder.append(this.a);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\DisplayCutoutCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */