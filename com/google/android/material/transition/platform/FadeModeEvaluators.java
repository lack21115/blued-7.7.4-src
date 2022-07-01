package com.google.android.material.transition.platform;

class FadeModeEvaluators {
  private static final FadeModeEvaluator a = new FadeModeEvaluator() {
      public FadeModeResult a(float param1Float1, float param1Float2, float param1Float3) {
        return FadeModeResult.b(255, TransitionUtils.a(0, 255, param1Float2, param1Float3, param1Float1));
      }
    };
  
  private static final FadeModeEvaluator b = new FadeModeEvaluator() {
      public FadeModeResult a(float param1Float1, float param1Float2, float param1Float3) {
        return FadeModeResult.a(TransitionUtils.a(255, 0, param1Float2, param1Float3, param1Float1), 255);
      }
    };
  
  private static final FadeModeEvaluator c = new FadeModeEvaluator() {
      public FadeModeResult a(float param1Float1, float param1Float2, float param1Float3) {
        return FadeModeResult.a(TransitionUtils.a(255, 0, param1Float2, param1Float3, param1Float1), TransitionUtils.a(0, 255, param1Float2, param1Float3, param1Float1));
      }
    };
  
  private static final FadeModeEvaluator d = new FadeModeEvaluator() {
      public FadeModeResult a(float param1Float1, float param1Float2, float param1Float3) {
        float f = (param1Float3 - param1Float2) * 0.35F + param1Float2;
        return FadeModeResult.a(TransitionUtils.a(255, 0, param1Float2, f, param1Float1), TransitionUtils.a(0, 255, f, param1Float3, param1Float1));
      }
    };
  
  static FadeModeEvaluator a(int paramInt, boolean paramBoolean) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3)
            return d; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid fade mode: ");
          stringBuilder.append(paramInt);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        return c;
      } 
      return paramBoolean ? b : a;
    } 
    return paramBoolean ? a : b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\FadeModeEvaluators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */