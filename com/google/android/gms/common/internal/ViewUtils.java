package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class ViewUtils {
  public static String getXmlAttributeString(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, String paramString3) {
    if (paramAttributeSet == null) {
      paramString1 = null;
    } else {
      paramString1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
    } 
    String str = paramString1;
    if (paramString1 != null) {
      str = paramString1;
      if (paramString1.startsWith("@string/")) {
        str = paramString1;
        if (paramBoolean1) {
          String str1;
          String str2 = paramString1.substring(8);
          String str3 = paramContext.getPackageName();
          TypedValue typedValue = new TypedValue();
          try {
            Resources resources = paramContext.getResources();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str3).length() + 8 + String.valueOf(str2).length());
            stringBuilder.append(str3);
            stringBuilder.append(":string/");
            stringBuilder.append(str2);
            resources.getValue(stringBuilder.toString(), typedValue, true);
          } catch (android.content.res.Resources.NotFoundException notFoundException) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 30 + String.valueOf(paramString1).length());
            stringBuilder.append("Could not find resource for ");
            stringBuilder.append(paramString2);
            stringBuilder.append(": ");
            stringBuilder.append(paramString1);
            Log.w(paramString3, stringBuilder.toString());
          } 
          if (typedValue.string != null) {
            str1 = typedValue.string.toString();
          } else {
            String str4 = String.valueOf(str1);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 28 + String.valueOf(str4).length());
            stringBuilder.append("Resource ");
            stringBuilder.append(paramString2);
            stringBuilder.append(" was not a string: ");
            stringBuilder.append(str4);
            Log.w(paramString3, stringBuilder.toString());
            str = paramString1;
          } 
        } 
      } 
    } 
    if (paramBoolean2 && str == null) {
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 33);
      stringBuilder.append("Required XML attribute \"");
      stringBuilder.append(paramString2);
      stringBuilder.append("\" missing");
      Log.w(paramString3, stringBuilder.toString());
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */