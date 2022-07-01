package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.o;

public class e {
  public static String a = "com.bytedance.openadsdk";
  
  public static String b;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("content://");
    stringBuilder.append(a);
    stringBuilder.append(".TTMultiProvider");
    b = stringBuilder.toString();
    a();
  }
  
  public static void a() {
    if (o.a() != null) {
      a = o.a().getPackageName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("content://");
      stringBuilder.append(a);
      stringBuilder.append(".TTMultiProvider");
      b = stringBuilder.toString();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */