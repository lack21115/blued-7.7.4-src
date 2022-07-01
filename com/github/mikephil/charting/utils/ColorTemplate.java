package com.github.mikephil.charting.utils;

import android.graphics.Color;

public class ColorTemplate {
  public static final int[] a = new int[] { Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(136, 180, 187), Color.rgb(118, 174, 175), Color.rgb(42, 109, 130) };
  
  public static final int[] b = new int[] { Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, 209) };
  
  public static final int[] c = new int[] { Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80) };
  
  public static final int[] d = new int[] { Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53) };
  
  public static final int[] e = new int[] { Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157) };
  
  public static final int[] f = new int[] { a("#2ecc71"), a("#f1c40f"), a("#e74c3c"), a("#3498db") };
  
  public static int a(int paramInt1, int paramInt2) {
    return paramInt1 & 0xFFFFFF | (paramInt2 & 0xFF) << 24;
  }
  
  public static int a(String paramString) {
    int i = (int)Long.parseLong(paramString.replace("#", ""), 16);
    return Color.rgb(i >> 16 & 0xFF, i >> 8 & 0xFF, i >> 0 & 0xFF);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\ColorTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */