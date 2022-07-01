package com.bytedance.sdk.a.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum ad {
  a("TLSv1.3"),
  b("TLSv1.2"),
  c("TLSv1.1"),
  d("TLSv1"),
  e("SSLv3");
  
  final String f;
  
  ad(String paramString1) {
    this.f = paramString1;
  }
  
  public static ad a(String paramString) {
    int i = paramString.hashCode();
    if (i != 79201641) {
      if (i != 79923350) {
        switch (i) {
          default:
            i = -1;
            break;
          case -503070501:
            if (paramString.equals("TLSv1.3")) {
              i = 0;
              break;
            } 
          case -503070502:
            if (paramString.equals("TLSv1.2")) {
              i = 1;
              break;
            } 
          case -503070503:
            if (paramString.equals("TLSv1.1")) {
              i = 2;
              break;
            } 
        } 
      } else if (paramString.equals("TLSv1")) {
        i = 3;
      } else {
      
      } 
    } else if (paramString.equals("SSLv3")) {
      i = 4;
    } else {
    
    } 
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i == 4)
              return e; 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected TLS version: ");
            stringBuilder.append(paramString);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
          return d;
        } 
        return c;
      } 
      return b;
    } 
    return a;
  }
  
  static List<ad> a(String... paramVarArgs) {
    ArrayList<ad> arrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
      arrayList.add(a(paramVarArgs[i])); 
    return Collections.unmodifiableList(arrayList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */