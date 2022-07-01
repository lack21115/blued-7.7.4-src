package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

final class WrappedDrawableState extends Drawable.ConstantState {
  int a;
  
  Drawable.ConstantState b;
  
  ColorStateList c = null;
  
  PorterDuff.Mode d = WrappedDrawableApi14.a;
  
  WrappedDrawableState(WrappedDrawableState paramWrappedDrawableState) {
    if (paramWrappedDrawableState != null) {
      this.a = paramWrappedDrawableState.a;
      this.b = paramWrappedDrawableState.b;
      this.c = paramWrappedDrawableState.c;
      this.d = paramWrappedDrawableState.d;
    } 
  }
  
  boolean a() {
    return (this.b != null);
  }
  
  public int getChangingConfigurations() {
    byte b;
    int i = this.a;
    Drawable.ConstantState constantState = this.b;
    if (constantState != null) {
      b = constantState.getChangingConfigurations();
    } else {
      b = 0;
    } 
    return i | b;
  }
  
  public Drawable newDrawable() {
    return newDrawable(null);
  }
  
  public Drawable newDrawable(Resources paramResources) {
    return (Build.VERSION.SDK_INT >= 21) ? new WrappedDrawableApi21(this, paramResources) : new WrappedDrawableApi14(this, paramResources);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\drawable\WrappedDrawableState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */