package org.chromium.content.browser.picker;

import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import java.util.IllegalFormatConversionException;
import java.util.Locale;
import java.util.regex.Pattern;

class DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug$WrappedResources extends Resources {
  DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug$WrappedResources(AssetManager paramAssetManager, DisplayMetrics paramDisplayMetrics, Configuration paramConfiguration) {
    super(paramAssetManager, paramDisplayMetrics, paramConfiguration);
  }
  
  public String getString(int paramInt, Object... paramVarArgs) {
    Locale locale;
    String str;
    try {
      return super.getString(paramInt, paramVarArgs);
    } catch (IllegalFormatConversionException illegalFormatConversionException) {
      String str1 = getString(paramInt);
      char c = illegalFormatConversionException.getConversion();
      StringBuilder stringBuilder = new StringBuilder("%");
      stringBuilder.append(c);
      str1 = str1.replaceAll(Pattern.quote(stringBuilder.toString()), "%s");
      stringBuilder = new StringBuilder("%1$");
      stringBuilder.append(c);
      str = str1.replaceAll(Pattern.quote(stringBuilder.toString()), "%s");
      if (Build.VERSION.SDK_INT >= 24) {
        LocaleList localeList = getConfiguration().getLocales();
        if (localeList.size() > 0) {
          Locale locale1 = localeList.get(0);
          return String.format(locale1, str, paramVarArgs);
        } 
      } 
      locale = (getConfiguration()).locale;
    } 
    return String.format(locale, str, paramVarArgs);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\DateTimePickerDialog$WorkaroundContextForSamsungLDateTimeBug$WrappedResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */