package com.google.android.material.transition;

import android.graphics.RectF;

class FitModeEvaluators {
  private static final FitModeEvaluator a = new FitModeEvaluator() {
      public FitModeResult a(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7) {
        param1Float1 = TransitionUtils.a(param1Float4, param1Float6, param1Float2, param1Float3, param1Float1);
        param1Float2 = param1Float1 / param1Float4;
        param1Float3 = param1Float1 / param1Float6;
        return new FitModeResult(param1Float2, param1Float3, param1Float1, param1Float5 * param1Float2, param1Float1, param1Float7 * param1Float3);
      }
      
      public void a(RectF param1RectF, float param1Float, FitModeResult param1FitModeResult) {
        float f = Math.abs(param1FitModeResult.f - param1FitModeResult.d);
        param1RectF.bottom -= f * param1Float;
      }
      
      public boolean a(FitModeResult param1FitModeResult) {
        return (param1FitModeResult.d > param1FitModeResult.f);
      }
    };
  
  private static final FitModeEvaluator b = new FitModeEvaluator() {
      public FitModeResult a(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7) {
        param1Float1 = TransitionUtils.a(param1Float5, param1Float7, param1Float2, param1Float3, param1Float1);
        param1Float2 = param1Float1 / param1Float5;
        param1Float3 = param1Float1 / param1Float7;
        return new FitModeResult(param1Float2, param1Float3, param1Float4 * param1Float2, param1Float1, param1Float6 * param1Float3, param1Float1);
      }
      
      public void a(RectF param1RectF, float param1Float, FitModeResult param1FitModeResult) {
        float f2 = Math.abs(param1FitModeResult.e - param1FitModeResult.c);
        float f1 = param1RectF.left;
        param1Float = f2 / 2.0F * param1Float;
        param1RectF.left = f1 + param1Float;
        param1RectF.right -= param1Float;
      }
      
      public boolean a(FitModeResult param1FitModeResult) {
        return (param1FitModeResult.c > param1FitModeResult.e);
      }
    };
  
  static FitModeEvaluator a(int paramInt, boolean paramBoolean, RectF paramRectF1, RectF paramRectF2) {
    StringBuilder stringBuilder;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2)
          return b; 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid fit mode: ");
        stringBuilder.append(paramInt);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return a;
    } 
    return a(paramBoolean, (RectF)stringBuilder, paramRectF2) ? a : b;
  }
  
  private static boolean a(boolean paramBoolean, RectF paramRectF1, RectF paramRectF2) {
    float f4 = paramRectF1.width();
    float f1 = paramRectF1.height();
    float f5 = paramRectF2.width();
    float f2 = paramRectF2.height();
    float f3 = f2 * f4 / f5;
    f4 = f5 * f1 / f4;
    if (paramBoolean) {
      if (f3 >= f1)
        return true; 
    } else if (f4 >= f2) {
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\FitModeEvaluators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */