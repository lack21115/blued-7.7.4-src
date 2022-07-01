package org.chromium.content.common;

public final class ContentSwitchUtils {
  public static String getSwitchValue(String[] paramArrayOfString, String paramString) {
    if (paramArrayOfString != null) {
      if (paramString == null)
        return null; 
      StringBuilder stringBuilder = new StringBuilder("--");
      stringBuilder.append(paramString);
      stringBuilder.append("=");
      paramString = stringBuilder.toString();
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++) {
        String str = paramArrayOfString[i];
        if (str != null && str.startsWith(paramString))
          return str.substring(paramString.length()); 
      } 
      return null;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\common\ContentSwitchUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */