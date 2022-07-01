package com.google.android.material.resources;

import android.graphics.Typeface;

public final class CancelableFontCallback extends TextAppearanceFontCallback {
  private final Typeface a;
  
  private final ApplyFont b;
  
  private boolean c;
  
  public CancelableFontCallback(ApplyFont paramApplyFont, Typeface paramTypeface) {
    this.a = paramTypeface;
    this.b = paramApplyFont;
  }
  
  private void a(Typeface paramTypeface) {
    if (!this.c)
      this.b.a(paramTypeface); 
  }
  
  public void a() {
    this.c = true;
  }
  
  public void a(int paramInt) {
    a(this.a);
  }
  
  public void a(Typeface paramTypeface, boolean paramBoolean) {
    a(paramTypeface);
  }
  
  public static interface ApplyFont {
    void a(Typeface param1Typeface);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\resources\CancelableFontCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */