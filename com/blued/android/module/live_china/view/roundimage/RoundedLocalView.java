package com.blued.android.module.live_china.view.roundimage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.module.live_china.R;

public class RoundedLocalView extends AppCompatImageView {
  public static final Shader.TileMode a;
  
  private static final ImageView.ScaleType[] c;
  
  private final float[] d = new float[] { 0.0F, 0.0F, 0.0F, 0.0F };
  
  private Drawable e;
  
  private ColorStateList f = ColorStateList.valueOf(-16777216);
  
  private float g = 0.0F;
  
  private ColorFilter h = null;
  
  private boolean i = false;
  
  private Drawable j;
  
  private boolean k = false;
  
  private boolean l = false;
  
  private boolean m = false;
  
  private int n;
  
  private int o;
  
  private ImageView.ScaleType p;
  
  private Shader.TileMode q;
  
  private Shader.TileMode r;
  
  static {
    a = Shader.TileMode.CLAMP;
    c = new ImageView.ScaleType[] { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  }
  
  public RoundedLocalView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedLocalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    Shader.TileMode tileMode = a;
    this.q = tileMode;
    this.r = tileMode;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedLocalView, paramInt, 0);
    paramInt = typedArray.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
    if (paramInt >= 0) {
      setScaleType(c[paramInt]);
    } else {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    } 
    float f = typedArray.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius, -1);
    this.d[0] = typedArray.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius_top_left, -1);
    this.d[1] = typedArray.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius_top_right, -1);
    this.d[2] = typedArray.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius_bottom_right, -1);
    this.d[3] = typedArray.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius_bottom_left, -1);
    int j = this.d.length;
    paramInt = 0;
    int i = 0;
    while (paramInt < j) {
      float[] arrayOfFloat = this.d;
      if (arrayOfFloat[paramInt] < 0.0F) {
        arrayOfFloat[paramInt] = 0.0F;
      } else {
        i = 1;
      } 
      paramInt++;
    } 
    if (!i) {
      float f1 = f;
      if (f < 0.0F)
        f1 = 0.0F; 
      i = this.d.length;
      for (paramInt = 0; paramInt < i; paramInt++)
        this.d[paramInt] = f1; 
    } 
    this.g = typedArray.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_border_width, -1);
    if (this.g < 0.0F)
      this.g = 0.0F; 
    this.f = typedArray.getColorStateList(R.styleable.RoundedLocalView_riv_border_color);
    if (this.f == null)
      this.f = ColorStateList.valueOf(-16777216); 
    this.m = typedArray.getBoolean(R.styleable.RoundedLocalView_riv_mutate_background, false);
    this.l = typedArray.getBoolean(R.styleable.RoundedLocalView_riv_oval, false);
    paramInt = typedArray.getInt(R.styleable.RoundedLocalView_riv_tile_mode, -2);
    if (paramInt != -2) {
      setTileModeX(a(paramInt));
      setTileModeY(a(paramInt));
    } 
    paramInt = typedArray.getInt(R.styleable.RoundedLocalView_riv_tile_mode_x, -2);
    if (paramInt != -2)
      setTileModeX(a(paramInt)); 
    paramInt = typedArray.getInt(R.styleable.RoundedLocalView_riv_tile_mode_y, -2);
    if (paramInt != -2)
      setTileModeY(a(paramInt)); 
    c();
    a(true);
    if (this.m)
      super.setBackgroundDrawable(this.e); 
    typedArray.recycle();
  }
  
  private static Shader.TileMode a(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? null : Shader.TileMode.MIRROR) : Shader.TileMode.REPEAT) : Shader.TileMode.CLAMP;
  }
  
  private Drawable a() {
    Resources resources = getResources();
    Drawable drawable2 = null;
    if (resources == null)
      return null; 
    int i = this.n;
    Drawable drawable1 = drawable2;
    if (i != 0)
      try {
        drawable1 = resources.getDrawable(i);
      } catch (Exception exception) {
        this.n = 0;
        drawable1 = drawable2;
      }  
    return RoundedDrawable.a(drawable1);
  }
  
  private void a(Drawable paramDrawable, ImageView.ScaleType paramScaleType) {
    float[] arrayOfFloat;
    if (paramDrawable == null)
      return; 
    boolean bool = paramDrawable instanceof RoundedDrawable;
    int i = 0;
    if (bool) {
      paramDrawable = paramDrawable;
      paramDrawable.a(paramScaleType).a(this.g).a(this.f).a(this.l).a(this.q).b(this.r);
      arrayOfFloat = this.d;
      if (arrayOfFloat != null)
        paramDrawable.a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]); 
      d();
      return;
    } 
    if (paramDrawable instanceof LayerDrawable) {
      LayerDrawable layerDrawable = (LayerDrawable)paramDrawable;
      int j = layerDrawable.getNumberOfLayers();
      while (i < j) {
        a(layerDrawable.getDrawable(i), (ImageView.ScaleType)arrayOfFloat);
        i++;
      } 
    } 
  }
  
  private void a(boolean paramBoolean) {
    if (this.m) {
      if (paramBoolean)
        this.e = RoundedDrawable.a(this.e); 
      a(this.e, ImageView.ScaleType.FIT_XY);
    } 
  }
  
  private Drawable b() {
    Resources resources = getResources();
    Drawable drawable2 = null;
    if (resources == null)
      return null; 
    int i = this.o;
    Drawable drawable1 = drawable2;
    if (i != 0)
      try {
        drawable1 = resources.getDrawable(i);
      } catch (Exception exception) {
        this.o = 0;
        drawable1 = drawable2;
      }  
    return RoundedDrawable.a(drawable1);
  }
  
  private void c() {
    a(this.j, this.p);
  }
  
  private void d() {
    Drawable drawable = this.j;
    if (drawable != null && this.i) {
      this.j = drawable.mutate();
      if (this.k)
        this.j.setColorFilter(this.h); 
    } 
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat[0] == paramFloat1 && arrayOfFloat[1] == paramFloat2 && arrayOfFloat[2] == paramFloat4 && arrayOfFloat[3] == paramFloat3)
      return; 
    arrayOfFloat = this.d;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[3] = paramFloat3;
    arrayOfFloat[2] = paramFloat4;
    c();
    a(false);
    invalidate();
  }
  
  public void drawableStateChanged() {
    super.drawableStateChanged();
    invalidate();
  }
  
  public int getBorderColor() {
    return this.f.getDefaultColor();
  }
  
  public ColorStateList getBorderColors() {
    return this.f;
  }
  
  public float getBorderWidth() {
    return this.g;
  }
  
  public float getCornerRadius() {
    return getMaxCornerRadius();
  }
  
  public float getMaxCornerRadius() {
    float[] arrayOfFloat = this.d;
    int j = arrayOfFloat.length;
    float f = 0.0F;
    for (int i = 0; i < j; i++)
      f = Math.max(arrayOfFloat[i], f); 
    return f;
  }
  
  public ImageView.ScaleType getScaleType() {
    return this.p;
  }
  
  public Shader.TileMode getTileModeX() {
    return this.q;
  }
  
  public Shader.TileMode getTileModeY() {
    return this.r;
  }
  
  public void setBackground(Drawable paramDrawable) {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt) {
    this.e = (Drawable)new ColorDrawable(paramInt);
    setBackgroundDrawable(this.e);
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable) {
    this.e = paramDrawable;
    a(true);
    super.setBackgroundDrawable(this.e);
  }
  
  public void setBackgroundResource(int paramInt) {
    if (this.o != paramInt) {
      this.o = paramInt;
      this.e = b();
      setBackgroundDrawable(this.e);
    } 
  }
  
  public void setBorderColor(int paramInt) {
    setBorderColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setBorderColor(ColorStateList paramColorStateList) {
    if (this.f.equals(paramColorStateList))
      return; 
    if (paramColorStateList == null)
      paramColorStateList = ColorStateList.valueOf(-16777216); 
    this.f = paramColorStateList;
    c();
    a(false);
    if (this.g > 0.0F)
      invalidate(); 
  }
  
  public void setBorderWidth(float paramFloat) {
    if (this.g == paramFloat)
      return; 
    this.g = paramFloat;
    c();
    a(false);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt) {
    setBorderWidth(getResources().getDimension(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (this.h != paramColorFilter) {
      this.h = paramColorFilter;
      this.k = true;
      this.i = true;
      d();
      invalidate();
    } 
  }
  
  public void setCornerRadius(float paramFloat) {
    a(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setCornerRadiusDimen(int paramInt) {
    float f = getResources().getDimension(paramInt);
    a(f, f, f, f);
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    this.n = 0;
    this.j = RoundedDrawable.a(paramBitmap);
    c();
    super.setImageDrawable(this.j);
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    this.n = 0;
    this.j = RoundedDrawable.a(paramDrawable);
    c();
    super.setImageDrawable(this.j);
  }
  
  public void setImageResource(int paramInt) {
    if (this.n != paramInt) {
      this.n = paramInt;
      this.j = a();
      c();
      super.setImageDrawable(this.j);
    } 
  }
  
  public void setImageURI(Uri paramUri) {
    super.setImageURI(paramUri);
    setImageDrawable(getDrawable());
  }
  
  public void setOval(boolean paramBoolean) {
    this.l = paramBoolean;
    c();
    a(false);
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType) {
    if (b || paramScaleType != null) {
      if (this.p != paramScaleType) {
        this.p = paramScaleType;
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
        c();
        a(false);
        invalidate();
      } 
      return;
    } 
    throw new AssertionError();
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode) {
    if (this.q == paramTileMode)
      return; 
    this.q = paramTileMode;
    c();
    a(false);
    invalidate();
  }
  
  public void setTileModeY(Shader.TileMode paramTileMode) {
    if (this.r == paramTileMode)
      return; 
    this.r = paramTileMode;
    c();
    a(false);
    invalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\roundimage\RoundedLocalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */