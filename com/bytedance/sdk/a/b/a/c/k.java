package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.net.ProtocolException;

public final class k {
  public final w a;
  
  public final int b;
  
  public final String c;
  
  public k(w paramw, int paramInt, String paramString) {
    this.a = paramw;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public static k a(aa paramaa) {
    return new k(paramaa.b(), paramaa.c(), paramaa.d());
  }
  
  public static k a(String paramString) throws IOException {
    boolean bool = paramString.startsWith("HTTP/1.");
    byte b = 9;
    if (bool) {
      if (paramString.length() >= 9 && paramString.charAt(8) == ' ') {
        int m = paramString.charAt(7) - 48;
        if (m == 0) {
          w w1 = w.a;
        } else if (m == 1) {
          w w1 = w.b;
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Unexpected status line: ");
          stringBuilder1.append(paramString);
          throw new ProtocolException(stringBuilder1.toString());
        } 
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpected status line: ");
        stringBuilder1.append(paramString);
        throw new ProtocolException(stringBuilder1.toString());
      } 
    } else if (paramString.startsWith("ICY ")) {
      w w1 = w.a;
      b = 4;
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Unexpected status line: ");
      stringBuilder1.append(paramString);
      throw new ProtocolException(stringBuilder1.toString());
    } 
    int j = paramString.length();
    int i = b + 3;
    if (j >= i)
      try {
        StringBuilder stringBuilder1;
        j = Integer.parseInt(paramString.substring(b, i));
        if (paramString.length() > i) {
          if (paramString.charAt(i) == ' ') {
            paramString = paramString.substring(b + 4);
          } else {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Unexpected status line: ");
            stringBuilder1.append(paramString);
            throw new ProtocolException(stringBuilder1.toString());
          } 
        } else {
          paramString = "";
        } 
        return new k((w)stringBuilder1, j, paramString);
      } catch (NumberFormatException numberFormatException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpected status line: ");
        stringBuilder1.append(paramString);
        throw new ProtocolException(stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected status line: ");
    stringBuilder.append(paramString);
    throw new ProtocolException(stringBuilder.toString());
  }
  
  public String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (this.a == w.a) {
      str = "HTTP/1.0";
    } else {
      str = "HTTP/1.1";
    } 
    stringBuilder.append(str);
    stringBuilder.append(' ');
    stringBuilder.append(this.b);
    if (this.c != null) {
      stringBuilder.append(' ');
      stringBuilder.append(this.c);
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */