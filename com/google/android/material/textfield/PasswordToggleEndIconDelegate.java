package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;

class PasswordToggleEndIconDelegate extends EndIconDelegate {
  private final TextWatcher d = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {}
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        this.a.c.setChecked(PasswordToggleEndIconDelegate.a(this.a) ^ true);
      }
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private final TextInputLayout.OnEditTextAttachedListener e = new TextInputLayout.OnEditTextAttachedListener(this) {
      public void a(TextInputLayout param1TextInputLayout) {
        EditText editText = param1TextInputLayout.getEditText();
        param1TextInputLayout.setEndIconVisible(true);
        param1TextInputLayout.setEndIconCheckable(true);
        this.a.c.setChecked(true ^ PasswordToggleEndIconDelegate.a(this.a));
        editText.removeTextChangedListener(PasswordToggleEndIconDelegate.b(this.a));
        editText.addTextChangedListener(PasswordToggleEndIconDelegate.b(this.a));
      }
    };
  
  private final TextInputLayout.OnEndIconChangedListener f = new TextInputLayout.OnEndIconChangedListener(this) {
      public void a(TextInputLayout param1TextInputLayout, int param1Int) {
        EditText editText = param1TextInputLayout.getEditText();
        if (editText != null && param1Int == 1) {
          editText.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
          editText.removeTextChangedListener(PasswordToggleEndIconDelegate.b(this.a));
        } 
      }
    };
  
  PasswordToggleEndIconDelegate(TextInputLayout paramTextInputLayout) {
    super(paramTextInputLayout);
  }
  
  private static boolean a(EditText paramEditText) {
    return (paramEditText != null && (paramEditText.getInputType() == 16 || paramEditText.getInputType() == 128 || paramEditText.getInputType() == 144 || paramEditText.getInputType() == 224));
  }
  
  private boolean c() {
    EditText editText = this.a.getEditText();
    return (editText != null && editText.getTransformationMethod() instanceof PasswordTransformationMethod);
  }
  
  void a() {
    this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.design_password_eye));
    this.a.setEndIconContentDescription(this.a.getResources().getText(R.string.password_toggle_content_description));
    this.a.setEndIconOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EditText editText = this.a.a.getEditText();
            if (editText == null)
              return; 
            int i = editText.getSelectionEnd();
            if (PasswordToggleEndIconDelegate.a(this.a)) {
              editText.setTransformationMethod(null);
            } else {
              editText.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance());
            } 
            if (i >= 0)
              editText.setSelection(i); 
          }
        });
    this.a.a(this.e);
    this.a.a(this.f);
    EditText editText = this.a.getEditText();
    if (a(editText))
      editText.setTransformationMethod((TransformationMethod)PasswordTransformationMethod.getInstance()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\PasswordToggleEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */