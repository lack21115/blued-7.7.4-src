package com.bytedance.sdk.a.b.a.i;

import javax.security.auth.x500.X500Principal;

final class d {
  private final String a;
  
  private final int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private char[] g;
  
  d(X500Principal paramX500Principal) {
    this.a = paramX500Principal.getName("RFC2253");
    this.b = this.a.length();
  }
  
  private int a(int paramInt) {
    int i = paramInt + 1;
    if (i < this.b) {
      paramInt = this.g[paramInt];
      if (paramInt >= 48 && paramInt <= 57) {
        paramInt -= 48;
      } else if (paramInt >= 97 && paramInt <= 102) {
        paramInt -= 87;
      } else if (paramInt >= 65 && paramInt <= 70) {
        paramInt -= 55;
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Malformed DN: ");
        stringBuilder1.append(this.a);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      i = this.g[i];
      if (i >= 48 && i <= 57) {
        i -= 48;
      } else if (i >= 97 && i <= 102) {
        i -= 87;
      } else {
        if (i >= 65 && i <= 70) {
          i -= 55;
          return (paramInt << 4) + i;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Malformed DN: ");
        stringBuilder1.append(this.a);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      return (paramInt << 4) + i;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Malformed DN: ");
    stringBuilder.append(this.a);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private String a() {
    while (true) {
      int j = this.c;
      if (j < this.b && this.g[j] == ' ') {
        this.c = j + 1;
        continue;
      } 
      break;
    } 
    int i = this.c;
    if (i == this.b)
      return null; 
    this.d = i;
    this.c = i + 1;
    while (true) {
      i = this.c;
      if (i < this.b) {
        char[] arrayOfChar = this.g;
        if (arrayOfChar[i] != '=' && arrayOfChar[i] != ' ') {
          this.c = i + 1;
          continue;
        } 
      } 
      break;
    } 
    i = this.c;
    if (i < this.b) {
      this.e = i;
      if (this.g[i] == ' ') {
        while (true) {
          i = this.c;
          if (i < this.b) {
            char[] arrayOfChar2 = this.g;
            if (arrayOfChar2[i] != '=' && arrayOfChar2[i] == ' ') {
              this.c = i + 1;
              continue;
            } 
          } 
          break;
        } 
        char[] arrayOfChar1 = this.g;
        i = this.c;
        if (arrayOfChar1[i] != '=' || i == this.b) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Unexpected end of DN: ");
          stringBuilder1.append(this.a);
          throw new IllegalStateException(stringBuilder1.toString());
        } 
      } 
      this.c++;
      while (true) {
        i = this.c;
        if (i < this.b && this.g[i] == ' ') {
          this.c = i + 1;
          continue;
        } 
        break;
      } 
      i = this.e;
      int j = this.d;
      if (i - j > 4) {
        char[] arrayOfChar1 = this.g;
        if (arrayOfChar1[j + 3] == '.' && (arrayOfChar1[j] == 'O' || arrayOfChar1[j] == 'o')) {
          arrayOfChar1 = this.g;
          i = this.d;
          if (arrayOfChar1[i + 1] == 'I' || arrayOfChar1[i + 1] == 'i') {
            arrayOfChar1 = this.g;
            i = this.d;
            if (arrayOfChar1[i + 2] == 'D' || arrayOfChar1[i + 2] == 'd')
              this.d += 4; 
          } 
        } 
      } 
      char[] arrayOfChar = this.g;
      i = this.d;
      return new String(arrayOfChar, i, this.e - i);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected end of DN: ");
    stringBuilder.append(this.a);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private String b() {
    this.d = ++this.c;
    this.e = this.d;
    while (true) {
      int i = this.c;
      if (i != this.b) {
        char[] arrayOfChar = this.g;
        if (arrayOfChar[i] == '"') {
          this.c = i + 1;
          while (true) {
            i = this.c;
            if (i < this.b && this.g[i] == ' ') {
              this.c = i + 1;
              continue;
            } 
            break;
          } 
          arrayOfChar = this.g;
          i = this.d;
          return new String(arrayOfChar, i, this.e - i);
        } 
        if (arrayOfChar[i] == '\\') {
          arrayOfChar[this.e] = e();
        } else {
          arrayOfChar[this.e] = arrayOfChar[i];
        } 
        this.c++;
        this.e++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected end of DN: ");
      stringBuilder.append(this.a);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  private String c() {
    int i = this.c;
    if (i + 4 < this.b) {
      this.d = i;
      this.c = i + 1;
      while (true) {
        i = this.c;
        if (i != this.b) {
          char[] arrayOfChar = this.g;
          if (arrayOfChar[i] != '+' && arrayOfChar[i] != ',' && arrayOfChar[i] != ';') {
            if (arrayOfChar[i] == ' ') {
              this.e = i;
              this.c = i + 1;
              while (true) {
                i = this.c;
                if (i < this.b && this.g[i] == ' ') {
                  this.c = i + 1;
                  continue;
                } 
                break;
              } 
              break;
            } 
            if (arrayOfChar[i] >= 'A' && arrayOfChar[i] <= 'F')
              arrayOfChar[i] = (char)(arrayOfChar[i] + 32); 
            this.c++;
            continue;
          } 
        } 
        this.e = this.c;
        break;
      } 
      i = this.e;
      int j = this.d;
      int k = i - j;
      if (k >= 5 && (k & 0x1) != 0) {
        byte[] arrayOfByte = new byte[k / 2];
        i = 0;
        j++;
        while (i < arrayOfByte.length) {
          arrayOfByte[i] = (byte)a(j);
          j += 2;
          i++;
        } 
        return new String(this.g, this.d, k);
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Unexpected end of DN: ");
      stringBuilder1.append(this.a);
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected end of DN: ");
    stringBuilder.append(this.a);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private String d() {
    int i = this.c;
    this.d = i;
    this.e = i;
    while (true) {
      i = this.c;
      if (i >= this.b) {
        char[] arrayOfChar2 = this.g;
        i = this.d;
        return new String(arrayOfChar2, i, this.e - i);
      } 
      char[] arrayOfChar1 = this.g;
      char c = arrayOfChar1[i];
      if (c != ' ') {
        if (c != ';')
          if (c != '\\') {
            if (c != '+' && c != ',') {
              int k = this.e;
              this.e = k + 1;
              arrayOfChar1[k] = arrayOfChar1[i];
              this.c = i + 1;
              continue;
            } 
          } else {
            i = this.e;
            this.e = i + 1;
            arrayOfChar1[i] = e();
            this.c++;
            continue;
          }  
        arrayOfChar1 = this.g;
        i = this.d;
        return new String(arrayOfChar1, i, this.e - i);
      } 
      int j = this.e;
      this.f = j;
      this.c = i + 1;
      this.e = j + 1;
      arrayOfChar1[j] = ' ';
      while (true) {
        i = this.c;
        if (i < this.b) {
          arrayOfChar1 = this.g;
          if (arrayOfChar1[i] == ' ') {
            j = this.e;
            this.e = j + 1;
            arrayOfChar1[j] = ' ';
            this.c = i + 1;
            continue;
          } 
        } 
        break;
      } 
      i = this.c;
      if (i != this.b) {
        arrayOfChar1 = this.g;
        if (arrayOfChar1[i] == ',' || arrayOfChar1[i] == '+' || arrayOfChar1[i] == ';')
          break; 
        continue;
      } 
      break;
    } 
    char[] arrayOfChar = this.g;
    i = this.d;
    return new String(arrayOfChar, i, this.f - i);
  }
  
  private char e() {
    int i = ++this.c;
    if (i != this.b) {
      i = this.g[i];
      if (i != 32 && i != 37 && i != 92 && i != 95 && i != 34 && i != 35)
        switch (i) {
          default:
            switch (i) {
              default:
                return f();
              case 59:
              case 60:
              case 61:
              case 62:
                break;
            } 
            break;
          case 42:
          case 43:
          case 44:
            break;
        }  
      return this.g[this.c];
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected end of DN: ");
    stringBuilder.append(this.a);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private char f() {
    int i = a(this.c);
    this.c++;
    if (i < 128)
      return (char)i; 
    if (i >= 192 && i <= 247) {
      byte b;
      if (i <= 223) {
        i &= 0x1F;
        b = 1;
      } else if (i <= 239) {
        b = 2;
        i &= 0xF;
      } else {
        b = 3;
        i &= 0x7;
      } 
      int j = 0;
      while (j < b) {
        int k = ++this.c;
        if (k != this.b) {
          if (this.g[k] != '\\')
            return '?'; 
          this.c = k + 1;
          k = a(this.c);
          this.c++;
          if ((k & 0xC0) != 128)
            return '?'; 
          i = (i << 6) + (k & 0x3F);
          j++;
          continue;
        } 
        return '?';
      } 
      return (char)i;
    } 
    return '?';
  }
  
  public String a(String paramString) {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = this.a.toCharArray();
    String str1 = a();
    String str2 = str1;
    if (str1 == null)
      return null; 
    while (true) {
      int i = this.c;
      if (i == this.b)
        return null; 
      i = this.g[i];
      if (i != 34) {
        if (i != 35) {
          if (i != 43 && i != 44 && i != 59) {
            str1 = d();
          } else {
            str1 = "";
          } 
        } else {
          str1 = c();
        } 
      } else {
        str1 = b();
      } 
      if (paramString.equalsIgnoreCase(str2))
        return str1; 
      i = this.c;
      if (i >= this.b)
        return null; 
      char[] arrayOfChar = this.g;
      if (arrayOfChar[i] == ',' || arrayOfChar[i] == ';' || arrayOfChar[i] == '+') {
        this.c++;
        str2 = a();
        if (str2 != null)
          continue; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Malformed DN: ");
        stringBuilder1.append(this.a);
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Malformed DN: ");
      stringBuilder.append(this.a);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */