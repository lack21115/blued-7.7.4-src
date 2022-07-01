package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;

interface CardViewImpl {
  ColorStateList getBackgroundColor(CardViewDelegate paramCardViewDelegate);
  
  float getElevation(CardViewDelegate paramCardViewDelegate);
  
  float getMaxElevation(CardViewDelegate paramCardViewDelegate);
  
  float getMinHeight(CardViewDelegate paramCardViewDelegate);
  
  float getMinWidth(CardViewDelegate paramCardViewDelegate);
  
  float getRadius(CardViewDelegate paramCardViewDelegate);
  
  void initStatic();
  
  void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3);
  
  void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate);
  
  void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate);
  
  void setBackgroundColor(CardViewDelegate paramCardViewDelegate, ColorStateList paramColorStateList);
  
  void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat);
  
  void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat);
  
  void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat);
  
  void updatePadding(CardViewDelegate paramCardViewDelegate);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cardview\widget\CardViewImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */