package com.amap.api.interfaces;

import android.graphics.Canvas;
import android.graphics.Typeface;
import com.amap.api.maps2d.model.LatLng;

public interface IText {
  void draw(Canvas paramCanvas);
  
  int getAddIndex();
  
  int getAlignX();
  
  int getAlignY();
  
  int getBackgroundColor();
  
  int getFonrColor();
  
  int getFontSize();
  
  Object getObject();
  
  LatLng getPosition();
  
  float getRotate();
  
  String getText();
  
  Typeface getTypeface();
  
  float getZIndex();
  
  boolean isVisible();
  
  void remove();
  
  void setAddIndex(int paramInt);
  
  void setAlign(int paramInt1, int paramInt2);
  
  void setBackgroundColor(int paramInt);
  
  void setFontColor(int paramInt);
  
  void setFontSize(int paramInt);
  
  void setObject(Object paramObject);
  
  void setPosition(LatLng paramLatLng);
  
  void setRotate(float paramFloat);
  
  void setText(String paramString);
  
  void setTypeface(Typeface paramTypeface);
  
  void setVisible(boolean paramBoolean);
  
  void setZIndex(float paramFloat);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */