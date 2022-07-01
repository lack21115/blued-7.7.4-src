package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

interface CardViewDelegate {
  Drawable getCardBackground();
  
  View getCardView();
  
  boolean getPreventCornerOverlap();
  
  boolean getUseCompatPadding();
  
  void setCardBackground(Drawable paramDrawable);
  
  void setMinWidthHeightInternal(int paramInt1, int paramInt2);
  
  void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cardview\widget\CardViewDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */