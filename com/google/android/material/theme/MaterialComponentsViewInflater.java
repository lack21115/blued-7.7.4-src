package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;

public class MaterialComponentsViewInflater extends AppCompatViewInflater {
  public AppCompatTextView a(Context paramContext, AttributeSet paramAttributeSet) {
    return (AppCompatTextView)new MaterialTextView(paramContext, paramAttributeSet);
  }
  
  public AppCompatButton c(Context paramContext, AttributeSet paramAttributeSet) {
    return (AppCompatButton)new MaterialButton(paramContext, paramAttributeSet);
  }
  
  public AppCompatCheckBox g(Context paramContext, AttributeSet paramAttributeSet) {
    return (AppCompatCheckBox)new MaterialCheckBox(paramContext, paramAttributeSet);
  }
  
  public AppCompatRadioButton h(Context paramContext, AttributeSet paramAttributeSet) {
    return (AppCompatRadioButton)new MaterialRadioButton(paramContext, paramAttributeSet);
  }
  
  public AppCompatAutoCompleteTextView j(Context paramContext, AttributeSet paramAttributeSet) {
    return (AppCompatAutoCompleteTextView)new MaterialAutoCompleteTextView(paramContext, paramAttributeSet);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\theme\MaterialComponentsViewInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */