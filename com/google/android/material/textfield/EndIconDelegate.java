package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate {
  TextInputLayout a;
  
  Context b;
  
  CheckableImageButton c;
  
  EndIconDelegate(TextInputLayout paramTextInputLayout) {
    this.a = paramTextInputLayout;
    this.b = paramTextInputLayout.getContext();
    this.c = paramTextInputLayout.getEndIconView();
  }
  
  abstract void a();
  
  void a(boolean paramBoolean) {}
  
  boolean a(int paramInt) {
    return true;
  }
  
  boolean b() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\EndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */