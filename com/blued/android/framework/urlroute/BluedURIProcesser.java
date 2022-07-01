package com.blued.android.framework.urlroute;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URLEncoder;

public class BluedURIProcesser {
  public static boolean navigation(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("http://maps.google.com/maps?daddr=");
      stringBuilder.append(paramString2);
      stringBuilder.append(",");
      stringBuilder.append(paramString1);
      paramString2 = stringBuilder.toString();
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString3)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString2);
        stringBuilder1.append("(");
        stringBuilder1.append(URLEncoder.encode(paramString3));
        stringBuilder1.append(")");
        str = stringBuilder1.toString();
      } 
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\urlroute\BluedURIProcesser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */