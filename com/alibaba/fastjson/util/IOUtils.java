package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

public class IOUtils {
  public static final char[] ASCII_CHARS;
  
  public static final char[] CA;
  
  public static final char[] DIGITS = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  static final char[] DigitOnes;
  
  static final char[] DigitTens;
  
  public static final int[] IA;
  
  private static final ThreadLocal<SoftReference<char[]>> charsBufLocal;
  
  private static final ThreadLocal<CharsetDecoder> decoderLocal;
  
  static final char[] digits;
  
  public static final boolean[] firstIdentifierFlags = new boolean[256];
  
  public static final boolean[] identifierFlags;
  
  public static final char[] replaceChars;
  
  static final int[] sizeTable;
  
  public static final byte[] specicalFlags_doubleQuotes;
  
  public static final boolean[] specicalFlags_doubleQuotesFlags;
  
  public static final byte[] specicalFlags_singleQuotes;
  
  public static final boolean[] specicalFlags_singleQuotesFlags;
  
  static {
    int i = 0;
    while (true) {
      boolean[] arrayOfBoolean = firstIdentifierFlags;
      if (i < arrayOfBoolean.length) {
        if (i >= 65 && i <= 90) {
          arrayOfBoolean[i] = true;
        } else if (i >= 97 && i <= 122) {
          firstIdentifierFlags[i] = true;
        } else if (i == 95) {
          firstIdentifierFlags[i] = true;
        } 
        i = (char)(i + 1);
        continue;
      } 
      identifierFlags = new boolean[256];
      i = 0;
      while (true) {
        arrayOfBoolean = identifierFlags;
        if (i < arrayOfBoolean.length) {
          if (i >= 65 && i <= 90) {
            arrayOfBoolean[i] = true;
          } else if (i >= 97 && i <= 122) {
            identifierFlags[i] = true;
          } else if (i == 95) {
            identifierFlags[i] = true;
          } else if (i >= 48 && i <= 57) {
            identifierFlags[i] = true;
          } 
          i = (char)(i + 1);
          continue;
        } 
        specicalFlags_doubleQuotes = new byte[161];
        specicalFlags_singleQuotes = new byte[161];
        specicalFlags_doubleQuotesFlags = new boolean[161];
        specicalFlags_singleQuotesFlags = new boolean[161];
        replaceChars = new char[93];
        byte[] arrayOfByte = specicalFlags_doubleQuotes;
        arrayOfByte[0] = 4;
        arrayOfByte[1] = 4;
        arrayOfByte[2] = 4;
        arrayOfByte[3] = 4;
        arrayOfByte[4] = 4;
        arrayOfByte[5] = 4;
        arrayOfByte[6] = 4;
        arrayOfByte[7] = 4;
        arrayOfByte[8] = 1;
        arrayOfByte[9] = 1;
        arrayOfByte[10] = 1;
        arrayOfByte[11] = 4;
        arrayOfByte[12] = 1;
        arrayOfByte[13] = 1;
        arrayOfByte[34] = 1;
        arrayOfByte[92] = 1;
        arrayOfByte = specicalFlags_singleQuotes;
        arrayOfByte[0] = 4;
        arrayOfByte[1] = 4;
        arrayOfByte[2] = 4;
        arrayOfByte[3] = 4;
        arrayOfByte[4] = 4;
        arrayOfByte[5] = 4;
        arrayOfByte[6] = 4;
        arrayOfByte[7] = 4;
        arrayOfByte[8] = 1;
        arrayOfByte[9] = 1;
        arrayOfByte[10] = 1;
        arrayOfByte[11] = 4;
        arrayOfByte[12] = 1;
        arrayOfByte[13] = 1;
        arrayOfByte[92] = 1;
        arrayOfByte[39] = 1;
        for (i = 14; i <= 31; i++) {
          specicalFlags_doubleQuotes[i] = 4;
          specicalFlags_singleQuotes[i] = 4;
        } 
        for (i = 127; i <= 160; i++) {
          specicalFlags_doubleQuotes[i] = 4;
          specicalFlags_singleQuotes[i] = 4;
        } 
        for (i = 0; i < 161; i++) {
          boolean bool;
          boolean[] arrayOfBoolean1 = specicalFlags_doubleQuotesFlags;
          if (specicalFlags_doubleQuotes[i] != 0) {
            bool = true;
          } else {
            bool = false;
          } 
          arrayOfBoolean1[i] = bool;
          arrayOfBoolean1 = specicalFlags_singleQuotesFlags;
          if (specicalFlags_singleQuotes[i] != 0) {
            bool = true;
          } else {
            bool = false;
          } 
          arrayOfBoolean1[i] = bool;
        } 
        char[] arrayOfChar = replaceChars;
        arrayOfChar[0] = '0';
        arrayOfChar[1] = '1';
        arrayOfChar[2] = '2';
        arrayOfChar[3] = '3';
        arrayOfChar[4] = '4';
        arrayOfChar[5] = '5';
        arrayOfChar[6] = '6';
        arrayOfChar[7] = '7';
        arrayOfChar[8] = 'b';
        arrayOfChar[9] = 't';
        arrayOfChar[10] = 'n';
        arrayOfChar[11] = 'v';
        arrayOfChar[12] = 'f';
        arrayOfChar[13] = 'r';
        arrayOfChar[34] = '"';
        arrayOfChar[39] = '\'';
        arrayOfChar[47] = '/';
        arrayOfChar[92] = '\\';
        ASCII_CHARS = new char[] { 
            '0', '0', '0', '1', '0', '2', '0', '3', '0', '4', 
            '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', 
            '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', 
            '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', 
            '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', 
            '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', 
            '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', 
            '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', 
            '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', 
            '2', 'D', '2', 'E', '2', 'F' };
        digits = new char[] { 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
            'u', 'v', 'w', 'x', 'y', 'z' };
        DigitTens = new char[] { 
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', 
            '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', 
            '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', 
            '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', 
            '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', 
            '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', 
            '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', 
            '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', 
            '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', 
            '9', '9', '9', '9', '9', '9', '9', '9', '9', '9' };
        DigitOnes = new char[] { 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        sizeTable = new int[] { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
        CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        IA = new int[256];
        Arrays.fill(IA, -1);
        int j = CA.length;
        for (i = 0; i < j; i++)
          IA[CA[i]] = i; 
        IA[61] = 0;
        charsBufLocal = new ThreadLocal<SoftReference<char[]>>();
        decoderLocal = new ThreadLocal<CharsetDecoder>();
        return;
      } 
      break;
    } 
  }
  
  private static char[] allocate(int paramInt) {
    if (paramInt > 131072)
      return new char[paramInt]; 
    if (paramInt >>> 10 <= 0) {
      paramInt = 1024;
    } else {
      paramInt = 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
    } 
    char[] arrayOfChar = new char[paramInt];
    charsBufLocal.set((SoftReference)new SoftReference<char>(arrayOfChar));
    return arrayOfChar;
  }
  
  public static void clearChars() {
    charsBufLocal.set(null);
  }
  
  public static void close(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void decode(CharsetDecoder paramCharsetDecoder, ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer) {
    try {
      CoderResult coderResult2 = paramCharsetDecoder.decode(paramByteBuffer, paramCharBuffer, true);
      if (!coderResult2.isUnderflow())
        coderResult2.throwException(); 
      CoderResult coderResult1 = paramCharsetDecoder.flush(paramCharBuffer);
      if (!coderResult1.isUnderflow())
        coderResult1.throwException(); 
      return;
    } catch (CharacterCodingException characterCodingException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("utf8 decode error, ");
      stringBuilder.append(characterCodingException.getMessage());
      throw new JSONException(stringBuilder.toString(), characterCodingException);
    } 
  }
  
  public static byte[] decodeFast(String paramString) {
    int n;
    int i1;
    int k = paramString.length();
    boolean bool = false;
    if (k == 0)
      return new byte[0]; 
    int i = k - 1;
    int j = 0;
    while (true) {
      n = i;
      if (j < i) {
        n = i;
        if (IA[paramString.charAt(j) & 0xFF] < 0) {
          j++;
          continue;
        } 
      } 
      break;
    } 
    while (n > 0 && IA[paramString.charAt(n) & 0xFF] < 0)
      n--; 
    if (paramString.charAt(n) == '=') {
      if (paramString.charAt(n - 1) == '=') {
        i = 2;
      } else {
        i = 1;
      } 
    } else {
      i = 0;
    } 
    int m = n - j + 1;
    if (k > 76) {
      if (paramString.charAt(76) == '\r') {
        k = m / 78;
      } else {
        k = 0;
      } 
      i1 = k << 1;
    } else {
      i1 = 0;
    } 
    int i3 = ((m - i1) * 6 >> 3) - i;
    byte[] arrayOfByte = new byte[i3];
    int i4 = i3 / 3;
    int i2 = 0;
    k = 0;
    m = j;
    for (j = i2; j < i4 * 3; j = i2 + 1) {
      int[] arrayOfInt = IA;
      int i5 = m + 1;
      i2 = arrayOfInt[paramString.charAt(m)];
      arrayOfInt = IA;
      m = i5 + 1;
      i5 = arrayOfInt[paramString.charAt(i5)];
      arrayOfInt = IA;
      int i6 = m + 1;
      int i7 = arrayOfInt[paramString.charAt(m)];
      arrayOfInt = IA;
      m = i6 + 1;
      i5 = i2 << 18 | i5 << 12 | i7 << 6 | arrayOfInt[paramString.charAt(i6)];
      i6 = j + 1;
      arrayOfByte[j] = (byte)(i5 >> 16);
      i2 = i6 + 1;
      arrayOfByte[i6] = (byte)(i5 >> 8);
      arrayOfByte[i2] = (byte)i5;
      j = k;
      if (i1 > 0) {
        j = ++k;
        if (k == 19) {
          m += 2;
          k = 0;
          continue;
        } 
      } 
      k = j;
      continue;
    } 
    if (j < i3) {
      i1 = 0;
      k = bool;
      while (m <= n - i) {
        k |= IA[paramString.charAt(m)] << 18 - i1 * 6;
        i1++;
        m++;
      } 
      i = 16;
      while (j < i3) {
        arrayOfByte[j] = (byte)(k >> i);
        i -= 8;
        j++;
      } 
    } 
    return arrayOfByte;
  }
  
  public static byte[] decodeFast(String paramString, int paramInt1, int paramInt2) {
    int k;
    int m;
    boolean bool = false;
    if (paramInt2 == 0)
      return new byte[0]; 
    int j = paramInt1 + paramInt2 - 1;
    int i = paramInt1;
    while (true) {
      k = j;
      if (i < j) {
        k = j;
        if (IA[paramString.charAt(i)] < 0) {
          i++;
          continue;
        } 
      } 
      break;
    } 
    while (k > 0 && IA[paramString.charAt(k)] < 0)
      k--; 
    if (paramString.charAt(k) == '=') {
      if (paramString.charAt(k - 1) == '=') {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      } 
    } else {
      paramInt1 = 0;
    } 
    j = k - i + 1;
    if (paramInt2 > 76) {
      if (paramString.charAt(76) == '\r') {
        paramInt2 = j / 78;
      } else {
        paramInt2 = 0;
      } 
      m = paramInt2 << 1;
    } else {
      m = 0;
    } 
    int n = ((j - m) * 6 >> 3) - paramInt1;
    byte[] arrayOfByte = new byte[n];
    int i1 = n / 3;
    j = i;
    paramInt2 = 0;
    i = 0;
    while (paramInt2 < i1 * 3) {
      int[] arrayOfInt = IA;
      int i3 = j + 1;
      int i2 = arrayOfInt[paramString.charAt(j)];
      arrayOfInt = IA;
      j = i3 + 1;
      i3 = arrayOfInt[paramString.charAt(i3)];
      arrayOfInt = IA;
      int i4 = j + 1;
      int i5 = arrayOfInt[paramString.charAt(j)];
      arrayOfInt = IA;
      j = i4 + 1;
      i3 = i2 << 18 | i3 << 12 | i5 << 6 | arrayOfInt[paramString.charAt(i4)];
      i4 = paramInt2 + 1;
      arrayOfByte[paramInt2] = (byte)(i3 >> 16);
      i2 = i4 + 1;
      arrayOfByte[i4] = (byte)(i3 >> 8);
      arrayOfByte[i2] = (byte)i3;
      paramInt2 = i;
      if (m > 0) {
        paramInt2 = ++i;
        if (i == 19) {
          j += 2;
          paramInt2 = 0;
        } 
      } 
      i2++;
      i = paramInt2;
      paramInt2 = i2;
    } 
    if (paramInt2 < n) {
      m = 0;
      i = bool;
      while (j <= k - paramInt1) {
        i |= IA[paramString.charAt(j)] << 18 - m * 6;
        m++;
        j++;
      } 
      paramInt1 = 16;
      while (paramInt2 < n) {
        arrayOfByte[paramInt2] = (byte)(i >> paramInt1);
        paramInt1 -= 8;
        paramInt2++;
      } 
    } 
    return arrayOfByte;
  }
  
  public static byte[] decodeFast(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    int k;
    int m;
    boolean bool = false;
    if (paramInt2 == 0)
      return new byte[0]; 
    int j = paramInt1 + paramInt2 - 1;
    int i = paramInt1;
    while (true) {
      k = j;
      if (i < j) {
        k = j;
        if (IA[paramArrayOfchar[i]] < 0) {
          i++;
          continue;
        } 
      } 
      break;
    } 
    while (k > 0 && IA[paramArrayOfchar[k]] < 0)
      k--; 
    if (paramArrayOfchar[k] == '=') {
      if (paramArrayOfchar[k - 1] == '=') {
        paramInt1 = 2;
      } else {
        paramInt1 = 1;
      } 
    } else {
      paramInt1 = 0;
    } 
    j = k - i + 1;
    if (paramInt2 > 76) {
      if (paramArrayOfchar[76] == '\r') {
        paramInt2 = j / 78;
      } else {
        paramInt2 = 0;
      } 
      m = paramInt2 << 1;
    } else {
      m = 0;
    } 
    int n = ((j - m) * 6 >> 3) - paramInt1;
    byte[] arrayOfByte = new byte[n];
    int i1 = n / 3;
    j = i;
    paramInt2 = 0;
    i = 0;
    while (paramInt2 < i1 * 3) {
      int[] arrayOfInt = IA;
      int i3 = j + 1;
      int i2 = arrayOfInt[paramArrayOfchar[j]];
      j = i3 + 1;
      i3 = arrayOfInt[paramArrayOfchar[i3]];
      int i4 = j + 1;
      int i5 = arrayOfInt[paramArrayOfchar[j]];
      j = i4 + 1;
      i3 = i2 << 18 | i3 << 12 | i5 << 6 | arrayOfInt[paramArrayOfchar[i4]];
      i4 = paramInt2 + 1;
      arrayOfByte[paramInt2] = (byte)(i3 >> 16);
      i2 = i4 + 1;
      arrayOfByte[i4] = (byte)(i3 >> 8);
      arrayOfByte[i2] = (byte)i3;
      paramInt2 = i;
      if (m > 0) {
        paramInt2 = ++i;
        if (i == 19) {
          j += 2;
          paramInt2 = 0;
        } 
      } 
      i2++;
      i = paramInt2;
      paramInt2 = i2;
    } 
    if (paramInt2 < n) {
      m = 0;
      i = bool;
      while (j <= k - paramInt1) {
        i |= IA[paramArrayOfchar[j]] << 18 - m * 6;
        m++;
        j++;
      } 
      paramInt1 = 16;
      while (paramInt2 < n) {
        arrayOfByte[paramInt2] = (byte)(i >> paramInt1);
        paramInt1 -= 8;
        paramInt2++;
      } 
    } 
    return arrayOfByte;
  }
  
  public static boolean firstIdentifier(char paramChar) {
    boolean[] arrayOfBoolean = firstIdentifierFlags;
    return (paramChar < arrayOfBoolean.length && arrayOfBoolean[paramChar]);
  }
  
  public static void getChars(byte paramByte, int paramInt, char[] paramArrayOfchar) {
    boolean bool;
    if (paramByte < 0) {
      bool = true;
      paramByte = -paramByte;
    } else {
      bool = false;
    } 
    while (true) {
      int j = 52429 * paramByte >>> 19;
      paramArrayOfchar[--paramInt] = digits[paramByte - (j << 3) + (j << 1)];
      if (j == 0) {
        if (bool)
          paramArrayOfchar[paramInt - 1] = bool; 
        return;
      } 
      int i = j;
    } 
  }
  
  public static void getChars(int paramInt1, int paramInt2, char[] paramArrayOfchar) {
    boolean bool;
    int i;
    int j;
    if (paramInt1 < 0) {
      bool = true;
      paramInt1 = -paramInt1;
    } else {
      bool = false;
    } 
    while (true) {
      i = paramInt1;
      j = paramInt2;
      if (paramInt1 >= 65536) {
        i = paramInt1 / 100;
        paramInt1 -= (i << 6) + (i << 5) + (i << 2);
        paramArrayOfchar[--paramInt2] = DigitOnes[paramInt1];
        paramArrayOfchar[--paramInt2] = DigitTens[paramInt1];
        paramInt1 = i;
        continue;
      } 
      break;
    } 
    while (true) {
      paramInt1 = 52429 * i >>> 19;
      paramArrayOfchar[--j] = digits[i - (paramInt1 << 3) + (paramInt1 << 1)];
      if (paramInt1 == 0) {
        if (bool)
          paramArrayOfchar[j - 1] = bool; 
        return;
      } 
      i = paramInt1;
    } 
  }
  
  public static void getChars(long paramLong, int paramInt, char[] paramArrayOfchar) {
    boolean bool;
    int j;
    int k;
    if (paramLong < 0L) {
      bool = true;
      paramLong = -paramLong;
    } else {
      bool = false;
    } 
    while (paramLong > 2147483647L) {
      long l = paramLong / 100L;
      int m = (int)(paramLong - (l << 6L) + (l << 5L) + (l << 2L));
      paramArrayOfchar[--paramInt] = DigitOnes[m];
      paramArrayOfchar[--paramInt] = DigitTens[m];
      paramLong = l;
    } 
    int i = (int)paramLong;
    while (true) {
      j = i;
      k = paramInt;
      if (i >= 65536) {
        j = i / 100;
        i -= (j << 6) + (j << 5) + (j << 2);
        paramArrayOfchar[--paramInt] = DigitOnes[i];
        paramArrayOfchar[--paramInt] = DigitTens[i];
        i = j;
        continue;
      } 
      break;
    } 
    while (true) {
      paramInt = 52429 * j >>> 19;
      paramArrayOfchar[--k] = digits[j - (paramInt << 3) + (paramInt << 1)];
      if (paramInt == 0) {
        if (bool)
          paramArrayOfchar[k - 1] = bool; 
        return;
      } 
      j = paramInt;
    } 
  }
  
  public static char[] getChars(int paramInt) {
    SoftReference<char[]> softReference = charsBufLocal.get();
    if (softReference == null)
      return allocate(paramInt); 
    char[] arrayOfChar2 = softReference.get();
    if (arrayOfChar2 == null)
      return allocate(paramInt); 
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2.length < paramInt)
      arrayOfChar1 = allocate(paramInt); 
    return arrayOfChar1;
  }
  
  public static CharsetDecoder getUTF8Decoder() {
    CharsetDecoder charsetDecoder2 = decoderLocal.get();
    CharsetDecoder charsetDecoder1 = charsetDecoder2;
    if (charsetDecoder2 == null) {
      charsetDecoder1 = new UTF8Decoder();
      decoderLocal.set(charsetDecoder1);
    } 
    return charsetDecoder1;
  }
  
  public static boolean isIdent(char paramChar) {
    boolean[] arrayOfBoolean = identifierFlags;
    return (paramChar < arrayOfBoolean.length && arrayOfBoolean[paramChar]);
  }
  
  public static String readAll(Reader paramReader) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      char[] arrayOfChar = new char[2048];
      while (true) {
        int i = paramReader.read(arrayOfChar, 0, arrayOfChar.length);
        if (i < 0)
          return stringBuilder.toString(); 
        stringBuilder.append(arrayOfChar, 0, i);
      } 
    } catch (Exception exception) {
      throw new JSONException("read string from reader error", exception);
    } 
  }
  
  public static int stringSize(int paramInt) {
    for (int i = 0;; i++) {
      if (paramInt <= sizeTable[i])
        return i + 1; 
    } 
  }
  
  public static int stringSize(long paramLong) {
    int i = 1;
    long l = 10L;
    while (i < 19) {
      if (paramLong < l)
        return i; 
      l *= 10L;
      i++;
    } 
    return 19;
  }
  
  public static String toString(InputStream paramInputStream) throws Exception {
    return readAll(new BufferedReader(new InputStreamReader(paramInputStream)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */