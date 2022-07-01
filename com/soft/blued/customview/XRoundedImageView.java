package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.soft.blued.R;
import com.soft.blued.customview.drawable.XRoundedDrawable;

public class XRoundedImageView extends AppCompatImageView {
  private static final ImageView.ScaleType[] k = new ImageView.ScaleType[] { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  
  private int a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private boolean g;
  
  private Drawable h;
  
  private Drawable i;
  
  private ImageView.ScaleType j;
  
  public XRoundedImageView(Context paramContext) {
    super(paramContext);
    this.e = 0;
    this.f = -16777216;
  }
  
  public XRoundedImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public XRoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.XRoundedImageView, paramInt, 0);
    paramInt = typedArray.getInt(0, -1);
    if (paramInt >= 0)
      setScaleType(k[paramInt]); 
    paramInt = typedArray.getDimensionPixelSize(3, 0);
    if (paramInt > 0) {
      this.a = paramInt;
      this.b = paramInt;
      this.c = paramInt;
      this.d = paramInt;
    } 
    this.a = typedArray.getDimensionPixelSize(5, paramInt);
    this.b = typedArray.getDimensionPixelSize(4, paramInt);
    this.c = typedArray.getDimensionPixelSize(7, paramInt);
    this.d = typedArray.getDimensionPixelSize(6, paramInt);
    this.e = typedArray.getDimensionPixelSize(2, 0);
    boolean bool = true;
    this.f = typedArray.getColor(1, -16777216);
    typedArray.recycle();
    if (this.a + this.b + this.c + this.d <= 0)
      bool = false; 
    this.g = bool;
  }
  
  public int getBorder() {
    return this.e;
  }
  
  public int getBorderColor() {
    return this.f;
  }
  
  public ImageView.ScaleType getScaleType() {
    return this.j;
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable) {
    if (this.g && paramDrawable != null) {
      this.i = XRoundedDrawable.a(paramDrawable, this.j, this.e, this.f, this.a, this.b, this.c, this.d);
    } else {
      this.i = paramDrawable;
    } 
    super.setBackgroundDrawable(this.i);
  }
  
  public void setBorderColor(int paramInt) {
    if (this.f == paramInt)
      return; 
    this.f = paramInt;
    Drawable drawable = this.h;
    if (drawable instanceof XRoundedDrawable)
      ((XRoundedDrawable)drawable).b(paramInt); 
    if (this.g) {
      drawable = this.i;
      if (drawable instanceof XRoundedDrawable)
        ((XRoundedDrawable)drawable).b(paramInt); 
    } 
    if (this.e > 0)
      invalidate(); 
  }
  
  public void setBorderWidth(int paramInt) {
    if (this.e == paramInt)
      return; 
    this.e = paramInt;
    Drawable drawable = this.h;
    if (drawable instanceof XRoundedDrawable)
      ((XRoundedDrawable)drawable).a(paramInt); 
    if (this.g) {
      drawable = this.i;
      if (drawable instanceof XRoundedDrawable)
        ((XRoundedDrawable)drawable).a(paramInt); 
    } 
    invalidate();
  }
  
  public void setCornerRadius(int paramInt) {
    this.a = paramInt;
    this.b = paramInt;
    this.c = paramInt;
    this.d = paramInt;
    Drawable drawable = this.h;
    if (drawable instanceof XRoundedDrawable)
      ((XRoundedDrawable)drawable).c(paramInt); 
    if (this.g) {
      drawable = this.i;
      if (drawable instanceof XRoundedDrawable)
        ((XRoundedDrawable)drawable).c(paramInt); 
    } 
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    if (paramBitmap != null) {
      this.h = (Drawable)new XRoundedDrawable(paramBitmap, this.e, this.f, this.a, this.b, this.c, this.d);
      ImageView.ScaleType scaleType = this.j;
      if (scaleType != null)
        ((XRoundedDrawable)this.h).a(scaleType); 
    } else {
      this.h = null;
    } 
    super.setImageDrawable(this.h);
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    if (paramDrawable != null) {
      this.h = XRoundedDrawable.a(paramDrawable, this.j, this.e, this.f, this.a, this.b, this.c, this.d);
      if (paramDrawable instanceof IRecyclingDrawable) {
        Drawable drawable = this.h;
        if (drawable instanceof IRecyclingDrawable && paramDrawable != drawable)
          ((IRecyclingDrawable)drawable).a(((IRecyclingDrawable)paramDrawable).b()); 
      } 
    } else {
      this.h = null;
    } 
    super.setImageDrawable(this.h);
  }
  
  public void setRound(boolean paramBoolean) {
    if (this.g == paramBoolean)
      return; 
    this.g = paramBoolean;
    if (paramBoolean) {
      Drawable drawable = this.i;
      if (drawable instanceof XRoundedDrawable) {
        ((XRoundedDrawable)drawable).a(this.j);
        ((XRoundedDrawable)this.i).a(this.e);
        ((XRoundedDrawable)this.i).b(this.f);
        ((XRoundedDrawable)this.i).g(this.a);
        ((XRoundedDrawable)this.i).f(this.b);
        ((XRoundedDrawable)this.i).e(this.c);
        ((XRoundedDrawable)this.i).d(this.d);
      } else {
        setBackgroundDrawable(drawable);
      } 
    } else {
      Drawable drawable = this.i;
      if (drawable instanceof XRoundedDrawable) {
        ((XRoundedDrawable)drawable).a(0);
        ((XRoundedDrawable)this.i).c(0);
      } 
    } 
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType) {
    if (paramScaleType != null) {
      if (this.j != paramScaleType) {
        this.j = paramScaleType;
        switch (null.a[paramScaleType.ordinal()]) {
          default:
            super.setScaleType(paramScaleType);
            break;
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
            super.setScaleType(ImageView.ScaleType.FIT_XY);
            break;
        } 
        Drawable drawable = this.h;
        if (drawable instanceof XRoundedDrawable && ((XRoundedDrawable)drawable).f() != paramScaleType)
          ((XRoundedDrawable)this.h).a(paramScaleType); 
        drawable = this.i;
        if (drawable instanceof XRoundedDrawable && ((XRoundedDrawable)drawable).f() != paramScaleType)
          ((XRoundedDrawable)this.i).a(paramScaleType); 
        setWillNotCacheDrawing(true);
        requestLayout();
        invalidate();
      } 
      return;
    } 
    throw new NullPointerException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\XRoundedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */