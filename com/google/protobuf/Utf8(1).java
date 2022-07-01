package com.google.protobuf;

import java.nio.ByteBuffer;

final class Utf8 {
  private static final long ASCII_MASK_LONG = -9187201950435737472L;
  
  public static final int COMPLETE = 0;
  
  public static final int MALFORMED = -1;
  
  static final int MAX_BYTES_PER_CHAR = 3;
  
  private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
  
  private static final Processor processor;
  
  static {
    SafeProcessor safeProcessor;
    if (UnsafeProcessor.isAvailable() && !Android.isOnAndroidDevice()) {
      UnsafeProcessor unsafeProcessor = new UnsafeProcessor();
    } else {
      safeProcessor = new SafeProcessor();
    } 
    processor = safeProcessor;
  }
  
  static String decodeUtf8(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) throws InvalidProtocolBufferException {
    return processor.decodeUtf8(paramByteBuffer, paramInt1, paramInt2);
  }
  
  static String decodeUtf8(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws InvalidProtocolBufferException {
    return processor.decodeUtf8(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  static int encode(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return processor.encodeUtf8(paramCharSequence, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  static void encodeUtf8(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
    processor.encodeUtf8(paramCharSequence, paramByteBuffer);
  }
  
  static int encodedLength(CharSequence paramCharSequence) {
    int k;
    int m = paramCharSequence.length();
    int j;
    for (j = 0; j < m && paramCharSequence.charAt(j) < ''; j++);
    int i = m;
    while (true) {
      k = i;
      if (j < m) {
        k = paramCharSequence.charAt(j);
        if (k < 2048) {
          i += 127 - k >>> 31;
          j++;
          continue;
        } 
        k = i + encodedLengthGeneral(paramCharSequence, j);
      } 
      break;
    } 
    if (k >= m)
      return k; 
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(k + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt) {
    int j = paramCharSequence.length();
    int i = 0;
    while (paramInt < j) {
      int k;
      char c = paramCharSequence.charAt(paramInt);
      if (c < 'ࠀ') {
        i += 127 - c >>> 31;
        k = paramInt;
      } else {
        int m = i + 2;
        i = m;
        k = paramInt;
        if ('?' <= c) {
          i = m;
          k = paramInt;
          if (c <= '?')
            if (Character.codePointAt(paramCharSequence, paramInt) >= 65536) {
              k = paramInt + 1;
              i = m;
            } else {
              throw new UnpairedSurrogateException(paramInt, j);
            }  
        } 
      } 
      paramInt = k + 1;
    } 
    return i;
  }
  
  private static int estimateConsecutiveAscii(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
    int i;
    for (i = paramInt1; i < paramInt2 - 7 && (paramByteBuffer.getLong(i) & 0x8080808080808080L) == 0L; i += 8);
    return i - paramInt1;
  }
  
  private static int incompleteStateFor(int paramInt) {
    int i = paramInt;
    if (paramInt > -12)
      i = -1; 
    return i;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2) {
    return (paramInt1 > -12 || paramInt2 > -65) ? -1 : (paramInt1 ^ paramInt2 << 8);
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > -12 || paramInt2 > -65 || paramInt3 > -65) ? -1 : (paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16);
  }
  
  private static int incompleteStateFor(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt3 != 0) {
      if (paramInt3 != 1) {
        if (paramInt3 == 2)
          return incompleteStateFor(paramInt1, paramByteBuffer.get(paramInt2), paramByteBuffer.get(paramInt2 + 1)); 
        throw new AssertionError();
      } 
      return incompleteStateFor(paramInt1, paramByteBuffer.get(paramInt2));
    } 
    return incompleteStateFor(paramInt1);
  }
  
  private static int incompleteStateFor(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte b = paramArrayOfbyte[paramInt1 - 1];
    paramInt2 -= paramInt1;
    if (paramInt2 != 0) {
      if (paramInt2 != 1) {
        if (paramInt2 == 2)
          return incompleteStateFor(b, paramArrayOfbyte[paramInt1], paramArrayOfbyte[paramInt1 + 1]); 
        throw new AssertionError();
      } 
      return incompleteStateFor(b, paramArrayOfbyte[paramInt1]);
    } 
    return incompleteStateFor(b);
  }
  
  static boolean isValidUtf8(ByteBuffer paramByteBuffer) {
    return processor.isValidUtf8(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfbyte) {
    return processor.isValidUtf8(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return processor.isValidUtf8(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  static int partialIsValidUtf8(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3) {
    return processor.partialIsValidUtf8(paramInt1, paramByteBuffer, paramInt2, paramInt3);
  }
  
  public static int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    return processor.partialIsValidUtf8(paramInt1, paramArrayOfbyte, paramInt2, paramInt3);
  }
  
  static class DecodeUtil {
    private static void handleFourBytes(byte param1Byte1, byte param1Byte2, byte param1Byte3, byte param1Byte4, char[] param1ArrayOfchar, int param1Int) throws InvalidProtocolBufferException {
      if (!isNotTrailingByte(param1Byte2) && (param1Byte1 << 28) + param1Byte2 + 112 >> 30 == 0 && !isNotTrailingByte(param1Byte3) && !isNotTrailingByte(param1Byte4)) {
        int i = (param1Byte1 & 0x7) << 18 | trailingByteValue(param1Byte2) << 12 | trailingByteValue(param1Byte3) << 6 | trailingByteValue(param1Byte4);
        param1ArrayOfchar[param1Int] = highSurrogate(i);
        param1ArrayOfchar[param1Int + 1] = lowSurrogate(i);
        return;
      } 
      throw InvalidProtocolBufferException.invalidUtf8();
    }
    
    private static void handleOneByte(byte param1Byte, char[] param1ArrayOfchar, int param1Int) {
      param1ArrayOfchar[param1Int] = (char)param1Byte;
    }
    
    private static void handleThreeBytes(byte param1Byte1, byte param1Byte2, byte param1Byte3, char[] param1ArrayOfchar, int param1Int) throws InvalidProtocolBufferException {
      if (!isNotTrailingByte(param1Byte2) && (param1Byte1 != -32 || param1Byte2 >= -96) && (param1Byte1 != -19 || param1Byte2 < -96) && !isNotTrailingByte(param1Byte3)) {
        param1ArrayOfchar[param1Int] = (char)((param1Byte1 & 0xF) << 12 | trailingByteValue(param1Byte2) << 6 | trailingByteValue(param1Byte3));
        return;
      } 
      throw InvalidProtocolBufferException.invalidUtf8();
    }
    
    private static void handleTwoBytes(byte param1Byte1, byte param1Byte2, char[] param1ArrayOfchar, int param1Int) throws InvalidProtocolBufferException {
      if (param1Byte1 >= -62 && !isNotTrailingByte(param1Byte2)) {
        param1ArrayOfchar[param1Int] = (char)((param1Byte1 & 0x1F) << 6 | trailingByteValue(param1Byte2));
        return;
      } 
      throw InvalidProtocolBufferException.invalidUtf8();
    }
    
    private static char highSurrogate(int param1Int) {
      return (char)((param1Int >>> 10) + 55232);
    }
    
    private static boolean isNotTrailingByte(byte param1Byte) {
      return (param1Byte > -65);
    }
    
    private static boolean isOneByte(byte param1Byte) {
      return (param1Byte >= 0);
    }
    
    private static boolean isThreeBytes(byte param1Byte) {
      return (param1Byte < -16);
    }
    
    private static boolean isTwoBytes(byte param1Byte) {
      return (param1Byte < -32);
    }
    
    private static char lowSurrogate(int param1Int) {
      return (char)((param1Int & 0x3FF) + 56320);
    }
    
    private static int trailingByteValue(byte param1Byte) {
      return param1Byte & 0x3F;
    }
  }
  
  static abstract class Processor {
    private static int partialIsValidUtf8(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) {
      param1Int1 += Utf8.estimateConsecutiveAscii(param1ByteBuffer, param1Int1, param1Int2);
      while (true) {
        if (param1Int1 >= param1Int2)
          return 0; 
        int i = param1Int1 + 1;
        byte b = param1ByteBuffer.get(param1Int1);
        param1Int1 = i;
        if (b < 0) {
          if (b < -32) {
            if (i >= param1Int2)
              return b; 
            if (b >= -62) {
              if (param1ByteBuffer.get(i) > -65)
                return -1; 
              param1Int1 = i + 1;
              continue;
            } 
            return -1;
          } 
          if (b < -16) {
            if (i >= param1Int2 - 1)
              return Utf8.incompleteStateFor(param1ByteBuffer, b, i, param1Int2 - i); 
            param1Int1 = i + 1;
            i = param1ByteBuffer.get(i);
            if (i <= -65 && (b != -32 || i >= -96) && (b != -19 || i < -96)) {
              if (param1ByteBuffer.get(param1Int1) > -65)
                return -1; 
              param1Int1++;
              continue;
            } 
            return -1;
          } 
          if (i >= param1Int2 - 2)
            return Utf8.incompleteStateFor(param1ByteBuffer, b, i, param1Int2 - i); 
          param1Int1 = i + 1;
          i = param1ByteBuffer.get(i);
          if (i <= -65 && (b << 28) + i + 112 >> 30 == 0) {
            i = param1Int1 + 1;
            if (param1ByteBuffer.get(param1Int1) <= -65) {
              param1Int1 = i + 1;
              if (param1ByteBuffer.get(i) > -65)
                break; 
              continue;
            } 
          } 
          break;
        } 
      } 
      return -1;
    }
    
    final String decodeUtf8(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      if (param1ByteBuffer.hasArray()) {
        int i = param1ByteBuffer.arrayOffset();
        return decodeUtf8(param1ByteBuffer.array(), i + param1Int1, param1Int2);
      } 
      return param1ByteBuffer.isDirect() ? decodeUtf8Direct(param1ByteBuffer, param1Int1, param1Int2) : decodeUtf8Default(param1ByteBuffer, param1Int1, param1Int2);
    }
    
    abstract String decodeUtf8(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException;
    
    final String decodeUtf8Default(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      if ((param1Int1 | param1Int2 | param1ByteBuffer.limit() - param1Int1 - param1Int2) >= 0) {
        int j = param1Int1 + param1Int2;
        char[] arrayOfChar = new char[param1Int2];
        for (param1Int2 = 0; param1Int1 < j; param1Int2++) {
          byte b = param1ByteBuffer.get(param1Int1);
          if (!Utf8.DecodeUtil.isOneByte(b))
            break; 
          param1Int1++;
          Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int2);
        } 
        int i = param1Int2;
        param1Int2 = param1Int1;
        param1Int1 = i;
        while (param1Int2 < j) {
          i = param1Int2 + 1;
          byte b = param1ByteBuffer.get(param1Int2);
          if (Utf8.DecodeUtil.isOneByte(b)) {
            param1Int2 = param1Int1 + 1;
            Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
            param1Int1 = param1Int2;
            param1Int2 = i;
            while (param1Int2 < j) {
              b = param1ByteBuffer.get(param1Int2);
              if (!Utf8.DecodeUtil.isOneByte(b))
                break; 
              param1Int2++;
              Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
              param1Int1++;
            } 
            continue;
          } 
          if (Utf8.DecodeUtil.isTwoBytes(b)) {
            if (i < j) {
              Utf8.DecodeUtil.handleTwoBytes(b, param1ByteBuffer.get(i), arrayOfChar, param1Int1);
              param1Int2 = i + 1;
              param1Int1++;
              continue;
            } 
            throw InvalidProtocolBufferException.invalidUtf8();
          } 
          if (Utf8.DecodeUtil.isThreeBytes(b)) {
            if (i < j - 1) {
              param1Int2 = i + 1;
              Utf8.DecodeUtil.handleThreeBytes(b, param1ByteBuffer.get(i), param1ByteBuffer.get(param1Int2), arrayOfChar, param1Int1);
              param1Int2++;
              param1Int1++;
              continue;
            } 
            throw InvalidProtocolBufferException.invalidUtf8();
          } 
          if (i < j - 2) {
            param1Int2 = i + 1;
            byte b1 = param1ByteBuffer.get(i);
            i = param1Int2 + 1;
            Utf8.DecodeUtil.handleFourBytes(b, b1, param1ByteBuffer.get(param1Int2), param1ByteBuffer.get(i), arrayOfChar, param1Int1);
            param1Int2 = i + 1;
            param1Int1 = param1Int1 + 1 + 1;
            continue;
          } 
          throw InvalidProtocolBufferException.invalidUtf8();
        } 
        return new String(arrayOfChar, 0, param1Int1);
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(param1ByteBuffer.limit()), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) }));
    }
    
    abstract String decodeUtf8Direct(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) throws InvalidProtocolBufferException;
    
    abstract int encodeUtf8(CharSequence param1CharSequence, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2);
    
    final void encodeUtf8(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer) {
      if (param1ByteBuffer.hasArray()) {
        int i = param1ByteBuffer.arrayOffset();
        param1ByteBuffer.position(Utf8.encode(param1CharSequence, param1ByteBuffer.array(), param1ByteBuffer.position() + i, param1ByteBuffer.remaining()) - i);
        return;
      } 
      if (param1ByteBuffer.isDirect()) {
        encodeUtf8Direct(param1CharSequence, param1ByteBuffer);
        return;
      } 
      encodeUtf8Default(param1CharSequence, param1ByteBuffer);
    }
    
    final void encodeUtf8Default(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer) {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface length : ()I
      //   6: istore #11
      //   8: aload_2
      //   9: invokevirtual position : ()I
      //   12: istore #7
      //   14: iconst_0
      //   15: istore #6
      //   17: iload #6
      //   19: iload #11
      //   21: if_icmpge -> 80
      //   24: iload #7
      //   26: istore #9
      //   28: iload #6
      //   30: istore #8
      //   32: aload_1
      //   33: iload #6
      //   35: invokeinterface charAt : (I)C
      //   40: istore #10
      //   42: iload #10
      //   44: sipush #128
      //   47: if_icmpge -> 80
      //   50: iload #7
      //   52: istore #9
      //   54: iload #6
      //   56: istore #8
      //   58: aload_2
      //   59: iload #7
      //   61: iload #6
      //   63: iadd
      //   64: iload #10
      //   66: i2b
      //   67: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   70: pop
      //   71: iload #6
      //   73: iconst_1
      //   74: iadd
      //   75: istore #6
      //   77: goto -> 17
      //   80: iload #6
      //   82: iload #11
      //   84: if_icmpne -> 677
      //   87: iload #7
      //   89: istore #9
      //   91: iload #6
      //   93: istore #8
      //   95: aload_2
      //   96: iload #7
      //   98: iload #6
      //   100: iadd
      //   101: invokevirtual position : (I)Ljava/nio/Buffer;
      //   104: pop
      //   105: return
      //   106: iload #6
      //   108: iload #11
      //   110: if_icmpge -> 558
      //   113: iload #7
      //   115: istore #9
      //   117: iload #6
      //   119: istore #8
      //   121: aload_1
      //   122: iload #6
      //   124: invokeinterface charAt : (I)C
      //   129: istore #4
      //   131: iload #4
      //   133: sipush #128
      //   136: if_icmpge -> 160
      //   139: iload #7
      //   141: istore #9
      //   143: iload #6
      //   145: istore #8
      //   147: aload_2
      //   148: iload #7
      //   150: iload #4
      //   152: i2b
      //   153: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   156: pop
      //   157: goto -> 687
      //   160: iload #4
      //   162: sipush #2048
      //   165: if_icmpge -> 232
      //   168: iload #7
      //   170: iconst_1
      //   171: iadd
      //   172: istore #9
      //   174: iload #4
      //   176: bipush #6
      //   178: iushr
      //   179: sipush #192
      //   182: ior
      //   183: i2b
      //   184: istore_3
      //   185: iload #9
      //   187: istore #8
      //   189: aload_2
      //   190: iload #7
      //   192: iload_3
      //   193: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   196: pop
      //   197: iload #9
      //   199: istore #8
      //   201: aload_2
      //   202: iload #9
      //   204: iload #4
      //   206: bipush #63
      //   208: iand
      //   209: sipush #128
      //   212: ior
      //   213: i2b
      //   214: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   217: pop
      //   218: iload #9
      //   220: istore #7
      //   222: goto -> 687
      //   225: iload #8
      //   227: istore #9
      //   229: goto -> 574
      //   232: iload #4
      //   234: ldc 55296
      //   236: if_icmplt -> 465
      //   239: ldc 57343
      //   241: iload #4
      //   243: if_icmpge -> 249
      //   246: goto -> 465
      //   249: iload #6
      //   251: iconst_1
      //   252: iadd
      //   253: istore #8
      //   255: iload #8
      //   257: iload #11
      //   259: if_icmpeq -> 445
      //   262: iload #7
      //   264: istore #6
      //   266: aload_1
      //   267: iload #8
      //   269: invokeinterface charAt : (I)C
      //   274: istore #5
      //   276: iload #7
      //   278: istore #6
      //   280: iload #4
      //   282: iload #5
      //   284: invokestatic isSurrogatePair : (CC)Z
      //   287: ifeq -> 427
      //   290: iload #7
      //   292: istore #6
      //   294: iload #4
      //   296: iload #5
      //   298: invokestatic toCodePoint : (CC)I
      //   301: istore #12
      //   303: iload #7
      //   305: iconst_1
      //   306: iadd
      //   307: istore #9
      //   309: iload #12
      //   311: bipush #18
      //   313: iushr
      //   314: sipush #240
      //   317: ior
      //   318: i2b
      //   319: istore_3
      //   320: iload #9
      //   322: istore #6
      //   324: aload_2
      //   325: iload #7
      //   327: iload_3
      //   328: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   331: pop
      //   332: iload #9
      //   334: iconst_1
      //   335: iadd
      //   336: istore #10
      //   338: iload #12
      //   340: bipush #12
      //   342: iushr
      //   343: bipush #63
      //   345: iand
      //   346: sipush #128
      //   349: ior
      //   350: i2b
      //   351: istore_3
      //   352: iload #10
      //   354: istore #6
      //   356: aload_2
      //   357: iload #9
      //   359: iload_3
      //   360: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   363: pop
      //   364: iload #10
      //   366: iconst_1
      //   367: iadd
      //   368: istore #7
      //   370: iload #12
      //   372: bipush #6
      //   374: iushr
      //   375: bipush #63
      //   377: iand
      //   378: sipush #128
      //   381: ior
      //   382: i2b
      //   383: istore_3
      //   384: iload #7
      //   386: istore #6
      //   388: aload_2
      //   389: iload #10
      //   391: iload_3
      //   392: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   395: pop
      //   396: iload #7
      //   398: istore #6
      //   400: aload_2
      //   401: iload #7
      //   403: iload #12
      //   405: bipush #63
      //   407: iand
      //   408: sipush #128
      //   411: ior
      //   412: i2b
      //   413: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   416: pop
      //   417: iload #8
      //   419: istore #6
      //   421: goto -> 687
      //   424: goto -> 434
      //   427: iload #8
      //   429: istore #6
      //   431: goto -> 445
      //   434: iload #6
      //   436: istore #9
      //   438: iload #8
      //   440: istore #6
      //   442: goto -> 574
      //   445: iload #7
      //   447: istore #9
      //   449: iload #6
      //   451: istore #8
      //   453: new com/google/protobuf/Utf8$UnpairedSurrogateException
      //   456: dup
      //   457: iload #6
      //   459: iload #11
      //   461: invokespecial <init> : (II)V
      //   464: athrow
      //   465: iload #7
      //   467: iconst_1
      //   468: iadd
      //   469: istore #10
      //   471: iload #4
      //   473: bipush #12
      //   475: iushr
      //   476: sipush #224
      //   479: ior
      //   480: i2b
      //   481: istore_3
      //   482: iload #10
      //   484: istore #8
      //   486: aload_2
      //   487: iload #7
      //   489: iload_3
      //   490: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   493: pop
      //   494: iload #10
      //   496: iconst_1
      //   497: iadd
      //   498: istore #7
      //   500: iload #4
      //   502: bipush #6
      //   504: iushr
      //   505: bipush #63
      //   507: iand
      //   508: sipush #128
      //   511: ior
      //   512: i2b
      //   513: istore_3
      //   514: iload #7
      //   516: istore #9
      //   518: iload #6
      //   520: istore #8
      //   522: aload_2
      //   523: iload #10
      //   525: iload_3
      //   526: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   529: pop
      //   530: iload #7
      //   532: istore #9
      //   534: iload #6
      //   536: istore #8
      //   538: aload_2
      //   539: iload #7
      //   541: iload #4
      //   543: bipush #63
      //   545: iand
      //   546: sipush #128
      //   549: ior
      //   550: i2b
      //   551: invokevirtual put : (IB)Ljava/nio/ByteBuffer;
      //   554: pop
      //   555: goto -> 687
      //   558: iload #7
      //   560: istore #9
      //   562: iload #6
      //   564: istore #8
      //   566: aload_2
      //   567: iload #7
      //   569: invokevirtual position : (I)Ljava/nio/Buffer;
      //   572: pop
      //   573: return
      //   574: aload_2
      //   575: invokevirtual position : ()I
      //   578: istore #7
      //   580: iload #6
      //   582: iload #9
      //   584: aload_2
      //   585: invokevirtual position : ()I
      //   588: isub
      //   589: iconst_1
      //   590: iadd
      //   591: invokestatic max : (II)I
      //   594: istore #8
      //   596: new java/lang/StringBuilder
      //   599: dup
      //   600: invokespecial <init> : ()V
      //   603: astore_2
      //   604: aload_2
      //   605: ldc 'Failed writing '
      //   607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   610: pop
      //   611: aload_2
      //   612: aload_1
      //   613: iload #6
      //   615: invokeinterface charAt : (I)C
      //   620: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   623: pop
      //   624: aload_2
      //   625: ldc ' at index '
      //   627: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   630: pop
      //   631: aload_2
      //   632: iload #7
      //   634: iload #8
      //   636: iadd
      //   637: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   640: pop
      //   641: new java/lang/ArrayIndexOutOfBoundsException
      //   644: dup
      //   645: aload_2
      //   646: invokevirtual toString : ()Ljava/lang/String;
      //   649: invokespecial <init> : (Ljava/lang/String;)V
      //   652: athrow
      //   653: astore #13
      //   655: iload #8
      //   657: istore #6
      //   659: goto -> 574
      //   662: astore #13
      //   664: goto -> 225
      //   667: astore #13
      //   669: goto -> 434
      //   672: astore #13
      //   674: goto -> 424
      //   677: iload #7
      //   679: iload #6
      //   681: iadd
      //   682: istore #7
      //   684: goto -> 106
      //   687: iload #6
      //   689: iconst_1
      //   690: iadd
      //   691: istore #6
      //   693: iload #7
      //   695: iconst_1
      //   696: iadd
      //   697: istore #7
      //   699: goto -> 106
      // Exception table:
      //   from	to	target	type
      //   32	42	653	java/lang/IndexOutOfBoundsException
      //   58	71	653	java/lang/IndexOutOfBoundsException
      //   95	105	653	java/lang/IndexOutOfBoundsException
      //   121	131	653	java/lang/IndexOutOfBoundsException
      //   147	157	653	java/lang/IndexOutOfBoundsException
      //   189	197	662	java/lang/IndexOutOfBoundsException
      //   201	218	662	java/lang/IndexOutOfBoundsException
      //   266	276	667	java/lang/IndexOutOfBoundsException
      //   280	290	667	java/lang/IndexOutOfBoundsException
      //   294	303	667	java/lang/IndexOutOfBoundsException
      //   324	332	672	java/lang/IndexOutOfBoundsException
      //   356	364	667	java/lang/IndexOutOfBoundsException
      //   388	396	672	java/lang/IndexOutOfBoundsException
      //   400	417	672	java/lang/IndexOutOfBoundsException
      //   453	465	653	java/lang/IndexOutOfBoundsException
      //   486	494	662	java/lang/IndexOutOfBoundsException
      //   522	530	653	java/lang/IndexOutOfBoundsException
      //   538	555	653	java/lang/IndexOutOfBoundsException
      //   566	573	653	java/lang/IndexOutOfBoundsException
    }
    
    abstract void encodeUtf8Direct(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer);
    
    final boolean isValidUtf8(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) {
      boolean bool = false;
      if (partialIsValidUtf8(0, param1ByteBuffer, param1Int1, param1Int2) == 0)
        bool = true; 
      return bool;
    }
    
    final boolean isValidUtf8(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      boolean bool = false;
      if (partialIsValidUtf8(0, param1ArrayOfbyte, param1Int1, param1Int2) == 0)
        bool = true; 
      return bool;
    }
    
    final int partialIsValidUtf8(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3) {
      if (param1ByteBuffer.hasArray()) {
        int i = param1ByteBuffer.arrayOffset();
        return partialIsValidUtf8(param1Int1, param1ByteBuffer.array(), param1Int2 + i, i + param1Int3);
      } 
      return param1ByteBuffer.isDirect() ? partialIsValidUtf8Direct(param1Int1, param1ByteBuffer, param1Int2, param1Int3) : partialIsValidUtf8Default(param1Int1, param1ByteBuffer, param1Int2, param1Int3);
    }
    
    abstract int partialIsValidUtf8(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3);
    
    final int partialIsValidUtf8Default(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3) {
      int i = param1Int2;
      if (param1Int1 != 0) {
        if (param1Int2 >= param1Int3)
          return param1Int1; 
        byte b = (byte)param1Int1;
        if (b < -32) {
          if (b >= -62) {
            param1Int1 = param1Int2 + 1;
            if (param1ByteBuffer.get(param1Int2) > -65)
              return -1; 
          } else {
            return -1;
          } 
        } else if (b < -16) {
          byte b1 = (byte)(param1Int1 >> 8);
          param1Int1 = b1;
          i = param1Int2;
          if (b1 == 0) {
            i = param1Int2 + 1;
            param1Int1 = param1ByteBuffer.get(param1Int2);
            if (i >= param1Int3)
              return Utf8.incompleteStateFor(b, param1Int1); 
          } 
          if (param1Int1 <= -65 && (b != -32 || param1Int1 >= -96) && (b != -19 || param1Int1 < -96)) {
            param1Int1 = i + 1;
            if (param1ByteBuffer.get(i) > -65)
              return -1; 
          } else {
            return -1;
          } 
        } else {
          i = (byte)(param1Int1 >> 8);
          int j = 0;
          if (i == 0) {
            int m = param1Int2 + 1;
            byte b1 = param1ByteBuffer.get(param1Int2);
            i = b1;
            param1Int2 = j;
            param1Int1 = m;
            if (m >= param1Int3)
              return Utf8.incompleteStateFor(b, b1); 
          } else {
            j = (byte)(param1Int1 >> 16);
            param1Int1 = param1Int2;
            param1Int2 = j;
          } 
          int k = param1Int2;
          j = param1Int1;
          if (param1Int2 == 0) {
            j = param1Int1 + 1;
            k = param1ByteBuffer.get(param1Int1);
            if (j >= param1Int3)
              return Utf8.incompleteStateFor(b, i, k); 
          } 
          if (i <= -65 && (b << 28) + i + 112 >> 30 == 0 && k <= -65) {
            i = j + 1;
            if (param1ByteBuffer.get(j) > -65)
              return -1; 
          } else {
            return -1;
          } 
          param1Int1 = i;
        } 
        return partialIsValidUtf8(param1ByteBuffer, param1Int1, param1Int3);
      } 
      param1Int1 = i;
    }
    
    abstract int partialIsValidUtf8Direct(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3);
  }
  
  static final class SafeProcessor extends Processor {
    private static int partialIsValidUtf8(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2 && param1ArrayOfbyte[param1Int1] >= 0)
        param1Int1++; 
      return (param1Int1 >= param1Int2) ? 0 : partialIsValidUtf8NonAscii(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    private static int partialIsValidUtf8NonAscii(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      while (true) {
        if (param1Int1 >= param1Int2)
          return 0; 
        int i = param1Int1 + 1;
        byte b = param1ArrayOfbyte[param1Int1];
        param1Int1 = i;
        if (b < 0) {
          if (b < -32) {
            if (i >= param1Int2)
              return b; 
            if (b >= -62) {
              param1Int1 = i + 1;
              if (param1ArrayOfbyte[i] > -65)
                return -1; 
              continue;
            } 
            return -1;
          } 
          if (b < -16) {
            if (i >= param1Int2 - 1)
              return Utf8.incompleteStateFor(param1ArrayOfbyte, i, param1Int2); 
            int j = i + 1;
            param1Int1 = param1ArrayOfbyte[i];
            if (param1Int1 <= -65 && (b != -32 || param1Int1 >= -96) && (b != -19 || param1Int1 < -96)) {
              param1Int1 = j + 1;
              if (param1ArrayOfbyte[j] > -65)
                return -1; 
              continue;
            } 
            return -1;
          } 
          if (i >= param1Int2 - 2)
            return Utf8.incompleteStateFor(param1ArrayOfbyte, i, param1Int2); 
          param1Int1 = i + 1;
          i = param1ArrayOfbyte[i];
          if (i <= -65 && (b << 28) + i + 112 >> 30 == 0) {
            i = param1Int1 + 1;
            if (param1ArrayOfbyte[param1Int1] <= -65) {
              param1Int1 = i + 1;
              if (param1ArrayOfbyte[i] > -65)
                break; 
              continue;
            } 
          } 
          break;
        } 
      } 
      return -1;
    }
    
    String decodeUtf8(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      if ((param1Int1 | param1Int2 | param1ArrayOfbyte.length - param1Int1 - param1Int2) >= 0) {
        int j = param1Int1 + param1Int2;
        char[] arrayOfChar = new char[param1Int2];
        for (param1Int2 = 0; param1Int1 < j; param1Int2++) {
          byte b = param1ArrayOfbyte[param1Int1];
          if (!Utf8.DecodeUtil.isOneByte(b))
            break; 
          param1Int1++;
          Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int2);
        } 
        int i = param1Int2;
        param1Int2 = param1Int1;
        param1Int1 = i;
        while (param1Int2 < j) {
          i = param1Int2 + 1;
          byte b = param1ArrayOfbyte[param1Int2];
          if (Utf8.DecodeUtil.isOneByte(b)) {
            param1Int2 = param1Int1 + 1;
            Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
            param1Int1 = param1Int2;
            param1Int2 = i;
            while (param1Int2 < j) {
              b = param1ArrayOfbyte[param1Int2];
              if (!Utf8.DecodeUtil.isOneByte(b))
                break; 
              param1Int2++;
              Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
              param1Int1++;
            } 
            continue;
          } 
          if (Utf8.DecodeUtil.isTwoBytes(b)) {
            if (i < j) {
              Utf8.DecodeUtil.handleTwoBytes(b, param1ArrayOfbyte[i], arrayOfChar, param1Int1);
              param1Int2 = i + 1;
              param1Int1++;
              continue;
            } 
            throw InvalidProtocolBufferException.invalidUtf8();
          } 
          if (Utf8.DecodeUtil.isThreeBytes(b)) {
            if (i < j - 1) {
              param1Int2 = i + 1;
              Utf8.DecodeUtil.handleThreeBytes(b, param1ArrayOfbyte[i], param1ArrayOfbyte[param1Int2], arrayOfChar, param1Int1);
              param1Int2++;
              param1Int1++;
              continue;
            } 
            throw InvalidProtocolBufferException.invalidUtf8();
          } 
          if (i < j - 2) {
            param1Int2 = i + 1;
            byte b1 = param1ArrayOfbyte[i];
            i = param1Int2 + 1;
            Utf8.DecodeUtil.handleFourBytes(b, b1, param1ArrayOfbyte[param1Int2], param1ArrayOfbyte[i], arrayOfChar, param1Int1);
            param1Int2 = i + 1;
            param1Int1 = param1Int1 + 1 + 1;
            continue;
          } 
          throw InvalidProtocolBufferException.invalidUtf8();
        } 
        return new String(arrayOfChar, 0, param1Int1);
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(param1ArrayOfbyte.length), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) }));
    }
    
    String decodeUtf8Direct(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      return decodeUtf8Default(param1ByteBuffer, param1Int1, param1Int2);
    }
    
    int encodeUtf8(CharSequence param1CharSequence, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      int j = param1CharSequence.length();
      int k = param1Int2 + param1Int1;
      param1Int2 = 0;
      while (param1Int2 < j) {
        int m = param1Int2 + param1Int1;
        if (m < k) {
          char c = param1CharSequence.charAt(param1Int2);
          if (c < '') {
            param1ArrayOfbyte[m] = (byte)c;
            param1Int2++;
          } 
        } 
      } 
      if (param1Int2 == j)
        return param1Int1 + j; 
      int i = param1Int1 + param1Int2;
      param1Int1 = param1Int2;
      while (param1Int1 < j) {
        char c = param1CharSequence.charAt(param1Int1);
        if (c < '' && i < k) {
          param1Int2 = i + 1;
          param1ArrayOfbyte[i] = (byte)c;
        } else if (c < 'ࠀ' && i <= k - 2) {
          int m = i + 1;
          param1ArrayOfbyte[i] = (byte)(c >>> 6 | 0x3C0);
          param1Int2 = m + 1;
          param1ArrayOfbyte[m] = (byte)(c & 0x3F | 0x80);
        } else if ((c < '?' || '?' < c) && i <= k - 3) {
          param1Int2 = i + 1;
          param1ArrayOfbyte[i] = (byte)(c >>> 12 | 0x1E0);
          i = param1Int2 + 1;
          param1ArrayOfbyte[param1Int2] = (byte)(c >>> 6 & 0x3F | 0x80);
          param1Int2 = i + 1;
          param1ArrayOfbyte[i] = (byte)(c & 0x3F | 0x80);
        } else if (i <= k - 4) {
          param1Int2 = param1Int1 + 1;
          if (param1Int2 != param1CharSequence.length()) {
            char c1 = param1CharSequence.charAt(param1Int2);
            if (Character.isSurrogatePair(c, c1)) {
              param1Int1 = Character.toCodePoint(c, c1);
              int m = i + 1;
              param1ArrayOfbyte[i] = (byte)(param1Int1 >>> 18 | 0xF0);
              i = m + 1;
              param1ArrayOfbyte[m] = (byte)(param1Int1 >>> 12 & 0x3F | 0x80);
              m = i + 1;
              param1ArrayOfbyte[i] = (byte)(param1Int1 >>> 6 & 0x3F | 0x80);
              i = m + 1;
              param1ArrayOfbyte[m] = (byte)(param1Int1 & 0x3F | 0x80);
              param1Int1 = param1Int2;
              param1Int2 = i;
            } else {
              param1Int1 = param1Int2;
              throw new Utf8.UnpairedSurrogateException(param1Int1 - 1, j);
            } 
          } else {
            throw new Utf8.UnpairedSurrogateException(param1Int1 - 1, j);
          } 
        } else {
          if ('?' <= c && c <= '?') {
            param1Int2 = param1Int1 + 1;
            if (param1Int2 == param1CharSequence.length() || !Character.isSurrogatePair(c, param1CharSequence.charAt(param1Int2)))
              throw new Utf8.UnpairedSurrogateException(param1Int1, j); 
          } 
          param1CharSequence = new StringBuilder();
          param1CharSequence.append("Failed writing ");
          param1CharSequence.append(c);
          param1CharSequence.append(" at index ");
          param1CharSequence.append(i);
          throw new ArrayIndexOutOfBoundsException(param1CharSequence.toString());
        } 
        param1Int1++;
        i = param1Int2;
      } 
      return i;
    }
    
    void encodeUtf8Direct(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer) {
      encodeUtf8Default(param1CharSequence, param1ByteBuffer);
    }
    
    int partialIsValidUtf8(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3) {
      int i = param1Int2;
      if (param1Int1 != 0) {
        if (param1Int2 >= param1Int3)
          return param1Int1; 
        byte b = (byte)param1Int1;
        if (b < -32) {
          if (b >= -62) {
            param1Int1 = param1Int2 + 1;
            if (param1ArrayOfbyte[param1Int2] > -65)
              return -1; 
          } else {
            return -1;
          } 
        } else if (b < -16) {
          byte b1 = (byte)(param1Int1 >> 8);
          param1Int1 = b1;
          i = param1Int2;
          if (b1 == 0) {
            i = param1Int2 + 1;
            param1Int1 = param1ArrayOfbyte[param1Int2];
            if (i >= param1Int3)
              return Utf8.incompleteStateFor(b, param1Int1); 
          } 
          if (param1Int1 <= -65 && (b != -32 || param1Int1 >= -96) && (b != -19 || param1Int1 < -96)) {
            param1Int1 = i + 1;
            if (param1ArrayOfbyte[i] > -65)
              return -1; 
          } else {
            return -1;
          } 
        } else {
          i = (byte)(param1Int1 >> 8);
          int j = 0;
          if (i == 0) {
            int m = param1Int2 + 1;
            byte b1 = param1ArrayOfbyte[param1Int2];
            i = b1;
            param1Int2 = j;
            param1Int1 = m;
            if (m >= param1Int3)
              return Utf8.incompleteStateFor(b, b1); 
          } else {
            j = (byte)(param1Int1 >> 16);
            param1Int1 = param1Int2;
            param1Int2 = j;
          } 
          int k = param1Int2;
          j = param1Int1;
          if (param1Int2 == 0) {
            j = param1Int1 + 1;
            k = param1ArrayOfbyte[param1Int1];
            if (j >= param1Int3)
              return Utf8.incompleteStateFor(b, i, k); 
          } 
          if (i <= -65 && (b << 28) + i + 112 >> 30 == 0 && k <= -65) {
            i = j + 1;
            if (param1ArrayOfbyte[j] > -65)
              return -1; 
          } else {
            return -1;
          } 
          param1Int1 = i;
        } 
        return partialIsValidUtf8(param1ArrayOfbyte, param1Int1, param1Int3);
      } 
      param1Int1 = i;
    }
    
    int partialIsValidUtf8Direct(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3) {
      return partialIsValidUtf8Default(param1Int1, param1ByteBuffer, param1Int2, param1Int3);
    }
  }
  
  static class UnpairedSurrogateException extends IllegalArgumentException {
    UnpairedSurrogateException(int param1Int1, int param1Int2) {
      super(stringBuilder.toString());
    }
  }
  
  static final class UnsafeProcessor extends Processor {
    static boolean isAvailable() {
      return (UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations());
    }
    
    private static int partialIsValidUtf8(long param1Long, int param1Int) {
      int i = unsafeEstimateConsecutiveAscii(param1Long, param1Int);
      param1Long += i;
      param1Int -= i;
      while (true) {
        long l;
        byte b = 0;
        i = param1Int;
        param1Int = b;
        while (true) {
          l = param1Long;
          if (i > 0) {
            l = param1Long + 1L;
            param1Int = UnsafeUtil.getByte(param1Long);
            if (param1Int >= 0) {
              i--;
              param1Long = l;
              continue;
            } 
          } 
          break;
        } 
        if (i == 0)
          return 0; 
        i--;
        if (param1Int < -32) {
          if (i == 0)
            return param1Int; 
          i--;
          if (param1Int >= -62) {
            param1Long = 1L + l;
            param1Int = i;
            if (UnsafeUtil.getByte(l) > -65)
              return -1; 
            continue;
          } 
          return -1;
        } 
        if (param1Int < -16) {
          if (i < 2)
            return unsafeIncompleteStateFor(l, param1Int, i); 
          i -= 2;
          long l1 = l + 1L;
          b = UnsafeUtil.getByte(l);
          if (b <= -65 && (param1Int != -32 || b >= -96) && (param1Int != -19 || b < -96)) {
            param1Long = 1L + l1;
            param1Int = i;
            if (UnsafeUtil.getByte(l1) > -65)
              return -1; 
            continue;
          } 
          return -1;
        } 
        if (i < 3)
          return unsafeIncompleteStateFor(l, param1Int, i); 
        i -= 3;
        param1Long = l + 1L;
        b = UnsafeUtil.getByte(l);
        if (b <= -65 && (param1Int << 28) + b + 112 >> 30 == 0) {
          l = param1Long + 1L;
          if (UnsafeUtil.getByte(param1Long) <= -65) {
            param1Long = 1L + l;
            param1Int = i;
            if (UnsafeUtil.getByte(l) > -65)
              break; 
            continue;
          } 
        } 
        break;
      } 
      return -1;
    }
    
    private static int partialIsValidUtf8(byte[] param1ArrayOfbyte, long param1Long, int param1Int) {
      int i = unsafeEstimateConsecutiveAscii(param1ArrayOfbyte, param1Long, param1Int);
      param1Int -= i;
      param1Long += i;
      while (true) {
        long l;
        byte b = 0;
        i = param1Int;
        param1Int = b;
        while (true) {
          l = param1Long;
          if (i > 0) {
            l = param1Long + 1L;
            param1Int = UnsafeUtil.getByte(param1ArrayOfbyte, param1Long);
            if (param1Int >= 0) {
              i--;
              param1Long = l;
              continue;
            } 
          } 
          break;
        } 
        if (i == 0)
          return 0; 
        i--;
        if (param1Int < -32) {
          if (i == 0)
            return param1Int; 
          i--;
          if (param1Int >= -62) {
            param1Long = 1L + l;
            param1Int = i;
            if (UnsafeUtil.getByte(param1ArrayOfbyte, l) > -65)
              return -1; 
            continue;
          } 
          return -1;
        } 
        if (param1Int < -16) {
          if (i < 2)
            return unsafeIncompleteStateFor(param1ArrayOfbyte, param1Int, l, i); 
          i -= 2;
          long l1 = l + 1L;
          b = UnsafeUtil.getByte(param1ArrayOfbyte, l);
          if (b <= -65 && (param1Int != -32 || b >= -96) && (param1Int != -19 || b < -96)) {
            param1Long = 1L + l1;
            param1Int = i;
            if (UnsafeUtil.getByte(param1ArrayOfbyte, l1) > -65)
              return -1; 
            continue;
          } 
          return -1;
        } 
        if (i < 3)
          return unsafeIncompleteStateFor(param1ArrayOfbyte, param1Int, l, i); 
        i -= 3;
        param1Long = l + 1L;
        b = UnsafeUtil.getByte(param1ArrayOfbyte, l);
        if (b <= -65 && (param1Int << 28) + b + 112 >> 30 == 0) {
          l = param1Long + 1L;
          if (UnsafeUtil.getByte(param1ArrayOfbyte, param1Long) <= -65) {
            param1Long = 1L + l;
            param1Int = i;
            if (UnsafeUtil.getByte(param1ArrayOfbyte, l) > -65)
              break; 
            continue;
          } 
        } 
        break;
      } 
      return -1;
    }
    
    private static int unsafeEstimateConsecutiveAscii(long param1Long, int param1Int) {
      if (param1Int < 16)
        return 0; 
      int j = 8 - ((int)param1Long & 0x7);
      int i = j;
      while (i > 0) {
        if (UnsafeUtil.getByte(param1Long) < 0)
          return j - i; 
        i--;
        param1Long = 1L + param1Long;
      } 
      for (i = param1Int - j; i >= 8 && (UnsafeUtil.getLong(param1Long) & 0x8080808080808080L) == 0L; i -= 8)
        param1Long += 8L; 
      return param1Int - i;
    }
    
    private static int unsafeEstimateConsecutiveAscii(byte[] param1ArrayOfbyte, long param1Long, int param1Int) {
      int i = 0;
      if (param1Int < 16)
        return 0; 
      while (i < param1Int) {
        if (UnsafeUtil.getByte(param1ArrayOfbyte, param1Long) < 0)
          return i; 
        i++;
        param1Long = 1L + param1Long;
      } 
      return param1Int;
    }
    
    private static int unsafeIncompleteStateFor(long param1Long, int param1Int1, int param1Int2) {
      if (param1Int2 != 0) {
        if (param1Int2 != 1) {
          if (param1Int2 == 2)
            return Utf8.incompleteStateFor(param1Int1, UnsafeUtil.getByte(param1Long), UnsafeUtil.getByte(param1Long + 1L)); 
          throw new AssertionError();
        } 
        return Utf8.incompleteStateFor(param1Int1, UnsafeUtil.getByte(param1Long));
      } 
      return Utf8.incompleteStateFor(param1Int1);
    }
    
    private static int unsafeIncompleteStateFor(byte[] param1ArrayOfbyte, int param1Int1, long param1Long, int param1Int2) {
      if (param1Int2 != 0) {
        if (param1Int2 != 1) {
          if (param1Int2 == 2)
            return Utf8.incompleteStateFor(param1Int1, UnsafeUtil.getByte(param1ArrayOfbyte, param1Long), UnsafeUtil.getByte(param1ArrayOfbyte, param1Long + 1L)); 
          throw new AssertionError();
        } 
        return Utf8.incompleteStateFor(param1Int1, UnsafeUtil.getByte(param1ArrayOfbyte, param1Long));
      } 
      return Utf8.incompleteStateFor(param1Int1);
    }
    
    String decodeUtf8(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      if ((param1Int1 | param1Int2 | param1ArrayOfbyte.length - param1Int1 - param1Int2) >= 0) {
        int j = param1Int1 + param1Int2;
        char[] arrayOfChar = new char[param1Int2];
        for (param1Int2 = 0; param1Int1 < j; param1Int2++) {
          byte b = UnsafeUtil.getByte(param1ArrayOfbyte, param1Int1);
          if (!Utf8.DecodeUtil.isOneByte(b))
            break; 
          param1Int1++;
          Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int2);
        } 
        int i = param1Int2;
        param1Int2 = param1Int1;
        param1Int1 = i;
        while (param1Int2 < j) {
          i = param1Int2 + 1;
          byte b = UnsafeUtil.getByte(param1ArrayOfbyte, param1Int2);
          if (Utf8.DecodeUtil.isOneByte(b)) {
            param1Int2 = param1Int1 + 1;
            Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
            param1Int1 = param1Int2;
            param1Int2 = i;
            while (param1Int2 < j) {
              b = UnsafeUtil.getByte(param1ArrayOfbyte, param1Int2);
              if (!Utf8.DecodeUtil.isOneByte(b))
                break; 
              param1Int2++;
              Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
              param1Int1++;
            } 
            continue;
          } 
          if (Utf8.DecodeUtil.isTwoBytes(b)) {
            if (i < j) {
              Utf8.DecodeUtil.handleTwoBytes(b, UnsafeUtil.getByte(param1ArrayOfbyte, i), arrayOfChar, param1Int1);
              param1Int2 = i + 1;
              param1Int1++;
              continue;
            } 
            throw InvalidProtocolBufferException.invalidUtf8();
          } 
          if (Utf8.DecodeUtil.isThreeBytes(b)) {
            if (i < j - 1) {
              param1Int2 = i + 1;
              Utf8.DecodeUtil.handleThreeBytes(b, UnsafeUtil.getByte(param1ArrayOfbyte, i), UnsafeUtil.getByte(param1ArrayOfbyte, param1Int2), arrayOfChar, param1Int1);
              param1Int2++;
              param1Int1++;
              continue;
            } 
            throw InvalidProtocolBufferException.invalidUtf8();
          } 
          if (i < j - 2) {
            param1Int2 = i + 1;
            byte b1 = UnsafeUtil.getByte(param1ArrayOfbyte, i);
            i = param1Int2 + 1;
            Utf8.DecodeUtil.handleFourBytes(b, b1, UnsafeUtil.getByte(param1ArrayOfbyte, param1Int2), UnsafeUtil.getByte(param1ArrayOfbyte, i), arrayOfChar, param1Int1);
            param1Int2 = i + 1;
            param1Int1 = param1Int1 + 1 + 1;
            continue;
          } 
          throw InvalidProtocolBufferException.invalidUtf8();
        } 
        return new String(arrayOfChar, 0, param1Int1);
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[] { Integer.valueOf(param1ArrayOfbyte.length), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) }));
    }
    
    String decodeUtf8Direct(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      char[] arrayOfChar;
      if ((param1Int1 | param1Int2 | param1ByteBuffer.limit() - param1Int1 - param1Int2) >= 0) {
        long l2;
        long l1 = UnsafeUtil.addressOffset(param1ByteBuffer) + param1Int1;
        long l3 = param1Int2 + l1;
        arrayOfChar = new char[param1Int2];
        param1Int1 = 0;
        while (true) {
          param1Int2 = param1Int1;
          l2 = l1;
          if (l1 < l3) {
            byte b = UnsafeUtil.getByte(l1);
            if (!Utf8.DecodeUtil.isOneByte(b)) {
              param1Int2 = param1Int1;
              l2 = l1;
              break;
            } 
            l1++;
            Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
            param1Int1++;
            continue;
          } 
          break;
        } 
        while (true) {
          param1Int1 = param1Int2;
          l1 = l2;
          while (l1 < l3) {
            l2 = l1 + 1L;
            byte b = UnsafeUtil.getByte(l1);
            if (Utf8.DecodeUtil.isOneByte(b)) {
              param1Int2 = param1Int1 + 1;
              Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
              param1Int1 = param1Int2;
              l1 = l2;
              while (l1 < l3) {
                b = UnsafeUtil.getByte(l1);
                if (!Utf8.DecodeUtil.isOneByte(b))
                  break; 
                l1++;
                Utf8.DecodeUtil.handleOneByte(b, arrayOfChar, param1Int1);
                param1Int1++;
              } 
              continue;
            } 
            if (Utf8.DecodeUtil.isTwoBytes(b)) {
              if (l2 < l3) {
                l1 = l2 + 1L;
                Utf8.DecodeUtil.handleTwoBytes(b, UnsafeUtil.getByte(l2), arrayOfChar, param1Int1);
                param1Int1++;
                continue;
              } 
              throw InvalidProtocolBufferException.invalidUtf8();
            } 
            if (Utf8.DecodeUtil.isThreeBytes(b)) {
              if (l2 < l3 - 1L) {
                l1 = l2 + 1L;
                Utf8.DecodeUtil.handleThreeBytes(b, UnsafeUtil.getByte(l2), UnsafeUtil.getByte(l1), arrayOfChar, param1Int1);
                param1Int1++;
                l1++;
                continue;
              } 
              throw InvalidProtocolBufferException.invalidUtf8();
            } 
            if (l2 < l3 - 2L) {
              l1 = l2 + 1L;
              byte b1 = UnsafeUtil.getByte(l2);
              long l = l1 + 1L;
              byte b2 = UnsafeUtil.getByte(l1);
              l2 = l + 1L;
              Utf8.DecodeUtil.handleFourBytes(b, b1, b2, UnsafeUtil.getByte(l), arrayOfChar, param1Int1);
              param1Int2 = param1Int1 + 1 + 1;
              continue;
            } 
            throw InvalidProtocolBufferException.invalidUtf8();
          } 
          return new String(arrayOfChar, 0, param1Int1);
        } 
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(arrayOfChar.limit()), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) }));
    }
    
    int encodeUtf8(CharSequence param1CharSequence, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      long l1 = param1Int1;
      long l2 = param1Int2 + l1;
      int i = param1CharSequence.length();
      if (i <= param1Int2 && param1ArrayOfbyte.length - param1Int2 >= param1Int1) {
        long l3;
        param1Int2 = 0;
        while (true) {
          l3 = 1L;
          if (param1Int2 < i) {
            param1Int1 = param1CharSequence.charAt(param1Int2);
            if (param1Int1 < 128) {
              UnsafeUtil.putByte(param1ArrayOfbyte, l1, (byte)param1Int1);
              param1Int2++;
              l1 = 1L + l1;
              continue;
            } 
          } 
          break;
        } 
        param1Int1 = param1Int2;
        long l4 = l1;
        if (param1Int2 == i)
          return (int)l1; 
        while (param1Int1 < i) {
          char c = param1CharSequence.charAt(param1Int1);
          if (c < '' && l4 < l2) {
            UnsafeUtil.putByte(param1ArrayOfbyte, l4, (byte)c);
            long l = l3;
            l1 = l4 + l3;
            l3 = l;
          } else if (c < 'ࠀ' && l4 <= l2 - 2L) {
            l1 = l4 + l3;
            UnsafeUtil.putByte(param1ArrayOfbyte, l4, (byte)(c >>> 6 | 0x3C0));
            UnsafeUtil.putByte(param1ArrayOfbyte, l1, (byte)(c & 0x3F | 0x80));
            l1 += l3;
          } else if ((c < '?' || '?' < c) && l4 <= l2 - 3L) {
            l1 = l4 + l3;
            UnsafeUtil.putByte(param1ArrayOfbyte, l4, (byte)(c >>> 12 | 0x1E0));
            l3 = l1 + l3;
            UnsafeUtil.putByte(param1ArrayOfbyte, l1, (byte)(c >>> 6 & 0x3F | 0x80));
            UnsafeUtil.putByte(param1ArrayOfbyte, l3, (byte)(c & 0x3F | 0x80));
            l1 = l3 + 1L;
            l3 = 1L;
          } else if (l4 <= l2 - 4L) {
            param1Int2 = param1Int1 + 1;
            if (param1Int2 != i) {
              char c1 = param1CharSequence.charAt(param1Int2);
              if (Character.isSurrogatePair(c, c1)) {
                param1Int1 = Character.toCodePoint(c, c1);
                l3 = l4 + 1L;
                UnsafeUtil.putByte(param1ArrayOfbyte, l4, (byte)(param1Int1 >>> 18 | 0xF0));
                l1 = l3 + 1L;
                UnsafeUtil.putByte(param1ArrayOfbyte, l3, (byte)(param1Int1 >>> 12 & 0x3F | 0x80));
                l4 = l1 + 1L;
                UnsafeUtil.putByte(param1ArrayOfbyte, l1, (byte)(param1Int1 >>> 6 & 0x3F | 0x80));
                l3 = 1L;
                l1 = l4 + 1L;
                UnsafeUtil.putByte(param1ArrayOfbyte, l4, (byte)(param1Int1 & 0x3F | 0x80));
                param1Int1 = param1Int2;
              } else {
                param1Int1 = param1Int2;
                throw new Utf8.UnpairedSurrogateException(param1Int1 - 1, i);
              } 
            } else {
              throw new Utf8.UnpairedSurrogateException(param1Int1 - 1, i);
            } 
          } else {
            if ('?' <= c && c <= '?') {
              param1Int2 = param1Int1 + 1;
              if (param1Int2 == i || !Character.isSurrogatePair(c, param1CharSequence.charAt(param1Int2)))
                throw new Utf8.UnpairedSurrogateException(param1Int1, i); 
            } 
            param1CharSequence = new StringBuilder();
            param1CharSequence.append("Failed writing ");
            param1CharSequence.append(c);
            param1CharSequence.append(" at index ");
            param1CharSequence.append(l4);
            throw new ArrayIndexOutOfBoundsException(param1CharSequence.toString());
          } 
          param1Int1++;
          l4 = l1;
        } 
        return (int)l4;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed writing ");
      stringBuilder.append(param1CharSequence.charAt(i - 1));
      stringBuilder.append(" at index ");
      stringBuilder.append(param1Int1 + param1Int2);
      throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }
    
    void encodeUtf8Direct(CharSequence param1CharSequence, ByteBuffer param1ByteBuffer) {
      long l2 = UnsafeUtil.addressOffset(param1ByteBuffer);
      long l1 = param1ByteBuffer.position() + l2;
      long l3 = param1ByteBuffer.limit() + l2;
      int i = param1CharSequence.length();
      if (i <= l3 - l1) {
        int k = 0;
        while (k < i) {
          char c = param1CharSequence.charAt(k);
          if (c < '') {
            UnsafeUtil.putByte(l1, (byte)c);
            k++;
            l1++;
          } 
        } 
        long l4 = l2;
        long l5 = l1;
        int j = k;
        if (k == i) {
          param1ByteBuffer.position((int)(l1 - l2));
          return;
        } 
        while (j < i) {
          char c = param1CharSequence.charAt(j);
          if (c < '' && l5 < l3) {
            UnsafeUtil.putByte(l5, (byte)c);
            l1 = l5 + 1L;
          } else if (c < 'ࠀ' && l5 <= l3 - 2L) {
            l1 = l5 + 1L;
            UnsafeUtil.putByte(l5, (byte)(c >>> 6 | 0x3C0));
            UnsafeUtil.putByte(l1, (byte)(c & 0x3F | 0x80));
            l1++;
          } else if ((c < '?' || '?' < c) && l5 <= l3 - 3L) {
            l1 = l5 + 1L;
            UnsafeUtil.putByte(l5, (byte)(c >>> 12 | 0x1E0));
            l5 = l1 + 1L;
            UnsafeUtil.putByte(l1, (byte)(c >>> 6 & 0x3F | 0x80));
            UnsafeUtil.putByte(l5, (byte)(c & 0x3F | 0x80));
            l1 = l5 + 1L;
          } else if (l5 <= l3 - 4L) {
            k = j + 1;
            if (k != i) {
              char c1 = param1CharSequence.charAt(k);
              j = k;
              if (Character.isSurrogatePair(c, c1)) {
                j = Character.toCodePoint(c, c1);
                l1 = l5 + 1L;
                UnsafeUtil.putByte(l5, (byte)(j >>> 18 | 0xF0));
                l5 = l1 + 1L;
                UnsafeUtil.putByte(l1, (byte)(j >>> 12 & 0x3F | 0x80));
                l1 = l5 + 1L;
                UnsafeUtil.putByte(l5, (byte)(j >>> 6 & 0x3F | 0x80));
                UnsafeUtil.putByte(l1, (byte)(j & 0x3F | 0x80));
                l1++;
                j = k;
              } else {
                throw new Utf8.UnpairedSurrogateException(j - 1, i);
              } 
            } else {
              throw new Utf8.UnpairedSurrogateException(j - 1, i);
            } 
          } else {
            if ('?' <= c && c <= '?') {
              k = j + 1;
              if (k == i || !Character.isSurrogatePair(c, param1CharSequence.charAt(k)))
                throw new Utf8.UnpairedSurrogateException(j, i); 
            } 
            param1CharSequence = new StringBuilder();
            param1CharSequence.append("Failed writing ");
            param1CharSequence.append(c);
            param1CharSequence.append(" at index ");
            param1CharSequence.append(l5);
            throw new ArrayIndexOutOfBoundsException(param1CharSequence.toString());
          } 
          j++;
          l5 = l1;
        } 
        param1ByteBuffer.position((int)(l5 - l4));
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed writing ");
      stringBuilder.append(param1CharSequence.charAt(i - 1));
      stringBuilder.append(" at index ");
      stringBuilder.append(param1ByteBuffer.limit());
      throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }
    
    int partialIsValidUtf8(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3) {
      int i = param1ArrayOfbyte.length;
      boolean bool = false;
      if ((param1Int2 | param1Int3 | i - param1Int3) >= 0) {
        long l1;
        long l2 = param1Int2;
        long l3 = param1Int3;
        if (param1Int1 != 0) {
          if (l2 >= l3)
            return param1Int1; 
          i = (byte)param1Int1;
          if (i < -32) {
            if (i >= -62) {
              l1 = l2 + 1L;
              if (UnsafeUtil.getByte(param1ArrayOfbyte, l2) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } else if (i < -16) {
            param1Int2 = (byte)(param1Int1 >> 8);
            long l = l2;
            param1Int1 = param1Int2;
            if (param1Int2 == 0) {
              l = l2 + 1L;
              param1Int1 = UnsafeUtil.getByte(param1ArrayOfbyte, l2);
              if (l >= l3)
                return Utf8.incompleteStateFor(i, param1Int1); 
            } 
            if (param1Int1 <= -65 && (i != -32 || param1Int1 >= -96) && (i != -19 || param1Int1 < -96)) {
              l1 = l + 1L;
              if (UnsafeUtil.getByte(param1ArrayOfbyte, l) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } else {
            param1Int2 = (byte)(param1Int1 >> 8);
            if (param1Int2 == 0) {
              l1 = l2 + 1L;
              param1Int2 = UnsafeUtil.getByte(param1ArrayOfbyte, l2);
              if (l1 >= l3)
                return Utf8.incompleteStateFor(i, param1Int2); 
              l2 = l1;
              param1Int1 = bool;
            } else {
              param1Int1 = (byte)(param1Int1 >> 16);
            } 
            param1Int3 = param1Int1;
            long l = l2;
            if (param1Int1 == 0) {
              l = l2 + 1L;
              param1Int3 = UnsafeUtil.getByte(param1ArrayOfbyte, l2);
              if (l >= l3)
                return Utf8.incompleteStateFor(i, param1Int2, param1Int3); 
            } 
            if (param1Int2 <= -65 && (i << 28) + param1Int2 + 112 >> 30 == 0 && param1Int3 <= -65) {
              l1 = l + 1L;
              if (UnsafeUtil.getByte(param1ArrayOfbyte, l) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } 
        } else {
          l1 = l2;
        } 
        return partialIsValidUtf8(param1ArrayOfbyte, l1, (int)(l3 - l1));
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(param1ArrayOfbyte.length), Integer.valueOf(param1Int2), Integer.valueOf(param1Int3) }));
    }
    
    int partialIsValidUtf8Direct(int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2, int param1Int3) {
      int i = param1ByteBuffer.limit();
      boolean bool = false;
      if ((param1Int2 | param1Int3 | i - param1Int3) >= 0) {
        long l1;
        long l2 = UnsafeUtil.addressOffset(param1ByteBuffer) + param1Int2;
        long l3 = (param1Int3 - param1Int2) + l2;
        if (param1Int1 != 0) {
          if (l2 >= l3)
            return param1Int1; 
          i = (byte)param1Int1;
          if (i < -32) {
            if (i >= -62) {
              l1 = l2 + 1L;
              if (UnsafeUtil.getByte(l2) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } else if (i < -16) {
            param1Int2 = (byte)(param1Int1 >> 8);
            long l = l2;
            param1Int1 = param1Int2;
            if (param1Int2 == 0) {
              l = l2 + 1L;
              param1Int1 = UnsafeUtil.getByte(l2);
              if (l >= l3)
                return Utf8.incompleteStateFor(i, param1Int1); 
            } 
            if (param1Int1 <= -65 && (i != -32 || param1Int1 >= -96) && (i != -19 || param1Int1 < -96)) {
              l1 = l + 1L;
              if (UnsafeUtil.getByte(l) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } else {
            param1Int2 = (byte)(param1Int1 >> 8);
            if (param1Int2 == 0) {
              l1 = l2 + 1L;
              param1Int2 = UnsafeUtil.getByte(l2);
              if (l1 >= l3)
                return Utf8.incompleteStateFor(i, param1Int2); 
              l2 = l1;
              param1Int1 = bool;
            } else {
              param1Int1 = (byte)(param1Int1 >> 16);
            } 
            param1Int3 = param1Int1;
            long l = l2;
            if (param1Int1 == 0) {
              l = l2 + 1L;
              param1Int3 = UnsafeUtil.getByte(l2);
              if (l >= l3)
                return Utf8.incompleteStateFor(i, param1Int2, param1Int3); 
            } 
            if (param1Int2 <= -65 && (i << 28) + param1Int2 + 112 >> 30 == 0 && param1Int3 <= -65) {
              l1 = l + 1L;
              if (UnsafeUtil.getByte(l) > -65)
                return -1; 
            } else {
              return -1;
            } 
          } 
        } else {
          l1 = l2;
        } 
        return partialIsValidUtf8(l1, (int)(l3 - l1));
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(param1ByteBuffer.limit()), Integer.valueOf(param1Int2), Integer.valueOf(param1Int3) }));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */