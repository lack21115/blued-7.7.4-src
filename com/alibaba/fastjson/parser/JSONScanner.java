package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;

public final class JSONScanner extends JSONLexerBase {
  public final int ISO8601_LEN_0 = 10;
  
  public final int ISO8601_LEN_1 = 19;
  
  public final int ISO8601_LEN_2 = 23;
  
  private final int len;
  
  private final String text;
  
  public JSONScanner(String paramString) {
    this(paramString, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONScanner(String paramString, int paramInt) {
    super(paramInt);
    this.text = paramString;
    this.len = this.text.length();
    this.bp = -1;
    next();
    if (this.ch == '﻿')
      next(); 
  }
  
  public JSONScanner(char[] paramArrayOfchar, int paramInt) {
    this(paramArrayOfchar, paramInt, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONScanner(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    this(new String(paramArrayOfchar, 0, paramInt1), paramInt2);
  }
  
  static boolean charArrayCompare(String paramString, int paramInt, char[] paramArrayOfchar) {
    int j = paramArrayOfchar.length;
    if (j + paramInt > paramString.length())
      return false; 
    for (int i = 0; i < j; i++) {
      if (paramArrayOfchar[i] != paramString.charAt(paramInt + i))
        return false; 
    } 
    return true;
  }
  
  static boolean checkDate(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, int paramInt1, int paramInt2) {
    if (paramChar1 != '1' && paramChar1 != '2')
      return false; 
    if (paramChar2 >= '0') {
      if (paramChar2 > '9')
        return false; 
      if (paramChar3 >= '0') {
        if (paramChar3 > '9')
          return false; 
        if (paramChar4 >= '0') {
          if (paramChar4 > '9')
            return false; 
          if (paramChar5 == '0') {
            if (paramChar6 < '1' || paramChar6 > '9')
              return false; 
          } else if (paramChar5 == '1') {
            if (paramChar6 != '0' && paramChar6 != '1' && paramChar6 != '2')
              return false; 
          } else {
            return false;
          } 
          if (paramInt1 == 48) {
            if (paramInt2 < 49 || paramInt2 > 57)
              return false; 
          } else {
            if (paramInt1 == 49 || paramInt1 == 50)
              return (paramInt2 >= 48) ? (!(paramInt2 > 57)) : false; 
            if (paramInt1 != 51 || (paramInt2 != 48 && paramInt2 != 49))
              return false; 
          } 
          return true;
        } 
      } 
    } 
    return false;
  }
  
  private boolean checkTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6) {
    if (paramChar1 == '0') {
      if (paramChar2 < '0' || paramChar2 > '9')
        return false; 
    } else if (paramChar1 == '1') {
      if (paramChar2 < '0' || paramChar2 > '9')
        return false; 
    } else if (paramChar1 == '2' && paramChar2 >= '0') {
      if (paramChar2 > '4')
        return false; 
    } else {
      return false;
    } 
    if (paramChar3 >= '0' && paramChar3 <= '5') {
      if (paramChar4 < '0' || paramChar4 > '9')
        return false; 
    } else if (paramChar3 == '6') {
      if (paramChar4 != '0')
        return false; 
    } else {
      return false;
    } 
    if (paramChar5 >= '0' && paramChar5 <= '5') {
      if (paramChar6 < '0' || paramChar6 > '9')
        return false; 
    } else {
      return (paramChar5 == '6') ? (!(paramChar6 != '0')) : false;
    } 
    return true;
  }
  
  private void setCalendar(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6, char paramChar7, char paramChar8) {
    this.calendar = Calendar.getInstance(this.timeZone, this.locale);
    int i = digits[paramChar1];
    int j = digits[paramChar2];
    int k = digits[paramChar3];
    int m = digits[paramChar4];
    int n = digits[paramChar5];
    int i1 = digits[paramChar6];
    int i2 = digits[paramChar7];
    int i3 = digits[paramChar8];
    this.calendar.set(1, i * 1000 + j * 100 + k * 10 + m);
    this.calendar.set(2, n * 10 + i1 - 1);
    this.calendar.set(5, i2 * 10 + i3);
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable) {
    return paramSymbolTable.addSymbol(this.text, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
    this.text.getChars(paramInt1, paramInt3 + paramInt1, paramArrayOfchar, paramInt2);
  }
  
  public byte[] bytesValue() {
    return IOUtils.decodeFast(this.text, this.np + 1, this.sp);
  }
  
  public final boolean charArrayCompare(char[] paramArrayOfchar) {
    return charArrayCompare(this.text, this.bp, paramArrayOfchar);
  }
  
  public final char charAt(int paramInt) {
    return (paramInt >= this.len) ? '\032' : this.text.charAt(paramInt);
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfchar) {
    this.text.getChars(paramInt1, paramInt2 + paramInt1, paramArrayOfchar, 0);
  }
  
  public final int indexOf(char paramChar, int paramInt) {
    return this.text.indexOf(paramChar, paramInt);
  }
  
  public String info() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pos ");
    stringBuilder.append(this.bp);
    stringBuilder.append(", json : ");
    if (this.text.length() < 65536) {
      str = this.text;
    } else {
      str = this.text.substring(0, 65536);
    } 
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public boolean isEOF() {
    int i = this.bp;
    int j = this.len;
    boolean bool = true;
    if (i != j) {
      if (this.ch == '\032' && this.bp + 1 == this.len)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public final char next() {
    int i = this.bp + 1;
    this.bp = i;
    char c = charAt(i);
    this.ch = c;
    return c;
  }
  
  public final String numberString() {
    char c = charAt(this.np + this.sp - 1);
    int j = this.sp;
    if (c != 'L' && c != 'S' && c != 'B' && c != 'F') {
      int k = j;
      if (c == 'D') {
        k = j - 1;
        return subString(this.np, k);
      } 
      return subString(this.np, k);
    } 
    int i = j - 1;
    return subString(this.np, i);
  }
  
  public boolean scanFieldBoolean(char[] paramArrayOfchar) {
    boolean bool;
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return false;
    } 
    int j = this.bp + paramArrayOfchar.length;
    int i = j + 1;
    j = charAt(j);
    if (j == 116) {
      j = i + 1;
      if (charAt(i) != 'r') {
        this.matchStat = -1;
        return false;
      } 
      i = j + 1;
      if (charAt(j) != 'u') {
        this.matchStat = -1;
        return false;
      } 
      if (charAt(i) != 'e') {
        this.matchStat = -1;
        return false;
      } 
      this.bp = i + 1;
      i = charAt(this.bp);
      bool = true;
    } else if (j == 102) {
      j = i + 1;
      if (charAt(i) != 'a') {
        this.matchStat = -1;
        return false;
      } 
      i = j + 1;
      if (charAt(j) != 'l') {
        this.matchStat = -1;
        return false;
      } 
      j = i + 1;
      if (charAt(i) != 's') {
        this.matchStat = -1;
        return false;
      } 
      if (charAt(j) != 'e') {
        this.matchStat = -1;
        return false;
      } 
      this.bp = j + 1;
      i = charAt(this.bp);
      bool = false;
    } else {
      this.matchStat = -1;
      return false;
    } 
    if (i == 44) {
      i = this.bp + 1;
      this.bp = i;
      this.ch = charAt(i);
      this.matchStat = 3;
      this.token = 16;
      return bool;
    } 
    if (i == 125) {
      i = this.bp + 1;
      this.bp = i;
      i = charAt(i);
      if (i == 44) {
        this.token = 16;
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
      } else if (i == 93) {
        this.token = 15;
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
      } else if (i == 125) {
        this.token = 13;
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
      } else {
        if (i == 26) {
          this.token = 20;
          this.matchStat = 4;
          return bool;
        } 
        this.matchStat = -1;
        return false;
      } 
      this.matchStat = 4;
      return bool;
    } 
    this.matchStat = -1;
    return false;
  }
  
  public int scanFieldInt(char[] paramArrayOfchar) {
    this.matchStat = 0;
    int k = this.bp;
    char c = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return 0;
    } 
    int i = this.bp + paramArrayOfchar.length;
    int j = i + 1;
    i = charAt(i);
    if (i >= 48 && i <= 57) {
      int m;
      i = digits[i];
      while (true) {
        m = j + 1;
        j = charAt(j);
        if (j >= 48 && j <= 57) {
          i = i * 10 + digits[j];
          j = m;
          continue;
        } 
        break;
      } 
      if (j == 46) {
        this.matchStat = -1;
        return 0;
      } 
      if (i < 0) {
        this.matchStat = -1;
        return 0;
      } 
      if (j == 44 || j == 125)
        this.bp = m - 1; 
      if (j == 44) {
        j = this.bp + 1;
        this.bp = j;
        this.ch = charAt(j);
        this.matchStat = 3;
        this.token = 16;
        return i;
      } 
      if (j == 125) {
        j = this.bp + 1;
        this.bp = j;
        j = charAt(j);
        if (j == 44) {
          this.token = 16;
          j = this.bp + 1;
          this.bp = j;
          this.ch = charAt(j);
        } else if (j == 93) {
          this.token = 15;
          j = this.bp + 1;
          this.bp = j;
          this.ch = charAt(j);
        } else if (j == 125) {
          this.token = 13;
          j = this.bp + 1;
          this.bp = j;
          this.ch = charAt(j);
        } else {
          if (j == 26) {
            this.token = 20;
            this.matchStat = 4;
            return i;
          } 
          this.bp = k;
          this.ch = c;
          this.matchStat = -1;
          return 0;
        } 
        this.matchStat = 4;
        return i;
      } 
      return i;
    } 
    this.matchStat = -1;
    return 0;
  }
  
  public long scanFieldLong(char[] paramArrayOfchar) {
    this.matchStat = 0;
    int k = this.bp;
    char c = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return 0L;
    } 
    int j = this.bp + paramArrayOfchar.length;
    int i = j + 1;
    j = charAt(j);
    if (j >= 48 && j <= 57) {
      long l = digits[j];
      while (true) {
        j = i + 1;
        i = charAt(i);
        if (i >= 48 && i <= 57) {
          l = l * 10L + digits[i];
          i = j;
          continue;
        } 
        break;
      } 
      if (i == 46) {
        this.matchStat = -1;
        return 0L;
      } 
      if (i == 44 || i == 125)
        this.bp = j - 1; 
      if (l < 0L) {
        this.bp = k;
        this.ch = c;
        this.matchStat = -1;
        return 0L;
      } 
      if (i == 44) {
        i = this.bp + 1;
        this.bp = i;
        this.ch = charAt(i);
        this.matchStat = 3;
        this.token = 16;
        return l;
      } 
      if (i == 125) {
        i = this.bp + 1;
        this.bp = i;
        i = charAt(i);
        if (i == 44) {
          this.token = 16;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        } else if (i == 93) {
          this.token = 15;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        } else if (i == 125) {
          this.token = 13;
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
        } else {
          if (i == 26) {
            this.token = 20;
            this.matchStat = 4;
            return l;
          } 
          this.bp = k;
          this.ch = c;
          this.matchStat = -1;
          return 0L;
        } 
        this.matchStat = 4;
        return l;
      } 
      this.matchStat = -1;
      return 0L;
    } 
    this.bp = k;
    this.ch = c;
    this.matchStat = -1;
    return 0L;
  }
  
  public String scanFieldString(char[] paramArrayOfchar) {
    boolean bool = false;
    this.matchStat = 0;
    int k = this.bp;
    char c = this.ch;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return stringDefaultValue();
    } 
    int j = this.bp + paramArrayOfchar.length;
    int i = j + 1;
    if (charAt(j) != '"') {
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    int m = this.text.indexOf('"', i);
    if (m != -1) {
      String str = subString(i, m - i);
      i = 0;
      while (true) {
        j = bool;
        if (i < str.length()) {
          if (str.charAt(i) == '\\') {
            j = 1;
            break;
          } 
          i++;
          continue;
        } 
        break;
      } 
      if (j != 0) {
        this.matchStat = -1;
        return stringDefaultValue();
      } 
      i = m + 1;
      char c1 = charAt(i);
      if (c1 == ',' || c1 == '}') {
        this.bp = i;
        this.ch = c1;
        if (c1 == ',') {
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
          this.matchStat = 3;
          return str;
        } 
        if (c1 == '}') {
          i = this.bp + 1;
          this.bp = i;
          i = charAt(i);
          if (i == 44) {
            this.token = 16;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          } else if (i == 93) {
            this.token = 15;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          } else if (i == 125) {
            this.token = 13;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          } else {
            if (i == 26) {
              this.token = 20;
              this.matchStat = 4;
              return str;
            } 
            this.bp = k;
            this.ch = c;
            this.matchStat = -1;
            return stringDefaultValue();
          } 
          this.matchStat = 4;
          return str;
        } 
        this.matchStat = -1;
        return stringDefaultValue();
      } 
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    throw new JSONException("unclosed str");
  }
  
  public Collection<String> scanFieldStringArray(char[] paramArrayOfchar, Class<?> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield matchStat : I
    //   5: aload_0
    //   6: getfield text : Ljava/lang/String;
    //   9: aload_0
    //   10: getfield bp : I
    //   13: aload_1
    //   14: invokestatic charArrayCompare : (Ljava/lang/String;I[C)Z
    //   17: ifne -> 28
    //   20: aload_0
    //   21: bipush #-2
    //   23: putfield matchStat : I
    //   26: aconst_null
    //   27: areturn
    //   28: aload_2
    //   29: ldc java/util/HashSet
    //   31: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   34: ifeq -> 48
    //   37: new java/util/HashSet
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore_2
    //   45: goto -> 76
    //   48: aload_2
    //   49: ldc java/util/ArrayList
    //   51: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   54: ifeq -> 68
    //   57: new java/util/ArrayList
    //   60: dup
    //   61: invokespecial <init> : ()V
    //   64: astore_2
    //   65: goto -> 76
    //   68: aload_2
    //   69: invokevirtual newInstance : ()Ljava/lang/Object;
    //   72: checkcast java/util/Collection
    //   75: astore_2
    //   76: aload_0
    //   77: getfield bp : I
    //   80: aload_1
    //   81: arraylength
    //   82: iadd
    //   83: istore #4
    //   85: iload #4
    //   87: iconst_1
    //   88: iadd
    //   89: istore #5
    //   91: aload_0
    //   92: iload #4
    //   94: invokevirtual charAt : (I)C
    //   97: bipush #91
    //   99: if_icmpeq -> 109
    //   102: aload_0
    //   103: iconst_m1
    //   104: putfield matchStat : I
    //   107: aconst_null
    //   108: areturn
    //   109: iload #5
    //   111: iconst_1
    //   112: iadd
    //   113: istore #4
    //   115: aload_0
    //   116: iload #5
    //   118: invokevirtual charAt : (I)C
    //   121: istore #5
    //   123: iload #5
    //   125: bipush #34
    //   127: if_icmpeq -> 137
    //   130: aload_0
    //   131: iconst_m1
    //   132: putfield matchStat : I
    //   135: aconst_null
    //   136: areturn
    //   137: iload #4
    //   139: istore #5
    //   141: iload #5
    //   143: iconst_1
    //   144: iadd
    //   145: istore #6
    //   147: aload_0
    //   148: iload #5
    //   150: invokevirtual charAt : (I)C
    //   153: istore #5
    //   155: iload #5
    //   157: bipush #34
    //   159: if_icmpne -> 504
    //   162: aload_2
    //   163: aload_0
    //   164: iload #4
    //   166: iload #6
    //   168: iload #4
    //   170: isub
    //   171: iconst_1
    //   172: isub
    //   173: invokevirtual subString : (II)Ljava/lang/String;
    //   176: invokeinterface add : (Ljava/lang/Object;)Z
    //   181: pop
    //   182: iload #6
    //   184: iconst_1
    //   185: iadd
    //   186: istore #5
    //   188: aload_0
    //   189: iload #6
    //   191: invokevirtual charAt : (I)C
    //   194: istore #4
    //   196: iload #4
    //   198: bipush #44
    //   200: if_icmpne -> 220
    //   203: iload #5
    //   205: iconst_1
    //   206: iadd
    //   207: istore #4
    //   209: aload_0
    //   210: iload #5
    //   212: invokevirtual charAt : (I)C
    //   215: istore #5
    //   217: goto -> 123
    //   220: iload #4
    //   222: bipush #93
    //   224: if_icmpne -> 497
    //   227: iload #5
    //   229: iconst_1
    //   230: iadd
    //   231: istore #4
    //   233: aload_0
    //   234: iload #5
    //   236: invokevirtual charAt : (I)C
    //   239: istore_3
    //   240: iload_3
    //   241: invokestatic isWhitespace : (C)Z
    //   244: ifeq -> 263
    //   247: aload_0
    //   248: iload #4
    //   250: invokevirtual charAt : (I)C
    //   253: istore_3
    //   254: iload #4
    //   256: iconst_1
    //   257: iadd
    //   258: istore #4
    //   260: goto -> 240
    //   263: aload_0
    //   264: iload #4
    //   266: putfield bp : I
    //   269: iload_3
    //   270: bipush #44
    //   272: if_icmpne -> 294
    //   275: aload_0
    //   276: aload_0
    //   277: aload_0
    //   278: getfield bp : I
    //   281: invokevirtual charAt : (I)C
    //   284: putfield ch : C
    //   287: aload_0
    //   288: iconst_3
    //   289: putfield matchStat : I
    //   292: aload_2
    //   293: areturn
    //   294: iload_3
    //   295: bipush #125
    //   297: if_icmpne -> 490
    //   300: aload_0
    //   301: aload_0
    //   302: getfield bp : I
    //   305: invokevirtual charAt : (I)C
    //   308: istore_3
    //   309: iload_3
    //   310: invokestatic isWhitespace : (C)Z
    //   313: ifeq -> 342
    //   316: iload #4
    //   318: iconst_1
    //   319: iadd
    //   320: istore #5
    //   322: aload_0
    //   323: iload #4
    //   325: invokevirtual charAt : (I)C
    //   328: istore_3
    //   329: aload_0
    //   330: iload #5
    //   332: putfield bp : I
    //   335: iload #5
    //   337: istore #4
    //   339: goto -> 309
    //   342: iload_3
    //   343: bipush #44
    //   345: if_icmpne -> 381
    //   348: aload_0
    //   349: bipush #16
    //   351: putfield token : I
    //   354: aload_0
    //   355: getfield bp : I
    //   358: iconst_1
    //   359: iadd
    //   360: istore #4
    //   362: aload_0
    //   363: iload #4
    //   365: putfield bp : I
    //   368: aload_0
    //   369: aload_0
    //   370: iload #4
    //   372: invokevirtual charAt : (I)C
    //   375: putfield ch : C
    //   378: goto -> 476
    //   381: iload_3
    //   382: bipush #93
    //   384: if_icmpne -> 420
    //   387: aload_0
    //   388: bipush #15
    //   390: putfield token : I
    //   393: aload_0
    //   394: getfield bp : I
    //   397: iconst_1
    //   398: iadd
    //   399: istore #4
    //   401: aload_0
    //   402: iload #4
    //   404: putfield bp : I
    //   407: aload_0
    //   408: aload_0
    //   409: iload #4
    //   411: invokevirtual charAt : (I)C
    //   414: putfield ch : C
    //   417: goto -> 476
    //   420: iload_3
    //   421: bipush #125
    //   423: if_icmpne -> 459
    //   426: aload_0
    //   427: bipush #13
    //   429: putfield token : I
    //   432: aload_0
    //   433: getfield bp : I
    //   436: iconst_1
    //   437: iadd
    //   438: istore #4
    //   440: aload_0
    //   441: iload #4
    //   443: putfield bp : I
    //   446: aload_0
    //   447: aload_0
    //   448: iload #4
    //   450: invokevirtual charAt : (I)C
    //   453: putfield ch : C
    //   456: goto -> 476
    //   459: iload_3
    //   460: bipush #26
    //   462: if_icmpne -> 483
    //   465: aload_0
    //   466: bipush #20
    //   468: putfield token : I
    //   471: aload_0
    //   472: iload_3
    //   473: putfield ch : C
    //   476: aload_0
    //   477: iconst_4
    //   478: putfield matchStat : I
    //   481: aload_2
    //   482: areturn
    //   483: aload_0
    //   484: iconst_m1
    //   485: putfield matchStat : I
    //   488: aconst_null
    //   489: areturn
    //   490: aload_0
    //   491: iconst_m1
    //   492: putfield matchStat : I
    //   495: aconst_null
    //   496: areturn
    //   497: aload_0
    //   498: iconst_m1
    //   499: putfield matchStat : I
    //   502: aconst_null
    //   503: areturn
    //   504: iload #5
    //   506: bipush #92
    //   508: if_icmpne -> 518
    //   511: aload_0
    //   512: iconst_m1
    //   513: putfield matchStat : I
    //   516: aconst_null
    //   517: areturn
    //   518: iload #6
    //   520: istore #5
    //   522: goto -> 141
    //   525: astore_1
    //   526: new com/alibaba/fastjson/JSONException
    //   529: dup
    //   530: aload_1
    //   531: invokevirtual getMessage : ()Ljava/lang/String;
    //   534: aload_1
    //   535: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   538: athrow
    // Exception table:
    //   from	to	target	type
    //   68	76	525	java/lang/Exception
  }
  
  public String scanFieldSymbol(char[] paramArrayOfchar, SymbolTable paramSymbolTable) {
    this.matchStat = 0;
    if (!charArrayCompare(this.text, this.bp, paramArrayOfchar)) {
      this.matchStat = -2;
      return null;
    } 
    int i = this.bp + paramArrayOfchar.length;
    int k = i + 1;
    if (charAt(i) != '"') {
      this.matchStat = -1;
      return null;
    } 
    int j = k;
    i = 0;
    while (true) {
      int m = j + 1;
      j = charAt(j);
      if (j == 34) {
        this.bp = m;
        char c = charAt(this.bp);
        this.ch = c;
        String str = paramSymbolTable.addSymbol(this.text, k, m - k - 1, i);
        if (c == ',') {
          i = this.bp + 1;
          this.bp = i;
          this.ch = charAt(i);
          this.matchStat = 3;
          return str;
        } 
        if (c == '}') {
          i = this.bp + 1;
          this.bp = i;
          i = charAt(i);
          if (i == 44) {
            this.token = 16;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          } else if (i == 93) {
            this.token = 15;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          } else if (i == 125) {
            this.token = 13;
            i = this.bp + 1;
            this.bp = i;
            this.ch = charAt(i);
          } else {
            if (i == 26) {
              this.token = 20;
              this.matchStat = 4;
              return str;
            } 
            this.matchStat = -1;
            return null;
          } 
          this.matchStat = 4;
          return str;
        } 
        this.matchStat = -1;
        return null;
      } 
      i = i * 31 + j;
      if (j == 92) {
        this.matchStat = -1;
        return null;
      } 
      j = m;
    } 
  }
  
  public boolean scanISO8601DateIfMatch() {
    return scanISO8601DateIfMatch(true);
  }
  
  public boolean scanISO8601DateIfMatch(boolean paramBoolean) {
    int i = this.len - this.bp;
    if (!paramBoolean && i > 13) {
      char c9 = charAt(this.bp);
      char c10 = charAt(this.bp + 1);
      char c11 = charAt(this.bp + 2);
      char c12 = charAt(this.bp + 3);
      char c13 = charAt(this.bp + 4);
      char c14 = charAt(this.bp + 5);
      char c15 = charAt(this.bp + i - 1);
      char c16 = charAt(this.bp + i - 2);
      if (c9 == '/' && c10 == 'D' && c11 == 'a' && c12 == 't' && c13 == 'e' && c14 == '(' && c15 == '/' && c16 == ')') {
        c9 = '\006';
        byte b;
        for (b = -1; c9 < i; b = b1) {
          byte b1;
          c12 = charAt(this.bp + c9);
          if (c12 == '+') {
            c11 = c9;
          } else if (c12 >= '0') {
            b1 = b;
            if (c12 > '9')
              break; 
          } else {
            break;
          } 
          int k = c9 + 1;
        } 
        if (b == -1)
          return false; 
        int j = this.bp + 6;
        long l = Long.parseLong(subString(j, b - j));
        this.calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar.setTimeInMillis(l);
        this.token = 5;
        return true;
      } 
    } 
    if (i == 8 || i == 14 || i == 17) {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (paramBoolean)
        return false; 
      char c9 = charAt(this.bp);
      char c10 = charAt(this.bp + 1);
      char c11 = charAt(this.bp + 2);
      char c12 = charAt(this.bp + 3);
      char c13 = charAt(this.bp + 4);
      char c14 = charAt(this.bp + 5);
      char c15 = charAt(this.bp + 6);
      char c16 = charAt(this.bp + 7);
      if (!checkDate(c9, c10, c11, c12, c13, c14, c15, c16))
        return false; 
      setCalendar(c9, c10, c11, c12, c13, c14, c15, c16);
      if (i != 8) {
        c9 = charAt(this.bp + 8);
        c10 = charAt(this.bp + 9);
        c11 = charAt(this.bp + 10);
        c12 = charAt(this.bp + 11);
        c13 = charAt(this.bp + 12);
        c14 = charAt(this.bp + 13);
        if (!checkTime(c9, c10, c11, c12, c13, c14))
          return false; 
        if (i == 17) {
          bool1 = charAt(this.bp + 14);
          char c17 = charAt(this.bp + 15);
          char c18 = charAt(this.bp + 16);
          if (bool1 >= 48) {
            if (bool1 > 57)
              return false; 
            if (c17 >= '0') {
              if (c17 > '9')
                return false; 
              if (c18 >= '0') {
                if (c18 > '9')
                  return false; 
                int j = digits[bool1] * 100 + digits[c17] * 10 + digits[c18];
              } else {
                return false;
              } 
            } else {
              return false;
            } 
          } else {
            return false;
          } 
        } else {
          bool1 = false;
        } 
        bool2 = digits[c9] * 10 + digits[c10];
        bool3 = digits[c11] * 10 + digits[c12];
        i = digits[c13] * 10 + digits[c14];
      } else {
        bool2 = false;
        bool3 = false;
        i = 0;
        bool1 = false;
      } 
      this.calendar.set(11, bool2);
      this.calendar.set(12, bool3);
      this.calendar.set(13, i);
      this.calendar.set(14, bool1);
      this.token = 5;
      return true;
    } 
    if (i < this.ISO8601_LEN_0)
      return false; 
    if (charAt(this.bp + 4) != '-')
      return false; 
    if (charAt(this.bp + 7) != '-')
      return false; 
    char c1 = charAt(this.bp);
    char c2 = charAt(this.bp + 1);
    char c3 = charAt(this.bp + 2);
    char c4 = charAt(this.bp + 3);
    char c5 = charAt(this.bp + 5);
    char c6 = charAt(this.bp + 6);
    char c7 = charAt(this.bp + 8);
    char c8 = charAt(this.bp + 9);
    if (!checkDate(c1, c2, c3, c4, c5, c6, c7, c8))
      return false; 
    setCalendar(c1, c2, c3, c4, c5, c6, c7, c8);
    c1 = charAt(this.bp + 10);
    if (c1 == 'T' || (c1 == ' ' && !paramBoolean)) {
      if (i < this.ISO8601_LEN_1)
        return false; 
      if (charAt(this.bp + 13) != ':')
        return false; 
      if (charAt(this.bp + 16) != ':')
        return false; 
      c1 = charAt(this.bp + 11);
      c2 = charAt(this.bp + 12);
      c3 = charAt(this.bp + 14);
      c4 = charAt(this.bp + 15);
      c5 = charAt(this.bp + 17);
      c6 = charAt(this.bp + 18);
      if (!checkTime(c1, c2, c3, c4, c5, c6))
        return false; 
      setTime(c1, c2, c3, c4, c5, c6);
      int j = charAt(this.bp + 19);
      if (j == 46) {
        if (i < this.ISO8601_LEN_2)
          return false; 
        j = charAt(this.bp + 20);
        if (j >= 48) {
          if (j > 57)
            return false; 
          j = digits[j];
          char c = charAt(this.bp + 21);
          if (c >= '0' && c <= '9') {
            j = j * 10 + digits[c];
            c = '\002';
          } else {
            c = '\001';
          } 
          i = j;
          char c9 = c;
          if (c == '\002') {
            char c10 = charAt(this.bp + 22);
            i = j;
            c9 = c;
            if (c10 >= '0') {
              i = j;
              c9 = c;
              if (c10 <= '9') {
                i = j * 10 + digits[c10];
                c9 = '\003';
              } 
            } 
          } 
          this.calendar.set(14, i);
          c1 = charAt(this.bp + 20 + c9);
          if (c1 == '+' || c1 == '-') {
            c2 = charAt(this.bp + 20 + c9 + 1);
            if (c2 >= '0') {
              if (c2 > '1')
                return false; 
              c3 = charAt(this.bp + 20 + c9 + 2);
              if (c3 >= '0') {
                if (c3 > '9')
                  return false; 
                j = charAt(this.bp + 20 + c9 + 3);
                if (j == 58) {
                  if (charAt(this.bp + 20 + c9 + 4) != '0')
                    return false; 
                  if (charAt(this.bp + 20 + c9 + 5) != '0')
                    return false; 
                  j = 6;
                } else if (j == 48) {
                  if (charAt(this.bp + 20 + c9 + 4) != '0')
                    return false; 
                  j = 5;
                } else {
                  j = 3;
                } 
                setTimeZone(c1, c2, c3);
              } else {
                return false;
              } 
            } else {
              return false;
            } 
          } else if (c1 == 'Z') {
            if (this.calendar.getTimeZone().getRawOffset() != 0) {
              String[] arrayOfString = TimeZone.getAvailableIDs(0);
              if (arrayOfString.length > 0) {
                TimeZone timeZone = TimeZone.getTimeZone(arrayOfString[0]);
                this.calendar.setTimeZone(timeZone);
              } 
            } 
            j = 1;
          } else {
            j = 0;
          } 
          int m = this.bp;
          j = c9 + 20 + j;
          m = charAt(m + j);
          if (m != 26 && m != 34)
            return false; 
          j = this.bp + j;
          this.bp = j;
          this.ch = charAt(j);
          this.token = 5;
          return true;
        } 
        return false;
      } 
      this.calendar.set(14, 0);
      int k = this.bp + 19;
      this.bp = k;
      this.ch = charAt(k);
      this.token = 5;
      if (j == 90 && this.calendar.getTimeZone().getRawOffset() != 0) {
        String[] arrayOfString = TimeZone.getAvailableIDs(0);
        if (arrayOfString.length > 0) {
          TimeZone timeZone = TimeZone.getTimeZone(arrayOfString[0]);
          this.calendar.setTimeZone(timeZone);
        } 
      } 
      return true;
    } 
    if (c1 == '"' || c1 == '\032') {
      this.calendar.set(11, 0);
      this.calendar.set(12, 0);
      this.calendar.set(13, 0);
      this.calendar.set(14, 0);
      int j = this.bp + 10;
      this.bp = j;
      this.ch = charAt(j);
      this.token = 5;
      return true;
    } 
    if (c1 == '+' || c1 == '-') {
      if (this.len == 16 && charAt(this.bp + 13) == ':' && charAt(this.bp + 14) == '0') {
        if (charAt(this.bp + 15) != '0')
          return false; 
        setTime('0', '0', '0', '0', '0', '0');
        this.calendar.set(14, 0);
        setTimeZone(c1, charAt(this.bp + 11), charAt(this.bp + 12));
        return true;
      } 
      return false;
    } 
    return false;
  }
  
  protected void setTime(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6) {
    int i = digits[paramChar1];
    int j = digits[paramChar2];
    int k = digits[paramChar3];
    int m = digits[paramChar4];
    int n = digits[paramChar5];
    int i1 = digits[paramChar6];
    this.calendar.set(11, i * 10 + j);
    this.calendar.set(12, k * 10 + m);
    this.calendar.set(13, n * 10 + i1);
  }
  
  protected void setTimeZone(char paramChar1, char paramChar2, char paramChar3) {
    int j = (digits[paramChar2] * 10 + digits[paramChar3]) * 3600 * 1000;
    int i = j;
    if (paramChar1 == '-')
      i = -j; 
    if (this.calendar.getTimeZone().getRawOffset() != i) {
      String[] arrayOfString = TimeZone.getAvailableIDs(i);
      if (arrayOfString.length > 0) {
        TimeZone timeZone = TimeZone.getTimeZone(arrayOfString[0]);
        this.calendar.setTimeZone(timeZone);
      } 
    } 
  }
  
  public final String stringVal() {
    return !this.hasSpecial ? subString(this.np + 1, this.sp) : new String(this.sbuf, 0, this.sp);
  }
  
  public final String subString(int paramInt1, int paramInt2) {
    if (ASMUtils.IS_ANDROID) {
      if (paramInt2 < this.sbuf.length) {
        this.text.getChars(paramInt1, paramInt1 + paramInt2, this.sbuf, 0);
        return new String(this.sbuf, 0, paramInt2);
      } 
      char[] arrayOfChar = new char[paramInt2];
      this.text.getChars(paramInt1, paramInt2 + paramInt1, arrayOfChar, 0);
      return new String(arrayOfChar);
    } 
    return this.text.substring(paramInt1, paramInt2 + paramInt1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\JSONScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */