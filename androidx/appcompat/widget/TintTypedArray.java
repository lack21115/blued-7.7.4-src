package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

public class TintTypedArray {
  private final Context a;
  
  private final TypedArray b;
  
  private TypedValue c;
  
  private TintTypedArray(Context paramContext, TypedArray paramTypedArray) {
    this.a = paramContext;
    this.b = paramTypedArray;
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
  
  public boolean getBoolean(int paramInt, boolean paramBoolean) {
    return this.b.getBoolean(paramInt, paramBoolean);
  }
  
  public int getChangingConfigurations() {
    return this.b.getChangingConfigurations();
  }
  
  public int getColor(int paramInt1, int paramInt2) {
    return this.b.getColor(paramInt1, paramInt2);
  }
  
  public ColorStateList getColorStateList(int paramInt) {
    if (this.b.hasValue(paramInt)) {
      int i = this.b.getResourceId(paramInt, 0);
      if (i != 0) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.a, i);
        if (colorStateList != null)
          return colorStateList; 
      } 
    } 
    return this.b.getColorStateList(paramInt);
  }
  
  public float getDimension(int paramInt, float paramFloat) {
    return this.b.getDimension(paramInt, paramFloat);
  }
  
  public int getDimensionPixelOffset(int paramInt1, int paramInt2) {
    return this.b.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public int getDimensionPixelSize(int paramInt1, int paramInt2) {
    return this.b.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public Drawable getDrawable(int paramInt) {
    if (this.b.hasValue(paramInt)) {
      int i = this.b.getResourceId(paramInt, 0);
      if (i != 0)
        return AppCompatResources.getDrawable(this.a, i); 
    } 
    return this.b.getDrawable(paramInt);
  }
  
  public Drawable getDrawableIfKnown(int paramInt) {
    if (this.b.hasValue(paramInt)) {
      paramInt = this.b.getResourceId(paramInt, 0);
      if (paramInt != 0)
        return AppCompatDrawableManager.get().a(this.a, paramInt, true); 
    } 
    return null;
  }
  
  public float getFloat(int paramInt, float paramFloat) {
    return this.b.getFloat(paramInt, paramFloat);
  }
  
  public Typeface getFont(int paramInt1, int paramInt2, ResourcesCompat.FontCallback paramFontCallback) {
    paramInt1 = this.b.getResourceId(paramInt1, 0);
    if (paramInt1 == 0)
      return null; 
    if (this.c == null)
      this.c = new TypedValue(); 
    return ResourcesCompat.getFont(this.a, paramInt1, this.c, paramInt2, paramFontCallback);
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    return this.b.getFraction(paramInt1, paramInt2, paramInt3, paramFloat);
  }
  
  public int getIndex(int paramInt) {
    return this.b.getIndex(paramInt);
  }
  
  public int getIndexCount() {
    return this.b.getIndexCount();
  }
  
  public int getInt(int paramInt1, int paramInt2) {
    return this.b.getInt(paramInt1, paramInt2);
  }
  
  public int getInteger(int paramInt1, int paramInt2) {
    return this.b.getInteger(paramInt1, paramInt2);
  }
  
  public int getLayoutDimension(int paramInt1, int paramInt2) {
    return this.b.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public int getLayoutDimension(int paramInt, String paramString) {
    return this.b.getLayoutDimension(paramInt, paramString);
  }
  
  public String getNonResourceString(int paramInt) {
    return this.b.getNonResourceString(paramInt);
  }
  
  public String getPositionDescription() {
    return this.b.getPositionDescription();
  }
  
  public int getResourceId(int paramInt1, int paramInt2) {
    return this.b.getResourceId(paramInt1, paramInt2);
  }
  
  public Resources getResources() {
    return this.b.getResources();
  }
  
  public String getString(int paramInt) {
    return this.b.getString(paramInt);
  }
  
  public CharSequence getText(int paramInt) {
    return this.b.getText(paramInt);
  }
  
  public CharSequence[] getTextArray(int paramInt) {
    return this.b.getTextArray(paramInt);
  }
  
  public int getType(int paramInt) {
    if (Build.VERSION.SDK_INT >= 21)
      return this.b.getType(paramInt); 
    if (this.c == null)
      this.c = new TypedValue(); 
    this.b.getValue(paramInt, this.c);
    return this.c.type;
  }
  
  public boolean getValue(int paramInt, TypedValue paramTypedValue) {
    return this.b.getValue(paramInt, paramTypedValue);
  }
  
  public boolean hasValue(int paramInt) {
    return this.b.hasValue(paramInt);
  }
  
  public int length() {
    return this.b.length();
  }
  
  public TypedValue peekValue(int paramInt) {
    return this.b.peekValue(paramInt);
  }
  
  public void recycle() {
    this.b.recycle();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\TintTypedArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */