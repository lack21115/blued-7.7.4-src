package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.math.MathUtils;

public interface CircularRevealWidget extends CircularRevealHelper.Delegate {
  void a();
  
  void an_();
  
  int getCircularRevealScrimColor();
  
  RevealInfo getRevealInfo();
  
  void setCircularRevealOverlayDrawable(Drawable paramDrawable);
  
  void setCircularRevealScrimColor(int paramInt);
  
  void setRevealInfo(RevealInfo paramRevealInfo);
  
  public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
    public static final TypeEvaluator<CircularRevealWidget.RevealInfo> a = new CircularRevealEvaluator();
    
    private final CircularRevealWidget.RevealInfo b = new CircularRevealWidget.RevealInfo();
    
    public CircularRevealWidget.RevealInfo a(float param1Float, CircularRevealWidget.RevealInfo param1RevealInfo1, CircularRevealWidget.RevealInfo param1RevealInfo2) {
      this.b.a(MathUtils.a(param1RevealInfo1.a, param1RevealInfo2.a, param1Float), MathUtils.a(param1RevealInfo1.b, param1RevealInfo2.b, param1Float), MathUtils.a(param1RevealInfo1.c, param1RevealInfo2.c, param1Float));
      return this.b;
    }
  }
  
  public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
    public static final Property<CircularRevealWidget, CircularRevealWidget.RevealInfo> a = new CircularRevealProperty("circularReveal");
    
    private CircularRevealProperty(String param1String) {
      super(CircularRevealWidget.RevealInfo.class, param1String);
    }
    
    public CircularRevealWidget.RevealInfo a(CircularRevealWidget param1CircularRevealWidget) {
      return param1CircularRevealWidget.getRevealInfo();
    }
    
    public void a(CircularRevealWidget param1CircularRevealWidget, CircularRevealWidget.RevealInfo param1RevealInfo) {
      param1CircularRevealWidget.setRevealInfo(param1RevealInfo);
    }
  }
  
  public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
    public static final Property<CircularRevealWidget, Integer> a = new CircularRevealScrimColorProperty("circularRevealScrimColor");
    
    private CircularRevealScrimColorProperty(String param1String) {
      super(Integer.class, param1String);
    }
    
    public Integer a(CircularRevealWidget param1CircularRevealWidget) {
      return Integer.valueOf(param1CircularRevealWidget.getCircularRevealScrimColor());
    }
    
    public void a(CircularRevealWidget param1CircularRevealWidget, Integer param1Integer) {
      param1CircularRevealWidget.setCircularRevealScrimColor(param1Integer.intValue());
    }
  }
  
  public static class RevealInfo {
    public float a;
    
    public float b;
    
    public float c;
    
    private RevealInfo() {}
    
    public RevealInfo(float param1Float1, float param1Float2, float param1Float3) {
      this.a = param1Float1;
      this.b = param1Float2;
      this.c = param1Float3;
    }
    
    public RevealInfo(RevealInfo param1RevealInfo) {
      this(param1RevealInfo.a, param1RevealInfo.b, param1RevealInfo.c);
    }
    
    public void a(float param1Float1, float param1Float2, float param1Float3) {
      this.a = param1Float1;
      this.b = param1Float2;
      this.c = param1Float3;
    }
    
    public void a(RevealInfo param1RevealInfo) {
      a(param1RevealInfo.a, param1RevealInfo.b, param1RevealInfo.c);
    }
    
    public boolean a() {
      return (this.c == Float.MAX_VALUE);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\circularreveal\CircularRevealWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */