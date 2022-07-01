package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

public class Mask {
  private final MaskMode a;
  
  private final AnimatableShapeValue b;
  
  private final AnimatableIntegerValue c;
  
  private final boolean d;
  
  public Mask(MaskMode paramMaskMode, AnimatableShapeValue paramAnimatableShapeValue, AnimatableIntegerValue paramAnimatableIntegerValue, boolean paramBoolean) {
    this.a = paramMaskMode;
    this.b = paramAnimatableShapeValue;
    this.c = paramAnimatableIntegerValue;
    this.d = paramBoolean;
  }
  
  public MaskMode a() {
    return this.a;
  }
  
  public AnimatableShapeValue b() {
    return this.b;
  }
  
  public AnimatableIntegerValue c() {
    return this.c;
  }
  
  public boolean d() {
    return this.d;
  }
  
  public enum MaskMode {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\content\Mask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */