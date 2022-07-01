package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public final class zaf extends Drawable implements Drawable.Callback {
  private int zaa = 0;
  
  private long zab;
  
  private int zac;
  
  private int zad;
  
  private int zae = 255;
  
  private int zaf;
  
  private int zag = 0;
  
  private boolean zah = true;
  
  private boolean zai;
  
  private zaj zaj;
  
  private Drawable zak;
  
  private Drawable zal;
  
  private boolean zam;
  
  private boolean zan;
  
  private boolean zao;
  
  private int zap;
  
  public zaf(Drawable paramDrawable1, Drawable paramDrawable2) {
    this((zaj)null);
    Drawable drawable2 = paramDrawable1;
    if (paramDrawable1 == null)
      drawable2 = zah.zaa(); 
    this.zak = drawable2;
    drawable2.setCallback(this);
    zaj zaj1 = this.zaj;
    int i = zaj1.zab;
    zaj1.zab = drawable2.getChangingConfigurations() | i;
    Drawable drawable1 = paramDrawable2;
    if (paramDrawable2 == null)
      drawable1 = zah.zaa(); 
    this.zal = drawable1;
    drawable1.setCallback(this);
    zaj zaj2 = this.zaj;
    i = zaj2.zab;
    zaj2.zab = drawable1.getChangingConfigurations() | i;
  }
  
  zaf(zaj paramzaj) {
    this.zaj = new zaj(paramzaj);
  }
  
  private final boolean zab() {
    if (!this.zam) {
      boolean bool;
      if (this.zak.getConstantState() != null && this.zal.getConstantState() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.zan = bool;
      this.zam = true;
    } 
    return this.zan;
  }
  
  public final void draw(Canvas paramCanvas) {
    int k = this.zaa;
    int i = 1;
    int j = 1;
    if (k != 1) {
      if (k == 2 && this.zab >= 0L) {
        float f = (float)(SystemClock.uptimeMillis() - this.zab) / this.zaf;
        if (f >= 1.0F) {
          i = j;
        } else {
          i = 0;
        } 
        if (i)
          this.zaa = 0; 
        f = Math.min(f, 1.0F);
        this.zag = (int)(this.zad * f + 0.0F);
      } 
    } else {
      this.zab = SystemClock.uptimeMillis();
      this.zaa = 2;
      i = 0;
    } 
    j = this.zag;
    boolean bool = this.zah;
    Drawable drawable1 = this.zak;
    Drawable drawable2 = this.zal;
    if (i != 0) {
      if (!bool || j == 0)
        drawable1.draw(paramCanvas); 
      i = this.zae;
      if (j == i) {
        drawable2.setAlpha(i);
        drawable2.draw(paramCanvas);
      } 
      return;
    } 
    if (bool)
      drawable1.setAlpha(this.zae - j); 
    drawable1.draw(paramCanvas);
    if (bool)
      drawable1.setAlpha(this.zae); 
    if (j > 0) {
      drawable2.setAlpha(j);
      drawable2.draw(paramCanvas);
      drawable2.setAlpha(this.zae);
    } 
    invalidateSelf();
  }
  
  public final int getChangingConfigurations() {
    return super.getChangingConfigurations() | this.zaj.zaa | this.zaj.zab;
  }
  
  public final Drawable.ConstantState getConstantState() {
    if (zab()) {
      this.zaj.zaa = getChangingConfigurations();
      return this.zaj;
    } 
    return null;
  }
  
  public final int getIntrinsicHeight() {
    return Math.max(this.zak.getIntrinsicHeight(), this.zal.getIntrinsicHeight());
  }
  
  public final int getIntrinsicWidth() {
    return Math.max(this.zak.getIntrinsicWidth(), this.zal.getIntrinsicWidth());
  }
  
  public final int getOpacity() {
    if (!this.zao) {
      this.zap = Drawable.resolveOpacity(this.zak.getOpacity(), this.zal.getOpacity());
      this.zao = true;
    } 
    return this.zap;
  }
  
  public final void invalidateDrawable(Drawable paramDrawable) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.invalidateDrawable(this); 
  }
  
  public final Drawable mutate() {
    if (!this.zai && super.mutate() == this) {
      if (zab()) {
        this.zak.mutate();
        this.zal.mutate();
        this.zai = true;
        return this;
      } 
      throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
    } 
    return this;
  }
  
  protected final void onBoundsChange(Rect paramRect) {
    this.zak.setBounds(paramRect);
    this.zal.setBounds(paramRect);
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.scheduleDrawable(this, paramRunnable, paramLong); 
  }
  
  public final void setAlpha(int paramInt) {
    if (this.zag == this.zae)
      this.zag = paramInt; 
    this.zae = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {
    this.zak.setColorFilter(paramColorFilter);
    this.zal.setColorFilter(paramColorFilter);
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.unscheduleDrawable(this, paramRunnable); 
  }
  
  public final Drawable zaa() {
    return this.zal;
  }
  
  public final void zaa(int paramInt) {
    this.zac = 0;
    this.zad = this.zae;
    this.zag = 0;
    this.zaf = 250;
    this.zaa = 1;
    invalidateSelf();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\base\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */