package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class TintTypedArray {
  final Context mContext;
  
  TypedValue mTypedValue;
  
  public final TypedArray mWrapped;
  
  private TintTypedArray(Context paramContext, TypedArray paramTypedArray) {
    this.mContext = paramContext;
    this.mWrapped = paramTypedArray;
  }
  
  public static TintTypedArray obtainStyledAttributes(Context paramContext, int paramInt, int[] paramArrayOfint) {
    return new TintTypedArray(paramContext, paramContext.obtainStyledAttributes(paramInt, paramArrayOfint));
  }
  
  public static TintTypedArray obtainStyledAttributes(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfint) {
    return new TintTypedArray(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfint));
  }
  
  public static TintTypedArray obtainStyledAttributes(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfint, int paramInt1, int paramInt2) {
    return new TintTypedArray(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfint, paramInt1, paramInt2));
  }
  
  public final boolean getBoolean(int paramInt, boolean paramBoolean) {
    return this.mWrapped.getBoolean(paramInt, paramBoolean);
  }
  
  public final int getColor(int paramInt1, int paramInt2) {
    return this.mWrapped.getColor(paramInt1, paramInt2);
  }
  
  public final ColorStateList getColorStateList(int paramInt) {
    if (this.mWrapped.hasValue(paramInt)) {
      int i = this.mWrapped.getResourceId(paramInt, 0);
      if (i != 0) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.mContext, i);
        if (colorStateList != null)
          return colorStateList; 
      } 
    } 
    return this.mWrapped.getColorStateList(paramInt);
  }
  
  public final int getDimensionPixelOffset(int paramInt1, int paramInt2) {
    return this.mWrapped.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public final int getDimensionPixelSize(int paramInt1, int paramInt2) {
    return this.mWrapped.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public final Drawable getDrawable(int paramInt) {
    if (this.mWrapped.hasValue(paramInt)) {
      int i = this.mWrapped.getResourceId(paramInt, 0);
      if (i != 0)
        return AppCompatResources.getDrawable(this.mContext, i); 
    } 
    return this.mWrapped.getDrawable(paramInt);
  }
  
  public final int getInt(int paramInt1, int paramInt2) {
    return this.mWrapped.getInt(paramInt1, paramInt2);
  }
  
  public final int getInteger(int paramInt1, int paramInt2) {
    return this.mWrapped.getInteger(paramInt1, paramInt2);
  }
  
  public final int getLayoutDimension(int paramInt1, int paramInt2) {
    return this.mWrapped.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public final int getResourceId(int paramInt1, int paramInt2) {
    return this.mWrapped.getResourceId(paramInt1, paramInt2);
  }
  
  public final CharSequence getText(int paramInt) {
    return this.mWrapped.getText(paramInt);
  }
  
  public final boolean hasValue(int paramInt) {
    return this.mWrapped.hasValue(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\TintTypedArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */