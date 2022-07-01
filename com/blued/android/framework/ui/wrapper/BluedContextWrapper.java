package com.blued.android.framework.ui.wrapper;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.util.Log;
import com.blued.android.framework.utils.LocaleUtils;
import java.util.Locale;

public class BluedContextWrapper extends ContextWrapper {
  public static ContextWrapper a(Context paramContext) {
    Context context;
    Locale locale = LocaleUtils.c();
    if (locale != null) {
      Context context1;
      Configuration configuration = paramContext.getResources().getConfiguration();
      if (Build.VERSION.SDK_INT >= 24) {
        configuration.setLocales(new LocaleList(new Locale[] { locale }));
        context1 = paramContext.createConfigurationContext(configuration);
      } else {
        context1 = paramContext;
        if (Build.VERSION.SDK_INT >= 19) {
          configuration.setLocale(locale);
          context1 = paramContext.createConfigurationContext(configuration);
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("locale :");
      stringBuilder.append(locale.getLanguage());
      stringBuilder.append(":");
      stringBuilder.append(locale.getCountry());
      Log.i("BluedContextWrapper", stringBuilder.toString());
      context = context1;
    } else {
      Log.i("BluedContextWrapper", "locale null");
    } 
    return new ContextWrapper(context);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\wrapper\BluedContextWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */