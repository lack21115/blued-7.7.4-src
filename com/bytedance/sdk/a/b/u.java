package com.bytedance.sdk.a.b;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class u {
  private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  
  private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  
  private final String c;
  
  private final String d;
  
  private final String e;
  
  private final String f;
  
  private u(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public static u a(String paramString) {
    String str1;
    Matcher matcher1 = a.matcher(paramString);
    if (!matcher1.lookingAt())
      return null; 
    String str2 = matcher1.group(1).toLowerCase(Locale.US);
    String str3 = matcher1.group(2).toLowerCase(Locale.US);
    Matcher matcher3 = b.matcher(paramString);
    int i = matcher1.end();
    Matcher matcher2 = null;
    while (i < paramString.length()) {
      String str4;
      matcher3.region(i, paramString.length());
      if (!matcher3.lookingAt())
        return null; 
      String str5 = matcher3.group(1);
      matcher1 = matcher2;
      if (str5 != null)
        if (!str5.equalsIgnoreCase("charset")) {
          matcher1 = matcher2;
        } else {
          str5 = matcher3.group(2);
          if (str5 != null) {
            str4 = str5;
            if (str5.startsWith("'")) {
              str4 = str5;
              if (str5.endsWith("'")) {
                str4 = str5;
                if (str5.length() > 2)
                  str4 = str5.substring(1, str5.length() - 1); 
              } 
            } 
          } else {
            str4 = matcher3.group(3);
          } 
          if (matcher2 != null && !str4.equalsIgnoreCase((String)matcher2))
            return null; 
        }  
      i = matcher3.end();
      str1 = str4;
    } 
    return new u(paramString, str2, str3, str1);
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof u && ((u)paramObject).c.equals(this.c));
  }
  
  public int hashCode() {
    return this.c.hashCode();
  }
  
  public String toString() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */