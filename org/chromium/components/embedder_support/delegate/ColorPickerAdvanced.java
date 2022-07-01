package org.chromium.components.embedder_support.delegate;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class ColorPickerAdvanced extends LinearLayout implements SeekBar.OnSeekBarChangeListener {
  int mCurrentColor;
  
  final float[] mCurrentHsvValues = new float[3];
  
  private ColorPickerAdvancedComponent mHueDetails;
  
  OnColorChangedListener mOnColorChangedListener;
  
  private ColorPickerAdvancedComponent mSaturationDetails;
  
  private ColorPickerAdvancedComponent mValueDetails;
  
  public ColorPickerAdvanced(Context paramContext) {
    super(paramContext);
    init();
  }
  
  public ColorPickerAdvanced(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ColorPickerAdvanced(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private ColorPickerAdvancedComponent createAndAddNewGradient(int paramInt1, int paramInt2, SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {
    View view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(R$layout.color_picker_advanced_component, null);
    addView(view);
    return new ColorPickerAdvancedComponent(view, paramInt1, paramInt2, paramOnSeekBarChangeListener);
  }
  
  private void init() {
    setOrientation(1);
    this.mHueDetails = createAndAddNewGradient(R$string.color_picker_hue, 360, this);
    this.mSaturationDetails = createAndAddNewGradient(R$string.color_picker_saturation, 100, this);
    this.mValueDetails = createAndAddNewGradient(R$string.color_picker_value, 100, this);
    refreshGradientComponents();
  }
  
  private void updateHueGradient() {
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[1] = this.mCurrentHsvValues[1];
    arrayOfFloat[2] = this.mCurrentHsvValues[2];
    int[] arrayOfInt = new int[7];
    for (int i = 0; i < 7; i++) {
      arrayOfFloat[0] = i * 60.0F;
      arrayOfInt[i] = Color.HSVToColor(arrayOfFloat);
    } 
    this.mHueDetails.setGradientColors(arrayOfInt);
  }
  
  private void updateSaturationGradient() {
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = this.mCurrentHsvValues[0];
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = this.mCurrentHsvValues[2];
    int i = Color.HSVToColor(arrayOfFloat);
    arrayOfFloat[1] = 1.0F;
    int j = Color.HSVToColor(arrayOfFloat);
    this.mSaturationDetails.setGradientColors(new int[] { i, j });
  }
  
  private void updateValueGradient() {
    float[] arrayOfFloat = new float[3];
    arrayOfFloat[0] = this.mCurrentHsvValues[0];
    arrayOfFloat[1] = this.mCurrentHsvValues[1];
    arrayOfFloat[2] = 0.0F;
    int i = Color.HSVToColor(arrayOfFloat);
    arrayOfFloat[2] = 1.0F;
    int j = Color.HSVToColor(arrayOfFloat);
    this.mValueDetails.setGradientColors(new int[] { i, j });
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      this.mCurrentHsvValues[0] = this.mHueDetails.getValue();
      this.mCurrentHsvValues[1] = this.mSaturationDetails.getValue() / 100.0F;
      this.mCurrentHsvValues[2] = this.mValueDetails.getValue() / 100.0F;
      this.mCurrentColor = Color.HSVToColor(this.mCurrentHsvValues);
      updateHueGradient();
      updateSaturationGradient();
      updateValueGradient();
      if (this.mOnColorChangedListener != null)
        this.mOnColorChangedListener.onColorChanged(this.mCurrentColor); 
    } 
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  final void refreshGradientComponents() {
    int i = Math.max(Math.min(Math.round(this.mCurrentHsvValues[1] * 100.0F), 100), 0);
    int j = Math.max(Math.min(Math.round(this.mCurrentHsvValues[2] * 100.0F), 100), 0);
    this.mHueDetails.setValue(this.mCurrentHsvValues[0]);
    this.mSaturationDetails.setValue(i);
    this.mValueDetails.setValue(j);
    updateHueGradient();
    updateSaturationGradient();
    updateValueGradient();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\embedder_support\delegate\ColorPickerAdvanced.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */