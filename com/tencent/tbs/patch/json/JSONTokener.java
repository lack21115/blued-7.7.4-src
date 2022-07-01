package com.tencent.tbs.patch.json;

public class JSONTokener {
  private final String a;
  
  private int b;
  
  public JSONTokener(String paramString) {
    this.a = paramString;
  }
  
  private int a() {
    while (this.b < this.a.length()) {
      String str = this.a;
      int i = this.b;
      this.b = i + 1;
      i = str.charAt(i);
      if (i != 13 && i != 32) {
        if (i != 47) {
          switch (i) {
            case 9:
            case 10:
              continue;
          } 
          return i;
        } 
        if (this.b == this.a.length())
          return i; 
        char c = this.a.charAt(this.b);
        if (c != '*' && c != '/')
          return i; 
        b();
      } 
    } 
    return -1;
  }
  
  private String a(String paramString) {
    int i = this.b;
    while (this.b < this.a.length()) {
      char c = this.a.charAt(this.b);
      if (c == '\r' || c == '\n' || paramString.indexOf(c) != -1)
        return this.a.substring(i, this.b); 
      this.b++;
    } 
    return this.a.substring(i);
  }
  
  private void b() {
    String str = this.a;
    int i = this.b;
    this.b = i + 1;
    if (str.charAt(i) == '*') {
      i = this.a.indexOf("*/", this.b);
      if (i != -1) {
        i += 2;
      } else {
        throw syntaxError("Unterminated comment");
      } 
    } else {
      while (true) {
        if (this.b < this.a.length()) {
          i = this.a.charAt(this.b);
          if (i == 13 || i == 10) {
            i = this.b + 1;
          } else {
            this.b++;
            continue;
          } 
        } else {
          break;
        } 
        this.b = i;
        return;
      } 
      return;
    } 
    this.b = i;
  }
  
  private char c() {
    String str = this.a;
    int i = this.b;
    this.b = i + 1;
    char c = str.charAt(i);
    if (c != 'b') {
      if (c != 'f') {
        if (c != 'n') {
          if (c != 'r') {
            switch (c) {
              default:
                return c;
              case 'u':
                if (this.b + 4 <= this.a.length()) {
                  str = this.a;
                  i = this.b;
                  str = str.substring(i, i + 4);
                  this.b += 4;
                  return (char)Integer.parseInt(str, 16);
                } 
                throw syntaxError("Unterminated escape sequence");
              case 't':
                break;
            } 
            return '\t';
          } 
          return '\r';
        } 
        return '\n';
      } 
      return '\f';
    } 
    return '\b';
  }
  
  private Object d() {
    String str = a("{}[]/\\:,=;# \t\f");
    if (str.length() != 0) {
      if ("null".equalsIgnoreCase(str))
        return JSONObject.NULL; 
      if ("true".equalsIgnoreCase(str))
        return Boolean.TRUE; 
      if ("false".equalsIgnoreCase(str))
        return Boolean.FALSE; 
      if (str.indexOf('.') == -1) {
        byte b;
        String str1;
        if (str.startsWith("0x") || str.startsWith("0X")) {
          str1 = str.substring(2);
          b = 16;
        } else if (str.startsWith("0") && str.length() > 1) {
          str1 = str.substring(1);
          b = 8;
        } else {
          str1 = str;
          b = 10;
        } 
        try {
          long l = Long.parseLong(str1, b);
          return (l <= 2147483647L && l >= -2147483648L) ? Integer.valueOf((int)l) : Long.valueOf(l);
        } catch (NumberFormatException numberFormatException) {}
      } 
      try {
        return Double.valueOf(str);
      } catch (NumberFormatException numberFormatException) {
        return new String(str);
      } 
    } 
    throw syntaxError("Expected literal value");
  }
  
  public static int dehexchar(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    byte b = 65;
    if (paramChar < 'A' || paramChar > 'F') {
      b = 97;
      if (paramChar < 'a' || paramChar > 'f')
        return -1; 
    } 
    return paramChar - b + 10;
  }
  
  private JSONObject e() {
    JSONObject jSONObject = new JSONObject();
    int i = a();
    if (i == 125)
      return jSONObject; 
    if (i != -1)
      this.b--; 
    while (true) {
      Object object = nextValue();
      if (!(object instanceof String)) {
        if (object == null)
          throw syntaxError("Names cannot be null"); 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Names must be strings, but ");
        stringBuilder.append(object);
        stringBuilder.append(" is of type ");
        stringBuilder.append(object.getClass().getName());
        throw syntaxError(stringBuilder.toString());
      } 
      i = a();
      if (i == 58 || i == 61) {
        if (this.b < this.a.length() && this.a.charAt(this.b) == '>')
          this.b++; 
        stringBuilder.put((String)object, nextValue());
        i = a();
        if (i != 44 && i != 59) {
          if (i == 125)
            return (JSONObject)stringBuilder; 
          throw syntaxError("Unterminated object");
        } 
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected ':' after ");
      stringBuilder.append(object);
      throw syntaxError(stringBuilder.toString());
    } 
  }
  
  private JSONArray f() {
    JSONArray jSONArray = new JSONArray();
    int i = 0;
    while (true) {
      int j = a();
      if (j != -1) {
        if (j != 44 && j != 59) {
          if (j != 93) {
            this.b--;
            jSONArray.put(nextValue());
            i = a();
            if (i != 44 && i != 59) {
              if (i == 93)
                return jSONArray; 
              throw syntaxError("Unterminated array");
            } 
          } else {
            if (i != 0)
              jSONArray.put((Object)null); 
            return jSONArray;
          } 
        } else {
          jSONArray.put((Object)null);
        } 
        i = 1;
        continue;
      } 
      throw syntaxError("Unterminated array");
    } 
  }
  
  public void back() {
    int i = this.b - 1;
    this.b = i;
    if (i == -1)
      this.b = 0; 
  }
  
  public boolean more() {
    return (this.b < this.a.length());
  }
  
  public char next() {
    if (this.b < this.a.length()) {
      String str = this.a;
      int i = this.b;
      this.b = i + 1;
      return str.charAt(i);
    } 
    return Character.MIN_VALUE;
  }
  
  public char next(char paramChar) {
    char c = next();
    if (c == paramChar)
      return c; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected ");
    stringBuilder.append(paramChar);
    stringBuilder.append(" but was ");
    stringBuilder.append(c);
    throw syntaxError(stringBuilder.toString());
  }
  
  public String next(int paramInt) {
    if (this.b + paramInt <= this.a.length()) {
      String str = this.a;
      int i = this.b;
      str = str.substring(i, i + paramInt);
      this.b += paramInt;
      return str;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append(" is out of bounds");
    throw syntaxError(stringBuilder.toString());
  }
  
  public char nextClean() {
    int i = a();
    return (i == -1) ? Character.MIN_VALUE : (char)i;
  }
  
  public String nextString(char paramChar) {
    int i = this.b;
    StringBuilder stringBuilder = null;
    while (this.b < this.a.length()) {
      String str = this.a;
      int j = this.b;
      this.b = j + 1;
      j = str.charAt(j);
      if (j == paramChar) {
        if (stringBuilder == null)
          return new String(this.a.substring(i, this.b - 1)); 
        stringBuilder.append(this.a, i, this.b - 1);
        return stringBuilder.toString();
      } 
      if (j == 92) {
        if (this.b != this.a.length()) {
          StringBuilder stringBuilder1 = stringBuilder;
          if (stringBuilder == null)
            stringBuilder1 = new StringBuilder(); 
          stringBuilder1.append(this.a, i, this.b - 1);
          stringBuilder1.append(c());
          i = this.b;
          stringBuilder = stringBuilder1;
          continue;
        } 
        throw syntaxError("Unterminated escape sequence");
      } 
    } 
    throw syntaxError("Unterminated string");
  }
  
  public String nextTo(char paramChar) {
    return a(String.valueOf(paramChar)).trim();
  }
  
  public String nextTo(String paramString) {
    if (paramString != null)
      return a(paramString).trim(); 
    throw new NullPointerException();
  }
  
  public Object nextValue() {
    int i = a();
    if (i != -1) {
      if (i != 34 && i != 39) {
        if (i != 91) {
          if (i != 123) {
            this.b--;
            return d();
          } 
          return e();
        } 
        return f();
      } 
      return nextString((char)i);
    } 
    throw syntaxError("End of input");
  }
  
  public void skipPast(String paramString) {
    int i = this.a.indexOf(paramString, this.b);
    if (i == -1) {
      i = this.a.length();
    } else {
      i = paramString.length() + i;
    } 
    this.b = i;
  }
  
  public char skipTo(char paramChar) {
    int i = this.a.indexOf(paramChar, this.b);
    if (i != -1) {
      this.b = i;
      return paramChar;
    } 
    return Character.MIN_VALUE;
  }
  
  public JSONException syntaxError(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(this);
    return new JSONException(stringBuilder.toString());
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" at character ");
    stringBuilder.append(this.b);
    stringBuilder.append(" of ");
    stringBuilder.append(this.a);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\json\JSONTokener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */