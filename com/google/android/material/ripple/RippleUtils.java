package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;

public class RippleUtils {
  public static final boolean a;
  
  static final String b;
  
  private static final int[] c = new int[] { 16842919 };
  
  private static final int[] d = new int[] { 16843623, 16842908 };
  
  private static final int[] e = new int[] { 16842908 };
  
  private static final int[] f = new int[] { 16843623 };
  
  private static final int[] g = new int[] { 16842913, 16842919 };
  
  private static final int[] h = new int[] { 16842913, 16843623, 16842908 };
  
  private static final int[] i = new int[] { 16842913, 16842908 };
  
  private static final int[] j = new int[] { 16842913, 16843623 };
  
  private static final int[] k = new int[] { 16842913 };
  
  private static final int[] l = new int[] { 16842910, 16842919 };
  
  static {
    b = RippleUtils.class.getSimpleName();
  }
  
  private static int a(int paramInt) {
    return ColorUtils.setAlphaComponent(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
  }
  
  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfint) {
    byte b;
    if (paramColorStateList != null) {
      b = paramColorStateList.getColorForState(paramArrayOfint, paramColorStateList.getDefaultColor());
    } else {
      b = 0;
    } 
    int i = b;
    if (a)
      i = a(b); 
    return i;
  }
  
  public static ColorStateList a(ColorStateList paramColorStateList) {
    if (a) {
      int[] arrayOfInt10 = k;
      int i4 = a(paramColorStateList, g);
      int[] arrayOfInt11 = StateSet.NOTHING;
      int i5 = a(paramColorStateList, c);
      return new ColorStateList(new int[][] { arrayOfInt10, arrayOfInt11 }, new int[] { i4, i5 });
    } 
    int[] arrayOfInt1 = g;
    int i = a(paramColorStateList, arrayOfInt1);
    int[] arrayOfInt2 = h;
    int j = a(paramColorStateList, arrayOfInt2);
    int[] arrayOfInt3 = i;
    int k = a(paramColorStateList, arrayOfInt3);
    int[] arrayOfInt4 = j;
    int m = a(paramColorStateList, arrayOfInt4);
    int[] arrayOfInt5 = k;
    int[] arrayOfInt6 = c;
    int n = a(paramColorStateList, arrayOfInt6);
    int[] arrayOfInt7 = d;
    int i1 = a(paramColorStateList, arrayOfInt7);
    int[] arrayOfInt8 = e;
    int i2 = a(paramColorStateList, arrayOfInt8);
    int[] arrayOfInt9 = f;
    int i3 = a(paramColorStateList, arrayOfInt9);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { i, j, k, m, 0, n, i1, i2, i3, 0 });
  }
  
  public static boolean a(int[] paramArrayOfint) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: istore #5
    //   4: iconst_0
    //   5: istore #8
    //   7: iconst_0
    //   8: istore_1
    //   9: iconst_0
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_1
    //   14: iload #5
    //   16: if_icmpge -> 85
    //   19: aload_0
    //   20: iload_1
    //   21: iaload
    //   22: istore #6
    //   24: iload #6
    //   26: ldc 16842910
    //   28: if_icmpne -> 37
    //   31: iconst_1
    //   32: istore #4
    //   34: goto -> 75
    //   37: iload #6
    //   39: ldc 16842908
    //   41: if_icmpne -> 52
    //   44: iconst_1
    //   45: istore_3
    //   46: iload_2
    //   47: istore #4
    //   49: goto -> 75
    //   52: iload #6
    //   54: ldc 16842919
    //   56: if_icmpne -> 62
    //   59: goto -> 44
    //   62: iload_2
    //   63: istore #4
    //   65: iload #6
    //   67: ldc 16843623
    //   69: if_icmpne -> 75
    //   72: goto -> 44
    //   75: iload_1
    //   76: iconst_1
    //   77: iadd
    //   78: istore_1
    //   79: iload #4
    //   81: istore_2
    //   82: goto -> 13
    //   85: iload #8
    //   87: istore #7
    //   89: iload_2
    //   90: ifeq -> 104
    //   93: iload #8
    //   95: istore #7
    //   97: iload_3
    //   98: ifeq -> 104
    //   101: iconst_1
    //   102: istore #7
    //   104: iload #7
    //   106: ireturn
  }
  
  public static ColorStateList b(ColorStateList paramColorStateList) {
    if (paramColorStateList != null) {
      if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 27 && Color.alpha(paramColorStateList.getDefaultColor()) == 0 && Color.alpha(paramColorStateList.getColorForState(l, 0)) != 0)
        Log.w(b, "Use a non-transparent color for the default color as it will be used to finish ripple animations."); 
      return paramColorStateList;
    } 
    return ColorStateList.valueOf(0);
  }
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\ripple\RippleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */