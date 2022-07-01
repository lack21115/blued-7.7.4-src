package com.google.zxing.client.result;

public abstract class ParsedResult {
  public static void a(String paramString, StringBuilder paramStringBuilder) {
    if (paramString != null && !paramString.isEmpty()) {
      if (paramStringBuilder.length() > 0)
        paramStringBuilder.append('\n'); 
      paramStringBuilder.append(paramString);
    } 
  }
  
  public static void a(String[] paramArrayOfString, StringBuilder paramStringBuilder) {
    if (paramArrayOfString != null) {
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++)
        a(paramArrayOfString[i], paramStringBuilder); 
    } 
  }
  
  public abstract String a();
  
  public final String toString() {
    return a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\ParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */