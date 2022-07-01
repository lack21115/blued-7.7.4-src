package com.google.android.material.transition.platform;

class FadeModeResult {
  final int a;
  
  final int b;
  
  final boolean c;
  
  private FadeModeResult(int paramInt1, int paramInt2, boolean paramBoolean) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }
  
  static FadeModeResult a(int paramInt1, int paramInt2) {
    return new FadeModeResult(paramInt1, paramInt2, false);
  }
  
  static FadeModeResult b(int paramInt1, int paramInt2) {
    return new FadeModeResult(paramInt1, paramInt2, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\FadeModeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */