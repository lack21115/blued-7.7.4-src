package com.soft.blued.customview.gridcodeedittext;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

public class CustomPasswordTransformationMethod extends PasswordTransformationMethod {
  String a;
  
  public CustomPasswordTransformationMethod(String paramString) {
    this.a = paramString;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView) {
    return new PasswordCharSequence(this, paramCharSequence);
  }
  
  class PasswordCharSequence implements CharSequence {
    private CharSequence b;
    
    public PasswordCharSequence(CustomPasswordTransformationMethod this$0, CharSequence param1CharSequence) {
      this.b = param1CharSequence;
    }
    
    public char charAt(int param1Int) {
      return this.a.a.charAt(0);
    }
    
    public int length() {
      return this.b.length();
    }
    
    public CharSequence subSequence(int param1Int1, int param1Int2) {
      return this.b.subSequence(param1Int1, param1Int2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\gridcodeedittext\CustomPasswordTransformationMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */