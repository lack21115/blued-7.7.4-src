package org.chromium.components.embedder_support.delegate;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public final class ColorPickerDialog extends AlertDialog implements OnColorChangedListener {
  private final ColorPickerAdvanced mAdvancedColorPicker;
  
  private int mCurrentColor;
  
  private final View mCurrentColorView;
  
  private final int mInitialColor;
  
  private final OnColorChangedListener mListener;
  
  private final Button mMoreButton;
  
  private final ColorPickerSimple mSimpleColorPicker;
  
  public ColorPickerDialog(Context paramContext, OnColorChangedListener paramOnColorChangedListener, int paramInt, ColorSuggestion[] paramArrayOfColorSuggestion) {
    super(paramContext, 0);
    this.mListener = paramOnColorChangedListener;
    this.mInitialColor = paramInt;
    this.mCurrentColor = this.mInitialColor;
    LayoutInflater layoutInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    View view2 = layoutInflater.inflate(R$layout.color_picker_dialog_title, null);
    setCustomTitle(view2);
    this.mCurrentColorView = view2.findViewById(R$id.selected_color_view);
    ((TextView)view2.findViewById(R$id.title)).setText(R$string.color_picker_dialog_title);
    setButton(-1, paramContext.getString(R$string.color_picker_button_set), new ColorPickerDialog$1(this));
    setButton(-2, paramContext.getString(R$string.color_picker_button_cancel), new ColorPickerDialog$2(this));
    setOnCancelListener(new ColorPickerDialog$3(this));
    View view1 = layoutInflater.inflate(R$layout.color_picker_dialog_content, null);
    setView(view1);
    this.mMoreButton = (Button)view1.findViewById(R$id.more_colors_button);
    this.mMoreButton.setOnClickListener(new ColorPickerDialog$4(this));
    this.mAdvancedColorPicker = (ColorPickerAdvanced)view1.findViewById(R$id.color_picker_advanced);
    this.mAdvancedColorPicker.setVisibility(8);
    this.mSimpleColorPicker = (ColorPickerSimple)view1.findViewById(R$id.color_picker_simple);
    this.mSimpleColorPicker.init(paramArrayOfColorSuggestion, this);
    updateCurrentColor(this.mInitialColor);
  }
  
  private void updateCurrentColor(int paramInt) {
    this.mCurrentColor = paramInt;
    if (this.mCurrentColorView != null)
      this.mCurrentColorView.setBackgroundColor(paramInt); 
  }
  
  public final void onColorChanged(int paramInt) {
    updateCurrentColor(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\embedder_support\delegate\ColorPickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */