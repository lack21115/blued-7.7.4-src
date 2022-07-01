package org.chromium.components.embedder_support.delegate;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import org.chromium.base.ApiCompatibilityUtils;

public final class ColorPickerAdvancedComponent {
  private int[] mGradientColors;
  
  private GradientDrawable mGradientDrawable;
  
  private final View mGradientView;
  
  private final SeekBar mSeekBar;
  
  private final TextView mText;
  
  ColorPickerAdvancedComponent(View paramView, int paramInt1, int paramInt2, SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {
    this.mGradientView = paramView.findViewById(R$id.gradient);
    this.mText = (TextView)paramView.findViewById(R$id.text);
    this.mText.setText(paramInt1);
    this.mGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
    this.mSeekBar = (SeekBar)paramView.findViewById(R$id.seek_bar);
    this.mSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    this.mSeekBar.setMax(paramInt2);
    paramInt1 = ApiCompatibilityUtils.getDrawable(paramView.getContext().getResources(), R$drawable.color_picker_advanced_select_handle).getIntrinsicWidth();
    this.mSeekBar.setThumbOffset(paramInt1 / 2);
  }
  
  public final float getValue() {
    return this.mSeekBar.getProgress();
  }
  
  public final void setGradientColors(int[] paramArrayOfint) {
    this.mGradientColors = (int[])paramArrayOfint.clone();
    this.mGradientDrawable.setColors(this.mGradientColors);
    this.mGradientView.setBackground((Drawable)this.mGradientDrawable);
  }
  
  public final void setValue(float paramFloat) {
    this.mSeekBar.setProgress((int)paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\embedder_support\delegate\ColorPickerAdvancedComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */