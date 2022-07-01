package com.alibaba.fastjson.asm;

public class Type {
  public static final Type BOOLEAN_TYPE;
  
  public static final Type BYTE_TYPE;
  
  public static final Type CHAR_TYPE;
  
  public static final Type DOUBLE_TYPE;
  
  public static final Type FLOAT_TYPE;
  
  public static final Type INT_TYPE;
  
  public static final Type LONG_TYPE;
  
  public static final Type SHORT_TYPE;
  
  public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
  
  private final char[] buf;
  
  private final int len;
  
  private final int off;
  
  protected final int sort;
  
  static {
    BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    CHAR_TYPE = new Type(2, null, 1124075009, 1);
    BYTE_TYPE = new Type(3, null, 1107297537, 1);
    SHORT_TYPE = new Type(4, null, 1392510721, 1);
    INT_TYPE = new Type(5, null, 1224736769, 1);
    FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    LONG_TYPE = new Type(7, null, 1241579778, 1);
    DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
  }
  
  private Type(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
    this.sort = paramInt1;
    this.buf = paramArrayOfchar;
    this.off = paramInt2;
    this.len = paramInt3;
  }
  
  public static int getArgumentsAndReturnSizes(String paramString) {
    byte b = 1;
    int j = 1;
    int i = 1;
    while (true) {
      int k = j + 1;
      j = paramString.charAt(j);
      if (j == 41) {
        k = paramString.charAt(k);
        if (k == 86) {
          j = 0;
        } else {
          if (k != 68) {
            j = b;
            if (k == 74)
              j = 2; 
            return i << 2 | j;
          } 
          j = 2;
        } 
        return i << 2 | j;
      } 
      if (j == 76) {
        while (true) {
          j = k + 1;
          if (paramString.charAt(k) != ';') {
            k = j;
            continue;
          } 
          i++;
        } 
        break;
      } 
      if (j == 68 || j == 74) {
        i += 2;
      } else {
        i++;
      } 
      j = k;
    } 
  }
  
  public static Type getType(String paramString) {
    return getType(paramString.toCharArray(), 0);
  }
  
  private static Type getType(char[] paramArrayOfchar, int paramInt) {
    char c = paramArrayOfchar[paramInt];
    if (c != 'F') {
      if (c != 'S') {
        if (c != 'V') {
          if (c != 'I') {
            if (c != 'J') {
              if (c != 'Z') {
                if (c != '[') {
                  int i;
                  switch (c) {
                    default:
                      c = '\001';
                      while (paramArrayOfchar[paramInt + c] != ';')
                        i = c + 1; 
                      return new Type(10, paramArrayOfchar, paramInt + 1, i - 1);
                    case 'D':
                      return DOUBLE_TYPE;
                    case 'C':
                      return CHAR_TYPE;
                    case 'B':
                      break;
                  } 
                  return BYTE_TYPE;
                } 
                c = '\001';
                while (true) {
                  int i;
                  int k = paramInt + c;
                  if (paramArrayOfchar[k] == '[') {
                    i = c + 1;
                    continue;
                  } 
                  int j = i;
                  if (paramArrayOfchar[k] == 'L')
                    while (true) {
                      j = ++i;
                      if (paramArrayOfchar[paramInt + i] != ';')
                        continue; 
                      break;
                    }  
                  return new Type(9, paramArrayOfchar, paramInt, j + 1);
                } 
              } 
              return BOOLEAN_TYPE;
            } 
            return LONG_TYPE;
          } 
          return INT_TYPE;
        } 
        return VOID_TYPE;
      } 
      return SHORT_TYPE;
    } 
    return FLOAT_TYPE;
  }
  
  String getDescriptor() {
    return new String(this.buf, this.off, this.len);
  }
  
  public String getInternalName() {
    return new String(this.buf, this.off, this.len);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\asm\Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */