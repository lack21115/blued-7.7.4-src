package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class CardViewApi21Impl implements CardViewImpl {
  private RoundRectDrawable a(CardViewDelegate paramCardViewDelegate) {
    return (RoundRectDrawable)paramCardViewDelegate.getCardBackground();
  }
  
  public ColorStateList getBackgroundColor(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).getColor();
  }
  
  public float getElevation(CardViewDelegate paramCardViewDelegate) {
    return paramCardViewDelegate.getCardView().getElevation();
  }
  
  public float getMaxElevation(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).a();
  }
  
  public float getMinHeight(CardViewDelegate paramCardViewDelegate) {
    return getRadius(paramCardViewDelegate) * 2.0F;
  }
  
  public float getMinWidth(CardViewDelegate paramCardViewDelegate) {
    return getRadius(paramCardViewDelegate) * 2.0F;
  }
  
  public float getRadius(CardViewDelegate paramCardViewDelegate) {
    return a(paramCardViewDelegate).getRadius();
  }
  
  public void initStatic() {}
  
  public void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3) {
    paramCardViewDelegate.setCardBackground(new RoundRectDrawable(paramColorStateList, paramFloat1));
    View view = paramCardViewDelegate.getCardView();
    view.setClipToOutline(true);
    view.setElevation(paramFloat2);
    setMaxElevation(paramCardViewDelegate, paramFloat3);
  }
  
  public void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate) {
    setMaxElevation(paramCardViewDelegate, getMaxElevation(paramCardViewDelegate));
  }
  
  public void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate) {
    setMaxElevation(paramCardViewDelegate, getMaxElevation(paramCardViewDelegate));
  }
  
  public void setBackgroundColor(CardViewDelegate paramCardViewDelegate, ColorStateList paramColorStateList) {
    a(paramCardViewDelegate).setColor(paramColorStateList);
  }
  
  public void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat) {
    paramCardViewDelegate.getCardView().setElevation(paramFloat);
  }
  
  public void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat) {
    a(paramCardViewDelegate).a(paramFloat, paramCardViewDelegate.getUseCompatPadding(), paramCardViewDelegate.getPreventCornerOverlap());
    updatePadding(paramCardViewDelegate);
  }
  
  public void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat) {
    a(paramCardViewDelegate).a(paramFloat);
  }
  
  public void updatePadding(CardViewDelegate paramCardViewDelegate) {
    if (!paramCardViewDelegate.getUseCompatPadding()) {
      paramCardViewDelegate.setShadowPadding(0, 0, 0, 0);
      return;
    } 
    float f1 = getMaxElevation(paramCardViewDelegate);
    float f2 = getRadius(paramCardViewDelegate);
    int i = (int)Math.ceil(RoundRectDrawableWithShadow.b(f1, f2, paramCardViewDelegate.getPreventCornerOverlap()));
    int j = (int)Math.ceil(RoundRectDrawableWithShadow.a(f1, f2, paramCardViewDelegate.getPreventCornerOverlap()));
    paramCardViewDelegate.setShadowPadding(i, j, i, j);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cardview\widget\CardViewApi21Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */