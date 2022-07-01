package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class SwitchMaterial extends SwitchCompat {
  private static final int c = R.style.Widget_MaterialComponents_CompoundButton_Switch;
  
  private static final int[][] d;
  
  private final ElevationOverlayProvider e;
  
  private ColorStateList f;
  
  private ColorStateList g;
  
  private boolean h;
  
  static {
    int[] arrayOfInt1 = { 16842910, 16842912 };
    int[] arrayOfInt2 = { 16842910, -16842912 };
    int[] arrayOfInt3 = { -16842910, -16842912 };
    d = new int[][] { arrayOfInt1, arrayOfInt2, { -16842910, 16842912 }, arrayOfInt3 };
  }
  
  public SwitchMaterial(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchMaterial(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, c), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.e = new ElevationOverlayProvider(paramContext);
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.SwitchMaterial, paramInt, c, new int[0]);
    this.h = typedArray.getBoolean(R.styleable.SwitchMaterial_useMaterialThemeColors, false);
    typedArray.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsThumbTintList() {
    if (this.f == null) {
      int i = MaterialColors.a((View)this, R.attr.colorSurface);
      int j = MaterialColors.a((View)this, R.attr.colorControlActivated);
      float f2 = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
      float f1 = f2;
      if (this.e.a())
        f1 = f2 + ViewUtils.d((View)this); 
      int k = this.e.a(i, f1);
      int[] arrayOfInt = new int[d.length];
      arrayOfInt[0] = MaterialColors.a(i, j, 1.0F);
      arrayOfInt[1] = k;
      arrayOfInt[2] = MaterialColors.a(i, j, 0.38F);
      arrayOfInt[3] = k;
      this.f = new ColorStateList(d, arrayOfInt);
    } 
    return this.f;
  }
  
  private ColorStateList getMaterialThemeColorsTrackTintList() {
    if (this.g == null) {
      int[] arrayOfInt = new int[d.length];
      int i = MaterialColors.a((View)this, R.attr.colorSurface);
      int j = MaterialColors.a((View)this, R.attr.colorControlActivated);
      int k = MaterialColors.a((View)this, R.attr.colorOnSurface);
      arrayOfInt[0] = MaterialColors.a(i, j, 0.54F);
      arrayOfInt[1] = MaterialColors.a(i, k, 0.32F);
      arrayOfInt[2] = MaterialColors.a(i, j, 0.12F);
      arrayOfInt[3] = MaterialColors.a(i, k, 0.12F);
      this.g = new ColorStateList(d, arrayOfInt);
    } 
    return this.g;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.h && getThumbTintList() == null)
      setThumbTintList(getMaterialThemeColorsThumbTintList()); 
    if (this.h && getTrackTintList() == null)
      setTrackTintList(getMaterialThemeColorsTrackTintList()); 
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean) {
    this.h = paramBoolean;
    if (paramBoolean) {
      setThumbTintList(getMaterialThemeColorsThumbTintList());
      setTrackTintList(getMaterialThemeColorsTrackTintList());
      return;
    } 
    setThumbTintList(null);
    setTrackTintList(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\switchmaterial\SwitchMaterial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */