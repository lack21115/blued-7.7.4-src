package com.amap.api.maps2d.model;

import android.graphics.Typeface;
import com.amap.api.interfaces.IText;
import com.amap.api.mapcore2d.aj;

public final class Text {
  public static final int ALIGN_BOTTOM = 5;
  
  public static final int ALIGN_CENTER_HORIZONTAL = 3;
  
  public static final int ALIGN_CENTER_VERTICAL = 6;
  
  public static final int ALIGN_LEFT = 1;
  
  public static final int ALIGN_RIGHT = 2;
  
  public static final int ALIGN_TOP = 4;
  
  private IText a;
  
  public Text(aj paramaj) {
    this.a = (IText)paramaj;
  }
  
  public int getAlignX() {
    return this.a.getAlignX();
  }
  
  public int getAlignY() {
    return this.a.getAlignY();
  }
  
  public int getBackgroundColor() {
    return this.a.getBackgroundColor();
  }
  
  public int getFontColor() {
    return this.a.getFonrColor();
  }
  
  public int getFontSize() {
    return this.a.getFontSize();
  }
  
  public Object getObject() {
    return this.a.getObject();
  }
  
  public LatLng getPosition() {
    return this.a.getPosition();
  }
  
  public float getRotate() {
    return this.a.getRotate();
  }
  
  public String getText() {
    return this.a.getText();
  }
  
  public Typeface getTypeface() {
    return this.a.getTypeface();
  }
  
  public float getZIndex() {
    return this.a.getZIndex();
  }
  
  public boolean isVisible() {
    return this.a.isVisible();
  }
  
  public void remove() {
    this.a.remove();
  }
  
  public void setAlign(int paramInt1, int paramInt2) {
    this.a.setAlign(paramInt1, paramInt2);
  }
  
  public void setBackgroundColor(int paramInt) {
    this.a.setBackgroundColor(paramInt);
  }
  
  public void setFontColor(int paramInt) {
    this.a.setFontColor(paramInt);
  }
  
  public void setFontSize(int paramInt) {
    this.a.setFontSize(paramInt);
  }
  
  public void setObject(Object paramObject) {
    this.a.setObject(paramObject);
  }
  
  public void setPosition(LatLng paramLatLng) {
    this.a.setPosition(paramLatLng);
  }
  
  public void setRotate(float paramFloat) {
    this.a.setRotate(paramFloat);
  }
  
  public void setText(String paramString) {
    this.a.setText(paramString);
  }
  
  public void setTypeface(Typeface paramTypeface) {
    this.a.setTypeface(paramTypeface);
  }
  
  public void setVisible(boolean paramBoolean) {
    this.a.setVisible(paramBoolean);
  }
  
  public void setZIndex(float paramFloat) {
    this.a.setZIndex(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\Text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */