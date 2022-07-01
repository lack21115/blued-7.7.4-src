package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

final class StaticLayoutBuilderCompat {
  private static boolean a;
  
  private static Constructor<StaticLayout> b;
  
  private static Object c;
  
  private CharSequence d;
  
  private final TextPaint e;
  
  private final int f;
  
  private int g;
  
  private int h;
  
  private Layout.Alignment i;
  
  private int j;
  
  private boolean k;
  
  private boolean l;
  
  private TextUtils.TruncateAt m;
  
  private StaticLayoutBuilderCompat(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt) {
    this.d = paramCharSequence;
    this.e = paramTextPaint;
    this.f = paramInt;
    this.g = 0;
    this.h = paramCharSequence.length();
    this.i = Layout.Alignment.ALIGN_NORMAL;
    this.j = Integer.MAX_VALUE;
    this.k = true;
    this.m = null;
  }
  
  public static StaticLayoutBuilderCompat a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt) {
    return new StaticLayoutBuilderCompat(paramCharSequence, paramTextPaint, paramInt);
  }
  
  private void b() throws StaticLayoutBuilderCompatException {
    if (a)
      return; 
    try {
      boolean bool;
      Class<?> clazz;
      if (this.l && Build.VERSION.SDK_INT >= 23) {
        bool = true;
      } else {
        bool = false;
      } 
      if (Build.VERSION.SDK_INT >= 18) {
        TextDirectionHeuristic textDirectionHeuristic;
        Class<TextDirectionHeuristic> clazz1 = TextDirectionHeuristic.class;
        if (bool) {
          textDirectionHeuristic = TextDirectionHeuristics.RTL;
        } else {
          textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } 
        c = textDirectionHeuristic;
        clazz = clazz1;
      } else {
        String str;
        ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
        if (this.l) {
          str = "RTL";
        } else {
          str = "LTR";
        } 
        Class<?> clazz1 = classLoader.loadClass("android.text.TextDirectionHeuristic");
        Class<?> clazz2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
        c = clazz2.getField(str).get(clazz2);
        clazz = clazz1;
      } 
      b = StaticLayout.class.getDeclaredConstructor(new Class[] { 
            CharSequence.class, int.class, int.class, TextPaint.class, int.class, Layout.Alignment.class, clazz, float.class, float.class, boolean.class, 
            TextUtils.TruncateAt.class, int.class, int.class });
      b.setAccessible(true);
      a = true;
      return;
    } catch (Exception exception) {
      throw new StaticLayoutBuilderCompatException(exception);
    } 
  }
  
  public StaticLayout a() throws StaticLayoutBuilderCompatException {
    TextUtils.TruncateAt truncateAt;
    if (this.d == null)
      this.d = ""; 
    int i = Math.max(0, this.f);
    CharSequence charSequence2 = this.d;
    CharSequence charSequence1 = charSequence2;
    if (this.j == 1)
      charSequence1 = TextUtils.ellipsize(charSequence2, this.e, i, this.m); 
    this.h = Math.min(charSequence1.length(), this.h);
    if (Build.VERSION.SDK_INT >= 23) {
      TextDirectionHeuristic textDirectionHeuristic;
      if (this.l)
        this.i = Layout.Alignment.ALIGN_OPPOSITE; 
      StaticLayout.Builder builder = StaticLayout.Builder.obtain(charSequence1, this.g, this.h, this.e, i);
      builder.setAlignment(this.i);
      builder.setIncludePad(this.k);
      if (this.l) {
        textDirectionHeuristic = TextDirectionHeuristics.RTL;
      } else {
        textDirectionHeuristic = TextDirectionHeuristics.LTR;
      } 
      builder.setTextDirection(textDirectionHeuristic);
      truncateAt = this.m;
      if (truncateAt != null)
        builder.setEllipsize(truncateAt); 
      builder.setMaxLines(this.j);
      return builder.build();
    } 
    b();
    try {
      return ((Constructor<StaticLayout>)Preconditions.checkNotNull(b)).newInstance(new Object[] { 
            truncateAt, Integer.valueOf(this.g), Integer.valueOf(this.h), this.e, Integer.valueOf(i), this.i, Preconditions.checkNotNull(c), Float.valueOf(1.0F), Float.valueOf(0.0F), Boolean.valueOf(this.k), 
            null, Integer.valueOf(i), Integer.valueOf(this.j) });
    } catch (Exception exception) {
      throw new StaticLayoutBuilderCompatException(exception);
    } 
  }
  
  public StaticLayoutBuilderCompat a(int paramInt) {
    this.j = paramInt;
    return this;
  }
  
  public StaticLayoutBuilderCompat a(Layout.Alignment paramAlignment) {
    this.i = paramAlignment;
    return this;
  }
  
  public StaticLayoutBuilderCompat a(TextUtils.TruncateAt paramTruncateAt) {
    this.m = paramTruncateAt;
    return this;
  }
  
  public StaticLayoutBuilderCompat a(boolean paramBoolean) {
    this.k = paramBoolean;
    return this;
  }
  
  public StaticLayoutBuilderCompat b(boolean paramBoolean) {
    this.l = paramBoolean;
    return this;
  }
  
  static class StaticLayoutBuilderCompatException extends Exception {
    StaticLayoutBuilderCompatException(Throwable param1Throwable) {
      super(stringBuilder.toString(), param1Throwable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\StaticLayoutBuilderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */