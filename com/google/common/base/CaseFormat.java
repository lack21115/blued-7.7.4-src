package com.google.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public enum CaseFormat {
  a(CharMatcher.a('-'), "-") {
    String a(String param1String) {
      return Ascii.a(param1String);
    }
    
    String b(CaseFormat param1CaseFormat, String param1String) {
      return (param1CaseFormat == b) ? param1String.replace('-', '_') : ((param1CaseFormat == e) ? Ascii.b(param1String.replace('-', '_')) : super.b(param1CaseFormat, param1String));
    }
  },
  b(CharMatcher.a('_'), "_") {
    String a(String param1String) {
      return Ascii.a(param1String);
    }
    
    String b(CaseFormat param1CaseFormat, String param1String) {
      return (param1CaseFormat == a) ? param1String.replace('_', '-') : ((param1CaseFormat == e) ? Ascii.b(param1String) : super.b(param1CaseFormat, param1String));
    }
  },
  c(CharMatcher.a('A', 'Z'), "") {
    String a(String param1String) {
      return c(param1String);
    }
    
    String b(String param1String) {
      return Ascii.a(param1String);
    }
  },
  d(CharMatcher.a('A', 'Z'), "") {
    String a(String param1String) {
      return c(param1String);
    }
  },
  e(CharMatcher.a('_'), "_") {
    String a(String param1String) {
      return Ascii.b(param1String);
    }
    
    String b(CaseFormat param1CaseFormat, String param1String) {
      return (param1CaseFormat == a) ? Ascii.a(param1String.replace('_', '-')) : ((param1CaseFormat == b) ? Ascii.a(param1String) : super.b(param1CaseFormat, param1String));
    }
  };
  
  private final CharMatcher f;
  
  private final String g;
  
  CaseFormat(CharMatcher paramCharMatcher, String paramString1) {
    this.f = paramCharMatcher;
    this.g = paramString1;
  }
  
  private static String d(String paramString) {
    if (paramString.isEmpty())
      return paramString; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Ascii.a(paramString.charAt(0)));
    stringBuilder.append(Ascii.a(paramString.substring(1)));
    return stringBuilder.toString();
  }
  
  public final String a(CaseFormat paramCaseFormat, String paramString) {
    Preconditions.a(paramCaseFormat);
    Preconditions.a(paramString);
    return (paramCaseFormat == this) ? paramString : b(paramCaseFormat, paramString);
  }
  
  abstract String a(String paramString);
  
  String b(CaseFormat paramCaseFormat, String paramString) {
    int i = 0;
    StringBuilder stringBuilder = null;
    int j = -1;
    while (true) {
      j = this.f.a(paramString, j + 1);
      if (j != -1) {
        if (!i) {
          stringBuilder = new StringBuilder(paramString.length() + paramCaseFormat.g.length() * 4);
          stringBuilder.append(paramCaseFormat.b(paramString.substring(i, j)));
        } else {
          stringBuilder.append(paramCaseFormat.a(paramString.substring(i, j)));
        } 
        stringBuilder.append(paramCaseFormat.g);
        i = this.g.length() + j;
        continue;
      } 
      if (i == 0)
        return paramCaseFormat.b(paramString); 
      stringBuilder.append(paramCaseFormat.a(paramString.substring(i)));
      return stringBuilder.toString();
    } 
  }
  
  String b(String paramString) {
    return a(paramString);
  }
  
  static final class StringConverter extends Converter<String, String> implements Serializable {
    private final CaseFormat a;
    
    private final CaseFormat b;
    
    protected String a(String param1String) {
      return this.a.a(this.b, param1String);
    }
    
    protected String b(String param1String) {
      return this.b.a(this.a, param1String);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof StringConverter;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a.equals(((StringConverter)param1Object).a)) {
          bool1 = bool2;
          if (this.b.equals(((StringConverter)param1Object).b))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.a.hashCode() ^ this.b.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append(".converterTo(");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\CaseFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */