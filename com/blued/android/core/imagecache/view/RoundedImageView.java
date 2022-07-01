package com.blued.android.core.imagecache.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.drawable.RoundedDrawable;
import com.blued.android.core.utils.Log;
import com.blued.blued_core.R;

public class RoundedImageView extends AutoAttachRecyclingImageView {
  private static final ImageView.ScaleType[] o = new ImageView.ScaleType[] { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  
  private int h;
  
  private int i;
  
  private int j;
  
  private boolean k;
  
  private Drawable l;
  
  private Drawable m;
  
  private ImageView.ScaleType n;
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView, paramInt, 0);
    paramInt = typedArray.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
    if (paramInt >= 0)
      setScaleType(o[paramInt]); 
    this.h = typedArray.getDimensionPixelSize(R.styleable.RoundedImageView_corner_radius, -1);
    this.i = typedArray.getDimensionPixelSize(R.styleable.RoundedImageView_border_width, -1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" mcor ");
    stringBuilder.append(this.h);
    Log.b("jason", stringBuilder.toString());
    if (this.h < 0)
      this.h = 0; 
    if (this.i < 0)
      this.i = 0; 
    this.j = typedArray.getColor(R.styleable.RoundedImageView_border_color, -16777216);
    this.k = typedArray.getBoolean(R.styleable.RoundedImageView_round_background, false);
    typedArray.recycle();
  }
  
  public int getBorder() {
    return this.i;
  }
  
  public int getBorderColor() {
    return this.j;
  }
  
  public int getCornerRadius() {
    return this.h;
  }
  
  public ImageView.ScaleType getScaleType() {
    return this.n;
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable) {
    if (this.k && paramDrawable != null) {
      this.m = RoundedDrawable.a(paramDrawable, this.n, this.h, this.i, this.j);
    } else {
      this.m = paramDrawable;
    } 
    super.setBackgroundDrawable(this.m);
  }
  
  public void setBorderColor(int paramInt) {
    if (this.j == paramInt)
      return; 
    this.j = paramInt;
    Drawable drawable = this.l;
    if (drawable instanceof RoundedDrawable)
      ((RoundedDrawable)drawable).b(paramInt); 
    if (this.k) {
      drawable = this.m;
      if (drawable instanceof RoundedDrawable)
        ((RoundedDrawable)drawable).b(paramInt); 
    } 
    if (this.i > 0)
      invalidate(); 
  }
  
  public void setBorderWidth(int paramInt) {
    if (this.i == paramInt)
      return; 
    this.i = paramInt;
    Drawable drawable = this.l;
    if (drawable instanceof RoundedDrawable)
      ((RoundedDrawable)drawable).a(paramInt); 
    if (this.k) {
      drawable = this.m;
      if (drawable instanceof RoundedDrawable)
        ((RoundedDrawable)drawable).a(paramInt); 
    } 
    invalidate();
  }
  
  public void setCornerRadius(int paramInt) {
    if (this.h == paramInt)
      return; 
    this.h = paramInt;
    Drawable drawable = this.l;
    if (drawable instanceof RoundedDrawable)
      ((RoundedDrawable)drawable).a(paramInt); 
    if (this.k) {
      drawable = this.m;
      if (drawable instanceof RoundedDrawable)
        ((RoundedDrawable)drawable).a(paramInt); 
    } 
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    if (paramBitmap != null) {
      this.l = (Drawable)new RoundedDrawable(paramBitmap, this.h, this.i, this.j);
      ImageView.ScaleType scaleType = this.n;
      if (scaleType != null)
        ((RoundedDrawable)this.l).a(scaleType); 
    } else {
      this.l = null;
    } 
    super.setImageDrawable(this.l);
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    if (paramDrawable != null) {
      this.l = RoundedDrawable.a(paramDrawable, this.n, this.h, this.i, this.j);
      if (paramDrawable instanceof IRecyclingDrawable) {
        Drawable drawable = this.l;
        if (drawable instanceof IRecyclingDrawable && paramDrawable != drawable)
          ((IRecyclingDrawable)drawable).a(((IRecyclingDrawable)paramDrawable).b()); 
      } 
    } else {
      this.l = null;
    } 
    super.setImageDrawable(this.l);
  }
  
  public void setRoundBackground(boolean paramBoolean) {
    if (this.k == paramBoolean)
      return; 
    this.k = paramBoolean;
    if (paramBoolean) {
      Drawable drawable = this.m;
      if (drawable instanceof RoundedDrawable) {
        ((RoundedDrawable)drawable).a(this.n);
        ((RoundedDrawable)this.m).a(this.h);
        ((RoundedDrawable)this.m).a(this.i);
        ((RoundedDrawable)this.m).b(this.j);
      } else {
        setBackgroundDrawable(drawable);
      } 
    } else {
      Drawable drawable = this.m;
      if (drawable instanceof RoundedDrawable) {
        ((RoundedDrawable)drawable).a(0);
        ((RoundedDrawable)this.m).a(0.0F);
      } 
    } 
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType) {
    if (paramScaleType != null) {
      if (this.n != paramScaleType) {
        this.n = paramScaleType;
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
        Drawable drawable = this.l;
        if (drawable instanceof RoundedDrawable && ((RoundedDrawable)drawable).f() != paramScaleType)
          ((RoundedDrawable)this.l).a(paramScaleType); 
        drawable = this.m;
        if (drawable instanceof RoundedDrawable && ((RoundedDrawable)drawable).f() != paramScaleType)
          ((RoundedDrawable)this.m).a(paramScaleType); 
        setWillNotCacheDrawing(true);
        requestLayout();
        invalidate();
      } 
      return;
    } 
    throw new NullPointerException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\view\RoundedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */