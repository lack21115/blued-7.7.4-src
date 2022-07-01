package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialCheckBox extends AppCompatCheckBox {
  private static final int a = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;
  
  private static final int[][] b = new int[][] { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  
  private ColorStateList c;
  
  private boolean d;
  
  public MaterialCheckBox(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.checkboxStyle);
  }
  
  public MaterialCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.MaterialCheckBox, paramInt, a, new int[0]);
    if (typedArray.hasValue(R.styleable.MaterialCheckBox_buttonTint))
      CompoundButtonCompat.setButtonTintList((CompoundButton)this, MaterialResources.a(paramContext, typedArray, R.styleable.MaterialCheckBox_buttonTint)); 
    this.d = typedArray.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
    typedArray.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsTintList() {
    if (this.c == null) {
      int[] arrayOfInt = new int[b.length];
      int i = MaterialColors.a((View)this, R.attr.colorControlActivated);
      int j = MaterialColors.a((View)this, R.attr.colorSurface);
      int k = MaterialColors.a((View)this, R.attr.colorOnSurface);
      arrayOfInt[0] = MaterialColors.a(j, i, 1.0F);
      arrayOfInt[1] = MaterialColors.a(j, k, 0.54F);
      arrayOfInt[2] = MaterialColors.a(j, k, 0.38F);
      arrayOfInt[3] = MaterialColors.a(j, k, 0.38F);
      this.c = new ColorStateList(b, arrayOfInt);
    } 
    return this.c;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.d && CompoundButtonCompat.getButtonTintList((CompoundButton)this) == null)
      setUseMaterialThemeColors(true); 
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean) {
    this.d = paramBoolean;
    if (paramBoolean) {
      CompoundButtonCompat.setButtonTintList((CompoundButton)this, getMaterialThemeColorsTintList());
      return;
    } 
    CompoundButtonCompat.setButtonTintList((CompoundButton)this, null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\checkbox\MaterialCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */