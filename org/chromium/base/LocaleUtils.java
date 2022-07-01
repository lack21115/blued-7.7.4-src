package org.chromium.base;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Locale;
import org.chromium.base.annotations.CalledByNative;

public class LocaleUtils {
  @CalledByNative
  private static String getDefaultCountryCode() {
    CommandLine commandLine = CommandLine.getInstance();
    return commandLine.hasSwitch("default-country-code") ? commandLine.getSwitchValue("default-country-code") : Locale.getDefault().getCountry();
  }
  
  public static String getDefaultLocaleListString() {
    if (Build.VERSION.SDK_INT >= 24) {
      LocaleList localeList = LocaleList.getDefault();
      ArrayList<String> arrayList = new ArrayList();
      for (int i = 0; i < localeList.size(); i++) {
        Locale locale = localeList.get(i);
        String str1 = locale.getLanguage();
        String str2 = getUpdatedLanguageForChromium(str1);
        if (!str2.equals(str1))
          locale = (new Locale.Builder()).setLocale(locale).setLanguage(str2).build(); 
        arrayList.add(toLanguageTag(locale));
      } 
      return TextUtils.join(",", arrayList);
    } 
    return getDefaultLocaleString();
  }
  
  @CalledByNative
  public static String getDefaultLocaleString() {
    return toLanguageTag(Locale.getDefault());
  }
  
  public static String getUpdatedLanguageForChromium(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual hashCode : ()I
    //   4: istore_1
    //   5: iload_1
    //   6: sipush #3365
    //   9: if_icmpeq -> 78
    //   12: iload_1
    //   13: sipush #3374
    //   16: if_icmpeq -> 64
    //   19: iload_1
    //   20: sipush #3391
    //   23: if_icmpeq -> 50
    //   26: iload_1
    //   27: sipush #3704
    //   30: if_icmpeq -> 36
    //   33: goto -> 92
    //   36: aload_0
    //   37: ldc 'tl'
    //   39: invokevirtual equals : (Ljava/lang/Object;)Z
    //   42: ifeq -> 92
    //   45: iconst_3
    //   46: istore_1
    //   47: goto -> 94
    //   50: aload_0
    //   51: ldc 'ji'
    //   53: invokevirtual equals : (Ljava/lang/Object;)Z
    //   56: ifeq -> 92
    //   59: iconst_1
    //   60: istore_1
    //   61: goto -> 94
    //   64: aload_0
    //   65: ldc 'iw'
    //   67: invokevirtual equals : (Ljava/lang/Object;)Z
    //   70: ifeq -> 92
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -> 94
    //   78: aload_0
    //   79: ldc 'in'
    //   81: invokevirtual equals : (Ljava/lang/Object;)Z
    //   84: ifeq -> 92
    //   87: iconst_2
    //   88: istore_1
    //   89: goto -> 94
    //   92: iconst_m1
    //   93: istore_1
    //   94: iload_1
    //   95: tableswitch default -> 124, 0 -> 135, 1 -> 132, 2 -> 129, 3 -> 126
    //   124: aload_0
    //   125: areturn
    //   126: ldc 'fil'
    //   128: areturn
    //   129: ldc 'id'
    //   131: areturn
    //   132: ldc 'yi'
    //   134: areturn
    //   135: ldc 'he'
    //   137: areturn
  }
  
  private static String toLanguageTag(Locale paramLocale) {
    String str1 = getUpdatedLanguageForChromium(paramLocale.getLanguage());
    String str2 = paramLocale.getCountry();
    if (str1.equals("no") && str2.equals("NO") && paramLocale.getVariant().equals("NY"))
      return "nn-NO"; 
    if (str2.isEmpty())
      return str1; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append("-");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\LocaleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */