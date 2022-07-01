package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

final class zaj extends Drawable.ConstantState {
  int zaa;
  
  int zab;
  
  zaj(zaj paramzaj) {
    if (paramzaj != null) {
      this.zaa = paramzaj.zaa;
      this.zab = paramzaj.zab;
    } 
  }
  
  public final int getChangingConfigurations() {
    return this.zaa;
  }
  
  public final Drawable newDrawable() {
    return new zaf(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\base\zaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */