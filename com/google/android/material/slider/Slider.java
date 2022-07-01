package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.google.android.material.R;

public class Slider extends BaseSlider<Slider, Slider.OnChangeListener, Slider.OnSliderTouchListener> {
  public Slider(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public Slider(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842788 });
    if (typedArray.hasValue(0))
      setValue(typedArray.getFloat(0, 0.0F)); 
    typedArray.recycle();
  }
  
  protected boolean b() {
    if (getActiveThumbIndex() != -1)
      return true; 
    setActiveThumbIndex(0);
    return true;
  }
  
  public float getValue() {
    return ((Float)getValues().get(0)).floatValue();
  }
  
  public void setValue(float paramFloat) {
    setValues(new Float[] { Float.valueOf(paramFloat) });
  }
  
  public static interface OnChangeListener extends BaseOnChangeListener<Slider> {}
  
  public static interface OnSliderTouchListener extends BaseOnSliderTouchListener<Slider> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\slider\Slider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */