package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R;

public class TextAppearance {
  public final float a;
  
  public final ColorStateList b;
  
  public final ColorStateList c;
  
  public final ColorStateList d;
  
  public final int e;
  
  public final int f;
  
  public final String g;
  
  public final boolean h;
  
  public final ColorStateList i;
  
  public final float j;
  
  public final float k;
  
  public final float l;
  
  private final int m;
  
  private boolean n = false;
  
  private Typeface o;
  
  public TextAppearance(Context paramContext, int paramInt) {
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
    this.a = typedArray.getDimension(R.styleable.TextAppearance_android_textSize, 0.0F);
    this.b = MaterialResources.a(paramContext, typedArray, R.styleable.TextAppearance_android_textColor);
    this.c = MaterialResources.a(paramContext, typedArray, R.styleable.TextAppearance_android_textColorHint);
    this.d = MaterialResources.a(paramContext, typedArray, R.styleable.TextAppearance_android_textColorLink);
    this.e = typedArray.getInt(R.styleable.TextAppearance_android_textStyle, 0);
    this.f = typedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
    paramInt = MaterialResources.a(typedArray, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
    this.m = typedArray.getResourceId(paramInt, 0);
    this.g = typedArray.getString(paramInt);
    this.h = typedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
    this.i = MaterialResources.a(paramContext, typedArray, R.styleable.TextAppearance_android_shadowColor);
    this.j = typedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    this.k = typedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    this.l = typedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    typedArray.recycle();
  }
  
  private void b() {
    if (this.o == null) {
      String str = this.g;
      if (str != null)
        this.o = Typeface.create(str, this.e); 
    } 
    if (this.o == null) {
      int i = this.f;
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            this.o = Typeface.DEFAULT;
          } else {
            this.o = Typeface.MONOSPACE;
          } 
        } else {
          this.o = Typeface.SERIF;
        } 
      } else {
        this.o = Typeface.SANS_SERIF;
      } 
      this.o = Typeface.create(this.o, this.e);
    } 
  }
  
  public Typeface a() {
    b();
    return this.o;
  }
  
  public Typeface a(Context paramContext) {
    if (this.n)
      return this.o; 
    if (!paramContext.isRestricted())
      try {
        this.o = ResourcesCompat.getFont(paramContext, this.m);
        if (this.o != null)
          this.o = Typeface.create(this.o, this.e); 
      } catch (UnsupportedOperationException|android.content.res.Resources.NotFoundException unsupportedOperationException) {
      
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error loading font ");
        stringBuilder.append(this.g);
        Log.d("TextAppearance", stringBuilder.toString(), exception);
      }  
    b();
    this.n = true;
    return this.o;
  }
  
  public void a(Context paramContext, TextPaint paramTextPaint, TextAppearanceFontCallback paramTextAppearanceFontCallback) {
    a(paramTextPaint, a());
    a(paramContext, new TextAppearanceFontCallback(this, paramTextPaint, paramTextAppearanceFontCallback) {
          public void a(int param1Int) {
            this.b.a(param1Int);
          }
          
          public void a(Typeface param1Typeface, boolean param1Boolean) {
            this.c.a(this.a, param1Typeface);
            this.b.a(param1Typeface, param1Boolean);
          }
        });
  }
  
  public void a(Context paramContext, TextAppearanceFontCallback paramTextAppearanceFontCallback) {
    if (TextAppearanceConfig.a()) {
      a(paramContext);
    } else {
      b();
    } 
    if (this.m == 0)
      this.n = true; 
    if (this.n) {
      paramTextAppearanceFontCallback.a(this.o, true);
      return;
    } 
    try {
      ResourcesCompat.getFont(paramContext, this.m, new ResourcesCompat.FontCallback(this, paramTextAppearanceFontCallback) {
            public void onFontRetrievalFailed(int param1Int) {
              TextAppearance.a(this.b, true);
              this.a.a(param1Int);
            }
            
            public void onFontRetrieved(Typeface param1Typeface) {
              TextAppearance textAppearance = this.b;
              TextAppearance.a(textAppearance, Typeface.create(param1Typeface, textAppearance.e));
              TextAppearance.a(this.b, true);
              this.a.a(TextAppearance.a(this.b), false);
            }
          }null);
      return;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      this.n = true;
      paramTextAppearanceFontCallback.a(1);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Error loading font ");
      stringBuilder.append(this.g);
      Log.d("TextAppearance", stringBuilder.toString(), exception);
      this.n = true;
      paramTextAppearanceFontCallback.a(-3);
      return;
    } 
  }
  
  public void a(TextPaint paramTextPaint, Typeface paramTypeface) {
    float f;
    boolean bool;
    paramTextPaint.setTypeface(paramTypeface);
    int i = this.e;
    i = paramTypeface.getStyle() & i;
    if ((i & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    paramTextPaint.setFakeBoldText(bool);
    if ((i & 0x2) != 0) {
      f = -0.25F;
    } else {
      f = 0.0F;
    } 
    paramTextPaint.setTextSkewX(f);
    paramTextPaint.setTextSize(this.a);
  }
  
  public void b(Context paramContext, TextPaint paramTextPaint, TextAppearanceFontCallback paramTextAppearanceFontCallback) {
    int i;
    c(paramContext, paramTextPaint, paramTextAppearanceFontCallback);
    ColorStateList colorStateList = this.b;
    if (colorStateList != null) {
      i = colorStateList.getColorForState(paramTextPaint.drawableState, this.b.getDefaultColor());
    } else {
      i = -16777216;
    } 
    paramTextPaint.setColor(i);
    float f1 = this.l;
    float f2 = this.j;
    float f3 = this.k;
    colorStateList = this.i;
    if (colorStateList != null) {
      i = colorStateList.getColorForState(paramTextPaint.drawableState, this.i.getDefaultColor());
    } else {
      i = 0;
    } 
    paramTextPaint.setShadowLayer(f1, f2, f3, i);
  }
  
  public void c(Context paramContext, TextPaint paramTextPaint, TextAppearanceFontCallback paramTextAppearanceFontCallback) {
    if (TextAppearanceConfig.a()) {
      a(paramTextPaint, a(paramContext));
      return;
    } 
    a(paramContext, paramTextPaint, paramTextAppearanceFontCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\resources\TextAppearance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */