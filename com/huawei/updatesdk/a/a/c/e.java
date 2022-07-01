package com.huawei.updatesdk.a.a.c;

import java.util.List;

public class e {
  private static String a(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public static String a(List<String> paramList, String paramString) {
    return a(paramList, paramString, (String)null, (String)null);
  }
  
  public static String a(List<String> paramList, String paramString1, String paramString2, String paramString3) {
    return (paramList != null && !paramList.isEmpty()) ? a(paramList.<String>toArray(new String[0]), paramString1, paramString2, paramString3) : "";
  }
  
  public static String a(String[] paramArrayOfString, String paramString) {
    return a(paramArrayOfString, paramString, (String)null, (String)null);
  }
  
  public static String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {
    if (paramArrayOfString != null && paramArrayOfString.length != 0) {
      paramString1 = a(paramString1);
      paramString2 = a(paramString2);
      paramString3 = a(paramString3);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append(paramArrayOfString[0]);
      stringBuilder.append(paramString3);
      int i;
      for (i = 1; i < paramArrayOfString.length; i++) {
        stringBuilder.append(paramString1);
        stringBuilder.append(paramString2);
        stringBuilder.append(paramArrayOfString[i]);
        stringBuilder.append(paramString3);
      } 
      return stringBuilder.toString();
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */