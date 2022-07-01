package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialRadioButton extends AppCompatRadioButton {
  private static final int a = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;
  
  private static final int[][] b = new int[][] { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  
  private ColorStateList c;
  
  private boolean d;
  
  public MaterialRadioButton(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.radioButtonStyle);
  }
  
  public MaterialRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.MaterialRadioButton, paramInt, a, new int[0]);
    if (typedArray.hasValue(R.styleable.MaterialRadioButton_buttonTint))
      CompoundButtonCompat.setButtonTintList((CompoundButton)this, MaterialResources.a(paramContext, typedArray, R.styleable.MaterialRadioButton_buttonTint)); 
    this.d = typedArray.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
    typedArray.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsTintList() {
    if (this.c == null) {
      int i = MaterialColors.a((View)this, R.attr.colorControlActivated);
      int j = MaterialColors.a((View)this, R.attr.colorOnSurface);
      int k = MaterialColors.a((View)this, R.attr.colorSurface);
      int[] arrayOfInt = new int[b.length];
      arrayOfInt[0] = MaterialColors.a(k, i, 1.0F);
      arrayOfInt[1] = MaterialColors.a(k, j, 0.54F);
      arrayOfInt[2] = MaterialColors.a(k, j, 0.38F);
      arrayOfInt[3] = MaterialColors.a(k, j, 0.38F);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\radiobutton\MaterialRadioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */