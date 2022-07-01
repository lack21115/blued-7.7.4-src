package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder {
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.h);
  
  private void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws ChecksumException {
    byte b;
    int j = paramInt2 + paramInt3;
    if (paramInt4 == 0) {
      b = 1;
    } else {
      b = 2;
    } 
    int[] arrayOfInt = new int[j / b];
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      if (paramInt4 == 0 || i % 2 == paramInt4 - 1)
        arrayOfInt[i / b] = paramArrayOfbyte[i + paramInt1] & 0xFF; 
    } 
    try {
      this.a.a(arrayOfInt, paramInt3 / b);
      for (paramInt3 = bool; paramInt3 < paramInt2; paramInt3++) {
        if (paramInt4 == 0 || paramInt3 % 2 == paramInt4 - 1)
          paramArrayOfbyte[paramInt3 + paramInt1] = (byte)arrayOfInt[paramInt3 / b]; 
      } 
      return;
    } catch (ReedSolomonException reedSolomonException) {
      throw ChecksumException.a();
    } 
  }
  
  public DecoderResult a(BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap) throws FormatException, ChecksumException {
    byte[] arrayOfByte1;
    byte[] arrayOfByte2 = (new BitMatrixParser(paramBitMatrix)).a();
    a(arrayOfByte2, 0, 10, 10, 0);
    int i = arrayOfByte2[0] & 0xF;
    if (i != 2 && i != 3 && i != 4) {
      if (i == 5) {
        a(arrayOfByte2, 20, 68, 56, 1);
        a(arrayOfByte2, 20, 68, 56, 2);
        arrayOfByte1 = new byte[78];
      } else {
        throw FormatException.a();
      } 
    } else {
      a(arrayOfByte2, 20, 84, 40, 1);
      a(arrayOfByte2, 20, 84, 40, 2);
      arrayOfByte1 = new byte[94];
    } 
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 10);
    System.arraycopy(arrayOfByte2, 20, arrayOfByte1, 10, arrayOfByte1.length - 10);
    return DecodedBitStreamParser.a(arrayOfByte1, i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\maxicode\decoder\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */