package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.List;

public class RangeSlider extends BaseSlider<RangeSlider, RangeSlider.OnChangeListener, RangeSlider.OnSliderTouchListener> {
  public RangeSlider(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public RangeSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { R.attr.values });
    if (typedArray.hasValue(0)) {
      paramInt = typedArray.getResourceId(0, 0);
      setValues(a(typedArray.getResources().obtainTypedArray(paramInt)));
    } 
    typedArray.recycle();
  }
  
  private static List<Float> a(TypedArray paramTypedArray) {
    ArrayList<Float> arrayList = new ArrayList();
    for (int i = 0; i < paramTypedArray.length(); i++)
      arrayList.add(Float.valueOf(paramTypedArray.getFloat(i, -1.0F))); 
    return arrayList;
  }
  
  public List<Float> getValues() {
    return super.getValues();
  }
  
  public void setValues(List<Float> paramList) {
    super.setValues(paramList);
  }
  
  public void setValues(Float... paramVarArgs) {
    super.setValues(paramVarArgs);
  }
  
  public static interface OnChangeListener extends BaseOnChangeListener<RangeSlider> {}
  
  public static interface OnSliderTouchListener extends BaseOnSliderTouchListener<RangeSlider> {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\slider\RangeSlider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */