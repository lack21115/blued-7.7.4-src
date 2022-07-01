package android.support.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

final class VectorDrawableCompat$VectorDrawableDelegateState extends Drawable.ConstantState {
  private final Drawable.ConstantState mDelegateState;
  
  public VectorDrawableCompat$VectorDrawableDelegateState(Drawable.ConstantState paramConstantState) {
    this.mDelegateState = paramConstantState;
  }
  
  public final boolean canApplyTheme() {
    return this.mDelegateState.canApplyTheme();
  }
  
  public final int getChangingConfigurations() {
    return this.mDelegateState.getChangingConfigurations();
  }
  
  public final Drawable newDrawable() {
    VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
    vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable();
    return vectorDrawableCompat;
  }
  
  public final Drawable newDrawable(Resources paramResources) {
    VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
    vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(paramResources);
    return vectorDrawableCompat;
  }
  
  public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme) {
    VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
    vectorDrawableCompat.mDelegateDrawable = this.mDelegateState.newDrawable(paramResources, paramTheme);
    return vectorDrawableCompat;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\VectorDrawableCompat$VectorDrawableDelegateState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */