package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k {
  private static final Pattern a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
  
  private static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
  
  public static long a(String paramString) {
    a a;
    boolean bool1;
    boolean bool2;
    int i;
    Matcher matcher = a.matcher(paramString);
    if (matcher.find()) {
      bool2 = b(matcher.group(1));
      bool1 = c(matcher.group(2));
      i = d(matcher.group(3));
      a = e(matcher.group(4));
    } else {
      matcher = b.matcher((CharSequence)a);
      if (matcher.find()) {
        bool1 = c(matcher.group(1));
        bool2 = b(matcher.group(2));
        a = e(matcher.group(3));
        i = d(matcher.group(4));
      } else {
        throw new IllegalArgumentException();
      } 
    } 
    if (i >= 2038) {
      bool2 = true;
      bool1 = false;
      i = 2038;
    } 
    Time time = new Time("UTC");
    time.set(a.c, a.b, a.a, bool2, bool1, i);
    return time.toMillis(false);
  }
  
  private static int b(String paramString) {
    return (paramString.length() == 2) ? ((paramString.charAt(0) - 48) * 10 + paramString.charAt(1) - 48) : (paramString.charAt(0) - 48);
  }
  
  private static int c(String paramString) {
    int i = Character.toLowerCase(paramString.charAt(0)) + Character.toLowerCase(paramString.charAt(1)) + Character.toLowerCase(paramString.charAt(2)) - 291;
    byte b = 9;
    if (i != 9) {
      if (i != 10) {
        if (i != 22) {
          if (i != 26) {
            if (i != 29) {
              if (i != 32) {
                if (i != 40) {
                  if (i != 42) {
                    if (i != 48) {
                      switch (i) {
                        default:
                          throw new IllegalArgumentException();
                        case 37:
                          return 8;
                        case 36:
                          b = 4;
                          break;
                        case 35:
                          break;
                      } 
                      return b;
                    } 
                    return 10;
                  } 
                  return 5;
                } 
                return 6;
              } 
              return 3;
            } 
            return 2;
          } 
          return 7;
        } 
        return 0;
      } 
      return 1;
    } 
    return 11;
  }
  
  private static int d(String paramString) {
    if (paramString.length() == 2) {
      int i = (paramString.charAt(0) - 48) * 10 + paramString.charAt(1) - 48;
      return (i >= 70) ? (i + 1900) : (i + 2000);
    } 
    return (paramString.length() == 3) ? ((paramString.charAt(0) - 48) * 100 + (paramString.charAt(1) - 48) * 10 + paramString.charAt(2) - 48 + 1900) : ((paramString.length() == 4) ? ((paramString.charAt(0) - 48) * 1000 + (paramString.charAt(1) - 48) * 100 + (paramString.charAt(2) - 48) * 10 + paramString.charAt(3) - 48) : 1970);
  }
  
  private static a e(String paramString) {
    int i = paramString.charAt(0) - 48;
    if (paramString.charAt(1) != ':') {
      j = 2;
      i = i * 10 + paramString.charAt(1) - 48;
    } else {
      j = 1;
    } 
    int m = j + 1;
    int j = m + 1;
    m = paramString.charAt(m);
    char c = paramString.charAt(j);
    j = j + 1 + 1;
    return new a(i, (m - 48) * 10 + c - 48, (paramString.charAt(j) - 48) * 10 + paramString.charAt(j + 1) - 48);
  }
  
  static final class a {
    int a;
    
    int b;
    
    int c;
    
    a(int param1Int1, int param1Int2, int param1Int3) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */