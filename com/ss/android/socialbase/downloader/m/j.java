package com.ss.android.socialbase.downloader.m;

public class j {
  public static String a(String paramString1, String paramString2, String[] paramArrayOfString) {
    StringBuilder stringBuilder = new StringBuilder(paramString1);
    stringBuilder.append('"');
    stringBuilder.append(paramString2);
    stringBuilder.append('"');
    stringBuilder.append(" (");
    a(stringBuilder, paramArrayOfString);
    stringBuilder.append(") VALUES (");
    a(stringBuilder, paramArrayOfString.length);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
  
  public static String a(String paramString, String[] paramArrayOfString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('"');
    stringBuilder.append(paramString);
    stringBuilder.append('"');
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder("DELETE FROM ");
    stringBuilder.append(paramString);
    if (paramArrayOfString != null && paramArrayOfString.length > 0) {
      stringBuilder.append(" WHERE ");
      a(stringBuilder, paramString, paramArrayOfString);
    } 
    return stringBuilder.toString();
  }
  
  public static String a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('"');
    stringBuilder.append(paramString);
    stringBuilder.append('"');
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder("UPDATE ");
    stringBuilder.append(paramString);
    stringBuilder.append(" SET ");
    b(stringBuilder, paramArrayOfString1);
    if (paramArrayOfString2 != null && paramArrayOfString2.length > 0) {
      stringBuilder.append(" WHERE ");
      a(stringBuilder, paramString, paramArrayOfString2);
    } 
    return stringBuilder.toString();
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, int paramInt) {
    for (int i = 0; i < paramInt; i++) {
      if (i < paramInt - 1) {
        paramStringBuilder.append("?,");
      } else {
        paramStringBuilder.append('?');
      } 
    } 
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString) {
    paramStringBuilder.append('"');
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString1, String paramString2) {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(".\"");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString) {
    for (int i = 0; i < paramArrayOfString.length; i++) {
      a(paramStringBuilder, paramString, paramArrayOfString[i]).append("=?");
      if (i < paramArrayOfString.length - 1)
        paramStringBuilder.append(','); 
    } 
    return paramStringBuilder;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, String[] paramArrayOfString) {
    int k = paramArrayOfString.length;
    for (int i = 0; i < k; i++) {
      paramStringBuilder.append('"');
      paramStringBuilder.append(paramArrayOfString[i]);
      paramStringBuilder.append('"');
      if (i < k - 1)
        paramStringBuilder.append(','); 
    } 
    return paramStringBuilder;
  }
  
  public static StringBuilder b(StringBuilder paramStringBuilder, String[] paramArrayOfString) {
    for (int i = 0; i < paramArrayOfString.length; i++) {
      a(paramStringBuilder, paramArrayOfString[i]).append("=?");
      if (i < paramArrayOfString.length - 1)
        paramStringBuilder.append(','); 
    } 
    return paramStringBuilder;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */