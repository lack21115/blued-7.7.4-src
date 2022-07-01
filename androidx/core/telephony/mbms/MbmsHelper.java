package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;

public final class MbmsHelper {
  public static CharSequence getBestNameForService(Context paramContext, ServiceInfo paramServiceInfo) {
    if (Build.VERSION.SDK_INT < 28)
      return null; 
    LocaleList localeList = paramContext.getResources().getConfiguration().getLocales();
    int i = paramServiceInfo.getNamedContentLocales().size();
    if (i == 0)
      return null; 
    String[] arrayOfString = new String[i];
    i = 0;
    Iterator<Locale> iterator = paramServiceInfo.getNamedContentLocales().iterator();
    while (iterator.hasNext()) {
      arrayOfString[i] = ((Locale)iterator.next()).toLanguageTag();
      i++;
    } 
    Locale locale = localeList.getFirstMatch(arrayOfString);
    return (locale == null) ? null : paramServiceInfo.getNameForLocale(locale);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\telephony\mbms\MbmsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */