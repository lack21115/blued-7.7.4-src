package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat {
  private static final Locale a = new Locale("", "");
  
  private static int a(Locale paramLocale) {
    byte b = Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0));
    return (b != 1 && b != 2) ? 0 : 1;
  }
  
  public static int getLayoutDirectionFromLocale(Locale paramLocale) {
    if (Build.VERSION.SDK_INT >= 17)
      return TextUtils.getLayoutDirectionFromLocale(paramLocale); 
    if (paramLocale != null && !paramLocale.equals(a)) {
      String str = ICUCompat.maximizeAndGetScript(paramLocale);
      if (str == null)
        return a(paramLocale); 
      if (str.equalsIgnoreCase("Arab") || str.equalsIgnoreCase("Hebr"))
        return 1; 
    } 
    return 0;
  }
  
  public static String htmlEncode(String paramString) {
    if (Build.VERSION.SDK_INT >= 17)
      return TextUtils.htmlEncode(paramString); 
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramString.length(); i++) {
      char c = paramString.charAt(i);
      if (c != '"') {
        if (c != '<') {
          if (c != '>') {
            if (c != '&') {
              if (c != '\'') {
                stringBuilder.append(c);
              } else {
                stringBuilder.append("&#39;");
              } 
            } else {
              stringBuilder.append("&amp;");
            } 
          } else {
            stringBuilder.append("&gt;");
          } 
        } else {
          stringBuilder.append("&lt;");
        } 
      } else {
        stringBuilder.append("&quot;");
      } 
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\text\TextUtilsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */