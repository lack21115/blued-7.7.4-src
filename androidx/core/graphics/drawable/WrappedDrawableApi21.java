package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

class WrappedDrawableApi21 extends WrappedDrawableApi14 {
  private static Method d;
  
  WrappedDrawableApi21(Drawable paramDrawable) {
    super(paramDrawable);
    b();
  }
  
  WrappedDrawableApi21(WrappedDrawableState paramWrappedDrawableState, Resources paramResources) {
    super(paramWrappedDrawableState, paramResources);
    b();
  }
  
  private void b() {
    if (d == null)
      try {
        d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
        return;
      } catch (Exception exception) {
        Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", exception);
      }  
  }
  
  protected boolean a() {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    null = bool;
    if (i == 21) {
      Drawable drawable = this.c;
      if (!(drawable instanceof android.graphics.drawable.GradientDrawable) && !(drawable instanceof android.graphics.drawable.DrawableContainer) && !(drawable instanceof android.graphics.drawable.InsetDrawable)) {
        null = bool;
        return (drawable instanceof android.graphics.drawable.RippleDrawable) ? true : null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public Rect getDirtyBounds() {
    return this.c.getDirtyBounds();
  }
  
  public void getOutline(Outline paramOutline) {
    this.c.getOutline(paramOutline);
  }
  
  public boolean isProjected() {
    if (this.c != null) {
      Method method = d;
      if (method != null)
        try {
          return ((Boolean)method.invoke(this.c, new Object[0])).booleanValue();
        } catch (Exception exception) {
          Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", exception);
        }  
    } 
    return false;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2) {
    this.c.setHotspot(paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.c.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(int[] paramArrayOfint) {
    if (super.setState(paramArrayOfint)) {
      invalidateSelf();
      return true;
    } 
    return false;
  }
  
  public void setTint(int paramInt) {
    if (a()) {
      super.setTint(paramInt);
      return;
    } 
    this.c.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    if (a()) {
      super.setTintList(paramColorStateList);
      return;
    } 
    this.c.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    if (a()) {
      super.setTintMode(paramMode);
      return;
    } 
    this.c.setTintMode(paramMode);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\drawable\WrappedDrawableApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */