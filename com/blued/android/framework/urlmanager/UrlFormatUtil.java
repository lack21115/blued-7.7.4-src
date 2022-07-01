package com.blued.android.framework.urlmanager;

public class UrlFormatUtil {
  public static String a(String paramString1, String paramString2, Object... paramVarArgs) {
    int i;
    if (paramString1 == null)
      return ""; 
    int j = 0;
    if (paramVarArgs == null) {
      i = 0;
    } else {
      i = paramVarArgs.length;
    } 
    int k = Integer.parseInt(paramString1.substring(0, 1), 16) + 1;
    String[] arrayOfString = new String[k];
    while (j < k) {
      String str;
      if (j < i) {
        str = String.valueOf(paramVarArgs[j]);
      } else {
        str = "";
      } 
      arrayOfString[j] = str;
      j++;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append(paramString1.substring(1));
    return String.format(stringBuilder.toString(), (Object[])arrayOfString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\urlmanager\UrlFormatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */