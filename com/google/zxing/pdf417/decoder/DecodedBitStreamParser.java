package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

final class DecodedBitStreamParser {
  private static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
  
  private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
  
  private static final BigInteger[] c;
  
  static {
    BigInteger[] arrayOfBigInteger = new BigInteger[16];
    c = arrayOfBigInteger;
    arrayOfBigInteger[0] = BigInteger.ONE;
    BigInteger bigInteger = BigInteger.valueOf(900L);
    c[1] = bigInteger;
    int i = 2;
    while (true) {
      BigInteger[] arrayOfBigInteger1 = c;
      if (i < arrayOfBigInteger1.length) {
        arrayOfBigInteger1[i] = arrayOfBigInteger1[i - 1].multiply(bigInteger);
        i++;
        continue;
      } 
      break;
    } 
  }
  
  private static int a(int paramInt1, int[] paramArrayOfint, Charset paramCharset, int paramInt2, StringBuilder paramStringBuilder) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = 6;
    byte b = 0;
    if (paramInt1 != 901) {
      if (paramInt1 != 924) {
        paramInt1 = paramInt2;
      } else {
        int j = 0;
        i = paramInt2;
        label68: while (true) {
          paramInt2 = 0;
          long l = 0L;
          while (true) {
            paramInt1 = i;
            if (i < paramArrayOfint[0]) {
              paramInt1 = i;
              if (!j) {
                paramInt1 = i + 1;
                int k = paramArrayOfint[i];
                if (k < 900) {
                  paramInt2++;
                  l = l * 900L + k;
                } 
                if (k != 928) {
                  int m;
                  long l1;
                  switch (k) {
                    default:
                      switch (k) {
                        default:
                          k = j;
                          m = paramInt2;
                          l1 = l;
                          break;
                        case 922:
                        case 923:
                        case 924:
                          break;
                      } 
                    case 900:
                    case 901:
                    case 902:
                      paramInt1--;
                      k = 1;
                      l1 = l;
                      m = paramInt2;
                      break;
                  } 
                  i = paramInt1;
                  j = k;
                  paramInt2 = m;
                  l = l1;
                  if (m % 5 == 0) {
                    i = paramInt1;
                    j = k;
                    paramInt2 = m;
                    l = l1;
                    if (m > 0) {
                      paramInt2 = 0;
                      while (true) {
                        i = paramInt1;
                        j = k;
                        if (paramInt2 < 6) {
                          byteArrayOutputStream.write((byte)(int)(l1 >> (5 - paramInt2) * 8));
                          paramInt2++;
                          continue;
                        } 
                        continue label68;
                      } 
                    } 
                  } 
                  continue;
                } 
              } 
            } 
            break;
          } 
          break;
        } 
      } 
    } else {
      int[] arrayOfInt = new int[6];
      paramInt1 = paramInt2 + 1;
      int k = paramArrayOfint[paramInt2];
      int j = 0;
      paramInt2 = i;
      while (true) {
        i = 0;
        long l = 0L;
        while (paramInt1 < paramArrayOfint[0] && !j) {
          int m = i + 1;
          arrayOfInt[i] = k;
          l = l * 900L + k;
          i = paramInt1 + 1;
          k = paramArrayOfint[paramInt1];
          if (k != 928)
            switch (k) {
              default:
                switch (k) {
                  case 922:
                  case 923:
                  case 924:
                    break;
                } 
                continue;
              case 900:
              case 901:
              case 902:
                break;
            }  
          paramInt1 = i - 1;
          i = m;
          paramInt2 = 6;
          j = 1;
        } 
        break;
      } 
      j = b;
      paramInt2 = i;
      if (paramInt1 == paramArrayOfint[0]) {
        j = b;
        paramInt2 = i;
        if (k < 900) {
          arrayOfInt[i] = k;
          paramInt2 = i + 1;
          j = b;
        } 
      } 
      while (j < paramInt2) {
        byteArrayOutputStream.write((byte)arrayOfInt[j]);
        j++;
      } 
    } 
    paramStringBuilder.append(new String(byteArrayOutputStream.toByteArray(), paramCharset));
    return paramInt1;
  }
  
  static int a(int[] paramArrayOfint, int paramInt, PDF417ResultMetadata paramPDF417ResultMetadata) throws FormatException {
    if (paramInt + 2 <= paramArrayOfint[0]) {
      int[] arrayOfInt = new int[2];
      int i = 0;
      while (i < 2) {
        arrayOfInt[i] = paramArrayOfint[paramInt];
        i++;
        paramInt++;
      } 
      paramPDF417ResultMetadata.a(Integer.parseInt(a(arrayOfInt, 2)));
      StringBuilder stringBuilder = new StringBuilder();
      paramInt = a(paramArrayOfint, paramInt, stringBuilder);
      paramPDF417ResultMetadata.a(stringBuilder.toString());
      if (paramArrayOfint[paramInt] == 923) {
        i = paramInt + 1;
      } else {
        i = -1;
      } 
      while (paramInt < paramArrayOfint[0]) {
        int j = paramArrayOfint[paramInt];
        if (j != 922) {
          if (j == 923) {
            switch (paramArrayOfint[++paramInt]) {
              default:
                throw FormatException.a();
              case 6:
                stringBuilder = new StringBuilder();
                paramInt = b(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.c(Integer.parseInt(stringBuilder.toString()));
                continue;
              case 5:
                stringBuilder = new StringBuilder();
                paramInt = b(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.a(Long.parseLong(stringBuilder.toString()));
                continue;
              case 4:
                stringBuilder = new StringBuilder();
                paramInt = a(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.c(stringBuilder.toString());
                continue;
              case 3:
                stringBuilder = new StringBuilder();
                paramInt = a(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.b(stringBuilder.toString());
                continue;
              case 2:
                stringBuilder = new StringBuilder();
                paramInt = b(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.b(Long.parseLong(stringBuilder.toString()));
                continue;
              case 1:
                stringBuilder = new StringBuilder();
                paramInt = b(paramArrayOfint, paramInt + 1, stringBuilder);
                paramPDF417ResultMetadata.b(Integer.parseInt(stringBuilder.toString()));
                continue;
              case 0:
                break;
            } 
            stringBuilder = new StringBuilder();
            paramInt = a(paramArrayOfint, paramInt + 1, stringBuilder);
            paramPDF417ResultMetadata.d(stringBuilder.toString());
            continue;
          } 
          throw FormatException.a();
        } 
        paramInt++;
        paramPDF417ResultMetadata.a(true);
      } 
      if (i != -1) {
        int k = paramInt - i;
        int j = k;
        if (paramPDF417ResultMetadata.a())
          j = k - 1; 
        paramPDF417ResultMetadata.a(Arrays.copyOfRange(paramArrayOfint, i, j + i));
      } 
      return paramInt;
    } 
    throw FormatException.a();
  }
  
  private static int a(int[] paramArrayOfint, int paramInt, StringBuilder paramStringBuilder) {
    int[] arrayOfInt1 = new int[paramArrayOfint[0] - paramInt << 1];
    int[] arrayOfInt2 = new int[paramArrayOfint[0] - paramInt << 1];
    boolean bool = false;
    int i = 0;
    while (true) {
      int j;
      if (paramInt < paramArrayOfint[0] && !bool) {
        j = paramInt + 1;
        paramInt = paramArrayOfint[paramInt];
        if (paramInt < 900) {
          arrayOfInt1[i] = paramInt / 30;
          arrayOfInt1[i + 1] = paramInt % 30;
          i += 2;
        } else {
          if (paramInt != 913) {
            if (paramInt != 928)
              switch (paramInt) {
                default:
                  switch (paramInt) {
                    case 922:
                    case 923:
                    case 924:
                      break;
                  } 
                  continue;
                case 900:
                  arrayOfInt1[i] = 900;
                  i++;
                  paramInt = j;
                  break;
                case 901:
                case 902:
                  break;
              }  
            paramInt = j - 1;
            bool = true;
            continue;
          } 
          arrayOfInt1[i] = 913;
          paramInt = j + 1;
          arrayOfInt2[i] = paramArrayOfint[j];
          i++;
          continue;
        } 
      } else {
        break;
      } 
      paramInt = j;
      break;
    } 
    a(arrayOfInt1, arrayOfInt2, i, paramStringBuilder);
    return paramInt;
  }
  
  static DecoderResult a(int[] paramArrayOfint, String paramString) throws FormatException {
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfint.length << 1);
    Charset charset = StandardCharsets.ISO_8859_1;
    int j = paramArrayOfint[1];
    PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
    int i = 2;
    while (i < paramArrayOfint[0]) {
      if (j != 913) {
        switch (j) {
          default:
            switch (j) {
              default:
                i = a(paramArrayOfint, i - 1, stringBuilder);
                break;
              case 928:
                i = a(paramArrayOfint, i, pDF417ResultMetadata);
                break;
              case 927:
                j = i + 1;
                charset = Charset.forName(CharacterSetECI.a(paramArrayOfint[i]).name());
                i = j;
                break;
              case 926:
                i += 2;
                break;
              case 925:
                i++;
                break;
              case 922:
              case 923:
                throw FormatException.a();
              case 924:
                break;
            } 
          case 902:
            i = b(paramArrayOfint, i, stringBuilder);
            break;
          case 901:
            i = a(j, paramArrayOfint, charset, i, stringBuilder);
            break;
          case 900:
            i = a(paramArrayOfint, i, stringBuilder);
            break;
        } 
      } else {
        j = i + 1;
        stringBuilder.append((char)paramArrayOfint[i]);
        i = j;
      } 
      if (i < paramArrayOfint.length) {
        int k = i + 1;
        j = paramArrayOfint[i];
        i = k;
        continue;
      } 
      throw FormatException.a();
    } 
    if (stringBuilder.length() != 0) {
      DecoderResult decoderResult = new DecoderResult(null, stringBuilder.toString(), null, paramString);
      decoderResult.a(pDF417ResultMetadata);
      return decoderResult;
    } 
    throw FormatException.a();
  }
  
  private static String a(int[] paramArrayOfint, int paramInt) throws FormatException {
    BigInteger bigInteger = BigInteger.ZERO;
    for (int i = 0; i < paramInt; i++)
      bigInteger = bigInteger.add(c[paramInt - i - 1].multiply(BigInteger.valueOf(paramArrayOfint[i]))); 
    String str = bigInteger.toString();
    if (str.charAt(0) == '1')
      return str.substring(1); 
    throw FormatException.a();
  }
  
  private static void a(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt, StringBuilder paramStringBuilder) {
    Mode mode1 = Mode.a;
    Mode mode2 = Mode.a;
    int i;
    for (i = 0; i < paramInt; i++) {
      char c;
      int j = paramArrayOfint1[i];
      switch (null.a[mode1.ordinal()]) {
        default:
          c = Character.MIN_VALUE;
        case 6:
          if (j < 29) {
            c = a[j];
          } else {
            if (j != 29) {
              if (j != 900) {
                if (j == 913)
                  paramStringBuilder.append((char)paramArrayOfint2[i]); 
              } else {
                mode1 = Mode.a;
              } 
            } else {
              mode1 = Mode.a;
            } 
            mode1 = mode2;
          } 
          mode1 = mode2;
          break;
        case 5:
        
        case 4:
          if (j < 29) {
            c = a[j];
            break;
          } 
          if (j != 29) {
            if (j != 900) {
              if (j == 913)
                paramStringBuilder.append((char)paramArrayOfint2[i]); 
            } else {
              mode1 = Mode.a;
            } 
          } else {
            mode1 = Mode.a;
          } 
        case 3:
          if (j < 25) {
            c = b[j];
            break;
          } 
          if (j != 900) {
            if (j != 913) {
              Mode mode = mode1;
              switch (j) {
                case 29:
                  mode2 = Mode.f;
                  c = Character.MIN_VALUE;
                  mode = mode1;
                  mode1 = mode2;
                  mode2 = mode;
                  break;
                case 28:
                  mode1 = Mode.a;
                  break;
                case 27:
                  mode1 = Mode.b;
                  break;
                case 25:
                  mode1 = Mode.d;
                  break;
                case 26:
                
              } 
            } else {
              paramStringBuilder.append((char)paramArrayOfint2[i]);
            } 
          } else {
            mode1 = Mode.a;
          } 
        case 2:
          if (j < 26) {
            j += 97;
          } else if (j != 900) {
            if (j != 913) {
              Mode mode = mode1;
              switch (j) {
                case 29:
                  mode2 = Mode.f;
                  c = Character.MIN_VALUE;
                  mode = mode1;
                  mode1 = mode2;
                  mode2 = mode;
                  break;
                case 28:
                  mode1 = Mode.c;
                  break;
                case 27:
                  mode2 = Mode.e;
                  c = Character.MIN_VALUE;
                  mode = mode1;
                  mode1 = mode2;
                  mode2 = mode;
                  break;
                case 26:
                
              } 
            } else {
              paramStringBuilder.append((char)paramArrayOfint2[i]);
            } 
          } else {
            mode1 = Mode.a;
          } 
          c = (char)j;
          break;
        case 1:
          if (j < 26) {
            j += 65;
          } else if (j != 900) {
            if (j != 913) {
              Mode mode = mode1;
              switch (j) {
                case 29:
                  mode2 = Mode.f;
                  c = Character.MIN_VALUE;
                  mode = mode1;
                  mode1 = mode2;
                  mode2 = mode;
                  break;
                case 28:
                  mode1 = Mode.c;
                  break;
                case 27:
                  mode1 = Mode.b;
                  break;
                case 26:
                  c = ' ';
                  mode1 = mode;
                  break;
              } 
            } else {
              paramStringBuilder.append((char)paramArrayOfint2[i]);
            } 
          } else {
            mode1 = Mode.a;
          } 
          c = (char)j;
          break;
      } 
      if (c != '\000')
        paramStringBuilder.append(c); 
      continue;
    } 
  }
  
  private static int b(int[] paramArrayOfint, int paramInt, StringBuilder paramStringBuilder) throws FormatException {
    // Byte code:
    //   0: bipush #15
    //   2: newarray int
    //   4: astore #7
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore #5
    //   11: iload_1
    //   12: istore #4
    //   14: iload #5
    //   16: istore_1
    //   17: iload #4
    //   19: aload_0
    //   20: iconst_0
    //   21: iaload
    //   22: if_icmpge -> 192
    //   25: iload_3
    //   26: ifne -> 192
    //   29: iload #4
    //   31: iconst_1
    //   32: iadd
    //   33: istore #5
    //   35: aload_0
    //   36: iload #4
    //   38: iaload
    //   39: istore #6
    //   41: iload #5
    //   43: aload_0
    //   44: iconst_0
    //   45: iaload
    //   46: if_icmpne -> 51
    //   49: iconst_1
    //   50: istore_3
    //   51: iload #6
    //   53: sipush #900
    //   56: if_icmpge -> 76
    //   59: aload #7
    //   61: iload_1
    //   62: iload #6
    //   64: iastore
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: iload #5
    //   71: istore #4
    //   73: goto -> 143
    //   76: iload #6
    //   78: sipush #900
    //   81: if_icmpeq -> 135
    //   84: iload #6
    //   86: sipush #901
    //   89: if_icmpeq -> 135
    //   92: iload #6
    //   94: sipush #928
    //   97: if_icmpeq -> 135
    //   100: iload #6
    //   102: tableswitch default -> 128, 922 -> 135, 923 -> 135, 924 -> 135
    //   128: iload #5
    //   130: istore #4
    //   132: goto -> 143
    //   135: iload #5
    //   137: iconst_1
    //   138: isub
    //   139: istore #4
    //   141: iconst_1
    //   142: istore_3
    //   143: iload_1
    //   144: bipush #15
    //   146: irem
    //   147: ifeq -> 165
    //   150: iload #6
    //   152: sipush #902
    //   155: if_icmpeq -> 165
    //   158: iload_1
    //   159: istore #5
    //   161: iload_3
    //   162: ifeq -> 186
    //   165: iload_1
    //   166: istore #5
    //   168: iload_1
    //   169: ifle -> 186
    //   172: aload_2
    //   173: aload #7
    //   175: iload_1
    //   176: invokestatic a : ([II)Ljava/lang/String;
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: iconst_0
    //   184: istore #5
    //   186: iload #5
    //   188: istore_1
    //   189: goto -> 17
    //   192: iload #4
    //   194: ireturn
  }
  
  enum Mode {
    a, b, c, d, e, f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */