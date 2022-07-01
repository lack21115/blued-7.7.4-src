package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialToolbar extends Toolbar {
  private static final int e = R.style.Widget_MaterialComponents_Toolbar;
  
  public MaterialToolbar(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public MaterialToolbar(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public MaterialToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, e), paramAttributeSet, paramInt);
    a(getContext());
  }
  
  private void a(Context paramContext) {
    boolean bool;
    Drawable drawable = getBackground();
    if (drawable != null && !(drawable instanceof ColorDrawable))
      return; 
    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
    if (drawable != null) {
      bool = ((ColorDrawable)drawable).getColor();
    } else {
      bool = false;
    } 
    materialShapeDrawable.g(ColorStateList.valueOf(bool));
    materialShapeDrawable.a(paramContext);
    materialShapeDrawable.r(ViewCompat.getElevation((View)this));
    ViewCompat.setBackground((View)this, (Drawable)materialShapeDrawable);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    MaterialShapeUtils.a((View)this);
  }
  
  public void setElevation(float paramFloat) {
    super.setElevation(paramFloat);
    MaterialShapeUtils.a((View)this, paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\appbar\MaterialToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */