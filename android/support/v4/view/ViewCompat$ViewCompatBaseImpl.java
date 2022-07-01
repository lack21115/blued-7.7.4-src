package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class ViewCompat$ViewCompatBaseImpl {
  private static Field sMinHeightField;
  
  private static boolean sMinHeightFieldFetched;
  
  private static WeakHashMap sTransitionNameMap;
  
  public ColorStateList getBackgroundTintList(View paramView) {
    return (paramView instanceof TintableBackgroundView) ? ((TintableBackgroundView)paramView).getSupportBackgroundTintList() : null;
  }
  
  public PorterDuff.Mode getBackgroundTintMode(View paramView) {
    return (paramView instanceof TintableBackgroundView) ? ((TintableBackgroundView)paramView).getSupportBackgroundTintMode() : null;
  }
  
  public int getLayoutDirection(View paramView) {
    return 0;
  }
  
  public int getMinimumHeight(View paramView) {
    if (!sMinHeightFieldFetched) {
      try {
        Field field = View.class.getDeclaredField("mMinHeight");
        sMinHeightField = field;
        field.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      sMinHeightFieldFetched = true;
    } 
    if (sMinHeightField != null)
      try {
        return ((Integer)sMinHeightField.get(paramView)).intValue();
      } catch (Exception exception) {} 
    return 0;
  }
  
  public int getPaddingEnd(View paramView) {
    return paramView.getPaddingRight();
  }
  
  public int getPaddingStart(View paramView) {
    return paramView.getPaddingLeft();
  }
  
  public String getTransitionName(View paramView) {
    return (sTransitionNameMap == null) ? null : (String)sTransitionNameMap.get(paramView);
  }
  
  public int getWindowSystemUiVisibility(View paramView) {
    return 0;
  }
  
  public boolean hasOverlappingRendering(View paramView) {
    return true;
  }
  
  public boolean isAttachedToWindow(View paramView) {
    return (paramView.getWindowToken() != null);
  }
  
  public void postInvalidateOnAnimation(View paramView) {
    paramView.postInvalidate();
  }
  
  public void postOnAnimation(View paramView, Runnable paramRunnable) {
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
  }
  
  public void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong) {
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay() + paramLong);
  }
  
  public void requestApplyInsets(View paramView) {}
  
  public void setBackground(View paramView, Drawable paramDrawable) {
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundTintList(View paramView, ColorStateList paramColorStateList) {
    if (paramView instanceof TintableBackgroundView)
      ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList); 
  }
  
  public void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode) {
    if (paramView instanceof TintableBackgroundView)
      ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode); 
  }
  
  public void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setTransitionName(View paramView, String paramString) {
    if (sTransitionNameMap == null)
      sTransitionNameMap = new WeakHashMap<Object, Object>(); 
    sTransitionNameMap.put(paramView, paramString);
  }
  
  public void stopNestedScroll(View paramView) {
    if (paramView instanceof NestedScrollingChild)
      ((NestedScrollingChild)paramView).stopNestedScroll(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewCompat$ViewCompatBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */