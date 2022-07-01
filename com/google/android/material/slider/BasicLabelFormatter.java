package com.google.android.material.slider;

import java.util.Locale;

public final class BasicLabelFormatter implements LabelFormatter {
  public String a(float paramFloat) {
    return (paramFloat >= 1.0E12F) ? String.format(Locale.US, "%.1fT", new Object[] { Float.valueOf(paramFloat / 1.0E12F) }) : ((paramFloat >= 1.0E9F) ? String.format(Locale.US, "%.1fB", new Object[] { Float.valueOf(paramFloat / 1.0E9F) }) : ((paramFloat >= 1000000.0F) ? String.format(Locale.US, "%.1fM", new Object[] { Float.valueOf(paramFloat / 1000000.0F) }) : ((paramFloat >= 1000.0F) ? String.format(Locale.US, "%.1fK", new Object[] { Float.valueOf(paramFloat / 1000.0F) }) : String.format(Locale.US, "%.0f", new Object[] { Float.valueOf(paramFloat) }))));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\slider\BasicLabelFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */