package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

final class DecodedBitStreamParser {
  private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
  
  private static char a(int paramInt) throws FormatException {
    char[] arrayOfChar = a;
    if (paramInt < arrayOfChar.length)
      return arrayOfChar[paramInt]; 
    throw FormatException.a();
  }
  
  private static int a(BitSource paramBitSource) throws FormatException {
    int i = paramBitSource.a(8);
    if ((i & 0x80) == 0)
      return i & 0x7F; 
    if ((i & 0xC0) == 128)
      return paramBitSource.a(8) | (i & 0x3F) << 8; 
    if ((i & 0xE0) == 192)
      return paramBitSource.a(16) | (i & 0x1F) << 16; 
    throw FormatException.a();
  }
  
  static DecoderResult a(byte[] paramArrayOfbyte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<DecodeHintType, ?> paramMap) throws FormatException {
    BitSource bitSource = new BitSource(paramArrayOfbyte);
    StringBuilder stringBuilder = new StringBuilder(50);
    ArrayList<byte[]> arrayList = new ArrayList(1);
    CharacterSetECI characterSetECI = null;
    boolean bool = false;
    int j = -1;
    int i = -1;
    while (true) {
      try {
        int n;
        int i1;
        Mode mode1;
        Mode mode2;
        Mode mode3;
        if (bitSource.c() < 4) {
          mode3 = Mode.a;
        } else {
          mode3 = Mode.a(bitSource.a(4));
        } 
        CharacterSetECI characterSetECI1 = characterSetECI;
        int k = j;
        int m = i;
        switch (null.a[mode3.ordinal()]) {
          case 10:
            n = bitSource.a(4);
            i1 = bitSource.a(mode3.a(paramVersion));
            characterSetECI1 = characterSetECI;
            k = j;
            m = i;
            if (n == 1) {
              a(bitSource, stringBuilder, i1);
              characterSetECI1 = characterSetECI;
              k = j;
              m = i;
            } 
          case 9:
            characterSetECI1 = CharacterSetECI.a(a(bitSource));
            if (characterSetECI1 != null) {
              k = j;
              m = i;
            } else {
              throw FormatException.a();
            } 
          case 8:
            if (bitSource.c() >= 16) {
              k = bitSource.a(8);
              m = bitSource.a(8);
              characterSetECI1 = characterSetECI;
            } else {
              throw FormatException.a();
            } 
          default:
            k = mode3.a(paramVersion);
            k = bitSource.a(k);
            m = null.a[mode3.ordinal()];
            if (m != 1) {
              if (m != 2) {
                if (m != 3) {
                  if (m == 4) {
                    b(bitSource, stringBuilder, k);
                    characterSetECI1 = characterSetECI;
                    k = j;
                    m = i;
                  } else {
                    throw FormatException.a();
                  } 
                } else {
                  a(bitSource, stringBuilder, k, characterSetECI, (Collection<byte[]>)arrayList, paramMap);
                  mode2 = Mode.a;
                } 
              } else {
                a(bitSource, stringBuilder, k, bool);
                mode2 = Mode.a;
              } 
            } else {
              c(bitSource, stringBuilder, k);
              mode2 = Mode.a;
            } 
          case 5:
            mode1 = mode2;
            j = k;
            i = m;
            mode2 = Mode.a;
          case 6:
          case 7:
            break;
        } 
      } catch (IllegalArgumentException illegalArgumentException) {
        throw FormatException.a();
      } 
      bool = true;
      Mode mode = Mode.a;
    } 
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt) throws FormatException {
    if (paramInt * 13 <= paramBitSource.c()) {
      byte[] arrayOfByte = new byte[paramInt * 2];
      int i = 0;
      while (paramInt > 0) {
        int j = paramBitSource.a(13);
        int k = j % 96 | j / 96 << 8;
        if (k < 959) {
          j = 41377;
        } else {
          j = 42657;
        } 
        j = k + j;
        arrayOfByte[i] = (byte)(j >> 8);
        arrayOfByte[i + 1] = (byte)j;
        i += 2;
        paramInt--;
      } 
      try {
        paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw FormatException.a();
      } 
    } 
    throw FormatException.a();
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, CharacterSetECI paramCharacterSetECI, Collection<byte[]> paramCollection, Map<DecodeHintType, ?> paramMap) throws FormatException {
    if (paramInt << 3 <= paramBitSource.c()) {
      String str;
      byte[] arrayOfByte = new byte[paramInt];
      int i;
      for (i = 0; i < paramInt; i++)
        arrayOfByte[i] = (byte)paramBitSource.a(8); 
      if (paramCharacterSetECI == null) {
        str = StringUtils.a(arrayOfByte, paramMap);
      } else {
        str = paramCharacterSetECI.name();
      } 
      try {
        paramStringBuilder.append(new String(arrayOfByte, str));
        paramCollection.add(arrayOfByte);
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw FormatException.a();
      } 
    } 
    throw FormatException.a();
  }
  
  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean) throws FormatException {
    int i = paramStringBuilder.length();
    while (paramInt > 1) {
      if (paramBitSource.c() >= 11) {
        int j = paramBitSource.a(11);
        paramStringBuilder.append(a(j / 45));
        paramStringBuilder.append(a(j % 45));
        paramInt -= 2;
        continue;
      } 
      throw FormatException.a();
    } 
    if (paramInt == 1)
      if (paramBitSource.c() >= 6) {
        paramStringBuilder.append(a(paramBitSource.a(6)));
      } else {
        throw FormatException.a();
      }  
    if (paramBoolean)
      for (paramInt = i; paramInt < paramStringBuilder.length(); paramInt++) {
        if (paramStringBuilder.charAt(paramInt) == '%') {
          if (paramInt < paramStringBuilder.length() - 1) {
            i = paramInt + 1;
            if (paramStringBuilder.charAt(i) == '%') {
              paramStringBuilder.deleteCharAt(i);
              continue;
            } 
          } 
          paramStringBuilder.setCharAt(paramInt, '\035');
        } 
        continue;
      }  
  }
  
  private static void b(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt) throws FormatException {
    if (paramInt * 13 <= paramBitSource.c()) {
      byte[] arrayOfByte = new byte[paramInt * 2];
      int i = 0;
      while (paramInt > 0) {
        int j = paramBitSource.a(13);
        int k = j % 192 | j / 192 << 8;
        if (k < 7936) {
          j = 33088;
        } else {
          j = 49472;
        } 
        j = k + j;
        arrayOfByte[i] = (byte)(j >> 8);
        arrayOfByte[i + 1] = (byte)j;
        i += 2;
        paramInt--;
      } 
      try {
        paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
        return;
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        throw FormatException.a();
      } 
    } 
    throw FormatException.a();
  }
  
  private static void c(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt) throws FormatException {
    while (paramInt >= 3) {
      if (paramBitSource.c() >= 10) {
        int i = paramBitSource.a(10);
        if (i < 1000) {
          paramStringBuilder.append(a(i / 100));
          paramStringBuilder.append(a(i / 10 % 10));
          paramStringBuilder.append(a(i % 10));
          paramInt -= 3;
          continue;
        } 
        throw FormatException.a();
      } 
      throw FormatException.a();
    } 
    if (paramInt == 2) {
      if (paramBitSource.c() >= 7) {
        paramInt = paramBitSource.a(7);
        if (paramInt < 100) {
          paramStringBuilder.append(a(paramInt / 10));
          paramStringBuilder.append(a(paramInt % 10));
          return;
        } 
        throw FormatException.a();
      } 
      throw FormatException.a();
    } 
    if (paramInt == 1) {
      if (paramBitSource.c() >= 4) {
        paramInt = paramBitSource.a(4);
        if (paramInt < 10) {
          paramStringBuilder.append(a(paramInt));
          return;
        } 
        throw FormatException.a();
      } 
      throw FormatException.a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\DecodedBitStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */