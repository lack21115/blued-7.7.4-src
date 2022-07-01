package org.chromium.components.embedder_support.delegate;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ColorPickerSimple extends ListView implements ColorSuggestionListAdapter$OnColorSuggestionClickListener {
  private static final int[] DEFAULT_COLORS = new int[] { -65536, -16711681, -16776961, -16711936, -65281, -256, -16777216, -1 };
  
  private static final int[] DEFAULT_COLOR_LABEL_IDS = new int[] { R$string.color_picker_button_red, R$string.color_picker_button_cyan, R$string.color_picker_button_blue, R$string.color_picker_button_green, R$string.color_picker_button_magenta, R$string.color_picker_button_yellow, R$string.color_picker_button_black, R$string.color_picker_button_white };
  
  private OnColorChangedListener mOnColorChangedListener;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ColorPickerSimple(Context paramContext) {
    super(paramContext);
  }
  
  public ColorPickerSimple(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public ColorPickerSimple(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void init(ColorSuggestion[] paramArrayOfColorSuggestion, OnColorChangedListener paramOnColorChangedListener) {
    this.mOnColorChangedListener = paramOnColorChangedListener;
    ColorSuggestion[] arrayOfColorSuggestion = paramArrayOfColorSuggestion;
    if (paramArrayOfColorSuggestion == null) {
      paramArrayOfColorSuggestion = new ColorSuggestion[DEFAULT_COLORS.length];
      int i = 0;
      while (true) {
        arrayOfColorSuggestion = paramArrayOfColorSuggestion;
        if (i < paramArrayOfColorSuggestion.length) {
          paramArrayOfColorSuggestion[i] = new ColorSuggestion(DEFAULT_COLORS[i], getContext().getString(DEFAULT_COLOR_LABEL_IDS[i]));
          i++;
          continue;
        } 
        break;
      } 
    } 
    ColorSuggestionListAdapter colorSuggestionListAdapter = new ColorSuggestionListAdapter(getContext(), arrayOfColorSuggestion);
    colorSuggestionListAdapter.mListener = this;
    setAdapter((ListAdapter)colorSuggestionListAdapter);
  }
  
  public final void onColorSuggestionClick(ColorSuggestion paramColorSuggestion) {
    this.mOnColorChangedListener.onColorChanged(paramColorSuggestion.mColor);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\embedder_support\delegate\ColorPickerSimple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */