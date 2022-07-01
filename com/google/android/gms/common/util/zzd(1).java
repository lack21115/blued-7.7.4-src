package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzd {
  private static final Pattern zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");
  
  public static String zza(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      StringBuffer stringBuffer;
      Matcher matcher = zza.matcher(paramString);
      str = null;
      while (matcher.find()) {
        StringBuffer stringBuffer1;
        String str1 = str;
        if (str == null)
          stringBuffer1 = new StringBuffer(); 
        matcher.appendReplacement(stringBuffer1, new String(Character.toChars(Integer.parseInt(matcher.group().substring(2), 16))));
        stringBuffer = stringBuffer1;
      } 
      if (stringBuffer == null)
        return paramString; 
      matcher.appendTail(stringBuffer);
      str = stringBuffer.toString();
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */