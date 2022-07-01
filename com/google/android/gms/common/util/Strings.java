package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class Strings {
  private static final Pattern zza = Pattern.compile("\\$\\{(.*?)\\}");
  
  public static String emptyToNull(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = null; 
    return str;
  }
  
  public static boolean isEmptyOrWhitespace(String paramString) {
    return (paramString == null || paramString.trim().isEmpty());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */