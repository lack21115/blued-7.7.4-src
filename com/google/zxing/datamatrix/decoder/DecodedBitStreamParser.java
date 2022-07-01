package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

final class DecodedBitStreamParser {
  private static final char[] a = new char[] { 
      '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', 
      '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 
      'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
      'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
  
  private static final char[] b = new char[] { 
      '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', 
      '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', 
      '?', '@', '[', '\\', ']', '^', '_' };
  
  private static final char[] c = new char[] { 
      '*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', 
      '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 
      'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 
      'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
  
  private static final char[] d = b;
  
  private static final char[] e = new char[] { 
      '`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 
      'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 
      'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', 
      '~', '' };
  
  private static int a(int paramInt1, int paramInt2) {
    paramInt1 -= paramInt2 * 149 % 255 + 1;
    return (paramInt1 >= 0) ? paramInt1 : (paramInt1 + 256);
  }
  
  static DecoderResult a(byte[] paramArrayOfbyte) throws FormatException {
    BitSource bitSource = new BitSource(paramArrayOfbyte);
    StringBuilder stringBuilder1 = new StringBuilder(100);
    StringBuilder stringBuilder2 = new StringBuilder(0);
    ArrayList<byte[]> arrayList2 = new ArrayList(1);
    Mode mode = Mode.b;
    do {
      if (mode == Mode.b) {
        mode = a(bitSource, stringBuilder1, stringBuilder2);
      } else {
        int i = null.a[mode.ordinal()];
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4) {
                if (i == 5) {
                  a(bitSource, stringBuilder1, (Collection<byte[]>)arrayList2);
                } else {
                  throw FormatException.a();
                } 
              } else {
                d(bitSource, stringBuilder1);
              } 
            } else {
              c(bitSource, stringBuilder1);
            } 
          } else {
            b(bitSource, stringBuilder1);
          } 
        } else {
          a(bitSource, stringBuilder1);
        } 
        mode = Mode.b;
      } 
    } while (mode != Mode.a && bitSource.c() > 0);
    if (stringBuilder2.length() > 0)
      stringBuilder1.append(stringBuilder2); 
    String str = stringBuilder1.toString();
    ArrayList<byte[]> arrayList1 = arrayList2;
    if (arrayList2.isEmpty())
      arrayList1 = null; 
    return new DecoderResult(paramArrayOfbyte, str, arrayList1, null);
  }
  
  private static Mode a(BitSource paramBitSource, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2) throws FormatException {
    boolean bool = false;
    while (true) {
      int i = paramBitSource.a(8);
      if (i != 0) {
        boolean bool1;
        if (i <= 128) {
          bool1 = i;
          if (bool)
            bool1 = i + 128; 
          paramStringBuilder1.append((char)(bool1 - 1));
          return Mode.b;
        } 
        if (i == 129)
          return Mode.a; 
        if (i <= 229) {
          bool1 = i - 130;
          if (bool1 < 10)
            paramStringBuilder1.append('0'); 
          paramStringBuilder1.append(bool1);
          bool1 = bool;
        } else {
          bool1 = bool;
          switch (i) {
            default:
              if (i == 254) {
                if (paramBitSource.c() == 0) {
                  bool1 = bool;
                  break;
                } 
                continue;
              } 
              throw FormatException.a();
            case 240:
              return Mode.f;
            case 239:
              return Mode.d;
            case 238:
              return Mode.e;
            case 237:
              paramStringBuilder1.append("[)>\03606\035");
              paramStringBuilder2.insert(0, "\036\004");
              bool1 = bool;
              break;
            case 236:
              paramStringBuilder1.append("[)>\03605\035");
              paramStringBuilder2.insert(0, "\036\004");
              bool1 = bool;
              break;
            case 235:
              bool1 = true;
              break;
            case 232:
              paramStringBuilder1.append('\035');
              bool1 = bool;
              break;
            case 231:
              return Mode.g;
            case 230:
              return Mode.c;
            case 233:
            case 234:
            case 241:
              break;
          } 
        } 
        bool = bool1;
        if (paramBitSource.c() <= 0)
          return Mode.b; 
        continue;
      } 
      throw FormatException.a();
    } 
  }
  
  private static void a(int paramInt1, int paramInt2, int[] paramArrayOfint) {
    paramInt1 = (paramInt1 << 8) + paramInt2 - 1;
    paramInt2 = paramInt1 / 1600;
    paramArrayOfint[0] = paramInt2;
    paramInt1 -= paramInt2 * 1600;
    paramInt2 = paramInt1 / 40;
    paramArrayOfint[1] = paramInt2;
    paramArrayOfint[2] = paramInt1 - paramInt2 * 40;
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder) throws FormatException {
    int[] arrayOfInt = new int[3];
    boolean bool = false;
    int i = 0;
    do {
      if (paramBitSource.c() == 8)
        return; 
      int j = paramBitSource.a(8);
      if (j == 254)
        return; 
      a(j, paramBitSource.a(8), arrayOfInt);
      j = 0;
      while (true) {
        if (j < 3) {
          int k = arrayOfInt[j];
          if (i) {
            if (i != 1) {
              if (i != 2) {
                if (i == 3) {
                  if (bool) {
                    paramStringBuilder.append((char)(k + 224));
                  } else {
                    paramStringBuilder.append((char)(k + 96));
                    i = 0;
                  } 
                } else {
                  throw FormatException.a();
                } 
              } else {
                char[] arrayOfChar = b;
                if (k < arrayOfChar.length) {
                  char c = arrayOfChar[k];
                  if (bool) {
                    paramStringBuilder.append((char)(c + 128));
                  } else {
                    paramStringBuilder.append(c);
                    i = 0;
                  } 
                } else {
                  if (k != 27) {
                    if (k == 30) {
                      bool = true;
                    } else {
                      throw FormatException.a();
                    } 
                  } else {
                    paramStringBuilder.append('\035');
                  } 
                  i = 0;
                } 
              } 
            } else if (bool) {
              paramStringBuilder.append((char)(k + 128));
            } else {
              paramStringBuilder.append((char)k);
              i = 0;
            } 
            bool = false;
          } else {
            if (k < 3) {
              i = k + 1;
            } else {
              char[] arrayOfChar = a;
              if (k < arrayOfChar.length) {
                char c = arrayOfChar[k];
                if (bool) {
                  paramStringBuilder.append((char)(c + 128));
                  bool = false;
                } else {
                  paramStringBuilder.append(c);
                } 
              } else {
                throw FormatException.a();
              } 
            } 
            j++;
          } 
        } else {
          break;
        } 
        i = 0;
      } 
    } while (paramBitSource.c() > 0);
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, Collection<byte[]> paramCollection) throws FormatException {
    int i = paramBitSource.b() + 1;
    int k = paramBitSource.a(8);
    int j = i + 1;
    i = a(k, i);
    if (i == 0) {
      i = paramBitSource.c() / 8;
    } else if (i >= 250) {
      i = (i - 249) * 250 + a(paramBitSource.a(8), j);
      j++;
    } 
    if (i >= 0) {
      byte[] arrayOfByte = new byte[i];
      k = 0;
      while (k < i) {
        if (paramBitSource.c() >= 8) {
          arrayOfByte[k] = (byte)a(paramBitSource.a(8), j);
          k++;
          j++;
          continue;
        } 
        throw FormatException.a();
      } 
      paramCollection.add(arrayOfByte);
      try {
        paramStringBuilder.append(new String(arrayOfByte, "ISO8859_1"));
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(unsupportedEncodingException)));
      } 
    } 
    throw FormatException.a();
  }
  
  private static void b(BitSource paramBitSource, StringBuilder paramStringBuilder) throws FormatException {
    int[] arrayOfInt = new int[3];
    boolean bool = false;
    int i = 0;
    do {
      if (paramBitSource.c() == 8)
        return; 
      int j = paramBitSource.a(8);
      if (j == 254)
        return; 
      a(j, paramBitSource.a(8), arrayOfInt);
      j = 0;
      while (true) {
        if (j < 3) {
          int k = arrayOfInt[j];
          if (i) {
            if (i != 1) {
              if (i != 2) {
                if (i == 3) {
                  char[] arrayOfChar = e;
                  if (k < arrayOfChar.length) {
                    char c = arrayOfChar[k];
                    if (bool) {
                      paramStringBuilder.append((char)(c + 128));
                    } else {
                      paramStringBuilder.append(c);
                      i = 0;
                    } 
                  } else {
                    throw FormatException.a();
                  } 
                } else {
                  throw FormatException.a();
                } 
              } else {
                char[] arrayOfChar = d;
                if (k < arrayOfChar.length) {
                  char c = arrayOfChar[k];
                  if (bool) {
                    paramStringBuilder.append((char)(c + 128));
                  } else {
                    paramStringBuilder.append(c);
                    i = 0;
                  } 
                } else {
                  if (k != 27) {
                    if (k == 30) {
                      bool = true;
                    } else {
                      throw FormatException.a();
                    } 
                  } else {
                    paramStringBuilder.append('\035');
                  } 
                  i = 0;
                } 
              } 
            } else if (bool) {
              paramStringBuilder.append((char)(k + 128));
            } else {
              paramStringBuilder.append((char)k);
              i = 0;
            } 
            bool = false;
          } else {
            if (k < 3) {
              i = k + 1;
            } else {
              char[] arrayOfChar = c;
              if (k < arrayOfChar.length) {
                char c = arrayOfChar[k];
                if (bool) {
                  paramStringBuilder.append((char)(c + 128));
                  bool = false;
                } else {
                  paramStringBuilder.append(c);
                } 
              } else {
                throw FormatException.a();
              } 
            } 
            j++;
          } 
        } else {
          break;
        } 
        i = 0;
      } 
    } while (paramBitSource.c() > 0);
  }
  
  private static void c(BitSource paramBitSource, StringBuilder paramStringBuilder) throws FormatException {
    int[] arrayOfInt = new int[3];
    do {
      if (paramBitSource.c() == 8)
        return; 
      int i = paramBitSource.a(8);
      if (i == 254)
        return; 
      a(i, paramBitSource.a(8), arrayOfInt);
      for (i = 0; i < 3; i++) {
        int j = arrayOfInt[i];
        if (j != 0) {
          if (j != 1) {
            if (j != 2) {
              if (j != 3) {
                if (j < 14) {
                  paramStringBuilder.append((char)(j + 44));
                } else if (j < 40) {
                  paramStringBuilder.append((char)(j + 51));
                } else {
                  throw FormatException.a();
                } 
              } else {
                paramStringBuilder.append(' ');
              } 
            } else {
              paramStringBuilder.append('>');
            } 
          } else {
            paramStringBuilder.append('*');
          } 
        } else {
          paramStringBuilder.append('\r');
        } 
      } 
    } while (paramBitSource.c() > 0);
  }
  
  private static void d(BitSource paramBitSource, StringBuilder paramStringBuilder) {
    do {
      if (paramBitSource.c() <= 16)
        return; 
      for (int i = 0; i < 4; i++) {
        int k = paramBitSource.a(6);
        if (k == 31) {
          i = 8 - paramBitSource.a();
          if (i != 8)
            paramBitSource.a(i); 
          return;
        } 
        int j = k;
        if ((k & 0x20) == 0)
          j = k | 0x40; 
        paramStringBuilder.append((char)j);
      } 
    } while (paramBitSource.c() > 0);
  }
  
  enum Mode {
    a, b, c, d, e, f, g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\datamatrix\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */