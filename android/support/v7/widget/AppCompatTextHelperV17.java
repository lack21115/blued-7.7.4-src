package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.TextView;

final class AppCompatTextHelperV17 extends AppCompatTextHelper {
  private TintInfo mDrawableEndTint;
  
  private TintInfo mDrawableStartTint;
  
  AppCompatTextHelperV17(TextView paramTextView) {
    super(paramTextView);
  }
  
  final void applyCompoundDrawablesTints() {
    super.applyCompoundDrawablesTints();
    if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
      Drawable[] arrayOfDrawable = this.mView.getCompoundDrawablesRelative();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableEndTint);
    } 
  }
  
  final void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    super.loadFromAttributes(paramAttributeSet, paramInt);
    Context context = this.mView.getContext();
    AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
    TypedArray typedArray = context.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    if (typedArray.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart))
      this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0)); 
    if (typedArray.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd))
      this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0)); 
    typedArray.recycle();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatTextHelperV17.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */