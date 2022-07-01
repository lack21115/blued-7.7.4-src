package com.ta.utdid2.a.a;

import java.util.regex.Pattern;

public class g {
  private static final Pattern a = Pattern.compile("([\t\r\n])+");
  
  public static int a(String paramString) {
    boolean bool;
    int i = paramString.length();
    int j = 0;
    if (i > 0) {
      char[] arrayOfChar = paramString.toCharArray();
      i = 0;
      while (true) {
        bool = i;
        if (j < arrayOfChar.length) {
          i = i * 31 + arrayOfChar[j];
          j++;
          continue;
        } 
        break;
      } 
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static boolean a(String paramString) {
    return !(paramString != null && paramString.length() > 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */