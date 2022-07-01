package com.amap.api.mapcore2d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.TextOptions;

public class bp implements aj {
  private b a;
  
  private at b;
  
  private String c;
  
  private int d;
  
  private int e;
  
  private LatLng f;
  
  private float g;
  
  private int h;
  
  private Typeface i;
  
  private boolean j;
  
  private float k;
  
  private int l;
  
  private int m;
  
  private Object n;
  
  private int o;
  
  public bp(y paramy, TextOptions paramTextOptions, at paramat) {
    this.b = paramat;
    this.c = paramTextOptions.getText();
    this.d = paramTextOptions.getFontSize();
    this.e = paramTextOptions.getFontColor();
    this.f = paramTextOptions.getPosition();
    this.g = paramTextOptions.getRotate();
    this.h = paramTextOptions.getBackgroundColor();
    this.i = paramTextOptions.getTypeface();
    this.j = paramTextOptions.isVisible();
    this.k = paramTextOptions.getZIndex();
    this.l = paramTextOptions.getAlignX();
    this.m = paramTextOptions.getAlignY();
    this.n = paramTextOptions.getObject();
    this.a = (b)paramy;
  }
  
  public void draw(Canvas paramCanvas) {
    float f2;
    int i;
    int j;
    TextPaint textPaint;
    Paint.FontMetrics fontMetrics;
    if (!TextUtils.isEmpty(this.c)) {
      if (this.f == null)
        return; 
      textPaint = new TextPaint();
      if (this.i == null)
        this.i = Typeface.DEFAULT; 
      textPaint.setTypeface(this.i);
      textPaint.setAntiAlias(true);
      textPaint.setTextSize(this.d);
      f2 = textPaint.measureText(this.c);
      f3 = this.d;
      textPaint.setColor(this.h);
      w w = new w((int)(this.f.latitude * 1000000.0D), (int)(this.f.longitude * 1000000.0D));
      Point point = new Point();
      this.a.d().a(w, point);
      paramCanvas.save();
      paramCanvas.rotate(-(this.g % 360.0F), point.x, point.y);
      fontMetrics = textPaint.getFontMetrics();
      i = this.l;
      if (i < 1 || i > 3)
        this.l = 3; 
      i = this.m;
      if (i < 4 || i > 6)
        this.m = 6; 
      i = this.l;
      j = 0;
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            i = 0;
          } else {
            float f = point.x - f2 / 2.0F;
            i = (int)f;
          } 
        } else {
          float f = point.x - f2;
          i = (int)f;
        } 
      } else {
        i = point.x;
      } 
      int k = this.m;
      if (k != 4) {
        float f;
        if (k != 5) {
          if (k != 6) {
            float f6 = (i - 1);
            float f7 = (j - 1);
            float f8 = i;
            f3 = j + f3 + 2.0F;
            paramCanvas.drawRect(f6, f7, f8 + f2 + 2.0F, f3, (Paint)textPaint);
            textPaint.setColor(this.e);
            paramCanvas.drawText(this.c, f8, f3 - fontMetrics.bottom, (Paint)textPaint);
            paramCanvas.restore();
            return;
          } 
          f = point.y - f3 / 2.0F;
        } else {
          f = point.y - f3;
        } 
        j = (int)f;
      } else {
        j = point.y;
      } 
    } else {
      return;
    } 
    float f1 = (i - 1);
    float f4 = (j - 1);
    float f5 = i;
    float f3 = j + f3 + 2.0F;
    paramCanvas.drawRect(f1, f4, f5 + f2 + 2.0F, f3, (Paint)textPaint);
    textPaint.setColor(this.e);
    paramCanvas.drawText(this.c, f5, f3 - fontMetrics.bottom, (Paint)textPaint);
    paramCanvas.restore();
  }
  
  public int getAddIndex() {
    return this.o;
  }
  
  public int getAlignX() {
    return this.l;
  }
  
  public int getAlignY() {
    return this.m;
  }
  
  public int getBackgroundColor() {
    return this.h;
  }
  
  public int getFonrColor() {
    return this.e;
  }
  
  public int getFontSize() {
    return this.d;
  }
  
  public Object getObject() {
    return this.n;
  }
  
  public LatLng getPosition() {
    return this.f;
  }
  
  public float getRotate() {
    return this.g;
  }
  
  public String getText() {
    return this.c;
  }
  
  public Typeface getTypeface() {
    return this.i;
  }
  
  public float getZIndex() {
    return this.k;
  }
  
  public boolean isVisible() {
    return this.j;
  }
  
  public void remove() {
    at at1 = this.b;
    if (at1 != null)
      at1.b(this); 
  }
  
  public void setAddIndex(int paramInt) {
    this.o = paramInt;
  }
  
  public void setAlign(int paramInt1, int paramInt2) {
    this.l = paramInt1;
    this.m = paramInt2;
    this.a.postInvalidate();
  }
  
  public void setBackgroundColor(int paramInt) {
    this.h = paramInt;
    this.a.postInvalidate();
  }
  
  public void setFontColor(int paramInt) {
    this.e = paramInt;
    this.a.postInvalidate();
  }
  
  public void setFontSize(int paramInt) {
    this.d = paramInt;
    this.a.postInvalidate();
  }
  
  public void setObject(Object paramObject) {
    this.n = paramObject;
  }
  
  public void setPosition(LatLng paramLatLng) {
    this.f = paramLatLng;
    this.a.postInvalidate();
  }
  
  public void setRotate(float paramFloat) {
    this.g = paramFloat;
    this.a.postInvalidate();
  }
  
  public void setText(String paramString) {
    this.c = paramString;
    this.a.postInvalidate();
  }
  
  public void setTypeface(Typeface paramTypeface) {
    this.i = paramTypeface;
    this.a.postInvalidate();
  }
  
  public void setVisible(boolean paramBoolean) {
    this.j = paramBoolean;
    this.a.postInvalidate();
  }
  
  public void setZIndex(float paramFloat) {
    this.k = paramFloat;
    this.b.d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */