package com.bytedance.sdk.a.a;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class f implements Serializable, Comparable<f> {
  static final char[] a = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  public static final f b = a(new byte[0]);
  
  final byte[] c;
  
  transient int d;
  
  transient String e;
  
  f(byte[] paramArrayOfbyte) {
    this.c = paramArrayOfbyte;
  }
  
  private static int a(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    byte b = 97;
    if (paramChar < 'a' || paramChar > 'f') {
      b = 65;
      if (paramChar < 'A' || paramChar > 'F') {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected hex digit: ");
        stringBuilder.append(paramChar);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
    } 
    return paramChar - b + 10;
  }
  
  static int a(String paramString, int paramInt) {
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k) {
      if (j == paramInt)
        return i; 
      int m = paramString.codePointAt(i);
      if ((Character.isISOControl(m) && m != 10 && m != 13) || m == 65533)
        return -1; 
      j++;
      i += Character.charCount(m);
    } 
    return paramString.length();
  }
  
  public static f a(String paramString) {
    if (paramString != null) {
      f f1 = new f(paramString.getBytes(u.a));
      f1.e = paramString;
      return f1;
    } 
    throw new IllegalArgumentException("s == null");
  }
  
  public static f a(byte... paramVarArgs) {
    if (paramVarArgs != null)
      return new f((byte[])paramVarArgs.clone()); 
    throw new IllegalArgumentException("data == null");
  }
  
  public static f b(String paramString) {
    if (paramString != null) {
      if (paramString.length() % 2 == 0) {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        for (int i = 0; i < arrayOfByte.length; i++) {
          int j = i * 2;
          arrayOfByte[i] = (byte)((a(paramString.charAt(j)) << 4) + a(paramString.charAt(j + 1)));
        } 
        return a(arrayOfByte);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected hex string: ");
      stringBuilder.append(paramString);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("hex == null");
  }
  
  private f c(String paramString) {
    try {
      return a(MessageDigest.getInstance(paramString).digest(this.c));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } 
  }
  
  public byte a(int paramInt) {
    return this.c[paramInt];
  }
  
  public f a(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      byte[] arrayOfByte = this.c;
      if (paramInt2 <= arrayOfByte.length) {
        int i = paramInt2 - paramInt1;
        if (i >= 0) {
          if (paramInt1 == 0 && paramInt2 == arrayOfByte.length)
            return this; 
          arrayOfByte = new byte[i];
          System.arraycopy(this.c, paramInt1, arrayOfByte, 0, i);
          return new f(arrayOfByte);
        } 
        throw new IllegalArgumentException("endIndex < beginIndex");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("endIndex > length(");
      stringBuilder.append(this.c.length);
      stringBuilder.append(")");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("beginIndex < 0");
  }
  
  public String a() {
    String str = this.e;
    if (str != null)
      return str; 
    str = new String(this.c, u.a);
    this.e = str;
    return str;
  }
  
  void a(c paramc) {
    byte[] arrayOfByte = this.c;
    paramc.b(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public boolean a(int paramInt1, f paramf, int paramInt2, int paramInt3) {
    return paramf.a(paramInt2, this.c, paramInt1, paramInt3);
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    if (paramInt1 >= 0) {
      byte[] arrayOfByte = this.c;
      if (paramInt1 <= arrayOfByte.length - paramInt3 && paramInt2 >= 0 && paramInt2 <= paramArrayOfbyte.length - paramInt3 && u.a(arrayOfByte, paramInt1, paramArrayOfbyte, paramInt2, paramInt3))
        return true; 
    } 
    return false;
  }
  
  public final boolean a(f paramf) {
    return a(0, paramf, 0, paramf.g());
  }
  
  public int b(f paramf) {
    int j = g();
    int k = paramf.g();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m) {
      int n = a(i) & 0xFF;
      int i1 = paramf.a(i) & 0xFF;
      if (n == i1) {
        i++;
        continue;
      } 
      return (n < i1) ? -1 : 1;
    } 
    return (j == k) ? 0 : ((j < k) ? -1 : 1);
  }
  
  public String b() {
    return b.a(this.c);
  }
  
  public f c() {
    return c("SHA-1");
  }
  
  public f d() {
    return c("SHA-256");
  }
  
  public String e() {
    byte[] arrayOfByte = this.c;
    char[] arrayOfChar = new char[arrayOfByte.length * 2];
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      byte b = arrayOfByte[i];
      int m = j + 1;
      char[] arrayOfChar1 = a;
      arrayOfChar[j] = arrayOfChar1[b >> 4 & 0xF];
      j = m + 1;
      arrayOfChar[m] = arrayOfChar1[b & 0xF];
      i++;
    } 
    return new String(arrayOfChar);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof f) {
      paramObject = paramObject;
      int i = paramObject.g();
      byte[] arrayOfByte = this.c;
      if (i == arrayOfByte.length && paramObject.a(0, arrayOfByte, 0, arrayOfByte.length))
        return true; 
    } 
    return false;
  }
  
  public f f() {
    int i = 0;
    while (true) {
      byte[] arrayOfByte = this.c;
      if (i < arrayOfByte.length) {
        byte b = arrayOfByte[i];
        if (b < 65 || b > 90) {
          i++;
          continue;
        } 
        arrayOfByte = (byte[])arrayOfByte.clone();
        int j = i + 1;
        arrayOfByte[i] = (byte)(b + 32);
        for (i = j; i < arrayOfByte.length; i++) {
          j = arrayOfByte[i];
          if (j >= 65 && j <= 90)
            arrayOfByte[i] = (byte)(j + 32); 
        } 
        return new f(arrayOfByte);
      } 
      return this;
    } 
  }
  
  public int g() {
    return this.c.length;
  }
  
  public byte[] h() {
    return (byte[])this.c.clone();
  }
  
  public int hashCode() {
    int i = this.d;
    if (i != 0)
      return i; 
    i = Arrays.hashCode(this.c);
    this.d = i;
    return i;
  }
  
  public String toString() {
    StringBuilder stringBuilder;
    if (this.c.length == 0)
      return "[size=0]"; 
    String str1 = a();
    int i = a(str1, 64);
    if (i == -1) {
      if (this.c.length <= 64) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[hex=");
        stringBuilder1.append(e());
        stringBuilder1.append("]");
        return stringBuilder1.toString();
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("[size=");
      stringBuilder.append(this.c.length);
      stringBuilder.append(" hex=");
      stringBuilder.append(a(0, 64).e());
      stringBuilder.append("…]");
      return stringBuilder.toString();
    } 
    String str2 = stringBuilder.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < stringBuilder.length()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("[size=");
      stringBuilder.append(this.c.length);
      stringBuilder.append(" text=");
      stringBuilder.append(str2);
      stringBuilder.append("…]");
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("[text=");
      stringBuilder.append(str2);
      stringBuilder.append("]");
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */