package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ViewOverlayApi18 implements ViewOverlayImpl {
  private final ViewOverlay a;
  
  ViewOverlayApi18(View paramView) {
    this.a = paramView.getOverlay();
  }
  
  public void a(Drawable paramDrawable) {
    this.a.add(paramDrawable);
  }
  
  public void b(Drawable paramDrawable) {
    this.a.remove(paramDrawable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ViewOverlayApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */