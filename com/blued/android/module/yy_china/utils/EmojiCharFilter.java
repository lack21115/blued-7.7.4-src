package com.blued.android.module.yy_china.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class EmojiCharFilter implements InputFilter {
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4) {
    while (paramInt1 < paramInt2) {
      if (!Character.isLetterOrDigit(paramCharSequence.charAt(paramInt1)) && !Character.toString(paramCharSequence.charAt(paramInt1)).equals("_") && !Character.toString(paramCharSequence.charAt(paramInt1)).equals("-"))
        return ""; 
      paramInt1++;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_chin\\utils\EmojiCharFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */