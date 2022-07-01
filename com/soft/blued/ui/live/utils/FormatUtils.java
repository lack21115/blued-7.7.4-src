package com.soft.blued.ui.live.utils;

import java.text.DecimalFormat;
import java.util.Locale;

public class FormatUtils {
  public static String a(float paramFloat) {
    return (new DecimalFormat("#0.0")).format(paramFloat);
  }
  
  public static String a(long paramLong) {
    return (paramLong <= 0L) ? "00:00" : ((paramLong < 60L) ? String.format(Locale.getDefault(), "00:%02d", new Object[] { Long.valueOf(paramLong % 60L) }) : ((paramLong < 3600L) ? String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) }) : String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong / 3600L), Long.valueOf(paramLong % 3600L / 60L), Long.valueOf(paramLong % 60L) })));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\liv\\utils\FormatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */