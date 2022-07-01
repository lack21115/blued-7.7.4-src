package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

final class CalendarItemStyle {
  private final Rect a;
  
  private final ColorStateList b;
  
  private final ColorStateList c;
  
  private final ColorStateList d;
  
  private final int e;
  
  private final ShapeAppearanceModel f;
  
  private CalendarItemStyle(ColorStateList paramColorStateList1, ColorStateList paramColorStateList2, ColorStateList paramColorStateList3, int paramInt, ShapeAppearanceModel paramShapeAppearanceModel, Rect paramRect) {
    Preconditions.checkArgumentNonnegative(paramRect.left);
    Preconditions.checkArgumentNonnegative(paramRect.top);
    Preconditions.checkArgumentNonnegative(paramRect.right);
    Preconditions.checkArgumentNonnegative(paramRect.bottom);
    this.a = paramRect;
    this.b = paramColorStateList2;
    this.c = paramColorStateList1;
    this.d = paramColorStateList3;
    this.e = paramInt;
    this.f = paramShapeAppearanceModel;
  }
  
  static CalendarItemStyle a(Context paramContext, int paramInt) {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Cannot create a CalendarItemStyle with a styleResId of 0");
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.MaterialCalendarItem);
    Rect rect = new Rect(typedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), typedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), typedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), typedArray.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
    ColorStateList colorStateList1 = MaterialResources.a(paramContext, typedArray, R.styleable.MaterialCalendarItem_itemFillColor);
    ColorStateList colorStateList2 = MaterialResources.a(paramContext, typedArray, R.styleable.MaterialCalendarItem_itemTextColor);
    ColorStateList colorStateList3 = MaterialResources.a(paramContext, typedArray, R.styleable.MaterialCalendarItem_itemStrokeColor);
    paramInt = typedArray.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
    ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.a(paramContext, typedArray.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArray.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
    typedArray.recycle();
    return new CalendarItemStyle(colorStateList1, colorStateList2, colorStateList3, paramInt, shapeAppearanceModel, rect);
  }
  
  int a() {
    return this.a.top;
  }
  
  void a(TextView paramTextView) {
    RippleDrawable rippleDrawable;
    MaterialShapeDrawable materialShapeDrawable1 = new MaterialShapeDrawable();
    MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
    materialShapeDrawable1.setShapeAppearanceModel(this.f);
    materialShapeDrawable2.setShapeAppearanceModel(this.f);
    materialShapeDrawable1.g(this.c);
    materialShapeDrawable1.a(this.e, this.d);
    paramTextView.setTextColor(this.b);
    if (Build.VERSION.SDK_INT >= 21)
      rippleDrawable = new RippleDrawable(this.b.withAlpha(30), (Drawable)materialShapeDrawable1, (Drawable)materialShapeDrawable2); 
    ViewCompat.setBackground((View)paramTextView, (Drawable)new InsetDrawable((Drawable)rippleDrawable, this.a.left, this.a.top, this.a.right, this.a.bottom));
  }
  
  int b() {
    return this.a.bottom;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\CalendarItemStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */