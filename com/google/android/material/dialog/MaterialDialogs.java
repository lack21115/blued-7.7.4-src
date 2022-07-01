package com.google.android.material.dialog;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

public class MaterialDialogs {
  public static InsetDrawable a(Drawable paramDrawable, Rect paramRect) {
    return new InsetDrawable(paramDrawable, paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\dialog\MaterialDialogs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */