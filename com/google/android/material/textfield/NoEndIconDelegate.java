package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

class NoEndIconDelegate extends EndIconDelegate {
  NoEndIconDelegate(TextInputLayout paramTextInputLayout) {
    super(paramTextInputLayout);
  }
  
  void a() {
    this.a.setEndIconOnClickListener(null);
    this.a.setEndIconDrawable((Drawable)null);
    this.a.setEndIconContentDescription((CharSequence)null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\NoEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */