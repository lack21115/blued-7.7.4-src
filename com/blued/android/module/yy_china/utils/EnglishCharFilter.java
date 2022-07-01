package com.blued.android.module.yy_china.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class EnglishCharFilter implements InputFilter {
  int a = 0;
  
  public EnglishCharFilter(int paramInt) {
    this.a = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4) {
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 <= this.a && paramInt2 < paramSpanned.length(); paramInt2++) {
      if ((paramSpanned.charAt(paramInt2) & Character.MAX_VALUE) <= 255) {
        paramInt1++;
      } else {
        paramInt1 += 2;
      } 
    } 
    if (paramInt1 > this.a)
      return paramSpanned.subSequence(0, paramInt2 - 1); 
    for (paramInt2 = 0; paramInt1 <= this.a && paramInt2 < paramCharSequence.length(); paramInt2++) {
      if ((paramCharSequence.charAt(paramInt2) & Character.MAX_VALUE) <= 255) {
        paramInt1++;
      } else {
        paramInt1 += 2;
      } 
    } 
    return (paramInt1 > this.a) ? paramCharSequence.subSequence(0, paramInt2 - 1) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_chin\\utils\EnglishCharFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */