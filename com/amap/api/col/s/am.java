package com.amap.api.col.s;

import android.content.Context;

public final class am {
  static de a;
  
  private static String a(String paramString, long paramLong, boolean paramBoolean) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("{");
      stringBuilder.append("\"RequestPath\":\"");
      stringBuilder.append(paramString);
      stringBuilder.append("\"");
      stringBuilder.append(",");
      stringBuilder.append("\"ResponseTime\":");
      stringBuilder.append(paramLong);
      stringBuilder.append(",");
      stringBuilder.append("\"Success\":");
      return stringBuilder.toString();
    } finally {
      paramString = null;
      i.a((Throwable)paramString, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
    } 
  }
  
  private static String a(String paramString, boolean paramBoolean) {
    String str1 = "";
    try {
      int j = paramString.indexOf("?");
    } finally {
      paramString = null;
      i.a((Throwable)paramString, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
    } 
    String str2 = paramString;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{");
    stringBuilder.append("\"RequestPath\":\"");
    stringBuilder.append(str2);
    stringBuilder.append("\"");
    stringBuilder.append(",");
    stringBuilder.append("\"RequestParm\":\"");
    stringBuilder.append(str1);
    stringBuilder.append("\"");
    stringBuilder.append(",");
    stringBuilder.append("\"IsCacheRequest\":");
    stringBuilder.append(paramBoolean);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong, boolean paramBoolean) {
    try {
      return;
    } finally {
      paramContext = null;
      i.a((Throwable)paramContext, "StatisticsUtil", "recordResponseAction");
    } 
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean) {
    try {
      return;
    } finally {
      paramContext = null;
      i.a((Throwable)paramContext, "StatisticsUtil", "recordResponseAction");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */